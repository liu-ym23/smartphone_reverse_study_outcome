package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.ttnet.TTConfigManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static final f e = null;
    public static final f f = null;
    public static final f g = null;
    public final boolean a;
    public final boolean b;

    @Nullable
    public final String[] c;

    @Nullable
    public final String[] d;

    public static final class a {
        public final boolean a;

        @Nullable
        public String[] b;

        @Nullable
        public String[] c;
        public boolean d;

        public a(f r2) {
            this.a = r2.a;
            this.b = r2.c;
            this.c = r2.d;
            this.d = r2.b;
        }

        public final void a(String... r2) {
            if (this.a == false) goto L11;
            if (r2.length == 0) goto L9;
            this.b = (String[]) r2.clone();
            return;
        L9:
            throw new IllegalArgumentException("At least one cipher suite is required");
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final void b(e... r4) {
            if (this.a == false) goto L11;
            String[] r0 = new String[r4.length];
            int r1 = 0;
        L6:
            if (r1 >= r4.length) goto L8;
            r0[r1] = r4[r1].a;
            r1 = r1 + 1;
            goto L6
        L8:
            a(r0);
            return;
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final void c(String... r2) {
            if (this.a == false) goto L11;
            if (r2.length == 0) goto L9;
            this.c = (String[]) r2.clone();
            return;
        L9:
            throw new IllegalArgumentException("At least one TLS version is required");
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public final void d(TlsVersion... r4) {
            if (this.a == false) goto L11;
            String[] r0 = new String[r4.length];
            int r1 = 0;
        L6:
            if (r1 >= r4.length) goto L8;
            r0[r1] = r4[r1].javaName;
            r1 = r1 + 1;
            goto L6
        L8:
            c(r0);
            return;
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    static {
        e r2 = e.q;
        e r4 = e.r;
        e r6 = e.s;
        e r8 = e.t;
        e r10 = e.u;
        e r12 = e.k;
        e r14 = e.m;
        e r16 = e.l;
        e r18 = e.n;
        e r20 = e.p;
        e r22 = e.o;
        e[] r1 = {r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22};
        e[] r0 = {r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, e.i, e.j, e.g, e.h, e.e, e.f, e.d};
        a r3 = new a(true);
        r3.b(r1);
        TlsVersion r5 = TlsVersion.TLS_1_3;
        TlsVersion r7 = TlsVersion.TLS_1_2;
        r3.d(new TlsVersion[]{r5, r7});
        r3.d = true;
        new f(r3);
        TlsVersion r9 = TlsVersion.TLS_1_0;
        TlsVersion[] r11 = {r5, r7, TlsVersion.TLS_1_1, r9};
        TlsVersion[] r13 = {r5, r7};
        a r15 = new a(true);
        r15.b(r0);
        if (TTConfigManager.inst().enableTls1_1() == true) goto L6;
        r11 = r13;
    L6:
        r15.d(r11);
        r15.d = true;
        e = new f(r15);
        a r17 = new a(true);
        r17.b(r0);
        r17.d(new TlsVersion[]{r9});
        r17.d = true;
        f = new f(r17);
        g = new f(new a(false));
    }

    public final int hashCode() {
        if (this.a == true) goto L7;
        return 17;
    L7:
        return ((((527 + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
    }

    public final String toString() {
        if (this.a == true) goto L6;
        return "ConnectionSpec()";
    L6:
        String[] r0 = this.c;
        List<TlsVersion> r1 = null;
        String r2 = "[all enabled]";
        if (r0 == null) goto L15;
        if (r0 == null) goto L13;
        ArrayList r3 = new ArrayList(r0.length);
        int r4 = r0.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L12;
        r3.add(e.a(r0[r5]));
        r5 = r5 + 1;
        goto L10
    L12:
        List r6 = Collections.unmodifiableList(r3);
    L14:
        String r7 = r6.toString();
    L16:
        String[] r8 = this.d;
        if (r8 == null) goto L22;
        if (r8 == null) goto L20;
        r1 = TlsVersion.forJavaNames(r8);
    L20:
        r2 = r1.toString();
    L22:
        return "ConnectionSpec(cipherSuites=" + r7 + ", tlsVersions=" + r2 + ", supportsTlsExtensions=" + this.b + ")";
    L13:
        r6 = null;
        goto L14
    L15:
        r7 = "[all enabled]";
        goto L16
    }

    public f(a r2) {
        this.a = r2.a;
        this.c = r2.b;
        this.d = r2.c;
        this.b = r2.d;
    }

    public final boolean a(SSLSocket r5) {
        if (this.a == true) goto L5;
        return false;
    L5:
        String[] r0 = this.d;
        if (r0 != null) goto L8;
    L10:
        String[] r1 = this.c;
        if (r1 != null) goto L13;
        return true;
    L13:
        if (cvc.c.r(e.b, r1, r5.getEnabledCipherSuites()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (cvc.c.r(cvc.c.q, r0, r5.getEnabledProtocols()) == true) goto L10;
        return false;
    }

    public final boolean equals(@Nullable Object r5) {
        if ((r5 instanceof f) == true) goto L6;
        return false;
    L6:
        if (r5 != this) goto L8;
        return true;
    L8:
        f r6 = (f) r5;
        boolean r2 = this.a;
        if (r2 == r6.a) goto L11;
        return false;
    L11:
        if (r2 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.c, r6.c) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.d, r6.d) == true) goto L19;
        return false;
    L19:
        if (this.b == r6.b) goto L21;
        return false;
    }
}
