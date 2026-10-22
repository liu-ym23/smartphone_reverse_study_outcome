package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final q e = null;
    public static final q f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f20725c;
    public final String[] d;

    static {
        m r10 = m.f20709q;
        m r11 = m.f20710r;
        m r12 = m.s;
        m r13 = m.f20703k;
        m r14 = m.f20705m;
        m r15 = m.f20704l;
        m r16 = m.f20706n;
        m r17 = m.f20708p;
        m r18 = m.f20707o;
        m[] r5 = {r10, r11, r12, r13, r14, r15, r16, r17, r18, m.f20701i, m.f20702j, m.g, m.f20700h, m.e, m.f, m.d};
        p r19 = new p();
        r19.c((m[]) Arrays.copyOf(new m[]{r10, r11, r12, r13, r14, r15, r16, r17, r18}, 9));
        TlsVersion r20 = TlsVersion.TLS_1_3;
        TlsVersion r21 = TlsVersion.TLS_1_2;
        r19.e(new TlsVersion[]{r20, r21});
        if (r19.f20720a == false) goto L15;
        r19.d = true;
        r19.a();
        p r22 = new p();
        r22.c((m[]) Arrays.copyOf(r5, 16));
        r22.e(new TlsVersion[]{r20, r21});
        if (r22.f20720a == false) goto L13;
        r22.d = true;
        e = r22.a();
        p r23 = new p();
        r23.c((m[]) Arrays.copyOf(r5, 16));
        r23.e(new TlsVersion[]{r20, r21, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0});
        if (r23.f20720a == false) goto L11;
        r23.d = true;
        r23.a();
        f = new q(false, false, null, null);
        return;
    L11:
        throw new IllegalArgumentException("no TLS extensions for cleartext connections");
    L13:
        throw new IllegalArgumentException("no TLS extensions for cleartext connections");
    L15:
        throw new IllegalArgumentException("no TLS extensions for cleartext connections");
    }

    public q(boolean r5, boolean r10, String[] r11, String[] r12) {
        this.f20723a = r5;
        this.f20724b = r10;
        this.f20725c = r11;
        this.d = r12;
    }

    public final void a(SSLSocket r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        String[] r5 = this.f20725c;
        if (r5 == null) goto L5;
        String[] r12 = Util.intersect(r10.getEnabledCipherSuites(), r5, m.f20698b);
    L6:
        String[] r13 = this.d;
        if (r13 == null) goto L9;
        String[] r14 = Util.intersect(r10.getEnabledProtocols(), r13, ComparisonsKt.naturalOrder());
    L10:
        String[] r15 = r10.getSupportedCipherSuites();
        int r16 = Util.indexOf(r15, "TLS_FALLBACK_SCSV", m.f20698b);
        if (r11 == true) goto L13;
    L15:
        Intrinsics.checkNotNullParameter(this, "connectionSpec");
        p r17 = new p();
        r17.f20720a = this.f20723a;
        r17.f20721b = r5;
        r17.f20722c = r13;
        r17.d = this.f20724b;
        r17.b((String[]) Arrays.copyOf(r12, r12.length));
        r17.d((String[]) Arrays.copyOf(r14, r14.length));
        q r18 = r17.a();
        if (r18.d() == null) goto L19;
        r10.setEnabledProtocols(r18.d);
    L19:
        if (r18.b() == null) goto L22;
        r10.setEnabledCipherSuites(r18.f20725c);
        return;
    L22:
        return;
    L13:
        if (r16 == (-1)) goto L15;
        r12 = Util.concat(r12, r15[r16]);
        goto L15
    L9:
        r14 = r10.getEnabledProtocols();
        goto L10
    L5:
        r12 = r10.getEnabledCipherSuites();
        goto L6
    }

    public final List b() {
        String[] r5 = this.f20725c;
        if (r5 == null) goto L8;
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        String r13 = r5[r12];
        r10.add(m.f20711t.e(r13));
        r12 = r12 + 1;
        goto L5
    L11:
        return CollectionsKt.toList(r10);
    L8:
        return null;
    }

    public final boolean c(SSLSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "socket");
        if (this.f20723a == true) goto L5;
        return false;
    L5:
        String[] r10 = this.d;
        if (r10 != null) goto L8;
    L10:
        String[] r11 = this.f20725c;
        if (r11 != null) goto L13;
        return true;
    L13:
        if (Util.hasIntersection(r11, r5.getEnabledCipherSuites(), m.f20698b) == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        if (Util.hasIntersection(r10, r5.getEnabledProtocols(), ComparisonsKt.naturalOrder()) == true) goto L10;
        return false;
    }

    public final List d() {
        String[] r5 = this.d;
        if (r5 == null) goto L8;
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        String r13 = r5[r12];
        TlsVersion.Companion.getClass();
        r10.add(y0.a(r13));
        r12 = r12 + 1;
        goto L5
    L11:
        return CollectionsKt.toList(r10);
    L8:
        return null;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof q) == true) goto L6;
        return false;
    L6:
        if (r5 != this) goto L8;
        return true;
    L8:
        q r10 = (q) r5;
        boolean r11 = r10.f20723a;
        boolean r12 = this.f20723a;
        if (r12 == r11) goto L11;
        return false;
    L11:
        if (r12 == true) goto L13;
    L21:
        return true;
    L13:
        if (Arrays.equals(this.f20725c, r10.f20725c) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.d, r10.d) == true) goto L19;
        return false;
    L19:
        if (this.f20724b == r10.f20724b) goto L21;
        return false;
    }

    public final int hashCode() {
        if (this.f20723a == false) goto L12;
        int r5 = 0;
        String[] r10 = this.f20725c;
        if (r10 == null) goto L7;
        int r11 = Arrays.hashCode(r10);
    L8:
        int r12 = (527 + r11) * 31;
        String[] r13 = this.d;
        if (r13 == null) goto L14;
        r5 = Arrays.hashCode(r13);
    L14:
        return ((r12 + r5) * 31) + (!this.f20724b ? 1 : 0);
    L7:
        r11 = 0;
        goto L8
    L12:
        return 17;
    }

    public final String toString() {
        if (this.f20723a == true) goto L6;
        return "ConnectionSpec()";
    L6:
        StringBuilder r5 = new StringBuilder("ConnectionSpec(cipherSuites=");
        r5.append(Objects.toString(b(), "[all enabled]"));
        r5.append(", tlsVersions=");
        r5.append(Objects.toString(d(), "[all enabled]"));
        r5.append(", supportsTlsExtensions=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f20724b, ')');
    }
}
