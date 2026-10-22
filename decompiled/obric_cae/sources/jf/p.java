package jf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f8861a = null;

    static {
        f8861a = Logger.getLogger(p.class.getName());
    }

    public p() {
    }

    public static q a(v r8) {
        return new q(r8);
    }

    public static a b(Socket r8) {
        if (r8 == null) goto L14;
        if (r8.getOutputStream() == null) goto L12;
        o r10 = new o(r8);
        OutputStream r11 = r8.getOutputStream();
        if (r11 == null) goto L10;
        return new a(r10, new m(r11, r10));
    L10:
        throw new IllegalArgumentException("out == null");
    L12:
        throw new IOException("socket's output stream == null");
    L14:
        throw new IllegalArgumentException("socket == null");
    }

    public static m c(OutputStream r8) {
        x r10 = new x();
        if (r8 == null) goto L7;
        return new m(r8, r10);
    L7:
        throw new IllegalArgumentException("out == null");
    }

    public static b d(Socket r8) {
        if (r8 == null) goto L14;
        if (r8.getInputStream() == null) goto L12;
        o r10 = new o(r8);
        InputStream r11 = r8.getInputStream();
        if (r11 == null) goto L10;
        return new b(r10, new n(r11, r10));
    L10:
        throw new IllegalArgumentException("in == null");
    L12:
        throw new IOException("socket's input stream == null");
    L14:
        throw new IllegalArgumentException("socket == null");
    }
}
