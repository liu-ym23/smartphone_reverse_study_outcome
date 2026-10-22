package com.bytedance.apm.block;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.monitor.collector.m;
import com.bytedance.monitor.collector.o;
import com.bytedance.sliver.Sliver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static long f787w = 1000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static boolean f788x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static boolean f789y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile l f790z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q0.e f791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final StringBuilder f799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final StringBuilder f800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final StringBuilder f801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.bytedance.apm.block.d f802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.bytedance.apm.block.d f803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LinkedList<y.d> f808r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f809s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private d0.c f810t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f811u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Runnable f812v;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f813c;

        a(l r10) {
            this.f813c = r10;
        }

        private void a(StackTraceElement[] r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            TimeoutException r11 = new TimeoutException("main thread task execute more than " + l.a(this.f813c) + "ms");
            r11.setStackTrace(r10);
            Logger.e("StackThread", "block detected", r11);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.b(this.f813c) != null) goto L43;
            return;
        L43:
            l.b(this.f813c).b();     // Catch: Throwable -> L40
            int r10 = 0;
            if (l.g(this.f813c) == false) goto L29;
            String r11 = Sliver.getStackTrace(Looper.getMainLooper().getThread());     // Catch: Throwable -> L40
            if (r11.contains(l.h(this.f813c)) == false) goto L11;
            return;
        L11:
            String[] r12 = r11.split("\\)\\n");     // Catch: Throwable -> L40
            l.i(this.f813c).setLength(0);     // Catch: Throwable -> L40
            int r13 = r12.length;     // Catch: Throwable -> L40
        L12:
            if (r10 >= r13) goto L25;
            String r14 = r12[r10];     // Catch: Throwable -> L40
            String r15 = "";
            char[] r16 = r14.toCharArray();     // Catch: Throwable -> L40
            if (r16 == null) goto L24;
            if (r16.length == 0) goto L24;
            if (r16[r16.length - 1] != '(') goto L23;
            String[] r17 = r14.split("\\.");     // Catch: Throwable -> L40
            int r18 = r17.length;     // Catch: Throwable -> L40
            if (r18 <= 2) goto L23;
            r15 = r17[r18 - 2];     // Catch: Throwable -> L40
        L23:
            StringBuilder r19 = l.i(this.f813c);     // Catch: Throwable -> L40
            r19.append("\tat " + r14);     // Catch: Throwable -> L40
            r19.append(r15);     // Catch: Throwable -> L40
            r19.append(".java:1");     // Catch: Throwable -> L40
            r19.append(")\n");     // Catch: Throwable -> L40
        L24:
            r10 = r10 + 1;     // Catch: Throwable -> L40
            goto L12
        L25:
            l.b(this.f813c).f766r = l.i(this.f813c).toString();     // Catch: Throwable -> L40
            if (com.bytedance.apm.d.D() == false) goto L49;
            Logger.e("StackThread", "block detected: " + l.i(this.f813c).toString());     // Catch: Throwable -> L40
            return;
        L49:
            return;
        L29:
            StackTraceElement[] r20 = Looper.getMainLooper().getThread().getStackTrace();     // Catch: Throwable -> L40
            if (r20[0].getClassName().startsWith(l.h(this.f813c)) == false) goto L32;
            return;
        L32:
            l.b(this.f813c).f762n = System.currentTimeMillis();     // Catch: Throwable -> L40
            l.b(this.f813c).f764p = r20;     // Catch: Throwable -> L40
            if (com.bytedance.apm.d.D() == false) goto L35;
            a(r20);     // Catch: Throwable -> L40
        L35:
            l.i(this.f813c).setLength(0);     // Catch: Throwable -> L40
            int r21 = r20.length;     // Catch: Throwable -> L40
        L36:
            if (r10 >= r21) goto L38;
            StackTraceElement r22 = r20[r10];     // Catch: Throwable -> L40
            StringBuilder r23 = l.i(this.f813c);     // Catch: Throwable -> L40
            r23.append("\tat " + r22.getClassName());     // Catch: Throwable -> L40
            r23.append(".");     // Catch: Throwable -> L40
            r23.append(r22.getMethodName());     // Catch: Throwable -> L40
            r23.append("(");     // Catch: Throwable -> L40
            r23.append(r22.getFileName());     // Catch: Throwable -> L40
            r23.append(":");     // Catch: Throwable -> L40
            r23.append(r22.getLineNumber());     // Catch: Throwable -> L40
            r23.append(")\n");     // Catch: Throwable -> L40
            r10 = r10 + 1;     // Catch: Throwable -> L40
            goto L36
        L38:
            l.b(this.f813c).f766r = l.i(this.f813c).toString();     // Catch: Throwable -> L40
            return;
        L40:
            th = move-exception;
            com.bytedance.apm.k.e().d(th, "block_deal_exception");
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f814c;

        b(l r10) {
            this.f814c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L31:
            th = move-exception;
            com.bytedance.apm.k.e().d(th, "serious_block_deal_exception");
            return;
        L3:
            if (l.b(this.f814c) != null) goto L5;
            return;
        L5:
            int r10 = 0;
            if (l.g(this.f814c) == false) goto L26;
            String r11 = Sliver.getStackTrace(Looper.getMainLooper().getThread());     // Catch: Throwable -> L31
            if (r11.contains(l.h(this.f814c)) == false) goto L10;
            return;
        L10:
            String[] r12 = r11.split("\\)\\n");     // Catch: Throwable -> L31
            l.j(this.f814c).setLength(0);     // Catch: Throwable -> L31
            int r13 = r12.length;     // Catch: Throwable -> L31
        L11:
            if (r10 >= r13) goto L24;
            String r14 = r12[r10];     // Catch: Throwable -> L31
            String r15 = "";
            char[] r16 = r14.toCharArray();     // Catch: Throwable -> L31
            if (r16 == null) goto L23;
            if (r16.length == 0) goto L23;
            if (r16[r16.length - 1] != '(') goto L22;
            String[] r17 = r14.split("\\.");     // Catch: Throwable -> L31
            int r18 = r17.length;     // Catch: Throwable -> L31
            if (r18 <= 2) goto L22;
            r15 = r17[r18 - 2];     // Catch: Throwable -> L31
        L22:
            StringBuilder r19 = l.j(this.f814c);     // Catch: Throwable -> L31
            r19.append("\tat " + r14);     // Catch: Throwable -> L31
            r19.append(r15);     // Catch: Throwable -> L31
            r19.append(".java:1");     // Catch: Throwable -> L31
            r19.append(")\n");     // Catch: Throwable -> L31
        L23:
            r10 = r10 + 1;     // Catch: Throwable -> L31
            goto L11
        L24:
            l.b(this.f814c).f766r = l.j(this.f814c).toString();     // Catch: Throwable -> L31
            l.b(this.f814c).f763o = System.currentTimeMillis();     // Catch: Throwable -> L31
            l.b(this.f814c).f770v = i0.d.b().a();     // Catch: Throwable -> L31
            l.b(this.f814c).f771w = l.k(this.f814c);     // Catch: Throwable -> L31
            l.b(this.f814c).f758j = true;     // Catch: Throwable -> L31
            return;
        L26:
            StackTraceElement[] r20 = Looper.getMainLooper().getThread().getStackTrace();     // Catch: Throwable -> L31
            if (r20[0].getClassName().startsWith(l.h(this.f814c)) == false) goto L29;
            return;
        L29:
            l.b(this.f814c).f763o = System.currentTimeMillis();     // Catch: Throwable -> L31
            l.b(this.f814c).f765q = r20;     // Catch: Throwable -> L31
            l.b(this.f814c).f770v = i0.d.b().a();     // Catch: Throwable -> L31
            l.b(this.f814c).f771w = l.k(this.f814c);     // Catch: Throwable -> L31
            l.b(this.f814c).f758j = true;     // Catch: Throwable -> L31
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.block.d f815c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f816g;

        c(l r10, com.bytedance.apm.block.d r11) {
            this.f816g = r10;
            this.f815c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.block.d r10 = this.f815c;
            if ((r10.f756h - r10.f755g) > l.l(this.f816g)) goto L5;
        L7:
            boolean r11 = false;
            if (this.f815c.f760l == true) goto L14;
            com.bytedance.apm.block.d r12 = this.f815c;
            if (r12.f766r == null) goto L14;
            if (r12.f761m == true) goto L14;
        L17:
            com.bytedance.apm.block.d r13 = this.f815c;
            if ((r13.f756h - r13.f755g) > l.l(this.f816g)) goto L20;
        L34:
            String r14 = o.b(this.f815c.f750b);     // Catch: Exception -> L33
            l r15 = this.f816g;     // Catch: Exception -> L33
            com.bytedance.apm.block.d r16 = this.f815c;     // Catch: Exception -> L33
            l.c(r15, r16.f752d, r16, r14);     // Catch: Exception -> L33
            if (this.f815c.f758j == true) goto L27;
        L31:
            l.f(this.f816g, this.f815c, r14);     // Catch: Exception -> L33
            return;
        L27:
            if (l.d(this.f816g) == false) goto L31;
            if (l.n(this.f816g) == false) goto L31;
            l.e(this.f816g, this.f815c, r14, r11);     // Catch: Exception -> L33
        L36:
            return;
        L20:
            if (this.f815c.f758j == true) goto L34;
            if (l.n(this.f816g) == false) goto L34;
            this.f815c.f771w = l.k(this.f816g);
            this.f815c.f770v = i0.d.b().a();
            this.f815c.f758j = true;
            r11 = true;
        L14:
            if (l.m(this.f816g) == false) goto L16;
            return;
        L16:
            this.f815c.f766r = "Invalid Stack\n";
            goto L17
        L5:
            if (o0.c.e(LogTypeName.MONITOR_TYPE_SERIOUS_BLOCK) == false) goto L7;
            com.bytedance.apm.block.d r17 = l.b(this.f816g);
            com.bytedance.monitor.collector.k r18 = com.bytedance.monitor.collector.k.n();
            com.bytedance.apm.block.d r19 = this.f815c;
            r17.f772x = r18.f(r19.f755g, r19.f756h);
            goto L7
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.block.d f817c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f819h;

        d(l r10, com.bytedance.apm.block.d r11, boolean r12) {
            this.f819h = r10;
            this.f817c = r11;
            this.f818g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new JSONObject();
            com.bytedance.monitor.collector.k r11 = com.bytedance.monitor.collector.k.n();
            com.bytedance.apm.block.d r12 = this.f817c;
            String r13 = r11.i(r12.f755g, r12.f756h);
            StringBuilder r14 = new StringBuilder();
            com.bytedance.apm.block.d r15 = this.f817c;
            long r16 = r15.f756h - r15.f755g;
            if (TextUtils.isEmpty(r13) == false) goto L5;
            return;
        L5:
            String r17 = m.c(r13, r14, 1000, r16);
            if (com.bytedance.apm.d.D() == false) goto L13;
            e0.g.c("StackThread", "%s", new Object[]{r13});
        L13:
            r10.put("stack", r14.toString());     // Catch: JSONException -> L10
            r10.put("stack_key", r17);     // Catch: JSONException -> L10
            r10.put("scene", this.f817c.f768t);     // Catch: JSONException -> L10
            r10.put("cost_time", r16);     // Catch: JSONException -> L10
            r10.put("method_time", r16);     // Catch: JSONException -> L10
            r10.put("monitor_type", "sampling");     // Catch: JSONException -> L10
            r10.put("message", o.b(this.f817c.f750b));     // Catch: JSONException -> L10
            r10.put(Constants.EVENT_TYPE, "lag_drop_frame");     // Catch: JSONException -> L10
            JSONObject r18 = PerfFilterManager.getInstance().getPerfFiltersJson(true);     // Catch: JSONException -> L10
            r18.put("crash_section", com.bytedance.apm.d.C(l.b(this.f819h).f757i));     // Catch: JSONException -> L10
            r18.put("belong_frame", String.valueOf(this.f818g));     // Catch: JSONException -> L10
            r18.put("monitor_type", "sample");     // Catch: JSONException -> L10
            r10.put("filters", r18);     // Catch: JSONException -> L10
            x.a.p().e(new y.d(LogTypeName.MONITOR_TYPE_DROP_FRAME_STACK, r10));     // Catch: JSONException -> L10
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
    }

    private l() {
        this.f792b = false;
        this.f793c = false;
        this.f794d = 2500;
        this.f795e = 5000;
        this.f796f = false;
        this.f797g = true;
        this.f799i = new StringBuilder(1200);
        this.f800j = new StringBuilder(1200);
        this.f801k = new StringBuilder(1200);
        this.f803m = null;
        this.f804n = false;
        this.f805o = false;
        this.f806p = true;
        this.f807q = true;
        this.f808r = new LinkedList();
        this.f809s = false;
        this.f810t = null;
        this.f811u = new a(this);
        this.f812v = new b(this);
        this.f798h = l.class.getName();
    }

    static boolean A(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    private JSONObject B(@NonNull com.bytedance.apm.block.d r10) {
        long r11 = r10.f756h - r10.f755g;
        JSONObject r12 = new JSONObject();
        r12.put("timestamp", r10.f757i);     // Catch: JSONException -> L5
        r12.put("crash_time", r10.f757i);     // Catch: JSONException -> L5
        r12.put("is_main_process", com.bytedance.apm.d.I());     // Catch: JSONException -> L5
        r12.put("process_name", com.bytedance.apm.d.h());     // Catch: JSONException -> L5
        r12.put("block_duration", r11);     // Catch: JSONException -> L5
        r12.put("last_scene", r10.f768t);     // Catch: JSONException -> L5
    L7:
        return r12;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void E(boolean r10, com.bytedance.apm.block.d r11, String r12) {
        if (this.f806p == true) goto L5;
        return;
    L5:
        JSONObject r13 = B(r11);
        r13.put("stack", r11.f766r);
        r13.put("message", r12);
        r13.put("ignore_stack", this.f802l.f761m);
        r13.put(Constants.EVENT_TYPE, "lag");
        r13.put("filters", u(r10, r11, r12));
        r13.put("custom", t());
        y.d r14 = new y.d(LogTypeName.MONITOR_TYPE_BLOCK, r13, r11.f755g);
        p(r14);
        x.a.p().e(r14);
        d0.c r15 = this.f810t;
        if (r15 == null) goto L9;
        r15.b(r11.f750b, r11.f756h - r11.f755g, r11.f768t, r11.f766r);
        return;
    }

    private void F(com.bytedance.apm.block.d r10, String r11) {
        if (PerfConfig.a() == false) goto L6;
        JSONObject r12 = B(r10);
        JSONObject r13 = PerfFilterManager.getInstance().getPerfFiltersJson(true);
        r13.put("crash_section", com.bytedance.apm.d.C(r10.f757i));
        r13.put("belong_frame", String.valueOf(r10.f752d));
        r13.put("belong_dump", String.valueOf(r10.f751c));
        r13.put("block_stack_type", "messageKey");
        r12.put("filters", r13);
        r12.put(Constants.EVENT_TYPE, "lag");
        r12.put("stack", "at " + r11 + ".*(a.java:-1)");
        y.d r14 = new y.d(LogTypeName.MONITOR_TYPE_BLOCK, r12);
        r14.g();
        x.a.p().e(r14);
        return;
    }

    private void G(com.bytedance.apm.block.d r18, String r19, boolean r20) {
        if (this.f807q == true) goto L5;
        return;
    L5:
        Logger.e("StackThread", "reportSeriousBlock :" + r18.f766r);
        JSONObject r10 = u(r18.f752d, r18, r19);
        r10.put("sbuuid", "empty");
        JSONObject r11 = B(r18);
        r11.put("message", r19);
        StackTraceElement[] r12 = r18.f764p;
        if (r12 == null) goto L43;
        StackTraceElement[] r13 = r18.f765q;
        if (r13 == null) goto L43;
        int r14 = r12.length;
        int r15 = r13.length;
        int r16 = 0;
        int r17 = 0;
    L11:
        if (r16 >= Math.min(r14, r15)) goto L19;
        int r110 = (r14 - r16) - 1;
        int r111 = (r15 - r16) - 1;
        if (r18.f764p[r110].equals(r18.f765q[r111]) == false) goto L15;
        r17 = r17 + 1;
        r16 = r16 + 1;
        goto L11
    L15:
        if (z(r18.f764p[r110], r18.f765q[r111]) == false) goto L19;
        r17 = r17 + 1;
    L19:
        if (r17 != 0) goto L22;
        String r21 = "none";
    L21:
        r10.put("serious_stack_coincide", r21);
        JSONObject r112 = r10;
    L34:
        this.f801k.setLength(0);
    L35:
        if (r17 <= 0) goto L38;
        StringBuilder r22 = this.f801k;
        r22.append("\tat ");
        int r23 = r14 - r17;
        r22.append(r18.f764p[r23].getClassName());
        r22.append(".");
        r22.append(r18.f764p[r23].getMethodName());
        r22.append("(");
        r22.append(r18.f764p[r23].getFileName());
        r22.append(":");
        r22.append(r18.f764p[r23].getLineNumber());
        r22.append(")\n");
        r17 = r17 - 1;
        goto L35
    L38:
        if (this.f801k.length() != 0) goto L40;
        String r24 = r18.f766r;
    L41:
        r11.put("stack", r24);
        r10 = r112;
        r10.put("sbuuid", r18.f767s);
        goto L43
    L40:
        r24 = this.f801k.toString();
        goto L41
    L22:
        if (r17 != r14) goto L25;
        if (r17 != r15) goto L25;
        r21 = "full";
    L25:
        r10.put("serious_stack_coincide", "part");
        this.f801k.setLength(0);
        int r25 = 0;
    L27:
        if (r25 > (r14 - r17)) goto L29;
        StringBuilder r113 = this.f801k;
        r113.append("\tat ");
        r113.append(r18.f764p[r25].getClassName());
        r113.append(".");
        r113.append(r18.f764p[r25].getMethodName());
        r113.append("(");
        r113.append(r18.f764p[r25].getFileName());
        r113.append(":");
        r113.append(r18.f764p[r25].getLineNumber());
        r113.append(")\n");
        r25 = r25 + 1;
        r10 = r10;
        goto L27
    L29:
        r112 = r10;
        r11.put("stack1", this.f801k.toString());
        this.f801k.setLength(0);
        int r114 = 0;
    L31:
        if (r114 > (r15 - r17)) goto L33;
        StringBuilder r26 = this.f801k;
        r26.append("\tat ");
        r26.append(r18.f765q[r114].getClassName());
        r26.append(".");
        r26.append(r18.f765q[r114].getMethodName());
        r26.append("(");
        r26.append(r18.f765q[r114].getFileName());
        r26.append(":");
        r26.append(r18.f765q[r114].getLineNumber());
        r26.append(")\n");
        r114 = r114 + 1;
        goto L31
    L33:
        r11.put("stack2", this.f801k.toString());
    L43:
        if (this.f809s == false) goto L45;
        r11.put("stack", r18.f766r);
        r10.put("sbuuid", r18.f767s);
    L45:
        r11.put("stack_cost", r18.f763o - r18.f762n);
        r11.put("filters", r10);
        r11.put(Constants.EVENT_TYPE, "serious_lag");
        r11.put("block_looper_info", r18.f769u);
        r11.put("block_cpu_info", r18.f770v);
        r11.put("block_memory_info", r18.f771w);
        r11.put("custom", r18.f772x);
        r11.put("block_error_info", r20);
        y.d r27 = new y.d(LogTypeName.MONITOR_TYPE_SERIOUS_BLOCK, r11, r18.f755g);
        p(r27);
        x.a.p().e(r27);
        d0.c r28 = this.f810t;
        if (r28 == null) goto L54;
        r28.a(r18.f750b, r18.f756h - r18.f755g, r18.f768t, r18.f766r);
        return;
    }

    private void H(boolean r10, com.bytedance.apm.block.d r11) {
        q0.b.f().i(new d(this, r11, r10));
    }

    public static void M(long r10) {
        if (r10 >= 70) goto L5;
        r10 = 1000;
    L5:
        f787w = r10;
    }

    static /* synthetic */ long a(l r10) {
        return r10.f794d;
    }

    static /* synthetic */ com.bytedance.apm.block.d b(l r10) {
        return r10.f802l;
    }

    static /* synthetic */ void c(l r10, boolean r11, com.bytedance.apm.block.d r12, String r13) {
        r10.E(r11, r12, r13);
    }

    static /* synthetic */ boolean d(l r10) {
        return r10.f792b;
    }

    static /* synthetic */ void e(l r10, com.bytedance.apm.block.d r11, String r12, boolean r13) {
        r10.G(r11, r12, r13);
    }

    static /* synthetic */ void f(l r10, com.bytedance.apm.block.d r11, String r12) {
        r10.F(r11, r12);
    }

    static /* synthetic */ boolean g(l r10) {
        return r10.f809s;
    }

    static /* synthetic */ String h(l r10) {
        return r10.f798h;
    }

    static /* synthetic */ StringBuilder i(l r10) {
        return r10.f799i;
    }

    static /* synthetic */ StringBuilder j(l r10) {
        return r10.f800j;
    }

    static /* synthetic */ JSONObject k(l r10) {
        return r10.w();
    }

    static /* synthetic */ long l(l r10) {
        return r10.f795e;
    }

    static /* synthetic */ boolean m(l r10) {
        return r10.f793c;
    }

    static /* synthetic */ boolean n(l r10) {
        return r10.f797g;
    }

    private StackTraceElement[] o(StackTraceElement[] r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", "a", "a.java", 1)};
    }

    private void p(y.d r10) {
    L3:
        if (this.f808r.size() == 0) goto L12;
        if ((r10.f() - this.f808r.getFirst().f()) < 0) goto L11;
        if ((r10.f() - this.f808r.getFirst().f()) > VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L11;
        if (this.f808r.size() <= 60) goto L12;
    L11:
        this.f808r.removeFirst();
    L12:
        this.f808r.addLast(r10);
    }

    private void q() {
        long r10 = this.f795e;
        long r11 = this.f794d;
        if (r10 >= r11) goto L6;
        this.f795e = r11 + 50;
        return;
    }

    private void r(com.bytedance.apm.block.d r10) {
        q0.b.f().i(new c(this, r10));
    }

    private void s(com.bytedance.apm.block.d r10) {
        String r11 = com.bytedance.apm.trace.fps.b.D();
        if (TextUtils.isEmpty(r11) == false) goto L5;
        String r12 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L6:
        r10.f768t = r12;
        return;
    L5:
        r12 = r11 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L6
    }

    private JSONObject t() {
        JSONObject r10 = new JSONObject();
        Map<String, String> r11 = com.bytedance.apm.block.c.a();     // Catch: JSONException -> L13
        if (r11 == null) goto L12;
        if (r11.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();     // Catch: JSONException -> L13
    L9:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, String> r13 = r12.next();     // Catch: JSONException -> L13
        r10.put(r13.getKey(), r13.getValue());     // Catch: JSONException -> L13
    L12:
        return r10;
    }

    private JSONObject u(boolean r10, com.bytedance.apm.block.d r11, String r12) {
        JSONObject r13 = PerfFilterManager.getInstance().getPerfFiltersJson(true);
        r13.put("crash_section", com.bytedance.apm.d.C(r11.f757i));
        r13.put("belong_frame", String.valueOf(r10));
        r13.put("belong_dump", String.valueOf(r11.f751c));
        r13.put("block_input", String.valueOf(r11.f753e));
        r13.put("block_frame", String.valueOf(r11.f754f));
        r13.put("block_message", r12);
        r13.put("block_stack_type", "stack");
        r13.put("buuid", r11.f767s);
        r13.put("belong_poll_once", String.valueOf(r11.f759k));
        Map<String, String> r14 = com.bytedance.apm.block.c.a();
        if (r14 != null) goto L5;
    L10:
        return r13;
    L5:
        if (r14.isEmpty() == true) goto L10;
        Iterator<Map.Entry<String, String>> r15 = r14.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Map.Entry<String, String> r16 = r15.next();
        r13.put(r16.getKey(), r16.getValue());
        goto L8
    }

    static l v() {
        if (f790z != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f790z != null) goto L9;
        f790z = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f790z;
    }

    private JSONObject w() {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L7
        Context r11 = com.bytedance.apm.d.g();     // Catch: Exception -> L7
        if (r11 == null) goto L5;
        ActivityManager r12 = (ActivityManager) r11.getSystemService("activity");     // Catch: Exception -> L7
        ActivityManager.MemoryInfo r13 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L7
        r12.getMemoryInfo(r13);     // Catch: Exception -> L7
        r10.put("availMem", r13.availMem);     // Catch: Exception -> L7
        r10.put("lowMemory", r13.lowMemory);     // Catch: Exception -> L7
        r10.put("threshold", r13.threshold);     // Catch: Exception -> L7
        r10.put("totalMem", q1.a.a(r13));     // Catch: Exception -> L7
    L5:
        Runtime r14 = Runtime.getRuntime();     // Catch: Exception -> L7
        r10.put("max_memory", r14.maxMemory());     // Catch: Exception -> L7
        r10.put("free_memory", r14.freeMemory());     // Catch: Exception -> L7
        r10.put("total_memory", r14.totalMemory());     // Catch: Exception -> L7
        return r10;
    L7:
        return null;
    }

    private void x(com.bytedance.apm.block.d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f749a == true) goto L8;
        r10.b();
    L8:
        if ((r10.f756h - r10.f755g) < this.f795e) goto L10;
        boolean r11 = true;
    L11:
        r10.f758j = r11;
        com.bytedance.monitor.collector.g.i r12 = com.bytedance.monitor.collector.k.n().o();
        if (r12 == null) goto L19;
        StackTraceElement[] r13 = o(r10.f764p);
        if (r10.f758j == false) goto L16;
        StackTraceElement[] r14 = o(r10.f765q);
    L17:
        r12.f(Api.KEY_UUID, r13, r14, null);
        goto L19
    L16:
        r14 = null;
    L19:
        if (r10.f759k == false) goto L21;
        r(r10);
        return;
    L21:
        this.f803m = r10;
        return;
    L10:
        r11 = false;
        goto L11
    }

    static boolean z(StackTraceElement r10, StackTraceElement r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == null) goto L18;
        if (r11 == null) goto L18;
        if (r10.getClassName().equals(r11.getClassName()) == false) goto L17;
        if (A(r10.getMethodName(), r11.getMethodName()) == false) goto L17;
        if (A(r10.getFileName(), r11.getFileName()) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public void C(boolean r10) {
        if (this.f791a.e() == false) goto L55;
        com.bytedance.apm.block.d r11 = this.f803m;     // Catch: Exception -> L52
        if (r11 == null) goto L9;
        if (r10 == false) goto L8;
        r11.f754f = true;     // Catch: Exception -> L52
    L8:
        r(r11);     // Catch: Exception -> L52
        this.f803m = null;     // Catch: Exception -> L52
    L9:
        com.bytedance.apm.block.d r12 = this.f802l;     // Catch: Exception -> L52
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.f755g >= 0) goto L14;
        return;
    L14:
        if (r12.f756h != (-1)) goto L58;
        r12.f756h = com.bytedance.monitor.collector.a.f2242b;     // Catch: Exception -> L52
        if (this.f797g == false) goto L19;
        this.f791a.h(this.f811u);     // Catch: Exception -> L52
        this.f791a.h(this.f812v);     // Catch: Exception -> L52
    L19:
        com.bytedance.apm.block.d r13 = this.f802l;     // Catch: Exception -> L52
        if ((r13.f756h - r13.f755g) <= this.f794d) goto L31;
        s(r13);     // Catch: Exception -> L52
        com.bytedance.apm.block.d r14 = this.f802l;     // Catch: Exception -> L52
        r14.f757i = System.currentTimeMillis();     // Catch: Exception -> L52
        if (this.f797g == true) goto L24;
        this.f802l.f761m = true;     // Catch: Exception -> L52
    L24:
        com.bytedance.apm.block.d r15 = this.f802l;     // Catch: Exception -> L52
        r15.f752d = r10;     // Catch: Exception -> L52
        r15.f751c = this.f804n;     // Catch: Exception -> L52
        x(this.f802l.a());     // Catch: Exception -> L52
        com.bytedance.apm.block.d r16 = this.f802l;     // Catch: Exception -> L52
        if ((r16.f756h - r16.f755g) <= this.f795e) goto L31;
        if (r10 == false) goto L31;
        if (this.f805o == false) goto L31;
        i.a();     // Catch: Exception -> L52
    L31:
        if (f788x == false) goto L42;
        com.bytedance.apm.block.d r17 = this.f802l;     // Catch: Exception -> L52
        if ((r17.f756h - r17.f755g) <= f787w) goto L42;
        if (TextUtils.isEmpty(r17.f768t) == false) goto L37;
        s(this.f802l);     // Catch: Exception -> L52
    L37:
        com.bytedance.apm.block.d r18 = this.f802l;     // Catch: Exception -> L52
        if (r18.f757i != 0) goto L40;
        r18.f757i = System.currentTimeMillis();     // Catch: Exception -> L52
    L40:
        H(r10, this.f802l.a());     // Catch: Exception -> L52
    L42:
        if (f789y == false) goto L59;
        Message r19 = com.bytedance.monitor.collector.i.b(com.bytedance.monitor.collector.i.a());     // Catch: Exception -> L52
        if (r19 != null) goto L46;
        return;
    L46:
        long r20 = SystemClock.uptimeMillis();     // Catch: Exception -> L52
        if (r19.getTarget() != null) goto L49;
        return;
    L49:
        if (r19.getWhen() >= r20) goto L61;
        this.f796f = true;     // Catch: Exception -> L52
        this.f802l.c(r20, null);     // Catch: Exception -> L52
        this.f791a.g(this.f811u, this.f794d);     // Catch: Exception -> L52
        return;
    L61:
        return;
    L59:
        return;
    L58:
        return;
    L55:
        return;
    }

    public void D(String r10) {
        if (this.f791a.e() == true) goto L5;
        return;
    L5:
        if (f789y == false) goto L12;
        if (this.f796f == false) goto L12;
        com.bytedance.apm.block.d r11 = this.f802l;     // Catch: Exception -> L28
        long r12 = com.bytedance.monitor.collector.a.f2242b;     // Catch: Exception -> L28
        r11.f756h = r12;     // Catch: Exception -> L28
        if ((r12 - r11.f755g) <= this.f794d) goto L12;
        r11.f759k = true;     // Catch: Exception -> L28
        r11.f752d = false;     // Catch: Exception -> L28
        r11.f751c = this.f804n;     // Catch: Exception -> L28
        x(this.f802l.a());     // Catch: Exception -> L28
    L12:
        if (this.f803m != null) goto L14;
    L16:
        com.bytedance.apm.block.d r13 = this.f802l;     // Catch: Exception -> L28
        if (r13 != null) goto L19;
        this.f802l = new com.bytedance.apm.block.d(com.bytedance.monitor.collector.a.f2242b, r10);     // Catch: Exception -> L28
    L21:
        if (this.f797g == false) goto L32;
        this.f791a.g(this.f811u, this.f794d);     // Catch: Exception -> L28
        if (this.f792b == true) goto L25;
        return;
    L25:
        if (this.f807q == false) goto L34;
        this.f791a.g(this.f812v, this.f795e);     // Catch: Exception -> L28
        return;
    L34:
        return;
    L32:
        return;
    L19:
        r13.c(com.bytedance.monitor.collector.a.f2242b, r10);     // Catch: Exception -> L28
        goto L21
    L14:
        if (t.e.B().f12841b.b() == false) goto L16;
        this.f803m.f753e = true;     // Catch: Exception -> L28
    }

    public void I(long r10) {
        if (r10 >= 70) goto L5;
        r10 = 2500;
    L5:
        this.f794d = r10;
        q();
    }

    public void J(d0.c r10) {
        this.f810t = r10;
    }

    public void K(boolean r10) {
        this.f797g = r10;
    }

    public void L(boolean r10) {
        this.f805o = r10;
    }

    public void N(boolean r10) {
        this.f793c = r10;
    }

    public void O(boolean r10) {
        this.f806p = r10;
    }

    public void P(boolean r10) {
        this.f807q = r10;
    }

    public void Q(long r10) {
        if (r10 >= this.f794d) goto L5;
        r10 = 5000;
    L5:
        this.f795e = r10;
        q();
    }

    public void R(boolean r10) {
        this.f809s = r10;
    }

    public void S(boolean r10) {
        this.f792b = r10;
    }

    public void y() {
        q0.e r10 = new q0.e("StackThread");
        this.f791a = r10;
        r10.k();
    }
}
