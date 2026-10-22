package e5;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.g;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.a0;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import n4.c;
import n4.d;
import o2.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends a3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f8636c = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f8637g = false;

    static {
    }

    public a() {
    }

    public static void e(boolean r10) {
        f8636c = r10;
    }

    private String f(String r10) {
        if (g.b(r10) == false) goto L53;
        return r10;
    L53:
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L50
        Pair<String, String> r12 = k.k(r10, r11);     // Catch: Throwable -> L50
        if (r12 != null) goto L9;
        return r10;
    L9:
        if (r11.isEmpty() == true) goto L28;
        Iterator r13 = r11.entrySet().iterator();     // Catch: Throwable -> L50
    L12:
        if (r13.hasNext() == false) goto L28;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L50
        if (r14 == null) goto L12;
        List r15 = (List) r14.getValue();     // Catch: Throwable -> L50
        if (r15 == null) goto L12;
        if (r15.isEmpty() == true) goto L12;
        LinkedHashSet r16 = new LinkedHashSet();     // Catch: Throwable -> L50
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L50
    L23:
        if (r17.hasNext() == false) goto L12;
        String r18 = (String) r17.next();     // Catch: Throwable -> L50
        if (r16.contains(r18) == true) goto L26;
        r16.add(r18);     // Catch: Throwable -> L50
        goto L23
    L26:
        r17.remove();     // Catch: Throwable -> L50
    L28:
        j r19 = new j(((String) r12.first) + ((String) r12.second));     // Catch: Throwable -> L50
        if (r11.isEmpty() == true) goto L48;
        Iterator r20 = r11.entrySet().iterator();     // Catch: Throwable -> L50
    L32:
        if (r20.hasNext() == false) goto L48;
        Map.Entry r21 = (Map.Entry) r20.next();     // Catch: Throwable -> L50
        if (r21 == null) goto L32;
        if (r21.getKey() == null) goto L32;
        List r22 = (List) r21.getValue();     // Catch: Throwable -> L50
        if (r22 == null) goto L32;
        if (r22.isEmpty() == true) goto L32;
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L50
    L46:
        if (r23.hasNext() == false) goto L32;
        r19.b((String) r21.getKey(), (String) r23.next());     // Catch: Throwable -> L50
    L48:
        return r19.c();
    L50:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }

    @Override // a3.a
    protected c b(c r10) {
        c r11 = super.b(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        if (f8637g == true) goto L9;
        a5.b.d();
        f8637g = true;
    L9:
        long r12 = SystemClock.uptimeMillis();
        c.a r13 = r11.O();
        String r14 = f(r11.G());
        r13.f(r14);
        if (r11.z() == null) goto L12;
        RetrofitMetrics r15 = r11.z();
        r15.X = SystemClock.uptimeMillis() - r12;
    L12:
        Long r16 = Long.valueOf(SystemClock.uptimeMillis());
        ArrayList r17 = new ArrayList();
        if (r11.v() == null) goto L16;
        r17.addAll(r11.v());
    L16:
        if (f8636c == false) goto L33;
        LinkedList r18 = new LinkedList();     // Catch: Throwable -> L30
        String r19 = g3.a.g(r14, r18);     // Catch: Throwable -> L30
        if (r19 == null) goto L21;
        r13.f(r19);     // Catch: Throwable -> L30
    L21:
        if (r18.isEmpty() == true) goto L33;
        Iterator r20 = r18.iterator();     // Catch: Throwable -> L30
    L23:
        if (r20.hasNext() == false) goto L33;
        Pair r21 = (Pair) r20.next();     // Catch: Throwable -> L30
        if (r21 == null) goto L23;
        r17.add(new n4.b((String) r21.first, (String) r21.second));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
    L33:
        if (r11.z() == null) goto L35;
        RetrofitMetrics r22 = r11.z();
        r22.Y = SystemClock.uptimeMillis() - r16.longValue();
    L35:
        Long r23 = Long.valueOf(SystemClock.uptimeMillis());
        String r24 = com.bytedance.ttnet.utils.c.g(r14);     // Catch: Throwable -> L40
        if (g.b(r24) == true) goto L43;
        r17.add(new n4.b("X-SS-REQ-TICKET", r24));     // Catch: Throwable -> L40
    L43:
        if (r11.z() == null) goto L45;
        RetrofitMetrics r25 = r11.z();
        r25.Z = SystemClock.uptimeMillis() - r23.longValue();
    L45:
        Long r26 = Long.valueOf(SystemClock.uptimeMillis());
        com.bytedance.ttnet.utils.a.h(r14, r17);
        if (r11.z() == null) goto L48;
        RetrofitMetrics r27 = r11.z();
        r27.f2428b0 = SystemClock.uptimeMillis() - r26.longValue();
    L48:
        ClientKeyManager.k().a(r17, r11.z());
        r13.b(r17);
        return r13.a();
    L40:
        th = move-exception;
        th.printStackTrace();
        goto L43
    }

    @Override // a3.a
    protected void c(c r18, a0 r19) {
        super.c(r18, r19);
        if (r18 == null) goto L139;
        if (r19 == null) goto L141;
        d r10 = r19.h();
        Long r11 = Long.valueOf(SystemClock.uptimeMillis());
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        if (r18.z() == null) goto L26;
        r18.z().f2436f0 = SystemClock.uptimeMillis() - r11.longValue();
    L26:
        ClientKeyManager.k().g(r18, r10);
        Long r12 = Long.valueOf(SystemClock.uptimeMillis());
        Object r13 = r10.b();
        String r14 = null;
        if ((r13 instanceof a5.b) == false) goto L47;
        a5.b r15 = (a5.b) r13;
        if (r15.f11398e == 0) goto L114;
        JSONObject r16 = new JSONObject();
        List<n4.b> r17 = r10.d();
        int r110 = 0;
    L32:
        if (r110 >= r17.size()) goto L43;
        n4.b r20 = r17.get(r110);     // Catch: Exception -> L40
        if (r20 == null) goto L42;
        if (TextUtils.isEmpty(r20.a()) == true) goto L42;
        r16.put(r20.a().toUpperCase(), r20.b());     // Catch: Exception -> L40
    L42:
        r110 = r110 + 1;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L43:
        T r21 = r15.f11398e;
        if ((r21 instanceof a5.d) == false) goto L46;
        ((a5.d) r21).C = r16;
    L46:
        ((a5.d) r21).f11421b = r10.e();
        ((a5.d) r15.f11398e).f11420a = r15.f11397d;
    L114:
        String r22 = r10.g();     // Catch: Throwable -> L60
        n4.b r23 = r18.u("X-SS-REQ-TICKET");     // Catch: Throwable -> L60
        if (r23 == null) goto L51;
        String r24 = r23.b();     // Catch: Throwable -> L60
    L52:
        n4.b r25 = r10.c("X-SS-REQ-TICKET");     // Catch: Throwable -> L60
        if (r25 == null) goto L55;
        String r26 = r25.b();     // Catch: Throwable -> L60
    L56:
        if (r26 == null) goto L58;
        r14 = r26;
    L58:
        com.bytedance.ttnet.utils.c.a(r22, r24, r14, r15);     // Catch: Throwable -> L60
    L116:
        String r27 = r18.G();     // Catch: Throwable -> L103
        Uri r28 = Uri.parse(r27);     // Catch: Throwable -> L103
        if (r28.getHost().endsWith(com.bytedance.ttnet.b.a()) == true) goto L65;
        return;
    L65:
        String[] r29 = {Api.KEY_SET_COOKIE};     // Catch: Throwable -> L103
        int r30 = 2;
        String[] r31 = {"sessionid", "tt_sessionid"};     // Catch: Throwable -> L103
        int r111 = 0;
    L67:
        if (r111 >= 1) goto L106;
        List<n4.b> r112 = r10.h(r29[r111]);     // Catch: Throwable -> L103
        if (r112 == null) goto L102;
        if (r112.size() <= 0) goto L102;
        Iterator<n4.b> r113 = r112.iterator();     // Catch: Throwable -> L103
    L75:
        if (r113.hasNext() == false) goto L102;
        n4.b r114 = r113.next();     // Catch: Throwable -> L103
        int r115 = 0;
    L77:
        if (r115 >= r30) goto L75;
        String r116 = z2.a.a(r114.b(), r31[r115]);     // Catch: Throwable -> L103
        if (Logger.debug() == false) goto L82;
        Logger.d("SsOkHttpClient", r116);     // Catch: Throwable -> L103
    L82:
        if (g.b(r116) == false) goto L84;
        Uri r117 = r28;
    L101:
        r115 = r115 + 1;
        r28 = r117;
        r30 = 2;
        goto L77
    L84:
        int r118 = r10.e();     // Catch: Throwable -> L103
        boolean r119 = r15.S;     // Catch: Throwable -> L103
        JSONObject r32 = new JSONObject();     // Catch: Throwable -> L103
        String r33 = r28.getEncodedQuery();     // Catch: Throwable -> L113
        if (g.b(r33) == true) goto L90;
        r117 = r28;
        r32.put("url_query", r33);     // Catch: Throwable -> L112
    L92:
        if (g.b(r15.f11397d) == true) goto L95;
        r32.put(ICronetClient.KEY_REMOTE_IP, r15.f11397d);     // Catch: Throwable -> L103
    L95:
        if (r10.d() == null) goto L97;
        r32.put("header_list", r10.d().toString());     // Catch: Throwable -> L103
    L97:
        int r34 = r27.indexOf("?");     // Catch: Throwable -> L103
        if (r34 != (-1)) goto L100;
        r34 = r27.length();     // Catch: Throwable -> L103
    L100:
        com.bytedance.ttnet.utils.c.d("set_cookie", r27.substring(0, r34), r118, r119, r32);     // Catch: Throwable -> L103
    L90:
        r117 = r28;
    L102:
        r111 = r111 + 1;
        r28 = r28;
        r30 = 2;
    L106:
        if (r18.z() == null) goto L108;
        r18.z().f2426a0 = SystemClock.uptimeMillis() - r12.longValue();
    L108:
        Long r35 = Long.valueOf(SystemClock.uptimeMillis());
        com.bytedance.ttnet.utils.a.f(r18, r10, r15);
        if (r18.z() == null) goto L140;
        r18.z().f2434e0 = SystemClock.uptimeMillis() - r35.longValue();
        return;
    L140:
        return;
    L103:
        th = move-exception;
        th.printStackTrace();
        goto L106
    L55:
        r26 = null;
        goto L56
    L51:
        r24 = null;
    L60:
        th = move-exception;
        th.printStackTrace();
        goto L116
    L47:
        r15 = null;
        goto L114
    L8:
        if (f.i() == null) goto L24;
        String r36 = f.i().b();     // Catch: Throwable -> L21
        if (g.b(r36) == true) goto L24;
        List<n4.b> r37 = r10.h(r36);     // Catch: Throwable -> L21
        if (r37 == null) goto L24;
        if (r37.size() <= 0) goto L24;
        ArrayList r38 = new ArrayList();     // Catch: Throwable -> L21
        Iterator<n4.b> r39 = r37.iterator();     // Catch: Throwable -> L21
    L17:
        if (r39.hasNext() == false) goto L19;
        r38.add(r39.next().b());     // Catch: Throwable -> L21
        goto L17
    L19:
        f.i().a(r38);     // Catch: Throwable -> L21
        goto L24
    L141:
        return;
    }
}
