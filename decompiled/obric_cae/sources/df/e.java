package df;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import we.w;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f7089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f7090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f7091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f7092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f7093g;

    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f7094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7096c;

        public a(ArrayList r8) {
            this.f7094a = r8;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r8, Method r10, Object[] r11) {
            String r12 = r10.getName();
            Class<?> r13 = r10.getReturnType();
            if (r11 != null) goto L6;
            r11 = xe.c.f13881b;
        L6:
            if (r12.equals("supports") == false) goto L12;
            if (Boolean.TYPE != r13) goto L12;
            return Boolean.TRUE;
        L12:
            if (r12.equals("unsupported") == true) goto L14;
        L17:
            boolean r14 = r12.equals("protocols");
            List<String> r15 = this.f7094a;
            if (r14 == false) goto L23;
            if (r11.length != 0) goto L23;
            return r15;
        L23:
            if (r12.equals("selectProtocol") == true) goto L27;
            if (r12.equals("select") == true) goto L27;
        L42:
            if (r12.equals("protocolSelected") == true) goto L46;
            if (r12.equals("selected") == true) goto L46;
        L50:
            return r10.invoke(this, r11);
        L46:
            if (r11.length != 1) goto L50;
            this.f7096c = (String) r11[0];
            return null;
        L27:
            if (String.class != r13) goto L42;
            if (r11.length != 1) goto L42;
            Object r16 = r11[0];
            if ((r16 instanceof List) == false) goto L42;
            List r17 = (List) r16;
            int r18 = r17.size();
            int r19 = 0;
        L33:
            if (r19 >= r18) goto L40;
            if (r15.contains(r17.get(r19)) == true) goto L36;
            r19 = r19 + 1;
            goto L33
        L36:
            Object r20 = r17.get(r19);
        L37:
            String r21 = (String) r20;
            this.f7096c = r21;
            return r21;
        L40:
            r20 = r15.get(0);
            goto L37
        L14:
            if (Void.TYPE != r13) goto L17;
            this.f7095b = true;
            return null;
        }
    }

    public e(Method r8, Method r10, Method r11, Class<?> r12, Class<?> r13) {
        this.f7089c = r8;
        this.f7090d = r10;
        this.f7091e = r11;
        this.f7092f = r12;
        this.f7093g = r13;
    }

    @Override // df.f
    public final void a(SSLSocket r8) {
        this.f7091e.invoke(null, new Object[]{r8});     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw xe.c.a("unable to remove alpn", e);
    }

    @Override // df.f
    public final void f(SSLSocket r8, String r10, List<w> r11) {
        ArrayList r12 = f.b(r11);
        this.f7089c.invoke(null, new Object[]{r8, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f7092f, this.f7093g}, new a(r12))});     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw xe.c.a("unable to set alpn", e);
    }

    @Override // df.f
    @Nullable
    public final String i(SSLSocket r8) {
        a r10 = (a) Proxy.getInvocationHandler(this.f7090d.invoke(null, new Object[]{r8}));     // Catch: Throwable -> L12
        boolean r11 = r10.f7095b;     // Catch: Throwable -> L12
        if (r11 == false) goto L5;
    L8:
        if (r11 == false) goto L11;
        return null;
    L11:
        return r10.f7096c;
    L5:
        if (r10.f7096c != null) goto L8;
        f.f7097a.l(4, null, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?");     // Catch: Throwable -> L12
        return null;
    L12:
        e = move-exception;
        throw xe.c.a("unable to get selected protocol", e);
    }
}
