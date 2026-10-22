package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import defpackage.b;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jf.e;
import we.q;
import we.r;
import we.t;
import we.u;
import we.z;

/* JADX INFO: loaded from: classes.dex */
public final class RequestBuilder {
    private static final char[] HEX_DIGITS = null;
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private boolean addCommonParam;
    private String apiUrl;
    private TypedOutput body;
    private String contentTypeHeader;
    private Object extraInfo;
    private final FormUrlEncodedTypedOutput formBody;
    private final boolean hasBody;
    private List<Header> headers;
    private int maxLength;
    private String method;
    private final MultipartTypedOutput multipartBody;
    private u.a multipartBuilder;
    private int priorityLevel;
    private String queryObjectParams;
    private StringBuilder queryParams;
    private String relativeUrl;
    private z requestBody;
    private int requestPriorityLevel;
    private boolean responseStreaming;
    private final Endpoint server;
    private String serviceType;
    private Map<Class<?>, Object> tags;
    private boolean useRequestBody;

    public static class ContentTypeOverridingRequestBody extends z {
        private final String contentType;
        private final z delegate;

        public ContentTypeOverridingRequestBody(z r8, String r10) {
            this.delegate = r8;
            this.contentType = r10;
        }

        @Override // we.z
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // we.z
        public t contentType() {
            return t.b(this.contentType);
        }

        @Override // we.z
        public void writeTo(e r8) {
            this.delegate.writeTo(r8);
        }
    }

