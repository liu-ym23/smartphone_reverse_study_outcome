package com.lynx.animax.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.lottieadapter.LottieAdapterAnimaX$w;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;
import x4a.c;
import x4a.d;
import x4a.e;
import x4a.f;
import x4a.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXView extends TextureView implements TextureView.SurfaceTextureListener, FirstFrameAwareSurfaceTexture.a, g, e {
    public FirstFrameAwareSurfaceTexture a;
    public Surface b;
    public boolean c;
    public AnimaXSurfaceDrawable d;
    public boolean e;
    public c f;
    public boolean g;
    public float h;
    public boolean i;
    public boolean j;
    public int k;
    public final AnimaXPlayer l;
    public boolean m;
    public boolean n;

    public class a implements Runnable {
        public final /* synthetic */ AnimaXView a;

        public final void a() {
            AnimaXLog.b("AnimaXView", "Try to updateSurfaceTexture, mHasDestroyed: " + this.a.c);
            AnimaXView r0 = this.a;
            if (r0.c == true) goto L6;
            r0.j = false;
            r0.setVisibility(r0.k);
            this.a.j();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AnimaXView r1) {
            this.a = r1;
        }
    }

    @Override // x4a.g
    public final /* synthetic */ void d(MotionEvent r1) {
        f.a(this, r1);
    }

    @Override // com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture.a
    public final void onFirstFrameAvailable() {
        setNeedAlphaWorkaround(false);
    }

    @Override // q4a.b
    public final void e() {
        if (this.d == null) goto L5;
        return;
    L5:
        if (this.e == false) goto L10;
        this.l.i = true;
        AnimaXLog.b("AnimaXView", "The Surface has not been created yet; Creating a temporary one.");
        onSurfaceTextureAvailable(null, 1, 1);
        return;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        String r0 = y4a.a.a;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 24) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L23;
        if (this.g == true) goto L23;
        if (this.f != null) goto L16;
        this.f = new c(this);
    L16:
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.SCREEN_OFF");
        f(getContext(), this.f, r3);     // Catch: Exception -> L19
    L21:
        this.g = true;
    L19:
        e = move-exception;
        AnimaXLog.a("AnimaXView", e.getMessage());
        AnimaXLog.a("AnimaXView", "register BoardCastReceiver: " + this.f);
    L23:
        if (this.e == false) goto L25;
        return;
    L25:
        super.onAttachedToWindow();
        this.l.z(true, VisibilityState.ATTACH);
        return;
    L5:
        if (r1 > 29) goto L7;
        r2 = true;
        goto L8
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        String r0 = y4a.a.a;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 24) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L29;
        if (this.g == false) goto L29;
        this.g = false;
        Context r3 = getContext();     // Catch: Exception -> L26
        c r4 = this.f;     // Catch: Exception -> L26
        ReceiverRegisterLancet.loge(r4, false);     // Catch: Exception -> L26
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L34;
        r3.unregisterReceiver(r4);     // Catch: Exception -> L26
        goto L29
    L34:
    L20:
        e = move-exception;
        if (r4 == null) goto L23;
        Npth.addTag("unregisterReceiver", r4.toString());     // Catch: Exception -> L26
    L23:
        e.printStackTrace();     // Catch: Exception -> L26
        goto L29
    L17:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r4, r3) == false) goto L29;
        r3.unregisterReceiver(r4);     // Catch: Exception -> L20
    L26:
        e = move-exception;
        AnimaXLog.a("AnimaXView", e.getMessage());
        AnimaXLog.a("AnimaXView", "unregister BoardCastReceiver: " + this.f);
    L29:
        if (this.e == false) goto L31;
        return;
    L31:
        super.onDetachedFromWindow();
        this.l.z(false, VisibilityState.ATTACH);
        return;
    L5:
        if (r1 > 29) goto L7;
        r2 = true;
        goto L8
    }

    @Override // x4a.g
    public final void release() {
        if (this.c == false) goto L5;
        return;
    L5:
        AnimaXLog.b("AnimaXView", "release: " + this);
        this.c = true;
        this.l.s();
    }

    @Override // x4a.e
    public final void cancel() {
        getPlayer().cancel();
    }

    public AnimaXComposition getComposition() {
        return getPlayer().getComposition();
    }

    @Override // x4a.e
    public double getCurrentFrame() {
        return getPlayer().getCurrentFrame();
    }

    @Override // x4a.e
    public double getDurationMs() {
        return getPlayer().getDurationMs();
    }

    @Override // x4a.e
    public final boolean isAnimating() {
        return getPlayer().isAnimating();
    }

    public final void j() {
        SurfaceTexture r0 = getSurfaceTexture();
        FirstFrameAwareSurfaceTexture r1 = this.a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.equals(r0) == true) goto L45;
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 26) goto L10;
    L13:
        if (r0 == null) goto L15;
        AnimaXLog.b("AnimaXView", "Init TextureView but it has already another st.");
    L15:
        setSurfaceTexture(this.a);
        FirstFrameAwareSurfaceTexture r3 = this.a;
        r3.getClass();
        if (r2 < 36) goto L43;
        String r4 = y4a.a.a;
        monitor-enter(y4a.a.class);
    L32:
        th = move-exception;
        throw th;
    L21:
        if (y4a.a.h == false) goto L41;
    L24:
        boolean r5 = y4a.a.i;     // Catch: Throwable -> L32
        monitor-exit(y4a.a.class);
        if (r5 == false) goto L46;
        Field r6 = SurfaceTexture.class.getDeclaredField("mTextureViewStub");     // Catch: Throwable -> L30
        r6.setAccessible(true);     // Catch: Throwable -> L30
        FirstFrameAwareSurfaceTexture.b(r6.get(r3));     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        AnimaXLog.a("AnimaXFirstFrameAwareSurfaceTexture", "clearMiuiStubCallbackIfNeeded fail: " + th.getMessage());
        return;
    L46:
        return;
    L41:
        y4a.a.a("miui.os.Build");     // Catch: Throwable -> L36
        y4a.a.i = true;     // Catch: Throwable -> L36
    L23:
        y4a.a.h = true;     // Catch: Throwable -> L32
        goto L24
    L43:
        return;
    L10:
        if (this.a.isReleased() == false) goto L13;
        AnimaXLog.a("AnimaXView", "Failed to updateSurfaceTexture, texture is released.");
        return;
    }

    @Override // x4a.e
    public final void pause() {
        getPlayer().pause();
    }

    @Override // x4a.e
    public final void play() {
        getPlayer().play();
    }

    @Override // x4a.e
    public final void resume() {
        getPlayer().resume();
    }

    @Override // x4a.g, x4a.e
    public d getPlayer() {
        return this.l;
    }

    public AnimaXView(Context r3) {
        super(r3);
        this.c = false;
        this.e = false;
        this.h = 1.0f;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.n = false;
        this.l = new AnimaXPlayer(new AnimaXContext(new AnimaXContext.a(new o4a.c(), r3)));
        h(null);
    }

    private void setNeedAlphaWorkaround(boolean r3) {
        String r0 = y4a.a.a;
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        this.i = r3;
        if (r3 == false) goto L11;
        super.setAlpha(0.0f);
        return;
    L11:
        super.setAlpha(this.h);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // x4a.e
    public final void a(int r2) {
        getPlayer().a(r2);
    }

    @Override // x4a.e
    public final void c(LottieAdapterAnimaX$w r2) {
        getPlayer().c(r2);
    }

    public final void h(AttributeSet r5) {
        AnimaXContext r0 = this.l.c;
        if (r0 != null) goto L5;
    L16:
        AnimaXLog.a("AnimaXView", "initView fail, missing AnimaXContext or Ability.");
        return;
    L5:
        if (r0.getAbility() == null) goto L16;
        BaseAbility r2 = r0.getAbility();
        r2.getClass();
        r2.b = new WeakReference(this);
        this.n = y4a.a.e(y4a.a.b("ANIMAX_UPDATE_TEXTURE_WHEN_VISIBLE", r2));
        g(r0.getContext(), r5);     // Catch: NullPointerException -> L10
    L11:
        setOpaque(false);
        setNeedAlphaWorkaround(true);
        setSurfaceTextureListener(this);
        this.a = new FirstFrameAwareSurfaceTexture();
        this.b = new Surface(this.a);
        AnimaXLog.b("AnimaXView", "create Surface: " + this.b);
        this.a.g(this.b);
        this.a.detachFromGLContext();
        FirstFrameAwareSurfaceTexture r1 = this.a;
        r1.getClass();
        r1.a = new WeakReference(this);
        if (r1.c == false) goto L14;
        setNeedAlphaWorkaround(false);
    L14:
        FirstFrameAwareSurfaceTexture r6 = this.a;
        r6.getClass();
        r6.d = new WeakReference(this);
        j();
        return;
    L10:
        AnimaXLog.a("AnimaXView", "initAttributes fail, context's theme is null.");
        goto L11
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r5) {
        AnimaXLog.b("AnimaXView", "onSurfaceTextureDestroyed: " + r5 + ", mHasDestroyed: " + this.c + ", this: " + this);
        if (y4a.a.c == true) goto L5;
        return false;
    L5:
        if (this.c == true) goto L13;
        AnimaXLog.b("AnimaXView", "needTextureDestroyWorkaround, try to postAtFrontOnUI.");
        this.k = getVisibility();
        this.j = true;
        setVisibility(4);
        a r0 = new a(this);
        Handler r1 = y4a.d.a();
        Message r2 = Message.obtain(r1, r0);
        if (Build.VERSION.SDK_INT < 22) goto L9;
        r2.setAsynchronous(true);
    L9:
        r1.sendMessageAtFrontOfQueue(r2);
        return false;
    L13:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r4) {
        BaseAbility r5 = this.l.c.getAbility();
        if (r5.g == null) goto L11;
        Iterator r0 = ((CopyOnWriteArrayList) r5.a).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((t4a.f) r0.next()).o(r5.g);
        goto L6
    L8:
        r5.g = null;
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.m == false) goto L6;
        f.a(this, r2);
    L6:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r3) {
        super.onVisibilityAggregated(r3);
        if (this.e == false) goto L5;
        return;
    L5:
        this.l.z(r3, VisibilityState.AGGREGATED);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r2) {
        super.onWindowVisibilityChanged(r2);
        if (this.n == true) goto L5;
        return;
    L5:
        if (getVisibility() != 0) goto L10;
        if (r2 != 0) goto L11;
        j();
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public void setAlpha(float r5) {
        float r0 = getAlpha();
        this.h = r5;
        if (this.i == true) goto L5;
        super.setAlpha(r5);
    L5:
        boolean r1 = false;
        if (r0 <= 0.0f) goto L8;
        boolean r2 = true;
    L10:
        if (r5 <= 0.0f) goto L12;
        r1 = true;
    L12:
        if (r2 == r1) goto L15;
        this.l.z(r1, VisibilityState.OPACITY);
        return;
    L15:
        return;
    L8:
        r2 = false;
        goto L10
    }

    public void setAntiAliasing(boolean r2) {
        getPlayer().l(r2);
    }

    @Override // x4a.e
    public void setAutoPlay(boolean r2) {
        getPlayer().setAutoPlay(r2);
    }

    @Override // x4a.e
    public void setAutoReverse(boolean r2) {
        getPlayer().setAutoReverse(r2);
    }

    @Override // android.view.View
    public void setBackground(Drawable r3) {
        super.setBackground(r3);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaXView", "setBackground fail, message: " + e.getMessage());
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r3) {
        super.setBackgroundDrawable(r3);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaXView", "setBackgroundDrawable fail, message: " + e.getMessage());
    }

    @Override // x4a.e
    public void setComposition(AnimaXComposition r2) {
        getPlayer().setComposition(r2);
    }

    public void setDynamicResource(boolean r2) {
        getPlayer().k(r2);
    }

    public void setEnableAudio(boolean r2) {
        getPlayer().setEnableAudio(r2);
    }

    @Override // x4a.g
    public void setEnableTapLayerEvent(boolean r1) {
        this.m = r1;
    }

    @Override // x4a.e
    public void setEndFrame(int r2) {
        getPlayer().setEndFrame(r2);
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable r3) {
        super.setForeground(r3);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaXView", "setForeground fail, message: " + e.getMessage());
    }

    public void setFpsEventInterval(long r2) {
        getPlayer().j(r2);
    }

    @Override // x4a.g
    public void setIgnoreAttachStatus(boolean r1) {
        this.e = r1;
    }

    @Override // x4a.e
    public void setImageFolder(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        getPlayer().setImageFolder(r2);
        return;
    }

    @Override // x4a.e
    public void setJson(String r2) {
        getPlayer().setJson(r2);
    }

    public void setKeepLastFrame(boolean r2) {
        getPlayer().e(r2);
    }

    @Override // x4a.e
    public void setLoop(boolean r2) {
        getPlayer().setLoop(r2);
    }

    @Override // x4a.e
    public void setLoopCount(int r2) {
        getPlayer().setLoopCount(r2);
    }

    @Override // x4a.e
    public void setMaxFrameRate(double r2) {
        getPlayer().setMaxFrameRate(r2);
    }

    public void setMuted(boolean r2) {
        getPlayer().setMuted(r2);
    }

    @Override // x4a.e
    public void setObjectFit(ObjectFit r2) {
        getPlayer().setObjectFit(r2);
    }

    public void setObjectPosition(ObjectPosition r2) {
        getPlayer().d(r2);
    }

    @Override // x4a.e
    public void setProgress(float r2) {
        getPlayer().setProgress(r2);
    }

    @Override // x4a.e
    public void setSpeed(float r2) {
        getPlayer().setSpeed(r2);
    }

    @Override // x4a.e
    public void setSrc(String r2) {
        getPlayer().setSrc(r2);
    }

    @Override // x4a.e
    public void setStartFrame(int r2) {
        getPlayer().setStartFrame(r2);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        if (this.j == false) goto L7;
        this.k = r3;
        if (r3 != 0) goto L7;
        AnimaXLog.b("AnimaXView", "Force visiblity to INVISIBLE due to workaround.");
        r3 = 4;
    L7:
        super.setVisibility(r3);
        AnimaXPlayer r0 = this.l;
        if (r3 != 0) goto L10;
        boolean r4 = true;
    L11:
        r0.z(r4, VisibilityState.VISIBLE);
        return;
    L10:
        r4 = false;
        goto L11
    }

    public AnimaXView(AnimaXContext r3) {
        super(r3.getContext());
        this.c = false;
        this.e = false;
        this.h = 1.0f;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.n = false;
        this.l = new AnimaXPlayer(r3);
        h(null);
    }

    public AnimaXView(AnimaXPlayer r3) {
        super(r3.c.getContext());
        this.c = false;
        this.e = false;
        this.h = 1.0f;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.n = false;
        this.l = r3;
        h(null);
    }

    public AnimaXView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.c = false;
        this.e = false;
        this.h = 1.0f;
        this.j = false;
        this.k = 0;
        this.m = false;
        this.n = false;
        this.l = new AnimaXPlayer(new AnimaXContext(new AnimaXContext.a(new o4a.c(), r3)));
        h(r4);
    }

    @Override // x4a.e
    public final void b(int[] r2, boolean r3) {
        getPlayer().b(r2, r3);
    }

    public final void g(Context r3, AttributeSet r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3.getTheme() != null) goto L8;
        AnimaXLog.a("AnimaXView", "initAttributes fail, context's theme is null.");
        return;
    L8:
        TypedArray r5 = r3.obtainStyledAttributes(r4, new int[]{2130968796, 2130968797, 2130968802, 2130968803});
        String r0 = r5.getString(0);
        if (r0 == null) goto L11;
        this.l.setSrc(r0);
    L11:
        this.l.setAutoPlay(r5.getBoolean(1, true));
        this.l.setLoop(r5.getBoolean(2, false));
        String r6 = r5.getString(3);
        if (r6 == null) goto L14;
        this.l.setObjectFit(y4a.c.a(r6));
    L14:
        r5.recycle();
    }

    public final void i(int r8, int r9) {
        AnimaXPlayer r0 = this.l;
        if (r8 <= 0) goto L6;
        if (r9 <= 0) goto L6;
        boolean r1 = true;
    L7:
        r0.z(r1, VisibilityState.SIZE);
        if (r8 <= 0) goto L19;
        if (r9 <= 0) goto L19;
        AnimaXSurfaceDrawable r2 = this.d;
        if (r2 != null) goto L16;
        FirstFrameAwareSurfaceTexture r3 = this.a;
        AnimaXSurfaceDrawable r4 = new AnimaXSurfaceDrawable(r3.c(), r3, null, r8, r9);
        this.d = r4;
        this.l.p(r4);
        return;
    L16:
        if (r2.a(r8, r9) == false) goto L21;
        this.l.y(this.d);
        return;
    L21:
        return;
    L19:
        AnimaXLog.b("AnimaXView", "Skip invalid size: " + r8 + " / " + r9);
        return;
    L6:
        r1 = false;
        goto L7
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        super.onVisibilityChanged(r2, r3);
        if (this.n == false) goto L8;
        if (r2 != this) goto L9;
        if (r3 != 0) goto L10;
        j();
        return;
    L10:
        return;
    L9:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void f(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
        AnimaXLog.b("AnimaXView", "onSurfaceTextureAvailable: " + r3 + ", width: " + r4 + ", height: " + r5 + ", this: " + this);
        if (this.c == false) goto L6;
        AnimaXLog.b("AnimaXView", "onSurfaceTextureAvailable failed as view is destroyed.");
        return;
    L6:
        j();
        i(r4, r5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r3, int r4, int r5) {
        AnimaXLog.b("AnimaXView", "onSurfaceTextureSizeChanged: " + r3 + ", width: " + r4 + ", height: " + r5 + ", this: " + this);
        if (this.c == false) goto L6;
        AnimaXLog.b("AnimaXView", "onSurfaceTextureSizeChanged failed as view is destroyed.");
        return;
    L6:
        i(r4, r5);
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        AnimaXLog.a("AnimaXView", "onSizeChanged before added to view tree, may produce npe on some devices");
    }
}
