package com.larus.video.impl.sdk.prefetch;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.PrefetchVideoProcessStage;
import com.larus.platform.api.s2;
import com.larus.platform.api.w4;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l0 {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final ExecutorCoroutineDispatcher h;
    public final Lazy i;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CachedVideosPreloadFrom.values().length];
            r0[CachedVideosPreloadFrom.CMD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CachedVideosPreloadFrom.UN_CONSUMED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CachedVideosPreloadFrom.UNLIMITED_FLOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final nr9.d a() {
        return (nr9.d) this.a.getValue();
    }

    public l0() {
        this.a = LazyKt.lazy(new c0());
        this.b = LazyKt.lazy(new d0(this));
        this.c = LazyKt.lazy(new e0(this));
        this.d = LazyKt.lazy(new f0(this));
        this.e = LazyKt.lazy(new g0(this));
        this.f = LazyKt.lazy(new h0(this));
        this.g = LazyKt.lazy(new i0(this));
        this.h = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new j0()));
        this.i = LazyKt.lazy(new k0(this));
    }

    public final Pair<List<String>, Boolean> c(List<String> r3) {
        if (r3.isEmpty() == true) goto L5;
        int r0 = Math.min(((Number) this.g.getValue()).intValue(), r3.size());
        if (r0 == (-1)) goto L11;
        r3 = b0.a(r3, 0, r0);
    L11:
        return TuplesKt.to(r3, Boolean.FALSE);
    L5:
        return TuplesKt.to(CollectionsKt.emptyList(), Boolean.FALSE);
    }

    public static void d(long r14, String r16, Integer r17, List r18, Map r19, CachedVideosPreloadFrom r20, Map r21) {
        ArrayList r3 = new ArrayList();
        List r0 = r18;
        r3.addAll(r0);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("saveCacheVideoItems messageId:");
        r2.append(w0.f(r16, r17));
        r2.append("=====newItemIdList.isNotEmpty():");
        r2.append(!r0.isEmpty());
        r2.append("======dataFrom:");
        r2.append(r20);
        r1.i("RelatedVideoFlowPreloadManager", r2.toString());
        if ((!r0.isEmpty()) == false) goto L12;
        w0.k(new g(r16, r19, r3, r14, r20.getValue(), r17, r21, 32));
        List r4 = r18;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r5.add(new pr9.a((String) r6.next(), false, 14));
        goto L6
    L8:
        qr9.c r7 = VideoFeedProviderDelegate.b.b();
        if (r7 == null) goto L11;
        r7.b(r5);
    L11:
        w0.o(w0.f(r16, r17), new w4(s2.a(r20).getValue(), AppHost.a.getAppClock().currentTimeMillis(), 1));
        return;
    L12:
        w0.o(w0.f(r16, r17), new w4(s2.a(r20).getValue(), AppHost.a.getAppClock().currentTimeMillis(), 0));
    }

    public final void e(String r19, Integer r20, String r21, String r22, String r23, boolean r24, boolean r25, boolean r26, boolean r27, g r28) {
        String r1 = w0.f(r19, r20);
        Intrinsics.checkNotNullParameter(r1, "messageId");
        ConcurrentHashMap r2 = w0.j();
        if (r2 == null) goto L5;
        w4 r3 = (w4) r2.get(r1);
    L7:
        if (r24 == false) goto L9;
        String r4 = PrefetchVideoProcessStage.FILTERED.getValue();
    L22:
        String r17 = r4;
    L23:
        if (r28 != null) goto L26;
        b(r19, r20, r21, r22, r23, false, r26, true, 0, r27, null, r17);
        return;
    L26:
        AppHost.Companion r5 = AppHost.a;
        long r8 = Math.abs(r5.getAppClock().currentTimeMillis() - r28.d);
        if (r25 == false) goto L29;
        Integer r11 = Integer.valueOf(r28.e);
    L30:
        if (r25 == false) goto L32;
        String r12 = null;
    L34:
        if (Math.abs(r5.getAppClock().currentTimeMillis() - r28.d) <= ((Number) this.b.getValue()).intValue()) goto L36;
        boolean r7 = true;
    L37:
        b(r19, r20, r21, r22, r23, r25, r26, r7, r8, r27, r11, r12);
        return;
    L36:
        r7 = false;
        goto L37
    L32:
        r12 = r17;
        goto L34
    L29:
        r11 = null;
        goto L30
    L9:
        if (r28 == null) goto L12;
        if (r25 == false) goto L12;
        r17 = null;
    L12:
        if (r3 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L19;
        r4 = PrefetchVideoProcessStage.EXCEPTION.getValue();
        goto L22
    L19:
        if (r3 == null) goto L21;
        r4 = r3.a;
        goto L22
    L21:
        r4 = PrefetchVideoProcessStage.CMD_INIT.getValue();
        goto L22
    L14:
        if (r3.c != 1) goto L16;
        r6 = true;
        goto L17
    L5:
        r3 = null;
        goto L7
    }

    public static void b(String r3, Integer r4, String r5, String r6, String r7, boolean r8, boolean r9, boolean r10, long r11, boolean r13, Integer r14, String r15) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("message_id", r3);
        r1.put("agent_id", r5);
        r1.put("hit_video_cache", r8 ? 1 : 0);
        r1.put("is_first_click_item", r9 ? 1 : 0);
        r1.put("is_enable_preload", 1);
        r1.put("distance_preload_duration", r11);
        r1.put("exceed_cache_time", r10 ? 1 : 0);
        r1.put("is_last_message", r13 ? 1 : 0);
        if (r6 == null) goto L5;
        r1.put("biz_scene", r6);
    L5:
        if (r7 == null) goto L7;
        r1.put("bot_id", r7);
    L7:
        if (r14 == null) goto L9;
        r1.put("cache_hit_type", r14.intValue());
    L9:
        if (r15 == null) goto L11;
        r1.put("cache_miss_reason", r15);
    L11:
        if (r4 == null) goto L13;
        r1.put("impr_index", r4.intValue());
    L13:
        Unit r12 = Unit.INSTANCE;
        r0.reportEvent("get_video_preload_cache", r1);
    }
}
