package df;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import we.w;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f7087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f7088d;

    public d(Method r8, Method r10) {
        this.f7087c = r8;
        this.f7088d = r10;
    }

    @Override // df.f
    public final void f(SSLSocket r8, String r10, List<w> r11) {
        SSLParameters r12 = r8.getSSLParameters();     // Catch: Throwable -> L4
        ArrayList r13 = f.b(r11);     // Catch: Throwable -> L4
        this.f7087c.invoke(r12, new Object[]{r13.toArray(new String[r13.size()])});     // Catch: Throwable -> L4
        r8.setSSLParameters(r12);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw xe.c.a("unable to set ssl parameters", e);
    }

    @Override // df.f
    @Nullable
    public final String i(SSLSocket r8) {
        String r10 = (String) this.f7088d.invoke(r8, new Object[0]);     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L13
        if (r10 == null) goto L9;
        if (r10.equals("") == true) goto L9;
        return r10;
    L9:
        return null;
    L10:
        e = move-exception;
        throw xe.c.a("failed to get ALPN selected protocol", e);
    L13:
        e = move-exception;
        if ((e.getCause() instanceof UnsupportedOperationException) == false) goto L18;
        return null;
    L18:
        throw xe.c.a("failed to get ALPN selected protocol", e);
    }
}
