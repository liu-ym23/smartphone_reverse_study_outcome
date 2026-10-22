package com.bytedance.android.live.core.monitor;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import om0.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveMonitor {
    public static final String ALOG_SERVICE_NAME = "service_name";
    public static final String ALOG_TAG = "LiveMonitorALog";
    public static final int SUCCESS = 0;
    public static final String TAG = "LiveMonitor";
    public JSONObject mCategory;
    private boolean mCompatibleWithVQOS;
    public LiveTracingMonitor.EventModule mEventModule;
    public JSONObject mExtraLog;
    public JSONObject mMetrics;
    private boolean mReportInLocalTest;
    public String mServiceName;
    private boolean mUseNewReportAction;
    private boolean mWriteLocalLog;
    private boolean mWriteLogcat;

    public static class a {
        public final String a;
        public final LiveTracingMonitor.EventModule b;
        public JSONObject c;
        public JSONObject d;
        public JSONObject e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;

        public LiveMonitor a() {
            LiveMonitor r0 = new LiveMonitor();
            r0.mCategory = this.c;
            r0.mEventModule = this.b;
            r0.mServiceName = this.a;
            r0.mExtraLog = this.e;
            r0.mMetrics = this.d;
            LiveMonitor.access$002(r0, this.f);
            LiveMonitor.access$102(r0, this.g);
            LiveMonitor.access$202(r0, this.h);
            LiveMonitor.access$302(r0, false);
            LiveMonitor.access$402(r0, this.i);
            return r0;
        }

        public final void b(JSONObject r5) {
            if (this.c == null) goto L13;
            Iterator<String> r0 = r5.keys();
        L6:
            if (r0.hasNext() == false) goto L22;
            String r1 = r0.next();
            if (TextUtils.isEmpty(r1) == true) goto L6;
            this.c.put(r1, r5.opt(r1));     // Catch: JSONException -> L11
        L11:
            e = move-exception;
            ALogger.w(LiveMonitor.TAG, e.getMessage());
            goto L6
        L22:
            return;
        L13:
            this.c = r5;
        }

        public final void c(String r3) {
            if (this.c != null) goto L9;
            this.c = new JSONObject();
        L9:
            this.c.put("category_1", r3);     // Catch: JSONException -> L8
            return;
        }

        public final void d(String r3) {
            if (this.c != null) goto L9;
            this.c = new JSONObject();
        L9:
            this.c.put("category_2", r3);     // Catch: JSONException -> L8
            return;
        }

        public final void h(long r3) {
            if (this.d != null) goto L9;
            this.d = new JSONObject();
        L9:
            this.d.put("duration", r3);     // Catch: JSONException -> L8
            return;
        }

        public final void j(long r3) {
            if (this.d != null) goto L9;
            this.d = new JSONObject();
        L9:
            this.d.put("latency", r3);     // Catch: JSONException -> L8
            return;
        }

        public final void k(JSONObject r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (this.d == null) goto L15;
            Iterator<String> r0 = r5.keys();
        L8:
            if (r0.hasNext() == false) goto L24;
            String r1 = r0.next();
            if (TextUtils.isEmpty(r1) == true) goto L8;
            this.d.put(r1, r5.opt(r1));     // Catch: JSONException -> L13
        L13:
            e = move-exception;
            ALogger.w(LiveMonitor.TAG, e.getMessage());
            goto L8
        L24:
            return;
        L15:
            this.d = r5;
        }

        public final void l(int r5) {
            if (this.c != null) goto L9;
            this.c = new JSONObject();
        L9:
            this.c.put("status_code", r5);     // Catch: JSONException -> L8
            return;
        }

        public final void m(String r3) {
            if (this.c != null) goto L9;
            this.c = new JSONObject();
        L9:
            this.c.put("status_msg", r3);     // Catch: JSONException -> L8
            return;
        }

        public a(String r3, LiveTracingMonitor.EventModule r4) {
            this.f = false;
            this.g = false;
            this.h = true;
            this.i = false;
            this.a = r3;
            this.b = r4;
        }

        public final void e(String r2, String r3) {
            if (this.c != null) goto L9;
            this.c = new JSONObject();
        L9:
            this.c.put(r2, r3);     // Catch: JSONException -> L8
            return;
        }

        public final void f(String r2, float r3) {
            if (this.d != null) goto L9;
            this.d = new JSONObject();
        L9:
            this.d.put(r2, Float.valueOf(r3));     // Catch: JSONException -> L8
            return;
        }

        public final void g(String r2, long r3) {
            if (this.d != null) goto L9;
            this.d = new JSONObject();
        L9:
            this.d.put(r2, r3);     // Catch: JSONException -> L8
            return;
        }

        public final void i(String r2, Object r3) {
            if (this.e != null) goto L9;
            this.e = new JSONObject();
        L9:
            this.e.put(r2, r3);     // Catch: JSONException -> L8
            return;
        }
    }

    public void report() {
        if (this.mWriteLocalLog == false) goto L6;
        HashMap r0 = new HashMap();
        r0.put(ALOG_SERVICE_NAME, this.mServiceName);
        sinkJsonToMap(this.mCategory, r0);
        sinkJsonToMap(this.mMetrics, r0);
        sinkJsonToMap(this.mExtraLog, r0);
        ALogger.i(ALOG_TAG, r0.toString());
    L6:
        if (this.mReportInLocalTest == true) goto L11;
        if (v.a() == false) goto L11;
        return;
    L11:
        if (this.mExtraLog != null) goto L14;
        this.mExtraLog = new JSONObject();
    L14:
        if (this.mCompatibleWithVQOS == false) goto L42;
        JSONObject r1 = new JSONObject();
        JSONObject r2 = this.mCategory;
        int r3 = 0;
        if (r2 == null) goto L56;
        r3 = r2.optInt("status_code", 0);
    L56:
        r1.put("status", r3);     // Catch: JSONException -> L21
    L23:
        JSONObject r4 = this.mMetrics;
        long r5 = -1;
        if (r4 == null) goto L28;
        r5 = r4.optLong("latency", -1);
    L28:
        if (r5 <= 0) goto L35;
        r1.put("value", durationJson(r5));     // Catch: JSONException -> L32
        r1.put("extra", this.mExtraLog);     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L35:
        if (this.mUseNewReportAction == false) goto L40;
        wm0.a r6 = c.h();
        if (r6 == null) goto L39;
        r6.d(this.mServiceName, this.mCategory, this.mMetrics, r1);
    L49:
        if (this.mWriteLogcat == true) goto L51;
        return;
    L51:
        if (v.a() == false) goto L59;
        Objects.toString(this.mCategory);
        Objects.toString(this.mExtraLog);
        Objects.toString(this.mEventModule);
        Objects.toString(this.mMetrics);
        return;
    L59:
        return;
    L39:
        LiveTracingMonitor.i(this.mServiceName, this.mCategory, this.mMetrics, r1);
        goto L49
    L40:
        LiveTracingMonitor.i(this.mServiceName, this.mCategory, this.mMetrics, r1);
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L42:
        if (this.mUseNewReportAction == false) goto L47;
        wm0.a r7 = c.h();
        if (r7 == null) goto L46;
        r7.g(this.mServiceName, this.mEventModule.getName(), LiveTracingMonitor.EventType.BUSSINESS_API_CALL.getName(), this.mCategory, this.mMetrics, this.mExtraLog);
        goto L49
    L46:
        LiveTracingMonitor.e(this.mServiceName, this.mEventModule, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.mCategory, this.mMetrics, this.mExtraLog);
        goto L49
    L47:
        LiveTracingMonitor.e(this.mServiceName, this.mEventModule, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.mCategory, this.mMetrics, this.mExtraLog);
        goto L49
    }

    public LiveMonitor() {
        this.mUseNewReportAction = false;
    }

    private static JSONObject durationJson(long r2) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r2);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static /* synthetic */ boolean access$002(LiveMonitor r0, boolean r1) {
        r0.mWriteLocalLog = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(LiveMonitor r0, boolean r1) {
        r0.mWriteLogcat = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(LiveMonitor r0, boolean r1) {
        r0.mReportInLocalTest = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$302(LiveMonitor r0, boolean r1) {
        r0.mCompatibleWithVQOS = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$402(LiveMonitor r0, boolean r1) {
        r0.mUseNewReportAction = r1;
        return r1;
    }

    private void sinkJsonToMap(JSONObject r4, Map<String, Object> r5) {
        if (r4 == null) goto L12;
        if (r5 == null) goto L16;
        Iterator<String> r0 = r4.keys();
    L7:
        if (r0.hasNext() == false) goto L17;
        String r1 = r0.next();
        Object r2 = r4.opt(r1);
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        r5.put(r1, r2);
        goto L7
    L17:
        return;
    L16:
        return;
    }
}
