package com.bytedance.retrofit2.client;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.OptConfig;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.Utils;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
public final class Request {
    public static final String KEY_BYPASS_DISPATCH = "x-tt-bypass-dp";
    public static final String KEY_BYPASS_OKHTTP_COOKIE = "x-metasec-bypass-okhttp-cookie";
    public static final String KEY_BYPASS_TTNET_COOKIE_HEADER = "x-ttnet-bypass-cookie";
    public static final String KEY_BYPASS_TTNET_FEATURES = "x-metasec-bypass-ttnet-features";
    private final boolean addCommonParam;
    private final TypedOutput body;
    private int commonParamLevel;
    private Object extraInfo;
    private final List<Header> headers;
    private boolean isBodyEncryptEnabled;
    private boolean isQueryEncryptEnabled;
    private final int maxLength;
    private final String method;
    private RetrofitMetrics metrics;
    private final int priorityLevel;
    private int queryFilterPriority;
    private final RequestBody requestBody;
    private final int requestPriorityLevel;
    private final boolean responseStreaming;
    private final String serviceType;
    private final Map<Class<?>, Object> tags;
    private URI uri;
    private final String url;

    public static class Builder {
        boolean addCommonParam;
        TypedOutput body;
        int commonParamLevel;
        Object extraInfo;
        List<Header> headers;
        boolean isBodyEncryptEnabled;
        boolean isQueryEncryptEnabled;
        int maxLength;
        String method;
        RetrofitMetrics metrics;
        int priorityLevel;
        RequestBody requestBody;
        int requestPriorityLevel;
        boolean responseStreaming;
        String serviceType;
        Map<Class<?>, Object> tags;
        String url;

        public Builder() {
            this.method = HttpMethodContrants.GET;
        }

        Builder(Request r3) {
            this.method = Request.access$000(r3);
            this.url = Request.access$100(r3);
            LinkedList r0 = new LinkedList();
            this.headers = r0;
            r0.addAll(Request.access$200(r3));
            this.body = Request.access$300(r3);
            this.requestBody = Request.access$400(r3);
            this.priorityLevel = Request.access$500(r3);
            this.requestPriorityLevel = Request.access$600(r3);
            this.responseStreaming = Request.access$700(r3);
            this.maxLength = Request.access$800(r3);
            this.addCommonParam = Request.access$900(r3);
            this.commonParamLevel = Request.access$1000(r3);
            this.extraInfo = Request.access$1100(r3);
            this.serviceType = Request.access$1200(r3);
            this.metrics = Request.access$1300(r3);
            this.tags = Request.access$1400(r3);
            this.isQueryEncryptEnabled = Request.access$1500(r3);
            this.isBodyEncryptEnabled = Request.access$1600(r3);
        }

        public Builder addCommonParam(boolean r1) {
            this.addCommonParam = r1;
            return this;
        }

