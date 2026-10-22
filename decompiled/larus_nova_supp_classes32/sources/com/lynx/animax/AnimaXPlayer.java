package com.lynx.animax;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.ability.Event;
import com.lynx.animax.base.AnimaXError;
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
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.ui.AnimaXContext;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.AnimaXMetricsCallback;
import com.lynx.lottieadapter.LottieAdapterAnimaX$a;
import com.lynx.lottieadapter.LottieAdapterAnimaX$b;
import com.lynx.lottieadapter.LottieAdapterAnimaX$w;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXPlayer implements x4a.d {
    public volatile long a;
    public final BaseAbility b;
    public final AnimaXContext c;
    public AnimaXResourceLoaderHolder d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public a j;
    public AnimaXComposition k;
    public int l;

    public static class a implements Runnable {
        public long a;
        public volatile boolean b;

        public final void a() {
            if (this.a != 0) goto L5;
            return;
        L5:
            if (this.b == true) goto L10;
            AnimaXLog.b("AnimaXPlayer", "Call nativeDestroy.");
            AnimaXPlayer.n(this.a);
            this.b = true;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.a != 0) goto L6;
            return;
        L6:
            if (this.b == true) goto L8;
            a();     // Catch: Throwable -> L10
        L8:
            AnimaXPlayer.m(this.a);     // Catch: Throwable -> L10
            this.a = 0;     // Catch: Throwable -> L10
        }

        public a(long r2) {
            this.b = false;
            this.a = r2;
        }
    }

    private native void nativeAddLayerPropertyCallback(long r1, int r3, AnimaXKeyPath r4, AnimaXValueCallback r5, AnimaXPropertyCallback r6);

    private native void nativeCancel(long r1);

    private native long nativeCreate(long r1, AnimaXContext r3);

    private native void nativeCreateAnimaXSurface(long r1, AnimaXSurfaceDrawable r3);

    private static native void nativeDeletePtr(long r0);

    private static native void nativeDestroy(long r0);

    private native double nativeGetCurrentFrame(long r1);

    private native double nativeGetDurationMs(long r1);

    private native ReadableMap nativeGetEventTrackingMap(long r1);

    private native void nativeGetKeysForKeyPath(long r1, AnimaXKeyPath r3, AnimaXKeyPathListCallback r4);

    private native long nativeGetMemoryUsageBytes(long r1);

    private native void nativeGetMetricsAsync(long r1, AnimaXMetricsCallback r3);

    private native boolean nativeIsAnimating(long r1);

    private native void nativeOnHide(long r1, long r3);

    private native void nativeOnShow(long r1, long r3);

    private native void nativeOnTap(long r1, float r3, float r4);

    private native void nativePause(long r1);

    private native void nativePlay(long r1);

    private native void nativePlaySegment(long r1, int r3, int r4);

    private native void nativeReload(long r1);

    private native void nativeResume(long r1);

    private native void nativeSeek(long r1, int r3);

    private native void nativeSetAutoPlay(long r1, boolean r3);

    private native void nativeSetAutoReverse(long r1, boolean r3);

    private native void nativeSetComposition(long r1, long r3);

    private native void nativeSetDynamicResource(long r1, boolean r3);

    private native void nativeSetEnableAudio(long r1, boolean r3);

    private native void nativeSetEndFrame(long r1, int r3);

    private native void nativeSetFpsEventInterval(long r1, long r3);

    private native void nativeSetImageFolder(long r1, String r3);

    private native void nativeSetJson(long r1, String r3);

    private native void nativeSetKeepLastFrame(long r1, boolean r3);

    private native void nativeSetLoop(long r1, boolean r3);

    private native void nativeSetLoopCount(long r1, int r3);

    private native void nativeSetMaxFrameRate(long r1, double r3);

    private native void nativeSetMuted(long r1, boolean r3);

    private native void nativeSetObjectFit(long r1, int r3);

    private native void nativeSetObjectPosition(long r1, int r3);

    private native void nativeSetProgress(long r1, float r3);

    private native void nativeSetResourceProperty(long r1, int r3, String r4, AnimaXValueParam r5, AnimaXPropertyCallback r6);

    private native void nativeSetSpeed(long r1, float r3);

    private native void nativeSetSrc(long r1, String r3);

    private native void nativeSetSrcPolyfill(long r1, JavaOnlyMap r3);

    private native void nativeSetStartFrame(long r1, int r3);

    private native void nativeStop(long r1);

    private native void nativeSubscribeUpdateEvent(long r1, int r3);

    private native void nativeSubscribeUpdateEvents(long r1, int[] r3, boolean r4);

    private native void nativeUnsubscribeUpdateEvent(long r1, int r3);

    private native void nativeUpdateAnimaXSurface(long r1, AnimaXSurfaceDrawable r3);

    private native void nativeUpdateLayerProperty(long r1, int r3, AnimaXKeyPath r4, AnimaXValueParam r5, AnimaXPropertyCallback r6);

    public final boolean o() {
        boolean r1 = false;
        if (this.f == false) goto L6;
        return false;
    L6:
        if (this.a == 0) goto L8;
        r1 = true;
    L8:
        if (r1 == true) goto L10;
        AnimaXLog.a("AnimaXPlayer", "checkNativeReady failed, ptr is 0");
    L10:
        return r1;
    }

    @Override // x4a.d
    public final void cancel() {
        if (o() == true) goto L5;
        return;
    L5:
        nativeCancel(this.a);
    }

    @Override // x4a.d
    public final double getCurrentFrame() {
        if (o() == true) goto L7;
        return 0.0d;
    L7:
        return nativeGetCurrentFrame(this.a);
    }

    @Override // x4a.d
    public final double getDurationMs() {
        if (o() == true) goto L7;
        return 0.0d;
    L7:
        return nativeGetDurationMs(this.a);
    }

    @Override // x4a.d
    public final boolean isAnimating() {
        if (o() == true) goto L7;
        return false;
    L7:
        return nativeIsAnimating(this.a);
    }

    @Override // x4a.d
    public final void pause() {
        if (o() == true) goto L5;
        return;
    L5:
        nativePause(this.a);
    }

    @Override // x4a.d
    public final void play() {
        if (o() == true) goto L5;
        return;
    L5:
        this.b.e.f(true);
        nativePlay(this.a);
    }

    public final long q() {
        if (o() == true) goto L7;
        return 0;
    L7:
        return nativeGetMemoryUsageBytes(this.a);
    }

    @Override // x4a.d
    public final void resume() {
        if (o() == true) goto L5;
        return;
    L5:
        this.b.e.f(true);
        nativeResume(this.a);
    }

    public final void s() {
        if (o() == true) goto L5;
        return;
    L5:
        BaseAbility r0 = this.b;
        v4a.d r1 = r0.e;
        Map<String, Object> r2 = r1.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put("stay_duration", Long.valueOf(System.currentTimeMillis() - r1.h));
        r1.h("onRelease");
        ((ConcurrentHashMap) r0.c.a).clear();
        ((CopyOnWriteArrayList) r0.a).clear();
        a r4 = this.j;
        if (r4 == null) goto L8;
        r4.a();
        this.j = null;
    L8:
        AnimaXResourceLoaderHolder r5 = this.d;
        if (r5 == null) goto L15;
        ((ArrayList) r5.b).clear();
        q4a.a r6 = r5.c;
        if (r6.a == true) goto L13;
        r6.b(q4a.a.f);
    L14:
        r5.a = 0;
        this.d = null;
        goto L15
    L13:
        r6.a(2);
    L15:
        this.f = true;
        this.a = 0;
        AnimaXLog.b("AnimaXPlayer", "AnimaXPlayer destroyed");
    }

    public final void t() {
        if (o() == true) goto L5;
        return;
    L5:
        nativeReload(this.a);
    }

    public final void v() {
        if (o() == true) goto L5;
        return;
    L5:
        nativeStop(this.a);
    }

    @Override // x4a.d
    public final AnimaXComposition getComposition() {
        return this.k;
    }

    public AnimaXPlayer(AnimaXContext r11) {
        boolean r0 = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = null;
        this.l = 0;
        AnimaXLog.b("AnimaXPlayer", "create AnimaXPlayer: " + this);
        this.c = r11;
        BaseAbility r2 = r11.getAbility();
        this.b = r2;
        v4a.d r4 = r2.e;
        r4.getClass();
        r4.b = new WeakReference(this);
        ((CopyOnWriteArrayList) r2.a).add(r2.e);
        if ((!y4a.a.d("ANIMAX_MODEL_BLOCK_LIST_ANDROID", r2)) == true) goto L10;
        o4a.a r3 = new o4a.a(r2, Event.ERROR.ordinal(), AnimaXError.createBlockErrorParam());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        r0 = true;
    L7:
        if (r0 == false) goto L9;
        r3.run();
        return;
    L9:
        y4a.d.a().post(r3);
        return;
    L10:
        Context r5 = r11.getContext();
        if (r5 != null) goto L14;
        AnimaXLog.a("AnimaXPlayer", "init fail, context is null");
        return;
    L14:
        if (AnimaX.e().a == true) goto L17;
        AnimaX r6 = AnimaX.e();
        r6.g(null);
        r6.d(null);
    L17:
        if (AnimaX.e().a == true) goto L24;
        AnimaXLog.a("AnimaXPlayer", "AnimaX.inst().init() fail again.");
        o4a.a r7 = new o4a.a(r2, Event.ERROR.ordinal(), AnimaXError.createLibraryInitErrorParam());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L21;
        r0 = true;
    L21:
        if (r0 == false) goto L23;
        r7.run();
        return;
    L23:
        y4a.d.a().post(r7);
        return;
    L24:
        AnimaX.e().g(r5.getApplicationContext());
        AnimaXResourceLoaderHolder r8 = new AnimaXResourceLoaderHolder((w4a.b) r2.c.a(w4a.b.class));
        this.d = r8;
        this.a = nativeCreate(r8.a, r11);
        this.j = new a(this.a);
        new q4a.a(this, this.j);
        if (this.a == 0) goto L27;
        boolean r1 = true;
    L28:
        if (r1 == true) goto L30;
        AnimaXLog.a("AnimaXPlayer", "init fail");
        return;
    L30:
        Context r12 = r11.getContext();
        if (r12 != null) goto L34;
        return;
    L34:
        if (Build.VERSION.SDK_INT >= 26) goto L36;
    L39:
        boolean r9 = true;
    L40:
        if (r9 == false) goto L43;
        AnimaXLog.b("AnimaXPlayer", "Limit frame rate to 30.");
        setMaxFrameRate(30.0d);
    L43:
        if (y4a.a.b >= 0) goto L49;
        y4a.a.b = ((ActivityManager) r12.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        AnimaXLog.a("DeviceUtil", "isES3Supported fail, message" + th.getMessage());
    L49:
        if (y4a.a.b < 196608) goto L51;
        boolean r13 = true;
    L52:
        if (r13 == true) goto L54;
    L55:
        r0 = true;
    L56:
        if (r0 == false) goto L67;
        AnimaXLog.b("AnimaXPlayer", "useSoftwareRender");
        this.h = true;
        return;
    L67:
        return;
    L54:
        if (y4a.a.d("ANIMAX_MODEL_SOFTWARE_LIST_ANDROID", r2) == false) goto L56;
    L51:
        r13 = false;
        goto L52
    L36:
        if (y4a.a.c() == true) goto L39;
        r9 = false;
        goto L40
    L27:
        r1 = false;
        goto L28
    }

    public static /* synthetic */ void m(long r0) {
        nativeDeletePtr(r0);
    }

    public static /* synthetic */ void n(long r0) {
        nativeDestroy(r0);
    }

    @Override // x4a.d
    public final void a(int r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSeek(this.a, r3);
    }

    @Override // x4a.d
    public final void c(LottieAdapterAnimaX$w r2) {
        ((CopyOnWriteArrayList) this.b.a).add(r2);
    }

    @Override // x4a.d
    public final void d(ObjectPosition r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetObjectPosition(this.a, r3.ordinal());
    }

    @Override // x4a.d
    public final void e(boolean r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetKeepLastFrame(this.a, r3);
    }

    @Override // x4a.d
    public final void f(AnimaXMetricsCallback r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeGetMetricsAsync(this.a, r3);
    }

    @Override // x4a.d
    public final void j(long r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetFpsEventInterval(this.a, r3);
    }

    @Override // x4a.d
    public final void k(boolean r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetDynamicResource(this.a, r3);
    }

    @Override // x4a.d
    public final void l(boolean r1) {
        this.g = r1;
    }

    public final void p(AnimaXSurfaceDrawable r3) {
        if (o() == true) goto L5;
        return;
    L5:
        r3.g = this.g;
        r3.h = this.h;
        String r0 = y4a.a.a;
        r3.j = false;
        r3.i = this.i;
        nativeCreateAnimaXSurface(this.a, r3);
    }

    @Override // x4a.d
    public final void setAutoPlay(boolean r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetAutoPlay(this.a, r3);
        this.e = r3;
    }

    @Override // x4a.d
    public final void setAutoReverse(boolean r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetAutoReverse(this.a, r3);
    }

    @Override // x4a.d
    public final void setComposition(AnimaXComposition r8) {
        this.k = r8;
        if (o() == true) goto L5;
        return;
    L5:
        long r0 = this.a;
        long r4 = 0;
        if (r8.a != 0) goto L8;
        AnimaXLog.a("AnimaXComposition", "checkNativeReady failed, nativePtr is 0");
        boolean r2 = false;
    L9:
        if (r2 == false) goto L12;
        r4 = r8.a;
    L12:
        nativeSetComposition(r0, r4);
        return;
    L8:
        r2 = true;
        goto L9
    }

    @Override // x4a.d
    public final void setEnableAudio(boolean r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetEnableAudio(this.a, r3);
    }

    @Override // x4a.d
    public final void setEndFrame(int r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetEndFrame(this.a, r3);
    }

    @Override // x4a.d
    public final void setImageFolder(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == false) goto L7;
        return;
    L7:
        if (o() == true) goto L9;
        return;
    L9:
        nativeSetImageFolder(this.a, r3);
    }

    @Override // x4a.d
    public final void setJson(String r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetJson(this.a, r3);
        IAnimaXMonitorService r4 = (IAnimaXMonitorService) this.b.e.a.a(IAnimaXMonitorService.class);
        if (r4 == null) goto L9;
        r4.setCurrentUrl("json");
        return;
    }

    @Override // x4a.d
    public final void setLoop(boolean r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetLoop(this.a, r3);
    }

    @Override // x4a.d
    public final void setLoopCount(int r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetLoopCount(this.a, r3);
    }

    @Override // x4a.d
    public final void setMaxFrameRate(double r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetMaxFrameRate(this.a, r3);
    }

    @Override // x4a.d
    public final void setMuted(boolean r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetMuted(this.a, r3);
    }

    @Override // x4a.d
    public final void setObjectFit(ObjectFit r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetObjectFit(this.a, r3.ordinal());
    }

    @Override // x4a.d
    public final void setProgress(float r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetProgress(this.a, r3);
    }

    @Override // x4a.d
    public final void setSpeed(float r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetSpeed(this.a, r3);
    }

    @Override // x4a.d
    public final void setSrc(String r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetSrc(this.a, r3);
        IAnimaXMonitorService r0 = (IAnimaXMonitorService) this.b.e.a.a(IAnimaXMonitorService.class);
        if (r3 == null) goto L10;
        if (r0 == null) goto L11;
        r0.setCurrentUrl(r3);
        return;
    L11:
        return;
    }

    @Override // x4a.d
    public final void setStartFrame(int r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetStartFrame(this.a, r3);
    }

    public final void u(JavaOnlyMap r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSetSrcPolyfill(this.a, r3);
    }

    public final void w(int r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSubscribeUpdateEvent(this.a, r3);
    }

    public final void x(int r3) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeUnsubscribeUpdateEvent(this.a, r3);
    }

    public final void y(AnimaXSurfaceDrawable r3) {
        if (o() == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        r3.g = this.g;
        r3.h = this.h;
        String r0 = y4a.a.a;
        r3.j = false;
        r3.i = this.i;
    L7:
        nativeUpdateAnimaXSurface(this.a, r3);
    }

    @Override // x4a.d
    public final void b(int[] r3, boolean r4) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeSubscribeUpdateEvents(this.a, r3, r4);
    }

    @Override // x4a.d
    public final void g(AnimaXKeyPath r3, LottieAdapterAnimaX$a r4) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeGetKeysForKeyPath(this.a, r3, r4);
    }

    @Override // x4a.d
    public final void h(float r3, float r4) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeOnTap(this.a, r3, r4);
    }

    public final void r(int r3, int r4) {
        if (o() == true) goto L5;
        return;
    L5:
        this.b.e.f(true);
        nativePlaySegment(this.a, r3, r4);
    }

    public final void z(boolean r4, VisibilityState r5) {
        boolean r1 = false;
        if ((this.l & r5.getValue()) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r4 == r0) goto L9;
        this.l ^= r5.getValue();
        r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (r4 == false) goto L17;
        if (o() == false) goto L22;
        nativeOnShow(this.a, r5.getValue());
        return;
    L22:
        return;
    L17:
        if (o() == false) goto L23;
        nativeOnHide(this.a, r5.getValue());
        return;
    L23:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // x4a.d
    public final void i(LayerPropertyType r9, AnimaXKeyPath r10, LottieAdapterAnimaX$b.a r11, LottieAdapterAnimaX$b.b r12) {
        if (o() == true) goto L5;
        return;
    L5:
        nativeAddLayerPropertyCallback(this.a, r9.getValue(), r10, r11, r12);
    }
}
