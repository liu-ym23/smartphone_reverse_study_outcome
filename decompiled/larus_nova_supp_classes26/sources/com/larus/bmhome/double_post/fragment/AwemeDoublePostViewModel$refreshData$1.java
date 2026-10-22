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
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.AwemeDoublePostViewModel$refreshData$1", f = "AwemeDoublePostViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class AwemeDoublePostViewModel$refreshData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needRetry;
    final /* synthetic */ SortRequestType $requestType;
    int label;
    final /* synthetic */ AwemeDoublePostViewModel this$0;

    public AwemeDoublePostViewModel$refreshData$1(AwemeDoublePostViewModel r1, SortRequestType r2, boolean r3, Continuation<? super AwemeDoublePostViewModel$refreshData$1> r4) {
        this.this$0 = r1;
        this.$requestType = r2;
        this.$needRetry = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AwemeDoublePostViewModel$refreshData$1(this.this$0, this.$requestType, this.$needRetry, r5);
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
        boolean r4 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L31:
        RecommendVideoData r16 = (RecommendVideoData) r15;
        if (r16 == null) goto L34;
        List<Content> r2 = r16.getItemLists();
    L35:
        AwemeDoublePostViewModel r3 = this.this$0;
        if (r16 == null) goto L38;
        boolean r5 = r16.getHasMore();
    L39:
        AwemeDoublePostViewModel.access$setHasMore$p(r3, r5);
        AwemeDoublePostViewModel.access$prefetchImage(this.this$0, r2);
        List<Content> r6 = r2;
        if (r6 != null) goto L42;
    L45:
        if (r4 == false) goto L51;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("refreshData: contentList isNullOrEmpty, requestId = ");
        if (r16 == null) goto L49;
        String r17 = r16.getRequestId();
    L50:
        r8.append(r17);
        r7.i("AwemeDoublePostViewModel", r8.toString());
        AwemeDoublePostViewModel.access$get_awemeRefreshList$p(this.this$0).postValue(new v(-2, null));
    L52:
        AwemeDoublePostViewModel.access$setRefreshing$p(this.this$0, false);
        return Unit.INSTANCE;
    L49:
        r17 = null;
        goto L50
    L51:
        AwemeDoublePostViewModel.access$get_awemeRefreshList$p(this.this$0).postValue(new v(0, r2));
        goto L52
    L42:
        if (r6.isEmpty() == true) goto L45;
        r4 = false;
        goto L45
    L38:
        r5 = true;
        goto L39
    L34:
        r2 = null;
        goto L35
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        if (AwemeDoublePostViewModel.access$getRefreshing$p(this.this$0) == false) goto L12;
        FLogger.a.i("AwemeDoublePostViewModel", "refreshData: is refreshing");
        return Unit.INSTANCE;
    L12:
        AwemeDoublePostViewModel.access$setRefreshing$p(this.this$0, true);
        FLogger.a.i("AwemeDoublePostViewModel", "refreshData: requestType(" + this.$requestType + "), sortScene(" + AwemeDoublePostViewModel.access$getSortScene$p(this.this$0) + ')');
        if (this.$needRetry == false) goto L15;
        int r9 = 12;
    L16:
        List r18 = AwemeDoublePostViewModel.access$getLastItemIdList$p(this.this$0);
        if (r18 == null) goto L19;
        List<String> r10 = CollectionsKt.toMutableList(r18);
    L20:
        if (r10 == null) goto L28;
        Function0 r19 = AwemeDoublePostViewModel.access$getFunctionGetItemIdList$p(this.this$0);
        if (r19 == null) goto L24;
        List r110 = (List) r19.invoke();
    L25:
        if (r110 != null) goto L27;
        r110 = CollectionsKt.emptyList();
    L27:
        Boxing.boxBoolean(r10.addAll(r110));
        goto L28
    L24:
        r110 = null;
    L28:
        w r11 = AwemeDoublePostViewModel.access$getRepo$p(this.this$0);
        SortScene r12 = AwemeDoublePostViewModel.access$getSortScene$p(this.this$0);
        SortRequestType r13 = this.$requestType;
        List<String> r14 = AwemeDoublePostViewModel.access$getReplyItemIdList$p(this.this$0);
        String r111 = AwemeDoublePostViewModel.access$getMessageId$p(this.this$0);
        String r112 = AwemeDoublePostViewModel.access$getRecommendType$p(this.this$0);
        this.label = 1;
        r15 = r11.b(r12, r13, r9, r14, r10, r111, r112, this);
        if (r15 != r0) goto L31;
        return r0;
    L19:
        r10 = null;
        goto L20
    L15:
        r9 = 1;
        goto L16
    }
}
