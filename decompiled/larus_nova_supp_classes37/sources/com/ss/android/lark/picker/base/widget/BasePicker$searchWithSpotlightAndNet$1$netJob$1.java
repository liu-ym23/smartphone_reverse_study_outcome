package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.service.SearchContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/search/dto/SearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$searchWithSpotlightAndNet$1$netJob$1", f = "BasePicker.kt", i = {}, l = {684}, m = "invokeSuspend", n = {}, s = {})
public final class BasePicker$searchWithSpotlightAndNet$1$netJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchResponse>, Object> {
    final /* synthetic */ String $queryKey;
    final /* synthetic */ String $requestId;
    int label;
    final /* synthetic */ BasePicker<P, PK> this$0;

    public BasePicker$searchWithSpotlightAndNet$1$netJob$1(BasePicker<P, PK> r1, String r2, String r3, Continuation<? super BasePicker$searchWithSpotlightAndNet$1$netJob$1> r4) {
        this.this$0 = r1;
        this.$requestId = r2;
        this.$queryKey = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BasePicker$searchWithSpotlightAndNet$1$netJob$1(this.this$0, this.$requestId, this.$queryKey, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super SearchResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L15:
        return (SearchResponse) r5;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        BasePicker<P, PK> r6 = this.this$0;     // Catch: Throwable -> L7
        String r2 = this.$requestId;     // Catch: Throwable -> L7
        SearchContext r3 = BasePicker.access$transform2SearchContext(r6, this.$queryKey);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r5 = BasePicker.access$getNetSearchResult(r6, r2, r3, this);     // Catch: Throwable -> L7
        if (r5 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        Log.e("BasePicker_spotlight", "getNetSearch fail: " + th);
        return null;
    }
}
