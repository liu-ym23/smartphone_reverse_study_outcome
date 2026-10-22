package com.lynx.markdown;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.View;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.textra.JavaFontManager;
import com.lynx.xelement.markdown.LynxUIMarkdownShadowNode;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import p8a.m;
import p8a.q;
import p8a.r;
import p8a.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ServalMarkdownView extends MarkdownGestureView {
    private boolean mAnimationPaused;
    private long mCurrentTime;
    private boolean mDisableInternalVSync;
    protected b mEventListener;
    protected c mExposureListener;
    protected long mInstance;
    private final Choreographer.FrameCallback mInternalVSyncCallback;
    private boolean mInternalVSyncPosted;
    protected e mLoader;
    private long mPauseStartTime;
    private long mTotalPausedDurationMs;

    private native long nativeCreateInstance();

    private native void nativeDestroyInstance(long r1);

    private native String[] nativeGetAllImageUrl(long r1);

    private native int nativeGetAnimationStep(long r1);

    private native int nativeGetCharIndexByPoint(long r1, float r3, float r4, int r5);

    private native long nativeGetCharRangeByPoint(long r1, float r3, float r4, int r5, int r6);

    private native String nativeGetContent(long r1, int r3, int r4, int r5);

    private native String nativeGetContentID(long r1);

    private native String nativeGetDocumentContent(long r1);

    private native float[] nativeGetLinkBoundingRect(long r1);

    private native String[] nativeGetLinkContent(long r1);

    private native String[] nativeGetLinkUrl(long r1);

    private native float[] nativeGetSelectedLineBoundingRect(long r1);

    private native long nativeGetSelectedRange(long r1);

    private native String nativeGetSelectedText(long r1);

    private native long nativeGetSelectionHandlePosition(long r1);

    private native float nativeGetSelectionHandleRadius(long r1);

    private native long[] nativeGetSyntaxSourceRanges(long r1, String r3);

    private native float[] nativeGetTextBoundingRect(long r1, int r3, int r4, int r5);

    private native void nativeMarkDirty(long r1);

    private native void nativeOnFontLoaded(long r1, String r3, int r4, int r5);

    private native void nativeOnImageLoaded(long r1, String r3);

    private native void nativeOnLayoutFrame(long r1, long r3);

    private native void nativeOnRendererFrame(long r1, long r3);

    private native void nativeSetAnimationStep(long r1, int r3);

    private native void nativeSetContent(long r1, String r3);

    private native void nativeSetDensity(float r1);

    private native void nativeSetExposureListenerEnabled(long r1, boolean r3);

    private native void nativeSetNumberProp(long r1, int r3, double r4);

    private native void nativeSetStringProp(long r1, int r3, String r4);

    private native void nativeSetStyle(long r1, byte[] r3);

    private native void nativeSetTextSelection(long r1, int r3, int r4);

    private native void nativeSetValueProp(long r1, int r3, byte[] r4);

    public void onImageAppear(String r1) {
    }

    public void onImageDisappear(String r1) {
    }

    public void onLinkAppear(String r1, String r2) {
    }

    public void onLinkDisappear(String r1, String r2) {
    }

    public void resumeAnimation() {
        resumeAnimation(-1);
    }

    private void clearInternalVSync() {
        if (this.mInternalVSyncPosted == true) goto L5;
        return;
    L5:
        Choreographer.getInstance().removeFrameCallback(this.mInternalVSyncCallback);
        this.mInternalVSyncPosted = false;
    }

    private void postInternalVSync() {
        if (this.mDisableInternalVSync == false) goto L5;
        return;
    L5:
        if (this.mInternalVSyncPosted == true) goto L10;
        this.mInternalVSyncPosted = true;
        Choreographer.getInstance().postFrameCallback(this.mInternalVSyncCallback);
        return;
    }

    public a createCustomView() {
        a r0 = new a(getContext());
        r0.mResourceManager = this.mResourceManager;
        addView(r0);
        return r0;
    }

    public a createRegionView() {
        a r0 = new a(getContext());
        r0.mResourceManager = this.mResourceManager;
        addView(r0, 0);
        return r0;
    }

    public String[] getAllImageUrl() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return new String[0];
    L7:
        return nativeGetAllImageUrl(r0);
    }

    public int getAnimationStep() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return nativeGetAnimationStep(r0);
    }

    public String getContent() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return nativeGetDocumentContent(r0);
    }

    public String getContentID() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return nativeGetContentID(r0);
    }

    public ArrayList<RectF> getLinkBoundingRect() {
        ArrayList<RectF> r0 = new ArrayList();
        long r1 = this.mInstance;
        if (r1 != 0) goto L5;
        return r0;
    L5:
        float[] r2 = nativeGetLinkBoundingRect(r1);
        int r3 = 0;
    L6:
        int r4 = r3 + 3;
        if (r4 >= r2.length) goto L9;
        r0.add(new RectF(r2[r3], r2[r3 + 1], r2[r3 + 2], r2[r4]));
        r3 = r3 + 4;
        goto L6
    L9:
        return r0;
    }

    public String[] getLinkContent() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return new String[0];
    L7:
        return nativeGetLinkContent(r0);
    }

    public String[] getLinkUrl() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return new String[0];
    L7:
        return nativeGetLinkUrl(r0);
    }

    public ArrayList<RectF> getSelectedLineBoundingRect() {
        ArrayList<RectF> r0 = new ArrayList();
        long r1 = this.mInstance;
        if (r1 != 0) goto L5;
        return r0;
    L5:
        float[] r2 = nativeGetSelectedLineBoundingRect(r1);
        int r3 = 0;
    L6:
        int r4 = r3 + 3;
        if (r4 >= r2.length) goto L9;
        r0.add(new RectF(r2[r3], r2[r3 + 1], r2[r3 + 2], r2[r4]));
        r3 = r3 + 4;
        goto L6
    L9:
        return r0;
    }

    public long getSelectedRange() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return i.a(-1, -1);
    L7:
        return nativeGetSelectedRange(r0);
    }

    public String getSelectedText() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return nativeGetSelectedText(r0);
    }

    public long getSelectionHandlePosition() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return i.a(-1, -1);
    L7:
        return nativeGetSelectionHandlePosition(r0);
    }

    public float getSelectionHandleRadius() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return 0.0f;
    L7:
        return nativeGetSelectionHandleRadius(r0);
    }

    public void markDirty() {
        long r0 = this.mInstance;
        if (r0 != 0) goto L5;
        return;
    L5:
        nativeMarkDirty(r0);
    }

    public void onDrawEnd() {
        b r0 = this.mEventListener;
        if (r0 == null) goto L6;
        LynxUIMarkdownShadowNode r1 = (LynxUIMarkdownShadowNode) ((m) r0).a;
        r1.getClass();
        UIThreadUtils.runOnUiThread(new p8a.f(r1, new m7a.a(r1.b, "drawEnd")));
        return;
    }

    public void onDrawStart() {
        b r0 = this.mEventListener;
        if (r0 == null) goto L6;
        LynxUIMarkdownShadowNode r1 = (LynxUIMarkdownShadowNode) ((m) r0).a;
        r1.getClass();
        UIThreadUtils.runOnUiThread(new p8a.f(r1, new m7a.a(r1.b, "drawStart")));
        return;
    }

    public void onParseEnd() {
        b r0 = this.mEventListener;
        if (r0 == null) goto L10;
        m r1 = (m) r0;
        final LynxUIMarkdownShadowNode r2 = (LynxUIMarkdownShadowNode) r1.a;
        r2.getClass();
        LynxUIMarkdownShadowNode r3 = (LynxUIMarkdownShadowNode) r1.a;
        p8a.d r4 = r3.v;
        if (r4 == null) goto L7;
        String r5 = r4.getContentID();
    L8:
        final m7a.a r6 = new m7a.a(r2.b, "parseEnd");
        r6.a("id", r5);
        UIThreadUtils.runOnUiThread(new p8a.l(r2, r6));
        return;
    L7:
        r5 = r3.C;
        goto L8
    }

    public void pauseAnimation() {
        if (this.mAnimationPaused == false) goto L5;
        return;
    L5:
        this.mAnimationPaused = true;
        this.mPauseStartTime = this.mCurrentTime;
    }

    public a createScrollXRegionView() {
        return createRegionView();
    }

    public a createSelectionHandleView() {
        return createCustomView();
    }

    public void destroy() {
        clearInternalVSync();
        long r0 = this.mInstance;
        if (r0 == 0) goto L5;
        nativeDestroyInstance(r0);
        this.mInstance = 0;
        setNativeGestureTarget(0);
    L5:
        this.mAnimationPaused = false;
        this.mTotalPausedDurationMs = 0;
    }

    public long getVisibleVerticalRangeInScreen() {
        int r0 = getWidth();
        long r2 = i.a(0, 0);
        if (r0 > 0) goto L5;
    L15:
        return r2;
    L5:
        if (getHeight() <= 0) goto L15;
        Rect r1 = new Rect();
        Point r4 = new Point();
        if (getGlobalVisibleRect(r1, r4) == true) goto L10;
        return r2;
    L10:
        int r5 = r1.top;
        int r6 = r4.y;
        int r3 = r1.bottom - r6;
        int r7 = Math.max(0, r5 - r6);
        int r8 = Math.min(getHeight(), r3);
        if (r8 > r7) goto L14;
        return r2;
    L14:
        return i.a(r7, r8);
    }

    public void updateDisplayMetrics() {
        DisplayMetrics r0 = INVOKEVIRTUAL_com_lynx_markdown_ServalMarkdownView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        if (r0 == null) goto L6;
        nativeSetDensity(r0.density);
        return;
    }

    public void initialVSync() {
        postInternalVSync();
    }

    public void removeAllSubviews() {
        removeAllViews();
    }

    public ServalMarkdownView(Context r3) {
        super(r3, 0);
        this.mInstance = 0;
        this.mLoader = null;
        this.mEventListener = null;
        this.mAnimationPaused = false;
        this.mDisableInternalVSync = false;
        this.mInternalVSyncPosted = false;
        this.mCurrentTime = 0;
        this.mPauseStartTime = 0;
        this.mTotalPausedDurationMs = 0;
        this.mInternalVSyncCallback = new l(this);
        Markdown.ensureInitialized();
        updateDisplayMetrics();
        long r0 = nativeCreateInstance();
        this.mInstance = r0;
        setNativeGestureTarget(r0);
        this.mResourceManager = new h();
        initialVSync();
        setClipChildren(false);
        setClipToPadding(false);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_markdown_ServalMarkdownView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public void disableInternalVSync(boolean r2) {
        if (this.mDisableInternalVSync != r2) goto L5;
        return;
    L5:
        this.mDisableInternalVSync = r2;
        if (r2 == false) goto L8;
        clearInternalVSync();
        return;
    L8:
        postInternalVSync();
    }

    public long getImageSize(int r4) {
        Drawable r5 = this.mResourceManager.a(r4);
        int r0 = 0;
        if (r5 == null) goto L5;
        Rect r1 = r5.getBounds();
        int r2 = r1.width();
        int r3 = r1.height();
        if (r2 <= 0) goto L9;
        if (r3 <= 0) goto L9;
    L10:
        if (r2 >= 0) goto L12;
        r2 = 0;
    L12:
        if (r3 < 0) goto L16;
        r0 = r3;
    L16:
        return i.a(r2, r0);
    L9:
        r2 = r5.getIntrinsicWidth();
        r3 = r5.getIntrinsicHeight();
        goto L10
    L5:
        return i.a(0, 0);
    }

    public long[] getSyntaxSourceRanges(String r6) {
        long r0 = this.mInstance;
        if (r0 != 0) goto L7;
        return new long[0];
    L7:
        return nativeGetSyntaxSourceRanges(r0, r6);
    }

    public int loadImage(String r7) {
        e r0 = this.mLoader;
        if (r0 != null) goto L5;
        return 0;
    L5:
        t r1 = (t) r0;
        LynxContext r2 = ((LynxUIMarkdownShadowNode) r1.a).m;
        if (TextUtils.isEmpty(r7) == true) goto L17;
        if (r2 == null) goto L17;
        q r3 = r1.b.get(r7);
        if (r3 != null) goto L12;
        r3 = new q(r7, r1.d, r1.e, r1.a);
        r1.b.put(r7, r3);
    L12:
        p8a.d r8 = ((LynxUIMarkdownShadowNode) r1.a).D();
        Drawable r4 = r3.e;
        if (r4 == null) goto L16;
        if (r8 == null) goto L16;
        r4.setCallback(r8);
    L16:
        Drawable r9 = r3.e;
    L18:
        if (r9 != null) goto L20;
        return 0;
    L20:
        h r5 = this.mResourceManager;
        Integer r6 = (Integer) ((Hashtable) r5.b).get(r9);
        if (r6 != null) goto L23;
        int r10 = -1;
    L24:
        if (r10 != (-1)) goto L28;
        r5.a.add(r9);
        int r11 = r5.a.size() - 1;
        ((Hashtable) r5.b).put(r9, Integer.valueOf(r11));
        return r11;
    L28:
        return r10;
    L23:
        r10 = r6.intValue();
    L17:
        r9 = null;
        goto L18
    }

    public IMarkdownViewHandle loadInlineView(String r7) {
        e r0 = this.mLoader;
        if (r0 != null) goto L5;
        return null;
    L5:
        t r1 = (t) r0;
        r1.getClass();
        if (TextUtils.isEmpty(r7) == true) goto L36;
        r r2 = r1.c.get(r7);
        if (r2 != null) goto L35;
        int r3 = 0;
    L13:
        if (r3 >= ((ShadowNode) r1.a).l()) goto L26;
        ShadowNode r4 = ((ShadowNode) r1.a).k(r3);
        if ((r4 instanceof NativeLayoutNodeRef) == false) goto L19;
        NativeLayoutNodeRef r5 = (NativeLayoutNodeRef) r4;
        if (r7.equals(r5.z) == false) goto L19;
        LynxContext r6 = ((LynxUIMarkdownShadowNode) r1.a).m;
        if (r6 != null) goto L23;
    L25:
        LynxBaseUI r8 = null;
    L27:
        if (r5 == null) goto L37;
        r r9 = new r(r5, r8, r1.a);
        r1.c.put(r7, r9);
        return r9;
    L37:
        return null;
    L23:
        if (r6.getLynxUIOwner() == null) goto L25;
        r8 = r6.getLynxUIOwner().findLynxUIBySign(r4.b);
    L19:
        r3 = r3 + 1;
        goto L13
    L26:
        r8 = null;
        r5 = null;
        goto L27
    L35:
        return r2;
    L36:
        return null;
    }

    public void onImageClicked(String r5) {
        b r0 = this.mEventListener;
        if (r0 == null) goto L6;
        final LynxUIMarkdownShadowNode r1 = (LynxUIMarkdownShadowNode) ((m) r0).a;
        r1.getClass();
        final m7a.a r2 = new m7a.a(r1.b, "imageTap");
        r2.a(LynxEventReporter.PROP_NAME_URL, r5);
        UIThreadUtils.runOnUiThread(new p8a.i(r1, r2));
        return;
    }

    public void onImageLoaded(String r6) {
        if (this.mInstance == 0) goto L8;
        if (r6 == null) goto L9;
        requestMeasure();
        nativeOnImageLoaded(this.mInstance, r6);
        return;
    L9:
        return;
    }

    public void onLayoutFrame(long r6) {
        long r7 = r6 / 1000000;
        this.mCurrentTime = r7;
        if (this.mAnimationPaused == true) goto L8;
        long r0 = this.mInstance;
        if (r0 == 0) goto L9;
        nativeOnLayoutFrame(r0, r7 - this.mTotalPausedDurationMs);
        return;
    L9:
        return;
    }

    public void onRendererFrame(long r6) {
        long r0 = this.mInstance;
        if (r0 == 0) goto L6;
        nativeOnRendererFrame(r0, r6 / 1000000);
        return;
    }

    public void onTextOverflow(int r5) {
        b r0 = this.mEventListener;
        if (r0 == null) goto L10;
        final LynxUIMarkdownShadowNode r1 = (LynxUIMarkdownShadowNode) ((m) r0).a;
        r1.getClass();
        if (r5 != 0) goto L7;
        String r6 = "clip";
    L8:
        final m7a.a r2 = new m7a.a(r1.b, "overflow");
        r2.a("type", r6);
        UIThreadUtils.runOnUiThread(new p8a.h(r1, r2));
        return;
    L7:
        r6 = "ellipsis";
        goto L8
    }

    public void onVSync(long r2) {
        this.mInternalVSyncPosted = false;
        onLayoutFrame(r2);
        onRendererFrame(r2);
        postInternalVSync();
    }

    public void removeSubView(View r1) {
        removeView(r1);
    }

    public void resumeAnimation(int r8) {
        if (r8 == (-1)) goto L8;
        long r3 = this.mInstance;
        if (r3 == 0) goto L8;
        nativeSetAnimationStep(r3, r8);
    L8:
        if (this.mAnimationPaused == false) goto L15;
        this.mAnimationPaused = false;
        long r4 = this.mPauseStartTime;
        if (r4 <= 0) goto L16;
        long r0 = this.mCurrentTime;
        if (r0 <= r4) goto L17;
        this.mTotalPausedDurationMs += r0 - r4;
        return;
    L17:
        return;
    L16:
        return;
    }

    public void setAnimationType(int r4) {
        setNumberProp(0, r4);
    }

    public void setAnimationVelocity(float r4) {
        setNumberProp(1, r4);
    }

    public void setContent(String r3) {
        nativeSetContent(this.mInstance, r3);
    }

    public void setEventListener(b r1) {
        this.mEventListener = r1;
    }

    public void setExposureListener(c r6) {
        long r0 = this.mInstance;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L6;
        boolean r7 = true;
    L7:
        nativeSetExposureListenerEnabled(r0, r7);
        return;
    L6:
        r7 = false;
        goto L7
    }

    public void setInitialAnimationStep(int r4) {
        setNumberProp(5, r4);
    }

    public void setResourceLoader(e r1) {
        this.mLoader = r1;
    }

    public void setStyle(HashMap<String, Object> r3) {
        g r0 = new g();
        r0.b(r3);     // Catch: IOException -> L5
        byte[] r4 = r0.a.toByteArray();     // Catch: IOException -> L5
        nativeSetStyle(this.mInstance, r4);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void onAnimationStep(int r6, int r7) {
        b r0 = this.mEventListener;
        if (r0 == null) goto L10;
        m r1 = (m) r0;
        final LynxUIMarkdownShadowNode r2 = (LynxUIMarkdownShadowNode) r1.a;
        r2.getClass();
        String r3 = ((LynxUIMarkdownShadowNode) r1.a).B;
        if (r3 != null) goto L7;
        int r4 = 0;
    L8:
        final m7a.a r5 = new m7a.a(r2.b, "animationStep");
        r5.a("animationStep", Integer.valueOf(r6));
        r5.a("maxAnimationStep", Integer.valueOf(r7));
        r5.a("contentLength", Integer.valueOf(r4));
        UIThreadUtils.runOnUiThread(new p8a.g(r2, r5));
        return;
    L7:
        r4 = r3.length();
        goto L8
    }

    public void onLinkClicked(String r5, String r6) {
        b r0 = this.mEventListener;
        if (r0 == null) goto L6;
        final LynxUIMarkdownShadowNode r1 = (LynxUIMarkdownShadowNode) ((m) r0).a;
        r1.getClass();
        final m7a.a r2 = new m7a.a(r1.b, "link");
        r2.a(LynxEventReporter.PROP_NAME_URL, r5);
        r2.a(LynxAccessibilityModule.MSG_CONTENT, r6);
        UIThreadUtils.runOnUiThread(new p8a.k(r1, r2));
        return;
    }

    public void setArrayProp(int r4, ArrayList<Object> r5) {
        g r0 = new g();
        r0.a(r5);     // Catch: IOException -> L5
    L7:
        nativeSetValueProp(this.mInstance, r4, r0.a.toByteArray());
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void setBooleanProp(int r3, boolean r4) {
        if (r4 == false) goto L4;
        double r0 = 1.0d;
    L5:
        setNumberProp(r3, r0);
        return;
    L4:
        r0 = 0.0d;
        goto L5
    }

    public void setColorProp(int r3, int r4) {
        setNumberProp(r3, r4);
    }

    public void setNumberProp(int r7, double r8) {
        nativeSetNumberProp(this.mInstance, r7, r8);
    }

    public void setObjectProp(int r4, HashMap<String, Object> r5) {
        g r0 = new g();
        r0.b(r5);     // Catch: IOException -> L5
    L7:
        nativeSetValueProp(this.mInstance, r4, r0.a.toByteArray());
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void setStringProp(int r3, String r4) {
        nativeSetStringProp(this.mInstance, r3, r4);
    }

    public void setTextSelection(int r6, int r7) {
        long r0 = this.mInstance;
        if (r0 != 0) goto L5;
        return;
    L5:
        nativeSetTextSelection(r0, r6, r7);
    }

    public int getCharIndexByPoint(float r7, float r8, int r9) {
        long r1 = this.mInstance;
        if (r1 != 0) goto L7;
        return -1;
    L7:
        return nativeGetCharIndexByPoint(r1, r7, r8, r9);
    }

    public String getContent(int r7, int r8, int r9) {
        long r1 = this.mInstance;
        if (r1 != 0) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return nativeGetContent(r1, r7, r8, r9);
    }

    public ArrayList<RectF> getTextBoundingRect(int r8, int r9, int r10) {
        ArrayList<RectF> r0 = new ArrayList();
        long r2 = this.mInstance;
        if (r2 != 0) goto L5;
        return r0;
    L5:
        float[] r11 = nativeGetTextBoundingRect(r2, r8, r9, r10);
        int r12 = 0;
    L6:
        int r13 = r12 + 3;
        if (r13 >= r11.length) goto L9;
        r0.add(new RectF(r11[r12], r11[r12 + 1], r11[r12 + 2], r11[r13]));
        r12 = r12 + 4;
        goto L6
    L9:
        return r0;
    }

    public long loadFont(String r13, int r14, int r15) {
        e r0 = this.mLoader;
        if (r0 != null) goto L5;
        return 0;
    L5:
        t r1 = (t) r0;
        LynxContext r3 = ((LynxUIMarkdownShadowNode) r1.a).m;
        boolean r5 = false;
        if (r3 != null) goto L9;
        Typeface r2 = null;
    L53:
        if (r2 != null) goto L55;
        return 0;
    L55:
        h r4 = this.mResourceManager;
        r4.getClass();
        JavaFontManager r6 = r4.c;
        if (r15 != 2) goto L59;
        r5 = true;
    L59:
        return r6.CreateOrRegisterTypeface(r2, r13, r14, r5).mIndex;
    L9:
        if (r14 > 400) goto L14;
        if (r15 == 1) goto L14;
        if (r15 == 3) goto L14;
        boolean r7 = false;
    L15:
        if (r15 == 2) goto L19;
        if (r15 == 3) goto L19;
        boolean r9 = false;
    L20:
        if (r9 == true) goto L24;
        if (r15 == 1) goto L24;
        boolean r10 = false;
    L25:
        if (r7 == false) goto L28;
        if (r10 == false) goto L28;
        int r8 = 3;
    L34:
        if (TextUtils.isEmpty(r13) == false) goto L36;
        Typeface r11 = Typeface.defaultFromStyle(r8);
    L37:
        if (r11 != null) goto L39;
    L47:
        Typeface r12 = r11;
    L49:
        if (TextUtils.isEmpty(r13) == true) goto L52;
        if (r12 != null) goto L52;
        FontFaceManager.g.a.g(r3, r13, r8, new t.a(r1, r13, r14, r15));
    L52:
        r2 = r12;
        goto L53
    L39:
        if (Build.VERSION.SDK_INT < 28) goto L47;
        int r16 = Math.max(1, r14);
        if (r8 == 2) goto L45;
        if (r8 == 3) goto L45;
        boolean r17 = false;
    L46:
        r12 = Typeface.create(r11, r16, r17);
    L45:
        r17 = true;
        goto L46
    L36:
        r11 = com.lynx.tasm.behavior.shadow.text.g.d(r3, r13, r8);
    L28:
        if (r10 == false) goto L30;
        r8 = 2;
        goto L34
    L30:
        if (r7 == false) goto L32;
        r8 = 1;
        goto L34
    L32:
        r8 = 0;
    L24:
        r10 = true;
    L19:
        r9 = true;
    L14:
        r7 = true;
        goto L15
    }

    public void onFontLoaded(String r12, int r13, int r14) {
        if (this.mInstance == 0) goto L8;
        if (r12 == null) goto L9;
        requestMeasure();
        nativeOnFontLoaded(this.mInstance, r12, r13, r14);
        return;
    L9:
        return;
    }

    public long getCharRangeByPoint(float r8, float r9, int r10, int r11) {
        long r1 = this.mInstance;
        if (r1 != 0) goto L7;
        return i.a(-1, -1);
    L7:
        return nativeGetCharRangeByPoint(r1, r8, r9, r10, r11);
    }

    public void onSelectionChanged(int r4, int r5, int r6, int r7) {
        b r8 = this.mEventListener;
        if (r8 == null) goto L14;
        final LynxUIMarkdownShadowNode r9 = (LynxUIMarkdownShadowNode) ((m) r8).a;
        r9.getClass();
        if (r4 > r5) goto L7;
        boolean r10 = true;
    L8:
        final m7a.a r0 = new m7a.a(r9.b, "selectionchange");
        r0.a("start", Integer.valueOf(r4));
        r0.a("end", Integer.valueOf(r5));
        if (r10 == false) goto L11;
        String r11 = "forward";
    L12:
        r0.a("direction", r11);
        UIThreadUtils.runOnUiThread(new p8a.j(r9, r0));
        return;
    L11:
        r11 = "backward";
        goto L12
    L7:
        r10 = false;
        goto L8
    }
}
