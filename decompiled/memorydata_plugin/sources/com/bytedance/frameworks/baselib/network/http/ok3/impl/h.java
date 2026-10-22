package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class h extends EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f2469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventListener f2470b;
    private final String c;

    public h(EventListener r2, j r3) {
        this.c = h.class.getSimpleName();
        this.f2470b = r2;
        this.f2469a = r3;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call r3) {
        Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.callEnd(r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.callEnd(r4);
    L5:
        this.f2469a.l();
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call r3, IOException r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.callFailed(r5, r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.callFailed(r5, r4);
    L5:
        this.f2469a.a(r4);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call r3) {
        Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.callStart(r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.callStart(r4);
    L5:
        this.f2469a.b();
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call r3, InetSocketAddress r4, Proxy r5, Protocol r6) {
        Call r7 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.connectEnd(r7, r4, r5, r6);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.connectEnd(r7, r4, r5, r6);
    L5:
        this.f2469a.a(r5);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call r7, InetSocketAddress r8, Proxy r9, Protocol r10, IOException r11) {
        Call r12 = (Call) ZeusTransformUtils.wrapperContextForParams(r7, Call.class, "com.obric.memorydata.plugin");
        super.connectFailed(r12, r8, r9, r10, r11);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L6;
        r0.connectFailed(r12, r8, r9, r10, r11);
        return;
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call r3, InetSocketAddress r4, Proxy r5) {
        Call r6 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.connectStart(r6, r4, r5);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.connectStart(r6, r4, r5);
    L5:
        this.f2469a.e();
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call r3, Connection r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        Connection r6 = (Connection) ZeusTransformUtils.wrapperContextForParams(r4, Connection.class, "com.obric.memorydata.plugin");
        super.connectionAcquired(r5, r6);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.connectionAcquired(r5, r6);
    L5:
        this.f2469a.a(r6);
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call r3, Connection r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        Connection r6 = (Connection) ZeusTransformUtils.wrapperContextForParams(r4, Connection.class, "com.obric.memorydata.plugin");
        super.connectionReleased(r5, r6);
        EventListener r2 = this.f2470b;
        if (r2 == null) goto L6;
        r2.connectionReleased(r5, r6);
        return;
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call r3, String r4, List<InetAddress> r5) {
        Call r6 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        List<InetAddress> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        super.dnsEnd(r6, r4, r7);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.dnsEnd(r6, r4, r7);
    L5:
        this.f2469a.d();
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call r3, String r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.dnsStart(r5, r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.dnsStart(r5, r4);
    L5:
        this.f2469a.c();
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call r3, long r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.requestBodyEnd(r5, r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.requestBodyEnd(r5, r4);
    L5:
        this.f2469a.a(r4);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call r3) {
        Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.requestBodyStart(r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.requestBodyStart(r4);
    L5:
        this.f2469a.i();
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call r3, Request r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.requestHeadersEnd(r5, r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.requestHeadersEnd(r5, r4);
    L5:
        this.f2469a.a(r4);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call r3) {
        Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.requestHeadersStart(r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.requestHeadersStart(r4);
    L5:
        this.f2469a.h();
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call r3, long r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.responseBodyEnd(r5, r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.responseBodyEnd(r5, r4);
    L5:
        this.f2469a.b(r4);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call r3) {
        Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.responseBodyStart(r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.responseBodyStart(r4);
    L5:
        this.f2469a.k();
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call r3, Response r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.responseHeadersEnd(r5, r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.responseHeadersEnd(r5, r4);
    L5:
        this.f2469a.a(r4);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call r3) {
        Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.responseHeadersStart(r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.responseHeadersStart(r4);
    L5:
        this.f2469a.j();
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call r3, Handshake r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.secureConnectEnd(r5, r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.secureConnectEnd(r5, r4);
    L5:
        this.f2469a.g();
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call r3) {
        Call r4 = (Call) ZeusTransformUtils.wrapperContextForParams(r3, Call.class, "com.obric.memorydata.plugin");
        super.secureConnectStart(r4);
        EventListener r0 = this.f2470b;
        if (r0 == null) goto L5;
        r0.secureConnectStart(r4);
    L5:
        this.f2469a.f();
    }
}
