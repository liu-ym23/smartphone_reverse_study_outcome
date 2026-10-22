package com.larus.bmhome.chat.deepsearch.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchContentComponent$showDeepSearchMessageByMsgId$1", f = "DeepSearchContentComponent.kt", i = {}, l = {121, 122}, m = "invokeSuspend", n = {}, s = {})
final class DeepSearchContentComponent$showDeepSearchMessageByMsgId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msgId;
    int label;
    final /* synthetic */ DeepSearchContentComponent this$0;

    public DeepSearchContentComponent$showDeepSearchMessageByMsgId$1(String r1, DeepSearchContentComponent r2, Continuation<? super DeepSearchContentComponent$showDeepSearchMessageByMsgId$1> r3) {
        this.$msgId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DeepSearchContentComponent$showDeepSearchMessageByMsgId$1(this.$msgId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        Message r8 = (Message) r7;
        if (r8 == null) goto L19;
        DeepSearchContentComponent r2 = this.this$0;
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        DeepSearchContentComponent$showDeepSearchMessageByMsgId$1$1$1 r4 = new DeepSearchContentComponent$showDeepSearchMessageByMsgId$1$1$1(r8, r2, null);
        this.label = 2;
        if (BuildersKt.withContext(r3, r4, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        IChatRepoService r9 = zh8.a.a;
        IChatRepoService r10 = zh8.a.a;
        String r5 = this.$msgId;
        this.label = 1;
        r7 = r10.E1(r5, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
