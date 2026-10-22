package com.bytedance.android.ec.core.hybrid.prefetch;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.hybrid.model.TabKitDeeplinkPrefetchConfig;
import com.bytedance.android.ec.core.hybrid.model.TabKitDeeplinkPrefetchRule;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.y;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.store.tabkit.brandmall.NaPrefetchSyncCallback;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class NativePrefetchUtil {
    public static final ConcurrentHashMap<String, NativePrefetch> a = null;
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<NativeRequestCache>> b = null;
    public static final Handler c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final ConcurrentHashMap<String, List<String>> f = null;
    public static final ConcurrentSkipListSet<String> g = null;

    public NativePrefetchUtil() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new Handler(Looper.getMainLooper());
        d = LazyKt.lazy(NativePrefetchUtil$configs$2.INSTANCE);
        e = LazyKt.lazy(NativePrefetchUtil$bootPrefetchConfig$2.INSTANCE);
        f = new ConcurrentHashMap();
        g = new ConcurrentSkipListSet();
    }

    public static int c(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        String r10 = UriProtector.getQueryParameter(r1, "na_prefetch_strategy");
        if (r10 == null) goto L7;
        Integer r11 = StringsKt.toIntOrNull(r10);
        if (r11 == null) goto L7;
        return r11.intValue();
    L7:
        return 0;
    }

    public static Pair j(String r10) {
        if (r10 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L42
        Uri r11 = UriProtector.parse(r10);     // Catch: Throwable -> L42
        String r12 = UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L42
        String r13 = UriProtector.getQueryParameter(r11, "surl");     // Catch: Throwable -> L42
        boolean r14 = false;
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == false) goto L9;
        Uri r15 = r11;
    L26:
        if (r15 == null) goto L28;
        String r16 = r15.getPath();     // Catch: Throwable -> L42
    L29:
        if (r16 != null) goto L31;
    L32:
        r14 = true;
    L33:
        if (r14 == true) goto L40;
        Lazy r17 = d;     // Catch: Throwable -> L42
        if (((Map) r17.getValue()).containsKey(r16) == false) goto L40;
        y.b r18 = (y.b) ((Map) r17.getValue()).get(r16);     // Catch: Throwable -> L42
        if (r18 == null) goto L40;
        return TuplesKt.to(i(r16, r18, r11), r16);
    L40:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L45:
        return TuplesKt.to(null, null);
    L31:
        if (r16.length() != 0) goto L33;
    L28:
        r16 = null;
        goto L29
    L9:
        if (r12 != null) goto L11;
    L14:
        boolean r19 = true;
    L15:
        if (r19 == true) goto L17;
        r15 = UriProtector.parse(r12);     // Catch: Throwable -> L42
        goto L26
    L17:
        if (r13 != null) goto L19;
    L22:
        boolean r20 = true;
    L23:
        if (r20 == true) goto L25;
        r15 = UriProtector.parse(r13);     // Catch: Throwable -> L42
        goto L26
    L25:
        r15 = null;
        goto L26
    L19:
        if (r13.length() == 0) goto L22;
        r20 = false;
        goto L23
    L11:
        if (r12.length() == 0) goto L14;
        r19 = false;
    L42:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L5:
        return TuplesKt.to(null, null);
    }

    public static boolean l(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return false;
    L12:
        return a.containsKey(r10);
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static String d(String r10, String r11) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        String r13 = null;
        if (r12 == true) goto L43;
        if (r11 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L43;
        NativePrefetch r14 = a.get(r10);
        if ((r14 instanceof NativePrefetchLepus) == true) goto L20;
        r14 = null;
    L20:
        NativePrefetchLepus r15 = (NativePrefetchLepus) r14;
        if (r15 == null) goto L43;
        monitor-enter(r15);
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L40
        if (r15.k.containsKey(r11) == false) goto L38;
        NativePrefetchLepus.a r1 = (NativePrefetchLepus.a) ((LinkedHashMap) r15.k).get(r11);     // Catch: Throwable -> L40
        if (r1 == null) goto L28;
        o r16 = r1.b;     // Catch: Throwable -> L40
    L29:
        if (r16 == null) goto L38;
        if (r16.b != 1) goto L38;
        NativePrefetchLepus.a r17 = (NativePrefetchLepus.a) ((LinkedHashMap) r15.k).get(r11);     // Catch: Throwable -> L40
        if (r17 == null) goto L35;
        r17.b = null;     // Catch: Throwable -> L40
    L35:
        r13 = r16.a;     // Catch: Throwable -> L40
        monitor-exit(r15);
        goto L43
    L28:
        r16 = null;
    L38:
        monitor-exit(r15);
    L40:
        th = move-exception;
        throw th;
    L13:
        if (StringsKt.isBlank(r11) == false) goto L15;
    L43:
        return r13;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L9
    }

    public static JSONObject g(String r10, String r11) {
        boolean r0 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        JSONObject r13 = null;
        if (r12 == true) goto L33;
        if (r11 != null) goto L13;
    L16:
        if (r0 == true) goto L33;
        NativePrefetch r14 = a.get(r10);
        if ((r14 instanceof NativePrefetchLepus) == true) goto L21;
        r14 = null;
    L21:
        NativePrefetchLepus r15 = (NativePrefetchLepus) r14;
        if (r15 == null) goto L33;
        monitor-enter(r15);
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L30
        NativePrefetchLepus.a r16 = (NativePrefetchLepus.a) ((LinkedHashMap) r15.k).get(r11);     // Catch: Throwable -> L30
        if (r16 == null) goto L28;
        r13 = r16.d;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r15);
    L30:
        th = move-exception;
        throw th;
    L13:
        if (StringsKt.isBlank(r11) == true) goto L16;
        r0 = false;
    L33:
        return r13;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L9
    }

    public static q h(String r10, String r11) {
        boolean r0 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        q r13 = null;
        if (r12 == true) goto L33;
        if (r11 != null) goto L13;
    L16:
        if (r0 == true) goto L33;
        NativePrefetch r14 = a.get(r10);
        if ((r14 instanceof NativePrefetchLepus) == true) goto L21;
        r14 = null;
    L21:
        NativePrefetchLepus r15 = (NativePrefetchLepus) r14;
        if (r15 == null) goto L33;
        monitor-enter(r15);
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L30
        NativePrefetchLepus.a r16 = (NativePrefetchLepus.a) ((LinkedHashMap) r15.k).get(r11);     // Catch: Throwable -> L30
        if (r16 == null) goto L28;
        r13 = r16.c;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r15);
    L30:
        th = move-exception;
        throw th;
    L13:
        if (StringsKt.isBlank(r11) == true) goto L16;
        r0 = false;
    L33:
        return r13;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L9
    }

    public static void k(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r1 == null) goto L8;
        ji.a r12 = r1.getIECHostALogService();
        if (r12 == null) goto L9;
        r12.log(4, r10, r11);
        return;
    L9:
        return;
    }

    public static void o(String r10, String r11) {
        boolean r0 = true;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L24;
        if (r11 != null) goto L12;
    L15:
        if (r0 == true) goto L26;
        NativePrefetch r13 = a.get(r10);
        if ((r13 instanceof NativePrefetchLepus) == true) goto L20;
        r13 = null;
    L20:
        NativePrefetchLepus r14 = (NativePrefetchLepus) r13;
        if (r14 == null) goto L25;
        r14.I(r11);
        return;
    L25:
        return;
    L26:
        return;
    L12:
        if (StringsKt.isBlank(r11) == true) goto L15;
        r0 = false;
        goto L15
    L24:
        return;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L9
    }

    public static boolean a(String r10, boolean r11, boolean r12) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r11 == true) goto L52;
    L31:
        Pair r13 = j(r10);
        List r14 = (List) r13.getFirst();
        if (r14 != null) goto L34;
    L39:
        Logger.i("NativePrefetch", "check in config  tags error");
        Lazy r15 = EcPreloadDynamicCP.a;
        String r16 = (String) r13.getSecond();
        if (r16 == null) goto L57;
        Map<String, EcPreloadDynamicCP.b> r17 = EcPreloadDynamicCP.b().c();
        if (r17 == null) goto L58;
        EcPreloadDynamicCP.b r18 = r17.get(r16);
        if (r18 == null) goto L59;
        Integer r19 = r18.e();
        if (r19 != null) goto L49;
        return false;
    L49:
        if (r19.intValue() != 1) goto L60;
        return true;
    L60:
        return false;
    L59:
        return false;
    L58:
        return false;
    L57:
        return false;
    L34:
        if ((!r14.isEmpty()) != true) goto L39;
        Logger.i("NativePrefetch", "check in config  tags success");
        if (r12 == false) goto L38;
        g.add(r10);
    L38:
        return true;
    L52:
        List<String> r20 = y.a().a();     // Catch: Exception -> L26
        Uri r21 = UriProtector.parse(r10);     // Catch: Exception -> L26
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == true) goto L11;
        r21 = UriProtector.parse(UriProtector.getQueryParameter(r21, com.bytedance.android.ec.core.event.a.KEY_URL));     // Catch: Exception -> L26
    L11:
        String r22 = a2.d(r21.getPath());     // Catch: Exception -> L26
        if (r22 == null) goto L28;
        y.b r23 = (y.b) ((Map) d.getValue()).get(r22);     // Catch: Exception -> L26
        if (r23 != null) goto L17;
    L19:
        if (r20 == null) goto L28;
        Iterator<T> r24 = r20.iterator();     // Catch: Exception -> L26
    L21:
        if (r24.hasNext() == false) goto L28;
        if (StringsKt.endsWith$default(r22, (String) r24.next(), false, 2, null) == false) goto L21;
    L25:
        boolean r25 = true;
    L29:
        if (r25 == true) goto L31;
        return false;
    L17:
        if (r23.k != true) goto L19;
    L28:
        r25 = false;
    L26:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L28
    }

    public static /* synthetic */ boolean b(String r10, boolean r11, int r12) {
        boolean r1 = false;
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r1 = true;
    L9:
        return a(r10, r11, r1);
    }

    public static void e(String r10, String r11, NaPrefetchSyncCallback r12) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r10 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L51;
        if (r11 != null) goto L12;
    L15:
        boolean r14 = true;
    L16:
        if (r14 == true) goto L55;
        NativePrefetch r15 = a.get(r10);
        if ((r15 instanceof NativePrefetchLepus) == true) goto L21;
        r15 = null;
    L21:
        NativePrefetchLepus r16 = (NativePrefetchLepus) r15;
        if (r16 == null) goto L54;
        monitor-enter(r16);
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L48
        Intrinsics.checkNotNullParameter(r12, "callback");     // Catch: Throwable -> L48
        if (r16.k.containsKey(r11) == false) goto L46;
        NativePrefetchLepus.a r17 = (NativePrefetchLepus.a) ((LinkedHashMap) r16.k).get(r11);     // Catch: Throwable -> L48
        if (r17 == null) goto L29;
        o r18 = r17.b;     // Catch: Throwable -> L48
    L30:
        if (r18 == null) goto L40;
        int r19 = r18.b;     // Catch: Throwable -> L48
        if (r19 == (-999)) goto L40;
        if (r19 != 1) goto L36;
        r12.success(r18.a, false);     // Catch: Throwable -> L48
    L43:
        NativePrefetchLepus.a r20 = (NativePrefetchLepus.a) ((LinkedHashMap) r16.k).get(r11);     // Catch: Throwable -> L48
        if (r20 == null) goto L46;
        r20.b = null;     // Catch: Throwable -> L48
        goto L46
    L36:
        if (r19 != 2) goto L43;
        r12.fail("");     // Catch: Throwable -> L48
    L40:
        NativePrefetchLepus.a r0 = (NativePrefetchLepus.a) ((LinkedHashMap) r16.k).get(r11);     // Catch: Throwable -> L48
        if (r0 == null) goto L43;
        r0.a = r12;     // Catch: Throwable -> L48
        goto L43
    L29:
        r18 = null;
    L46:
        monitor-exit(r16);
        return;
    L48:
        th = move-exception;
        throw th;
    L54:
        return;
    L55:
        return;
    L12:
        if (StringsKt.isBlank(r11) == true) goto L15;
        r14 = false;
        goto L16
    L51:
        return;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r13 = false;
        goto L9
    }

    public static List i(String r18, y.b r19, Uri r20) {
        y.b r1 = r19;
        List<String> r10 = f.get(r18);
        List<String> r11 = r10;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
        return r10;
    L11:
        ArrayList r13 = new ArrayList();
        String r14 = r1.i;
        if (r14 == null) goto L14;
        List r15 = StringsKt.split$default(r14, new String[]{"|"}, false, 0, 6, null);
    L15:
        List r16 = r15;
        if (r16 != null) goto L18;
    L21:
        boolean r17 = true;
    L23:
        if (r17 == false) goto L25;
    L28:
        boolean r21 = !Intrinsics.areEqual(r1.d, "AB");
        if (r18 == null) goto L38;
        y.b r22 = (y.b) ((Map) d.getValue()).get(r18);
        if (r22 == null) goto L38;
        boolean r110 = r21;
        if (r22.b != null) goto L36;
    L39:
        boolean r23 = false;
    L40:
        if (r23 == true) goto L43;
        String r111 = "";
    L63:
        boolean r24 = false;
    L64:
        if (r24 == false) goto L66;
        Logger.i("NativePrefetch", "use default");
        r13.add("default");
    L66:
        boolean r25 = r110;
    L67:
        if (r15 != null) goto L69;
    L132:
        if (r25 == false) goto L134;
        f.put(r18, r13);
    L134:
        return r13;
    L69:
        if (r15.contains("config_tags") != true) goto L132;
        Map<String, y.c> r26 = r1.j;
        if (r26 == null) goto L132;
        Set<String> r27 = r26.keySet();
        if (r27 == null) goto L132;
        Iterator<T> r28 = r27.iterator();
    L76:
        if (r28.hasNext() == false) goto L132;
        String r29 = (String) r28.next();
        y.c r30 = r1.j.get(r29);
        if (r25 == false) goto L85;
        if (r30 == null) goto L81;
        String r31 = r30.c();
    L83:
        if ((!Intrinsics.areEqual(r31, "AB")) == false) goto L85;
        r25 = true;
    L86:
        if (r30 == null) goto L131;
        String r112 = r30.b();
        if (r112 != null) goto L90;
    L93:
        boolean r113 = true;
    L94:
        if (r113 == true) goto L96;
        String r114 = r30.c();
        if (r114 != null) goto L100;
    L103:
        boolean r115 = true;
    L104:
        if (r115 == true) goto L127;
        if (Intrinsics.areEqual(r30.c(), "full") == true) goto L127;
        if (Intrinsics.areEqual(r30.c(), "AB-Key") == false) goto L122;
        HashMap<String, JSONObject> r116 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        if (com.bytedance.android.ec.core.hybrid.utils.j.e(r30.a()) == false) goto L122;
        String r32 = r30.a();
        if (r32 != null) goto L115;
        r32 = r111;
    L115:
        Integer r33 = (Integer) com.bytedance.dataplatform.o.c(r32, Integer.TYPE, 0, true, true);
        if (r33 == null) goto L96;
        if (r33.intValue() != 1) goto L96;
    L122:
        if (Intrinsics.areEqual(r30.c(), "AB") == false) goto L96;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r20, "enable_native_prefetch"), "true") == false) goto L96;
    L127:
        boolean r117 = true;
    L128:
        if (r117 == false) goto L131;
        Logger.i("NativePrefetch", "use config tag is " + r29);
        r13.add(r29);
        goto L131
    L100:
        if (r114.length() == 0) goto L103;
        r115 = false;
    L96:
        r117 = false;
        goto L128
    L90:
        if (r112.length() == 0) goto L93;
        r113 = false;
    L131:
        r1 = r19;
        goto L76
    L81:
        r31 = null;
    L85:
        r25 = false;
        goto L86
    L43:
        if (Intrinsics.areEqual(r1.d, "full") == false) goto L46;
        r111 = "";
    L62:
        r24 = true;
        goto L64
    L46:
        if (Intrinsics.areEqual(r1.d, "AB-Key") == false) goto L58;
        HashMap<String, JSONObject> r34 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        if (com.bytedance.android.ec.core.hybrid.utils.j.e(r1.e) == false) goto L58;
        String r35 = r1.e;
        if (r35 != null) goto L52;
        r35 = "";
    L52:
        r111 = "";
        Integer r36 = (Integer) com.bytedance.dataplatform.o.c(r35, Integer.TYPE, 0, true, true);
        if (r36 == null) goto L63;
        if (r36.intValue() != 1) goto L63;
    L58:
        r111 = "";
        if (Intrinsics.areEqual(r1.d, "AB") == false) goto L63;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r20, "enable_native_prefetch"), "true") == false) goto L63;
    L36:
        if (r22.c == null) goto L39;
        r23 = true;
    L38:
        r110 = r21;
        goto L39
    L25:
        if (r15.contains("default") == true) goto L28;
        r111 = "";
        r25 = true;
        goto L67
    L18:
        if (r16.isEmpty() == true) goto L21;
        r17 = false;
        goto L23
    L14:
        r15 = null;
        goto L15
    L5:
        if (r11.isEmpty() == true) goto L8;
        r12 = false;
        goto L9
    }

    public static HashMap p(String r10, JSONObject r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Pair<String, String> r13 = new NativePrefetch().s(r10, r11, r12, false, null);
        String r14 = (String) r13.getFirst();
        if (r14.length() <= 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L11;
        HashMap r16 = new HashMap();
        r16.put("ec_request_id", r14);
        String r17 = (String) r13.getSecond();
        if (r17 == null) goto L10;
        r16.put("prefetch_config_tags", r17);
    L10:
        return r16;
    L11:
        return null;
    L5:
        r15 = false;
        goto L6
    }

    public static JSONObject f(String r10, String r11, String r12, boolean r13) {
        boolean r0 = true;
        boolean r1 = false;
        if (r11 != null) goto L5;
    L8:
        boolean r14 = true;
    L10:
        if (r14 == true) goto L69;
        if (r12 != null) goto L13;
    L16:
        boolean r15 = true;
    L17:
        if (r15 == true) goto L73;
        if (r13 == false) goto L24;
        NativePrefetch r16 = a.get(r11);
        if (r16 != null) goto L23;
        return null;
    L23:
        return r16.p(r12);
    L24:
        if (r10 != null) goto L26;
    L29:
        boolean r17 = true;
    L30:
        if (r17 == true) goto L70;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L50
        int r19 = t0.a;     // Catch: Throwable -> L50
        List<TabKitDeeplinkPrefetchRule> r20 = ((TabKitDeeplinkPrefetchConfig) t0.a.a.fromJson((JsonObject) e.getValue(), TabKitDeeplinkPrefetchConfig.class)).getRules();     // Catch: Throwable -> L50
        if (r20 == null) goto L43;
        Iterator<T> r21 = r20.iterator();     // Catch: Throwable -> L50
    L35:
        if (r21.hasNext() == false) goto L39;
        Object r22 = r21.next();     // Catch: Throwable -> L50
        if (Intrinsics.areEqual(((TabKitDeeplinkPrefetchRule) r22).getBizTag(), r10) == false) goto L35;
    L40:
        TabKitDeeplinkPrefetchRule r23 = (TabKitDeeplinkPrefetchRule) r22;     // Catch: Throwable -> L50
        if (r23 == null) goto L43;
        int r24 = r23.getStrategy();     // Catch: Throwable -> L50
    L45:
        if ((r24 & 2) > 0) goto L48;
        r0 = false;
    L48:
        Object r25 = Result.constructor-impl(Boolean.valueOf(r0));     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r25) == false) goto L55;
        r25 = null;
    L55:
        Boolean r26 = (Boolean) r25;
        if (r26 == null) goto L58;
        r1 = r26.booleanValue();
    L58:
        if (r1 == false) goto L71;
        NativePrefetch r27 = a.get(r11);
        if (r27 != null) goto L62;
        return null;
    L62:
        return r27.p(r12);
    L71:
        return null;
    L39:
        r22 = null;
    L43:
        r24 = 0;
    L50:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L70:
        return null;
    L26:
        if (StringsKt.isBlank(r10) == true) goto L29;
        r17 = false;
        goto L30
    L73:
        return null;
    L13:
        if (StringsKt.isBlank(r12) == true) goto L16;
        r15 = false;
        goto L17
    L69:
        return null;
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r14 = false;
        goto L10
    }

    public static String m(String r10, JSONObject r11, String r12, boolean r13, boolean r14, boolean r15, JSONObject r16) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Lazy r1 = EcPreloadDynamicCP.a;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        boolean r17 = false;
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L28;
        String r18 = EcPreloadDynamicCP.c(r10);
        if (r18 != null) goto L11;
    L14:
        boolean r19 = true;
    L15:
        if (r19 == true) goto L28;
        Map<String, EcPreloadDynamicCP.b> r20 = EcPreloadDynamicCP.b().c();
        if (r20 == null) goto L28;
        EcPreloadDynamicCP.b r21 = r20.get(r18);
        if (r21 == null) goto L28;
        Integer r22 = r21.f();
        if (r22 == null) goto L28;
        if (r22.intValue() != 1) goto L28;
        boolean r23 = true;
    L29:
        if (r23 == true) goto L31;
        ConcurrentSkipListSet<String> r24 = g;
        if (r24.contains(r10) == false) goto L35;
        r24.remove(r10);
        boolean r25 = true;
    L36:
        if (r25 == false) goto L58;
        if (r14 == false) goto L40;
        NativePrefetch r110 = new NativePrefetchLepus();
    L41:
        NativePrefetch r26 = r110;
        r26.h = r13;
        Pair<String, String> r111 = r26.s(r10, r11, r12, r15, r16);
        String r112 = (String) r111.getFirst();
        String r113 = (String) r111.getSecond();
        if (r112.length() <= 0) goto L44;
        boolean r114 = true;
    L45:
        if (r114 == false) goto L58;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L55
        Uri.Builder r116 = UriProtector.parse(r10).buildUpon().appendQueryParameter("ec_request_id", r112);     // Catch: Throwable -> L55
        if (r113 != null) goto L49;
    L50:
        r17 = true;
    L51:
        if (r17 == true) goto L53;
        r116.appendQueryParameter("prefetch_config_tags", r113);     // Catch: Throwable -> L55
    L53:
        r10 = r116.build().toString();     // Catch: Throwable -> L55
        goto L58
    L49:
        if (r113.length() != 0) goto L51;
    L55:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L44:
        r114 = false;
        goto L45
    L40:
        r110 = new NativePrefetch();
    L58:
        return EcPreloadDynamicCP.a(r10, r11);
    L35:
        r25 = a(r10, false, false);
        goto L36
    L31:
        return EcPreloadDynamicCP.a(r10, r11);
    L11:
        if (r18.length() == 0) goto L14;
        r19 = false;
    L28:
        r23 = false;
        goto L29
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ String n(String r10, JSONObject r11, String r12, boolean r13, boolean r14, boolean r15, int r16) {
        if ((r16 & 4) == 0) goto L5;
        r12 = null;
    L5:
        String r17 = r12;
        if ((r16 & 8) == 0) goto L8;
        boolean r18 = false;
    L10:
        if ((r16 & 16) == 0) goto L12;
        boolean r19 = false;
    L14:
        if ((r16 & 32) == 0) goto L16;
        boolean r20 = false;
    L18:
        return m(r10, r11, r17, r18, r19, r20, null);
    L16:
        r20 = r15;
        goto L18
    L12:
        r19 = r14;
        goto L14
    L8:
        r18 = r13;
        goto L10
    }
}
