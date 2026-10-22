package com.larus.bmhome.chat.component.share;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$registerSelectStatusChanged$1", f = "ChatShareBottomComponent.kt", i = {}, l = {693}, m = "invokeSuspend", n = {}, s = {})
public final class ChatShareBottomComponent$registerSelectStatusChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<rr8.a> $collector;
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    public ChatShareBottomComponent$registerSelectStatusChanged$1(ChatShareBottomComponent r1, FlowCollector<? super rr8.a> r2, Continuation<? super ChatShareBottomComponent$registerSelectStatusChanged$1> r3) {
        this.this$0 = r1;
        this.$collector = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatShareBottomComponent$registerSelectStatusChanged$1(this.this$0, this.$collector, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r4);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ChatShareBottomComponent r5 = this.this$0;
        int r2 = ChatShareBottomComponent.R;
        kotlinx.coroutines.flow.i1<rr8.a> r6 = r5.e4().getShareModeFlow();
        FlowCollector<rr8.a> r3 = this.$collector;
        this.label = 1;
        if (r6.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
