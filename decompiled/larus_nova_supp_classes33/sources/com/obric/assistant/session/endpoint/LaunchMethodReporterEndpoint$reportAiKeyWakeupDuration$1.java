package com.obric.assistant.session.endpoint;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.reporter.IObricReporter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.endpoint.LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1", f = "LaunchMethodReporterEndpoint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $duration;
    final /* synthetic */ Integer $systemKeyToWakeupDuration;
    final /* synthetic */ long $wakeupTimeMillis;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LaunchMethodReporterEndpoint this$0;

    public LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1(int r1, Integer r2, LaunchMethodReporterEndpoint r3, long r4, Continuation<? super LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1> r6) {
        this.$duration = r1;
        this.$systemKeyToWakeupDuration = r2;
        this.this$0 = r3;
        this.$wakeupTimeMillis = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1 r7 = new LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1(this.$duration, this.$systemKeyToWakeupDuration, this.this$0, this.$wakeupTimeMillis, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r18);
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        int r3 = this.$duration;
        Number r4 = this.$systemKeyToWakeupDuration;
        LaunchMethodReporterEndpoint r5 = this.this$0;
        long r6 = this.$wakeupTimeMillis;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L51
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L51
        r8.put("duration", r3);     // Catch: Throwable -> L51
        if (r4 == null) goto L8;
        r8.put("system_key_to_wakeup_duration", r4.intValue());     // Catch: Throwable -> L51
    L8:
        r5.getClass();     // Catch: Throwable -> L51
        r8.put("wakeup_from", bga.j.a());     // Catch: Throwable -> L51
        r8.put(WindowEvent.Params.LAUNCH_METHOD, r5.a.get());     // Catch: Throwable -> L51
        IObricReporter.a.getClass();     // Catch: Throwable -> L51
        IObricReporter r9 = IObricReporter.a.a();     // Catch: Throwable -> L51
        int r10 = -1;
        if (r9 == null) goto L11;
        int r11 = r9.m();     // Catch: Throwable -> L51
    L12:
        r8.put("launch_process_type", r11);     // Catch: Throwable -> L51
        if (r11 != 0) goto L37;
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L51
        Long r13 = null;
        if (r12 == null) goto L19;
        r12.r();     // Catch: Throwable -> L51
        com.larus.platform.api.l r14 = mc9.a.a.f();     // Catch: Throwable -> L51
    L20:
        if (r14 == null) goto L29;
        Long r15 = r14.a;     // Catch: Throwable -> L51
        if (r15 == null) goto L29;
        if (r15.longValue() <= 0) goto L26;
        boolean r16 = true;
    L27:
        if (r16 == false) goto L29;
        r13 = r15;
        goto L29
    L26:
        r16 = false;
    L29:
        if (r14 == null) goto L37;
        if (r13 == null) goto L37;
        long r17 = r14.d;     // Catch: Throwable -> L51
        if (r17 < r13.longValue()) goto L35;
        r8.put("app_init_duration", r17 - r13.longValue());     // Catch: Throwable -> L51
    L35:
        if (r6 < r13.longValue()) goto L37;
        long r19 = r6 - r13.longValue();     // Catch: Throwable -> L51
        r8.put("app_attach_to_wakeup_duration", r19);     // Catch: Throwable -> L51
    L39:
        if (r4 != null) goto L41;
        r4 = Boxing.boxLong(r19);     // Catch: Throwable -> L51
    L41:
        r8.put("ai_key_wakeup_launch_duration", r4);     // Catch: Throwable -> L51
        if (r9 == null) goto L44;
        r10 = r9.q();     // Catch: Throwable -> L51
    L44:
        r8.put("process_adj", r10);     // Catch: Throwable -> L51
        if (r9 == null) goto L48;
        String r20 = r9.j();     // Catch: Throwable -> L51
        if (r20 == null) goto L48;
    L49:
        r8.put("keep_alive_level_mode", r20);     // Catch: Throwable -> L51
        TrackParams r21 = new TrackParams().merge(r8);     // Catch: Throwable -> L51
        by7.a r22 = new by7.a("ai_key_wakeup_duration");     // Catch: Throwable -> L51
        r22.a.merge(r21);     // Catch: Throwable -> L51
        r22.b();     // Catch: Throwable -> L51
        FLogger.a.i("AiIsland-SessionUtils", "reportAiKeyWakeupDuration duration " + r3 + ", payload " + r8);     // Catch: Throwable -> L51
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L54:
        return Unit.INSTANCE;
    L48:
        r20 = "";
        goto L49
    L19:
        r14 = null;
    L37:
        r19 = -1;
        goto L39
    L11:
        r11 = -1;
    L51:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
