package p58;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.bytedance.keva.Keva;
import com.larus.audio.audiov3.audio.record.AudioRecordErrorEnum;
import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.audio.call.dora.CommandStatus;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fna.g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements r58.c {
    public int a;
    public final int b;
    public final Object c;
    public volatile boolean d;
    public boolean e;
    public Function2<? super Boolean, ? super String, Unit> f;
    public boolean g;
    public AudioRecord h;
    public AudioRecordState i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final AudioManager o;
    public final int p;
    public volatile long q;
    public volatile long r;
    public volatile String s;
    public volatile Function2<? super String, ? super Long, Unit> t;

    public static final class a {
    }

    static {
    }

    @Override // r58.c
    public final void e(Function0<Unit> r1) {
    }

    @Override // r58.c
    public final void h(v58.a r2) {
        Intrinsics.checkNotNullParameter(r2, "audioRecordConfig");
    }

    @Override // r58.c
    public final void j() {
        this.e = true;
    }

    @Override // r58.c
    public final int c() {
        int r0 = this.a;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        m();
        return this.a;
    }

    public final void m() {
        this.a = (((this.k / CommandStatus.DORA_TRACE) * this.j) * this.l) * 40;
        int r0 = c68.b.a;
        c68.b.d("BackTraceAudioRecorder", "assignMinBufferSize => minBufferSize:" + this.a);
    }

    @Override // r58.c
    public final void prepare() {
        if (this.d == false) goto L5;
    L67:
        int r0 = c68.b.a;
        c68.b.e("BackTraceAudioRecorder", "prepare ignored: releaseRequested=" + this.d + ", isReleased=" + this.g);
        return;
    L5:
        if (this.g == true) goto L67;
        Field r1 = AudioFormat.class.getDeclaredField("CHANNEL_IN_2POINT0POINT2");
        boolean r2 = true;
        r1.setAccessible(true);
        Object r3 = r1.get(null);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
        v58.a r4 = new v58.a(this.k, ((Integer) r3).intValue(), this.j, this.m);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L51
        if (this.a != (-1)) goto L11;
        m();     // Catch: Throwable -> L51
    L11:
        int r6 = c68.b.a;     // Catch: Throwable -> L51
        c68.b.d("BackTraceAudioRecorder", "start => minBufferSize:" + this.a);     // Catch: Throwable -> L51
        Object r7 = this.c;     // Catch: Throwable -> L51
        monitor-enter(r7);     // Catch: Throwable -> L51
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L48
        monitor-exit(r7);     // Catch: Throwable -> L51
        AudioRecord.Builder r9 = new AudioRecord.Builder();     // Catch: Throwable -> L51
        AudioRecord.Builder.class.getDeclaredMethod("setRequestBacktraceStream", new Class[]{Boolean.TYPE}).invoke(r9, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23 Throwable -> L51
    L25:
        AudioRecord r10 = r9.setAudioFormat(new AudioFormat.Builder().setEncoding(r4.c).setSampleRate(r4.a).setChannelMask(r4.b).build()).setAudioSource(r4.d).setBufferSizeInBytes(this.n).build();     // Catch: Throwable -> L51
        Object r11 = this.c;     // Catch: Throwable -> L51
        monitor-enter(r11);     // Catch: Throwable -> L51
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L28:
        if (this.d == false) goto L30;
    L33:
        if (r2 == true) goto L35;
        this.h = r10;     // Catch: Throwable -> L45
    L35:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L51
        if (r2 == true) goto L76;
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L54:
        if (Result.isSuccess-impl(r13) == false) goto L56;
        Unit r14 = (Unit) r13;
        c68.b.d("BackTraceAudioRecorder", "prepare => success");
        r(AudioRecordState.INITIALIZED);
    L56:
        Throwable r15 = Result.exceptionOrNull-impl(r13);
        if (r15 == null) goto L66;
        Object r16 = this.c;
        monitor-enter(r16);
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r16);
        c68.b.c("BackTraceAudioRecorder", "prepare => fail", r15);
        q(AudioRecordErrorEnum.PREPARE_ERROR);
        return;
    L63:
        th = move-exception;
        throw th;
    L66:
        return;
    L76:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L40
        n(r10);     // Catch: Throwable -> L40
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        r(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L51
        return;
    L40:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L51
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
        goto L42
    L30:
        if (this.g == true) goto L33;
        r2 = false;
        goto L33
    L21:
        e = move-exception;
        int r21 = c68.b.a;     // Catch: Throwable -> L51
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L51
    L23:
        e = move-exception;
        int r22 = c68.b.a;     // Catch: Throwable -> L51
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L51
    L19:
        e = move-exception;
        int r23 = c68.b.a;     // Catch: Throwable -> L51
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L51
        goto L25
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    }

    @Override // r58.c
    public final void release() {
        Object r0 = this.c;
        monitor-enter(r0);
        this.d = true;     // Catch: Throwable -> L28
        this.g = true;     // Catch: Throwable -> L28
        AudioRecord r1 = this.h;     // Catch: Throwable -> L28
        this.h = null;     // Catch: Throwable -> L28
        monitor-exit(r0);
        if (r1 != null) goto L9;
    L26:
        r(AudioRecordState.UNINITIALIZED);
        return;
    L9:
        if (r1.getState() == 0) goto L26;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        n(r1);     // Catch: Throwable -> L13
        r(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L13
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L16:
        if (Result.isSuccess-impl(r3) == false) goto L22;
        Unit r4 = (Unit) r3;
        Lazy r5 = r58.b.a;
        long r6 = System.currentTimeMillis();
        if (r6 <= 0) goto L21;
        ((Keva) r58.b.a.getValue()).storeLong("last_backtrace_recorder_release_time_ms", r6);
    L21:
        c68.b.d("BackTraceAudioRecorder", "release => success");
    L22:
        Throwable r7 = Result.exceptionOrNull-impl(r3);
        if (r7 == null) goto L35;
        c68.b.c("BackTraceAudioRecorder", "release => fail", r7);
        q(AudioRecordErrorEnum.RELEASE_ERROR);
        return;
    L35:
        return;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        throw th;
    }

    public final void s() {
        if (this.e == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        long r4 = 0;
        if (this.q <= 0) goto L8;
        long r2 = this.q;
    L9:
        boolean r8 = false;
        Unit r10 = null;
        if (this.r <= 0) goto L22;
        Long r1 = Long.valueOf(r0 - this.r);
        long r6 = r1.longValue();
        if (1 <= r6) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L20;
        r1 = null;
    L20:
        if (r1 == null) goto L22;
        r4 = r1.longValue();
        goto L22
    L14:
        if (r6 >= 5001) goto L16;
        r3 = true;
    L22:
        long r5 = r2 + r4;
        int r7 = c68.b.a;
        c68.b.d("BackTraceAudioRecorder", "setBackTraceTime, backTraceTimeMs: " + r2 + ", timeOfIPC: " + r4 + ", realBackTrace: " + r5);
        AudioManager r9 = this.o;
        if (r9 == null) goto L25;
        r9.setParameters("backtrace_history_length=" + r5);
    L25:
        String r11 = this.s;
        if (r11.length() <= 0) goto L28;
        r8 = true;
    L28:
        if (r8 == false) goto L39;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L34
        Function2<? super String, ? super Long, Unit> r13 = this.t;     // Catch: Throwable -> L34
        if (r13 == null) goto L32;
        r13.invoke(r11, Long.valueOf(r5));     // Catch: Throwable -> L34
        r10 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        Result.constructor-impl(r10);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L39:
        return;
    L8:
        r2 = 50;
        goto L9
    }

    @Override // r58.c
    public final void start() {
        if (this.d == false) goto L5;
    L104:
        int r0 = c68.b.a;
        c68.b.e("BackTraceAudioRecorder", "start ignored: releaseRequested=" + this.d + ", isReleased=" + this.g);
        q(AudioRecordErrorEnum.START_ERROR);
        Function2<? super Boolean, ? super String, Unit> r1 = this.f;
        if (r1 == null) goto L125;
        r1.invoke(Boolean.FALSE, "isReleased");
        return;
    L125:
        return;
    L5:
        if (this.g == true) goto L104;
        Object r2 = this.c;
        monitor-enter(r2);
        AudioRecord r3 = this.h;     // Catch: Throwable -> L101
        monitor-exit(r2);
        boolean r4 = true;
        if (r3 != null) goto L14;
    L26:
        Field r5 = AudioFormat.class.getDeclaredField("CHANNEL_IN_2POINT0POINT2");
        r5.setAccessible(true);
        Object r6 = r5.get(null);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Int");
        v58.a r7 = new v58.a(this.k, ((Integer) r6).intValue(), this.j, this.m);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L81
        if (this.a != (-1)) goto L30;
        m();     // Catch: Throwable -> L81
    L30:
        int r9 = c68.b.a;     // Catch: Throwable -> L81
        c68.b.d("BackTraceAudioRecorder", "start => minBufferSize:" + this.a);     // Catch: Throwable -> L81
        Object r10 = this.c;     // Catch: Throwable -> L81
        monitor-enter(r10);     // Catch: Throwable -> L81
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L78
        monitor-exit(r10);     // Catch: Throwable -> L81
        AudioRecord.Builder r12 = new AudioRecord.Builder();     // Catch: Throwable -> L81
        AudioRecord.Builder.class.getDeclaredMethod("setRequestBacktraceStream", new Class[]{Boolean.TYPE}).invoke(r12, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L40 IllegalAccessException -> L42 NoSuchMethodException -> L44 Throwable -> L81
        if (this.b == (-1)) goto L46;
        AudioRecord.Builder.class.getDeclaredMethod("setSessionId", new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(this.b)});     // Catch: InvocationTargetException -> L40 IllegalAccessException -> L42 NoSuchMethodException -> L44 Throwable -> L81
    L46:
        AudioRecord r13 = r12.setAudioFormat(new AudioFormat.Builder().setEncoding(r7.c).setSampleRate(r7.a).setChannelMask(r7.b).build()).setAudioSource(r7.d).setBufferSizeInBytes(this.n).build();     // Catch: Throwable -> L81
        Object r14 = this.c;     // Catch: Throwable -> L81
        monitor-enter(r14);     // Catch: Throwable -> L81
    L75:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L49:
        if (this.d == false) goto L51;
    L54:
        if (r4 == true) goto L56;
        this.h = r13;     // Catch: Throwable -> L75
    L56:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L75
        monitor-exit(r14);     // Catch: Throwable -> L81
        if (r4 == true) goto L117;
        c68.b.d("BackTraceAudioRecorder", "start => set sessionId: " + this.b + ", new record sessionId: " + r13.getAudioSessionId());     // Catch: Throwable -> L81
        r(AudioRecordState.INITIALIZED);     // Catch: Throwable -> L81
        if (this.b != (-1)) goto L71;
        s();     // Catch: Throwable -> L81
    L71:
        if (g.d() == true) goto L73;
        o(r13);     // Catch: Throwable -> L81
    L74:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L84:
        if (Result.isSuccess-impl(r16) == false) goto L88;
        Unit r17 = (Unit) r16;
        c68.b.d("BackTraceAudioRecorder", "start => success");
        r(AudioRecordState.STARTED);
        Function2<? super Boolean, ? super String, Unit> r19 = this.f;
        if (r19 == null) goto L88;
        r19.invoke(Boolean.TRUE, "");
    L88:
        Throwable r20 = Result.exceptionOrNull-impl(r16);
        if (r20 == null) goto L100;
        Object r21 = this.c;
        monitor-enter(r21);
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L97
        monitor-exit(r21);
        c68.b.c("BackTraceAudioRecorder", "start => fail", r20);
        q(AudioRecordErrorEnum.START_ERROR);
        Function2<? super Boolean, ? super String, Unit> r23 = this.f;
        if (r23 == null) goto L123;
        r23.invoke(Boolean.FALSE, "start fail");
        return;
    L123:
        return;
    L97:
        th = move-exception;
        throw th;
    L100:
        return;
    L73:
        o(r13);     // Catch: Throwable -> L81
        hna.a.b(r13.hashCode());     // Catch: Throwable -> L81
        goto L74
    L117:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L61
        n(r13);     // Catch: Throwable -> L61
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        r(AudioRecordState.UNINITIALIZED);     // Catch: Throwable -> L81
        Function2<? super Boolean, ? super String, Unit> r25 = this.f;     // Catch: Throwable -> L81
        if (r25 == null) goto L122;
        r25.invoke(Boolean.FALSE, "releaseImmediately");     // Catch: Throwable -> L81
        return;
    L122:
        return;
    L61:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L81
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
        goto L63
    L51:
        if (this.g == true) goto L54;
        r4 = false;
    L40:
        e = move-exception;
        int r27 = c68.b.a;     // Catch: Throwable -> L81
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L81
    L42:
        e = move-exception;
        int r29 = c68.b.a;     // Catch: Throwable -> L81
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L81
    L44:
        e = move-exception;
        int r30 = c68.b.a;     // Catch: Throwable -> L81
        c68.b.e("BackTraceAudioRecorder", e.toString());     // Catch: Throwable -> L81
        goto L46
    L78:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L84
    L14:
        if (r3.getState() != 1) goto L26;
        c68.b.d("BackTraceAudioRecorder", "start => success");
        if (this.b != (-1)) goto L19;
        s();
    L19:
        if (g.d() == true) goto L21;
        o(r3);
    L22:
        r(AudioRecordState.STARTED);
        Function2<? super Boolean, ? super String, Unit> r32 = this.f;
        if (r32 == null) goto L121;
        r32.invoke(Boolean.TRUE, "");
        return;
    L121:
        return;
    L21:
        o(r3);
        hna.a.b(r3.hashCode());
    L101:
        th = move-exception;
        throw th;
    }

    @Override // r58.c
    public final void stop() {
        Object r0 = this.c;
        monitor-enter(r0);
        AudioRecord r1 = this.h;     // Catch: Throwable -> L27
        monitor-exit(r0);
        if (r1 != null) goto L8;
    L25:
        r(AudioRecordState.STOPPED);
        return;
    L8:
        if (r1.getState() == 0) goto L25;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        if (g.d() == true) goto L13;
        p(r1);     // Catch: Throwable -> L16
    L14:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.isSuccess-impl(r3) == false) goto L21;
        Unit r4 = (Unit) r3;
        c68.b.d("BackTraceAudioRecorder", "stop => success");
        r(AudioRecordState.STOPPED);
    L21:
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 == null) goto L34;
        c68.b.c("BackTraceAudioRecorder", "stop => fail", r5);
        q(AudioRecordErrorEnum.UNKNOWN_ERROR);
        return;
    L34:
        return;
    L13:
        p(r1);     // Catch: Throwable -> L16
        hna.a.c(r1.hashCode());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        th = move-exception;
        throw th;
    }

    @Override // r58.c
    public final AudioRecordState l() {
        return this.i;
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
        this.s = r2;
    }

    @Override // r58.c
    public final long d(long r3) {
        return ((r3 / ((long) (this.j * this.l))) * ((long) CommandStatus.DORA_TRACE)) / ((long) this.k);
    L4:
        th = move-exception;
        int r4 = c68.b.a;
        c68.b.b("BackTraceAudioRecorder", "calculateAudioDuration msg=" + th.getMessage());
        return 0;
    }

    @Override // r58.c
    public final void f(Function2<? super String, ? super Long, Unit> r1) {
        this.t = r1;
    }

    @Override // r58.c
    public final void g(Function2<? super Boolean, ? super String, Unit> r4) {
        x58.a r0 = h.a;
        m58.b r1 = h.k;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        if (r2 == false) goto L10;
        this.f = r4;
        return;
    L10:
        return;
    L5:
        if (r1.a() != true) goto L7;
        r2 = true;
        goto L7
    }

    @Override // r58.c
    public final void k(Function2<? super r58.d, ? super byte[], Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onAudioDataReceived");
        int r0 = c() * this.p;
        if (r0 > 0) goto L8;
        int r11 = c68.b.a;
        c68.b.b("BackTraceAudioRecorder", "audio recorder startLoop fail: size " + r0 + " is under zero");
        Function2<? super Boolean, ? super String, Unit> r12 = this.f;
        if (r12 == null) goto L42;
        r12.invoke(Boolean.FALSE, "startLoop fail: size " + r0 + " is under zero");
        return;
    L42:
        return;
    L8:
        byte[] r2 = new byte[r0];
    L10:
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L43;
        if (this.g == true) goto L44;
        if (this.i != AudioRecordState.STARTED) goto L34;
    L22:
        int r3 = i(r2, r0);
        int r4 = c68.b.a;
        c68.b.d("BackTraceAudioRecorder", "readSize: " + r3);
        if (r3 < 0) goto L25;
    L30:
        if (r3 <= 0) goto L10;
        r10.invoke(new r58.d(r3, Arrays.copyOf(r2, r3), null), null);
        goto L10
    L25:
        if (this.i != AudioRecordState.STARTED) goto L30;
        Function2<? super Boolean, ? super String, Unit> r5 = this.f;
        if (r5 == null) goto L29;
        r5.invoke(Boolean.FALSE, "startLoop:readSize < 0， " + r3);
    L29:
        this.f = null;
        goto L30
    L34:
        Thread.sleep(100);     // Catch: Exception -> L18 InterruptedException -> L20
    L20:
        e = move-exception;
        int r1 = c68.b.a;
        c68.b.c("BackTraceAudioRecorder", "interruptException1.", e);
        return;
    L18:
        e = move-exception;
        int r6 = c68.b.a;
        c68.b.c("BackTraceAudioRecorder", "1 on err. msg=" + e.getMessage(), e);
        goto L22
    L44:
        return;
    }

    public final void q(AudioRecordErrorEnum r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        int r0 = c68.b.a;
        c68.b.d("BackTraceAudioRecorder", "onFailed error:" + r3);
        r(AudioRecordState.STOPPED);
    }

    public final void r(AudioRecordState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        int r0 = c68.b.a;
        c68.b.d("BackTraceAudioRecorder", "onStateChange state:" + r3);
        this.i = r3;
    }

    @Override // r58.c
    public final void b(long r3, long r5) {
        this.q = r3;
        this.r = r5;
        int r0 = c68.b.a;
        c68.b.d("BackTraceAudioRecorder", "setBackTraceParams historyLengthMs: " + r3 + ", wakeupTime: " + r5 + ", sessionId: " + this.b);
    }

    @Override // r58.c
    public final int i(byte[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "buffer");
        AudioRecord r0 = this.h;
        int r1 = -1;
        if (r0 != null) goto L5;
    L14:
        return r1;
    L5:
        if (r0.getState() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L14;
        AudioRecord r3 = this.h;
        if (r3 == null) goto L13;
        r1 = r3.read(r4, 0, r5);
    L13:
        Intrinsics.checkNotNullParameter(r4, "data");
        goto L14
    L7:
        r2 = false;
        goto L8
    }

    public e(Context r2, int r3, int r4) {
        this.a = r3;
        this.b = r4;
        this.c = new Object();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(new Date()));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r6) == null) goto L11;
        r6 = String.valueOf(System.currentTimeMillis());
    L11:
        String r7 = (String) r6;
        this.i = AudioRecordState.UNINITIALIZED;
        this.j = 2;
        this.k = 16000;
        this.l = 4;
        this.m = 6;
        this.n = 640000;
        AudioManager r8 = null;
        if (r2 == null) goto L16;
        Context r9 = r2.getApplicationContext();
        if (r9 == null) goto L16;
        Object r10 = r9.getSystemService("audio");
    L18:
        if ((r10 instanceof AudioManager) == false) goto L20;
        r8 = (AudioManager) r10;
    L20:
        this.o = r8;
        this.p = 4;
        this.q = 50;
        this.s = "";
        return;
    L16:
        r10 = null;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
