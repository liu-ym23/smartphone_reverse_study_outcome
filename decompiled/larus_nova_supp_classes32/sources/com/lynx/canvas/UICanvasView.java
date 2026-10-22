package com.lynx.canvas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.TextureView;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.nio.ByteBuffer;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UICanvasView extends TextureView implements TextureView.SurfaceTextureListener, SurfaceHolder.FirstFrameListener {
    private static final String TAG = "KryptonCanvasView";
    private float mAlphaSet;
    private BroadcastReceiver mBoardCastReceiver;
    private int mLastVisibility;
    private boolean mNeedAlphaWorkaround;
    private boolean mNeedProcessGesture;
    private boolean mNeedVisibilityWorkaround;
    private PlatformCanvasView mPlatformCanvasView;
    private boolean mScreenLockWorkaroundInited;
    private SurfaceHolder mSurfaceHolder;

    @Override // com.lynx.canvas.SurfaceHolder.FirstFrameListener
    public void onFirstFrame() {
        setNeedAlphaWorkaround(false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    private void deInitScreenLockWorkaround() {
        if (this.mScreenLockWorkaroundInited == true) goto L6;
        KryptonLLog.w(TAG, "deInitScreenLockWorkaround multiple times.");
        return;
    L6:
        KryptonLLog.i(TAG, "deInitScreenLockWorkaround " + this);
        this.mScreenLockWorkaroundInited = false;
        INVOKEVIRTUAL_com_lynx_canvas_UICanvasView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(getContext(), this.mBoardCastReceiver);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        KryptonLLog.e(TAG, e.getMessage());
        KryptonLLog.e(TAG, "unregister BoardCastReceiver: " + this.mBoardCastReceiver);
    }

    private void initScreenLockWorkaround() {
        if (this.mScreenLockWorkaroundInited == false) goto L6;
        KryptonLLog.w(TAG, "initScreenLockWorkaround multiple times.");
        return;
    L6:
        KryptonLLog.i(TAG, "initScreenLockWorkaround " + this);
        if (this.mBoardCastReceiver != null) goto L9;
        this.mBoardCastReceiver = new AnonymousClass2(this);
    L9:
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.SCREEN_OFF");
        INVOKEVIRTUAL_com_lynx_canvas_UICanvasView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getContext(), this.mBoardCastReceiver, r0);     // Catch: Exception -> L12
    L14:
        this.mScreenLockWorkaroundInited = true;
        return;
    L12:
        e = move-exception;
        KryptonLLog.e(TAG, e.getMessage());
        KryptonLLog.e(TAG, "register BoardCastReceiver: " + this.mBoardCastReceiver);
        goto L14
    }

    public void destroy() {
        KryptonLLog.i(TAG, "UICanvasView destroy");
        if (this.mSurfaceHolder == null) goto L5;
        KryptonLLog.w(TAG, "Destroy surface during UICanvasView destroyed.");
        this.mSurfaceHolder.dispose();
        this.mSurfaceHolder = null;
    L5:
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 == null) goto L9;
        r0.onSurfaceDestroyed();
        this.mPlatformCanvasView.dispose();
        this.mPlatformCanvasView = null;
        return;
    }

    public long getMemoryUsageBytes() {
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getMemoryUsageBytes();
    }

    public Map<String, String> getMemoryUsageDetail() {
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMemoryUsageDetail();
    }

    public float getScale() {
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.getScale();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        KryptonLLog.i(TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
        initScreenLockWorkaround();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        deInitScreenLockWorkaround();
    }

    public UICanvasView(Context r3) {
        super(r3.getApplicationContext());
        this.mNeedProcessGesture = false;
        KryptonLLog.i(TAG, "UICanvasView created");
        setSurfaceTextureListener(this);
        this.mAlphaSet = 1.0f;
        setOpaque(false);
        setNeedAlphaWorkaround(true);
        SurfaceHolder r4 = new SurfaceHolder(this);
        this.mSurfaceHolder = r4;
        r4.initTextureView(this);
        this.mPlatformCanvasView = new PlatformCanvasView();
    }

    public static /* synthetic */ int access$100(UICanvasView r0) {
        return r0.mLastVisibility;
    }

    public static /* synthetic */ SurfaceHolder access$200(UICanvasView r0) {
        return r0.mSurfaceHolder;
    }

    private void postAtFrontOnUI(Runnable r4) {
        Handler r0 = new Handler(Looper.getMainLooper());
        Message r5 = Message.obtain(r0, r4);
        if (Build.VERSION.SDK_INT < 22) goto L5;
        r5.setAsynchronous(true);
    L5:
        r0.sendMessageAtFrontOfQueue(r5);
    }

    private void setNeedAlphaWorkaround(boolean r4) {
        StringBuilder r0 = new StringBuilder("setNeedAlphaWorkaround with ");
        r0.append(r4);
        r0.append(" Build.VERSION.SDK_INT ");
        int r1 = Build.VERSION.SDK_INT;
        r0.append(r1);
        KryptonLLog.i(TAG, r0.toString());
        if (r1 <= 28) goto L5;
        return;
    L5:
        this.mNeedAlphaWorkaround = r4;
        if (r4 == false) goto L8;
        super.setAlpha(0.0f);
        return;
    L8:
        super.setAlpha(this.mAlphaSet);
    }

    public boolean dispatchTransformedTouch(ByteBuffer r2) {
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 == null) goto L7;
        r0.dispatchTransformedTouchEvent(r2);
        return false;
    L7:
        return false;
    }

    public void notifyLayout(Rect r4) {
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.notifyLayoutUpdate(r4, getWidth(), getHeight());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
        KryptonLLog.i(TAG, "onSurfaceTextureDestroyed " + r3);
        if (DeviceUtil.needTextureDestroyWorkaround() == false) goto L7;
        KryptonLLog.i(TAG, "needTextureDestroyWorkaround, try to postAtFrontOnUI.");
        this.mLastVisibility = getVisibility();
        this.mNeedVisibilityWorkaround = true;
        setVisibility(4);
        postAtFrontOnUI(new AnonymousClass3(this));
        return false;
    L7:
        return false;
    }

    @Override // android.view.View
    public void setAlpha(float r2) {
        this.mAlphaSet = r2;
        if (this.mNeedAlphaWorkaround == true) goto L6;
        super.setAlpha(r2);
        return;
    }

    @Override // android.view.View
    public void setBackground(Drawable r3) {
        super.setBackground(r3);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "setBackground fail, message: " + e.getMessage());
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r3) {
        super.setBackgroundDrawable(r3);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "setBackgroundDrawable fail, message: " + e.getMessage());
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable r3) {
        super.setForeground(r3);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "setForeground fail, message: " + e.getMessage());
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture r1) {
        super.setSurfaceTexture(r1);
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        if (this.mNeedVisibilityWorkaround == false) goto L7;
        this.mLastVisibility = r2;
        if (r2 != 0) goto L7;
        KryptonLLog.i(TAG, "Force visiblity to INVISIBLE due to workaround.");
        r2 = 4;
    L7:
        super.setVisibility(r2);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_lynx_canvas_UICanvasView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ boolean access$002(UICanvasView r0, boolean r1) {
        r0.mNeedVisibilityWorkaround = r1;
        return r1;
    }

    public void setup(String r7, KryptonApp r8) {
        float r3 = r8.getSystemRatio();
        if (this.mPlatformCanvasView != null) goto L5;
        return;
    L5:
        if (this.mPlatformCanvasView.setup(r7, r8, r3, getWidth(), getHeight()) == false) goto L13;
        boolean r9 = r8.getFeatureFlag().needProcessGesture();
        this.mNeedProcessGesture = r9;
        if (r9 == false) goto L10;
        setOnTouchListener(new AnonymousClass1(this));
    L10:
        this.mSurfaceHolder.onSurfaceTextureSizeChanged(getWidth(), getHeight());
        this.mPlatformCanvasView.notifySurfaceChanged(this.mSurfaceHolder, getWidth(), getHeight());
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_lynx_canvas_UICanvasView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    public boolean dispatchTouch(MotionEvent r2, Rect r3, Rect r4) {
        PlatformCanvasView r0 = this.mPlatformCanvasView;
        if (r0 == null) goto L7;
        r0.dispatchTouchEvent(r2, r3, r4);
        return false;
    L7:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
        KryptonLLog.w(TAG, "onSurfaceTextureAvailable " + r3 + " wh " + r4 + " / " + r5);
        SurfaceHolder r6 = this.mSurfaceHolder;
        if (r6 == null) goto L7;
        r6.initTextureView(this);
        this.mSurfaceHolder.onSurfaceTextureSizeChanged(r4, r5);
        PlatformCanvasView r7 = this.mPlatformCanvasView;
        if (r7 == null) goto L9;
        r7.notifySurfaceChanged(this.mSurfaceHolder, r4, r5);
        return;
    L9:
        return;
    L7:
        KryptonLLog.e(TAG, "onSurfaceTextureAvailable but sh is " + this.mSurfaceHolder);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r3, int r4, int r5) {
        KryptonLLog.i(TAG, "onSurfaceTextureSizeChanged " + r3 + " wh " + r4 + " / " + r5);
        SurfaceHolder r6 = this.mSurfaceHolder;
        if (r6 == null) goto L7;
        r6.onSurfaceTextureSizeChanged(r4, r5);
        PlatformCanvasView r7 = this.mPlatformCanvasView;
        if (r7 == null) goto L9;
        r7.notifySurfaceChanged(this.mSurfaceHolder, r4, r5);
        return;
    L9:
        return;
    L7:
        KryptonLLog.e(TAG, "onSurfaceTextureSizeChanged but sh is " + this.mSurfaceHolder);
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        KryptonLLog.e(TAG, "onSizeChanged before added to view tree, may produce npe on some devices");
    }
}
