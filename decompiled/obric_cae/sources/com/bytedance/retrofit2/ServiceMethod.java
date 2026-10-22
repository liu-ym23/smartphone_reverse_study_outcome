package com.bytedance.retrofit2;

import android.aimedia.a;
import android.text.TextUtils;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.PATCH;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.QueryName;
import com.bytedance.retrofit2.http.RequestPriority;
import com.bytedance.retrofit2.http.ServiceType;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Tag;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.http.ext.QueryObject;
import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import defpackage.b;
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
import we.q;
import we.u;
import we.z;

/* JADX INFO: loaded from: classes.dex */
final class ServiceMethod<T> {
    static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern PARAM_NAME_REGEX = null;
    static final Pattern PARAM_URL_REGEX = null;
    final boolean addCommonParam;
    final ICacheServer cacheServer;
    final CallAdapter<?> callAdapter;
    final Client.Provider clientProvider;
    private String contentTypeHeader;
    final Object extraInfo;
    private final boolean hasBody;
    private List<Header> headers;
    final Executor httpExecutor;
    private final String httpMethod;
    final List<Interceptor> interceptors;
    private final boolean isCustomMethod;
    private final boolean isFormEncoded;
    private final boolean isMultipart;
    final boolean isResponseStreaming;
    final int maxLength;
    final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    final int priorityLevel;
    private final String relativeUrl;
    final int requestPriorityLevel;
    private final Converter<TypedInput, T> responseConverter;
    private RetrofitMetrics retrofitMetrics;
    private final Endpoint server;
    final String serviceType;

    public static final class Builder<T> {
        boolean addCommonParam;
        CallAdapter<?> callAdapter;
        String contentTypeHeader;
        Object extraInfo;
        boolean gotBody;
        boolean gotField;
        boolean gotMethod;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotUrl;
        boolean hasBody;
        List<Header> headers;
        String httpMethod;
        boolean isCustomMethod;
        boolean isFormEncoded;
        boolean isMultipart;
        boolean isResponseStreaming;
        int maxLength;
        final Method method;
        final Annotation[] methodAnnotations;
        String methodParamName;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        int priorityLevel;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        int requestPriorityLevel;
        Converter<TypedInput, T> responseConverter;
        Type responseType;
        final Retrofit retrofit;
        String serviceType;

        public Builder(Retrofit r8, Method r10) {
            this.priorityLevel = 1;
            this.serviceType = "";
            this.isResponseStreaming = false;
            this.maxLength = -1;
            this.addCommonParam = true;
            this.isCustomMethod = false;
            this.extraInfo = null;
            this.requestPriorityLevel = 3;
            this.retrofit = r8;
            this.method = r10;
            this.methodAnnotations = r10.getAnnotations();
            this.parameterTypes = r10.getGenericParameterTypes();
            this.parameterAnnotationsArray = r10.getParameterAnnotations();
        }

        private ParameterHandler<?> bodyAdapt(Type r8) {
            if (z.class.isAssignableFrom(Utils.getRawType(r8)) == true) goto L5;
            return null;
        L5:
            return ParameterHandler.ConverterBody.INSTANCE;
        }

        private CallAdapter<?> createCallAdapter() {
            Type r8 = this.method.getGenericReturnType();
            if (Utils.hasUnresolvableType(r8) == true) goto L15;
            if (r8 == Void.TYPE) goto L13;
            Annotation[] r10 = this.method.getAnnotations();
            return this.retrofit.callAdapter(r8, r10);
        L9:
            e = move-exception;
            throw methodError(e, "Unable to create call adapter for %s", new Object[]{r8});
        L13:
            throw methodError("Service methods cannot return void.", new Object[0]);
        L15:
            throw methodError("Method return type must not include a type variable or wildcard: %s", new Object[]{r8});
        }

        private Converter<TypedInput, T> createResponseConverter() {
            Annotation[] r8 = this.method.getAnnotations();
            return this.retrofit.responseBodyConverter(this.responseType, r8);
        L5:
            e = move-exception;
            throw methodError(e, "Unable to create converter for %s", new Object[]{this.responseType});
        }

