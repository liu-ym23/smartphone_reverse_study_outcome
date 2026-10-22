package ai;

import com.bytedance.retrofit2.client.Request;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f263u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f264v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bi.a f265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f267c;
    public final h.a d;
    public final int e;
    public final int f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Method f269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final w0[] f277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f278r;
    public final String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public i0 f279t;

    static {
        f263u = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        f264v = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    }

    public l0(k0 r5) {
        h0 r10 = r5.f240a;
        this.f265a = r10.f214b;
        this.f266b = r5.D;
        this.f267c = r10.f216h;
        this.d = r10.g;
        this.f270j = r10.f215c;
        this.f271k = r5.C;
        this.f272l = r5.s;
        this.f273m = r5.f257w;
        this.f274n = r5.f254t;
        this.f275o = r5.f255u;
        this.f276p = r5.f256v;
        this.f277q = r5.B;
        this.f278r = r5.f258x;
        this.s = r5.f259y;
        this.e = r5.f;
        this.f = r5.f245j;
        this.g = r5.g;
        this.f268h = r5.f243h;
        this.f269i = r5.f241b;
    }

    public static Class a(Class r5) {
        if (Boolean.TYPE != r5) goto L7;
        return Boolean.class;
    L7:
        if (Byte.TYPE != r5) goto L11;
        return Byte.class;
    L11:
        if (Character.TYPE != r5) goto L15;
        return Character.class;
    L15:
        if (Double.TYPE != r5) goto L19;
        return Double.class;
    L19:
        if (Float.TYPE != r5) goto L23;
        return Float.class;
    L23:
        if (Integer.TYPE != r5) goto L27;
        return Integer.class;
    L27:
        if (Long.TYPE != r5) goto L31;
        return Long.class;
    L31:
        if (Short.TYPE != r5) goto L34;
        return Short.class;
    L34:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v20, types: [fi.c] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r20v0, types: [fi.j] */
    public final Request b(Object... r31) {
        e0 r15 = new e0(this.f272l, this.f270j, this.f273m, this.f278r, this.s, this.e, this.f, this.f268h, this.f274n, this.f275o, this.f276p, this.g);
        if (r31 == null) goto L5;
        int r5 = r31.length;
    L6:
        w0[] r10 = this.f277q;
        if (r5 != r10.length) goto L110;
        ArrayList r11 = new ArrayList(r5);
        int r12 = 0;
    L9:
        if (r12 >= r5) goto L11;
        r11.add(r31[r12]);
        r10[r12].a(r15, r31[r12]);
        r12 = r12 + 1;
        goto L9
    L11:
        r15.f203v.put(p.class, p.class.cast(new p(this.f269i, r11)));
        fi.f r13 = r15.f192j;
        if (r13 != null) goto L14;
    L20:
        ?? r14 = r15.f188b.f239a;
        if (b0.f181b == false) goto L112;
        okhttp3.e0 r16 = okhttp3.e0.h(r14);
        if (r16 == null) goto L37;
        if (r16.b() != null) goto L27;
    L31:
        okhttp3.e0 r17 = r16.j(r15.d);
        if (r17 == null) goto L35;
        r14 = new StringBuilder(r17.f20644j);
    L55:
        StringBuilder r18 = r15.e;
        if (r18 != null) goto L58;
    L65:
        r15.f189c = r14.toString();
        fi.j r19 = r15.f193k;
        ArrayList r20 = r15.f;
        okhttp3.q0 r21 = r15.f201t;
        c0 r22 = null;
        if (r15.f202u == false) goto L85;
        if (r21 != null) goto L78;
        okhttp3.i0 r23 = r15.s;
        if (r23 == null) goto L76;
        ArrayList r24 = r23.f20662c;
        if (r24.isEmpty() == true) goto L74;
        r21 = new okhttp3.k0(r23.f20660a, r23.f20661b, Util.toImmutableList(r24));
        goto L78
    L74:
        throw new IllegalStateException("Multipart body must have at least one part.");
    L76:
        if (r15.f190h == false) goto L78;
        r21 = okhttp3.q0.create(null, new byte[0]);
    L78:
        if (r21 == null) goto L84;
        String r25 = r15.g;
        if (r25 == null) goto L84;
        r22 = new c0(0, r21, r25);
        List r26 = r20;
    L82:
        List r110 = r26;
        fi.j r27 = r19;
    L83:
        okhttp3.q0 r28 = r22;
        ?? r29 = r27;
        List r111 = r110;
    L93:
        if (r29 != 0) goto L108;
        String r30 = r15.f187a;
        if (r30.equals("POST") == true) goto L105;
        if (r30.equals("PUT") == true) goto L105;
        if (r30.equals("PATCH") == true) goto L105;
        if (r30.equals("PROPPATCH") == true) goto L105;
        if (r30.equals("REPORT") == false) goto L108;
    L105:
        if (r15.f202u == true) goto L108;
        r29 = new fi.c();
        r29.f("body", "null", true, true);
    L108:
        return new Request(r15.f187a, r15.f189c, r111, r29, r28, r15.f194l, r15.f195m, r15.f197o, r15.f198p, r15.f199q, r15.f200r, r15.f196n, r15.f203v);
    L84:
        r111 = r20;
        r28 = r21;
        r29 = r19;
        goto L93
    L85:
        String r32 = r15.g;
        r26 = r20;
        if (r32 == null) goto L82;
        if (r19 == null) goto L89;
        r110 = r20;
        r27 = new d0(r19, r32);
        goto L83
    L89:
        bi.c r33 = new bi.c("Content-Type", r32);
        if (r20 != null) goto L92;
        r26 = Collections.singletonList(r33);
        goto L82
    L92:
        r20.add(r33);
        r26 = r20;
        goto L82
    L58:
        if ('?' != r18.charAt(0)) goto L64;
        String r34 = r15.d;
        if (r34 == null) goto L64;
        if (r34.indexOf(63) == (-1)) goto L64;
        r18.setCharAt(0, Typography.amp);
    L64:
        r14.append(r18);
        goto L65
    L35:
        throw new IllegalArgumentException("Malformed URL. Base: " + r16 + ", Relative: " + r15.d);
    L27:
        if (r16.b().length() <= 0) goto L31;
        if ("/".equals(r15.d) == false) goto L31;
        r14 = e0.c(r14, r15.d);
        goto L55
    L37:
        throw new IllegalArgumentException("Malformed URL. Base: " + r16 + ", Relative: " + r15.d);
    L112:
        URI r35 = URI.create(r14);     // Catch: Throwable -> L47
        if (r35.getPath() == null) goto L46;
        if (r35.getPath().length() < 1) goto L46;
        if ("/".equals(r15.d) == false) goto L46;
        r14 = e0.c(r14, r15.d);     // Catch: Throwable -> L47
    L111:
    L46:
        r14 = new StringBuilder(r35.resolve(r15.d).toString());     // Catch: Throwable -> L47
    L47:
        String r36 = r15.d;
        if (r36 != null) goto L50;
    L54:
        r14 = e0.c(r14, r15.d);
        goto L55
    L50:
        if (r36.startsWith("http://") == false) goto L52;
    L53:
        r14 = new StringBuilder(r15.d);
        goto L55
    L52:
        if (r15.d.startsWith("https://") == false) goto L54;
    L14:
        if (r13.f16907a.size() != 0) goto L20;
        if (r15.f202u == true) goto L20;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    L110:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.s(j0.s(r5, "Argument count (", ") doesn't match expected count ("), r10.length, ")"));
    L5:
        r5 = 0;
        goto L6
    }
}
