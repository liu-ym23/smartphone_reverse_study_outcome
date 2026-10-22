package com.loc;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes3.dex */
public final class ap extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f5320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5321b;
    private SSLContext c;

    public ap(Context r7, SSLContext r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L56;
    L5:
        this.c = r8;     // Catch: Throwable -> L23
        if (r8 == null) goto L62;
        this.f5320a = r8.getSocketFactory();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        q.b(th, "myssl", "<init>");     // Catch: Throwable -> L40
    L31:
        th = move-exception;
        q.b(th, "myssl", "<init2>");
    L70:
    L37:
        th = move-exception;
        q.b(th, "myssl", "<init3>");
        return;
    L34:
        if (this.f5320a != null) goto L73;
        this.f5320a = (SSLSocketFactory) ZeusTransformUtils.preCheckCast(SSLSocketFactory.getDefault(), SSLSocketFactory.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        return;
    L73:
        return;
    L26:
        if (this.c != null) goto L70;
        if (Build.VERSION.SDK_INT < 9) goto L70;
        this.c = SSLContext.getDefault();     // Catch: Throwable -> L31
    L40:
        th = move-exception;
    L47:
        th = move-exception;
        q.b(th, "myssl", "<init2>");
    L66:
    L53:
        th = move-exception;
        q.b(th, "myssl", "<init3>");
        throw th;
    L50:
        if (this.f5320a != null) goto L74;
        this.f5320a = (SSLSocketFactory) ZeusTransformUtils.preCheckCast(SSLSocketFactory.getDefault(), SSLSocketFactory.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        throw th;
    L74:
        throw th;
    L42:
        if (this.c != null) goto L66;
        if (Build.VERSION.SDK_INT < 9) goto L66;
        this.c = SSLContext.getDefault();     // Catch: Throwable -> L47
    L62:
    L14:
        th = move-exception;
        q.b(th, "myssl", "<init2>");
    L68:
    L20:
        th = move-exception;
        q.b(th, "myssl", "<init3>");
        return;
    L17:
        if (this.f5320a != null) goto L72;
        this.f5320a = (SSLSocketFactory) ZeusTransformUtils.preCheckCast(SSLSocketFactory.getDefault(), SSLSocketFactory.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        return;
    L72:
        return;
    L9:
        if (this.c != null) goto L68;
        if (Build.VERSION.SDK_INT < 9) goto L68;
        this.c = SSLContext.getDefault();     // Catch: Throwable -> L14
        goto L68
    L56:
        this.f5321b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        goto L5
    }

    private static Socket a(Socket r3) {
    L11:
        th = move-exception;
        q.b(th, "myssl", "stlv2");
    L13:
        return r3;
    L3:
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return r3;
    L6:
        if (fn.f.f5571b == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, SSLSocket.class) == false) goto L13;
        ((SSLSocket) ZeusTransformUtils.preCheckCast(r3, SSLSocket.class, "com.obric.memorydata.plugin")).setEnabledProtocols(new String[]{"TLSv1.2"});     // Catch: Throwable -> L11
        goto L13
    }

    private void a(SSLSessionCache r9) {
        SSLContext r8 = this.c;
        if (r8 != null) goto L16;
        return;
    L16:
        SSLSessionContext r10 = r8.getClientSessionContext();     // Catch: Throwable -> L13
        Field r0 = r9.getClass().getDeclaredField(fx.c("UbVNlc3Npb25DYWNoZQ"));     // Catch: Throwable -> L13
        r0.setAccessible(true);     // Catch: Throwable -> L13
        Object r11 = r0.get(r9);     // Catch: Throwable -> L13
        Method[] r1 = r10.getClass().getMethods();     // Catch: Throwable -> L13
        String r2 = fx.c("Yc2V0UGVyc2lzdGVudENhY2hl");     // Catch: Throwable -> L13
        int r3 = r1.length;     // Catch: Throwable -> L13
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L12;
        Method r6 = r1[r5];     // Catch: Throwable -> L13
        if (r6.getName().equals(r2) == true) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        r6.invoke(r10, new Object[]{r11});     // Catch: Throwable -> L13
        return;
    L12:
        return;
    L13:
        th = move-exception;
        q.b(th, "myssl", "isc2");
    }

    private static void b(Socket r6) {
        if (Build.VERSION.SDK_INT >= 17) goto L6;
        return;
    L6:
        if (fn.f.c == true) goto L8;
        return;
    L8:
        if (fn.f.e == true) goto L11;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r6, SSLSocket.class) == true) goto L14;
        return;
    L14:
        if (fn.f.f <= fn.f.d) goto L16;
        int r0 = fn.f.d;
    L17:
        if (r0 > 17) goto L19;
    L21:
        Class<?> r1 = r6.getClass();
        r1.getMethod(fx.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), new Class[]{Boolean.TYPE}).invoke(r6, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        q.b(th, "myssl", "sust");
        return;
    L19:
        if (Build.VERSION.SDK_INT <= r0) goto L21;
        return;
    L16:
        r0 = fn.f.f;
        goto L17
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 17) goto L6;
        return;
    L6:
        if (fn.f.c == true) goto L9;
        return;
    L9:
        if (this.f5321b != null) goto L11;
        return;
    L11:
        if (this.c == null) goto L32;
        int r0 = fn.f.d;
        if (r0 > 17) goto L16;
    L18:
        SSLSessionCache r1 = new SSLSessionCache(this.f5321b);
        if (Build.VERSION.SDK_INT > 20) goto L21;
    L27:
        a(r1);
        return;
    L21:
        if (Build.VERSION.SDK_INT >= 28) goto L27;
        r1.getClass().getMethod(fx.c("MaW5zdGFsbA"), new Class[]{SSLSessionCache.class, SSLContext.class}).invoke(r1, new Object[]{r1, this.c});     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        q.b(th, "myssl", "isc1");
        a(r1);
        return;
    L16:
        if (Build.VERSION.SDK_INT <= r0) goto L18;
        return;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() {
        SSLSocketFactory r2 = this.f5320a;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        Socket r3 = a(r2.createSocket());     // Catch: Throwable -> L6
        b(r3);     // Catch: Throwable -> L6
        return r3;
    L9:
        return null;
    L6:
        th = move-exception;
        q.b(th, "myssl", "cs1");
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L12;
        return null;
    L12:
        throw ((IOException) ZeusTransformUtils.preCheckCast(th, IOException.class, "com.obric.memorydata.plugin"));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r1, int r2) {
        SSLSocketFactory r0 = this.f5320a;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        Socket r3 = a(r0.createSocket(r1, r2));     // Catch: Throwable -> L6
        b(r3);     // Catch: Throwable -> L6
        return r3;
    L11:
        return null;
    L6:
        th = move-exception;
        q.b(th, "myssl", "cs3");
        if (ZeusTransformUtils.instanceOf(th, UnknownHostException.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L14;
        return null;
    L14:
        throw ((IOException) ZeusTransformUtils.preCheckCast(th, IOException.class, "com.obric.memorydata.plugin"));
    L16:
        throw ((UnknownHostException) ZeusTransformUtils.preCheckCast(th, UnknownHostException.class, "com.obric.memorydata.plugin"));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r1, int r2, InetAddress r3, int r4) {
        SSLSocketFactory r0 = this.f5320a;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        Socket r5 = a(r0.createSocket(r1, r2, r3, r4));     // Catch: Throwable -> L6
        b(r5);     // Catch: Throwable -> L6
        return r5;
    L11:
        return null;
    L6:
        th = move-exception;
        q.b(th, "myssl", "cs4");
        if (ZeusTransformUtils.instanceOf(th, UnknownHostException.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L14;
        return null;
    L14:
        throw ((IOException) ZeusTransformUtils.preCheckCast(th, IOException.class, "com.obric.memorydata.plugin"));
    L16:
        throw ((UnknownHostException) ZeusTransformUtils.preCheckCast(th, UnknownHostException.class, "com.obric.memorydata.plugin"));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r1, int r2) {
        SSLSocketFactory r0 = this.f5320a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r3 = a(r0.createSocket(r1, r2));     // Catch: Throwable -> L6
        b(r3);     // Catch: Throwable -> L6
        return r3;
    L9:
        return null;
    L6:
        th = move-exception;
        q.b(th, "myssl", "cs5");
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L12;
        return null;
    L12:
        throw ((IOException) ZeusTransformUtils.preCheckCast(th, IOException.class, "com.obric.memorydata.plugin"));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r1, int r2, InetAddress r3, int r4) {
        SSLSocketFactory r0 = this.f5320a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r5 = a(r0.createSocket(r1, r2, r3, r4));     // Catch: Throwable -> L6
        b(r5);     // Catch: Throwable -> L6
        return r5;
    L9:
        return null;
    L6:
        th = move-exception;
        q.b(th, "myssl", "cs6");
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L12;
        return null;
    L12:
        throw ((IOException) ZeusTransformUtils.preCheckCast(th, IOException.class, "com.obric.memorydata.plugin"));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r1, String r2, int r3, boolean r4) {
        SSLSocketFactory r0 = this.f5320a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r5 = a(r0.createSocket(r1, r2, r3, r4));     // Catch: Throwable -> L6
        b(r5);     // Catch: Throwable -> L6
        return r5;
    L9:
        return null;
    L6:
        th = move-exception;
        q.b(th, "myssl", "cs2");
        if (ZeusTransformUtils.instanceOf(th, IOException.class) == true) goto L12;
        return null;
    L12:
        throw ((IOException) ZeusTransformUtils.preCheckCast(th, IOException.class, "com.obric.memorydata.plugin"));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        SSLSocketFactory r2 = this.f5320a;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        return r2.getDefaultCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        q.b(th, "myssl", "gdcs");
        goto L9
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        SSLSocketFactory r2 = this.f5320a;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        return r2.getSupportedCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        q.b(th, "myssl", "gscs");
        goto L9
    }
}
