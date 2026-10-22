package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.load.engine.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class GifFrameLoader {
    private final com.bumptech.glide.load.engine.bitmap_recycle.a bitmapPool;
    private final List<f> callbacks;
    private e current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final x.a gifDecoder;
    private final Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private e next;

    @Nullable
    private h onEveryFrameListener;
    private e pendingTarget;
    private com.bumptech.glide.f requestBuilder;
    final com.bumptech.glide.g requestManager;
    private boolean startFromFirstFrame;
    private z.i transformation;
    private int width;

    public GifFrameLoader(com.bumptech.glide.load.engine.bitmap_recycle.a r5, com.bumptech.glide.g r10, x.a r11, Handler r12, com.bumptech.glide.f r13, z.i r14, Bitmap r15) {
        this.callbacks = new ArrayList();
        this.requestManager = r10;
        if (r12 != null) goto L5;
        r12 = new Handler(Looper.getMainLooper(), new g(this));
    L5:
        this.bitmapPool = r5;
        this.handler = r12;
        this.requestBuilder = r13;
        this.gifDecoder = r11;
        setFrameTransformation(r14, r15);
    }

    private static z.c getFrameSignature() {
        return new p0.b(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.f getRequestBuilder(com.bumptech.glide.g r5, int r10, int r11) {
        r5.getClass();
        com.bumptech.glide.f r12 = new com.bumptech.glide.f(r5.f1407a, r5, Bitmap.class, r5.f1408b).r(com.bumptech.glide.g.f1406l);
        m r13 = m.f1544b;
        return r12.r(((com.bumptech.glide.request.c) ((com.bumptech.glide.request.c) ((com.bumptech.glide.request.c) new com.bumptech.glide.request.c().e(r13)).q()).n()).h(r10, r11));
    }

    private void loadNextFrame() {
        if (this.isRunning == true) goto L5;
        return;
    L5:
        if (this.isLoadPending == true) goto L30;
        int r5 = -1;
        int r10 = 0;
        if (this.startFromFirstFrame == true) goto L10;
    L14:
        e r11 = this.pendingTarget;
        if (r11 == null) goto L18;
        this.pendingTarget = null;
        onFrameReady(r11);
        return;
    L18:
        this.isLoadPending = true;
        x.e r12 = (x.e) this.gifDecoder;
        x.c r13 = r12.f22935l;
        int r14 = r13.f22919c;
        if (r14 <= 0) goto L27;
        int r15 = r12.f22934k;
        if (r15 < 0) goto L27;
        if (r15 < 0) goto L26;
        if (r15 >= r14) goto L26;
        r5 = ((x.b) r13.e.get(r15)).f22914i;
    L26:
        r10 = r5;
    L27:
        long r16 = SystemClock.uptimeMillis() + ((long) r10);
        x.a r17 = this.gifDecoder;
        x.e r18 = (x.e) r17;
        r18.f22934k = (r18.f22934k + 1) % r18.f22935l.f22919c;
        this.next = new e(this.handler, ((x.e) r17).f22934k, r16);
        com.bumptech.glide.f r19 = this.requestBuilder.r((com.bumptech.glide.request.c) new com.bumptech.glide.request.c().m(getFrameSignature()));
        r19.f1404v = this.gifDecoder;
        r19.f1405w = true;
        r19.t(this.next, r19, q0.e.f21451a);
        return;
    L10:
        if (this.pendingTarget != null) goto L12;
        boolean r20 = true;
    L13:
        io.reactivex.internal.observers.h.f("Pending target must be null when starting from the first frame", r20);
        ((x.e) this.gifDecoder).f22934k = -1;
        this.startFromFirstFrame = false;
        goto L14
    L12:
        r20 = false;
        goto L13
    }

    private void recycleFirstFrame() {
        Bitmap r5 = this.firstFrame;
        if (r5 == null) goto L6;
        this.bitmapPool.b(r5);
        this.firstFrame = null;
        return;
    }

    private void start() {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    private void stop() {
        this.isRunning = false;
    }

    public void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        e r5 = this.current;
        if (r5 == null) goto L5;
        this.requestManager.j(r5);
        this.current = null;
    L5:
        e r10 = this.next;
        if (r10 == null) goto L8;
        this.requestManager.j(r10);
        this.next = null;
    L8:
        e r11 = this.pendingTarget;
        if (r11 == null) goto L11;
        this.requestManager.j(r11);
        this.pendingTarget = null;
    L11:
        x.e r12 = (x.e) this.gifDecoder;
        r12.f22935l = null;
        byte[] r13 = r12.f22932i;
        com.lynx.animax.player.b r14 = r12.f22930c;
        if (r13 == null) goto L17;
        com.bumptech.glide.load.engine.bitmap_recycle.f r15 = (com.bumptech.glide.load.engine.bitmap_recycle.f) r14.f9658c;
        if (r15 == null) goto L17;
        r15.h(r13);
    L17:
        int[] r16 = r12.f22933j;
        if (r16 == null) goto L23;
        com.bumptech.glide.load.engine.bitmap_recycle.f r17 = (com.bumptech.glide.load.engine.bitmap_recycle.f) r14.f9658c;
        if (r17 == null) goto L23;
        r17.h(r16);
    L23:
        Bitmap r18 = r12.f22936m;
        if (r18 == null) goto L26;
        ((com.bumptech.glide.load.engine.bitmap_recycle.a) r14.f9657b).b(r18);
    L26:
        r12.f22936m = null;
        r12.d = null;
        r12.s = null;
        byte[] r19 = r12.e;
        if (r19 == null) goto L32;
        com.bumptech.glide.load.engine.bitmap_recycle.f r20 = (com.bumptech.glide.load.engine.bitmap_recycle.f) r14.f9658c;
        if (r20 == null) goto L32;
        r20.h(r19);
    L32:
        this.isCleared = true;
    }

    public ByteBuffer getBuffer() {
        return ((x.e) this.gifDecoder).d.asReadOnlyBuffer();
    }

    public Bitmap getCurrentFrame() {
        e r5 = this.current;
        if (r5 == null) goto L6;
        return r5.g;
    L6:
        return this.firstFrame;
    }

    public int getCurrentIndex() {
        e r5 = this.current;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.e;
    }

    public Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    public int getFrameCount() {
        return ((x.e) this.gifDecoder).f22935l.f22919c;
    }

    public z.i getFrameTransformation() {
        return this.transformation;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        int r5 = ((x.e) this.gifDecoder).f22935l.f22924l;
        if (r5 == (-1)) goto L10;
        if (r5 != 0) goto L8;
        return 0;
    L8:
        return 1 + r5;
    L10:
        return 1;
    }

    public int getSize() {
        x.e r5 = (x.e) this.gifDecoder;
        int r10 = r5.d.limit() + r5.f22932i.length;
        return ((r5.f22933j.length * 4) + r10) + this.firstFrameSize;
    }

    public int getWidth() {
        return this.width;
    }

    @VisibleForTesting
    public void onFrameReady(e r10) {
        this.isLoadPending = false;
        if (this.isCleared == false) goto L7;
        this.handler.obtainMessage(2, r10).sendToTarget();
        return;
    L7:
        if (this.isRunning == true) goto L11;
        this.pendingTarget = r10;
        return;
    L11:
        if (r10.g == null) goto L36;
        recycleFirstFrame();
        e r5 = this.current;
        this.current = r10;
        int r11 = this.callbacks.size() - 1;
    L13:
        if (r11 < 0) goto L34;
        GifDrawable r12 = (GifDrawable) this.callbacks.get(r11);
        Object r13 = r12.getCallback();
    L16:
        if ((r13 instanceof Drawable) == false) goto L18;
        r13 = ((Drawable) r13).getCallback();
        goto L16
    L18:
        if (r13 != null) goto L20;
        r12.stop();
        r12.invalidateSelf();
    L33:
        r11 = r11 - 1;
        goto L13
    L20:
        r12.invalidateSelf();
        GifDrawable.GifState r14 = r12.f1643a;
        if (r14.frameLoader.getCurrentIndex() != (r14.frameLoader.getFrameCount() - 1)) goto L23;
        r12.f++;
    L23:
        int r15 = r12.g;
        if (r15 == (-1)) goto L33;
        if (r12.f < r15) goto L33;
        ArrayList r16 = r12.f1649k;
        if (r16 == null) goto L32;
        int r17 = r16.size();
        int r18 = 0;
    L30:
        if (r18 >= r17) goto L32;
        ((Animatable2Compat.AnimationCallback) r12.f1649k.get(r18)).onAnimationEnd(r12);
        r18 = r18 + 1;
    L32:
        r12.stop();
        goto L33
    L34:
        if (r5 == null) goto L36;
        this.handler.obtainMessage(2, r5).sendToTarget();
    L36:
        loadNextFrame();
    }

    public void setFrameTransformation(z.i r5, Bitmap r10) {
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.transformation = r5;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        this.firstFrame = r10;
        this.requestBuilder = this.requestBuilder.r(new com.bumptech.glide.request.c().p(r5, true));
        this.firstFrameSize = q0.i.c(r10);
        this.width = r10.getWidth();
        this.height = r10.getHeight();
    }

    public void setNextStartFromFirstFrame() {
        io.reactivex.internal.observers.h.f("Can't restart a running animation", !this.isRunning);
        this.startFromFirstFrame = true;
        e r5 = this.pendingTarget;
        if (r5 == null) goto L6;
        this.requestManager.j(r5);
        this.pendingTarget = null;
        return;
    }

    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable h r5) {
    }

    public void subscribe(f r5) {
        if (this.isCleared == true) goto L13;
        if (this.callbacks.contains(r5) == true) goto L11;
        boolean r10 = this.callbacks.isEmpty();
        this.callbacks.add(r5);
        if (r10 == false) goto L14;
        start();
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("Cannot subscribe twice in a row");
    L13:
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    public void unsubscribe(f r5) {
        this.callbacks.remove(r5);
        if (this.callbacks.isEmpty() == false) goto L6;
        stop();
        return;
    }

    public GifFrameLoader(com.bumptech.glide.b r10, x.a r11, int r12, int r13, z.i r14, Bitmap r15) {
        com.bumptech.glide.load.engine.bitmap_recycle.a r5 = r10.f1382a;
        com.bumptech.glide.c r16 = r10.f1384c;
        Context r17 = r16.getBaseContext();
        io.reactivex.internal.observers.h.h(r17, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        com.bumptech.glide.g r18 = com.bumptech.glide.b.b(r17).f.b(r17);
        Context r19 = r16.getBaseContext();
        io.reactivex.internal.observers.h.h(r19, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        this(r5, r18, r11, null, getRequestBuilder(com.bumptech.glide.b.b(r19).f.b(r19), r12, r13), r14, r15);
    }
}
