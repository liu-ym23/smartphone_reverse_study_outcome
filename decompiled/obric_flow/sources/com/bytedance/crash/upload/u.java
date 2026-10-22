package com.bytedance.crash.upload;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f4162b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f4163a;

    static {
        f4162b = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};
    }

    public u(SSLSocketFactory r5) {
        this.f4163a = r5;
    }

    public static Socket a(Socket r5) {
        if ((r5 instanceof SSLSocket) == false) goto L5;
        ((SSLSocket) r5).setEnabledProtocols(f4162b);
        io.reactivex.exceptions.a.i("setEnabledProtocols TLS_ALL");
    L5:
        return r5;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r5, String r10, int r11, boolean r12) {
        return a(this.f4163a.createSocket(r5, r10, r11, r12));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f4163a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f4163a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r5, int r10) {
        return a(this.f4163a.createSocket(r5, r10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r5, int r10, InetAddress r11, int r12) {
        return a(this.f4163a.createSocket(r5, r10, r11, r12));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r5, int r10) {
        return a(this.f4163a.createSocket(r5, r10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r5, int r10, InetAddress r11, int r12) {
        return a(this.f4163a.createSocket(r5, r10, r11, r12));
    }
}
