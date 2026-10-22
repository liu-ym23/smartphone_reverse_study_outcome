package com.obric.audio.continuous_talk;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.IObricBackTraceLogService;
import com.obric.assistant.t1;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricBackTraceLogServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricBackTraceLogService;", "<init>", "()V", "setHistoryLengthMs", "", "historyLengthMs", "", "createTracer", "Lcom/obric/assistant/spi/audio/IObricBackTraceTracer;", "reportBackTraceRecorderConfig", "scene", "", "", "reportAudioRecorderStartResult", "success", "", "errorReason", "reportAudioRecorderStart", "reportBacktraceDuration", "payloadJson", "reportBacktraceRecordError", "Companion", "TracerImpl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ObricBackTraceLogServiceImpl implements IObricBackTraceLogService {
    public static final a a = null;
    public static int b;

    public static final class a {
        public a() {
        }

        public static void a(String r3, JSONObject r4) {
            by7.a r0 = new by7.a(r3);
            TrackParams r1 = new TrackParams().merge(r4);
            r0.a.merge(r1);
            r0.b();
            if (t1.a.o0() == false) goto L6;
            g.a.monitorEventForSlardar(r3, r4, null, null);
            return;
        }
    }

    public static final class b implements hga.b {
        public volatile long a;
        public volatile long b;
        public volatile long c;
        public volatile long d;
        public volatile long e;
        public volatile long f;
        public volatile long g;
        public volatile long h;
        public volatile String i;
        public final AtomicBoolean j;

        public static final class a {
        }

        static {
        }

        @Override // hga.b
        public final void h() {
        }

        @Override // hga.b
        public final void d() {
            if (this.e < 0) goto L5;
            return;
        L5:
            this.e = System.currentTimeMillis();
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] aecInit=" + this.e);
        }

        @Override // hga.b
        public final void e() {
            if (this.d < 0) goto L5;
            return;
        L5:
            this.d = System.currentTimeMillis();
        }

        @Override // hga.b
        public final void g() {
            if (this.b >= 0) goto L6;
            this.b = System.currentTimeMillis();
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] aecFirstFrame=" + this.b);
            return;
        }

        public final void j() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.h = 0;
            this.j.set(false);
            ObricBackTraceLogServiceImpl.a.getClass();
            ObricBackTraceLogServiceImpl.b = 0;
        }

        public b() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.i = "";
            this.j = new AtomicBoolean(false);
        }

        @Override // hga.b
        public final void a(int r8) {
            if (r8 > 0) goto L4;
            return;
        L4:
            if (this.c < 0) goto L7;
            return;
        L7:
            if (this.g > 0) goto L10;
            this.c = System.currentTimeMillis();
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] recordReadEnd(no-history)=" + this.c);
            return;
        L10:
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] recordReadEnd=" + this.c + ", accumulatedBytes=" + this.h + ", readSize=" + r8);
            if (this.h < this.g) goto L15;
            this.c = System.currentTimeMillis();
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault())), null, null, new TracerImpl.scheduleDelayedReport.1(this, null), 3, null);
            return;
        }

        @Override // hga.b
        public final void f(String r6) {
            Intrinsics.checkNotNullParameter(r6, "scene");
            ObricBackTraceLogServiceImpl.a.getClass();
            Intrinsics.checkNotNullParameter(r6, "scene");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
            JSONObject r3 = new JSONObject();     // Catch: Throwable -> L5
            r3.put("scene", r6);     // Catch: Throwable -> L5
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] report scene=" + r6 + ", category=" + r3);     // Catch: Throwable -> L5
            a.a("backtrace_recorder_start_count", r3);     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // hga.b
        public final void i(int r7) {
            if (r7 > 0) goto L5;
            return;
        L5:
            if (this.a >= 0) goto L8;
            this.a = System.currentTimeMillis();
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] recordReadStart=" + this.a + ", readSize=" + r7);
        L8:
            if (this.c >= 0) goto L11;
            this.h += (long) r7;
            return;
        }

        @Override // hga.b
        public final void b(String r7, boolean r8, String r9) {
            Intrinsics.checkNotNullParameter(r7, "scene");
            int r1 = 1;
            if (r9 != null) goto L5;
        L7:
            boolean r3 = false;
        L9:
            if (r3 == false) goto L15;
            ObricBackTraceLogServiceImpl.a.getClass();
            Intrinsics.checkNotNullParameter(r7, "scene");
            Intrinsics.checkNotNullParameter(r9, "errorReason");
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
            JSONObject r11 = new JSONObject();     // Catch: Throwable -> L13
            r11.put("scene", r7);     // Catch: Throwable -> L13
            r11.put("error_reason", r9);     // Catch: Throwable -> L13
            a.a("backtrace_recorder_error", r11);     // Catch: Throwable -> L13
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L15:
            ObricBackTraceLogServiceImpl.a.getClass();
            Intrinsics.checkNotNullParameter(r7, "scene");
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L27
            JSONObject r6 = new JSONObject();     // Catch: Throwable -> L27
            r6.put("scene", r7);     // Catch: Throwable -> L27
            if (r8 == true) goto L20;
            r1 = 0;
        L20:
            r6.put("success", r1);     // Catch: Throwable -> L27
            if (r8 == true) goto L25;
            if (r9 != null) goto L24;
            r9 = "";
        L24:
            r6.put("error_reason", r9);     // Catch: Throwable -> L27
        L25:
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] reportAudioRecorderStartResult scene=" + r7 + ", category=" + r6);     // Catch: Throwable -> L27
            a.a("backtrace_recorder_start_result", r6);     // Catch: Throwable -> L27
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
            return;
        L27:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L5:
            if (StringsKt.contains$default(r9, "startLoop", false, 2, null) != true) goto L7;
            r3 = true;
            goto L9
        }

        @Override // hga.b
        public final void c(long r6, int r8, int r9, int r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "scene");
            this.i = r11;
            ObricBackTraceLogServiceImpl.a.getClass();
            if (ObricBackTraceLogServiceImpl.b > 0) goto L5;
        L9:
            long r7 = RangesKt.coerceAtLeast(r6, 0);
        L10:
            j();
            this.f = r7;
            long r1 = RangesKt.coerceAtLeast(r9, 1);
            this.g = (((((long) RangesKt.coerceAtLeast(r8, 1)) * r7) * r1) * RangesKt.coerceAtLeast(r10, 1)) / 1000;
            FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] reset scene=" + r11 + ", historyLengthMs=" + r7 + ", expectedHistoryBytes=" + this.g);
            return;
        L5:
            if (Intrinsics.areEqual(r11, "realtime_call") == false) goto L7;
        L8:
            r7 = ObricBackTraceLogServiceImpl.b;
            goto L10
        L7:
            if (Intrinsics.areEqual(r11, "obric_continuous_talk") == false) goto L9;
            goto L8
        }
    }

    public ObricBackTraceLogServiceImpl() {
    }

    static {
        a = new a();
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final hga.b c() {
        return new b();
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void b(int r1) {
        b = r1;
    }

    @Override // com.obric.assistant.spi.audio.IObricBackTraceLogService
    public final void a(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        a.getClass();
        Intrinsics.checkNotNullParameter(r4, "scene");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L5
        r3.put("scene", r4);     // Catch: Throwable -> L5
        r3.put("history_length_ms", r5);     // Catch: Throwable -> L5
        FLogger.a.i("IObricBackTraceLogService", "[backtrace_trace] report config scene=" + r4 + ", category=" + r3);     // Catch: Throwable -> L5
        a.a("backtrace_recorder_config", r3);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
