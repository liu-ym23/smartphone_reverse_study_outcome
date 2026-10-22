package ca;

import ai.i0;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Request;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import fi.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static volatile e e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f1156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f1157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CopyOnWriteArrayList f1158c;
    public CopyOnWriteArrayList d;

    public static e b() {
        if (e != null) goto L16;
        monitor-enter(e.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L11;
        e r5 = new e();     // Catch: Throwable -> L9
        r5.f1157b = false;     // Catch: Throwable -> L9
        r5.f1158c = new CopyOnWriteArrayList();     // Catch: Throwable -> L9
        r5.d = new CopyOnWriteArrayList();     // Catch: Throwable -> L9
        e = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(e.class);     // Catch: Throwable -> L9
    L16:
        return e;
    }

    public static void c(JSONObject r5, ArrayList r10) {
        String r11 = r5.getString("action");
        int r12 = r5.getInt("act_priority");
        if (r12 >= 0) goto L5;
        return;
    L5:
        JSONObject r13 = r5.getJSONObject("param");
        int r14 = r5.optInt("set_req_priority", r12);
        if (r14 != (-1)) goto L9;
        r14 = Integer.MAX_VALUE;
    L9:
        if (r11.equals("rm") == false) goto L12;
        g r15 = new g(r12);
        r15.f1162i = new ArrayList();
        r15.f1163j = new ArrayList();
        r15.f1164k = false;
        r15.f1165l = false;
        c r16 = r15;
    L14:
        r16.c(r13);
        r16.f1153b = r14;
        c r17 = r16;
    L16:
        if (r17 == null) goto L19;
        r10.add(r17);
        return;
    L19:
        return;
    L12:
        if (r11.equals("encrypt") == false) goto L15;
        b r18 = new b(r12);
        r18.f1148i = new ArrayList();
        r18.f1149j = false;
        r18.f1150k = false;
        r16 = r18;
        goto L14
    L15:
        r17 = null;
        goto L16
    }

    public static void d(JSONArray r5, ArrayList r10) {
        if (r5 == null) goto L12;
        if (r10 == null) goto L19;
        int r11 = 0;
    L14:
        if (r11 >= r5.length()) goto L21;
        String r12 = r5.getString(r11);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r10.add(r12);     // Catch: JSONException -> L13
    L11:
        r11 = r11 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public static void f(bi.d r10, Request r11, String r12) {
        if (r11.isQueryEncryptEnabled() == false) goto L5;
    L7:
        ArrayList r5 = new ArrayList();
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r5.add(new bi.c("x-tt-encrypt-queries", r12));
    L11:
        if (r11.getHeaders() == null) goto L14;
        r5.addAll(r11.getHeaders());
    L14:
        if (r11.isBodyEncryptEnabled() == false) goto L20;
        j r13 = r11.getBody();
        if ((r13 instanceof fi.a) == false) goto L20;
        long r14 = System.currentTimeMillis();
        boolean r15 = ((fi.a) r13).e();
        i0 r16 = r11.getMetrics();
        if (r16 == null) goto L22;
        r16.L = System.currentTimeMillis() - r14;
    L22:
        if (r15 == true) goto L24;
    L26:
        if (r15 == false) goto L29;
        r5.add(new bi.c("x-tt-cipher-version", "1.0.0"));
        r5.add(new bi.c("x-tt-encrypt-info", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
    L31:
        r10.f919c = r5;
        return;
    L29:
        if (r11.isQueryEncryptEnabled() == false) goto L31;
        r5.add(new bi.c("x-tt-cipher-version", "1.0.0"));
        r5.add(new bi.c("x-tt-encrypt-info", "0"));
        goto L31
    L24:
        if (r11.isQueryEncryptEnabled() == false) goto L26;
        r5.add(new bi.c("x-tt-cipher-version", "1.0.0"));
        r5.add(new bi.c("x-tt-encrypt-info", "2"));
    L20:
        r15 = false;
        goto L22
    L5:
        if (r11.isBodyEncryptEnabled() == true) goto L7;
    }

    public final boolean a(Request r14, LinkedHashMap r15) {
        ArrayList r5 = new ArrayList();
        r14.setQueryFilterPriority(0);
        Iterator r13 = this.f1158c.iterator();
        boolean r10 = false;
    L4:
        if (r13.hasNext() == false) goto L14;
        c r11 = (c) r13.next();
        r11.getClass();
        a r12 = new a();
        r12.f1145a = false;
        r12.f1146b = -1;
        r12.f1147c = -1;
        r12.d = -1;
        r12.f1147c = SystemClock.uptimeMillis();
        int r16 = r14.getQueryFilterPriority();
        int r17 = r11.f1152a;
        if (r16 <= r17) goto L8;
        boolean r18 = false;
    L9:
        if (r18 == false) goto L11;
        r14.setQueryFilterPriority(r11.f1153b);
    L11:
        r12.f1145a = r18;
        r12.f1146b = r17;
        r12.d = SystemClock.uptimeMillis();
        r5.add(r12);
        if (r18 == false) goto L4;
        r10 = true;
        goto L4
    L8:
        r18 = r11.a(r14, r15);
        goto L9
    L14:
        Logger.d("e", "dispatchQueryMap hit: " + r10);
        if (r14.getMetrics() == null) goto L34;
        i0 r19 = r14.getMetrics();
        JSONArray r110 = new JSONArray();
        Iterator r20 = r5.iterator();
    L18:
        if (r20.hasNext() == false) goto L33;
        a r21 = (a) r20.next();
        JSONObject r22 = new JSONObject();     // Catch: JSONException -> L31
        r22.put("hit", r21.f1145a);     // Catch: JSONException -> L31
        r22.put("priority", r21.f1146b);     // Catch: JSONException -> L31
        long r23 = r21.f1147c;     // Catch: JSONException -> L31
        if (r23 < 0) goto L28;
        long r111 = r21.d;     // Catch: JSONException -> L31
        if (r111 < 0) goto L28;
        if (r23 > r111) goto L28;
        long r112 = r111 - r23;     // Catch: JSONException -> L31
    L29:
        r22.put("consume", r112);     // Catch: JSONException -> L31
        r110.put(r22);     // Catch: JSONException -> L31
    L28:
        r112 = -1;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L33:
        Logger.d("e", "action info: " + r110.toString());
        r19.O = r110;
    L34:
        return r10;
    }

    public final synchronized void e(String r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(this.f1156a) == false) goto L7;
    L13:
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L11
        JSONArray r11 = new JSONArray(r10);     // Catch: Throwable -> L11
        int r12 = 0;
    L15:
        if (r12 >= r11.length()) goto L17;
        c(r11.getJSONObject(r12), r5);     // Catch: Throwable -> L11
        r12 = r12 + 1;     // Catch: Throwable -> L11
        goto L15
    L17:
        Collections.sort(r5, new d(0));     // Catch: Throwable -> L11
        this.f1158c.clear();     // Catch: Throwable -> L11
        this.f1158c.addAll(r5);     // Catch: Throwable -> L11
        this.f1156a = r10;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        if (this.f1156a.equals(r10) == false) goto L13;
        Logger.d("e", "Config is same with local config, do not parse.");     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