        public Request build() {
            if (this.url == null) goto L7;
            return new Request(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public Builder delete(TypedOutput r3) {
            return method(HttpMethodContrants.DELETE, (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r3, TypedOutput.class, "com.obric.memorydata.plugin"));
        }

        public Builder get() {
            return method(HttpMethodContrants.GET, null);
        }

        public Builder head() {
            return method(HttpMethodContrants.HEAD, null);
        }

        public Builder headers(List<Header> r3) {
            this.headers = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder maxLength(int r1) {
            this.maxLength = r1;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
        public Builder method(String r3, TypedOutput r4) {
            ?? r5 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r4, TypedOutput.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r3, "method == null");
            if (r3.length() == 0) goto L17;
            if (r5 != 0) goto L6;
        L10:
            if (r5 == 0) goto L12;
        L14:
            this.method = r3;
            this.body = r5;
            return this;
        L12:
            if (Utils.requiresRequestBody(r3) == false) goto L14;
            r5 = new FormUrlEncodedTypedOutput();
            r5.addField("body", "null");
            goto L14
        L6:
            if (Utils.permitsRequestBody(r3) == true) goto L10;
            throw new IllegalArgumentException("method " + r3 + " must not have a request body.");
        L17:
            throw new IllegalArgumentException("method.length() == 0");
        }

        public Builder patch(TypedOutput r3) {
            return method(HttpMethodContrants.PATCH, (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r3, TypedOutput.class, "com.obric.memorydata.plugin"));
        }

        public Builder post(TypedOutput r3) {
            return method("POST", (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r3, TypedOutput.class, "com.obric.memorydata.plugin"));
        }

        public Builder priorityLevel(int r1) {
            this.priorityLevel = r1;
            return this;
        }

        public Builder put(TypedOutput r3) {
            return method(HttpMethodContrants.PUT, (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r3, TypedOutput.class, "com.obric.memorydata.plugin"));
        }

        public Builder requestPriorityLevel(int r1) {
            this.requestPriorityLevel = r1;
            return this;
        }

        public Builder responseStreaming(boolean r1) {
            this.responseStreaming = r1;
            return this;
        }

        public Builder serviceType(String r1) {
            this.serviceType = r1;
            return this;
        }

        public Builder setExtraInfo(Object r1) {
            this.extraInfo = r1;
            return this;
        }

        public <T> Builder tag(Class<? super T> r2, T r3) {
            Objects.requireNonNull(r2, "type == null");
            if (this.tags != null) goto L5;
            this.tags = new HashMap();
        L5:
            if (r3 != null) goto L7;
            this.tags.remove(r2);
        L8:
            return this;
        L7:
            this.tags.put(r2, r2.cast(r3));
            goto L8
        }

        public Builder tag(Object r2) {
            return tag(Object.class, r2);
        }

        public Builder url(String r2) {
            Objects.requireNonNull(r2, "url == null");
            this.url = r2;
            return this;
        }
    }

    Request(Builder r3) {
        this.queryFilterPriority = 0;
        Objects.requireNonNull(r3.url, "URL must not be null.");
        this.url = r3.url;
        Objects.requireNonNull(r3.method, "Method must not be null.");
        this.method = r3.method;
        if (r3.headers != null) goto L5;
        List<Header> r0 = Collections.emptyList();
    L6:
        this.headers = r0;
        this.body = r3.body;
        this.requestBody = r3.requestBody;
        this.priorityLevel = r3.priorityLevel;
        this.requestPriorityLevel = r3.requestPriorityLevel;
        this.responseStreaming = r3.responseStreaming;
        this.maxLength = r3.maxLength;
        this.addCommonParam = r3.addCommonParam;
        this.commonParamLevel = r3.commonParamLevel;
        this.extraInfo = r3.extraInfo;
        this.serviceType = r3.serviceType;
        this.metrics = r3.metrics;
        this.tags = r3.tags;
        this.isQueryEncryptEnabled = r3.isQueryEncryptEnabled;
        this.isBodyEncryptEnabled = r3.isBodyEncryptEnabled;
        return;
    L5:
        r0 = Collections.unmodifiableList(new ArrayList(r3.headers));
        goto L6
    }

    public Request(String r18, String r19, List<Header> r20, TypedOutput r21, int r22, boolean r23, int r24, boolean r25, Object r26) {
        this(r18, r19, (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin"), (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r21, TypedOutput.class, "com.obric.memorydata.plugin"), null, r22, 3, r23, r24, r25, 0, r26, "", null);
    }

    public Request(String r9, String r10, List<Header> r11, TypedOutput r12, RequestBody r13, int r14, int r15, boolean r16, int r17, boolean r18, int r19, Object r20, String r21, Map<Class<?>, Object> r22) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        TypedOutput r5 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r12, TypedOutput.class, "com.obric.memorydata.plugin");
        Map<Class<?>, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        this.queryFilterPriority = 0;
        Objects.requireNonNull(r9, "Method must not be null.");
        Objects.requireNonNull(r10, "URL must not be null.");
        this.method = r9;
        this.url = r10;
        if (r3 != null) goto L5;
        List<Header> r1 = Collections.emptyList();
    L6:
        this.headers = r1;
        this.body = r5;
        this.requestBody = r13;
        this.priorityLevel = r14;
        this.requestPriorityLevel = r15;
        this.responseStreaming = r16;
        this.maxLength = r17;
        this.addCommonParam = r18;
        this.commonParamLevel = r19;
        this.extraInfo = r20;
        this.serviceType = r21;
        this.tags = r4;
        return;
    L5:
        r1 = Collections.unmodifiableList(new ArrayList(r3));
        goto L6
    }

    static /* synthetic */ String access$000(Request r0) {
        return r0.method;
    }

    static /* synthetic */ String access$100(Request r0) {
        return r0.url;
    }

    static /* synthetic */ int access$1000(Request r0) {
        return r0.commonParamLevel;
    }

    static /* synthetic */ Object access$1100(Request r0) {
        return r0.extraInfo;
    }

    static /* synthetic */ String access$1200(Request r0) {
        return r0.serviceType;
    }

    static /* synthetic */ RetrofitMetrics access$1300(Request r0) {
        return r0.metrics;
    }

    static /* synthetic */ Map access$1400(Request r0) {
        return r0.tags;
    }

    static /* synthetic */ boolean access$1500(Request r0) {
        return r0.isQueryEncryptEnabled;
    }

    static /* synthetic */ boolean access$1600(Request r0) {
        return r0.isBodyEncryptEnabled;
    }

    static /* synthetic */ List access$200(Request r0) {
        return r0.headers;
    }

    static /* synthetic */ TypedOutput access$300(Request r0) {
        return r0.body;
    }

    static /* synthetic */ RequestBody access$400(Request r0) {
        return r0.requestBody;
    }

    static /* synthetic */ int access$500(Request r0) {
        return r0.priorityLevel;
    }

    static /* synthetic */ int access$600(Request r0) {
        return r0.requestPriorityLevel;
    }

    static /* synthetic */ boolean access$700(Request r0) {
        return r0.responseStreaming;
    }

    static /* synthetic */ int access$800(Request r0) {
        return r0.maxLength;
    }

    static /* synthetic */ boolean access$900(Request r0) {
        return r0.addCommonParam;
    }

    private static URI createUriWithOutQuery(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L18;
        int r0 = r2.indexOf("?");     // Catch: Exception -> L11
        if (r0 <= 0) goto L9;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L11
    L9:
        return URI.create(r2);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    private URI getUri() {
        if (OptConfig.isEnableRequestOpt() == false) goto L18;
        if (this.uri != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.uri != null) goto L10;
        this.uri = safeCreateUri(this.url);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L16:
        return this.uri;
    L18:
        return safeCreateUri(this.url);
    }

    private static URI safeCreateUri(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L17;
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r2);
    L17:
        return null;
    }

    public TypedOutput getBody() {
        RequestBody r0 = this.requestBody;
        if (r0 == null) goto L7;
        return Utils.convert(r0);
    L7:
        return this.body;
    }

    public int getCommonParamLevel() {
        return this.commonParamLevel;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public Header getFirstHeader(String r5) {
        if (r5 == null) goto L13;
        List<Header> r4 = this.headers;
        if (r4 == null) goto L13;
        Iterator<Header> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Header r1 = (Header) ZeusTransformUtils.preCheckCast(r6.next(), Header.class, "com.obric.memorydata.plugin");
        if (r5.equalsIgnoreCase(r1.getName()) == false) goto L9;
        return r1;
    L13:
        return null;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getHost() {
        URI r0 = getUri();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHost();
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public String getMethod() {
        return this.method;
    }

    public RetrofitMetrics getMetrics() {
        return this.metrics;
    }

    public String getPath() {
        URI r0 = getUri();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPath();
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public int getQueryFilterPriority() {
        return this.queryFilterPriority;
    }

    public RequestBody getRequestBody() {
        return this.requestBody;
    }

    public int getRequestPriorityLevel() {
        return this.requestPriorityLevel;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public String getUrl() {
        return this.url;
    }

    public List<Header> headers(String r5) {
        ArrayList r0 = null;
        if (r5 == null) goto L15;
        List<Header> r4 = this.headers;
        if (r4 == null) goto L15;
        Iterator<Header> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        Header r1 = (Header) ZeusTransformUtils.preCheckCast(r6.next(), Header.class, "com.obric.memorydata.plugin");
        if (r5.equalsIgnoreCase(r1.getName()) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public boolean isBodyEncryptEnabled() {
        return this.isBodyEncryptEnabled;
    }

    public boolean isBypassDispatch() {
        List<Header> r3 = headers(KEY_BYPASS_DISPATCH);
        if (r3 != null) goto L5;
    L10:
        return false;
    L5:
        if (r3.size() <= 0) goto L10;
        if ("1".equals(((Header) ZeusTransformUtils.preCheckCast(r3.get(0), Header.class, "com.obric.memorydata.plugin")).getValue()) == false) goto L10;
        return true;
    }

    public boolean isPureRequest() {
        List<Header> r3 = headers(KEY_BYPASS_TTNET_FEATURES);
        if (r3 != null) goto L5;
    L10:
        return false;
    L5:
        if (r3.size() <= 0) goto L10;
        if ("1".equals(((Header) ZeusTransformUtils.preCheckCast(r3.get(0), Header.class, "com.obric.memorydata.plugin")).getValue()) == false) goto L10;
        return true;
    }

    public boolean isQueryEncryptEnabled() {
        return this.isQueryEncryptEnabled;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public void setBodyEncryptEnabled(boolean r1) {
        this.isBodyEncryptEnabled = r1;
    }

    public void setCommonParamLevel(int r1) {
        this.commonParamLevel = r1;
    }

    public void setExtraInfo(Object r1) {
        this.extraInfo = r1;
    }

    public void setMetrics(RetrofitMetrics r1) {
        this.metrics = r1;
    }

    public void setQueryEncryptEnabled(boolean r1) {
        this.isQueryEncryptEnabled = r1;
    }

    public void setQueryFilterPriority(int r1) {
        this.queryFilterPriority = r1;
    }

    public Object tag() {
        return tag(Object.class);
    }

    public <T> T tag(Class<? extends T> r1) {
        Map<Class<?>, Object> r0 = this.tags;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r1.cast(r0.get(r1));
    }
}
