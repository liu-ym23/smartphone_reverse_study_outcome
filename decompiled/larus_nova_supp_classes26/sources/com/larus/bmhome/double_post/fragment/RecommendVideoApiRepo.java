package com.larus.bmhome.double_post.fragment;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RecommendVideoApiRepo implements w {
    public static final /* synthetic */ int b = 0;
    public int a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.double_post.fragment.w
    public final void a() {
        this.a = 1;
    }

    public RecommendVideoApiRepo() {
        this.a = 1;
    }

    public static void d(int r5, List r6) {
        if (r5 <= 2) goto L5;
        return;
    L5:
        if (r5 != 1) goto L7;
        FLogger.a.d("RecommendVideoApiRepo", "clear cache");
        ((ArrayList) AwemeDoublePostCacheManager.d).clear();
    L7:
        FLogger r1 = FLogger.a;
        r1.d("RecommendVideoApiRepo", "append cache page: " + r5);
        AwemeDoublePostCacheManager r3 = AwemeDoublePostCacheManager.a;
        if (r6 == null) goto L11;
        ((ArrayList) AwemeDoublePostCacheManager.d).addAll(r6);
    L11:
        if (r5 != 2) goto L15;
        r1.d("RecommendVideoApiRepo", "save cache");
        AwemeDoublePostCacheManager.c();
        return;
    }

    public final Object f(RecommendVideoData r7, SortRequestType r8, Continuation<? super RecommendVideoData> r9) {
        if ((r9 instanceof RecommendVideoApiRepo$tryUseLocalCache$1) == false) goto L7;
        RecommendVideoApiRepo$tryUseLocalCache$1 r0 = (RecommendVideoApiRepo$tryUseLocalCache$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L35:
        return new RecommendVideoData((List) r10, null, true, 2, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        boolean r4 = false;
        if (r8 != SortRequestType.PreLoad) goto L17;
    L18:
        if (r7 == null) goto L27;
        List<Content> r11 = r7.getItemLists();
        if (r11 != null) goto L22;
    L25:
        boolean r12 = true;
    L26:
        if (r12 == true) goto L27;
    L30:
        if (r4 == false) goto L36;
        AwemeDoublePostCacheManager r13 = AwemeDoublePostCacheManager.a;
        r0.label = 1;
        r10 = r13.a(r0);
        if (r10 != r2) goto L35;
        return r2;
    L36:
        return r7;
    L22:
        if (r11.isEmpty() == true) goto L25;
        r12 = false;
    L27:
        Lazy r14 = com.larus.bmhome.video.b.a;
        if (com.larus.bmhome.video.b.f() == true) goto L30;
        r4 = true;
        goto L30
    L17:
        if (r8 != SortRequestType.LandingEnterPage) goto L30;
    L7:
        r0 = new RecommendVideoApiRepo$tryUseLocalCache$1(this, r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00fc -> B:51:0x00ff). Please report as a decompilation issue!!! */
    public final Object e(int r19, long r20, Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r22, Continuation<? super RecommendVideoData> r23) {
        if ((r23 instanceof RecommendVideoApiRepo$requestWithRetry$1) == false) goto L7;
        RecommendVideoApiRepo$requestWithRetry$1 r1 = (RecommendVideoApiRepo$requestWithRetry$1) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r5 = r1.I$1;
        long r8 = r1.J$0;
        int r10 = r1.I$0;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r11 = (Function1) r1.L$0;
        ResultKt.throwOnFailure(r0);
        RecommendVideoApiRepo$requestWithRetry$1 r9 = r1;
        int r6 = r10;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r12 = r11;
        Object r13 = r3;
        int r14 = r5;
        long r7 = r8;
    L51:
        r14 = r14 + 1;
    L21:
        if (r14 < r6) goto L55;
        return null;
    L55:
        r9.L$0 = r12;     // Catch: Exception -> L46
        r9.I$0 = r6;     // Catch: Exception -> L46
        r9.J$0 = r7;     // Catch: Exception -> L46
        r9.I$1 = r14;     // Catch: Exception -> L46
        r9.I$2 = r14;     // Catch: Exception -> L46
        r9.label = 1;     // Catch: Exception -> L46
        r0 = r12.invoke(r9);     // Catch: Exception -> L46
        if (r0 != r13) goto L26;
        return r13;
    L26:
        RecommendVideoData r15 = (RecommendVideoData) r0;     // Catch: Exception -> L18
        if (r15 == null) goto L44;
        if (r15.getHasMore() == true) goto L32;
        return r15;
    L32:
        List<Content> r16 = r15.getItemLists();     // Catch: Exception -> L18
        if (r16 != null) goto L35;
    L38:
        boolean r17 = true;
    L39:
        if (r17 == true) goto L42;
        return r15;
    L42:
        throw new RequestRecommendVideoDataError("data is null or itemLists is null or empty");     // Catch: Exception -> L18
    L35:
        if (r16.isEmpty() == true) goto L38;
        r17 = false;
        goto L39
    L44:
        throw new RequestRecommendVideoDataError("data is null or itemLists is null or empty");     // Catch: Exception -> L18
    L46:
        Exception e = e;
        int r18 = r14;
    L48:
        FLogger.a.i("RecommendVideoApiRepo", "requestWithRetry: request error attempt(" + (r18 + 1) + ") with exception(" + e.getMessage() + ')');
        r9.L$0 = r12;
        r9.I$0 = r6;
        r9.J$0 = r7;
        r9.I$1 = r14;
        r9.label = 2;
        if (DelayKt.delay(r7, r9) != r13) goto L51;
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r21 = r1.I$2;
        int r24 = r1.I$1;
        long r25 = r1.J$0;
        int r110 = r1.I$0;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r111 = (Function1) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L18
    L18:
        e = e;
        r9 = r1;
        r13 = r3;
        r6 = r110;
        r14 = r24;
        r12 = r111;
        r18 = r21;
        r7 = r25;
        goto L48
    L20:
        ResultKt.throwOnFailure(r0);
        r12 = r22;
        r9 = r1;
        r13 = r3;
        r14 = 0;
        r6 = r19;
        r7 = r20;
    L7:
        r1 = new RecommendVideoApiRepo$requestWithRetry$1(this, r23);
        goto L8
    }

    @Override // com.larus.bmhome.double_post.fragment.w
    public final Object b(SortScene r20, SortRequestType r21, int r22, List<String> r23, List<String> r24, String r25, String r26, Continuation<? super RecommendVideoData> r27) {
        SortRequestType r10 = r21;
        if ((r27 instanceof RecommendVideoApiRepo$refreshData$1) == false) goto L7;
        RecommendVideoApiRepo$refreshData$1 r1 = (RecommendVideoApiRepo$refreshData$1) r27;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        RecommendVideoApiRepo$refreshData$1 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L34:
        return r0;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        SortRequestType r4 = (SortRequestType) r11.L$0;
        ResultKt.throwOnFailure(r0);
        r10 = r4;
    L27:
        RecommendVideoData r5 = (RecommendVideoData) r0;
        int r6 = this.a;
        if (r5 == null) goto L30;
        List<Content> r7 = r5.getItemLists();
    L31:
        d(r6, r7);
        r11.L$0 = null;
        r11.label = 3;
        r0 = f(r5, r10, r11);
        if (r0 != r12) goto L34;
        return r12;
    L30:
        r7 = null;
        goto L31
    L17:
        ResultKt.throwOnFailure(r0);
    L23:
        return r0;
    L18:
        ResultKt.throwOnFailure(r0);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L24;
        FLogger.a.i("RecommendVideoApiRepo", "refreshData: network is not available");
        r11.label = 1;
        r0 = f(null, r10, r11);
        if (r0 != r12) goto L23;
        return r12;
    L24:
        this.a = 1;
        RecommendVideoApiRepo$refreshData$data$1 r18 = new RecommendVideoApiRepo$refreshData$data$1(r20, r21, this, r23, r24, r25, r26, null);
        r11.L$0 = r10;
        r11.label = 2;
        r0 = e(r22, 5000, r18, r11);
        if (r0 != r12) goto L27;
        return r12;
    L7:
        r1 = new RecommendVideoApiRepo$refreshData$1(this, r27);
        goto L8
    }

    @Override // com.larus.bmhome.double_post.fragment.w
    public final Object c(SortScene r20, SortRequestType r21, int r22, List<String> r23, List<String> r24, String r25, String r26, Continuation<? super RecommendVideoData> r27) {
        if ((r27 instanceof RecommendVideoApiRepo$loadMoreData$1) == false) goto L7;
        RecommendVideoApiRepo$loadMoreData$1 r1 = (RecommendVideoApiRepo$loadMoreData$1) r27;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        RecommendVideoApiRepo$loadMoreData$1 r4 = r1;
        Object r0 = r4.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r4.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L35:
        return r0;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r6 = r4.I$0;
        SortRequestType r7 = (SortRequestType) r4.L$0;
        ResultKt.throwOnFailure(r0);
        Object r8 = r3;
        RecommendVideoApiRepo$loadMoreData$1 r10 = r4;
        List<Content> r9 = null;
    L28:
        RecommendVideoData r11 = (RecommendVideoData) r0;
        if (r11 == null) goto L31;
        List<Content> r13 = r11.getItemLists();
    L32:
        d(r6, r13);
        r10.L$0 = r9;
        r10.label = 3;
        r0 = f(r11, r7, r10);
        if (r0 != r8) goto L35;
        return r8;
    L31:
        r13 = r9;
        goto L32
    L17:
        ResultKt.throwOnFailure(r0);
    L23:
        return r0;
    L18:
        ResultKt.throwOnFailure(r0);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L24;
        FLogger.a.i("RecommendVideoApiRepo", "loadMoreData: network is not available");
        r4.label = 1;
        r0 = f(null, r21, r4);
        if (r0 != r3) goto L23;
        return r3;
    L24:
        int r12 = 1 + this.a;
        this.a = r12;
        RecommendVideoApiRepo$loadMoreData$data$1 r18 = new RecommendVideoApiRepo$loadMoreData$data$1(r20, r21, r12, r23, r24, r25, r26, null);
        r4.L$0 = r21;
        r4.I$0 = r12;
        r4.label = 2;
        r9 = null;
        r8 = r3;
        r10 = r4;
        r0 = e(r22, 5000, r18, r10);
        if (r0 != r8) goto L27;
        return r8;
    L27:
        r7 = r21;
        r6 = r12;
    L7:
        r1 = new RecommendVideoApiRepo$loadMoreData$1(this, r27);
        goto L8
    }
}
