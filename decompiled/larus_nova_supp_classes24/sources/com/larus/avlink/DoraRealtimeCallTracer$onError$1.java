package com.larus.avlink;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.RealtimeCallParam;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tx9.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.DoraRealtimeCallTracer$onError$1", f = "DoraRealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraRealtimeCallTracer$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizScene;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ long $fromStatus;
    final /* synthetic */ Boolean $isSessionStarted;
    final /* synthetic */ boolean $isV2;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ int $subErrorCode;
    final /* synthetic */ String $subErrorMsg;
    final /* synthetic */ String $subExtraInfo;
    int label;
    final /* synthetic */ DoraRealtimeCallTracer this$0;

    public DoraRealtimeCallTracer$onError$1(RealtimeCallParam r1, DoraRealtimeCallTracer r2, int r3, String r4, int r5, String r6, String r7, long r8, boolean r10, Boolean r11, String r12, Continuation<? super DoraRealtimeCallTracer$onError$1> r13) {
        this.$params = r1;
        this.this$0 = r2;
        this.$errorCode = r3;
        this.$errorMsg = r4;
        this.$subErrorCode = r5;
        this.$subErrorMsg = r6;
        this.$subExtraInfo = r7;
        this.$fromStatus = r8;
        this.$isV2 = r10;
        this.$isSessionStarted = r11;
        this.$bizScene = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r17, Continuation<?> r19) {
        return new DoraRealtimeCallTracer$onError$1(this.$params, this.this$0, this.$errorCode, this.$errorMsg, this.$subErrorCode, this.$subErrorMsg, this.$subExtraInfo, this.$fromStatus, this.$isV2, this.$isSessionStarted, this.$bizScene, r19);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r38) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r38);
        RealtimeCallParam r1 = this.$params;
        String r3 = r1.o.h;
        String r4 = r1.e;
        DoraRealtimeCallTracer r2 = this.this$0;
        int r5 = DoraRealtimeCallTracer.u;
        String r6 = (String) r2.q.getValue();
        String r7 = this.$params.l.c;
        long r8 = this.$errorCode;
        String r17 = this.this$0.z0();
        RealtimeCallParam r9 = this.$params;
        RealtimeCallParam.d r10 = r9.l;
        String r15 = r10.a;
        String r14 = r10.p;
        long r12 = r10.h;
        long r32 = 1;
        if (r10.m == false) goto L7;
        long r19 = 1;
    L8:
        String r11 = r9.o.d;
        boolean r27 = com.larus.im.service.audio.y0.e(((RealtimeCallParam) this.this$0.a.invoke()).s);
        boolean r29 = Intrinsics.areEqual(((RealtimeCallParam) this.this$0.a.invoke()).k.o, "dora_si");
        int r210 = ((RealtimeCallParam) this.this$0.a.invoke()).s.getType();
        c3.d(r3, r4, r6, r7, Boxing.boxLong(r8), this.$errorMsg, Boxing.boxInt(this.$subErrorCode), this.$subErrorMsg, this.$subExtraInfo, Boxing.boxLong(this.$fromStatus), Boxing.boxLong(0), Boxing.boxLong(0), r14, Boxing.boxLong(r19), r17, r15, Boxing.boxLong(r12), r11, Boxing.boxInt(0), Boxing.boxInt(0), Boxing.boxInt(0), null, null, this.$params.k.t, Boxing.boxInt(r27 ? 1 : 0), Boxing.boxInt(r29 ? 1 : 0), Boxing.boxInt(r210), null, 817889281);
        if (this.$isV2 == false) goto L16;
        RealtimeCallParam r13 = this.$params;
        String r16 = r13.o.h;
        String r20 = r13.e;
        String r21 = r13.l.c;
        long r22 = this.$errorCode;
        String r110 = this.this$0.z0();
        RealtimeCallParam r23 = this.$params;
        RealtimeCallParam.d r24 = r23.l;
        String r111 = r24.a;
        String r112 = r24.p;
        long r113 = r24.h;
        if (r24.m == true) goto L14;
        r32 = 0;
    L14:
        c3.e(r16, r20, r21, Boxing.boxLong(r22), this.$errorMsg, Boxing.boxLong(this.$fromStatus), Boxing.boxLong(0), Boxing.boxLong(0), r112, Boxing.boxLong(r32), r110, r111, Boxing.boxLong(r113), r23.o.d, Boxing.boxInt(Intrinsics.areEqual(this.$isSessionStarted, Boxing.boxBoolean(true)) ? 1 : 0), this.$bizScene, null, Boxing.boxInt(Intrinsics.areEqual(((RealtimeCallParam) this.this$0.a.invoke()).k.o, "dora_si") ? 1 : 0), 7569409);
    L16:
        return Unit.INSTANCE;
    L7:
        r19 = 0;
        goto L8
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
