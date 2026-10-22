package p;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.apm.util.j;
import e0.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import q.l;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n.a f12283c;

    /* JADX INFO: renamed from: p.a$a, reason: collision with other inner class name */
    class RunnableC0274a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f12284c;

        RunnableC0274a(a r10) {
            this.f12284c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f12284c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            t4.a.d(th, "handleReportAndHandleCache");
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f12285a = null;

        static {
            f12285a = new a(null);
        }

        static /* synthetic */ a a() {
            return f12285a;
        }
    }

    private a() {
        this.f12281a = "";
    }

    /* synthetic */ a(RunnableC0274a r10) {
        this();
    }

    static /* synthetic */ void a(a r10) {
        r10.n();
    }

    private void b(long r10) {
        f().n(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        t4.a.d(e, "cleanBatteryLog");
    }

    private boolean c(p.b r10, List<b0.a> r11) {
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator<b0.a> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L25;
        b0.a r15 = r14.next();
        if (r15.m() == true) goto L7;
        r13.add(r15);
        goto L4
    L7:
        r12.add(r15);
        goto L4
    L25:
    L22:
        e = move-exception;
        t4.a.d(e, "divideByChargingStatusAndReport");
        return false;
    L11:
        if (r12.isEmpty() == false) goto L13;
    L15:
        boolean r16 = true;
    L17:
        if (r13.isEmpty() == true) goto L33;
        if (m(r10, r13) == true) goto L33;
        return false;
    L33:
        return r16;
    L13:
        if (m(r10, r12) == true) goto L15;
        r16 = false;
        goto L17
    }

    private boolean d(p.b r10, List<b0.a> r11) {
        HashMap r12 = new HashMap(4);
        Iterator<b0.a> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L20;
        b0.a r14 = r13.next();
        String r15 = r14.d();
        List r16 = (List) r12.get(r15);
        if (r16 != null) goto L7;
        LinkedList r17 = new LinkedList();
        r17.add(r14);
        r12.put(r15, r17);
        goto L4
    L7:
        r16.add(r14);
        goto L4
    L20:
        Iterator r18 = r12.values().iterator();     // Catch: Exception -> L17
        boolean r19 = true;
    L12:
        if (r18.hasNext() == false) goto L33;
        if (c(r10, (List) r18.next()) == true) goto L12;
        r19 = false;
        goto L12
    L33:
        return r19;
    L17:
        e = move-exception;
        t4.a.d(e, "divideBySceneAndReport");
        return false;
    }

    private List<b0.a> e(boolean r10, long r11) {
        return f().l(r10, r11);
    L5:
        return Collections.emptyList();
    }

    private n.a f() {
        if (this.f12283c != null) goto L6;
        this.f12283c = n.a.k();
    L6:
        return this.f12283c;
    }

    public static a h() {
        return b.a();
    }

    private void i(b0.a r10) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        if (r10.k() == true) goto L10;
        r10.t(false);
        return;
    }

    private void j(b0.a r10) {
        if (TextUtils.isEmpty(this.f12282b) == false) goto L5;
        this.f12282b = String.valueOf(System.currentTimeMillis());
    L5:
        r10.p(d.I());
        r10.q(d.h());
        r10.s(this.f12282b);
        if (r10.k() == false) goto L8;
        String r11 = this.f12281a;
    L10:
        if (TextUtils.isEmpty(r10.d()) == true) goto L13;
        r11 = r10.d() + "#" + r11;
    L13:
        r10.r(r11);
        i(r10);
        o(r10);
        return;
    L8:
        r11 = "background";
        goto L10
    }

    private boolean m(p.b r10, List<b0.a> r11) {
        Map<String, l> r12 = k.a.G().D();
        StringBuilder r13 = new StringBuilder();
        Iterator<b0.a> r14 = r11.iterator();
        String r15 = null;
    L4:
        if (r14.hasNext() == false) goto L19;
        b0.a r16 = r14.next();
        if (r15 != null) goto L8;
    L9:
        r15 = r16.f();
        r13.append(r15);
    L11:
        if ("ground_record".equals(r16.f494d) == true) goto L13;
        l r17 = r12.get(r16.f494d);
        if (r17 == null) goto L4;
        r17.e(r10, r16);
        goto L4
    L13:
        if (r16.k() == true) goto L14;
        r10.c(r16.a());
        goto L4
    L14:
        r10.m(r16.a());
        goto L4
    L8:
        if (r15.equals(r16.f()) == true) goto L11;
    L19:
        b0.a r18 = r11.get(0);
        r10.C(r18.l());
        r10.D(r18.c());
        r10.F(r13.toString());
        r10.E(r18.d());
        r10.B(r18.m());
        e0.a.d("APM-Battery", "Report Data proc:" + r18.c() + " scene:" + r18.d() + " size:" + r11.size());
        return r10.z(true);
    }

    private void n() {
        if (d.I() == true) goto L5;
        return;
    L5:
        p.b r10 = new p.b();
        List<b0.a> r11 = e(true, 0);
        if (j.b(r11) == false) goto L8;
        return;
    L8:
        boolean r12 = d(r10, r11);
        r10.y();
        b0.a r13 = r11.get(r11.size() - 1);
        long r14 = r13.b();
        long r15 = r13.g();
        if (r12 == true) goto L16;
        if (d.D() == false) goto L13;
        e.g(e0.b.f8548b, new String[]{"report main process data failed, clean data and stop calc data of other process"});
    L13:
        b(r14);
        return;
    L16:
        if (d.D() == false) goto L18;
        e.d(e0.b.f8548b, new String[]{"report main process data over, begin handle other process data"});
    L18:
        List<b0.a> r16 = e(false, r15);
        HashMap r17 = new HashMap(4);
        Iterator<b0.a> r18 = r16.iterator();
    L20:
        if (r18.hasNext() == false) goto L34;
        b0.a r19 = r18.next();
        String r20 = r19.c();
        List r21 = (List) r17.get(r20);
        if (r21 != null) goto L23;
        LinkedList r22 = new LinkedList();
        r22.add(r19);
        r17.put(r20, r22);
        goto L20
    L23:
        r21.add(r19);
        goto L20
    L34:
        Iterator r23 = r17.values().iterator();     // Catch: Exception -> L30
    L27:
        if (r23.hasNext() == false) goto L32;
        d(r10, (List) r23.next());     // Catch: Exception -> L30
        r10.y();     // Catch: Exception -> L30
    L32:
        r10.A();
        b(r14);
        e0.a.d("APM-Battery", "Report Data All Success");
        return;
    L30:
        e = move-exception;
        t4.a.d(e, "reportLastTimeBattery");
        goto L32
    }

    private void o(b0.a r10) {
    L7:
        e = move-exception;
        t4.a.d(e, "saveBatteryLog");
        return;
    L3:
        if (d.D() == false) goto L5;
        e.d(e0.b.f8548b, new String[]{"saveBatteryLog into db: " + r10});     // Catch: Exception -> L7
    L5:
        e0.a.d("APM-BatteryLocal", q(r10));     // Catch: Exception -> L7
        f().m(r10);     // Catch: Exception -> L7
    }

    private String q(b0.a r10) {
        JSONObject r11 = r10.v();
        if (TextUtils.equals(r10.h(), "cpu_active_time") == false) goto L7;
        long r12 = r10.a() * 1000;
        long r13 = com.bytedance.apm.util.b.k(100);
    L5:
        r12 = r12 / r13;
    L6:
        r11.put("accumulation", r12);
        return r11.toString();
    L7:
        boolean r14 = TextUtils.equals(r10.h(), "traffic");
        r12 = r10.a();
        if (r14 == false) goto L6;
        r13 = 1024;
        goto L5
    }

    public String g() {
        return this.f12281a;
    }

    public void k(boolean r10) {
        if (r10 == false) goto L9;
        q0.b.f().i(new RunnableC0274a(this));
        return;
    L9:
        n();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        t4.a.d(th, "handleReportAndHandleCache");
    }

    public void l(b0.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        j(r10);
    }

    public void p(String r10) {
        this.f12281a = r10;
    }
}
