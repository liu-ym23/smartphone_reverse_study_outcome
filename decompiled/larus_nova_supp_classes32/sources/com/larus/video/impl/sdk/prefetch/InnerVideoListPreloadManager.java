package com.larus.video.impl.sdk.prefetch;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.PrefetchVideoProcessStage;
import com.larus.platform.api.s2;
import com.larus.platform.api.w4;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class InnerVideoListPreloadManager {
    public static final /* synthetic */ int q = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final ExecutorCoroutineDispatcher k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CachedVideosPreloadFrom.values().length];
            r0[CachedVideosPreloadFrom.CMD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CachedVideosPreloadFrom.UN_CONSUMED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final nr9.d c() {
        return (nr9.d) this.a.getValue();
    }

    public final int d() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final int e() {
        return ((Number) this.h.getValue()).intValue();
    }

    public InnerVideoListPreloadManager() {
        this.a = LazyKt.lazy(new l());
        this.b = LazyKt.lazy(new y(this));
        this.c = LazyKt.lazy(new z(this));
        this.d = LazyKt.lazy(new a0(this));
        this.e = LazyKt.lazy(new m(this));
        this.f = LazyKt.lazy(new n(this));
        this.g = LazyKt.lazy(new o(this));
        this.h = LazyKt.lazy(new p(this));
        this.i = LazyKt.lazy(new q(this));
        this.j = LazyKt.lazy(new r(this));
        this.k = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new s()));
        this.l = LazyKt.lazy(new t(this));
        this.m = LazyKt.lazy(new u());
        this.n = LazyKt.lazy(new v());
        this.o = LazyKt.lazy(new w(this));
        this.p = LazyKt.lazy(new x(this));
    }

    public final Pair<List<String>, Boolean> g(List<String> r3) {
        if (r3.isEmpty() == true) goto L5;
        int r0 = Math.min(e(), r3.size());
        if (r0 == (-1)) goto L11;
        r3 = b0.a(r3, 0, r0);
    L11:
        return TuplesKt.to(r3, Boolean.FALSE);
    L5:
        return TuplesKt.to(CollectionsKt.emptyList(), Boolean.FALSE);
    }

    public final void j(PrefetchRecommendVideoParam r10) {
        Intrinsics.checkNotNullParameter(r10, "prefetchRecommendVideoParam");
        String r0 = r10.getMessageId();
        if (r0 != null) goto L6;
        h(null, r10.getOuterFallbackInfo(), "default1");
        return;
    L6:
        AppHost.Companion r2 = AppHost.a;
        if (r2.isPlugin() == false) goto L9;
    L17:
        h(null, r10.getOuterFallbackInfo(), "default3");
        return;
    L9:
        if (r2.isOversea() == true) goto L17;
        if (Intrinsics.areEqual(r10.getEnableVideoRecommend(), Boolean.TRUE) == true) goto L15;
        h(null, r10.getOuterFallbackInfo(), "default4");
        return;
    L15:
        BuildersKt.launch$default((CoroutineScope) this.l.getValue(), null, null, new InnerVideoListPreloadManager$tryPreloadRecommendVideoList$1(r10, r0, this, null), 3, null);
    }

    public final void b(boolean r7, String r8) {
        FLogger.a.i("InnerVideoListPreloadManager", "clearExpireCache, lastMessageId: " + r8);
        if (r7 == false) goto L5;
        BuildersKt.launch$default((CoroutineScope) this.l.getValue(), null, null, new InnerVideoListPreloadManager$clearExpireCache$1(r8, null), 3, null);
        return;
    L5:
        i1.r(r8);
    }

    public static final void a(InnerVideoListPreloadManager r7, String r8, PrefetchRecommendVideoParam r9) {
        BuildersKt.launch$default((CoroutineScope) r7.l.getValue(), null, null, new InnerVideoListPreloadManager$requestRecommendVideoList$1(r7, r9, r8, null), 3, null);
    }

    public final void h(g r9, OuterFallbackInfo r10, String r11) {
        if (r9 == null) goto L7;
        int r0 = r9.e;
        CachedVideosPreloadFrom.Companion.getClass();
        CachedVideosPreloadFrom r1 = (CachedVideosPreloadFrom) CachedVideosPreloadFrom.access$getMap$cp().get(Integer.valueOf(r0));
        if (r1 != null) goto L6;
        r1 = CachedVideosPreloadFrom.DEFAULT;
    L6:
        if (r1 == null) goto L7;
    L8:
        List r2 = null;
        if (r9 == null) goto L11;
        List r12 = r9.c;
    L12:
        if (r12 != null) goto L14;
        r12 = CollectionsKt.emptyList();
    L14:
        int r3 = b.a[r1.ordinal()];
        if (r3 != 1) goto L17;
    L26:
        List r13 = r12;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r14 = r13.iterator();
    L28:
        if (r14.hasNext() == false) goto L30;
        r4.add(new pr9.a((String) r14.next(), false, 14));
    L30:
        if (r10 == null) goto L32;
        r2 = r10.getOuterFallbackVideoItems();
    L32:
        if (r2 != null) goto L34;
        r2 = CollectionsKt.emptyList();
    L34:
        if (r10 == null) goto L36;
        int r15 = r10.getOuterShowCount();
    L37:
        int r16 = RangesKt.coerceAtLeast(r15 + 1, 0);
        List r17 = b0.a(r2, 0, r16);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r18 = r17.iterator();
    L39:
        if (r18.hasNext() == false) goto L47;
        String r6 = (String) r18.next();
        if (r6 != null) goto L43;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L43:
        pr9.a r7 = new pr9.a(r6, false, 14);
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L46;
        r7.d = true;
    L46:
        r5.add(r7);
        goto L39
    L47:
        FLogger.a.d("InnerVideoListPreloadManager", "enablePreloadMergeOptimize：" + ((Boolean) this.j.getValue()).booleanValue() + "\npreloadSource from:" + r11 + " \ninnerModels:size:" + r4.size() + "  innerModels: " + r4 + "\nouterModels:size:" + r5.size() + "  outerModels: " + r5 + "\nouterFallbackInfo?.outerShowCount:" + r16);
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L56;
        List r19 = CollectionsKt.plus(r4, r5);
        if (r19.isEmpty() == false) goto L52;
        return;
    L52:
        qr9.c r110 = VideoFeedProviderDelegate.b.b();
        if (r110 == null) goto L73;
        r110.b(r19);
        return;
    L73:
        return;
    L56:
        if (r4.isEmpty() == false) goto L58;
        return;
    L58:
        VideoFeedProviderDelegate r20 = VideoFeedProviderDelegate.b;
        qr9.c r111 = r20.b();
        if (r111 == null) goto L62;
        r111.b(r4);
    L62:
        if (r5.isEmpty() == false) goto L64;
        return;
    L64:
        qr9.c r21 = r20.b();
        if (r21 == null) goto L75;
        r21.b(r5);
        return;
    L75:
        return;
    L36:
        r15 = 0;
        goto L37
    L17:
        if (r3 == 2) goto L26;
        List r8 = r12;
        if (d() != (-1)) goto L21;
        int r22 = r12.size();
    L22:
        List r23 = CollectionsKt.take(r8, r22);
        r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r24 = r23.iterator();
    L24:
        if (r24.hasNext() == false) goto L30;
        r4.add(new pr9.a((String) r24.next(), false, 14));
        goto L24
    L21:
        r22 = RangesKt.coerceAtLeast(d(), 0);
        goto L22
    L11:
        r12 = null;
    L7:
        r1 = CachedVideosPreloadFrom.CMD;
        goto L8
    }

    public final void i(long r15, String r17, List<String> r18, Map<String, String> r19, CachedVideosPreloadFrom r20) {
        ArrayList r3 = new ArrayList();
        List<String> r0 = r18;
        r3.addAll(r0);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("saveCacheVideoItems messageId:");
        r2.append(r17);
        r2.append("=====newItemIdList.isNotEmpty():");
        r2.append(!r0.isEmpty());
        r2.append("======dataFrom:");
        r2.append(r20);
        r1.i("InnerVideoListPreloadManager", r2.toString());
        if ((!r0.isEmpty()) == false) goto L5;
        g r13 = new g(r17, r19, r3, r15, r20.getValue(), null, null, 224);
        i1.k(r13);
        h(r13, null, "preload saved disk cache");
        i1.q(r17, new w4(s2.a(r20).getValue(), AppHost.a.getAppClock().currentTimeMillis(), 1));
        return;
    L5:
        Lazy r4 = i1.a;
        i1.q(r17, new w4(s2.a(r20).getValue(), AppHost.a.getAppClock().currentTimeMillis(), 0));
    }

    public final void k(String r16, String r17, String r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, g r24) {
        Lazy r2 = i1.a;
        Intrinsics.checkNotNullParameter(r16, "messageId");
        ConcurrentHashMap r3 = i1.j();
        if (r3 == null) goto L5;
        w4 r4 = (w4) r3.get(r16);
    L7:
        if (r20 == false) goto L9;
        String r5 = PrefetchVideoProcessStage.FILTERED.getValue();
    L22:
        String r11 = r5;
    L23:
        if (r24 != null) goto L26;
        f(r16, r17, r18, r19, false, r22, r23, 0, r23, null, r11);
        return;
    L26:
        AppHost.Companion r6 = AppHost.a;
        long r7 = Math.abs(r6.getAppClock().currentTimeMillis() - r24.d);
        if (r21 == false) goto L29;
        Integer r10 = Integer.valueOf(r24.e);
    L30:
        if (r21 == false) goto L33;
        r11 = null;
    L33:
        if (Math.abs(r6.getAppClock().currentTimeMillis() - r24.d) <= ((Number) this.b.getValue()).intValue()) goto L35;
        boolean r1 = true;
    L36:
        if (r23 == false) goto L39;
        if (r1 == false) goto L39;
        boolean r8 = true;
    L40:
        f(r16, r17, r18, r19, r21, r22, r8, r7, r23, r10, r11);
        return;
    L39:
        r8 = false;
        goto L40
    L35:
        r1 = false;
        goto L36
    L29:
        r10 = null;
        goto L30
    L9:
        if (r24 == null) goto L12;
        if (r21 == false) goto L12;
        r11 = null;
    L12:
        if (r4 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == false) goto L19;
        r5 = PrefetchVideoProcessStage.EXCEPTION.getValue();
        goto L22
    L19:
        if (r4 == null) goto L21;
        r5 = r4.a;
        goto L22
    L21:
        r5 = PrefetchVideoProcessStage.CMD_INIT.getValue();
        goto L22
    L14:
        if (r4.c != 1) goto L16;
        r9 = true;
        goto L17
    L5:
        r4 = null;
        goto L7
    }

    public static void f(String r3, String r4, String r5, String r6, boolean r7, boolean r8, boolean r9, long r10, boolean r12, Integer r13, String r14) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("message_id", r3);
        r1.put("agent_id", r4);
        r1.put("hit_video_cache", r7 ? 1 : 0);
        r1.put("is_first_click_item", r8 ? 1 : 0);
        r1.put("is_enable_preload", 1);
        r1.put("distance_preload_duration", r10);
        r1.put("exceed_cache_time", r9 ? 1 : 0);
        r1.put("is_last_message", r12 ? 1 : 0);
        if (r5 == null) goto L5;
        r1.put("biz_scene", r5);
    L5:
        if (r6 == null) goto L7;
        r1.put("bot_id", r6);
    L7:
        if (r13 == null) goto L9;
        r1.put("cache_hit_type", r13.intValue());
    L9:
        if (r14 == null) goto L11;
        r1.put("cache_miss_reason", r14);
    L11:
        Unit r11 = Unit.INSTANCE;
        r0.reportEvent("get_video_preload_cache", r1);
    }
}
