package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class b {
    private static b a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private List<Serializable> i;
    private List<Serializable> j;
    private Executor k;
    private boolean l;

    public static synchronized b a() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new b();     // Catch: Throwable -> L10
    L7:
        b r1 = a;     // Catch: Throwable -> L10
        monitor-exit(b.class);
        return r1;
    }

    private void c() {
    L3:
        if (this.j.isEmpty() == true) goto L5;
        c r0 = (c) ListProtector.remove(this.j, 0);
        r0.a.put("appid", this.b);
        r0.a.put("app_name", this.c);
        r0.a.put("app_ver", this.e);
        r0.a.put("pkg_name", this.f);
        r0.a.put("qq_install", this.g);
        r0.a.put("qq_ver", this.h);
        r0.a.put("openid", this.d);
        r0.a.put("time_appid_openid", r0.a.get("time") + "_" + this.b + "_" + this.d);
        StringBuilder r1 = new StringBuilder("fixDirtyData--------------------------");
        r1.append(r0);
        SLog.i("AttaReporter", r1.toString());
        this.i.add(r0);
        goto L3
    }

    private void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (this.l == true) goto L8;
        List<Serializable> r0 = g.b("report_atta");
        this.l = r0.isEmpty();
        this.i.addAll(r0);
        Iterator<Serializable> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        SLog.i("AttaReporter", "attaReportAtSubThread from db = " + r1.next());
    L8:
        ArrayList r2 = new ArrayList();
    L10:
        if (this.i.isEmpty() == true) goto L15;
        c r3 = (c) ListProtector.remove(this.i, 0);
        if (b(r3) == true) goto L10;
        r2.add(r3);
        goto L10
    L15:
        if (r2.isEmpty() == true) goto L22;
        SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + r2.size());
        Iterator r4 = r2.iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) r4.next())));
        goto L18
    L20:
        g.a("report_atta", r2);
        this.l = false;
        return;
    L22:
        if (this.l == true) goto L33;
        SLog.i("AttaReporter", "attaReportAtSubThread clear db");
        g.a("report_atta");
        this.l = true;
        return;
    }

    private b() {
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = Collections.synchronizedList(new ArrayList());
        this.j = Collections.synchronizedList(new ArrayList());
        this.k = l.b();
    }

    public static String b() {
        return a().b;
    }

    private boolean b(c r8) {
        int r2 = 0;
    L3:
        r2 = r2 + 1;
        SLog.i("AttaReporter", "doAttaReportItem post " + r8);     // Catch: Exception -> L9
        if (com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", r8.a).d() != 200) goto L18;
        return true;
    L18:
        return false;
    L9:
        e = move-exception;
        SLog.i("AttaReporter", "Exception", e);
        if (r2 < 2) goto L3;
        return false;
    }

    public void a(String r3) {
        SLog.i("AttaReporter", "updateOpenId");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.d = r3;
    }

    private void a(final c r3) {
        this.k.execute(new AnonymousClass1(this, r3));
    }

    public static /* synthetic */ void b(b r0) {
        r0.d();
    }

    public static /* synthetic */ List a(b r0) {
        return r0.i;
    }

    public void a(String r3, Context r4) {
        SLog.i("AttaReporter", "init");
        this.b = r3;
        this.c = k.a(r4);
        this.e = m.d(r4, com.tencent.open.utils.g.b());
        this.f = com.tencent.open.utils.g.b();
        if (k.b(r4) == false) goto L5;
        String r5 = "1";
    L6:
        this.g = r5;
        this.h = m.c(r4, "com.tencent.mobileqq");
        c();
        g.a();
        return;
    L5:
        r5 = "0";
        goto L6
    }

    public void a(String r3, Object r4) {
        a(r3, "", r4, null);
    }

    public void a(String r2, String r3) {
        a(r2, r3, null);
    }

    public void a(String r2, String r3, Map<String, Object> r4) {
        a(r2, r3, "", r4);
    }

    private c b(String r7, String r8, Object r9, Map<String, Object> r10) {
        long r0 = System.currentTimeMillis();
        HashMap r2 = new HashMap();
        r2.put("attaid", "09400051119");
        r2.put("token", "9389887874");
        r2.put("time_appid_openid", r0 + "_" + this.b + "_" + this.d);
        r2.put("time", String.valueOf(r0));
        r2.put("openid", this.d);
        r2.put("appid", this.b);
        r2.put("app_name", this.c);
        r2.put("app_ver", this.e);
        r2.put("pkg_name", this.f);
        r2.put("os", "AND");
        r2.put("os_ver", Build.VERSION.RELEASE);
        r2.put("sdk_ver", "3.5.11.lite");
        r2.put("model_name", com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        r2.put("interface_name", r7);
        r2.put("interface_data", r8);
        String r11 = "";
        if (r9 != null) goto L5;
        String r12 = "";
    L6:
        r2.put("interface_result", r12);
        r2.put("qq_install", this.g);
        r2.put("qq_ver", this.h);
        if (r10 == null) goto L28;
        if (r10.isEmpty() == true) goto L28;
        Object r13 = r10.get("reserve1");
        if (r13 != null) goto L13;
        String r14 = "";
    L14:
        r2.put("reserve1", r14);
        Object r15 = r10.get("reserve2");
        if (r15 != null) goto L17;
        String r16 = "";
    L18:
        r2.put("reserve2", r16);
        Object r17 = r10.get("reserve3");
        if (r17 != null) goto L21;
        String r18 = "";
    L22:
        r2.put("reserve3", r18);
        Object r19 = r10.get("reserve4");
        if (r19 == null) goto L26;
        r11 = r19.toString();
    L26:
        r2.put("reserve4", r11);
        goto L28
    L21:
        r18 = r17.toString();
        goto L22
    L17:
        r16 = r15.toString();
        goto L18
    L13:
        r14 = r13.toString();
    L28:
        return new c(r2);
    L5:
        r12 = r9.toString();
        goto L6
    }

    public void a(String r1, String r2, Object r3, Map<String, Object> r4) {
        c r5 = b(r1, r2, r3, r4);
        if (TextUtils.isEmpty(this.b) == false) goto L5;
    L11:
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.b + ", mAppName=" + this.c + ", context=" + com.tencent.open.utils.g.a() + ", " + r5);
        this.j.add(r5);
        return;
    L5:
        if (TextUtils.isEmpty(this.c) == true) goto L11;
        if (com.tencent.open.utils.g.a() == null) goto L11;
        a(r5);
    }
}
