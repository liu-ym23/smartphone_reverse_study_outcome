package ai;

import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
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
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {
    public String A;
    public w0[] B;
    public i C;
    public e D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Annotation[] f242c;
    public final Annotation[][] d;
    public final Type[] e;
    public int f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Type f246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f247l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f248m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f249n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f250o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f251p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f252q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f253r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f254t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f255u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f256v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f257w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList f258x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f259y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinkedHashSet f260z;

    public k0(h0 r5, Method r10) {
        this.f = 1;
        this.g = "";
        this.f243h = false;
        this.f244i = false;
        this.f245j = 3;
        this.f240a = r5;
        this.f241b = r10;
        this.f242c = r10.getAnnotations();
        this.e = r10.getGenericParameterTypes();
        this.d = r10.getParameterAnnotations();
    }

    public static okhttp3.c0 c(String r5, String r10) {
        return okhttp3.z.h(new String[]{"Content-Disposition", j0.k("form-data; name=\"", r5, "\""), "Content-Transfer-Encoding", r10});
    }

    public static w0 j(Type r5, String r10, String r11) {
        Class r12 = w0.g(r5);
        if (TextUtils.isEmpty(r10) == false) goto L23;
        boolean r13 = Iterable.class.isAssignableFrom(r12);
        t r14 = t.e;
        if (r13 == false) goto L14;
        if ((r5 instanceof ParameterizedType) == true) goto L10;
        return null;
    L10:
        if (okhttp3.j0.class.isAssignableFrom(w0.g(w0.f(0, (ParameterizedType) r5))) == true) goto L12;
    L41:
        return null;
    L12:
        return new q(r14, 0);
    L14:
        if (r12.isArray() == false) goto L20;
        if (okhttp3.j0.class.isAssignableFrom(r12.getComponentType()) == false) goto L41;
        return new q(r14, 1);
    L20:
        if (okhttp3.j0.class.isAssignableFrom(r12) == false) goto L41;
        return r14;
    L23:
        if (Iterable.class.isAssignableFrom(r12) == false) goto L32;
        if ((r5 instanceof ParameterizedType) == true) goto L28;
        return null;
    L28:
        if (okhttp3.q0.class.isAssignableFrom(w0.g(w0.f(0, (ParameterizedType) r5))) == false) goto L41;
        return new q(new u(c(r10, r11), 0), 0);
    L32:
        if (r12.isArray() == false) goto L38;
        if (okhttp3.q0.class.isAssignableFrom(l0.a(r12.getComponentType())) == false) goto L41;
        return new q(new u(c(r10, r11), 0), 1);
    L38:
        if (okhttp3.q0.class.isAssignableFrom(r12) == false) goto L41;
        return new u(c(r10, r11), 0);
    }

    public final l0 a() {
        h0 r5 = this.f240a;
        Method r10 = this.f241b;
        Type r11 = r10.getGenericReturnType();
        if (w0.i(r11) == true) goto L205;
        if (r11 == Void.TYPE) goto L203;
        e r12 = r5.a(r11, r10.getAnnotations());     // Catch: RuntimeException -> L199
        this.D = r12;
        Type r13 = r12.responseType();
        this.f246k = r13;
        if (r13 == bi.e.class) goto L198;
        this.C = r5.d(this.f246k, r10.getAnnotations());
        Annotation[] r14 = this.f242c;
        int r15 = r14.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L132;
        Annotation r17 = r14[r16];
        Annotation[] r18 = r14;
        if ((r17 instanceof ci.c) == false) goto L18;
        int r19 = r15;
        h("DELETE", ((ci.c) r17).value(), false);
    L17:
        int r110 = r16;
    L77:
        if (b0.f181b == false) goto L130;
        if ((r17 instanceof DELETE) == false) goto L82;
        h("DELETE", ((DELETE) r17).value(), false);
        goto L130
    L82:
        if ((r17 instanceof GET) == false) goto L85;
        h("GET", ((GET) r17).value(), false);
        goto L130
    L85:
        if ((r17 instanceof HEAD) == false) goto L92;
        h("HEAD", ((HEAD) r17).value(), false);
        if (Void.class.equals(this.f246k) == true) goto L130;
        throw d(null, "HEAD method must use Void as response type.", new Object[0]);
    L92:
        if ((r17 instanceof PATCH) == false) goto L95;
        h("PATCH", ((PATCH) r17).value(), true);
        goto L130
    L95:
        if ((r17 instanceof POST) == false) goto L98;
        h("POST", ((POST) r17).value(), true);
        goto L130
    L98:
        if ((r17 instanceof PUT) == false) goto L101;
        h("PUT", ((PUT) r17).value(), true);
        goto L130
    L101:
        if ((r17 instanceof OPTIONS) == false) goto L104;
        h("OPTIONS", ((OPTIONS) r17).value(), false);
        goto L130
    L104:
        if ((r17 instanceof HTTP) == false) goto L107;
        HTTP r20 = (HTTP) r17;
        h(r20.method(), r20.path(), r20.hasBody());
        goto L130
    L107:
        if ((r17 instanceof Headers) == false) goto L114;
        String[] r21 = ((Headers) r17).value();
        if (r21.length == 0) goto L112;
        this.f258x = g(r21);
        goto L130
    L112:
        throw d(null, "@Headers annotation is empty.", new Object[0]);
    L114:
        if ((r17 instanceof Multipart) == false) goto L121;
        if (this.f255u == true) goto L119;
        this.f256v = true;
        goto L130
    L119:
        throw d(null, "Only one encoding annotation is allowed.", new Object[0]);
    L121:
        if ((r17 instanceof FormUrlEncoded) == false) goto L128;
        if (this.f256v == true) goto L126;
        this.f255u = true;
        goto L130
    L126:
        throw d(null, "Only one encoding annotation is allowed.", new Object[0]);
    L128:
        if ((r17 instanceof Streaming) == false) goto L130;
        this.f243h = true;
    L130:
        r16 = r110 + 1;
        r14 = r18;
        r15 = r19;
        goto L13
    L18:
        r19 = r15;
        if ((r17 instanceof ci.h) == false) goto L22;
        h("GET", ((ci.h) r17).value(), false);
        goto L17
    L22:
        if ((r17 instanceof ci.i) == false) goto L29;
        h("HEAD", ((ci.i) r17).value(), false);
        if (Void.class.equals(this.f246k) == true) goto L17;
        throw d(null, "HEAD method must use Void as response type.", new Object[0]);
    L29:
        if ((r17 instanceof ci.s) == false) goto L32;
        h("PATCH", ((ci.s) r17).value(), true);
        goto L17
    L32:
        if ((r17 instanceof ci.t) == false) goto L35;
        h("POST", ((ci.t) r17).value(), true);
        goto L17
    L35:
        if ((r17 instanceof ci.u) == false) goto L38;
        h("PUT", ((ci.u) r17).value(), true);
        goto L17
    L38:
        if ((r17 instanceof ci.r) == false) goto L41;
        h("OPTIONS", ((ci.r) r17).value(), false);
        goto L17
    L41:
        if ((r17 instanceof ci.j) == false) goto L43;
        ci.j r22 = (ci.j) r17;
        r110 = r16;
        h(r22.method(), r22.path(), r22.hasBody());
        goto L77
    L43:
        r110 = r16;
        if ((r17 instanceof ci.n) == false) goto L51;
        String[] r23 = ((ci.n) r17).value();
        if (r23.length == 0) goto L49;
        this.f258x = g(r23);
        goto L77
    L49:
        throw d(null, "@Headers annotation is empty.", new Object[0]);
    L51:
        if ((r17 instanceof ci.q) == false) goto L58;
        if (this.f255u == true) goto L56;
        this.f256v = true;
        goto L77
    L56:
        throw d(null, "Only one encoding annotation is allowed.", new Object[0]);
    L58:
        if ((r17 instanceof ci.g) == false) goto L65;
        if (this.f256v == true) goto L63;
        this.f255u = true;
        goto L77
    L63:
        throw d(null, "Only one encoding annotation is allowed.", new Object[0]);
    L65:
        if ((r17 instanceof ci.e0) == false) goto L68;
        this.f243h = true;
        goto L77
    L68:
        if ((r17 instanceof ci.y) == false) goto L71;
        this.f = ((ci.y) r17).value();
        goto L77
    L71:
        if ((r17 instanceof ci.d0) == false) goto L74;
        this.g = ((ci.d0) r17).value();
        goto L77
    L74:
        if ((r17 instanceof ci.c0) == false) goto L77;
        this.f245j = ((ci.c0) r17).value();
        goto L77
    L132:
        if (this.s == null) goto L193;
        if (this.f254t == false) goto L136;
    L146:
        Annotation[][] r24 = this.d;
        int r25 = r24.length;
        this.B = new w0[r25];
        int r26 = 0;
    L147:
        if (r26 >= r25) goto L158;
        Type r27 = this.e[r26];
        if (w0.i(r27) == true) goto L156;
        Annotation[] r28 = r24[r26];
        if (r28 == null) goto L154;
        this.B[r26] = i(r26, r27, r28);
        r26 = r26 + 1;
        goto L147
    L154:
        throw e(r26, "No Retrofit annotation found.", new Object[0]);
    L156:
        throw e(r26, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r27});
    L158:
        if (this.f257w == null) goto L160;
    L164:
        boolean r29 = this.f255u;
        if (r29 == false) goto L167;
    L177:
        if (r29 == false) goto L184;
        if (this.f247l == true) goto L184;
        throw d(null, "Form-encode method must contain at least one @Field.", new Object[0]);
    L184:
        if (this.f256v == false) goto L191;
        if (this.f248m == true) goto L191;
        throw d(null, "Multipart method must contain at least one @Part.", new Object[0]);
    L191:
        return new l0(this);
    L167:
        if (this.f256v == true) goto L177;
        if (this.f254t == true) goto L177;
        if (this.f244i == true) goto L177;
        if (this.f249n == false) goto L177;
        throw d(null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
    L160:
        if (this.f252q == true) goto L164;
        throw d(null, "Missing either @%s URL or @Url parameter.", new Object[]{this.s});
    L136:
        if (this.f244i == true) goto L146;
        if (this.f256v == true) goto L145;
        if (this.f255u == false) goto L146;
        throw d(null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
    L145:
        throw d(null, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
    L193:
        throw d(null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
    L194:
        e = move-exception;
        throw d(e, "Unable to create converter for %s", new Object[]{this.f246k});
    L198:
        throw d(null, "'" + w0.g(this.f246k).getName() + "' is not a valid response body type.", new Object[0]);
    L199:
        e = move-exception;
        throw d(e, "Unable to create call adapter for %s", new Object[]{r11});
    L203:
        throw d(null, "Service methods cannot return void.", new Object[0]);
    L205:
        throw d(null, "Method return type must not include a type variable or wildcard: %s", new Object[]{r11});
    }

    public final w0 b(int r5, Type r10, Annotation[] r11, boolean r12, String r13, boolean r14) {
        Class r15 = w0.g(r10);
        this.f251p = true;
        boolean r16 = Iterable.class.isAssignableFrom(r15);
        h0 r17 = this.f240a;
        if (r16 == false) goto L15;
        if ((r10 instanceof ParameterizedType) == false) goto L13;
        i r18 = r17.e(w0.f(0, (ParameterizedType) r10), r11);
        if (r12 == false) goto L11;
        return new q(new s(r18, r14, 3), 0);
    L11:
        return new q(new v(r13, r18, r14, 2), 0);
    L13:
        throw e(r5, r15.getSimpleName() + " must include generic type (e.g., " + r15.getSimpleName() + "<String>)", new Object[0]);
    L15:
        if (r15.isArray() == false) goto L22;
        i r19 = r17.e(l0.a(r15.getComponentType()), r11);
        if (r12 == false) goto L21;
        return new q(new s(r19, r14, 3), 1);
    L21:
        return new q(new v(r13, r19, r14, 2), 1);
    L22:
        i r20 = r17.e(r10, r11);
        if (r12 == false) goto L27;
        return new s(r20, r14, 3);
    L27:
        return new v(r13, r20, r14, 2);
    }

    public final IllegalArgumentException d(RuntimeException r5, String r10, Object... r11) {
        StringBuilder r12 = j0.w(String.format(r10, r11), "\n    for method ");
        Method r13 = this.f241b;
        r12.append(r13.getDeclaringClass().getSimpleName());
        r12.append(".");
        r12.append(r13.getName());
        return new IllegalArgumentException(r12.toString(), r5);
    }

    public final IllegalArgumentException e(int r5, String r10, Object... r11) {
        StringBuilder r12 = j0.w(r10, " (parameter #");
        r12.append(r5 + 1);
        r12.append(")");
        return d(null, r12.toString(), r11);
    }

    public final IllegalArgumentException f(RuntimeException r5, int r10, String r11, Object... r12) {
        StringBuilder r13 = j0.w(r11, " (parameter #");
        r13.append(r10 + 1);
        r13.append(")");
        return d(r5, r13.toString(), r12);
    }

    public final ArrayList g(String[] r10) {
        ArrayList r5 = new ArrayList();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L16;
        String r13 = r10[r12];
        int r14 = r13.indexOf(58);
        if (r14 == (-1)) goto L15;
        if (r14 == 0) goto L15;
        if (r14 == (r13.length() - 1)) goto L15;
        String r15 = r13.substring(0, r14);
        String r16 = r13.substring(r14 + 1).trim();
        if ("Content-Type".equalsIgnoreCase(r15) == false) goto L12;
        this.f259y = r16;
    L13:
        r12 = r12 + 1;
        goto L3
    L12:
        r5.add(new bi.c(r15, r16));
    L15:
        throw d(null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r13});
    L16:
        return r5;
    }

    public final void h(String r5, String r10, boolean r11) {
        String r12 = this.s;
        if (r12 != null) goto L33;
        this.s = r5;
        if (r5 == null) goto L12;
        Matcher r13 = l0.f263u.matcher(r5);
        if (r13.find() == false) goto L9;
        String r14 = r13.group(1);
    L10:
        this.A = r14;
        goto L12
    L9:
        r14 = null;
    L12:
        if (this.A == null) goto L14;
        this.f244i = true;
    L14:
        this.f254t = r11;
        if (r10.isEmpty() == false) goto L17;
        return;
    L17:
        int r15 = r10.indexOf(63);
        if (r15 != (-1)) goto L20;
    L26:
        this.f257w = r10;
        Matcher r16 = l0.f263u.matcher(r10);
        LinkedHashSet r17 = new LinkedHashSet();
    L28:
        if (r16.find() == false) goto L30;
        r17.add(r16.group(1));
        goto L28
    L30:
        this.f260z = r17;
        return;
    L20:
        if (r15 >= (r10.length() - 1)) goto L26;
        String r18 = r10.substring(r15 + 1);
        if (l0.f263u.matcher(r18).find() == false) goto L26;
        throw d(null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r18});
    L33:
        throw d(null, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r12, r5});
    }

    public final w0 i(int r60, Type r61, Annotation[] r62) {
        int r14 = r62.length;
        int r10 = 0;
        w0 r16 = null;
    L3:
        if (r10 >= r14) goto L519;
        Annotation r5 = r62[r10];
        boolean r11 = r5 instanceof ci.g0;
        t r17 = t.d;
        int r20 = r14;
        String r22 = "@PartMap parameter type must be Map.";
        String r23 = "@PartMap keys must be of type String: ";
        Annotation[] r24 = this.f242c;
        Class r26 = okhttp3.q0.class;
        String r27 = "@FieldMap parameter type must be Map.";
        String r28 = "@FieldMap keys must be of type String: ";
        String r29 = "@Field parameters can only be used with form encoding.";
        String r30 = "@HeaderMap parameter type must be Map.";
        String r31 = "@HeaderMap keys must be of type String: ";
        String r33 = " must include generic type (e.g., ";
        Class r34 = Iterable.class;
        String r35 = "@QueryMap parameter type must be Map.";
        String r13 = "@Path can only be used with relative url on @%s";
        String r36 = "Map must include generic types (e.g., Map<String, String>)";
        h0 r12 = this.f240a;
        String r37 = "@QueryMap keys must be of type String: ";
        String r15 = "Multiple @Url method annotations found.";
        Class r38 = Map.class;
        String r18 = "A @Url parameter must not come after a @Query";
        String r39 = "@Part parameters can only be used with multipart encoding.";
        String r19 = "@Url cannot be used with @%s URL";
        int r40 = r10;
        String r41 = "@Body parameters cannot be used with form or multi-part encoding.";
        String r21 = "android.net.Uri";
        String r42 = "Multiple @Body method annotations found.";
        String r43 = "Unable to create @Body converter for %s";
        String r44 = "A @Path parameter must not come after a @Query.";
        String r110 = "@Path parameters may not be used with @Url.";
        if (r11 == false) goto L35;
        if (this.f252q == true) goto L33;
        if (this.f250o == true) goto L31;
        if (this.f251p == true) goto L29;
        if (this.f257w != null) goto L27;
        this.f252q = true;
        if (r61 == String.class) goto L24;
        if (r61 == URI.class) goto L24;
        if ((r61 instanceof Class) == false) goto L23;
        if ("android.net.Uri".equals(((Class) r61).getName()) == true) goto L24;
    L23:
        throw e(r60, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
    L24:
        Type r53 = URI.class;
        String r55 = "@Url must be String, java.net.URI, or android.net.Uri type.";
        Type r25 = String.class;
        w0 r32 = new t(3);
    L25:
        int r45 = r40;
        Annotation r111 = r5;
        String r46 = "<String>)";
    L290:
        if (r32 != null) goto L511;
        if (b0.f181b == false) goto L511;
        if ((r111 instanceof Url) == true) goto L296;
        String r47 = r110;
        if ((r111 instanceof Path) == false) goto L342;
        if (this.f251p == true) goto L340;
        if (this.f252q == true) goto L338;
        if (this.f257w == null) goto L336;
        this.f250o = true;
        Path r48 = (Path) r111;
        String r49 = r48.value();
        k(r60, r49);
        r32 = new v(r49, r12.e(r61, r62), !r48.encoded(), 1);
        goto L511
    L336:
        throw e(r60, r13, new Object[]{this.s});
    L338:
        throw e(r60, r47, new Object[0]);
    L340:
        throw e(r60, r44, new Object[0]);
    L342:
        if ((r111 instanceof Query) == false) goto L354;
        Query r50 = (Query) r111;
        String r51 = r50.value();
        boolean r52 = r50.encoded();
        Class<?> r54 = w0.g(r61);
        this.f251p = true;
        if (r34.isAssignableFrom(r54) == false) goto L351;
        if ((r61 instanceof ParameterizedType) == false) goto L349;
        w0 r56 = new q(new v(r51, r12.e(w0.f(0, (ParameterizedType) r61), r62), !r52, 2), 0);
    L315:
        r32 = r56;
        goto L511
    L349:
        throw e(r60, r54.getSimpleName() + r33 + r54.getSimpleName() + r46, new Object[0]);
    L351:
        if (r54.isArray() == false) goto L353;
        r32 = new q(new v(r51, r12.e(l0.a(r54.getComponentType()), r62), !r52, 2), 1);
        goto L511
    L353:
        r32 = new v(r51, r12.e(r61, r62), !r52, 2);
        goto L511
    L354:
        Class r57 = r34;
        if ((r111 instanceof QueryName) == false) goto L370;
        boolean r58 = ((QueryName) r111).encoded();
        Class<?> r59 = w0.g(r61);
        this.f251p = true;
        if (r57.isAssignableFrom(r59) == false) goto L364;
        if ((r61 instanceof ParameterizedType) == false) goto L362;
        r56 = new q(new s(r12.e(w0.f(0, (ParameterizedType) r61), r62), r58, 3), 0);
        goto L315
    L362:
        throw e(r60, r59.getSimpleName() + r33 + r59.getSimpleName() + r46, new Object[0]);
    L364:
        if (r59.isArray() == false) goto L368;
        char r63 = 3;
        r32 = new q(new s(r12.e(l0.a(r59.getComponentType()), r62), r58, 3), 1);
        goto L511
    L368:
        r63 = 3;
        r32 = new s(r12.e(r61, r62), r58, 3);
        goto L511
    L370:
        if ((r111 instanceof QueryMap) == false) goto L384;
        Class<?> r64 = w0.g(r61);
        Class r65 = r38;
        if (r65.isAssignableFrom(r64) == false) goto L383;
        Type r66 = w0.h(r61, r64, r65);
        if ((r66 instanceof ParameterizedType) == false) goto L381;
        ParameterizedType r67 = (ParameterizedType) r66;
        Type r68 = w0.f(0, r67);
        if (r25 != r68) goto L379;
        r32 = new s(r12.e(w0.f(1, r67), r62), !((QueryMap) r111).encoded(), 2);
        goto L511
    L379:
        throw e(r60, j0.m(r37, r68), new Object[0]);
    L381:
        throw e(r60, r36, new Object[0]);
    L383:
        throw e(r60, r35, new Object[0]);
    L384:
        Class r69 = r38;
        if ((r111 instanceof Header) == false) goto L398;
        String r70 = ((Header) r111).value();
        Class<?> r71 = w0.g(r61);
        if (r57.isAssignableFrom(r71) == false) goto L394;
        if ((r61 instanceof ParameterizedType) == false) goto L392;
        r56 = new q(new w(r70, r12.e(w0.f(0, (ParameterizedType) r61), r62), 0), 0);
        goto L315
    L392:
        throw e(r60, r71.getSimpleName() + r33 + r71.getSimpleName() + r46, new Object[0]);
    L394:
        if (r71.isArray() == false) goto L396;
        r56 = new q(new w(r70, r12.e(l0.a(r71.getComponentType()), r62), 0), 1);
        goto L315
    L396:
        r32 = new w(r70, r12.e(r61, r62), 0);
        goto L511
    L398:
        if ((r111 instanceof HeaderMap) == false) goto L414;
        Class<?> r72 = w0.g(r61);
        if (r69.isAssignableFrom(r72) == false) goto L412;
        Type r73 = w0.h(r61, r72, r69);
        if ((r73 instanceof ParameterizedType) == false) goto L410;
        ParameterizedType r74 = (ParameterizedType) r73;
        Type r75 = w0.f(0, r74);
        if (r25 != r75) goto L408;
        w0 r76 = new r(r12.e(w0.f(1, r74), r62), 3);
    L406:
        r32 = r76;
        goto L511
    L408:
        throw e(r60, j0.m(r31, r75), new Object[0]);
    L410:
        throw e(r60, r36, new Object[0]);
    L412:
        throw e(r60, r30, new Object[0]);
    L414:
        if ((r111 instanceof Field) == false) goto L432;
        if (this.f255u == false) goto L430;
        Field r77 = (Field) r111;
        String r78 = r77.value();
        boolean r79 = r77.encoded();
        this.f247l = true;
        Class<?> r80 = w0.g(r61);
        if (r57.isAssignableFrom(r80) == false) goto L426;
        if ((r61 instanceof ParameterizedType) == false) goto L424;
        w0 r81 = new q(new v(r78, r12.e(w0.f(0, (ParameterizedType) r61), r62), !r79, 0), 0);
    L422:
        r32 = r81;
        goto L511
    L424:
        throw e(r60, r80.getSimpleName() + r33 + r80.getSimpleName() + r46, new Object[0]);
    L426:
        if (r80.isArray() == false) goto L428;
        r76 = new q(new v(r78, r12.e(l0.a(r80.getComponentType()), r62), !r79, 0), 1);
        goto L406
    L428:
        r32 = new v(r78, r12.e(r61, r62), !r79, 0);
        goto L511
    L430:
        throw e(r60, r29, new Object[0]);
    L432:
        if ((r111 instanceof FieldMap) == false) goto L451;
        if (this.f255u == false) goto L449;
        Class<?> r82 = w0.g(r61);
        if (r69.isAssignableFrom(r82) == false) goto L447;
        Type r83 = w0.h(r61, r82, r69);
        if ((r83 instanceof ParameterizedType) == false) goto L445;
        ParameterizedType r84 = (ParameterizedType) r83;
        Type r85 = w0.f(0, r84);
        if (r25 != r85) goto L443;
        i r86 = r12.e(w0.f(1, r84), r62);
        this.f247l = true;
        r32 = new s(r86, !((FieldMap) r111).encoded(), 1);
        goto L511
    L443:
        throw e(r60, j0.m(r28, r85), new Object[0]);
    L445:
        throw e(r60, r36, new Object[0]);
    L447:
        throw e(r60, r27, new Object[0]);
    L449:
        throw e(r60, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
    L451:
        if ((r111 instanceof Part) == false) goto L462;
        if (this.f256v == false) goto L460;
        Part r87 = (Part) r111;
        this.f248m = true;
        r81 = j(r61, r87.value(), r87.encoding());
        if (r81 != null) goto L422;
        w r88 = new w(r87.value(), r12.c(r61, r62, r24), 2);
    L458:
        r32 = r88;
        goto L511
    L460:
        throw e(r60, r39, new Object[0]);
    L462:
        if ((r111 instanceof PartMap) == false) goto L487;
        if (this.f256v == false) goto L485;
        int r89 = 1;
        this.f248m = true;
        Class<?> r90 = w0.g(r61);
        if (r69.isAssignableFrom(r90) == false) goto L483;
        Type r91 = w0.h(r61, r90, r69);
        if ((r91 instanceof ParameterizedType) == false) goto L481;
        ParameterizedType r92 = (ParameterizedType) r91;
        Type r93 = w0.f(0, r92);
        if (r25 != r93) goto L479;
        if (r26.isAssignableFrom(w0.g(w0.f(1, r92))) == false) goto L474;
        u r94 = new u(((ci.w) r111).encoding(), r89);
    L475:
        if (r94 == null) goto L477;
        r32 = r94;
        goto L511
    L477:
        r88 = new w(r12.c(w0.f(1, r92), r62, r24), ((PartMap) r111).encoding());
        goto L458
    L474:
        r94 = null;
        goto L475
    L479:
        throw e(r60, j0.m(r23, r93), new Object[0]);
    L481:
        throw e(r60, r36, new Object[0]);
    L483:
        throw e(r60, r22, new Object[0]);
    L485:
        throw e(r60, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
    L487:
        if ((r111 instanceof Body) == true) goto L489;
        r32 = null;
        goto L511
    L489:
        if (this.f255u == true) goto L509;
        if (this.f256v == true) goto L509;
        if (this.f249n == true) goto L507;
        if (r26.isAssignableFrom(w0.g(r61)) == true) goto L498;
        r17 = null;
    L498:
        if (r17 == null) goto L531;
        this.f249n = true;
        r32 = r17;
        goto L511
    L531:
        i r95 = r12.c(r61, r62, r24);     // Catch: RuntimeException -> L503
        this.f249n = true;
        r32 = new s(this.f244i, r95);
    L503:
        e = move-exception;
        throw f(e, r60, r43, new Object[]{r61});
    L507:
        throw e(r60, r42, new Object[0]);
    L509:
        throw e(r60, r41, new Object[0]);
    L296:
        if (this.f252q == true) goto L325;
        if (this.f250o == true) goto L323;
        if (this.f251p == true) goto L321;
        if (this.f257w != null) goto L319;
        this.f252q = true;
        if (r61 != r25) goto L306;
    L314:
        r56 = new t(3);
        goto L315
    L306:
        if (r61 == r53) goto L314;
        if ((r61 instanceof Class) == false) goto L313;
        if (r21.equals(((Class) r61).getName()) == true) goto L314;
    L313:
        throw e(r60, r55, new Object[0]);
    L319:
        throw e(r60, r19, new Object[]{this.s});
    L321:
        throw e(r60, r18, new Object[0]);
    L323:
        throw e(r60, r110, new Object[0]);
    L325:
        throw e(r60, r15, new Object[0]);
    L511:
        if (r32 == null) goto L515;
        if (r16 != null) goto L517;
        r16 = r32;
        goto L515
    L517:
        throw e(r60, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
    L515:
        r10 = r45 + 1;
        r14 = r20;
        goto L3
    L27:
        throw e(r60, "@Url cannot be used with @%s URL", new Object[]{this.s});
    L29:
        throw e(r60, "A @Url parameter must not come after a @Query", new Object[0]);
    L31:
        throw e(r60, "@Path parameters may not be used with @Url.", new Object[0]);
    L33:
        throw e(r60, "Multiple @Url method annotations found.", new Object[0]);
    L35:
        if ((r5 instanceof ci.x) == true) goto L37;
        r21 = "android.net.Uri";
        if ((r5 instanceof ci.z) == false) goto L53;
        ci.z r96 = (ci.z) r5;
        Type r510 = String.class;
        r43 = r43;
        r42 = r42;
        r53 = URI.class;
        r44 = r44;
        r13 = "@Path can only be used with relative url on @%s";
        r15 = "Multiple @Url method annotations found.";
        r110 = "@Path parameters may not be used with @Url.";
        r111 = r5;
        r45 = r40;
        r55 = "@Url must be String, java.net.URI, or android.net.Uri type.";
        r19 = "@Url cannot be used with @%s URL";
        r18 = "A @Url parameter must not come after a @Query";
        r39 = r39;
        r32 = b(r60, r61, r62, false, r96.value(), r96.encode());
        r41 = r41;
    L52:
        r24 = r24;
        r26 = r26;
        r46 = "<String>)";
        r33 = r33;
        r36 = r36;
        r25 = r510;
        goto L290
    L53:
        r44 = r44;
        r19 = "@Url cannot be used with @%s URL";
        r18 = "A @Url parameter must not come after a @Query";
        r39 = r39;
        r42 = r42;
        r43 = r43;
        r510 = String.class;
        r53 = URI.class;
        r55 = "@Url must be String, java.net.URI, or android.net.Uri type.";
        r13 = "@Path can only be used with relative url on @%s";
        r110 = "@Path parameters may not be used with @Url.";
        r45 = r40;
        r111 = r5;
        r15 = "Multiple @Url method annotations found.";
        if ((r111 instanceof ci.b0) == false) goto L57;
        r32 = b(r60, r61, r62, true, null, ((ci.b0) r111).encoded());
        r41 = r41;
        r21 = r21;
        goto L52
    L57:
        if ((r111 instanceof ci.a0) == false) goto L71;
        Class<?> r97 = w0.g(r61);
        if (r38.isAssignableFrom(r97) == false) goto L70;
        Type r98 = w0.h(r61, r97, r38);
        if ((r98 instanceof ParameterizedType) == false) goto L68;
        ParameterizedType r99 = (ParameterizedType) r98;
        Type r100 = w0.f(0, r99);
        r25 = r510;
        if (r25 != r100) goto L66;
        r38 = r38;
        r32 = new s(r12.e(w0.f(1, r99), r62), ((ci.a0) r111).encode(), 2);
        r41 = r41;
        r21 = r21;
        r24 = r24;
        r26 = r26;
        r46 = "<String>)";
        r33 = r33;
        r36 = r36;
        goto L290
    L66:
        throw e(r60, j0.m(r37, r100), new Object[0]);
    L68:
        throw e(r60, r36, new Object[0]);
    L70:
        throw e(r60, r35, new Object[0]);
    L71:
        r36 = r36;
        r38 = r38;
        r25 = r510;
        if ((r111 instanceof ci.k) == false) goto L90;
        String r101 = ((ci.k) r111).value();
        Class<?> r102 = w0.g(r61);
        Class r112 = r34;
        if (r112.isAssignableFrom(r102) == false) goto L80;
        r35 = r35;
        if ((r61 instanceof ParameterizedType) == false) goto L79;
        r37 = r37;
        r38 = r38;
        r32 = new q(new w(r101, r12.e(w0.f(0, (ParameterizedType) r61), r62), 0), 0);
        r34 = r112;
        r41 = r41;
        r21 = r21;
        r24 = r24;
        r26 = r26;
        r46 = "<String>)";
        r33 = r33;
        goto L290
    L79:
        throw e(r60, r102.getSimpleName() + r33 + r102.getSimpleName() + "<String>)", new Object[0]);
    L80:
        r37 = r37;
        r35 = r35;
        r21 = r21;
        r46 = "<String>)";
        r33 = r33;
        if (r102.isArray() == false) goto L87;
        String r310 = r41;
        r32 = new q(new w(r101, r12.e(l0.a(r102.getComponentType()), r62), 0), 1);
    L83:
        r38 = r38;
        r34 = r112;
    L84:
        r24 = r24;
    L85:
        r26 = r26;
    L86:
        r41 = r310;
        goto L290
    L87:
        r310 = r41;
        w0 r113 = new w(r101, r12.e(r61, r62), 0);
    L88:
        r34 = r112;
    L89:
        r32 = r113;
        goto L84
    L90:
        r37 = r37;
        r35 = r35;
        r21 = r21;
        r46 = "<String>)";
        r33 = r33;
        r112 = r34;
        r310 = r41;
        if ((r111 instanceof ci.l) == false) goto L113;
        Class r103 = w0.g(r61);
        if (List.class.isAssignableFrom(r103) == false) goto L111;
        Type r104 = w0.h(r61, r103, List.class);
        if ((r104 instanceof ParameterizedType) == false) goto L109;
        Type r105 = w0.f(0, (ParameterizedType) r104);
        if (bi.c.class != r105) goto L107;
        r12.getClass();
        w0.b(r105, "type == null");
        List r106 = r12.d;
        int r114 = r106.size();
        int r115 = 0;
    L99:
        if (r115 >= r114) goto L105;
        List r311 = r106;
        i r107 = ((h) r106.get(r115)).a(r105);
        if (r107 != null) goto L102;
        r115 = r115 + 1;
        r106 = r311;
        goto L99
    L102:
        r32 = new r(r107, 2);
        goto L83
    L105:
        throw new IllegalArgumentException("Could not locate header converter");
    L107:
        throw e(r60, j0.m("@HeaderList keys must be of type retrofit.client.Header: ", r105), new Object[0]);
    L109:
        throw e(r60, "List must include generic types (e.g., List<Header>)", new Object[0]);
    L111:
        throw e(r60, "@HeaderList parameter type must be List.", new Object[0]);
    L113:
        if ((r111 instanceof ci.m) == false) goto L128;
        Class<?> r108 = w0.g(r61);
        if (r38.isAssignableFrom(r108) == false) goto L126;
        Type r109 = w0.h(r61, r108, r38);
        if ((r109 instanceof ParameterizedType) == false) goto L124;
        ParameterizedType r116 = (ParameterizedType) r109;
        Type r117 = w0.f(0, r116);
        if (r25 != r117) goto L122;
        r113 = new r(r12.e(w0.f(1, r116), r62), 3);
        goto L88
    L122:
        throw e(r60, j0.m(r31, r117), new Object[0]);
    L124:
        throw e(r60, r36, new Object[0]);
    L126:
        throw e(r60, r30, new Object[0]);
    L128:
        if ((r111 instanceof ci.e) == true) goto L130;
        r31 = r31;
        r34 = r112;
        r30 = r30;
        if ((r111 instanceof ci.f) == false) goto L164;
        if (this.f255u == false) goto L162;
        Class<?> r118 = w0.g(r61);
        if (r38.isAssignableFrom(r118) == false) goto L160;
        Type r119 = w0.h(r61, r118, r38);
        if ((r119 instanceof ParameterizedType) == false) goto L158;
        ParameterizedType r120 = (ParameterizedType) r119;
        Type r121 = w0.f(0, r120);
        if (r25 != r121) goto L156;
        i r122 = r12.e(w0.f(1, r120), r62);
        this.f247l = true;
        r113 = new s(r122, ((ci.f) r111).encode(), 1);
        r29 = r29;
        goto L89
    L156:
        throw e(r60, j0.m(r28, r121), new Object[0]);
    L158:
        throw e(r60, r36, new Object[0]);
    L160:
        throw e(r60, r27, new Object[0]);
    L162:
        throw e(r60, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
    L164:
        if ((r111 instanceof ci.v) == true) goto L166;
        r29 = r29;
        r28 = r28;
        r27 = r27;
        r24 = r24;
        if ((r111 instanceof ci.w) == true) goto L176;
        r38 = r38;
        r39 = r39;
        r26 = r26;
        if ((r111 instanceof ci.b) == true) goto L202;
        r22 = r22;
        r41 = r310;
        if ((r111 instanceof ci.p) == true) goto L226;
        r23 = r23;
        r43 = r43;
        if ((r111 instanceof ci.o) == false) goto L249;
        r32 = new r(r12.e(r61, r62), 4);
    L245:
        e = move-exception;
        throw f(e, r60, "Unable to create @MaxLength converter for %s", new Object[]{r61});
    L249:
        if ((r111 instanceof ci.a) == false) goto L256;
        r32 = new r(r12.e(r61, r62), 0);
    L252:
        e = move-exception;
        throw f(e, r60, "Unable to create @AddCommonParam converter for %s", new Object[]{r61});
    L256:
        if ((r111 instanceof ci.d) == false) goto L270;
        r12.getClass();     // Catch: RuntimeException -> L266
        w0.b(r61, "type == null");     // Catch: RuntimeException -> L266
        List r123 = r12.d;     // Catch: RuntimeException -> L266
        int r124 = r123.size();     // Catch: RuntimeException -> L266
        int r125 = 0;
    L258:
        if (r125 >= r124) goto L265;
        i r126 = ((h) r123.get(r125)).b(r61);     // Catch: RuntimeException -> L266
        if (r126 != null) goto L261;
        r125 = r125 + 1;
        goto L258
    L261:
        w0 r127 = new r(r126, 1);
    L262:
        r32 = r127;
        goto L290
    L265:
        throw new IllegalArgumentException("Could not locate object converter");     // Catch: RuntimeException -> L266
    L266:
        e = move-exception;
        throw f(e, r60, "Unable to create @ExtraInfo converter for %s", new Object[]{r61});
    L270:
        if ((r111 instanceof di.a) == false) goto L277;
        if (di.b.class.isAssignableFrom(w0.g(r61)) == false) goto L275;
        r127 = new t(2);
        goto L262
    L275:
        throw e(r60, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r61});
    L277:
        if ((r111 instanceof ci.f0) == false) goto L289;
        Class r128 = w0.g(r61);
        int r129 = r60 - 1;
    L279:
        if (r129 < 0) goto L288;
        w0 r130 = this.B[r129];
        if ((r130 instanceof x) == false) goto L287;
        if (((x) r130).f307c.equals(r128) == false) goto L287;
        throw e(r60, "@Tag type " + r128.getName() + " is duplicate of parameter #" + (r129 + 1) + " and would always overwrite its value.", new Object[0]);
    L287:
        r129 = r129 - 1;
        goto L279
    L288:
        r32 = new x(r128);
        goto L290
    L289:
        r32 = null;
        goto L290
    L226:
        if (this.f253r == true) goto L240;
        this.f253r = true;
        String r131 = ((ci.p) r111).value();
        if (l0.f264v.matcher(r131).matches() == false) goto L238;
        String r132 = this.A;
        if (r132 != null) goto L232;
    L236:
        r43 = r43;
        r23 = r23;
        r32 = new w(r131, r12.e(r61, r62), 1);
        goto L290
    L232:
        if (r132.equals(r131) == true) goto L236;
        throw e(r60, "Method \"%s\" does not contain \"{%s}\".", new Object[]{this.s, r131});
    L238:
        throw e(r60, "@Method parameter name must match %s. Found: %s", new Object[]{l0.f263u.pattern(), r131});
    L240:
        throw e(r60, "Multiple @Method method annotations found.", new Object[0]);
    L202:
        if (this.f255u == true) goto L222;
        if (this.f256v == true) goto L222;
        if (this.f249n == true) goto L220;
        if (r26.isAssignableFrom(w0.g(r61)) == false) goto L210;
        w0 r133 = r17;
    L211:
        if (r133 == null) goto L523;
        this.f249n = true;
        r23 = r23;
        r22 = r22;
    L190:
        r32 = r133;
        goto L86
    L523:
        i r134 = r12.c(r61, r62, r24);     // Catch: RuntimeException -> L216
        this.f249n = true;
        r22 = r22;
        r23 = r23;
        r32 = new s(this.f244i, r134);
    L216:
        e = move-exception;
        throw f(e, r60, r43, new Object[]{r61});
    L210:
        r133 = null;
        goto L211
    L220:
        throw e(r60, r42, new Object[0]);
    L222:
        throw e(r60, r310, new Object[0]);
    L176:
        if (this.f256v == false) goto L198;
        int r135 = 1;
        this.f248m = true;
        Class<?> r136 = w0.g(r61);
        if (r38.isAssignableFrom(r136) == false) goto L196;
        Type r137 = w0.h(r61, r136, r38);
        if ((r137 instanceof ParameterizedType) == false) goto L194;
        ParameterizedType r138 = (ParameterizedType) r137;
        r39 = r39;
        Type r139 = w0.f(0, r138);
        if (r25 != r139) goto L192;
        r26 = r26;
        if (r26.isAssignableFrom(w0.g(w0.f(1, r138))) == false) goto L186;
        u r140 = new u(((ci.w) r111).encoding(), r135);
    L187:
        if (r140 == null) goto L189;
        r32 = r140;
        goto L86
    L189:
        r133 = new w(r12.c(w0.f(1, r138), r62, r24), ((ci.w) r111).encoding());
        goto L190
    L186:
        r140 = null;
        goto L187
    L192:
        throw e(r60, j0.m(r23, r139), new Object[0]);
    L194:
        throw e(r60, r36, new Object[0]);
    L196:
        throw e(r60, r22, new Object[0]);
    L198:
        throw e(r60, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
    L166:
        if (this.f256v == false) goto L172;
        ci.v r141 = (ci.v) r111;
        this.f248m = true;
        r27 = r27;
        r113 = j(r61, r141.value(), r141.encoding());
        if (r113 == null) goto L170;
        r29 = r29;
        r28 = r28;
        goto L89
    L170:
        r24 = r24;
        r28 = r28;
        r29 = r29;
        r38 = r38;
        r32 = new w(r141.value(), r12.c(r61, r62, r24), 2);
        goto L85
    L172:
        throw e(r60, r39, new Object[0]);
    L130:
        if (this.f255u == false) goto L143;
        ci.e r142 = (ci.e) r111;
        String r143 = r142.value();
        boolean r144 = r142.encode();
        r30 = r30;
        this.f247l = true;
        Class<?> r145 = w0.g(r61);
        if (r112.isAssignableFrom(r145) == false) goto L138;
        r31 = r31;
        if ((r61 instanceof ParameterizedType) == false) goto L137;
        r34 = r112;
        r32 = new q(new v(r143, r12.e(w0.f(0, (ParameterizedType) r61), r62), r144, 0), 0);
        r38 = r38;
        goto L84
    L137:
        throw e(r60, r145.getSimpleName() + r33 + r145.getSimpleName() + r46, new Object[0]);
    L138:
        r31 = r31;
        r34 = r112;
        if (r145.isArray() == false) goto L141;
        r38 = r38;
        r32 = new q(new v(r143, r12.e(l0.a(r145.getComponentType()), r62), r144, 0), 1);
        goto L84
    L141:
        r113 = new v(r143, r12.e(r61, r62), r144, 0);
        goto L89
    L143:
        throw e(r60, r29, new Object[0]);
    L37:
        if (this.f251p == true) goto L48;
        if (this.f252q == true) goto L46;
        if (this.f257w == null) goto L44;
        this.f250o = true;
        ci.x r146 = (ci.x) r5;
        String r147 = r146.value();
        k(r60, r147);
        r32 = new v(r147, r12.e(r61, r62), r146.encode(), 1);
        r25 = String.class;
        r53 = URI.class;
        r55 = "@Url must be String, java.net.URI, or android.net.Uri type.";
        goto L25
    L44:
        throw e(r60, "@Path can only be used with relative url on @%s", new Object[]{this.s});
    L46:
        throw e(r60, "@Path parameters may not be used with @Url.", new Object[0]);
    L48:
        throw e(r60, r44, new Object[0]);
    L519:
        if (r16 == null) goto L522;
        return r16;
    L522:
        throw e(r60, "No Retrofit annotation found.", new Object[0]);
    }

    public final void k(int r5, String r10) {
        if (l0.f264v.matcher(r10).matches() == false) goto L10;
        if (this.f260z.contains(r10) == false) goto L8;
        return;
    L8:
        throw e(r5, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.f257w, r10});
    L10:
        throw e(r5, "@Path parameter name must match %s. Found: %s", new Object[]{l0.f263u.pattern(), r10});
    }
}
