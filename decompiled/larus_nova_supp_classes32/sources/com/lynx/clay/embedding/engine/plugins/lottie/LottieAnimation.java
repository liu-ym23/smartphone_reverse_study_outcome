package com.lynx.clay.embedding.engine.plugins.lottie;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.BitmapBufferGroup;
import com.lynx.animax.ui.AnimaXContext;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import o4a.c;
import t4a.d;
import t4a.f;
import u4a.k;
import w4a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LottieAnimation implements SurfaceTexture.OnFrameAvailableListener, f {
    public long a;
    public final AnimaXPlayer b;
    public SurfaceTexture c;
    public AnimaXSurfaceDrawable d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;

    public class a implements b {
        @Override // w4a.b
        public final List<k> b() {
            return Collections.singletonList(new l5a.a());
        }

        public a() {
        }
    }

    private native void nativeOnCancel(long r1);

    private native void nativeOnComplete(long r1);

    private native void nativeOnError(long r1, int r3, String r4);

    private native void nativeOnFPS(long r1, float r3, float r4);

    private native void nativeOnFirstFrame(long r1);

    private native void nativeOnReady(long r1);

    private native void nativeOnRepeat(long r1);

    private native void nativeOnStart(long r1);

    private native void nativeOnUpdate(long r1);

    public int getRepeatCountTotal() {
        return 0;
    }

    public int getTotalFrameCount() {
        return 0;
    }

    @Override // t4a.f
    public final void k(t4a.a r1) {
    }

    @Override // t4a.f
    public final void n(d r1) {
    }

    public void destroy() {
        this.a = 0;
        SurfaceTexture r0 = this.c;
        if (r0 == null) goto L5;
        r0.setOnFrameAvailableListener(null);
        this.c.release();
        this.c = null;
    L5:
        this.b.v();
        this.b.s();
    }

    public void enterBackground() {
        AnimaXPlayer r0 = this.b;
        r0.getClass();
        r0.z(false, VisibilityState.BACKGROUND);
    }

    public void enterForeground() {
        AnimaXPlayer r0 = this.b;
        r0.getClass();
        r0.z(true, VisibilityState.BACKGROUND);
    }

    public double getCurrentFrame() {
        return this.b.getCurrentFrame();
    }

    public double getDuration() {
        return this.b.getDurationMs();
    }

    public boolean pause() {
        this.b.pause();
        this.i = true;
        return true;
    }

    public boolean start() {
        if (this.i == false) goto L5;
        this.b.resume();
    L6:
        this.i = false;
        return true;
    L5:
        this.b.play();
        goto L6
    }

    public boolean stop() {
        this.b.v();
        this.i = false;
        return true;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.c;
    }

    public LottieAnimation(ClayPluginContext r7) {
        this.a = 0;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = true;
        this.i = false;
        Context r8 = r7.a.getContext();
        c r2 = new c();
        a r4 = new a();
        ((ConcurrentHashMap) r2.c.a).put(b.class, r4);
        AnimaXContext r9 = new AnimaXContext(new AnimaXContext.a(r2, r8));
        ((CopyOnWriteArrayList) r9.getAbility().a).add(this);
        AnimaXPlayer r3 = new AnimaXPlayer(r9);
        this.b = r3;
        r3.setAutoPlay(true);
        SurfaceTexture r10 = new SurfaceTexture(0);
        this.c = r10;
        r10.setOnFrameAvailableListener(this);
        this.c.detachFromGLContext();
    }

    public static LottieAnimation Create(ClayPluginContext r1) {
        return new LottieAnimation(r1);
    }

    @Override // t4a.f
    public final void a(t4a.c r3) {
        if (this.h == false) goto L6;
        nativeOnUpdate(this.a);
        return;
    }

    @Override // t4a.f
    public final void b(t4a.c r3) {
        nativeOnCancel(this.a);
    }

    @Override // t4a.f
    public final void c(t4a.c r3) {
        nativeOnReady(this.a);
    }

    @Override // t4a.f
    public final void d(t4a.c r3) {
        nativeOnRepeat(this.a);
    }

    @Override // t4a.f
    public final void e(t4a.c r3) {
        nativeOnFirstFrame(this.a);
    }

    @Override // t4a.f
    public final void g(t4a.b r5) {
        nativeOnFPS(this.a, r5.a("fps"), r5.a("max_drop_rate"));
    }

    @Override // t4a.f
    public final void i(t4a.a r5) {
        long r0 = this.a;
        int r2 = r5.b();
        Object r6 = r5.a.get("msg");
        if ((r6 instanceof String) == false) goto L5;
        String r7 = (String) r6;
    L6:
        nativeOnError(r0, r2, r7);
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // t4a.f
    public final void j(t4a.c r3) {
        nativeOnStart(this.a);
    }

    @Override // t4a.f
    public final void l(t4a.c r3) {
        nativeOnComplete(this.a);
    }

    public void listenAnimationUpdate(boolean r1) {
        this.h = r1;
    }

    @Override // t4a.f
    public final void o(t4a.c r3) {
        nativeOnFirstFrame(this.a);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r2) {
        c5a.c.c("LottieAnimation", "onFrameAvailable");
    }

    public boolean seekFrame(int r2) {
        this.b.a(r2);
        return true;
    }

    public void setAutoPlay(boolean r2) {
        this.b.setAutoPlay(r2);
    }

    public void setAutoReverse(boolean r2) {
        this.b.setAutoReverse(r2);
    }

    public void setDynamicResource(boolean r2) {
        this.b.k(r2);
    }

    public void setEndFrame(int r2) {
        this.b.setEndFrame(r2);
    }

    public void setFpsEventInterval(int r4) {
        this.b.j(r4);
    }

    public void setJson(String r2) {
        this.b.setJson(r2);
        if (this.b.e == false) goto L6;
        start();
        return;
    }

    public void setLoop(boolean r2) {
        this.b.setLoop(r2);
    }

    public void setMaxFrameRate(float r4) {
        this.b.setMaxFrameRate(r4);
    }

    public void setNativePointer(long r1) {
        this.a = r1;
    }

    public void setObjectFit(String r2) {
        if (r2.equals("center") == false) goto L6;
        this.b.setObjectFit(ObjectFit.CENTER);
        return;
    L6:
        if (r2.equals("contain") == false) goto L9;
        this.b.setObjectFit(ObjectFit.CONTAIN);
        return;
    L9:
        if (r2.equals("cover") == false) goto L12;
        this.b.setObjectFit(ObjectFit.COVER);
        return;
    L12:
        if (r2.equals("fill") == false) goto L18;
        this.b.setObjectFit(ObjectFit.FILL);
        return;
    }

    public void setProgress(float r2) {
        this.b.setProgress(r2);
    }

    public void setRepeatCount(int r2) {
        this.b.setLoopCount(r2);
    }

    public void setSpeed(float r2) {
        this.b.setSpeed(r2);
    }

    public void setSrc(String r2) {
        this.b.setSrc(r2);
        if (this.b.e == false) goto L6;
        start();
        return;
    }

    public void setStartFrame(int r2) {
        this.b.setStartFrame(r2);
    }

    public boolean subscribeUpdateFrame(int r2) {
        this.b.w(r2);
        return true;
    }

    public boolean subscribeUpdateFrames(int[] r3) {
        this.b.b(r3, true);
        return true;
    }

    public boolean unSubscribeUpdateFrame(int r2) {
        this.b.x(r2);
        return true;
    }

    public boolean unSubscribeUpdateFrames(int[] r3) {
        this.b.b(r3, false);
        return true;
    }

    public void playSegment(int r2, int r3) {
        this.b.r(r2, r3);
    }

    public void render(int r8, int r9) {
        if (this.e != r8) goto L8;
        if (this.f != r9) goto L8;
        return;
    L8:
        if (this.g == true) goto L10;
        SurfaceTexture r3 = this.c;
        AnimaXSurfaceDrawable r0 = new AnimaXSurfaceDrawable(new Surface(r3), r3, null, r8, r9);
        this.d = r0;
        this.b.p(r0);
        this.g = true;
    L14:
        this.e = r8;
        this.f = r9;
        return;
    L10:
        AnimaXSurfaceDrawable r1 = this.d;
        r1.e = r8;
        r1.f = r9;
        BitmapBufferGroup r2 = r1.c;
        if (r2 == null) goto L13;
        r2.b(r8, r9);
    L13:
        this.b.y(this.d);
        goto L14
    }
}
