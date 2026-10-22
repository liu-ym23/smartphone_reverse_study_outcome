package c7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final android.webkit.CookieManager f3399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c7.a f3400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pattern f3401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f3402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<String> f3403e;

    public interface a {
    }

    public g(Context r8, int r10, android.webkit.CookieManager r11, ArrayList r12, TTNetInit.e r13) {
        this.f3401c = Pattern.compile("(?<=Domain=)([^;]*)", 2);
        if (r10 <= 0) goto L5;
        s5.a.f12024b.schedule(new f(this, r8), r10, TimeUnit.SECONDS);
    L6:
        this.f3399a = r11;
        this.f3403e = r12;
        this.f3402d = r13;
        JSONObject r14 = new JSONObject();
        r14.put("init", "success");     // Catch: JSONException -> L9
    L11:
        a r15 = this.f3402d;
        if (r15 == null) goto L19;
        TTNetInit.e r16 = (TTNetInit.e) r15;
        if (TTNetInit.cookieLogReportEnabled() == false) goto L20;
        TTNetInit.getTTNetDepend().mobOnEvent(r16.f4071a, "TTNET-COOKIE", "init", r14);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        this.f3400b = new c7.a(new e(r8));
        goto L6
    }

    public static Map b(List r8, Map r10) {
        Map r11 = Collections.emptyMap();
        if (r10 == null) goto L9;
        List r12 = c("Cookie", r10);
        if (r12 == null) goto L9;
        if (r12.isEmpty() == true) goto L9;
        return r11;
    L9:
        return Collections.singletonMap("Cookie", r8);
    }

    public static List c(String r8, Map r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r8) == true) goto L15;
        List r11 = (List) r10.get(r8);
        if (r11 == null) goto L11;
        if (r11.isEmpty() == true) goto L11;
        return r11;
    L11:
        return (List) r10.get(r8.toLowerCase());
    L15:
        return null;
    }

    public final void a(String r8, boolean r10) {
        if (r10 == false) goto L6;
        android.webkit.CookieManager.getInstance().flush();
        Logger.d("SSCookieHandler", "Force flush cookie: " + r8);
        return;
    L6:
        ArrayList<String> r11 = this.f3403e;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.isEmpty() == true) goto L22;
        Iterator<String> r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L23;
        if (r8.equals(r12.next()) == false) goto L13;
        android.webkit.CookieManager.getInstance().flush();
        Logger.d("SSCookieHandler", "Path match flush cookie: ".concat(r8));
        return;
    L23:
        return;
    }

    public final boolean d(URI r8, String r10) {
        if (r8 != null) goto L5;
    L18:
        return false;
    L5:
        if (r5.f.b(r10) == true) goto L18;
        String r11 = r8.getHost().toLowerCase();     // Catch: Throwable -> L16
        String r12 = "";
        Matcher r13 = this.f3401c.matcher(r10);     // Catch: Throwable -> L16
        if (r13.find() == false) goto L11;
        r12 = r13.group().toLowerCase();     // Catch: Throwable -> L16
    L11:
        if (TextUtils.isEmpty(r12) == true) goto L21;
        if (r11.endsWith(r12) == false) goto L22;
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

    public final void e(JSONObject r8, String r10, boolean r11) {
        a r12 = this.f3402d;
        if (r12 == null) goto L13;
        if (r11 == false) goto L14;
        r8.put(QesdkUtils.TAGS.JSON_TAG_RETURN, r10);     // Catch: JSONException -> L10
    L6:
        TTNetInit.e r13 = (TTNetInit.e) r12;
        if (TTNetInit.cookieLogReportEnabled() == false) goto L15;
        TTNetInit.getTTNetDepend().mobOnEvent(r13.f4071a, "TTNET-COOKIE", "put", r8);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public final Map<String, List<String>> get(URI r8, Map<String, List<String>> r10) {
        String r11 = r8.toString();     // Catch: Throwable -> L23
        if (r10 != null) goto L71;
    L19:
        w6.e.d r12 = w6.e.f13020a;     // Catch: Throwable -> L21
    L26:
        if (r8 == null) goto L68;
        android.webkit.CookieManager r13 = this.f3399a;
        if (r13 == null) goto L68;
        w6.e.InterfaceC0187e r14 = w6.e.f13028i;     // Catch: Throwable -> L36
        if (r14 == null) goto L69;
        List<String> r15 = r14.a(r13, this.f3400b, r8);     // Catch: Throwable -> L36
        if (l6.a.g0(r15) == true) goto L69;
        return b(r15, r10);
    L69:
        String r16 = this.f3399a.getCookie(r11);     // Catch: Exception -> L47
        if (r16 == null) goto L50;
        if (r16.length() <= 0) goto L50;
        if (Logger.debug() == false) goto L45;
        Logger.v("SSCookieHandler", "send cookie: " + r11 + " " + r16);     // Catch: Exception -> L47
    L45:
        return b(Collections.singletonList(r16), r10);
    L50:
        if (this.f3400b == null) goto L52;
        c7.a r17 = this.f3400b;     // Catch: Throwable -> L63
        if (r10 != null) goto L56;
        Map<String, List<String>> r18 = new LinkedHashMap();     // Catch: Throwable -> L63
    L57:
        Map<String, List<String>> r19 = r17.get(r8, r18);     // Catch: Throwable -> L63
        if (r19 == null) goto L66;
        if (r19.isEmpty() == true) goto L66;
        return b(r19.get("Cookie"), r10);
    L66:
        return Collections.emptyMap();
    L56:
        r18 = r10;
    L63:
        th = move-exception;
        th.printStackTrace();
        goto L66
    L52:
        return Collections.emptyMap();
    L47:
        e = move-exception;
        e.printStackTrace();
    L36:
        th = move-exception;
        th.printStackTrace();
    L68:
        return Collections.emptyMap();
    L71:
        List r20 = c("X-SS-No-Cookie", r10);     // Catch: Throwable -> L21
        if (r20 == null) goto L19;
        Iterator r21 = r20.iterator();     // Catch: Throwable -> L21
    L9:
        if (r21.hasNext() == false) goto L19;
        String r22 = (String) r21.next();     // Catch: Throwable -> L21
        if (r22 == null) goto L9;
        if (Boolean.parseBoolean(r22) == false) goto L9;
        if (Logger.debug() == false) goto L18;
        Logger.v("SSCookieHandler", "X-SS-No-Cookie " + r11);     // Catch: Throwable -> L21
    L18:
        return Collections.emptyMap();
    L21:
        th = th;
    L25:
        th.printStackTrace();
    L23:
        th = th;
        r11 = null;
        goto L25
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public final void put(URI r20, Map<String, List<String>> r21) {
        w6.e.InterfaceC0187e r8 = w6.e.f13028i;
        if (r8 == null) goto L5;
        List<String> r10 = r8.b(r20.getHost());
    L6:
        List<String> r11 = r10;
        JSONObject r12 = new JSONObject();
        int r13 = 0;
        if (r21 != null) goto L9;
    L11:
        boolean r14 = false;
    L13:
        String r15 = "";
        if (r11 != null) goto L146;
        String r16 = "";
    L17:
        r12.put("shareHostList", r16);     // Catch: JSONException -> L122
        if (r14 == false) goto L21;
        r12.put("responseHeaders", r21.toString());     // Catch: JSONException -> L122
    L21:
        if (r20 == null) goto L24;
        r15 = r20.toString();     // Catch: JSONException -> L122
    L24:
        r12.put(WsConstants.KEY_CONNECTION_URL, r15);     // Catch: JSONException -> L122
    L129:
        w6.e.d r17 = w6.e.f13020a;     // Catch: Throwable -> L27
    L29:
        if (r20 == null) goto L119;
        if (r21 == null) goto L119;
        if (this.f3399a == null) goto L119;
        String r18 = r20.toString();
        String[] r19 = {"Set-Cookie"};
        int r110 = r19.length;
        boolean r111 = false;
    L35:
        if (r13 >= r110) goto L131;
        String r112 = r19[r13];
        List<String> r113 = r21.get(r112);
        if (r113 != null) goto L39;
    L40:
        r113 = r21.get(r112.toLowerCase());
        if (r113 == null) goto L82;
        if (r113.isEmpty() == true) goto L82;
    L139:
        r12.put("cookieMgrList", r113.toString());     // Catch: JSONException -> L123
    L46:
        Iterator<String> r114 = r113.iterator();
    L48:
        if (r114.hasNext() == false) goto L82;
        String r115 = r114.next();
        String[] r116 = r19;
        if (r115.toLowerCase().trim().contains("sessionid=") == false) goto L52;
        r111 = true;
    L52:
        this.f3399a.setCookie(r18, r115);
        if ((!l6.a.g0(r11)) == true) goto L56;
        int r117 = r110;
    L81:
        r19 = r116;
        r110 = r117;
        goto L48
    L56:
        Iterator<String> r22 = r11.iterator();     // Catch: Throwable -> L126
    L58:
        if (r22.hasNext() == false) goto L78;
        String r118 = r22.next();     // Catch: Throwable -> L126
        if (r5.f.b(r118) == true) goto L58;
        Iterator<String> r119 = r22;
        if (r20.getHost().endsWith(r118) == true) goto L69;
        if (d(r20, r115) == false) goto L69;
        String r23 = this.f3401c.matcher(r115).replaceFirst(r118);     // Catch: Throwable -> L125
        if (r5.f.b(r23) == true) goto L76;
        int r120 = r110;
        this.f3399a.setCookie(r118, r23);     // Catch: Throwable -> L124
    L77:
        r22 = r119;
        r110 = r120;
    L69:
        r22 = r119;
    L76:
        r120 = r110;
    L75:
        r119 = r22;
    L78:
        r117 = r110;
        if (Logger.debug() == false) goto L81;
        StringBuilder r24 = defpackage.b.i("receive cookie: ", r18, " ", r112, ": ");
        r24.append(r115);
        Logger.v("SSCookieHandler", r24.toString());
    L82:
        r13 = r13 + 1;
        r19 = r19;
        r110 = r110;
        goto L35
    L39:
        if (r113.isEmpty() == false) goto L139;
    L131:
        a(r20.getPath(), r111);     // Catch: Throwable -> L127
    L85:
        if (this.f3400b != null) goto L143;
        String r25 = "mAppCookieMgr is null";
    L120:
        e(r12, r25, r14);
        return;
    L143:
        LinkedHashMap r26 = new LinkedHashMap();     // Catch: Throwable -> L116
        r26.putAll(r21);     // Catch: Throwable -> L116
        this.f3400b.put(r20, r26);     // Catch: Throwable -> L116
        if ((!l6.a.g0(r11)) == true) goto L91;
        e(r12, "isInShareCookieList is false", r14);     // Catch: Throwable -> L116
        return;
    L91:
        Iterator<String> r27 = r11.iterator();     // Catch: Throwable -> L116
    L93:
        if (r27.hasNext() == false) goto L118;
        String r28 = r27.next();     // Catch: Throwable -> L116
        if (r5.f.b(r28) == true) goto L93;
        if (r20.getHost().endsWith(r28) == true) goto L93;
        List<String> r29 = r21.get("Set-Cookie");     // Catch: Throwable -> L128
        if (r29 != null) goto L105;
        e(r12, "cookieList is null", r14);     // Catch: Throwable -> L128
        return;
    L105:
        LinkedList r121 = new LinkedList();     // Catch: Throwable -> L128
        Iterator<String> r30 = r29.iterator();     // Catch: Throwable -> L128
    L107:
        if (r30.hasNext() == false) goto L114;
        String r122 = r30.next();     // Catch: Throwable -> L128
        if (d(r20, r122) == false) goto L107;
        String r123 = this.f3401c.matcher(r122).replaceFirst(r28);     // Catch: Throwable -> L128
        if (r5.f.b(r123) == true) goto L107;
        r121.add(r123);     // Catch: Throwable -> L128
        goto L107
    L114:
        r26.put("Set-Cookie", r121);     // Catch: Throwable -> L128
        this.f3400b.put(URI.create(r20.getScheme() + "://" + r28), r26);     // Catch: Throwable -> L128
    L118:
        r25 = "last return";
    L116:
        th = move-exception;
        th.printStackTrace();
    L119:
        r25 = "uri responseHeaders or mCookieMgr is null";
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L146:
        r16 = r11.toString();     // Catch: JSONException -> L122
        goto L17
    L9:
        if (r21.containsKey("Set-Cookie") == false) goto L11;
        r14 = true;
        goto L13
    L5:
        r10 = null;
        goto L6
    }
}
