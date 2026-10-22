package com.larus.bmhome.double_post.fragment;

import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/video/RecommendVideoData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.RecommendVideoApiRepo$loadMoreData$data$1", f = "RecommendVideoApiRepo.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class RecommendVideoApiRepo$loadMoreData$data$1 extends SuspendLambda implements Function1<Continuation<? super RecommendVideoData>, Object> {
    final /* synthetic */ List<String> $lastItemIdList;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $recommendType;
    final /* synthetic */ List<String> $replyItemIdList;
    final /* synthetic */ int $requestPage;
    final /* synthetic */ SortRequestType $requestType;
    final /* synthetic */ SortScene $sortScene;
    int label;

    public RecommendVideoApiRepo$loadMoreData$data$1(SortScene r1, SortRequestType r2, int r3, List<String> r4, List<String> r5, String r6, String r7, Continuation<? super RecommendVideoApiRepo$loadMoreData$data$1> r8) {
        this.$sortScene = r1;
        this.$requestType = r2;
        this.$requestPage = r3;
        this.$replyItemIdList = r4;
        this.$lastItemIdList = r5;
        this.$messageId = r6;
        this.$recommendType = r7;
        super(1, r8);
    }

    public final Continuation<Unit> create(Continuation<?> r11) {
        return new RecommendVideoApiRepo$loadMoreData$data$1(this.$sortScene, this.$requestType, this.$requestPage, this.$replyItemIdList, this.$lastItemIdList, this.$messageId, this.$recommendType, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super RecommendVideoData> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        RecommendVideoApi r15 = RecommendVideoApi.a;
        SortScene r3 = this.$sortScene;
        SortRequestType r4 = this.$requestType;
        int r5 = this.$requestPage;
        List<String> r6 = this.$replyItemIdList;
        List<String> r7 = this.$lastItemIdList;
        String r9 = this.$messageId;
        String r10 = this.$recommendType;
        this.label = 1;
        r14 = RecommendVideoApi.b(r3, r4, r5, r6, r7, null, r9, r10, this, 32);
        if (r14 != r0) goto L11;
        return r0;
    }
}
