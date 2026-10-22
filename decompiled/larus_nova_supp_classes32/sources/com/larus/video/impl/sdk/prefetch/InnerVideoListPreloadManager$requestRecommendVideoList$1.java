package com.larus.video.impl.sdk.prefetch;

import android.util.Pair;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.s2;
import com.larus.platform.api.w4;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.douyin.DouYinActivityVideoModel;
import com.larus.video.impl.douyin.RecommendVideos;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.sdk.prefetch.InnerVideoListPreloadManager$requestRecommendVideoList$1", f = "InnerVideoListPreloadManager.kt", i = {}, l = {490}, m = "invokeSuspend", n = {}, s = {})
final class InnerVideoListPreloadManager$requestRecommendVideoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ PrefetchRecommendVideoParam $prefetchRecommendVideoParam;
    int label;
    final /* synthetic */ InnerVideoListPreloadManager this$0;

    public static final class a extends BDNetworkTagContextProviderAdapter {
        public final /* synthetic */ PrefetchRecommendVideoParam a;

        public final int triggerType() {
            if (this.a.getCachedVideosPreloadFrom() != CachedVideosPreloadFrom.BIND_PULL_API) goto L5;
            return 0;
        L5:
            return 1;
        }

        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public a(PrefetchRecommendVideoParam r1) {
            this.a = r1;
        }
    }

    public InnerVideoListPreloadManager$requestRecommendVideoList$1(InnerVideoListPreloadManager r1, PrefetchRecommendVideoParam r2, String r3, Continuation<? super InnerVideoListPreloadManager$requestRecommendVideoList$1> r4) {
        this.this$0 = r1;
        this.$prefetchRecommendVideoParam = r2;
        this.$messageId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InnerVideoListPreloadManager$requestRecommendVideoList$1(this.this$0, this.$prefetchRecommendVideoParam, this.$messageId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r14 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L24:
        com.larus.network.http.y r2 = (com.larus.network.http.a) r1;
        CachedVideosPreloadFrom r3 = this.$prefetchRecommendVideoParam.getCachedVideosPreloadFrom();
        Lazy r4 = i1.a;
        g r5 = i1.f(this.$messageId);
        if (r5 == null) goto L27;
        Integer r6 = Boxing.boxInt(r5.e);
    L28:
        FLogger r7 = FLogger.a;
        r7.i("InnerVideoListPreloadManager", "requestRecommendVideoList====messageId:" + this.$messageId + "==requestFrom:" + r3 + "===cachedDataFrom:" + r6 + "===");
        if (r3 != CachedVideosPreloadFrom.BIND_PULL_API) goto L38;
        int r8 = CachedVideosPreloadFrom.CMD.getValue();
        if (r6 == null) goto L38;
        if (r6.intValue() != r8) goto L38;
        return Unit.INSTANCE;
    L38:
        if ((r2 instanceof com.larus.network.http.y) == false) goto L61;
        RecommendVideos r9 = (RecommendVideos) ((com.larus.network.http.a) r2).b;
        if (r9 == null) goto L44;
        List<String> r10 = r9.getItemIds();
        if (r10 == null) goto L44;
    L45:
        ArrayList r11 = new ArrayList(r10);
        if (r9 == null) goto L50;
        Map<String, String> r12 = r9.getExt();
        if (r12 == null) goto L50;
        r14 = r12.get("req_id");
    L50:
        if (r14 != null) goto L52;
        r14 = NameKeys.UnloadStrategy_No_Strategy;
    L52:
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
        Iterator r16 = r11.iterator();
    L54:
        if (r16.hasNext() == false) goto L56;
        Object r18 = r16.next();
        String r19 = (String) r18;
        r15.put(r18, r14);
        goto L54
    L56:
        long r20 = AppHost.a.getAppClock().currentTimeMillis();
        CachedVideosPreloadFrom r21 = this.$prefetchRecommendVideoParam.getCachedVideosPreloadFrom();
        if (r21 != null) goto L59;
        r21 = CachedVideosPreloadFrom.DEFAULT;
    L59:
        CachedVideosPreloadFrom r22 = r21;
        InnerVideoListPreloadManager r23 = this.this$0;
        String r24 = this.$messageId;
        int r25 = InnerVideoListPreloadManager.q;
        r23.i(r20, r24, r11, r15, r22);
    L64:
        return Unit.INSTANCE;
    L44:
        r10 = CollectionsKt.emptyList();
        goto L45
    L61:
        if ((r2 instanceof com.larus.network.http.f) == false) goto L64;
        r7.e("InnerVideoListPreloadManager", "requestRecommendVideoList fail:" + ((com.larus.network.http.f) r2).d);
        i1.q(this.$messageId, new w4(s2.a(this.$prefetchRecommendVideoParam.getCachedVideosPreloadFrom()).getValue(), AppHost.a.getAppClock().currentTimeMillis(), 0));
        goto L64
    L27:
        r6 = null;
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        Pair r26 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(this.$prefetchRecommendVideoParam));
        InnerVideoListPreloadManager r27 = this.this$0;
        PrefetchRecommendVideoParam r28 = this.$prefetchRecommendVideoParam;
        String r29 = this.$messageId;
        int r30 = InnerVideoListPreloadManager.q;
        r27.getClass();
        JSONObject r31 = new JSONObject();
        String r32 = r28.getReplyId();
        if (r32 == null) goto L11;
        Long r33 = StringsKt.toLongOrNull(r32);
    L12:
        r31.put("question_id", r33);
        r31.put("answer_id", StringsKt.toLongOrNull(r29));
        List r34 = r28.getReplyItemIds();
        if (r34 == null) goto L15;
        List r35 = CollectionsKt.filterNotNull(r34);
    L16:
        r31.put("reply_item_ids", new JSONArray(r35));
        r31.put("page_index", 1);
        r31.put("click_index", r28.getClickIndex());
        r31.put("playlist_item_ids", (JSONArray) r27.n.getValue());
        r31.put("playlist_playtime", (JSONObject) r27.p.getValue());
        List r36 = r28.getQuery();
        if (r36 == null) goto L21;
        List r37 = r36;
        if ((!r37.isEmpty()) == false) goto L21;
        r31.put("query", new JSONArray(r37));
    L21:
        HashMap r38 = new HashMap();
        r38.put(r26.first, r26.second);
        Unit r39 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Basic", RecommendVideos.class, DouYinActivityVideoModel.LOAD_MORE_PATH_FOR_RECOMMEND, r31, null, r38, false, null, null, null, this, 976);
        if (r1 != r13) goto L24;
        return r13;
    L15:
        r35 = null;
        goto L16
    L11:
        r33 = null;
        goto L12
    }
}
