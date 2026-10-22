package mu;

import ai.j0;
import com.lynx.tasm.utils.d;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.j;
import nu.l;
import nu.r;
import okhttp3.Request;
import okhttp3.c0;
import okhttp3.f0;
import okhttp3.g0;
import okhttp3.h0;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import okhttp3.n;
import okhttp3.q0;
import okhttp3.s0;
import okhttp3.w0;
import zm.z;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f20182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile HttpLoggingInterceptor$Level f20183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f20184c;

    public a(z r5) {
        Intrinsics.checkNotNullParameter(r5, "logger");
        this.f20184c = r5;
        this.f20182a = SetsKt.emptySet();
        this.f20183b = HttpLoggingInterceptor$Level.NONE;
    }

    public final void a(c0 r5, int r10) {
        if (this.f20182a.contains(r5.c(r10)) == false) goto L5;
        String r11 = "██";
    L6:
        this.f20184c.f(r5.c(r10) + ": " + r11);
        return;
    L5:
        r11 = r5.e(r10);
        goto L6
    }

    @Override // okhttp3.g0
    public final s0 intercept(f0 r23) {
        Intrinsics.checkNotNullParameter(r23, "chain");
        HttpLoggingInterceptor$Level r5 = this.f20183b;
        Request r10 = r23.request();
        if (r5 == HttpLoggingInterceptor$Level.NONE) goto L5;
        boolean r11 = true;
        if (r5 != HttpLoggingInterceptor$Level.BODY) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L12;
    L15:
        q0 r13 = r10.body();
        n r14 = r23.connection();
        StringBuilder r15 = new StringBuilder("--> ");
        r15.append(r10.method());
        r15.append(' ');
        r15.append(r10.url());
        if (r14 == null) goto L18;
        String r16 = " " + r14.protocol();
    L19:
        r15.append(r16);
        String r17 = r15.toString();
        if (r11 == true) goto L23;
        if (r13 == null) goto L23;
        StringBuilder r18 = j0.w(r17, " (");
        r18.append(r13.contentLength());
        r18.append("-byte body)");
        r17 = r18.toString();
    L23:
        this.f20184c.f(r17);
        String r19 = "-byte body omitted)";
        if (r11 == false) goto L71;
        c0 r20 = r10.headers();
        if (r13 == null) goto L39;
        h0 r21 = r13.contentType();
        if (r21 == null) goto L34;
        if (r20.b("Content-Type") != null) goto L34;
        this.f20184c.f("Content-Type: " + r21);
    L34:
        if (r13.contentLength() == (-1)) goto L40;
        if (r20.b("Content-Length") != null) goto L40;
        this.f20184c.f("Content-Length: " + r13.contentLength());
    L40:
        int r22 = r20.size();
        int r24 = 0;
    L41:
        if (r24 >= r22) goto L44;
        a(r20, r24);
        r24 = r24 + 1;
        goto L41
    L44:
        if (r12 == false) goto L70;
        if (r13 == null) goto L70;
        String r25 = r10.headers().b("Content-Encoding");
        if (r25 == null) goto L55;
        if (StringsKt.l(r25, "identity") == true) goto L55;
        if (StringsKt.l(r25, "gzip") == true) goto L55;
        this.f20184c.f("--> END " + r10.method() + " (encoded body omitted)");
    L72:
        long r26 = System.nanoTime();
        s0 r27 = r23.proceed(r10);     // Catch: Exception -> L132
        long r28 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r26);
        w0 r29 = r27.f20748h;
        Intrinsics.checkNotNull(r29);
        long r110 = r29.contentLength();
        if (r110 == (-1)) goto L77;
        String r30 = r110 + "-byte";
    L78:
        z r31 = this.f20184c;
        StringBuilder r111 = new StringBuilder("<-- ");
        r111.append(r27.e);
        if (r27.d.length() != 0) goto L81;
        String r32 = "";
        String r112 = r32;
        char r210 = ' ';
    L82:
        r111.append(r32);
        r111.append(r210);
        r111.append(r27.f20746b.url());
        r111.append(" (");
        r111.append(r28);
        r111.append("ms");
        if (r11 == true) goto L85;
        String r33 = j0.k(", ", r30, " body");
    L86:
        r111.append(r33);
        r111.append(')');
        r31.f(r111.toString());
        if (r11 == false) goto L131;
        c0 r34 = r27.g;
        int r35 = r34.size();
        int r36 = 0;
    L89:
        if (r36 >= r35) goto L91;
        a(r34, r36);
        r36 = r36 + 1;
        goto L89
    L91:
        if (r12 == true) goto L93;
    L130:
        this.f20184c.f("<-- END HTTP");
        goto L131
    L93:
        if (HttpHeaders.promisesBody(r27) == false) goto L130;
        String r37 = r27.g.b("Content-Encoding");
        if (r37 != null) goto L98;
    L102:
        l r38 = r29.source();
        r38.request(Long.MAX_VALUE);
        j r39 = r38.h();
        Long r40 = null;
        if (StringsKt.l("gzip", r34.b("Content-Encoding")) == false) goto L113;
        Long r41 = Long.valueOf(r39.f20328b);
        r r42 = new r(r39.e());
        r39 = new j();     // Catch: Throwable -> L107
        r39.G(r42);     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r42, null);
        r40 = r41;
    L107:
        th = move-exception;
        throw th;     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        CloseableKt.closeFinally(r42, th);
        throw th;
    L113:
        h0 r43 = r29.contentType();
        if (r43 == null) goto L118;
        Charset r44 = r43.a(StandardCharsets.UTF_8);
        if (r44 == null) goto L118;
    L120:
        if (d.r(r39) == true) goto L123;
        this.f20184c.f(r112);
        this.f20184c.f("<-- END HTTP (binary " + r39.f20328b + r19);
        return r27;
    L123:
        String r45 = r112;
        if (r110 == 0) goto L127;
        this.f20184c.f(r45);
        this.f20184c.f(r39.e().A(r44));
    L127:
        if (r40 == null) goto L129;
        this.f20184c.f("<-- END HTTP (" + r39.f20328b + "-byte, " + r40 + "-gzipped-byte body)");
        goto L131
    L129:
        this.f20184c.f("<-- END HTTP (" + r39.f20328b + "-byte body)");
    L118:
        r44 = StandardCharsets.UTF_8;
        goto L120
    L98:
        if (StringsKt.l(r37, "identity") == true) goto L102;
        if (StringsKt.l(r37, "gzip") == true) goto L102;
        this.f20184c.f("<-- END HTTP (encoded body omitted)");
    L131:
        return r27;
    L85:
        r33 = r112;
        goto L86
    L81:
        String r113 = r27.d;
        StringBuilder r46 = new StringBuilder();
        r112 = "";
        r210 = ' ';
        r46.append(String.valueOf(' '));
        r46.append(r113);
        r32 = r46.toString();
        goto L82
    L77:
        r30 = "unknown-length";
    L132:
        e = move-exception;
        this.f20184c.f("<-- HTTP FAILED: " + e);
        throw e;
    L55:
        if (r13.isDuplex() == false) goto L58;
        this.f20184c.f("--> END " + r10.method() + " (duplex request body omitted)");
        goto L72
    L58:
        if (r13.isOneShot() == false) goto L60;
        this.f20184c.f("--> END " + r10.method() + " (one-shot body omitted)");
        goto L72
    L60:
        j r47 = new j();
        r13.writeTo(r47);
        h0 r48 = r13.contentType();
        if (r48 == null) goto L65;
        Charset r49 = r48.a(StandardCharsets.UTF_8);
        if (r49 == null) goto L65;
    L66:
        this.f20184c.f("");
        if (d.r(r47) == false) goto L69;
        this.f20184c.f(r47.A(r49));
        this.f20184c.f("--> END " + r10.method() + " (" + r13.contentLength() + "-byte body)");
        goto L72
    L69:
        this.f20184c.f("--> END " + r10.method() + " (binary " + r13.contentLength() + r19);
    L65:
        r49 = StandardCharsets.UTF_8;
    L70:
        this.f20184c.f("--> END " + r10.method());
        goto L72
    L39:
        r11 = r11;
        goto L40
    L71:
        r11 = r11;
        r19 = "-byte body omitted)";
        goto L72
    L18:
        r16 = "";
        goto L19
    L12:
        if (r5 == HttpLoggingInterceptor$Level.HEADERS) goto L15;
        r11 = false;
        goto L15
    L9:
        r12 = false;
        goto L10
    L5:
        return r23.proceed(r10);
    }
}
