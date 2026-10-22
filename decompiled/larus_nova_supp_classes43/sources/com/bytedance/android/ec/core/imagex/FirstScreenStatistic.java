package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class FirstScreenStatistic {
    public static final AtomicInteger A = null;
    public static final q0 B = null;
    public static long C;
    public static final Set<String> D = null;
    public static final boolean E = false;
    public static final boolean F = false;
    public static final boolean G = false;
    public static boolean H;
    public static final Handler I = null;
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, i0>> J = null;
    public static final ConcurrentHashMap<String, Boolean> K = null;
    public static final ConcurrentHashMap<ImageView, String> L = null;
    public static final ConcurrentHashMap<String, String> M = null;
    public static final ConcurrentHashMap<String, p0> N = null;
    public static final ConcurrentHashMap<String, Bitmap> O = null;
    public static final ConcurrentHashMap<String, Deferred<Bitmap>> P = null;
    public static final ConcurrentLinkedQueue<com.bytedance.android.ec.core.imagex.a> Q = null;
    public static final Lazy R = null;
    public static final FirstScreenStatistic S = null;
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static long d;
    public static boolean e;
    public static final HashMap<String, HashMap<String, i0>> f = null;
    public static final HashMap<String, HashMap<String, i0>> g = null;
    public static final HashMap<String, o0> h = null;
    public static final Set<String> i = null;
    public static final List<String> j = null;
    public static final List<String> k = null;
    public static final List<String> l = null;
    public static final boolean m = false;
    public static final boolean n = false;
    public static final boolean o = false;
    public static final boolean p = false;
    public static final HashSet<String> q = null;
    public static final Set<String> r = null;
    public static final Set<String> s = null;
    public static boolean t;
    public static boolean u;
    public static final HashSet<String> v = null;
    public static final HashSet<String> w = null;
    public static final AtomicInteger x = null;
    public static final AtomicInteger y = null;
    public static final HashSet<String> z = null;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FirstScreenStatistic r0 = FirstScreenStatistic.S;     // Catch: Throwable -> L4
            String r1 = this.a;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            FirstScreenStatistic.j(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ long f;

        public b(Bitmap r1, String r10, int r11, int r12, Map r13, long r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FirstScreenStatistic r0 = FirstScreenStatistic.S;     // Catch: Throwable -> L4
            Bitmap r1 = this.a;     // Catch: Throwable -> L4
            String r10 = this.b;     // Catch: Throwable -> L4
            int r11 = this.c;     // Catch: Throwable -> L4
            int r12 = this.d;     // Catch: Throwable -> L4
            Map r13 = this.e;     // Catch: Throwable -> L4
            long r14 = this.f;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            FirstScreenStatistic.u(r1, r10, r11, r12, r13, r14);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ long f;

        public c(Bitmap r1, String r10, int r11, int r12, Map r13, long r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FirstScreenStatistic r0 = FirstScreenStatistic.S;     // Catch: Throwable -> L4
            Bitmap r1 = this.a;     // Catch: Throwable -> L4
            String r10 = this.b;     // Catch: Throwable -> L4
            int r11 = this.c;     // Catch: Throwable -> L4
            int r12 = this.d;     // Catch: Throwable -> L4
            Map r13 = this.e;     // Catch: Throwable -> L4
            long r14 = this.f;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            FirstScreenStatistic.u(r1, r10, r11, r12, r13, r14);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FirstScreenStatistic() {
    }

    public static void c() {
        Iterator<Map.Entry<String, o0>> r0 = h.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L32;
        o0 r1 = r0.next().getValue();
        if (r1.e < 0) goto L4;
        if (r1.g == null) goto L4;
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L30
        r10.put("loadStartTime", r1.c);     // Catch: Exception -> L30
        r10.put("loadEndTime", r1.d);     // Catch: Exception -> L30
        r10.put("loadCostTime", r1.e);     // Catch: Exception -> L30
        int r11 = r1.f;     // Catch: Exception -> L30
        if (r11 != 0) goto L12;
        String r12 = "network";
    L28:
        r10.put(com.bytedance.android.ec.core.event.a.KEY_FROM, r12);     // Catch: Exception -> L30
        r10.put("sceneTag", r1.b);     // Catch: Exception -> L30
        r10.put("loadType", r1.g);     // Catch: Exception -> L30
        r10.put(com.bytedance.android.ec.core.event.a.KEY_URL, r1.a);     // Catch: Exception -> L30
        int r13 = ECMonitorService.b;     // Catch: Exception -> L30
        ECMonitorService.a.a("first_screen_load_image_info", r10, null, null);     // Catch: Exception -> L30
        dm.a.a("FirstScreenStatistic").a("first_screen_load_image_info " + r10.toString());     // Catch: Exception -> L30
    L31:
        r0.remove();
        goto L4
    L12:
        if (r11 != 1) goto L14;
        r12 = "memory_encode";
        goto L28
    L14:
        if (r11 != 2) goto L16;
        r12 = "disk";
        goto L28
    L16:
        if (r11 != 3) goto L18;
        r12 = "memory_decode";
        goto L28
    L18:
        if (r11 != 4) goto L20;
        r12 = "bitmap_cache";
        goto L28
    L20:
        if (r11 == 5) goto L22;
        r12 = "unkown";
        goto L28
    L22:
        r12 = "simple_fresco";
    L30:
        ECExceptionMonitor.c("batchReportLoadImageInfo json error");
        goto L31
    }

    public static void r() {
        Set r0 = CollectionsKt.toSet(L.values());
        dm.a.a("FirstScreenStatistic").a("saveFirstScreenImageSet: " + r0.size() + ' ' + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FirstScreenStatistic$saveFirstScreenImageSet$1(r0, null), 3, null);
    }

    public static void e() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new FirstScreenStatistic$clear$1(null), 3, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new FirstScreenStatistic$clear$2(null), 3, null);
    }

    static {
        S = new FirstScreenStatistic();
        f = new HashMap();
        g = new HashMap();
        h = new HashMap();
        i = new LinkedHashSet();
        List<String> r0 = CollectionsKt.listOf(new String[]{"ec_na_mall_header", "ec_na_mall_topbar", "ec_na_mall_background", "ec_na_mall_combined", "ec_na_mall_product", "ec_na_mall_top_category_tab", "ec_na_mall_live_product", "ec_na_mall_live_cover", "ec_na_mall_live_avatar", "ec_na_mall_video_product", "ec_na_mall_video_avatar", "ec_na_mall_video_cover"});
        j = r0;
        k = CollectionsKt.listOf(new String[]{"ec_na_mall_header", "ec_na_mall_topbar", "ec_na_mall_background", "ec_na_mall_top_category_tab"});
        l = r0;
        int r1 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r10 = Boolean.FALSE;
        Object r11 = null;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L93;
        int r12 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L83
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L58
        Object r14 = SDKSettingsCacheManager.b().get("ec_first_screen_image_monitor_enable");     // Catch: Throwable -> L58
        if (r14 != null) goto L10;
    L55:
        Object r15 = null;
    L56:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L58
    L60:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L83
        if (r17 == null) goto L64;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L83
    L64:
        if (Result.isFailure-impl(r16) == false) goto L67;
        r16 = null;
    L67:
        if ((r16 instanceof Boolean) == true) goto L69;
        r16 = null;
    L69:
        Object r18 = (Boolean) r16;     // Catch: Throwable -> L83
        if (r18 != null) goto L179;
        Object r19 = jj4.a.a("ec_first_screen_image_monitor_enable", Boolean.class, r10, jj4.b.b.a());     // Catch: Throwable -> L83
        if (r19 != null) goto L76;
        Intrinsics.throwNpe();     // Catch: Throwable -> L83
    L76:
        if ((r19 instanceof Boolean) == true) goto L78;
        r19 = null;
    L78:
        Object r20 = (Boolean) r19;     // Catch: Throwable -> L83
        if (r20 != null) goto L81;
        r20 = r10;
    L81:
        r18 = Result.constructor-impl(r20);     // Catch: Throwable -> L83
    L86:
        if (Result.exceptionOrNull-impl(r18) == null) goto L179;
        r18 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_image_monitor_enable", Boolean.class, r10);     // Catch: Throwable -> L90
    L91:
        if (r18 != null) goto L179;
    L180:
        m = ((Boolean) r10).booleanValue();
        boolean r21 = true;
        n = true;
        int r22 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r23 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L271;
        int r24 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L261
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L236
        Object r26 = SDKSettingsCacheManager.b().get("ec_first_screen_simple_fresco_opt_enable");     // Catch: Throwable -> L236
        if (r26 != null) goto L188;
    L233:
        Object r27 = null;
    L234:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L236
    L238:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L261
        if (r29 == null) goto L242;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L261
    L242:
        if (Result.isFailure-impl(r28) == false) goto L245;
        r28 = null;
    L245:
        if ((r28 instanceof Boolean) == true) goto L247;
        r28 = null;
    L247:
        Object r30 = (Boolean) r28;     // Catch: Throwable -> L261
        if (r30 != null) goto L357;
        Object r31 = jj4.a.a("ec_first_screen_simple_fresco_opt_enable", Boolean.class, r23, jj4.b.b.a());     // Catch: Throwable -> L261
        if (r31 != null) goto L254;
        Intrinsics.throwNpe();     // Catch: Throwable -> L261
    L254:
        if ((r31 instanceof Boolean) == true) goto L256;
        r31 = null;
    L256:
        Object r32 = (Boolean) r31;     // Catch: Throwable -> L261
        if (r32 != null) goto L259;
        r32 = r23;
    L259:
        r30 = Result.constructor-impl(r32);     // Catch: Throwable -> L261
    L264:
        if (Result.exceptionOrNull-impl(r30) == null) goto L357;
        r30 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_simple_fresco_opt_enable", Boolean.class, r23);     // Catch: Throwable -> L268
    L269:
        if (r30 != null) goto L357;
    L358:
        o = ((Boolean) r23).booleanValue();
        int r33 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r34 = Boolean.TRUE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L449;
        int r35 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L439
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L414
        Object r37 = SDKSettingsCacheManager.b().get("ec_first_screen_post_fix_enable");     // Catch: Throwable -> L414
        if (r37 != null) goto L366;
    L411:
        Object r38 = null;
    L412:
        Object r39 = Result.constructor-impl(r38);     // Catch: Throwable -> L414
    L416:
        Throwable r40 = Result.exceptionOrNull-impl(r39);     // Catch: Throwable -> L439
        if (r40 == null) goto L420;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L439
    L420:
        if (Result.isFailure-impl(r39) == false) goto L423;
        r39 = null;
    L423:
        if ((r39 instanceof Boolean) == true) goto L425;
        r39 = null;
    L425:
        Object r41 = (Boolean) r39;     // Catch: Throwable -> L439
        if (r41 != null) goto L535;
        Object r42 = jj4.a.a("ec_first_screen_post_fix_enable", Boolean.class, r34, jj4.b.b.a());     // Catch: Throwable -> L439
        if (r42 != null) goto L432;
        Intrinsics.throwNpe();     // Catch: Throwable -> L439
    L432:
        if ((r42 instanceof Boolean) == true) goto L434;
        r42 = null;
    L434:
        Object r43 = (Boolean) r42;     // Catch: Throwable -> L439
        if (r43 != null) goto L437;
        r43 = r34;
    L437:
        r41 = Result.constructor-impl(r43);     // Catch: Throwable -> L439
    L442:
        if (Result.exceptionOrNull-impl(r41) == null) goto L535;
        r41 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_post_fix_enable", Boolean.class, r34);     // Catch: Throwable -> L446
    L447:
        if (r41 != null) goto L535;
    L536:
        p = ((Boolean) r34).booleanValue();
        q = new HashSet();
        r = new LinkedHashSet();
        s = new LinkedHashSet();
        v = new HashSet();
        w = new HashSet();
        x = new AtomicInteger(0);
        y = new AtomicInteger(0);
        z = new HashSet();
        A = new AtomicInteger(0);
        B = new q0();
        D = new LinkedHashSet();
        int r44 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r45 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L627;
        int r46 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L617
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L592
        Object r48 = SDKSettingsCacheManager.b().get("ec_first_screen_bitmap_place_holder");     // Catch: Throwable -> L592
        if (r48 != null) goto L544;
    L589:
        Object r49 = null;
    L590:
        Object r50 = Result.constructor-impl(r49);     // Catch: Throwable -> L592
    L594:
        Throwable r51 = Result.exceptionOrNull-impl(r50);     // Catch: Throwable -> L617
        if (r51 == null) goto L598;
        EnsureManager.ensureNotReachHere(r51);     // Catch: Throwable -> L617
    L598:
        if (Result.isFailure-impl(r50) == false) goto L601;
        r50 = null;
    L601:
        if ((r50 instanceof Boolean) == true) goto L603;
        r50 = null;
    L603:
        Object r52 = (Boolean) r50;     // Catch: Throwable -> L617
        if (r52 != null) goto L713;
        Object r53 = jj4.a.a("ec_first_screen_bitmap_place_holder", Boolean.class, r45, jj4.b.b.a());     // Catch: Throwable -> L617
        if (r53 != null) goto L610;
        Intrinsics.throwNpe();     // Catch: Throwable -> L617
    L610:
        if ((r53 instanceof Boolean) == true) goto L612;
        r53 = null;
    L612:
        Object r54 = (Boolean) r53;     // Catch: Throwable -> L617
        if (r54 != null) goto L615;
        r54 = r45;
    L615:
        r52 = Result.constructor-impl(r54);     // Catch: Throwable -> L617
    L620:
        if (Result.exceptionOrNull-impl(r52) == null) goto L713;
        r52 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_bitmap_place_holder", Boolean.class, r45);     // Catch: Throwable -> L624
    L625:
        if (r52 != null) goto L713;
    L714:
        E = ((Boolean) r45).booleanValue();
        int r55 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r56 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L805;
        int r57 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L795
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L770
        Object r59 = SDKSettingsCacheManager.b().get("ec_first_screen_delay_late_flip_enable");     // Catch: Throwable -> L770
        if (r59 != null) goto L722;
    L767:
        Object r60 = null;
    L768:
        Object r61 = Result.constructor-impl(r60);     // Catch: Throwable -> L770
    L772:
        Throwable r62 = Result.exceptionOrNull-impl(r61);     // Catch: Throwable -> L795
        if (r62 == null) goto L776;
        EnsureManager.ensureNotReachHere(r62);     // Catch: Throwable -> L795
    L776:
        if (Result.isFailure-impl(r61) == false) goto L779;
        r61 = null;
    L779:
        if ((r61 instanceof Boolean) == true) goto L781;
        r61 = null;
    L781:
        Object r63 = (Boolean) r61;     // Catch: Throwable -> L795
        if (r63 != null) goto L891;
        Object r64 = jj4.a.a("ec_first_screen_delay_late_flip_enable", Boolean.class, r56, jj4.b.b.a());     // Catch: Throwable -> L795
        if (r64 != null) goto L788;
        Intrinsics.throwNpe();     // Catch: Throwable -> L795
    L788:
        if ((r64 instanceof Boolean) == true) goto L790;
        r64 = null;
    L790:
        Object r65 = (Boolean) r64;     // Catch: Throwable -> L795
        if (r65 != null) goto L793;
        r65 = r56;
    L793:
        r63 = Result.constructor-impl(r65);     // Catch: Throwable -> L795
    L798:
        if (Result.exceptionOrNull-impl(r63) == null) goto L891;
        r63 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_delay_late_flip_enable", Boolean.class, r56);     // Catch: Throwable -> L802
    L803:
        if (r63 != null) goto L891;
    L892:
        F = ((Boolean) r56).booleanValue();
        int r66 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r67 = Boolean.FALSE;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L983;
        int r68 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L973
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L948
        Object r70 = SDKSettingsCacheManager.b().get("ec_first_screen_lynx_bitmap_hit_enable");     // Catch: Throwable -> L948
        if (r70 != null) goto L900;
    L945:
        Object r71 = null;
    L946:
        Object r72 = Result.constructor-impl(r71);     // Catch: Throwable -> L948
    L950:
        Throwable r73 = Result.exceptionOrNull-impl(r72);     // Catch: Throwable -> L973
        if (r73 == null) goto L954;
        EnsureManager.ensureNotReachHere(r73);     // Catch: Throwable -> L973
    L954:
        if (Result.isFailure-impl(r72) == false) goto L957;
        r72 = null;
    L957:
        if ((r72 instanceof Boolean) == true) goto L959;
        r72 = null;
    L959:
        Object r74 = (Boolean) r72;     // Catch: Throwable -> L973
        if (r74 != null) goto L1069;
        Object r75 = jj4.a.a("ec_first_screen_lynx_bitmap_hit_enable", Boolean.class, r67, jj4.b.b.a());     // Catch: Throwable -> L973
        if (r75 != null) goto L966;
        Intrinsics.throwNpe();     // Catch: Throwable -> L973
    L966:
        if ((r75 instanceof Boolean) == true) goto L968;
        r75 = null;
    L968:
        Object r76 = (Boolean) r75;     // Catch: Throwable -> L973
        if (r76 != null) goto L971;
        r76 = r67;
    L971:
        r74 = Result.constructor-impl(r76);     // Catch: Throwable -> L973
    L976:
        if (Result.exceptionOrNull-impl(r74) == null) goto L1069;
        r74 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_lynx_bitmap_hit_enable", Boolean.class, r67);     // Catch: Throwable -> L980
    L981:
        if (r74 != null) goto L1069;
    L1070:
        ((Boolean) r67).booleanValue();
        G = true;
        I = new Handler(Looper.getMainLooper());
        J = new ConcurrentHashMap();
        K = new ConcurrentHashMap();
        L = new ConcurrentHashMap();
        M = new ConcurrentHashMap();
        new ConcurrentHashMap();
        N = new ConcurrentHashMap();
        O = new ConcurrentHashMap();
        P = new ConcurrentHashMap();
        Q = new ConcurrentLinkedQueue();
        R = LazyKt.lazy(FirstScreenStatistic$bitmapCacheDir$2.INSTANCE);
        if (m == false) goto L1365;
        int r77 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r78 = "";
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L1164;
        int r79 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r80 = Result.Companion;     // Catch: Throwable -> L1154
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L1128
        Object r81 = SDKSettingsCacheManager.b().get("ec_first_screen_image_filter");     // Catch: Throwable -> L1128
        if (r81 != null) goto L1080;
    L1125:
        Object r82 = null;
    L1126:
        Object r83 = Result.constructor-impl(r82);     // Catch: Throwable -> L1128
    L1130:
        Throwable r84 = Result.exceptionOrNull-impl(r83);     // Catch: Throwable -> L1154
        if (r84 == null) goto L1134;
        EnsureManager.ensureNotReachHere(r84);     // Catch: Throwable -> L1154
    L1134:
        if (Result.isFailure-impl(r83) == false) goto L1137;
        r83 = null;
    L1137:
        if ((r83 instanceof String) == true) goto L1139;
        r83 = null;
    L1139:
        Object r85 = (String) r83;     // Catch: Throwable -> L1154
        if (r85 != null) goto L1252;
        Object r86 = jj4.a.a("ec_first_screen_image_filter", String.class, "", jj4.b.b.a());     // Catch: Throwable -> L1154
        if (r86 != null) goto L1146;
        Intrinsics.throwNpe();     // Catch: Throwable -> L1154
    L1146:
        if ((r86 instanceof String) == false) goto L1149;
        r11 = r86;
    L1149:
        String r87 = (String) r11;     // Catch: Throwable -> L1154
        if (r87 != null) goto L1152;
        r87 = "";
    L1152:
        r85 = Result.constructor-impl(r87);     // Catch: Throwable -> L1154
    L1157:
        if (Result.exceptionOrNull-impl(r85) == null) goto L1252;
        r85 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_first_screen_image_filter", String.class, "");     // Catch: Throwable -> L1161
    L1162:
        if (r85 != null) goto L1252;
    L1253:
        String r88 = (String) r78;
        if (r88.length() > 0) goto L1257;
        r21 = false;
    L1257:
        if (r21 == false) goto L1259;
        l = StringsKt.split$default(r88, new String[]{","}, false, 0, 6, null);
    L1260:
        Iterator<T> r89 = l.iterator();
    L1262:
        if (r89.hasNext() == false) goto L1264;
        String r90 = (String) r89.next();
        f.put(r90, new HashMap());
        g.put(r90, new HashMap());
        J.put(r90, new ConcurrentHashMap());
        goto L1262
    L1264:
        f.put("ec_na_mall_other", new HashMap());
        g.put("ec_na_mall_other", new HashMap());
        J.put("ec_na_mall_other", new ConcurrentHashMap());
        return;
    L1259:
        l = j;
    L1161:
        r85 = "";
    L1252:
        r78 = r85;
        goto L1253
    L1080:
        if ((r81 instanceof String) == true) goto L1082;
        Object r91 = null;
    L1083:
        r82 = (String) r91;     // Catch: Throwable -> L1128
        if (r82 != null) goto L1126;
        if ((r81 instanceof Number) == false) goto L1113;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L1095;
        Float r92 = Float.valueOf(((Number) r81).floatValue());     // Catch: Throwable -> L1128
        if ((r92 instanceof String) == true) goto L1093;
        r92 = null;
    L1093:
        r82 = (String) r92;     // Catch: Throwable -> L1128
        goto L1126
    L1095:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L1101;
        Double r93 = Double.valueOf(((Number) r81).doubleValue());     // Catch: Throwable -> L1128
        if ((r93 instanceof String) == true) goto L1099;
        r93 = null;
    L1099:
        r82 = (String) r93;     // Catch: Throwable -> L1128
        goto L1126
    L1101:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L1107;
        Integer r94 = Integer.valueOf(((Number) r81).intValue());     // Catch: Throwable -> L1128
        if ((r94 instanceof String) == true) goto L1105;
        r94 = null;
    L1105:
        r82 = (String) r94;     // Catch: Throwable -> L1128
        goto L1126
    L1107:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L1113;
        Long r95 = Long.valueOf(((Number) r81).longValue());     // Catch: Throwable -> L1128
        if ((r95 instanceof String) == true) goto L1111;
        r95 = null;
    L1111:
        r82 = (String) r95;     // Catch: Throwable -> L1128
    L1113:
        if ((r81 instanceof JSONObject) == false) goto L1115;
    L1282:
        Object r96 = SDKSettingsCacheManager.a().fromJson(r81.toString(), String.class);     // Catch: Throwable -> L1121
        if ((r96 instanceof String) == true) goto L1119;
        r96 = null;
    L1119:
        Object r97 = Result.constructor-impl((String) r96);     // Catch: Throwable -> L1121
    L1123:
        r82 = r97;
        if (Result.isFailure-impl(r82) == false) goto L1126;
    L1121:
        th = move-exception;
        Result.Companion r98 = Result.Companion;     // Catch: Throwable -> L1128
        r97 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1128
        goto L1123
    L1115:
        if ((r81 instanceof JSONArray) == false) goto L1125;
    L1082:
        r91 = r81;
    L1128:
        th = move-exception;
        Result.Companion r99 = Result.Companion;     // Catch: Throwable -> L1154
        r83 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1154
    L1154:
        th = move-exception;
        Result.Companion r100 = Result.Companion;
        r85 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L1157
    L1164:
        int r101 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r102 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L1245
        Object r104 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_image_filter");     // Catch: Throwable -> L1218
        if (r104 != null) goto L1170;
    L1215:
        Object r105 = null;
    L1216:
        Object r106 = Result.constructor-impl(r105);     // Catch: Throwable -> L1218
    L1220:
        Throwable r107 = Result.exceptionOrNull-impl(r106);     // Catch: Throwable -> L1245
        if (r107 == null) goto L1224;
        EnsureManager.ensureNotReachHere(r107);     // Catch: Throwable -> L1245
    L1224:
        if (Result.isFailure-impl(r106) == false) goto L1227;
        r106 = null;
    L1227:
        if ((r106 instanceof String) == true) goto L1229;
        r106 = null;
    L1229:
        r85 = (String) r106;     // Catch: Throwable -> L1245
        if (r85 != null) goto L1252;
        IHybridHostService r108 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L1245
        if (r108 == null) goto L1235;
        Object r109 = r108.getHostABValue("ec_first_screen_image_filter", "");     // Catch: Throwable -> L1245
    L1236:
        if (r109 == null) goto L1253;
        if ((r109 instanceof String) == false) goto L1241;
        r11 = r109;
    L1241:
        String r110 = (String) r11;     // Catch: Throwable -> L1245
        if (r110 == null) goto L1253;
        r78 = r110;
        goto L1253
    L1235:
        r109 = null;
        goto L1236
    L1170:
        if ((r104 instanceof String) == true) goto L1172;
        Object r111 = null;
    L1173:
        r105 = (String) r111;     // Catch: Throwable -> L1218
        if (r105 != null) goto L1216;
        if ((r104 instanceof Number) == false) goto L1203;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L1185;
        Float r112 = Float.valueOf(((Number) r104).floatValue());     // Catch: Throwable -> L1218
        if ((r112 instanceof String) == true) goto L1183;
        r112 = null;
    L1183:
        r105 = (String) r112;     // Catch: Throwable -> L1218
        goto L1216
    L1185:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L1191;
        Double r113 = Double.valueOf(((Number) r104).doubleValue());     // Catch: Throwable -> L1218
        if ((r113 instanceof String) == true) goto L1189;
        r113 = null;
    L1189:
        r105 = (String) r113;     // Catch: Throwable -> L1218
        goto L1216
    L1191:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L1197;
        Integer r114 = Integer.valueOf(((Number) r104).intValue());     // Catch: Throwable -> L1218
        if ((r114 instanceof String) == true) goto L1195;
        r114 = null;
    L1195:
        r105 = (String) r114;     // Catch: Throwable -> L1218
        goto L1216
    L1197:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L1203;
        Long r115 = Long.valueOf(((Number) r104).longValue());     // Catch: Throwable -> L1218
        if ((r115 instanceof String) == true) goto L1201;
        r115 = null;
    L1201:
        r105 = (String) r115;     // Catch: Throwable -> L1218
    L1203:
        if ((r104 instanceof JSONObject) == false) goto L1205;
    L1268:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L1211
        Object r116 = SDKSettingsCacheManager.a().fromJson(r104.toString(), String.class);     // Catch: Throwable -> L1211
        if ((r116 instanceof String) == true) goto L1209;
        r116 = null;
    L1209:
        Object r117 = Result.constructor-impl((String) r116);     // Catch: Throwable -> L1211
    L1213:
        r105 = r117;
        if (Result.isFailure-impl(r105) == false) goto L1216;
    L1211:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L1218
        r117 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1218
        goto L1213
    L1205:
        if ((r104 instanceof JSONArray) == false) goto L1215;
    L1172:
        r111 = r104;
    L1218:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L1245
        r106 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1245
    L1245:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r85 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r121 = Result.exceptionOrNull-impl(r85);
        if (r121 == null) goto L1250;
        EnsureManager.ensureNotReachHere(r121);
    L1250:
        if (Result.isFailure-impl(r85) == false) goto L1252;
    L1365:
        return;
    L980:
        r74 = r67;
    L1069:
        r67 = r74;
        goto L1070
    L900:
        if ((r70 instanceof Boolean) == true) goto L902;
        Object r122 = null;
    L903:
        r71 = (Boolean) r122;     // Catch: Throwable -> L948
        if (r71 != null) goto L946;
        if ((r70 instanceof Number) == false) goto L933;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L915;
        Float r123 = Float.valueOf(((Number) r70).floatValue());     // Catch: Throwable -> L948
        if ((r123 instanceof Boolean) == true) goto L913;
        r123 = null;
    L913:
        r71 = (Boolean) r123;     // Catch: Throwable -> L948
        goto L946
    L915:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L921;
        Double r124 = Double.valueOf(((Number) r70).doubleValue());     // Catch: Throwable -> L948
        if ((r124 instanceof Boolean) == true) goto L919;
        r124 = null;
    L919:
        r71 = (Boolean) r124;     // Catch: Throwable -> L948
        goto L946
    L921:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L927;
        Integer r125 = Integer.valueOf(((Number) r70).intValue());     // Catch: Throwable -> L948
        if ((r125 instanceof Boolean) == true) goto L925;
        r125 = null;
    L925:
        r71 = (Boolean) r125;     // Catch: Throwable -> L948
        goto L946
    L927:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L933;
        Long r126 = Long.valueOf(((Number) r70).longValue());     // Catch: Throwable -> L948
        if ((r126 instanceof Boolean) == true) goto L931;
        r126 = null;
    L931:
        r71 = (Boolean) r126;     // Catch: Throwable -> L948
    L933:
        if ((r70 instanceof JSONObject) == false) goto L935;
    L1356:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r70.toString(), Boolean.class);     // Catch: Throwable -> L941
        if ((r127 instanceof Boolean) == true) goto L939;
        r127 = null;
    L939:
        Object r128 = Result.constructor-impl((Boolean) r127);     // Catch: Throwable -> L941
    L943:
        r71 = r128;
        if (Result.isFailure-impl(r71) == false) goto L946;
    L941:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L948
        r128 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L948
        goto L943
    L935:
        if ((r70 instanceof JSONArray) == false) goto L945;
    L902:
        r122 = r70;
    L948:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L973
        r72 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L973
    L973:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r74 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L976
    L983:
        int r132 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r133 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L1062
        Object r135 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_lynx_bitmap_hit_enable");     // Catch: Throwable -> L1037
        if (r135 != null) goto L989;
    L1034:
        Object r136 = null;
    L1035:
        Object r137 = Result.constructor-impl(r136);     // Catch: Throwable -> L1037
    L1039:
        Throwable r138 = Result.exceptionOrNull-impl(r137);     // Catch: Throwable -> L1062
        if (r138 == null) goto L1043;
        EnsureManager.ensureNotReachHere(r138);     // Catch: Throwable -> L1062
    L1043:
        if (Result.isFailure-impl(r137) == false) goto L1046;
        r137 = null;
    L1046:
        if ((r137 instanceof Boolean) == true) goto L1048;
        r137 = null;
    L1048:
        r74 = (Boolean) r137;     // Catch: Throwable -> L1062
        if (r74 != null) goto L1069;
        IHybridHostService r139 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L1062
        if (r139 == null) goto L1054;
        Object r140 = r139.getHostABValue("ec_first_screen_lynx_bitmap_hit_enable", r67);     // Catch: Throwable -> L1062
    L1055:
        if (r140 == null) goto L1070;
        if ((r140 instanceof Boolean) == true) goto L1059;
        r140 = null;
    L1059:
        r74 = (Boolean) r140;     // Catch: Throwable -> L1062
        if (r74 != null) goto L1069;
    L1054:
        r140 = null;
        goto L1055
    L989:
        if ((r135 instanceof Boolean) == true) goto L991;
        Object r141 = null;
    L992:
        r136 = (Boolean) r141;     // Catch: Throwable -> L1037
        if (r136 != null) goto L1035;
        if ((r135 instanceof Number) == false) goto L1022;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L1004;
        Float r142 = Float.valueOf(((Number) r135).floatValue());     // Catch: Throwable -> L1037
        if ((r142 instanceof Boolean) == true) goto L1002;
        r142 = null;
    L1002:
        r136 = (Boolean) r142;     // Catch: Throwable -> L1037
        goto L1035
    L1004:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L1010;
        Double r143 = Double.valueOf(((Number) r135).doubleValue());     // Catch: Throwable -> L1037
        if ((r143 instanceof Boolean) == true) goto L1008;
        r143 = null;
    L1008:
        r136 = (Boolean) r143;     // Catch: Throwable -> L1037
        goto L1035
    L1010:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L1016;
        Integer r144 = Integer.valueOf(((Number) r135).intValue());     // Catch: Throwable -> L1037
        if ((r144 instanceof Boolean) == true) goto L1014;
        r144 = null;
    L1014:
        r136 = (Boolean) r144;     // Catch: Throwable -> L1037
        goto L1035
    L1016:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L1022;
        Long r145 = Long.valueOf(((Number) r135).longValue());     // Catch: Throwable -> L1037
        if ((r145 instanceof Boolean) == true) goto L1020;
        r145 = null;
    L1020:
        r136 = (Boolean) r145;     // Catch: Throwable -> L1037
    L1022:
        if ((r135 instanceof JSONObject) == false) goto L1024;
    L1342:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L1030
        Object r146 = SDKSettingsCacheManager.a().fromJson(r135.toString(), Boolean.class);     // Catch: Throwable -> L1030
        if ((r146 instanceof Boolean) == true) goto L1028;
        r146 = null;
    L1028:
        Object r147 = Result.constructor-impl((Boolean) r146);     // Catch: Throwable -> L1030
    L1032:
        r136 = r147;
        if (Result.isFailure-impl(r136) == false) goto L1035;
    L1030:
        th = move-exception;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L1037
        r147 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1037
        goto L1032
    L1024:
        if ((r135 instanceof JSONArray) == false) goto L1034;
    L991:
        r141 = r135;
    L1037:
        th = move-exception;
        Result.Companion r149 = Result.Companion;     // Catch: Throwable -> L1062
        r137 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L1062
    L1062:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r74 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r151 = Result.exceptionOrNull-impl(r74);
        if (r151 == null) goto L1067;
        EnsureManager.ensureNotReachHere(r151);
    L1067:
        if (Result.isFailure-impl(r74) == false) goto L1069;
    L802:
        r63 = r56;
    L891:
        r56 = r63;
        goto L892
    L722:
        if ((r59 instanceof Boolean) == true) goto L724;
        Object r152 = null;
    L725:
        r60 = (Boolean) r152;     // Catch: Throwable -> L770
        if (r60 != null) goto L768;
        if ((r59 instanceof Number) == false) goto L755;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L737;
        Float r153 = Float.valueOf(((Number) r59).floatValue());     // Catch: Throwable -> L770
        if ((r153 instanceof Boolean) == true) goto L735;
        r153 = null;
    L735:
        r60 = (Boolean) r153;     // Catch: Throwable -> L770
        goto L768
    L737:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L743;
        Double r154 = Double.valueOf(((Number) r59).doubleValue());     // Catch: Throwable -> L770
        if ((r154 instanceof Boolean) == true) goto L741;
        r154 = null;
    L741:
        r60 = (Boolean) r154;     // Catch: Throwable -> L770
        goto L768
    L743:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L749;
        Integer r155 = Integer.valueOf(((Number) r59).intValue());     // Catch: Throwable -> L770
        if ((r155 instanceof Boolean) == true) goto L747;
        r155 = null;
    L747:
        r60 = (Boolean) r155;     // Catch: Throwable -> L770
        goto L768
    L749:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L755;
        Long r156 = Long.valueOf(((Number) r59).longValue());     // Catch: Throwable -> L770
        if ((r156 instanceof Boolean) == true) goto L753;
        r156 = null;
    L753:
        r60 = (Boolean) r156;     // Catch: Throwable -> L770
    L755:
        if ((r59 instanceof JSONObject) == false) goto L757;
    L1298:
        Object r157 = SDKSettingsCacheManager.a().fromJson(r59.toString(), Boolean.class);     // Catch: Throwable -> L763
        if ((r157 instanceof Boolean) == true) goto L761;
        r157 = null;
    L761:
        Object r158 = Result.constructor-impl((Boolean) r157);     // Catch: Throwable -> L763
    L765:
        r60 = r158;
        if (Result.isFailure-impl(r60) == false) goto L768;
    L763:
        th = move-exception;
        Result.Companion r159 = Result.Companion;     // Catch: Throwable -> L770
        r158 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L770
        goto L765
    L757:
        if ((r59 instanceof JSONArray) == false) goto L767;
    L724:
        r152 = r59;
    L770:
        th = move-exception;
        Result.Companion r160 = Result.Companion;     // Catch: Throwable -> L795
        r61 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L795
    L795:
        th = move-exception;
        Result.Companion r161 = Result.Companion;
        r63 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L798
    L805:
        int r162 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r163 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r164 = Result.Companion;     // Catch: Throwable -> L884
        Object r165 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_delay_late_flip_enable");     // Catch: Throwable -> L859
        if (r165 != null) goto L811;
    L856:
        Object r166 = null;
    L857:
        Object r167 = Result.constructor-impl(r166);     // Catch: Throwable -> L859
    L861:
        Throwable r168 = Result.exceptionOrNull-impl(r167);     // Catch: Throwable -> L884
        if (r168 == null) goto L865;
        EnsureManager.ensureNotReachHere(r168);     // Catch: Throwable -> L884
    L865:
        if (Result.isFailure-impl(r167) == false) goto L868;
        r167 = null;
    L868:
        if ((r167 instanceof Boolean) == true) goto L870;
        r167 = null;
    L870:
        r63 = (Boolean) r167;     // Catch: Throwable -> L884
        if (r63 != null) goto L891;
        IHybridHostService r169 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L884
        if (r169 == null) goto L876;
        Object r170 = r169.getHostABValue("ec_first_screen_delay_late_flip_enable", r56);     // Catch: Throwable -> L884
    L877:
        if (r170 == null) goto L892;
        if ((r170 instanceof Boolean) == true) goto L881;
        r170 = null;
    L881:
        r63 = (Boolean) r170;     // Catch: Throwable -> L884
        if (r63 != null) goto L891;
    L876:
        r170 = null;
        goto L877
    L811:
        if ((r165 instanceof Boolean) == true) goto L813;
        Object r171 = null;
    L814:
        r166 = (Boolean) r171;     // Catch: Throwable -> L859
        if (r166 != null) goto L857;
        if ((r165 instanceof Number) == false) goto L844;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L826;
        Float r172 = Float.valueOf(((Number) r165).floatValue());     // Catch: Throwable -> L859
        if ((r172 instanceof Boolean) == true) goto L824;
        r172 = null;
    L824:
        r166 = (Boolean) r172;     // Catch: Throwable -> L859
        goto L857
    L826:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L832;
        Double r173 = Double.valueOf(((Number) r165).doubleValue());     // Catch: Throwable -> L859
        if ((r173 instanceof Boolean) == true) goto L830;
        r173 = null;
    L830:
        r166 = (Boolean) r173;     // Catch: Throwable -> L859
        goto L857
    L832:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L838;
        Integer r174 = Integer.valueOf(((Number) r165).intValue());     // Catch: Throwable -> L859
        if ((r174 instanceof Boolean) == true) goto L836;
        r174 = null;
    L836:
        r166 = (Boolean) r174;     // Catch: Throwable -> L859
        goto L857
    L838:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L844;
        Long r175 = Long.valueOf(((Number) r165).longValue());     // Catch: Throwable -> L859
        if ((r175 instanceof Boolean) == true) goto L842;
        r175 = null;
    L842:
        r166 = (Boolean) r175;     // Catch: Throwable -> L859
    L844:
        if ((r165 instanceof JSONObject) == false) goto L846;
    L1280:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L852
        Object r176 = SDKSettingsCacheManager.a().fromJson(r165.toString(), Boolean.class);     // Catch: Throwable -> L852
        if ((r176 instanceof Boolean) == true) goto L850;
        r176 = null;
    L850:
        Object r177 = Result.constructor-impl((Boolean) r176);     // Catch: Throwable -> L852
    L854:
        r166 = r177;
        if (Result.isFailure-impl(r166) == false) goto L857;
    L852:
        th = move-exception;
        Result.Companion r178 = Result.Companion;     // Catch: Throwable -> L859
        r177 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L859
        goto L854
    L846:
        if ((r165 instanceof JSONArray) == false) goto L856;
    L813:
        r171 = r165;
    L859:
        th = move-exception;
        Result.Companion r179 = Result.Companion;     // Catch: Throwable -> L884
        r167 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L884
    L884:
        th = move-exception;
        Result.Companion r180 = Result.Companion;
        r63 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r181 = Result.exceptionOrNull-impl(r63);
        if (r181 == null) goto L889;
        EnsureManager.ensureNotReachHere(r181);
    L889:
        if (Result.isFailure-impl(r63) == false) goto L891;
    L624:
        r52 = r45;
    L713:
        r45 = r52;
        goto L714
    L544:
        if ((r48 instanceof Boolean) == true) goto L546;
        Object r182 = null;
    L547:
        r49 = (Boolean) r182;     // Catch: Throwable -> L592
        if (r49 != null) goto L590;
        if ((r48 instanceof Number) == false) goto L577;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L559;
        Float r183 = Float.valueOf(((Number) r48).floatValue());     // Catch: Throwable -> L592
        if ((r183 instanceof Boolean) == true) goto L557;
        r183 = null;
    L557:
        r49 = (Boolean) r183;     // Catch: Throwable -> L592
        goto L590
    L559:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L565;
        Double r184 = Double.valueOf(((Number) r48).doubleValue());     // Catch: Throwable -> L592
        if ((r184 instanceof Boolean) == true) goto L563;
        r184 = null;
    L563:
        r49 = (Boolean) r184;     // Catch: Throwable -> L592
        goto L590
    L565:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L571;
        Integer r185 = Integer.valueOf(((Number) r48).intValue());     // Catch: Throwable -> L592
        if ((r185 instanceof Boolean) == true) goto L569;
        r185 = null;
    L569:
        r49 = (Boolean) r185;     // Catch: Throwable -> L592
        goto L590
    L571:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L577;
        Long r186 = Long.valueOf(((Number) r48).longValue());     // Catch: Throwable -> L592
        if ((r186 instanceof Boolean) == true) goto L575;
        r186 = null;
    L575:
        r49 = (Boolean) r186;     // Catch: Throwable -> L592
    L577:
        if ((r48 instanceof JSONObject) == false) goto L579;
    L1334:
        Object r187 = SDKSettingsCacheManager.a().fromJson(r48.toString(), Boolean.class);     // Catch: Throwable -> L585
        if ((r187 instanceof Boolean) == true) goto L583;
        r187 = null;
    L583:
        Object r188 = Result.constructor-impl((Boolean) r187);     // Catch: Throwable -> L585
    L587:
        r49 = r188;
        if (Result.isFailure-impl(r49) == false) goto L590;
    L585:
        th = move-exception;
        Result.Companion r189 = Result.Companion;     // Catch: Throwable -> L592
        r188 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L592
        goto L587
    L579:
        if ((r48 instanceof JSONArray) == false) goto L589;
    L546:
        r182 = r48;
    L592:
        th = move-exception;
        Result.Companion r190 = Result.Companion;     // Catch: Throwable -> L617
        r50 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L617
    L617:
        th = move-exception;
        Result.Companion r191 = Result.Companion;
        r52 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L620
    L627:
        int r192 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r193 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r194 = Result.Companion;     // Catch: Throwable -> L706
        Object r195 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_bitmap_place_holder");     // Catch: Throwable -> L681
        if (r195 != null) goto L633;
    L678:
        Object r196 = null;
    L679:
        Object r197 = Result.constructor-impl(r196);     // Catch: Throwable -> L681
    L683:
        Throwable r198 = Result.exceptionOrNull-impl(r197);     // Catch: Throwable -> L706
        if (r198 == null) goto L687;
        EnsureManager.ensureNotReachHere(r198);     // Catch: Throwable -> L706
    L687:
        if (Result.isFailure-impl(r197) == false) goto L690;
        r197 = null;
    L690:
        if ((r197 instanceof Boolean) == true) goto L692;
        r197 = null;
    L692:
        r52 = (Boolean) r197;     // Catch: Throwable -> L706
        if (r52 != null) goto L713;
        IHybridHostService r199 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L706
        if (r199 == null) goto L698;
        Object r200 = r199.getHostABValue("ec_first_screen_bitmap_place_holder", r45);     // Catch: Throwable -> L706
    L699:
        if (r200 == null) goto L714;
        if ((r200 instanceof Boolean) == true) goto L703;
        r200 = null;
    L703:
        r52 = (Boolean) r200;     // Catch: Throwable -> L706
        if (r52 != null) goto L713;
    L698:
        r200 = null;
        goto L699
    L633:
        if ((r195 instanceof Boolean) == true) goto L635;
        Object r201 = null;
    L636:
        r196 = (Boolean) r201;     // Catch: Throwable -> L681
        if (r196 != null) goto L679;
        if ((r195 instanceof Number) == false) goto L666;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L648;
        Float r202 = Float.valueOf(((Number) r195).floatValue());     // Catch: Throwable -> L681
        if ((r202 instanceof Boolean) == true) goto L646;
        r202 = null;
    L646:
        r196 = (Boolean) r202;     // Catch: Throwable -> L681
        goto L679
    L648:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L654;
        Double r203 = Double.valueOf(((Number) r195).doubleValue());     // Catch: Throwable -> L681
        if ((r203 instanceof Boolean) == true) goto L652;
        r203 = null;
    L652:
        r196 = (Boolean) r203;     // Catch: Throwable -> L681
        goto L679
    L654:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L660;
        Integer r204 = Integer.valueOf(((Number) r195).intValue());     // Catch: Throwable -> L681
        if ((r204 instanceof Boolean) == true) goto L658;
        r204 = null;
    L658:
        r196 = (Boolean) r204;     // Catch: Throwable -> L681
        goto L679
    L660:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L666;
        Long r205 = Long.valueOf(((Number) r195).longValue());     // Catch: Throwable -> L681
        if ((r205 instanceof Boolean) == true) goto L664;
        r205 = null;
    L664:
        r196 = (Boolean) r205;     // Catch: Throwable -> L681
    L666:
        if ((r195 instanceof JSONObject) == false) goto L668;
    L1324:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L674
        Object r206 = SDKSettingsCacheManager.a().fromJson(r195.toString(), Boolean.class);     // Catch: Throwable -> L674
        if ((r206 instanceof Boolean) == true) goto L672;
        r206 = null;
    L672:
        Object r207 = Result.constructor-impl((Boolean) r206);     // Catch: Throwable -> L674
    L676:
        r196 = r207;
        if (Result.isFailure-impl(r196) == false) goto L679;
    L674:
        th = move-exception;
        Result.Companion r208 = Result.Companion;     // Catch: Throwable -> L681
        r207 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L681
        goto L676
    L668:
        if ((r195 instanceof JSONArray) == false) goto L678;
    L635:
        r201 = r195;
    L681:
        th = move-exception;
        Result.Companion r209 = Result.Companion;     // Catch: Throwable -> L706
        r197 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L706
    L706:
        th = move-exception;
        Result.Companion r210 = Result.Companion;
        r52 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r211 = Result.exceptionOrNull-impl(r52);
        if (r211 == null) goto L711;
        EnsureManager.ensureNotReachHere(r211);
    L711:
        if (Result.isFailure-impl(r52) == false) goto L713;
    L446:
        r41 = r34;
    L535:
        r34 = r41;
        goto L536
    L366:
        if ((r37 instanceof Boolean) == true) goto L368;
        Object r212 = null;
    L369:
        r38 = (Boolean) r212;     // Catch: Throwable -> L414
        if (r38 != null) goto L412;
        if ((r37 instanceof Number) == false) goto L399;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L381;
        Float r213 = Float.valueOf(((Number) r37).floatValue());     // Catch: Throwable -> L414
        if ((r213 instanceof Boolean) == true) goto L379;
        r213 = null;
    L379:
        r38 = (Boolean) r213;     // Catch: Throwable -> L414
        goto L412
    L381:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L387;
        Double r214 = Double.valueOf(((Number) r37).doubleValue());     // Catch: Throwable -> L414
        if ((r214 instanceof Boolean) == true) goto L385;
        r214 = null;
    L385:
        r38 = (Boolean) r214;     // Catch: Throwable -> L414
        goto L412
    L387:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L393;
        Integer r215 = Integer.valueOf(((Number) r37).intValue());     // Catch: Throwable -> L414
        if ((r215 instanceof Boolean) == true) goto L391;
        r215 = null;
    L391:
        r38 = (Boolean) r215;     // Catch: Throwable -> L414
        goto L412
    L393:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L399;
        Long r216 = Long.valueOf(((Number) r37).longValue());     // Catch: Throwable -> L414
        if ((r216 instanceof Boolean) == true) goto L397;
        r216 = null;
    L397:
        r38 = (Boolean) r216;     // Catch: Throwable -> L414
    L399:
        if ((r37 instanceof JSONObject) == false) goto L401;
    L1316:
        Object r217 = SDKSettingsCacheManager.a().fromJson(r37.toString(), Boolean.class);     // Catch: Throwable -> L407
        if ((r217 instanceof Boolean) == true) goto L405;
        r217 = null;
    L405:
        Object r218 = Result.constructor-impl((Boolean) r217);     // Catch: Throwable -> L407
    L409:
        r38 = r218;
        if (Result.isFailure-impl(r38) == false) goto L412;
    L407:
        th = move-exception;
        Result.Companion r219 = Result.Companion;     // Catch: Throwable -> L414
        r218 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L414
        goto L409
    L401:
        if ((r37 instanceof JSONArray) == false) goto L411;
    L368:
        r212 = r37;
    L414:
        th = move-exception;
        Result.Companion r220 = Result.Companion;     // Catch: Throwable -> L439
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L439
    L439:
        th = move-exception;
        Result.Companion r221 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L442
    L449:
        int r222 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r223 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r224 = Result.Companion;     // Catch: Throwable -> L528
        Object r225 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_post_fix_enable");     // Catch: Throwable -> L503
        if (r225 != null) goto L455;
    L500:
        Object r226 = null;
    L501:
        Object r227 = Result.constructor-impl(r226);     // Catch: Throwable -> L503
    L505:
        Throwable r228 = Result.exceptionOrNull-impl(r227);     // Catch: Throwable -> L528
        if (r228 == null) goto L509;
        EnsureManager.ensureNotReachHere(r228);     // Catch: Throwable -> L528
    L509:
        if (Result.isFailure-impl(r227) == false) goto L512;
        r227 = null;
    L512:
        if ((r227 instanceof Boolean) == true) goto L514;
        r227 = null;
    L514:
        r41 = (Boolean) r227;     // Catch: Throwable -> L528
        if (r41 != null) goto L535;
        IHybridHostService r229 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L528
        if (r229 == null) goto L520;
        Object r230 = r229.getHostABValue("ec_first_screen_post_fix_enable", r34);     // Catch: Throwable -> L528
    L521:
        if (r230 == null) goto L536;
        if ((r230 instanceof Boolean) == true) goto L525;
        r230 = null;
    L525:
        r41 = (Boolean) r230;     // Catch: Throwable -> L528
        if (r41 != null) goto L535;
    L520:
        r230 = null;
        goto L521
    L455:
        if ((r225 instanceof Boolean) == true) goto L457;
        Object r231 = null;
    L458:
        r226 = (Boolean) r231;     // Catch: Throwable -> L503
        if (r226 != null) goto L501;
        if ((r225 instanceof Number) == false) goto L488;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L470;
        Float r232 = Float.valueOf(((Number) r225).floatValue());     // Catch: Throwable -> L503
        if ((r232 instanceof Boolean) == true) goto L468;
        r232 = null;
    L468:
        r226 = (Boolean) r232;     // Catch: Throwable -> L503
        goto L501
    L470:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L476;
        Double r233 = Double.valueOf(((Number) r225).doubleValue());     // Catch: Throwable -> L503
        if ((r233 instanceof Boolean) == true) goto L474;
        r233 = null;
    L474:
        r226 = (Boolean) r233;     // Catch: Throwable -> L503
        goto L501
    L476:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L482;
        Integer r234 = Integer.valueOf(((Number) r225).intValue());     // Catch: Throwable -> L503
        if ((r234 instanceof Boolean) == true) goto L480;
        r234 = null;
    L480:
        r226 = (Boolean) r234;     // Catch: Throwable -> L503
        goto L501
    L482:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L488;
        Long r235 = Long.valueOf(((Number) r225).longValue());     // Catch: Throwable -> L503
        if ((r235 instanceof Boolean) == true) goto L486;
        r235 = null;
    L486:
        r226 = (Boolean) r235;     // Catch: Throwable -> L503
    L488:
        if ((r225 instanceof JSONObject) == false) goto L490;
    L1300:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L496
        Object r236 = SDKSettingsCacheManager.a().fromJson(r225.toString(), Boolean.class);     // Catch: Throwable -> L496
        if ((r236 instanceof Boolean) == true) goto L494;
        r236 = null;
    L494:
        Object r237 = Result.constructor-impl((Boolean) r236);     // Catch: Throwable -> L496
    L498:
        r226 = r237;
        if (Result.isFailure-impl(r226) == false) goto L501;
    L496:
        th = move-exception;
        Result.Companion r238 = Result.Companion;     // Catch: Throwable -> L503
        r237 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L503
        goto L498
    L490:
        if ((r225 instanceof JSONArray) == false) goto L500;
    L457:
        r231 = r225;
    L503:
        th = move-exception;
        Result.Companion r239 = Result.Companion;     // Catch: Throwable -> L528
        r227 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L528
    L528:
        th = move-exception;
        Result.Companion r240 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r241 = Result.exceptionOrNull-impl(r41);
        if (r241 == null) goto L533;
        EnsureManager.ensureNotReachHere(r241);
    L533:
        if (Result.isFailure-impl(r41) == false) goto L535;
    L268:
        r30 = r23;
    L357:
        r23 = r30;
        goto L358
    L188:
        if ((r26 instanceof Boolean) == true) goto L190;
        Object r242 = null;
    L191:
        r27 = (Boolean) r242;     // Catch: Throwable -> L236
        if (r27 != null) goto L234;
        if ((r26 instanceof Number) == false) goto L221;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L203;
        Float r243 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L236
        if ((r243 instanceof Boolean) == true) goto L201;
        r243 = null;
    L201:
        r27 = (Boolean) r243;     // Catch: Throwable -> L236
        goto L234
    L203:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L209;
        Double r244 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L236
        if ((r244 instanceof Boolean) == true) goto L207;
        r244 = null;
    L207:
        r27 = (Boolean) r244;     // Catch: Throwable -> L236
        goto L234
    L209:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L215;
        Integer r245 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L236
        if ((r245 instanceof Boolean) == true) goto L213;
        r245 = null;
    L213:
        r27 = (Boolean) r245;     // Catch: Throwable -> L236
        goto L234
    L215:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L221;
        Long r246 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L236
        if ((r246 instanceof Boolean) == true) goto L219;
        r246 = null;
    L219:
        r27 = (Boolean) r246;     // Catch: Throwable -> L236
    L221:
        if ((r26 instanceof JSONObject) == false) goto L223;
    L1348:
        Object r247 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Boolean.class);     // Catch: Throwable -> L229
        if ((r247 instanceof Boolean) == true) goto L227;
        r247 = null;
    L227:
        Object r248 = Result.constructor-impl((Boolean) r247);     // Catch: Throwable -> L229
    L231:
        r27 = r248;
        if (Result.isFailure-impl(r27) == false) goto L234;
    L229:
        th = move-exception;
        Result.Companion r249 = Result.Companion;     // Catch: Throwable -> L236
        r248 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L236
        goto L231
    L223:
        if ((r26 instanceof JSONArray) == false) goto L233;
    L190:
        r242 = r26;
    L236:
        th = move-exception;
        Result.Companion r250 = Result.Companion;     // Catch: Throwable -> L261
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L261
    L261:
        th = move-exception;
        Result.Companion r251 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L264
    L271:
        int r252 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r253 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r254 = Result.Companion;     // Catch: Throwable -> L350
        Object r255 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_simple_fresco_opt_enable");     // Catch: Throwable -> L325
        if (r255 != null) goto L277;
    L322:
        Object r256 = null;
    L323:
        Object r257 = Result.constructor-impl(r256);     // Catch: Throwable -> L325
    L327:
        Throwable r258 = Result.exceptionOrNull-impl(r257);     // Catch: Throwable -> L350
        if (r258 == null) goto L331;
        EnsureManager.ensureNotReachHere(r258);     // Catch: Throwable -> L350
    L331:
        if (Result.isFailure-impl(r257) == false) goto L334;
        r257 = null;
    L334:
        if ((r257 instanceof Boolean) == true) goto L336;
        r257 = null;
    L336:
        r30 = (Boolean) r257;     // Catch: Throwable -> L350
        if (r30 != null) goto L357;
        IHybridHostService r259 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L350
        if (r259 == null) goto L342;
        Object r260 = r259.getHostABValue("ec_first_screen_simple_fresco_opt_enable", r23);     // Catch: Throwable -> L350
    L343:
        if (r260 == null) goto L358;
        if ((r260 instanceof Boolean) == true) goto L347;
        r260 = null;
    L347:
        r30 = (Boolean) r260;     // Catch: Throwable -> L350
        if (r30 != null) goto L357;
    L342:
        r260 = null;
        goto L343
    L277:
        if ((r255 instanceof Boolean) == true) goto L279;
        Object r261 = null;
    L280:
        r256 = (Boolean) r261;     // Catch: Throwable -> L325
        if (r256 != null) goto L323;
        if ((r255 instanceof Number) == false) goto L310;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L292;
        Float r262 = Float.valueOf(((Number) r255).floatValue());     // Catch: Throwable -> L325
        if ((r262 instanceof Boolean) == true) goto L290;
        r262 = null;
    L290:
        r256 = (Boolean) r262;     // Catch: Throwable -> L325
        goto L323
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L298;
        Double r263 = Double.valueOf(((Number) r255).doubleValue());     // Catch: Throwable -> L325
        if ((r263 instanceof Boolean) == true) goto L296;
        r263 = null;
    L296:
        r256 = (Boolean) r263;     // Catch: Throwable -> L325
        goto L323
    L298:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L304;
        Integer r264 = Integer.valueOf(((Number) r255).intValue());     // Catch: Throwable -> L325
        if ((r264 instanceof Boolean) == true) goto L302;
        r264 = null;
    L302:
        r256 = (Boolean) r264;     // Catch: Throwable -> L325
        goto L323
    L304:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L310;
        Long r265 = Long.valueOf(((Number) r255).longValue());     // Catch: Throwable -> L325
        if ((r265 instanceof Boolean) == true) goto L308;
        r265 = null;
    L308:
        r256 = (Boolean) r265;     // Catch: Throwable -> L325
    L310:
        if ((r255 instanceof JSONObject) == false) goto L312;
    L1336:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L318
        Object r266 = SDKSettingsCacheManager.a().fromJson(r255.toString(), Boolean.class);     // Catch: Throwable -> L318
        if ((r266 instanceof Boolean) == true) goto L316;
        r266 = null;
    L316:
        Object r267 = Result.constructor-impl((Boolean) r266);     // Catch: Throwable -> L318
    L320:
        r256 = r267;
        if (Result.isFailure-impl(r256) == false) goto L323;
    L318:
        th = move-exception;
        Result.Companion r268 = Result.Companion;     // Catch: Throwable -> L325
        r267 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L325
        goto L320
    L312:
        if ((r255 instanceof JSONArray) == false) goto L322;
    L279:
        r261 = r255;
    L325:
        th = move-exception;
        Result.Companion r269 = Result.Companion;     // Catch: Throwable -> L350
        r257 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L350
    L350:
        th = move-exception;
        Result.Companion r270 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r271 = Result.exceptionOrNull-impl(r30);
        if (r271 == null) goto L355;
        EnsureManager.ensureNotReachHere(r271);
    L355:
        if (Result.isFailure-impl(r30) == false) goto L357;
    L90:
        r18 = r10;
    L179:
        r10 = r18;
        goto L180
    L10:
        if ((r14 instanceof Boolean) == true) goto L12;
        Object r272 = null;
    L13:
        r15 = (Boolean) r272;     // Catch: Throwable -> L58
        if (r15 != null) goto L56;
        if ((r14 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r273 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L58
        if ((r273 instanceof Boolean) == true) goto L23;
        r273 = null;
    L23:
        r15 = (Boolean) r273;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r274 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L58
        if ((r274 instanceof Boolean) == true) goto L29;
        r274 = null;
    L29:
        r15 = (Boolean) r274;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r275 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L58
        if ((r275 instanceof Boolean) == true) goto L35;
        r275 = null;
    L35:
        r15 = (Boolean) r275;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r276 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L58
        if ((r276 instanceof Boolean) == true) goto L41;
        r276 = null;
    L41:
        r15 = (Boolean) r276;     // Catch: Throwable -> L58
    L43:
        if ((r14 instanceof JSONObject) == false) goto L45;
    L1292:
        Object r277 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L51
        if ((r277 instanceof Boolean) == true) goto L49;
        r277 = null;
    L49:
        Object r278 = Result.constructor-impl((Boolean) r277);     // Catch: Throwable -> L51
    L53:
        r15 = r278;
        if (Result.isFailure-impl(r15) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r279 = Result.Companion;     // Catch: Throwable -> L58
        r278 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r14 instanceof JSONArray) == false) goto L55;
    L12:
        r272 = r14;
    L58:
        th = move-exception;
        Result.Companion r280 = Result.Companion;     // Catch: Throwable -> L83
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        Result.Companion r281 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L93:
        int r282 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r283 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r284 = Result.Companion;     // Catch: Throwable -> L172
        Object r285 = com.bytedance.android.ec.base.settings.d.a().get("ec_first_screen_image_monitor_enable");     // Catch: Throwable -> L147
        if (r285 != null) goto L99;
    L144:
        Object r286 = null;
    L145:
        Object r287 = Result.constructor-impl(r286);     // Catch: Throwable -> L147
    L149:
        Throwable r288 = Result.exceptionOrNull-impl(r287);     // Catch: Throwable -> L172
        if (r288 == null) goto L153;
        EnsureManager.ensureNotReachHere(r288);     // Catch: Throwable -> L172
    L153:
        if (Result.isFailure-impl(r287) == false) goto L156;
        r287 = null;
    L156:
        if ((r287 instanceof Boolean) == true) goto L158;
        r287 = null;
    L158:
        r18 = (Boolean) r287;     // Catch: Throwable -> L172
        if (r18 != null) goto L179;
        IHybridHostService r289 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L172
        if (r289 == null) goto L164;
        Object r290 = r289.getHostABValue("ec_first_screen_image_monitor_enable", r10);     // Catch: Throwable -> L172
    L165:
        if (r290 == null) goto L180;
        if ((r290 instanceof Boolean) == true) goto L169;
        r290 = null;
    L169:
        r18 = (Boolean) r290;     // Catch: Throwable -> L172
        if (r18 != null) goto L179;
    L164:
        r290 = null;
        goto L165
    L99:
        if ((r285 instanceof Boolean) == true) goto L101;
        Object r291 = null;
    L102:
        r286 = (Boolean) r291;     // Catch: Throwable -> L147
        if (r286 != null) goto L145;
        if ((r285 instanceof Number) == false) goto L132;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L114;
        Float r292 = Float.valueOf(((Number) r285).floatValue());     // Catch: Throwable -> L147
        if ((r292 instanceof Boolean) == true) goto L112;
        r292 = null;
    L112:
        r286 = (Boolean) r292;     // Catch: Throwable -> L147
        goto L145
    L114:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L120;
        Double r293 = Double.valueOf(((Number) r285).doubleValue());     // Catch: Throwable -> L147
        if ((r293 instanceof Boolean) == true) goto L118;
        r293 = null;
    L118:
        r286 = (Boolean) r293;     // Catch: Throwable -> L147
        goto L145
    L120:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L126;
        Integer r294 = Integer.valueOf(((Number) r285).intValue());     // Catch: Throwable -> L147
        if ((r294 instanceof Boolean) == true) goto L124;
        r294 = null;
    L124:
        r286 = (Boolean) r294;     // Catch: Throwable -> L147
        goto L145
    L126:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L132;
        Long r295 = Long.valueOf(((Number) r285).longValue());     // Catch: Throwable -> L147
        if ((r295 instanceof Boolean) == true) goto L130;
        r295 = null;
    L130:
        r286 = (Boolean) r295;     // Catch: Throwable -> L147
    L132:
        if ((r285 instanceof JSONObject) == false) goto L134;
    L1276:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L140
        Object r296 = SDKSettingsCacheManager.a().fromJson(r285.toString(), Boolean.class);     // Catch: Throwable -> L140
        if ((r296 instanceof Boolean) == true) goto L138;
        r296 = null;
    L138:
        Object r297 = Result.constructor-impl((Boolean) r296);     // Catch: Throwable -> L140
    L142:
        r286 = r297;
        if (Result.isFailure-impl(r286) == false) goto L145;
    L140:
        th = move-exception;
        Result.Companion r298 = Result.Companion;     // Catch: Throwable -> L147
        r297 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L147
        goto L142
    L134:
        if ((r285 instanceof JSONArray) == false) goto L144;
    L101:
        r291 = r285;
    L147:
        th = move-exception;
        Result.Companion r299 = Result.Companion;     // Catch: Throwable -> L172
        r287 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r300 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r301 = Result.exceptionOrNull-impl(r18);
        if (r301 == null) goto L177;
        EnsureManager.ensureNotReachHere(r301);
    L177:
        if (Result.isFailure-impl(r18) == false) goto L179;
        goto L179
    }

    public static String g(GenericDraweeView r10) {
        Intrinsics.checkNotNullParameter(r10, "imageView");
        String r0 = L.get(r10);
        if (r0 != null) goto L5;
    L9:
        dm.a.a("FirstScreenStatistic").a("getLoadingUrl " + r10.hashCode() + ' ' + r0);
    L10:
        if (r0 != null) goto L13;
        return "";
    L13:
        return r0;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    public static boolean h(String r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        String r10 = M.get(r1);
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        Boolean r11 = K.get(r10);
        if (r11 != null) goto L9;
        r11 = Boolean.FALSE;
    L9:
        return r11.booleanValue();
    }

    public static void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "cleanUrl");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L5;
        I.post(new a(r10));
        return;
    L5:
        if (com.bytedance.android.shopping.extensions.k.c(r10) == false) goto L11;
        HashSet<String> r0 = w;
        if (r0.contains(r10) == true) goto L12;
        r0.add(r10);
        y.incrementAndGet();
        return;
    L12:
        return;
    }

    public static String k(String r10) {
        Intrinsics.checkNotNullParameter(r10, "originUrl");
        int r0 = StringsKt.indexOf$default(r10, "&is_from_mall_cache=", 0, false, 6, null);
        if (r0 != (-1)) goto L5;
        return r10;
    L5:
        return StringsKt.removeRange(r10, r0, (r0 + 20) + 1).toString();
    }

    public static void o(int r10) {
        JSONObject r0 = new JSONObject();
        int r1 = x.get();
        int r11 = y.get();
        int r12 = r1 + r11;
        int r13 = A.get();
        r0.put("normalFrescoLoadNum", r1);     // Catch: Exception -> L7
        r0.put("simpleFrescoLoadNum", r11);     // Catch: Exception -> L7
        r0.put("totalFrescoLoadNum", r12);     // Catch: Exception -> L7
        r0.put("cacheNum", r13);     // Catch: Exception -> L7
        r0.put("time", r10);     // Catch: Exception -> L7
        if (r12 <= 0) goto L8;
        r0.put("cacheRate", Float.valueOf(r13 / r12));     // Catch: Exception -> L7
    L8:
        dm.a.a("FirstScreenStatistic").a("reportFrescoLoadAndCacheRate " + r0);
        int r14 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_fresco_load_cache_rate", r0, null, null);
        return;
    L7:
        ECExceptionMonitor.c("reportFrescoLoadAndCacheRate json error");
        goto L8
    }

    public static String t(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        q0 r1 = B;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        byte[] r0 = r10.getBytes(Charsets.UTF_8);     // Catch: Exception -> L9
        MessageDigest r11 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r11.update(r0);     // Catch: Exception -> L9
        byte[] r12 = r11.digest();     // Catch: Exception -> L9
        char[] r13 = new char[32];     // Catch: Exception -> L9
        int r14 = 0;
        int r15 = 0;
    L5:
        if (r14 > 15) goto L7;
        byte r16 = r12[r14];     // Catch: Exception -> L9
        int r17 = r15 + 1;     // Catch: Exception -> L9
        char[] r18 = r1.a;     // Catch: Exception -> L9
        r13[r15] = r18[15 & (r16 >>> 4)];     // Catch: Exception -> L9
        r15 = r17 + 1;     // Catch: Exception -> L9
        r13[r17] = r18[r16 & 15];     // Catch: Exception -> L9
        r14 = r14 + 1;     // Catch: Exception -> L9
        goto L5
    L7:
        String r19 = new String(r13);     // Catch: Exception -> L9
    L11:
        if (r19 != null) goto L14;
        return r10;
    L14:
        return r19;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        HashMap r20 = new HashMap();
        r20.put("cleanUrl", r10);
        S.getClass();
        n("md5", "", e, r20);
        r19 = null;
        goto L11
    }

    public static final void a(FirstScreenStatistic r24, com.bytedance.android.ec.core.imagex.a r25) {
        r24.getClass();
        String r10 = r25.a;
        String r11 = r25.b;
        String r12 = r25.c;
        Map<String, String> r13 = r25.d;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L75
        Uri r1 = UriProtector.parse(r10);     // Catch: Throwable -> L75
        String r14 = M.get(r10);     // Catch: Throwable -> L75
        if (r14 != null) goto L6;
        r14 = t(r10);     // Catch: Throwable -> L75
    L6:
        p0 r15 = N.get(r14);     // Catch: Throwable -> L75
        FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1 r16 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE;     // Catch: Throwable -> L75
        if (r15 == null) goto L9;
        long r17 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r15.c, r15.e);     // Catch: Throwable -> L75
    L10:
        if (r15 == null) goto L12;
        long r18 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r15.d, r15.e);     // Catch: Throwable -> L75
    L13:
        if (r15 == null) goto L17;
        Map<String, String> r19 = r13;
        long r20 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r15.a, r15.b);     // Catch: Throwable -> L24
    L18:
        if (r15 == null) goto L26;
        long r110 = r15.b;     // Catch: Throwable -> L24
        if (r110 <= 0) goto L26;
        long r21 = r20;
        long r22 = r15.c;     // Catch: Throwable -> L24
        if (r22 <= 0) goto L27;
        long r23 = r22 - r110;     // Catch: Throwable -> L24
    L28:
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L24
        String r112 = null;
        if (r12 != null) goto L31;
    L35:
        r12 = "ec_default";
    L36:
        r111.put("biz_tag", r12);     // Catch: Throwable -> L24
        if ((!StringsKt.isBlank(r11)) == true) goto L42;
        r11 = null;
    L42:
        if (r11 != null) goto L44;
        r11 = "unknown";
    L44:
        r111.put("scene_tag", r11);     // Catch: Throwable -> L24
        r111.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "unknown");     // Catch: Throwable -> L24
        r111.put("host", r1.getHost());     // Catch: Throwable -> L24
        if (r1.isHierarchical() == false) goto L61;
        String r26 = UriProtector.getQueryParameter(r1, "biz_tag");     // Catch: Throwable -> L24
        if (r26 != null) goto L49;
    L54:
        String r27 = UriProtector.getQueryParameter(r1, "scene_tag");     // Catch: Throwable -> L24
        if (r27 == null) goto L61;
        if ((!StringsKt.isBlank(r27)) == false) goto L59;
        r112 = r27;
    L59:
        if (r112 == null) goto L61;
        r111.put("url_scene", r112);     // Catch: Throwable -> L24
        goto L61
    L49:
        if ((!StringsKt.isBlank(r26)) == true) goto L52;
        r26 = null;
    L52:
        if (r26 == null) goto L54;
        r111.put("url_biz", r26);     // Catch: Throwable -> L24
    L61:
        r111.put("is_animated_image", false);     // Catch: Throwable -> L24
        r111.put(com.bytedance.android.ec.core.event.a.KEY_IS_SUCCESS, true);     // Catch: Throwable -> L24
        r111.put("is_cancel", false);     // Catch: Throwable -> L24
        r111.put("from_cache", true);     // Catch: Throwable -> L24
        r111.put("is_preload", false);     // Catch: Throwable -> L24
        r111.put("first_request", true);     // Catch: Throwable -> L24
        r111.put("image_from", "bitmap_cache");     // Catch: Throwable -> L24
        JSONObject r28 = new JSONObject();     // Catch: Throwable -> L24
        r28.put("ec_local_duration", 0);     // Catch: Throwable -> L24
        r28.put("ec_sdk_duration", 0);     // Catch: Throwable -> L24
        r28.put("ec_biz_duration", r17);     // Catch: Throwable -> L24
        r28.put("ec_queue_duration", 0);     // Catch: Throwable -> L24
        r28.put("ec_download_duration", 0);     // Catch: Throwable -> L24
        r28.put("ec_decode_duration", 0);     // Catch: Throwable -> L24
        r28.put("ec_image_set_duration", r18);     // Catch: Throwable -> L24
        r28.put("ec_biz_image_set_duration", r18);     // Catch: Throwable -> L24
        if (r15 == null) goto L64;
        long r29 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(0, r15.a);     // Catch: Throwable -> L24
    L65:
        r28.put("bitmap_prepare_duration", r29);     // Catch: Throwable -> L24
        r28.put("bitmap_disk_load_duration", r21);     // Catch: Throwable -> L24
        if (r15 == null) goto L68;
        long r30 = FirstScreenStatistic$doReportBitmapHitImageMonitor$1$1.INSTANCE.invoke(r15.c, r15.d);     // Catch: Throwable -> L24
    L69:
        r28.put("bitmap_use_duration", r30);     // Catch: Throwable -> L24
        r28.put("bitmap_set_duration", r18);     // Catch: Throwable -> L24
        r28.put("bitmap_total_duration", r17);     // Catch: Throwable -> L24
        r28.put("bitmap_real_load_to_disk_end_duration", r23);     // Catch: Throwable -> L24
        JSONObject r31 = new JSONObject();     // Catch: Throwable -> L24
        r31.put(com.bytedance.android.ec.core.event.a.KEY_URL, r10);     // Catch: Throwable -> L24
        r31.put("url_path", r1.getPath());     // Catch: Throwable -> L24
        r31.put("bitmap_cache_md5", r14);     // Catch: Throwable -> L24
        r31.put("bitmap_cache_hit", true);     // Catch: Throwable -> L24
        Iterator<Map.Entry<String, String>> r32 = r19.entrySet().iterator();     // Catch: Throwable -> L24
    L71:
        if (r32.hasNext() == false) goto L73;
        Map.Entry<String, String> r33 = r32.next();     // Catch: Throwable -> L24
        r31.put(r33.getKey(), r33.getValue());     // Catch: Throwable -> L24
        goto L71
    L73:
        int r34 = ECMonitorService.b;     // Catch: Throwable -> L24
        ECMonitorService.a.a("ecom_image_monitor", r111, r28, r31);     // Catch: Throwable -> L24
        Object r35 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L78:
        Throwable r36 = Result.exceptionOrNull-impl(r35);
        if (r36 == null) goto L87;
        S.getClass();
        n("reportBitmapHitImageMonitor", "report bitmap hit image monitor error", r36, r19);
        return;
    L87:
        return;
    L68:
        r30 = -1;
        goto L69
    L64:
        r29 = -1;
        goto L65
    L31:
        if ((!StringsKt.isBlank(r12)) == true) goto L34;
        r12 = null;
    L34:
        if (r12 != null) goto L36;
    L27:
        r23 = -1;
    L26:
        r21 = r20;
    L24:
        th = th;
    L77:
        Result.Companion r37 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    L17:
        r19 = r13;
        r20 = -1;
        goto L18
    L12:
        r18 = -1;
        goto L13
    L9:
        r17 = -1;
    L75:
        th = th;
        r19 = r13;
        goto L77
    }

    public static void q(boolean r10, Map r11) {
        Intrinsics.checkNotNullParameter(r11, "extra");
        JSONObject r0 = new JSONObject();
        r0.put("success", r10);     // Catch: Exception -> L8
        Iterator r12 = r11.entrySet().iterator();     // Catch: Exception -> L8
    L5:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Exception -> L8
        r0.put((String) r13.getKey(), r13.getValue());     // Catch: Exception -> L8
    L9:
        int r14 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_simple_fresco_load", r0, null, null);
        return;
    L8:
        ECExceptionMonitor.c("reportSimpleFrescoLoadResult json error");
        goto L9
    }

    public static boolean s(Bitmap r10, PolarisFileWrapper r11) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "md5WhFile");
        int r0 = r10.getByteCount();
        if (r10.isRecycled() == true) goto L19;
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r10.getWidth() != 0) goto L8;
        return false;
    L8:
        if (r10.getHeight() == 0) goto L27;
        PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r11);
        ByteBuffer r12 = ByteBuffer.allocateDirect(r0);     // Catch: Throwable -> L14
        r10.copyPixelsToBuffer(r12);     // Catch: Throwable -> L14
        r1.write(r12.array());     // Catch: Throwable -> L14
        r1.flush();     // Catch: Throwable -> L14
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r1, null);
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L27:
        return false;
    L19:
        return false;
    }

    public static Bitmap f(String r10, CloseableImage r11, Map r12) {
        Intrinsics.checkNotNullParameter(r10, "cleanUrl");
        Intrinsics.checkNotNullParameter(r12, "extra");
        if (r11 != null) goto L37;
    L22:
        Bitmap r13 = null;
        Exception r1 = null;
    L23:
        if (r13 != null) goto L26;
        n("cacheBitmap", "getBitmap null", r1, r12);
        return null;
    L26:
        Bitmap.Config r14 = r13.getConfig();
        if (r14 != null) goto L29;
        r14 = Bitmap.Config.ARGB_8888;
    L29:
        long r15 = System.currentTimeMillis();
        boolean r16 = n;
        if (r16 == false) goto L32;
        Bitmap r17 = r13.copy(r14, false);
    L33:
        long r18 = System.currentTimeMillis();
        if (r16 == false) goto L36;
        int r19 = r17.getByteCount();
        int r20 = r13.getWidth();
        int r21 = r13.getHeight();
        JSONObject r22 = new JSONObject();
        r22.put("bitmapByteCount", r19);
        r22.put("bitmapWidth", r20);
        r22.put("bitmapHeight", r21);
        r22.put("time", r18 - r15);
        int r23 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_bitmap_copy", r22, null, null);
    L36:
        return r17;
    L32:
        r17 = r13;
        goto L33
    L37:
    L20:
        e = move-exception;
        dm.a.a("FirstScreenStatistic").b("onFinalImageSet getBitmap from closeableImage failed " + e.toString(), null);
        r1 = e;
        r13 = null;
        goto L23
    L5:
        if ((r11 instanceof CloseableStaticBitmap) == false) goto L8;
        r13 = ((CloseableStaticBitmap) r11).getUnderlyingBitmap();     // Catch: Exception -> L20
    L19:
        r1 = null;
        goto L23
    L8:
        if ((r11 instanceof CloseableAnimatedImage) == false) goto L15;
        AnimatedImage r24 = ((CloseableAnimatedImage) r11).getImage();     // Catch: Exception -> L20
        if (r24 == null) goto L22;
        if (r24.getFrameCount() <= 0) goto L18;
        AnimatedImageFrame r25 = r24.getFrame(0);     // Catch: Exception -> L20
        Bitmap r26 = Bitmap.createBitmap(r25.getWidth(), r25.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L20
        r25.renderFrame(r25.getWidth(), r25.getHeight(), r26);     // Catch: Exception -> L20
        r13 = r26;
    L18:
        r13 = null;
        goto L19
    L15:
        if ((r11 instanceof CloseableBitmap) == false) goto L18;
        r13 = ((CloseableBitmap) r11).getUnderlyingBitmap();     // Catch: Exception -> L20
        goto L19
    }

    public static void i(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "sceneTag");
        o0 r0 = h.get(r10);
        if (r0 == null) goto L6;
        long r1 = System.currentTimeMillis();
        r0.d = r1;
        r0.e = r1 - r0.c;
        r0.f = r12;
    L6:
        if (H == false) goto L9;
        c();
    L9:
        if (e == false) goto L12;
        return;
    L12:
        if (a == false) goto L40;
        String r13 = String.valueOf(r11);
        ConcurrentHashMap<String, i0> r14 = J.get(r13);
        if (r14 != null) goto L16;
        return;
    L16:
        HashMap<String, HashMap<String, i0>> r15 = g;
        HashMap<String, i0> r16 = r15.get(r13);
        if (r16 != null) goto L19;
        return;
    L19:
        i0 r17 = r16.get(r10);
        if (r17 != null) goto L22;
        return;
    L22:
        r17.a = System.currentTimeMillis() - d;
        r17.c = System.currentTimeMillis();
        r17.d = r12;
        if (r14.containsKey(r10) == true) goto L25;
        r14.put(r10, r17);
    L25:
        Iterator<T> r18 = r15.values().iterator();
        int r19 = 0;
        int r20 = 0;
    L27:
        if (r18.hasNext() == false) goto L29;
        r20 = r20 + ((HashMap) r18.next()).size();
        goto L27
    L29:
        Iterator<T> r21 = f.values().iterator();
        int r22 = 0;
    L31:
        if (r21.hasNext() == false) goto L33;
        r22 = r22 + ((HashMap) r21.next()).size();
        goto L31
    L33:
        Iterator<T> r23 = J.values().iterator();
    L35:
        if (r23.hasNext() == false) goto L38;
        r19 = r19 + ((ConcurrentHashMap) r23.next()).size();
        goto L35
    L38:
        if (r20 != (r22 + r19)) goto L56;
        dm.a.a("FirstScreenStatistic").a("all image load complete, not accept load end any more");
        e = true;
        return;
    L56:
        return;
    L40:
        String r24 = String.valueOf(r11);
        HashMap<String, i0> r25 = f.get(r24);
        if (r25 != null) goto L43;
        return;
    L43:
        HashMap<String, i0> r26 = g.get(r24);
        if (r26 != null) goto L46;
        return;
    L46:
        i0 r27 = r26.get(r10);
        if (r27 != null) goto L49;
        return;
    L49:
        r27.d = r12;
        r27.c = System.currentTimeMillis();
        if (r25.containsKey(r10) == true) goto L58;
        r25.put(r10, r27);
        return;
    }

    public static void p(boolean r10, int r11, int r12) {
        JSONObject r0 = new JSONObject();
        r0.put("success", r10);
        r0.put("md5Size", r11);
        r0.put("urlSize", r12);
        int r13 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_save_first_screen", r0, null, null);
    }

    public static final Bitmap b(FirstScreenStatistic r10, File r11, int r12, int r13) {
        r10.getClass();
        Bitmap r14 = null;
        if (r11 != null) goto L5;
    L21:
        return r14;
    L5:
        if (r11.exists() == false) goto L21;
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(r11);
        int r15 = r0.available();     // Catch: Throwable -> L16
        byte[] r1 = new byte[r15];     // Catch: Throwable -> L16
        if (r0.read(r1) == r15) goto L10;
        CloseableKt.closeFinally(r0, null);
        goto L21
    L10:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r0, null);
        r14 = Bitmap.createBitmap(r12, r13, Bitmap.Config.ARGB_8888);
        if (r14 == null) goto L14;
        r14.copyPixelsFromBuffer(ByteBuffer.wrap(r1));
    L14:
        if (r14 == null) goto L21;
        r14.prepareToDraw();
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static void m(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "editedUrl");
        Intrinsics.checkNotNullParameter(r11, "originUrl");
        Intrinsics.checkNotNullParameter(r12, "cleanUrl");
        Intrinsics.checkNotNullParameter(r13, "sceneTag");
        if (a == false) goto L5;
        return;
    L5:
        JSONObject r14 = new JSONObject();
        r14.put("editedUrl", r10);
        r14.put("originUrl", r11);
        r14.put("cleanUrl", r12);
        r14.put("sceneTag", r13);
        int r15 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_record_image_load", r14, null, null);
    }

    public static void n(String r10, String r11, Throwable r12, Map r13) {
        Intrinsics.checkNotNullParameter(r10, "phase");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        JSONObject r1 = new JSONObject();
        r1.put("phase", r10);
        if (r13 == null) goto L9;
        Iterator r14 = r13.entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        Map.Entry r15 = (Map.Entry) r14.next();
        r1.put((String) r15.getKey(), (String) r15.getValue());
    L9:
        if (r12 == null) goto L11;
        r1.put(IHostStyleUIDepend.TOAST_TYPE_ERROR, r12.toString());
    L12:
        int r16 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_bitmap_opt_error", r1, null, null);
        dm.a.a("FirstScreenStatistic").a(String.valueOf(r1.toString(2)));
        return;
    L11:
        r1.put(IHostStyleUIDepend.TOAST_TYPE_ERROR, r11);
        goto L12
    }

    public static void d(Bitmap r10, ImageRequest r11, String r12, Map r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "cleanUrl");
        Intrinsics.checkNotNullParameter(r13, "extra");
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_FROM);
        if (D.contains(r12) == true) goto L6;
        dm.a.a("FirstScreenStatistic").a("not start before realdata firstscreen return " + r12 + ' ');
        return;
    L6:
        HashSet<String> r0 = z;
        if (r0.contains(r12) == false) goto L11;
        dm.a.a("FirstScreenStatistic").a("repeatCache already caching return " + r12);
        return;
    L11:
        if (h(r12) == false) goto L15;
        dm.a.a("FirstScreenStatistic").a("hasCacheFile return ".concat(r12));
        return;
    L15:
        if (v.contains(r12) == false) goto L17;
    L19:
        r0.add(r12);
        A.incrementAndGet();
        if (r10 == null) goto L22;
        Bitmap.Config r15 = r10.getConfig();
    L23:
        if (r10 == null) goto L45;
        if (r15 == null) goto L46;
        if (r11 == null) goto L28;
        ResizeOptions r16 = r11.getResizeOptions();
    L29:
        int r17 = r10.getWidth();
        int r18 = r10.getHeight();
        int r19 = 0;
        if (r16 == null) goto L32;
        int r20 = r16.width;
    L33:
        if (r16 == null) goto L35;
        r19 = r16.height;
    L35:
        if (r17 != 0) goto L38;
        if (r18 != 0) goto L38;
        dm.a.a("FirstScreenStatistic").b("bitmapSize width&height = 0", null);
    L38:
        if (r20 == 0) goto L43;
        if (r19 == 0) goto L43;
        if (r20 == r17) goto L43;
        if (r19 == r18) goto L43;
        dm.a.a("FirstScreenStatistic").b("bitmapSize width&height != resizeWidth&resizeHeight", null);
    L43:
        dm.a.a("FirstScreenStatistic").a(ThreadMethodProxy.currentThread().getName() + ' ' + r14 + " cacheBitmap: bitmapSize " + r17 + ' ' + r18 + " resize " + r20 + ' ' + r19 + ' ' + r12);
        u(r10, r12, r17, r18, r13, System.currentTimeMillis());
        return;
    L32:
        r20 = 0;
        goto L33
    L28:
        r16 = null;
        goto L29
    L46:
        return;
    L45:
        return;
    L22:
        r15 = null;
        goto L23
    L17:
        if (w.contains(r12) == true) goto L19;
        dm.a.a("FirstScreenStatistic").a("not in fresco loading urls. extra " + r13.toString() + " cleanUrl " + r12);
        goto L19
    }

    public static void l(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "editedUrl");
        Intrinsics.checkNotNullParameter(r11, "originUrl");
        Intrinsics.checkNotNullParameter(r12, "cleanUrl");
        Intrinsics.checkNotNullParameter(r13, "sceneTag");
        Intrinsics.checkNotNullParameter(r14, "callerContextState");
        JSONObject r15 = new JSONObject();
        r15.put("editedUrl", r10);
        r15.put("originUrl", r11);
        r15.put("cleanUrl", r12);
        r15.put("sceneTag", r13);
        r15.put("callerContext", r14);
        int r16 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_record_image_end", r15, null, null);
    }

    public static void u(Bitmap r11, String r12, int r13, int r14, Map r15, long r16) {
        Intrinsics.checkNotNullParameter(r11, "saveBitmap");
        Intrinsics.checkNotNullParameter(r12, "cleanUrl");
        Intrinsics.checkNotNullParameter(r15, "extra");
        if (H == true) goto L15;
        long r0 = System.currentTimeMillis();
        if (F == false) goto L7;
        long r10 = 4000;
    L9:
        if ((r0 - r16) <= r10) goto L11;
        return;
    L11:
        if (p == false) goto L13;
        I.postDelayed(new b(r11, r12, r13, r14, r15, r16), 300);
        return;
    L13:
        I.post(new c(r11, r12, r13, r14, r15, r16));
        return;
    L7:
        r10 = 1000;
        goto L9
    L15:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FirstScreenStatistic$writeBitmapToDisk$3(r12, r13, r14, r11, r15, null), 3, null);
    }
}
