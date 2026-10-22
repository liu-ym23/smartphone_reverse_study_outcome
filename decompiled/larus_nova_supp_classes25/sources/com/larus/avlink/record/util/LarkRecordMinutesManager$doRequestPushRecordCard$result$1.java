package com.larus.avlink.record.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/record/util/LarkRecordStartData;", "Lcom/larus/avlink/record/util/LarkRecordStartApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$doRequestPushRecordCard$result$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {1807}, m = "invokeSuspend", n = {}, s = {})
final class LarkRecordMinutesManager$doRequestPushRecordCard$result$1 extends SuspendLambda implements Function2<LarkRecordStartApi, Continuation<? super BizResponse<l>>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Integer $productId;
    final /* synthetic */ String $recordingId;
    final /* synthetic */ int $startScene;
    private /* synthetic */ Object L$0;
    int label;

    public LarkRecordMinutesManager$doRequestPushRecordCard$result$1(String r1, String r2, Integer r3, String r4, int r5, Continuation<? super LarkRecordMinutesManager$doRequestPushRecordCard$result$1> r6) {
        this.$botId = r1;
        this.$cvsId = r2;
        this.$productId = r3;
        this.$recordingId = r4;
        this.$startScene = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        LarkRecordMinutesManager$doRequestPushRecordCard$result$1 r7 = new LarkRecordMinutesManager$doRequestPushRecordCard$result$1(this.$botId, this.$cvsId, this.$productId, this.$recordingId, this.$startScene, r10);
        r7.L$0 = r9;
        return r7;
    }

    public final Object invoke(LarkRecordStartApi r1, Continuation<? super BizResponse<l>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((LarkRecordStartApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        LarkRecordStartApi r12 = (LarkRecordStartApi) this.L$0;
        m r2 = new m(this.$botId, this.$cvsId, 3, this.$productId, this.$recordingId, this.$startScene);
        this.label = 1;
        r11 = r12.larkRecordStart(r2, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
