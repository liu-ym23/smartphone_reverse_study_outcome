package com.larus.avlink.notification;

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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/avlink/notification/DoraLinkApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.notification.DoraLinkStatusReporter$doReport$response$1", f = "DoraLinkStatusReporter.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
final class DoraLinkStatusReporter$doReport$response$1 extends SuspendLambda implements Function2<DoraLinkApi, Continuation<? super BizResponse<Unit>>, Object> {
    final /* synthetic */ b $postBody;
    private /* synthetic */ Object L$0;
    int label;

    public DoraLinkStatusReporter$doReport$response$1(b r1, Continuation<? super DoraLinkStatusReporter$doReport$response$1> r2) {
        this.$postBody = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraLinkStatusReporter$doReport$response$1 r0 = new DoraLinkStatusReporter$doReport$response$1(this.$postBody, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(DoraLinkApi r1, Continuation<? super BizResponse<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DoraLinkApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DoraLinkApi r5 = (DoraLinkApi) this.L$0;
        b r2 = this.$postBody;
        this.label = 1;
        r4 = r5.uploadDoraStatus(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
