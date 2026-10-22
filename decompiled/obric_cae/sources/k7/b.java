package k7;

import a7.i;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.obric.cae.userAware.report.SubwayEvaluationEvent;
import d9.c;
import d9.d;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import l7.f;
import l7.g;
import org.json.JSONException;
import org.json.JSONObject;
import r1.s;
import we.a0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile b f8960m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f8967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f8968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f8969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f8972l;

    public b() {
        this.f8961a = "";
        this.f8962b = "";
        this.f8963c = "";
        this.f8964d = "";
        this.f8965e = "";
        this.f8966f = "";
        this.f8967g = new ArrayList();
        this.f8968h = new ArrayList();
        this.f8970j = false;
        this.f8971k = false;
    }

    public static String d(String r8, HttpURLConnection r10) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return "";
    L6:
        String r11 = r10.getHeaderField(r8);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        return r11;
    L9:
        return r10.getHeaderField(r8.toLowerCase());
    }

    public static b e() {
        if (f8960m != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8960m != null) goto L9;
        f8960m = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f8960m;
    }

    public final void a() {
        if (this.f8964d.isEmpty() == true) goto L7;
        this.f8961a = this.f8964d;
        String r8 = "uid";
    L5:
        this.f8965e = r8;
        return;
    L7:
        if (this.f8963c.isEmpty() == true) goto L10;
        this.f8961a = this.f8963c;
        r8 = "did";
        goto L5
    L10:
        if (this.f8966f.isEmpty() == true) goto L12;
        this.f8961a = this.f8966f;
        r8 = "local";
        goto L5
    L12:
        this.f8965e = SubwayEvaluationEvent.VERIFY_METHOD_NONE;
        this.f8961a = "";
    }

    public final Request b(Request r8) {
        if (this.f8970j == true) goto L5;
    L65:
        return null;
    L5:
        if (this.f8971k == true) goto L65;
        if (TextUtils.isEmpty(r8.getHost()) == true) goto L65;
        Iterator r10 = this.f8968h.iterator();
    L10:
        boolean r11 = false;
        if (r10.hasNext() == false) goto L15;
        if (g.b(r8.getHost(), (String) r10.next()) == false) goto L10;
        boolean r12 = true;
    L16:
        if (r12 == true) goto L18;
        return null;
    L18:
        ArrayList r13 = new ArrayList();
        if (r8.getHeaders() == null) goto L22;
        r13.addAll(r8.getHeaders());
    L22:
        if (TextUtils.isEmpty(this.f8962b) == true) goto L25;
        r13.add(new Header("x-tt-store-idc", this.f8962b));
    L25:
        if (TextUtils.isEmpty(this.f8961a) == true) goto L41;
        String r14 = this.f8965e;
        if (TextUtils.isEmpty(r14) == false) goto L30;
    L34:
        boolean r15 = false;
    L36:
        if (r15 == false) goto L39;
        r13.add(new Header("x-tt-store-region", this.f8961a));
        Header r16 = new Header("x-tt-store-region-src", this.f8965e);
    L42:
        r13.add(r16);
    L43:
        Request.Builder r17 = r8.newBuilder();
        if (TextUtils.isEmpty(r8.getPath()) == true) goto L63;
        Iterator r18 = this.f8967g.iterator();
    L48:
        if (r18.hasNext() == false) goto L52;
        if (g.b(r8.getPath(), (String) r18.next()) == false) goto L48;
        r11 = true;
    L52:
        if (r11 == false) goto L63;
        if (this.f8963c.isEmpty() == true) goto L57;
        Header r19 = new Header("x-tt-store-region-did", this.f8963c);
    L58:
        r13.add(r19);
        if (this.f8964d.isEmpty() == true) goto L61;
        r13.add(new Header("x-tt-store-region-uid", this.f8964d));
    L62:
        f r20 = new f(r8.getUrl());
        r20.b("okhttp_version", "4.0.76.2");
        r17.url(r20.c());
        goto L63
    L61:
        r13.add(new Header("x-tt-store-region-uid", SubwayEvaluationEvent.VERIFY_METHOD_NONE));
        goto L62
    L57:
        r19 = new Header("x-tt-store-region-did", SubwayEvaluationEvent.VERIFY_METHOD_NONE);
    L63:
        r17.headers(r13);
        return r17.build();
    L39:
        if (this.f8965e.equals("local") == false) goto L43;
        r16 = new Header("x-tt-local-region", this.f8966f);
        goto L42
    L30:
        if (r14.equals("uid") == false) goto L32;
    L35:
        r15 = true;
        goto L36
    L32:
        if (r14.equals("did") == false) goto L34;
    L41:
        r16 = new Header("x-tt-local-region", "unknown");
        goto L42
    L15:
        r12 = false;
        goto L16
    }

    public final boolean c(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        Iterator r10 = this.f8967g.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        if (g.b(r8, (String) r10.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final void f() {
        SharedPreferences r8 = this.f8969i.getSharedPreferences("ttnet_store_region", 0);
        this.f8962b = r8.getString("store_idc", "");
        this.f8961a = r8.getString("store_region", "");
        this.f8964d = r8.getString("store_region_uid", "");
        this.f8963c = r8.getString("store_region_did", "");
        this.f8965e = r8.getString("store_region_src", "");
        this.f8971k = r8.getBoolean("disable_store_region", false);
        a();
        a r10 = this.f8972l;
        String r11 = this.f8962b;
        String r12 = this.f8961a;
        String r13 = this.f8965e;
        ((c) r10).getClass();
        if (y8.b.f14092a == null) goto L5;
    L14:
        y8.b.f14092a.a(r11, r12, r13);
        Logger.d("b", "Init idc: " + this.f8962b + " region: " + this.f8961a + " source: " + this.f8965e + " did: " + this.f8963c + " uid: " + this.f8964d + " local: " + this.f8966f);
        return;
    L5:
        monitor-enter(y8.b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (y8.b.f14092a != null) goto L9;
        y8.b.f14092a = new y8.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(y8.b.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void g(HttpURLConnection r10, byte[] r11, s r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f8970j == true) goto L7;
        return;
    L7:
        if (this.f8971k == false) goto L10;
        return;
    L10:
        if (c(r10.getURL().getPath()) == true) goto L12;
        return;
    L12:
        String r8 = d("x-tt-store-region", r10);
        String r13 = d("x-tt-store-region-src", r10);
        if (TextUtils.isEmpty(r8) == false) goto L15;
    L22:
        boolean r14 = false;
    L23:
        if (r14 == true) goto L25;
        return;
    L25:
        String r15 = d("x-tt-store-idc", r10);
        String r16 = d("x-tt-with-tnc", r10);
        String r17 = d("x-tt-tnc-attr", r10);
        String r18 = d("x-ss-etag", r10);
        String r19 = d("x-tt-tnc-config", r10);
        if (TextUtils.isEmpty(r16) == false) goto L28;
    L35:
        String r20 = "";
    L36:
        String r21 = r20;
        String r22 = r10.getURL().toString();
        String r23 = r10.getHeaderFields().toString();
        JSONObject r110 = new JSONObject();
        r110.put(WsConstants.KEY_CONNECTION_URL, r22);     // Catch: JSONException -> L39
        r110.put("headers", r23);     // Catch: JSONException -> L39
    L49:
        i.n(r15, r8, r13, r17, r18, r19, r21, r110.toString());     // Catch: Exception -> L44
        return;
    L44:
        e = move-exception;
        e.printStackTrace();
        return;
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L49
    L28:
        if (r16.equals("1") == false) goto L35;
        if (TextUtils.isEmpty(r17) == true) goto L35;
        r20 = "{\"data\": " + new JSONObject(new String(r11)).getString("tnc_data") + "}";     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L15:
        if (TextUtils.isEmpty(r13) == true) goto L22;
        if (r13.equals("uid") == false) goto L20;
    L21:
        r14 = true;
        goto L23
    L20:
        if (r13.equals("did") == false) goto L22;
        goto L21
    }

    public final void h(a0 r17, String r18, byte[] r19) {
        if (this.f8970j == true) goto L5;
        return;
    L5:
        if (this.f8971k == true) goto L116;
        URI r8 = g.e(r18);     // Catch: Exception -> L101
        if (r8 != null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r8.getPath()) == false) goto L13;
        return;
    L13:
        if (c(r8.getPath()) == true) goto L15;
        return;
    L15:
        String r10 = r17.n("x-tt-store-region");
        String r11 = r17.n("x-tt-store-region-src");
        if (TextUtils.isEmpty(r10) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r11) == false) goto L20;
        return;
    L20:
        if (TextUtils.isEmpty(r11) == false) goto L23;
    L27:
        boolean r12 = false;
    L29:
        if (r12 == false) goto L118;
        Logger.d("b", "origin idc: " + this.f8962b + " region: " + this.f8961a + " source: " + this.f8965e + " did: " + this.f8963c + " uid: " + this.f8964d + " local: " + this.f8966f);
        String r13 = r17.n("x-tt-store-idc");
        SharedPreferences.Editor r14 = this.f8969i.getSharedPreferences("ttnet_store_region", 0).edit();
        if (r11.equals("did") == false) goto L37;
        if (this.f8963c.equals(r10) == true) goto L37;
        this.f8963c = r10;
        r14.putString("store_region_did", r10);
    L46:
        boolean r15 = true;
    L48:
        String r16 = this.f8961a;
        a();
        if (this.f8961a.equals(r16) == false) goto L57;
        if (TextUtils.isEmpty(r13) == false) goto L53;
    L55:
        boolean r20 = false;
    L60:
        Logger.d("b", "update idc: " + this.f8962b + " region: " + this.f8961a + " source: " + this.f8965e + " did: " + this.f8963c + " uid: " + this.f8964d + " local: " + this.f8966f);
        StringBuilder r21 = new StringBuilder("save config: ");
        r21.append(r15);
        r21.append(" update tnc: ");
        r21.append(r20);
        Logger.d("b", r21.toString());
        if (r15 == false) goto L80;
        r14.putString("store_region_src", this.f8965e);
        r14.apply();
        a r22 = this.f8972l;
        JSONObject r23 = new JSONObject();
        JSONObject r24 = new JSONObject();
        r24.put(WsConstants.KEY_CONNECTION_URL, r18);     // Catch: JSONException -> L65
        r24.put("headers", r17.f13119p.toString());     // Catch: JSONException -> L65
        r23.put("base", r24);     // Catch: JSONException -> L65
        r23.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L65
        r23.put("store_idc", this.f8962b);     // Catch: JSONException -> L65
        r23.put("store_region", this.f8961a);     // Catch: JSONException -> L65
        r23.put("source", this.f8965e);     // Catch: JSONException -> L65
        r23.put("did_region", this.f8963c);     // Catch: JSONException -> L65
        r23.put("uid_region", this.f8964d);     // Catch: JSONException -> L65
        r23.put("local", this.f8966f);     // Catch: JSONException -> L65
    L67:
        ((c) r22).f6975a.sendAppMonitorEvent(r23.toString(), "store_idc");
        a r25 = this.f8972l;
        String r26 = this.f8962b;
        String r27 = this.f8961a;
        String r28 = this.f8965e;
        ((c) r25).getClass();
        if (y8.b.f14092a == null) goto L70;
    L79:
        y8.b.f14092a.a(r26, r27, r28);
        goto L80
    L70:
        monitor-enter(y8.b.class);
    L76:
        th = move-exception;
        throw th;
    L72:
        if (y8.b.f14092a != null) goto L74;
        y8.b.f14092a = new y8.b();     // Catch: Throwable -> L76
    L74:
        monitor-exit(y8.b.class);     // Catch: Throwable -> L76
    L65:
        e = move-exception;
        e.printStackTrace();
    L80:
        String r29 = r17.n("x-ss-etag");
        String r30 = r17.n("x-tt-tnc-attr");
        String r31 = r17.n("x-tt-with-tnc");
        if (TextUtils.isEmpty(r31) == false) goto L83;
    L90:
        JSONObject r32 = null;
    L91:
        JSONObject r33 = r32;
        ((c) this.f8972l).getClass();
        d r34 = d.c();
        r34.getClass();
        Logger.d("TNCManager", "data: " + r33 + " etag: " + r29 + " tncAttr: " + r30 + " needUpdateTnc: " + r20);
        if (r33 == null) goto L96;
        d9.b r35 = r34.f6981d;
        if (r35 == null) goto L96;
        r35.f6974d = "";
        boolean r36 = r35.a(r33, d.b.f6996o, r29, r30, System.currentTimeMillis());
    L97:
        if (r20 == false) goto L114;
        if (r36 == true) goto L115;
        Logger.d("TNCManager", "doUpdateRemote tnc");
        r34.a(d.b.f7001t, true);
        return;
    L115:
        return;
    L114:
        return;
    L96:
        r36 = false;
        goto L97
    L83:
        if (r31.equals("1") == false) goto L90;
        if (TextUtils.isEmpty(r30) == true) goto L90;
        r32 = new JSONObject(new String(r19)).getJSONObject("tnc_data");     // Catch: JSONException -> L88
    L88:
        e = move-exception;
        e.printStackTrace();
        goto L90
    L53:
        if (r13.equals(this.f8962b) == true) goto L55;
    L57:
        if (TextUtils.isEmpty(r13) == true) goto L59;
        this.f8962b = r13;
    L59:
        r14.putString("store_region", this.f8961a);
        r14.putString("store_idc", this.f8962b);
        r15 = true;
        r20 = true;
    L37:
        if (r11.equals("uid") == true) goto L39;
    L47:
        r15 = false;
        goto L48
    L39:
        if (this.f8964d.equals(r10) == true) goto L47;
        if (r10.equals(SubwayEvaluationEvent.VERIFY_METHOD_NONE) == true) goto L43;
        this.f8964d = r10;
        r14.putString("store_region_uid", r10);
        goto L46
    L43:
        if (this.f8964d.isEmpty() == true) goto L47;
        this.f8964d = "";
        r14.putString("store_region_uid", "");
        goto L46
    L118:
        return;
    L23:
        if (r11.equals("uid") == false) goto L25;
    L28:
        r12 = true;
        goto L29
    L25:
        if (r11.equals("did") == false) goto L27;
    L119:
        return;
    }
}
