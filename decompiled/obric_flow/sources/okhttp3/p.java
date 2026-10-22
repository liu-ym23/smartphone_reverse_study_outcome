package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f20721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f20722c;
    public boolean d;

    public p() {
        this.f20720a = true;
    }

    public final q a() {
        boolean r5 = this.d;
        String[] r10 = this.f20721b;
        String[] r11 = this.f20722c;
        return new q(this.f20720a, r5, r10, r11);
    }

    public final void b(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "cipherSuites");
        if (this.f20720a == false) goto L15;
        if (r5.length == 0) goto L13;
        Object r10 = r5.clone();
        if (r10 == null) goto L11;
        this.f20721b = (String[]) r10;
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    L13:
        throw new IllegalArgumentException("At least one cipher suite is required");
    L15:
        throw new IllegalArgumentException("no cipher suites for cleartext connections");
    }

    public final void c(m... r10) {
        Intrinsics.checkNotNullParameter(r10, "cipherSuites");
        if (this.f20720a == false) goto L14;
        ArrayList r5 = new ArrayList(r10.length);
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        r5.add(r10[r12].f20712a);
        r12 = r12 + 1;
        goto L5
    L7:
        Object[] r13 = r5.toArray(new String[0]);
        if (r13 == null) goto L12;
        String[] r14 = (String[]) r13;
        b((String[]) Arrays.copyOf(r14, r14.length));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        throw new IllegalArgumentException("no cipher suites for cleartext connections");
    }

    public final void d(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "tlsVersions");
        if (this.f20720a == false) goto L15;
        if (r5.length == 0) goto L13;
        Object r10 = r5.clone();
        if (r10 == null) goto L11;
        this.f20722c = (String[]) r10;
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    L13:
        throw new IllegalArgumentException("At least one TLS version is required");
    L15:
        throw new IllegalArgumentException("no TLS versions for cleartext connections");
    }

    public final void e(TlsVersion... r10) {
        Intrinsics.checkNotNullParameter(r10, "tlsVersions");
        if (this.f20720a == false) goto L14;
        ArrayList r5 = new ArrayList(r10.length);
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        r5.add(r10[r12].javaName());
        r12 = r12 + 1;
        goto L5
    L7:
        Object[] r13 = r5.toArray(new String[0]);
        if (r13 == null) goto L12;
        String[] r14 = (String[]) r13;
        d((String[]) Arrays.copyOf(r14, r14.length));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        throw new IllegalArgumentException("no TLS versions for cleartext connections");
    }
}
