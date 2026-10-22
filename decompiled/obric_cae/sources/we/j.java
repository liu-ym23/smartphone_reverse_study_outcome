package we;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f13202e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f13203f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String[] f13206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String[] f13207d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f13208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String[] f13209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String[] f13210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13211d;

        public a(j r8) {
            this.f13208a = r8.f13204a;
            this.f13209b = r8.f13206c;
            this.f13210c = r8.f13207d;
            this.f13211d = r8.f13205b;
        }

        public final void a(String... r8) {
            if (this.f13208a == false) goto L11;
            if (r8.length == 0) goto L9;
            this.f13209b = (String[]) r8.clone();
            return;
        L9:
            throw new IllegalArgumentException("At least one cipher suite is required");
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final void b(g... r8) {
            if (this.f13208a == false) goto L11;
            String[] r10 = new String[r8.length];
            int r11 = 0;
        L6:
            if (r11 >= r8.length) goto L8;
            r10[r11] = r8[r11].f13193a;
            r11 = r11 + 1;
            goto L6
        L8:
            a(r10);
            return;
        L11:
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public final void c(String... r8) {
            if (this.f13208a == false) goto L11;
            if (r8.length == 0) goto L9;
            this.f13210c = (String[]) r8.clone();
            return;
        L9:
            throw new IllegalArgumentException("At least one TLS version is required");
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public final void d(e0... r8) {
            if (this.f13208a == false) goto L11;
            String[] r10 = new String[r8.length];
            int r11 = 0;
        L6:
            if (r11 >= r8.length) goto L8;
            r10[r11] = r8[r11].f13168a;
            r11 = r11 + 1;
            goto L6
        L8:
            c(r10);
            return;
        L11:
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(boolean r8) {
            this.f13208a = r8;
        }
    }

    static {
        g r8 = g.f13188q;
        g r10 = g.f13189r;
        g r11 = g.f13190s;
        g r12 = g.f13191t;
        g r13 = g.f13192u;
        g r14 = g.f13182k;
        g r15 = g.f13184m;
        g r16 = g.f13183l;
        g r17 = g.f13185n;
        g r18 = g.f13187p;
        g r19 = g.f13186o;
        g[] r20 = {r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        g[] r21 = {r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, g.f13180i, g.f13181j, g.f13178g, g.f13179h, g.f13176e, g.f13177f, g.f13175d};
        a r22 = new a(true);
        r22.b(r20);
        e0 r23 = e0.f13162b;
        e0 r24 = e0.f13163m;
        r22.d(new e0[]{r23, r24});
        r22.f13211d = true;
        new j(r22);
        e0 r25 = e0.f13164n;
        e0 r26 = e0.f13165o;
        e0[] r27 = {r23, r24, r25, r26};
        e0[] r28 = {r23, r24};
        a r29 = new a(true);
        r29.b(r21);
        if (p000if.a.b().f8342l.get() == true) goto L6;
        r27 = r28;
    L6:
        r29.d(r27);
        r29.f13211d = true;
        f13202e = new j(r29);
        a r30 = new a(true);
        r30.b(r21);
        r30.d(new e0[]{r26});
        r30.f13211d = true;
        new j(r30);
        f13203f = new j(new a(false));
    }

    public j(a r8) {
        this.f13204a = r8.f13208a;
        this.f13206c = r8.f13209b;
        this.f13207d = r8.f13210c;
        this.f13205b = r8.f13211d;
    }

    public final boolean a(SSLSocket r8) {
        if (this.f13204a == true) goto L5;
        return false;
    L5:
        String[] r10 = this.f13207d;
        if (r10 != null) goto L8;
    L10:
        String[] r11 = this.f13206c;
        if (r11 != null) goto L13;
        return true;
    L13:
        if (xe.c.t(g.f13173b, r11, r8.getEnabledCipherSuites()) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (xe.c.t(xe.c.f13894o, r10, r8.getEnabledProtocols()) == true) goto L10;
        return false;
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof j) == true) goto L6;
        return false;
    L6:
        if (r8 != this) goto L8;
        return true;
    L8:
        j r10 = (j) r8;
        boolean r11 = r10.f13204a;
        boolean r12 = this.f13204a;
        if (r12 == r11) goto L11;
        return false;
    L11:
        if (r12 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.f13206c, r10.f13206c) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.f13207d, r10.f13207d) == true) goto L19;
        return false;
    L19:
        if (this.f13205b == r10.f13205b) goto L21;
        return false;
    }

    public final int hashCode() {
        if (this.f13204a == true) goto L7;
        return 17;
    L7:
        return ((((527 + Arrays.hashCode(this.f13206c)) * 31) + Arrays.hashCode(this.f13207d)) * 31) + (!this.f13205b ? 1 : 0);
    }

    public final String toString() {
        if (this.f13204a == true) goto L6;
        return "ConnectionSpec()";
    L6:
        int r8 = 0;
        List r10 = null;
        String r11 = "[all enabled]";
        String[] r12 = this.f13206c;
        if (r12 == null) goto L15;
        if (r12 == null) goto L13;
        ArrayList r13 = new ArrayList(r12.length);
        int r14 = r12.length;
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L12;
        r13.add(g.a(r12[r15]));
        r15 = r15 + 1;
        goto L10
    L12:
        List r16 = Collections.unmodifiableList(r13);
    L14:
        String r17 = r16.toString();
    L16:
        String[] r18 = this.f13207d;
        if (r18 == null) goto L24;
        if (r18 == null) goto L23;
        e0 r19 = e0.f13162b;
        ArrayList r20 = new ArrayList(r18.length);
        int r21 = r18.length;
    L20:
        if (r8 >= r21) goto L22;
        r20.add(e0.a(r18[r8]));
        r8 = r8 + 1;
        goto L20
    L22:
        r10 = Collections.unmodifiableList(r20);
    L23:
        r11 = r10.toString();
    L24:
        StringBuilder r22 = defpackage.b.i("ConnectionSpec(cipherSuites=", r17, ", tlsVersions=", r11, ", supportsTlsExtensions=");
        r22.append(this.f13205b);
        r22.append(")");
        return r22.toString();
    L13:
        r16 = null;
        goto L14
    L15:
        r17 = "[all enabled]";
        goto L16
    }
}
