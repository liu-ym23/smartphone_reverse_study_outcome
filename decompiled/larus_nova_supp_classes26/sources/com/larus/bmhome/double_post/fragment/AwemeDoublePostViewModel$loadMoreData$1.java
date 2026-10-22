package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.AwemeDoublePostViewModel$loadMoreData$1", f = "AwemeDoublePostViewModel.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
public final class AwemeDoublePostViewModel$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needRetry;
    final /* synthetic */ SortRequestType $requestType;
    int label;
    final /* synthetic */ AwemeDoublePostViewModel this$0;

    public AwemeDoublePostViewModel$loadMoreData$1(AwemeDoublePostViewModel r1, SortRequestType r2, boolean r3, Continuation<? super AwemeDoublePostViewModel$loadMoreData$1> r4) {
        this.this$0 = r1;
        this.$requestType = r2;
        this.$needRetry = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AwemeDoublePostViewModel$loadMoreData$1(this.this$0, this.$requestType, this.$needRetry, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L32:
        RecommendVideoData r16 = (RecommendVideoData) r15;
        if (r16 == null) goto L35;
        List<Content> r2 = r16.getItemLists();
    L36:
        AwemeDoublePostViewModel r4 = this.this$0;
        if (r16 == null) goto L39;
        r3 = r16.getHasMore();
    L39:
        AwemeDoublePostViewModel.access$setHasMore$p(r4, r3);
        AwemeDoublePostViewModel.access$prefetchImage(this.this$0, r2);
        if (r2 != null) goto L46;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("loadMoreData: contentList isNullOrEmpty, requestId = ");
        if (r16 == null) goto L44;
        String r17 = r16.getRequestId();
    L45:
        r6.append(r17);
        r5.i("AwemeDoublePostViewModel", r6.toString());
        AwemeDoublePostViewModel.access$get_awemeLoadMoreList$p(this.this$0).postValue(new v(-2, null));
    L47:
        AwemeDoublePostViewModel.access$setLoadingMore$p(this.this$0, false);
        return Unit.INSTANCE;
    L44:
        r17 = null;
        goto L45
    L46:
        AwemeDoublePostViewModel.access$get_awemeLoadMoreList$p(this.this$0).postValue(new v(0, r2));
        goto L47
    L35:
        r2 = null;
        goto L36
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        if (AwemeDoublePostViewModel.access$getHasMore$p(this.this$0) == true) goto L11;
    L49:
        FLogger.a.i("AwemeDoublePostViewModel", "loadMoreData: hasMore(" + AwemeDoublePostViewModel.access$getHasMore$p(this.this$0) + ") or loadingMore(" + AwemeDoublePostViewModel.access$getLoadingMore$p(this.this$0) + ')');
        return Unit.INSTANCE;
    L11:
        if (AwemeDoublePostViewModel.access$getLoadingMore$p(this.this$0) == true) goto L49;
        FLogger.a.i("AwemeDoublePostViewModel", "loadMoreData: requestType(" + this.$requestType + "), sortScene(" + AwemeDoublePostViewModel.access$getSortScene$p(this.this$0) + ')');
        AwemeDoublePostViewModel.access$setLoadingMore$p(this.this$0, true);
        AwemeDoublePostViewModel.access$get_awemeLoadMoreList$p(this.this$0).postValue(new v(-1, null));
        if (this.$needRetry == false) goto L16;
        int r8 = 12;
    L17:
        List r18 = AwemeDoublePostViewModel.access$getLastItemIdList$p(this.this$0);
        if (r18 == null) goto L20;
        List<String> r10 = CollectionsKt.toMutableList(r18);
    L21:
        if (r10 == null) goto L29;
        Function0 r19 = AwemeDoublePostViewModel.access$getFunctionGetItemIdList$p(this.this$0);
        if (r19 == null) goto L25;
        List r110 = (List) r19.invoke();
    L26:
        if (r110 != null) goto L28;
        r110 = CollectionsKt.emptyList();
    L28:
        Boxing.boxBoolean(r10.addAll(r110));
        goto L29
    L25:
        r110 = null;
    L29:
        w r7 = AwemeDoublePostViewModel.access$getRepo$p(this.this$0);
        SortScene r9 = AwemeDoublePostViewModel.access$getSortScene$p(this.this$0);
        SortRequestType r11 = this.$requestType;
        List<String> r12 = AwemeDoublePostViewModel.access$getReplyItemIdList$p(this.this$0);
        String r13 = AwemeDoublePostViewModel.access$getMessageId$p(this.this$0);
        String r14 = AwemeDoublePostViewModel.access$getRecommendType$p(this.this$0);
        this.label = 1;
        r15 = r7.c(r9, r11, r8, r12, r10, r13, r14, this);
        if (r15 != r0) goto L32;
        return r0;
    L20:
        r10 = null;
        goto L21
    L16:
        r8 = 1;
        goto L17
    }
}
