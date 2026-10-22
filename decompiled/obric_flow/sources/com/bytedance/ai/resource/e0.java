package com.bytedance.ai.resource;

import android.app.Application;
import android.net.Uri;
import android.os.Looper;
import android.util.LruCache;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache f2711a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f2712b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f2713c = null;
    public static final int d = 0;
    public static volatile android.support.v4.media.c e;
    public static final Object f = null;
    public static final kotlinx.coroutines.s g = null;

    static {
        f2711a = new LruCache(20);
        f2712b = LazyKt.lazy(new a3.f(14));
        f2713c = LazyKt.lazy(new a3.f(15));
        d = AISDKSettingConfigManager.INSTANCE.getGECKO_HOST_VERSION().getValue().intValue();
        f = new Object();
        g = j0.a();
        String r5 = AIPackageConfig.f2571a;
    }

    public static Object a(String r10, String r11, Continuation r12) {
        kotlinx.coroutines.l r5 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(r12));
        r5.w();
        AtomicReference r13 = new AtomicReference(r5);
        r5.y(new com.bytedance.ai.process.resource.b(r13, 1));
        BuildersKt.launch$default(h0.a(r5.e), t2.b.f22089a, null, new AppletResourceTool$loadImage$2$2(r10, r11, r13, null), 2, null);
        Object r14 = r5.v();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L5:
        return r14;
    }

    public static String b(long r5, String r10) {
        return Uri.parse(r10).buildUpon().appendQueryParameter("loader_name", "forest").appendQueryParameter("disable_gecko", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).appendQueryParameter("disable_builtin", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).appendQueryParameter("disable_gecko_update", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).appendQueryParameter("disable_offline", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).appendQueryParameter("disable_cdn_cache", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).appendQueryParameter("enable_memory_cache", "0").appendQueryParameter("packageVersion", String.valueOf(r5)).build().toString();
    }

    public static String c(Applet r10, String r11) {
        String r5 = l(r11);
        Intrinsics.checkNotNullParameter(r10.f2259b, "appletName");
        if (r10.A == true) goto L5;
        j r12 = j.f2734a;
        if (j.n(r10.f2259b) == false) goto L49;
        String r13 = o(r10.f2259b);
        if (r13 != null) goto L39;
    L47:
        return r5;
    L39:
        if (r13.length() == 0) goto L47;
        if (StringsKt.k(r13, "/") == false) goto L44;
        StringBuilder r14 = sk.a.a(r13);
        r14.append(r10.f2259b);
        r14.append('/');
        r14.append(r5);
        String r15 = r14.toString();
    L46:
        return n(r15, r10.f2276x, false);
    L44:
        r15 = r13 + '/' + r10.f2259b + '/' + r5;
        goto L46
    L49:
        return f(r10.f2259b, r10.F, r10.F + '_' + r10.f2267n, r5, r10.f2260c, null);
    L5:
        if (com.bytedance.ai.utils.c.l("") == true) goto L7;
        String r16 = r10.F + '_' + r10.f2267n;
        String r17 = r10.f2259b;
        com.bytedance.ai.multiprocess.a r18 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r18 != null) goto L15;
    L31:
        String r19 = null;
    L33:
        return f(r10.f2259b, r10.F, r16, r5, r10.f2260c, r19);
    L15:
        if (r18.f2402c == true) goto L26;
        if (r18.f2402c == true) goto L31;
        if (r17 == null) goto L31;
        if (r17.length() == 0) goto L31;
        if (r18.d.contains(r17) == false) goto L31;
    L26:
        if (ym.h.a(r10.f2261h, "3.0") < 0) goto L28;
        String r20 = r5;
    L29:
        r19 = e(r10.f2259b, r20);
        goto L33
    L28:
        r20 = StringsKt.H(r5, r10.F, "applet");
        goto L29
    L7:
        if (ym.h.a(r10.f2261h, "3.0") >= 0) goto L11;
        r5 = StringsKt.H(r5, r10.F, "applet");
    L11:
        return b(r10.f2260c, td.d.b("/", r5));
    }

    public static String d(Widget r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        String r5 = l(r11);
        Intrinsics.checkNotNullParameter(r10.f2259b, "appletName");
        long r12 = r10.f2260c;
        if (r10.A == true) goto L5;
        j r13 = j.f2734a;
        if (j.n(r10.f2259b) == false) goto L45;
        String r14 = o(r10.f2259b);
        if (r14 != null) goto L39;
    L43:
        return r5;
    L39:
        if (r14.length() == 0) goto L43;
        return n(r14 + '/' + r10.f2259b + '/' + r5, r10.f2276x, false);
    L45:
        return f(r10.f2259b, r10.F, r10.F + '_' + r10.f2267n, r5, r12, null);
    L5:
        if (com.bytedance.ai.utils.c.l("") == true) goto L7;
        String r15 = r10.F + '_' + r10.f2267n;
        String r16 = r10.f2259b;
        com.bytedance.ai.multiprocess.a r17 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r17 != null) goto L15;
    L31:
        String r18 = null;
    L33:
        return f(r10.f2259b, r10.F, r15, r5, r12, r18);
    L15:
        if (r17.f2402c == true) goto L26;
        if (r17.f2402c == true) goto L31;
        if (r16 == null) goto L31;
        if (r16.length() == 0) goto L31;
        if (r17.d.contains(r16) == false) goto L31;
    L26:
        if (ym.h.a(r10.f2261h, "3.0") < 0) goto L28;
        String r19 = r5;
    L29:
        r18 = e(r10.F, r19);
        goto L33
    L28:
        r19 = td.d.b("widgets/", r5);
        goto L29
    L7:
        if (ym.h.a(r10.f2261h, "3.0") >= 0) goto L11;
        r5 = td.d.b("widgets/", r5);
    L11:
        return b(r12, "/" + r5);
    }

    public static String e(String r5, String r10) {
        return Uri.encode(new JSONObject().put(Constant.APPID, r5).put("fileName", r10).toString());
    }

    public static String f(String r5, String r10, String r11, String r12, long r13, String r14) {
        Uri.Builder r15 = Uri.parse("https://app.aisdk.local/" + r5 + '/' + r11 + '/' + r12).buildUpon().appendQueryParameter("packageName", r5);
        u0.a r16 = s0.a.f21800c;
        if (r16 == null) goto L6;
        String r17 = r16.f22202m;
        if (r17 == null) goto L6;
    L7:
        Uri.Builder r18 = r15.appendQueryParameter("bid", r17).appendQueryParameter(IIvyAIPackageResourceService.QUERY_STORE_DIR, r10).appendQueryParameter(IIvyAIPackageResourceService.QUERY_INTERCEPT_REQUEST, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).appendQueryParameter("packageVersion", String.valueOf(r13));
        if (r14 == null) goto L11;
        r18.appendQueryParameter("debugInfo", r14);
    L11:
        return r18.build().toString();
    L6:
        r17 = "";
        goto L7
    }

    public static String g(String r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        if (StringsKt.k(r10, "/") == false) goto L6;
        r10 = androidx.constraintlayout.motion.widget.a.n(r10, 1, 0);
    L6:
        return n(r10 + '/' + r5 + "/base/manifest.json", null, r11);
    }

    public static void h() {
        if (e == null) goto L5;
        return;
    L5:
        Object r5 = f;
        monitor-enter(r5);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (e == null) goto L12;
        monitor-exit(r5);
        return;
    L12:
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper()) == false) goto L16;
        String r10 = AIPackageConfig.f2571a;     // Catch: Throwable -> L14
    L17:
        Intrinsics.checkNotNullParameter(r10, IIvyAIPackageResourceService.QUERY_STORE_DIR);     // Catch: Throwable -> L14
        android.support.v4.media.c r11 = new android.support.v4.media.c();     // Catch: Throwable -> L14
        r11.f367a = r10;     // Catch: Throwable -> L14
        e = r11;     // Catch: Throwable -> L14
        com.bytedance.android.monitorV2.k r12 = e3.c.f16757a;     // Catch: Throwable -> L14
        if (r12 != null) goto L20;
    L21:
        com.bytedance.android.monitorV2.k r13 = e3.c.f16757a;     // Catch: Throwable -> L14
        if (r13 == null) goto L24;
        r13.evictAll();     // Catch: Throwable -> L14
    L24:
        e3.c.f16758b.clear();     // Catch: Throwable -> L14
        e3.c.f16757a = new com.bytedance.android.monitorV2.k(5242880, 4);     // Catch: Throwable -> L14
    L25:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r5);
        return;
    L20:
        if (r12.maxSize() <= 5242880) goto L25;
    L16:
        r10 = (String) BuildersKt.runBlocking$default(null, new AppletResourceTool$ensureAppletResourceLoaderInitialized$1$dir$1(null), 1, null);     // Catch: Throwable -> L14
        goto L17
    }

    public static void i(Application r16, String r17, u r18, kotlinx.coroutines.s r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "saveDir");
        Intrinsics.checkNotNullParameter(r19, "geckoInit");
        a2.a r5 = new a2.a(2, r16, r17);
        Intrinsics.checkNotNullParameter(r5, "task");
        com.bytedance.ai.multiprocess.a r10 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r10 == null) goto L8;
        Intrinsics.checkNotNullParameter(r5, "task");
        Function1 r11 = r10.f2401b;
        if (r11 == null) goto L7;
        r11.invoke(r5);
    L10:
        if (j.f2739j == false) goto L13;
        h();
    L13:
        if (j.f2738i == false) goto L48;
        int r12 = p().getInt("geckoHostVersion", 0);
        int r13 = d;
        if (r12 == r13) goto L20;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L19;
        r14.i("AppletResourceLoader", "GeckoHostVersion has been changed. clear all hosts in local.");
    L19:
        p().clear();
        p().storeInt("geckoHostVersion", r13);
    L20:
        if (r18 == null) goto L47;
        int r15 = p().getInt("offlineFileVersion", 0);
        int r20 = AISDKSettingConfigManager.INSTANCE.getOFFLINE_FILE_VERSION().getValue().intValue();
        if (r15 == r20) goto L36;
        Iterator<T> r21 = p().getAll().keySet().iterator();
    L25:
        if (r21.hasNext() == false) goto L31;
        Object r22 = r21.next();
        String r110 = (String) r22;
        if (Intrinsics.areEqual(r110, "offlineFileVersion") == true) goto L25;
        if (Intrinsics.areEqual(r110, "offlineFileVersion") == true) goto L25;
    L33:
        if (com.bytedance.ai.utils.c.l((String) r22) == false) goto L35;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AppletResourceTool$forceGeckoUpdate$1(r19, r18, r20, r16, null), 3, null);
    L37:
        long r23 = System.currentTimeMillis();
        if (((Keva) f2713c.getValue()).getBoolean("com_flow_music_auth", false) == true) goto L49;
        Iterator r24 = r18.f2759a.iterator();
    L42:
        if (r24.hasNext() == false) goto L44;
        t r25 = (t) r24.next();
        ConcurrentHashMap r26 = com.bytedance.iesgurd.a.f6593a;
        com.bytedance.iesgurd.a.a(r25.f2757a, "com_flow_music_auth");
        goto L42
    L44:
        ((Keva) f2713c.getValue()).storeBoolean("com_flow_music_auth", true);
        String r27 = "deleteMusicResourceCache cost: " + (System.currentTimeMillis() - r23);
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L49;
        r28.i("AppletResourceLoader", r27);
    L49:
        g.N(Boolean.TRUE);
        return;
    L35:
        p().storeInt("offlineFileVersion", r20);
        r19.N(Boolean.TRUE);
        goto L37
    L31:
        r22 = null;
        goto L33
    L36:
        r19.N(Boolean.TRUE);
        goto L37
    L47:
        r19.N(Boolean.TRUE);
        goto L49
    L48:
        r19.N(Boolean.TRUE);
        goto L49
    L7:
        r5.invoke();
        goto L10
    L8:
        r5.invoke();
        goto L10
    }

    public static void j(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        String r10 = "closeSession: " + r5;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L5;
        r11.d("AIManager", r10);
    L5:
        IIvyAIPackageResourceService.Companion.closeSession(r5);
    }

    public static void k(final String r10, final String r11, final Function1 r12, final Function1 r13, final boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        Function0 r5 = new a0(r10, r11, r12, r13, r14);
        if (g.isCompleted() == false) goto L7;
        r5.invoke();
        Unit r15 = Unit.INSTANCE;
        return;
    L7:
        if (Intrinsics.areEqual(c1.b.c().getLooper(), Looper.myLooper()) == false) goto L10;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AppletResourceTool$runAfterEnsureInitialized$1(r5, null), 3, null);
        return;
    L10:
        BuildersKt.runBlocking$default(null, new AppletResourceTool$runAfterEnsureInitialized$2(r5, null), 1, null);
    }

    public static String l(String r5) {
        if (StringsKt.P(r5, ".") == false) goto L6;
        r5 = StringsKt.S(r5, ".");
    L6:
        if (StringsKt.P(r5, "/") == true) goto L8;
        return r5;
    L8:
        return StringsKt.S(r5, "/");
    }

    public static String m(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        String r5 = l(r10);
        Uri r12 = Uri.parse(l(r10));
        j r13 = j.f2734a;
        Intrinsics.checkNotNullParameter(r11, "packageId");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        if (j.n(r11) == false) goto L5;
        f0 r14 = (f0) j.f2736c.get(r11);
    L6:
        if (r14 != null) goto L11;
        String r15 = androidx.room.jarjarred.org.antlr.runtime.a.r("getCommonResourceUrl exception: package: ", r11, " is NOT Found", "AppletResourceLoader", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L71;
        r16.e("AppletResourceLoader", r15);
        return r10;
    L71:
        return r10;
    L11:
        String r17 = r12.getHost();
        if (r17 != null) goto L14;
    L36:
        Intrinsics.checkNotNullParameter(r11, "appletName");
        long r18 = r14.f2721i;
        if (r14.f2718b == false) goto L60;
        if (com.bytedance.ai.utils.c.l("") == true) goto L41;
        String r19 = "base_" + r14.f2721i;
        com.bytedance.ai.multiprocess.a r20 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r20 != null) goto L45;
    L56:
        String r21 = null;
    L58:
        return f(r11, "base", r19, r5, r18, r21);
    L45:
        if (r20.f2402c == false) goto L48;
    L54:
        r21 = e(r11, r5);
        goto L58
    L48:
        if (r20.f2402c == true) goto L56;
        if (r11.length() == 0) goto L56;
        if (r20.d.contains(r11) == false) goto L56;
    L41:
        return b(r18, "/" + r5);
    L60:
        if (j.n(r11) == false) goto L70;
        String r22 = o(r11);
        if (r22 != null) goto L64;
    L68:
        return r5;
    L64:
        if (r22.length() == 0) goto L68;
        return n(r22 + '/' + r11 + '/' + r5, r14.e, false);
    L70:
        return f(r11, "base", "base_" + r14.f2721i, r5, r18, null);
    L14:
        if (r17.length() == 0) goto L36;
        if (r14.f2718b == false) goto L72;
        com.bytedance.ai.multiprocess.a r23 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r23 != null) goto L21;
        return r10;
    L21:
        if (r23.f2402c == false) goto L24;
    L30:
        String r24 = r12.getPath();
        if (r24 == null) goto L35;
        r5 = r24;
    L35:
        return Uri.parse(r10).buildUpon().appendQueryParameter("debugInfo", e(r11, r5)).appendQueryParameter("packageName", r11).build().toString();
    L24:
        if (r23.f2402c == false) goto L26;
        return r10;
    L26:
        if (r11.length() != 0) goto L29;
        return r10;
    L29:
        if (r23.d.contains(r11) == true) goto L30;
        return r10;
    L72:
        return r10;
    L5:
        r14 = (f0) j.d.get(r11);
        goto L6
    }

    public static String n(String r5, String r10, boolean r11) {
        Uri.Builder r12 = Uri.parse(r5).buildUpon();
        r12.appendQueryParameter("loader_name", "forest");
        r12.appendQueryParameter("dynamic", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        r12.appendQueryParameter("enable_memory_cache", "0");
        if (r10 != null) goto L5;
    L8:
        if (r11 == false) goto L11;
        r12.appendQueryParameter("dynamic", "2");
    L11:
        return r12.build().toString();
    L5:
        if (r10.length() == 0) goto L8;
        r12.appendQueryParameter("forest_session_id", r10);
        goto L8
    }

    public static String o(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        LruCache r10 = f2711a;
        String r11 = (String) r10.get(r5);
        if (r11 != null) goto L5;
    L8:
        String r12 = p().getString(r5, null);
        if (r12 != null) goto L11;
    L14:
        return r12;
    L11:
        if (r12.length() == 0) goto L14;
        r10.put(r5, r12);
        goto L14
    L5:
        if (r11.length() == 0) goto L8;
        return r11;
    }

    public static Keva p() {
        return (Keva) f2712b.getValue();
    }
}
