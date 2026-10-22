package com.bytedance.applog.priority;

import android.app.Application;
import androidx.annotation.Keep;
import androidx.room.h;
import c4.m;
import defpackage.a;
import i4.f;
import i4.j;
import i4.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import r3.c;
import r3.e;
import v4.b;
import v4.i;
import x4.s0;
import xd.d;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PriorityCallbackImpl implements PriorityCallback {
    private static final List<String> loggerTags = null;
    private final c appLogInstance;

    static {
        loggerTags = Collections.singletonList("PriorityCallbackImpl");
    }

    public PriorityCallbackImpl(c r8) {
        this.appLogInstance = r8;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean allowIsolateReport(String r8, String r10) {
        this.appLogInstance.getClass();
        this.appLogInstance.getClass();
        return true;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(String r11, byte[] r12, d<String, String> r13) {
        long r8 = System.currentTimeMillis();
        c r10 = this.appLogInstance;
        m r14 = r10.H;
        List<String> r15 = loggerTags;
        Object[] r16 = new Object[2];
        r16[0] = r11;
        if (r10.i() == false) goto L5;
        Object r17 = new String(r12);
    L6:
        r16[1] = r17;
        r14.g(0, r15, "****** priority callback do http post, url: {}, buffer: {}", r16);
        HashMap r18 = new HashMap();
        if (this.appLogInstance.A == null) goto L18;
        e r19 = ((h) this.appLogInstance.A).a(r12);     // Catch: Throwable -> L13
        byte[] r20 = (byte[]) r19.f11423c;     // Catch: Throwable -> L13
        r18.putAll((Map) r19.f11424d);     // Catch: Throwable -> L11
    L16:
        r12 = r20;
    L11:
        Throwable th = th;
    L15:
        this.appLogInstance.H.i(loggerTags, "****** log compress toBytes failed", th, new Object[0]);
        this.appLogInstance.f11417y.b(k.U, 1);
    L13:
        th = move-exception;
        r20 = r12;
        th = th;
    L18:
        if (this.appLogInstance.f11409q == false) goto L20;
        r12 = this.appLogInstance.f11397e.f10136c.b(r12);
        r18.remove("Content-Encoding");
        r18.put("Content-Type", "application/octet-stream;tt-data=a");
    L20:
        this.appLogInstance.getClass();
        c r21 = this.appLogInstance;
        String r22 = r21.f11396d.c(r21.f11402j, r11);
        if (r13 == null) goto L29;
        byte[] r110 = this.appLogInstance.f().postStream(r22, r12, r18);     // Catch: Throwable -> L35
        byte[] r111 = b.a(r13.f13867a, r110, r13.f13868b);     // Catch: Throwable -> L35
        if (r111 != null) goto L25;
    L28:
        String r112 = new String(r110);     // Catch: Throwable -> L35
    L31:
        if (i.h(r112) == false) goto L33;
        PriorityHttpResponse r113 = new PriorityHttpResponse(200, "", r112);     // Catch: Throwable -> L35
    L41:
        this.appLogInstance.H.l(0, loggerTags, "****** priority request cost {}ms", new Object[]{Long.valueOf(System.currentTimeMillis() - r8)});
        return r113;
    L33:
        r113 = new PriorityHttpResponse(0, "response empty", null);     // Catch: Throwable -> L35
        goto L41
    L25:
        if (r111.length == 0) goto L28;
        r112 = new String(b.c(r111));     // Catch: Throwable -> L35
        goto L31
    L29:
        r112 = this.appLogInstance.f().post(r22, r12, r18);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        if ((th instanceof s0) == false) goto L39;
        s0 r114 = th;
        int r23 = r114.f13548a;
        String r115 = r114.getMessage();
        this.appLogInstance.H.i(loggerTags, a.d("****** send resultCode: ", r23), th, new Object[0]);
        r113 = new PriorityHttpResponse(r23, r115, null);
    L40:
        this.appLogInstance.f11417y.g(defpackage.b.c("send priority log error, url: ", r11), new Throwable(r113.toString()));
        goto L41
    L39:
        r113 = new PriorityHttpResponse(0, th.toString(), null);
        goto L40
    L5:
        r17 = Integer.valueOf(r12.length);
        goto L6
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        this.appLogInstance.H.g(0, loggerTags, "****** priority callback get header json...", new Object[0]);
        c r8 = this.appLogInstance;
        if (r8.f11404l != null) goto L5;
        r8.H.b("Init first please to get header", new Object[0]);
        JSONObject r10 = null;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        this.appLogInstance.getClass();
        return r10.toString();
    L5:
        r10 = r8.f11404l.a();
        goto L6
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isMonitorEnabled() {
        return this.appLogInstance.f11417y.f8212a.f8157b;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isNetworkAvailable() {
        Application r8 = this.appLogInstance.f11402j;
        r5.e.a(r8);
        if ((System.currentTimeMillis() - r5.e.f11505d) <= r5.e.f11504c) goto L5;
        r5.e.f11502a = r5.e.d(r8);
        r5.e.f11505d = System.currentTimeMillis();
    L5:
        r5.e.a r10 = r5.e.f11502a;
        r10.getClass();
        if (r10 != r5.e.a.f11506b) goto L8;
    L10:
        return false;
    L8:
        if (r10 == r5.e.a.f11507m) goto L10;
        return true;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isStageEnabled() {
        return this.appLogInstance.f11417y.f();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String isolateKey() {
        this.appLogInstance.getClass();
        this.appLogInstance.getClass();
        return "";
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorError(String r8, String r10) {
        if (isMonitorEnabled() == true) goto L5;
        return;
    L5:
        this.appLogInstance.f11417y.g(r8, new Throwable(r10));
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String r8, int r10) {
        this.appLogInstance.f11417y.a(r10, r8);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorLatency(int r8, int r10, int r11) {
        if (isMonitorEnabled() == true) goto L5;
        return;
    L5:
        f r12 = this.appLogInstance.f11417y;
        if (r10 != 1) goto L8;
        j r13 = j.f8241m;
    L18:
        i4.c r14 = r12.f8212a;
        if (r14.f8157b == true) goto L21;
    L23:
        boolean r15 = false;
    L24:
        if (r15 == false) goto L64;
        m.u().l(8, f.f8209w, "onLatency {} -> {}", new Object[]{Integer.valueOf(r8), Integer.valueOf(r11)});
        j4.b r16 = r12.f8216o;
        r16.getClass();
        if (r11 > 1) goto L30;
        j4.b.EnumC0098b r17 = j4.b.EnumC0098b.f8594b;
    L51:
        String r18 = r8 + "_" + r13.toString() + "_" + r17.toString();
        ConcurrentHashMap r19 = r16.f8588b;
        monitor-enter(r19);
        j4.b.a r20 = (j4.b.a) r16.f8588b.get(r18);     // Catch: Throwable -> L59
        if (r20 != null) goto L56;
        r20 = new j4.b.a();     // Catch: Throwable -> L59
        r20.f8592d = r17;     // Catch: Throwable -> L59
        r20.f8591c = r13;     // Catch: Throwable -> L59
        r20.f8590b = r8;     // Catch: Throwable -> L59
        r16.f8588b.put(r18, r20);     // Catch: Throwable -> L59
    L56:
        r20.f8589a++;     // Catch: Throwable -> L59
        monitor-exit(r19);     // Catch: Throwable -> L59
        return;
    L59:
        th = move-exception;
        throw th;
    L30:
        if (r11 > 10) goto L33;
        r17 = j4.b.EnumC0098b.f8595m;
        goto L51
    L33:
        if (r11 > 20) goto L36;
        r17 = j4.b.EnumC0098b.f8596n;
        goto L51
    L36:
        if (r11 > 30) goto L39;
        r17 = j4.b.EnumC0098b.f8597o;
        goto L51
    L39:
        if (r11 > 40) goto L42;
        r17 = j4.b.EnumC0098b.f8598p;
        goto L51
    L42:
        if (r11 > 50) goto L45;
        r17 = j4.b.EnumC0098b.f8599q;
        goto L51
    L45:
        if (r11 > 60) goto L48;
        r17 = j4.b.EnumC0098b.f8600r;
        goto L51
    L48:
        if (r11 > 120) goto L50;
        r17 = j4.b.EnumC0098b.f8601s;
        goto L51
    L50:
        r17 = j4.b.EnumC0098b.f8602t;
        goto L51
    L64:
        return;
    L21:
        if (r14.f8161f == false) goto L23;
        r15 = true;
        goto L24
    L8:
        if (r10 != 2) goto L10;
        r13 = j.f8242n;
        goto L18
    L10:
        if (r10 != 3) goto L12;
        r13 = j.f8243o;
        goto L18
    L12:
        if (r10 == 4) goto L14;
        r13 = j.f8240b;
        goto L18
    L14:
        r13 = j.f8244p;
        goto L18
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String r15, String r16, int r17, int r18, String r19, String r20, long r21) {
        if (isStageEnabled() == true) goto L5;
        return;
    L5:
        f r8 = this.appLogInstance.f11417y;
        i4.a[] r10 = i4.a.values();
        int r11 = r10.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        i4.a r13 = r10[r12];
        if (r13.f8151a.equals(r15) == true) goto L13;
        r12 = r12 + 1;
    L13:
        if (r18 != 1) goto L15;
        j r14 = j.f8241m;
    L25:
        l6.a.O0(r8, r13, new i4.i(r16, r17, r19, r20, r21, r14));
        return;
    L15:
        if (r18 != 2) goto L17;
        r14 = j.f8242n;
        goto L25
    L17:
        if (r18 != 3) goto L19;
        r14 = j.f8243o;
        goto L25
    L19:
        if (r18 == 4) goto L21;
        r14 = j.f8240b;
        goto L25
    L21:
        r14 = j.f8244p;
        goto L25
    L11:
        r13 = i4.a.f8136b;
        goto L13
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int r8, String r10) {
        if (this.appLogInstance.i() == true) goto L6;
        return;
    L6:
        if (r8 == 2) goto L14;
        c r11 = this.appLogInstance;
        if (r8 != 3) goto L10;
        r11.H.f(0, loggerTags, r10, new Object[0]);
        return;
    L10:
        if (r8 == 4) goto L12;
        r11.H.l(0, loggerTags, r10, new Object[0]);
        return;
    L12:
        r11.H.i(loggerTags, r10, null, new Object[0]);
        return;
    L14:
        this.appLogInstance.H.g(0, loggerTags, r10, new Object[0]);
    }
}
