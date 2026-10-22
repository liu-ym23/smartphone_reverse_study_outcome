package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import jta.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class l implements nx3.e, Runnable {
    public String a;
    public volatile boolean b;
    public volatile long c;
    public List<String> d;
    public final BlockingQueue<b> e;

    public l() {
        this.b = false;
        this.c = 200;
        this.e = new LinkedBlockingQueue();
    }

    public final void a() {
    L100:
    L87:
        th = move-exception;
        ita.j.b("EventVerifyWrapper out exception =", th);
        return;
    L3:
        if (Thread.interrupted() == true) goto L4;
        if (this.b == false) goto L136;
        JSONObject r0 = AppLog.g0.m();     // Catch: Throwable -> L87
        if (r0 != null) goto L11;
    L92:
        Thread.sleep(1000);     // Catch: InterruptedException -> L90 Throwable -> L87
        goto L100
    L11:
        if (r0.isNull("device_id") == true) goto L92;
        if (TextUtils.isEmpty(this.a) == true) goto L92;
        b r1 = (b) ((LinkedBlockingQueue) this.e).take();     // Catch: Throwable -> L87
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L87
        r4.add(r1);     // Catch: Throwable -> L87
        ((LinkedBlockingQueue) this.e).drainTo(r4);     // Catch: Throwable -> L87
        HashMap r2 = new HashMap();     // Catch: Throwable -> L87
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L87
    L17:
        if (r5.hasNext() == false) goto L96;
        b r6 = (b) r5.next();     // Catch: Throwable -> L87
        if (r6 == null) goto L17;
        JSONArray r7 = r6.b;     // Catch: Throwable -> L87
        int r8 = 0;
        if (r7 != null) goto L23;
    L48:
        String r9 = r6.a;     // Catch: Throwable -> L87
        JSONArray r10 = (JSONArray) r2.get(r9);     // Catch: Throwable -> L87
        if (r7 != null) goto L51;
    L60:
        r7 = r10;
    L61:
        r2.put(r9, r7);     // Catch: Throwable -> L87
        goto L17
    L51:
        if (r7.length() <= 0) goto L60;
        if (r10 == null) goto L61;
        if (r10.length() <= 0) goto L61;
    L58:
        if (r8 >= r7.length()) goto L60;
        r10.put(r7.optJSONObject(r8));     // Catch: Throwable -> L87
        r8 = r8 + 1;     // Catch: Throwable -> L87
        goto L58
    L23:
        if (r7.length() <= 0) goto L48;
        int r11 = 0;
    L26:
        if (r11 >= r7.length()) goto L48;
        JSONObject r12 = r7.optJSONObject(r11);     // Catch: Throwable -> L87
        if (r12 == null) goto L47;
        Iterator<String> r13 = r12.keys();     // Catch: Throwable -> L87
    L31:
        if (r13.hasNext() == false) goto L47;
        String r14 = r13.next();     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r14) == true) goto L31;
        List<String> r15 = this.d;     // Catch: Throwable -> L87
        if (r15 == null) goto L39;
        if (((CopyOnWriteArrayList) r15).contains(r14) == false) goto L39;
    L40:
        String r16 = r12.optString(r14);     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r16) == true) goto L31;
        if (r16.contains("?") == false) goto L31;
        ita.j.b("EventVerifyWrapper original value = " + r16, null);     // Catch: Throwable -> L87
        String r17 = Uri.encode(r16);     // Catch: Throwable -> L87
        ita.j.b("EventVerifyWrapper encode value = " + r17, null);     // Catch: Throwable -> L87
        r12.put(r14, r17);     // Catch: JSONException -> L91 Throwable -> L87
    L39:
        if (r14.contains("url") == false) goto L31;
    L47:
        r11 = r11 + 1;
        goto L26
    L96:
        String r18 = c0.b(UriProtector.parse(this.a).buildUpon().toString(), true);     // Catch: Throwable -> L75
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L75
        r19.put("header", AppLog.g0.m());     // Catch: Throwable -> L75
        r19.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Throwable -> L75
        r19.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L75
        AppLog.g0.e(null).getClass();     // Catch: Throwable -> L75
        r19.put("time_sync", AppLog.g0.C());     // Catch: Throwable -> L75
        Iterator r3 = r2.entrySet().iterator();     // Catch: Throwable -> L75
    L65:
        if (r3.hasNext() == false) goto L69;
        Map.Entry r20 = (Map.Entry) r3.next();     // Catch: Throwable -> L75
        if (r20 == null) goto L65;
        r19.put((String) r20.getKey(), r20.getValue());     // Catch: Throwable -> L75
        goto L65
    L69:
        byte[] r21 = r19.toString().getBytes("UTF-8");     // Catch: Throwable -> L75
        ConcurrentHashMap r22 = AppLog.G0;     // Catch: Throwable -> L75
        if (AppLog.t() == false) goto L72;
        String r23 = c0.h(AppLog.s(), r18, r21, null, false, null, r22, false, false);     // Catch: Throwable -> L75
    L73:
        ita.j.b("EventVerifyWrapper send event verify resp: " + r23, null);     // Catch: Throwable -> L75
    L79:
        if (this.c <= 0) goto L100;
        Thread.sleep(this.c);     // Catch: InterruptedException -> L82 Throwable -> L87
    L82:
        e = move-exception;
        ita.j.c("EventVerifyWrapper wait next event verify exception", e);     // Catch: Throwable -> L87
        goto L100
    L72:
        r23 = c0.e(AppLog.s(), r18, r21, false, "application/octet-stream;tt-data=b", r22, false, false);     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        ita.j.c("EventVerifyWrapper send event verify", th);     // Catch: Throwable -> L87
        goto L79
    L136:
        return;
    L4:
        ita.j.b("EventVerifyWrapper interrupted", null);     // Catch: Throwable -> L87
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final boolean isEnable() {
        return this.b;
    }

    public final void setEventVerifyInterval(long r4) {
        if (r4 < 0) goto L6;
        this.c = r4;
        return;
    }

    public final void setEventVerifyUrl(String r2) {
        this.a = r2 + "/service/2/app_log_test/";
    }

    public final void setSpecialKeys(List<String> r2) {
        this.d = new CopyOnWriteArrayList(r2);
    }

    public final void loginEtWithScheme(String r5, Context r6) {
        if (TextUtils.isEmpty(r5) == false) goto L14;
        ita.j.c("EventVerifyWrapper login et", new RuntimeException("scheme is null"));
        return;
    L14:
        Uri r7 = UriProtector.parse(r5);     // Catch: Throwable -> L9
        String r0 = UriProtector.getQueryParameter(r7, "report_interval");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r0) == false) goto L16;
    L7:
        Uri.Builder r8 = UriProtector.parse(UriProtector.getQueryParameter(r7, "callback_url")).buildUpon();     // Catch: Throwable -> L9
        boolean r2 = AppLog.L;     // Catch: Throwable -> L9
        r8.appendQueryParameter("app_id", String.valueOf(g.c()));     // Catch: Throwable -> L9
        r8.appendQueryParameter("device_id", AppLog.v());     // Catch: Throwable -> L9
        r8.appendQueryParameter("device_model", Build.MODEL);     // Catch: Throwable -> L9
        new ThreadPlus(new a(this, r8.build().toString(), r6), "EventVerifyWrapper", true).start();     // Catch: Throwable -> L9
        return;
    L16:
        setEventVerifyInterval(CastLongProtector.parseLong(r0));     // Catch: NumberFormatException -> L13 Throwable -> L9
    L9:
        th = move-exception;
        ita.j.c("EventVerifyWrapper login et", th);
    }

    public final void putEvent(String r3, JSONArray r4) {
        if (this.b == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.length() <= 0) goto L15;
        this.e.add(new b(r3, r4));
        return;
    L15:
        return;
    }

    public final void setEnable(boolean r2, Context r3) {
        if (this.b != r2) goto L5;
        return;
    L5:
        this.b = r2;
        if (this.b == false) goto L9;
        new ThreadPlus(this, "EventVerifyWrapper", true).start();
        return;
    }
}
