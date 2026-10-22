package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.params.BasePickerParams;
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
@DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$searchWithSpotlightAndNet$1$spotlightJob$1", f = "BasePicker.kt", i = {}, l = {674}, m = "invokeSuspend", n = {}, s = {})
public final class BasePicker$searchWithSpotlightAndNet$1$spotlightJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchResponse>, Object> {
    final /* synthetic */ String $queryKey;

    /* JADX INFO: Incorrect field signature: TP; */
    final /* synthetic */ BasePickerParams $spotlightPickerParam;
    int label;
    final /* synthetic */ BasePicker<P, PK> this$0;

    /* JADX WARN: Incorrect types in method signature: (Lcom/ss/android/lark/picker/base/widget/BasePicker<TP;TPK;>;Ljava/lang/String;TP;Lkotlin/coroutines/Continuation<-Lcom/ss/android/lark/picker/base/widget/BasePicker$searchWithSpotlightAndNet$1$spotlightJob$1;>;)V */
    public BasePicker$searchWithSpotlightAndNet$1$spotlightJob$1(BasePicker r1, String r2, BasePickerParams r3, Continuation r4) {
        this.this$0 = r1;
        this.$queryKey = r2;
        this.$spotlightPickerParam = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BasePicker$searchWithSpotlightAndNet$1$spotlightJob$1(this.this$0, this.$queryKey, this.$spotlightPickerParam, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super SearchResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L7
    L15:
        return (SearchResponse) r7;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r7);
        BasePicker<P, PK> r8 = this.this$0;     // Catch: Throwable -> L7
        String r2 = BasePicker.access$getSpotlightRequestId$p(r8);     // Catch: Throwable -> L7
        SearchContext r3 = BasePicker.access$transform2SearchContext4Spotlight(this.this$0, this.$queryKey, this.$spotlightPickerParam);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r7 = BasePicker.access$getSpotlightSearchResult(r8, r2, r3, this);     // Catch: Throwable -> L7
        if (r7 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        Log.e("BasePicker_spotlight", "getSpotlightSearch fail: " + th);
        return null;
    }
}
