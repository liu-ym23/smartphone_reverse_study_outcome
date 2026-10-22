package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.SearchResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "Lcom/ss/android/lark/search/dto/SearchResponse;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$1", f = "BasePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$1 extends SuspendLambda implements Function2<SearchResponse, Continuation<? super Deferred<? extends SearchResponse>>, Object> {
    final /* synthetic */ Deferred<SearchResponse> $spotlightJob;
    int label;

    public BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$1(Deferred<? extends SearchResponse> r1, Continuation<? super BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$1> r2) {
        this.$spotlightJob = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$1(this.$spotlightJob, r3);
    }

    public final Object invoke(SearchResponse r1, Continuation<? super Deferred<? extends SearchResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SearchResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return this.$spotlightJob;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
