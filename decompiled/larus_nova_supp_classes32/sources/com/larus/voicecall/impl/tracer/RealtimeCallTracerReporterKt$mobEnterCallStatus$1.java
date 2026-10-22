package com.larus.voicecall.impl.tracer;

import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.bean.bot.SceneModel;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.performance.IObricMemoryReportSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
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
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracerReporterKt$mobEnterCallStatus$1", f = "RealtimeCallTracerReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallTracerReporterKt$mobEnterCallStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ boolean $isV2;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ long $pseudoDuration;
    final /* synthetic */ IRealtimeCallTracer.EnterCallSessionStatus $sessionStatus;
    final /* synthetic */ RealtimeCallTracer $this_mobEnterCallStatus;
    int label;

    public RealtimeCallTracerReporterKt$mobEnterCallStatus$1(RealtimeCallParam r1, IRealtimeCallTracer.EnterCallSessionStatus r2, RealtimeCallTracer r3, long r4, long r6, boolean r8, Continuation<? super RealtimeCallTracerReporterKt$mobEnterCallStatus$1> r9) {
        this.$params = r1;
        this.$sessionStatus = r2;
        this.$this_mobEnterCallStatus = r3;
        this.$duration = r4;
        this.$pseudoDuration = r6;
        this.$isV2 = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new RealtimeCallTracerReporterKt$mobEnterCallStatus$1(this.$params, this.$sessionStatus, this.$this_mobEnterCallStatus, this.$duration, this.$pseudoDuration, this.$isV2, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r33) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L63;
        ResultKt.throwOnFailure(r33);
        RealtimeCallParam r1 = this.$params;
        String r3 = r1.o.h;
        String r4 = r1.e;
        String r5 = r1.l.c;
        int r2 = this.$sessionStatus.getValue();
        RealtimeCallParam r6 = this.$params;
        String r15 = r6.w;
        RealtimeCallParam.p r7 = r6.o;
        String r11 = r7.f;
        String r12 = r7.d;
        String r13 = r7.g;
        RealtimeCallParam.k r8 = r6.p;
        String r9 = r8.i;
        String r10 = r8.d;
        RealtimeCallTracer r14 = this.$this_mobEnterCallStatus;
        RealtimeCallParam r16 = (RealtimeCallParam) r14.b.invoke();
        JSONObject r17 = new JSONObject();
        RealtimeCallTracer.C0(r16, r17);
        r14.w0(r17);
        RealtimeCallTracer r18 = this.$this_mobEnterCallStatus;
        RealtimeCallParam r19 = this.$params;
        r18.v0(r17);
        RealtimeCallParam.c r20 = r19.p.o;
        if (r20 == null) goto L7;
        String r21 = r20.a;
    L8:
        r17.put("action_bar_item_id", r21);
        RealtimeCallParam.c r22 = r19.p.o;
        if (r22 == null) goto L11;
        String r23 = r22.d;
    L12:
        r17.put("action_bar_key", r23);
        RealtimeCallTracerReporterKt.a(r17, r19.r);
        RealtimeCallParam r24 = this.$params;
        RealtimeCallParam.k r25 = r24.p;
        boolean r26 = r25.q;
        if (r26 == false) goto L15;
    L18:
        String r110 = "1";
    L20:
        if (r24.b == false) goto L22;
        String r111 = "1";
    L23:
        if (r26 == false) goto L25;
        String r27 = null;
    L26:
        String r28 = r25.g;
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r29 = RealtimeCallUtil.l;
        if (r29 == null) goto L31;
        SceneModel r30 = r29.a;
        if (r30 == null) goto L31;
        String r210 = r30.getKey();
    L32:
        a1.a(r3, r4, r5, NameKeys.UnloadStrategy_No_Strategy, "1", Boxing.boxInt(r2), r9, r10, r11, r12, r13, null, r15, r17, Boxing.boxLong(this.$duration), r110, r111, r27, r28, null, null, r210, Boxing.boxLong(this.$pseudoDuration), 101255048);
        if (this.$isV2 == false) goto L54;
        RealtimeCallParam r31 = this.$params;
        String r32 = r31.o.h;
        String r34 = r31.e;
        String r35 = r31.l.c;
        int r36 = this.$sessionStatus.getValue();
        RealtimeCallParam r37 = this.$params;
        RealtimeCallParam.p r38 = r37.o;
        String r112 = r38.f;
        String r113 = r38.d;
        String r114 = r38.g;
        String r39 = r37.p.i;
        JSONObject r115 = new JSONObject();
        RealtimeCallTracer r40 = this.$this_mobEnterCallStatus;
        RealtimeCallParam r41 = this.$params;
        r40.v0(r115);
        RealtimeCallTracer.C0((RealtimeCallParam) r40.b.invoke(), r115);
        if (r41.p.q == false) goto L37;
    L40:
        Object r42 = "1";
    L41:
        r115.put("is_continuous_speak", r42);
        if (r41.b == false) goto L44;
        Object r43 = "1";
    L45:
        r115.put("is_obric_continuous_talk", r43);
        r115.put("enter_method", r41.p.i);
        RealtimeCallParam.c r44 = r41.p.o;
        if (r44 == null) goto L48;
        String r45 = r44.a;
    L49:
        r115.put("action_bar_item_id", r45);
        RealtimeCallParam.c r46 = r41.p.o;
        if (r46 == null) goto L52;
        String r47 = r46.d;
    L53:
        r115.put("action_bar_key", r47);
        RealtimeCallTracerReporterKt.a(r115, r41.r);
        a1.b(r32, r34, r35, NameKeys.UnloadStrategy_No_Strategy, "1", Boxing.boxInt(r36), r39, r112, r113, r114, null, r115, Boxing.boxLong(this.$duration), null, Boxing.boxLong(this.$pseudoDuration), 690056);
        goto L54
    L52:
        r47 = null;
        goto L53
    L48:
        r45 = null;
        goto L49
    L44:
        r43 = "0";
        goto L45
    L37:
        if (r41.a == true) goto L40;
        r42 = "0";
    L54:
        IObricMemoryReportSPIService r48 = (IObricMemoryReportSPIService) ServiceManager.get().getService(IObricMemoryReportSPIService.class);
        if (r48 == null) goto L57;
        r48.a("realtime_call_".concat(u.a(this.$this_mobEnterCallStatus)), false);
    L57:
        IAudioDeviceMonitorReporter r49 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);
        if (r49 == null) goto L61;
        r49.a(AudioDeviceMonitorScenes.CONNECT);
    L61:
        return Unit.INSTANCE;
    L31:
        r210 = null;
        goto L32
    L25:
        r27 = r25.v;
        goto L26
    L22:
        r111 = "0";
        goto L23
    L15:
        if (r24.a == true) goto L18;
        r110 = "0";
        goto L20
    L11:
        r23 = null;
        goto L12
    L7:
        r21 = null;
        goto L8
    L63:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
