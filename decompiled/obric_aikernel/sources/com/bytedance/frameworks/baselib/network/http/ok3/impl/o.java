package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class o extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f1798b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f1799a;

    static {
        f1798b = new String[]{"TLSv1.2"};
    }

    public o(SSLSocketFactory r10) {
        this.f1799a = r10;
    }

    private Socket a(Socket r10) {
        if ((r10 instanceof SSLSocket) == false) goto L5;
        ((SSLSocket) r10).setEnabledProtocols(f1798b);
    L5:
        return r10;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r10, int r11) {
        return a(this.f1799a.createSocket(r10, r11));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r10, int r11, InetAddress r12, int r13) {
        return a(this.f1799a.createSocket(r10, r11, r12, r13));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r10, int r11) {
        return a(this.f1799a.createSocket(r10, r11));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r10, int r11, InetAddress r12, int r13) {
        return a(this.f1799a.createSocket(r10, r11, r12, r13));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r10, String r11, int r12, boolean r13) {
        return a(this.f1799a.createSocket(r10, r11, r12, r13));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f1799a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f1799a.getSupportedCipherSuites();
    }
}
