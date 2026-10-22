package com.bytedance.retrofit2;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestBuilder {
    private boolean addCommonParam;
    private String apiUrl;
    private TypedOutput body;
    private int commonParamLevel;
    private String contentTypeHeader;
    private final boolean enableRecordFormFields;
    private Object extraInfo;
    private final FormUrlEncodedTypedOutput formBody;
    private final boolean hasBody;
    private List<Header> headers;
    private int maxLength;
    private String method;
    private final MultipartTypedOutput multipartBody;
    private final MultipartBody.Builder multipartBuilder;
    private int priorityLevel;
    private String queryObjectParams;
    private StringBuilder queryParams;
    private String relativeUrl;
    private RequestBody requestBody;
    private final int requestPriorityLevel;
    private boolean responseStreaming;
    private final Endpoint server;
    private final String serviceType;
    private final Map<Class<?>, Object> tags;
    private boolean useRequestBody;

    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final String contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody r1, String r2) {
            this.delegate = r1;
            this.contentType = r2;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return MediaType.parse(this.contentType);
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink r3) {
            BufferedSink r4 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSink.class, "com.obric.memorydata.plugin");
            this.delegate.writeTo(r4);
        }
    }

    public static class MimeOverridingTypedOutput extends AbsTypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        MimeOverridingTypedOutput(TypedOutput r3, String r4) {
            this.delegate = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r3, TypedOutput.class, "com.obric.memorydata.plugin");
            this.mimeType = r4;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public String bodyCompressType() {
            if (ZeusTransformUtils.instanceOf(this.delegate, AbsTypedOutput.class) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) ZeusTransformUtils.preCheckCast(this.delegate, AbsTypedOutput.class, "com.obric.memorydata.plugin")).bodyCompressType();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public TTRequestCompressManager.CompressData compressRequestBody(String r3, String r4, boolean r5) {
            if (ZeusTransformUtils.instanceOf(this.delegate, AbsTypedOutput.class) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) ZeusTransformUtils.preCheckCast(this.delegate, AbsTypedOutput.class, "com.obric.memorydata.plugin")).compressRequestBody(r3, r4, r5);
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String fileName() {
            return this.delegate.fileName();
        }

        public TypedOutput getDelegate() {
            return this.delegate;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public byte[] getOriginBody() {
            if (ZeusTransformUtils.instanceOf(this.delegate, AbsTypedOutput.class) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) ZeusTransformUtils.preCheckCast(this.delegate, AbsTypedOutput.class, "com.obric.memorydata.plugin")).getOriginBody();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public boolean interceptRequestBody() {
            if (ZeusTransformUtils.instanceOf(this.delegate, AbsTypedOutput.class) == true) goto L5;
            return false;
        L5:
            return ((AbsTypedOutput) ZeusTransformUtils.preCheckCast(this.delegate, AbsTypedOutput.class, "com.obric.memorydata.plugin")).interceptRequestBody();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public long length() {
            return this.delegate.length();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String md5Stub() {
            this.mBodyMd5Stub = this.delegate.md5Stub();
            return this.mBodyMd5Stub;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String mimeType() {
            return this.mimeType;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public void writeTo(OutputStream r1) {
            this.delegate.writeTo(r1);
        }
    }

    RequestBuilder(String r7, Endpoint r8, String r9, List<Header> r10, String r11, int r12, int r13, boolean r14, int r15, boolean r16, int r17, Object r18, boolean r19, boolean r20, boolean r21, String r22, boolean r23) {
        Endpoint r2 = (Endpoint) ZeusTransformUtils.wrapperContextForParams(r8, Endpoint.class, "com.obric.memorydata.plugin");
        List<Header> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        this.tags = new LinkedHashMap();
        this.method = r7;
        this.server = r2;
        this.relativeUrl = r9;
        this.contentTypeHeader = r11;
        this.priorityLevel = r12;
        this.requestPriorityLevel = r13;
        this.responseStreaming = r14;
        this.maxLength = r15;
        this.addCommonParam = r16;
        this.commonParamLevel = r17;
        this.extraInfo = r18;
        this.hasBody = r19;
        this.headers = r3;
        this.serviceType = r22;
        this.enableRecordFormFields = r23;
        if (r20 == false) goto L6;
        FormUrlEncodedTypedOutput r4 = new FormUrlEncodedTypedOutput(r23);
        this.formBody = r4;
        this.multipartBody = null;
        this.body = r4;
    L5:
        this.multipartBuilder = null;
        return;
    L6:
        this.formBody = null;
        if (r21 == false) goto L9;
        MultipartTypedOutput r1 = new MultipartTypedOutput();
        this.multipartBody = r1;
        this.body = r1;
        MultipartBody.Builder r5 = new MultipartBody.Builder();
        this.multipartBuilder = r5;
        r5.setType(MultipartBody.FORM);
        return;
    L9:
        this.multipartBody = null;
        goto L5
    }

    private StringBuilder newUrlBuilder(String r2, String r3) {
        StringBuilder r1 = new StringBuilder(r2);
        if (r2.endsWith("/") == false) goto L5;
        r1.deleteCharAt(r1.length() - 1);
    L5:
        r1.append(r3);
        return r1;
    }

    void addFormField(String r1, String r2, boolean r3) {
        this.formBody.addField(r1, r3, r2, r3);
    }

    void addHeader(String r3, String r4) {
        if (r3 == null) goto L13;
        if (NetConst.KEY_CONTENT_TYPE.equalsIgnoreCase(r3) == false) goto L7;
        this.contentTypeHeader = r4;
        return;
    L7:
        List r0 = this.headers;
        if (r0 != null) goto L10;
        r0 = new ArrayList(2);
        this.headers = r0;
    L10:
        r0.add(new Header(r3, r4));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public void addPart(String r3, TypedOutput r4) {
        TypedOutput r5 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r4, TypedOutput.class, "com.obric.memorydata.plugin");
        this.multipartBody.addPart(r3, r5);
    }

    public void addPart(String r3, String r4, TypedOutput r5) {
        TypedOutput r6 = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r5, TypedOutput.class, "com.obric.memorydata.plugin");
        this.multipartBody.addPart(r3, r4, r6);
    }

    void addPart(Headers r1, RequestBody r2) {
        this.multipartBuilder.addPart(r1, r2);
    }

    void addPart(MultipartBody.Part r1) {
        this.multipartBuilder.addPart(r1);
    }

    void addPathParam(String r5, String r6, boolean r7) {
        String r0 = this.relativeUrl;
        if (r0 == null) goto L22;
        if (r5 == null) goto L20;
        if (r6 == null) goto L18;
        if (r7 == false) goto L12;
        String r8 = this.relativeUrl.replace("{" + r5 + "}", URLEncoder.encode(String.valueOf(r6), RpcUtils.CHARSET_UTF8).replace(Marker.ANY_NON_NULL_MARKER, "%20"));     // Catch: UnsupportedEncodingException -> L10
    L9:
        this.relativeUrl = r8;     // Catch: UnsupportedEncodingException -> L10
        return;
    L12:
        r8 = r0.replace("{" + r5 + "}", String.valueOf(r6));     // Catch: UnsupportedEncodingException -> L10
    L10:
        e = move-exception;
        throw new RuntimeException("Unable to convert path parameter \"" + r5 + "\" value to UTF-8:" + r6, e);
    L18:
        throw new IllegalArgumentException("Path replacement \"" + r5 + "\" value must not be null.");
    L20:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L22:
        throw new AssertionError();
    }

    void addQueryParam(String r3, String r4, boolean r5) {
        if (r3 == null) goto L27;
        StringBuilder r0 = this.queryParams;     // Catch: UnsupportedEncodingException -> L23
        if (r0 != null) goto L7;
        r0 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L23
        this.queryParams = r0;     // Catch: UnsupportedEncodingException -> L23
    L7:
        if (r0.length() <= 0) goto L9;
        char r2 = Typography.amp;
    L10:
        r0.append(r2);     // Catch: UnsupportedEncodingException -> L23
        if (r5 == false) goto L14;
        r3 = URLEncoder.encode(r3, RpcUtils.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L23
    L14:
        if (r5 == false) goto L16;
        r4 = URLEncoder.encode(r4, RpcUtils.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L23
    L16:
        if (r4 != null) goto L18;
    L21:
        r0.append(r3);     // Catch: UnsupportedEncodingException -> L23
        return;
    L18:
        if (r4.isEmpty() == true) goto L21;
        r0.append(r3).append('=').append(r4);     // Catch: UnsupportedEncodingException -> L23
        return;
    L9:
        r2 = '?';
    L23:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r3 + "\" value to UTF-8: " + r4, e);
    L27:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    public <T> void addTag(Class<? super T> r1, T r2) {
        this.tags.put(r1, r1.cast(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.bytedance.retrofit2.RequestBuilder] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.retrofit2.mime.TypedOutput] */
    Request build(ExpandCallback<?> r18) {
        ExpandCallback r1 = (ExpandCallback) ZeusTransformUtils.wrapperContextForParams(r18, ExpandCallback.class, "com.obric.memorydata.plugin");
        MultipartTypedOutput r2 = this.multipartBody;
        if (r2 != null) goto L5;
    L11:
        ?? r3 = this.server.getUrl();
        if (Platform.squareRetrofitExists() == false) goto L95;
        HttpUrl r4 = HttpUrl.parse(r3);
        if (r4 == null) goto L28;
        if (r4.encodedPath() != null) goto L18;
    L22:
        HttpUrl r5 = r4.resolve(this.relativeUrl);
        if (r5 == null) goto L26;
        r3 = new StringBuilder(r5.toString());
    L46:
        StringBuilder r6 = this.queryParams;
        if (r6 != null) goto L49;
    L56:
        String r7 = this.queryObjectParams;
        if (r7 == null) goto L59;
        r3.append(r7);
    L59:
        this.apiUrl = r3.toString();
        if (ZeusTransformUtils.instanceOf(r1, ExpandCallback.class) == false) goto L62;
        r1.onAsyncPreRequest(this);
    L62:
        TypedOutput r8 = this.body;
        List<Header> r9 = this.headers;
        RequestBody r10 = this.requestBody;
        ContentTypeOverridingRequestBody r11 = null;
        if (this.useRequestBody == false) goto L77;
        if (r10 != null) goto L71;
        MultipartBody.Builder r12 = this.multipartBuilder;
        if (r12 == null) goto L69;
        r10 = r12.build();
        goto L71
    L69:
        if (this.hasBody == false) goto L71;
        r10 = RequestBody.create(null, new byte[0]);
    L71:
        if (r10 != null) goto L73;
    L75:
        List<Header> r13 = r9;
        RequestBody r14 = r10;
        ?? r15 = r8;
    L86:
        if (r15 != 0) goto L93;
        if (Utils.requiresRequestBody(this.method) == false) goto L93;
        if (this.useRequestBody == true) goto L93;
        r15 = new FormUrlEncodedTypedOutput();
        r15.addField("body", "null");
    L93:
        return new Request(this.method, this.apiUrl, r13, r15, r14, this.priorityLevel, this.requestPriorityLevel, this.responseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.serviceType, this.tags);
    L73:
        if (this.contentTypeHeader == null) goto L75;
        r11 = new ContentTypeOverridingRequestBody(r10, this.contentTypeHeader);
    L84:
        r13 = r9;
        TypedOutput r16 = r8;
    L85:
        r14 = r11;
        r15 = r16;
        goto L86
    L77:
        if (this.contentTypeHeader == null) goto L84;
        if (r8 == null) goto L80;
        r13 = r9;
        r16 = new MimeOverridingTypedOutput(r8, this.contentTypeHeader);
        goto L85
    L80:
        Header r17 = new Header(NetConst.KEY_CONTENT_TYPE, this.contentTypeHeader);
        if (r9 != null) goto L83;
        r9 = Collections.singletonList(r17);
        goto L84
    L83:
        r9.add(r17);
        goto L84
    L49:
        if ('?' != r6.charAt(0)) goto L55;
        String r19 = this.relativeUrl;
        if (r19 == null) goto L55;
        if (r19.indexOf(63) == (-1)) goto L55;
        r6.setCharAt(0, Typography.amp);
    L55:
        r3.append(r6);
        goto L56
    L26:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.relativeUrl);
    L18:
        if (r4.encodedPath().length() <= 0) goto L22;
        ?? r20 = r3;
        if ("/".equals(this.relativeUrl) == false) goto L22;
    L45:
        r3 = newUrlBuilder(r20, this.relativeUrl);
        goto L46
    L28:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.relativeUrl);
    L95:
        URI r21 = URI.create(r3);     // Catch: Throwable -> L38
        if (r21.getPath() == null) goto L37;
        if (r21.getPath().length() < 1) goto L37;
        if ("/".equals(this.relativeUrl) == false) goto L37;
        r3 = newUrlBuilder(r3, this.relativeUrl);     // Catch: Throwable -> L38
    L94:
    L37:
        r3 = new StringBuilder(r21.resolve(this.relativeUrl).toString());     // Catch: Throwable -> L38
    L38:
        String r22 = this.relativeUrl;
        r20 = r3;
        if (r22 == null) goto L45;
        if (r22.startsWith("http://") == true) goto L44;
        r20 = r3;
        if (this.relativeUrl.startsWith(ReportConsts.HTTPS) == false) goto L45;
    L44:
        r3 = new StringBuilder(this.relativeUrl);
        goto L46
    L5:
        if (r2.getPartCount() != 0) goto L11;
        if (this.useRequestBody == true) goto L11;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }

    public String getApiUrl() {
        return this.apiUrl;
    }

    public TypedOutput getBody() {
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getRelativeUrl() {
        return this.relativeUrl;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public void setAddCommonParam(boolean r1) {
        this.addCommonParam = r1;
    }

    public void setApiUrl(String r1) {
        this.apiUrl = r1;
    }

    public void setBody(TypedOutput r3) {
        this.body = (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r3, TypedOutput.class, "com.obric.memorydata.plugin");
    }

    void setBody(RequestBody r1) {
        this.requestBody = r1;
    }

    public void setCommonParamLevel(int r1) {
        this.commonParamLevel = r1;
    }

    public void setExtraInfo(Object r1) {
        this.extraInfo = r1;
    }

    public void setHeaders(List<Header> r3) {
        this.headers = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setMaxLength(int r1) {
        this.maxLength = r1;
    }

    public void setMethod(String r1) {
        this.method = r1;
    }

    void setMethod(String r4, String r5) {
        String r0 = this.method;
        if (r0 == null) goto L7;
        this.method = r0.replace("{" + r4 + "}", r5);
        return;
    L7:
        throw new AssertionError();
    }

    public void setPriorityLevel(int r1) {
        this.priorityLevel = r1;
    }

    void setQueryObjectParams(String r1) {
        this.queryObjectParams = r1;
    }

    void setRelativeUrl(Object r2) {
        Objects.requireNonNull(r2, "@Url parameter is null.");
        this.relativeUrl = r2.toString();
    }

    public void setResponseStreaming(boolean r1) {
        this.responseStreaming = r1;
    }

    void useRequestBody() {
        this.useRequestBody = true;
    }
}
