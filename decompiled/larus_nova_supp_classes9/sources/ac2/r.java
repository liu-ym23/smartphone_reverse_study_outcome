package ac2;

import android.text.TextUtils;
import com.bytedance.android.live.base.UplinkService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.network.PbRequestCallAdapter;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.config.w81;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Endpoint;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import io.reactivex.Observable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> {
    public static final Pattern o = null;
    public final long a;
    public final String b;
    public final String c;
    public final boolean d;
    public final CallAdapter<?, ?> e;
    public final Type f;
    public final p<?>[] g;
    public final Endpoint h;
    public w81 i;
    public long j;
    public Map<String, String> k;
    public Map<String, String> l;
    public final List<Header> m;
    public final String n;

    public static final class a<T> {
        public final Retrofit a;
        public final Method b;
        public final Annotation[] c;
        public final Annotation[][] d;
        public final Type[] e;
        public CallAdapter<?, ?> f;
        public Type g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public String l;
        public boolean m;
        public boolean n;
        public String o;
        public p<?>[] p;
        public long q;
        public boolean r;
        public List<Header> s;
        public String t;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v55 */
        /* JADX WARN: Type inference failed for: r4v56 */
        public final r a() {
            Type r2 = this.b.getGenericReturnType();
            p<?> r3 = null;
            int r4 = 1;
            int r5 = 0;
            if (y.f(r2) == true) goto L262;
            if (r2 == Void.TYPE) goto L260;
            if (y.e(r2) != Observable.class) goto L258;
            CallAdapter<?, ?> r0 = this.a.callAdapter(r2, this.b.getAnnotations());     // Catch: RuntimeException -> L254
            this.f = r0;
            this.g = r0.responseType();
            GET[] r1 = this.c;
            int r6 = r1.length;
            int r7 = 0;
        L11:
            if (r7 >= r6) goto L49;
            GET r8 = r1[r7];
            if ((r8 instanceof GET) == false) goto L16;
            e("GET", r8.value(), false);
        L43:
            r7 = r7 + 1;
            goto L11
        L16:
            if ((r8 instanceof POST) == false) goto L19;
            e("POST", ((POST) r8).value(), true);
            goto L43
        L19:
            if ((r8 instanceof FormUrlEncoded) == false) goto L22;
            this.n = true;
            goto L43
        L22:
            if ((r8 instanceof UplinkService) == false) goto L25;
            this.q = ((UplinkService) r8).value();
            this.r = true;
            goto L43
        L25:
            if ((r8 instanceof Headers) == false) goto L47;
            String[] r9 = ((Headers) r8).value();
            if (r9.length == 0) goto L45;
            ArrayList r10 = new ArrayList();
            int r11 = r9.length;
            int r13 = 0;
        L29:
            if (r13 >= r11) goto L42;
            String r14 = r9[r13];
            int r15 = r14.indexOf(58);
            if (r15 == (-1)) goto L41;
            if (r15 == 0) goto L41;
            if (r15 == (r14.length() - 1)) goto L41;
            String r16 = r14.substring(0, r15);
            String r17 = r14.substring(r15 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(r16) == false) goto L38;
            this.t = r17;
        L39:
            r13 = r13 + 1;
            goto L29
        L38:
            r10.add(new Header(r16, r17));
        L41:
            throw b(null, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r14});
        L42:
            this.s = r10;
            goto L43
        L45:
            throw b(null, "@Headers annotation is empty.", new Object[0]);
        L47:
            throw c(r8.toString(), new Object[0]);
        L49:
            if (this.r == false) goto L253;
            if (this.l == null) goto L251;
            if (this.m == false) goto L55;
        L59:
            int r18 = this.d.length;
            this.p = new p[r18];
            int r19 = 0;
        L60:
            if (r19 >= r18) goto L224;
            Type r20 = this.e[r19];
            if (y.f(r20) == true) goto L221;
            Query[] r21 = this.d[r19];
            if (r21 == null) goto L220;
            p<?>[] r23 = this.p;
            int r110 = r21.length;
            p<?> r111 = r3;
            int r112 = 0;
            int r24 = r4;
        L66:
            if (r112 >= r110) goto L215;
            Query r113 = r21[r112];
            if ((r113 instanceof Url) == false) goto L94;
            if (this.k == true) goto L92;
            if (this.j == true) goto L90;
            if (this.o != null) goto L87;
            this.k = r24;
            if (r20 != String.class) goto L78;
        L86:
            p<?> r114 = new p.g();
        L195:
            p<?> r25 = r114;
        L199:
            if (r111 != null) goto L202;
            r112 = r112 + 1;
            r111 = r25;
            r24 = 1;
            r5 = 0;
            goto L66
        L202:
            throw d(r19, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L78:
            if (r20 == URI.class) goto L86;
            if ((r20 instanceof Class) == false) goto L85;
            if ("android.net.Uri".equals(((Class) r20).getName()) == true) goto L86;
        L85:
            throw d(r19, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[r5]);
        L87:
            Object[] r26 = new Object[r24];
            r26[r5] = this.l;
            throw d(r19, "@Url cannot be used with @%s URL", r26);
        L90:
            throw d(r19, "A @Url parameter must not come after a @Query", new Object[r5]);
        L92:
            throw d(r19, "Multiple @Url method annotations found.", new Object[r5]);
        L94:
            if ((r113 instanceof Path) == true) goto L213;
            if ((r113 instanceof Query) == false) goto L111;
            Query r115 = r113;
            String r116 = r115.value();
            boolean r117 = r115.encode();
            Class<?> r27 = y.e(r20);
            this.j = r24;
            if (Iterable.class.isAssignableFrom(r27) == false) goto L105;
            if ((r20 instanceof ParameterizedType) == false) goto L103;
            r114 = new m(new p.e(r116, this.a.stringConverter(y.d(0, (ParameterizedType) r20), r21), r117));
            goto L195
        L103:
            throw d(r19, r27.getSimpleName() + " must include generic type (e.g., " + r27.getSimpleName() + "<String>)", new Object[0]);
        L105:
            if (r27.isArray() == false) goto L108;
            r114 = new n(new p.e(r116, this.a.stringConverter(r.a(r27.getComponentType()), r21), r117));
            goto L195
        L108:
            p<?> r28 = new p.e(r116, this.a.stringConverter(r20, r21), r117);
        L109:
            r114 = r28;
            goto L195
        L111:
            if ((r113 instanceof QueryMap) == false) goto L130;
            Class<?> r29 = y.e(r20);
            if (Map.class.isAssignableFrom(r29) == false) goto L128;
            if (Map.class.isAssignableFrom(r29) == false) goto L126;
            Type r30 = y.g(r20, r29, y.c(r20, r29, Map.class));
            if ((r30 instanceof ParameterizedType) == false) goto L124;
            ParameterizedType r31 = (ParameterizedType) r30;
            Type r33 = y.d(0, r31);
            if (String.class != r33) goto L122;
            r28 = new p.f(this.a.stringConverter(y.d(1, r31), r21), ((QueryMap) r113).encode());
            goto L109
        L122:
            throw d(r19, "@QueryMap keys must be of type String: " + r33, new Object[0]);
        L124:
            throw d(r19, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L126:
            throw new IllegalArgumentException();
        L128:
            throw d(r19, "@QueryMap parameter type must be Map.", new Object[0]);
        L130:
            if ((r113 instanceof com.bytedance.retrofit2.http.Header) == false) goto L143;
            String r34 = ((com.bytedance.retrofit2.http.Header) r113).value();
            Class<?> r35 = y.e(r20);
            if (Iterable.class.isAssignableFrom(r35) == false) goto L139;
            if ((r20 instanceof ParameterizedType) == false) goto L137;
            r114 = new m(new p.d(r34, this.a.stringConverter(y.d(0, (ParameterizedType) r20), r21)));
            goto L195
        L137:
            throw d(r19, r35.getSimpleName() + " must include generic type (e.g., " + r35.getSimpleName() + "<String>)", new Object[0]);
        L139:
            if (r35.isArray() == false) goto L141;
            r114 = new n(new p.d(r34, this.a.stringConverter(r.a(r35.getComponentType()), r21)));
            goto L195
        L141:
            r114 = new p.d(r34, this.a.stringConverter(r20, r21));
            goto L195
        L143:
            if ((r113 instanceof Field) == false) goto L161;
            if (this.n == false) goto L159;
            Field r118 = (Field) r113;
            String r36 = r118.value();
            boolean r37 = r118.encode();
            this.h = true;
            Class<?> r119 = y.e(r20);
            if (Iterable.class.isAssignableFrom(r119) == false) goto L154;
            if ((r20 instanceof ParameterizedType) == false) goto L152;
            p<?> r38 = new m(new p.b(r36, this.a.stringConverter(y.d(0, (ParameterizedType) r20), r21), r37));
        L156:
            r114 = r38;
            goto L195
        L152:
            throw d(r19, r119.getSimpleName() + " must include generic type (e.g., " + r119.getSimpleName() + "<String>)", new Object[0]);
        L154:
            if (r119.isArray() == false) goto L157;
            r38 = new n(new p.b(r36, this.a.stringConverter(r.a(r119.getComponentType()), r21), r37));
            goto L156
        L157:
            r114 = new p.b(r36, this.a.stringConverter(r20, r21), r37);
            goto L195
        L159:
            throw d(r19, "@Field parameters can only be used with form encoding.", new Object[0]);
        L161:
            if ((r113 instanceof FieldMap) == false) goto L184;
            if (this.n == false) goto L182;
            Class<?> r39 = y.e(r20);
            if (Map.class.isAssignableFrom(r39) == false) goto L180;
            if (Map.class.isAssignableFrom(r39) == false) goto L178;
            Type r40 = y.g(r20, r39, y.c(r20, r39, Map.class));
            if ((r40 instanceof ParameterizedType) == false) goto L176;
            ParameterizedType r41 = (ParameterizedType) r40;
            Type r43 = y.d(0, r41);
            if (String.class != r43) goto L174;
            Converter r44 = this.a.stringConverter(y.d(1, r41), r21);
            this.h = true;
            r28 = new p.c(r44, ((FieldMap) r113).encode());
            goto L109
        L174:
            throw d(r19, "@FieldMap keys must be of type String: " + r43, new Object[0]);
        L176:
            throw d(r19, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L178:
            throw new IllegalArgumentException();
        L180:
            throw d(r19, "@FieldMap parameter type must be Map.", new Object[0]);
        L182:
            throw d(r19, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L184:
            if ((r113 instanceof Body) == false) goto L211;
            if (this.n == true) goto L209;
            if (this.i == true) goto L207;
            if (RequestBody.class.isAssignableFrom(y.e(r20)) == false) goto L192;
            r114 = new p.h();
        L193:
            if (r114 == null) goto L265;
            this.i = true;
            goto L195
        L265:
            Converter r45 = this.a.requestBodyConverter(r20, r21, this.c);     // Catch: RuntimeException -> L203
            this.i = true;
            r25 = new p.a(r45, r20);
        L203:
            e = move-exception;
            throw b(e, "Unable to create @Body converter for %s (parameter #" + (r19 + 1) + ")", new Object[]{r20});
        L192:
            r114 = null;
            goto L193
        L207:
            throw d(r19, "Multiple @Body method annotations found.", new Object[0]);
        L209:
            throw d(r19, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L211:
            throw c(r113.toString(), new Object[0]);
        L213:
            throw c("Path", new Object[0]);
        L215:
            if (r111 == null) goto L218;
            r23[r19] = r111;
            r19 = r19 + 1;
            r3 = null;
            r4 = 1;
            r5 = 0;
            goto L60
        L218:
            throw d(r19, "No Retrofit annotation found.", new Object[0]);
        L220:
            throw d(r19, "No Retrofit annotation found.", new Object[0]);
        L221:
            Object[] r46 = new Object[r4];
            r46[0] = r20;
            throw d(r19, "Parameter type must not include a type variable or wildcard: %s", r46);
        L224:
            if (this.o == null) goto L226;
        L232:
            boolean r47 = this.n;
            if (r47 == true) goto L242;
            if (this.m == true) goto L242;
            if (this.i == false) goto L242;
            throw b(null, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L242:
            if (r47 == false) goto L249;
            if (this.h == true) goto L249;
            throw b(null, "Form-encode method must contain at least one @Field.", new Object[0]);
        L249:
            return new r(this);
        L226:
            if (this.k == true) goto L232;
            if (this.q != 0) goto L232;
            throw b(null, "Missing either @%s URL or @Url parameter.", new Object[]{this.l});
        L55:
            if (this.n == false) goto L59;
            throw b(null, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L251:
            throw b(null, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        L253:
            throw b(null, "uplink request must need service id, contact wupanjie.flying", new Object[0]);
        L254:
            e = move-exception;
            throw b(e, "Unable to create call adapter for %s", new Object[]{r2});
        L258:
            throw b(null, "Uplink Service only support Observable", new Object[0]);
        L260:
            throw b(null, "Service methods cannot return void.", new Object[0]);
        L262:
            throw b(null, "Method return type must not include a type variable or wildcard: %s", new Object[]{r2});
        }

        public a(Retrofit r1, Method r2) {
            this.a = r1;
            this.b = r2;
            this.c = r2.getAnnotations();
            this.e = r2.getGenericParameterTypes();
            this.d = r2.getParameterAnnotations();
        }

        public final RuntimeException c(String r3, Object... r4) {
            return b(null, "uplink not support annotation: " + r3, r4);
        }

        public final RuntimeException b(Throwable r2, String r3, Object... r4) {
            return new IllegalArgumentException(String.format(r3, r4) + "\n    for method " + this.b.getDeclaringClass().getSimpleName() + "." + this.b.getName(), r2);
        }

        public final RuntimeException d(int r2, String r3, Object... r4) {
            return b(null, r3 + " (parameter #" + (r2 + 1) + ")", r4);
        }

        public final void e(String r5, String r6, boolean r7) {
            String r0 = this.l;
            Matcher r2 = null;
            if (r0 != null) goto L38;
            this.l = r5;
            Matcher r8 = r.o.matcher(r5);     // Catch: Exception -> L7
        L8:
            if (r8 != null) goto L10;
        L12:
            this.m = r7;
            if (r6.isEmpty() == false) goto L15;
            return;
        L15:
            int r9 = r6.indexOf(63);
            if (r9 != (-1)) goto L18;
        L29:
            this.o = r6;
            r2 = r.o.matcher(r6);     // Catch: Exception -> L39
        L31:
            LinkedHashSet r10 = new LinkedHashSet();
        L32:
            if (r2 == null) goto L36;
            if (r2.find() == false) goto L48;
            r10.add(r2.group(1));
            goto L32
        L48:
            return;
        L36:
            return;
        L18:
            if (r9 >= (r6.length() - 1)) goto L29;
            String r11 = r6.substring(r9 + 1);
            Matcher r13 = r.o.matcher(r11);     // Catch: Exception -> L22
        L23:
            if (r13 == null) goto L29;
            if (r13.find() == false) goto L29;
            throw b(null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r11});
        L22:
            r13 = null;
            goto L23
        L10:
            if (r8.find() == false) goto L12;
            r8.group(1);
        L7:
            r8 = null;
            goto L8
        L38:
            throw b(null, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r0, r5});
        }
    }

    static {
        o = PatternProtector.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    }

    public static Map b() {
        HashMap r0 = new HashMap(32);
        r0.putAll(jc1.k.f(IMiddlewareNetworkService.class).getCommonParams());
        r0.putAll(jc1.k.f(IMiddlewareHostNetwork.class).getCommonParams());
        return r0;
    }

    public r(a<T> r3) {
        this.i = null;
        this.j = -1;
        this.k = new HashMap();
        this.l = new HashMap();
        this.a = r3.q;
        this.b = r3.l;
        this.c = r3.o;
        this.d = r3.n;
        this.e = r3.f;
        this.f = r3.g;
        this.g = r3.p;
        this.h = r3.a.server();
        this.m = r3.s;
        this.n = r3.t;
    }

    public static Class<?> a(Class<?> r1) {
        if (Boolean.TYPE != r1) goto L7;
        return Boolean.class;
    L7:
        if (Byte.TYPE != r1) goto L11;
        return Byte.class;
    L11:
        if (Character.TYPE != r1) goto L15;
        return Character.class;
    L15:
        if (Double.TYPE != r1) goto L19;
        return Double.class;
    L19:
        if (Float.TYPE != r1) goto L23;
        return Float.class;
    L23:
        if (Integer.TYPE != r1) goto L27;
        return Integer.class;
    L27:
        if (Long.TYPE != r1) goto L31;
        return Long.class;
    L31:
        if (Short.TYPE != r1) goto L34;
        return Short.class;
    L34:
        return r1;
    }

    public final com.ss.ugc.live.sdk.msg.network.f c(Object... r11) throws IOException {
        p<?>[] r0 = this.g;
        if (r11 == null) goto L5;
        int r2 = r11.length;
    L7:
        if (r2 != r0.length) goto L92;
        w r3 = new w();
        String r4 = this.c;
        if (r4 == null) goto L12;
        r3.a = r4.toString();
    L12:
        if ("GET".equalsIgnoreCase(this.b) == false) goto L15;
        r3.b = HttpMethod.GET;
    L17:
        HashMap r5 = (HashMap) b();
        r5.remove("openudid");
        Iterator r6 = r5.entrySet().iterator();
    L19:
        if (r6.hasNext() == false) goto L21;
        Map.Entry r7 = (Map.Entry) r6.next();
        r3.c((String) r7.getKey(), (String) r7.getValue(), true);
        goto L19
    L21:
        ArrayList r8 = new ArrayList(r2);
        int r9 = 0;
    L22:
        if (r9 >= r2) goto L25;
        r8.add(r11[r9]);
        r0[r9].a(r3, r11[r9]);
        r9 = r9 + 1;
        goto L22
    L25:
        if (this.d == false) goto L27;
        r3.c = "application/x-www-form-urlencoded; charset=UTF-8";
    L27:
        r3.h = new l(this.f);
        PbRequestCallAdapter r13 = this.e;
        if ((r13 instanceof PbRequestCallAdapter) == false) goto L32;
        PbRequestCallAdapter r14 = r13;
        r14.getClass();
        PbRequestCallAdapter.f.getClass();
        if (((JSONObject) PbRequestCallAdapter.e.getValue()).optBoolean(r14.b, false) == false) goto L32;
        r3.b("response-format", "protobuf");
    L32:
        IHostWebView r15 = jc1.k.f(IHostWebView.class);
        if (r15 == null) goto L41;
        Map r16 = r15.getHeaderMap(this.h.getUrl());
        if (r16 == null) goto L41;
        Iterator r1 = r16.keySet().iterator();
    L38:
        if (r1.hasNext() == false) goto L41;
        String r10 = (String) r1.next();
        r3.b(r10, (String) r16.get(r10));
    L41:
        if (this.i != null) goto L43;
        this.i = (w81) LiveInfraSettingKeys.LIVE_TRACE_COMMON_PARAMS_OPT_CONFIG.getValue();
    L43:
        boolean r17 = this.i.d();
        if (r17 == true) goto L46;
    L48:
        if (r17 == true) goto L50;
    L51:
        this.l = s.a(r3.d(this.h.getUrl()), this.i.b());
        ALogger.i("TraceClientMonitor", "get Cookie EveryTime");
    L52:
        Map<String, String> r18 = this.l;
        if (r18 != null) goto L55;
    L60:
        if (r17 == true) goto L62;
        this.k = b();
        ALogger.i("TraceClientMonitor", "get CommonParams EveryTime");
    L62:
        Map<String, String> r19 = this.k;
        if (r19 == null) goto L70;
        Iterator r110 = ((HashMap) r19).entrySet().iterator();
    L66:
        if (r110.hasNext() == false) goto L70;
        Map.Entry r20 = (Map.Entry) r110.next();
        if (TextUtils.equals((CharSequence) r20.getKey(), "openudid") == true) goto L66;
        r3.c((String) r20.getKey(), (String) r20.getValue(), true);
    L70:
        r3.b("im_uplink_service_id", String.valueOf(this.a));
        List<Header> r111 = this.m;
        if (r111 == null) goto L77;
        Iterator r112 = ((ArrayList) r111).iterator();
    L74:
        if (r112.hasNext() == false) goto L77;
        Header r21 = (Header) r112.next();
        r3.b(r21.getName(), r21.getValue());
    L77:
        if (TextUtils.isEmpty(this.n) == true) goto L80;
        r3.b("Content-Type", this.n);
    L80:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L89;
        HostBoeParams r113 = jc1.k.f(IMiddleWareHostContext.class).getHostBoeParams();
        if (r113 == null) goto L89;
        if (r113.getBoeEnable() == false) goto L87;
        r3.b("X-TT-ENV", r113.getBoeLane());
        r3.b("X-USE-BOE", "1");
        goto L89
    L87:
        if (r113.getPpeEnable() == false) goto L89;
        r3.b("X-TT-ENV", r113.getPpeLane());
        r3.b("X-USE-PPE", "1");
    L89:
        String r114 = r3.d(this.h.getUrl());
        com.ss.ugc.live.sdk.msg.network.f.a r23 = new com.ss.ugc.live.sdk.msg.network.f.a();
        com.ss.ugc.live.sdk.msg.network.f r24 = r23.a;
        r24.b = r114;
        r24.a = r3.b;
        r24.g = r3.c;
        r24.c = r3.d;
        com.ss.ugc.live.sdk.msg.network.f.a r115 = r23.query(r3.e);
        LinkedHashMap<String, String> r25 = r3.f;
        com.ss.ugc.live.sdk.msg.network.f r26 = r115.a;
        r26.h = r25;
        r26.f = r3.g;
        r26.j = r3.h;
        r26.l = true;
        return r115.a();
    L55:
        if (r18.isEmpty() == true) goto L60;
        Iterator<String> r27 = this.l.keySet().iterator();
    L58:
        if (r27.hasNext() == false) goto L60;
        String r28 = r27.next();
        r3.b(r28, this.l.get(r28));
        goto L58
    L50:
        if (this.i.c() == true) goto L52;
    L46:
        if ((System.currentTimeMillis() - this.j) <= this.i.a()) goto L48;
        this.k = b();
        this.l = s.a(r3.d(this.h.getUrl()), this.i.b());
        this.j = System.currentTimeMillis();
        ALogger.i("TraceClientMonitor", "get CommonParams & Cookie Once");
        goto L48
    L15:
        if ("POST".equalsIgnoreCase(this.b) == false) goto L17;
        r3.b = HttpMethod.POST;
        goto L17
    L92:
        throw new IllegalArgumentException("Argument count (" + r2 + ") doesn't match expected count (" + r0.length + ")");
    L5:
        r2 = 0;
        goto L7
    }
}
