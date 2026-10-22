package com.bytedance.retrofit2;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
final class RequestFactory<T> {
    final boolean addCommonParam;
    final ICacheServer cacheServer;
    final Client.Provider clientProvider;
    final int commonParamLevel;
    private final String contentTypeHeader;
    private final boolean enableRecordFormFields;
    final Object extraInfo;
    private final boolean hasBody;
    private final List<Header> headers;
    final Executor httpExecutor;
    final String httpMethod;
    final List<Interceptor> interceptors;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    final boolean isResponseStreaming;
    final int maxLength;
    final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    final int priorityLevel;
    private final String relativeUrl;
    final int requestPriorityLevel;
    public Converter<TypedInput, T> responseConverter;
    private RetrofitMetrics retrofitMetrics;
    private final Endpoint server;
    final String serviceType;

    static final class Builder<T> {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = null;
        private static final Pattern PARAM_URL_REGEX = null;
        boolean addCommonParam;
        int commonParamLevel;
        String contentTypeHeader;
        boolean enableRecordFormFields;
        Object extraInfo;
        boolean gotBody;
        boolean gotField;
        boolean gotMethod;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        List<Header> headers;
        String httpMethod;
        boolean isCustomMethod;
        boolean isFormEncoded;
        boolean isKotlinSuspendFunction;
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
        final Retrofit retrofit;
        final RetrofitMetrics retrofitMetrics;
        String serviceType;

        static {
            PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            PARAM_NAME_REGEX = Pattern.compile(PARAM);
        }

        Builder(Retrofit r4, Method r5, RetrofitMetrics r6) {
            this.priorityLevel = 1;
            this.serviceType = "";
            this.isResponseStreaming = false;
            this.maxLength = -1;
            this.addCommonParam = true;
            this.commonParamLevel = 0;
            this.isCustomMethod = false;
            this.extraInfo = null;
            this.requestPriorityLevel = 3;
            this.retrofit = r4;
            this.method = r5;
            this.methodAnnotations = r5.getAnnotations();
            this.parameterTypes = r5.getGenericParameterTypes();
            this.parameterAnnotationsArray = r5.getParameterAnnotations();
            this.retrofitMetrics = r6;
        }

