package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import java.math.BigDecimal;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupConversationName$1$2$1", f = "CommonSettingFragment.kt", i = {}, l = {4427}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupConversationName$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ub8.e $result;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupConversationName$1$2$1(CommonSettingFragment r1, ub8.e r2, Continuation<? super CommonSettingFragment$setupConversationName$1$2$1> r3) {
        this.this$0 = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonSettingFragment$setupConversationName$1$2$1(this.this$0, this.$result, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CommonSettingFragment r6 = this.this$0;
        ub8.e r2 = this.$result;
        String r3 = r2.b;
        String r4 = r2.c;
        this.label = 1;
        BigDecimal r7 = CommonSettingFragment.k1;
        r6.getClass();
        RepoDispatcher.a.getClass();
        RepoDispatcher.f.getClass();
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "name");
        com.larus.im.d.d().updateConversationTitle(r3, r4, null);
        if (Unit.INSTANCE != r0) goto L12;
        return r0;
    }
}
