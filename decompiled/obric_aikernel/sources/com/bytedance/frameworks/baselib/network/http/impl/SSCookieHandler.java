package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SSCookieHandler extends CookieManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f1619f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f1620g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.webkit.CookieManager f1621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.bytedance.frameworks.baselib.network.http.impl.b f1622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pattern f1623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f1624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<String> f1625e;

    private static final enum ReqCookieSource extends Enum<ReqCookieSource> {
        private static final /* synthetic */ ReqCookieSource[] $VALUES = null;
        public static final ReqCookieSource APP_COOKIE_STORE = null;
        public static final ReqCookieSource BACKUP = null;
        public static final ReqCookieSource MAIN = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_BACKUP = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_MAIN = null;
        public static final ReqCookieSource UNKNOWN = null;

        static {
            ReqCookieSource r10 = new ReqCookieSource("UNKNOWN", 0);
            UNKNOWN = r10;
            ReqCookieSource r11 = new ReqCookieSource("APP_COOKIE_STORE", 1);
            APP_COOKIE_STORE = r11;
            ReqCookieSource r12 = new ReqCookieSource("SHARE_INTERCEPTOR_MAIN", 2);
            SHARE_INTERCEPTOR_MAIN = r12;
            ReqCookieSource r13 = new ReqCookieSource("SHARE_INTERCEPTOR_BACKUP", 3);
            SHARE_INTERCEPTOR_BACKUP = r13;
            ReqCookieSource r14 = new ReqCookieSource("MAIN", 4);
            MAIN = r14;
            ReqCookieSource r15 = new ReqCookieSource("BACKUP", 5);
            BACKUP = r15;
            $VALUES = new ReqCookieSource[]{r10, r11, r12, r13, r14, r15};
        }

        private ReqCookieSource(String r10, int r11) {
            super(r10, r11);
        }

        public static ReqCookieSource valueOf(String r10) {
            return (ReqCookieSource) Enum.valueOf(ReqCookieSource.class, r10);
        }

        public static ReqCookieSource[] values() {
            return (ReqCookieSource[]) $VALUES.clone();
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f1626c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ SSCookieHandler f1627g;

        a(SSCookieHandler r10, Context r11) {
            this.f1627g = r10;
            this.f1626c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            SSCookieHandler.b(this.f1627g, new com.bytedance.frameworks.baselib.network.http.impl.b(new h(this.f1626c), c.f1641a));
        }
    }

    public interface b {
        boolean a();

        void b(String r10, String r11, JSONObject r12);
    }

    static {
    }

    public SSCookieHandler(Context r10, int r11, android.webkit.CookieManager r12, ArrayList<String> r13, b r14) {
        this.f1623c = Pattern.compile("(?<=Domain=)([^;]*)", 2);
        if (k2.b.b() == true) goto L7;
        if (r11 <= 0) goto L6;
        r1.a.b().schedule(new a(this, r10), r11, TimeUnit.SECONDS);
        goto L7
    L6:
        this.f1622b = new com.bytedance.frameworks.baselib.network.http.impl.b(new h(r10), c.f1641a);
    L7:
        this.f1621a = r12;
        this.f1625e = r13;
        this.f1624d = r14;
        if (r14 != null) goto L10;
        return;
    L10:
        if (r14.a() == false) goto L19;
        JSONObject r15 = new JSONObject();
        r15.put(CommonConsts.APM_INNER_EVENT_COST_INIT, "success");     // Catch: JSONException -> L15
    L13:
        this.f1624d.b("TTNET-COOKIE", CommonConsts.APM_INNER_EVENT_COST_INIT, r15);
        return;
    }

    public static /* synthetic */ void a(SSCookieHandler r10, Map r11) {
        r10.j(r11);
    }

    static /* synthetic */ com.bytedance.frameworks.baselib.network.http.impl.b b(SSCookieHandler r10, com.bytedance.frameworks.baselib.network.http.impl.b r11) {
        r10.f1622b = r11;
        return r11;
    }

    private static boolean c(String r10) {
        if (r10.length() >= 2) goto L5;
        return false;
    L5:
        int r11 = 1;
        int r12 = 0;
    L7:
        if (r11 >= r10.length()) goto L14;
        if (r10.charAt(r11) != '.') goto L13;
        r12 = r12 + 1;
        if (r12 >= 2) goto L14;
    L13:
        r11 = r11 + 1;
    L14:
        if (r12 >= 2) goto L16;
        return false;
    L16:
        return true;
    }

    private JSONObject d() {
        b r10 = this.f1624d;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.a() == true) goto L8;
        return null;
    L8:
        return new JSONObject();
    }

    private void e(String r10, boolean r11) {
        if (r11 == false) goto L9;
        android.webkit.CookieManager.getInstance().flush();
        if (Logger.debug() == false) goto L27;
        Logger.d("SSCookieHandler", "Force flush cookie: " + r10);
        return;
    L27:
        return;
    L9:
        if (Build.VERSION.SDK_INT < 21) goto L28;
        ArrayList<String> r12 = this.f1625e;
        if (r12 != null) goto L13;
        return;
    L13:
        if (r12.isEmpty() == true) goto L31;
        Iterator<String> r13 = this.f1625e.iterator();
    L17:
        if (r13.hasNext() == false) goto L32;
        if (r10.equals(r13.next()) == false) goto L17;
        android.webkit.CookieManager.getInstance().flush();
        if (Logger.debug() == false) goto L30;
        Logger.d("SSCookieHandler", "Path match flush cookie: " + r10);
        return;
    L30:
        return;
    L32:
        return;
    L31:
        return;
    }

    private Map<String, List<String>> f(List<String> r10, Map<String, List<String>> r11) {
        Map<String, List<String>> r12 = Collections.emptyMap();
        if (f1619f == false) goto L18;
        LinkedHashMap r13 = new LinkedHashMap();
        if (r11 == null) goto L10;
        List<String> r14 = h(r11, "Cookie");
        if (r14 == null) goto L10;
        if (r14.isEmpty() == true) goto L10;
    L12:
        if (r11 == null) goto L17;
        List<String> r15 = h(r11, CronetHttpURLConnection.SS_COOKIE);
        if (r15 == null) goto L17;
        if (r15.isEmpty() == true) goto L17;
        return r13;
    L17:
        r13.put(CronetHttpURLConnection.SS_COOKIE, r10);
        return r13;
    L10:
        r13.put("Cookie", r10);
        goto L12
    L18:
        if (r11 == null) goto L24;
        List<String> r16 = h(r11, "Cookie");
        if (r16 == null) goto L24;
        if (r16.isEmpty() == true) goto L24;
        return r12;
    L24:
        return Collections.singletonMap("Cookie", r10);
    }

    private static Map<String, List<String>> g(boolean r10, Map<String, List<String>> r11, ReqCookieSource r12) {
        if (r10 == true) goto L4;
        return r11;
    L4:
        if (r11 != null) goto L7;
        return null;
    L7:
        LinkedHashMap r13 = new LinkedHashMap(r11);
        r13.put("x-tt-get-cookie-source", Collections.singletonList(String.valueOf(r12.ordinal())));
        return r13;
    }

    private List<String> h(Map<String, List<String>> r10, String r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        List<String> r12 = r10.get(r11);
        if (r12 == null) goto L13;
        if (r12.isEmpty() == true) goto L13;
        return r12;
    L13:
        return r10.get(r11.toLowerCase());
    L18:
        return null;
    }

    private boolean i(URI r10, String r11) {
        if (r10 != null) goto L5;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        String r12 = r10.getHost().toLowerCase();     // Catch: Throwable -> L16
        String r13 = "";
        Matcher r14 = this.f1623c.matcher(r11);     // Catch: Throwable -> L16
        if (r14.find() == false) goto L11;
        r13 = r14.group().toLowerCase();     // Catch: Throwable -> L16
    L11:
        if (TextUtils.isEmpty(r13) == true) goto L21;
        if (r12.endsWith(r13) == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    private /* synthetic */ void j(Map r10) {
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        this.f1622b.d((URI) r12.getKey(), (List) r12.getValue());     // Catch: Throwable -> L9
        goto L4
    }

    private static void k(JSONObject r10, String r11, String r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L15;
        r10.put(r11, r12);     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }

    private void l(String r10, String r11, Set<String> r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L17;
        r12.add(r10);
        this.f1621a.setCookie(r10, r11);
        o2.f.k r13 = o2.f.m();     // Catch: Throwable -> L12
        if (r13 == null) goto L16;
        r13.b(r10, r11);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L18:
        return;
    }

    private void m(String r10, List<String> r11, Set<String> r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.collection.a.a(r11) == true) goto L36;
        r12.add(r10);
        boolean r13 = false;
        if (k2.b.c() == true) goto L28;
    L13:
        o2.f.k r14 = o2.f.m();
        if (r13 == false) goto L17;
        if (r14 != null) goto L17;
        return;
    L17:
        Iterator<String> r15 = r11.iterator();
    L19:
        if (r15.hasNext() == false) goto L37;
        String r16 = r15.next();
        if (r13 == true) goto L23;
        this.f1621a.setCookie(r10, r16);
    L23:
        if (r14 == null) goto L19;
        r14.b(r10, r16);     // Catch: Throwable -> L27
        goto L19
    L37:
        return;
    L28:
        Method r17 = this.f1621a.getClass().getDeclaredMethod("setCookieList", new Class[]{String.class, List.class});     // Catch: Throwable -> L11
        r17.setAccessible(true);     // Catch: Throwable -> L11
        r13 = ((Boolean) r17.invoke(this.f1621a, new Object[]{r10, r11})).booleanValue();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Logger.d("SSCookieHandler", "Batch save cookie failed:" + th);
        goto L13
    }

    private void n(URI r17, Map<String, List<String>> r18) {
        if (r17 == null) goto L120;
        if (r18 != null) goto L6;
        return;
    L6:
        if (r18.isEmpty() == true) goto L163;
        List<String> r10 = h(r18, Api.KEY_SET_COOKIE);
        if (f1619f == false) goto L14;
        if (com.bytedance.common.utility.c.a(r10) == false) goto L14;
        r10 = h(r18, "X-SS-Set-Cookie");
    L14:
        if (com.bytedance.common.utility.c.a(r10) == false) goto L16;
        return;
    L16:
        o2.f.j r11 = o2.f.l();
        String r12 = null;
        if (r11 == null) goto L19;
        List<String> r13 = r11.g(r17.getHost());
    L20:
        JSONObject r14 = d();
        if (r14 == null) goto L28;
        k(r14, "version", "v2");
        k(r14, "url", r17.toString());
        if (r13 != null) goto L25;
        String r15 = "";
    L26:
        k(r14, "shareHostList", r15);
        k(r14, "responseHeaders", r18.toString());
        k(r14, "setCookieList", r10.toString());
        goto L28
    L25:
        r15 = r13.toString();
    L28:
        if (k2.a.c() == true) goto L30;
    L134:
        o2.f.InterfaceC0255f r16 = o2.f.h();     // Catch: Throwable -> L121
        if (r16 == null) goto L38;
        r16.b(r17, r18);     // Catch: Throwable -> L121
    L38:
        if (this.f1621a != null) goto L45;
        if (r14 == null) goto L41;
        boolean r19 = true;
    L42:
        String r20 = "mCookieMgr is null";
    L43:
        o(r14, r20, r19);
        return;
    L41:
        r19 = false;
        goto L42
    L45:
        HashSet r21 = new HashSet();
        List<String> r22 = r18.get("webview-origin-url");
        if (com.bytedance.common.utility.c.a(r22) == true) goto L49;
        r12 = r22.get(0);
    L49:
        if (TextUtils.isEmpty(r12) == false) goto L126;
    L51:
        final ConcurrentHashMap r23 = new ConcurrentHashMap();
        r23.put(r17, r10);
        Iterator<String> r24 = r10.iterator();
        boolean r110 = false;
    L53:
        if (r24.hasNext() == false) goto L97;
        String r111 = r24.next();
        if (Logger.debug() == false) goto L58;
        Logger.v("SSCookieHandler", "receive cookie: " + r17 + ", set-cookie:" + r111);
    L58:
        if (TextUtils.isEmpty(r111) == true) goto L53;
        String r112 = r111.toLowerCase().trim();
        if (r112.contains("sessionid=") == false) goto L63;
        r110 = true;
    L63:
        if (r110 == true) goto L72;
        if (k2.b.f() == false) goto L72;
        if (r112.contains("store-country-code=") == false) goto L69;
    L70:
        r110 = true;
        goto L72
    L69:
        if (r112.contains("store-region=") == true) goto L70;
    L72:
        if (TextUtils.isEmpty(r12) == false) goto L53;
        if (com.bytedance.common.utility.c.a(r13) == true) goto L53;
        if (i(r17, r111) == false) goto L53;
        Iterator<String> r113 = r13.iterator();
    L82:
        if (r113.hasNext() == false) goto L53;
        String r114 = r113.next();
        if (TextUtils.isEmpty(r114) == true) goto L82;
        if (r17.getHost().endsWith(r114) == true) goto L82;
        String r115 = this.f1623c.matcher(r111).replaceFirst(r114);     // Catch: Throwable -> L123
        if (TextUtils.isEmpty(r115) == true) goto L82;
        URI r25 = URI.create(r17.getScheme() + "://" + r114 + "/");     // Catch: Throwable -> L123
        List r116 = (List) r23.get(r25);     // Catch: Throwable -> L123
        if (r116 == null) goto L94;
        r116.add(r115);     // Catch: Throwable -> L123
        goto L82
    L94:
        ArrayList r117 = new ArrayList();     // Catch: Throwable -> L123
        r117.add(r115);     // Catch: Throwable -> L123
        r23.put(r25, r117);     // Catch: Throwable -> L123
        goto L82
    L97:
        Iterator r26 = r23.entrySet().iterator();
    L99:
        if (r26.hasNext() == false) goto L101;
        Map.Entry r27 = (Map.Entry) r26.next();
        m(((URI) r27.getKey()).toString(), (List) r27.getValue(), r21);
        goto L99
    L101:
        o2.f.k r28 = o2.f.m();
        if (r21.isEmpty() == true) goto L132;
        if (r28 == null) goto L132;
        r28.a(r21);     // Catch: Throwable -> L124
    L132:
        e(r17.getPath(), r110);     // Catch: Throwable -> L125
    L107:
        if (this.f1622b != null) goto L112;
        if (r14 == null) goto L110;
        r19 = true;
    L111:
        r20 = "mAppCookieMgr is null";
        goto L43
    L110:
        r19 = false;
        goto L111
    L112:
        Runnable r29 = new j(this, r23);
        if (k2.b.a() == false) goto L115;
        r1.a.a().submit(r29);
    L116:
        if (r14 == null) goto L118;
        r19 = true;
    L119:
        r20 = "last return";
        goto L43
    L118:
        r19 = false;
        goto L119
    L115:
        r29.run();
        goto L116
    L126:
        q(r12, r10, r21);     // Catch: Throwable -> L122
        goto L51
    L30:
        if ("http".equalsIgnoreCase(r17.getScheme()) == false) goto L134;
        if (r13 == null) goto L33;
        r13.clear();
    L33:
        k(r14, "disable_share_insecure_cookie", NetConst.ENCRYPT_VERISON_CODE);
        goto L134
    L19:
        r13 = null;
        goto L20
    L163:
        return;
    }

    private void o(JSONObject r10, String r11, boolean r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f1624d == null) goto L13;
        if (r12 == false) goto L14;
        r10.put("return", r11);     // Catch: JSONException -> L10
    L8:
        this.f1624d.b("TTNET-COOKIE", "put", r10);
        return;
    L14:
        return;
    }

    private String p(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L18;
        return null;
    L18:
        Matcher r12 = this.f1623c.matcher(r11);     // Catch: IllegalArgumentException -> L17
        if (r12.find() == false) goto L8;
        String r13 = r12.group().toLowerCase();     // Catch: IllegalArgumentException -> L17
    L10:
        if (TextUtils.isEmpty(r13) == false) goto L13;
        return r11;
    L13:
        if (c(r13) == false) goto L20;
        return r12.replaceFirst(r10);
    L20:
        return null;
    L8:
        r13 = null;
    L21:
        return null;
    }

    private void q(String r10, List<String> r11, Set<String> r12) {
        ArrayList r13 = new ArrayList();
        Iterator<String> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        String r15 = p(r10, r14.next());
        if (TextUtils.isEmpty(r15) == true) goto L4;
        r13.add(r15);
        goto L4
    L10:
        if (r13.isEmpty() == false) goto L13;
        return;
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d("SSCookieHandler", "Sync cookies list for WebView request, original url: " + r10);
    L15:
        m(r10, r13, r12);
    }

    private void r(String r10, String r11, Set<String> r12) {
        if (this.f1621a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        String r13 = p(r10, r11);
        if (TextUtils.isEmpty(r13) == false) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("SSCookieHandler", " Sync cookies for WebView request, original url: " + r10);
    L13:
        l(r10, r13, r12);
        return;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r10, Map<String, List<String>> r11) {
        android.webkit.CookieManager r12 = null;
        boolean r13 = false;
        String r14 = r10.toString();     // Catch: Throwable -> L33
        if (r11 != null) goto L90;
    L19:
        o2.f.InterfaceC0255f r15 = o2.f.h();     // Catch: Throwable -> L31
        if (r15 == null) goto L36;
        Map<String, List<String>> r16 = r15.a(r10, r11);     // Catch: Throwable -> L31
        if (r16 == null) goto L36;
        if (r16.isEmpty() == true) goto L36;
        if (r16.containsKey("Cookie") == true) goto L30;
        if (r16.containsKey(CronetHttpURLConnection.SS_COOKIE) == false) goto L36;
    L30:
        return g(r13, r16, ReqCookieSource.APP_COOKIE_STORE);
    L36:
        if (r10 == null) goto L85;
        if (this.f1621a == null) goto L85;
        o2.f.j r17 = o2.f.l();     // Catch: Throwable -> L53
        if (r17 == null) goto L56;
        if (f1620g == true) goto L46;
        r12 = this.f1621a;     // Catch: Throwable -> L53
    L46:
        List<String> r18 = r17.f(r12, this.f1622b, r10);     // Catch: Throwable -> L53
        if (com.bytedance.common.utility.c.a(r18) == true) goto L56;
        ReqCookieSource r19 = ReqCookieSource.SHARE_INTERCEPTOR_MAIN;     // Catch: Throwable -> L53
        if (r18.remove("x-tt-cookie-backup-source=1") == false) goto L51;
        r19 = ReqCookieSource.SHARE_INTERCEPTOR_BACKUP;     // Catch: Throwable -> L53
    L51:
        return g(r13, f(r18, r11), r19);
    L56:
        if (f1620g == true) goto L67;
        String r20 = this.f1621a.getCookie(r14);     // Catch: Exception -> L64
        if (TextUtils.isEmpty(r20) == true) goto L67;
        if (Logger.debug() == false) goto L62;
        Logger.v("SSCookieHandler", "send cookie: " + r14 + " " + r20);     // Catch: Exception -> L64
    L62:
        return g(r13, f(Collections.singletonList(r20), r11), ReqCookieSource.MAIN);
    L64:
        e = move-exception;
        e.printStackTrace();
    L67:
        if (this.f1622b == null) goto L69;
        com.bytedance.frameworks.baselib.network.http.impl.b r21 = this.f1622b;     // Catch: Throwable -> L80
        if (r11 != null) goto L73;
        Map<String, List<String>> r22 = new LinkedHashMap();     // Catch: Throwable -> L80
    L74:
        Map<String, List<String>> r23 = r21.get(r10, r22);     // Catch: Throwable -> L80
        if (r23 == null) goto L83;
        if (r23.isEmpty() == true) goto L83;
        return g(r13, f(r23.get("Cookie"), r11), ReqCookieSource.BACKUP);
    L83:
        return Collections.emptyMap();
    L73:
        r22 = r11;
    L80:
        th = move-exception;
        th.printStackTrace();
        goto L83
    L69:
        return Collections.emptyMap();
    L53:
        th = move-exception;
        th.printStackTrace();
    L85:
        return Collections.emptyMap();
    L90:
        r13 = r11.containsKey("x-tt-get-cookie-source");     // Catch: Throwable -> L31
        List<String> r24 = h(r11, "X-SS-No-Cookie");     // Catch: Throwable -> L31
        if (r24 == null) goto L19;
        Iterator<String> r25 = r24.iterator();     // Catch: Throwable -> L31
    L9:
        if (r25.hasNext() == false) goto L19;
        String r26 = r25.next();     // Catch: Throwable -> L31
        if (r26 == null) goto L9;
        if (Boolean.parseBoolean(r26) == false) goto L9;
        if (Logger.debug() == false) goto L18;
        Logger.v("SSCookieHandler", "X-SS-No-Cookie " + r14);     // Catch: Throwable -> L31
    L18:
        return Collections.emptyMap();
    L31:
        th = th;
    L35:
        th.printStackTrace();
    L33:
        th = th;
        r14 = null;
        goto L35
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r28, Map<String, List<String>> r29) {
        if (k2.b.d() == false) goto L6;
        n(r28, r29);
        return;
    L6:
        List<String> r10 = null;
        o2.f.j r11 = o2.f.l();
        if (r11 == null) goto L10;
        if (r28 == null) goto L10;
        r10 = r11.g(r28.getHost());
    L10:
        List<String> r12 = r10;
        JSONObject r13 = new JSONObject();
        String r14 = "X-SS-Set-Cookie";
        if (r29 != null) goto L13;
    L17:
        boolean r15 = false;
    L19:
        String r16 = "";
        if (r12 != null) goto L205;
        String r17 = "";
    L23:
        r13.put("shareHostList", r17);     // Catch: JSONException -> L195
        if (r15 == false) goto L27;
        r13.put("responseHeaders", r29.toString());     // Catch: JSONException -> L195
    L27:
        if (r28 == null) goto L30;
        r16 = r28.toString();     // Catch: JSONException -> L195
    L30:
        r13.put("url", r16);     // Catch: JSONException -> L195
        if (r28 != null) goto L33;
    L215:
        o2.f.InterfaceC0255f r18 = o2.f.h();     // Catch: Throwable -> L43
        if (r18 == null) goto L45;
        r18.b(r28, r29);     // Catch: Throwable -> L43
    L45:
        String r19 = "webview-origin-url";
        if (r29 != null) goto L48;
    L50:
        boolean r110 = false;
    L52:
        if (f1620g == true) goto L145;
        if (r28 == null) goto L142;
        if (r29 == null) goto L142;
        if (this.f1621a == null) goto L142;
        HashSet r111 = new HashSet();
        String r112 = r28.toString();
        if (f1619f == false) goto L61;
        String[] r113 = {"X-SS-Set-Cookie", Api.KEY_SET_COOKIE};
    L62:
        int r20 = r113.length;
        int r21 = 0;
        boolean r22 = false;
        boolean r114 = false;
    L63:
        if (r21 >= r20) goto L135;
        int r23 = r20;
        String r24 = r113[r21];
        List<String> r25 = r29.get(r24);
        if (r25 != null) goto L67;
    L70:
        String[] r26 = r113;
        List<String> r115 = r29.get(r24.toLowerCase());
        if (r115 != null) goto L73;
    L133:
        String r116 = r19;
    L134:
        r21 = r21 + 1;
        r19 = r116;
        r20 = r23;
        r113 = r26;
        r14 = r14;
        r15 = r15;
        goto L63
    L73:
        if (r115.isEmpty() == true) goto L133;
    L225:
        r13.put("cookieMgrList", r115.toString());     // Catch: JSONException -> L196
    L81:
        Iterator<String> r27 = r115.iterator();
    L83:
        if (r27.hasNext() == false) goto L132;
        String r117 = r27.next();
        Iterator<String> r118 = r27;
        if (r117.toLowerCase().trim().contains("sessionid=") == false) goto L87;
        r22 = true;
    L87:
        if (r22 == false) goto L89;
    L95:
        l(r112, r117, r111);
        if (r110 == false) goto L217;
        r(r29.get(r19).get(0), r117, r111);
    L98:
        String r119 = r19;
        boolean r210 = r22;
    L131:
        r19 = r119;
        r27 = r118;
        r22 = r210;
        goto L83
    L217:
        if ((!com.bytedance.common.utility.c.a(r12)) == false) goto L98;
        if (i(r28, r117) == false) goto L98;
        Iterator<String> r30 = r12.iterator();     // Catch: Throwable -> L200
    L108:
        if (r30.hasNext() == false) goto L128;
        String r120 = r30.next();     // Catch: Throwable -> L200
        if (TextUtils.isEmpty(r120) == true) goto L108;
        String r121 = r19;
        if (r28.getHost().endsWith(r120) == false) goto L117;
        r19 = r121;
        goto L108
    L117:
        String r31 = this.f1623c.matcher(r117).replaceFirst(r120);     // Catch: Throwable -> L199
        if (TextUtils.isEmpty(r31) == true) goto L124;
        Iterator<String> r211 = r30;
        StringBuilder r32 = new StringBuilder();     // Catch: Throwable -> L198
        boolean r212 = r22;
        r32.append(r28.getScheme());     // Catch: Throwable -> L197
        r32.append("://");     // Catch: Throwable -> L197
        r32.append(r120);     // Catch: Throwable -> L197
        r32.append("/");     // Catch: Throwable -> L197
        l(r32.toString(), r31, r111);     // Catch: Throwable -> L197
    L127:
        r19 = r121;
        r30 = r211;
        r22 = r212;
    L125:
        r212 = r22;
    L124:
        r211 = r30;
    L126:
        r121 = r19;
    L128:
        r119 = r19;
        r210 = r22;
        if (Logger.debug() == false) goto L131;
        Logger.v("SSCookieHandler", "receive cookie: " + r112 + " " + r24 + ": " + r117);
        goto L131
    L89:
        if (k2.b.f() == false) goto L95;
        if (r117.toLowerCase().trim().contains("store-country-code=") == false) goto L93;
    L94:
        r22 = true;
        goto L95
    L93:
        if (r117.toLowerCase().trim().contains("store-region=") == false) goto L95;
    L132:
        r116 = r19;
        r114 = true;
        goto L134
    L67:
        if (r25.isEmpty() == true) goto L70;
        r26 = r113;
        r115 = r25;
        goto L225
    L135:
        String r213 = r14;
        boolean r214 = r15;
        o2.f.k r33 = o2.f.m();
        if (r111.isEmpty() == true) goto L139;
        if (r33 == null) goto L139;
        r33.a(r111);     // Catch: Throwable -> L201
    L139:
        if (r114 == true) goto L228;
    L141:
        boolean r34 = r214;
    L146:
        if (r28 == null) goto L194;
        if (r29 == null) goto L194;
        if (this.f1622b == null) goto L194;
        LinkedHashMap r35 = new LinkedHashMap();     // Catch: Throwable -> L191
        if (f1619f == false) goto L158;
        String r36 = r213;
        if (r29.containsKey(r36) == false) goto L158;
        Object r37 = Api.KEY_SET_COOKIE;
        if (r29.containsKey(r37) == true) goto L159;
        r35.put(r37, r29.get(r36));     // Catch: Throwable -> L191
    L159:
        r35.putAll(r29);     // Catch: Throwable -> L191
        this.f1622b.put(r28, r35);     // Catch: Throwable -> L191
        if ((!com.bytedance.common.utility.c.a(r12)) == false) goto L189;
        if (r110 == true) goto L189;
        Iterator<String> r38 = r12.iterator();     // Catch: Throwable -> L191
    L165:
        if (r38.hasNext() == false) goto L193;
        String r39 = r38.next();     // Catch: Throwable -> L191
        if (TextUtils.isEmpty(r39) == true) goto L165;
        if (r28.getHost().endsWith(r39) == true) goto L165;
        List<String> r40 = r29.get(r37);     // Catch: Throwable -> L203
        if (r40 != null) goto L177;
        o(r13, "cookieList is null", r34);     // Catch: Throwable -> L203
        return;
    L177:
        LinkedList r122 = new LinkedList();     // Catch: Throwable -> L203
        Iterator<String> r41 = r40.iterator();     // Catch: Throwable -> L203
    L179:
        if (r41.hasNext() == false) goto L187;
        String r123 = r41.next();     // Catch: Throwable -> L203
        if (i(r28, r123) == false) goto L179;
        String r124 = this.f1623c.matcher(r123).replaceFirst(r39);     // Catch: Throwable -> L203 IllegalArgumentException -> L204
        if (TextUtils.isEmpty(r124) == true) goto L179;
        r122.add(r124);     // Catch: Throwable -> L203 IllegalArgumentException -> L204
        goto L179
    L187:
        r35.put(r37, r122);     // Catch: Throwable -> L203
        this.f1622b.put(URI.create(r28.getScheme() + "://" + r39), r35);     // Catch: Throwable -> L203
    L193:
        String r42 = "last return";
    L143:
        o(r13, r42, r34);
        return;
    L189:
        o(r13, "isInShareCookieList is false", r34);     // Catch: Throwable -> L191
        return;
    L158:
        r37 = r8;
    L191:
        th = move-exception;
        th.printStackTrace();
    L194:
        r42 = "uri responseHeaders or mAppCookieMgr is null";
        goto L143
    L228:
        e(r28.getPath(), r22);     // Catch: Throwable -> L202
        goto L141
    L61:
        r113 = new String[]{Api.KEY_SET_COOKIE};
    L142:
        r42 = "uri responseHeaders or mCookieMgr is null";
        r34 = r15;
        goto L143
    L145:
        r213 = "X-SS-Set-Cookie";
        r34 = r15;
        goto L146
    L48:
        if (r29.containsKey("webview-origin-url") == false) goto L50;
        r110 = true;
    L43:
        th = move-exception;
        th.printStackTrace();
        goto L45
    L33:
        if ("http".equalsIgnoreCase(r28.getScheme()) == false) goto L215;
        if (k2.a.c() == false) goto L215;
        if (r12 == null) goto L38;
        r12.clear();     // Catch: JSONException -> L195
    L38:
        r13.put("disable_share_insecure_cookie", 1);     // Catch: JSONException -> L195
        goto L215
    L205:
        r17 = r12.toString();     // Catch: JSONException -> L195
        goto L23
    L13:
        if (r29.containsKey(Api.KEY_SET_COOKIE) == false) goto L15;
    L16:
        r15 = true;
        goto L19
    L15:
        if (r29.containsKey("X-SS-Set-Cookie") == false) goto L17;
        goto L16
    }
}
