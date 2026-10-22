package com.bytedance.crash.upload;

import ai.j0;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.util.ListMap;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static volatile int d = 30;
    public static volatile int e = 100;
    public static final ListMap f = null;
    public static final HashMap g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile n f4143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f4144i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l9.u f4145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f4146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a6.a f4147c;

    static {
        f = new EventUploadQueue$1();
        g = new HashMap();
        f4144i = z8.d.f23419b;
    }

    public n() {
        this.f4147c = new a6.a(this, 9);
        this.f4145a = l9.o.e();
    }

    public static n a() {
        if (f4143h != null) goto L16;
        monitor-enter(n.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f4143h != null) goto L11;
        f4143h = new n();     // Catch: Throwable -> L9
    L11:
        monitor-exit(n.class);     // Catch: Throwable -> L9
    L16:
        return f4143h;
    }

    public static void b(n r11) {
        l9.u r5 = r11.f4145a;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r11.f4146b == false) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L10:
        r11.f4146b = true;     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        LinkedList r10 = new LinkedList();
        Iterator r12 = f.entrySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L56;
        Map.Entry r13 = (Map.Entry) r12.next();
        List r14 = (List) r13.getValue();
        Object r15 = ((m) r13.getKey()).f4141a;
        int r16 = ((m) r13.getKey()).f4142b;
    L17:
        if (r14.isEmpty() == true) goto L14;
        int r17 = 0;
    L61:
        if (r17 >= d) goto L28;
        if (r14.isEmpty() == true) goto L28;
        r10.add(r14.remove(0));     // Catch: Throwable -> L25
        r17 = r17 + 1;     // Catch: Throwable -> L25
    L28:
        if (r10.isEmpty() == true) goto L14;
        l9.l.f().getClass();     // Catch: Throwable -> L25
        z8.c r18 = l9.l.h(r10);     // Catch: Throwable -> L25
        if (r18 == null) goto L53;
        io.reactivex.exceptions.a.i("upload events");     // Catch: Throwable -> L25
        if (r15 != f4144i) goto L35;
        JSONArray r19 = null;
    L52:
        JSONObject r20 = r18.f23416a;     // Catch: Throwable -> L25
        k r21 = new k();     // Catch: Throwable -> L25
        r21.f4136a = r16;     // Catch: Throwable -> L25
        b.l(r20, r19, r21);     // Catch: Throwable -> L25
        goto L53
    L35:
        if (r16 != 0) goto L44;
        r19 = new JSONArray();     // Catch: Throwable -> L25
        Iterator r22 = z8.d.f23418a.iterator();     // Catch: Throwable -> L25
    L38:
        if (r22.hasNext() == false) goto L52;
        com.bytedance.crash.j r23 = (com.bytedance.crash.j) r22.next();     // Catch: Throwable -> L25
        if (r23 == null) goto L38;
        if (r23.f4055a != r15) goto L38;
        r19.put(r23.d(CrashType.JAVA));     // Catch: Throwable -> L25
        goto L52
    L44:
        r19 = new JSONArray();     // Catch: Throwable -> L25
        Iterator r24 = z8.d.f23418a.iterator();     // Catch: Throwable -> L25
    L46:
        if (r24.hasNext() == false) goto L52;
        com.bytedance.crash.j r25 = (com.bytedance.crash.j) r24.next();     // Catch: Throwable -> L25
        if (r25 == null) goto L46;
        if (r25.f4055a != r15) goto L46;
        r19.put(r25.b(CrashType.JAVA));     // Catch: Throwable -> L25
    L53:
        l9.i.a().f();     // Catch: Throwable -> L25
        r10.clear();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        goto L17
    L56:
        r11.f4146b = false;
    }

    public static void c(Object r21, z8.f r22) {
        if (com.bytedance.crash.p.f4084h == false) goto L6;
        return;
    L6:
        if (com.bytedance.crash.p.f4085i == false) goto L9;
        return;
    L9:
        if (f() == false) goto L19;
        HashMap r5 = g;
        if (r5.isEmpty() == true) goto L182;
        monitor-enter(r5);
        r5.clear();     // Catch: Throwable -> L16
        monitor-exit(r5);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L182:
        return;
    L19:
        if (r21 != null) goto L21;
        Object r10 = f4144i;
    L22:
        CrashType r11 = CrashType.CUSTOM_JAVA;
        String r12 = r22.f23416a.optString("event_type");
        if ((r22 instanceof z8.e) == false) goto L26;
        r11 = CrashType.EVENT;
    L30:
        if (s.m(z8.d.a(r10), r11) == true) goto L188;
        Handler r13 = l9.o.e().d;
        if (r13 != null) goto L35;
    L160:
        l9.o.e().b(new ab.b(7, r10, r22));
        return;
    L35:
        if (r13.getLooper() != Looper.myLooper()) goto L160;
        if (com.bytedance.crash.p.f4081a == false) goto L172;
        Object r14 = f4144i;
        if (r10 != r14) goto L49;
        ConcurrentLinkedQueue r15 = l9.c.f19554a;
        if (com.bytedance.crash.p.f4081a == false) goto L47;
        if (l9.c.e() != null) goto L49;
    L47:
        if ((System.currentTimeMillis() - com.bytedance.crash.n.f4059c) < 180000) goto L172;
    L49:
        n9.a r16 = null;
        if (r10 != r14) goto L52;
    L83:
        g();
        String r17 = r22.f23416a.optString("log_type");
        if ("service_monitor".equals(r17) == false) goto L91;
        String r18 = r22.f23416a.optString(NotificationCompat.CATEGORY_SERVICE);
        if (TextUtils.isEmpty(r18) == false) goto L88;
    L90:
        io.reactivex.exceptions.a.d("EventUploadQueue", "serviceName " + r18 + " not sampled");
        return;
    L88:
        if (l9.c.c(r10, r18) == false) goto L90;
        io.reactivex.exceptions.a.d("EventUploadQueue", "serviceName " + r18 + " enqueue success");
        e(r10, r22);
        return;
    L91:
        String r19 = r22.f23416a.optString("message");
        String r20 = r22.f23416a.optString("message_md5");
        if (TextUtils.isEmpty(r20) == true) goto L94;
    L97:
        String r23 = r22.f23416a.optString("crash_md5");
        l9.i r24 = l9.i.a();
        boolean r25 = r24.d(r23, r24.d, false);
        l9.i.c(r25);
        if (r25 == false) goto L137;
        if (r20 == null) goto L103;
        boolean r26 = r24.d(r20, r24.e, false);
        l9.i.c(r26);
        if (r26 == false) goto L137;
    L103:
        if (TextUtils.isEmpty(r17) == true) goto L135;
        ConcurrentLinkedQueue r27 = l9.c.f19554a;
        HashMap r28 = n9.a.f;
        String r29 = z8.d.a(r10);
        if (TextUtils.isEmpty(r29) == false) goto L107;
        n9.a r30 = null;
    L108:
        if (r30 != null) goto L110;
        boolean r31 = false;
    L111:
        if (r31 == false) goto L135;
        String r32 = z8.d.a(r10);
        if (TextUtils.isEmpty(r32) == true) goto L116;
        r16 = (n9.a) n9.a.f.get(r32);
    L116:
        if (r16 != null) goto L118;
        boolean r33 = false;
    L119:
        if (r33 == true) goto L122;
        io.reactivex.exceptions.a.i("exception has been discard (enqueue) due to message not sampled: " + r19);
        return;
    L122:
        l9.i r34 = l9.i.a();
        boolean r35 = r34.d(r23, r34.d, false);
        l9.i.c(r35);
        if (r35 == false) goto L133;
        if (r20 == null) goto L127;
        boolean r36 = r34.d(r20, r34.e, false);
        l9.i.c(r36);
        if (r36 == false) goto L133;
    L127:
        boolean r37 = r34.d("exception", r34.f19569c, false);
        l9.i.c(r37);
        if (r37 == false) goto L133;
        l9.i.c(r34.d(r23, r34.d, true));
        if (r20 == null) goto L132;
        l9.i.c(r34.d(r20, r34.e, true));
    L132:
        l9.i.c(r34.d("exception", r34.f19569c, true));
        io.reactivex.exceptions.a.d("EventUploadQueue", j0.l("logType ", r17, " message ", r19, " enqueue success"));
        e(r10, r22);
        return;
    L133:
        io.reactivex.exceptions.a.l("exception has been discard (enqueue) due to exceed limit: " + r17);
        return;
    L118:
        r33 = r16.b(r19);
        goto L119
    L110:
        r31 = r30.c(r17);
        goto L111
    L107:
        r30 = (n9.a) n9.a.f.get(r29);
    L135:
        io.reactivex.exceptions.a.d("EventUploadQueue", "logType " + r17 + " not sampled");
        return;
    L137:
        io.reactivex.exceptions.a.l("exception has been discard (enqueue) due to exceed limit: " + r17);
        return;
    L94:
        if (TextUtils.isEmpty(r19) == false) goto L96;
        r20 = null;
        goto L97
    L96:
        r20 = com.bytedance.crash.util.d.b(r19);
        goto L97
    L52:
        if (n9.a.f.get(z8.d.a(r10)) == null) goto L56;
        if (b.o(z8.d.a(r10)) == false) goto L83;
    L56:
        if (b.o(z8.d.a(r10)) == false) goto L83;
        if (com.bytedance.ies.bullet.base.utils.b.n(com.bytedance.crash.n.f4057a) == false) goto L83;
        String r38 = com.bytedance.crash.n.f4062j.getApmConfigUrl();     // Catch: Throwable -> L77
        Iterator r39 = z8.d.f23418a.iterator();     // Catch: Throwable -> L77
    L61:
        if (r39.hasNext() == false) goto L67;
        com.bytedance.crash.j r40 = (com.bytedance.crash.j) r39.next();     // Catch: Throwable -> L77
        if (r40 == null) goto L61;
        if (r40.f4055a != r10) goto L61;
        JSONObject r41 = r40.c();     // Catch: Throwable -> L77
    L68:
        String[] r42 = {WsConstants.KEY_APP_ID, "4444", "crash", "npth", "os", "Android", "update_version_code", "000000", LynxMonitorService.KEY_CHANNEL, "unknown", "app_version", "0.0.0", WsConstants.KEY_DEVICE_ID, com.bytedance.crash.n.g().e()};     // Catch: Throwable -> L77
        HashMap r43 = new HashMap();     // Catch: Throwable -> L77
        if (r41 == null) goto L75;
        Iterator<String> r44 = r41.keys();     // Catch: Throwable -> L77
    L73:
        if (r44.hasNext() == false) goto L75;
        String r45 = r44.next();     // Catch: Throwable -> L77
        r43.put(r45, r41.opt(r45));     // Catch: Throwable -> L77
    L75:
        byte[] r46 = (byte[]) b.c(b.h(r38, i4.a.j(r43, r42)), null, "application/json; charset=utf-8", "gzip", "GET", false).e;     // Catch: Throwable -> L77
    L78:
        if (r46 == null) goto L83;
        JSONObject r47 = new JSONObject(new String(r46)).optJSONObject("ret");     // Catch: Throwable -> L163
        String r48 = z8.d.a(r10);     // Catch: Throwable -> L163
        JSONArray r49 = new JSONArray();     // Catch: Throwable -> L163
        JSONObject r50 = new JSONObject();     // Catch: Throwable -> L163
        r50.put(r48, r47);     // Catch: JSONException -> L162 Throwable -> L163
        r49.put(r50);     // Catch: JSONException -> L162 Throwable -> L163
    L82:
        l9.c.a(r49, true);     // Catch: Throwable -> L163
        io.reactivex.exceptions.a.i("success fetchAidConfig net");     // Catch: Throwable -> L163
        goto L83
    L67:
        r41 = null;
    L77:
        r46 = null;
    L172:
        String r51 = r22.f23416a.getString("log_type");     // Catch: JSONException -> L154
        HashMap r52 = g;     // Catch: JSONException -> L154
        monitor-enter(r52);     // Catch: JSONException -> L154
        ConcurrentHashMap r53 = (ConcurrentHashMap) r52.get(m.a(r10, r22));     // Catch: Throwable -> L144
        if (r53 != null) goto L146;
        r53 = new ConcurrentHashMap();     // Catch: Throwable -> L144
        r52.put(m.a(r10, r22), r53);     // Catch: Throwable -> L144
    L146:
        LinkedList r54 = (LinkedList) r53.get(r51);     // Catch: Throwable -> L144
        if (r54 != null) goto L149;
        r54 = new LinkedList();     // Catch: Throwable -> L144
        r53.put(r51, r54);     // Catch: Throwable -> L144
    L149:
        monitor-exit(r52);     // Catch: Throwable -> L144
        r54.add(r22);     // Catch: JSONException -> L154
        if (r54.size() <= e) goto L189;
        r54.poll();     // Catch: JSONException -> L154
        return;
    L189:
        return;
    L144:
        th = move-exception;
        throw th;     // Catch: JSONException -> L154
    L154:
        e = move-exception;
        e.printStackTrace();
        return;
    L188:
        return;
    L26:
        if (r12.equals("native_exception") == false) goto L28;
        r11 = CrashType.CUSTOM_NATIVE;
        goto L30
    L28:
        r12.equals("exception");
        goto L30
    L21:
        r10 = r21;
        goto L22
    }

    public static void d(z8.f r5, Object r10, long r11, File r12) {
        LinkedList r13 = new LinkedList();
        r13.add(r5);
        l9.l.f().getClass();
        JSONObject r14 = l9.l.h(r13).f23416a;
        if (r10 != f4144i) goto L5;
        JSONArray r15 = null;
    L14:
        b.l(r14, r15, new l(r12, r11, 0));
        return;
    L5:
        JSONArray r16 = new JSONArray();
        Iterator r17 = z8.d.f23418a.iterator();
    L7:
        if (r17.hasNext() == false) goto L13;
        com.bytedance.crash.j r18 = (com.bytedance.crash.j) r17.next();
        if (r18 == null) goto L7;
        if (r18.f4055a != r10) goto L7;
        r16.put(r18.d(CrashType.JAVA));
    L13:
        r15 = r16;
        goto L14
    }

    public static void e(Object r5, z8.f r10) {
        List r11 = f.a(m.a(r5, r10));
        r11.add(r10);
        int r12 = r11.size();
        if (r12 < d) goto L5;
        boolean r13 = true;
    L6:
        io.reactivex.exceptions.a.c("[enqueue] size=" + r12);
        if (r13 == true) goto L9;
        return;
    L9:
        if (com.bytedance.crash.p.f4081a == true) goto L11;
        return;
    L11:
        if (com.bytedance.crash.p.f4084h == true) goto L20;
        l9.o.e().b(new com.bytedance.android.anniex.worker.a(7));     // Catch: Throwable -> L15
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r13 = false;
        goto L6
    }

    public static boolean f() {
        if (d > 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void g() {
        HashMap r5 = g;
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (com.bytedance.crash.p.f4081a == false) goto L37;
        ConcurrentLinkedQueue r10 = l9.c.f19554a;
        if (com.bytedance.crash.p.f4081a == false) goto L13;
        if (l9.c.e() == null) goto L13;
    L15:
        monitor-enter(r5);
        HashMap r11 = new HashMap(r5);     // Catch: Throwable -> L34
        r5.clear();     // Catch: Throwable -> L34
        monitor-exit(r5);     // Catch: Throwable -> L34
        if (f() == true) goto L51;
        Iterator r12 = r11.entrySet().iterator();
    L23:
        if (r12.hasNext() == false) goto L52;
        Map.Entry r13 = (Map.Entry) r12.next();
        Iterator r14 = ((ConcurrentHashMap) r13.getValue()).entrySet().iterator();
    L26:
        if (r14.hasNext() == false) goto L23;
        LinkedList r15 = (LinkedList) ((Map.Entry) r14.next()).getValue();
    L29:
        if (r15.isEmpty() == true) goto L26;
        z8.f r16 = (z8.f) r15.poll();     // Catch: Throwable -> L38
        if (r16 == null) goto L26;
        c(((m) r13.getKey()).f4141a, r16);     // Catch: Throwable -> L38
    L52:
        return;
    L51:
        return;
    L34:
        th = move-exception;
        throw th;
    L13:
        if ((System.currentTimeMillis() - com.bytedance.crash.n.f4059c) >= 180000) goto L15;
        return;
    }
}
