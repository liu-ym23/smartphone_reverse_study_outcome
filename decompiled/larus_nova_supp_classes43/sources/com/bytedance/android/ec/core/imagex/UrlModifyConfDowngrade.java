package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.net.Uri;
import android.util.LruCache;
import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.android.ec.core.cps.CyberProtectionCollector;
import com.bytedance.android.ec.core.imagex.common.AsyncWorker;
import com.bytedance.android.ec.core.imagex.common.ProxyRequestListener;
import com.bytedance.android.ec.core.imagex.opt.ECImageRequestBuilderCacheForSlc;
import com.bytedance.android.ec.core.imagex.opt.ImageXSettingKt$lazyImageXSettingsOrNull$4;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UrlModifyConfDowngrade {
    public static final /* synthetic */ KProperty[] a = null;
    public static final AtomicBoolean b = null;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static final AtomicBoolean f = null;
    public static long g;
    public static final AtomicBoolean h = null;
    public static final AtomicInteger i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final ReadOnlyProperty l = null;
    public static final Lazy m = null;
    public static final UrlModifyConfDowngrade n = null;

    public static final class a implements ReadOnlyProperty<Object, com.bytedance.android.shopping.api.image.r0> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public com.bytedance.android.shopping.api.image.r0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.r0, java.lang.Object] */
        public final com.bytedance.android.shopping.api.image.r0 getValue(Object r10, KProperty<?> r11) {
            Intrinsics.checkNotNullParameter(r10, "thisRef");
            Intrinsics.checkNotNullParameter(r11, "property");
            if (this.b != null) goto L5;
            LazyFastSDKSettings r12 = this.a;
            KProperty<?>[] r0 = g;
            if (r12.getValue(this, r0[0]) == this.d) goto L15;
            this.b = this.a.getValue(this, r0[0]);
            if (ColdLaunchExpFilter.e.b(this.c) == true) goto L15;
            return this.b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.e.b(this.c) == false) goto L8;
            return null;
        L8:
            return this.b;
        }

        public a(final com.bytedance.android.shopping.api.image.r0 r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_image_url_modify_downgrade_remote_conf";
            this.c = "ec_image_url_modify_downgrade_remote_conf";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_image_url_modify_downgrade_remote_conf", r10, null, r11, r12, new UrlModifyConfDowngrade$$special$$inlined$lazyImageXSettingsOrNull$1$1(r1, r10));
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(UrlModifyConfDowngrade.class, "conf", "getConf()Lcom/bytedance/android/shopping/api/image/UrlModifyConfDowngradeConf;", 0))};
        n = new UrlModifyConfDowngrade();
        b = new AtomicBoolean(true);
        c = true;
        f = new AtomicBoolean(false);
        h = new AtomicBoolean(true);
        i = new AtomicInteger(0);
        j = LazyKt.lazy(UrlModifyConfDowngrade$showToast$2.INSTANCE);
        k = LazyKt.lazy(UrlModifyConfDowngrade$enable$2.INSTANCE);
        com.bytedance.android.shopping.api.image.r0 r0 = new com.bytedance.android.shopping.api.image.r0(null);
        UrlModifyConfDowngrade$conf$2 r10 = UrlModifyConfDowngrade$conf$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r11 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L5;
        ReadOnlyProperty r1 = new a(r0, r10, r11);
    L6:
        l = r1;
        m = LazyKt.lazy(UrlModifyConfDowngrade$localRepo$2.INSTANCE);
        return;
    L5:
        r1 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_url_modify_downgrade_remote_conf", r0, null, r10, r11);
        goto L6
    }

    public UrlModifyConfDowngrade() {
    }

    public static boolean c() {
        return ((Boolean) k.getValue()).booleanValue();
    }

    public static Keva d() {
        return (Keva) m.getValue();
    }

    public final com.bytedance.android.shopping.api.image.r0 b() {
        return (com.bytedance.android.shopping.api.image.r0) l.getValue(this, a[0]);
    }

    public final void e() {
        com.bytedance.android.shopping.api.image.r0 r0 = b();
        com.bytedance.android.shopping.api.image.s0 r1 = null;
        if (r0 == null) goto L5;
        Boolean r10 = r0.d();
    L7:
        if ((!Intrinsics.areEqual(r10, Boolean.TRUE)) == false) goto L9;
        return;
    L9:
        if (d == true) goto L12;
        return;
    L12:
        if (e == true) goto L47;
        int r11 = 0;
        if (f.compareAndSet(false, true) == false) goto L50;
        CyberProtectionCollector r12 = CyberProtectionCollector.a;
        String r13 = ECAppInfoService.e.getAppVersion();
        if (com.bytedance.android.shopping.extensions.k.c(r13) == true) goto L20;
        r13 = null;
    L20:
        e = true;
        com.bytedance.android.shopping.api.image.r0 r14 = b();
        if (r14 == null) goto L25;
        Integer r15 = r14.a();
        if (r15 == null) goto L25;
        int r16 = r15.intValue();
    L26:
        Integer r17 = StringsKt.toIntOrNull(d().getString("rm_cc", "0"));
        if (r17 == null) goto L29;
        r11 = r17.intValue();
    L29:
        int r18 = r11 + 1;
        d().storeString("rm_cc", String.valueOf(r18));
        if (r18 < r16) goto L48;
        d().storeString("dg", "1");
        d().storeString("dg_v", r13);
        d().storeString("dg_t", String.valueOf(System.currentTimeMillis()));
        Keva r19 = d();
        if (r13 == null) goto L43;
        com.bytedance.android.shopping.api.image.r0 r20 = n.b();
        if (r20 == null) goto L38;
        Map r21 = r20.f();
        if (r21 == null) goto L38;
        r1 = (com.bytedance.android.shopping.api.image.s0) r21.get(r13);
    L38:
        if (r1 == null) goto L43;
        Integer r22 = r1.a();
        if (r22 == null) goto L43;
        String r23 = String.valueOf(r22.intValue());
        if (r23 == null) goto L43;
    L44:
        r19.storeString("rm_cv", r23);
        return;
    L43:
        r23 = "";
        goto L44
    L48:
        return;
    L25:
        r16 = 1;
        goto L26
    L50:
        return;
    L47:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final void g() {
        if (c() == true) goto L5;
        return;
    L5:
        if (c == true) goto L7;
        return;
    L7:
        if (b() != null) goto L10;
        return;
    L10:
        if (b.compareAndSet(true, false) == true) goto L12;
        return;
    L12:
        c = false;
        Executor r0 = AsyncWorker.a;
        com.bytedance.android.ec.core.imagex.common.g.a(true, false, UrlModifyConfDowngrade$tryInit$1.INSTANCE, 2);
    }

    public static final void a(UrlModifyConfDowngrade r17) {
        String r0 = d().getString("dg", "0");
        String r10 = d().getString("dg_v", "");
        String r11 = d().getString("dg_t", "");
        String r12 = d().getString("rm_cv", "");
        CyberProtectionCollector r13 = CyberProtectionCollector.a;
        String r14 = ECAppInfoService.e.getAppVersion();
        Integer r15 = null;
        if (com.bytedance.android.shopping.extensions.k.c(r14) == true) goto L6;
        r14 = null;
    L6:
        if (r14 == null) goto L12;
        com.bytedance.android.shopping.api.image.r0 r16 = n.b();
        if (r16 == null) goto L12;
        Map r18 = r16.f();
        if (r18 == null) goto L12;
        com.bytedance.android.shopping.api.image.s0 r19 = (com.bytedance.android.shopping.api.image.s0) r18.get(r14);
    L13:
        if (r19 == null) goto L15;
        Integer r110 = r19.b();
    L17:
        if (r110 == null) goto L23;
        if (r110.intValue() != 1) goto L23;
        e = true;
        f.set(true);
        return;
    L23:
        if (Intrinsics.areEqual(r0, "1") == true) goto L25;
        return;
    L25:
        if (StringsKt.isBlank(r10) == false) goto L27;
    L62:
        boolean r1 = false;
    L63:
        if (r1 == false) goto L65;
        e = true;
        f.set(true);
        return;
    L65:
        f.set(false);
        e = false;
        d().storeString("dg", "");
        d().storeString("dg_v", "");
        d().storeString("dg_t", "");
        d().storeString("rm_cv", "");
        return;
    L27:
        if (StringsKt.isBlank(r11) == true) goto L62;
        com.bytedance.android.shopping.api.image.r0 r20 = r17.b();
        if (r20 == null) goto L32;
        Long r21 = r20.b();
    L33:
        Long r22 = StringsKt.toLongOrNull(r11);
        if (r14 != null) goto L36;
    L39:
        boolean r111 = true;
    L40:
        if (r111 == true) goto L62;
        if (r19 == null) goto L44;
        r15 = r19.a();
    L44:
        Integer r23 = StringsKt.toIntOrNull(r12);
        if (r15 == null) goto L50;
        if (r23 != null) goto L48;
    L49:
        d().storeString("rm_cc", "0");
        goto L62
    L48:
        if (r15.intValue() > r23.intValue()) goto L49;
    L50:
        if (r21 == null) goto L62;
        if (r21.longValue() <= 0) goto L62;
        if (r22 == null) goto L62;
        if (r22.longValue() <= 0) goto L62;
        if (Intrinsics.areEqual(r14, r10) == false) goto L62;
        if ((System.currentTimeMillis() - r22.longValue()) > r21.longValue()) goto L62;
        r1 = true;
        goto L63
    L36:
        if (StringsKt.isBlank(r14) == true) goto L39;
        r111 = false;
        goto L40
    L32:
        r21 = null;
        goto L33
    L15:
        r110 = null;
    L12:
        r19 = null;
        goto L13
    }

    public static String f(ImageRequest r10) {
        int r0 = ProxyRequestListener.c;
        Object r1 = null;
        if (r10 == null) goto L5;
        RequestListener r11 = r10.getRequestListener();
    L7:
        if ((r11 instanceof ProxyRequestListener) == true) goto L9;
        r11 = null;
    L9:
        ProxyRequestListener r12 = (ProxyRequestListener) r11;
        if (r12 == null) goto L12;
        Object r13 = r12.a("tag#ImageUrls");
    L14:
        if ((r13 instanceof List) == true) goto L16;
        r13 = null;
    L16:
        List r14 = (List) r13;
        if (r14 == null) goto L29;
        Iterator r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L25;
        Object r16 = r15.next();
        if ((!UriProtector.getQueryParameterNames(UriProtector.parse((String) r16)).contains("from_ec_image_loaded")) == false) goto L20;
        r1 = r16;
    L25:
        return (String) r1;
    L29:
        return null;
    L12:
        r13 = null;
        goto L14
    L5:
        r11 = null;
        goto L7
    }

    public final void h(ImageRequest r23, boolean r24, boolean r25, u r26) {
        Intrinsics.checkNotNullParameter(r26, "context");
        m0.c("UrlModifyConfDowngrade.tryRecordBadLoad");
        if (m0.b() == true) goto L6;
        return;
    L6:
        if (c() == false) goto L149;
        if (r24 == false) goto L150;
        if (r25 == false) goto L151;
        if (r23 != null) goto L12;
        return;
    L12:
        if (r23.getLowestPermittedRequestLevel() == ImageRequest.RequestLevel.FULL_FETCH) goto L14;
        return;
    L14:
        String r1 = r26.E;
        if (r1 != null) goto L30;
        int r10 = ProxyRequestListener.c;
        RequestListener r11 = r23.getRequestListener();
        if ((r11 instanceof ProxyRequestListener) == true) goto L19;
        r11 = null;
    L19:
        ProxyRequestListener r12 = (ProxyRequestListener) r11;
        if (r12 == null) goto L22;
        Object r13 = r12.a("tag#ImageUrls");
    L24:
        if ((r13 instanceof List) == true) goto L26;
        r13 = null;
    L26:
        List r14 = (List) r13;
        if (r14 == null) goto L29;
        r1 = (String) CollectionsKt.firstOrNull(r14);
        goto L30
    L29:
        String r15 = null;
    L31:
        if (r15 != null) goto L34;
        return;
    L34:
        if (Intrinsics.areEqual(r23.getSourceUri().toString(), r15) == false) goto L133;
        return;
    L133:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L130
        String r17 = r26.D;     // Catch: Throwable -> L130
        if (r17 != null) goto L39;
        r17 = f(r23);     // Catch: Throwable -> L130
    L39:
        String r18 = r17;
        if (r18 != null) goto L42;
        return;
    L42:
        Uri.Builder r19 = r23.getSourceUri().buildUpon();     // Catch: Throwable -> L130
        r19.clearQuery();     // Catch: Throwable -> L130
        Uri r20 = r19.build();     // Catch: Throwable -> L130
        Uri.Builder r21 = UriProtector.parse(r18).buildUpon();     // Catch: Throwable -> L130
        r21.clearQuery();     // Catch: Throwable -> L130
        Uri r110 = r21.build();     // Catch: Throwable -> L130
        int r22 = StringsKt.indexOf$default(r15, "?", 0, false, 6, null);     // Catch: Throwable -> L130
        if (r22 <= 0) goto L45;
        String r111 = r15.substring(0, r22);     // Catch: Throwable -> L130
    L47:
        if (r110.equals(r20) == true) goto L49;
        return;
    L49:
        if (Intrinsics.areEqual(r111, r110.toString()) == true) goto L148;
        com.bytedance.android.shopping.api.image.r0 r27 = b();     // Catch: Throwable -> L130
        if (r27 == null) goto L54;
        Integer r28 = r27.c();     // Catch: Throwable -> L130
    L55:
        int r112 = i.incrementAndGet();     // Catch: Throwable -> L130
        com.bytedance.android.shopping.api.image.r0 r29 = b();     // Catch: Throwable -> L130
        if (r29 == null) goto L58;
        Boolean r30 = r29.e();     // Catch: Throwable -> L130
    L60:
        if (Intrinsics.areEqual(r30, Boolean.TRUE) == false) goto L104;
        String r31 = r26.C;     // Catch: Throwable -> L130
        if (r31 == null) goto L77;
        Lazy r32 = EditUrlCache.a;     // Catch: Throwable -> L130
        ImageExperiments.G.getClass();     // Catch: Throwable -> L130
        if (((Boolean) ImageExperiments.e.getValue()).booleanValue() == true) goto L66;
        Pair r33 = null;
    L67:
        if (r33 == null) goto L77;
        List r34 = (List) r33.component1();     // Catch: Throwable -> L130
        com.bytedance.android.shopping.api.image.r r35 = (com.bytedance.android.shopping.api.image.r) r33.component2();     // Catch: Throwable -> L130
        if ((!r34.isEmpty()) == false) goto L77;
        String r36 = r23.getSourceUri().toString();     // Catch: Throwable -> L130
        List r37 = CollectionsKt.mutableListOf(new String[]{r36});     // Catch: Throwable -> L130
        Iterator r38 = r34.iterator();     // Catch: Throwable -> L130
    L72:
        if (r38.hasNext() == false) goto L76;
        String r39 = (String) r38.next();     // Catch: Throwable -> L130
        if ((!Intrinsics.areEqual(r39, r36)) == false) goto L72;
        r37.add(r39);     // Catch: Throwable -> L130
        goto L72
    L76:
        EditUrlCache.b(r31, r37, r35);     // Catch: Throwable -> L130
        goto L77
    L66:
        r33 = (Pair) EditUrlCache.a().get(r31);     // Catch: Throwable -> L130
    L77:
        String r40 = r26.B;     // Catch: Throwable -> L130
        if (r40 == null) goto L104;
        Triple r41 = ECImageRequestBuilderCacheForSlc.a(r40);     // Catch: Throwable -> L130
        if (r41 == null) goto L104;
        com.bytedance.android.shopping.api.image.q r42 = (com.bytedance.android.shopping.api.image.q) r41.component1();     // Catch: Throwable -> L130
        List r43 = (List) r41.component2();     // Catch: Throwable -> L130
        ImageRequest r44 = (ImageRequest) r41.component3();     // Catch: Throwable -> L130
        ArrayList r45 = new ArrayList();     // Catch: Throwable -> L130
        Iterator r46 = r43.iterator();     // Catch: Throwable -> L130
    L83:
        if (r46.hasNext() == false) goto L94;
        Object r113 = r46.next();     // Catch: Throwable -> L130
        ImageRequest r47 = (ImageRequest) r113;     // Catch: Throwable -> L130
        if (r47 != r23) goto L87;
    L90:
        boolean r48 = true;
    L91:
        if (r48 == false) goto L83;
    L95:
        ImageRequest r49 = (ImageRequest) r113;     // Catch: Throwable -> L130
        if (r49 == null) goto L104;
        r45.add(r49);     // Catch: Throwable -> L130
        Iterator r50 = r43.iterator();     // Catch: Throwable -> L130
    L99:
        if (r50.hasNext() == false) goto L103;
        ImageRequest r51 = (ImageRequest) r50.next();     // Catch: Throwable -> L130
        if (r51 == r49) goto L99;
        r45.add(r51);     // Catch: Throwable -> L130
        goto L99
    L103:
        Lazy r52 = ECImageRequestBuilderCacheForSlc.a;     // Catch: Throwable -> L130
        Intrinsics.checkNotNullParameter(r40, "key");     // Catch: Throwable -> L130
        Intrinsics.checkNotNullParameter(r45, "cache");     // Catch: Throwable -> L130
        ((LruCache) ECImageRequestBuilderCacheForSlc.a.getValue()).put(r40, new SoftReference(new Triple(r42, r45, r44)));     // Catch: Throwable -> L130
        goto L104
    L87:
        if (r47.getSourceUri().equals(r23.getSourceUri()) == true) goto L90;
        r48 = false;
        goto L91
    L94:
        r113 = null;
    L104:
        if (r28 != null) goto L106;
    L110:
        ECAppInfoService r53 = ECAppInfoService.e;     // Catch: Throwable -> L130
        if (r53.isLocalTest() == true) goto L113;
    L123:
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("biz_tag", r26.f), TuplesKt.to("scene_tag", r26.g), TuplesKt.to("edit_url", r111), TuplesKt.to("origin_url", r18), TuplesKt.to("fail_num", String.valueOf(r112)), TuplesKt.to("is_downgrade", String.valueOf(e))});     // Catch: Throwable -> L130
        int r54 = ECMonitorService.b;     // Catch: Throwable -> L130
        JSONObject r55 = new JSONObject();     // Catch: Throwable -> L130
        Iterator r56 = r0.entrySet().iterator();     // Catch: Throwable -> L130
    L125:
        if (r56.hasNext() == false) goto L127;
        Map.Entry r57 = (Map.Entry) r56.next();     // Catch: Throwable -> L130
        r55.putOpt((String) r57.getKey(), r57.getValue());     // Catch: Throwable -> L130
        goto L125
    L127:
        Unit r58 = Unit.INSTANCE;     // Catch: Throwable -> L130
        ECMonitorService.a.a("ec_image_url_modify_unusual_monitor", r55, null, null);     // Catch: Throwable -> L130
        EnsureManager.ensureNotReachHere("ECModifyUnusualException", r0);     // Catch: Throwable -> L130
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L130
        return;
    L113:
        if (((Boolean) j.getValue()).booleanValue() == false) goto L123;
        if ((System.currentTimeMillis() - g) <= ServerInfo.ERROR_BIND_SERVICE) goto L123;
        AtomicBoolean r59 = h;     // Catch: Throwable -> L130
        if (r59.compareAndSet(true, false) == false) goto L123;
        Context r60 = r53.getApplicationContext();     // Catch: Throwable -> L130
        if (r60 == null) goto L123;
        if (r59.compareAndSet(false, true) == false) goto L123;
        g = System.currentTimeMillis();     // Catch: Throwable -> L130
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new UrlModifyConfDowngrade$tryRecordBadLoad$$inlined$runCatching$lambda$1(r60, null, this, r26, r23, r15), 2, null);     // Catch: Throwable -> L130
        goto L123
    L106:
        if (r28.intValue() <= 0) goto L110;
        if (r112 <= r28.intValue()) goto L110;
        e();     // Catch: Throwable -> L130
        goto L110
    L58:
        r30 = null;
        goto L60
    L54:
        r28 = null;
        goto L55
    L148:
        return;
    L45:
        r111 = r15;
    L130:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L22:
        r13 = null;
    L30:
        r15 = r1;
        goto L31
    L151:
        return;
    L150:
        return;
    }
}
