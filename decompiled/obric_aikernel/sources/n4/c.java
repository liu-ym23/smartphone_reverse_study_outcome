package n4;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.c0;
import com.bytedance.retrofit2.o;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.y;
import r4.f;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private URI f11202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f11203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f11204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y f11205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f11206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f11207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f11208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f11209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f11210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f11211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Object f11212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f11213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Map<Class<?>, Object> f11214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f11215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f11217r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RetrofitMetrics f11218s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f11219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f11220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<b> f11221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        f f11222d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        y f11223e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f11224f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f11225g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f11226h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f11227i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f11228j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f11229k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f11230l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        String f11231m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        RetrofitMetrics f11232n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Map<Class<?>, Object> f11233o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f11234p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f11235q;

        public a() {
            this.f11219a = "GET";
        }

        a(c r10) {
            this.f11219a = c.a(r10);
            this.f11220b = c.b(r10);
            LinkedList r11 = new LinkedList();
            this.f11221c = r11;
            r11.addAll(c.j(r10));
            this.f11222d = c.k(r10);
            this.f11223e = c.l(r10);
            this.f11224f = c.m(r10);
            this.f11225g = c.n(r10);
            this.f11226h = c.o(r10);
            this.f11227i = c.p(r10);
            this.f11228j = c.q(r10);
            this.f11229k = c.c(r10);
            this.f11230l = c.d(r10);
            this.f11231m = c.e(r10);
            this.f11232n = c.f(r10);
            this.f11233o = c.g(r10);
            this.f11234p = c.h(r10);
            this.f11235q = c.i(r10);
        }

        public c a() {
            if (this.f11220b == null) goto L7;
            return new c(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public a b(List<b> r10) {
            this.f11221c = r10;
            return this;
        }

        public a c(int r10) {
            this.f11224f = r10;
            return this;
        }

        public a d(int r10) {
            this.f11225g = r10;
            return this;
        }

        public a e(Object r10) {
            this.f11230l = r10;
            return this;
        }

        public a f(String r10) {
            Objects.requireNonNull(r10, "url == null");
            this.f11220b = r10;
            return this;
        }
    }

    public c(String r10, String r11, List<b> r12, f r13, y r14, int r15, int r16, boolean r17, int r18, boolean r19, int r110, Object r111, String r112, Map<Class<?>, Object> r113) {
        this.f11215p = 0;
        Objects.requireNonNull(r10, "Method must not be null.");
        Objects.requireNonNull(r11, "URL must not be null.");
        this.f11200a = r10;
        this.f11201b = r11;
        if (r12 != null) goto L5;
        List<b> r20 = Collections.emptyList();
    L6:
        this.f11203d = r20;
        this.f11204e = r13;
        this.f11205f = r14;
        this.f11206g = r15;
        this.f11207h = r16;
        this.f11208i = r17;
        this.f11209j = r18;
        this.f11210k = r19;
        this.f11211l = r110;
        this.f11212m = r111;
        this.f11213n = r112;
        this.f11214o = r113;
        return;
    L5:
        r20 = Collections.unmodifiableList(new ArrayList(r12));
        goto L6
    }

    c(a r10) {
        this.f11215p = 0;
        String r11 = r10.f11220b;
        Objects.requireNonNull(r11, "URL must not be null.");
        this.f11201b = r11;
        String r12 = r10.f11219a;
        Objects.requireNonNull(r12, "Method must not be null.");
        this.f11200a = r12;
        if (r10.f11221c != null) goto L5;
        List<b> r13 = Collections.emptyList();
    L6:
        this.f11203d = r13;
        this.f11204e = r10.f11222d;
        this.f11205f = r10.f11223e;
        this.f11206g = r10.f11224f;
        this.f11207h = r10.f11225g;
        this.f11208i = r10.f11226h;
        this.f11209j = r10.f11227i;
        this.f11210k = r10.f11228j;
        this.f11211l = r10.f11229k;
        this.f11212m = r10.f11230l;
        this.f11213n = r10.f11231m;
        this.f11218s = r10.f11232n;
        this.f11214o = r10.f11233o;
        this.f11216q = r10.f11234p;
        this.f11217r = r10.f11235q;
        return;
    L5:
        r13 = Collections.unmodifiableList(new ArrayList(r10.f11221c));
        goto L6
    }

    private URI F() {
        if (o.a() == false) goto L18;
        if (this.f11202c != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f11202c != null) goto L10;
        this.f11202c = P(this.f11201b);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L16:
        return this.f11202c;
    L18:
        return P(this.f11201b);
    }

    private static URI P(String r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L17;
        return new URI(r10);
    L8:
        return URI.create(r10.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return r(r10);
    L17:
        return null;
    }

    static /* synthetic */ String a(c r10) {
        return r10.f11200a;
    }

    static /* synthetic */ String b(c r10) {
        return r10.f11201b;
    }

    static /* synthetic */ int c(c r10) {
        return r10.f11211l;
    }

    static /* synthetic */ Object d(c r10) {
        return r10.f11212m;
    }

    static /* synthetic */ String e(c r10) {
        return r10.f11213n;
    }

    static /* synthetic */ RetrofitMetrics f(c r10) {
        return r10.f11218s;
    }

    static /* synthetic */ Map g(c r10) {
        return r10.f11214o;
    }

    static /* synthetic */ boolean h(c r10) {
        return r10.f11216q;
    }

    static /* synthetic */ boolean i(c r10) {
        return r10.f11217r;
    }

    static /* synthetic */ List j(c r10) {
        return r10.f11203d;
    }

    static /* synthetic */ f k(c r10) {
        return r10.f11204e;
    }

    static /* synthetic */ y l(c r10) {
        return r10.f11205f;
    }

    static /* synthetic */ int m(c r10) {
        return r10.f11206g;
    }

    static /* synthetic */ int n(c r10) {
        return r10.f11207h;
    }

    static /* synthetic */ boolean o(c r10) {
        return r10.f11208i;
    }

    static /* synthetic */ int p(c r10) {
        return r10.f11209j;
    }

    static /* synthetic */ boolean q(c r10) {
        return r10.f11210k;
    }

    private static URI r(String r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L18;
        int r11 = r10.indexOf("?");     // Catch: Exception -> L11
        if (r11 <= 0) goto L9;
        r10 = r10.substring(0, r11);     // Catch: Exception -> L11
    L9:
        return URI.create(r10);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    public String A() {
        URI r10 = F();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getPath();
    }

    public int B() {
        return this.f11206g;
    }

    public int C() {
        return this.f11215p;
    }

    public y D() {
        return this.f11205f;
    }

    public int E() {
        return this.f11207h;
    }

    public String G() {
        return this.f11201b;
    }

    public List<b> H(String r10) {
        ArrayList r11 = null;
        if (r10 == null) goto L15;
        List<b> r12 = this.f11203d;
        if (r12 == null) goto L15;
        Iterator<b> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        b r14 = r13.next();
        if (r10.equalsIgnoreCase(r14.a()) == false) goto L9;
        if (r11 != null) goto L14;
        r11 = new ArrayList();
    L14:
        r11.add(r14);
    L15:
        return r11;
    }

    public boolean I() {
        return this.f11210k;
    }

    public boolean J() {
        return this.f11217r;
    }

    public boolean K() {
        List<b> r10 = H("x-tt-bypass-dp");
        if (r10 != null) goto L5;
    L10:
        return false;
    L5:
        if (r10.size() <= 0) goto L10;
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r10.get(0).b()) == false) goto L10;
        return true;
    }

    public boolean L() {
        List<b> r10 = H("x-metasec-bypass-ttnet-features");
        if (r10 != null) goto L5;
    L10:
        return false;
    L5:
        if (r10.size() <= 0) goto L10;
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r10.get(0).b()) == false) goto L10;
        return true;
    }

    public boolean M() {
        return this.f11216q;
    }

    public boolean N() {
        return this.f11208i;
    }

    public a O() {
        return new a(this);
    }

    public void Q(boolean r10) {
        this.f11217r = r10;
    }

    public void R(Object r10) {
        this.f11212m = r10;
    }

    public void S(RetrofitMetrics r10) {
        this.f11218s = r10;
    }

    public void T(boolean r10) {
        this.f11216q = r10;
    }

    public void U(int r10) {
        this.f11215p = r10;
    }

    public <T> T V(Class<? extends T> r10) {
        Map<Class<?>, Object> r11 = this.f11214o;
        if (r11 != null) goto L6;
        return null;
    L6:
        return r10.cast(r11.get(r10));
    }

    public f s() {
        y r10 = this.f11205f;
        if (r10 == null) goto L7;
        return c0.c(r10);
    L7:
        return this.f11204e;
    }

    public Object t() {
        return this.f11212m;
    }

    public b u(String r10) {
        if (r10 == null) goto L13;
        List<b> r11 = this.f11203d;
        if (r11 == null) goto L13;
        Iterator<b> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        b r13 = r12.next();
        if (r10.equalsIgnoreCase(r13.a()) == false) goto L9;
        return r13;
    L13:
        return null;
    }

    public List<b> v() {
        return this.f11203d;
    }

    public String w() {
        URI r10 = F();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getHost();
    }

    public int x() {
        return this.f11209j;
    }

    public String y() {
        return this.f11200a;
    }

    public RetrofitMetrics z() {
        return this.f11218s;
    }
}
