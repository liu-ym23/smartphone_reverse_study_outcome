package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f20630k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f20631l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f20633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20634c;
    public final Protocol d;
    public final int e;
    public final String f;
    public final c0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0 f20635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f20636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f20637j;

    static {
        StringBuilder r5 = new StringBuilder();
        Platform.Companion r10 = Platform.Companion;
        r5.append(r10.get().getPrefix());
        r5.append("-Sent-Millis");
        f20630k = r5.toString();
        f20631l = r10.get().getPrefix() + "-Received-Millis";
    }

    public e(nu.c0 r11) {
        Intrinsics.checkNotNullParameter(r11, "rawSource");
        nu.x r5 = f4.b.e(r11);     // Catch: Throwable -> L6
        this.f20632a = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L6
        this.f20634c = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L6
        b0 r10 = new b0();     // Catch: Throwable -> L6
        int r12 = z.n(r5);     // Catch: Throwable -> L6
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L8;
        r10.b(r5.c(Long.MAX_VALUE));     // Catch: Throwable -> L6
        r14 = r14 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        this.f20633b = r10.d();     // Catch: Throwable -> L6
        StatusLine r15 = StatusLine.Companion.parse(r5.c(Long.MAX_VALUE));     // Catch: Throwable -> L6
        this.d = r15.protocol;     // Catch: Throwable -> L6
        this.e = r15.code;     // Catch: Throwable -> L6
        this.f = r15.message;     // Catch: Throwable -> L6
        b0 r16 = new b0();     // Catch: Throwable -> L6
        int r17 = z.n(r5);     // Catch: Throwable -> L6
    L9:
        if (r13 >= r17) goto L11;
        r16.b(r5.c(Long.MAX_VALUE));     // Catch: Throwable -> L6
        r13 = r13 + 1;     // Catch: Throwable -> L6
        goto L9
    L11:
        String r18 = f20630k;     // Catch: Throwable -> L6
        String r19 = r16.e(r18);     // Catch: Throwable -> L6
        String r20 = f20631l;     // Catch: Throwable -> L6
        String r21 = r16.e(r20);     // Catch: Throwable -> L6
        r16.f(r18);     // Catch: Throwable -> L6
        r16.f(r20);     // Catch: Throwable -> L6
        long r22 = 0;
        if (r19 == null) goto L14;
        long r23 = Long.parseLong(r19);     // Catch: Throwable -> L6
    L15:
        this.f20636i = r23;     // Catch: Throwable -> L6
        if (r21 == null) goto L18;
        r22 = Long.parseLong(r21);     // Catch: Throwable -> L6
    L18:
        this.f20637j = r22;     // Catch: Throwable -> L6
        this.g = r16.d();     // Catch: Throwable -> L6
        if (StringsKt.P(this.f20632a, "https://") == false) goto L29;
        String r24 = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L6
        if (r24.length() > 0) goto L28;
        m r25 = m.f20711t.e(r5.c(Long.MAX_VALUE));     // Catch: Throwable -> L6
        List r26 = a(r5);     // Catch: Throwable -> L6
        List r27 = a(r5);     // Catch: Throwable -> L6
        if (r5.y() == true) goto L25;
        y0 r28 = TlsVersion.Companion;     // Catch: Throwable -> L6
        String r29 = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L6
        r28.getClass();     // Catch: Throwable -> L6
        TlsVersion r30 = y0.a(r29);     // Catch: Throwable -> L6
    L26:
        Intrinsics.checkNotNullParameter(r30, "tlsVersion");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r25, "cipherSuite");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r26, "peerCertificates");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r27, "localCertificates");     // Catch: Throwable -> L6
        final List r31 = Util.toImmutableList(r26);     // Catch: Throwable -> L6
        this.f20635h = new a0(r30, r25, Util.toImmutableList(r27), new Handshake$Companion$get$1(r31));     // Catch: Throwable -> L6
    L30:
        r11.close();
        return;
    L25:
        r30 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L6
        goto L26
    L28:
        throw new IOException("expected \"\" but was \"" + r24 + Typography.quote);     // Catch: Throwable -> L6
    L29:
        this.f20635h = null;     // Catch: Throwable -> L6
        goto L30
    L14:
        r23 = 0;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static List a(nu.x r10) {
        int r5 = z.n(r10);
        if (r5 == (-1)) goto L5;
        CertificateFactory r11 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L10
        ArrayList r12 = new ArrayList(r5);     // Catch: CertificateException -> L10
        int r13 = 0;
    L7:
        if (r13 >= r5) goto L12;
        String r14 = r10.c(Long.MAX_VALUE);     // Catch: CertificateException -> L10
        nu.j r15 = new nu.j();     // Catch: CertificateException -> L10
        ByteString.Companion.getClass();     // Catch: CertificateException -> L10
        ByteString r16 = nu.m.a(r14);     // Catch: CertificateException -> L10
        Intrinsics.checkNotNull(r16);     // Catch: CertificateException -> L10
        r15.Q(r16);     // Catch: CertificateException -> L10
        r12.add(r11.generateCertificate(new nu.h(r15, 0)));     // Catch: CertificateException -> L10
        r13 = r13 + 1;
        goto L7
    L12:
        return r12;
    L10:
        e = move-exception;
        throw new IOException(e.getMessage());
    L5:
        return CollectionsKt.emptyList();
    }

    public static void b(nu.w r5, List r10) {
        r5.t(r10.size());     // Catch: CertificateEncodingException -> L6
        r5.writeByte(10);     // Catch: CertificateEncodingException -> L6
        int r11 = r10.size();     // Catch: CertificateEncodingException -> L6
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        r5.l(nu.m.d(ByteString.Companion, ((Certificate) r10.get(r12)).getEncoded()).base64());     // Catch: CertificateEncodingException -> L6
        r5.writeByte(10);     // Catch: CertificateEncodingException -> L6
        r12 = r12 + 1;
        goto L3
    L8:
        return;
    L6:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    public final void c(DiskLruCache.Editor r11) {
        String r5 = this.f20632a;
        a0 r10 = this.f20635h;
        c0 r12 = this.g;
        c0 r13 = this.f20633b;
        Intrinsics.checkNotNullParameter(r11, "editor");
        int r14 = 0;
        nu.w r15 = f4.b.d(r11.newSink(0));
        r15.l(r5);     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        r15.l(this.f20634c);     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        r15.t(r13.size());     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        int r16 = r13.size();     // Catch: Throwable -> L8
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L10;
        r15.l(r13.c(r17));     // Catch: Throwable -> L8
        r15.l(": ");     // Catch: Throwable -> L8
        r15.l(r13.e(r17));     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        r17 = r17 + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        r15.l(new StatusLine(this.d, this.e, this.f).toString());     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        r15.t(r12.size() + 2);     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        int r18 = r12.size();     // Catch: Throwable -> L8
    L11:
        if (r14 >= r18) goto L13;
        r15.l(r12.c(r14));     // Catch: Throwable -> L8
        r15.l(": ");     // Catch: Throwable -> L8
        r15.l(r12.e(r14));     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        r14 = r14 + 1;     // Catch: Throwable -> L8
        goto L11
    L13:
        r15.l(f20630k);     // Catch: Throwable -> L8
        r15.l(": ");     // Catch: Throwable -> L8
        r15.t(this.f20636i);     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        r15.l(f20631l);     // Catch: Throwable -> L8
        r15.l(": ");     // Catch: Throwable -> L8
        r15.t(this.f20637j);     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        if (StringsKt.P(r5, "https://") == false) goto L16;
        r15.writeByte(10);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L8
        r15.l(r10.f20618c.f20712a);     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
        b(r15, r10.a());     // Catch: Throwable -> L8
        b(r15, r10.d);     // Catch: Throwable -> L8
        r15.l(r10.f20617b.javaName());     // Catch: Throwable -> L8
        r15.writeByte(10);     // Catch: Throwable -> L8
    L16:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r15, null);
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    }

    public e(s0 r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        Request r5 = r10.f20746b;
        this.f20632a = r5.url().f20644j;
        Intrinsics.checkNotNullParameter(r10, "$this$varyHeaders");
        s0 r11 = r10.f20749i;
        Intrinsics.checkNotNull(r11);
        c0 r12 = r11.f20746b.headers();
        c0 r13 = r10.g;
        Set r14 = z.o(r13);
        if (r14.isEmpty() == false) goto L5;
        c0 r15 = Util.EMPTY_HEADERS;
    L12:
        this.f20633b = r15;
        this.f20634c = r5.method();
        this.d = r10.f20747c;
        this.e = r10.e;
        this.f = r10.d;
        this.g = r13;
        this.f20635h = r10.f;
        this.f20636i = r10.f20752l;
        this.f20637j = r10.f20753m;
        return;
    L5:
        b0 r16 = new b0();
        int r17 = r12.size();
        int r18 = 0;
    L6:
        if (r18 >= r17) goto L11;
        String r19 = r12.c(r18);
        if (r14.contains(r19) == false) goto L10;
        r16.a(r19, r12.e(r18));
    L10:
        r18 = r18 + 1;
        goto L6
    L11:
        r15 = r16.d();
        goto L12
    }
}
