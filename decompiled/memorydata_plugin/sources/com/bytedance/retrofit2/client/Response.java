package com.bytedance.retrofit2.client;

import com.bytedance.retrofit2.mime.TypedInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Response {
    private final TypedInput body;
    private Object extraInfo;
    private final List<Header> headers;
    private String message;
    private final String reason;
    private final int status;
    private String traceCode;
    private final String url;

    public Response(String r3, int r4, String r5, List<Header> r6, TypedInput r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        TypedInput r9 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r7, TypedInput.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L17;
        if (r4 < 200) goto L15;
        if (r5 == null) goto L13;
        if (r8 == null) goto L11;
        this.url = r3;
        this.status = r4;
        this.reason = r5;
        this.headers = Collections.unmodifiableList(new ArrayList(r8));
        this.body = r9;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException("Invalid status code: " + r4);
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public TypedInput getBody() {
        return this.body;
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

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTraceCode() {
        return this.traceCode;
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

    public boolean isSuccessful() {
        int r1 = this.status;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public String message() {
        return this.message;
    }

    public void setExtraInfo(Object r1) {
        this.extraInfo = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setTraceCode(String r1) {
        this.traceCode = r1;
    }
}
