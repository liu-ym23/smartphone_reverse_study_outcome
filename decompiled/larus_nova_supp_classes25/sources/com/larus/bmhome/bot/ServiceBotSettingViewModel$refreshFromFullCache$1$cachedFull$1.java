package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.FullPermissionSettings;
import com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/model/repo/FullPermissionSettings;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FullPermissionSettings>, Object> {
    final /* synthetic */ String $currentBotId;
    int label;

    public ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1(String r1, Continuation<? super ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1> r2) {
        this.$currentBotId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1(this.$currentBotId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super FullPermissionSettings> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        ServiceBotNoticeRepo r3 = ServiceBotNoticeRepo.a;
        String r0 = this.$currentBotId;
        r3.getClass();
        return ServiceBotNoticeRepo.f(r0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
