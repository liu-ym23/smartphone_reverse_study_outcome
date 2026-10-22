package com.larus.uaigc.chat.loading;

import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1$1$1", f = "CreationQueuingTaskViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
public final class CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $queuingKey;
    final /* synthetic */ CreationTask $task;
    int label;
    final /* synthetic */ CreationQueuingTaskViewModel this$0;

    public CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1$1$1(CreationQueuingTaskViewModel r1, Message r2, CreationTask r3, String r4, Continuation<? super CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1$1$1> r5) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$task = r3;
        this.$queuingKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1$1$1(this.this$0, this.$msg, this.$task, this.$queuingKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CreationQueuingTaskViewModel r2 = this.this$0;
        Message r10 = this.$msg;
        CreationTask r3 = this.$task;
        String r4 = this.$queuingKey;
        this.label = 1;
        int r5 = CreationQueuingTaskViewModel.g;
        if (r2.a(r10, r3, r4, true, 20, this) != r0) goto L12;
        return r0;
    }
}
