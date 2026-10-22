package ai;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f189c;
    public String d;
    public StringBuilder e;
    public ArrayList f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fi.c f191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final fi.f f192j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public fi.j f193k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f194l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f195m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f196n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f197o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f198p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f199q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Object f200r;
    public final okhttp3.i0 s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public okhttp3.q0 f201t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f202u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinkedHashMap f203v;

    public e0(String r5, k r10, String r11, ArrayList r12, String r13, int r14, int r15, boolean r16, boolean r17, boolean r18, boolean r19, String r110) {
        this.f203v = new LinkedHashMap();
        this.f187a = r5;
        this.f188b = r10;
        this.d = r11;
        this.g = r13;
        this.f194l = r14;
        this.f195m = r15;
        this.f197o = r16;
        this.f198p = -1;
        this.f199q = true;
        this.f200r = null;
        this.f190h = r17;
        this.f = r12;
        this.f196n = r110;
        if (r18 == false) goto L5;
        fi.c r20 = new fi.c();
        this.f191i = r20;
        this.f192j = null;
        this.f193k = r20;
        this.s = null;
        return;
    L5:
        if (r19 == false) goto L7;
        this.f191i = null;
        fi.f r21 = new fi.f();
        this.f192j = r21;
        this.f193k = r21;
        okhttp3.i0 r22 = new okhttp3.i0();
        this.s = r22;
        r22.b(okhttp3.k0.f);
        return;
    L7:
        this.f191i = null;
        this.f192j = null;
        this.s = null;
    }

    public static StringBuilder c(String r5, String r10) {
        StringBuilder r11 = new StringBuilder(r5);
        if (r5.endsWith("/") == false) goto L5;
        r11.deleteCharAt(r11.length() - 1);
    L5:
        r11.append(r10);
        return r11;
    }

    public final void a(String r5, String r10) {
        if (r5 == null) goto L13;
        if ("Content-Type".equalsIgnoreCase(r5) == false) goto L7;
        this.g = r10;
        return;
    L7:
        ArrayList r11 = this.f;
        if (r11 != null) goto L10;
        r11 = new ArrayList(2);
        this.f = r11;
    L10:
        r11.add(new bi.c(r5, r10));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public final void b(String r5, String r10, boolean r11) {
        if (r5 == null) goto L28;
        StringBuilder r12 = this.e;     // Catch: UnsupportedEncodingException -> L6
        if (r12 != null) goto L9;
        r12 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L6
        this.e = r12;     // Catch: UnsupportedEncodingException -> L6
    L9:
        if (r12.length() <= 0) goto L11;
        char r13 = Typography.amp;
    L12:
        r12.append(r13);     // Catch: UnsupportedEncodingException -> L6
        if (r11 == false) goto L16;
        r5 = URLEncoder.encode(r5, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L16:
        if (r11 == false) goto L18;
        r10 = URLEncoder.encode(r10, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L18:
        if (r10 != null) goto L20;
    L23:
        r12.append(r5);     // Catch: UnsupportedEncodingException -> L6
        return;
    L20:
        if (r10.isEmpty() == true) goto L23;
        r12.append(r5);     // Catch: UnsupportedEncodingException -> L6
        r12.append('=');     // Catch: UnsupportedEncodingException -> L6
        r12.append(r10);     // Catch: UnsupportedEncodingException -> L6
        return;
    L11:
        r13 = '?';
    L6:
        e = move-exception;
        throw new RuntimeException(androidx.constraintlayout.motion.widget.a.p("Unable to convert query parameter \"", r5, "\" value to UTF-8: ", r10), e);
    L28:
        throw new IllegalArgumentException("Query param name must not be null.");
    }
}
