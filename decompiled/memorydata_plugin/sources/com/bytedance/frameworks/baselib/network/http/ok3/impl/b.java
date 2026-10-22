package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.EventListener;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.http.HttpMethod;
import okhttp3.ttnet.TTNetUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.bytedance.frameworks.baselib.network.http.impl.a implements WeakHandler.IHandler {
    static final /* synthetic */ boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OkHttpClient f2457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Request f2458b;
    Response c;
    Call d;
    volatile j e;
    private final WeakHandler l;

    static {
    }

    public b(com.bytedance.retrofit2.client.Request r6) {
        super(r6);
        this.f2457a = null;
        this.e = null;
        this.g.G = 1;     // Catch: Exception -> L5
        this.g.K.put("hc", "SsOkHttp3Client");     // Catch: Exception -> L5
        this.g.K.put("hcv", o.h());     // Catch: Exception -> L5
    L7:
        com.bytedance.frameworks.baselib.network.http.b r7 = this.g;
        r7.H = o.e();
        com.bytedance.frameworks.baselib.network.http.b r8 = this.g;
        r8.I = o.f();
        if (k == false) goto L10;
    L14:
        RetrofitMetrics r9 = this.g.d;
        r9.fallbackReason = this.g.H;
        RetrofitMetrics r10 = this.g.d;
        r10.fallbackMessage = this.g.I;
        this.l = new WeakHandler(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.a().k().getLooper(), this);
        String r11 = this.f.getUrl();
        this.e = new j(this.g, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(o.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.e.a(r11, this.f.getMethod());
        return;
    L10:
        if (this.g.d != null) goto L14;
        throw new AssertionError();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private String a(String r12, String r13, List<Header> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().b() == true) goto L22;
        long r0 = System.currentTimeMillis();
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.d r16 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().a(new com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.k(r12, r13, r15));
        long r2 = System.currentTimeMillis();
        if (r16 == null) goto L30;
        this.e.a(this.f.getMethod(), r16.f2516a, r2 - r0, false, r16.c);
        if (r12.equals(r16.f2516a) == false) goto L9;
        return r12;
    L9:
        if (r16.f2516a.isEmpty() == false) goto L19;
        if (r16.f2517b.isEmpty() == true) goto L19;
        this.e.a(r16.d);
        StringBuilder r17 = new StringBuilder().append("ERR_TTNET_TRAFFIC_CONTROL_DROP");
        if (r16.d != (-555)) goto L15;
        String r18 = "";
    L17:
        throw new Exception(r17.append(r18).append(", ").append(r16.d).toString());
    L15:
        r18 = "_" + (-r16.d);
    L19:
        if (com.bytedance.frameworks.baselib.network.http.util.k.b(r16.f2516a) == true) goto L33;
        return r12;
    L33:
        return r16.f2516a;
    L30:
        return r12;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d("Ok3SsCall", "fallback to host replace map");
    L24:
        long r19 = System.currentTimeMillis();
        String r1 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j.a().b(r12);
        long r3 = System.currentTimeMillis();
        if (r12.equals(r1) == false) goto L27;
        return r12;
    L27:
        if (com.bytedance.frameworks.baselib.network.http.util.k.b(r1) == false) goto L35;
        this.e.a(this.f.getMethod(), r1, r3 - r19, true, null);
        return r1;
    L35:
        return r12;
    }

    private static /* synthetic */ Request a(com.bytedance.frameworks.baselib.network.http.c.a r4, Route r5, Response r6) {
        Iterator<Challenge> r7 = r6.challenges().iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        Challenge r0 = (Challenge) ZeusTransformUtils.preCheckCast(r7.next(), Challenge.class, "com.obric.memorydata.plugin");
        if ("Basic".equalsIgnoreCase(r0.scheme()) == false) goto L4;
        String r8 = Credentials.basic(r4.f2367a, r4.f2368b, r0.charset());
        if (TextUtils.equals(r8, r6.request().header("Proxy-Authorization")) == false) goto L12;
        return null;
    L12:
        return r6.request().newBuilder().header("Proxy-Authorization", r8).build();
    L13:
        return null;
    }

    private static RequestBody a(TypedOutput r2, RequestBody r3) {
        final TypedOutput r4 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r2, TypedOutput.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        if (r4 == null) goto L7;
        final MediaType r5 = MediaType.parse(r4.mimeType());
        return new AnonymousClass1(r5, r4);
    L7:
        return RequestBody.create(null, "body=null");
    }

    private void a(com.bytedance.frameworks.baselib.network.http.b r4) {
        long r0 = -1;
        r0 = r4.d.constructConnectionStart();     // Catch: Throwable -> L6
        this.f2457a = o.a();     // Catch: Throwable -> L6
        r4.d.constructConnectionEnd(r0);
        return;
    L6:
        th = move-exception;
        r4.d.constructConnectionEnd(r0);
        throw th;
    }

    private void a(com.bytedance.retrofit2.client.Request r13, com.bytedance.frameworks.baselib.network.http.b r14, Map<String, String> r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        long r2 = r14.d.configureConnectionStart();
        OkHttpClient.Builder r0 = this.f2457a.newBuilder();     // Catch: Throwable -> L108
        if (r14.c == 0) goto L6;
        r0.followRedirects(r14.c.t);     // Catch: Throwable -> L108
    L6:
        r0.connectTimeout(com.bytedance.frameworks.baselib.network.http.f.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
        r0.readTimeout(com.bytedance.frameworks.baselib.network.http.f.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
        r0.writeTimeout(com.bytedance.frameworks.baselib.network.http.f.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
        r0.proxy(o.g());     // Catch: Throwable -> L108
        r0.enableBoe(com.bytedance.frameworks.baselib.network.http.util.c.a());     // Catch: Throwable -> L108
        if (r14.c == 0) goto L31;
        com.bytedance.frameworks.baselib.network.http.c r4 = r14.c;     // Catch: Throwable -> L108
        if (r4.c <= 0) goto L12;
        r0.connectTimeout(r4.c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
    L12:
        if (r4.e <= 0) goto L15;
        r0.writeTimeout(r4.e, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
    L15:
        if (r4.d <= 0) goto L18;
        r0.readTimeout(r4.d, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L108
    L18:
        if (r4.y == false) goto L20;
        r0.proxy(Proxy.NO_PROXY);     // Catch: Throwable -> L108
    L20:
        final com.bytedance.frameworks.baselib.network.http.c.a r5 = r4.z;     // Catch: Throwable -> L108
        if (r5 != null) goto L23;
    L27:
        com.bytedance.frameworks.baselib.network.http.c.b r6 = r4.A;     // Catch: Throwable -> L108
        if (r6 == null) goto L30;
        r6.a(r0);     // Catch: Throwable -> L108
    L30:
        this.e.a(r4);     // Catch: Throwable -> L108
        goto L31
    L23:
        if (r5.f2367a == null) goto L27;
        if (r5.f2368b == null) goto L27;
        r0.proxyAuthenticator(new $$Lambda$b$56XvarWpEzGh9cXeies0Sbk1OQw(r5));     // Catch: Throwable -> L108
    L31:
        String r7 = r13.getUrl();     // Catch: Throwable -> L108
        String r8 = null;
        if (this.f2457a.eventListenerFactory() == null) goto L34;
        EventListener r9 = this.f2457a.eventListenerFactory().create(this.f2457a.newCall(new Request.Builder().originUrl(r7).url(r7).build()));     // Catch: Throwable -> L108
    L35:
        r0.eventListener(new h(r9, this.e));     // Catch: Throwable -> L108
        this.f2457a = r0.build();     // Catch: Throwable -> L108
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L108
        if (r13.isBypassDispatch() == false) goto L113;
    L41:
        List<Header> r10 = new ArrayList();     // Catch: Throwable -> L108
        long r11 = SystemClock.uptimeMillis();     // Catch: Throwable -> L108
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b r12 = new com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b();     // Catch: Throwable -> L108
        String r17 = com.bytedance.frameworks.baselib.network.http.ok3.impl.a.c.a().a(r7, r13, r12, r10);     // Catch: Throwable -> L108
        r12.e = SystemClock.uptimeMillis() - r11;     // Catch: Throwable -> L108
        this.e.a(r12);     // Catch: Throwable -> L108
        if (r10.isEmpty() == false) goto L44;
        r10 = r13.getHeaders();     // Catch: Throwable -> L108
    L44:
        String r18 = com.bytedance.frameworks.baselib.network.http.util.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(o.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r17, r10);     // Catch: Throwable -> L108
        Request.Builder r19 = new Request.Builder().originUrl(r18).url(r18);     // Catch: Throwable -> L108
        Iterator<Header> r3 = r1.iterator();     // Catch: Throwable -> L108
    L46:
        if (r3.hasNext() == false) goto L49;
        Header r20 = (Header) ZeusTransformUtils.preCheckCast(r3.next(), Header.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        r19.addHeader(r20.getName(), r20.getValue());     // Catch: Throwable -> L108
        goto L46
    L49:
        if (Logger.debug() == false) goto L52;
        r19.addHeader("fallback-reason", o.a(r13));     // Catch: Throwable -> L108
    L52:
        if (HttpMethod.permitsRequestBody(r13.getMethod()) == true) goto L54;
        Request.Builder r21 = r19.method(r13.getMethod(), null);     // Catch: Throwable -> L108
    L56:
        if (r13.getBody() != null) goto L58;
    L62:
        r21.addHeader(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L108
        Iterator<Header> r110 = r10.iterator();     // Catch: Throwable -> L108
    L65:
        if (r110.hasNext() == false) goto L76;
        Header r22 = (Header) ZeusTransformUtils.preCheckCast(r110.next(), Header.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        if (com.bytedance.common.utility.h.a(r22.getName()) == true) goto L65;
        if (com.bytedance.common.utility.h.a(r22.getValue()) == true) goto L65;
        if ("User-Agent".equals(r22.getName()) == false) goto L74;
        r8 = r22.getValue();     // Catch: Throwable -> L108
    L74:
        r21.header(r22.getName(), r22.getValue());     // Catch: Throwable -> L108
        goto L65
    L76:
        if (com.bytedance.common.utility.h.a(r8) == false) goto L81;
        r8 = com.bytedance.frameworks.baselib.network.http.f.l();     // Catch: Throwable -> L108
        if (com.bytedance.common.utility.h.a(r8) == true) goto L81;
        r8 = r8 + " " + o.h();     // Catch: Throwable -> L108
        r21.header("User-Agent", r8);     // Catch: Throwable -> L108
    L81:
        if (com.bytedance.common.utility.h.a(r8) == false) goto L117;
        r8 = o.b();     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r8) == true) goto L117;
        r21.header("User-Agent", r8);     // Catch: Throwable -> L108
    L117:
        r14.K.put("ua", r8);     // Catch: Exception -> L87 Throwable -> L108
    L89:
        if (r16 != null) goto L91;
    L100:
        Request r111 = r21.build();     // Catch: Throwable -> L108
        this.f2458b = r111;     // Catch: Throwable -> L108
        this.d = this.f2457a.newCall(r111);     // Catch: Throwable -> L108
        r14.v = new URL(r18);     // Catch: Exception -> L103 Throwable -> L108
    L105:
        r14.d.url = r14.v;     // Catch: Throwable -> L108
        r14.d.configureConnectionEnd(r2);
        return;
    L103:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L108
        goto L105
    L91:
        if (r16.isEmpty() == true) goto L100;
        Iterator r112 = r16.entrySet().iterator();     // Catch: Throwable -> L108
    L94:
        if (r112.hasNext() == false) goto L100;
        Map.Entry r113 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        String r23 = (String) ZeusTransformUtils.preCheckCast(r113.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r23) == true) goto L94;
        if (TextUtils.isEmpty(r114) == true) goto L94;
        r21.addHeader(r23, r114);     // Catch: Throwable -> L108
        goto L94
    L87:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L108
        goto L89
    L58:
        if (r13.isPureRequest() == true) goto L62;
        String r115 = r13.getBody().md5Stub();     // Catch: Throwable -> L108
        if (r115 == null) goto L62;
        r21.addHeader("X-SS-STUB", r115);     // Catch: Throwable -> L108
        goto L62
    L54:
        r21 = r19.method(r13.getMethod(), a(r13.getBody(), r13.getRequestBody()));     // Catch: Throwable -> L108
        goto L56
    L113:
        r7 = a(r7, r13.getMethod(), r1);     // Catch: Exception -> L39 Throwable -> L108
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L108
        goto L41
    L34:
        r9 = null;
    L108:
        th = move-exception;
        r14.d.configureConnectionEnd(r2);
        throw th;
    }

    public static /* synthetic */ Request lambda$56XvarWpEzGh9cXeies0Sbk1OQw(com.bytedance.frameworks.baselib.network.http.c.a r0, Route r1, Response r2) {
        return a(r0, r1, r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public int a(IOException r1) {
        return TTNetUtils.convertExceptionToErrorCode(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public IOException a(Exception r9) {
        if (ZeusTransformUtils.instanceOf(r9, TTNetExceptionStorage.class) == false) goto L6;
        ((TTNetExceptionStorage) ZeusTransformUtils.preCheckCast(r9, TTNetExceptionStorage.class, "com.obric.memorydata.plugin")).setInfo(false, true, this.f.getUrl(), this.g.P, this.g);
        return (TTNetExceptionStorage) ZeusTransformUtils.preCheckCast(r9, TTNetExceptionStorage.class, "com.obric.memorydata.plugin");
    L6:
        TTNetExceptionStorage r6 = new TTNetExceptionStorage(r9.getMessage(), r9);
        r6.setInfo(false, true, this.f.getUrl(), this.g.P, this.g);
        return r6;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public String a(String r1) {
        Response r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.header(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(com.bytedance.frameworks.baselib.network.http.b r3, com.bytedance.frameworks.baselib.network.http.impl.c r4) {
        super.a(r3, (com.bytedance.frameworks.baselib.network.http.impl.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.frameworks.baselib.network.http.impl.c.class, "com.obric.memorydata.plugin"));
        if (o.c() == null) goto L6;
        o.c().a(this.f2458b, this.c);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(RetrofitMetrics r4) {
        if (this.d == null) goto L10;
        long r0 = r4.executeConnectionStart();
        this.c = this.d.execute();     // Catch: Throwable -> L7
        this.e.b(this.c);     // Catch: Throwable -> L7
        r4.executeConnectionEnd(r0);
        return;
    L7:
        th = move-exception;
        r4.executeConnectionEnd(r0);
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(TypedInput r6) {
        TypedInput r7 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r6, TypedInput.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (this.f.isResponseStreaming() == false) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, TypedByteArray.class) == false) goto L17;
        this.g.d.postProcessBodyStart();
        com.bytedance.frameworks.baselib.network.http.d.b.a().a(this.c, this.f.getUrl(), ((TypedByteArray) ZeusTransformUtils.preCheckCast(r7, TypedByteArray.class, "com.obric.memorydata.plugin")).getBytes());     // Catch: Throwable -> L12
    L10:
        this.g.d.postProcessBodyEnd();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void a(String r3, com.bytedance.retrofit2.client.Request r4, com.bytedance.frameworks.baselib.network.http.b r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        r5.d.prepareConnectionStart();     // Catch: Throwable -> L6 Exception -> L8
        a(r5);     // Catch: Throwable -> L6 Exception -> L8
        a(r4, r5, r7);     // Catch: Throwable -> L6 Exception -> L8
        r5.d.prepareConnectionEnd();
        return;
    L8:
        e = move-exception;
        throw TTNetExceptionStorage.wrapIfNeeded(e, r3, r5.P, r5);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r5.d.prepareConnectionEnd();
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void b(Exception r2) {
        if (o.c() == null) goto L6;
        o.c().a(this.f2458b, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public int c() {
        Response r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.code();
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        Call r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isCanceled() == true) goto L10;
        this.e.a();
        this.d.cancel();
        this.i = true;
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public long d() {
        Response r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r0.body() == null) goto L7;
        return this.c.body().contentLength();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public String e() {
        Response r0 = this.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.body() == null) goto L12;
        MediaType r2 = this.c.body().contentType();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.toString();
    L12:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public Map<String, List<String>> f() {
        Response r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.headers().toMultimap();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public InputStream g() {
        Response r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.body() == null) goto L7;
        return this.c.body().byteStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(o.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public InputStream h() {
        return null;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public String i() {
        Response r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.message();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public boolean j() {
        return NetConst.GZIP.equalsIgnoreCase(this.c.header(NetConst.KEY_CONTENT_ENCODING));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public void k() {
        Response r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        Call r1 = this.d;
        if (r1 == null) goto L11;
        r1.cancel();
        return;
    L11:
        return;
    L5:
        if (r0.body() == null) goto L7;
        com.bytedance.frameworks.baselib.network.http.parser.d.a(this.c.body());
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.c
    public boolean l() {
        Response r0 = this.c;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.cacheResponse() != null) goto L9;
        return false;
    L9:
        if (this.c.networkResponse() != null) goto L11;
        return true;
    L11:
        if (this.c.code() == 304) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public boolean m() {
        return this.h;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a
    public void n() {
        if (o.d() == true) goto L6;
        return;
    L6:
        throw new NotAllowUseNetworkException("request is not allowed using network");
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r1) {
        return false;
    }
}
