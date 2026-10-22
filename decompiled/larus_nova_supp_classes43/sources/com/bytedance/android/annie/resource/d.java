package com.bytedance.android.annie.resource;

import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.preload.PreLoadUtils;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.p;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.utils.r;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements com.bytedance.android.annie.service.resource.e {

    public static final class a {
    }

    public static final class b {
        public final Map<String, List<p>> a;
        public final List<String> b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Map<String, List<p>> r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "ForestPreloadConfig(forestSubRes=" + this.a + ", preloadUrls=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Map<String, ? extends List<p>> r10, List<String> r11) {
            Intrinsics.checkNotNullParameter(r11, "preloadUrls");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class c {
        public final String a;
        public final long b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "VideoConfig(key=" + this.a + ", size=" + this.b + ", url=" + this.c + ')';
        }

        public c(String r10, long r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.resource.d$d, reason: collision with other inner class name */
    public static final class RunnableC0079d implements Runnable {
        public final /* synthetic */ Pair<b, List<c>> a;
        public final /* synthetic */ d b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: Multi-variable type inference failed */
        public RunnableC0079d(Pair<b, ? extends List<c>> r1, d r10, boolean r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void a() {
            Pair<b, List<c>> r0 = this.a;
            d r1 = this.b;
            boolean r10 = this.c;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
            List r12 = (List) r0.getSecond();     // Catch: Throwable -> L13
            if (r12 == null) goto L10;
            Iterator r13 = r12.iterator();     // Catch: Throwable -> L13
        L7:
            if (r13.hasNext() == false) goto L9;
            d.H1(r1, (c) r13.next(), r10);     // Catch: Throwable -> L13
            goto L7
        L9:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        L11:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L13
        L15:
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L22;
            x8.a.c("AnnieForestResourceLoader", r16, false);
            return;
        L22:
            return;
        L10:
            r14 = null;
        L13:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d() {
    }

    static {
        ai7.a.b();
    }

    public static List J1(JSONArray r11) {
        ArrayList r0 = new ArrayList();
        int r1 = r11.length();
        int r10 = 0;
    L3:
        if (r10 >= r1) goto L13;
        JSONObject r12 = JSONArrayProtectorUtils.getJSONObject(r11, r10);
        String r13 = r12.optString(com.bytedance.android.ec.core.event.a.KEY_URL);
        String r14 = r12.optString("key");
        long r15 = r12.optLong("size");
        if ((!StringsKt.isBlank(r13)) == true) goto L7;
    L11:
        int r16 = x8.a.a;
        x8.a.d("AnnieForestResourceLoader", "invalid config key " + r14 + " url " + r13 + " size " + r15, false);
    L12:
        r10 = r10 + 1;
        goto L3
    L7:
        if ((!StringsKt.isBlank(r14)) == false) goto L11;
        if (r15 <= 0) goto L11;
        r0.add(new c(r14, r15, r13));
        goto L12
    L13:
        return r0;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean D1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return GeckoXAdapter.Companion.isCDNMultiVersionResource(r10);
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean F0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return Forest.Companion.isPreloaded$default(Forest.Companion, r10, null, 2, null);
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final void h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        Forest r0 = ForestLoader.a();
        if (r0 == null) goto L6;
        r0.closeSession(r10);
        return;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final boolean l(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return GeckoXAdapter.Companion.canParsed(r10);
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final String t1(String r20) {
        Intrinsics.checkNotNullParameter(r20, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
    L40:
        return r20;
    L5:
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L40;
        if (((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).D1(r20) == false) goto L40;
        Uri r1 = UriProtector.parse(r20);
        if (r1 != null) goto L12;
        return r20;
    L12:
        Uri.Builder r10 = r1.buildUpon();
        Iterator r11 = ((CopyOnWriteArrayList) p9.a.b).iterator();
    L14:
        if (r11.hasNext() == false) goto L22;
        Iterator r12 = ((p9.h) r11.next()).a(r20, null, null).entrySet().iterator();
    L17:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (UriProtector.getQueryParameter(r1, (String) r13.getKey()) != null) goto L17;
        r10.appendQueryParameter((String) r13.getKey(), (String) r13.getValue());
        goto L17
    L22:
        if (com.bytedance.android.annie.ng.g.g == false) goto L39;
        if (com.bytedance.android.annie.ng.g.b().a.b == false) goto L39;
        if (r1.getHost() == null) goto L39;
        String r0 = r1.getHost();
        Intrinsics.checkNotNull(r0);
        String r14 = r1.getHost();
        if (r14 != null) goto L30;
    L32:
        boolean r15 = false;
    L33:
        if (r15 == false) goto L35;
        r0 = r0 + ".boe-gateway.byted.org";
    L35:
        String r16 = r10.build().toString();
        String r17 = r1.getHost();
        Intrinsics.checkNotNull(r17);
        String r18 = StringsKt.replace$default(r16, r17, r0, false, 4, null);
        if (StringsKt.startsWith$default(r18, "https", false, 2, null) == true) goto L48;
        return r18;
    L48:
        return StringsKt.replaceFirst$default(r18, "https", "http", false, 4, null);
    L30:
        if (StringsKt.contains$default(r14, "boe", false, 2, null) == true) goto L32;
        r15 = true;
    L39:
        return r10.build().toString();
    }

    public final b I1(JSONObject r21, boolean r22) {
        if (r21 != null) goto L6;
        return null;
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        ArrayList r10 = new ArrayList();
        Iterator<String> r11 = r21.keys();
    L8:
        if (r11.hasNext() == false) goto L22;
        String r12 = r11.next();
        JSONArray r13 = JSONObjectProtectorUtils.getJSONArray(r21, r12);
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        int r16 = r13.length();
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L20;
        JSONObject r18 = JSONArrayProtectorUtils.getJSONObject(r13, r17);
        String r19 = r18.optString(com.bytedance.android.ec.core.event.a.KEY_URL);
        if ((!StringsKt.isBlank(r19)) == false) goto L18;
        String r110 = t1(r19);
        boolean r111 = r18.optBoolean("enableMemory", false);
        if (r22 == false) goto L16;
        NetWorker r112 = NetWorker.TTNet;
    L17:
        r14.add(new p(r110, r111, false, r112, 12));
        r15.add(r19);
    L19:
        r17 = r17 + 1;
        goto L10
    L16:
        r112 = NetWorker.Downloader;
        goto L17
    L18:
        int r113 = x8.a.a;
        x8.a.d("AnnieForestResourceLoader", "url is null index " + r18 + '}', false);
        goto L19
    L20:
        Pair r20 = new Pair(r14, r15);
        r1.put(r12, r20.getFirst());
        r10.addAll((Collection) r20.getSecond());
        goto L8
    L22:
        return new b(r1, r10);
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final com.bytedance.android.annie.service.resource.d b1(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Forest r1 = ForestLoader.a();
        if (r1 == null) goto L21;
        int r12 = com.bytedance.forest.e.a;
        Request r13 = com.bytedance.forest.e.a(r10, r1, new RequestParams(0), false, new com.bytedance.forest.utils.e(r1.getApplication()));
        if (StringsKt.isBlank(r13.getGeckoModel().a) == false) goto L20;
        com.bytedance.forest.model.j r14 = r13.getGeckoModel();
        GeckoConfig r15 = r1.getConfig().h;
        if (r15 == null) goto L17;
        String r16 = r15.b;
        if (r16 == null) goto L17;
    L18:
        r14.a = r16;
    L17:
        r16 = "";
    L20:
        return new com.bytedance.android.annie.service.resource.d(r13.getGeckoModel().a, r13.getGeckoModel().b, r13.getGeckoModel().c);
    L21:
        com.bytedance.forest.model.j r17 = r.a(r10, GeckoXAdapter.Companion.getPrefixAsGeckoCDN(r11));
        if (r17 == null) goto L26;
        return new com.bytedance.android.annie.service.resource.d(r17.a, r17.b, r17.c);
    L26:
        return new com.bytedance.android.annie.service.resource.d(0);
    L8:
        return new com.bytedance.android.annie.service.resource.d(0);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final com.bytedance.android.annie.service.resource.h o0(String r10, RequestConfig r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "requestConfig");
        return new l(r10, r11, null);
    }

    public static final void H1(final d r10, final c r11, boolean r12) {
        r10.getClass();
        Forest r0 = ForestLoader.a();
        if (r0 == null) goto L10;
        String r1 = r11.c;
        RequestParams r13 = new RequestParams(Scene.LYNX_CHILD_RESOURCE);
        r13.k = true;
        r13.l = true;
        if (r12 == false) goto L7;
        NetWorker r14 = NetWorker.TTNet;
    L8:
        r13.D = r14;
        Unit r15 = Unit.INSTANCE;
        r0.fetchResourceAsync(r1, r13, new AnnieForestResourceLoader$preloadVideoItem$2(r11, r10));
        return;
    L7:
        r14 = NetWorker.Downloader;
        goto L8
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final com.bytedance.android.annie.service.resource.h x(String r10, RequestConfig r11, Function1<? super com.bytedance.android.annie.service.resource.i, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "requestConfig");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        return new l(r10, r11, r12);
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final int A1(String r10, boolean r11, String r12, String r13, IHybridComponent.HybridType r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "type");
        Forest r1 = ForestLoader.a();
        if (r1 != null) goto L24;
        return -1;
    L24:
        String r16 = t1(r10);     // Catch: Throwable -> L9
        if (r16 != null) goto L8;
        r16 = "";
    L8:
        String r17 = r16;
        RequestParams r18 = new RequestParams(Scene.WEB_MAIN_DOCUMENT);     // Catch: Throwable -> L9
        y9.m r19 = n.a;     // Catch: Throwable -> L9
        if ((AnnieConfigSettingKeys.RL_FOREST_RESOLUTION.a().intValue() % 2) == 0) goto L14;
        boolean r20 = true;
    L15:
        r18.k = r20;     // Catch: Throwable -> L9
        r18.g = true;     // Catch: Throwable -> L9
        if (r15 == false) goto L18;
        r18.D = NetWorker.TTNet;     // Catch: Throwable -> L9
    L18:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r1.preload(r17, r18, r11, r12, r13);     // Catch: Throwable -> L9
        return 0;
    L14:
        r20 = false;
    L9:
        th = move-exception;
        x8.a.c("AnnieForestResourceLoader", th, false);
        return 302;
    }

    @Override // com.bytedance.android.annie.service.resource.e
    public final int m(String r22, JSONObject r23, String r24, String r25, String r26, IHybridComponent.HybridType r27, String r28, boolean r29) {
        Intrinsics.checkNotNullParameter(r24, "source");
        Intrinsics.checkNotNullParameter(r27, "type");
        Intrinsics.checkNotNullParameter(r28, "bizKey");
        Forest r10 = ForestLoader.a();
        if (r10 == null) goto L107;
        if (r23 == null) goto L6;
        Object r0 = r23.remove("video");
    L8:
        if ((r0 instanceof JSONArray) == false) goto L10;
        JSONArray r1 = (JSONArray) r0;
    L109:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L17
        b r14 = I1(r23, r29);     // Catch: Throwable -> L17
        if (r1 == null) goto L14;
        List r11 = J1(r1);     // Catch: Throwable -> L17
    L15:
        Object r12 = Result.constructor-impl(new Pair(r14, r11));     // Catch: Throwable -> L17
    L20:
        if (Result.isSuccess-impl(r12) == false) goto L104;
        Pair r15 = (Pair) r12;
        Schedulers.computation().scheduleDirect(new RunnableC0079d(r15, this, r29));
        if (r22 == null) goto L24;
        String r16 = t1(r22);
    L26:
        if (r27 != IHybridComponent.HybridType.LYNX) goto L28;
        PreloadType r17 = PreloadType.LYNX;
    L29:
        PreloadType r18 = r17;
        b r19 = (b) r15.getFirst();
        if (r19 == null) goto L32;
        Map<String, List<p>> r110 = r19.a;
    L33:
        if (r29 == false) goto L35;
        NetWorker r20 = NetWorker.TTNet;
    L36:
        com.bytedance.forest.model.n r21 = new com.bytedance.forest.model.n(r16, r18, r110, true, false, r20);
        b r30 = (b) r15.getFirst();
        if (r30 == null) goto L39;
        List<String> r31 = r30.b;
    L40:
        if (r22 == null) goto L42;
        PreLoadUtils.a.getClass();
        PreLoadUtils.b(r22);
    L42:
        if (r31 == null) goto L47;
        Iterator<T> r32 = r31.iterator();
    L45:
        if (r32.hasNext() == false) goto L47;
        String r111 = (String) r32.next();
        PreLoadUtils.a.getClass();
        PreLoadUtils.b(r111);
    L47:
        r10.preload(r21, r25, r26);
        int r33 = k.a;
        Intrinsics.checkNotNullParameter(r15, "pair");
        Intrinsics.checkNotNullParameter(r24, "source");
        Intrinsics.checkNotNullParameter(r28, "bizKey");
        PreLoadUtils r34 = PreLoadUtils.a;
        JSONObject r35 = new JSONObject();
        b r112 = (b) r15.getFirst();
        if (r112 == null) goto L52;
        Map<String, List<p>> r113 = r112.a;
        if (r113 == null) goto L52;
        List<p> r114 = r113.get("image");
    L53:
        List r36 = (List) r15.getSecond();
        if (r114 == null) goto L56;
        int r115 = r114.size();
    L57:
        r35.put("image_count", r115);
        if (r114 == null) goto L68;
        List<p> r116 = r114;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r118 = r116.iterator();
    L61:
        if (r118.hasNext() == false) goto L67;
        Long r119 = ((p) r118.next()).e;
        if (r119 == null) goto L65;
        long r120 = r119.longValue();
    L66:
        r117.add(Long.valueOf(r120));
        goto L61
    L65:
        r120 = 0;
        goto L66
    L67:
        long r121 = CollectionsKt.sumOfLong(r117);
    L69:
        r35.put("image_size", r121);
        if (r36 == null) goto L72;
        int r122 = r36.size();
    L73:
        r35.put("video_count", r122);
        if (r36 == null) goto L80;
        List r37 = r36;
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r37, 10));
        Iterator r38 = r37.iterator();
    L77:
        if (r38.hasNext() == false) goto L79;
        r123.add(Long.valueOf(((c) r38.next()).b));
        goto L77
    L79:
        long r124 = CollectionsKt.sumOfLong(r123);
    L81:
        r35.put("video_size", r124);
        JSONObject r39 = new JSONObject();
        r39.put("source", r24);
        if (r22 == null) goto L84;
        r39.put(com.bytedance.android.ec.core.event.a.KEY_URL, r22);
    L84:
        if (r25 == null) goto L86;
        r39.put("container_trace_id", r25);
    L86:
        JSONObject r40 = new JSONObject();
        if (r23 == null) goto L89;
        r40.put("preload_param", r23.toString());
    L89:
        r34.getClass();
        Intrinsics.checkNotNullParameter(r28, "bizKey");
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L99
        j9.b r42 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();     // Catch: Throwable -> L99
        JSONObject r43 = new JSONObject();     // Catch: Throwable -> L99
        com.bytedance.android.annie.ng.a r44 = com.bytedance.android.annie.ng.g.c.get(r28);     // Catch: Throwable -> L99
        if (r44 == null) goto L96;
        o8.f r45 = r44.b;     // Catch: Throwable -> L99
        if (r45 == null) goto L96;
        String r46 = r45.a;     // Catch: Throwable -> L99
        if (r46 == null) goto L96;
    L97:
        r43.put("virtual_aid", r46);     // Catch: Throwable -> L99
        Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L99
        r42.b(null, "ttlive_container_preload_pv", r22, r39, r35, r40, r43, 0, r25);     // Catch: Throwable -> L99
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L99
        return 0;
    L96:
        r46 = "88888";
    L99:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return 0;
    L80:
        r124 = 0;
        goto L81
    L72:
        r122 = 0;
        goto L73
    L68:
        r121 = 0;
        goto L69
    L56:
        r115 = 0;
    L52:
        r114 = null;
        goto L53
    L39:
        r31 = null;
        goto L40
    L35:
        r20 = NetWorker.Downloader;
        goto L36
    L32:
        r110 = null;
        goto L33
    L28:
        r17 = PreloadType.WEB;
        goto L29
    L24:
        r16 = null;
        goto L26
    L104:
        if (Result.exceptionOrNull-impl(r12) == null) goto L119;
        return 302;
    L119:
        return -1;
    L14:
        r11 = null;
    L17:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L10:
        r1 = null;
        goto L109
    L6:
        r0 = null;
        goto L8
    L107:
        return -1;
    }
}
