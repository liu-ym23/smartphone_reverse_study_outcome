package p58;

import android.media.AudioRecord;
import android.media.AudioTimestamp;
import android.os.Build;
import android.os.SystemClock;
import com.larus.audio.audiov3.audio.record.AudioRecordErrorEnum;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.audio.call.dora.CommandStatus;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fna.g;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements r58.c {
    public int a;
    public final String b;
    public boolean c;
    public v58.a d;
    public AudioRecord e;
    public AudioRecordState f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void b(long r1, long r3) {
    }

    @Override // r58.c
    public final void e(Function0<Unit> r1) {
    }

    @Override // r58.c
    public final void f(Function2<? super String, ? super Long, Unit> r1) {
    }

    @Override // r58.c
    public final void g(Function2<? super Boolean, ? super String, Unit> r1) {
    }

    @Override // r58.c
    public final void j() {
    }

    @Override // r58.c
    public final int c() {
        int r0 = this.a;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        v58.a r1 = this.d;
        if (r1 == null) goto L9;
        m(r1);
    L9:
        return this.a;
    }

    @Override // r58.c
    public final void prepare() {
        v58.a r1 = this.d;
        if (r1 == null) goto L21;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        if (this.a != (-1)) goto L7;
        m(r1);     // Catch: Throwable -> L9
    L7:
        int r3 = c68.b.a;     // Catch: Throwable -> L9
        c68.b.d(this.b, "start => minBufferSize:" + this.a);     // Catch: Throwable -> L9
        this.e = new AudioRecord(r1.d, r1.a, r1.b, r1.c, this.a * ((Number) this.h.getValue()).intValue());     // Catch: Throwable -> L9
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.isSuccess-impl(r0) == false) goto L14;
        Unit r4 = (Unit) r0;
        int r5 = c68.b.a;
        c68.b.d(this.b, "prepare => success");
        s(AudioRecordState.INITIALIZED);
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r0);
        if (r6 == null) goto L17;
        int r7 = c68.b.a;
        c68.b.c(this.b, "prepare => fail", r6);
        r(AudioRecordErrorEnum.PREPARE_ERROR);
    L17:
        Result.box-impl(r0);
        return;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final long q() {
        v58.a r0 = this.d;
        if (r0 != null) goto L6;
        return 40;
    L6:
        int r1 = c();
        if (r0.b != 12) goto L9;
        int r2 = 2;
    L11:
        return (((((long) r1) * 1000) / ((long) r0.a)) / ((long) r0.c)) / ((long) r2);
    L9:
        r2 = 1;
        goto L11
    }

    @Override // r58.c
    public final void release() {
        AudioRecord r0 = this.e;
        if (r0 != null) goto L5;
    L25:
        r(AudioRecordErrorEnum.RELEASE_ERROR);
        return;
    L5:
        if (r0.getState() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L25;
        AudioRecord r2 = this.e;
        if (r2 != null) goto L27;
    L23:
        this.c = true;
        return;
    L27:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        n(r2);     // Catch: Throwable -> L14
        s(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L14
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        if (Result.isSuccess-impl(r4) == false) goto L19;
        Unit r5 = (Unit) r4;
        int r6 = c68.b.a;
        c68.b.d(this.b, "release => success");
    L19:
        Throwable r7 = Result.exceptionOrNull-impl(r4);
        if (r7 == null) goto L22;
        int r8 = c68.b.a;
        c68.b.c(this.b, "release => fail", r7);
        r(AudioRecordErrorEnum.RELEASE_ERROR);
    L22:
        Result.box-impl(r4);
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L7:
        r1 = false;
        goto L8
    }

    @Override // r58.c
    public final void start() {
        if (this.d != null) goto L6;
        r(AudioRecordErrorEnum.START_ERROR);
        return;
    L6:
        AudioRecord r1 = this.e;
        if (r1 == null) goto L21;
        boolean r3 = true;
        if (r1.getState() == 1) goto L12;
        r3 = false;
    L12:
        if (r3 == false) goto L21;
        int r0 = c68.b.a;
        c68.b.d(this.b, "start => success");
        AudioRecord r2 = this.e;
        if (r2 != null) goto L16;
    L19:
        s(AudioRecordState.STARTED);
        return;
    L16:
        if (g.d() == true) goto L18;
        o(r2);
        goto L19
    L18:
        o(r2);
        hna.a.b(r2.hashCode());
    L21:
        v58.a r4 = this.d;
        if (r4 == null) goto L48;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L36
        if (this.a != (-1)) goto L26;
        m(r4);     // Catch: Throwable -> L36
    L26:
        int r6 = c68.b.a;     // Catch: Throwable -> L36
        c68.b.d(this.b, "start => minBufferSize:" + this.a);     // Catch: Throwable -> L36
        this.e = new AudioRecord(r4.d, r4.a, r4.b, r4.c, this.a * ((Number) this.h.getValue()).intValue());     // Catch: Throwable -> L36
        s(AudioRecordState.INITIALIZED);     // Catch: Throwable -> L36
        AudioRecord r7 = this.e;     // Catch: Throwable -> L36
        if (r7 != null) goto L29;
        Unit r8 = null;
    L34:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L36
    L39:
        if (Result.isSuccess-impl(r9) == false) goto L41;
        Unit r10 = (Unit) r9;
        int r11 = c68.b.a;
        c68.b.d(this.b, "start => success");
        s(AudioRecordState.STARTED);
    L41:
        Throwable r12 = Result.exceptionOrNull-impl(r9);
        if (r12 == null) goto L44;
        int r13 = c68.b.a;
        c68.b.c(this.b, "start => fail", r12);
        r(AudioRecordErrorEnum.START_ERROR);
    L44:
        Result.box-impl(r9);
        return;
    L29:
        if (g.d() == true) goto L31;
        o(r7);     // Catch: Throwable -> L36
    L32:
        r8 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L31:
        o(r7);     // Catch: Throwable -> L36
        hna.a.b(r7.hashCode());     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    @Override // r58.c
    public final void stop() {
        AudioRecord r0 = this.e;
        if (r0 != null) goto L5;
    L28:
        r(AudioRecordErrorEnum.UNKNOWN_ERROR);
        return;
    L5:
        if (r0.getState() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L28;
        AudioRecord r2 = this.e;
        if (r2 == null) goto L32;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        if (g.d() == true) goto L15;
        p(r2);     // Catch: Throwable -> L18
    L16:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        if (Result.isSuccess-impl(r4) == false) goto L23;
        Unit r5 = (Unit) r4;
        int r6 = c68.b.a;
        c68.b.d(this.b, "stop => success");
        s(AudioRecordState.STOPPED);
    L23:
        Throwable r7 = Result.exceptionOrNull-impl(r4);
        if (r7 == null) goto L26;
        int r8 = c68.b.a;
        c68.b.c(this.b, "stop => fail", r7);
        r(AudioRecordErrorEnum.UNKNOWN_ERROR);
    L26:
        Result.box-impl(r4);
        return;
    L15:
        p(r2);     // Catch: Throwable -> L18
        hna.a.c(r2.hashCode());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L32:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.f;
    }

    public d(int r1) {
        this.a = r1;
        this.b = "AudioRecorder";
        this.f = AudioRecordState.UNINITIALIZED;
        this.g = LazyKt.lazy(new b());
        this.h = LazyKt.lazy(new c(this));
    }

    public static void n(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100403, "android/media/AudioRecord", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, true);
    }

    public static void o(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100400, "android/media/AudioRecord", "startRecording", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, false);
        return;
    L6:
        r12.startRecording();
        r8.a(100400, "android/media/AudioRecord", "startRecording", r12, r9, null, r10, true);
    }

    public static void p(AudioRecord r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100401, "android/media/AudioRecord", "stop", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, false);
        return;
    L6:
        r12.stop();
        r8.a(100401, "android/media/AudioRecord", "stop", r12, r9, null, r10, true);
    }

    @Override // r58.c
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    @Override // r58.c
    public final long d(long r6) {
        v58.a r2 = this.d;     // Catch: Throwable -> L12
        if (r2 != null) goto L7;
        return 0;
    L7:
        if (r2.b != 16) goto L9;
        int r3 = 1;
    L10:
        return (((long) CommandStatus.DORA_TRACE) * (r6 / ((long) (r2.c * r3)))) / ((long) r2.a);
    L9:
        r3 = 2;
    L12:
        th = move-exception;
        int r7 = c68.b.a;
        c68.b.b(this.b, "calculateAudioDuration msg=" + th.getMessage());
        return 0;
    }

    @Override // r58.c
    public final void h(v58.a r2) {
        Intrinsics.checkNotNullParameter(r2, "audioRecordConfig");
        this.d = r2;
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "onAudioDataReceived");
        int r0 = c() * ((Number) this.h.getValue()).intValue();
        if (r0 > 0) goto L6;
        int r15 = c68.b.a;
        c68.b.b(this.b, "audio recorder startLoop fail: size " + r0 + " is under zero");
        return;
    L6:
        byte[] r1 = new byte[r0];
        AudioTimestamp r2 = new AudioTimestamp();
        long r5 = 0;
    L8:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L76;
        if (this.c == true) goto L77;
        if (this.f == AudioRecordState.STARTED) goto L21;
        Thread.sleep(100);     // Catch: Exception -> L16 InterruptedException -> L18
    L33:
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L58;
        int r6 = Build.VERSION.SDK_INT;
        if (r6 < 23) goto L58;
        if (r6 >= 24) goto L65;
        Long r7 = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    L46:
        Intrinsics.checkNotNullParameter(r1, "buffer");
        AudioRecord r8 = this.e;
        int r9 = -1;
        if (r8 != null) goto L49;
    L59:
        long r10 = System.currentTimeMillis();
        int r11 = c68.b.a;
        c68.b.d(this.b, "readSize: " + r9);
        if (r9 <= 0) goto L63;
        r14.invoke(new r58.d(r9, Arrays.copyOf(r1, r9), r7), null);
    L63:
        r5 = r10;
        goto L8
    L49:
        if (r8.getState() != 0) goto L51;
        boolean r12 = true;
    L52:
        if (r12 == true) goto L59;
        AudioRecord r13 = this.e;
        if (r13 == null) goto L57;
        r9 = r13.read(r1, 0, r0, 1);
    L57:
        Intrinsics.checkNotNullParameter(r1, "data");
        goto L59
    L51:
        r12 = false;
        goto L52
    L65:
        AudioRecord r16 = this.e;     // Catch: Exception -> L43
        if (r16 == null) goto L41;
        r16.getTimestamp(r2, 1);     // Catch: Exception -> L43
    L41:
        r7 = Long.valueOf(r2.nanoTime);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        int r17 = c68.b.a;
        c68.b.c(this.b, "getTimestampException", e);
        r7 = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    L58:
        r9 = i(r1, r0);
        r7 = null;
    L18:
        e = move-exception;
        int r3 = c68.b.a;
        c68.b.c(this.b, "interruptException1.", e);
        return;
    L16:
        e = move-exception;
        int r19 = c68.b.a;
        c68.b.c(this.b, "1 on err. msg=" + e.getMessage(), e);
        goto L33
    L21:
        if (r5 <= 0) goto L33;
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L33;
        long r20 = q() - (System.currentTimeMillis() - r5);     // Catch: Exception -> L28 InterruptedException -> L30
        if (r20 <= 0) goto L33;
        Thread.sleep(r20);     // Catch: Exception -> L28 InterruptedException -> L30
    L30:
        e = move-exception;
        int r4 = c68.b.a;
        c68.b.c(this.b, "interruptException2", e);
        return;
    L28:
        e = move-exception;
        int r21 = c68.b.a;
        c68.b.c(this.b, "2 on err. msg=" + e.getMessage(), e);
        goto L33
    L77:
        return;
    }

    public final void m(v58.a r3) {
        this.a = AudioRecord.getMinBufferSize(r3.a, r3.b, r3.c);
        int r4 = c68.b.a;
        c68.b.d(this.b, "assignMinBufferSize => minBufferSize:" + this.a);
    }

    public final void r(AudioRecordErrorEnum r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        int r0 = c68.b.a;
        c68.b.a(this.b, "onFailed error:" + r4);
        s(AudioRecordState.STOPPED);
    }

    public final void s(AudioRecordState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        int r0 = c68.b.a;
        c68.b.d(this.b, "onStateChange state:" + r4);
        this.f = r4;
    }

    @Override // r58.c
    public final int i(byte[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "buffer");
        AudioRecord r0 = this.e;
        int r1 = -1;
        if (r0 != null) goto L5;
    L14:
        return r1;
    L5:
        if (r0.getState() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L14;
        AudioRecord r3 = this.e;
        if (r3 == null) goto L13;
        r1 = r3.read(r4, 0, r5);
    L13:
        Intrinsics.checkNotNullParameter(r4, "data");
        goto L14
    L7:
        r2 = false;
        goto L8
    }
}