    public static class MimeOverridingTypedOutput implements TypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        public MimeOverridingTypedOutput(TypedOutput r8, String r10) {
            this.delegate = r8;
            this.mimeType = r10;
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String fileName() {
            return this.delegate.fileName();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public long length() {
            return this.delegate.length();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String md5Stub() {
            return this.delegate.md5Stub();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String mimeType() {
            return this.mimeType;
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public void writeTo(OutputStream r8) {
            this.delegate.writeTo(r8);
        }
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public RequestBuilder(String r8, Endpoint r10, String r11, List<Header> r12, String r13, int r14, int r15, boolean r16, int r17, boolean r18, Object r19, boolean r110, boolean r111, boolean r112, String r113) {
        this.tags = new LinkedHashMap();
        this.method = r8;
        this.server = r10;
        this.relativeUrl = r11;
        this.contentTypeHeader = r13;
        this.priorityLevel = r14;
        this.requestPriorityLevel = r15;
        this.responseStreaming = r16;
        this.maxLength = r17;
        this.addCommonParam = r18;
        this.extraInfo = r19;
        this.hasBody = r110;
        this.headers = r12;
        this.serviceType = r113;
        if (r111 == false) goto L5;
        FormUrlEncodedTypedOutput r20 = new FormUrlEncodedTypedOutput();
        this.formBody = r20;
        this.multipartBody = null;
        this.body = r20;
    L9:
        this.multipartBuilder = null;
        return;
    L5:
        this.formBody = null;
        if (r112 == false) goto L8;
        MultipartTypedOutput r21 = new MultipartTypedOutput();
        this.multipartBody = r21;
        this.body = r21;
        u.a r22 = new u.a();
        this.multipartBuilder = r22;
        r22.c(u.f13264f);
        return;
    L8:
        this.multipartBody = null;
        goto L9
    }

    private StringBuilder newUrlBuilder(String r8, String r10) {
        StringBuilder r11 = new StringBuilder(r8);
        if (r8.endsWith("/") == false) goto L5;
        r11.deleteCharAt(r11.length() - 1);
    L5:
        r11.append(r10);
        return r11;
    }

    public void addFormField(String r8, String r10, boolean r11) {
        this.formBody.addField(r8, r11, r10.toString(), r11);
    }

    public void addHeader(String r8, String r10) {
        if (r8 == null) goto L13;
        if ("Content-Type".equalsIgnoreCase(r8) == false) goto L7;
        this.contentTypeHeader = r10;
        return;
    L7:
        List r11 = this.headers;
        if (r11 != null) goto L10;
        r11 = new ArrayList(2);
        this.headers = r11;
    L10:
        r11.add(new Header(r8, r10));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public void addPart(String r8, TypedOutput r10) {
        this.multipartBody.addPart(r8, r10);
    }

    public void addPathParam(String r8, String r10, boolean r11) {
        String r12 = this.relativeUrl;
        if (r12 == null) goto L20;
        if (r8 == null) goto L18;
        if (r10 == null) goto L16;
        if (r11 == false) goto L9;
        String r13 = URLEncoder.encode(r10, "UTF-8").replace("+", "%20");     // Catch: UnsupportedEncodingException -> L12
        String r14 = this.relativeUrl.replace("{" + r8 + "}", r13);     // Catch: UnsupportedEncodingException -> L12
    L10:
        this.relativeUrl = r14;     // Catch: UnsupportedEncodingException -> L12
        return;
    L9:
        r14 = r12.replace("{" + r8 + "}", r10);     // Catch: UnsupportedEncodingException -> L12
    L12:
        e = move-exception;
        throw new RuntimeException(b.e("Unable to convert path parameter \"", r8, "\" value to UTF-8:", r10), e);
    L16:
        throw new IllegalArgumentException(b.d("Path replacement \"", r8, "\" value must not be null."));
    L18:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L20:
        throw new AssertionError();
    }

    public void addQueryParam(String r8, String r10, boolean r11) {
        if (r8 == null) goto L27;
        StringBuilder r12 = this.queryParams;     // Catch: UnsupportedEncodingException -> L23
        if (r12 != null) goto L7;
        r12 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L23
        this.queryParams = r12;     // Catch: UnsupportedEncodingException -> L23
    L7:
        if (r12.length() <= 0) goto L9;
        char r13 = '&';
    L10:
        r12.append(r13);     // Catch: UnsupportedEncodingException -> L23
        if (r11 == false) goto L14;
        r8 = URLEncoder.encode(r8, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L14:
        if (r11 == false) goto L16;
        r10 = URLEncoder.encode(r10, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L16:
        if (r10 != null) goto L18;
    L21:
        r12.append(r8);     // Catch: UnsupportedEncodingException -> L23
        return;
    L18:
        if (r10.isEmpty() == true) goto L21;
        r12.append(r8);     // Catch: UnsupportedEncodingException -> L23
        r12.append('=');     // Catch: UnsupportedEncodingException -> L23
        r12.append(r10);     // Catch: UnsupportedEncodingException -> L23
        return;
    L9:
        r13 = '?';
    L23:
        e = move-exception;
        throw new RuntimeException(b.e("Unable to convert query parameter \"", r8, "\" value to UTF-8: ", r10), e);
    L27:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    public <T> void addTag(Class<? super T> r8, T r10) {
        this.tags.put(r8, r8.cast(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.retrofit2.mime.TypedOutput] */
    public Request build(ExpandCallback r15) {
        MultipartTypedOutput r8 = this.multipartBody;
        if (r8 != null) goto L5;
    L11:
        String r10 = this.server.getUrl();
        z r11 = null;
        if (Platform.squareRetrofitExists() == false) goto L107;
        r.a r12 = new r.a();     // Catch: IllegalArgumentException -> L15
        r12.b(null, r10);     // Catch: IllegalArgumentException -> L15
        r r13 = r12.a();     // Catch: IllegalArgumentException -> L15
    L17:
        if (r13 == null) goto L37;
        if (r13.e() != null) goto L21;
    L25:
        String r14 = this.relativeUrl;
        r.a r16 = new r.a();     // Catch: IllegalArgumentException -> L28
        r16.b(r13, r14);     // Catch: IllegalArgumentException -> L28
    L29:
        if (r16 == null) goto L31;
        r r17 = r16.a();
    L32:
        if (r17 == null) goto L35;
        StringBuilder r18 = new StringBuilder(r17.f13249i);
    L55:
        StringBuilder r19 = this.queryParams;
        if (r19 != null) goto L58;
    L65:
        String r20 = this.queryObjectParams;
        if (r20 == null) goto L68;
        r18.append(r20);
    L68:
        this.apiUrl = r18.toString();
        if ((r15 instanceof ExpandCallback) == false) goto L71;
        r15.onAsyncPreRequest(this);
    L71:
        TypedOutput r110 = this.body;
        List<Header> r21 = this.headers;
        z r22 = this.requestBody;
        if (this.useRequestBody == false) goto L85;
        if (r22 != null) goto L80;
        u.a r23 = this.multipartBuilder;
        if (r23 == null) goto L78;
        r22 = r23.b();
        goto L80
    L78:
        if (this.hasBody == false) goto L80;
        r22 = z.create(null, new byte[0]);
    L80:
        r11 = r22;
        TypedOutput r111 = r110;
        if (r11 == null) goto L93;
        String r24 = this.contentTypeHeader;
        r111 = r110;
        if (r24 == null) goto L93;
        z r25 = new ContentTypeOverridingRequestBody(r11, r24);
        List<Header> r26 = r21;
        ?? r112 = r110;
    L94:
        if (r112 != 0) goto L101;
        if (Utils.requiresRequestBody(this.method) == false) goto L101;
        if (this.useRequestBody == true) goto L101;
        r112 = new FormUrlEncodedTypedOutput();
        r112.addField("body", "null");
    L101:
        return new Request(this.method, this.apiUrl, r26, r112, r25, this.priorityLevel, this.requestPriorityLevel, this.responseStreaming, this.maxLength, this.addCommonParam, this.extraInfo, this.serviceType, this.tags);
    L93:
        r26 = r21;
        r25 = r11;
        r112 = r111;
        goto L94
    L85:
        String r27 = this.contentTypeHeader;
        r111 = r110;
        if (r27 == null) goto L93;
        if (r110 == null) goto L89;
        r111 = new MimeOverridingTypedOutput(r110, r27);
        goto L93
    L89:
        Header r28 = new Header("Content-Type", r27);
        if (r21 != null) goto L92;
        r21 = Collections.singletonList(r28);
        r111 = r110;
        goto L93
    L92:
        r21.add(r28);
        r111 = r110;
        goto L93
    L58:
        if ('?' != r19.charAt(0)) goto L64;
        String r29 = this.relativeUrl;
        if (r29 == null) goto L64;
        if (r29.indexOf(63) == (-1)) goto L64;
        r19.setCharAt(0, '&');
    L64:
        r18.append(r19);
        goto L65
    L35:
        throw new IllegalArgumentException("Malformed URL. Base: " + r13 + ", Relative: " + this.relativeUrl);
    L31:
        r17 = null;
    L28:
        r16 = null;
        goto L29
    L21:
        if (r13.e().length() <= 0) goto L25;
        if ("/".equals(this.relativeUrl) == false) goto L25;
    L54:
        r18 = newUrlBuilder(r10, this.relativeUrl);
        goto L55
    L37:
        throw new IllegalArgumentException("Malformed URL. Base: " + r13 + ", Relative: " + this.relativeUrl);
    L15:
        r13 = null;
        goto L17
    L107:
        URI r30 = URI.create(r10);     // Catch: Throwable -> L47
        if (r30.getPath() == null) goto L46;
        if (r30.getPath().length() < 1) goto L46;
        if ("/".equals(this.relativeUrl) == false) goto L46;
        r18 = newUrlBuilder(r10, this.relativeUrl);     // Catch: Throwable -> L47
    L106:
    L46:
        r18 = new StringBuilder(r30.resolve(this.relativeUrl).toString());     // Catch: Throwable -> L47
    L47:
        String r31 = this.relativeUrl;
        if (r31 == null) goto L54;
        if (r31.startsWith("http://") == false) goto L52;
    L53:
        r18 = new StringBuilder(this.relativeUrl);
        goto L55
    L52:
        if (this.relativeUrl.startsWith("https://") == false) goto L54;
    L5:
        if (r8.getPartCount() != 0) goto L11;
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

    public void setAddCommonParam(boolean r8) {
        this.addCommonParam = r8;
    }

    public void setApiUrl(String r8) {
        this.apiUrl = r8;
    }

    public void setBody(TypedOutput r8) {
        this.body = r8;
    }

    public void setExtraInfo(Object r8) {
        this.extraInfo = r8;
    }

    public void setHeaders(List<Header> r8) {
        this.headers = r8;
    }

    public void setMaxLength(int r8) {
        this.maxLength = r8;
    }

    public void setMethod(String r8) {
        this.method = r8;
    }

    public void setPriorityLevel(int r8) {
        this.priorityLevel = r8;
    }

    public void setQueryObjectParams(String r8) {
        this.queryObjectParams = r8;
    }

    public void setRelativeUrl(Object r8) {
        if (r8 == null) goto L6;
        this.relativeUrl = r8.toString();
        return;
    L6:
        throw new NullPointerException("@Url parameter is null.");
    }

    public void setResponseStreaming(boolean r8) {
        this.responseStreaming = r8;
    }

    public void useRequestBody() {
        this.useRequestBody = true;
    }

    public void addPart(String r8, String r10, TypedOutput r11) {
        this.multipartBody.addPart(r8, r10, r11);
    }

    public void setBody(z r8) {
        this.requestBody = r8;
    }

    public void setMethod(String r8, String r10) {
        String r11 = this.method;
        if (r11 == null) goto L7;
        this.method = r11.replace("{" + r8 + "}", r10);
        return;
    L7:
        throw new AssertionError();
    }

    public void addPart(q r8, z r10) {
        u.a r11 = this.multipartBuilder;
        r11.getClass();
        r11.a(u.b.a(r8, r10));
    }

    public void addPart(u.b r8) {
        this.multipartBuilder.a(r8);
    }
}
