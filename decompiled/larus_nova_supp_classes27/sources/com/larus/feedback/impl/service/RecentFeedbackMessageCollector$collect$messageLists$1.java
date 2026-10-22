package com.larus.feedback.impl.service;

import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/bean/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.feedback.impl.service.RecentFeedbackMessageCollector$collect$messageLists$1", f = "RecentFeedbackMessageCollector.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class RecentFeedbackMessageCollector$collect$messageLists$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends List<? extends Message>>>, Object> {
    final /* synthetic */ List<e> $conversations;
    private /* synthetic */ Object L$0;
    int label;

    public RecentFeedbackMessageCollector$collect$messageLists$1(List<e> r1, Continuation<? super RecentFeedbackMessageCollector$collect$messageLists$1> r2) {
        this.$conversations = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RecentFeedbackMessageCollector$collect$messageLists$1 r0 = new RecentFeedbackMessageCollector$collect$messageLists$1(this.$conversations, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends List<Message>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L15:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        List<e> r2 = this.$conversations;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r9.add(BuildersKt.async$default(r12, null, null, new RecentFeedbackMessageCollector$collect$messageLists$1$1$1((e) r3.next(), null), 3, null));
        goto L10
    L12:
        this.label = 1;
        r11 = AwaitKt.a(r9, this);
        if (r11 != r0) goto L15;
        return r0;
    }
}
