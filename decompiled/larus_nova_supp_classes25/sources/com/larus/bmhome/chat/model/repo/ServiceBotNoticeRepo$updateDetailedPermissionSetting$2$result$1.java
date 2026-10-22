package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/model/repo/DetailedPermissionSetting;", "Lcom/larus/bmhome/chat/model/repo/ServiceBotNoticeApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1", f = "ServiceBotNoticeRepo.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1 extends SuspendLambda implements Function2<ServiceBotNoticeApi, Continuation<? super BizResponse<DetailedPermissionSetting>>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $supplierId;
    final /* synthetic */ List<TileForUpdate> $updates;
    private /* synthetic */ Object L$0;
    int label;

    public ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1(String r1, String r2, List<TileForUpdate> r3, Continuation<? super ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1> r4) {
        this.$botId = r1;
        this.$supplierId = r2;
        this.$updates = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1 r0 = new ServiceBotNoticeRepo$updateDetailedPermissionSetting$2$result$1(this.$botId, this.$supplierId, this.$updates, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ServiceBotNoticeApi r1, Continuation<? super BizResponse<DetailedPermissionSetting>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ServiceBotNoticeApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ServiceBotNoticeApi r8 = (ServiceBotNoticeApi) this.L$0;
        UpdateDetailedPermissionSettingReq r2 = new UpdateDetailedPermissionSettingReq(this.$botId, this.$supplierId, this.$updates);
        this.label = 1;
        r7 = r8.updateDetailedPermissionSetting(r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
