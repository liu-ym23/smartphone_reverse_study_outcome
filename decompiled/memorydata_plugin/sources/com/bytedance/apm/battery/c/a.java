package com.bytedance.apm.battery.c;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.battery.d.l;
import com.bytedance.apm.e.e;
import com.bytedance.apm.util.i;
import com.bytedance.bdlocation.trace.TraceCons;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1140b;
    private com.bytedance.apm.battery.dao.a.a c;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.c.a$a, reason: collision with other inner class name */
    private static class C0083a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1142a = null;

        static {
            f1142a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1142a;
        }
    }

    private a() {
        this.f1139a = "";
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return C0083a.a();
    }

    private List<com.bytedance.apm.c.a> a(boolean r1, long r2) {
        return d().a(r1, r2);
    L5:
        return Collections.emptyList();
    }

    private void a(long r1) {
        d().a(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "cleanBatteryLog");
    }

    static /* synthetic */ void a(a r0) {
        r0.c();
    }

    private boolean a(b r7, List<com.bytedance.apm.c.a> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap(4);
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L20;
        com.bytedance.apm.c.a r2 = (com.bytedance.apm.c.a) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.apm.c.a.class, "com.obric.memorydata.plugin");
        String r3 = r2.g();
        List r4 = (List) ZeusTransformUtils.preCheckCast(r0.get(r3), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        LinkedList r5 = new LinkedList();
        r5.add(r2);
        r0.put(r3, r5);
        goto L4
    L7:
        r4.add(r2);
        goto L4
    L20:
        Iterator r1 = r0.values().iterator();     // Catch: Exception -> L17
        boolean r6 = true;
    L12:
        if (r1.hasNext() == false) goto L33;
        if (b(r7, (List) ZeusTransformUtils.preCheckCast(r1.next(), List.class, "com.obric.memorydata.plugin")) == true) goto L12;
        r6 = false;
        goto L12
    L33:
        return r6;
    L17:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "divideBySceneAndReport");
        return false;
    }

    private void b(com.bytedance.apm.c.a r4) {
        if (TextUtils.isEmpty(this.f1140b) == false) goto L5;
        this.f1140b = String.valueOf(System.currentTimeMillis());
    L5:
        r4.b(com.bytedance.apm.b.f());
        r4.b(com.bytedance.apm.b.e());
        r4.c(this.f1140b);
        if (r4.a() == false) goto L8;
        String r0 = this.f1139a;
    L10:
        if (TextUtils.isEmpty(r4.g()) == true) goto L13;
        r0 = r4.g() + "#" + r0;
    L13:
        r4.a(r0);
        c(r4);
        d(r4);
        return;
    L8:
        r0 = TraceCons.METRIC_BACKGROUND;
        goto L10
    }

    private boolean b(b r6, List<com.bytedance.apm.c.a> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L25;
        com.bytedance.apm.c.a r3 = (com.bytedance.apm.c.a) ZeusTransformUtils.preCheckCast(r9.next(), com.bytedance.apm.c.a.class, "com.obric.memorydata.plugin");
        if (r3.c() == true) goto L7;
        r2.add(r3);
        goto L4
    L7:
        r0.add(r3);
        goto L4
    L25:
    L22:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "divideByChargingStatusAndReport");
        return false;
    L11:
        if (r0.isEmpty() == false) goto L13;
    L15:
        boolean r1 = true;
    L17:
        if (r2.isEmpty() == true) goto L33;
        if (c(r6, r2) == true) goto L33;
        return false;
    L33:
        return r1;
    L13:
        if (c(r6, r0) == true) goto L15;
        r1 = false;
        goto L17
    }

    private void c() {
        if (com.bytedance.apm.b.f() == true) goto L5;
        return;
    L5:
        b r0 = new b();
        List<com.bytedance.apm.c.a> r1 = a(true, 0);
        if (i.a(r1) == false) goto L8;
        return;
    L8:
        boolean r2 = a(r0, r1);
        r0.e();
        com.bytedance.apm.c.a r3 = (com.bytedance.apm.c.a) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 1), com.bytedance.apm.c.a.class, "com.obric.memorydata.plugin");
        long r5 = r3.m();
        long r7 = r3.e();
        if (r2 == true) goto L16;
        if (com.bytedance.apm.b.k() == false) goto L13;
        e.b(com.bytedance.apm.e.b.f1308b, new String[]{"report main process data failed, clean data and stop calc data of other process"});
    L13:
        a(r5);
        return;
    L16:
        if (com.bytedance.apm.b.k() == false) goto L18;
        e.c(com.bytedance.apm.e.b.f1308b, new String[]{"report main process data over, begin handle other process data"});
    L18:
        List<com.bytedance.apm.c.a> r4 = a(false, r7);
        HashMap r6 = new HashMap(4);
        Iterator<com.bytedance.apm.c.a> r8 = r4.iterator();
    L20:
        if (r8.hasNext() == false) goto L34;
        com.bytedance.apm.c.a r9 = (com.bytedance.apm.c.a) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.apm.c.a.class, "com.obric.memorydata.plugin");
        String r10 = r9.j();
        List r11 = (List) ZeusTransformUtils.preCheckCast(r6.get(r10), List.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L23;
        LinkedList r12 = new LinkedList();
        r12.add(r9);
        r6.put(r10, r12);
        goto L20
    L23:
        r11.add(r9);
        goto L20
    L34:
        Iterator r13 = r6.values().iterator();     // Catch: Exception -> L30
    L27:
        if (r13.hasNext() == false) goto L32;
        a(r0, (List) ZeusTransformUtils.preCheckCast(r13.next(), List.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L30
        r0.e();     // Catch: Exception -> L30
    L32:
        r0.b();
        a(r5);
        com.bytedance.apm.e.a.b("APM-Battery", "Report Data All Success");
        return;
    L30:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "reportLastTimeBattery");
        goto L32
    }

    private void c(com.bytedance.apm.c.a r2) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        if (r2.a() == true) goto L10;
        r2.a(false);
        return;
    }

    private boolean c(b r8, List<com.bytedance.apm.c.a> r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Map<String, l> r10 = com.bytedance.apm.battery.a.a().f();
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = r7.iterator();
        String r3 = null;
    L4:
        if (r2.hasNext() == false) goto L19;
        com.bytedance.apm.c.a r4 = (com.bytedance.apm.c.a) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.apm.c.a.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
    L9:
        r3 = r4.l();
        r1.append(r3);
    L11:
        if ("ground_record".equals(r4.f1245b) == true) goto L13;
        l r5 = (l) ZeusTransformUtils.preCheckCast(r10.get(r4.f1245b), l.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L4;
        r5.a(r8, r4);
        goto L4
    L13:
        if (r4.a() == true) goto L14;
        r8.a(r4.d());
        goto L4
    L14:
        r8.j(r4.d());
        goto L4
    L8:
        if (r3.equals(r4.l()) == true) goto L11;
    L19:
        com.bytedance.apm.c.a r11 = (com.bytedance.apm.c.a) ZeusTransformUtils.preCheckCast(r7.get(0), com.bytedance.apm.c.a.class, "com.obric.memorydata.plugin");
        r8.a(r11.k());
        r8.a(r11.j());
        r8.b(r1.toString());
        r8.c(r11.g());
        r8.b(r11.c());
        com.bytedance.apm.e.a.b("APM-Battery", "Report Data proc:" + r11.j() + " scene:" + r11.g() + " size:" + r7.size());
        return r8.c(true);
    }

    private com.bytedance.apm.battery.dao.a.a d() {
        if (this.c != null) goto L6;
        this.c = com.bytedance.apm.battery.dao.a.a.e();
    L6:
        return this.c;
    }

    private void d(com.bytedance.apm.c.a r6) {
    L7:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "saveBatteryLog");
        return;
    L3:
        if (com.bytedance.apm.b.k() == false) goto L5;
        e.c(com.bytedance.apm.e.b.f1308b, new String[]{"saveBatteryLog into db: " + r6});     // Catch: Exception -> L7
    L5:
        com.bytedance.apm.e.a.b("APM-BatteryLocal", e(r6));     // Catch: Exception -> L7
        d().a(r6);     // Catch: Exception -> L7
    }

    private String e(com.bytedance.apm.c.a r7) {
        JSONObject r6 = r7.n();
        if (TextUtils.equals(r7.getType(), "cpu_active_time") == false) goto L7;
        long r2 = r7.d() * 1000;
        long r4 = com.bytedance.apm.util.b.a(100);
    L5:
        r2 = r2 / r4;
    L6:
        r6.put("accumulation", r2);
        return r6.toString();
    L7:
        boolean r0 = TextUtils.equals(r7.getType(), "traffic");
        r2 = r7.d();
        if (r0 == false) goto L6;
        r4 = 1024;
        goto L5
    }

    public void a(com.bytedance.apm.c.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        b(r1);
    }

    public void a(String r1) {
        this.f1139a = r1;
    }

    public void a(boolean r2) {
        if (r2 == false) goto L9;
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(this));
        return;
    L9:
        c();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.bytedance.services.apm.api.a.a(th, "handleReportAndHandleCache");
    }

    public String b() {
        return this.f1139a;
    }
}
