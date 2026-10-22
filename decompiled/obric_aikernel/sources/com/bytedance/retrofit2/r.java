package com.bytedance.retrofit2;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f2619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private StringBuilder f2622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<n4.b> f2624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f2626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bytedance.retrofit2.mime.b f2627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final r4.c f2628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private r4.f f2629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f2631n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f2632o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f2633p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f2634q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f2635r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f2636s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Object f2637t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final okhttp3.v.a f2638u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private okhttp3.y f2639v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f2640w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Map<Class<?>, Object> f2641x;

    private static class a extends okhttp3.y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final okhttp3.y f2642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f2643c;

        a(okhttp3.y r10, String r11) {
            this.f2642b = r10;
            this.f2643c = r11;
        }

        @Override // okhttp3.y
        public long a() {
            return this.f2642b.a();
        }

        @Override // okhttp3.y
        public okhttp3.u b() {
            return okhttp3.u.g(this.f2643c);
        }

        @Override // okhttp3.y
        public void g(okio.e r10) {
            this.f2642b.g(r10);
        }
    }

    private static class b extends com.bytedance.retrofit2.mime.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final r4.f f2644d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f2645e;

        b(r4.f r10, String r11) {
            this.f2644d = r10;
            this.f2645e = r11;
        }

        @Override // com.bytedance.retrofit2.mime.a, r4.f
        public String a() {
            return this.f2645e;
        }

        @Override // com.bytedance.retrofit2.mime.a, r4.f
        public String b() {
            return this.f2644d.b();
        }

        @Override // com.bytedance.retrofit2.mime.a, r4.f
        public String d() {
            this.f2554c = this.f2644d.d();
            return this.f2554c;
        }

        @Override // com.bytedance.retrofit2.mime.a
        public String e() {
            r4.f r10 = this.f2644d;
            if ((r10 instanceof com.bytedance.retrofit2.mime.a) == true) goto L5;
            return null;
        L5:
            return ((com.bytedance.retrofit2.mime.a) r10).e();
        }

        @Override // com.bytedance.retrofit2.mime.a
        public TTRequestCompressManager.b f(String r10, String r11, boolean r12) {
            r4.f r13 = this.f2644d;
            if ((r13 instanceof com.bytedance.retrofit2.mime.a) == true) goto L5;
            return null;
        L5:
            return ((com.bytedance.retrofit2.mime.a) r13).f(r10, r11, r12);
        }

        @Override // com.bytedance.retrofit2.mime.a
        public boolean h() {
            r4.f r10 = this.f2644d;
            if ((r10 instanceof com.bytedance.retrofit2.mime.a) == true) goto L5;
            return false;
        L5:
            return ((com.bytedance.retrofit2.mime.a) r10).h();
        }

        @Override // com.bytedance.retrofit2.mime.a, r4.f
        public long length() {
            return this.f2644d.length();
        }

        @Override // com.bytedance.retrofit2.mime.a, r4.f
        public void writeTo(OutputStream r10) {
            this.f2644d.writeTo(r10);
        }
    }

    r(String r10, h r11, String r12, List<n4.b> r13, String r14, int r15, int r16, boolean r17, int r18, boolean r19, int r110, Object r111, boolean r112, boolean r113, boolean r114, String r20, boolean r21) {
        this.f2641x = new LinkedHashMap();
        this.f2618a = r10;
        this.f2619b = r11;
        this.f2621d = r12;
        this.f2625h = r14;
        this.f2630m = r15;
        this.f2631n = r16;
        this.f2633p = r17;
        this.f2634q = r18;
        this.f2635r = r19;
        this.f2636s = r110;
        this.f2637t = r111;
        this.f2626i = r112;
        this.f2624g = r13;
        this.f2632o = r20;
        if (r113 == false) goto L6;
        com.bytedance.retrofit2.mime.b r22 = new com.bytedance.retrofit2.mime.b(r21);
        this.f2627j = r22;
        this.f2628k = null;
        this.f2629l = r22;
    L5:
        this.f2638u = null;
        return;
    L6:
        this.f2627j = null;
        if (r114 == false) goto L9;
        r4.c r23 = new r4.c();
        this.f2628k = r23;
        this.f2629l = r23;
        okhttp3.v.a r24 = new okhttp3.v.a();
        this.f2638u = r24;
        r24.e(okhttp3.v.f12054i);
        return;
    L9:
        this.f2628k = null;
        goto L5
    }

    private StringBuilder k(String r10, String r11) {
        StringBuilder r12 = new StringBuilder(r10);
        if (r10.endsWith("/") == false) goto L5;
        r12.deleteCharAt(r12.length() - 1);
    L5:
        r12.append(r11);
        return r12;
    }

    void a(String r10, String r11, boolean r12) {
        this.f2627j.k(r10, r12, r11, r12);
    }

    void b(String r10, String r11) {
        if (r10 == null) goto L13;
        if (NetConst.KEY_CONTENT_TYPE.equalsIgnoreCase(r10) == false) goto L7;
        this.f2625h = r11;
        return;
    L7:
        List r12 = this.f2624g;
        if (r12 != null) goto L10;
        r12 = new ArrayList(2);
        this.f2624g = r12;
    L10:
        r12.add(new n4.b(r10, r11));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public void c(String r10, String r11, r4.f r12) {
        this.f2628k.f(r10, r11, r12);
    }

    public void d(String r10, r4.f r11) {
        this.f2628k.g(r10, r11);
    }

    void e(okhttp3.r r10, okhttp3.y r11) {
        this.f2638u.b(r10, r11);
    }

    void f(okhttp3.v.c r10) {
        this.f2638u.c(r10);
    }

    void g(String r10, String r11, boolean r12) {
        String r13 = this.f2621d;
        if (r13 == null) goto L21;
        if (r10 == null) goto L19;
        if (r11 == null) goto L17;
        if (r12 == false) goto L10;
        String r14 = URLEncoder.encode(r11, "UTF-8").replace("+", "%20");     // Catch: UnsupportedEncodingException -> L13
        String r15 = this.f2621d.replace("{" + r10 + "}", r14);     // Catch: UnsupportedEncodingException -> L13
    L9:
        this.f2621d = r15;     // Catch: UnsupportedEncodingException -> L13
        return;
    L10:
        r15 = r13.replace("{" + r10 + "}", r11);     // Catch: UnsupportedEncodingException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException("Unable to convert path parameter \"" + r10 + "\" value to UTF-8:" + r11, e);
    L17:
        throw new IllegalArgumentException("Path replacement \"" + r10 + "\" value must not be null.");
    L19:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L21:
        throw new AssertionError();
    }

    void h(String r10, String r11, boolean r12) {
        if (r10 == null) goto L27;
        StringBuilder r13 = this.f2622e;     // Catch: UnsupportedEncodingException -> L23
        if (r13 != null) goto L7;
        r13 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L23
        this.f2622e = r13;     // Catch: UnsupportedEncodingException -> L23
    L7:
        if (r13.length() <= 0) goto L9;
        char r14 = Typography.amp;
    L10:
        r13.append(r14);     // Catch: UnsupportedEncodingException -> L23
        if (r12 == false) goto L14;
        r10 = URLEncoder.encode(r10, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L14:
        if (r12 == false) goto L16;
        r11 = URLEncoder.encode(r11, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L16:
        if (r11 != null) goto L18;
    L21:
        r13.append(r10);     // Catch: UnsupportedEncodingException -> L23
        return;
    L18:
        if (r11.isEmpty() == true) goto L21;
        r13.append(r10);     // Catch: UnsupportedEncodingException -> L23
        r13.append('=');     // Catch: UnsupportedEncodingException -> L23
        r13.append(r11);     // Catch: UnsupportedEncodingException -> L23
        return;
    L9:
        r14 = '?';
    L23:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r10 + "\" value to UTF-8: " + r11, e);
    L27:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    public <T> void i(Class<? super T> r10, T r11) {
        this.f2641x.put(r10, r10.cast(r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.bytedance.retrofit2.r] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.retrofit2.mime.b] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v2, types: [r4.f] */
    n4.c j(k<?> r18) {
        r4.c r10 = this.f2628k;
        if (r10 != null) goto L5;
    L11:
        ?? r11 = this.f2619b.a();
        if (q.j() == false) goto L95;
        okhttp3.s r12 = okhttp3.s.m(r11);
        if (r12 == null) goto L28;
        if (r12.d() != null) goto L18;
    L22:
        okhttp3.s r13 = r12.q(this.f2621d);
        if (r13 == null) goto L26;
        r11 = new StringBuilder(r13.toString());
    L46:
        StringBuilder r14 = this.f2622e;
        if (r14 != null) goto L49;
    L56:
        String r15 = this.f2623f;
        if (r15 == null) goto L59;
        r11.append(r15);
    L59:
        this.f2620c = r11.toString();
        if ((r18 instanceof k) == false) goto L62;
        r18.c(this);
    L62:
        r4.f r16 = this.f2629l;
        List<n4.b> r17 = this.f2624g;
        okhttp3.y r19 = this.f2639v;
        a r20 = null;
        if (this.f2640w == false) goto L76;
        if (r19 != null) goto L71;
        okhttp3.v.a r21 = this.f2638u;
        if (r21 == null) goto L69;
        r19 = r21.d();
        goto L71
    L69:
        if (this.f2626i == false) goto L71;
        r19 = okhttp3.y.d(null, new byte[0]);
    L71:
        if (r19 != null) goto L73;
    L75:
        List<n4.b> r22 = r17;
        okhttp3.y r23 = r19;
        ?? r24 = r16;
    L86:
        if (r24 != 0) goto L93;
        if (c0.s(this.f2618a) == false) goto L93;
        if (this.f2640w == true) goto L93;
        r24 = new com.bytedance.retrofit2.mime.b();
        r24.j("body", "null");
    L93:
        return new n4.c(this.f2618a, this.f2620c, r22, r24, r23, this.f2630m, this.f2631n, this.f2633p, this.f2634q, this.f2635r, this.f2636s, this.f2637t, this.f2632o, this.f2641x);
    L73:
        if (this.f2625h == null) goto L75;
        r20 = new a(r19, this.f2625h);
    L84:
        r22 = r17;
        r4.f r25 = r16;
    L85:
        r23 = r20;
        r24 = r25;
        goto L86
    L76:
        String r26 = this.f2625h;
        if (r26 == null) goto L84;
        if (r16 == null) goto L80;
        r22 = r17;
        r25 = new b(r16, r26);
        goto L85
    L80:
        n4.b r27 = new n4.b(NetConst.KEY_CONTENT_TYPE, r26);
        if (r17 != null) goto L83;
        r17 = Collections.singletonList(r27);
        goto L84
    L83:
        r17.add(r27);
        goto L84
    L49:
        if ('?' != r14.charAt(0)) goto L55;
        String r28 = this.f2621d;
        if (r28 == null) goto L55;
        if (r28.indexOf(63) == (-1)) goto L55;
        r14.setCharAt(0, Typography.amp);
    L55:
        r11.append(r14);
        goto L56
    L26:
        throw new IllegalArgumentException("Malformed URL. Base: " + r12 + ", Relative: " + this.f2621d);
    L18:
        if (r12.d().length() <= 0) goto L22;
        ?? r29 = r11;
        if ("/".equals(this.f2621d) == false) goto L22;
    L45:
        r11 = k(r29, this.f2621d);
        goto L46
    L28:
        throw new IllegalArgumentException("Malformed URL. Base: " + r12 + ", Relative: " + this.f2621d);
    L95:
        URI r30 = URI.create(r11);     // Catch: Throwable -> L38
        if (r30.getPath() == null) goto L37;
        if (r30.getPath().length() < 1) goto L37;
        if ("/".equals(this.f2621d) == false) goto L37;
        r11 = k(r11, this.f2621d);     // Catch: Throwable -> L38
    L94:
    L37:
        r11 = new StringBuilder(r30.resolve(this.f2621d).toString());     // Catch: Throwable -> L38
    L38:
        String r31 = this.f2621d;
        r29 = r11;
        if (r31 == null) goto L45;
        if (r31.startsWith("http://") == true) goto L44;
        r29 = r11;
        if (this.f2621d.startsWith(ReportConsts.HTTPS) == false) goto L45;
    L44:
        r11 = new StringBuilder(this.f2621d);
        goto L46
    L5:
        if (r10.j() != 0) goto L11;
        if (this.f2640w == true) goto L11;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }

    public void l(boolean r10) {
        this.f2635r = r10;
    }

    void m(okhttp3.y r10) {
        this.f2639v = r10;
    }

    public void n(r4.f r10) {
        this.f2629l = r10;
    }

    public void o(Object r10) {
        this.f2637t = r10;
    }

    public void p(int r10) {
        this.f2634q = r10;
    }

    void q(String r10, String r11) {
        String r12 = this.f2618a;
        if (r12 == null) goto L7;
        this.f2618a = r12.replace("{" + r10 + "}", r11);
        return;
    L7:
        throw new AssertionError();
    }

    void r(String r10) {
        this.f2623f = r10;
    }

    void s(Object r10) {
        Objects.requireNonNull(r10, "@Url parameter is null.");
        this.f2621d = r10.toString();
    }

    void t() {
        this.f2640w = true;
    }
}
