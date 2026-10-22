package com.larus.voicecall.impl.component.feedback;

import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.component.feedback.api.RealtimeCallFeedbackApi;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.feedback.RealtimeCallFeedbackComponent$onFeedbackLikeCall$1", f = "RealtimeCallFeedbackComponent.kt", i = {}, l = {396, 397}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallFeedbackComponent$onFeedbackLikeCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallFeedbackComponent this$0;

    public RealtimeCallFeedbackComponent$onFeedbackLikeCall$1(RealtimeCallFeedbackComponent r1, Continuation<? super RealtimeCallFeedbackComponent$onFeedbackLikeCall$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallFeedbackComponent$onFeedbackLikeCall$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L16:
        dm9.a.a r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.a) == false) goto L20;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("[onFeedbackLikeCall]: likeCall error, callId = ");
        RealtimeCallFeedbackComponent r4 = this.this$0;
        int r5 = RealtimeCallFeedbackComponent.u;
        r3.append(r4.m3().e);
        r3.append(", code = ");
        dm9.a.a r15 = r14;
        r3.append(r15.a);
        r3.append(", msg = ");
        r3.append(r15.b);
        r2.i("RealtimeCallFeedbackComponent", r3.toString());
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L13:
        RealtimeCallFeedbackComponent r16 = this.this$0;
        int r6 = RealtimeCallFeedbackComponent.u;
        String r7 = r16.m3().e;
        Map<String, String> r8 = this.this$0.p3().b();
        this.label = 2;
        RealtimeCallFeedbackApi.a r9 = RealtimeCallFeedbackApi.a;
        RealtimeCallFeedbackComponent$likeCall$2 r10 = new RealtimeCallFeedbackComponent$likeCall$2(r16, r8, null);
        r9.getClass();
        FlowHttpConnection r17 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("Audio", RealtimeCallFeedbackApi.class, r10, false, null, null, null, this, 248);
        if (r13 != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r13);
        RealtimeCallFeedbackComponent r18 = this.this$0;
        int r11 = RealtimeCallFeedbackComponent.u;
        c r12 = r18.p3();
        String r19 = ((h88.b) r18.z3()).b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r19, "taskId");
        r12.e = r19;
        RealtimeCallFeedbackComponent r110 = this.this$0;
        this.label = 1;
        if (RealtimeCallFeedbackComponent.h3(r110, this) != r0) goto L13;
        return r0;
    }
}
