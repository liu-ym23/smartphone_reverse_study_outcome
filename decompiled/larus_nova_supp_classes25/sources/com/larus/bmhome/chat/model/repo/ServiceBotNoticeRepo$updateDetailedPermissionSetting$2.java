package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import dm9.a;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/model/repo/DetailedPermissionSetting;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo$updateDetailedPermissionSetting$2", f = "ServiceBotNoticeRepo.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotNoticeRepo$updateDetailedPermissionSetting$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DetailedPermissionSetting>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $supplierId;
    final /* synthetic */ List<TileForUpdate> $updates;
    int label;

    public ServiceBotNoticeRepo$updateDetailedPermissionSetting$2(String r1, String r2, List<TileForUpdate> r3, Continuation<? super ServiceBotNoticeRepo$updateDetailedPermissionSetting$2> r4) {
        this.$botId = r1;
        this.$supplierId = r2;
        this.$updates = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ServiceBotNoticeRepo$updateDetailedPermissionSetting$2(this.$botId, this.$supplierId, this.$updates, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super DetailedPermissionSetting> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        DetailedPermissionSetting r4 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        a.b r10 = (a) r9;
        if ((r10 instanceof a.b) == false) goto L22;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("updateDetailedPermissionSetting code=");
        a.b r11 = r10;
        r3.append(r11.a.getCode());
        r3.append(" resp=");
        r3.append(r11.a.getData());
        r2.i("ServiceBotNoticeRepo", r3.toString());
        BizResponse r12 = r11.a;
        if (r12.isSuccess() == true) goto L17;
        r12 = null;
    L17:
        if (r12 == null) goto L19;
        r4 = (DetailedPermissionSetting) r12.getData();
    L19:
        if (r4 == null) goto L24;
        ServiceBotNoticeRepo.a(ServiceBotNoticeRepo.a, this.$botId, this.$supplierId, r4);
    L24:
        return r4;
    L22:
        if ((r10 instanceof a.a) == false) goto L26;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("updateDetailedPermissionSetting fail: code=");
        a.a r13 = (a.a) r10;
        r6.append(r13.a);
        r6.append(" msg=");
        r6.append(r13.b);
        r5.e("ServiceBotNoticeRepo", r6.toString());
        goto L24
    L26:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("ServiceBotNoticeRepo", "updateDetailedPermissionSetting " + this.$botId + ' ' + this.$supplierId + ' ' + this.$updates);
        ServiceBotNoticeApi.a r14 = ServiceBotNoticeApi.a;
        ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1 r7 = new ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1(this.$botId, this.$supplierId, this.$updates, null);
        this.label = 1;
        r14.getClass();
        r9 = ServiceBotNoticeApi.a.a(r7, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
