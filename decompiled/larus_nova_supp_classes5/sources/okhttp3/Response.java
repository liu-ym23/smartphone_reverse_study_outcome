package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class Response implements Closeable {

    @Nullable
    final ResponseBody body;

    @Nullable
    private volatile CacheControl cacheControl;

    @Nullable
    final Response cacheResponse;
    final int code;

    @Nullable
    final j handshake;
    final Headers headers;
    final String message;

    @Nullable
    final Response networkResponse;

    @Nullable
    final Response priorResponse;
    final Protocol protocol;
    final long receivedResponseAtMillis;
    final Request request;
    final long sentRequestAtMillis;

    public CacheControl cacheControl() {
        CacheControl r0 = this.cacheControl;
        if (r0 != null) goto L7;
        CacheControl r1 = CacheControl.parse(this.headers);
        this.cacheControl = r1;
        return r1;
    L7:
        return r0;
    }

    public List<d> challenges() {
        int r1 = this.code;
        if (r1 != 401) goto L6;
        String r2 = "WWW-Authenticate";
    L8:
        Headers r3 = headers();
        ByteString r4 = evc.e.a;
        ArrayList r5 = new ArrayList();
        int r6 = 0;
    L10:
        if (r6 >= r3.size()) goto L77;
        if (r2.equalsIgnoreCase(r3.name(r6)) == false) goto L76;
        Buffer r7 = new Buffer().writeUtf8(r3.value(r6));
    L14:
        Object r8 = null;
        String r9 = null;
    L15:
        if (r9 != null) goto L19;
        evc.e.h(r7);
        r9 = evc.e.d(r7);
        if (r9 == null) goto L76;
    L19:
        boolean r10 = evc.e.h(r7);
        String r11 = evc.e.d(r7);
        if (r11 == null) goto L22;
        int r12 = evc.e.f(r7);
        boolean r13 = evc.e.h(r7);
        if (r10 == true) goto L31;
        if (r13 == true) goto L30;
        if (r7.exhausted() == false) goto L31;
    L30:
        char[] r14 = new char[r12];
        Arrays.fill(r14, '=');
        r5.add(new d(r9, Collections.singletonMap(r8, r11.concat(new String(r14)))));
    L31:
        LinkedHashMap r15 = new LinkedHashMap();
        int r16 = r12 + evc.e.f(r7);
    L32:
        if (r11 != null) goto L37;
        r11 = evc.e.d(r7);
        if (evc.e.h(r7) == true) goto L38;
        r16 = evc.e.f(r7);
    L38:
        r5.add(new d(r9, r15));
        r9 = r11;
    L37:
        if (r16 == 0) goto L38;
        if (r16 > 1) goto L76;
        if (evc.e.h(r7) == true) goto L76;
        if (r7.exhausted() == false) goto L48;
    L64:
        String r17 = r9;
        String r18 = evc.e.d(r7);
    L65:
        if (r18 == null) goto L76;
        if (((String) r15.put(r11, r18)) != null) goto L76;
        if (evc.e.h(r7) == true) goto L75;
        if (r7.exhausted() == false) goto L76;
    L75:
        r9 = r17;
        r8 = null;
        r11 = null;
        goto L32
    L48:
        if (r7.getByte(0) != 34) goto L64;
        if (r7.readByte() != 34) goto L63;
        Buffer r19 = new Buffer();
    L52:
        long r110 = r7.indexOfElement(evc.e.a);
        if (r110 == (-1)) goto L54;
        if (r7.getByte(r110) == 34) goto L57;
        r17 = r9;
        if (r7.size() == (r110 + 1)) goto L60;
        r19.write(r7, r110);
        r7.readByte();
        r19.write(r7, 1);
        r9 = r17;
    L60:
        r18 = null;
        goto L65
    L57:
        r19.write(r7, r110);
        r7.readByte();
        r18 = r19.readUtf8();
        r17 = r9;
        goto L65
    L54:
        r17 = r9;
        goto L60
    L63:
        throw new IllegalArgumentException();
    L22:
        if (r7.exhausted() == false) goto L76;
        r5.add(new d(r9, Collections.emptyMap()));
    L76:
        r6 = r6 + 1;
        goto L10
    L77:
        return r5;
    L6:
        if (r1 != 407) goto L79;
        r2 = "Proxy-Authenticate";
        goto L8
    L79:
        return Collections.emptyList();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody r0 = this.body;
        if (r0 == null) goto L7;
        r0.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public boolean isRedirect() {
        int r0 = this.code;
        if (r0 != 307) goto L5;
        return true;
    L5:
        if (r0 == 308) goto L11;
        switch(r0) {
            case 300: goto L12;
            case 301: goto L12;
            case 302: goto L12;
            case 303: goto L12;
            default: goto L7;
        };
    L7:
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    public boolean isSuccessful() {
        int r0 = this.code;
        if (r0 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= 300) goto L7;
        return true;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @Nullable
    public ResponseBody body() {
        return this.body;
    }

    @Nullable
    public Response cacheResponse() {
        return this.cacheResponse;
    }

    public int code() {
        return this.code;
    }

    @Nullable
    public j handshake() {
        return this.handshake;
    }

    public Headers headers() {
        return this.headers;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public Response networkResponse() {
        return this.networkResponse;
    }

    @Nullable
    public Response priorResponse() {
        return this.priorResponse;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public Request request() {
        return this.request;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public Response(Builder r3) {
        this.request = r3.request;
        this.protocol = r3.protocol;
        this.code = r3.code;
        this.message = r3.message;
        this.handshake = r3.handshake;
        this.headers = r3.headers.build();
        this.body = r3.body;
        this.networkResponse = r3.networkResponse;
        this.cacheResponse = r3.cacheResponse;
        this.priorResponse = r3.priorResponse;
        this.sentRequestAtMillis = r3.sentRequestAtMillis;
        this.receivedResponseAtMillis = r3.receivedResponseAtMillis;
    }

    @Nullable
    public String header(String r2) {
        return header(r2, null);
    }

    public List<String> headers(String r2) {
        return this.headers.values(r2);
    }

    public ResponseBody peekBody(long r5) throws IOException {
        BufferedSource r0 = this.body.source();
        r0.request(r5);
        Buffer r1 = r0.buffer().m539clone();
        if (r1.size() <= r5) goto L6;
        Buffer r2 = new Buffer();
        r2.write(r1, r5);
        r1.clear();
        r1 = r2;
    L6:
        return ResponseBody.create(this.body.contentType(), r1.size(), r1);
    }

    @Nullable
    public String header(String r2, @Nullable String r3) {
        String r4 = this.headers.get(r2);
        if (r4 != null) goto L5;
        return r3;
    L5:
        return r4;
    }
}
