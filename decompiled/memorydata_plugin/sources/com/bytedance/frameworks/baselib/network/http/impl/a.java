package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.h;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.frameworks.baselib.network.http.i;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.d;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitLayerMetrics;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements c, IRequestInfo, SsCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2441a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f2442b = false;
    static final /* synthetic */ boolean j = true;
    protected Request f;
    protected com.bytedance.frameworks.baselib.network.http.b g;
    protected boolean h;
    protected volatile boolean i;

    static {
    }

    public a(Request r4) {
        this.h = false;
        this.i = false;
        this.f = r4;
        this.g = com.bytedance.frameworks.baselib.network.http.b.a();
        if (r4.getMetrics() == null) goto L6;
        this.g.a(r4.getMetrics());
    L6:
        if (j == false) goto L8;
    L12:
        this.g.d.ResetNetworkLibMetrics();
        RetrofitLayerMetrics.EventTimestamp r5 = this.g.d.retrofit.eventTs;
        r5.cronetInitStart = TTNetInitMetrics.c().o;
        RetrofitLayerMetrics.EventTimestamp r6 = this.g.d.retrofit.eventTs;
        r6.cronetInitEnd = TTNetInitMetrics.c().L;
        this.g.d.ttnetVersion = "4.2.243.22-doubao";
        com.bytedance.frameworks.baselib.network.http.b r7 = this.g;
        r7.L = this.f.isResponseStreaming();
        if (ZeusTransformUtils.instanceOf(this.f.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L22;
        com.bytedance.frameworks.baselib.network.http.b r8 = this.g;
        r8.c = (T) ZeusTransformUtils.preCheckCast(this.f.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin");
        this.h = this.g.c.n;
        List<com.bytedance.frameworks.baselib.network.http.c.C0124c> r9 = this.g.c.B;
        if (r9 != null) goto L17;
        return;
    L17:
        if (r9.size() > 0) goto L19;
        return;
    L19:
        if (r9.size() > 3) goto L25;
        com.bytedance.frameworks.baselib.network.http.b r3 = this.g;
        r3.Z = new i(r9);
        return;
    L25:
        return;
    L22:
        return;
    L8:
        if (this.g.d != null) goto L12;
        throw new AssertionError();
    }

    public static TypedInput a(String r11, final Request r12, final com.bytedance.frameworks.baselib.network.http.b r13, c r14, SsCall r15) {
        final c r16 = (c) ZeusTransformUtils.wrapperContextForParams(r14, c.class, "com.obric.memorydata.plugin");
        final SsCall r17 = (SsCall) ZeusTransformUtils.wrapperContextForParams(r15, SsCall.class, "com.obric.memorydata.plugin");
        r13.d.processResponseBodyStart();
        boolean r0 = b(r13);     // Catch: Throwable -> L66
        TypedInput r1 = new AnonymousClass1(r16, r13, r12, r17);     // Catch: Throwable -> L66
        if (r12.isResponseStreaming() == true) goto L6;
    L10:
        r13.d.markReadResponseBodyInternal();     // Catch: Throwable -> L66
        if (f2441a == true) goto L13;
    L15:
        boolean r9 = false;
    L16:
        boolean r10 = r13.f2362a;     // Catch: Throwable -> L66
        InputStream r18 = null;
        String r19 = null;
        r19 = null;
        r19 = null;
        r19 = null;
        r19 = null;
        r19 = null;
        int[] r7 = new int[1];     // Catch: Throwable -> L63
        InputStream r2 = r1.in();     // Catch: Throwable -> L63
        byte[] r3 = d.a(r16.j(), r12.getMaxLength(), r2, r7, r13.d, r9, r10);     // Catch: Throwable -> L61
        d.a(r2);     // Catch: Throwable -> L66
        if (a(r12, r16) == true) goto L51;
        if (r0 == true) goto L51;
        if (r3 != null) goto L26;
    L44:
        HttpResponseException r6 = new HttpResponseException(r16.c(), "", r12.getPath(), r19);     // Catch: Throwable -> L66
        if (r12.isResponseStreaming() == false) goto L47;
    L48:
        r6.setInfo(true, false, r11, r13.P, r13);     // Catch: Throwable -> L66
        throw r6;     // Catch: Throwable -> L66
    L47:
        if (r16.c() == 304) goto L48;
        throw r6;     // Catch: Throwable -> L66
    L26:
        if (r3.length <= 0) goto L44;
        if (h.a(r16.e()) == true) goto L44;
        if (Logger.debug() == false) goto L32;
    L72:
        MimeType r4 = new MimeType(r16.e());     // Catch: Throwable -> L42
        if (IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT.equalsIgnoreCase(r4.getPrimaryType()) == false) goto L36;
    L37:
        String r5 = r4.getParameter("charset");     // Catch: Throwable -> L42
        if (h.a(r5) == false) goto L40;
        r5 = "utf-8";
    L40:
        r19 = new String(r3, r5);     // Catch: Throwable -> L42
        goto L44
    L36:
        if ("application/json".equalsIgnoreCase(r4.getBaseType()) == false) goto L44;
    L42:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
        goto L44
    L32:
        if (a(r13) == false) goto L44;
    L51:
        if (d.a(r16.e()) == false) goto L54;
        if (r3 == null) goto L54;
        d.a(r3, r3.length);     // Catch: Throwable -> L66
    L54:
        String r110 = r16.e();     // Catch: Throwable -> L66
        if (r3 != null) goto L58;
        r3 = new byte[0];     // Catch: Throwable -> L66
    L58:
        TypedByteArray r111 = new TypedByteArray(r110, r3, new String[0]);     // Catch: Throwable -> L66
        r13.d.processResponseBodyEnd();
        return r111;
    L61:
        th = th;
        r18 = r2;
    L64:
        d.a(r18);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L63:
        th = th;
        goto L64
    L13:
        if (f2442b == false) goto L15;
        r9 = true;
        goto L16
    L6:
        if (a(r12, r16) == true) goto L8;
        if (r0 == false) goto L10;
    L8:
        r13.d.processResponseBodyEnd();
        return r1;
    L66:
        th = move-exception;
        r13.d.processResponseBodyEnd();
        throw th;
    }

    public static String a(com.bytedance.frameworks.baselib.network.http.b r9, Map<String, List<String>> r10, int r11, InputStream r12, String r13, boolean r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L36;
        return null;
    L36:
        r12 = d.a(r12, r15, r14, r9.d);     // Catch: Throwable -> L29 Exception -> L31
        byte[] r16 = d.a(r14, r11, r12, new int[1], r9.d, false, r9.f2362a);     // Catch: Throwable -> L29 Exception -> L31
        d.a(r12);
        if (r16 != null) goto L10;
        return null;
    L10:
        if (r16.length > 0) goto L12;
        return null;
    L12:
        if (h.a(r13) == false) goto L14;
        return null;
    L14:
        if (Logger.debug() == false) goto L16;
    L38:
        MimeType r17 = new MimeType(r13);     // Catch: Throwable -> L26
        if (IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT.equalsIgnoreCase(r17.getPrimaryType()) == false) goto L20;
    L21:
        String r18 = r17.getParameter("charset");     // Catch: Throwable -> L26
        if (h.a(r18) == false) goto L24;
        r18 = "utf-8";
    L24:
        return new String(r16, r18);
    L20:
        if ("application/json".equalsIgnoreCase(r17.getBaseType()) == true) goto L21;
        return null;
    L26:
        th = move-exception;
        th.printStackTrace();
        return null;
    L16:
        if (a(r9) == true) goto L38;
        return null;
    L29:
        th = move-exception;
        d.a(r12);
        throw th;
    L31:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L29
    }

    private static String a(Map<String, List<String>> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L37;
    L36:
        return "";
    L37:
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L5:
        if (r10.isEmpty() == true) goto L36;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L34
        Iterator r11 = r10.entrySet().iterator();     // Catch: Throwable -> L34
    L9:
        if (r11.hasNext() == false) goto L32;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r3 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (h.a(r4) == true) goto L9;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r5 == null) goto L9;
        if (r5.isEmpty() == true) goto L9;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L34
        int r7 = 0;
        Iterator r8 = r5.iterator();     // Catch: Throwable -> L34
    L23:
        if (r8.hasNext() == false) goto L31;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (h.a(r12) == true) goto L23;
        if (r7 != 0) goto L29;
        r6.append(r12);     // Catch: Throwable -> L34
    L30:
        r7 = r7 + 1;     // Catch: Throwable -> L34
        goto L23
    L29:
        r6.append("; ").append(r12);     // Catch: Throwable -> L34
        goto L30
    L31:
        r2.put(r4, r6.toString());     // Catch: Throwable -> L34
        goto L9
    L32:
        return r2.toString();
    }

    public static List<Header> a(c r8, List<String> r9) {
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Map<String, List<String>> r12 = r10.f();
        if (r12 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r13 = r12.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L26;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L22;
        if (r11 == null) goto L22;
        if (r11.isEmpty() == true) goto L22;
        boolean r4 = false;
        Iterator r5 = r11.iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        if (r3.equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r4 = true;
    L20:
        if (r4 == true) goto L8;
    L22:
        Iterator r6 = ((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r6.hasNext() == false) goto L8;
        r0.add(new Header(r3, (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin")));
        goto L24
    L26:
        return r0;
    }

    public static void a(com.bytedance.frameworks.baselib.network.http.b r2, c r3, Exception r4) {
        String r5 = a(((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin")).f());     // Catch: Throwable -> L14
        if (h.a(r5) == true) goto L6;
        r2.K.put("response-headers", r5);     // Catch: Throwable -> L14
    L6:
        String r6 = r4.getMessage();     // Catch: Throwable -> L14
        Throwable r0 = r4.getCause();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r6) == true) goto L12;
        if (r0 == null) goto L12;
        if (TextUtils.isEmpty(r0.getMessage()) == true) goto L12;
        r6 = r6 + ", cause = " + r0.getMessage();     // Catch: Throwable -> L14
    L12:
        r2.K.put("ex", r6);     // Catch: Throwable -> L14
    L17:
        if (h.a(r2.w) == false) goto L22;
        a(c(r4), r2);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    private void a(Request r8, int r9, com.bytedance.frameworks.baselib.network.http.b r10, c r11, IOException r12, boolean r13) {
        c r14 = (c) ZeusTransformUtils.wrapperContextForParams(r11, c.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.h r15 = f.a(r8, r9, r10, r8.getHeaders(), null, r13, false);
        if (r15 != null) goto L5;
        throw r12;
    L5:
        if (r15.a() == true) goto L7;
        throw r12;
    L7:
        if (r10.Y == false) goto L12;
        a(r8.newBuilder().url(r15.d()).build(), r10, r14, r15.c());
        return;
    L12:
        throw r12;
    }

    public static void a(Request r1, com.bytedance.frameworks.baselib.network.http.b r2) {
        f.a(r2.d);
        if (com.bytedance.frameworks.baselib.network.http.cookie.a.a(r1.getExtraInfo()) == true) goto L10;
        r2.d.tryInitCookieManagerStart();
        com.bytedance.frameworks.baselib.network.http.cookie.a.b();     // Catch: Throwable -> L7
        r2.d.tryInitCookieManagerEnd();
        return;
    L7:
        th = move-exception;
        r2.d.tryInitCookieManagerEnd();
        throw th;
    }

    private static void a(String r1, com.bytedance.frameworks.baselib.network.http.b r2) {
        if (h.a(r1) == false) goto L10;
        return;
    L10:
        r2.w = r1;     // Catch: Throwable -> L9
        if (r2.c == 0) goto L12;
        r2.c.f2365a = r1;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private static boolean a(com.bytedance.frameworks.baselib.network.http.b r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.c == 0) goto L8;
        if (r1.c.k == false) goto L8;
        return true;
    }

    private static boolean a(Request r3, c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        if (r3.isResponseStreaming() == false) goto L12;
        if (r5.c() < 200) goto L10;
        if (r5.c() >= 300) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r5.c() != 200) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean b(com.bytedance.frameworks.baselib.network.http.b r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.c == 0) goto L8;
        if (r1.c.j == false) goto L8;
        return true;
    }

    private static String c(Exception r3) {
        if (r3 != null) goto L18;
        return "";
    L18:
        String r1 = r3.getMessage();     // Catch: Throwable -> L15
        if (r1 != null) goto L8;
    L14:
        return "";
    L8:
        if (TextUtils.isEmpty(r3.getMessage()) == true) goto L14;
        String[] r4 = r1.split("\\|");     // Catch: Throwable -> L15
        if (r4.length < 2) goto L17;
        return r4[0];
    L17:
        return "";
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public static void c(boolean r0) {
        f2441a = r0;
    }

    public static void d(boolean r0) {
        f2442b = r0;
    }

    public int a(IOException r1) {
        return -1;
    }

    public IOException a(Exception r2) {
        return new IOException(r2.getMessage(), r2.getCause());
    }

    public List<String> a(Request r8, com.bytedance.frameworks.baselib.network.http.b r9, c r10, boolean r11, boolean r12) {
        c r13 = (c) ZeusTransformUtils.wrapperContextForParams(r10, c.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.h r14 = f.a(r8, r13.c(), r9, r8.getHeaders(), r13.f(), r11, r12);
        ArrayList r15 = null;
        if (r14 == null) goto L12;
        if (r14.a() == false) goto L12;
        if (r9.Y == false) goto L9;
        r8 = r8.newBuilder().url(r14.d()).build();
    L9:
        a(r8, r9, r13, r14.c());
        return null;
    L12:
        if (h.a(r9.V) == true) goto L19;
        if (r14 != null) goto L15;
    L16:
        r15 = new ArrayList();
        if (h.a(r9.V) == true) goto L19;
        r15.add(r9.V);
        goto L19
    L15:
        if (r14.b() == true) goto L16;
    L19:
        return r15;
    }

    public void a(com.bytedance.frameworks.baselib.network.http.b r5, c r6) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        long r0 = System.currentTimeMillis();
        r5.h = r0;
        r5.i = r0;
        r5.O = com.bytedance.frameworks.baselib.network.http.a.a(r4.e());
        a(r4.a("x-net-info.remoteaddr"), r5);
        if (r5.c == 0) goto L5;
        T r7 = r5.c;
        r7.f2366b = r4.c();
    L5:
        r5.P = r4.a("X-TT-LOGID");
        if (r5.P != null) goto L9;
        r5.P = "";
    L9:
        if (j == false) goto L11;
    L15:
        RetrofitMetrics r8 = r5.d;
        r8.traceCode = r5.P;
        r5.F = r4.l();
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        if (r5.U < 0) goto L20;
        r5.K.put("turing_callback", r5.U);     // Catch: Throwable -> L40
    L20:
        if (r5.X < 0) goto L24;
        r5.K.put("retry_for_account_cost", r5.X);     // Catch: Throwable -> L40
    L24:
        if (r5.T == false) goto L27;
        r5.K.put("turing_retry", "1");     // Catch: Throwable -> L40
    L27:
        if (r5.W == false) goto L30;
        r5.K.put("account_retry", "1");     // Catch: Throwable -> L40
    L30:
        if (r5.V == null) goto L33;
        r5.K.put("retry_by_header", r5.V);     // Catch: Throwable -> L40
    L33:
        if (r5.Z == null) goto L45;
        JSONObject r9 = r5.Z.c();     // Catch: Throwable -> L40
        if (r9 != null) goto L37;
        return;
    L37:
        if (r9.length() <= 0) goto L47;
        r5.K.put("rotation_host_retry", r9);     // Catch: Throwable -> L40
        r5.d.setRotationHostRetryInfo(r9);     // Catch: Throwable -> L40
        return;
    L47:
        return;
    L45:
        return;
    L11:
        if (r5.d != null) goto L15;
        throw new AssertionError();
    }

    public abstract void a(RetrofitMetrics r1);

    public void a(Request r10, com.bytedance.frameworks.baselib.network.http.b r11, c r12, Map<String, String> r13) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r12, c.class, "com.obric.memorydata.plugin");
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        r6.k();
        r11.aa = System.currentTimeMillis();
        a(r10.getUrl(), r10, r11, r14);
        a(r11.d);     // Catch: IOException -> L5
        a(r10, r11, this, false, false);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        a(r10, a(e), r11, r6, e, false);
    }

    public void a(Request r1, Exception r2) {
    }

    public void a(TypedInput r2) {
        TypedInput r1 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r2, TypedInput.class, "com.obric.memorydata.plugin");
    }

    public abstract void a(String r1, Request r2, com.bytedance.frameworks.baselib.network.http.b r3, Map<String, String> r4);

    public void b(Exception r1) {
    }

    public Response execute() {
        if (this.i == true) goto L80;
        n();
        a(this.f, this.g);
        o();
        long r0 = System.nanoTime();
        this.f = com.bytedance.frameworks.baselib.network.d.d.a(this.f, this.g);     // Catch: Throwable -> L81
    L6:
        boolean r2 = true;
        boolean r3 = false;
        a(this.f.getUrl(), this.f, this.g, null);     // Catch: Throwable -> L46 Exception -> L48
    L44:
        e = move-exception;
        Exception r4 = e;
        r2 = false;
    L53:
        if (r2 == true) goto L67;
        b(r4);     // Catch: Throwable -> L46
        if (ZeusTransformUtils.instanceOf(r4, HttpResponseException.class) == false) goto L61;
        if (((HttpResponseException) ZeusTransformUtils.preCheckCast(r4, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode() != 304) goto L61;
        throw r4;     // Catch: Throwable -> L46
    L61:
        if (ZeusTransformUtils.instanceOf(r4, IOException.class) == true) goto L63;
    L65:
        a(this.f, r4);     // Catch: Throwable -> L46
        throw a(r4);     // Catch: Throwable -> L46
    L63:
        if ("Canceled".equals(r4.getMessage()) == false) goto L65;
        throw r4;     // Catch: Throwable -> L46
    L67:
        throw r4;     // Catch: Throwable -> L46
    L9:
        if (this.f.isResponseStreaming() == true) goto L16;
        f.i r5 = f.i();     // Catch: Exception -> L44 Throwable -> L46
        if (r5 == null) goto L16;
        if (r5.shouldSampling(this.f.getUrl()) == false) goto L16;
        com.bytedance.frameworks.baselib.network.connectionclass.b.a().b();     // Catch: Exception -> L44 Throwable -> L46
    L93:
        List<String> r6 = new ArrayList();     // Catch: Throwable -> L40 Exception -> L42
        a(this.g.d);     // Catch: Throwable -> L22 IOException -> L24
        r6 = a(this.f, this.g, this, true, false);     // Catch: Throwable -> L22 IOException -> L24
        RetrofitMetrics r7 = this.g.d;     // Catch: Throwable -> L40 Exception -> L42
    L20:
        r7.setConstructConfigureAndRetryConnection(r0);     // Catch: Throwable -> L40 Exception -> L42
        a(this.g, this);     // Catch: Throwable -> L40 Exception -> L42
        TypedInput r12 = a(this.f.getUrl(), this.f, this.g, this, this);     // Catch: Throwable -> L40 Exception -> L42
        a(r12);     // Catch: Throwable -> L40 Exception -> L42
        Response r1 = new Response(this.f.getUrl(), c(), i(), a(this, r6), r12);     // Catch: Throwable -> L40 Exception -> L42
        r1.setExtraInfo(this.g);     // Catch: Throwable -> L40 Exception -> L42
        r1.setTraceCode(this.g.P);     // Catch: Throwable -> L40 Exception -> L42
        if (this.f.isResponseStreaming() == true) goto L34;
        k();
    L34:
        if (this.f.isResponseStreaming() == true) goto L37;
        if (r2 == false) goto L37;
        com.bytedance.frameworks.baselib.network.connectionclass.b.a().c();
    L37:
        return r1;
    L22:
        th = move-exception;
        this.g.d.setConstructConfigureAndRetryConnection(r0);     // Catch: Throwable -> L40 Exception -> L42
        throw th;     // Catch: Throwable -> L40 Exception -> L42
    L24:
        e = move-exception;
        a(this.f, a(e), this.g, this, e, true);     // Catch: Throwable -> L22
        r7 = this.g.d;     // Catch: Throwable -> L40 Exception -> L42
    L42:
        e = move-exception;
        r4 = e;
        r2 = false;
    L40:
        th = th;
        r3 = r2;
    L68:
        if (0 == 0) goto L71;
        a(this.g, this, null);
    L71:
        if (this.f.isResponseStreaming() == false) goto L73;
        if (0 != 0) goto L73;
    L75:
        if (this.f.isResponseStreaming() == true) goto L78;
        if (r3 == false) goto L78;
        com.bytedance.frameworks.baselib.network.connectionclass.b.a().c();
    L78:
        throw th;
    L73:
        k();
    L16:
        r2 = false;
    L46:
        th = th;
    L48:
        e = move-exception;
        this.g.d.setConstructConfigureAndRetryConnection(r0);     // Catch: Throwable -> L46 Exception -> L51
        throw e;     // Catch: Throwable -> L46 Exception -> L51
    L51:
        e = move-exception;
        r4 = e;
        goto L53
    L80:
        throw new IOException("request canceled");
    }

    public abstract Context getContext();

    @Override // com.bytedance.retrofit2.client.SsCall
    public Request getRequest() {
        return this.f;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        return this.g;
    }

    public boolean m() {
        return false;
    }

    public void n() {
    }

    public void o() {
        if (m() == false) goto L5;
        return;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L7;
        return;
    L7:
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L13;
        NetworkNotAvailabeException r0 = new NetworkNotAvailabeException("network not available for " + this.f.getPath());
        r0.setInfo(false, false, this.f.getUrl(), "", this.g);
        throw r0;
    }
}
