package l9;

import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f19554a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static n9.a f19556c;

    static {
        f19554a = new ConcurrentLinkedQueue();
    }

    public static void a(JSONArray r13, boolean r14) {
        io.reactivex.exceptions.a.d("apmconfig", "fromnet " + r14 + " : " + r13);
        String r5 = com.bytedance.crash.n.d().i();
        int r10 = 0;
    L3:
        boolean r11 = true;
        n9.a r12 = null;
        if (r10 >= r13.length()) goto L24;
        JSONObject r15 = r13.optJSONObject(r10);     // Catch: Throwable -> L44
        String r16 = r15.keys().next();     // Catch: Throwable -> L44
        JSONObject r17 = r15.optJSONObject(r16);     // Catch: Throwable -> L44
        io.reactivex.exceptions.a.i("update config " + r16 + " : " + r17);     // Catch: Throwable -> L44
        HashMap r18 = n9.a.f;     // Catch: Throwable -> L44
        n9.a r19 = (n9.a) r18.get(r16);     // Catch: Throwable -> L44
        if (r19 == null) goto L14;
        r19.f20212a = r17;     // Catch: Throwable -> L44
        if (r17 != null) goto L10;
    L12:
        r11 = false;
    L13:
        r19.e = r11;     // Catch: Throwable -> L44
    L16:
        if (TextUtils.equals(r5, r16) == false) goto L22;
        f();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r5) == true) goto L21;
        r12 = (n9.a) r18.get(r5);     // Catch: Throwable -> L44
    L21:
        f19556c = r12;     // Catch: Throwable -> L44
    L22:
        com.bytedance.crash.upload.b.k(r16, r14);     // Catch: Throwable -> L44
        goto L23
    L10:
        if (mh.e.c(r17, 0, new String[]{"exception_modules", "exception", "enable_upload"}) != 1) goto L12;
    L14:
        new d(r16, r17);     // Catch: Throwable -> L44
    L23:
        r10 = r10 + 1;
        goto L3
    L24:
        if (r14 == true) goto L45;
        Map r110 = com.bytedance.crash.upload.b.f4097i;
        if (r110 == null) goto L45;
        if (r110.isEmpty() == true) goto L45;
        if (com.bytedance.crash.upload.b.f4097i.size() < z8.d.f23418a.size()) goto L45;
        return;
    L45:
        if (com.bytedance.crash.upload.b.g == true) goto L37;
        com.bytedance.crash.upload.b.g = true;     // Catch: Throwable -> L43
        boolean r111 = com.bytedance.crash.upload.b.o(null);     // Catch: Throwable -> L43
        com.bytedance.crash.upload.b.r();     // Catch: Throwable -> L43
        if (r111 == false) goto L37;
        io.reactivex.exceptions.a.i("start fetch apmConfig");     // Catch: Throwable -> L43
        com.bytedance.crash.upload.b.f4094b = 40;     // Catch: Throwable -> L43
        o.e().b(com.bytedance.crash.upload.b.f4093a);     // Catch: Throwable -> L43
    L37:
        cl.a.p(new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22991n), n9.a.a());     // Catch: Throwable -> L43
        if (com.bytedance.crash.upload.b.e != null) goto L40;
        com.bytedance.crash.upload.b.e = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22993p);     // Catch: Throwable -> L43
    L40:
        cl.a.o(com.bytedance.crash.upload.b.e, com.bytedance.crash.upload.b.f4097i);     // Catch: Throwable -> L43
    L41:
        io.reactivex.exceptions.a.i("success saveApmConfig");
    }

    public static boolean b() {
        JSONObject r5 = e();
        if (mh.e.c(r5, -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_looper_monitor"}) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c(Object r5, String r10) {
        HashMap r11 = n9.a.f;
        String r12 = z8.d.a(r5);
        if (TextUtils.isEmpty(r12) == false) goto L5;
        n9.a r13 = null;
    L7:
        if (r13 != null) goto L9;
        return false;
    L9:
        JSONObject r14 = r13.f20212a;
        if (r14 != null) goto L13;
        return false;
    L13:
        if (r13.d != null) goto L18;
        JSONObject r15 = mh.e.q(r14, new String[]{"custom_event_settings", "allow_service_name", "test"});
        r13.d = r15;
        if (r15 != null) goto L18;
        r13.d = new JSONObject();
    L18:
        if (r13.d.optInt(r10) != 1) goto L20;
        return true;
    L20:
        return false;
    L5:
        r13 = (n9.a) n9.a.f.get(r12);
        goto L7
    }

    public static boolean d() {
        JSONObject r5 = e();
        if (mh.e.c(r5, -1, new String[]{"custom_event_settings", "npth_simple_setting", "disable_network_disaster"}) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static JSONObject e() {
        String r5 = com.bytedance.crash.n.d().i();
        n9.a r10 = (n9.a) n9.a.f.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.f20212a;
    }

    public static void f() {
        String[] r5 = {"custom_event_settings", "npth_simple_setting", "crash_upload_domain"};
        JSONObject r10 = mh.e.q(e(), r5);
        if (r10 != null) goto L5;
        String r11 = null;
    L6:
        mh.e.f(e(), new String[]{"custom_event_settings", "npth_simple_setting", "crash_upload_domain_list"});
        io.reactivex.exceptions.a.i("setDomainName begin:" + r11);
        Iterator r12 = f19554a.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        b r13 = (b) r12.next();
        if (f19555b == true) goto L12;
        r13.b();
    L12:
        r13.a();
        goto L8
    L13:
        f19555b = true;
        return;
    L5:
        r11 = r10.optString(r5[2]);
        goto L6
    }
}
