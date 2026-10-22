package v3a;

import android.os.Handler;
import android.os.Looper;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.AbsAudioPlayManager;
import com.larus.audio.call.play.h;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends com.larus.audio.call.play.c {
    public Handler A;
    public volatile boolean B;
    public final ReentrantLock C;
    public volatile ByteBuffer D;
    public final boolean x;
    public final String y;
    public final PthreadHandlerThreadV2 z;

    public static final class a {
    }

    static {
    }

    public final int p() {
        return 4;
    }

    public final int r() {
        return 4800;
    }

    public final void C() {
        if (this.x == true) goto L5;
        return;
    L5:
        ReentrantLock r0 = this.C;
        r0.lock();
        this.D = ByteBuffer.allocateDirect(4800);     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r0.unlock();
        return;
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void b() {
        Handler r0 = this.A;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        w(AbsAudioPlayManager.Wait.INVALID);
        super.b();
    }

    public final void init() {
        if (this.B == false) goto L5;
    L7:
        Handler r1 = null;
        if (ThreadMethodProxy.isAlive(this.z) == false) goto L10;
        PthreadHandlerThreadV2 r0 = this.z;
    L11:
        if (r0 == null) goto L13;
        r1 = new Handler(r0.getLooper());
    L13:
        this.A = r1;
        super.init();
        return;
    L10:
        r0 = null;
        goto L11
    L5:
        if (ThreadMethodProxy.isAlive(this.z) == true) goto L7;
        ThreadMethodProxy.start(this.z);
        goto L7
    }

    public final boolean isPlaying() {
        return ((com.larus.audio.call.play.c) this).o;
    }

    public final String t() {
        return this.y;
    }

    public final void D(Runnable r5) {
        Thread r1 = null;
        if (ThreadMethodProxy.isAlive(this.z) == false) goto L5;
        PthreadHandlerThreadV2 r0 = this.z;
    L6:
        Handler r2 = this.A;
        if (r2 != null) goto L13;
        if (r0 == null) goto L12;
        Looper r3 = r0.getLooper();
        if (r3 == null) goto L12;
        r2 = new Handler(r3);
    L12:
        r2 = null;
    L13:
        if (r2 != null) goto L15;
    L25:
        r5.run();
        return;
    L15:
        if (this.B == true) goto L25;
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r0 == null) goto L22;
        Looper r6 = r0.getLooper();
        if (r6 == null) goto L22;
        r1 = ThreadMethodProxy.getLooperThread(r6);
    L22:
        if (Intrinsics.areEqual(r4, r1) == true) goto L25;
        r2.post(r5);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void g(final h r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        D(new e(this, r2));
    }

    public final void pause(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        D(new c(this, r2));
    }

    public final void release(boolean r3) {
        Handler r0 = this.A;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        if (r3 == false) goto L7;
        this.A = null;
        this.B = true;
        this.z.quit();
    L7:
        super.release(r3);
    }

    public final void resume(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        D(new v3a.a(this, r2));
    }

    public final byte[] s(byte[] r12) {
        if (this.x == false) goto L46;
        ReentrantLock r2 = this.C;
        r2.lock();
        ByteBuffer r3 = this.D;     // Catch: Throwable -> L42
        if (r3 != null) goto L8;
        r2.unlock();
        goto L46
    L8:
        int r4 = r3.remaining();     // Catch: Throwable -> L42
        boolean r5 = false;
        if (r12 == null) goto L11;
        int r6 = r12.length;     // Catch: Throwable -> L42
    L13:
        if (r3.isReadOnly() == true) goto L26;
        if (r4 <= r6) goto L26;
        if (r12 != null) goto L18;
    L24:
        r2.unlock();
    L25:
        r12 = null;
        goto L46
    L18:
        if (r12.length != 0) goto L20;
        r5 = true;
    L20:
        if (r5 == true) goto L24;
        r3.put(r12);     // Catch: Throwable -> L42
        r2.unlock();
    L26:
        r3.flip();     // Catch: Throwable -> L42
        ByteBuffer r7 = ByteBuffer.allocate(r3.limit() + r6);     // Catch: Throwable -> L42
        r7.put(r3);     // Catch: Throwable -> L42
        if (r12 != null) goto L29;
    L34:
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r7, "<this>");     // Catch: Throwable -> L42
        r7.rewind();     // Catch: Throwable -> L42
        int r13 = r7.remaining();     // Catch: Throwable -> L42
        byte[] r8 = new byte[r13];     // Catch: Throwable -> L42
        r7.get(r8);     // Catch: Throwable -> L42
        if (r3.isReadOnly() == false) goto L40;
        FLogger.a.w(this.y, "[buffer] Buffer is read only, will relocate buffer region, input length: " + r6 + ",buffer remaining: " + r4 + ",result length: " + r13 + '.');     // Catch: Throwable -> L42
        C();     // Catch: Throwable -> L42
    L41:
        r2.unlock();
        r12 = r8;
        goto L46
    L40:
        FLogger.a.w(this.y, "[buffer] The input data content will exceed the free buffer space, input length: " + r6 + ", buffer remaining: " + r4 + ",result length: " + r13 + '.');     // Catch: Throwable -> L42
        r3.clear();     // Catch: Throwable -> L42
        goto L41
    L29:
        if (r12.length != 0) goto L32;
        r5 = true;
    L32:
        if ((!r5) == false) goto L34;
        r7.put(r12);     // Catch: Throwable -> L42
        goto L34
    L11:
        r6 = 0;
    L42:
        th = move-exception;
        r2.unlock();
        throw th;
    L46:
        return super.s(r12);
    }

    public final void setVolume(final float r2) {
        D(new b(this, r2));
    }

    public static void A(f r0, float r1) {
        super.setVolume(r1);
    }

    public static void B(f r0, String r1) {
        super.pause(r1);
    }

    public static void x(f r0, h r1) {
        super.g(r1);
    }

    public static void y(f r0, String r1) {
        super.resume(r1);
    }

    public f(RealtimeCallParam r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "param");
        super(r2, r3, r4);
        this.x = false;
        this.y = "AsyncAudioPlayManager" + hashCode();
        this.z = new PthreadHandlerThreadV2("audio_play_manager_operator_thread");
        this.C = new ReentrantLock();
        i(new g(this));
    }

    public final void d(boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "endType");
        Handler r1 = this.A;
        if (r1 == null) goto L5;
        r1.removeCallbacksAndMessages(null);
    L5:
        w(AbsAudioPlayManager.Wait.INVALID);
        super.d(r6, r7, r8);
        if (this.x == false) goto L13;
        ReentrantLock r9 = this.C;
        r9.lock();
        FLogger.a.w(this.y, "[Stop] immediate: " + r6 + ", releaseTrack: " + r7 + ", remove buffer region.");     // Catch: Throwable -> L10
        this.D = null;     // Catch: Throwable -> L10
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r9.unlock();
        return;
    L10:
        th = move-exception;
        r9.unlock();
        throw th;
    }

    public final void k(final boolean r2, final boolean r3, final String r4) {
        Intrinsics.checkNotNullParameter(r4, "caller");
        D(new d(this, r2, r3, r4));
    }

    public static void z(f r0, boolean r1, boolean r2, String r3) {
        super.k(r1, r2, r3);
    }
}
