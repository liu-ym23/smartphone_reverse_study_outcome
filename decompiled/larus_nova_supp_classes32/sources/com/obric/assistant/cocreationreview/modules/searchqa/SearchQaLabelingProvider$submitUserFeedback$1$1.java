package com.obric.assistant.cocreationreview.modules.searchqa;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.CocreationLabelingServerClient;
import com.obric.assistant.cocreationreview.CocreationUserFeedbackRequest;
import dm9.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.searchqa.SearchQaLabelingProvider$submitUserFeedback$1$1", f = "SearchQaProvider.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
final class SearchQaLabelingProvider$submitUserFeedback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends Object>>, Object> {
    final /* synthetic */ m $this_runCatching;
    final /* synthetic */ CocreationUserFeedbackRequest $userFeedbackRequest;
    int label;

    public SearchQaLabelingProvider$submitUserFeedback$1$1(m r1, CocreationUserFeedbackRequest r2, Continuation<? super SearchQaLabelingProvider$submitUserFeedback$1$1> r3) {
        this.$this_runCatching = r1;
        this.$userFeedbackRequest = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SearchQaLabelingProvider$submitUserFeedback$1$1(this.$this_runCatching, this.$userFeedbackRequest, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<? extends Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
        CocreationLabelingServerClient r5 = this.$this_runCatching.d;
        CocreationUserFeedbackRequest r2 = this.$userFeedbackRequest;
        this.label = 1;
        r4 = r5.b(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
