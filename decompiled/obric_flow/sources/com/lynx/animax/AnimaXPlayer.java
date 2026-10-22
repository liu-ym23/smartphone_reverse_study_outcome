package com.lynx.animax;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.loader.AnimaXResourceLoaderHolder;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.AnimaXKeyPathListCallback;
import com.lynx.animax.property.AnimaXPropertyCallback;
import com.lynx.animax.property.AnimaXValueCallback;
import com.lynx.animax.property.AnimaXValueParam;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.AnimaXMetricsCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXPlayer implements im.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f9550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseAbility f9551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final im.b f9552c;
    public AnimaXResourceLoaderHolder d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final am.d f9554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnimaXComposition f9555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9556k;

    public AnimaXPlayer(im.b r13) {
        this.e = false;
        this.f = false;
        this.g = false;
        this.f9553h = false;
        this.f9554i = null;
        this.f9556k = 0;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXPlayer", "create AnimaXPlayer: " + this);
        this.f9552c = r13;
        BaseAbility r5 = r13.f17579a;
        this.f9551b = r5;
        fm.c r10 = r5.e;
        r10.getClass();
        r10.f16928b = new WeakReference(this);
        r5.f9575a.add(r5.e);
        if (jm.b.c("ANIMAX_MODEL_BLOCK_LIST_ANDROID", r5) == false) goto L6;
        HashMap r12 = new HashMap();
        r12.put("code", 5);
        r12.put("msg", "The device is not support.");
        r5.n(r12, 6);
        return;
    L6:
        Context r14 = r13.f17580b;
        if (r14 != null) goto L10;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXPlayer", "init fail, context is null");
        return;
    L10:
        AnimaX r11 = AnimaX.a();
        if (r11.f9710a == true) goto L13;
    L15:
        AnimaX r15 = AnimaX.a();
        Context r16 = r15.f9712c;
        r15.b(null);
        if (r15.d == false) goto L18;
    L27:
        AnimaX r17 = AnimaX.a();
        if (r17.f9710a == true) goto L30;
    L64:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXPlayer", "init fail, AnimaX.inst().forceInit() fail");
        BaseAbility r18 = this.f9551b;
        HashMap r19 = new HashMap();
        r19.put("code", 2);
        r19.put("msg", "Thread init error.");
        r18.n(r19, 6);
        return;
    L30:
        if (r17.d == false) goto L64;
        AnimaX r20 = AnimaX.a();
        Context r21 = r14.getApplicationContext();
        if (r20.f9712c != null) goto L35;
        if (r21 == null) goto L35;
        r20.f9712c = r21;
    L35:
        float r22 = r14.getResources().getDisplayMetrics().density;
        if (jm.b.f == true) goto L38;
        jm.b.f = true;
    L38:
        AnimaXResourceLoaderHolder r23 = new AnimaXResourceLoaderHolder((g) this.f9551b.f9577c.c(g.class));
        this.d = r23;
        BaseAbility r24 = this.f9551b;
        this.f9550a = nativeCreate(r22, r24, r23.f9635a, this.f9552c.f17581c, jm.b.b(jm.b.a("ANIMAX_SKIP_COUNT_DOWN_EVENT", r24)));
        long r25 = this.f9550a;
        bm.a r26 = new bm.a(1);
        r26.f960b = r25;
        this.f9554i = new am.d(this, r26);
        if (this.f9550a == 0) goto L63;
        Context r110 = this.f9552c.f17580b;
        if (r110 != null) goto L44;
        return;
    L44:
        if (jm.b.d == true) goto L50;
        boolean r27 = Process.is64Bit();     // Catch: Exception -> L47
    L48:
        jm.b.e = !r27;
        jm.b.d = true;
    L47:
        r27 = true;
    L50:
        if (jm.b.e == false) goto L52;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXPlayer", "Limit frame rate to 30.");
        setMaxFrameRate(30.0d);
    L52:
        BaseAbility r28 = this.f9551b;
        if (jm.b.f18355b >= 0) goto L59;
        jm.b.f18355b = ((ActivityManager) r110.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "DeviceUtil", androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("isES3Supported fail, message")));
    L59:
        if (jm.b.f18355b >= 196608) goto L61;
    L62:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXPlayer", "useSoftwareRender");
        this.g = true;
        return;
    L61:
        if (jm.b.c("ANIMAX_MODEL_SOFTWARE_LIST_ANDROID", r28) == true) goto L62;
        return;
    L63:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXPlayer", "init fail");
        return;
    L18:
        if (r15.f9710a == false) goto L27;
        if (jm.c.i() == true) goto L27;
    L25:
        e = move-exception;
        Thread.currentThread().interrupt();
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaX", "Interrupted while waiting for main thread to be marked: " + e.getMessage());
        goto L27
    L22:
        if (r15.e.await(10000, TimeUnit.MILLISECONDS) == true) goto L27;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaX", "Timeout while waiting for main thread to be marked.");     // Catch: InterruptedException -> L25
        goto L27
    L13:
        if (r11.d == false) goto L15;
        goto L15
    }

    public static /* synthetic */ void e(long r5) {
        nativeDestroy(r5);
    }

    private native void nativeAddLayerPropertyCallback(long r5, int r10, AnimaXKeyPath r11, AnimaXValueCallback r12, AnimaXPropertyCallback r13);

    private native void nativeCancel(long r5);

    private native long nativeCreate(float r5, BaseAbility r10, long r11, boolean r12, boolean r13);

    private native void nativeCreateAnimaXSurface(long r5, AnimaXSurfaceDrawable r10);

    private static native void nativeDestroy(long r5);

    private native double nativeGetCurrentFrame(long r5);

    private native double nativeGetDurationMs(long r5);

    private native ReadableMap nativeGetEventTrackingMap(long r5);

    private native void nativeGetKeysForKeyPath(long r5, AnimaXKeyPath r10, AnimaXKeyPathListCallback r11);

    private native void nativeGetMetricsAsync(long r5, AnimaXMetricsCallback r10);

    private native boolean nativeIsAnimating(long r5);

    private native void nativeOnHide(long r5, long r10);

    private native void nativeOnShow(long r5, long r10);

    private native void nativeOnTap(long r5, float r10, float r11);

    private native void nativePause(long r5);

    private native void nativePlay(long r5);

    private native void nativePlaySegment(long r5, int r10, int r11);

    private native void nativeReload(long r5);

    private native void nativeResume(long r5);

    private native void nativeSeek(long r5, int r10);

    private native void nativeSetAutoPlay(long r5, boolean r10);

    private native void nativeSetAutoReverse(long r5, boolean r10);

    private native void nativeSetComposition(long r5, long r10);

    private native void nativeSetDynamicResource(long r5, boolean r10);

    private native void nativeSetEndFrame(long r5, int r10);

    private native void nativeSetFpsEventInterval(long r5, long r10);

    private native void nativeSetImageFolder(long r5, String r10);

    private native void nativeSetJson(long r5, String r10);

    private native void nativeSetKeepLastFrame(long r5, boolean r10);

    private native void nativeSetLoop(long r5, boolean r10);

    private native void nativeSetLoopCount(long r5, int r10);

    private native void nativeSetMaxFrameRate(long r5, double r10);

    private native void nativeSetObjectFit(long r5, int r10);

    private native void nativeSetObjectPosition(long r5, int r10);

    private native void nativeSetProgress(long r5, float r10);

    private native void nativeSetResourceProperty(long r5, int r10, String r11, AnimaXValueParam r12, AnimaXPropertyCallback r13);

    private native void nativeSetSpeed(long r5, float r10);

    private native void nativeSetSrc(long r5, String r10);

    private native void nativeSetSrcPolyfill(long r5, JavaOnlyMap r10);

    private native void nativeSetStartFrame(long r5, int r10);

    private native void nativeStop(long r5);

    private native void nativeSubscribeUpdateEvent(long r5, int r10);

    private native void nativeSubscribeUpdateEvents(long r5, int[] r10, boolean r11);

    private native void nativeUnsubscribeUpdateEvent(long r5, int r10);

    private native void nativeUpdateAnimaXSurface(long r5, AnimaXSurfaceDrawable r10);

    private native void nativeUpdateLayerProperty(long r5, int r10, AnimaXKeyPath r11, AnimaXValueParam r12, AnimaXPropertyCallback r13);

    @Override // im.f
    public final void a(AnimaXMetricsCallback r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeGetMetricsAsync(this.f9550a, r5);
    }

    @Override // im.f
    public final void b(float r5, float r10) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeOnTap(this.f9550a, r5, r10);
    }

    public final void c(int r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSeek(this.f9550a, r5);
    }

    public final void d(int r5, int r10) {
        if (i() == true) goto L5;
        return;
    L5:
        this.f9551b.e.n(true);
        nativePlaySegment(this.f9550a, r5, r10);
    }

    public final void f(AnimaXSurfaceDrawable r5) {
        if (i() == true) goto L5;
        return;
    L5:
        r5.g = this.f;
        r5.f9593h = this.g;
        String r10 = jm.b.f18354a;
        r5.f9594i = this.f9553h;
        nativeCreateAnimaXSurface(this.f9550a, r5);
    }

    public final void g(boolean r5, VisibilityState r10) {
        int r11 = this.f9556k;
        int r12 = r10.f9584a;
        if ((r11 & r12) != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r5 == r13) goto L20;
        this.f9556k = r11 ^ r12;
        if (r5 == false) goto L16;
        if (i() == false) goto L21;
        nativeOnShow(this.f9550a, r10.f9584a);
        return;
    L21:
        return;
    L16:
        if (i() == true) goto L18;
        return;
    L18:
        nativeOnHide(this.f9550a, r10.f9584a);
        return;
    L20:
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // im.f
    public final im.b getAnimaXContext() {
        return this.f9552c;
    }

    @Override // im.f
    public final AnimaXComposition getComposition() {
        return this.f9555j;
    }

    @Override // im.f
    public final double getCurrentFrame() {
        if (i() == true) goto L7;
        return 0.0d;
    L7:
        return nativeGetCurrentFrame(this.f9550a);
    }

    @Override // im.f
    public final double getDurationMs() {
        if (i() == true) goto L7;
        return 0.0d;
    L7:
        return nativeGetDurationMs(this.f9550a);
    }

    public final void h(int[] r5, boolean r10) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSubscribeUpdateEvents(this.f9550a, r5, r10);
    }

    public final boolean i() {
        boolean r5 = false;
        if (this.e == false) goto L6;
        return false;
    L6:
        if (this.f9550a == 0) goto L8;
        r5 = true;
    L8:
        if (r5 == true) goto L10;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXPlayer", "checkNativeReady failed, ptr is 0");
    L10:
        return r5;
    }

    public final void j(int r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSubscribeUpdateEvent(this.f9550a, r5);
    }

    public final void k(AnimaXSurfaceDrawable r5) {
        if (i() == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        r5.g = this.f;
        r5.f9593h = this.g;
        String r10 = jm.b.f18354a;
        r5.f9594i = this.f9553h;
    L7:
        nativeUpdateAnimaXSurface(this.f9550a, r5);
    }

    public final boolean l() {
        if (i() == true) goto L7;
        return false;
    L7:
        return nativeIsAnimating(this.f9550a);
    }

    public final void m() {
        if (i() == true) goto L5;
        return;
    L5:
        nativePause(this.f9550a);
    }

    public final void n(int r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeUnsubscribeUpdateEvent(this.f9550a, r5);
    }

    public final void o() {
        if (i() == true) goto L5;
        return;
    L5:
        this.f9551b.e.n(true);
        nativePlay(this.f9550a);
    }

    public final void p() {
        if (i() == true) goto L5;
        return;
    L5:
        BaseAbility r5 = this.f9551b;
        fm.c r10 = r5.e;
        r10.d.put("stay_duration", Long.valueOf(System.currentTimeMillis() - r10.f16930h));
        r10.m("onRelease");
        ((ConcurrentHashMap) r5.f9577c.f9657b).clear();
        r5.f9575a.clear();
        this.f9554i.a();
        AnimaXResourceLoaderHolder r11 = this.d;
        if (r11 == null) goto L8;
        r11.f9636b.clear();
        r11.f9637c.a();
        r11.f9635a = 0;
        this.d = null;
    L8:
        this.e = true;
        this.f9550a = 0;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXPlayer", "AnimaXPlayer destroyed");
    }

    public final void q() {
        if (i() == true) goto L5;
        return;
    L5:
        nativeReload(this.f9550a);
    }

    public final void r() {
        if (i() == true) goto L5;
        return;
    L5:
        this.f9551b.e.n(true);
        nativeResume(this.f9550a);
    }

    public final void s() {
        if (i() == true) goto L5;
        return;
    L5:
        nativeStop(this.f9550a);
    }

    @Override // im.f
    public final void setAntiAliasing(boolean r5) {
        this.f = r5;
    }

    @Override // im.f
    public final void setAutoPlay(boolean r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetAutoPlay(this.f9550a, r5);
    }

    @Override // im.f
    public final void setAutoReverse(boolean r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetAutoReverse(this.f9550a, r5);
    }

    @Override // im.f
    public final void setComposition(AnimaXComposition r10) {
        this.f9555j = r10;
        if (i() == true) goto L5;
        return;
    L5:
        long r5 = this.f9550a;
        long r11 = r10.f9587a;
        if (r11 != 0) goto L8;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXComposition", "checkNativeReady failed, nativePtr is 0");
        r11 = 0;
    L8:
        nativeSetComposition(r5, r11);
    }

    @Override // im.f
    public final void setDynamicResource(boolean r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetDynamicResource(this.f9550a, r5);
    }

    @Override // im.f
    public final void setEndFrame(int r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetEndFrame(this.f9550a, r5);
    }

    @Override // im.f
    public final void setFpsEventInterval(long r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetFpsEventInterval(this.f9550a, r5);
    }

    @Override // im.f
    public final void setImageFolder(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == false) goto L7;
        return;
    L7:
        if (i() == false) goto L13;
        nativeSetImageFolder(this.f9550a, r5);
        return;
    }

    @Override // im.f
    public final void setJson(String r5) {
        if (i() == false) goto L10;
        nativeSetJson(this.f9550a, r5);
        IAnimaXMonitorService r10 = (IAnimaXMonitorService) this.f9551b.e.f16927a.c(IAnimaXMonitorService.class);
        if (r10 == null) goto L9;
        r10.setCurrentUrl("json");
        return;
    L9:
        return;
    }

    @Override // im.f
    public final void setKeepLastFrame(boolean r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetKeepLastFrame(this.f9550a, r5);
    }

    @Override // im.f
    public final void setLoop(boolean r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetLoop(this.f9550a, r5);
    }

    @Override // im.f
    public final void setLoopCount(int r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetLoopCount(this.f9550a, r5);
    }

    @Override // im.f
    public final void setMaxFrameRate(double r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetMaxFrameRate(this.f9550a, r5);
    }

    @Override // im.f
    public final void setObjectFit(ObjectFit r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetObjectFit(this.f9550a, r5.ordinal());
    }

    @Override // im.f
    public final void setObjectPosition(ObjectPosition r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetObjectPosition(this.f9550a, r5.ordinal());
    }

    @Override // im.f
    public final void setProgress(float r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetProgress(this.f9550a, r5);
    }

    @Override // im.f
    public final void setSpeed(float r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetSpeed(this.f9550a, r5);
    }

    @Override // im.f
    public final void setSrc(String r5) {
        if (i() == false) goto L12;
        nativeSetSrc(this.f9550a, r5);
        IAnimaXMonitorService r10 = (IAnimaXMonitorService) this.f9551b.e.f16927a.c(IAnimaXMonitorService.class);
        if (r5 == null) goto L10;
        if (r10 == null) goto L11;
        r10.setCurrentUrl(r5);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // im.f
    public final void setSrcPolyfill(JavaOnlyMap r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetSrcPolyfill(this.f9550a, r5);
    }

    @Override // im.f
    public final void setStartFrame(int r5) {
        if (i() == true) goto L5;
        return;
    L5:
        nativeSetStartFrame(this.f9550a, r5);
    }
}
