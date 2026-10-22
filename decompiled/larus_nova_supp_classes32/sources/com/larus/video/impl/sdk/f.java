package com.larus.video.impl.sdk;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.ItemSourceApp;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.api.v;
import com.larus.platform.api.v4;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.douyin.DouYinArticleActivity;
import com.larus.video.impl.sdk.prefetch.InnerVideoListPreloadManager;
import com.larus.video.impl.sdk.prefetch.b0;
import com.larus.video.impl.sdk.prefetch.i1;
import com.larus.video.impl.sdk.prefetch.l0;
import com.larus.video.impl.sdk.prefetch.w0;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements r2 {
    public static final f a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final List<String> d = null;

    public f() {
    }

    public final void c(List r2) {
        Intrinsics.checkNotNullParameter(r2, "videoIds");
    }

    public final void l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final Object n(List r1) {
        return r1;
    }

    static {
        a = new f();
        b = LazyKt.lazy(new b());
        c = LazyKt.lazy(new c());
        d = CollectionsKt.listOf("aweme://flow");
    }

    public static InnerVideoListPreloadManager s() {
        return (InnerVideoListPreloadManager) b.getValue();
    }

    public static l0 t() {
        return (l0) c.getValue();
    }

    public final int q() {
        return ((Number) s().i.getValue()).intValue();
    }

    public final String f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        t().getClass();
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Lazy r1 = w0.a;
        Intrinsics.checkNotNullParameter(r3, "messageId");
        ConcurrentHashMap r0 = w0.c();
        if (r0 == null) goto L5;
        com.larus.video.impl.sdk.prefetch.d r4 = (com.larus.video.impl.sdk.prefetch.d) r0.get(r3);
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.b;
    L5:
        r4 = null;
        goto L6
    }

    public final void g(PrefetchRecommendVideoParam r4) {
        Intrinsics.checkNotNullParameter(r4, "prefetchRecommendVideoParam");
        s().b(true, r4.getLastVideoMessageId());
        s().j(r4);
    }

    public final boolean i(String r3) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        t().getClass();
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Lazy r1 = w0.a;
        Intrinsics.checkNotNullParameter(r3, "messageId");
        ConcurrentHashMap r0 = w0.b();
        if (r0 == null) goto L5;
        com.larus.video.impl.sdk.prefetch.a r4 = (com.larus.video.impl.sdk.prefetch.a) r0.get(r3);
    L6:
        if (r4 != null) goto L8;
    L11:
        return true;
    L8:
        if (r4.b == true) goto L11;
        return false;
    L5:
        r4 = null;
        goto L6
    }

    public final boolean j(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.URI_KEY);
        if (d.contains(r4.getScheme() + "://" + r4.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r4.getPath(), "/downloadAPP") == false) goto L7;
        return true;
    }

    public final void k(String r5) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        t().getClass();
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Lazy r1 = w0.a;
        Intrinsics.checkNotNullParameter(r5, "messageId");
        ConcurrentHashMap r0 = w0.b();
        if (r0 == null) goto L5;
        r0.put(r5, new com.larus.video.impl.sdk.prefetch.a(AppHost.a.getAppClock().currentTimeMillis()));
    L5:
        if (r0 == null) goto L8;
        w0.l(r0);
        return;
    }

    public final void a(Context r6, Uri r7) {
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.URI_KEY);
    L7:
        e = move-exception;
        FLogger.a.i("HolderHandlerImpl", "e:" + e.getMessage());
        return;
    L4:
        if (StringsKt.startsWith$default(r7.toString(), "aweme://flow/downloadAPP", false, 2, null) == false) goto L12;
        com.bytedance.router.i r8 = SmartRouter.buildRoute(r6, "//flow/chat_page");     // Catch: Exception -> L7
        r8.d = 2130772401;     // Catch: Exception -> L7
        r8.e = 2130772399;     // Catch: Exception -> L7
        r8.d();     // Catch: Exception -> L7
        FLogger.a.i("HolderHandlerImpl", "diversion");     // Catch: Exception -> L7
        return;
    }

    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "contentListJsonStr");
        if (r3 != null) goto L5;
        return;
    L5:
        t().getClass();
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "contentListJsonStr");
        com.larus.video.impl.sdk.prefetch.d r0 = new com.larus.video.impl.sdk.prefetch.d(r3, r4);
        Lazy r5 = w0.a;
        Intrinsics.checkNotNullParameter(r0, "cachedFirstScreenData");
        ConcurrentHashMap r6 = w0.c();
        if (r6 == null) goto L8;
        r6.put(r0.a, r0);
    L8:
        if (r6 == null) goto L11;
        com.larus.video.impl.sdk.prefetch.e r7 = new com.larus.video.impl.sdk.prefetch.e(r6);
        String r8 = GsonProtectorUtils.toJson(w0.g(), r7, com.larus.video.impl.sdk.prefetch.e.class);
        w0.h().storeString("user_first_screen_data_refine", r8);
        return;
    }

    public final v4 d(v r44, boolean r45) {
        Intrinsics.checkNotNullParameter(r44, "getCachedVideoItemsParams");
        if (r45 == false) goto L208;
        t().getClass();
        w0.p();
        l0 r13 = t();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r44, "getCachedVideoItemsParams");
        String r14 = r44.a;
        Boolean r1 = r44.b;
        if (r1 == null) goto L7;
        boolean r22 = r1.booleanValue();
    L8:
        Intrinsics.checkNotNullParameter(r14, "messageId");
        ConcurrentHashMap r2 = w0.d();
        if (r2 == null) goto L13;
        com.larus.video.impl.sdk.prefetch.c r3 = (com.larus.video.impl.sdk.prefetch.c) r2.get(r14);
        if (r3 == null) goto L13;
        boolean r21 = r3.b;
    L14:
        Intrinsics.checkNotNullParameter(r14, "messageId");
        ConcurrentHashMap r4 = w0.d();
        if (r4 == null) goto L17;
        com.larus.video.impl.sdk.prefetch.c r5 = (com.larus.video.impl.sdk.prefetch.c) r4.put(r14, new com.larus.video.impl.sdk.prefetch.c(AppHost.a.getAppClock().currentTimeMillis()));
    L17:
        w0.m(r4);
        if (Intrinsics.areEqual(r44.b, Boolean.TRUE) == false) goto L34;
        String r6 = r44.a;
        Integer r7 = r44.l;
        Intrinsics.checkNotNullParameter(r6, "messageId");
        ConcurrentHashMap<String, com.larus.video.impl.sdk.prefetch.g> r8 = w0.h;
        if (r8 == null) goto L23;
        com.larus.video.impl.sdk.prefetch.g r9 = r8.get(w0.f(r6, r7));
    L24:
        ConcurrentHashMap<String, com.larus.video.impl.sdk.prefetch.g> r12 = w0.h;
        if (r12 == null) goto L27;
        com.larus.video.impl.sdk.prefetch.g r10 = r12.remove(w0.f(r6, r7));
    L27:
        if (r9 == null) goto L31;
        List r11 = r9.c;
        if (r11 == null) goto L31;
    L33:
        if (r11.isEmpty() == true) goto L34;
        if (r9 == null) goto L40;
        Map<String, String> r15 = r9.b;
        if (r15 == null) goto L40;
        Map<String, String> r26 = r15;
    L48:
        String r16 = r44.a;
        ArrayList r17 = new ArrayList(r11);
        long r28 = AppHost.a.getAppClock().currentTimeMillis();
        int r30 = CachedVideosPreloadFrom.UNLIMITED_FLOW.getValue();
        if (r9 == null) goto L51;
        Integer r31 = r9.g;
    L52:
        if (r9 == null) goto L54;
        Map<String, String> r32 = r9.h;
    L55:
        com.larus.video.impl.sdk.prefetch.g r18 = new com.larus.video.impl.sdk.prefetch.g(r16, r26, r17, r28, r30, r31, r32, 32);
    L57:
        if (((Number) r13.g.getValue()).intValue() <= 0) goto L96;
        List r19 = r44.h;
        if (r19 != null) goto L62;
    L65:
        boolean r20 = true;
    L66:
        if (r20 == true) goto L96;
        List r23 = r44.h;
        if (r23 != null) goto L71;
    L73:
        boolean r24 = false;
    L74:
        if (r24 == false) goto L76;
        List r25 = CollectionsKt.emptyList();
    L95:
        if (r25.isEmpty() == true) goto L96;
        List r27 = r25;
        LinkedHashMap r29 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r27, 10)), 16));
        Iterator r33 = r27.iterator();
    L99:
        if (r33.hasNext() == false) goto L104;
        Object r34 = r33.next();
        String r35 = (String) r34;
        String r36 = r44.c;
        if (r36 != null) goto L103;
        r36 = NameKeys.UnloadStrategy_No_Strategy;
    L103:
        r29.put(r34, r36);
        goto L99
    L104:
        String r37 = r44.a;
        ArrayList r38 = new ArrayList(r25);
        long r210 = AppHost.a.getAppClock().currentTimeMillis();
        int r39 = CachedVideosPreloadFrom.OUTER_FALLBACK.getValue();
        Integer r40 = r44.l;
        HashMap r41 = r44.m;
        if (r41 == null) goto L114;
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r42 = r41.entrySet().iterator();
    L108:
        if (r42.hasNext() == false) goto L113;
        Map.Entry r111 = (Map.Entry) r42.next();
        if (r25.contains(r111.getKey()) == false) goto L108;
        r110.put(r111.getKey(), r111.getValue());
        goto L108
    L113:
        LinkedHashMap r310 = r110;
    L115:
        com.larus.video.impl.sdk.prefetch.g r43 = new com.larus.video.impl.sdk.prefetch.g(r37, r29, r38, r210, r39, r40, r310, 32);
    L117:
        if (r18 == null) goto L119;
        FLogger.a.i("RelatedVideoFlowPreloadManager", "getPreloadRecommendVideoListFromUserClick form flow cache fallback:" + r18);
    L127:
        FLogger.a.i("RelatedVideoFlowPreloadManager", "getPreloadRecommendVideoListFromUserClick cachedVideoData:" + r18);
        if (r18 != null) goto L130;
    L206:
        r13.e(r14, r44.l, r44.f, r44.i, r44.j, false, false, r21, r22, r18);
        return null;
    L130:
        if (r18.c.isEmpty() == true) goto L206;
        if (Math.abs(AppHost.a.getAppClock().currentTimeMillis() - r18.d) <= ((Number) r13.b.getValue()).intValue()) goto L134;
        boolean r46 = true;
    L135:
        if (r46 == true) goto L206;
        int r47 = r18.e;
        if (r47 == CachedVideosPreloadFrom.CMD.getValue()) goto L175;
        if (r47 == CachedVideosPreloadFrom.BIND_PULL_API.getValue()) goto L175;
        if (r47 == CachedVideosPreloadFrom.REFRESH_VIDEO.getValue()) goto L175;
        if (r47 != CachedVideosPreloadFrom.OUTER_FALLBACK.getValue()) goto L148;
        Pair<List<String>, Boolean> r48 = r13.c(r18.c);
    L198:
        List r49 = (List) r48.component1();
        boolean r50 = ((Boolean) r48.component2()).booleanValue();
        if (r49.isEmpty() == false) goto L204;
        if ((!r18.c.isEmpty()) == false) goto L204;
        boolean r112 = true;
    L205:
        List r51 = r49;
        r13.e(r14, r44.l, r44.f, r44.i, r44.j, r112, !r51.isEmpty(), r21, r22, r18);
        return new v4(r18.b, new ArrayList(r51), r50, r18.h);
    L204:
        r112 = false;
        goto L205
    L148:
        if (r47 == CachedVideosPreloadFrom.UN_CONSUMED.getValue()) goto L154;
        if (r47 == CachedVideosPreloadFrom.UNLIMITED_FLOW.getValue()) goto L154;
        r48 = TuplesKt.to(CollectionsKt.emptyList(), Boolean.FALSE);
    L154:
        if (r18.f == false) goto L156;
        int r52 = ((Number) r13.d.getValue()).intValue();
    L157:
        int r53 = Math.min(Math.min(r52, ((Number) r13.f.getValue()).intValue()), r18.c.size());
        List r54 = r18.c;
        if (r53 == (-1)) goto L162;
        r54 = b0.a(r54, 0, r53);
    L162:
        if (r54.size() <= ((Number) r13.e.getValue()).intValue()) goto L164;
        boolean r55 = true;
    L165:
        Pair<List<String>, Boolean> r56 = TuplesKt.to(r54, Boolean.valueOf(r55));
        if ((!((Collection) r56.getFirst()).isEmpty()) == true) goto L191;
        if (r43 == null) goto L172;
        List<String> r57 = r43.c;
        if (r57 == null) goto L172;
    L173:
        r48 = r13.c(r57);
    L172:
        r57 = CollectionsKt.emptyList();
    L191:
        r48 = r56;
        goto L198
    L164:
        r55 = false;
        goto L165
    L156:
        r52 = ((Number) r13.c.getValue()).intValue();
    L175:
        if (r18.f == true) goto L177;
        int r58 = ((Number) r13.c.getValue()).intValue();
    L181:
        int r59 = Math.min(r58, r18.c.size());
        List r60 = r18.c;
        if (r59 == (-1)) goto L186;
        r60 = b0.a(r60, 0, r59);
    L186:
        if (r60.size() <= ((Number) r13.e.getValue()).intValue()) goto L188;
        boolean r61 = true;
    L189:
        r56 = TuplesKt.to(r60, Boolean.valueOf(r61));
        if ((!((Collection) r56.getFirst()).isEmpty()) == true) goto L191;
        if (r43 == null) goto L196;
        List<String> r62 = r43.c;
        if (r62 == null) goto L196;
    L197:
        r48 = r13.c(r62);
    L196:
        r62 = CollectionsKt.emptyList();
        goto L197
    L188:
        r61 = false;
        goto L189
    L177:
        if (((Number) r13.d.getValue()).intValue() != (-1)) goto L179;
        r58 = r18.c.size();
        goto L181
    L179:
        r58 = ((Number) r13.d.getValue()).intValue();
        goto L181
    L134:
        r46 = false;
        goto L135
    L119:
        Lazy r63 = w0.a;
        Integer r64 = r44.l;
        Intrinsics.checkNotNullParameter(r14, "messageId");
        ConcurrentHashMap r65 = w0.a();
        if (r65 == null) goto L122;
        r18 = (com.larus.video.impl.sdk.prefetch.g) r65.get(w0.f(r14, r64));
    L123:
        FLogger r66 = FLogger.a;
        r66.i("RelatedVideoFlowPreloadManager", "getPreloadRecommendVideoListFromUserClick, " + w0.f(r14, r44.l) + " diskCachedVideoData:" + r18);
        if (r18 == null) goto L126;
        w0.k(com.larus.video.impl.sdk.prefetch.g.a(r18));
        goto L127
    L126:
        r66.i("RelatedVideoFlowPreloadManager", "getPreloadRecommendVideoListFromUserClick form fallback:" + r43);
        r18 = r43;
        goto L127
    L122:
        r18 = null;
        goto L123
    L114:
        r310 = null;
        goto L115
    L76:
        int r67 = r44.d;
        int r68 = r44.e;
        List r69 = r44.h;
        if (r69 != null) goto L80;
        r25 = CollectionsKt.emptyList();
        goto L95
    L80:
        if (r69.size() > r67) goto L83;
        r67 = (r68 + 1) % r69.size();
    L83:
        int r70 = RangesKt.coerceAtMost(((Number) r13.g.getValue()).intValue() + r67, r69.size());
        if (r67 >= r69.size()) goto L86;
        List r71 = r69.subList(r67, r70);
    L87:
        ArrayList r72 = new ArrayList();
        Iterator r73 = r71.iterator();
    L89:
        if (r73.hasNext() == false) goto L93;
        Object r74 = r73.next();
        if ((!Intrinsics.areEqual((String) r74, r44.g)) == false) goto L89;
        r72.add(r74);
        goto L89
    L93:
        r25 = r72;
        goto L95
    L86:
        r71 = CollectionsKt.emptyList();
        goto L87
    L71:
        if (r23.size() != 1) goto L73;
        r24 = true;
        goto L74
    L62:
        if (r19.isEmpty() == true) goto L65;
        r20 = false;
    L96:
        r43 = null;
        goto L117
    L54:
        r32 = null;
        goto L55
    L51:
        r31 = null;
    L40:
        List r75 = r11;
        LinkedHashMap r113 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r75, 10)), 16));
        Iterator r76 = r75.iterator();
    L42:
        if (r76.hasNext() == false) goto L47;
        Object r114 = r76.next();
        String r115 = (String) r114;
        String r77 = r44.c;
        if (r77 != null) goto L46;
        r77 = NameKeys.UnloadStrategy_No_Strategy;
    L46:
        r113.put(r114, r77);
        goto L42
    L47:
        r26 = r113;
    L31:
        r11 = CollectionsKt.emptyList();
        goto L33
    L23:
        r9 = null;
    L34:
        r18 = null;
    L13:
        r21 = true;
        goto L14
    L7:
        r22 = false;
        goto L8
    L208:
        s().b(false, r44.k);
        InnerVideoListPreloadManager r78 = s();
        r78.getClass();
        Intrinsics.checkNotNullParameter(r44, "getCachedVideoItemsParams");
        String r79 = r44.a;
        Boolean r80 = r44.b;
        if (r80 == null) goto L211;
        boolean r311 = r80.booleanValue();
    L212:
        Lazy r81 = i1.a;
        Intrinsics.checkNotNullParameter(r79, "messageId");
        ConcurrentHashMap r82 = i1.c();
        if (r82 == null) goto L217;
        com.larus.video.impl.sdk.prefetch.c r83 = (com.larus.video.impl.sdk.prefetch.c) r82.get(r79);
        if (r83 == null) goto L217;
        boolean r312 = r83.b;
    L218:
        Intrinsics.checkNotNullParameter(r79, "messageId");
        ConcurrentHashMap r84 = i1.c();
        if (r84 == null) goto L221;
        com.larus.video.impl.sdk.prefetch.c r85 = (com.larus.video.impl.sdk.prefetch.c) r84.put(r79, new com.larus.video.impl.sdk.prefetch.c(AppHost.a.getAppClock().currentTimeMillis()));
    L221:
        i1.o(r84);
        com.larus.video.impl.sdk.prefetch.g r86 = i1.f(r79);
        FLogger r87 = FLogger.a;
        r87.i("InnerVideoListPreloadManager", "getPreloadRecommendVideoListFromUserClick diskCachedVideoData:" + r86);
        if (r78.e() > 0) goto L224;
        r87.i("InnerVideoListPreloadManager", "getFallbackVideoList, prefetchVideoOuterFallbackSize: " + r78.e());
    L261:
        com.larus.video.impl.sdk.prefetch.g r88 = null;
    L270:
        if (r86 == null) goto L272;
        Lazy r89 = i1.a;
        i1.k(com.larus.video.impl.sdk.prefetch.g.a(r86));
    L273:
        FLogger.a.i("InnerVideoListPreloadManager", "getPreloadRecommendVideoListFromUserClick cachedVideoData:" + r86);
        if (r86 != null) goto L276;
    L345:
        r78.k(r79, r44.f, r44.i, r44.j, false, false, r312, r311, r86);
        return null;
    L276:
        if (r86.c.isEmpty() == true) goto L345;
        int r90 = r86.e;
        if (r90 == CachedVideosPreloadFrom.CMD.getValue()) goto L314;
        if (r90 == CachedVideosPreloadFrom.BIND_PULL_API.getValue()) goto L314;
        if (r90 == CachedVideosPreloadFrom.REFRESH_VIDEO.getValue()) goto L314;
        if (r90 != CachedVideosPreloadFrom.OUTER_FALLBACK.getValue()) goto L290;
        Pair<List<String>, Boolean> r91 = r78.g(r86.c);
    L337:
        List r92 = (List) r91.component1();
        boolean r93 = ((Boolean) r91.component2()).booleanValue();
        if (r92.isEmpty() == false) goto L342;
        boolean r94 = true;
        if ((!r86.c.isEmpty()) == false) goto L343;
        boolean r211 = true;
    L344:
        List r95 = r92;
        r78.k(r79, r44.f, r44.i, r44.j, r211, r94 ^ r95.isEmpty(), r312, r311, r86);
        return new v4(r86.b, new ArrayList(r95), r93, null);
    L343:
        r211 = false;
        goto L344
    L342:
        r94 = true;
        goto L343
    L290:
        if (r90 == CachedVideosPreloadFrom.UN_CONSUMED.getValue()) goto L292;
        r91 = TuplesKt.to(CollectionsKt.emptyList(), Boolean.FALSE);
        goto L337
    L292:
        if (r86.f == false) goto L294;
        int r96 = r78.d();
    L295:
        int r97 = Math.min(Math.min(r96, ((Number) r78.g.getValue()).intValue()), r86.c.size());
        List r98 = r86.c;
        if (r97 == (-1)) goto L300;
        r98 = b0.a(r98, 0, r97);
    L300:
        if (r98.size() <= ((Number) r78.f.getValue()).intValue()) goto L302;
        boolean r99 = true;
    L303:
        r91 = TuplesKt.to(r98, Boolean.valueOf(r99));
        if ((!((Collection) r91.getFirst()).isEmpty()) == true) goto L337;
        if (r88 == null) goto L310;
        List<String> r100 = r88.c;
        if (r100 == null) goto L310;
    L311:
        r91 = r78.g(r100);
    L310:
        r100 = CollectionsKt.emptyList();
        goto L311
    L302:
        r99 = false;
        goto L303
    L294:
        r96 = ((Number) r78.c.getValue()).intValue();
    L314:
        if (r86.f == true) goto L316;
        int r101 = ((Number) r78.c.getValue()).intValue();
    L320:
        int r102 = Math.min(r101, r86.c.size());
        List r103 = r86.c;
        if (r102 == (-1)) goto L325;
        r103 = b0.a(r103, 0, r102);
    L325:
        if (r103.size() <= ((Number) r78.f.getValue()).intValue()) goto L327;
        boolean r104 = true;
    L328:
        r91 = TuplesKt.to(r103, Boolean.valueOf(r104));
        if ((!((Collection) r91.getFirst()).isEmpty()) == true) goto L337;
        if (r88 == null) goto L335;
        List<String> r105 = r88.c;
        if (r105 == null) goto L335;
    L336:
        r91 = r78.g(r105);
    L335:
        r105 = CollectionsKt.emptyList();
        goto L336
    L327:
        r104 = false;
        goto L328
    L316:
        if (r78.d() != (-1)) goto L318;
        r101 = r86.c.size();
        goto L320
    L318:
        r101 = r78.d();
        goto L320
    L272:
        FLogger.a.i("InnerVideoListPreloadManager", "getPreloadRecommendVideoListFromUserClick form fallback:" + r88);
        r86 = r88;
        goto L273
    L224:
        List r106 = r44.h;
        if (r106 != null) goto L227;
    L230:
        boolean r107 = true;
    L231:
        if (r107 == false) goto L233;
        r87.i("InnerVideoListPreloadManager", "getFallbackVideoList, outerFallbackVideoItems is empty");
        goto L261
    L233:
        List r108 = r44.h;
        if (r108 != null) goto L236;
    L238:
        boolean r109 = false;
    L239:
        if (r109 == false) goto L241;
        r87.i("InnerVideoListPreloadManager", "calculateDefaultVideos, outerFallbackVideoItems size is 1");
        List r116 = CollectionsKt.emptyList();
    L259:
        if (r116.isEmpty() == false) goto L262;
        FLogger.a.i("InnerVideoListPreloadManager", "getFallbackVideoList, itemIdList is empty");
        goto L261
    L262:
        List r117 = r116;
        LinkedHashMap r118 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r117, 10)), 16));
        Iterator r119 = r117.iterator();
    L264:
        if (r119.hasNext() == false) goto L269;
        Object r120 = r119.next();
        String r121 = (String) r120;
        String r122 = r44.c;
        if (r122 != null) goto L268;
        r122 = NameKeys.UnloadStrategy_No_Strategy;
    L268:
        r118.put(r120, r122);
        goto L264
    L269:
        r88 = new com.larus.video.impl.sdk.prefetch.g(r44.a, r118, new ArrayList(r116), AppHost.a.getAppClock().currentTimeMillis(), CachedVideosPreloadFrom.OUTER_FALLBACK.getValue(), null, null, 224);
        goto L270
    L241:
        List r123 = r44.h;
        if (r123 != null) goto L244;
        r116 = CollectionsKt.emptyList();
        goto L259
    L244:
        int r124 = r123.size();
        int r125 = RangesKt.coerceAtLeast(r44.d, 0);
        int r126 = RangesKt.coerceAtLeast(r44.e, 0);
        r87.i("InnerVideoListPreloadManager", "calculateDefaultVideos, outerFallbackVideoItems ：" + r123);
        if (r124 > r125) goto L248;
        r125 = (r126 + 1) % r124;
    L248:
        int r127 = RangesKt.coerceAtLeast(r78.e(), 0);
        if (r127 != 0) goto L251;
        r116 = CollectionsKt.emptyList();
        goto L259
    L251:
        int r128 = RangesKt.coerceAtMost(r127 + r125, r124);
        r87.i("InnerVideoListPreloadManager", "calculateDefaultVideos, startIndex: " + r125 + ", endIndex: " + r128 + ", fallbackList: " + r124);
        List r129 = b0.a(r123, r125, r128);
        ArrayList r130 = new ArrayList();
        Iterator r131 = r129.iterator();
    L253:
        if (r131.hasNext() == false) goto L257;
        Object r132 = r131.next();
        if ((!Intrinsics.areEqual((String) r132, r44.g)) == false) goto L253;
        r130.add(r132);
        goto L253
    L257:
        r116 = r130;
        goto L259
    L236:
        if (r108.size() != 1) goto L238;
        r109 = true;
        goto L239
    L227:
        if (r106.isEmpty() == true) goto L230;
        r107 = false;
    L217:
        r312 = true;
        goto L218
    L211:
        r311 = false;
        goto L212
    }

    public final List<pr9.a> h(String r5, Integer r6) {
        ArrayList r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        t().getClass();
        Lazy r1 = w0.a;
        Intrinsics.checkNotNullParameter(r5, "messageId");
        ConcurrentHashMap r2 = w0.a();
        if (r2 == null) goto L8;
        com.larus.video.impl.sdk.prefetch.g r7 = (com.larus.video.impl.sdk.prefetch.g) r2.get(w0.f(r5, r6));
    L9:
        if (r7 == null) goto L15;
        ArrayList<String> r8 = r7.c;
        r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r0.add(new pr9.a((String) r9.next(), true, 12));
    L15:
        return r0;
    L8:
        r7 = null;
        goto L9
    }

    public final void o(com.larus.platform.api.k r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "cmdCachedVideoItems");
        if (r22 == false) goto L34;
        l0 r5 = t();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r21, "cmdCachedVideoItems");
        int r1 = l0.b.a[r21.e.ordinal()];
        if (r1 == 1) goto L33;
        if (r1 == 2) goto L30;
        if (r1 != 3) goto L50;
        com.larus.video.impl.sdk.prefetch.g r2 = new com.larus.video.impl.sdk.prefetch.g(r21.b, r21.a, r21.d, r21.c, r21.e.getValue(), null, r21.g, 96);
        ArrayList r3 = r21.d;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r6 = r3.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r4.add(new pr9.a((String) r6.next(), true, 12));
        goto L12
    L14:
        qr9.c r7 = VideoFeedProviderDelegate.b.b();
        if (r7 == null) goto L17;
        r7.b(r4);
    L17:
        Integer r8 = r21.f;
        if (r8 != null) goto L21;
    L23:
        FLogger.a.i("RelatedVideoFlowPreloadManager", "putCacheVideoDataFromFlow messageId:" + r21.b + "=====newItemIdList.isNotEmpty():" + (true ^ r21.d.isEmpty()) + "======dataFrom:" + r21.e);
        Lazy r9 = w0.a;
        String r10 = r21.b;
        Integer r0 = r21.f;
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Intrinsics.checkNotNullParameter(r2, "cachedVideoIds");
        if (w0.h != null) goto L26;
        w0.h = new ConcurrentHashMap();
    L26:
        ConcurrentHashMap<String, com.larus.video.impl.sdk.prefetch.g> r11 = w0.h;
        if (r11 == null) goto L45;
        com.larus.video.impl.sdk.prefetch.g r12 = r11.put(w0.f(r10, r0), r2);
        return;
    L45:
        return;
    L21:
        if (r8.intValue() != 1) goto L23;
        l0.d(r21.c, r21.b, r21.f, r21.d, r21.a, CachedVideosPreloadFrom.UNLIMITED_FLOW, r21.g);
        goto L23
    L50:
        return;
    L30:
        if (((Number) r5.f.getValue()).intValue() <= 0) goto L51;
        List r13 = b0.a(r21.d, 0, ((Number) r5.f.getValue()).intValue());
        l0.d(r21.c, r21.b, r21.f, r13, r21.a, CachedVideosPreloadFrom.UN_CONSUMED, r21.g);
        return;
    L51:
        return;
    L33:
        l0.d(r21.c, r21.b, r21.f, r21.d, r21.a, CachedVideosPreloadFrom.CMD, r21.g);
        return;
    L34:
        InnerVideoListPreloadManager r14 = s();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r21, "cmdCachedVideoItems");
        int r15 = InnerVideoListPreloadManager.b.a[r21.e.ordinal()];
        if (r15 == 1) goto L42;
        if (r15 == 2) goto L39;
        return;
    L39:
        if (((Number) r14.g.getValue()).intValue() <= 0) goto L53;
        List<String> r16 = b0.a(r21.d, 0, ((Number) r14.g.getValue()).intValue());
        r14.i(r21.c, r21.b, r16, r21.a, CachedVideosPreloadFrom.UN_CONSUMED);
        return;
    L53:
        return;
    L42:
        r14.i(r21.c, r21.b, r21.d, r21.a, CachedVideosPreloadFrom.CMD);
    }

    public final void e(Context r5, ArticleParam r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "articleParam");
        int r0 = ItemSourceApp.TOUTIAO.getValue();
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.intValue() != r0) goto L18;
        String r8 = r6.getEnterAid();
        if (r8 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L16;
        return;
    L16:
        com.larus.platform.service.q r10 = com.larus.platform.service.q.a;
        StringBuilder r2 = new StringBuilder();
        HttpConst.a.getClass();
        r2.append(HttpConst.e0);
        r2.append(r6.getEnterAid());
        r10.e(r5, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r2.toString())}), null);
        return;
    L10:
        if (r8.length() == 0) goto L13;
        r9 = false;
        goto L14
    }

    public final void m(Context r5, ArticleParam r6, View r7) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "articleParam");
        Intrinsics.checkNotNullParameter(r7, "transitionElement");
        boolean r0 = r5 instanceof Activity;
        Activity r1 = null;
        if (r0 == false) goto L5;
        ActivityOptions r8 = ActivityOptions.makeSceneTransitionAnimation((Activity) r5, r7, "share_article");
    L6:
        if (r0 == false) goto L8;
        r1 = (Activity) r5;
    L8:
        if (r1 == null) goto L12;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L12;
        r2.setSharedElementsUseOverlay(false);
    L12:
        Intent r3 = new Intent(r5, DouYinArticleActivity.class);
        r3.putExtra("key_article_param", r6);
        if (r8 != null) goto L15;
        r5.startActivity(r3);
        return;
    L15:
        r5.startActivity(r3, r8.toBundle());
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final void p(Context r8, String r9, VideoParam r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "videoParam");
        com.obric.assistant.spi.keyguard.a.b(false, new d(r8, r9, r10, null, null), 3);
    }

    public final void r(Context r8, VideoParam r9, View r10, final r2.a r11) {
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "videoParam");
        Intrinsics.checkNotNullParameter(r10, "transitionElement");
        boolean r0 = r8 instanceof Activity;
        Activity r1 = null;
        if (r0 == false) goto L5;
        ActivityOptions r4 = ActivityOptions.makeSceneTransitionAnimation((Activity) r8, r10, "share_video");
    L6:
        if (r0 == false) goto L8;
        Activity r3 = (Activity) r8;
    L10:
        if (r3 == null) goto L14;
        Window r5 = r3.getWindow();
        if (r5 == null) goto L14;
        r5.setSharedElementsUseOverlay(false);
    L14:
        if (r0 == false) goto L16;
        r1 = (Activity) r8;
    L16:
        if (r1 == null) goto L20;
        if (r11 == null) goto L20;
        ActivityCompat.setExitSharedElementCallback(r1, new HolderHandlerImpl$tryConfigDouyinVideoTransition$1(r11));
    L20:
        com.obric.assistant.spi.keyguard.a.b(false, new d(r8, r2, r9, r4, r10), 3);
        return;
    L8:
        r3 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
