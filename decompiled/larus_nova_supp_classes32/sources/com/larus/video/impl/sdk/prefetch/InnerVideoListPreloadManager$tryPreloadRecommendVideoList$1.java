package com.larus.video.impl.sdk.prefetch;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.sdk.prefetch.InnerVideoListPreloadManager$tryPreloadRecommendVideoList$1", f = "InnerVideoListPreloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InnerVideoListPreloadManager$tryPreloadRecommendVideoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ PrefetchRecommendVideoParam $prefetchRecommendVideoParam;
    int label;
    final /* synthetic */ InnerVideoListPreloadManager this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CachedVideosPreloadFrom.values().length];
            r0[CachedVideosPreloadFrom.REFRESH_VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CachedVideosPreloadFrom.BIND_PULL_API.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public InnerVideoListPreloadManager$tryPreloadRecommendVideoList$1(PrefetchRecommendVideoParam r1, String r2, InnerVideoListPreloadManager r3, Continuation<? super InnerVideoListPreloadManager$tryPreloadRecommendVideoList$1> r4) {
        this.$prefetchRecommendVideoParam = r1;
        this.$messageId = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InnerVideoListPreloadManager$tryPreloadRecommendVideoList$1(this.$prefetchRecommendVideoParam, this.$messageId, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L71;
        ResultKt.throwOnFailure(r12);
        Function0 r13 = this.$prefetchRecommendVideoParam.isLastVideo();
        boolean r0 = true;
        if (r13 == null) goto L7;
        boolean r14 = ((Boolean) r13.invoke()).booleanValue();
    L8:
        if (r14 == true) goto L11;
        Lazy r15 = i1.a;
        g r16 = i1.f(this.$messageId);
        InnerVideoListPreloadManager r1 = this.this$0;
        OuterFallbackInfo r2 = this.$prefetchRecommendVideoParam.getOuterFallbackInfo();
        int r3 = InnerVideoListPreloadManager.q;
        r1.h(r16, r2, "history_message");
        return Unit.INSTANCE;
    L11:
        CachedVideosPreloadFrom r17 = this.$prefetchRecommendVideoParam.getCachedVideosPreloadFrom();
        if (r17 != null) goto L14;
        int r18 = -1;
    L15:
        int r4 = 0;
        if (r18 != 1) goto L18;
        Lazy r19 = i1.a;
        String r110 = this.$messageId;
        Intrinsics.checkNotNullParameter(r110, "messageId");
        ConcurrentHashMap r6 = i1.e();
        if (r6 == null) goto L56;
        i r111 = (i) r6.get(r110);
        if (r111 == null) goto L56;
        int r112 = r111.b;
    L58:
        if (r112 >= ((Number) this.this$0.e.getValue()).intValue()) goto L67;
        InnerVideoListPreloadManager.a(this.this$0, this.$messageId, this.$prefetchRecommendVideoParam);
        String r7 = this.$messageId;
        Intrinsics.checkNotNullParameter(r7, "messageId");
        ConcurrentHashMap r5 = i1.e();
        if (r5 == null) goto L64;
        i r8 = (i) r5.get(r7);
        if (r8 == null) goto L64;
        r4 = r8.b;
    L64:
        if (r5 == null) goto L66;
        i r9 = (i) r5.put(r7, new i(AppHost.a.getAppClock().currentTimeMillis(), Math.min(r4 + 1, 100000)));
    L66:
        i1.l(r5);
        FLogger.a.i("InnerVideoListPreloadManager", "refresh innervideo cache currentRefreshCount：" + r112 + "====maxPrefetchVideoRepeatedCount:" + ((Number) this.this$0.e.getValue()).intValue());
        this.this$0.h(null, this.$prefetchRecommendVideoParam.getOuterFallbackInfo(), "preload last message outer");
    L69:
        return Unit.INSTANCE;
    L67:
        FLogger.a.i("InnerVideoListPreloadManager", "refresh innervideo cache reach max prefetchVideoRepeatedCount");
    L56:
        r112 = 0;
        goto L58
    L18:
        if (r18 != 2) goto L69;
        Lazy r113 = i1.a;
        g r114 = i1.f(this.$messageId);
        String r10 = this.$messageId;
        Intrinsics.checkNotNullParameter(r10, "messageId");
        ConcurrentHashMap r11 = i1.b();
        if (r11 == null) goto L23;
        com.larus.video.impl.sdk.prefetch.a r20 = (com.larus.video.impl.sdk.prefetch.a) r11.get(r10);
    L24:
        if (r20 != null) goto L26;
    L29:
        boolean r21 = true;
    L30:
        String r22 = this.$messageId;
        Intrinsics.checkNotNullParameter(r22, "messageId");
        ConcurrentHashMap r23 = i1.b();
        if (r23 == null) goto L33;
        r23.put(r22, new com.larus.video.impl.sdk.prefetch.a(AppHost.a.getAppClock().currentTimeMillis()));
    L33:
        if (r23 == null) goto L35;
        i1.n(r23);
    L35:
        if (r21 == false) goto L41;
        if (this.$prefetchRecommendVideoParam.getFirstBindPreloadRecommend() == true) goto L41;
        InnerVideoListPreloadManager r115 = this.this$0;
        OuterFallbackInfo r24 = this.$prefetchRecommendVideoParam.getOuterFallbackInfo();
        int r25 = InnerVideoListPreloadManager.q;
        r115.h(null, r24, "refresh_inner");
        return Unit.INSTANCE;
    L41:
        if (r114 != null) goto L43;
        InnerVideoListPreloadManager r116 = this.this$0;
        OuterFallbackInfo r26 = this.$prefetchRecommendVideoParam.getOuterFallbackInfo();
        int r27 = InnerVideoListPreloadManager.q;
        r116.h(null, r26, "preload last message outer");
        FLogger.a.i("InnerVideoListPreloadManager", "messageId:" + this.$messageId + " no cache from pull api directly request cache");
        InnerVideoListPreloadManager.a(this.this$0, this.$messageId, this.$prefetchRecommendVideoParam);
        goto L69
    L43:
        long r28 = Math.abs(r114.d) - AppHost.a.getAppClock().currentTimeMillis();
        InnerVideoListPreloadManager r29 = this.this$0;
        int r30 = InnerVideoListPreloadManager.q;
        if (r28 > ((Number) r29.b.getValue()).intValue()) goto L47;
        r0 = false;
    L47:
        FLogger.a.i("InnerVideoListPreloadManager", "messageId:" + this.$messageId + " judge video Cache  isCacheExpired:" + r0);
        if (r0 == false) goto L50;
        this.this$0.h(null, this.$prefetchRecommendVideoParam.getOuterFallbackInfo(), "preload last message outer");
        InnerVideoListPreloadManager.a(this.this$0, this.$messageId, this.$prefetchRecommendVideoParam);
        goto L69
    L50:
        this.this$0.h(r114, this.$prefetchRecommendVideoParam.getOuterFallbackInfo(), "preload last message outer and disk cache");
        goto L69
    L26:
        if (r20.b == true) goto L29;
        r21 = false;
        goto L30
    L23:
        r20 = null;
        goto L24
    L14:
        r18 = a.a[r17.ordinal()];
        goto L15
    L7:
        r14 = true;
        goto L8
    L71:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
