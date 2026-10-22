package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cookie.CookieMetricManager;
import com.bytedance.frameworks.baselib.network.http.cookie.WebviewCookieRawSyncUtil;
import com.bytedance.frameworks.baselib.network.http.cookie.d;
import com.bytedance.frameworks.baselib.network.http.cookie.e;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SSCookieHandler extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2439a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile android.webkit.CookieManager f2440b;
    private final Pattern c;
    private final a d;
    private final boolean e;
    private final boolean f;
    private final WebViewCookieMgrUsage g;
    private volatile long h;
    private final AtomicBoolean i;
    private final ConcurrentHashMap<URI, List<String>> j;
    private final long k;
    private long l;

    public static final enum CookieInitType extends Enum<CookieInitType> {
        private static final /* synthetic */ CookieInitType[] $VALUES = null;
        public static final CookieInitType INIT_V1 = null;
        public static final CookieInitType INIT_V2_DISABLE_COOKIE_MGR = null;
        public static final CookieInitType INIT_V2_PREFER_DELAY_COOKIE_MGR = null;

        static {
            CookieInitType r0 = new CookieInitType("INIT_V1", 0);
            INIT_V1 = r0;
            CookieInitType r1 = new CookieInitType("INIT_V2_PREFER_DELAY_COOKIE_MGR", 1);
            INIT_V2_PREFER_DELAY_COOKIE_MGR = r1;
            CookieInitType r3 = new CookieInitType("INIT_V2_DISABLE_COOKIE_MGR", 2);
            INIT_V2_DISABLE_COOKIE_MGR = r3;
            $VALUES = new CookieInitType[]{r0, r1, r3};
        }

        private CookieInitType(String r1, int r2) {
            super(r1, r2);
        }

        public static CookieInitType valueOf(String r2) {
            return (CookieInitType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CookieInitType.class, r2), CookieInitType.class, "com.obric.memorydata.plugin");
        }

        public static CookieInitType[] values() {
            return (CookieInitType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CookieInitType[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final enum ReqCookieSource extends Enum<ReqCookieSource> {
        private static final /* synthetic */ ReqCookieSource[] $VALUES = null;
        public static final ReqCookieSource APP_COOKIE_STORE = null;
        public static final ReqCookieSource MAIN = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_BACKUP = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_MAIN = null;
        public static final ReqCookieSource TT_WRAP = null;
        public static final ReqCookieSource UNKNOWN = null;

        static {
            ReqCookieSource r0 = new ReqCookieSource("UNKNOWN", 0);
            UNKNOWN = r0;
            ReqCookieSource r1 = new ReqCookieSource("APP_COOKIE_STORE", 1);
            APP_COOKIE_STORE = r1;
            ReqCookieSource r3 = new ReqCookieSource("SHARE_INTERCEPTOR_MAIN", 2);
            SHARE_INTERCEPTOR_MAIN = r3;
            ReqCookieSource r5 = new ReqCookieSource("SHARE_INTERCEPTOR_BACKUP", 3);
            SHARE_INTERCEPTOR_BACKUP = r5;
            ReqCookieSource r7 = new ReqCookieSource("MAIN", 4);
            MAIN = r7;
            ReqCookieSource r9 = new ReqCookieSource("TT_WRAP", 5);
            TT_WRAP = r9;
            $VALUES = new ReqCookieSource[]{r0, r1, r3, r5, r7, r9};
        }

        private ReqCookieSource(String r1, int r2) {
            super(r1, r2);
        }

        public static ReqCookieSource valueOf(String r2) {
            return (ReqCookieSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReqCookieSource.class, r2), ReqCookieSource.class, "com.obric.memorydata.plugin");
        }

        public static ReqCookieSource[] values() {
            return (ReqCookieSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReqCookieSource[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final enum TtCookieRelTestState extends Enum<TtCookieRelTestState> {
        private static final /* synthetic */ TtCookieRelTestState[] $VALUES = null;
        public static final TtCookieRelTestState BOTH_EMPTY = null;
        public static final TtCookieRelTestState EQUAL = null;
        public static final TtCookieRelTestState INVALID = null;
        public static final TtCookieRelTestState NOT_EQUAL = null;
        public static final TtCookieRelTestState ONLY_SYS_EMPTY = null;
        public static final TtCookieRelTestState ONLY_TT_EMPTY = null;

        static {
            TtCookieRelTestState r0 = new TtCookieRelTestState("INVALID", 0);
            INVALID = r0;
            TtCookieRelTestState r1 = new TtCookieRelTestState("BOTH_EMPTY", 1);
            BOTH_EMPTY = r1;
            TtCookieRelTestState r3 = new TtCookieRelTestState("ONLY_SYS_EMPTY", 2);
            ONLY_SYS_EMPTY = r3;
            TtCookieRelTestState r5 = new TtCookieRelTestState("ONLY_TT_EMPTY", 3);
            ONLY_TT_EMPTY = r5;
            TtCookieRelTestState r7 = new TtCookieRelTestState("NOT_EQUAL", 4);
            NOT_EQUAL = r7;
            TtCookieRelTestState r9 = new TtCookieRelTestState("EQUAL", 5);
            EQUAL = r9;
            $VALUES = new TtCookieRelTestState[]{r0, r1, r3, r5, r7, r9};
        }

        private TtCookieRelTestState(String r1, int r2) {
            super(r1, r2);
        }

        public static TtCookieRelTestState valueOf(String r2) {
            return (TtCookieRelTestState) ZeusTransformUtils.preCheckCast(Enum.valueOf(TtCookieRelTestState.class, r2), TtCookieRelTestState.class, "com.obric.memorydata.plugin");
        }

        public static TtCookieRelTestState[] values() {
            return (TtCookieRelTestState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TtCookieRelTestState[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum WebViewCookieMgrUsage extends Enum<WebViewCookieMgrUsage> {
        private static final /* synthetic */ WebViewCookieMgrUsage[] $VALUES = null;
        public static final WebViewCookieMgrUsage COLD_START_DELAY_INIT = null;
        public static final WebViewCookieMgrUsage DISABLED = null;
        public static final WebViewCookieMgrUsage INIT_AT_START = null;

        static {
            WebViewCookieMgrUsage r0 = new WebViewCookieMgrUsage("INIT_AT_START", 0);
            INIT_AT_START = r0;
            WebViewCookieMgrUsage r1 = new WebViewCookieMgrUsage("COLD_START_DELAY_INIT", 1);
            COLD_START_DELAY_INIT = r1;
            WebViewCookieMgrUsage r3 = new WebViewCookieMgrUsage("DISABLED", 2);
            DISABLED = r3;
            $VALUES = new WebViewCookieMgrUsage[]{r0, r1, r3};
        }

        private WebViewCookieMgrUsage(String r1, int r2) {
            super(r1, r2);
        }

        public static WebViewCookieMgrUsage valueOf(String r2) {
            return (WebViewCookieMgrUsage) ZeusTransformUtils.preCheckCast(Enum.valueOf(WebViewCookieMgrUsage.class, r2), WebViewCookieMgrUsage.class, "com.obric.memorydata.plugin");
        }

        public static WebViewCookieMgrUsage[] values() {
            return (WebViewCookieMgrUsage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WebViewCookieMgrUsage[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface a {
        ArrayList<String> a();

        void a(String r1, String r2, JSONObject r3);
    }

    static {
    }

    public SSCookieHandler(Context r6, android.webkit.CookieManager r7, CookieInitType r8, a r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
        this.c = Pattern.compile("(?<=Domain=)([^;]*)", 2);
        this.h = -1;
        boolean r4 = false;
        this.i = new AtomicBoolean(false);
        this.j = new ConcurrentHashMap();
        this.l = -1;
        this.k = System.currentTimeMillis();
        boolean r1 = g.b(r10);
        this.f = r1;
        if (r8 == CookieInitType.INIT_V1) goto L5;
        boolean r2 = true;
    L6:
        this.e = r2;
        if (r8 != CookieInitType.INIT_V2_DISABLE_COOKIE_MGR) goto L9;
        r7 = null;
    L9:
        this.f2440b = r7;
        this.d = r11;
        if (r8 != CookieInitType.INIT_V2_DISABLE_COOKIE_MGR) goto L15;
        this.g = WebViewCookieMgrUsage.DISABLED;
        if (Logger.debug() == false) goto L32;
        Logger.d("SSCookieHandler", "CookieInitV2 disableCookieMgr");
    L32:
        a(r10);
        if (this.g != WebViewCookieMgrUsage.INIT_AT_START) goto L36;
        b();
    L36:
        if (com.bytedance.frameworks.baselib.network.a.b.e() == false) goto L44;
        JSONObject r12 = new JSONObject();
        r12.put(CommonConsts.APM_INNER_EVENT_COST_INIT, "success");     // Catch: JSONException -> L41
    L39:
        this.d.a("TTNET-COOKIE", CommonConsts.APM_INNER_EVENT_COST_INIT, r12);
        return;
    L44:
        return;
    L15:
        if (r8 != CookieInitType.INIT_V2_PREFER_DELAY_COOKIE_MGR) goto L30;
        if (r1 == false) goto L25;
        if (this.f2440b != null) goto L25;
        if (b.a().b() == false) goto L25;
        if (WebviewCookieRawSyncUtil.b() == false) goto L25;
        r4 = true;
    L25:
        if (Logger.debug() == false) goto L27;
        Logger.d("SSCookieHandler", "CookieInitV2 isMain:" + r1 + ", cookieMgr:" + this.f2440b + ", delayInitCookieMgr:" + r4);
    L27:
        if (r4 == false) goto L30;
        WebViewCookieMgrUsage r13 = WebViewCookieMgrUsage.COLD_START_DELAY_INIT;
    L31:
        this.g = r13;
    L30:
        r13 = WebViewCookieMgrUsage.INIT_AT_START;
        goto L31
    L5:
        r2 = false;
        goto L6
    }

    private String a(String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return null;
    L18:
        Matcher r3 = this.c.matcher(r5);     // Catch: IllegalArgumentException -> L17
        if (r3.find() == false) goto L8;
        String r0 = r3.group().toLowerCase();     // Catch: IllegalArgumentException -> L17
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return r5;
    L13:
        if (a(r0) == false) goto L20;
        return r3.replaceFirst(r4);
    L20:
        return null;
    L8:
        r0 = null;
    L21:
        return null;
    }

    private String a(URI r18, String r19, Pair<String, Map<String, Set<e>>> r20, long r21, long r23, boolean r25, boolean r26, boolean r27) {
        long r2 = System.nanoTime();
        JSONObject r4 = new JSONObject();
        int r12 = 0;
        if (r27 == true) goto L108;
    L55:
        boolean r7 = false;
    L58:
        if (com.bytedance.frameworks.baselib.network.a.b.d() == true) goto L73;
        long r8 = System.nanoTime();     // Catch: Throwable -> L64
        JSONObject r10 = CookieMetricManager.a().b();     // Catch: Throwable -> L64
        long r13 = (System.nanoTime() - r8) / 1000;     // Catch: Throwable -> L62
    L67:
        if (r10 == null) goto L70;
        r4.put(MemoryListActivity.JUMP_FROM_DETAIL, r10);     // Catch: Throwable -> L104
    L70:
        if (r13 <= 0) goto L73;
        r4.put("detail_t", r13);     // Catch: Throwable -> L104
    L62:
        th = th;
    L66:
        th.printStackTrace();     // Catch: Throwable -> L104
        r13 = -1;
    L64:
        th = th;
        r10 = null;
    L73:
        if (this.g != WebViewCookieMgrUsage.COLD_START_DELAY_INIT) goto L75;
        int r0 = 1;
    L77:
        if (this.f2440b != null) goto L79;
        int r9 = 0;
    L81:
        if (this.i.get() == false) goto L83;
        int r11 = 4;
    L84:
        if (r25 == false) goto L86;
        int r14 = 8;
    L87:
        if (r7 == false) goto L89;
        int r15 = 16;
    L90:
        if (r26 == false) goto L92;
        int r16 = 32;
    L94:
        if (this.g != WebViewCookieMgrUsage.DISABLED) goto L96;
        r12 = 64;
    L96:
        r4.put("init_state", (((((r0 | r9) | r11) | r14) | r15) | r16) | r12);     // Catch: Throwable -> L104
        long r17 = b.c();     // Catch: Throwable -> L104
        if (r17 <= 0) goto L99;
        r4.put("tt_init", r17);     // Catch: Throwable -> L104
    L99:
        long r1 = this.l;     // Catch: Throwable -> L104
        if (r1 <= 0) goto L102;
        r4.put("cs_t", r1);     // Catch: Throwable -> L104
    L102:
        r4.put("rel_t", (System.nanoTime() - r2) / 1000);     // Catch: Throwable -> L104
        return r4.toString();
    L104:
        th = move-exception;
        th.printStackTrace();
        return null;
    L92:
        r16 = 0;
        goto L94
    L89:
        r15 = 0;
        goto L90
    L86:
        r14 = 0;
        goto L87
    L83:
        r11 = 0;
        goto L84
    L79:
        r9 = 2;
        goto L81
    L75:
        r0 = 0;
        goto L77
    L108:
        if (this.f2440b == null) goto L55;
        if (r23 != (-1)) goto L10;
        long r110 = System.nanoTime();     // Catch: Throwable -> L104
        Pair<String, Map<String, Set<e>>> r3 = b.a().b(r18);     // Catch: Throwable -> L104
        long r111 = (System.nanoTime() - r110) / 1000;     // Catch: Throwable -> L104
    L11:
        String r112 = "";
        if (r3 != null) goto L14;
    L17:
        String r6 = "";
    L18:
        if (r19 == null) goto L22;
        r112 = r19;
    L22:
        if (r112.isEmpty() == false) goto L27;
        if (r6.isEmpty() == false) goto L27;
        TtCookieRelTestState r5 = TtCookieRelTestState.BOTH_EMPTY;     // Catch: Throwable -> L104
    L29:
        r7 = false;
        double r22 = 100.0d;
    L51:
        r4.put(NotificationCompat.CATEGORY_SYSTEM, r21);     // Catch: Throwable -> L104
        r4.put("tt", r111);     // Catch: Throwable -> L104
        r4.put("rel", r5.ordinal());     // Catch: Throwable -> L104
        r4.put("rel_p", r22);     // Catch: Throwable -> L104
        String r24 = WebviewCookieRawSyncUtil.a();     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r24) == true) goto L58;
        r4.put("sync", new JSONObject(r24));     // Catch: Throwable -> L107
    L27:
        if (r112.equalsIgnoreCase(r6) == false) goto L30;
    L28:
        r5 = TtCookieRelTestState.EQUAL;     // Catch: Throwable -> L104
        goto L29
    L30:
        HashSet<String> r28 = d.a(r112);     // Catch: Throwable -> L104
        if (r3 != null) goto L33;
    L36:
        Map r29 = new HashMap();     // Catch: Throwable -> L104
    L37:
        Set r30 = r29.keySet();     // Catch: Throwable -> L104
        if (Objects.equals(r28, r30) == true) goto L28;
        if (r28.isEmpty() == false) goto L44;
        TtCookieRelTestState r31 = TtCookieRelTestState.ONLY_SYS_EMPTY;     // Catch: Throwable -> L104
    L47:
        Pair<Boolean, Double> r32 = d.a(r28, r29, r4);     // Catch: Throwable -> L104
        if (r32 == null) goto L50;
        boolean r33 = ((Boolean) ZeusTransformUtils.preCheckCast(r32.first, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L104
        double r113 = ((Double) ZeusTransformUtils.preCheckCast(r32.second, Double.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: Throwable -> L104
        r5 = r31;
        r7 = r33;
        r22 = r113;
        goto L51
    L50:
        r5 = r31;
        goto L29
    L44:
        if (r30.isEmpty() == false) goto L46;
        r31 = TtCookieRelTestState.ONLY_TT_EMPTY;     // Catch: Throwable -> L104
        goto L47
    L46:
        r31 = TtCookieRelTestState.NOT_EQUAL;     // Catch: Throwable -> L104
        goto L47
    L33:
        if (r3.second == null) goto L36;
        r29 = (Map) ZeusTransformUtils.preCheckCast(r3.second, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L104
        goto L37
    L14:
        if (r3.first == null) goto L17;
        r6 = (String) ZeusTransformUtils.preCheckCast(r3.first, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L104
        goto L18
    L10:
        r3 = r20;
        r111 = r23;
        goto L11
    }

    private List<String> a(Map<String, List<String>> r3, String r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(r2.get(r4), List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        if (r5.isEmpty() == true) goto L14;
        return r5;
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r2.get(r4.toLowerCase()), List.class, "com.obric.memorydata.plugin");
    L19:
        return null;
    }

    private Map<String, List<String>> a(List<String> r5, Map<String, List<String>> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Map<String, List<String>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map<String, List<String>> r0 = Collections.emptyMap();
        List<String> r2 = null;
        if (f2439a == false) goto L14;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r8 == null) goto L7;
        r2 = a(r8, "Cookie");
        List<String> r4 = a(r8, CronetHttpURLConnection.SS_COOKIE);
    L9:
        if (com.bytedance.common.utility.collection.a.a(r2) == false) goto L12;
        r1.put("Cookie", r7);
    L12:
        if (com.bytedance.common.utility.collection.a.a(r4) == false) goto L20;
        r1.put(CronetHttpURLConnection.SS_COOKIE, r7);
        return r1;
    L20:
        return r1;
    L7:
        r4 = null;
        goto L9
    L14:
        if (r8 == null) goto L17;
        r2 = a(r8, "Cookie");
    L17:
        if (com.bytedance.common.utility.collection.a.a(r2) == true) goto L19;
        return r0;
    L19:
        return Collections.singletonMap("Cookie", r7);
    }

    private static Map<String, List<String>> a(boolean r2, Map<String, List<String>> r3, ReqCookieSource r4) {
        Map<String, List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L5;
        return r5;
    L5:
        if (r5 != null) goto L7;
    L11:
        return r5;
    L7:
        if (r5.isEmpty() == true) goto L11;
        LinkedHashMap r6 = new LinkedHashMap(r5);
        r6.put("x-tt-get-cookie-source", Collections.singletonList(String.valueOf(r4.ordinal())));
        return r6;
    }

    private void a() {
        this.l = System.currentTimeMillis() - this.k;
        ConcurrentHashMap<URI, List<String>> r0 = this.j;     // Catch: Throwable -> L19
        monitor-enter(r0);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.j.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("SSCookieHandler", "syncColdStartSetCookies, cache host size:" + this.j.size());     // Catch: Throwable -> L16
    L12:
        a(this.j, true, true);     // Catch: Throwable -> L16
        this.j.clear();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        a("", true);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
    }

    private void a(Context r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        b.a();
        com.bytedance.common.utility.a.a.b().schedule(new $$Lambda$SSCookieHandler$JeU0OA01gpKOw5X97qkwtpE4gLc(this, r5), com.bytedance.frameworks.baselib.network.a.b.j(), TimeUnit.SECONDS);
    }

    @Deprecated
    private void a(String r3, String r4, Set<String> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return;
    L7:
        if (this.f2440b == null) goto L20;
        r6.add(r3);
        this.f2440b.setCookie(r3, r4);
        f.k r2 = f.h();     // Catch: Throwable -> L14
        if (r2 == null) goto L19;
        r2.a(r3, r4);     // Catch: Throwable -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    private void a(String r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L13;
        String r2 = a(r5, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        if (TextUtils.isEmpty(r2) == true) goto L7;
        r0.add(r2);
        goto L7
    L13:
        if (r0.isEmpty() == false) goto L16;
        return;
    L16:
        if (Logger.debug() == false) goto L23;
        Logger.d("SSCookieHandler", "Sync cookies list for WebView request, original url: " + r5);
    L23:
        HashMap r9 = new HashMap();     // Catch: Throwable -> L20
        r9.put(new URI(r5), r0);     // Catch: Throwable -> L20
        a(r9, true, false);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
    }

    private void a(String r5, boolean r6) {
        if (this.f2440b != null) goto L5;
        return;
    L5:
        if (this.g != WebViewCookieMgrUsage.DISABLED) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        return;
    L10:
        if (r6 == false) goto L15;
        this.f2440b.flush();
        if (Logger.debug() == false) goto L32;
        Logger.d("SSCookieHandler", "Force flush cookie: " + r5);
        return;
    L32:
        return;
    L15:
        ArrayList<String> r7 = this.d.a();
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return;
    L18:
        if (com.bytedance.common.utility.collection.a.a(r7) == true) goto L38;
        Iterator<String> r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L39;
        if (r5.equals((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L22;
        this.f2440b.flush();
        if (Logger.debug() == false) goto L36;
        Logger.d("SSCookieHandler", "Path match flush cookie: " + r5);
        return;
    L36:
        return;
    L39:
        return;
    }

    private void a(URI r14, Map<String, List<String>> r15) {
        Map<String, List<String>> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L153;
        if (r16 != null) goto L6;
        return;
    L6:
        if (r16.isEmpty() == true) goto L155;
        List<String> r0 = a(r16, Api.KEY_SET_COOKIE);
        if (f2439a == false) goto L14;
        if (com.bytedance.common.utility.d.a(r0) == false) goto L14;
        r0 = a(r16, "X-SS-Set-Cookie");
    L14:
        if (com.bytedance.common.utility.d.a(r0) == false) goto L16;
        return;
    L16:
        f.j r2 = f.f();
        String r3 = null;
        if (r2 == null) goto L19;
        List<String> r4 = r2.getShareCookieHostList(r14.getHost());
    L21:
        if (com.bytedance.frameworks.baselib.network.a.b.e() == false) goto L23;
        JSONObject r5 = new JSONObject();
    L24:
        if (r5 == null) goto L31;
        a(r5, "version", LocationInfoConst.LIBRA_PARAM_V2);
        a(r5, "url", r14.toString());
        if (r4 != null) goto L28;
        String r6 = "";
    L29:
        a(r5, "shareHostList", r6);
        a(r5, "responseHeaders", r16.toString());
        a(r5, "setCookieList", r0.toString());
        goto L31
    L28:
        r6 = r4.toString();
    L31:
        if (com.bytedance.frameworks.baselib.network.a.a.a() == true) goto L33;
    L125:
        f.InterfaceC0129f r7 = f.g();     // Catch: Throwable -> L41
        if (r7 == null) goto L43;
        r7.b(r14, r16);     // Catch: Throwable -> L41
    L43:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r16.get("webview-origin-url"), List.class, "com.obric.memorydata.plugin");
        boolean r8 = true;
        if (com.bytedance.common.utility.d.a(r17) == true) goto L52;
        r3 = (String) ZeusTransformUtils.preCheckCast(r17.get(0), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == false) goto L119;
    L51:
        boolean r18 = true;
    L53:
        ArrayList r9 = new ArrayList();
        Iterator<String> r10 = r0.iterator();
        boolean r11 = false;
    L55:
        if (r10.hasNext() == false) goto L86;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L60;
        Logger.v("SSCookieHandler", "receive cookie: " + r14 + ", set-cookie:" + r12);
    L60:
        if (TextUtils.isEmpty(r12) == true) goto L55;
        String r13 = r12.toLowerCase().trim();
        if (r13.contains("sessionid=") == false) goto L65;
        r11 = true;
    L65:
        if (r11 == true) goto L74;
        if (com.bytedance.frameworks.baselib.network.a.b.c() == false) goto L74;
        if (r13.contains("store-country-code=") == false) goto L71;
    L72:
        r11 = true;
        goto L74
    L71:
        if (r13.contains("store-region=") == true) goto L72;
    L74:
        if (com.bytedance.frameworks.baselib.network.a.b.a(r12) == true) goto L55;
        if (TextUtils.isEmpty(r3) == false) goto L55;
        if (com.bytedance.common.utility.d.a(r4) == true) goto L55;
        if (a(r14, r12) == false) goto L55;
        r9.add(r12);
        goto L55
    L86:
        HashMap r19 = new HashMap();
        r19.put(r14, r0);
        if (r9.isEmpty() == false) goto L89;
    L109:
        a(r19, r18, false);
        a(r14.getPath(), r11);     // Catch: Throwable -> L112
    L114:
        if (r5 != null) goto L117;
        r8 = false;
    L117:
        a(r5, "last return", r8);
        return;
    L112:
        th = move-exception;
        th.printStackTrace();
        goto L114
    L89:
        if (com.bytedance.common.utility.d.a(r4) == true) goto L109;
        Iterator<String> r1 = r4.iterator();
    L92:
        if (r1.hasNext() == false) goto L109;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r20) == true) goto L92;
        if (r14.getHost().endsWith(r20) == true) goto L92;
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L107
        Iterator r110 = r9.iterator();     // Catch: Throwable -> L107
    L101:
        if (r110.hasNext() == false) goto L105;
        String r111 = this.c.matcher((String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin")).replaceFirst(r20);     // Catch: Throwable -> L107
        if (TextUtils.isEmpty(r111) == true) goto L101;
        r21.add(r111);     // Catch: Throwable -> L107
        goto L101
    L105:
        r19.put(URI.create(r14.getScheme() + "://" + r20 + "/"), r21);     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        th.printStackTrace();
        goto L92
    L119:
        a(r3, r0);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        th.printStackTrace();
        goto L51
    L52:
        r18 = false;
    L41:
        th = move-exception;
        th.printStackTrace();
        goto L43
    L33:
        if ("http".equalsIgnoreCase(r14.getScheme()) == false) goto L125;
        if (r4 == null) goto L36;
        r4.clear();
    L36:
        a(r5, "disable_share_insecure_cookie", "1");
        goto L125
    L23:
        r5 = null;
        goto L24
    L19:
        r4 = null;
        goto L21
    L155:
        return;
    }

    private void a(Map<URI, List<String>> r12, boolean r13, boolean r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L5;
        return;
    L5:
        if (r15.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.g != WebViewCookieMgrUsage.DISABLED) goto L10;
        boolean r0 = true;
    L12:
        if (this.e == false) goto L42;
        if (r13 == false) goto L15;
    L19:
        boolean r16 = false;
    L20:
        r0 = r0 | r16;
        if (this.f2440b != null) goto L24;
        if (r0 == true) goto L24;
        b();
    L24:
        if (r16 == false) goto L42;
        ConcurrentHashMap<URI, List<String>> r17 = this.j;
        monitor-enter(r17);
        Iterator r1 = r15.entrySet().iterator();     // Catch: Throwable -> L39
    L29:
        if (r1.hasNext() == false) goto L37;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (Logger.debug() == false) goto L33;
        Logger.v("SSCookieHandler", "cache coldStart cookie for: " + r4.getKey());     // Catch: Throwable -> L39
    L33:
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(this.j.get(r4.getKey()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (r5 != null) goto L36;
        r5 = new ArrayList();     // Catch: Throwable -> L39
        this.j.put((URI) ZeusTransformUtils.preCheckCast(r4.getKey(), URI.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L39
    L36:
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(r4.getValue(), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
        goto L29
    L37:
        monitor-exit(r17);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    L15:
        if (this.g != WebViewCookieMgrUsage.COLD_START_DELAY_INIT) goto L19;
        if (this.i.get() == true) goto L19;
        r16 = true;
    L42:
        HashSet r18 = new HashSet();
        f.k r2 = f.h();
        Iterator r19 = r15.entrySet().iterator();
    L44:
        if (r19.hasNext() == false) goto L70;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = ((URI) ZeusTransformUtils.preCheckCast(r6.getKey(), URI.class, "com.obric.memorydata.plugin")).toString();
        List<String> r8 = (List) ZeusTransformUtils.preCheckCast(r6.getValue(), List.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r7) == true) goto L44;
        if (com.bytedance.common.utility.collection.a.a(r8) == true) goto L44;
        if (r14 == true) goto L52;
        b.a().a((URI) ZeusTransformUtils.preCheckCast(r6.getKey(), URI.class, "com.obric.memorydata.plugin"), r8, null, true);
    L52:
        if (r0 == true) goto L44;
        this.h = System.currentTimeMillis();
        r18.add(r7);
        if (this.f2440b != null) goto L56;
    L59:
        boolean r9 = false;
    L60:
        Iterator<String> r10 = r8.iterator();
    L62:
        if (r10.hasNext() == false) goto L44;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (this.f2440b == null) goto L67;
        if (r9 == true) goto L67;
        this.f2440b.setCookie(r7, r11);
    L67:
        if (r2 == null) goto L62;
        r2.a(r7, r11);     // Catch: Throwable -> L76
        goto L62
    L56:
        if (com.bytedance.frameworks.baselib.network.a.b.b() == false) goto L59;
        Method r20 = this.f2440b.getClass().getDeclaredMethod("setCookieList", new Class[]{String.class, List.class});     // Catch: Throwable -> L77
        r20.setAccessible(true);     // Catch: Throwable -> L77
        r9 = ((Boolean) ZeusTransformUtils.preCheckCast(r20.invoke(this.f2440b, new Object[]{r7, r8}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L77
    L70:
        if (r0 == true) goto L103;
        if (r2 != null) goto L73;
        return;
    L73:
        if (r18.isEmpty() == true) goto L105;
        r2.a(r18);     // Catch: Throwable -> L78
        return;
    L107:
        return;
    L105:
        return;
    L103:
        return;
    L10:
        r0 = false;
        goto L12
    }

    private static void a(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r1.put(r2, r3);     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }

    private void a(JSONObject r2, String r3, boolean r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.d == null) goto L13;
        if (r4 == false) goto L14;
        r2.put("return", r3);     // Catch: JSONException -> L10
    L8:
        this.d.a("TTNET-COOKIE", "put", r2);
        return;
    L14:
        return;
    }

    private static boolean a(String r7) {
        if (r7.length() >= 2) goto L5;
        return false;
    L5:
        int r3 = 1;
        int r4 = 0;
    L7:
        if (r3 >= r7.length()) goto L14;
        if (r7.charAt(r3) != '.') goto L13;
        r4 = r4 + 1;
        if (r4 >= 2) goto L14;
    L13:
        r3 = r3 + 1;
    L14:
        if (r4 >= 2) goto L16;
        return false;
    L16:
        return true;
    }

    private boolean a(URI r4, String r5) {
        if (r4 != null) goto L5;
    L25:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L25;
        String r6 = r4.getHost().toLowerCase();     // Catch: Throwable -> L23
        String r2 = "";
        Matcher r3 = this.c.matcher(r5);     // Catch: Throwable -> L23
        if (r3.find() == false) goto L11;
        r2 = r3.group().toLowerCase();     // Catch: Throwable -> L23
    L11:
        if (TextUtils.isEmpty(r2) == false) goto L14;
        return false;
    L14:
        if (r2.equals(r6) == false) goto L18;
        return true;
    L18:
        if (r2.startsWith(".") == false) goto L22;
        return r6.endsWith(r2);
    L22:
        return r6.endsWith("." + r2);
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }

    private void b() {
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.f2440b == null) goto L7;
        return;
    L7:
        if (this.g == WebViewCookieMgrUsage.DISABLED) goto L24;
        this.f2440b = android.webkit.CookieManager.getInstance();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Logger.e("SSCookieHandler", "CookieInitV2 CookieManager get failed", th);
        if (this.f == true) goto L15;
        return;
    L15:
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L23;
        new Handler(Looper.getMainLooper()).post(new $$Lambda$SSCookieHandler$aqvyeP3mCXSUVkA_sPBMU2CdJg(this));
        return;
    L23:
        return;
    }

    private /* synthetic */ void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (this.i.compareAndSet(false, true) == true) goto L5;
    L10:
        WebviewCookieRawSyncUtil.a(r5, this.g);
        com.bytedance.frameworks.baselib.network.http.cookie.f.a(r5);
        return;
    L5:
        if (this.g != WebViewCookieMgrUsage.COLD_START_DELAY_INIT) goto L10;
        if (Logger.debug() == false) goto L9;
        Logger.d("SSCookieHandler", "CookieInitV2 cold start end by timer");
    L9:
        a();
        goto L10
    }

    @Deprecated
    private void b(String r3, String r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if (this.f2440b != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        String r7 = a(r3, r4);
        if (TextUtils.isEmpty(r7) == false) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("SSCookieHandler", " Sync cookies for WebView request, original url: " + r3);
    L13:
        a(r3, r7, r6);
        return;
    }

    private /* synthetic */ void c() {
        this.f2440b = android.webkit.CookieManager.getInstance();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.e("SSCookieHandler", "CookieInitV2 CookieManager get main failed", th);
    }

    public static /* synthetic */ void lambda$JeU0OA01gpKOw5X97qkwtpE4gLc(SSCookieHandler r0, Context r1) {
        r0.b(r1);
    }

    /* JADX INFO: renamed from: lambda$a-qvyeP3mCXSUVkA_sPBMU2CdJg, reason: not valid java name */
    public static /* synthetic */ void m90lambda$aqvyeP3mCXSUVkA_sPBMU2CdJg(SSCookieHandler r0) {
        r0.c();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r29, Map<String, List<String>> r30) {
        Map<String, List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L5;
        String r9 = r29.toString();     // Catch: Throwable -> L53
        if (r5 != null) goto L194;
    L38:
        boolean r10 = false;
        boolean r11 = false;
        boolean r13 = false;
    L39:
        f.InterfaceC0129f r0 = f.g();     // Catch: Throwable -> L51
        if (r0 == null) goto L59;
        Map<String, List<String>> r1 = r0.a(r29, r5);     // Catch: Throwable -> L51
        if (r1 == null) goto L59;
        if (r1.isEmpty() == true) goto L59;
        if (r1.containsKey("Cookie") == true) goto L50;
        if (r1.containsKey(CronetHttpURLConnection.SS_COOKIE) == false) goto L59;
    L50:
        return a(r10, r1, ReqCookieSource.APP_COOKIE_STORE);
    L59:
        boolean r27 = r10;
        String r12 = r9;
        boolean r14 = r13;
        boolean r15 = r11;
        f.j r2 = f.f();     // Catch: Throwable -> L69
        if (r2 == null) goto L72;
        List<String> r3 = r2.getShareCookie(this.f2440b, b.a(), r29);     // Catch: Throwable -> L69
        if (com.bytedance.common.utility.d.a(r3) == true) goto L72;
        ReqCookieSource r16 = ReqCookieSource.SHARE_INTERCEPTOR_MAIN;     // Catch: Throwable -> L69
        if (r3.remove("x-tt-cookie-backup-source=1") == false) goto L67;
        r16 = ReqCookieSource.SHARE_INTERCEPTOR_BACKUP;     // Catch: Throwable -> L69
    L67:
        return a(r27, a(r3, r5), r16);
    L72:
        if (this.g != WebViewCookieMgrUsage.DISABLED) goto L74;
        boolean r4 = true;
    L76:
        if (this.e == false) goto L89;
        if (r14 == false) goto L79;
    L83:
        boolean r17 = false;
    L84:
        r4 = r4 | r17;
        if (r4 == true) goto L89;
        if (this.f2440b != null) goto L89;
        b();
        goto L89
    L79:
        if (this.g != WebViewCookieMgrUsage.COLD_START_DELAY_INIT) goto L83;
        if (this.i.get() == true) goto L83;
        r17 = true;
    L89:
        long r18 = -1;
        if (this.f2440b == null) goto L128;
        if (r4 == true) goto L128;
        long r20 = System.nanoTime();     // Catch: Exception -> L125
        String r19 = this.f2440b.getCookie(r12);     // Catch: Exception -> L125
        if (r15 == true) goto L186;
        boolean r24 = r14;
        long r22 = -1;
        String r6 = null;
        boolean r8 = false;
    L188:
    L123:
        e = e;
        r19 = r6;
    L127:
        e.printStackTrace();
        boolean r21 = r8;
        Map<String, List<String>> r7 = null;
    L129:
        if (r7 != null) goto L163;
        if (r15 == true) goto L184;
        Map<String, List<String>> r31 = r7;
        String r23 = b.a().a(r29);     // Catch: Throwable -> L159
        Pair<String, Map<String, Set<e>>> r25 = null;
    L198:
    L157:
        th = th;
    L161:
        th.printStackTrace();
        Map<String, List<String>> r26 = r31;
    L162:
        Pair<String, Map<String, Set<e>>> r28 = r25;
        long r32 = r18;
    L164:
        String r33 = a(r29, r19, r28, r22, r32, r24, r21, r15);
        if (TextUtils.isEmpty(r33) == false) goto L167;
        if (r26 == null) goto L174;
        return r26;
    L174:
        return Collections.emptyMap();
    L167:
        if (r26 == null) goto L169;
        LinkedHashMap r34 = new LinkedHashMap(r26);
    L170:
        r34.put("x-tt-cookie-rel-metric", Collections.singletonList(r33));
        return r34;
    L169:
        r34 = new LinkedHashMap();
        goto L170
    L149:
        if (TextUtils.isEmpty(r23) == false) goto L151;
        Map<String, List<String>> r35 = r31;
    L156:
        r26 = r35;
        goto L162
    L151:
        if (Logger.debug() == false) goto L153;
        Logger.v("SSCookieHandler", "send ttWrap cookie: " + r12 + " " + r23);     // Catch: Throwable -> L157
    L153:
        r35 = a(r27, a(Collections.singletonList(r23), r5), ReqCookieSource.TT_WRAP);     // Catch: Throwable -> L157
    L159:
        th = th;
    L160:
        r25 = null;
        goto L161
    L184:
        long r36 = System.nanoTime();     // Catch: Throwable -> L143
        Pair<String, Map<String, Set<e>>> r37 = b.a().b(r29);     // Catch: Throwable -> L143
        if (r37 != null) goto L196;
        r31 = r7;
        r23 = null;
    L139:
        r18 = (System.nanoTime() - r36) / 1000;     // Catch: Throwable -> L141
        r25 = r37;
    L141:
        th = th;
    L142:
        r25 = r37;
        goto L161
    L196:
        r31 = r7;
        r23 = (String) ZeusTransformUtils.preCheckCast(r37.first, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L141
    L136:
        th = th;
        r31 = r7;
    L143:
        th = th;
        r31 = r7;
        goto L160
    L163:
        r26 = r7;
        r32 = -1;
        r28 = null;
        goto L164
    L115:
        if (TextUtils.isEmpty(r19) == false) goto L117;
        Map<String, List<String>> r38 = null;
    L122:
        r19 = r6;
        r21 = r8;
        r7 = r38;
        goto L129
    L117:
        if (Logger.debug() == false) goto L119;
        Logger.v("SSCookieHandler", "send cookie: " + r12 + " " + r19);     // Catch: Exception -> L123
    L119:
        r38 = a(r27, a(Collections.singletonList(r19), r5), ReqCookieSource.MAIN);     // Catch: Exception -> L123
        goto L122
    L186:
        r22 = (System.nanoTime() - r20) / 1000;     // Catch: Exception -> L110
    L108:
        e = e;
        r24 = r14;
    L112:
        r8 = false;
        goto L127
    L96:
        if (this.h <= 0) goto L105;
        r24 = r14;
        if ((System.currentTimeMillis() - this.h) > 3000) goto L106;
        boolean r39 = true;
    L107:
        r8 = r39;
        r6 = r19;
    L106:
        r39 = false;
    L103:
        e = e;
        goto L112
    L105:
        r24 = r14;
    L110:
        e = e;
        r24 = r14;
        r22 = -1;
    L125:
        e = e;
        r24 = r14;
        r22 = -1;
        r8 = false;
        r19 = null;
    L128:
        r24 = r14;
        r22 = -1;
        r7 = null;
        r19 = null;
        r21 = false;
        goto L129
    L74:
        r4 = false;
    L69:
        th = move-exception;
        th.printStackTrace();
        goto L72
    L194:
    L36:
        th = th;
    L55:
        r10 = false;
    L56:
        r11 = false;
    L57:
        r13 = false;
    L58:
        th.printStackTrace();
        goto L59
    L9:
        if (r5.isEmpty() == true) goto L38;
        r10 = r5.containsKey("x-tt-get-cookie-source");     // Catch: Throwable -> L36
    L34:
        th = th;
        goto L56
    L12:
        if (r5.containsKey("x-tt-cookie-rel-metric") == false) goto L16;
        if (com.bytedance.frameworks.baselib.network.a.b.k() == false) goto L16;
        r11 = true;
    L190:
        r13 = r5.containsKey("x-tt-webview-request");     // Catch: Throwable -> L32
        List<String> r40 = a(r5, "X-SS-No-Cookie");     // Catch: Throwable -> L51
        if (com.bytedance.common.utility.collection.a.a(r40) == true) goto L39;
        Iterator<String> r41 = r40.iterator();     // Catch: Throwable -> L51
    L22:
        if (r41.hasNext() == false) goto L39;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r41.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r110 == null) goto L22;
        if (Boolean.parseBoolean(r110) == false) goto L22;
        if (Logger.debug() == false) goto L31;
        Logger.v("SSCookieHandler", "X-SS-No-Cookie " + r9);     // Catch: Throwable -> L51
    L31:
        return Collections.emptyMap();
    L51:
        th = th;
    L32:
        th = th;
    L16:
        r11 = false;
    L53:
        th = th;
        r9 = null;
        goto L55
    L5:
        return Collections.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v11, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Class, java.lang.Class<java.util.List>] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r28, Map<String, List<String>> r29) {
        Map<String, List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.memorydata.plugin");
        if (com.bytedance.frameworks.baselib.network.a.b.a() == false) goto L5;
    L209:
        a(r28, r4);
        return;
    L5:
        if (this.e == true) goto L209;
        if (this.f2440b != null) goto L10;
        return;
    L10:
        f.j r0 = f.f();
        if (r0 == null) goto L14;
        if (r28 == null) goto L14;
        List<String> r6 = r0.getShareCookieHostList(r28.getHost());
    L15:
        JSONObject r7 = new JSONObject();
        String r8 = "X-SS-Set-Cookie";
        if (r4 != null) goto L18;
    L22:
        boolean r12 = false;
    L24:
        String r13 = "";
        if (r6 != null) goto L239;
        String r14 = "";
    L28:
        r7.put("shareHostList", r14);     // Catch: JSONException -> L211
        if (r12 == false) goto L32;
        r7.put("responseHeaders", r4.toString());     // Catch: JSONException -> L211
    L32:
        if (r28 == null) goto L35;
        r13 = r28.toString();     // Catch: JSONException -> L211
    L35:
        r7.put("url", r13);     // Catch: JSONException -> L211
        if (r28 != null) goto L38;
    L249:
        f.InterfaceC0129f r1 = f.g();     // Catch: Throwable -> L48
        if (r1 == null) goto L50;
        r1.b(r28, r4);     // Catch: Throwable -> L48
    L50:
        String r2 = "webview-origin-url";
        if (r4 != null) goto L53;
    L55:
        boolean r15 = false;
    L56:
        if (r28 == null) goto L208;
        if (r4 == null) goto L208;
        if (this.f2440b == null) goto L208;
        HashSet r16 = new HashSet();
        String r17 = r28.toString();
        if (f2439a == false) goto L64;
        String[] r18 = {"X-SS-Set-Cookie", Api.KEY_SET_COOKIE};
    L65:
        String[] r5 = r18;
        int r11 = r5.length;
        boolean r19 = r12;
        int r9 = 0;
        boolean r110 = false;
        boolean r111 = false;
    L67:
        if (r9 >= r11) goto L138;
        int r20 = r11;
        String r112 = r5[r9];
        String[] r21 = r5;
        String r22 = r8;
        List r10 = (List) ZeusTransformUtils.preCheckCast(r4.get(r112), List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L71;
    L72:
        r10 = (List) ZeusTransformUtils.preCheckCast(r4.get(r112.toLowerCase()), List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L75;
    L136:
        String r24 = r2;
        JSONObject r26 = r7;
        r110 = r110;
    L137:
        r9 = r9 + 1;
        r11 = r20;
        r5 = r21;
        r8 = r22;
        r2 = r24;
        r7 = r26;
        goto L67
    L75:
        if (r10.isEmpty() == true) goto L136;
    L78:
        boolean r23 = r110;
        r7.put("cookieMgrList", r10.toString());     // Catch: JSONException -> L212
    L82:
        Iterator r25 = r10.iterator();
        r110 = r23;
    L84:
        if (r25.hasNext() == false) goto L135;
        Iterator r113 = r25;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r25.next(), String.class, "com.obric.memorydata.plugin");
        boolean r210 = r110;
        if (r27.toLowerCase().trim().contains("sessionid=") == false) goto L88;
        r210 = true;
    L88:
        if (r210 == false) goto L90;
    L96:
        boolean r114 = r210;
    L97:
        a(r17, r27, r16);
        if (r15 == false) goto L101;
        String r211 = r2;
        b((String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r4.get(r2), List.class, "com.obric.memorydata.plugin")).get(0), String.class, "com.obric.memorydata.plugin"), r27, r16);
    L100:
        JSONObject r212 = r7;
        boolean r213 = r114;
    L134:
        r25 = r113;
        r2 = r211;
        r110 = r213;
        r7 = r212;
        goto L84
    L101:
        r211 = r2;
        if (com.bytedance.frameworks.baselib.network.a.b.a(r27) == true) goto L100;
        if ((!com.bytedance.common.utility.d.a(r6)) == false) goto L100;
        if (a(r28, r27) == false) goto L100;
        Iterator<String> r3 = r6.iterator();     // Catch: Throwable -> L215
    L113:
        if (r3.hasNext() == false) goto L131;
        r3 = r3;
        String r30 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L215
        if (TextUtils.isEmpty(r30) == true) goto L113;
        if (r28.getHost().endsWith(r30) == true) goto L113;
        String r31 = this.c.matcher(r27).replaceFirst(r30);     // Catch: Throwable -> L214
        if (TextUtils.isEmpty(r31) == true) goto L129;
        boolean r214 = r114;
        JSONObject r215 = r7;
        a(new StringBuilder().append(r28.getScheme()).append("://").append(r30).append("/").toString(), r31, r16);     // Catch: Throwable -> L213
    L130:
        r114 = r214;
        r7 = r215;
    L128:
        r215 = r7;
    L129:
        r215 = r7;
        r214 = r114;
    L131:
        r212 = r7;
        r213 = r114;
        if (Logger.debug() == false) goto L134;
        Logger.v("SSCookieHandler", "receive cookie: " + r17 + " " + r112 + ": " + r27);
        goto L134
    L90:
        if (com.bytedance.frameworks.baselib.network.a.b.c() == false) goto L96;
        if (r27.toLowerCase().trim().contains("store-country-code=") == false) goto L94;
    L95:
        r114 = true;
        goto L97
    L94:
        if (r27.toLowerCase().trim().contains("store-region=") == false) goto L96;
    L135:
        r24 = r2;
        r26 = r7;
        r111 = true;
        goto L137
    L71:
        if (r10.isEmpty() == false) goto L78;
    L138:
        ?? r216 = r7;
        String r217 = r8;
        boolean r218 = r110;
        f.k r32 = f.h();
        if (r16.isEmpty() == true) goto L142;
        if (r32 == null) goto L142;
        r32.a(r16);     // Catch: Throwable -> L216
    L142:
        if (r111 == true) goto L235;
    L144:
        if (r28 == null) goto L207;
        if (r4 == null) goto L207;
        LinkedHashMap r33 = new LinkedHashMap();     // Catch: Throwable -> L201
        if (f2439a == true) goto L150;
    L154:
        Object r34 = Api.KEY_SET_COOKIE;
    L155:
        r33.putAll(r4);     // Catch: Throwable -> L201
        boolean r115 = true;
        b.a().a(r28, (List) ZeusTransformUtils.preCheckCast(r33.get(r34), List.class, "com.obric.memorydata.plugin"), null, true);     // Catch: Throwable -> L201
        if ((!com.bytedance.common.utility.d.a(r6)) == false) goto L196;
        if (r15 == true) goto L196;
        Iterator<String> r35 = r6.iterator();     // Catch: Throwable -> L201
    L160:
        if (r35.hasNext() == false) goto L195;
        String r36 = (String) ZeusTransformUtils.preCheckCast(r35.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
    L192:
        r115 = r19;
        ?? r37 = r216;
    L194:
        r216 = r37;
        r19 = r115;
        goto L160
    L164:
        if (TextUtils.isEmpty(r36) == true) goto L160;
        if (r28.getHost().endsWith(r36) == true) goto L160;
        r37 = List.class;
        List r38 = (List) ZeusTransformUtils.preCheckCast(r4.get(r34), r37, "com.obric.memorydata.plugin");     // Catch: Throwable -> L192
        if (r38 == null) goto L172;
        r115 = r19;
        r37 = r216;
        LinkedList r116 = new LinkedList();     // Catch: Throwable -> L218
        Iterator r39 = r38.iterator();     // Catch: Throwable -> L218
    L177:
        if (r39.hasNext() == false) goto L188;
        String r117 = (String) ZeusTransformUtils.preCheckCast(r39.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L218
        if (com.bytedance.frameworks.baselib.network.a.b.a(r117) == true) goto L177;
        if (a(r28, r117) == false) goto L177;
        String r118 = this.c.matcher(r117).replaceFirst(r36);     // Catch: IllegalArgumentException -> L220 Throwable -> L218
        if (TextUtils.isEmpty(r118) == true) goto L177;
        r116.add(r118);     // Catch: IllegalArgumentException -> L220 Throwable -> L218
        goto L177
    L188:
        r33.put(r34, r116);     // Catch: Throwable -> L218
        b.a().a(URI.create(r28.getScheme() + "://" + r36), (List) ZeusTransformUtils.preCheckCast(r33.get(r34), List.class, "com.obric.memorydata.plugin"), null, true);     // Catch: Throwable -> L219
        goto L194
    L172:
        r115 = r19;
        r37 = r216;
        a(r37, "cookieList is null", r115);     // Catch: Throwable -> L218
        return;
    L195:
        boolean r119 = r19;
        ?? r40 = r216;
    L204:
        String r41 = "last return";
        ?? r42 = r40;
    L205:
        a(r42, r41, r119);
        return;
    L196:
        r119 = r19;
        ?? r43 = r216;
        a(r43, "isInShareCookieList is false", r119);     // Catch: Throwable -> L199
        return;
    L199:
        th = th;
    L203:
        th.printStackTrace();
        r40 = r43;
        goto L204
    L150:
        if (r4.containsKey(r217) == false) goto L154;
        r34 = Api.KEY_SET_COOKIE;
        if (r4.containsKey(r34) == true) goto L155;
        r33.put(r34, (List) ZeusTransformUtils.preCheckCast(r4.get(r217), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L201
    L201:
        th = th;
        r119 = r19;
        r43 = r216;
    L207:
        r119 = r19;
        r42 = r216;
        r41 = "uri responseHeaders or mAppCookieMgr is null";
        goto L205
    L235:
        a(r28.getPath(), r218);     // Catch: Throwable -> L217
        goto L144
    L64:
        r18 = new String[]{Api.KEY_SET_COOKIE};
    L208:
        r42 = r7;
        r119 = r12;
        r41 = "uri responseHeaders or mCookieMgr is null";
        goto L205
    L53:
        if (r4.containsKey("webview-origin-url") == false) goto L55;
        r15 = true;
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L50
    L38:
        if ("http".equalsIgnoreCase(r28.getScheme()) == false) goto L249;
        if (com.bytedance.frameworks.baselib.network.a.a.a() == false) goto L249;
        if (r6 == null) goto L43;
        r6.clear();     // Catch: JSONException -> L211
    L43:
        r7.put("disable_share_insecure_cookie", 1);     // Catch: JSONException -> L211
        goto L249
    L239:
        r14 = r6.toString();     // Catch: JSONException -> L211
        goto L28
    L18:
        if (r4.containsKey(Api.KEY_SET_COOKIE) == false) goto L20;
    L21:
        r12 = true;
        goto L24
    L20:
        if (r4.containsKey("X-SS-Set-Cookie") == false) goto L22;
    L14:
        r6 = null;
        goto L15
    }
}
