package com.bytedance.retrofit2;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import o4.d0;
import o4.e0;
import o4.f0;
import o4.g0;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Streaming;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes.dex */
final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f2646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final n4.a.InterfaceC0245a f2647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<q4.a> f2648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Executor f2649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f2650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f2651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f2652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f2653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f2654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f2655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f2656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Object f2657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final Method f2658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final m4.a f2659n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final h f2660o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f<r4.e, T> f2661p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final String f2662q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f2663r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f2664s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f2665t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f2666u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final p<?>[] f2667v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final List<n4.b> f2668w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f2669x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private RetrofitMetrics f2670y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final boolean f2671z;

    static final class a<T> {
        private static final Pattern L = null;
        private static final Pattern M = null;
        boolean A;
        boolean B;
        String C;
        List<n4.b> D;
        String E;
        Set<String> F;
        String G;
        p<?>[] H;
        f<r4.e, T> I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        boolean f2672J;
        boolean K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final t f2673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f2674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f2675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f2676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f2677e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final RetrofitMetrics f2678f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f2679g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f2680h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f2681i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f2682j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f2683k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f2684l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f2685m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f2686n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f2687o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f2688p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f2689q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f2690r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f2691s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f2692t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f2693u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f2694v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f2695w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f2696x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        String f2697y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        boolean f2698z;

        static {
            L = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            M = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        }

        a(t r10, Method r11, RetrofitMetrics r12) {
            this.f2679g = 1;
            this.f2680h = "";
            this.f2681i = false;
            this.f2682j = -1;
            this.f2683k = true;
            this.f2684l = 0;
            this.f2685m = false;
            this.f2686n = null;
            this.f2687o = 3;
            this.f2673a = r10;
            this.f2674b = r11;
            this.f2675c = r11.getAnnotations();
            this.f2677e = r11.getGenericParameterTypes();
            this.f2676d = r11.getParameterAnnotations();
            this.f2678f = r12;
        }

        private p<?> a(Type r10) {
            if (okhttp3.y.class.isAssignableFrom(c0.j(r10)) == true) goto L5;
            return null;
        L5:
            return p.e.f2571a;
        }

        private static Class<?> b(Class<?> r10) {
            if (Boolean.TYPE != r10) goto L7;
            return Boolean.class;
        L7:
            if (Byte.TYPE != r10) goto L11;
            return Byte.class;
        L11:
            if (Character.TYPE != r10) goto L15;
            return Character.class;
        L15:
            if (Double.TYPE != r10) goto L19;
            return Double.class;
        L19:
            if (Float.TYPE != r10) goto L23;
            return Float.class;
        L23:
            if (Integer.TYPE != r10) goto L27;
            return Integer.class;
        L27:
            if (Long.TYPE != r10) goto L31;
            return Long.class;
        L31:
            if (Short.TYPE != r10) goto L34;
            return Short.class;
        L34:
            return r10;
        }

        private okhttp3.r d(String r10, String r11) {
            return okhttp3.r.g(new String[]{"Content-Disposition", "form-data; name=\"" + r10 + "\"", "Content-Transfer-Encoding", r11});
        }

        private List<n4.b> e(String[] r10) {
            ArrayList r11 = new ArrayList();
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L16;
            String r14 = r10[r13];
            int r15 = r14.indexOf(58);
            if (r15 == (-1)) goto L15;
            if (r15 == 0) goto L15;
            if (r15 == (r14.length() - 1)) goto L15;
            String r16 = r14.substring(0, r15);
            String r17 = r14.substring(r15 + 1).trim();
            if (NetConst.KEY_CONTENT_TYPE.equalsIgnoreCase(r16) == false) goto L12;
            this.E = r17;
        L13:
            r13 = r13 + 1;
            goto L3
        L12:
            r11.add(new n4.b(r16, r17));
        L15:
            throw c0.o(this.f2674b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r14});
        L16:
            return r11;
        }

        private void f(String r10, String r11, boolean r12) {
            String r13 = this.f2697y;
            if (r13 != null) goto L31;
            this.f2697y = r10;
            if (r10 == null) goto L8;
            this.G = h(r10);
        L8:
            if (this.G == null) goto L10;
            this.f2685m = true;
        L10:
            this.f2698z = r12;
            if (r11.isEmpty() == false) goto L13;
            return;
        L13:
            int r14 = r11.indexOf(63);
            if (r14 != (-1)) goto L16;
        L28:
            this.C = r11;
            this.F = k(r11);
            return;
        L16:
            if (r14 >= (r11.length() - 1)) goto L28;
            String r15 = r11.substring(r14 + 1);     // Catch: IllegalArgumentException -> L23
            if (L.matcher(r15).find() == false) goto L28;
            throw c0.o(this.f2674b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r15});     // Catch: IllegalArgumentException -> L23
        L23:
            e = move-exception;
            if (e.getMessage().contains("URL query string") == false) goto L28;
            throw e;
        L31:
            throw c0.o(this.f2674b, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r13, r10});
        }

        private void g(Annotation r10) {
            if ((r10 instanceof o4.c) == false) goto L7;
            String r11 = ((o4.c) r10).value();
            String r12 = "DELETE";
        L5:
            f(r12, r11, false);
            return;
        L7:
            if ((r10 instanceof o4.h) == false) goto L10;
            r11 = ((o4.h) r10).value();
            r12 = "GET";
            goto L5
        L10:
            if ((r10 instanceof o4.i) == false) goto L13;
            r11 = ((o4.i) r10).value();
            r12 = "HEAD";
            goto L5
        L13:
            if ((r10 instanceof o4.s) == false) goto L17;
            String r13 = ((o4.s) r10).value();
            String r14 = "PATCH";
        L15:
            f(r14, r13, true);
            return;
        L17:
            if ((r10 instanceof o4.t) == false) goto L20;
            r13 = ((o4.t) r10).value();
            r14 = CloudConfig.REQUEST_TYPE_POST;
            goto L15
        L20:
            if ((r10 instanceof o4.u) == false) goto L23;
            r13 = ((o4.u) r10).value();
            r14 = "PUT";
            goto L15
        L23:
            if ((r10 instanceof o4.r) == false) goto L26;
            r11 = ((o4.r) r10).value();
            r12 = "OPTIONS";
            goto L5
        L26:
            if ((r10 instanceof o4.j) == false) goto L29;
            o4.j r15 = (o4.j) r10;
            f(r15.method(), r15.path(), r15.hasBody());
            return;
        L29:
            if ((r10 instanceof o4.n) == false) goto L36;
            String[] r16 = ((o4.n) r10).value();
            if (r16.length == 0) goto L34;
            this.D = e(r16);
            return;
        L34:
            throw c0.o(this.f2674b, "@Headers annotation is empty.", new Object[0]);
        L36:
            if ((r10 instanceof o4.q) == false) goto L43;
            if (this.A == true) goto L41;
            this.B = true;
            return;
        L41:
            throw c0.o(this.f2674b, "Only one encoding annotation is allowed.", new Object[0]);
        L43:
            if ((r10 instanceof o4.g) == false) goto L50;
            if (this.B == true) goto L48;
            this.A = true;
            this.K = ((o4.g) r10).enableRecord();
            return;
        L48:
            throw c0.o(this.f2674b, "Only one encoding annotation is allowed.", new Object[0]);
        L50:
            if ((r10 instanceof e0) == false) goto L53;
            this.f2681i = true;
            return;
        L53:
            if ((r10 instanceof o4.y) == false) goto L56;
            this.f2679g = ((o4.y) r10).value();
            return;
        L56:
            if ((r10 instanceof d0) == false) goto L59;
            this.f2680h = ((d0) r10).value();
            return;
        L59:
            if ((r10 instanceof o4.c0) == false) goto L71;
            this.f2687o = ((o4.c0) r10).value();
            return;
        }

        static String h(String r10) {
            Matcher r11 = L.matcher(r10);     // Catch: IllegalArgumentException -> L8
            if (r11.find() == false) goto L6;
            return r11.group(1);
        L6:
            return null;
        L11:
            return null;
        }

        private p<?> i(int r10, Type r11, Annotation[] r12, boolean r13) {
            if (r12 == null) goto L18;
            int r14 = r12.length;
            p<?> r15 = null;
            int r16 = 0;
        L5:
            if (r16 >= r14) goto L19;
            Annotation r17 = r12[r16];
            p<?> r18 = j(r10, r11, r12, r17);
            if (r18 == null) goto L9;
        L11:
            if (r18 == null) goto L15;
            if (r15 != null) goto L17;
            r15 = r18;
            goto L15
        L17:
            throw c0.q(this.f2674b, r10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L15:
            r16 = r16 + 1;
            goto L5
        L9:
            if (q.j() == false) goto L11;
            r18 = m(r10, r11, r12, r17);
        L19:
            if (r15 != null) goto L27;
            if (r13 == false) goto L26;
            if (c0.j(r11) != Continuation.class) goto L26;
            this.f2672J = true;     // Catch: NoClassDefFoundError -> L28
            return null;
        L26:
            throw c0.q(this.f2674b, r10, "No Retrofit annotation found.", new Object[0]);
        L27:
            return r15;
        L18:
            r15 = null;
            goto L19
        }

        private p<?> j(int r10, Type r11, Annotation[] r12, Annotation r13) {
            if ((r13 instanceof g0) == false) goto L42;
            r(r10, r11);
            if (this.f2695w == true) goto L40;
            if (this.f2691s == true) goto L38;
            if (this.f2692t == true) goto L36;
            if (this.C != null) goto L34;
            if (this.f2693u == true) goto L32;
            if (this.f2694v == true) goto L30;
            this.f2695w = true;
            if (r11 == String.class) goto L28;
            if (r11 == URI.class) goto L28;
            if ((r11 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r11).getName()) == true) goto L28;
        L26:
            throw c0.q(this.f2674b, r10, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new p.x(this.f2674b, r10);
        L30:
            throw c0.q(this.f2674b, r10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L32:
            throw c0.q(this.f2674b, r10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L34:
            throw c0.q(this.f2674b, r10, "@Url cannot be used with @%s URL", new Object[]{this.f2697y});
        L36:
            throw c0.q(this.f2674b, r10, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw c0.q(this.f2674b, r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw c0.q(this.f2674b, r10, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r13 instanceof o4.x) == false) goto L66;
            r(r10, r11);
            if (this.f2692t == true) goto L64;
            if (this.f2695w == true) goto L62;
            if (this.C == null) goto L60;
            if (this.f2693u == true) goto L58;
            if (this.f2694v == true) goto L56;
            this.f2691s = true;
            o4.x r14 = (o4.x) r13;
            String r15 = r14.value();
            q(r10, r15);
            return new p.s(this.f2674b, r10, r15, this.f2673a.t(r11, r12), r14.encode());
        L56:
            throw c0.q(this.f2674b, r10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L58:
            throw c0.q(this.f2674b, r10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L60:
            throw c0.q(this.f2674b, r10, "@Path can only be used with relative url on @%s", new Object[]{this.f2697y});
        L62:
            throw c0.q(this.f2674b, r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L64:
            throw c0.q(this.f2674b, r10, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r13 instanceof o4.z) == false) goto L82;
            r(r10, r11);
            o4.z r16 = (o4.z) r13;
            String r17 = r16.value();
            boolean r18 = r16.encode();
            Class<?> r19 = c0.j(r11);
            this.f2692t = true;
            if (Iterable.class.isAssignableFrom(r19) == false) goto L76;
            if ((r11 instanceof ParameterizedType) == false) goto L74;
            return new p.t(r17, this.f2673a.t(c0.i(0, (ParameterizedType) r11), r12), r18).c();
        L74:
            throw c0.q(this.f2674b, r10, r19.getSimpleName() + " must include generic type (e.g., " + r19.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r19.isArray() == false) goto L80;
            return new p.t(r17, this.f2673a.t(b(r19.getComponentType()), r12), r18).b();
        L80:
            return new p.t(r17, this.f2673a.t(r11, r12), r18);
        L82:
            if ((r13 instanceof o4.b0) == false) goto L98;
            r(r10, r11);
            boolean r110 = ((o4.b0) r13).encoded();
            Class<?> r20 = c0.j(r11);
            this.f2693u = true;
            if (Iterable.class.isAssignableFrom(r20) == false) goto L92;
            if ((r11 instanceof ParameterizedType) == false) goto L90;
            return new p.v(this.f2673a.t(c0.i(0, (ParameterizedType) r11), r12), r110).c();
        L90:
            throw c0.q(this.f2674b, r10, r20.getSimpleName() + " must include generic type (e.g., " + r20.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r20.isArray() == false) goto L96;
            return new p.v(this.f2673a.t(b(r20.getComponentType()), r12), r110).b();
        L96:
            return new p.v(this.f2673a.t(r11, r12), r110);
        L98:
            if ((r13 instanceof o4.a0) == false) goto L114;
            r(r10, r11);
            Class<?> r21 = c0.j(r11);
            this.f2694v = true;
            if (Map.class.isAssignableFrom(r21) == false) goto L112;
            Type r22 = c0.k(r11, r21, Map.class);
            if ((r22 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r23 = (ParameterizedType) r22;
            Type r24 = c0.i(0, r23);
            if (String.class != r24) goto L108;
            return new p.u(this.f2674b, r10, this.f2673a.t(c0.i(1, r23), r12), ((o4.a0) r13).encode());
        L108:
            throw c0.q(this.f2674b, r10, "@QueryMap keys must be of type String: " + r24, new Object[0]);
        L110:
            throw c0.q(this.f2674b, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw c0.q(this.f2674b, r10, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r13 instanceof o4.k) == false) goto L130;
            r(r10, r11);
            String r111 = ((o4.k) r13).value();
            Class<?> r25 = c0.j(r11);
            if (Iterable.class.isAssignableFrom(r25) == false) goto L124;
            if ((r11 instanceof ParameterizedType) == false) goto L122;
            return new p.l(r111, this.f2673a.t(c0.i(0, (ParameterizedType) r11), r12)).c();
        L122:
            throw c0.q(this.f2674b, r10, r25.getSimpleName() + " must include generic type (e.g., " + r25.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r25.isArray() == false) goto L128;
            return new p.l(r111, this.f2673a.t(b(r25.getComponentType()), r12)).b();
        L128:
            return new p.l(r111, this.f2673a.t(r11, r12));
        L130:
            if ((r13 instanceof o4.l) == false) goto L146;
            Class<?> r112 = c0.j(r11);
            if (List.class.isAssignableFrom(r112) == false) goto L144;
            Type r26 = c0.k(r11, r112, List.class);
            if ((r26 instanceof ParameterizedType) == false) goto L142;
            Type r27 = c0.i(0, (ParameterizedType) r26);
            if (n4.b.class != r27) goto L140;
            return new p.m(this.f2673a.g(r27, r12));
        L140:
            throw c0.q(this.f2674b, r10, "@HeaderList keys must be of type retrofit.client.Header: " + r27, new Object[0]);
        L142:
            throw c0.q(this.f2674b, r10, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L144:
            throw c0.q(this.f2674b, r10, "@HeaderList parameter type must be List.", new Object[0]);
        L146:
            if ((r13 instanceof o4.m) == false) goto L162;
            r(r10, r11);
            Class<?> r113 = c0.j(r11);
            if (Map.class.isAssignableFrom(r113) == false) goto L160;
            Type r28 = c0.k(r11, r113, Map.class);
            if ((r28 instanceof ParameterizedType) == false) goto L158;
            ParameterizedType r29 = (ParameterizedType) r28;
            Type r114 = c0.i(0, r29);
            if (String.class != r114) goto L156;
            return new p.n(this.f2674b, r10, this.f2673a.t(c0.i(1, r29), r12));
        L156:
            throw c0.q(this.f2674b, r10, "@HeaderMap keys must be of type String: " + r114, new Object[0]);
        L158:
            throw c0.q(this.f2674b, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L160:
            throw c0.q(this.f2674b, r10, "@HeaderMap parameter type must be Map.", new Object[0]);
        L162:
            if ((r13 instanceof o4.e) == false) goto L182;
            r(r10, r11);
            if (this.A == false) goto L180;
            o4.e r115 = (o4.e) r13;
            String r30 = r115.value();
            boolean r116 = r115.encode();
            this.f2688p = true;
            Class<?> r31 = c0.j(r11);
            if (Iterable.class.isAssignableFrom(r31) == false) goto L174;
            if ((r11 instanceof ParameterizedType) == false) goto L172;
            return new p.j(r30, this.f2673a.t(c0.i(0, (ParameterizedType) r11), r12), r116).c();
        L172:
            throw c0.q(this.f2674b, r10, r31.getSimpleName() + " must include generic type (e.g., " + r31.getSimpleName() + "<String>)", new Object[0]);
        L174:
            if (r31.isArray() == false) goto L178;
            return new p.j(r30, this.f2673a.t(b(r31.getComponentType()), r12), r116).b();
        L178:
            return new p.j(r30, this.f2673a.t(r11, r12), r116);
        L180:
            throw c0.q(this.f2674b, r10, "@Field parameters can only be used with form encoding.", new Object[0]);
        L182:
            if ((r13 instanceof o4.f) == false) goto L202;
            r(r10, r11);
            if (this.A == false) goto L200;
            Class<?> r32 = c0.j(r11);
            if (Map.class.isAssignableFrom(r32) == false) goto L198;
            Type r33 = c0.k(r11, r32, Map.class);
            if ((r33 instanceof ParameterizedType) == false) goto L196;
            ParameterizedType r34 = (ParameterizedType) r33;
            Type r35 = c0.i(0, r34);
            if (String.class != r35) goto L194;
            f<T, String> r36 = this.f2673a.t(c0.i(1, r34), r12);
            this.f2688p = true;
            return new p.k(this.f2674b, r10, r36, ((o4.f) r13).encode());
        L194:
            throw c0.q(this.f2674b, r10, "@FieldMap keys must be of type String: " + r35, new Object[0]);
        L196:
            throw c0.q(this.f2674b, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L198:
            throw c0.q(this.f2674b, r10, "@FieldMap parameter type must be Map.", new Object[0]);
        L200:
            throw c0.q(this.f2674b, r10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L202:
            if ((r13 instanceof o4.v) == false) goto L213;
            if (this.B == false) goto L211;
            o4.v r117 = (o4.v) r13;
            this.f2689q = true;
            p<?> r37 = n(r11, r117.value(), r117.encoding());
            if (r37 == null) goto L209;
            return r37;
        L209:
            return new p.q(this.f2674b, r10, r117.value(), this.f2673a.p(r11, r12, this.f2675c));
        L211:
            throw c0.q(this.f2674b, r10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L213:
            if ((r13 instanceof o4.w) == false) goto L236;
            r(r10, r11);
            if (this.B == false) goto L234;
            this.f2689q = true;
            Class<?> r38 = c0.j(r11);
            if (Map.class.isAssignableFrom(r38) == false) goto L232;
            Type r39 = c0.k(r11, r38, Map.class);
            if ((r39 instanceof ParameterizedType) == false) goto L230;
            ParameterizedType r40 = (ParameterizedType) r39;
            Type r41 = c0.i(0, r40);
            if (String.class != r41) goto L228;
            p<?> r42 = o(r40, r13);
            if (r42 == null) goto L226;
            return r42;
        L226:
            return new p.r(this.f2674b, r10, this.f2673a.p(c0.i(1, r40), r12, this.f2675c), ((o4.w) r13).encoding());
        L228:
            throw c0.q(this.f2674b, r10, "@PartMap keys must be of type String: " + r41, new Object[0]);
        L230:
            throw c0.q(this.f2674b, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L232:
            throw c0.q(this.f2674b, r10, "@PartMap parameter type must be Map.", new Object[0]);
        L234:
            throw c0.q(this.f2674b, r10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L236:
            if ((r13 instanceof o4.b) == false) goto L258;
            r(r10, r11);
            if (this.A == true) goto L256;
            if (this.B == true) goto L256;
            if (this.f2690r == true) goto L254;
            p<?> r118 = a(r11);
            if (r118 == null) goto L314;
            this.f2690r = true;
            return r118;
        L314:
            f<T, r4.f> r43 = this.f2673a.p(r11, r12, this.f2675c);     // Catch: RuntimeException -> L250
            this.f2690r = true;
            return new p.d(this.f2674b, r10, this.f2685m, r43);
        L250:
            e = move-exception;
            throw c0.r(this.f2674b, e, r10, "Unable to create @Body converter for %s", new Object[]{r11});
        L254:
            throw c0.q(this.f2674b, r10, "Multiple @Body method annotations found.", new Object[0]);
        L256:
            throw c0.q(this.f2674b, r10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L258:
            if ((r13 instanceof o4.p) == false) goto L266;
            if (this.f2696x == true) goto L264;
            this.f2696x = true;
            String r119 = ((o4.p) r13).value();
            p(r10, r119);
            return new p.C0070p(r119, this.f2673a.t(r11, r12));
        L264:
            throw c0.q(this.f2674b, r10, "Multiple @Method method annotations found.", new Object[0]);
        L266:
            if ((r13 instanceof o4.o) == false) goto L274;
            return new p.o(this.f2673a.t(r11, r12));
        L270:
            e = move-exception;
            throw c0.r(this.f2674b, e, r10, "Unable to create @MaxLength converter for %s", new Object[]{r11});
        L274:
            if ((r13 instanceof o4.a) == false) goto L283;
            this.f2684l = ((o4.a) r13).level();
            return new p.c(this.f2673a.t(r11, r12));
        L279:
            e = move-exception;
            throw c0.r(this.f2674b, e, r10, "Unable to create @AddCommonParam converter for %s", new Object[]{r11});
        L283:
            if ((r13 instanceof o4.d) == false) goto L291;
            return new p.i(this.f2673a.o(r11, r12));
        L287:
            e = move-exception;
            throw c0.r(this.f2674b, e, r10, "Unable to create @ExtraInfo converter for %s", new Object[]{r11});
        L291:
            if ((r13 instanceof p4.a) == false) goto L299;
            if (p4.b.class.isAssignableFrom(c0.j(r11)) == false) goto L297;
            return new p.w();
        L297:
            throw c0.q(this.f2674b, r10, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r11});
        L299:
            if ((r13 instanceof f0) == false) goto L312;
            r(r10, r11);
            Class<?> r44 = c0.j(r11);
            int r120 = r10 - 1;
        L301:
            if (r120 < 0) goto L311;
            p<?> r121 = this.H[r120];
            if ((r121 instanceof p.y) == false) goto L309;
            if (((p.y) r121).f2614a.equals(r44) == false) goto L309;
            throw c0.q(this.f2674b, r10, "@Tag type " + r44.getName() + " is duplicate of parameter #" + (r120 + 1) + " and would always overwrite its value.", new Object[0]);
        L309:
            r120 = r120 - 1;
            goto L301
        L311:
            return new p.y(r44);
        L312:
            return null;
        }

        static Set<String> k(String r10) {
            LinkedHashSet r11 = new LinkedHashSet();
            Matcher r12 = L.matcher(r10);     // Catch: IllegalArgumentException -> L9
        L5:
            if (r12.find() == false) goto L8;
            r11.add(r12.group(1));     // Catch: IllegalArgumentException -> L9
        L8:
            return r11;
        }

        private void l(Annotation r10) {
            if ((r10 instanceof DELETE) == false) goto L7;
            String r11 = ((DELETE) r10).value();
            String r12 = "DELETE";
        L5:
            f(r12, r11, false);
            return;
        L7:
            if ((r10 instanceof GET) == false) goto L10;
            r11 = ((GET) r10).value();
            r12 = "GET";
            goto L5
        L10:
            if ((r10 instanceof HEAD) == false) goto L13;
            r11 = ((HEAD) r10).value();
            r12 = "HEAD";
            goto L5
        L13:
            if ((r10 instanceof PATCH) == false) goto L17;
            String r13 = ((PATCH) r10).value();
            String r14 = "PATCH";
        L15:
            f(r14, r13, true);
            return;
        L17:
            if ((r10 instanceof POST) == false) goto L20;
            r13 = ((POST) r10).value();
            r14 = CloudConfig.REQUEST_TYPE_POST;
            goto L15
        L20:
            if ((r10 instanceof PUT) == false) goto L23;
            r13 = ((PUT) r10).value();
            r14 = "PUT";
            goto L15
        L23:
            if ((r10 instanceof OPTIONS) == false) goto L26;
            r11 = ((OPTIONS) r10).value();
            r12 = "OPTIONS";
            goto L5
        L26:
            if ((r10 instanceof HTTP) == false) goto L29;
            HTTP r15 = (HTTP) r10;
            f(r15.method(), r15.path(), r15.hasBody());
            return;
        L29:
            if ((r10 instanceof Headers) == false) goto L36;
            String[] r16 = ((Headers) r10).value();
            if (r16.length == 0) goto L34;
            this.D = e(r16);
            return;
        L34:
            throw c0.o(this.f2674b, "@Headers annotation is empty.", new Object[0]);
        L36:
            if ((r10 instanceof Multipart) == false) goto L43;
            if (this.A == true) goto L41;
            this.B = true;
            return;
        L41:
            throw c0.o(this.f2674b, "Only one encoding annotation is allowed.", new Object[0]);
        L43:
            if ((r10 instanceof FormUrlEncoded) == false) goto L50;
            if (this.B == true) goto L48;
            this.A = true;
            return;
        L48:
            throw c0.o(this.f2674b, "Only one encoding annotation is allowed.", new Object[0]);
        L50:
            if ((r10 instanceof Streaming) == false) goto L59;
            this.f2681i = true;
            return;
        }

        private p<?> m(int r11, Type r12, Annotation[] r13, Annotation r14) {
            if ((r14 instanceof Url) == false) goto L42;
            r(r11, r12);
            if (this.f2695w == true) goto L40;
            if (this.f2691s == true) goto L38;
            if (this.f2692t == true) goto L36;
            if (this.f2693u == true) goto L34;
            if (this.f2694v == true) goto L32;
            if (this.C != null) goto L30;
            this.f2695w = true;
            if (r12 == String.class) goto L28;
            if (r12 == URI.class) goto L28;
            if ((r12 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r12).getName()) == true) goto L28;
        L26:
            throw c0.q(this.f2674b, r11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new p.x(this.f2674b, r11);
        L30:
            throw c0.q(this.f2674b, r11, "@Url cannot be used with @%s URL", new Object[]{this.f2697y});
        L32:
            throw c0.q(this.f2674b, r11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L34:
            throw c0.q(this.f2674b, r11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L36:
            throw c0.q(this.f2674b, r11, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw c0.q(this.f2674b, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw c0.q(this.f2674b, r11, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r14 instanceof Path) == false) goto L66;
            r(r11, r12);
            if (this.f2692t == true) goto L64;
            if (this.f2693u == true) goto L62;
            if (this.f2694v == true) goto L60;
            if (this.f2695w == true) goto L58;
            if (this.C == null) goto L56;
            this.f2691s = true;
            Path r15 = (Path) r14;
            String r10 = r15.value();
            q(r11, r10);
            return new p.s(this.f2674b, r11, r10, this.f2673a.t(r12, r13), !r15.encoded());
        L56:
            throw c0.q(this.f2674b, r11, "@Path can only be used with relative url on @%s", new Object[]{this.f2697y});
        L58:
            throw c0.q(this.f2674b, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L60:
            throw c0.q(this.f2674b, r11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L62:
            throw c0.q(this.f2674b, r11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L64:
            throw c0.q(this.f2674b, r11, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r14 instanceof Query) == false) goto L82;
            r(r11, r12);
            Query r16 = (Query) r14;
            String r17 = r16.value();
            boolean r18 = r16.encoded();
            Class<?> r19 = c0.j(r12);
            this.f2692t = true;
            if (Iterable.class.isAssignableFrom(r19) == false) goto L76;
            if ((r12 instanceof ParameterizedType) == false) goto L74;
            return new p.t(r17, this.f2673a.t(c0.i(0, (ParameterizedType) r12), r13), !r18).c();
        L74:
            throw c0.q(this.f2674b, r11, r19.getSimpleName() + " must include generic type (e.g., " + r19.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r19.isArray() == false) goto L80;
            return new p.t(r17, this.f2673a.t(b(r19.getComponentType()), r13), !r18).b();
        L80:
            return new p.t(r17, this.f2673a.t(r12, r13), !r18);
        L82:
            if ((r14 instanceof QueryName) == false) goto L98;
            r(r11, r12);
            boolean r110 = ((QueryName) r14).encoded();
            Class<?> r20 = c0.j(r12);
            this.f2693u = true;
            if (Iterable.class.isAssignableFrom(r20) == false) goto L92;
            if ((r12 instanceof ParameterizedType) == false) goto L90;
            return new p.v(this.f2673a.t(c0.i(0, (ParameterizedType) r12), r13), r110).c();
        L90:
            throw c0.q(this.f2674b, r11, r20.getSimpleName() + " must include generic type (e.g., " + r20.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r20.isArray() == false) goto L96;
            return new p.v(this.f2673a.t(b(r20.getComponentType()), r13), r110).b();
        L96:
            return new p.v(this.f2673a.t(r12, r13), r110);
        L98:
            if ((r14 instanceof QueryMap) == false) goto L114;
            r(r11, r12);
            Class<?> r21 = c0.j(r12);
            this.f2694v = true;
            if (Map.class.isAssignableFrom(r21) == false) goto L112;
            Type r111 = c0.k(r12, r21, Map.class);
            if ((r111 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r112 = (ParameterizedType) r111;
            Type r22 = c0.i(0, r112);
            if (String.class != r22) goto L108;
            return new p.u(this.f2674b, r11, this.f2673a.t(c0.i(1, r112), r13), !((QueryMap) r14).encoded());
        L108:
            throw c0.q(this.f2674b, r11, "@QueryMap keys must be of type String: " + r22, new Object[0]);
        L110:
            throw c0.q(this.f2674b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw c0.q(this.f2674b, r11, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r14 instanceof Header) == false) goto L130;
            r(r11, r12);
            String r113 = ((Header) r14).value();
            Class<?> r23 = c0.j(r12);
            if (Iterable.class.isAssignableFrom(r23) == false) goto L124;
            if ((r12 instanceof ParameterizedType) == false) goto L122;
            return new p.l(r113, this.f2673a.t(c0.i(0, (ParameterizedType) r12), r13)).c();
        L122:
            throw c0.q(this.f2674b, r11, r23.getSimpleName() + " must include generic type (e.g., " + r23.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r23.isArray() == false) goto L128;
            return new p.l(r113, this.f2673a.t(b(r23.getComponentType()), r13)).b();
        L128:
            return new p.l(r113, this.f2673a.t(r12, r13));
        L130:
            if ((r14 instanceof HeaderMap) == false) goto L146;
            r(r11, r12);
            Class<?> r114 = c0.j(r12);
            if (Map.class.isAssignableFrom(r114) == false) goto L144;
            Type r115 = c0.k(r12, r114, Map.class);
            if ((r115 instanceof ParameterizedType) == false) goto L142;
            ParameterizedType r116 = (ParameterizedType) r115;
            Type r117 = c0.i(0, r116);
            if (String.class != r117) goto L140;
            return new p.n(this.f2674b, r11, this.f2673a.t(c0.i(1, r116), r13));
        L140:
            throw c0.q(this.f2674b, r11, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L142:
            throw c0.q(this.f2674b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L144:
            throw c0.q(this.f2674b, r11, "@HeaderMap parameter type must be Map.", new Object[0]);
        L146:
            if ((r14 instanceof Field) == false) goto L166;
            r(r11, r12);
            if (this.A == false) goto L164;
            Field r118 = (Field) r14;
            String r24 = r118.value();
            boolean r119 = r118.encoded();
            this.f2688p = true;
            Class<?> r25 = c0.j(r12);
            if (Iterable.class.isAssignableFrom(r25) == false) goto L158;
            if ((r12 instanceof ParameterizedType) == false) goto L156;
            return new p.j(r24, this.f2673a.t(c0.i(0, (ParameterizedType) r12), r13), !r119).c();
        L156:
            throw c0.q(this.f2674b, r11, r25.getSimpleName() + " must include generic type (e.g., " + r25.getSimpleName() + "<String>)", new Object[0]);
        L158:
            if (r25.isArray() == false) goto L162;
            return new p.j(r24, this.f2673a.t(b(r25.getComponentType()), r13), !r119).b();
        L162:
            return new p.j(r24, this.f2673a.t(r12, r13), !r119);
        L164:
            throw c0.q(this.f2674b, r11, "@Field parameters can only be used with form encoding.", new Object[0]);
        L166:
            if ((r14 instanceof FieldMap) == false) goto L186;
            r(r11, r12);
            if (this.A == false) goto L184;
            Class<?> r26 = c0.j(r12);
            if (Map.class.isAssignableFrom(r26) == false) goto L182;
            Type r120 = c0.k(r12, r26, Map.class);
            if ((r120 instanceof ParameterizedType) == false) goto L180;
            ParameterizedType r121 = (ParameterizedType) r120;
            Type r27 = c0.i(0, r121);
            if (String.class != r27) goto L178;
            f<T, String> r122 = this.f2673a.t(c0.i(1, r121), r13);
            this.f2688p = true;
            return new p.k(this.f2674b, r11, r122, !((FieldMap) r14).encoded());
        L178:
            throw c0.q(this.f2674b, r11, "@FieldMap keys must be of type String: " + r27, new Object[0]);
        L180:
            throw c0.q(this.f2674b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L182:
            throw c0.q(this.f2674b, r11, "@FieldMap parameter type must be Map.", new Object[0]);
        L184:
            throw c0.q(this.f2674b, r11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L186:
            if ((r14 instanceof Part) == false) goto L197;
            if (this.B == false) goto L195;
            Part r123 = (Part) r14;
            this.f2689q = true;
            p<?> r28 = n(r12, r123.value(), r123.encoding());
            if (r28 == null) goto L193;
            return r28;
        L193:
            return new p.q(this.f2674b, r11, r123.value(), this.f2673a.p(r12, r13, this.f2675c));
        L195:
            throw c0.q(this.f2674b, r11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L197:
            if ((r14 instanceof PartMap) == false) goto L221;
            r(r11, r12);
            if (this.B == false) goto L219;
            this.f2689q = true;
            Class<?> r29 = c0.j(r12);
            if (Map.class.isAssignableFrom(r29) == false) goto L217;
            Type r124 = c0.k(r12, r29, Map.class);
            if ((r124 instanceof ParameterizedType) == false) goto L215;
            ParameterizedType r125 = (ParameterizedType) r124;
            Type r30 = c0.i(0, r125);
            if (String.class != r30) goto L213;
            Type r126 = c0.i(1, r125);
            if (okhttp3.v.c.class.isAssignableFrom(c0.j(r126)) == true) goto L211;
            return new p.r(this.f2674b, r11, this.f2673a.p(r126, r13, this.f2675c), ((PartMap) r14).encoding());
        L211:
            throw c0.q(this.f2674b, r11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L213:
            throw c0.q(this.f2674b, r11, "@PartMap keys must be of type String: " + r30, new Object[0]);
        L215:
            throw c0.q(this.f2674b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L217:
            throw c0.q(this.f2674b, r11, "@PartMap parameter type must be Map.", new Object[0]);
        L219:
            throw c0.q(this.f2674b, r11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L221:
            if ((r14 instanceof Body) == false) goto L243;
            r(r11, r12);
            if (this.A == true) goto L241;
            if (this.B == true) goto L241;
            if (this.f2690r == true) goto L239;
            p<?> r127 = a(r12);
            if (r127 == null) goto L258;
            this.f2690r = true;
            return r127;
        L258:
            f<T, r4.f> r128 = this.f2673a.p(r12, r13, this.f2675c);     // Catch: RuntimeException -> L235
            this.f2690r = true;
            return new p.d(this.f2674b, r11, this.f2685m, r128);
        L235:
            e = move-exception;
            throw c0.r(this.f2674b, e, r11, "Unable to create @Body converter for %s", new Object[]{r12});
        L239:
            throw c0.q(this.f2674b, r11, "Multiple @Body method annotations found.", new Object[0]);
        L241:
            throw c0.q(this.f2674b, r11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L243:
            if ((r14 instanceof Tag) == false) goto L256;
            r(r11, r12);
            Class<?> r129 = c0.j(r12);
            int r130 = r11 - 1;
        L245:
            if (r130 < 0) goto L255;
            p<?> r131 = this.H[r130];
            if ((r131 instanceof p.y) == false) goto L253;
            if (((p.y) r131).f2614a.equals(r129) == false) goto L253;
            throw c0.q(this.f2674b, r11, "@Tag type " + r129.getName() + " is duplicate of parameter #" + (r130 + 1) + " and would always overwrite its value.", new Object[0]);
        L253:
            r130 = r130 - 1;
            goto L245
        L255:
            return new p.y(r129);
        L256:
            return null;
        }

        private p<?> n(Type r10, String r11, String r12) {
            Class<?> r13 = c0.j(r10);
            if (TextUtils.isEmpty(r11) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r13) == false) goto L14;
            if ((r10 instanceof ParameterizedType) == true) goto L10;
            return null;
        L10:
            if (okhttp3.v.c.class.isAssignableFrom(c0.j(c0.i(0, (ParameterizedType) r10))) == true) goto L12;
        L42:
            return null;
        L12:
            return p.h.f2574a.c();
        L14:
            if (r13.isArray() == false) goto L20;
            if (okhttp3.v.c.class.isAssignableFrom(r13.getComponentType()) == false) goto L42;
            return p.h.f2574a.b();
        L20:
            if (okhttp3.v.c.class.isAssignableFrom(r13) == false) goto L42;
            return p.h.f2574a;
        L24:
            if (Iterable.class.isAssignableFrom(r13) == false) goto L33;
            if ((r10 instanceof ParameterizedType) == true) goto L29;
            return null;
        L29:
            if (okhttp3.y.class.isAssignableFrom(c0.j(c0.i(0, (ParameterizedType) r10))) == false) goto L42;
            return new p.f(d(r11, r12)).c();
        L33:
            if (r13.isArray() == false) goto L39;
            if (okhttp3.y.class.isAssignableFrom(b(r13.getComponentType())) == false) goto L42;
            return new p.f(d(r11, r12)).b();
        L39:
            if (okhttp3.y.class.isAssignableFrom(r13) == false) goto L42;
            return new p.f(d(r11, r12));
        }

        private p<?> o(ParameterizedType r10, Annotation r11) {
            if (okhttp3.y.class.isAssignableFrom(c0.j(c0.i(1, r10))) == true) goto L5;
            return null;
        L5:
            return new p.g(((o4.w) r11).encoding());
        }

        private void p(int r10, String r11) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                r0 = 1
                r1 = 0
                r2 = 2
                java.util.regex.Pattern r3 = com.bytedance.retrofit2.s.a.M     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Matcher r3 = r3.matcher(r9)     // Catch: java.lang.IllegalArgumentException -> L25
                boolean r3 = r3.matches()     // Catch: java.lang.IllegalArgumentException -> L25
                if (r3 == 0) goto L10
                goto L32
            L10:
                java.lang.reflect.Method r3 = r7.f2674b     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r4 = "@Method parameter name must match %s. Found: %s"
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Pattern r6 = com.bytedance.retrofit2.s.a.L     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r6 = r6.pattern()     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r1] = r6     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r0] = r9     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.RuntimeException r3 = com.bytedance.retrofit2.c0.q(r3, r8, r4, r5)     // Catch: java.lang.IllegalArgumentException -> L25
                throw r3     // Catch: java.lang.IllegalArgumentException -> L25
            L25:
                r3 = move-exception
                java.lang.String r4 = r3.getMessage()
                java.lang.String r5 = "@Method parameter name must match"
                boolean r4 = r4.contains(r5)
                if (r4 != 0) goto L4f
            L32:
                java.lang.String r3 = r7.G
                if (r3 == 0) goto L4e
                boolean r3 = r3.equals(r9)
                if (r3 == 0) goto L3d
                goto L4e
            L3d:
                java.lang.reflect.Method r3 = r7.f2674b
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r7 = r7.f2697y
                r2[r1] = r7
                r2[r0] = r9
                java.lang.String r7 = "Method \"%s\" does not contain \"{%s}\"."
                java.lang.RuntimeException r7 = com.bytedance.retrofit2.c0.q(r3, r8, r7, r2)
                throw r7
            L4e:
                return
            L4f:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.retrofit2.s.a.p(int, java.lang.String):void");
        }

        private void q(int r10, String r11) {
        L8:
            e = move-exception;
            if (e.getMessage().contains("@Path parameter name must match") == false) goto L12;
            throw e;
        L12:
            if (this.F.contains(r11) == false) goto L15;
            return;
        L15:
            throw c0.q(this.f2674b, r10, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.C, r11});
        L4:
            if (M.matcher(r11).matches() == true) goto L12;
            throw c0.q(this.f2674b, r10, "@Path parameter name must match %s. Found: %s", new Object[]{L.pattern(), r11});     // Catch: IllegalArgumentException -> L8
        }

        private void r(int r10, Type r11) {
            if (c0.l(r11) == true) goto L6;
            return;
        L6:
            throw c0.q(this.f2674b, r10, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r11});
        }

        s c() {
            Annotation[] r10 = this.f2675c;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L9;
            Annotation r13 = r10[r12];
            g(r13);
            if (q.j() == false) goto L7;
            l(r13);
        L7:
            r12 = r12 + 1;
            goto L3
        L9:
            if (this.f2697y == null) goto L67;
            if (this.f2698z == false) goto L13;
        L23:
            int r14 = this.f2676d.length;
            this.H = new p[r14];
            int r15 = r14 - 1;
            int r16 = 0;
        L24:
            boolean r17 = true;
            if (r16 >= r14) goto L32;
            p<?>[] r18 = this.H;
            Type r19 = this.f2677e[r16];
            Annotation[] r20 = this.f2676d[r16];
            if (r16 == r15) goto L30;
            r17 = false;
        L30:
            r18[r16] = i(r16, r19, r20, r17);
            r16 = r16 + 1;
            goto L24
        L32:
            if (this.C == null) goto L34;
        L38:
            boolean r21 = this.A;
            if (r21 == false) goto L41;
        L51:
            if (r21 == false) goto L58;
            if (this.f2688p == true) goto L58;
            throw c0.o(this.f2674b, "Form-encoded method must contain at least one @Field.", new Object[0]);
        L58:
            if (this.B == false) goto L65;
            if (this.f2689q == true) goto L65;
            throw c0.o(this.f2674b, "Multipart method must contain at least one @Part.", new Object[0]);
        L65:
            return new s(this);
        L41:
            if (this.B == true) goto L51;
            if (this.f2698z == true) goto L51;
            if (this.f2685m == true) goto L51;
            if (this.f2690r == false) goto L51;
            throw c0.o(this.f2674b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L34:
            if (this.f2695w == true) goto L38;
            throw c0.o(this.f2674b, "Missing either @%s URL or @Url parameter.", new Object[]{this.f2697y});
        L13:
            if (this.f2685m == true) goto L23;
            if (this.B == true) goto L22;
            if (this.A == false) goto L23;
            throw c0.o(this.f2674b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L22:
            throw c0.o(this.f2674b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L67:
            throw c0.o(this.f2674b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    s(a r10) {
        this.f2647b = r10.f2673a.d();
        this.f2648c = r10.f2673a.i();
        this.f2649d = r10.f2673a.h();
        this.f2660o = r10.f2673a.r();
        this.f2661p = r10.I;
        this.f2662q = r10.f2697y;
        this.f2663r = r10.C;
        this.f2664s = r10.f2698z;
        this.f2665t = r10.A;
        this.f2666u = r10.B;
        this.f2667v = r10.H;
        this.f2668w = r10.D;
        this.f2669x = r10.E;
        this.f2650e = r10.f2679g;
        this.f2651f = r10.f2687o;
        this.f2652g = r10.f2680h;
        this.f2653h = r10.f2681i;
        this.f2654i = r10.f2682j;
        this.f2655j = r10.f2683k;
        this.f2656k = r10.f2684l;
        this.f2657l = r10.f2686n;
        this.f2658m = r10.f2674b;
        this.f2659n = r10.f2673a.b();
        this.f2646a = r10.f2672J;
        this.f2670y = r10.f2678f;
        this.f2671z = r10.K;
    }

    static s b(t r10, Method r11, RetrofitMetrics r12) {
        return new a(r10, r11, r12).c();
    }

    public RetrofitMetrics a() {
        return this.f2670y;
    }

    public void c(RetrofitMetrics r10) {
        this.f2670y = r10;
    }

    n4.c d(k r22, Object... r23) {
        r r15 = new r(this.f2662q, this.f2660o, this.f2663r, this.f2668w, this.f2669x, this.f2650e, this.f2651f, this.f2653h, this.f2654i, this.f2655j, this.f2656k, this.f2657l, this.f2664s, this.f2665t, this.f2666u, this.f2652g, this.f2671z);
        p<?>[] r10 = this.f2667v;
        int r11 = 0;
        if (r23 == null) goto L5;
        int r12 = r23.length;
    L7:
        if (r12 != r10.length) goto L17;
        if (this.f2646a == false) goto L11;
        r12 = r12 - 1;
    L11:
        ArrayList r13 = new ArrayList(r12);
    L12:
        if (r11 >= r12) goto L14;
        r13.add(r23[r11]);
        r10[r11].a(r15, r23[r11]);
        r11 = r11 + 1;
        goto L12
    L14:
        r15.i(n.class, new n(this.f2658m, r13));
        return r15.j(r22);
    L17:
        throw new IllegalArgumentException("Argument count (" + r12 + ") doesn't match expected count (" + r10.length + ")");
    L5:
        r12 = 0;
        goto L7
    }

    T e(r4.e r10) {
        return this.f2661p.convert(r10);
    }
}
