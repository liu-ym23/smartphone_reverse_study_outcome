package com.lynx.animax.player;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends com.lynx.animax.player.a implements SurfaceTexture.OnFrameAvailableListener, CodecManager.a {
    public boolean j;
    public final Lock k;
    public final Condition l;
    public CodecManager m;
    public Handler n;
    public volatile boolean o;

    public class a implements Runnable {
        public final /* synthetic */ h a;

        @Override // java.lang.Runnable
        public final void run() {
            h r0 = this.a;     // Catch: Throwable -> L4
            CodecManager r1 = new CodecManager(r0);     // Catch: Throwable -> L4
            r0.m = r1;     // Catch: Throwable -> L4
            r1.j = 0;     // Catch: Throwable -> L4
            r1.g();     // Catch: Throwable -> L4
            r1.e = -1;     // Catch: Throwable -> L4
            r1.h = 0;     // Catch: Throwable -> L4
            r1.f = 0;     // Catch: Throwable -> L4
            r1.g = -1;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ VideoAsset a;
        public final /* synthetic */ h b;

        @Override // java.lang.Runnable
        public final void run() {
            CodecManager r0 = this.b.m;     // Catch: Throwable -> L14
            VideoAsset r1 = this.a;     // Catch: Throwable -> L14
            r0.n = r1;     // Catch: Throwable -> L14
            if (r1 != null) goto L6;
        L19:
            return;
        L6:
            if (r1.b() == true) goto L8;
            AnimaXLog.a("CodecManager", "attachAsset error: prepareFrameBuffer fail, reset mAsset");     // Catch: Throwable -> L14
            r0.n = null;     // Catch: Throwable -> L14
            goto L19
        L8:
            long r2 = (long) r0.n.getFrameRate();     // Catch: Throwable -> L14
            if (r2 > 0) goto L12;
            r2 = 30;
        L12:
            r0.l = 1000000 / r2;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }

        public b(h r1, VideoAsset r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ h a;

        @Override // java.lang.Runnable
        public final void run() {
            h r0 = this.a;     // Catch: Throwable -> L4
            CodecManager r1 = r0.m;     // Catch: Throwable -> L4
            r1.o = r0.c;     // Catch: Throwable -> L4
            r1.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(h r1) {
            this.a = r1;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ h b;

        public final void a() {
            CodecManager r0 = this.b.m;
            int r1 = this.a;
            if (r0.d == false) goto L6;
            r0.d = false;
            r0.d();
            r0.b();
        L6:
            if (r0.c == true) goto L9;
            return;
        L9:
            if (r1 == r0.e) goto L123;
            VideoAsset r2 = r0.n;
            if (r2 == null) goto L38;
            int r3 = r2.getPrevKeyFrame(r1);
            if ((-1) != r0.g) goto L17;
            r0.h = 0;
            r0.f = r3;
            goto L38
        L17:
            int r8 = (r1 - r3) + 1;
            int r9 = r0.e;
            if (r9 > r1) goto L20;
            int r10 = r9;
            int r11 = r1;
        L21:
            int r12 = r11 - r10;
            int r13 = r0.h;
            if (r12 > r13) goto L24;
            int r14 = 0;
        L25:
            if (r14 <= r8) goto L38;
            if (r13 > 0) goto L104;
        L36:
            r0.f = r3;
            r0.g = -1;
            goto L38
        L104:
            r0.a.flush();     // Catch: IllegalStateException -> L29 MediaCodec.CodecException -> L31
            String r15 = null;
        L33:
            if (r15 == null) goto L35;
            r0.e(r15);
            r0.c = false;
        L35:
            r0.h = 0;
            goto L36
        L31:
            e = move-exception;
            r15 = "[" + r0.b + "]: flush CodecException: " + e.getMessage();
        L29:
            e = move-exception;
            r15 = "[" + r0.b + "]: flush IllegalStateException: " + e.getMessage();
            goto L33
        L24:
            r14 = r12 - r13;
            goto L25
        L20:
            r11 = r0.n.getFrameCount() + r1;
            r10 = r0.e;
        L38:
            if (r0.c == false) goto L124;
            MediaCodec.BufferInfo r4 = new MediaCodec.BufferInfo();
            int r16 = 3;
        L42:
            if (r0.e == r1) goto L97;
        L44:
            if (r0.c() == true) goto L44;
            if (r0.h == 0) goto L125;
            if (r0.g != r1) goto L51;
            boolean r17 = true;
        L53:
            if (r0.n != null) goto L108;
            CodecManager.ProcessFrameStatus r18 = CodecManager.ProcessFrameStatus.FATAL;
        L88:
            if (CodecManager.ProcessFrameStatus.SUCCESS == r18) goto L42;
            if (CodecManager.ProcessFrameStatus.TRY_AGAIN == r18) goto L42;
            if (CodecManager.ProcessFrameStatus.TRY_AGAIN_IF_NECESSARY != r18) goto L126;
            if (r16 <= 0) goto L127;
            r16 = r16 - 1;
            goto L42
        L127:
            return;
        L126:
            return;
        L108:
            int r19 = r0.a.dequeueOutputBuffer(r4, r0.l);     // Catch: IllegalStateException -> L83 MediaCodec.CodecException -> L85
        L57:
            if ((-3) != r19) goto L60;
            AnimaXLog.b("CodecManager", "output buffers changed");
            r18 = CodecManager.ProcessFrameStatus.TRY_AGAIN;
            goto L88
        L60:
            if ((-2) != r19) goto L70;
            StringBuilder r20 = new StringBuilder("output format changed: ");
            MediaCodec r110 = r0.a;
            if (r110 != null) goto L102;
        L68:
            MediaFormat r111 = null;
        L69:
            r20.append(r111);
            AnimaXLog.b("CodecManager", r20.toString());
            r18 = CodecManager.ProcessFrameStatus.TRY_AGAIN;
            goto L88
        L102:
            r111 = r110.getOutputFormat();     // Catch: IllegalStateException -> L66
        L66:
            e = move-exception;
            AnimaXLog.a("CodecManager", "getOutputFormat failed: " + e.getMessage());
            goto L68
        L70:
            if ((-1) != r19) goto L72;
            r0.j++;
            r0.g();
            r18 = CodecManager.ProcessFrameStatus.TRY_AGAIN_IF_NECESSARY;
            goto L88
        L72:
            if (r19 >= 0) goto L106;
            r0.e("[" + r0.b + "]: outputBufferIndex: " + r19);
            r18 = CodecManager.ProcessFrameStatus.FATAL;
            goto L88
        L106:
            r0.a.releaseOutputBuffer(r19, r17);     // Catch: IllegalStateException -> L76 MediaCodec.CodecException -> L78
            String r21 = null;
        L80:
            if (r21 == null) goto L82;
            r0.e(r21);
        L82:
            r0.h--;
            int r22 = r0.g;
            r0.e = r22;
            r0.g = (r22 + 1) % r0.n.getFrameCount();
            r18 = CodecManager.ProcessFrameStatus.SUCCESS;
            goto L88
        L78:
            e = move-exception;
            r21 = "[" + r0.b + "]: releaseOutputBuffer CodecException: " + e.getMessage();
        L76:
            e = move-exception;
            r21 = "[" + r0.b + "]: releaseOutputBuffer IllegalStateException: " + e.getMessage();
        L85:
            e = move-exception;
            r0.e("[" + r0.b + "]: dequeueOutputBuffer CodecException: " + e.getMessage());
            r18 = CodecManager.ProcessFrameStatus.FATAL;
        L83:
            e = move-exception;
            r0.e("[" + r0.b + "]: dequeueOutputBuffer IllegalStateException: " + e.getMessage());
            r0.c = false;
            r0.d = true;
            r18 = CodecManager.ProcessFrameStatus.FATAL;
            goto L88
        L51:
            r17 = false;
            goto L53
        L125:
            return;
        L97:
            CodecManager.a r5 = r0.m;
            if (r5 == null) goto L100;
            h r6 = (h) r5;
            r6.d(new j(r6));
        L100:
            r0.c();
            return;
        L124:
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

        public d(h r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ CountDownLatch a;
        public final /* synthetic */ h b;

        @Override // java.lang.Runnable
        public final void run() {
            CodecManager r0 = this.b.m;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.m = null;     // Catch: Throwable -> L7
            r0.d();     // Catch: Throwable -> L7
        L5:
            this.a.countDown();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public e(h r1, CountDownLatch r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // com.lynx.animax.player.a, com.lynx.animax.player.IVideoPlayer
    public final void destroy() {
        if (this.o == false) goto L5;
        return;
    L5:
        this.o = true;
        CountDownLatch r3 = new CountDownLatch(1);
        com.lynx.animax.player.c r2 = com.lynx.animax.player.c.a();
        e r4 = new e(this, r3);
        Handler r5 = r2.b;
        if (r5 != null) goto L8;
        AnimaXLog.a("CodecThreadManager", "Attempted to post to codec thread after it was released or not alive.");
    L16:
        long r6 = this.i.d;     // Catch: InterruptedException -> L13
        AnimaXLog.b("VideoPlayerImpl", "destroy: wait for codec thread to complete destroy tasks with " + r6 + "ms");     // Catch: InterruptedException -> L13
        if (r3.await(r6, TimeUnit.MILLISECONDS) == true) goto L14;
        AnimaXLog.d("VideoPlayerImpl", "Timeout waiting for codec thread to complete destroy tasks");     // Catch: InterruptedException -> L13
    L14:
        super.destroy();
        return;
    L13:
        AnimaXLog.d("VideoPlayerImpl", "Interrupted while waiting for codec thread to complete destroy tasks");
        ThreadMethodProxy.currentThread().interrupt();
        goto L14
    L8:
        r5.postAtFrontOfQueue(r4);
        goto L16
    }

    @Override // com.lynx.animax.player.a, com.lynx.animax.player.IVideoPlayer
    public final void attachAsset(VideoAsset r2) {
        super.attachAsset(r2);
        c(new k(this, new b(this, r2)));
    }

    public final void c(Runnable r4) {
        if (this.o == false) goto L5;
        return;
    L5:
        com.lynx.animax.player.c r0 = com.lynx.animax.player.c.a();
        if (r0.b != null) goto L9;
        AnimaXLog.a("CodecThreadManager", "Attempted to post to codec thread after it was released or not alive.");
        return;
    L9:
        if (Looper.myLooper() != r0.b.getLooper()) goto L11;
        r4.run();
        return;
    L11:
        r0.b.post(r4);
    }

    public final void d(Runnable r3) {
        if (this.n != null) goto L5;
        AnimaXLog.a("VideoPlayerImpl", "Attempted to post to GL thread after it was released or not alive.");
        return;
    L5:
        if (Looper.myLooper() != this.n.getLooper()) goto L7;
        r3.run();
        return;
    L7:
        this.n.post(r3);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r2) {
        ((ReentrantLock) this.k).lock();
        this.j = true;
        this.l.signalAll();     // Catch: Throwable -> L6
        ((ReentrantLock) this.k).unlock();
        return;
    L6:
        th = move-exception;
        ((ReentrantLock) this.k).unlock();
        throw th;
    }

    @Override // com.lynx.animax.player.a, com.lynx.animax.player.IVideoPlayer
    public final void setSurface(int r2) {
        super.setSurface(r2);
        this.j = false;
        this.b.setOnFrameAvailableListener(this, y4a.d.a());
        if (this.a != null) goto L6;
        AnimaXLog.a("VideoPlayerImpl", "setSurface error: mAsset is null");
        return;
    L6:
        c(new k(this, new c(this)));
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final boolean updateSurface(int r8) {
        if (this.o == false) goto L5;
        return false;
    L5:
        c(new k(this, new d(this, r8)));
        if (this.n == null) goto L26;
        if (Looper.myLooper() != this.n.getLooper()) goto L26;
        ((ReentrantLock) this.k).lock();
        if (this.j == false) goto L27;
        this.j = false;
        ((ReentrantLock) this.k).unlock();
        boolean r9 = true;
    L21:
        if (r9 == true) goto L23;
        AnimaXLog.a("VideoPlayerImpl", "await onFrameAvailable time out");
        return false;
    L23:
        this.b.updateTexImage();
        return true;
    L27:
        this.l.await(this.i.c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L13 InterruptedException -> L15
    L17:
        r9 = this.j;
        this.j = false;
        ((ReentrantLock) this.k).unlock();
        goto L21
    L15:
        e = move-exception;
        AnimaXLog.a("VideoPlayerImpl", "await onFrameAvailable error: " + e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.j = false;
        ((ReentrantLock) this.k).unlock();
        throw th;
    L26:
        throw new IllegalStateException("Must be called on GL thread, current: " + ThreadMethodProxy.currentThread().getName());
    }

    public h(long r4, g r6) {
        super(r6);
        ReentrantLock r5 = new ReentrantLock();
        this.k = r5;
        this.l = r5.newCondition();
        this.o = false;
        Looper r7 = Looper.myLooper();
        if (r7 == null) goto L5;
        this.n = new Handler(r7);
    L5:
        c(new a(this));
        g r8 = this.i;
        if (r8.c > 0) goto L9;
        r8.c = 20;
    L9:
        if (r8.d > 0) goto L12;
        r8.d = 1000;
        return;
    }
}
