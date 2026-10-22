package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarConfResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.BotRepo$requireCustomActionBarConf$newRequest$1", f = "BotRepo.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
public final class BotRepo$requireCustomActionBarConf$newRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends com.larus.bmhome.actionbar.model.x0>>, Object> {
    final /* synthetic */ IBotRepoService$a $param;
    final /* synthetic */ boolean $useActionBarV2;
    int label;
    final /* synthetic */ BotRepo this$0;

    public BotRepo$requireCustomActionBarConf$newRequest$1(BotRepo r1, IBotRepoService$a r2, boolean r3, Continuation<? super BotRepo$requireCustomActionBarConf$newRequest$1> r4) {
        this.this$0 = r1;
        this.$param = r2;
        this.$useActionBarV2 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotRepo$requireCustomActionBarConf$newRequest$1(this.this$0, this.$param, this.$useActionBarV2, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<com.larus.bmhome.actionbar.model.x0>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        BotRepo r6 = this.this$0;
        IBotRepoService$a r2 = this.$param;
        boolean r3 = this.$useActionBarV2;
        this.label = 1;
        int r4 = BotRepo.g;
        if (r3 == false) goto L11;
        r6.getClass();
        r5 = BotRepo.a().e(r2, this);
    L12:
        if (r5 != r0) goto L14;
        return r0;
    L11:
        r6.getClass();
        r5 = BotRepo.a().f(r2, this);
        goto L12
    }
}
