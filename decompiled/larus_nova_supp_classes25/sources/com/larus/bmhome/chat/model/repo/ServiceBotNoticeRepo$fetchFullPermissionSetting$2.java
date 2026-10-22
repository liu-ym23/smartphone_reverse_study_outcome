package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import dm9.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo$fetchFullPermissionSetting$2", f = "ServiceBotNoticeRepo.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotNoticeRepo$fetchFullPermissionSetting$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FullPermissionSettings>, Object> {
    final /* synthetic */ String $botId;
    int label;

    public ServiceBotNoticeRepo$fetchFullPermissionSetting$2(String r1, Continuation<? super ServiceBotNoticeRepo$fetchFullPermissionSetting$2> r2) {
        this.$botId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ServiceBotNoticeRepo$fetchFullPermissionSetting$2(this.$botId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super FullPermissionSettings> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        FullPermissionSettings r4 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        a.b r9 = (a) r8;
        if ((r9 instanceof a.b) == false) goto L22;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("fetchFullPermissionSetting code=");
        a.b r10 = r9;
        r3.append(r10.a.getCode());
        r3.append(" resp=");
        r3.append(r10.a.getData());
        r2.i("ServiceBotNoticeRepo", r3.toString());
        BizResponse r11 = r10.a;
        if (r11.isSuccess() == true) goto L17;
        r11 = null;
    L17:
        if (r11 == null) goto L19;
        r4 = (FullPermissionSettings) r11.getData();
    L19:
        if (r4 == null) goto L24;
        ServiceBotNoticeRepo r12 = ServiceBotNoticeRepo.a;
        String r5 = this.$botId;
        r12.getClass();
        ServiceBotNoticeRepo.i(r5, r4);
    L24:
        return r4;
    L22:
        if ((r9 instanceof a.a) == false) goto L26;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("fetchFullPermissionSetting fail: code=");
        a.a r13 = (a.a) r9;
        r7.append(r13.a);
        r7.append(" msg=");
        r7.append(r13.b);
        r6.e("ServiceBotNoticeRepo", r7.toString());
        goto L24
    L26:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("ServiceBotNoticeRepo", "fetchFullPermissionSetting botId=" + this.$botId);
        ServiceBotNoticeApi.a r14 = ServiceBotNoticeApi.a;
        ServiceBotNoticeRepo$fetchFullPermissionSetting$2$result$1 r15 = new ServiceBotNoticeRepo$fetchFullPermissionSetting$2$result$1(this.$botId, null);
        this.label = 1;
        r14.getClass();
        r8 = ServiceBotNoticeApi.a.a(r15, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
