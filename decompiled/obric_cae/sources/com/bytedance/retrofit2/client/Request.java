package com.bytedance.retrofit2.client;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.Utils;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import defpackage.b;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import we.z;

/* JADX INFO: loaded from: classes.dex */
public final class Request {
    private final boolean addCommonParam;
    private final TypedOutput body;
    private Object extraInfo;
    private final List<Header> headers;
    private final int maxLength;
    private final String method;
    private RetrofitMetrics metrics;
    private final int priorityLevel;
    private int queryFilterPriority;
    private final z requestBody;
    private final int requestPriorityLevel;
    private final boolean responseStreaming;
    private String serviceType;
    private Map<Class<?>, Object> tags;
    private final String url;

    public static class Builder {
        boolean addCommonParam;
        TypedOutput body;
        Object extraInfo;
        List<Header> headers;
        int maxLength;
        String method;
        RetrofitMetrics metrics;
        int priorityLevel;
        z requestBody;
        int requestPriorityLevel;
        boolean responseStreaming;
        String serviceType;
        Map<Class<?>, Object> tags;
        String url;

        public Builder() {
            this.method = HttpMethodContrants.GET;
        }

        public Request build() {
            if (this.url == null) goto L7;
            return new Request(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public Builder delete(TypedOutput r8) {
            return method(HttpMethodContrants.DELETE, r8);
        }

        public Builder get() {
            return method(HttpMethodContrants.GET, null);
        }

        public Builder head() {
            return method(HttpMethodContrants.HEAD, null);
        }

        public Builder headers(List<Header> r8) {
            this.headers = r8;
            return this;
        }

        public Builder maxLength(int r8) {
            this.maxLength = r8;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
        public Builder method(String r8, TypedOutput r10) {
            if (r8 == null) goto L20;
            if (r8.length() == 0) goto L18;
            if (r10 != 0) goto L7;
        L11:
            if (r10 == 0) goto L13;
        L15:
            this.method = r8;
            this.body = r10;
            return this;
        L13:
            if (Utils.requiresRequestBody(r8) == false) goto L15;
            r10 = new FormUrlEncodedTypedOutput();
            r10.addField("body", "null");
            goto L15
        L7:
            if (Utils.permitsRequestBody(r8) == true) goto L11;
            throw new IllegalArgumentException(b.d("method ", r8, " must not have a request body."));
        L18:
            throw new IllegalArgumentException("method.length() == 0");
        L20:
            throw new NullPointerException("method == null");
        }

        public Builder patch(TypedOutput r8) {
            return method(HttpMethodContrants.PATCH, r8);
        }

        public Builder post(TypedOutput r8) {
            return method(HttpMethodContrants.POST, r8);
        }

        public Builder priorityLevel(int r8) {
            this.priorityLevel = r8;
            return this;
        }

        public Builder put(TypedOutput r8) {
            return method(HttpMethodContrants.PUT, r8);
        }

        public Builder requestPriorityLevel(int r8) {
            this.requestPriorityLevel = r8;
            return this;
        }

        public Builder responseStreaming(boolean r8) {
            this.responseStreaming = r8;
            return this;
        }

        public Builder serviceType(String r8) {
            this.serviceType = r8;
            return this;
        }

        public Builder setExtraInfo(Object r8) {
            this.extraInfo = r8;
            return this;
        }

        public <T> Builder tag(Class<? super T> r8, T r10) {
            if (r8 == null) goto L11;
            if (this.tags != null) goto L6;
            this.tags = new HashMap();
        L6:
            if (r10 != null) goto L8;
            this.tags.remove(r8);
        L9:
            return this;
        L8:
            this.tags.put(r8, r8.cast(r10));
            goto L9
        L11:
            throw new NullPointerException("type == null");
        }

        public Builder url(String r8) {
            if (r8 == null) goto L6;
            this.url = r8;
            return this;
        L6:
            throw new NullPointerException("url == null");
        }

        public Builder(Request r8) {
            this.method = Request.access$000(r8);
            this.url = Request.access$100(r8);
            LinkedList r10 = new LinkedList();
            this.headers = r10;
            r10.addAll(Request.access$200(r8));
            this.body = Request.access$300(r8);
            this.requestBody = Request.access$400(r8);
            this.priorityLevel = Request.access$500(r8);
            this.requestPriorityLevel = Request.access$600(r8);
            this.responseStreaming = Request.access$700(r8);
            this.maxLength = Request.access$800(r8);
            this.addCommonParam = Request.access$900(r8);
            this.extraInfo = Request.access$1000(r8);
            this.serviceType = Request.access$1100(r8);
            this.metrics = Request.access$1200(r8);
            this.tags = Request.access$1300(r8);
        }

        public Builder tag(Object r8) {
            return tag(Object.class, r8);
        }
    }

    public Request(Builder r8) {
        this.queryFilterPriority = 0;
        String r10 = r8.url;
        if (r10 == null) goto L15;
        this.url = r10;
        String r11 = r8.method;
        if (r11 == null) goto L13;
        this.method = r11;
        if (r8.headers != null) goto L9;
        List<Header> r12 = Collections.emptyList();
    L10:
        this.headers = r12;
        this.body = r8.body;
        this.requestBody = r8.requestBody;
        this.priorityLevel = r8.priorityLevel;
        this.requestPriorityLevel = r8.requestPriorityLevel;
        this.responseStreaming = r8.responseStreaming;
        this.maxLength = r8.maxLength;
        this.addCommonParam = r8.addCommonParam;
        this.extraInfo = r8.extraInfo;
        this.serviceType = r8.serviceType;
        this.metrics = r8.metrics;
        this.tags = r8.tags;
        return;
    L9:
        r12 = Collections.unmodifiableList(new ArrayList(r8.headers));
        goto L10
    L13:
        throw new NullPointerException("Method must not be null.");
    L15:
        throw new NullPointerException("URL must not be null.");
    }

    public static /* synthetic */ String access$000(Request r8) {
        return r8.method;
    }

    public static /* synthetic */ String access$100(Request r8) {
        return r8.url;
    }

    public static /* synthetic */ Object access$1000(Request r8) {
        return r8.extraInfo;
    }

    public static /* synthetic */ String access$1100(Request r8) {
        return r8.serviceType;
    }

    public static /* synthetic */ RetrofitMetrics access$1200(Request r8) {
        return r8.metrics;
    }

    public static /* synthetic */ Map access$1300(Request r8) {
        return r8.tags;
    }

    public static /* synthetic */ List access$200(Request r8) {
        return r8.headers;
    }

    public static /* synthetic */ TypedOutput access$300(Request r8) {
        return r8.body;
    }

    public static /* synthetic */ z access$400(Request r8) {
        return r8.requestBody;
    }

    public static /* synthetic */ int access$500(Request r8) {
        return r8.priorityLevel;
    }

    public static /* synthetic */ int access$600(Request r8) {
        return r8.requestPriorityLevel;
    }

    public static /* synthetic */ boolean access$700(Request r8) {
        return r8.responseStreaming;
    }

    public static /* synthetic */ int access$800(Request r8) {
        return r8.maxLength;
    }

    public static /* synthetic */ boolean access$900(Request r8) {
        return r8.addCommonParam;
    }

    private static URI createUriWithOutQuery(String r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.isEmpty() == true) goto L18;
        int r10 = r8.indexOf("?");     // Catch: Exception -> L11
        if (r10 <= 0) goto L9;
        r8 = r8.substring(0, r10);     // Catch: Exception -> L11
    L9:
        return URI.create(r8);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    private static URI safeCreateUri(String r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.isEmpty() == true) goto L17;
        return new URI(r8);
    L8:
        return URI.create(r8.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r8);
    L17:
        return null;
    }

    public TypedOutput getBody() {
        z r8 = this.requestBody;
        if (r8 == null) goto L7;
        return Utils.convert(r8);
    L7:
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public Header getFirstHeader(String r8) {
        if (r8 == null) goto L13;
        List<Header> r10 = this.headers;
        if (r10 == null) goto L13;
        Iterator<Header> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        Header r12 = r11.next();
        if (r8.equalsIgnoreCase(r12.getName()) == false) goto L9;
        return r12;
    L13:
        return null;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getHost() {
        URI r8 = safeCreateUri(this.url);
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getHost();
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
        URI r8 = safeCreateUri(this.url);
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getPath();
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public int getQueryFilterPriority() {
        return this.queryFilterPriority;
    }

    public z getRequestBody() {
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

    public List<Header> headers(String r8) {
        ArrayList r10 = null;
        if (r8 == null) goto L15;
        List<Header> r11 = this.headers;
        if (r11 == null) goto L15;
        Iterator<Header> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        Header r13 = r12.next();
        if (r8.equalsIgnoreCase(r13.getName()) == false) goto L9;
        if (r10 != null) goto L14;
        r10 = new ArrayList();
    L14:
        r10.add(r13);
    L15:
        return r10;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public void setExtraInfo(Object r8) {
        this.extraInfo = r8;
    }

    public void setMetrics(RetrofitMetrics r8) {
        this.metrics = r8;
    }

    public void setQueryFilterPriority(int r8) {
        this.queryFilterPriority = r8;
    }

    public Object tag() {
        return tag(Object.class);
    }

    public Request(String r15, String r16, List<Header> r17, TypedOutput r18, int r19, boolean r20, int r21, boolean r22, Object r23) {
        this(r15, r16, r17, r18, null, r19, 3, r20, r21, r22, r23, "", null);
    }

    public <T> T tag(Class<? extends T> r8) {
        return r8.cast(this.tags.get(r8));
    }

    public Request(String r8, String r10, List<Header> r11, TypedOutput r12, z r13, int r14, int r15, boolean r16, int r17, boolean r18, Object r19, String r110, Map<Class<?>, Object> r111) {
        this.queryFilterPriority = 0;
        if (r8 == null) goto L14;
        if (r10 == null) goto L12;
        this.method = r8;
        this.url = r10;
        if (r11 != null) goto L8;
        List<Header> r20 = Collections.emptyList();
    L9:
        this.headers = r20;
        this.body = r12;
        this.requestBody = r13;
        this.priorityLevel = r14;
        this.requestPriorityLevel = r15;
        this.responseStreaming = r16;
        this.maxLength = r17;
        this.addCommonParam = r18;
        this.extraInfo = r19;
        this.serviceType = r110;
        this.tags = r111;
        return;
    L8:
        r20 = Collections.unmodifiableList(new ArrayList(r11));
        goto L9
    L12:
        throw new NullPointerException("URL must not be null.");
    L14:
        throw new NullPointerException("Method must not be null.");
    }
}
