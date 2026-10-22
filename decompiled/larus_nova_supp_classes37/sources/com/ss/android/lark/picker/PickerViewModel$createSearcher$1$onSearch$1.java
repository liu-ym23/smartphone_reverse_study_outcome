package com.ss.android.lark.picker;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.SearcherConfig;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.picker.PickerViewModel$createSearcher$1$onSearch$1", f = "PickerViewModel.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_USER_GROUP}, m = "invokeSuspend", n = {}, s = {})
public final class PickerViewModel$createSearcher$1$onSearch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<SearchResponse> $callback;
    final /* synthetic */ SearchContext $context;
    final /* synthetic */ boolean $isSpotlight;
    final /* synthetic */ String $requestId;
    int label;
    final /* synthetic */ PickerViewModel.AnonymousClass1 this$0;

    public PickerViewModel$createSearcher$1$onSearch$1(PickerViewModel.AnonymousClass1 r1, String r2, SearchContext r3, boolean r4, IGetDataCallback<SearchResponse> r5, Continuation<? super PickerViewModel$createSearcher$1$onSearch$1> r6) {
        this.this$0 = r1;
        this.$requestId = r2;
        this.$context = r3;
        this.$isSpotlight = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new PickerViewModel$createSearcher$1$onSearch$1(this.this$0, this.$requestId, this.$context, this.$isSpotlight, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L7 ErrorResult -> L9
    L17:
        IGetDataCallback<SearchResponse> r2 = this.$callback;     // Catch: Throwable -> L7 ErrorResult -> L9
        r2.onSuccess((SearchResponse) r13);     // Catch: Throwable -> L7 ErrorResult -> L9
    L25:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r13);
        Searcher r3 = PickerViewModel.AnonymousClass1.access$getInnerSearcher$p(this.this$0);     // Catch: Throwable -> L7 ErrorResult -> L9
        String r4 = this.$requestId;     // Catch: Throwable -> L7 ErrorResult -> L9
        String r5 = this.$context.b;     // Catch: Throwable -> L7 ErrorResult -> L9
        SearcherConfig r6 = this.this$0.getConfig();     // Catch: Throwable -> L7 ErrorResult -> L9
        boolean r7 = this.$isSpotlight;     // Catch: Throwable -> L7 ErrorResult -> L9
        this.label = 1;     // Catch: Throwable -> L7 ErrorResult -> L9
        r13 = Searcher.search$default(r3, r4, r5, r6, r7, false, this, 16, null);     // Catch: Throwable -> L7 ErrorResult -> L9
        if (r13 != r0) goto L17;
        return r0;
    L9:
        e = move-exception;
        this.$callback.onError(e);
    L7:
        th = move-exception;
        IGetDataCallback<SearchResponse> r8 = this.$callback;
        String r14 = th.getMessage();
        if (r14 != null) goto L22;
        r14 = "";
    L22:
        r8.onError(new UnKnownError(r14));
        goto L25
    }
}
