package com.larus.bmhome.chat.deepresearch.network;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/deepresearch/network/ShareDeepResearchReportData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.network.PreloadDeepResearchShareHelper$requestShareMessage$2", f = "PreloadDeepResearchShareHelper.kt", i = {}, l = {MessageCellStateTransformerType.DEVICE_OR_RUNTIME_CHANGED}, m = "invokeSuspend", n = {}, s = {})
public final class PreloadDeepResearchShareHelper$requestShareMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BizResponse<a>>, Object> {
    final /* synthetic */ b $request;
    int label;
    final /* synthetic */ PreloadDeepResearchShareHelper this$0;

    public PreloadDeepResearchShareHelper$requestShareMessage$2(PreloadDeepResearchShareHelper r1, b r2, Continuation<? super PreloadDeepResearchShareHelper$requestShareMessage$2> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PreloadDeepResearchShareHelper$requestShareMessage$2(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BizResponse<a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r1 = r19;
    L14:
        dm9.a.b r2 = (dm9.a) r1;
        if ((r2 instanceof dm9.a.b) == false) goto L19;
        return r2.a;
    L19:
        if ((r2 instanceof dm9.a.a) == false) goto L23;
        FLogger.a.i("PreloadMessageShareHelper", String.valueOf(((dm9.a.a) r2).c));
        return new BizResponse(-1, null, null, null, 14, null);
    L23:
        return new BizResponse(-1, null, null, null, 14, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        BizResponse<a> r3 = this.this$0.a;
        if (r3 == null) goto L11;
        return r3;
    L11:
        DeepResearchApi.a r4 = DeepResearchApi.a;
        PreloadDeepResearchShareHelper$requestShareMessage$2$result$1 r5 = new PreloadDeepResearchShareHelper$requestShareMessage$2$result$1(this.$request, null);
        this.label = 1;
        r4.getClass();
        FlowHttpConnection r6 = FlowHttpConnection.a;
        r1 = FlowHttpConnection.g("Basic", DeepResearchApi.class, r5, false, null, null, null, this, 248);
        if (r1 != r10) goto L14;
        return r10;
    }
}
