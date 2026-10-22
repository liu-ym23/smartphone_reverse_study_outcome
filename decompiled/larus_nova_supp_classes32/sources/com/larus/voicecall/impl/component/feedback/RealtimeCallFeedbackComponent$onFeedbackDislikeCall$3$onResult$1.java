package com.larus.voicecall.impl.component.feedback;

import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.component.feedback.api.RealtimeCallFeedbackApi;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.feedback.RealtimeCallFeedbackComponent$onFeedbackDislikeCall$3$onResult$1", f = "RealtimeCallFeedbackComponent.kt", i = {0}, l = {448, 449}, m = "invokeSuspend", n = {"feedbackDetailType"}, s = {"L$0"})
public final class RealtimeCallFeedbackComponent$onFeedbackDislikeCall$3$onResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $data;
    Object L$0;
    int label;
    final /* synthetic */ RealtimeCallFeedbackComponent this$0;

    public RealtimeCallFeedbackComponent$onFeedbackDislikeCall$3$onResult$1(b r1, RealtimeCallFeedbackComponent r2, Continuation<? super RealtimeCallFeedbackComponent$onFeedbackDislikeCall$3$onResult$1> r3) {
        this.$data = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeCallFeedbackComponent$onFeedbackDislikeCall$3$onResult$1(this.$data, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
        Object r1 = r11;
    L25:
        dm9.a.a r2 = (dm9.a) r1;
        if ((r2 instanceof dm9.a.a) == false) goto L29;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onFeedbackDislikeCall: dislikeCall error, code = ");
        dm9.a.a r5 = r2;
        r4.append(r5.a);
        r4.append(", msg = ");
        r4.append(r5.b);
        r3.i("RealtimeCallFeedbackComponent", r4.toString());
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        List r6 = (List) this.L$0;
        ResultKt.throwOnFailure(r11);
        List r7 = r6;
    L10:
        List r8 = r7;
        RealtimeCallFeedbackComponent r10 = this.this$0;
        int r12 = RealtimeCallFeedbackComponent.u;
        String r13 = r10.m3().e;
        String r14 = this.$data.c;
        Map<String, String> r15 = this.this$0.p3().b();
        this.L$0 = null;
        this.label = 2;
        RealtimeCallFeedbackApi.a r16 = RealtimeCallFeedbackApi.a;
        RealtimeCallFeedbackComponent$dislikeCall$2 r17 = new RealtimeCallFeedbackComponent$dislikeCall$2(r10, r8, r14, r15, null);
        r16.getClass();
        FlowHttpConnection r18 = FlowHttpConnection.a;
        r1 = FlowHttpConnection.g("Audio", RealtimeCallFeedbackApi.class, r17, false, null, null, null, this, 248);
        if (r1 != r9) goto L25;
        return r9;
    L11:
        ResultKt.throwOnFailure(r11);
        ArrayList r19 = new ArrayList();
        List<FeedbackMeta> r20 = this.$data.b;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r22 = r20.iterator();
    L13:
        if (r22.hasNext() == false) goto L15;
        r21.add(Boxing.boxInt(((FeedbackMeta) r22.next()).a()));
        goto L13
    L15:
        Iterator r23 = r21.iterator();
    L17:
        if (r23.hasNext() == false) goto L19;
        r19.add(Boxing.boxInt(((Number) r23.next()).intValue()));
        goto L17
    L19:
        RealtimeCallFeedbackComponent r24 = this.this$0;
        int r25 = RealtimeCallFeedbackComponent.u;
        c r26 = r24.p3();
        String r27 = ((h88.b) r24.z3()).b;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r27, "taskId");
        r26.e = r27;
        RealtimeCallFeedbackComponent r28 = this.this$0;
        this.L$0 = r19;
        this.label = 1;
        r7 = r19;
        if (RealtimeCallFeedbackComponent.h3(r28, this) != r9) goto L10;
        return r9;
    }
}
