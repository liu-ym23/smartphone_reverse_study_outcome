package com.larus.bmhome.double_post.fragment;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.fragment.RecommendVideoApiRepo", f = "RecommendVideoApiRepo.kt", i = {}, l = {88, 90, 92}, m = "prefetchData", n = {}, s = {})
final class RecommendVideoApiRepo$prefetchData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendVideoApiRepo this$0;

    public RecommendVideoApiRepo$prefetchData$1(RecommendVideoApiRepo r1, Continuation<? super RecommendVideoApiRepo$prefetchData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        RecommendVideoApiRepo r15 = this.this$0;
        r15.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        RecommendVideoApiRepo$prefetchData$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 == 2) goto L14;
        if (r4 == 3) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
    L24:
        List r8 = (List) r2;
        RecommendVideoApiRepo.d(1, r8);
        RecommendVideoData r5 = new RecommendVideoData(r8, null, true, 2, null);
        SortRequestType r6 = SortRequestType.PreLoad;
        r0.label = 3;
        r2 = r15.f(r5, r6, r0);
        if (r2 != r3) goto L28;
        return r3;
    L28:
        return r2;
    L15:
        ResultKt.throwOnFailure(r2);
        goto L28
    L16:
        ResultKt.throwOnFailure(r2);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L21;
        FLogger.a.i("RecommendVideoApiRepo", "prefetchData: network is not available");
        SortRequestType r7 = SortRequestType.PreLoad;
        r0.label = 1;
        r2 = r15.f(null, r7, r0);
        if (r2 != r3) goto L28;
        return r3;
    L21:
        RecommendVideoApi r9 = RecommendVideoApi.a;
        r0.label = 2;
        r2 = RecommendVideoApi.a.c(SortScene.PreFetch, r0);
        if (r2 != r3) goto L24;
        return r3;
    L5:
        r0 = new RecommendVideoApiRepo$prefetchData$1(r15, this);
        goto L6
    }
}
