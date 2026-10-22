package qa;

import android.content.Context;
import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class l0 extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f10781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SSLContext f10783c;

    public l0(Context r8, SSLContext r10) {
        if (r8 != null) goto L55;
    L5:
        this.f10783c = r10;     // Catch: Throwable -> L20
        if (r10 == null) goto L8;
        this.f10781a = r10.getSocketFactory();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        q.f("myssl", "<init>", th);     // Catch: Throwable -> L35
    L26:
        th = move-exception;
        q.f("myssl", "<init2>", th);
    L59:
    L32:
        th = move-exception;
        q.f("myssl", "<init3>", th);
        return;
    L29:
        if (this.f10781a != null) goto L66;
        this.f10781a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L32
        return;
    L66:
        return;
    L23:
        if (this.f10783c != null) goto L59;
        this.f10783c = SSLContext.getDefault();     // Catch: Throwable -> L26
    L35:
        th = move-exception;
    L40:
        th = move-exception;
        q.f("myssl", "<init2>", th);
    L63:
    L46:
        th = move-exception;
        q.f("myssl", "<init3>", th);
        throw th;
    L43:
        if (this.f10781a != null) goto L67;
        this.f10781a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L46
        throw th;
    L67:
        throw th;
    L37:
        if (this.f10783c != null) goto L63;
        this.f10783c = SSLContext.getDefault();     // Catch: Throwable -> L40
    L8:
        if (r10 != null) goto L53;
        this.f10783c = SSLContext.getDefault();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        q.f("myssl", "<init2>", th);
    L53:
    L17:
        th = move-exception;
        q.f("myssl", "<init3>", th);
        return;
    L14:
        if (this.f10781a != null) goto L65;
        this.f10781a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L17
        return;
    L65:
        return;
    L55:
        this.f10782b = r8.getApplicationContext();     // Catch: Throwable -> L20
        goto L5
    }

    public static void a(Socket r8) {
    L8:
        th = move-exception;
        q.f("myssl", "stlv2", th);
        return;
    L3:
        if (i4.g.f10587b == true) goto L5;
        return;
    L5:
        if ((r8 instanceof SSLSocket) == false) goto L14;
        ((SSLSocket) r8).setEnabledProtocols(new String[]{"TLSv1.2"});     // Catch: Throwable -> L8
        return;
    }

    public static void b(Socket r8) {
        int r10 = Build.VERSION.SDK_INT;
        if (i4.g.f10588c == true) goto L5;
        return;
    L5:
        if (i4.g.f10590e == true) goto L8;
        return;
    L8:
        if ((r8 instanceof SSLSocket) == true) goto L10;
        return;
    L10:
        int r11 = i4.g.f10591f;
        int r12 = i4.g.f10589d;
        if (r11 <= r12) goto L14;
        r11 = r12;
    L14:
        if (r11 <= 17) goto L17;
        if (r10 <= r11) goto L17;
        return;
    L17:
        Class<?> r13 = r8.getClass();
        r13.getMethod(t4.n("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), new Class[]{Boolean.TYPE}).invoke(r8, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        q.f("myssl", "sust", th);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() {
        SSLSocketFactory r8 = this.f10781a;     // Catch: Throwable -> L6
        if (r8 == null) goto L9;
        Socket r10 = r8.createSocket();     // Catch: Throwable -> L6
        a(r10);     // Catch: Throwable -> L6
        b(r10);     // Catch: Throwable -> L6
        return r10;
    L9:
        return null;
    L6:
        th = move-exception;
        q.f("myssl", "cs1", th);
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        SSLSocketFactory r8 = this.f10781a;     // Catch: Throwable -> L6
        if (r8 == null) goto L9;
        return r8.getDefaultCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        q.f("myssl", "gdcs", th);
        goto L9
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        SSLSocketFactory r8 = this.f10781a;     // Catch: Throwable -> L6
        if (r8 == null) goto L9;
        return r8.getSupportedCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        q.f("myssl", "gscs", th);
        goto L9
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r8, int r10) {
        SSLSocketFactory r11 = this.f10781a;     // Catch: Throwable -> L6
        if (r11 == null) goto L11;
        Socket r12 = r11.createSocket(r8, r10);     // Catch: Throwable -> L6
        a(r12);     // Catch: Throwable -> L6
        b(r12);     // Catch: Throwable -> L6
        return r12;
    L11:
        return null;
    L6:
        th = move-exception;
        q.f("myssl", "cs3", th);
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r8, int r10, InetAddress r11, int r12) {
        SSLSocketFactory r13 = this.f10781a;     // Catch: Throwable -> L6
        if (r13 == null) goto L11;
        Socket r14 = r13.createSocket(r8, r10, r11, r12);     // Catch: Throwable -> L6
        a(r14);     // Catch: Throwable -> L6
        b(r14);     // Catch: Throwable -> L6
        return r14;
    L11:
        return null;
    L6:
        th = move-exception;
        q.f("myssl", "cs4", th);
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r8, int r10) {
        SSLSocketFactory r11 = this.f10781a;     // Catch: Throwable -> L6
        if (r11 == null) goto L9;
        Socket r12 = r11.createSocket(r8, r10);     // Catch: Throwable -> L6
        a(r12);     // Catch: Throwable -> L6
        b(r12);     // Catch: Throwable -> L6
        return r12;
    L9:
        return null;
    L6:
        th = move-exception;
        q.f("myssl", "cs5", th);
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r8, int r10, InetAddress r11, int r12) {
        SSLSocketFactory r13 = this.f10781a;     // Catch: Throwable -> L6
        if (r13 == null) goto L9;
        Socket r14 = r13.createSocket(r8, r10, r11, r12);     // Catch: Throwable -> L6
        a(r14);     // Catch: Throwable -> L6
        b(r14);     // Catch: Throwable -> L6
        return r14;
    L9:
        return null;
    L6:
        th = move-exception;
        q.f("myssl", "cs6", th);
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r8, String r10, int r11, boolean r12) {
        SSLSocketFactory r13 = this.f10781a;     // Catch: Throwable -> L6
        if (r13 == null) goto L9;
        Socket r14 = r13.createSocket(r8, r10, r11, r12);     // Catch: Throwable -> L6
        a(r14);     // Catch: Throwable -> L6
        b(r14);     // Catch: Throwable -> L6
        return r14;
    L9:
        return null;
    L6:
        th = move-exception;
        q.f("myssl", "cs2", th);
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }
}
