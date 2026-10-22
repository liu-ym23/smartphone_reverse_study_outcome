package com.tencent.open.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class h {
    protected static h a;
    protected Random b;
    protected List<Serializable> c;
    protected List<Serializable> d;
    protected HandlerThread e;
    protected Handler f;
    protected Executor g;
    protected Executor h;

    public void b() {
    }

    public static synchronized h a() {
        monitor-enter(h.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new h();     // Catch: Throwable -> L10
    L7:
        h r1 = a;     // Catch: Throwable -> L10
        monitor-exit(h.class);
        return r1;
    }

    public Map<String, String> c() {
        List<Serializable> r1 = g.b("report_via");
        if (r1 == null) goto L5;
        this.d.addAll(r1);
    L5:
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() != 0) goto L8;
        return null;
    L8:
        JSONArray r2 = new JSONArray();
        Iterator<Serializable> r4 = this.d.iterator();
    L10:
        if (r4.hasNext() == false) goto L23;
        Serializable r5 = r4.next();
        JSONObject r7 = new JSONObject();
        c r6 = (c) r5;
        Iterator<String> r8 = r6.a.keySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L22;
        String r9 = r8.next();
        String r10 = r6.a.get(r9);     // Catch: JSONException -> L20
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r7.put(r9, r10);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
        goto L13
    L22:
        r2.put(r7);
        goto L10
    L23:
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + r2.toString());
        JSONObject r11 = new JSONObject();
        r11.put("data", r2);     // Catch: JSONException -> L27
        HashMap r3 = new HashMap();
        r3.put("data", r11.toString());
        return r3;
    L27:
        e = move-exception;
        SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
        return null;
    }

    private h() {
        this.e = null;
        this.b = new SecureRandom();
        this.d = Collections.synchronizedList(new ArrayList());
        this.c = Collections.synchronizedList(new ArrayList());
        this.g = l.b();
        this.h = l.b();
        if (this.e != null) goto L6;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("opensdk.report.handlerthread", 10);
        this.e = r0;
        ThreadMethodProxy.start(r0);
    L6:
        if (ThreadMethodProxy.isAlive(this.e) == true) goto L8;
        return;
    L8:
        if (this.e.getLooper() == null) goto L12;
        final Looper r1 = this.e.getLooper();
        this.f = new AnonymousClass1(this, r1);
        return;
    }

    public void d() {
        if (m.b(com.tencent.open.utils.g.a()) == true) goto L5;
        return;
    L5:
        this.g.execute(new AnonymousClass3(this));
    }

    public int a(int r2) {
        if (r2 != 0) goto L7;
        int r3 = i.a(com.tencent.open.utils.g.a(), null).a("Common_CGIReportFrequencySuccess");
        if (r3 != 0) goto L11;
        return 10;
    L11:
        return r3;
    L7:
        int r4 = i.a(com.tencent.open.utils.g.a(), null).a("Common_CGIReportFrequencyFailed");
        if (r4 != 0) goto L13;
        return 100;
    L13:
        return r4;
    }

    public boolean a(String r6, String r7) {
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + r6 + " | ext: " + r7);
        boolean r2 = false;
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        int r4 = 100;
        if (r6.equals("report_cgi") == false) goto L13;
        int r8 = a(CastIntegerProtector.parseInt(r7));
        if (this.b.nextInt(100) >= r8) goto L17;
        r2 = true;
    L17:
        r4 = r8;
    L18:
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + r2 + " | frequency: " + r4);
        return r2;
    L11:
        return false;
    L13:
        if (r6.equals("report_via") == false) goto L18;
        r8 = f.a(r7);
        if (this.b.nextInt(100) >= r8) goto L17;
        r4 = r8;
        r2 = true;
        goto L18
    }

    public boolean a(String r5, int r6) {
        int r1 = 5;
        if (r5.equals("report_cgi") == false) goto L9;
        int r0 = i.a(com.tencent.open.utils.g.a(), null).a("Common_CGIReportMaxcount");
        if (r0 == 0) goto L14;
    L7:
        r1 = r0;
    L14:
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + r5 + " | dataSize: " + r6 + " | maxcount: " + r1);
        if (r6 < r1) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (r5.equals("report_via") == false) goto L13;
        r0 = i.a(com.tencent.open.utils.g.a(), null).a("Agent_ReportBatchCount");
        if (r0 != 0) goto L7;
    L13:
        r1 = 0;
        goto L14
    }

    public void a(final String r2, final Map<String, String> r3) {
        if (m.b(com.tencent.open.utils.g.a()) == true) goto L5;
        return;
    L5:
        l.b(new AnonymousClass4(this, r2, r3));
    }

    public void a(final Bundle r3, String r4, final boolean r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + r3.toString());
        if (a("report_via", r4) == true) goto L8;
        if (r5 == true) goto L8;
        return;
    L8:
        this.g.execute(new AnonymousClass2(this, r3, r5));
    }

    public void a(String r12, long r13, long r15, long r17, int r19) {
        a(r12, r13, r15, r17, r19, "", false);
    }

    public void a(String r2, long r3, long r5, long r7, int r9, String r10, boolean r11) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + r2 + " | startTime: " + r3 + " | reqSize:" + r5 + " | rspSize: " + r7 + " | responseCode: " + r9 + " | detail: " + r10);
    }
}
