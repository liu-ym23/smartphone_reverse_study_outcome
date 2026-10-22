package com.ss.android.lark.picker;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.picker.PickerViewModel$createSearcher$1$onLoadMore$1", f = "PickerViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class PickerViewModel$createSearcher$1$onLoadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $requestId;
    int label;
    final /* synthetic */ PickerViewModel.AnonymousClass1 this$0;

    public PickerViewModel$createSearcher$1$onLoadMore$1(PickerViewModel.AnonymousClass1 r1, String r2, Continuation<? super PickerViewModel$createSearcher$1$onLoadMore$1> r3) {
        this.this$0 = r1;
        this.$requestId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PickerViewModel$createSearcher$1$onLoadMore$1(this.this$0, this.$requestId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L7 ErrorResult -> L9
    L17:
        SearchResponse r5 = (SearchResponse) r4;     // Catch: Throwable -> L7 ErrorResult -> L9
        IGetDataCallback<SearchResponse> r2 = this.this$0.getCallback();     // Catch: Throwable -> L7 ErrorResult -> L9
        if (r2 == null) goto L31;
        r2.onSuccess(r5);     // Catch: Throwable -> L7 ErrorResult -> L9
    L31:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r4);
        Searcher r6 = PickerViewModel.AnonymousClass1.access$getInnerSearcher$p(this.this$0);     // Catch: Throwable -> L7 ErrorResult -> L9
        String r3 = this.$requestId;     // Catch: Throwable -> L7 ErrorResult -> L9
        this.label = 1;     // Catch: Throwable -> L7 ErrorResult -> L9
        r4 = r6.loadMore(r3, this);     // Catch: Throwable -> L7 ErrorResult -> L9
        if (r4 != r0) goto L17;
        return r0;
    L9:
        e = move-exception;
        IGetDataCallback<SearchResponse> r7 = this.this$0.getCallback();
        if (r7 == null) goto L31;
        r7.onError(e);
    L7:
        th = move-exception;
        IGetDataCallback<SearchResponse> r8 = this.this$0.getCallback();
        if (r8 == null) goto L31;
        String r9 = th.getMessage();
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r8.onError(new UnKnownError(r9));
        goto L31
    }
}