        private ParameterHandler<?> bodyAdapt(Type r2) {
            if (RequestBody.class.isAssignableFrom(Utils.getRawType((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"))) == true) goto L5;
            return null;
        L5:
            return ParameterHandler.ConverterBody.INSTANCE;
        }

        private static Class<?> boxIfPrimitive(Class<?> r1) {
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

        private Headers getRequestBodyHeader(String r3, String r4) {
            return Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r3 + "\"", "Content-Transfer-Encoding", r4});
        }

        private List<Header> parseHeaders(String[] r9) {
            ArrayList r0 = new ArrayList();
            int r1 = r9.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L16;
            String r4 = r9[r3];
            int r5 = r4.indexOf(58);
            if (r5 == (-1)) goto L15;
            if (r5 == 0) goto L15;
            if (r5 == (r4.length() - 1)) goto L15;
            String r6 = r4.substring(0, r5);
            String r7 = r4.substring(r5 + 1).trim();
            if (NetConst.KEY_CONTENT_TYPE.equalsIgnoreCase(r6) == false) goto L12;
            this.contentTypeHeader = r7;
        L13:
            r3 = r3 + 1;
            goto L3
        L12:
            r0.add(new Header(r6, r7));
        L15:
            throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r4});
        L16:
            return r0;
        }

        private void parseHttpMethodAndPath(String r4, String r5, boolean r6) {
            String r0 = this.httpMethod;
            if (r0 != null) goto L31;
            this.httpMethod = r4;
            if (r4 == null) goto L8;
            this.methodParamName = parseMethodParameters(r4);
        L8:
            if (this.methodParamName == null) goto L10;
            this.isCustomMethod = true;
        L10:
            this.hasBody = r6;
            if (r5.isEmpty() == false) goto L13;
            return;
        L13:
            int r7 = r5.indexOf(63);
            if (r7 != (-1)) goto L16;
        L28:
            this.relativeUrl = r5;
            this.relativeUrlParamNames = parsePathParameters(r5);
            return;
        L16:
            if (r7 >= (r5.length() - 1)) goto L28;
            String r8 = r5.substring(r7 + 1);     // Catch: IllegalArgumentException -> L23
            if (PARAM_URL_REGEX.matcher(r8).find() == false) goto L28;
            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r8});     // Catch: IllegalArgumentException -> L23
        L23:
            e = move-exception;
            if (e.getMessage().contains("URL query string") == false) goto L28;
            throw e;
        L31:
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r0, r4});
        }

        private void parseMethodAnnotation(Annotation r6) {
            Annotation r7 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r6, Annotation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, DELETE.class) == false) goto L7;
            String r8 = ((DELETE) ZeusTransformUtils.preCheckCast(r7, DELETE.class, "com.obric.memorydata.plugin")).value();
            String r0 = HttpMethodContrants.DELETE;
        L5:
            parseHttpMethodAndPath(r0, r8, false);
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r7, GET.class) == false) goto L10;
            r8 = ((GET) ZeusTransformUtils.preCheckCast(r7, GET.class, "com.obric.memorydata.plugin")).value();
            r0 = HttpMethodContrants.GET;
            goto L5
        L10:
            if (ZeusTransformUtils.instanceOf(r7, HEAD.class) == false) goto L13;
            r8 = ((HEAD) ZeusTransformUtils.preCheckCast(r7, HEAD.class, "com.obric.memorydata.plugin")).value();
            r0 = HttpMethodContrants.HEAD;
            goto L5
        L13:
            if (ZeusTransformUtils.instanceOf(r7, PATCH.class) == false) goto L17;
            String r9 = ((PATCH) ZeusTransformUtils.preCheckCast(r7, PATCH.class, "com.obric.memorydata.plugin")).value();
            String r1 = HttpMethodContrants.PATCH;
        L15:
            parseHttpMethodAndPath(r1, r9, true);
            return;
        L17:
            if (ZeusTransformUtils.instanceOf(r7, POST.class) == false) goto L20;
            r9 = ((POST) ZeusTransformUtils.preCheckCast(r7, POST.class, "com.obric.memorydata.plugin")).value();
            r1 = "POST";
            goto L15
        L20:
            if (ZeusTransformUtils.instanceOf(r7, PUT.class) == false) goto L23;
            r9 = ((PUT) ZeusTransformUtils.preCheckCast(r7, PUT.class, "com.obric.memorydata.plugin")).value();
            r1 = HttpMethodContrants.PUT;
            goto L15
        L23:
            if (ZeusTransformUtils.instanceOf(r7, OPTIONS.class) == false) goto L26;
            r8 = ((OPTIONS) ZeusTransformUtils.preCheckCast(r7, OPTIONS.class, "com.obric.memorydata.plugin")).value();
            r0 = HttpMethodContrants.OPTIONS;
            goto L5
        L26:
            if (ZeusTransformUtils.instanceOf(r7, HTTP.class) == false) goto L29;
            HTTP r10 = (HTTP) ZeusTransformUtils.preCheckCast(r7, HTTP.class, "com.obric.memorydata.plugin");
            parseHttpMethodAndPath(r10.method(), r10.path(), r10.hasBody());
            return;
        L29:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.http.Headers.class) == false) goto L36;
            String[] r11 = ((com.bytedance.retrofit2.http.Headers) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.http.Headers.class, "com.obric.memorydata.plugin")).value();
            if (r11.length == 0) goto L34;
            this.headers = parseHeaders(r11);
            return;
        L34:
            throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
        L36:
            if (ZeusTransformUtils.instanceOf(r7, Multipart.class) == false) goto L43;
            if (this.isFormEncoded == true) goto L41;
            this.isMultipart = true;
            return;
        L41:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L43:
            if (ZeusTransformUtils.instanceOf(r7, FormUrlEncoded.class) == false) goto L50;
            if (this.isMultipart == true) goto L48;
            this.isFormEncoded = true;
            this.enableRecordFormFields = ((FormUrlEncoded) ZeusTransformUtils.preCheckCast(r7, FormUrlEncoded.class, "com.obric.memorydata.plugin")).enableRecord();
            return;
        L48:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L50:
            if (ZeusTransformUtils.instanceOf(r7, Streaming.class) == false) goto L53;
            this.isResponseStreaming = true;
            return;
        L53:
            if (ZeusTransformUtils.instanceOf(r7, Priority.class) == false) goto L56;
            this.priorityLevel = ((Priority) ZeusTransformUtils.preCheckCast(r7, Priority.class, "com.obric.memorydata.plugin")).value();
            return;
        L56:
            if (ZeusTransformUtils.instanceOf(r7, ServiceType.class) == false) goto L59;
            this.serviceType = ((ServiceType) ZeusTransformUtils.preCheckCast(r7, ServiceType.class, "com.obric.memorydata.plugin")).value();
            return;
        L59:
            if (ZeusTransformUtils.instanceOf(r7, RequestPriority.class) == false) goto L71;
            this.requestPriorityLevel = ((RequestPriority) ZeusTransformUtils.preCheckCast(r7, RequestPriority.class, "com.obric.memorydata.plugin")).value();
            return;
        }

        static String parseMethodParameters(String r1) {
            Matcher r2 = PARAM_URL_REGEX.matcher(r1);     // Catch: IllegalArgumentException -> L8
            if (r2.find() == false) goto L6;
            return r2.group(1);
        L6:
            return null;
        L11:
            return null;
        }

        private ParameterHandler<?> parseParameter(int r9, Type r10, Annotation[] r11, boolean r12) {
            Type r13 = (Type) ZeusTransformUtils.wrapperContextForParams(r10, Type.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L18;
            int r2 = r11.length;
            ParameterHandler<?> r4 = null;
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L19;
            Annotation r5 = r11[r3];
            ParameterHandler<?> r6 = parseParameterAnnotation(r9, r13, r11, r5);
            if (r6 == null) goto L9;
        L11:
            if (r6 == null) goto L15;
            if (r4 != null) goto L17;
            r4 = r6;
            goto L15
        L17:
            throw Utils.parameterError(this.method, r9, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L15:
            r3 = r3 + 1;
            goto L5
        L9:
            if (Platform.squareRetrofitExists() == false) goto L11;
            r6 = parseSquareParameterAnnotation(r9, r13, r11, r5);
        L19:
            if (r4 != null) goto L27;
            if (r12 == false) goto L26;
            if (Utils.getRawType(r13) != Continuation.class) goto L26;
            this.isKotlinSuspendFunction = true;     // Catch: NoClassDefFoundError -> L28
            return null;
        L26:
            throw Utils.parameterError(this.method, r9, "No Retrofit annotation found.", new Object[0]);
        L27:
            return r4;
        L18:
            r4 = null;
            goto L19
        }

        private ParameterHandler<?> parseParameterAnnotation(int r8, Type r9, Annotation[] r10, Annotation r11) {
            Type r12 = (Type) ZeusTransformUtils.wrapperContextForParams(r9, Type.class, "com.obric.memorydata.plugin");
            Annotation r13 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r11, Annotation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, Url.class) == false) goto L42;
            validateResolvableType(r8, r12);
            if (this.gotUrl == true) goto L40;
            if (this.gotPath == true) goto L38;
            if (this.gotQuery == true) goto L36;
            if (this.relativeUrl != null) goto L34;
            if (this.gotQueryName == true) goto L32;
            if (this.gotQueryMap == true) goto L30;
            this.gotUrl = true;
            if (r12 == String.class) goto L28;
            if (r12 == URI.class) goto L28;
            if (ZeusTransformUtils.instanceOf(r12, Class.class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) ZeusTransformUtils.preCheckCast(r12, Class.class, "com.obric.memorydata.plugin")).getName()) == true) goto L28;
        L26:
            throw Utils.parameterError(this.method, r8, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new ParameterHandler.RelativeUrl(this.method, r8);
        L30:
            throw Utils.parameterError(this.method, r8, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L32:
            throw Utils.parameterError(this.method, r8, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L34:
            throw Utils.parameterError(this.method, r8, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L36:
            throw Utils.parameterError(this.method, r8, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw Utils.parameterError(this.method, r8, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw Utils.parameterError(this.method, r8, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if (ZeusTransformUtils.instanceOf(r13, Path.class) == false) goto L66;
            validateResolvableType(r8, r12);
            if (this.gotQuery == true) goto L64;
            if (this.gotUrl == true) goto L62;
            if (this.relativeUrl == null) goto L60;
            if (this.gotQueryName == true) goto L58;
            if (this.gotQueryMap == true) goto L56;
            this.gotPath = true;
            Path r14 = (Path) ZeusTransformUtils.preCheckCast(r13, Path.class, "com.obric.memorydata.plugin");
            String r3 = r14.value();
            validatePathName(r8, r3);
            return new ParameterHandler.Path(this.method, r8, r3, this.retrofit.stringConverter(r12, r10), r14.encode());
        L56:
            throw Utils.parameterError(this.method, r8, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L58:
            throw Utils.parameterError(this.method, r8, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L60:
            throw Utils.parameterError(this.method, r8, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L62:
            throw Utils.parameterError(this.method, r8, "@Path parameters may not be used with @Url.", new Object[0]);
        L64:
            throw Utils.parameterError(this.method, r8, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if (ZeusTransformUtils.instanceOf(r13, Query.class) == false) goto L82;
            validateResolvableType(r8, r12);
            Query r15 = (Query) ZeusTransformUtils.preCheckCast(r13, Query.class, "com.obric.memorydata.plugin");
            String r0 = r15.value();
            boolean r16 = r15.encode();
            Class<?> r6 = Utils.getRawType(r12);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r6) == false) goto L76;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L74;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.memorydata.plugin")), r10), r16).iterable();
        L74:
            throw Utils.parameterError(this.method, r8, r6.getSimpleName() + " must include generic type (e.g., " + r6.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r6.isArray() == false) goto L80;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(boxIfPrimitive(r6.getComponentType()), r10), r16).array();
        L80:
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(r12, r10), r16);
        L82:
            if (ZeusTransformUtils.instanceOf(r13, QueryName.class) == false) goto L98;
            validateResolvableType(r8, r12);
            boolean r17 = ((QueryName) ZeusTransformUtils.preCheckCast(r13, QueryName.class, "com.obric.memorydata.plugin")).encoded();
            Class<?> r1 = Utils.getRawType(r12);
            this.gotQueryName = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L92;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L90;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.memorydata.plugin")), r10), r17).iterable();
        L90:
            throw Utils.parameterError(this.method, r8, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r1.isArray() == false) goto L96;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(r1.getComponentType()), r10), r17).array();
        L96:
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(r12, r10), r17);
        L98:
            if (ZeusTransformUtils.instanceOf(r13, QueryMap.class) == false) goto L114;
            validateResolvableType(r8, r12);
            Class<?> r2 = Utils.getRawType(r12);
            this.gotQueryMap = true;
            if (Map.class.isAssignableFrom(r2) == false) goto L112;
            Type r18 = Utils.getSupertype(r12, r2, Map.class);
            if (ZeusTransformUtils.instanceOf(r18, ParameterizedType.class) == false) goto L110;
            ParameterizedType r19 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r18, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r4 = Utils.getParameterUpperBound(0, r19);
            if (String.class != r4) goto L108;
            return new ParameterHandler.QueryMap(this.method, r8, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r19), r10), ((QueryMap) ZeusTransformUtils.preCheckCast(r13, QueryMap.class, "com.obric.memorydata.plugin")).encode());
        L108:
            throw Utils.parameterError(this.method, r8, "@QueryMap keys must be of type String: " + r4, new Object[0]);
        L110:
            throw Utils.parameterError(this.method, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw Utils.parameterError(this.method, r8, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.http.Header.class) == false) goto L130;
            validateResolvableType(r8, r12);
            String r110 = ((com.bytedance.retrofit2.http.Header) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.http.Header.class, "com.obric.memorydata.plugin")).value();
            Class<?> r5 = Utils.getRawType(r12);
            if (Iterable.class.isAssignableFrom(r5) == false) goto L124;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L122;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.memorydata.plugin")), r10)).iterable();
        L122:
            throw Utils.parameterError(this.method, r8, r5.getSimpleName() + " must include generic type (e.g., " + r5.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r5.isArray() == false) goto L128;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(boxIfPrimitive(r5.getComponentType()), r10)).array();
        L128:
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(r12, r10));
        L130:
            if (ZeusTransformUtils.instanceOf(r13, HeaderList.class) == false) goto L146;
            Class<?> r111 = Utils.getRawType(r12);
            if (List.class.isAssignableFrom(r111) == false) goto L144;
            Type r20 = Utils.getSupertype(r12, r111, List.class);
            if (ZeusTransformUtils.instanceOf(r20, ParameterizedType.class) == false) goto L142;
            Type r21 = Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r20, ParameterizedType.class, "com.obric.memorydata.plugin"));
            if (Header.class != r21) goto L140;
            return new ParameterHandler.HeaderList(this.retrofit.headerConverter(r21, r10));
        L140:
            throw Utils.parameterError(this.method, r8, "@HeaderList keys must be of type retrofit.client.Header: " + r21, new Object[0]);
        L142:
            throw Utils.parameterError(this.method, r8, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L144:
            throw Utils.parameterError(this.method, r8, "@HeaderList parameter type must be List.", new Object[0]);
        L146:
            if (ZeusTransformUtils.instanceOf(r13, HeaderMap.class) == false) goto L162;
            validateResolvableType(r8, r12);
            Class<?> r112 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r112) == false) goto L160;
            Type r22 = Utils.getSupertype(r12, r112, Map.class);
            if (ZeusTransformUtils.instanceOf(r22, ParameterizedType.class) == false) goto L158;
            ParameterizedType r23 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r22, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r113 = Utils.getParameterUpperBound(0, r23);
            if (String.class != r113) goto L156;
            return new ParameterHandler.HeaderMap(this.method, r8, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r23), r10));
        L156:
            throw Utils.parameterError(this.method, r8, "@HeaderMap keys must be of type String: " + r113, new Object[0]);
        L158:
            throw Utils.parameterError(this.method, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L160:
            throw Utils.parameterError(this.method, r8, "@HeaderMap parameter type must be Map.", new Object[0]);
        L162:
            if (ZeusTransformUtils.instanceOf(r13, Field.class) == false) goto L182;
            validateResolvableType(r8, r12);
            if (this.isFormEncoded == false) goto L180;
            Field r114 = (Field) ZeusTransformUtils.preCheckCast(r13, Field.class, "com.obric.memorydata.plugin");
            String r7 = r114.value();
            boolean r115 = r114.encode();
            this.gotField = true;
            Class<?> r24 = Utils.getRawType(r12);
            if (Iterable.class.isAssignableFrom(r24) == false) goto L174;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L172;
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.memorydata.plugin")), r10), r115).iterable();
        L172:
            throw Utils.parameterError(this.method, r8, r24.getSimpleName() + " must include generic type (e.g., " + r24.getSimpleName() + "<String>)", new Object[0]);
        L174:
            if (r24.isArray() == false) goto L178;
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(boxIfPrimitive(r24.getComponentType()), r10), r115).array();
        L178:
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(r12, r10), r115);
        L180:
            throw Utils.parameterError(this.method, r8, "@Field parameters can only be used with form encoding.", new Object[0]);
        L182:
            if (ZeusTransformUtils.instanceOf(r13, FieldMap.class) == false) goto L202;
            validateResolvableType(r8, r12);
            if (this.isFormEncoded == false) goto L200;
            Class<?> r25 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r25) == false) goto L198;
            Type r26 = Utils.getSupertype(r12, r25, Map.class);
            if (ZeusTransformUtils.instanceOf(r26, ParameterizedType.class) == false) goto L196;
            ParameterizedType r27 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r26, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r28 = Utils.getParameterUpperBound(0, r27);
            if (String.class != r28) goto L194;
            Converter<T, String> r29 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r27), r10);
            this.gotField = true;
            return new ParameterHandler.FieldMap(this.method, r8, r29, ((FieldMap) ZeusTransformUtils.preCheckCast(r13, FieldMap.class, "com.obric.memorydata.plugin")).encode());
        L194:
            throw Utils.parameterError(this.method, r8, "@FieldMap keys must be of type String: " + r28, new Object[0]);
        L196:
            throw Utils.parameterError(this.method, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L198:
            throw Utils.parameterError(this.method, r8, "@FieldMap parameter type must be Map.", new Object[0]);
        L200:
            throw Utils.parameterError(this.method, r8, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L202:
            if (ZeusTransformUtils.instanceOf(r13, Part.class) == false) goto L213;
            if (this.isMultipart == false) goto L211;
            Part r116 = (Part) ZeusTransformUtils.preCheckCast(r13, Part.class, "com.obric.memorydata.plugin");
            this.gotPart = true;
            ParameterHandler<?> r30 = partAdapt(r12, r116.value(), r116.encoding());
            if (r30 == null) goto L209;
            return r30;
        L209:
            return new ParameterHandler.Part(this.method, r8, r116.value(), this.retrofit.requestBodyConverter(r12, r10, this.methodAnnotations));
        L211:
            throw Utils.parameterError(this.method, r8, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L213:
            if (ZeusTransformUtils.instanceOf(r13, PartMap.class) == false) goto L236;
            validateResolvableType(r8, r12);
            if (this.isMultipart == false) goto L234;
            this.gotPart = true;
            Class<?> r31 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r31) == false) goto L232;
            Type r32 = Utils.getSupertype(r12, r31, Map.class);
            if (ZeusTransformUtils.instanceOf(r32, ParameterizedType.class) == false) goto L230;
            ParameterizedType r33 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r32, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r34 = Utils.getParameterUpperBound(0, r33);
            if (String.class != r34) goto L228;
            ParameterHandler<?> r35 = partMapAdapt(r33, r13);
            if (r35 == null) goto L226;
            return r35;
        L226:
            return new ParameterHandler.PartMap(this.method, r8, this.retrofit.requestBodyConverter(Utils.getParameterUpperBound(1, r33), r10, this.methodAnnotations), ((PartMap) ZeusTransformUtils.preCheckCast(r13, PartMap.class, "com.obric.memorydata.plugin")).encoding());
        L228:
            throw Utils.parameterError(this.method, r8, "@PartMap keys must be of type String: " + r34, new Object[0]);
        L230:
            throw Utils.parameterError(this.method, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L232:
            throw Utils.parameterError(this.method, r8, "@PartMap parameter type must be Map.", new Object[0]);
        L234:
            throw Utils.parameterError(this.method, r8, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L236:
            if (ZeusTransformUtils.instanceOf(r13, Body.class) == false) goto L258;
            validateResolvableType(r8, r12);
            if (this.isFormEncoded == true) goto L256;
            if (this.isMultipart == true) goto L256;
            if (this.gotBody == true) goto L254;
            ParameterHandler<?> r117 = bodyAdapt(r12);
            if (r117 == null) goto L316;
            this.gotBody = true;
            return r117;
        L316:
            Converter<T, TypedOutput> r36 = this.retrofit.requestBodyConverter(r12, r10, this.methodAnnotations);     // Catch: RuntimeException -> L250
            this.gotBody = true;
            return new ParameterHandler.Body(this.method, r8, this.isCustomMethod, r36);
        L250:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r8, "Unable to create @Body converter for %s", new Object[]{r12});
        L254:
            throw Utils.parameterError(this.method, r8, "Multiple @Body method annotations found.", new Object[0]);
        L256:
            throw Utils.parameterError(this.method, r8, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L258:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.http.Method.class) == false) goto L266;
            if (this.gotMethod == true) goto L264;
            this.gotMethod = true;
            String r118 = ((com.bytedance.retrofit2.http.Method) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.http.Method.class, "com.obric.memorydata.plugin")).value();
            validateMethodName(r8, r118);
            return new ParameterHandler.Method(r118, this.retrofit.stringConverter(r12, r10));
        L264:
            throw Utils.parameterError(this.method, r8, "Multiple @Method method annotations found.", new Object[0]);
        L266:
            if (ZeusTransformUtils.instanceOf(r13, MaxLength.class) == false) goto L274;
            return new ParameterHandler.MaxLength(this.retrofit.stringConverter(r12, r10));
        L270:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r8, "Unable to create @MaxLength converter for %s", new Object[]{r12});
        L274:
            if (ZeusTransformUtils.instanceOf(r13, AddCommonParam.class) == false) goto L283;
            this.commonParamLevel = ((AddCommonParam) ZeusTransformUtils.preCheckCast(r13, AddCommonParam.class, "com.obric.memorydata.plugin")).level();
            return new ParameterHandler.AddCommonParam(this.retrofit.stringConverter(r12, r10));
        L279:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r8, "Unable to create @AddCommonParam converter for %s", new Object[]{r12});
        L283:
            if (ZeusTransformUtils.instanceOf(r13, ExtraInfo.class) == false) goto L291;
            return new ParameterHandler.ExtraInfo(this.retrofit.objectConverter(r12, r10));
        L287:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r8, "Unable to create @ExtraInfo converter for %s", new Object[]{r12});
        L291:
            if (ZeusTransformUtils.instanceOf(r13, QueryObject.class) == false) goto L299;
            if (QueryParamObject.class.isAssignableFrom(Utils.getRawType(r12)) == false) goto L297;
            return new ParameterHandler.QueryObject();
        L297:
            throw Utils.parameterError(this.method, r8, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r12});
        L299:
            if (ZeusTransformUtils.instanceOf(r13, Tag.class) == false) goto L312;
            validateResolvableType(r8, r12);
            Class<?> r37 = Utils.getRawType(r12);
            int r119 = r8 - 1;
        L301:
            if (r119 < 0) goto L311;
            ParameterHandler<?> r120 = this.parameterHandlers[r119];
            if (ZeusTransformUtils.instanceOf(r120, ParameterHandler.Tag.class) == false) goto L309;
            if (((ParameterHandler.Tag) ZeusTransformUtils.preCheckCast(r120, ParameterHandler.Tag.class, "com.obric.memorydata.plugin")).cls.equals(r37) == false) goto L309;
            throw Utils.parameterError(this.method, r8, "@Tag type " + r37.getName() + " is duplicate of parameter #" + (r119 + 1) + " and would always overwrite its value.", new Object[0]);
        L309:
            r119 = r119 - 1;
            goto L301
        L311:
            return new ParameterHandler.Tag(r37);
        L312:
            return null;
        }

        static Set<String> parsePathParameters(String r2) {
            LinkedHashSet r0 = new LinkedHashSet();
            Matcher r3 = PARAM_URL_REGEX.matcher(r2);     // Catch: IllegalArgumentException -> L9
        L5:
            if (r3.find() == false) goto L8;
            r0.add(r3.group(1));     // Catch: IllegalArgumentException -> L9
        L8:
            return r0;
        }

        private void parseSquareMethodAnnotation(Annotation r5) {
            Annotation r6 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r5, Annotation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.DELETE.class) == false) goto L7;
            String r7 = ((retrofit2.http.DELETE) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.DELETE.class, "com.obric.memorydata.plugin")).value();
            String r0 = HttpMethodContrants.DELETE;
        L5:
            parseHttpMethodAndPath(r0, r7, false);
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.GET.class) == false) goto L10;
            r7 = ((retrofit2.http.GET) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.GET.class, "com.obric.memorydata.plugin")).value();
            r0 = HttpMethodContrants.GET;
            goto L5
        L10:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.HEAD.class) == false) goto L13;
            r7 = ((retrofit2.http.HEAD) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.HEAD.class, "com.obric.memorydata.plugin")).value();
            r0 = HttpMethodContrants.HEAD;
            goto L5
        L13:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.PATCH.class) == false) goto L17;
            String r8 = ((retrofit2.http.PATCH) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.PATCH.class, "com.obric.memorydata.plugin")).value();
            String r1 = HttpMethodContrants.PATCH;
        L15:
            parseHttpMethodAndPath(r1, r8, true);
            return;
        L17:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.POST.class) == false) goto L20;
            r8 = ((retrofit2.http.POST) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.POST.class, "com.obric.memorydata.plugin")).value();
            r1 = "POST";
            goto L15
        L20:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.PUT.class) == false) goto L23;
            r8 = ((retrofit2.http.PUT) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.PUT.class, "com.obric.memorydata.plugin")).value();
            r1 = HttpMethodContrants.PUT;
            goto L15
        L23:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.OPTIONS.class) == false) goto L26;
            r7 = ((retrofit2.http.OPTIONS) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.OPTIONS.class, "com.obric.memorydata.plugin")).value();
            r0 = HttpMethodContrants.OPTIONS;
            goto L5
        L26:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.HTTP.class) == false) goto L29;
            retrofit2.http.HTTP r9 = (retrofit2.http.HTTP) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.HTTP.class, "com.obric.memorydata.plugin");
            parseHttpMethodAndPath(r9.method(), r9.path(), r9.hasBody());
            return;
        L29:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.Headers.class) == false) goto L36;
            String[] r10 = ((retrofit2.http.Headers) ZeusTransformUtils.preCheckCast(r6, retrofit2.http.Headers.class, "com.obric.memorydata.plugin")).value();
            if (r10.length == 0) goto L34;
            this.headers = parseHeaders(r10);
            return;
        L34:
            throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
        L36:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.Multipart.class) == false) goto L43;
            if (this.isFormEncoded == true) goto L41;
            this.isMultipart = true;
            return;
        L41:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L43:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.FormUrlEncoded.class) == false) goto L50;
            if (this.isMultipart == true) goto L48;
            this.isFormEncoded = true;
            return;
        L48:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L50:
            if (ZeusTransformUtils.instanceOf(r6, retrofit2.http.Streaming.class) == false) goto L59;
            this.isResponseStreaming = true;
            return;
        }

        private ParameterHandler<?> parseSquareParameterAnnotation(int r11, Type r12, Annotation[] r13, Annotation r14) {
            Type r15 = (Type) ZeusTransformUtils.wrapperContextForParams(r12, Type.class, "com.obric.memorydata.plugin");
            Annotation r16 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r14, Annotation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Url.class) == false) goto L42;
            validateResolvableType(r11, r15);
            if (this.gotUrl == true) goto L40;
            if (this.gotPath == true) goto L38;
            if (this.gotQuery == true) goto L36;
            if (this.gotQueryName == true) goto L34;
            if (this.gotQueryMap == true) goto L32;
            if (this.relativeUrl != null) goto L30;
            this.gotUrl = true;
            if (r15 == String.class) goto L28;
            if (r15 == URI.class) goto L28;
            if (ZeusTransformUtils.instanceOf(r15, Class.class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) ZeusTransformUtils.preCheckCast(r15, Class.class, "com.obric.memorydata.plugin")).getName()) == true) goto L28;
        L26:
            throw Utils.parameterError(this.method, r11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new ParameterHandler.RelativeUrl(this.method, r11);
        L30:
            throw Utils.parameterError(this.method, r11, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L32:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L34:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L36:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw Utils.parameterError(this.method, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw Utils.parameterError(this.method, r11, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Path.class) == false) goto L66;
            validateResolvableType(r11, r15);
            if (this.gotQuery == true) goto L64;
            if (this.gotQueryName == true) goto L62;
            if (this.gotQueryMap == true) goto L60;
            if (this.gotUrl == true) goto L58;
            if (this.relativeUrl == null) goto L56;
            this.gotPath = true;
            retrofit2.http.Path r17 = (retrofit2.http.Path) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.Path.class, "com.obric.memorydata.plugin");
            String r7 = r17.value();
            validatePathName(r11, r7);
            return new ParameterHandler.Path(this.method, r11, r7, this.retrofit.stringConverter(r15, r13), !r17.encoded());
        L56:
            throw Utils.parameterError(this.method, r11, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L58:
            throw Utils.parameterError(this.method, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L60:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L62:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L64:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Query.class) == false) goto L82;
            validateResolvableType(r11, r15);
            retrofit2.http.Query r18 = (retrofit2.http.Query) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.Query.class, "com.obric.memorydata.plugin");
            String r0 = r18.value();
            boolean r19 = r18.encoded();
            Class<?> r6 = Utils.getRawType(r15);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r6) == false) goto L76;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L74;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.memorydata.plugin")), r13), !r19).iterable();
        L74:
            throw Utils.parameterError(this.method, r11, r6.getSimpleName() + " must include generic type (e.g., " + r6.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r6.isArray() == false) goto L80;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(boxIfPrimitive(r6.getComponentType()), r13), !r19).array();
        L80:
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(r15, r13), !r19);
        L82:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.QueryName.class) == false) goto L98;
            validateResolvableType(r11, r15);
            boolean r110 = ((retrofit2.http.QueryName) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.QueryName.class, "com.obric.memorydata.plugin")).encoded();
            Class<?> r1 = Utils.getRawType(r15);
            this.gotQueryName = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L92;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L90;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.memorydata.plugin")), r13), r110).iterable();
        L90:
            throw Utils.parameterError(this.method, r11, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r1.isArray() == false) goto L96;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(r1.getComponentType()), r13), r110).array();
        L96:
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(r15, r13), r110);
        L98:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.QueryMap.class) == false) goto L114;
            validateResolvableType(r11, r15);
            Class<?> r2 = Utils.getRawType(r15);
            this.gotQueryMap = true;
            if (Map.class.isAssignableFrom(r2) == false) goto L112;
            Type r111 = Utils.getSupertype(r15, r2, Map.class);
            if (ZeusTransformUtils.instanceOf(r111, ParameterizedType.class) == false) goto L110;
            ParameterizedType r112 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r111, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r3 = Utils.getParameterUpperBound(0, r112);
            if (String.class != r3) goto L108;
            return new ParameterHandler.QueryMap(this.method, r11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r112), r13), !((retrofit2.http.QueryMap) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.QueryMap.class, "com.obric.memorydata.plugin")).encoded());
        L108:
            throw Utils.parameterError(this.method, r11, "@QueryMap keys must be of type String: " + r3, new Object[0]);
        L110:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw Utils.parameterError(this.method, r11, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Header.class) == false) goto L130;
            validateResolvableType(r11, r15);
            String r113 = ((retrofit2.http.Header) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.Header.class, "com.obric.memorydata.plugin")).value();
            Class<?> r4 = Utils.getRawType(r15);
            if (Iterable.class.isAssignableFrom(r4) == false) goto L124;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L122;
            return new ParameterHandler.Header(r113, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.memorydata.plugin")), r13)).iterable();
        L122:
            throw Utils.parameterError(this.method, r11, r4.getSimpleName() + " must include generic type (e.g., " + r4.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r4.isArray() == false) goto L128;
            return new ParameterHandler.Header(r113, this.retrofit.stringConverter(boxIfPrimitive(r4.getComponentType()), r13)).array();
        L128:
            return new ParameterHandler.Header(r113, this.retrofit.stringConverter(r15, r13));
        L130:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.HeaderMap.class) == false) goto L146;
            validateResolvableType(r11, r15);
            Class<?> r114 = Utils.getRawType(r15);
            if (Map.class.isAssignableFrom(r114) == false) goto L144;
            Type r115 = Utils.getSupertype(r15, r114, Map.class);
            if (ZeusTransformUtils.instanceOf(r115, ParameterizedType.class) == false) goto L142;
            ParameterizedType r116 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r115, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r117 = Utils.getParameterUpperBound(0, r116);
            if (String.class != r117) goto L140;
            return new ParameterHandler.HeaderMap(this.method, r11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r116), r13));
        L140:
            throw Utils.parameterError(this.method, r11, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L142:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L144:
            throw Utils.parameterError(this.method, r11, "@HeaderMap parameter type must be Map.", new Object[0]);
        L146:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Field.class) == false) goto L166;
            validateResolvableType(r11, r15);
            if (this.isFormEncoded == false) goto L164;
            retrofit2.http.Field r118 = (retrofit2.http.Field) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.Field.class, "com.obric.memorydata.plugin");
            String r5 = r118.value();
            boolean r119 = r118.encoded();
            this.gotField = true;
            Class<?> r8 = Utils.getRawType(r15);
            if (Iterable.class.isAssignableFrom(r8) == false) goto L158;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L156;
            return new ParameterHandler.Field(r5, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.memorydata.plugin")), r13), !r119).iterable();
        L156:
            throw Utils.parameterError(this.method, r11, r8.getSimpleName() + " must include generic type (e.g., " + r8.getSimpleName() + "<String>)", new Object[0]);
        L158:
            if (r8.isArray() == false) goto L162;
            return new ParameterHandler.Field(r5, this.retrofit.stringConverter(boxIfPrimitive(r8.getComponentType()), r13), !r119).array();
        L162:
            return new ParameterHandler.Field(r5, this.retrofit.stringConverter(r15, r13), !r119);
        L164:
            throw Utils.parameterError(this.method, r11, "@Field parameters can only be used with form encoding.", new Object[0]);
        L166:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.FieldMap.class) == false) goto L186;
            validateResolvableType(r11, r15);
            if (this.isFormEncoded == false) goto L184;
            Class<?> r9 = Utils.getRawType(r15);
            if (Map.class.isAssignableFrom(r9) == false) goto L182;
            Type r120 = Utils.getSupertype(r15, r9, Map.class);
            if (ZeusTransformUtils.instanceOf(r120, ParameterizedType.class) == false) goto L180;
            ParameterizedType r121 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r120, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r10 = Utils.getParameterUpperBound(0, r121);
            if (String.class != r10) goto L178;
            Converter<T, String> r122 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r121), r13);
            this.gotField = true;
            return new ParameterHandler.FieldMap(this.method, r11, r122, !((retrofit2.http.FieldMap) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.FieldMap.class, "com.obric.memorydata.plugin")).encoded());
        L178:
            throw Utils.parameterError(this.method, r11, "@FieldMap keys must be of type String: " + r10, new Object[0]);
        L180:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L182:
            throw Utils.parameterError(this.method, r11, "@FieldMap parameter type must be Map.", new Object[0]);
        L184:
            throw Utils.parameterError(this.method, r11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L186:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Part.class) == false) goto L197;
            if (this.isMultipart == false) goto L195;
            retrofit2.http.Part r123 = (retrofit2.http.Part) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.Part.class, "com.obric.memorydata.plugin");
            this.gotPart = true;
            ParameterHandler<?> r20 = partAdapt(r15, r123.value(), r123.encoding());
            if (r20 == null) goto L193;
            return r20;
        L193:
            return new ParameterHandler.Part(this.method, r11, r123.value(), this.retrofit.requestBodyConverter(r15, r13, this.methodAnnotations));
        L195:
            throw Utils.parameterError(this.method, r11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L197:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.PartMap.class) == false) goto L221;
            validateResolvableType(r11, r15);
            if (this.isMultipart == false) goto L219;
            this.gotPart = true;
            Class<?> r21 = Utils.getRawType(r15);
            if (Map.class.isAssignableFrom(r21) == false) goto L217;
            Type r124 = Utils.getSupertype(r15, r21, Map.class);
            if (ZeusTransformUtils.instanceOf(r124, ParameterizedType.class) == false) goto L215;
            ParameterizedType r125 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r124, ParameterizedType.class, "com.obric.memorydata.plugin");
            Type r22 = Utils.getParameterUpperBound(0, r125);
            if (String.class != r22) goto L213;
            Type r126 = Utils.getParameterUpperBound(1, r125);
            if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(r126)) == true) goto L211;
            return new ParameterHandler.PartMap(this.method, r11, this.retrofit.requestBodyConverter(r126, r13, this.methodAnnotations), ((retrofit2.http.PartMap) ZeusTransformUtils.preCheckCast(r16, retrofit2.http.PartMap.class, "com.obric.memorydata.plugin")).encoding());
        L211:
            throw Utils.parameterError(this.method, r11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L213:
            throw Utils.parameterError(this.method, r11, "@PartMap keys must be of type String: " + r22, new Object[0]);
        L215:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L217:
            throw Utils.parameterError(this.method, r11, "@PartMap parameter type must be Map.", new Object[0]);
        L219:
            throw Utils.parameterError(this.method, r11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L221:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Body.class) == false) goto L243;
            validateResolvableType(r11, r15);
            if (this.isFormEncoded == true) goto L241;
            if (this.isMultipart == true) goto L241;
            if (this.gotBody == true) goto L239;
            ParameterHandler<?> r127 = bodyAdapt(r15);
            if (r127 == null) goto L258;
            this.gotBody = true;
            return r127;
        L258:
            Converter<T, TypedOutput> r128 = this.retrofit.requestBodyConverter(r15, r13, this.methodAnnotations);     // Catch: RuntimeException -> L235
            this.gotBody = true;
            return new ParameterHandler.Body(this.method, r11, this.isCustomMethod, r128);
        L235:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r11, "Unable to create @Body converter for %s", new Object[]{r15});
        L239:
            throw Utils.parameterError(this.method, r11, "Multiple @Body method annotations found.", new Object[0]);
        L241:
            throw Utils.parameterError(this.method, r11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L243:
            if (ZeusTransformUtils.instanceOf(r16, retrofit2.http.Tag.class) == false) goto L256;
            validateResolvableType(r11, r15);
            Class<?> r129 = Utils.getRawType(r15);
            int r130 = r11 - 1;
        L245:
            if (r130 < 0) goto L255;
            ParameterHandler<?> r131 = this.parameterHandlers[r130];
            if (ZeusTransformUtils.instanceOf(r131, ParameterHandler.Tag.class) == false) goto L253;
            if (((ParameterHandler.Tag) ZeusTransformUtils.preCheckCast(r131, ParameterHandler.Tag.class, "com.obric.memorydata.plugin")).cls.equals(r129) == false) goto L253;
            throw Utils.parameterError(this.method, r11, "@Tag type " + r129.getName() + " is duplicate of parameter #" + (r130 + 1) + " and would always overwrite its value.", new Object[0]);
        L253:
            r130 = r130 - 1;
            goto L245
        L255:
            return new ParameterHandler.Tag(r129);
        L256:
            return null;
        }

        private ParameterHandler<?> partAdapt(Type r6, String r7, String r8) {
            Type r9 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
            Class<?> r0 = Utils.getRawType(r9);
            if (TextUtils.isEmpty(r7) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r0) == false) goto L14;
            if (ZeusTransformUtils.instanceOf(r9, ParameterizedType.class) == true) goto L10;
            return null;
        L10:
            if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r9, ParameterizedType.class, "com.obric.memorydata.plugin")))) == true) goto L12;
        L42:
            return null;
        L12:
            return ParameterHandler.ConverterRawPart.INSTANCE.iterable();
        L14:
            if (r0.isArray() == false) goto L20;
            if (MultipartBody.Part.class.isAssignableFrom(r0.getComponentType()) == false) goto L42;
            return ParameterHandler.ConverterRawPart.INSTANCE.array();
        L20:
            if (MultipartBody.Part.class.isAssignableFrom(r0) == false) goto L42;
            return ParameterHandler.ConverterRawPart.INSTANCE;
        L24:
            if (Iterable.class.isAssignableFrom(r0) == false) goto L33;
            if (ZeusTransformUtils.instanceOf(r9, ParameterizedType.class) == true) goto L29;
            return null;
        L29:
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r9, ParameterizedType.class, "com.obric.memorydata.plugin")))) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r7, r8)).iterable();
        L33:
            if (r0.isArray() == false) goto L39;
            if (RequestBody.class.isAssignableFrom(boxIfPrimitive(r0.getComponentType())) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r7, r8)).array();
        L39:
            if (RequestBody.class.isAssignableFrom(r0) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r7, r8));
        }

        private ParameterHandler<?> partMapAdapt(ParameterizedType r2, Annotation r3) {
            ParameterizedType r1 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r2, ParameterizedType.class, "com.obric.memorydata.plugin");
            Annotation r4 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.memorydata.plugin");
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(1, r1))) == true) goto L5;
            return null;
        L5:
            return new ParameterHandler.ConverterPartMap(((PartMap) ZeusTransformUtils.preCheckCast(r4, PartMap.class, "com.obric.memorydata.plugin")).encoding());
        }

        private void validateMethodName(int r8, String r9) {
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
                java.util.regex.Pattern r3 = com.bytedance.retrofit2.RequestFactory.Builder.PARAM_NAME_REGEX     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Matcher r3 = r3.matcher(r9)     // Catch: java.lang.IllegalArgumentException -> L25
                boolean r3 = r3.matches()     // Catch: java.lang.IllegalArgumentException -> L25
                if (r3 == 0) goto L10
                goto L32
            L10:
                java.lang.reflect.Method r3 = r7.method     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r4 = "@Method parameter name must match %s. Found: %s"
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Pattern r6 = com.bytedance.retrofit2.RequestFactory.Builder.PARAM_URL_REGEX     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r6 = r6.pattern()     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r1] = r6     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r0] = r9     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.RuntimeException r3 = com.bytedance.retrofit2.Utils.parameterError(r3, r8, r4, r5)     // Catch: java.lang.IllegalArgumentException -> L25
                throw r3     // Catch: java.lang.IllegalArgumentException -> L25
            L25:
                r3 = move-exception
                java.lang.String r4 = r3.getMessage()
                java.lang.String r5 = "@Method parameter name must match"
                boolean r4 = r4.contains(r5)
                if (r4 != 0) goto L4f
            L32:
                java.lang.String r3 = r7.methodParamName
                if (r3 == 0) goto L4e
                boolean r3 = r3.equals(r9)
                if (r3 == 0) goto L3d
                goto L4e
            L3d:
                java.lang.reflect.Method r3 = r7.method
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r7 = r7.httpMethod
                r2[r1] = r7
                r2[r0] = r9
                java.lang.String r7 = "Method \"%s\" does not contain \"{%s}\"."
                java.lang.RuntimeException r7 = com.bytedance.retrofit2.Utils.parameterError(r3, r8, r7, r2)
                throw r7
            L4e:
                return
            L4f:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.retrofit2.RequestFactory.Builder.validateMethodName(int, java.lang.String):void");
        }

        private void validatePathName(int r8, String r9) {
        L8:
            e = move-exception;
            if (e.getMessage().contains("@Path parameter name must match") == false) goto L12;
            throw e;
        L12:
            if (this.relativeUrlParamNames.contains(r9) == false) goto L15;
            return;
        L15:
            throw Utils.parameterError(this.method, r8, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.relativeUrl, r9});
        L4:
            if (PARAM_NAME_REGEX.matcher(r9).matches() == true) goto L12;
            throw Utils.parameterError(this.method, r8, "@Path parameter name must match %s. Found: %s", new Object[]{PARAM_URL_REGEX.pattern(), r9});     // Catch: IllegalArgumentException -> L8
        }

        private void validateResolvableType(int r3, Type r4) {
            Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
            if (Utils.hasUnresolvableType(r5) == true) goto L6;
            return;
        L6:
            throw Utils.parameterError(this.method, r3, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r5});
        }

        RequestFactory build() {
            Annotation[] r0 = this.methodAnnotations;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            Annotation r4 = r0[r3];
            parseMethodAnnotation(r4);
            if (Platform.squareRetrofitExists() == false) goto L7;
            parseSquareMethodAnnotation(r4);
        L7:
            r3 = r3 + 1;
            goto L3
        L9:
            if (this.httpMethod == null) goto L67;
            if (this.hasBody == false) goto L13;
        L23:
            int r2 = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[r2];
            int r5 = r2 - 1;
            int r6 = 0;
        L24:
            boolean r7 = true;
            if (r6 >= r2) goto L32;
            ParameterHandler<?>[] r8 = this.parameterHandlers;
            Type r9 = this.parameterTypes[r6];
            Annotation[] r10 = this.parameterAnnotationsArray[r6];
            if (r6 == r5) goto L30;
            r7 = false;
        L30:
            r8[r6] = parseParameter(r6, r9, r10, r7);
            r6 = r6 + 1;
            goto L24
        L32:
            if (this.relativeUrl == null) goto L34;
        L38:
            boolean r11 = this.isFormEncoded;
            if (r11 == false) goto L41;
        L51:
            if (r11 == false) goto L58;
            if (this.gotField == true) goto L58;
            throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
        L58:
            if (this.isMultipart == false) goto L65;
            if (this.gotPart == true) goto L65;
            throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
        L65:
            return new RequestFactory(this);
        L41:
            if (this.isMultipart == true) goto L51;
            if (this.hasBody == true) goto L51;
            if (this.isCustomMethod == true) goto L51;
            if (this.gotBody == false) goto L51;
            throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L34:
            if (this.gotUrl == true) goto L38;
            throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", new Object[]{this.httpMethod});
        L13:
            if (this.isCustomMethod == true) goto L23;
            if (this.isMultipart == true) goto L22;
            if (this.isFormEncoded == false) goto L23;
            throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L22:
            throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L67:
            throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    RequestFactory(Builder r3) {
        this.clientProvider = r3.retrofit.clientProvider();
        this.interceptors = r3.retrofit.interceptors();
        this.httpExecutor = r3.retrofit.httpExecutor();
        this.server = r3.retrofit.server();
        this.responseConverter = r3.responseConverter;
        this.httpMethod = r3.httpMethod;
        this.relativeUrl = r3.relativeUrl;
        this.hasBody = r3.hasBody;
        this.isFormEncoded = r3.isFormEncoded;
        this.isMultipart = r3.isMultipart;
        this.parameterHandlers = r3.parameterHandlers;
        this.headers = r3.headers;
        this.contentTypeHeader = r3.contentTypeHeader;
        this.priorityLevel = r3.priorityLevel;
        this.requestPriorityLevel = r3.requestPriorityLevel;
        this.serviceType = r3.serviceType;
        boolean r0 = r3.isResponseStreaming;
        this.isResponseStreaming = r0;
        this.maxLength = r3.maxLength;
        this.addCommonParam = r3.addCommonParam;
        this.commonParamLevel = r3.commonParamLevel;
        this.extraInfo = r3.extraInfo;
        this.method = r3.method;
        this.cacheServer = r3.retrofit.cacheServer();
        this.isKotlinSuspendFunction = r3.isKotlinSuspendFunction;
        RetrofitMetrics r1 = r3.retrofitMetrics;
        this.retrofitMetrics = r1;
        r1.isResponseStreaming = r0;
        this.enableRecordFormFields = r3.enableRecordFormFields;
    }

    static RequestFactory parseAnnotations(Retrofit r1, Method r2, RetrofitMetrics r3) {
        return new Builder(r1, r2, r3).build();
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public void setRetrofitMetrics(RetrofitMetrics r1) {
        this.retrofitMetrics = r1;
    }

    Request toRequest(ExpandCallback r23, Object... r24) {
        ExpandCallback<?> r2 = (ExpandCallback) ZeusTransformUtils.wrapperContextForParams(r23, ExpandCallback.class, "com.obric.memorydata.plugin");
        RequestBuilder r15 = new RequestBuilder(this.httpMethod, this.server, this.relativeUrl, this.headers, this.contentTypeHeader, this.priorityLevel, this.requestPriorityLevel, this.isResponseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.hasBody, this.isFormEncoded, this.isMultipart, this.serviceType, this.enableRecordFormFields);
        ParameterHandler<?>[] r3 = this.parameterHandlers;
        int r4 = 0;
        if (r24 == null) goto L5;
        int r5 = r24.length;
    L7:
        if (r5 != r3.length) goto L17;
        if (this.isKotlinSuspendFunction == false) goto L11;
        r5 = r5 - 1;
    L11:
        ArrayList r6 = new ArrayList(r5);
    L12:
        if (r4 >= r5) goto L14;
        r6.add(r24[r4]);
        r3[r4].apply(r15, r24[r4]);
        r4 = r4 + 1;
        goto L12
    L14:
        r15.addTag(Invocation.class, new Invocation(this.method, r6));
        return r15.build(r2);
    L17:
        throw new IllegalArgumentException("Argument count (" + r5 + ") doesn't match expected count (" + r3.length + ")");
    L5:
        r5 = 0;
        goto L7
    }

    T toResponse(TypedInput r3) {
        TypedInput r4 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r3, TypedInput.class, "com.obric.memorydata.plugin");
        return this.responseConverter.convert(r4);
    }
}
