package com.bytedance.retrofit2.client;

import ai.i0;
import ai.s0;
import bi.c;
import bi.d;
import fi.j;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class Request {
    private final boolean addCommonParam;
    private final j body;
    private Object extraInfo;
    private final List<c> headers;
    private boolean isBodyEncryptEnabled;
    private boolean isQueryEncryptEnabled;
    private final int maxLength;
    private final String method;
    private i0 metrics;
    private final int priorityLevel;
    private int queryFilterPriority;
    private final q0 requestBody;
    private final int requestPriorityLevel;
    private final boolean responseStreaming;
    private String serviceType;
    private Map<Class<?>, Object> tags;
    private final String url;

    public Request(String r15, String r16, List<c> r17, j r18, int r19, boolean r20, int r21, boolean r22, Object r23) {
        this(r15, r16, r17, r18, null, r19, 3, r20, r21, r22, r23, "", null);
    }

    public static /* synthetic */ String access$000(Request r5) {
        return r5.method;
    }

    public static /* synthetic */ String access$100(Request r5) {
        return r5.url;
    }

    public static /* synthetic */ Object access$1000(Request r5) {
        return r5.extraInfo;
    }

    public static /* synthetic */ String access$1100(Request r5) {
        return r5.serviceType;
    }

    public static /* synthetic */ i0 access$1200(Request r5) {
        return r5.metrics;
    }

    public static /* synthetic */ Map access$1300(Request r5) {
        return r5.tags;
    }

    public static /* synthetic */ boolean access$1400(Request r5) {
        return r5.isQueryEncryptEnabled;
    }

    public static /* synthetic */ boolean access$1500(Request r5) {
        return r5.isBodyEncryptEnabled;
    }

    public static /* synthetic */ List access$200(Request r5) {
        return r5.headers;
    }

    public static /* synthetic */ j access$300(Request r5) {
        return r5.body;
    }

    public static /* synthetic */ q0 access$400(Request r5) {
        return r5.requestBody;
    }

    public static /* synthetic */ int access$500(Request r5) {
        return r5.priorityLevel;
    }

    public static /* synthetic */ int access$600(Request r5) {
        return r5.requestPriorityLevel;
    }

    public static /* synthetic */ boolean access$700(Request r5) {
        return r5.responseStreaming;
    }

    public static /* synthetic */ int access$800(Request r5) {
        return r5.maxLength;
    }

    public static /* synthetic */ boolean access$900(Request r5) {
        return r5.addCommonParam;
    }

    private static URI createUriWithOutQuery(String r5) throws RuntimeException {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.isEmpty() == true) goto L19;
        int r10 = r5.indexOf("?");     // Catch: Exception -> L9
        if (r10 <= 0) goto L11;
        r5 = r5.substring(0, r10);     // Catch: Exception -> L9
    L11:
        return URI.create(r5);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L19:
        return null;
    }

    private static URI safeCreateUri(String r5) throws RuntimeException {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.isEmpty() == true) goto L17;
        return new URI(r5);
    L8:
        return URI.create(r5.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r5);
    L17:
        return null;
    }

    public j getBody() {
        q0 r5 = this.requestBody;
        if (r5 == null) goto L7;
        return new s0(r5);
    L7:
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public c getFirstHeader(String r5) {
        if (r5 == null) goto L13;
        List<c> r10 = this.headers;
        if (r10 == null) goto L13;
        Iterator<c> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        c r12 = r11.next();
        if (r5.equalsIgnoreCase(r12.f915a) == false) goto L9;
        return r12;
    L13:
        return null;
    }

    public List<c> getHeaders() {
        return this.headers;
    }

    public String getHost() {
        URI r5 = safeCreateUri(this.url);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getHost();
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public String getMethod() {
        return this.method;
    }

    public i0 getMetrics() {
        return this.metrics;
    }

    public String getPath() {
        URI r5 = safeCreateUri(this.url);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getPath();
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public int getQueryFilterPriority() {
        return this.queryFilterPriority;
    }

    public q0 getRequestBody() {
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

    public List<c> headers(String r5) {
        ArrayList r10 = null;
        if (r5 == null) goto L15;
        List<c> r11 = this.headers;
        if (r11 == null) goto L15;
        Iterator<c> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        c r13 = r12.next();
        if (r5.equalsIgnoreCase(r13.f915a) == false) goto L9;
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

    public boolean isBodyEncryptEnabled() {
        return this.isBodyEncryptEnabled;
    }

    public boolean isQueryEncryptEnabled() {
        return this.isQueryEncryptEnabled;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public d newBuilder() {
        d r5 = new d();
        r5.f927o = false;
        r5.f928p = false;
        r5.f917a = access$000(this);
        r5.f918b = access$100(this);
        LinkedList r10 = new LinkedList();
        r5.f919c = r10;
        r10.addAll(access$200(this));
        r5.d = access$300(this);
        r5.e = access$400(this);
        r5.f = access$500(this);
        r5.g = access$600(this);
        r5.f920h = access$700(this);
        r5.f921i = access$800(this);
        r5.f922j = access$900(this);
        r5.f923k = access$1000(this);
        r5.f924l = access$1100(this);
        r5.f925m = access$1200(this);
        r5.f926n = access$1300(this);
        r5.f927o = access$1400(this);
        r5.f928p = access$1500(this);
        return r5;
    }

    public void setBodyEncryptEnabled(boolean r5) {
        this.isBodyEncryptEnabled = r5;
    }

    public void setExtraInfo(Object r5) {
        this.extraInfo = r5;
    }

    public void setMetrics(i0 r5) {
        this.metrics = r5;
    }

    public void setQueryEncryptEnabled(boolean r5) {
        this.isQueryEncryptEnabled = r5;
    }

    public void setQueryFilterPriority(int r5) {
        this.queryFilterPriority = r5;
    }

    public Object tag() {
        return tag(Object.class);
    }

    public Request(String r5, String r10, List<c> r11, j r12, q0 r13, int r14, int r15, boolean r16, int r17, boolean r18, Object r19, String r110, Map<Class<?>, Object> r111) {
        this.queryFilterPriority = 0;
        this.isQueryEncryptEnabled = false;
        this.isBodyEncryptEnabled = false;
        if (r5 == null) goto L14;
        if (r10 == null) goto L12;
        this.method = r5;
        this.url = r10;
        if (r11 != null) goto L8;
        this.headers = Collections.emptyList();
    L9:
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
        this.headers = Collections.unmodifiableList(new ArrayList(r11));
        goto L9
    L12:
        throw new NullPointerException("URL must not be null.");
    L14:
        throw new NullPointerException("Method must not be null.");
    }

    public <T> T tag(Class<? extends T> r5) {
        Map<Class<?>, Object> r10 = this.tags;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r5.cast(r10.get(r5));
    }

    public Request(d r5) {
        this.queryFilterPriority = 0;
        this.isQueryEncryptEnabled = false;
        this.isBodyEncryptEnabled = false;
        String r10 = r5.f918b;
        if (r10 == null) goto L15;
        this.url = r10;
        String r11 = r5.f917a;
        if (r11 == null) goto L13;
        this.method = r11;
        if (r5.f919c != null) goto L9;
        this.headers = Collections.emptyList();
    L10:
        this.body = r5.d;
        this.requestBody = r5.e;
        this.priorityLevel = r5.f;
        this.requestPriorityLevel = r5.g;
        this.responseStreaming = r5.f920h;
        this.maxLength = r5.f921i;
        this.addCommonParam = r5.f922j;
        this.extraInfo = r5.f923k;
        this.serviceType = r5.f924l;
        this.metrics = r5.f925m;
        this.tags = r5.f926n;
        this.isQueryEncryptEnabled = r5.f927o;
        this.isBodyEncryptEnabled = r5.f928p;
        return;
    L9:
        this.headers = Collections.unmodifiableList(new ArrayList(r5.f919c));
        goto L10
    L13:
        throw new NullPointerException("Method must not be null.");
    L15:
        throw new NullPointerException("URL must not be null.");
    }
}
