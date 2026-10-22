package com.larus.bmhome.chat.helper;

import com.larus.bmhome.chat.api.SearchSuggestApi;
import com.larus.bmhome.chat.api.SuggestPromptData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/SuggestPromptData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.FlowReqHelper$execSearchApiCall$2", f = "FlowReqHelper.kt", i = {0}, l = {22, MessageCellStateTransformerType.SEARCH_LIST, MessageCellStateTransformerType.FORM_MSG}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
final class FlowReqHelper$execSearchApiCall$2 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends BizResponse<SuggestPromptData>>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $prompt;
    final /* synthetic */ String $searchResp;
    private /* synthetic */ Object L$0;
    int label;

    public FlowReqHelper$execSearchApiCall$2(String r1, String r2, Continuation<? super FlowReqHelper$execSearchApiCall$2> r3) {
        this.$prompt = r1;
        this.$searchResp = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FlowReqHelper$execSearchApiCall$2 r0 = new FlowReqHelper$execSearchApiCall$2(this.$prompt, this.$searchResp, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Result<BizResponse<SuggestPromptData>>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r16);
    L29:
        return Unit.INSTANCE;
    L11:
        FlowCollector r1 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r16);
        FlowCollector r14 = r1;
        Object r2 = r16;
    L15:
        dm9.a.b r3 = (dm9.a) r2;
        if ((r3 instanceof dm9.a.b) == false) goto L21;
        Result.Companion r4 = Result.Companion;
        Result r5 = Result.box-impl(Result.constructor-impl(r3.a));
        this.L$0 = null;
        this.label = 2;
        if (r14.emit(r5, this) != r10) goto L29;
        return r10;
    L21:
        if ((r3 instanceof dm9.a.a) == false) goto L29;
        dm9.a.a r6 = (dm9.a.a) r3;
        Objects.toString(r6.c);
        Result.Companion r7 = Result.Companion;
        Throwable r8 = r6.c;
        if (r8 != null) goto L25;
        r8 = new Exception();
    L25:
        Result r9 = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r8)));
        this.L$0 = null;
        this.label = 3;
        if (r14.emit(r9, this) != r10) goto L29;
        return r10;
    L12:
        ResultKt.throwOnFailure(r16);
        r14 = (FlowCollector) this.L$0;
        SearchSuggestApi.a r11 = SearchSuggestApi.a;
        FlowReqHelper$execSearchApiCall$2$result$1 r12 = new FlowReqHelper$execSearchApiCall$2$result$1(this.$prompt, this.$searchResp, null);
        this.L$0 = r14;
        this.label = 1;
        r11.getClass();
        FlowHttpConnection r13 = FlowHttpConnection.a;
        r2 = FlowHttpConnection.g("Message", SearchSuggestApi.class, r12, false, null, null, null, this, 248);
        if (r2 != r10) goto L15;
        return r10;
    }
}
