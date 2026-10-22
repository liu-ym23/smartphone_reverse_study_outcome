package okhttp3;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Response$Builder {

    @Nullable
    ResponseBody body;

    @Nullable
    Response cacheResponse;
    int code;

    @Nullable
    j handshake;
    Headers.Builder headers;
    String message;

    @Nullable
    Response networkResponse;

    @Nullable
    Response priorResponse;

    @Nullable
    Protocol protocol;
    long receivedResponseAtMillis;

    @Nullable
    Request request;
    long sentRequestAtMillis;

    public Response build() {
        if (this.request == null) goto L19;
        if (this.protocol == null) goto L17;
        if (this.code < 0) goto L15;
        if (this.message == null) goto L13;
        return new Response(this);
    L13:
        throw new IllegalStateException("message == null");
    L15:
        throw new IllegalStateException("code < 0: " + this.code);
    L17:
        throw new IllegalStateException("protocol == null");
    L19:
        throw new IllegalStateException("request == null");
    }

    public Response$Builder() {
        this.code = -1;
        this.headers = new Headers.Builder();
    }

    public Response$Builder(Response r3) {
        this.code = -1;
        this.request = r3.request;
        this.protocol = r3.protocol;
        this.code = r3.code;
        this.message = r3.message;
        this.handshake = r3.handshake;
        this.headers = r3.headers.newBuilder();
        this.body = r3.body;
        this.networkResponse = r3.networkResponse;
        this.cacheResponse = r3.cacheResponse;
        this.priorResponse = r3.priorResponse;
        this.sentRequestAtMillis = r3.sentRequestAtMillis;
        this.receivedResponseAtMillis = r3.receivedResponseAtMillis;
    }

    private void checkPriorResponse(Response r2) {
        if (r2.body != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("priorResponse.body != null");
    }

    public Response$Builder body(@Nullable ResponseBody r1) {
        this.body = r1;
        return this;
    }

    public Response$Builder cacheResponse(@Nullable Response r2) {
        if (r2 == null) goto L4;
        checkSupportResponse("cacheResponse", r2);
    L4:
        this.cacheResponse = r2;
        return this;
    }

    public Response$Builder code(int r1) {
        this.code = r1;
        return this;
    }

    public Response$Builder handshake(@Nullable j r1) {
        this.handshake = r1;
        return this;
    }

    public Response$Builder headers(Headers r1) {
        this.headers = r1.newBuilder();
        return this;
    }

    public Response$Builder message(String r1) {
        this.message = r1;
        return this;
    }

    public Response$Builder networkResponse(@Nullable Response r2) {
        if (r2 == null) goto L4;
        checkSupportResponse("networkResponse", r2);
    L4:
        this.networkResponse = r2;
        return this;
    }

    public Response$Builder priorResponse(@Nullable Response r1) {
        if (r1 == null) goto L4;
        checkPriorResponse(r1);
    L4:
        this.priorResponse = r1;
        return this;
    }

    public Response$Builder protocol(Protocol r1) {
        this.protocol = r1;
        return this;
    }

    public Response$Builder receivedResponseAtMillis(long r1) {
        this.receivedResponseAtMillis = r1;
        return this;
    }

    public Response$Builder removeHeader(String r2) {
        this.headers.removeAll(r2);
        return this;
    }

    public Response$Builder request(Request r1) {
        this.request = r1;
        return this;
    }

    public Response$Builder sentRequestAtMillis(long r1) {
        this.sentRequestAtMillis = r1;
        return this;
    }

    private void checkSupportResponse(String r2, Response r3) {
        if (r3.body != null) goto L18;
        if (r3.networkResponse != null) goto L16;
        if (r3.cacheResponse != null) goto L14;
        if (r3.priorResponse != null) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(r2 + ".priorResponse != null");
    L14:
        throw new IllegalArgumentException(r2 + ".cacheResponse != null");
    L16:
        throw new IllegalArgumentException(r2 + ".networkResponse != null");
    L18:
        throw new IllegalArgumentException(r2 + ".body != null");
    }

    public Response$Builder addHeader(String r2, String r3) {
        this.headers.add(r2, r3);
        return this;
    }

    public Response$Builder header(String r2, String r3) {
        this.headers.set(r2, r3);
        return this;
    }
}
