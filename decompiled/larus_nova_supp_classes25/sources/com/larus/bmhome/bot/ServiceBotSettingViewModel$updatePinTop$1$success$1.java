package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$updatePinTop$1$success$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {229, 231}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotSettingViewModel$updatePinTop$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $checked;
    final /* synthetic */ wc9.e $currentConversation;
    int label;
    final /* synthetic */ ServiceBotSettingViewModel this$0;

    public ServiceBotSettingViewModel$updatePinTop$1$success$1(wc9.e r1, boolean r2, ServiceBotSettingViewModel r3, Continuation<? super ServiceBotSettingViewModel$updatePinTop$1$success$1> r4) {
        this.$currentConversation = r1;
        this.$checked = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ServiceBotSettingViewModel$updatePinTop$1$success$1(this.$currentConversation, this.$checked, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L23:
        boolean r7 = ((Boolean) r6).booleanValue();
    L25:
        return Boxing.boxBoolean(r7);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L19:
        r7 = ((Boolean) r6).booleanValue();
        goto L25
    L10:
        ResultKt.throwOnFailure(r6);
        Integer r8 = this.$currentConversation.j;
        if (r8 == null) goto L13;
        int r9 = r8.intValue();
    L15:
        if (this.$checked == false) goto L20;
        RepoDispatcher.a.getClass();
        ConversationRepo r2 = RepoDispatcher.f;
        String r3 = ServiceBotSettingViewModel.access$getConversationId$p(this.this$0);
        int r4 = this.$currentConversation.F;
        this.label = 1;
        r2.getClass();
        r6 = ConversationRepo.A(r3, r4, r9, this);
        if (r6 != r0) goto L19;
        return r0;
    L20:
        RepoDispatcher.a.getClass();
        ConversationRepo r5 = RepoDispatcher.f;
        String r10 = ServiceBotSettingViewModel.access$getConversationId$p(this.this$0);
        int r11 = this.$currentConversation.F;
        this.label = 2;
        r5.getClass();
        r6 = ConversationRepo.D(r10, r11, r9, this);
        if (r6 != r0) goto L23;
        return r0;
    L13:
        r9 = 0;
        goto L15
    }
}
