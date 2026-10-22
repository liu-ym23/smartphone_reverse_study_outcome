package okhttp3;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001FB{\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b+J\r\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\b,J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\b-J\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\b\u00101\u001a\u000202H\u0016J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b3J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\b4J\u001e\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00106\u001a\u00020\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007H\u0007J\r\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\b8J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070/2\u0006\u00106\u001a\u00020\u0007J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b9J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\b:J\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0014J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0002\b?J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b@J\r\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0002\bAJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\bBJ\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0007H\u0016J\u0006\u0010E\u001a\u00020\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001dR\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010 R\u0013\u0010\f\u001a\u00020\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u0011\u0010%\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001dR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001dR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010(R\u0013\u0010\u0015\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010)R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010*R\u0013\u0010\u0013\u001a\u00020\u00148\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010)¨\u0006G"}, d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "protocol", "Lokhttp3/Protocol;", "message", "", "code", "", "handshake", "Lokhttp3/Handshake;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/ResponseBody;", "networkResponse", "cacheResponse", "priorResponse", "sentRequestAtMillis", "", "receivedResponseAtMillis", "exchange", "Lokhttp3/internal/connection/Exchange;", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "()Lokhttp3/ResponseBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Response;", "()I", "()Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/Handshake;", "()Lokhttp3/Headers;", "isRedirect", "", "()Z", "isSuccessful", "lazyCacheControl", "()Ljava/lang/String;", "()Lokhttp3/Protocol;", "()J", "()Lokhttp3/Request;", "-deprecated_body", "-deprecated_cacheControl", "-deprecated_cacheResponse", "challenges", "", "Lokhttp3/Challenge;", IslandSession.REOPEN_VALUE_CLOSE, "", "-deprecated_code", "-deprecated_handshake", "header", ActivityLifecycle.NAME, "defaultValue", "-deprecated_headers", "-deprecated_message", "-deprecated_networkResponse", "newBuilder", "Lokhttp3/Response$Builder;", "peekBody", "byteCount", "-deprecated_priorResponse", "-deprecated_protocol", "-deprecated_receivedResponseAtMillis", "-deprecated_request", "-deprecated_sentRequestAtMillis", "toString", "trailers", "Builder", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020)H\u0016J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010M\u001a\u00020N2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010O\u001a\u00020N2\u0006\u0010J\u001a\u00020)2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010P\u001a\u00020\u00002\u0006\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020)H\u0016J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020QH\u0016J\u0015\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020\u0017H\u0000¢\u0006\u0002\bTJ\u0010\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010.\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00101\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000205H\u0016J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010U\u001a\u00020\u00002\u0006\u0010J\u001a\u00020)H\u0016J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020;H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0005R\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0005R\u001c\u00104\u001a\u0004\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?¨\u0006V"}, d2 = {"Lokhttp3/Response$Builder;", "", "()V", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "body", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "cacheResponse", "getCacheResponse$okhttp", "()Lokhttp3/Response;", "setCacheResponse$okhttp", "code", "", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "handshake", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "message", "", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "networkResponse", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "priorResponse", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "protocol", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "receivedResponseAtMillis", "", "getReceivedResponseAtMillis$okhttp", "()J", "setReceivedResponseAtMillis$okhttp", "(J)V", Ext.KEY_REQUEST, "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "sentRequestAtMillis", "getSentRequestAtMillis$okhttp", "setSentRequestAtMillis$okhttp", "addHeader", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "build", "checkPriorResponse", "", "checkSupportResponse", "header", "Lokhttp3/Headers;", "initExchange", "deferredTrailers", "initExchange$okhttp", "removeHeader", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        public Builder(Response r3) {
            Intrinsics.checkParameterIsNotNull(r3, ChatMessage.TYPE_RESPONSE);
            this.code = -1;
            this.request = r3.request();
            this.protocol = r3.protocol();
            this.code = r3.code();
            this.message = r3.message();
            this.handshake = r3.handshake();
            this.headers = r3.headers().newBuilder();
            this.body = r3.body();
            this.networkResponse = r3.networkResponse();
            this.cacheResponse = r3.cacheResponse();
            this.priorResponse = r3.priorResponse();
            this.sentRequestAtMillis = r3.sentRequestAtMillis();
            this.receivedResponseAtMillis = r3.receivedResponseAtMillis();
            this.exchange = r3.exchange();
        }

        private final void checkPriorResponse(Response r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (r2.body() != null) goto L6;
            boolean r1 = true;
        L7:
            if (r1 == false) goto L10;
            return;
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("priorResponse.body != null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L6:
            r1 = false;
            goto L7
        }

        private final void checkSupportResponse(String r4, Response r5) {
            if (r5 == null) goto L33;
            boolean r0 = true;
            if (r5.body() != null) goto L6;
            boolean r3 = true;
        L8:
            if (r3 == false) goto L32;
            if (r5.networkResponse() != null) goto L12;
            boolean r6 = true;
        L13:
            if (r6 == false) goto L30;
            if (r5.cacheResponse() != null) goto L17;
            boolean r7 = true;
        L18:
            if (r7 == false) goto L28;
            if (r5.priorResponse() == null) goto L23;
            r0 = false;
        L23:
            if (r0 == false) goto L26;
            return;
        L26:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((r4 + ".priorResponse != null").toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L28:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((r4 + ".cacheResponse != null").toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L17:
            r7 = false;
            goto L18
        L30:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((r4 + ".networkResponse != null").toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L12:
            r6 = false;
            goto L13
        L32:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((r4 + ".body != null").toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L6:
            r3 = false;
            goto L8
        }

        public Builder addHeader(String r4, String r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).headers.add(r4, r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder body(ResponseBody r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).body = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Response build() {
            int r4 = this.code;
            if (r4 < 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == false) goto L23;
            Request r2 = this.request;
            if (r2 == null) goto L21;
            Protocol r3 = this.protocol;
            if (r3 == null) goto L19;
            String r5 = this.message;
            if (r5 == null) goto L17;
            return new Response(r2, r3, r5, r4, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("message == null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L19:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("protocol == null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L21:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("request == null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L23:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("code < 0: " + this.code).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r1 = false;
            goto L7
        }

        public Builder cacheResponse(Response r5) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.checkSupportResponse("cacheResponse", r5);
            r2.cacheResponse = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder code(int r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).code = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public Builder handshake(Handshake r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).handshake = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder header(String r4, String r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).headers.set(r4, r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder headers(Headers r4) {
            Intrinsics.checkParameterIsNotNull(r4, "headers");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.headers = r4.newBuilder();
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final void initExchange$okhttp(Exchange r2) {
            Intrinsics.checkParameterIsNotNull(r2, "deferredTrailers");
            this.exchange = r2;
        }

        public Builder message(String r4) {
            Intrinsics.checkParameterIsNotNull(r4, "message");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).message = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder networkResponse(Response r5) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.checkSupportResponse("networkResponse", r5);
            r2.networkResponse = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder priorResponse(Response r4) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.checkPriorResponse(r4);
            r2.priorResponse = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder protocol(Protocol r4) {
            Intrinsics.checkParameterIsNotNull(r4, "protocol");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).protocol = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder receivedResponseAtMillis(long r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).receivedResponseAtMillis = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder removeHeader(String r4) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).headers.removeAll(r4);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder request(Request r4) {
            Intrinsics.checkParameterIsNotNull(r4, Ext.KEY_REQUEST);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).request = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder sentRequestAtMillis(long r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).sentRequestAtMillis = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final void setBody$okhttp(ResponseBody r1) {
            this.body = r1;
        }

        public final void setCacheResponse$okhttp(Response r1) {
            this.cacheResponse = r1;
        }

        public final void setCode$okhttp(int r1) {
            this.code = r1;
        }

        public final void setExchange$okhttp(Exchange r1) {
            this.exchange = r1;
        }

        public final void setHandshake$okhttp(Handshake r1) {
            this.handshake = r1;
        }

        public final void setHeaders$okhttp(Headers.Builder r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.headers = r2;
        }

        public final void setMessage$okhttp(String r1) {
            this.message = r1;
        }

        public final void setNetworkResponse$okhttp(Response r1) {
            this.networkResponse = r1;
        }

        public final void setPriorResponse$okhttp(Response r1) {
            this.priorResponse = r1;
        }

        public final void setProtocol$okhttp(Protocol r1) {
            this.protocol = r1;
        }

        public final void setReceivedResponseAtMillis$okhttp(long r1) {
            this.receivedResponseAtMillis = r1;
        }

        public final void setRequest$okhttp(Request r1) {
            this.request = r1;
        }

        public final void setSentRequestAtMillis$okhttp(long r1) {
            this.sentRequestAtMillis = r1;
        }
    }

    public Response(Request r7, Protocol r8, String r9, int r10, Handshake r11, Headers r12, ResponseBody r13, Response r14, Response r15, Response r16, long r17, long r19, Exchange r21) {
        Intrinsics.checkParameterIsNotNull(r7, Ext.KEY_REQUEST);
        Intrinsics.checkParameterIsNotNull(r8, "protocol");
        Intrinsics.checkParameterIsNotNull(r9, "message");
        Intrinsics.checkParameterIsNotNull(r12, "headers");
        this.request = r7;
        this.protocol = r8;
        this.message = r9;
        this.code = r10;
        this.handshake = r11;
        this.headers = r12;
        this.body = r13;
        this.networkResponse = r14;
        this.cacheResponse = r15;
        this.priorResponse = r16;
        this.sentRequestAtMillis = r17;
        this.receivedResponseAtMillis = r19;
        this.exchange = r21;
    }

    public static /* synthetic */ String header$default(Response r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L6:
        return r0.header(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final ResponseBody m3030deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m3031deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheResponse", imports = {}))
    /* JADX INFO: renamed from: -deprecated_cacheResponse, reason: not valid java name */
    public final Response m3032deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "code", imports = {}))
    /* JADX INFO: renamed from: -deprecated_code, reason: not valid java name */
    public final int m3033deprecated_code() {
        return this.code;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "handshake", imports = {}))
    /* JADX INFO: renamed from: -deprecated_handshake, reason: not valid java name */
    public final Handshake m3034deprecated_handshake() {
        return this.handshake;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m3035deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "message", imports = {}))
    /* JADX INFO: renamed from: -deprecated_message, reason: not valid java name */
    public final String m3036deprecated_message() {
        return this.message;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkResponse", imports = {}))
    /* JADX INFO: renamed from: -deprecated_networkResponse, reason: not valid java name */
    public final Response m3037deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "priorResponse", imports = {}))
    /* JADX INFO: renamed from: -deprecated_priorResponse, reason: not valid java name */
    public final Response m3038deprecated_priorResponse() {
        return this.priorResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocol", imports = {}))
    /* JADX INFO: renamed from: -deprecated_protocol, reason: not valid java name */
    public final Protocol m3039deprecated_protocol() {
        return this.protocol;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "receivedResponseAtMillis", imports = {}))
    /* JADX INFO: renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name */
    public final long m3040deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = Ext.KEY_REQUEST, imports = {}))
    /* JADX INFO: renamed from: -deprecated_request, reason: not valid java name */
    public final Request m3041deprecated_request() {
        return this.request;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sentRequestAtMillis", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name */
    public final long m3042deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final ResponseBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl r0 = this.lazyCacheControl;
        if (r0 != null) goto L6;
        CacheControl r1 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = r1;
        return r1;
    L6:
        return r0;
    }

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        Headers r0 = this.headers;
        int r2 = this.code;
        if (r2 != 401) goto L5;
        String r3 = "WWW-Authenticate";
    L11:
        return HttpHeaders.parseChallenges(r0, r3);
    L5:
        if (r2 != 407) goto L7;
        r3 = "Proxy-Authenticate";
        goto L11
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody r2 = this.body;
        if (r2 == null) goto L7;
        r2.close();
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("response is not eligible for a body and must not be closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final int code() {
        return this.code;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final String header(String r3) {
        return header$default(this, r3, null, 2, null);
    }

    public final String header(String r2, String r3) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        String r1 = this.headers.get(r2);
        if (r1 != null) goto L5;
        return r3;
    L5:
        return r1;
    }

    public final List<String> headers(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        return this.headers.values(r2);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int r1 = this.code;
        if (r1 != 307) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 308) goto L8;
        switch(r1) {
            case 300: goto L8;
            case 301: goto L8;
            case 302: goto L8;
            case 303: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    }

    public final boolean isSuccessful() {
        int r1 = this.code;
        if (200 <= r1) goto L6;
    L8:
        return false;
    L6:
        if (299 < r1) goto L8;
        return true;
    }

    public final String message() {
        return this.message;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long r7) {
        ResponseBody r0 = this.body;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        BufferedSource r1 = r0.source().peek();
        Buffer r2 = new Buffer();
        r1.request(r7);
        r2.write((Source) ZeusTransformUtils.preCheckCast(r1, Source.class, "com.obric.memorydata.plugin"), Math.min(r7, r1.getBuffer().size()));
        return ResponseBody.Companion.create((BufferedSource) ZeusTransformUtils.preCheckCast(r2, BufferedSource.class, "com.obric.memorydata.plugin"), this.body.contentType(), r2.size());
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public final Headers trailers() {
        Exchange r2 = this.exchange;
        if (r2 == null) goto L7;
        return r2.trailers();
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("trailers not available".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
