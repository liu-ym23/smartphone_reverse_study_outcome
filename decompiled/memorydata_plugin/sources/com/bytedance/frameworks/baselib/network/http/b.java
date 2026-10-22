package com.bytedance.frameworks.baselib.network.http;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.c;
import com.bytedance.retrofit2.LegacyLogRecorder;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b<T extends c> implements LegacyLogRecorder {
    private static volatile a ad;

    @Deprecated
    public long A;

    @Deprecated
    public long B;

    @Deprecated
    public int C;

    @Deprecated
    public boolean D;

    @Deprecated
    public long E;
    public boolean F;
    public int G;
    public int H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @Deprecated
    public String f2361J;
    public JSONObject K;

    @Deprecated
    public boolean L;
    public String M;
    public String N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;

    @Deprecated
    public long U;
    public String V;
    public boolean W;

    @Deprecated
    public long X;
    public boolean Y;
    public i Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2362a;
    public long aa;

    @Deprecated
    public boolean ab;

    @Deprecated
    public final AtomicBoolean ac;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2363b;
    public T c;
    public RetrofitMetrics d;

    @Deprecated
    public long e;

    @Deprecated
    public long f;

    @Deprecated
    public long g;

    @Deprecated
    public long h;

    @Deprecated
    public long i;

    @Deprecated
    public long j;

    @Deprecated
    public long k;

    @Deprecated
    public long l;

    @Deprecated
    public long m;

    @Deprecated
    public long n;

    @Deprecated
    public long o;

    @Deprecated
    public long p;

    @Deprecated
    public long q;

    @Deprecated
    public long r;

    @Deprecated
    public long s;

    @Deprecated
    public long t;

    @Deprecated
    public long u;
    public URL v;

    @Deprecated
    public String w;

    @Deprecated
    public long x;

    @Deprecated
    public long y;
    public long z;

    public interface a {
        b a();
    }

    static {
        ad = new AnonymousClass1();
    }

    public b() {
        this.f2362a = false;
        this.f2363b = -1;
        this.d = new RetrofitMetrics(this);
        this.g = System.currentTimeMillis();
        this.k = -1;
        this.m = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.F = false;
        this.G = -1;
        this.H = -1;
        this.I = "";
        this.f2361J = "";
        this.K = new JSONObject();
        this.L = false;
        this.O = "";
        this.P = "";
        this.S = false;
        this.T = false;
        this.U = -1;
        this.W = false;
        this.X = -1;
        this.Y = false;
        this.ab = false;
        this.ac = new AtomicBoolean(false);
    }

    public static b a() {
        return ad.a();
    }

    public static JSONObject a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        String[] r5 = r4.split(",");
        JSONArray r0 = new JSONArray();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0.put(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        JSONObject r6 = new JSONObject();
        r6.put("hit", r0);     // Catch: JSONException -> L12
    L14:
        return r6;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void a(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        ad = r3;
        return;
    }

    @Deprecated
    private void a(JSONObject r5) {
        r5.put("requestStart", this.g);
        r5.put("responseBack", this.h);
        r5.put("completeReadResponse", this.i);
        r5.put("appLevelRequestStart", this.e);
        r5.put("beforeAllInterceptors", this.f);
        r5.put("requestEnd", this.j);
        r5.put("recycleCount", this.C);
        r5.put("timing_dns", this.n);
        r5.put("timing_connect", this.o);
        r5.put("timing_ssl", this.p);
        r5.put("timing_send", this.q);
        r5.put("timing_waiting", this.s);
        r5.put("timing_receive", this.t);
        r5.put("timing_total", this.u);
        r5.put("timing_isSocketReused", this.D);
        r5.put("timing_totalSendBytes", this.x);
        r5.put("timing_totalReceivedBytes", this.y);
        r5.put("timing_remoteIP", this.w);
        r5.put("request_log", this.f2361J);
        JSONObject r0 = this.K;
        if (r0 == null) goto L5;
        r5.put("req_info", r0);
    L5:
        r5.put("download", this.L);
        r5.put("addExecutorToAllInterceptors", this.f - this.e);
        r5.put("addExecutorTime", this.e);
        r5.put("allInterceptorsTime", this.f);
        r5.put("fallback", this.H);
        r5.put("requestHeader", this.M);
        r5.put("responseHeader", this.N);
        if (this.Q == false) goto L9;
        r5.put("hit_rules", 1);
        return;
    }

    @Deprecated
    private void b(JSONObject r21) {
        r21.put("use_deprecated_api", this.ab);
        T r2 = this.c;
        if (r2 != null) goto L5;
    L9:
        RetrofitMetrics r3 = this.d;
        if (r3 != null) goto L12;
        return;
    L12:
        r21.put("resp_comp", r3.responseCompressType);
        r21.put("req_comp", this.d.requestCompressType);
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.d.responseInterceptDuration.get("CallServerInterceptor"), Long.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L15;
        long r7 = r4.longValue();
    L16:
        r21.put("parse_time", r7);
        r21.put("priority_level", this.d.priorityLevel);
        r21.put("req_priority_level", this.d.requestPriorityLevel);
        r21.put("thread_priority", Thread.currentThread().getPriority());
        int r15 = 0;
        if (this.d.executeTime <= 0) goto L31;
        r21.put("biz_before_time", this.d.executeTime - this.d.appCreateRetrofitStartUpTime);
        r21.put("queue_time", this.d.responseChainTime - this.d.executeTime);
        r21.put("preprocess_time", this.d.executeCallStartTime - this.d.responseChainTime);
        r21.put("realcall_time", this.d.executeCallEndTime - this.d.executeCallStartTime);
        r21.put("is_async", 0);
        if (this.L == true) goto L21;
        r21.put("postprocess_time", this.d.executeEndTime - this.d.executeCallEndTime);
        long r5 = this.d.executeEndTime - this.d.appCreateRetrofitStartUpTime;
    L29:
        r21.put("biz_total_time", r5);
    L45:
        if (this.d.interceptorRequestInfos.size() <= 0) goto L80;
        HashMap r6 = new HashMap();
        int r8 = 0;
    L48:
        if (r8 >= this.d.interceptorRequestInfos.size()) goto L54;
        RetrofitMetrics.InterceptorInfo r9 = (RetrofitMetrics.InterceptorInfo) ZeusTransformUtils.preCheckCast(this.d.interceptorRequestInfos.get(r8), RetrofitMetrics.InterceptorInfo.class, "com.obric.memorydata.plugin");
        long r10 = r9.end - r9.start;
        Long r11 = (Long) ZeusTransformUtils.preCheckCast(r6.get(r9.name), Long.class, "com.obric.memorydata.plugin");
        String r12 = r9.name;
        if (r11 != null) goto L52;
        Long r13 = Long.valueOf(r10);
    L53:
        r6.put(r12, r13);
        r8 = r8 + 1;
        goto L48
    L52:
        r13 = Long.valueOf(r11.longValue() + r10);
        goto L53
    L54:
        JSONObject r14 = new JSONObject();
        Iterator r16 = r6.keySet().iterator();
    L56:
        if (r16.hasNext() == false) goto L58;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        r14.put(r17, r6.get(r17));
        goto L56
    L58:
        r21.put("request_interceptors_time", r14);
        HashMap r18 = new HashMap();
    L60:
        if (r15 >= this.d.interceptorResponseInfos.size()) goto L66;
        RetrofitMetrics.InterceptorInfo r19 = (RetrofitMetrics.InterceptorInfo) ZeusTransformUtils.preCheckCast(this.d.interceptorResponseInfos.get(r15), RetrofitMetrics.InterceptorInfo.class, "com.obric.memorydata.plugin");
        long r20 = r19.end - r19.start;
        Long r22 = (Long) ZeusTransformUtils.preCheckCast(r18.get(r19.name), Long.class, "com.obric.memorydata.plugin");
        String r23 = r19.name;
        if (r22 != null) goto L64;
        Long r24 = Long.valueOf(r20);
    L65:
        r18.put(r23, r24);
        r15 = r15 + 1;
        goto L60
    L64:
        r24 = Long.valueOf(r22.longValue() + r20);
        goto L65
    L66:
        JSONObject r0 = new JSONObject();
        Iterator r25 = r18.keySet().iterator();
    L68:
        if (r25.hasNext() == false) goto L70;
        String r26 = (String) ZeusTransformUtils.preCheckCast(r25.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r26, r18.get(r26));
        goto L68
    L70:
        r21.put("response_interceptors_time", r0);
        return;
    L80:
        return;
    L21:
        if (this.d.executeEndTime > 0) goto L23;
        r21.put("postprocess_time", -1);
        r21.put("cb_time", -1);
        r21.put("executeCallEndTime", this.d.executeCallEndTime);
        long r27 = this.d.executeEndTime;
        String r28 = "executeEndTime";
    L27:
        r21.put(r28, r27);
        r5 = this.d.executeCallEndTime - this.d.appCreateRetrofitStartUpTime;
        goto L29
    L23:
        if (this.d.interceptorResponseInfos.size() <= 0) goto L25;
        r21.put("postprocess_time", this.d.executeEndTime - ((RetrofitMetrics.InterceptorInfo) ZeusTransformUtils.preCheckCast(this.d.interceptorResponseInfos.get(0), RetrofitMetrics.InterceptorInfo.class, "com.obric.memorydata.plugin")).start);
    L25:
        r27 = this.d.executeCallEndTime - this.d.executeEndTime;
        r28 = "cb_time";
        goto L27
    L31:
        if (this.d.enqueueTime <= 0) goto L45;
        r21.put("biz_before_time", this.d.enqueueTime - this.d.appCreateRetrofitStartUpTime);
        r21.put("queue_time", this.d.responseChainTime - this.d.enqueueTime);
        r21.put("preprocess_time", this.d.executeCallStartTime - this.d.responseChainTime);
        r21.put("realcall_time", this.d.executeCallEndTime - this.d.executeCallStartTime);
        r21.put("is_async", 1);
        if (this.L == true) goto L35;
        long r29 = SystemClock.uptimeMillis();
        r21.put("postprocess_time", this.d.enqueueCallbackStartTime - this.d.executeCallEndTime);
        r21.put("cb_time", r29 - this.d.enqueueCallbackStartTime);
        long r30 = r29 - this.d.appCreateRetrofitStartUpTime;
    L43:
        r21.put("biz_total_time", r30);
        goto L45
    L35:
        if (this.d.enqueueCallbackStartTime > 0) goto L37;
        r21.put("postprocess_time", -1);
        r21.put("cb_time", -1);
        r21.put("enqueueCallbackStartTime", this.d.enqueueCallbackStartTime);
        r21.put("executeCallEndTime", this.d.executeCallEndTime);
    L41:
        r30 = this.d.executeCallEndTime - this.d.appCreateRetrofitStartUpTime;
        goto L43
    L37:
        if (this.d.interceptorResponseInfos.size() <= 0) goto L39;
        r21.put("postprocess_time", this.d.enqueueCallbackStartTime - ((RetrofitMetrics.InterceptorInfo) ZeusTransformUtils.preCheckCast(this.d.interceptorResponseInfos.get(0), RetrofitMetrics.InterceptorInfo.class, "com.obric.memorydata.plugin")).start);
    L39:
        r21.put("cb_time", this.d.executeCallEndTime - this.d.enqueueCallbackStartTime);
        goto L41
    L15:
        r7 = 0;
        goto L16
    L5:
        if (r2.i <= 0) goto L7;
        r21.put("protect_timeout", this.c.i);
        r21.put("connect_timeout", this.c.f);
        r21.put("read_timeout", this.c.h);
        long r31 = this.c.g;
    L8:
        r21.put("write_timeout", r31);
        goto L9
    L7:
        r21.put("connect_timeout", this.c.c);
        r21.put("read_timeout", this.c.d);
        r31 = this.c.e;
        goto L8
    }

    public void a(RetrofitMetrics r3) {
        r3.requestInfo = new WeakReference(this);
        this.d = r3;
        long r0 = r3.retrofit.eventTs.ssHttpCallApiStartTime;
        this.g = r0;
        this.e = r0;
        this.f = r3.ConvertToWallClockTimeMs(r3.retrofit.eventTs.requestInterceptorStart);
        this.A = r3.retrofit.misc.requestStartAppResumeState;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void generateOldFormatLog(JSONObject r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        a(r1);
        b(r1);
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setAccountRetryCallbackDuration(long r1) {
        this.X = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setBdTuringCallbackDuration(long r1) {
        this.U = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelDns(long r1) {
        this.n = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelPush(long r1) {
        this.r = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelReceiveBody(long r1) {
        this.t = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelSend(long r1) {
        this.q = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTCPConnect(long r1) {
        this.o = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTTFB(long r1) {
        this.s = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTls(long r1) {
        this.p = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTotal(long r1) {
        this.u = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setNetworkKernelRawRequestLog(String r1) {
        this.f2361J = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setRequestEnd(long r1) {
        this.j = r1;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setRequestEndAppResumeState(long r1) {
        this.B = r1;
    }
}
