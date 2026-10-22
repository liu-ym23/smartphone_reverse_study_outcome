package com.loc;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import n4a.f5;
import n4a.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends SSLSocketFactory {
    public final SSLSocketFactory a;
    public final Context b;
    public final SSLContext c;

    public e(Context r4, SSLContext r5) {
        if (r4 != null) goto L55;
    L5:
        this.c = r5;     // Catch: Throwable -> L20
        if (r5 == null) goto L8;
        this.a = r5.getSocketFactory();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r.f(th, "myssl", "<init>");     // Catch: Throwable -> L35
    L26:
        th = move-exception;
        r.f(th, "myssl", "<init2>");
    L59:
    L32:
        th = move-exception;
        r.f(th, "myssl", "<init3>");
        return;
    L29:
        if (this.a != null) goto L66;
        this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L32
        return;
    L66:
        return;
    L23:
        if (this.c != null) goto L59;
        this.c = SSLContext.getDefault();     // Catch: Throwable -> L26
    L35:
        th = move-exception;
    L40:
        th = move-exception;
        r.f(th, "myssl", "<init2>");
    L63:
    L46:
        th = move-exception;
        r.f(th, "myssl", "<init3>");
        throw th;
    L43:
        if (this.a != null) goto L67;
        this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L46
        throw th;
    L67:
        throw th;
    L37:
        if (this.c != null) goto L63;
        this.c = SSLContext.getDefault();     // Catch: Throwable -> L40
    L8:
        if (r5 != null) goto L53;
        this.c = SSLContext.getDefault();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r.f(th, "myssl", "<init2>");
    L53:
    L17:
        th = move-exception;
        r.f(th, "myssl", "<init3>");
        return;
    L14:
        if (this.a != null) goto L65;
        this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L17
        return;
    L65:
        return;
    L55:
        this.b = r4.getApplicationContext();     // Catch: Throwable -> L20
        goto L5
    }

    public static void b(Socket r2) {
    L8:
        th = move-exception;
        r.f(th, "myssl", "stlv2");
        return;
    L3:
        if (i.g.b == true) goto L5;
        return;
    L5:
        if ((r2 instanceof SSLSocket) == false) goto L14;
        ((SSLSocket) r2).setEnabledProtocols(new String[]{"TLSv1.2"});     // Catch: Throwable -> L8
        return;
    }

    public static void c(Socket r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (i.g.c == true) goto L5;
        return;
    L5:
        if (i.g.e == true) goto L8;
        return;
    L8:
        if ((r6 instanceof SSLSocket) == true) goto L10;
        return;
    L10:
        int r1 = i.g.f;
        int r2 = i.g.d;
        if (r1 <= r2) goto L14;
        r1 = r2;
    L14:
        if (r1 <= 17) goto L17;
        if (r0 <= r1) goto L17;
        return;
    L17:
        Class<?> r3 = r6.getClass();
        r3.getMethod(f5.o("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), new Class[]{Boolean.TYPE}).invoke(r6, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        r.f(th, "myssl", "sust");
    }

    public final void a(SSLSessionCache r10) {
        SSLContext r0 = this.c;
        if (r0 != null) goto L16;
        return;
    L16:
        SSLSessionContext r1 = r0.getClientSessionContext();     // Catch: Throwable -> L13
        Field r2 = r10.getClass().getDeclaredField(f5.o("UbVNlc3Npb25DYWNoZQ"));     // Catch: Throwable -> L13
        r2.setAccessible(true);     // Catch: Throwable -> L13
        Object r11 = r2.get(r10);     // Catch: Throwable -> L13
        Method[] r3 = r1.getClass().getMethods();     // Catch: Throwable -> L13
        String r4 = f5.o("Yc2V0UGVyc2lzdGVudENhY2hl");     // Catch: Throwable -> L13
        int r5 = r3.length;     // Catch: Throwable -> L13
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L12;
        Method r7 = r3[r6];     // Catch: Throwable -> L13
        if (r7.getName().equals(r4) == true) goto L9;
        r6 = r6 + 1;
        goto L6
    L9:
        r7.invoke(r1, new Object[]{r11});     // Catch: Throwable -> L13
        return;
    L12:
        return;
    L13:
        th = move-exception;
        r.f(th, "myssl", "isc2");
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r1 = r0.createSocket();     // Catch: Throwable -> L6
        b(r1);     // Catch: Throwable -> L6
        c(r1);     // Catch: Throwable -> L6
        return r1;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs1");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r2, int r3) throws IOException, UnknownHostException {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        Socket r4 = r0.createSocket(r2, r3);     // Catch: Throwable -> L6
        b(r4);     // Catch: Throwable -> L6
        c(r4);     // Catch: Throwable -> L6
        return r4;
    L11:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs3");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r2, int r3, InetAddress r4, int r5) throws IOException, UnknownHostException {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        Socket r6 = r0.createSocket(r2, r3, r4, r5);     // Catch: Throwable -> L6
        b(r6);     // Catch: Throwable -> L6
        c(r6);     // Catch: Throwable -> L6
        return r6;
    L11:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs4");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r2, int r3) throws IOException {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r4 = r0.createSocket(r2, r3);     // Catch: Throwable -> L6
        b(r4);     // Catch: Throwable -> L6
        c(r4);     // Catch: Throwable -> L6
        return r4;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs5");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r2, int r3, InetAddress r4, int r5) throws IOException {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r6 = r0.createSocket(r2, r3, r4, r5);     // Catch: Throwable -> L6
        b(r6);     // Catch: Throwable -> L6
        c(r6);     // Catch: Throwable -> L6
        return r6;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs6");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r2, String r3, int r4, boolean r5) throws IOException {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r6 = r0.createSocket(r2, r3, r4, r5);     // Catch: Throwable -> L6
        b(r6);     // Catch: Throwable -> L6
        c(r6);     // Catch: Throwable -> L6
        return r6;
    L9:
        return null;
    L6:
        th = move-exception;
        r.f(th, "myssl", "cs2");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        return r0.getDefaultCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        r.f(th, "myssl", "gdcs");
        goto L9
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        SSLSocketFactory r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        return r0.getSupportedCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        r.f(th, "myssl", "gscs");
        goto L9
    }
}
