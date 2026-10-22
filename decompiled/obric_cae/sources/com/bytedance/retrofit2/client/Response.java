package com.bytedance.retrofit2.client;

import com.bytedance.retrofit2.mime.TypedInput;
import defpackage.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Response {
    private final TypedInput body;
    private Object extraInfo;
    private final List<Header> headers;
    private final String reason;
    private final int status;
    private final String url;

    public Response(String r8, int r10, String r11, List<Header> r12, TypedInput r13) {
        if (r8 == null) goto L17;
        if (r10 < 200) goto L15;
        if (r11 == null) goto L13;
        if (r12 == null) goto L11;
        this.url = r8;
        this.status = r10;
        this.reason = r11;
        this.headers = Collections.unmodifiableList(new ArrayList(r12));
        this.body = r13;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException(a.d("Invalid status code: ", r10));
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public TypedInput getBody() {
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

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
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

    public boolean isSuccessful() {
        int r8 = this.status;
        if (r8 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r8 >= 300) goto L7;
        return true;
    }

    public void setExtraInfo(Object r8) {
        this.extraInfo = r8;
    }
}
