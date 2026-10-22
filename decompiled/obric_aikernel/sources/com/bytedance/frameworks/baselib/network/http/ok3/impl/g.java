package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.q;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f1691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f1692c;

    public g(q r10, i r11) {
        this.f1692c = r10;
        this.f1691b = r11;
    }

    @Override // okhttp3.q
    public void B(okhttp3.e r10, z r11) {
        super.B(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.B(r10, r11);
    L5:
        this.f1691b.z(r11);
    }

    @Override // okhttp3.q
    public void C(okhttp3.e r10) {
        super.C(r10);
        q r11 = this.f1692c;
        if (r11 == null) goto L5;
        r11.C(r10);
    L5:
        this.f1691b.A();
    }

    @Override // okhttp3.q
    public void E(okhttp3.e r10, Handshake r11) {
        super.E(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.E(r10, r11);
    L5:
        this.f1691b.B();
    }

    @Override // okhttp3.q
    public void F(okhttp3.e r10) {
        super.F(r10);
        q r11 = this.f1692c;
        if (r11 == null) goto L5;
        r11.F(r10);
    L5:
        this.f1691b.C();
    }

    @Override // okhttp3.q
    public void c(okhttp3.e r10) {
        super.c(r10);
        q r11 = this.f1692c;
        if (r11 == null) goto L5;
        r11.c(r10);
    L5:
        this.f1691b.a();
    }

    @Override // okhttp3.q
    public void d(okhttp3.e r10, IOException r11) {
        super.d(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.d(r10, r11);
    L5:
        this.f1691b.b(r11);
    }

    @Override // okhttp3.q
    public void e(okhttp3.e r10, JSONObject r11) {
        super.e(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.e(r10, r11);
    L5:
        u2.a r13 = n.p();
        if (r13 == null) goto L9;
        r13.sendAppMonitorEvent(r11.toString(), "ttnet_insec_rect");
        return;
    }

    @Override // okhttp3.q
    public void g(okhttp3.e r10) {
        super.g(r10);
        q r11 = this.f1692c;
        if (r11 == null) goto L5;
        r11.g(r10);
    L5:
        this.f1691b.c();
    }

    @Override // okhttp3.q
    public void i(okhttp3.e r10, InetSocketAddress r11, Proxy r12, Protocol r13) {
        super.i(r10, r11, r12, r13);
        q r14 = this.f1692c;
        if (r14 == null) goto L5;
        r14.i(r10, r11, r12, r13);
    L5:
        this.f1691b.d(r12);
    }

    @Override // okhttp3.q
    public void j(okhttp3.e r10, InetSocketAddress r11, Proxy r12, Protocol r13, IOException r14) {
        super.j(r10, r11, r12, r13, r14);
        q r15 = this.f1692c;
        if (r15 == null) goto L6;
        r15.j(r10, r11, r12, r13, r14);
        return;
    }

    @Override // okhttp3.q
    public void k(okhttp3.e r10, InetSocketAddress r11, Proxy r12, Protocol r13, IOException r14, String r15) {
        super.k(r10, r11, r12, r13, r14, r15);
        q r16 = this.f1692c;
        if (r16 == null) goto L5;
        r16.j(r10, r11, r12, r13, r14);
    L5:
        this.f1691b.e(r11, r14, r15);
    }

    @Override // okhttp3.q
    public void l(okhttp3.e r10, InetSocketAddress r11, Proxy r12) {
        super.l(r10, r11, r12);
        q r13 = this.f1692c;
        if (r13 == null) goto L5;
        r13.l(r10, r11, r12);
    L5:
        this.f1691b.f();
    }

    @Override // okhttp3.q
    public void m(okhttp3.e r10, okhttp3.i r11) {
        super.m(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.m(r10, r11);
    L5:
        this.f1691b.g(r11);
    }

    @Override // okhttp3.q
    public void n(okhttp3.e r10, okhttp3.i r11) {
        super.n(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L6;
        r12.n(r10, r11);
        return;
    }

    @Override // okhttp3.q
    public void o(okhttp3.e r10, String r11, List<InetAddress> r12) {
        super.o(r10, r11, r12);
        q r13 = this.f1692c;
        if (r13 == null) goto L5;
        r13.o(r10, r11, r12);
    L5:
        this.f1691b.l();
    }

    @Override // okhttp3.q
    public void p(okhttp3.e r10, String r11, List<InetAddress> r12, String r13) {
        super.p(r10, r11, r12, r13);
        q r14 = this.f1692c;
        if (r14 == null) goto L5;
        r14.o(r10, r11, r12);
    L5:
        this.f1691b.m(r13);
    }

    @Override // okhttp3.q
    public void q(okhttp3.e r10, String r11) {
        super.q(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.q(r10, r11);
    L5:
        this.f1691b.n();
    }

    @Override // okhttp3.q
    public void t(okhttp3.e r10, long r11) {
        super.t(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.t(r10, r11);
    L5:
        this.f1691b.t(r11);
    }

    @Override // okhttp3.q
    public void u(okhttp3.e r10) {
        super.u(r10);
        q r11 = this.f1692c;
        if (r11 == null) goto L5;
        r11.u(r10);
    L5:
        this.f1691b.u();
    }

    @Override // okhttp3.q
    public void w(okhttp3.e r10, x r11) {
        super.w(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.w(r10, r11);
    L5:
        this.f1691b.v(r11);
    }

    @Override // okhttp3.q
    public void x(okhttp3.e r10) {
        super.x(r10);
        q r11 = this.f1692c;
        if (r11 == null) goto L5;
        r11.x(r10);
    L5:
        this.f1691b.w();
    }

    @Override // okhttp3.q
    public void y(okhttp3.e r10, long r11) {
        super.y(r10, r11);
        q r12 = this.f1692c;
        if (r12 == null) goto L5;
        r12.y(r10, r11);
    L5:
        this.f1691b.x(r11);
    }

    @Override // okhttp3.q
    public void z(okhttp3.e r10) {
        super.z(r10);
        q r11 = this.f1692c;
        if (r11 == null) goto L5;
        r11.z(r10);
    L5:
        this.f1691b.y();
    }
}