        private ParameterHandler generateQueryParameterHandler(int r8, Type r10, Annotation[] r11, boolean r12, String r13, boolean r14) {
            Class<?> r15 = Utils.getRawType(r10);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r15) == false) goto L15;
            if ((r10 instanceof ParameterizedType) == false) goto L13;
            Converter<T, String> r16 = this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r10), r11);
            if (r12 == false) goto L11;
            return new ParameterHandler.QueryName(r16, r14).iterable();
        L11:
            return new ParameterHandler.Query(r13, r16, r14).iterable();
        L13:
            throw parameterError(r8, r15.getSimpleName() + " must include generic type (e.g., " + r15.getSimpleName() + "<String>)", new Object[0]);
        L15:
            if (r15.isArray() == false) goto L22;
            Converter<T, String> r17 = this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(r15.getComponentType()), r11);
            if (r12 == false) goto L21;
            return new ParameterHandler.QueryName(r17, r14).array();
        L21:
            return new ParameterHandler.Query(r13, r17, r14).array();
        L22:
            Converter<T, String> r18 = this.retrofit.stringConverter(r10, r11);
            if (r12 == false) goto L27;
            return new ParameterHandler.QueryName(r18, r14);
        L27:
            return new ParameterHandler.Query(r13, r18, r14);
        }

        private q getRequestBodyHeader(String r8, String r10) {
            return q.h(new String[]{"Content-Disposition", b.d("form-data; name=\"", r8, "\""), "Content-Transfer-Encoding", r10});
        }

        private RuntimeException methodError(String r8, Object... r10) {
            return methodError(null, r8, r10);
        }

        private RuntimeException parameterError(int r8, String r10, Object... r11) {
            StringBuilder r12 = a.k(r10, " (parameter #");
            r12.append(r8 + 1);
            r12.append(")");
            return methodError(r12.toString(), r11);
        }

        private List<Header> parseHeaders(String[] r8) {
            ArrayList r10 = new ArrayList();
            int r11 = r8.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L16;
            String r13 = r8[r12];
            int r14 = r13.indexOf(58);
            if (r14 == (-1)) goto L15;
            if (r14 == 0) goto L15;
            if (r14 == (r13.length() - 1)) goto L15;
            String r15 = r13.substring(0, r14);
            String r16 = r13.substring(r14 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(r15) == false) goto L12;
            this.contentTypeHeader = r16;
        L13:
            r12 = r12 + 1;
            goto L3
        L12:
            r10.add(new Header(r15, r16));
        L15:
            throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r13});
        L16:
            return r10;
        }

        private void parseHttpMethodAndPath(String r8, String r10, boolean r11) {
            String r12 = this.httpMethod;
            if (r12 != null) goto L25;
            this.httpMethod = r8;
            if (r8 == null) goto L8;
            this.methodParamName = ServiceMethod.parseMethodParameters(r8);
        L8:
            if (this.methodParamName == null) goto L10;
            this.isCustomMethod = true;
        L10:
            this.hasBody = r11;
            if (r10.isEmpty() == false) goto L13;
            return;
        L13:
            int r13 = r10.indexOf(63);
            if (r13 != (-1)) goto L16;
        L22:
            this.relativeUrl = r10;
            this.relativeUrlParamNames = ServiceMethod.parsePathParameters(r10);
            return;
        L16:
            if (r13 >= (r10.length() - 1)) goto L22;
            String r14 = r10.substring(r13 + 1);
            if (ServiceMethod.PARAM_URL_REGEX.matcher(r14).find() == false) goto L22;
            throw methodError("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r14});
        L25:
            throw methodError("Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r12, r8});
        }

        private void parseMethodAnnotation(Annotation r8) {
            if ((r8 instanceof DELETE) == false) goto L7;
            String r10 = ((DELETE) r8).value();
            String r11 = HttpMethodContrants.DELETE;
        L5:
            parseHttpMethodAndPath(r11, r10, false);
            return;
        L7:
            if ((r8 instanceof GET) == false) goto L10;
            r10 = ((GET) r8).value();
            r11 = HttpMethodContrants.GET;
            goto L5
        L10:
            if ((r8 instanceof HEAD) == false) goto L17;
            parseHttpMethodAndPath(HttpMethodContrants.HEAD, ((HEAD) r8).value(), false);
            if (Void.class.equals(this.responseType) == false) goto L15;
            return;
        L15:
            throw methodError("HEAD method must use Void as response type.", new Object[0]);
        L17:
            if ((r8 instanceof PATCH) == false) goto L21;
            String r12 = ((PATCH) r8).value();
            String r13 = HttpMethodContrants.PATCH;
        L19:
            parseHttpMethodAndPath(r13, r12, true);
            return;
        L21:
            if ((r8 instanceof POST) == false) goto L24;
            r12 = ((POST) r8).value();
            r13 = HttpMethodContrants.POST;
            goto L19
        L24:
            if ((r8 instanceof PUT) == false) goto L27;
            r12 = ((PUT) r8).value();
            r13 = HttpMethodContrants.PUT;
            goto L19
        L27:
            if ((r8 instanceof OPTIONS) == false) goto L30;
            r10 = ((OPTIONS) r8).value();
            r11 = HttpMethodContrants.OPTIONS;
            goto L5
        L30:
            if ((r8 instanceof HTTP) == false) goto L33;
            HTTP r14 = (HTTP) r8;
            parseHttpMethodAndPath(r14.method(), r14.path(), r14.hasBody());
            return;
        L33:
            if ((r8 instanceof Headers) == false) goto L40;
            String[] r15 = ((Headers) r8).value();
            if (r15.length == 0) goto L38;
            this.headers = parseHeaders(r15);
            return;
        L38:
            throw methodError("@Headers annotation is empty.", new Object[0]);
        L40:
            if ((r8 instanceof Multipart) == false) goto L47;
            if (this.isFormEncoded == true) goto L45;
            this.isMultipart = true;
            return;
        L45:
            throw methodError("Only one encoding annotation is allowed.", new Object[0]);
        L47:
            if ((r8 instanceof FormUrlEncoded) == false) goto L54;
            if (this.isMultipart == true) goto L52;
            this.isFormEncoded = true;
            return;
        L52:
            throw methodError("Only one encoding annotation is allowed.", new Object[0]);
        L54:
            if ((r8 instanceof Streaming) == false) goto L57;
            this.isResponseStreaming = true;
            return;
        L57:
            if ((r8 instanceof Priority) == false) goto L60;
            this.priorityLevel = ((Priority) r8).value();
            return;
        L60:
            if ((r8 instanceof ServiceType) == false) goto L63;
            this.serviceType = ((ServiceType) r8).value();
            return;
        L63:
            if ((r8 instanceof RequestPriority) == false) goto L75;
            this.requestPriorityLevel = ((RequestPriority) r8).value();
            return;
        }

        private ParameterHandler<?> parseParameter(int r8, Type r10, Annotation[] r11) {
            int r12 = r11.length;
            ParameterHandler<?> r13 = null;
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L16;
            Annotation r15 = r11[r14];
            ParameterHandler<?> r16 = parseParameterAnnotation(r8, r10, r11, r15);
            if (r16 == null) goto L7;
        L9:
            if (r16 == null) goto L13;
            if (r13 != null) goto L15;
            r13 = r16;
            goto L13
        L15:
            throw parameterError(r8, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L13:
            r14 = r14 + 1;
            goto L3
        L7:
            if (Platform.squareRetrofitExists() == false) goto L9;
            r16 = parseSquareParameterAnnotation(r8, r10, r11, r15);
            goto L9
        L16:
            if (r13 == null) goto L19;
            return r13;
        L19:
            throw parameterError(r8, "No Retrofit annotation found.", new Object[0]);
        }

        private ParameterHandler<?> parseParameterAnnotation(int r10, Type r11, Annotation[] r12, Annotation r13) {
            if ((r13 instanceof Url) == false) goto L34;
            if (this.gotUrl == true) goto L32;
            if (this.gotPath == true) goto L30;
            if (this.gotQuery == true) goto L28;
            if (this.relativeUrl != null) goto L26;
            this.gotUrl = true;
            if (r11 == String.class) goto L24;
            if (r11 == URI.class) goto L24;
            if ((r11 instanceof Class) == false) goto L22;
            if ("android.net.Uri".equals(((Class) r11).getName()) == true) goto L24;
        L22:
            throw parameterError(r10, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L24:
            return new ParameterHandler.RelativeUrl();
        L26:
            throw parameterError(r10, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L28:
            throw parameterError(r10, "A @Url parameter must not come after a @Query", new Object[0]);
        L30:
            throw parameterError(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L32:
            throw parameterError(r10, "Multiple @Url method annotations found.", new Object[0]);
        L34:
            if ((r13 instanceof Path) == false) goto L50;
            if (this.gotQuery == true) goto L48;
            if (this.gotUrl == true) goto L46;
            if (this.relativeUrl == null) goto L44;
            this.gotPath = true;
            Path r14 = (Path) r13;
            String r8 = r14.value();
            validatePathName(r10, r8);
            return new ParameterHandler.Path(r8, this.retrofit.stringConverter(r11, r12), r14.encode());
        L44:
            throw parameterError(r10, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L46:
            throw parameterError(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L48:
            throw parameterError(r10, "A @Path parameter must not come after a @Query.", new Object[0]);
        L50:
            if ((r13 instanceof Query) == false) goto L54;
            Query r15 = (Query) r13;
            return generateQueryParameterHandler(r10, r11, r12, false, r15.value(), r15.encode());
        L54:
            if ((r13 instanceof QueryName) == false) goto L58;
            return generateQueryParameterHandler(r10, r11, r12, true, null, ((QueryName) r13).encoded());
        L58:
            if ((r13 instanceof QueryMap) == false) goto L74;
            Class<?> r16 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r16) == false) goto L72;
            Type r17 = Utils.getSupertype(r11, r16, Map.class);
            if ((r17 instanceof ParameterizedType) == false) goto L70;
            ParameterizedType r18 = (ParameterizedType) r17;
            Type r19 = Utils.getParameterUpperBound(0, r18);
            if (String.class != r19) goto L68;
            return new ParameterHandler.QueryMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r18), r12), ((QueryMap) r13).encode());
        L68:
            throw parameterError(r10, "@QueryMap keys must be of type String: " + r19, new Object[0]);
        L70:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L72:
            throw parameterError(r10, "@QueryMap parameter type must be Map.", new Object[0]);
        L74:
            if ((r13 instanceof com.bytedance.retrofit2.http.Header) == false) goto L90;
            String r110 = ((com.bytedance.retrofit2.http.Header) r13).value();
            Class<?> r20 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r20) == false) goto L84;
            if ((r11 instanceof ParameterizedType) == false) goto L82;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12)).iterable();
        L82:
            throw parameterError(r10, r20.getSimpleName() + " must include generic type (e.g., " + r20.getSimpleName() + "<String>)", new Object[0]);
        L84:
            if (r20.isArray() == false) goto L88;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(r20.getComponentType()), r12)).array();
        L88:
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(r11, r12));
        L90:
            if ((r13 instanceof HeaderList) == false) goto L106;
            Class<?> r111 = Utils.getRawType(r11);
            if (List.class.isAssignableFrom(r111) == false) goto L104;
            Type r112 = Utils.getSupertype(r11, r111, List.class);
            if ((r112 instanceof ParameterizedType) == false) goto L102;
            Type r113 = Utils.getParameterUpperBound(0, (ParameterizedType) r112);
            if (Header.class != r113) goto L100;
            return new ParameterHandler.HeaderList(this.retrofit.headerConverter(r113, r12));
        L100:
            throw parameterError(r10, "@HeaderList keys must be of type retrofit.client.Header: " + r113, new Object[0]);
        L102:
            throw parameterError(r10, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L104:
            throw parameterError(r10, "@HeaderList parameter type must be List.", new Object[0]);
        L106:
            if ((r13 instanceof HeaderMap) == false) goto L122;
            Class<?> r114 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r114) == false) goto L120;
            Type r115 = Utils.getSupertype(r11, r114, Map.class);
            if ((r115 instanceof ParameterizedType) == false) goto L118;
            ParameterizedType r116 = (ParameterizedType) r115;
            Type r117 = Utils.getParameterUpperBound(0, r116);
            if (String.class != r117) goto L116;
            return new ParameterHandler.HeaderMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r116), r12));
        L116:
            throw parameterError(r10, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L118:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L120:
            throw parameterError(r10, "@HeaderMap parameter type must be Map.", new Object[0]);
        L122:
            if ((r13 instanceof Field) == false) goto L142;
            if (this.isFormEncoded == false) goto L140;
            Field r118 = (Field) r13;
            String r21 = r118.value();
            boolean r119 = r118.encode();
            this.gotField = true;
            Class<?> r22 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r22) == false) goto L134;
            if ((r11 instanceof ParameterizedType) == false) goto L132;
            return new ParameterHandler.Field(r21, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), r119).iterable();
        L132:
            throw parameterError(r10, r22.getSimpleName() + " must include generic type (e.g., " + r22.getSimpleName() + "<String>)", new Object[0]);
        L134:
            if (r22.isArray() == false) goto L138;
            return new ParameterHandler.Field(r21, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(r22.getComponentType()), r12), r119).array();
        L138:
            return new ParameterHandler.Field(r21, this.retrofit.stringConverter(r11, r12), r119);
        L140:
            throw parameterError(r10, "@Field parameters can only be used with form encoding.", new Object[0]);
        L142:
            if ((r13 instanceof FieldMap) == false) goto L162;
            if (this.isFormEncoded == false) goto L160;
            Class<?> r23 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r23) == false) goto L158;
            Type r120 = Utils.getSupertype(r11, r23, Map.class);
            if ((r120 instanceof ParameterizedType) == false) goto L156;
            ParameterizedType r121 = (ParameterizedType) r120;
            Type r24 = Utils.getParameterUpperBound(0, r121);
            if (String.class != r24) goto L154;
            Converter<T, String> r122 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r121), r12);
            this.gotField = true;
            return new ParameterHandler.FieldMap(r122, ((FieldMap) r13).encode());
        L154:
            throw parameterError(r10, "@FieldMap keys must be of type String: " + r24, new Object[0]);
        L156:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L158:
            throw parameterError(r10, "@FieldMap parameter type must be Map.", new Object[0]);
        L160:
            throw parameterError(r10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L162:
            if ((r13 instanceof Part) == false) goto L173;
            if (this.isMultipart == false) goto L171;
            Part r123 = (Part) r13;
            this.gotPart = true;
            ParameterHandler<?> r124 = partAdapt(r11, r123.value(), r123.encoding());
            if (r124 == null) goto L169;
            return r124;
        L169:
            return new ParameterHandler.Part(r123.value(), this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations));
        L171:
            throw parameterError(r10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L173:
            if ((r13 instanceof PartMap) == false) goto L196;
            if (this.isMultipart == false) goto L194;
            this.gotPart = true;
            Class<?> r25 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r25) == false) goto L192;
            Type r125 = Utils.getSupertype(r11, r25, Map.class);
            if ((r125 instanceof ParameterizedType) == false) goto L190;
            ParameterizedType r126 = (ParameterizedType) r125;
            Type r26 = Utils.getParameterUpperBound(0, r126);
            if (String.class != r26) goto L188;
            ParameterHandler<?> r127 = partMapAdapt(r126, r13);
            if (r127 == null) goto L186;
            return r127;
        L186:
            return new ParameterHandler.PartMap(this.retrofit.requestBodyConverter(Utils.getParameterUpperBound(1, r126), r12, this.methodAnnotations), ((PartMap) r13).encoding());
        L188:
            throw parameterError(r10, "@PartMap keys must be of type String: " + r26, new Object[0]);
        L190:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L192:
            throw parameterError(r10, "@PartMap parameter type must be Map.", new Object[0]);
        L194:
            throw parameterError(r10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L196:
            if ((r13 instanceof Body) == false) goto L218;
            if (this.isFormEncoded == true) goto L216;
            if (this.isMultipart == true) goto L216;
            if (this.gotBody == true) goto L214;
            ParameterHandler<?> r128 = bodyAdapt(r11);
            if (r128 == null) goto L279;
            this.gotBody = true;
            return r128;
        L279:
            Converter<T, TypedOutput> r129 = this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations);     // Catch: RuntimeException -> L210
            this.gotBody = true;
            return new ParameterHandler.Body(this.isCustomMethod, r129);
        L210:
            e = move-exception;
            throw parameterError(e, r10, "Unable to create @Body converter for %s", new Object[]{r11});
        L214:
            throw parameterError(r10, "Multiple @Body method annotations found.", new Object[0]);
        L216:
            throw parameterError(r10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L218:
            if ((r13 instanceof com.bytedance.retrofit2.http.Method) == false) goto L226;
            if (this.gotMethod == true) goto L224;
            this.gotMethod = true;
            String r130 = ((com.bytedance.retrofit2.http.Method) r13).value();
            validateMethodName(r10, r130);
            return new ParameterHandler.Method(r130, this.retrofit.stringConverter(r11, r12));
        L224:
            throw parameterError(r10, "Multiple @Method method annotations found.", new Object[0]);
        L226:
            if ((r13 instanceof MaxLength) == false) goto L234;
            return new ParameterHandler.MaxLength(this.retrofit.stringConverter(r11, r12));
        L230:
            e = move-exception;
            throw parameterError(e, r10, "Unable to create @MaxLength converter for %s", new Object[]{r11});
        L234:
            if ((r13 instanceof AddCommonParam) == false) goto L242;
            return new ParameterHandler.AddCommonParam(this.retrofit.stringConverter(r11, r12));
        L238:
            e = move-exception;
            throw parameterError(e, r10, "Unable to create @AddCommonParam converter for %s", new Object[]{r11});
        L242:
            if ((r13 instanceof ExtraInfo) == false) goto L250;
            return new ParameterHandler.ExtraInfo(this.retrofit.objectConverter(r11, r12));
        L246:
            e = move-exception;
            throw parameterError(e, r10, "Unable to create @ExtraInfo converter for %s", new Object[]{r11});
        L250:
            if ((r13 instanceof QueryObject) == false) goto L258;
            if (QueryParamObject.class.isAssignableFrom(Utils.getRawType(r11)) == false) goto L256;
            return new ParameterHandler.QueryObject();
        L256:
            throw parameterError(r10, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r11});
        L258:
            if ((r13 instanceof Tag) == false) goto L271;
            Class<?> r131 = Utils.getRawType(r11);
            int r132 = r10 - 1;
        L260:
            if (r132 < 0) goto L270;
            ParameterHandler<?> r133 = this.parameterHandlers[r132];
            if ((r133 instanceof ParameterHandler.Tag) == false) goto L268;
            if (((ParameterHandler.Tag) r133).cls.equals(r131) == false) goto L268;
            throw parameterError(r10, "@Tag type " + r131.getName() + " is duplicate of parameter #" + (r132 + 1) + " and would always overwrite its value.", new Object[0]);
        L268:
            r132 = r132 - 1;
            goto L260
        L270:
            return new ParameterHandler.Tag(r131);
        L271:
            return null;
        }

        private void parseSquareMethodAnnotation(Annotation r8) {
            if ((r8 instanceof retrofit2.http.DELETE) == false) goto L7;
            String r10 = ((retrofit2.http.DELETE) r8).value();
            String r11 = HttpMethodContrants.DELETE;
        L5:
            parseHttpMethodAndPath(r11, r10, false);
            return;
        L7:
            if ((r8 instanceof retrofit2.http.GET) == false) goto L10;
            r10 = ((retrofit2.http.GET) r8).value();
            r11 = HttpMethodContrants.GET;
            goto L5
        L10:
            if ((r8 instanceof retrofit2.http.HEAD) == false) goto L17;
            parseHttpMethodAndPath(HttpMethodContrants.HEAD, ((retrofit2.http.HEAD) r8).value(), false);
            if (Void.class.equals(this.responseType) == false) goto L15;
            return;
        L15:
            throw methodError("HEAD method must use Void as response type.", new Object[0]);
        L17:
            if ((r8 instanceof retrofit2.http.PATCH) == false) goto L21;
            String r12 = ((retrofit2.http.PATCH) r8).value();
            String r13 = HttpMethodContrants.PATCH;
        L19:
            parseHttpMethodAndPath(r13, r12, true);
            return;
        L21:
            if ((r8 instanceof retrofit2.http.POST) == false) goto L24;
            r12 = ((retrofit2.http.POST) r8).value();
            r13 = HttpMethodContrants.POST;
            goto L19
        L24:
            if ((r8 instanceof retrofit2.http.PUT) == false) goto L27;
            r12 = ((retrofit2.http.PUT) r8).value();
            r13 = HttpMethodContrants.PUT;
            goto L19
        L27:
            if ((r8 instanceof retrofit2.http.OPTIONS) == false) goto L30;
            r10 = ((retrofit2.http.OPTIONS) r8).value();
            r11 = HttpMethodContrants.OPTIONS;
            goto L5
        L30:
            if ((r8 instanceof retrofit2.http.HTTP) == false) goto L33;
            retrofit2.http.HTTP r14 = (retrofit2.http.HTTP) r8;
            parseHttpMethodAndPath(r14.method(), r14.path(), r14.hasBody());
            return;
        L33:
            if ((r8 instanceof retrofit2.http.Headers) == false) goto L40;
            String[] r15 = ((retrofit2.http.Headers) r8).value();
            if (r15.length == 0) goto L38;
            this.headers = parseHeaders(r15);
            return;
        L38:
            throw methodError("@Headers annotation is empty.", new Object[0]);
        L40:
            if ((r8 instanceof retrofit2.http.Multipart) == false) goto L47;
            if (this.isFormEncoded == true) goto L45;
            this.isMultipart = true;
            return;
        L45:
            throw methodError("Only one encoding annotation is allowed.", new Object[0]);
        L47:
            if ((r8 instanceof retrofit2.http.FormUrlEncoded) == false) goto L54;
            if (this.isMultipart == true) goto L52;
            this.isFormEncoded = true;
            return;
        L52:
            throw methodError("Only one encoding annotation is allowed.", new Object[0]);
        L54:
            if ((r8 instanceof retrofit2.http.Streaming) == false) goto L63;
            this.isResponseStreaming = true;
            return;
        }

        private ParameterHandler<?> parseSquareParameterAnnotation(int r10, Type r11, Annotation[] r12, Annotation r13) {
            if ((r13 instanceof retrofit2.http.Url) == false) goto L34;
            if (this.gotUrl == true) goto L32;
            if (this.gotPath == true) goto L30;
            if (this.gotQuery == true) goto L28;
            if (this.relativeUrl != null) goto L26;
            this.gotUrl = true;
            if (r11 == String.class) goto L24;
            if (r11 == URI.class) goto L24;
            if ((r11 instanceof Class) == false) goto L22;
            if ("android.net.Uri".equals(((Class) r11).getName()) == true) goto L24;
        L22:
            throw parameterError(r10, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L24:
            return new ParameterHandler.RelativeUrl();
        L26:
            throw parameterError(r10, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L28:
            throw parameterError(r10, "A @Url parameter must not come after a @Query", new Object[0]);
        L30:
            throw parameterError(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L32:
            throw parameterError(r10, "Multiple @Url method annotations found.", new Object[0]);
        L34:
            if ((r13 instanceof retrofit2.http.Path) == false) goto L50;
            if (this.gotQuery == true) goto L48;
            if (this.gotUrl == true) goto L46;
            if (this.relativeUrl == null) goto L44;
            this.gotPath = true;
            retrofit2.http.Path r14 = (retrofit2.http.Path) r13;
            String r8 = r14.value();
            validatePathName(r10, r8);
            return new ParameterHandler.Path(r8, this.retrofit.stringConverter(r11, r12), !r14.encoded());
        L44:
            throw parameterError(r10, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L46:
            throw parameterError(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L48:
            throw parameterError(r10, "A @Path parameter must not come after a @Query.", new Object[0]);
        L50:
            if ((r13 instanceof retrofit2.http.Query) == false) goto L66;
            retrofit2.http.Query r15 = (retrofit2.http.Query) r13;
            String r16 = r15.value();
            boolean r17 = r15.encoded();
            Class<?> r18 = Utils.getRawType(r11);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r18) == false) goto L60;
            if ((r11 instanceof ParameterizedType) == false) goto L58;
            return new ParameterHandler.Query(r16, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), !r17).iterable();
        L58:
            throw parameterError(r10, r18.getSimpleName() + " must include generic type (e.g., " + r18.getSimpleName() + "<String>)", new Object[0]);
        L60:
            if (r18.isArray() == false) goto L64;
            return new ParameterHandler.Query(r16, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(r18.getComponentType()), r12), !r17).array();
        L64:
            return new ParameterHandler.Query(r16, this.retrofit.stringConverter(r11, r12), !r17);
        L66:
            if ((r13 instanceof retrofit2.http.QueryName) == false) goto L82;
            boolean r19 = ((retrofit2.http.QueryName) r13).encoded();
            Class<?> r20 = Utils.getRawType(r11);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r20) == false) goto L76;
            if ((r11 instanceof ParameterizedType) == false) goto L74;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), r19).iterable();
        L74:
            throw parameterError(r10, r20.getSimpleName() + " must include generic type (e.g., " + r20.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r20.isArray() == false) goto L80;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(r20.getComponentType()), r12), r19).array();
        L80:
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(r11, r12), r19);
        L82:
            if ((r13 instanceof retrofit2.http.QueryMap) == false) goto L98;
            Class<?> r21 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r21) == false) goto L96;
            Type r110 = Utils.getSupertype(r11, r21, Map.class);
            if ((r110 instanceof ParameterizedType) == false) goto L94;
            ParameterizedType r111 = (ParameterizedType) r110;
            Type r22 = Utils.getParameterUpperBound(0, r111);
            if (String.class != r22) goto L92;
            return new ParameterHandler.QueryMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r111), r12), !((retrofit2.http.QueryMap) r13).encoded());
        L92:
            throw parameterError(r10, "@QueryMap keys must be of type String: " + r22, new Object[0]);
        L94:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L96:
            throw parameterError(r10, "@QueryMap parameter type must be Map.", new Object[0]);
        L98:
            if ((r13 instanceof retrofit2.http.Header) == false) goto L114;
            String r112 = ((retrofit2.http.Header) r13).value();
            Class<?> r23 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r23) == false) goto L108;
            if ((r11 instanceof ParameterizedType) == false) goto L106;
            return new ParameterHandler.Header(r112, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12)).iterable();
        L106:
            throw parameterError(r10, r23.getSimpleName() + " must include generic type (e.g., " + r23.getSimpleName() + "<String>)", new Object[0]);
        L108:
            if (r23.isArray() == false) goto L112;
            return new ParameterHandler.Header(r112, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(r23.getComponentType()), r12)).array();
        L112:
            return new ParameterHandler.Header(r112, this.retrofit.stringConverter(r11, r12));
        L114:
            if ((r13 instanceof retrofit2.http.HeaderMap) == false) goto L130;
            Class<?> r113 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r113) == false) goto L128;
            Type r114 = Utils.getSupertype(r11, r113, Map.class);
            if ((r114 instanceof ParameterizedType) == false) goto L126;
            ParameterizedType r115 = (ParameterizedType) r114;
            Type r116 = Utils.getParameterUpperBound(0, r115);
            if (String.class != r116) goto L124;
            return new ParameterHandler.HeaderMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r115), r12));
        L124:
            throw parameterError(r10, "@HeaderMap keys must be of type String: " + r116, new Object[0]);
        L126:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L128:
            throw parameterError(r10, "@HeaderMap parameter type must be Map.", new Object[0]);
        L130:
            if ((r13 instanceof retrofit2.http.Field) == false) goto L150;
            if (this.isFormEncoded == false) goto L148;
            retrofit2.http.Field r117 = (retrofit2.http.Field) r13;
            String r24 = r117.value();
            boolean r118 = r117.encoded();
            this.gotField = true;
            Class<?> r25 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r25) == false) goto L142;
            if ((r11 instanceof ParameterizedType) == false) goto L140;
            return new ParameterHandler.Field(r24, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), !r118).iterable();
        L140:
            throw parameterError(r10, r25.getSimpleName() + " must include generic type (e.g., " + r25.getSimpleName() + "<String>)", new Object[0]);
        L142:
            if (r25.isArray() == false) goto L146;
            return new ParameterHandler.Field(r24, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(r25.getComponentType()), r12), !r118).array();
        L146:
            return new ParameterHandler.Field(r24, this.retrofit.stringConverter(r11, r12), !r118);
        L148:
            throw parameterError(r10, "@Field parameters can only be used with form encoding.", new Object[0]);
        L150:
            if ((r13 instanceof retrofit2.http.FieldMap) == false) goto L170;
            if (this.isFormEncoded == false) goto L168;
            Class<?> r26 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r26) == false) goto L166;
            Type r119 = Utils.getSupertype(r11, r26, Map.class);
            if ((r119 instanceof ParameterizedType) == false) goto L164;
            ParameterizedType r120 = (ParameterizedType) r119;
            Type r27 = Utils.getParameterUpperBound(0, r120);
            if (String.class != r27) goto L162;
            Converter<T, String> r121 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r120), r12);
            this.gotField = true;
            return new ParameterHandler.FieldMap(r121, !((retrofit2.http.FieldMap) r13).encoded());
        L162:
            throw parameterError(r10, "@FieldMap keys must be of type String: " + r27, new Object[0]);
        L164:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L166:
            throw parameterError(r10, "@FieldMap parameter type must be Map.", new Object[0]);
        L168:
            throw parameterError(r10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L170:
            if ((r13 instanceof retrofit2.http.Part) == false) goto L181;
            if (this.isMultipart == false) goto L179;
            retrofit2.http.Part r122 = (retrofit2.http.Part) r13;
            this.gotPart = true;
            ParameterHandler<?> r123 = partAdapt(r11, r122.value(), r122.encoding());
            if (r123 == null) goto L177;
            return r123;
        L177:
            return new ParameterHandler.Part(r122.value(), this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations));
        L179:
            throw parameterError(r10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L181:
            if ((r13 instanceof retrofit2.http.PartMap) == false) goto L204;
            if (this.isMultipart == false) goto L202;
            this.gotPart = true;
            Class<?> r28 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r28) == false) goto L200;
            Type r124 = Utils.getSupertype(r11, r28, Map.class);
            if ((r124 instanceof ParameterizedType) == false) goto L198;
            ParameterizedType r125 = (ParameterizedType) r124;
            Type r29 = Utils.getParameterUpperBound(0, r125);
            if (String.class != r29) goto L196;
            ParameterHandler<?> r126 = partMapAdapt(r125, r13);
            if (r126 == null) goto L194;
            return r126;
        L194:
            return new ParameterHandler.PartMap(this.retrofit.requestBodyConverter(Utils.getParameterUpperBound(1, r125), r12, this.methodAnnotations), ((retrofit2.http.PartMap) r13).encoding());
        L196:
            throw parameterError(r10, "@PartMap keys must be of type String: " + r29, new Object[0]);
        L198:
            throw parameterError(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L200:
            throw parameterError(r10, "@PartMap parameter type must be Map.", new Object[0]);
        L202:
            throw parameterError(r10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L204:
            if ((r13 instanceof retrofit2.http.Body) == true) goto L206;
            return null;
        L206:
            if (this.isFormEncoded == true) goto L224;
            if (this.isMultipart == true) goto L224;
            if (this.gotBody == true) goto L222;
            ParameterHandler<?> r127 = bodyAdapt(r11);
            if (r127 == null) goto L227;
            this.gotBody = true;
            return r127;
        L227:
            Converter<T, TypedOutput> r128 = this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations);     // Catch: RuntimeException -> L218
            this.gotBody = true;
            return new ParameterHandler.Body(this.isCustomMethod, r128);
        L218:
            e = move-exception;
            throw parameterError(e, r10, "Unable to create @Body converter for %s", new Object[]{r11});
        L222:
            throw parameterError(r10, "Multiple @Body method annotations found.", new Object[0]);
        L224:
            throw parameterError(r10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        }

        private ParameterHandler<?> partAdapt(Type r8, String r10, String r11) {
            Class<?> r12 = Utils.getRawType(r8);
            if (TextUtils.isEmpty(r10) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r12) == false) goto L14;
            if ((r8 instanceof ParameterizedType) == true) goto L10;
            return null;
        L10:
            if (u.b.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) r8))) == true) goto L12;
        L42:
            return null;
        L12:
            return ParameterHandler.ConverterRawPart.INSTANCE.iterable();
        L14:
            if (r12.isArray() == false) goto L20;
            if (u.b.class.isAssignableFrom(r12.getComponentType()) == false) goto L42;
            return ParameterHandler.ConverterRawPart.INSTANCE.array();
        L20:
            if (u.b.class.isAssignableFrom(r12) == false) goto L42;
            return ParameterHandler.ConverterRawPart.INSTANCE;
        L24:
            if (Iterable.class.isAssignableFrom(r12) == false) goto L33;
            if ((r8 instanceof ParameterizedType) == true) goto L29;
            return null;
        L29:
            if (z.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) r8))) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r10, r11)).iterable();
        L33:
            if (r12.isArray() == false) goto L39;
            if (z.class.isAssignableFrom(ServiceMethod.boxIfPrimitive(r12.getComponentType())) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r10, r11)).array();
        L39:
            if (z.class.isAssignableFrom(r12) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r10, r11));
        }

        private ParameterHandler<?> partMapAdapt(ParameterizedType r8, Annotation r10) {
            if (z.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(1, r8))) == true) goto L5;
            return null;
        L5:
            return new ParameterHandler.ConverterPartMap(((PartMap) r10).encoding());
        }

        private void validateMethodName(int r8, String r10) {
            if (ServiceMethod.PARAM_NAME_REGEX.matcher(r10).matches() == false) goto L13;
            String r11 = this.methodParamName;
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.equals(r10) == false) goto L10;
            return;
        L10:
            throw parameterError(r8, "Method \"%s\" does not contain \"{%s}\".", new Object[]{this.httpMethod, r10});
        L13:
            throw parameterError(r8, "@Method parameter name must match %s. Found: %s", new Object[]{ServiceMethod.PARAM_URL_REGEX.pattern(), r10});
        }

        private void validatePathName(int r8, String r10) {
            if (ServiceMethod.PARAM_NAME_REGEX.matcher(r10).matches() == false) goto L10;
            if (this.relativeUrlParamNames.contains(r10) == false) goto L8;
            return;
        L8:
            throw parameterError(r8, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.relativeUrl, r10});
        L10:
            throw parameterError(r8, "@Path parameter name must match %s. Found: %s", new Object[]{ServiceMethod.PARAM_URL_REGEX.pattern(), r10});
        }

        public ServiceMethod build() {
            CallAdapter<?> r8 = createCallAdapter();
            this.callAdapter = r8;
            Type r10 = r8.responseType();
            this.responseType = r10;
            if (r10 == Response.class) goto L74;
            this.responseConverter = createResponseConverter();
            Annotation[] r11 = this.methodAnnotations;
            int r12 = r11.length;
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L11;
            Annotation r14 = r11[r13];
            parseMethodAnnotation(r14);
            if (Platform.squareRetrofitExists() == false) goto L9;
            parseSquareMethodAnnotation(r14);
        L9:
            r13 = r13 + 1;
            goto L5
        L11:
            if (this.httpMethod == null) goto L72;
            if (this.hasBody == false) goto L15;
        L25:
            int r15 = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[r15];
            int r16 = 0;
        L26:
            if (r16 >= r15) goto L37;
            Type r17 = this.parameterTypes[r16];
            if (Utils.hasUnresolvableType(r17) == true) goto L35;
            Annotation[] r18 = this.parameterAnnotationsArray[r16];
            if (r18 == null) goto L33;
            this.parameterHandlers[r16] = parseParameter(r16, r17, r18);
            r16 = r16 + 1;
            goto L26
        L33:
            throw parameterError(r16, "No Retrofit annotation found.", new Object[0]);
        L35:
            throw parameterError(r16, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r17});
        L37:
            if (this.relativeUrl == null) goto L39;
        L43:
            boolean r19 = this.isFormEncoded;
            if (r19 == false) goto L46;
        L56:
            if (r19 == false) goto L63;
            if (this.gotField == true) goto L63;
            throw methodError("Form-encode method must contain at least one @Field.", new Object[0]);
        L63:
            if (this.isMultipart == false) goto L70;
            if (this.gotPart == true) goto L70;
            throw methodError("Multipart method must contain at least one @Part.", new Object[0]);
        L70:
            return new ServiceMethod(this);
        L46:
            if (this.isMultipart == true) goto L56;
            if (this.hasBody == true) goto L56;
            if (this.isCustomMethod == true) goto L56;
            if (this.gotBody == false) goto L56;
            throw methodError("Non-body HTTP method cannot contain @Body.", new Object[0]);
        L39:
            if (this.gotUrl == true) goto L43;
            throw methodError("Missing either @%s URL or @Url parameter.", new Object[]{this.httpMethod});
        L15:
            if (this.isCustomMethod == true) goto L25;
            if (this.isMultipart == true) goto L24;
            if (this.isFormEncoded == false) goto L25;
            throw methodError("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L24:
            throw methodError("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L72:
            throw methodError("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        L74:
            throw methodError("'" + Utils.getRawType(this.responseType).getName() + "' is not a valid response body type.", new Object[0]);
        }

        private RuntimeException methodError(Throwable r8, String r10, Object... r11) {
            StringBuilder r12 = a.k(String.format(r10, r11), "\n    for method ");
            r12.append(this.method.getDeclaringClass().getSimpleName());
            r12.append(".");
            r12.append(this.method.getName());
            return new IllegalArgumentException(r12.toString(), r8);
        }

        private RuntimeException parameterError(Throwable r8, int r10, String r11, Object... r12) {
            StringBuilder r13 = a.k(r11, " (parameter #");
            r13.append(r10 + 1);
            r13.append(")");
            return methodError(r8, r13.toString(), r12);
        }
    }

    static {
        PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        PARAM_NAME_REGEX = Pattern.compile(PARAM);
    }

    public ServiceMethod(Builder<T> r8) {
        this.clientProvider = r8.retrofit.clientProvider();
        this.callAdapter = r8.callAdapter;
        this.interceptors = r8.retrofit.interceptors();
        this.httpExecutor = r8.retrofit.httpExecutor();
        this.server = r8.retrofit.server();
        this.responseConverter = r8.responseConverter;
        this.httpMethod = r8.httpMethod;
        this.relativeUrl = r8.relativeUrl;
        this.hasBody = r8.hasBody;
        this.isFormEncoded = r8.isFormEncoded;
        this.isMultipart = r8.isMultipart;
        this.parameterHandlers = r8.parameterHandlers;
        this.headers = r8.headers;
        this.contentTypeHeader = r8.contentTypeHeader;
        this.priorityLevel = r8.priorityLevel;
        this.requestPriorityLevel = r8.requestPriorityLevel;
        this.serviceType = r8.serviceType;
        this.isResponseStreaming = r8.isResponseStreaming;
        this.maxLength = r8.maxLength;
        this.addCommonParam = r8.addCommonParam;
        this.isCustomMethod = r8.isCustomMethod;
        this.extraInfo = r8.extraInfo;
        this.method = r8.method;
        this.cacheServer = r8.retrofit.cacheServer();
    }

    public static Class<?> boxIfPrimitive(Class<?> r8) {
        if (Boolean.TYPE != r8) goto L7;
        return Boolean.class;
    L7:
        if (Byte.TYPE != r8) goto L11;
        return Byte.class;
    L11:
        if (Character.TYPE != r8) goto L15;
        return Character.class;
    L15:
        if (Double.TYPE != r8) goto L19;
        return Double.class;
    L19:
        if (Float.TYPE != r8) goto L23;
        return Float.class;
    L23:
        if (Integer.TYPE != r8) goto L27;
        return Integer.class;
    L27:
        if (Long.TYPE != r8) goto L31;
        return Long.class;
    L31:
        if (Short.TYPE != r8) goto L34;
        return Short.class;
    L34:
        return r8;
    }

    public static String parseMethodParameters(String r8) {
        Matcher r10 = PARAM_URL_REGEX.matcher(r8);
        if (r10.find() == true) goto L5;
        return null;
    L5:
        return r10.group(1);
    }

    public static Set<String> parsePathParameters(String r8) {
        Matcher r10 = PARAM_URL_REGEX.matcher(r8);
        LinkedHashSet r11 = new LinkedHashSet();
    L4:
        if (r10.find() == false) goto L6;
        r11.add(r10.group(1));
        goto L4
    L6:
        return r11;
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public void setRetrofitMetrics(RetrofitMetrics r8) {
        this.retrofitMetrics = r8;
    }

    public Request toRequest(ExpandCallback r20, Object... r21) {
        RequestBuilder r15 = new RequestBuilder(this.httpMethod, this.server, this.relativeUrl, this.headers, this.contentTypeHeader, this.priorityLevel, this.requestPriorityLevel, this.isResponseStreaming, this.maxLength, this.addCommonParam, this.extraInfo, this.hasBody, this.isFormEncoded, this.isMultipart, this.serviceType);
        ParameterHandler<?>[] r8 = this.parameterHandlers;
        int r10 = 0;
        if (r21 == null) goto L5;
        int r11 = r21.length;
    L7:
        if (r11 != r8.length) goto L14;
        ArrayList r12 = new ArrayList(r11);
    L9:
        if (r10 >= r11) goto L11;
        r12.add(r21[r10]);
        r8[r10].apply(r15, r21[r10]);
        r10 = r10 + 1;
        goto L9
    L11:
        r15.addTag(Invocation.class, new Invocation(this.method, r12));
        return r15.build(r20);
    L14:
        throw new IllegalArgumentException(a.h(b.f("Argument count (", r11, ") doesn't match expected count ("), r8.length, ")"));
    L5:
        r11 = 0;
        goto L7
    }

    public T toResponse(TypedInput r8) {
        return this.responseConverter.convert(r8);
    }
}
