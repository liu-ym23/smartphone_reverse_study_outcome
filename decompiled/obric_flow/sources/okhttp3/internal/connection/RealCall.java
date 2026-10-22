package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.web.jsbridge2.p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nu.e;
import nu.f0;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.a;
import okhttp3.e0;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.j;
import okhttp3.k;
import okhttp3.s0;
import okhttp3.w;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b*\u0001Y\u0018\u00002\u00020\u0001:\u0002z{B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u001f\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001e\u0010\u0018J\u001d\u0010!\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0017\u0010(\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b&\u0010'J\u0015\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J;\u00105\u001a\u00028\u0000\"\n\b\u0000\u0010.*\u0004\u0018\u00010-2\u0006\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00028\u0000H\u0000¢\u0006\u0004\b3\u00104J\u001b\u00108\u001a\u0004\u0018\u00010-2\b\u00102\u001a\u0004\u0018\u00010-H\u0000¢\u0006\u0004\b6\u00107J\u0011\u0010<\u001a\u0004\u0018\u000109H\u0000¢\u0006\u0004\b:\u0010;J\r\u0010=\u001a\u00020\u0011¢\u0006\u0004\b=\u0010\u0013J\u0017\u0010A\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u0006H\u0000¢\u0006\u0004\b?\u0010@J\r\u0010B\u001a\u00020\u0006¢\u0006\u0004\bB\u0010\u0015J\u000f\u0010F\u001a\u00020CH\u0000¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020\u0011H\u0002¢\u0006\u0004\bG\u0010\u0013J#\u0010H\u001a\u00028\u0000\"\n\b\u0000\u0010.*\u0004\u0018\u00010-2\u0006\u00102\u001a\u00028\u0000H\u0002¢\u0006\u0004\bH\u00107J#\u0010J\u001a\u00028\u0000\"\n\b\u0000\u0010.*\u0004\u0018\u00010-2\u0006\u0010I\u001a\u00028\u0000H\u0002¢\u0006\u0004\bJ\u00107J\u0017\u0010N\u001a\u00020M2\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020CH\u0002¢\u0006\u0004\bP\u0010ER\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010U\u001a\u00020T8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0014\u0010\u000b\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010d\u001a\u0004\u0018\u00010)8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010e\u001a\u0004\bf\u0010gR\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010hR(\u0010i\u001a\u0004\u0018\u00010%2\b\u0010d\u001a\u0004\u0018\u00010%8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010hR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010hR\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010hR\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010hR\u0018\u0010/\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010jR$\u0010q\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010e\u001a\u0004\br\u0010g\"\u0004\bs\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010t\u001a\u0004\bu\u0010vR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010w\u001a\u0004\bx\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010h\u001a\u0004\by\u0010\u0015¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/Request;", "originalRequest", "", "forWebSocket", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "Lnu/e;", "timeout", "()Lnu/e;", "clone", "()Lokhttp3/internal/connection/RealCall;", "request", "()Lokhttp3/Request;", "", "cancel", "()V", "isCanceled", "()Z", "Lokhttp3/s0;", "execute", "()Lokhttp3/s0;", "Lokhttp3/j;", "responseCallback", "enqueue", "(Lokhttp3/j;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newExchangeFinder", "enterNetworkInterceptorExchange", "(Lokhttp3/Request;Z)V", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", WsConstants.KEY_CONNECTION, "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "exchange", "requestDone", "responseDone", "e", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "(Ljava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "", "redactedUrl$okhttp", "()Ljava/lang/String;", "redactedUrl", "callStart", "callDone", "cause", "timeoutExit", "Lokhttp3/e0;", "url", "Lokhttp3/a;", "createAddress", "(Lokhttp3/e0;)Lokhttp3/a;", "toLoggableString", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/w;", "eventListener", "Lokhttp3/w;", "getEventListener$okhttp", "()Lokhttp3/w;", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "callStackTrace", "Ljava/lang/Object;", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "Z", "interceptorScopedExchange", "Lokhttp3/internal/connection/Exchange;", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "requestBodyOpen", "responseBodyOpen", "expectMoreExchanges", "canceled", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "Lokhttp3/Request;", "getOriginalRequest", "getForWebSocket", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final w eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final AnonymousClass1 timeout;
    private boolean timeoutEarlyExit;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0000R\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\"\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/j;", "responseCallback", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/j;)V", "Lokhttp3/internal/connection/RealCall;", "other", "", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "Lokhttp3/j;", "", "getHost", "()Ljava/lang/String;", "host", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "request", "getCall", "()Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final j responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall r5, j r10) {
            Intrinsics.checkNotNullParameter(r10, "responseCallback");
            this.this$0 = r5;
            this.responseCallback = r10;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(ExecutorService r5) {
            Intrinsics.checkNotNullParameter(r5, "executorService");
            p r10 = this.this$0.getClient().f20587a;
            if (Util.assertionsEnabled == true) goto L5;
        L19:
            r5.execute(this);     // Catch: Throwable -> L11 RejectedExecutionException -> L13
        L22:
            return;
        L11:
            th = move-exception;
            this.this$0.getClient().f20587a.h(this);
            throw th;
        L13:
            e = move-exception;
            InterruptedIOException r11 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L11
            r11.initCause(e);     // Catch: Throwable -> L11
            this.this$0.noMoreExchanges$okhttp(r11);     // Catch: Throwable -> L11
            this.responseCallback.onFailure(this.this$0, r11);     // Catch: Throwable -> L11
            this.this$0.getClient().f20587a.h(this);
            return;
        L5:
            if (Thread.holdsLock(r10) == false) goto L19;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r10);
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().e;
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            this.callsPerHost = r5.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r5 = "OkHttp " + this.this$0.redactedUrl$okhttp();
            Thread r10 = Thread.currentThread();
            String r11 = r10.getName();
            r10.setName(r5);
            RealCall.access$getTimeout$p(this.this$0).enter();     // Catch: Throwable -> L11
            boolean r12 = false;
        L41:
            this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain$okhttp());     // Catch: Throwable -> L13 IOException -> L15
            p r13 = this.this$0.getClient().f20587a;     // Catch: Throwable -> L11
        L9:
            r13.h(this);     // Catch: Throwable -> L11
            r10.setName(r11);
            return;
        L15:
            e = e;
            r12 = true;
        L27:
            if (r12 == false) goto L29;
            Platform.Companion.get().log("Callback failure for " + RealCall.access$toLoggableString(this.this$0), 4, e);     // Catch: Throwable -> L24
        L30:
            r13 = this.this$0.getClient().f20587a;     // Catch: Throwable -> L11
            goto L9
        L29:
            this.responseCallback.onFailure(this.this$0, e);     // Catch: Throwable -> L24
        L13:
            th = th;
            r12 = true;
        L21:
            this.this$0.cancel();     // Catch: Throwable -> L24
            if (r12 == true) goto L26;
            IOException r14 = new IOException("canceled due to " + th);     // Catch: Throwable -> L24
            ExceptionsKt.addSuppressed(r14, th);     // Catch: Throwable -> L24
            this.responseCallback.onFailure(this.this$0, r14);     // Catch: Throwable -> L24
        L26:
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            this.this$0.getClient().f20587a.h(this);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L19:
            e = e;
        L17:
            th = th;
        L11:
            th = move-exception;
            r10.setName(r11);
            throw th;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        public CallReference(RealCall r5, Object r10) {
            Intrinsics.checkNotNullParameter(r5, "referent");
            super(r5);
            this.callStackTrace = r10;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [nu.f0, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(OkHttpClient r5, Request r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "client");
        Intrinsics.checkNotNullParameter(r10, "originalRequest");
        this.client = r5;
        this.originalRequest = r10;
        this.forWebSocket = r11;
        this.connectionPool = r5.f20588b.f20716a;
        this.eventListener = r5.e.create(this);
        ?? r12 = new AnonymousClass1(this);
        r12.timeout(r5.f20604w, TimeUnit.MILLISECONDS);
        Unit r13 = Unit.INSTANCE;
        this.timeout = r12;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public static final /* synthetic */ AnonymousClass1 access$getTimeout$p(RealCall r5) {
        return r5.timeout;
    }

    public static final /* synthetic */ String access$toLoggableString(RealCall r5) {
        return r5.toLoggableString();
    }

    private final <E extends IOException> E callDone(E r5) {
        boolean r10 = Util.assertionsEnabled;
        if (r10 == true) goto L5;
    L9:
        RealConnection r11 = this.connection;
        if (r11 == null) goto L32;
        if (r10 == true) goto L13;
    L17:
        monitor-enter(r11);
        Socket r12 = releaseConnectionNoEvents$okhttp();     // Catch: Throwable -> L29
        monitor-exit(r11);
        if (this.connection != null) goto L25;
        if (r12 == null) goto L24;
        Util.closeQuietly(r12);
    L24:
        this.eventListener.c(this, r11);
        goto L32
    L25:
        if (r12 == null) goto L32;
        throw new IllegalStateException("Check failed.");
    L29:
        th = move-exception;
        throw th;
    L13:
        if (Thread.holdsLock(r11) == false) goto L17;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r11);
    L32:
        E r13 = (E) timeoutExit(r5);
        if (r5 == null) goto L35;
        w r14 = this.eventListener;
        Intrinsics.checkNotNull(r13);
        r14.getClass();
        Intrinsics.checkNotNullParameter(this, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r13, "ioe");
    L36:
        return r13;
    L35:
        this.eventListener.getClass();
        Intrinsics.checkNotNullParameter(this, NotificationCompat.CATEGORY_CALL);
        goto L36
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.getClass();
        Intrinsics.checkNotNullParameter(this, NotificationCompat.CATEGORY_CALL);
    }

    private final a createAddress(e0 r15) {
        if (r15.f20639a == false) goto L9;
        OkHttpClient r5 = this.client;
        SSLSocketFactory r10 = r5.f20598p;
        if (r10 == null) goto L8;
        OkHostnameVerifier r11 = r5.f20601t;
        k r12 = r5.f20602u;
        SSLSocketFactory r13 = r10;
        OkHostnameVerifier r14 = r11;
    L10:
        OkHttpClient r16 = this.client;
        return new a(r15.e, r15.f, r16.f20594l, r16.f20597o, r13, r14, r12, r16.f20596n, r16.s, r16.f20600r, r16.f20595m);
    L8:
        throw new IllegalStateException("CLEARTEXT-only client");
    L9:
        r13 = null;
        r14 = null;
        r12 = null;
        goto L10
    }

    private final <E extends IOException> E timeoutExit(E r5) {
        if (this.timeoutEarlyExit == false) goto L6;
        return r5;
    L6:
        if (exit() == true) goto L8;
        return r5;
    L8:
        InterruptedIOException r10 = new InterruptedIOException("timeout");
        if (r5 == null) goto L11;
        r10.initCause(r5);
    L11:
        return r10;
    }

    private final String toLoggableString() {
        StringBuilder r5 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r10 = "canceled ";
    L6:
        r5.append(r10);
        if (this.forWebSocket == false) goto L9;
        String r11 = "web socket";
    L10:
        r5.append(r11);
        r5.append(" to ");
        r5.append(redactedUrl$okhttp());
        return r5.toString();
    L9:
        r11 = NotificationCompat.CATEGORY_CALL;
        goto L10
    L5:
        r10 = "";
        goto L6
    }

    public final void acquireConnectionNoEvents(RealConnection r5) {
        Intrinsics.checkNotNullParameter(r5, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(r5) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r5);
    L10:
        if (this.connection != null) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        this.connection = r5;
        r5.getCalls().add(new CallReference(this, this.callStackTrace));
        return;
    L17:
        throw new IllegalStateException("Check failed.");
    L12:
        r10 = false;
        goto L13
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled == false) goto L5;
        return;
    L5:
        this.canceled = true;
        Exchange r5 = this.exchange;
        if (r5 == null) goto L8;
        r5.cancel();
    L8:
        RealConnection r10 = this.connectionToCancel;
        if (r10 == null) goto L11;
        r10.cancel();
    L11:
        this.eventListener.getClass();
        Intrinsics.checkNotNullParameter(this, NotificationCompat.CATEGORY_CALL);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m1643clone();
    }

    @Override // okhttp3.Call
    public void enqueue(j r5) {
        Intrinsics.checkNotNullParameter(r5, "responseCallback");
        if (this.executed.compareAndSet(false, true) == false) goto L32;
        callStart();
        p r10 = this.client.f20587a;
        AsyncCall r11 = new AsyncCall(this, r5);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        monitor-enter(r10);
        ((ArrayDeque) r10.f6304c).add(r11);     // Catch: Throwable -> L23
        if (r11.getCall().getForWebSocket() == true) goto L25;
        String r12 = r11.getHost();     // Catch: Throwable -> L23
        Iterator r13 = ((ArrayDeque) r10.d).iterator();     // Catch: Throwable -> L23
    L10:
        if (r13.hasNext() == false) goto L14;
        AsyncCall r14 = (AsyncCall) r13.next();     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r14.getHost(), r12) == false) goto L10;
    L21:
        if (r14 == null) goto L25;
        r11.reuseCallsPerHostFrom(r14);     // Catch: Throwable -> L23
        goto L25
    L14:
        Iterator r15 = ((ArrayDeque) r10.f6304c).iterator();     // Catch: Throwable -> L23
    L16:
        if (r15.hasNext() == false) goto L20;
        r14 = (AsyncCall) r15.next();     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r14.getHost(), r12) == false) goto L16;
    L20:
        r14 = null;
    L25:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r10);
        r10.i();
        return;
    L23:
        th = move-exception;
        throw th;
    L32:
        throw new IllegalStateException("Already Executed");
    }

    public final void enterNetworkInterceptorExchange(Request r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "request");
        if (this.interceptorScopedExchange != null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L26;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.responseBodyOpen == true) goto L22;
        if (this.requestBodyOpen == true) goto L20;
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        if (r10 == false) goto L28;
        this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(r5.url()), this, this.eventListener);
        return;
    L28:
        return;
    L20:
        throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L17
    L22:
        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");     // Catch: Throwable -> L17
    L26:
        throw new IllegalStateException("Check failed.");
    L5:
        r11 = false;
        goto L6
    }

    @Override // okhttp3.Call
    public s0 execute() {
        if (this.executed.compareAndSet(false, true) == false) goto L20;
        enter();
        callStart();
        p r5 = this.client.f20587a;     // Catch: Throwable -> L12
        monitor-enter(r5);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(this, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L14
        ((ArrayDeque) r5.e).add(this);     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L12
        s0 r10 = getResponseWithInterceptorChain$okhttp();     // Catch: Throwable -> L12
        p r11 = this.client.f20587a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(this, NotificationCompat.CATEGORY_CALL);
        r11.g((ArrayDeque) r11.e, this);
        return r10;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        p r12 = this.client.f20587a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(this, NotificationCompat.CATEGORY_CALL);
        r12.g((ArrayDeque) r12.e, this);
        throw th;
    L20:
        throw new IllegalStateException("Already Executed");
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.expectMoreExchanges == false) goto L16;
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        if (r5 == false) goto L11;
        Exchange r11 = this.exchange;
        if (r11 == null) goto L11;
        r11.detachWithViolence();
    L11:
        this.interceptorScopedExchange = null;
        return;
    L16:
        throw new IllegalStateException("released");     // Catch: Throwable -> L13
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    public final w getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final s0 getResponseWithInterceptorChain$okhttp() throws IOException {
        ArrayList r5 = new ArrayList();
        CollectionsKt.a(r5, this.client.f20589c);
        r5.add(new RetryAndFollowUpInterceptor(this.client));
        r5.add(new BridgeInterceptor(this.client.f20592j));
        r5.add(new CacheInterceptor(this.client.f20593k));
        r5.add(ConnectInterceptor.INSTANCE);
        if (this.forWebSocket == true) goto L5;
        CollectionsKt.a(r5, this.client.d);
    L5:
        r5.add(new CallServerInterceptor(this.forWebSocket));
        Request r10 = this.originalRequest;
        OkHttpClient r11 = this.client;
        boolean r12 = false;
        s0 r13 = new RealInterceptorChain(this, r5, 0, null, r10, r11.f20605x, r11.f20606y, r11.f20607z).proceed(this.originalRequest);     // Catch: Throwable -> L12 IOException -> L14
        if (isCanceled() == true) goto L10;
        noMoreExchanges$okhttp(null);
        return r13;
    L10:
        Util.closeQuietly(r13);     // Catch: Throwable -> L12 IOException -> L14
        throw new IOException("Canceled");     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = move-exception;
        IOException r14 = noMoreExchanges$okhttp(e);     // Catch: Throwable -> L20
        if (r14 == null) goto L19;
        throw r14;     // Catch: Throwable -> L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th = th;
        r12 = true;
    L23:
        if (r12 == true) goto L25;
        noMoreExchanges$okhttp(null);
    L25:
        throw th;
    L12:
        th = th;
        goto L23
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain r5) {
        Intrinsics.checkNotNullParameter(r5, "chain");
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.expectMoreExchanges == false) goto L32;
        if (this.responseBodyOpen == true) goto L30;
        if (this.requestBodyOpen == true) goto L28;
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(this);
        ExchangeFinder r11 = this.exchangeFinder;
        Intrinsics.checkNotNull(r11);
        ExchangeCodec r12 = r11.find(this.client, r5);
        Exchange r13 = new Exchange(this, this.eventListener, r11, r12);
        this.interceptorScopedExchange = r13;
        this.exchange = r13;
        monitor-enter(this);
        this.requestBodyOpen = true;     // Catch: Throwable -> L22
        this.responseBodyOpen = true;     // Catch: Throwable -> L22
        monitor-exit(this);
        if (this.canceled == true) goto L21;
        return r13;
    L21:
        throw new IOException("Canceled");
    L22:
        th = move-exception;
        throw th;
    L28:
        throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L25
    L30:
        throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L25
    L32:
        throw new IllegalStateException("released");     // Catch: Throwable -> L25
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    public final <E extends IOException> E messageDone$okhttp(Exchange r5, boolean r10, boolean r11, E r12) {
        Intrinsics.checkNotNullParameter(r5, "exchange");
        if (Intrinsics.areEqual(r5, this.exchange) == true) goto L5;
        return r12;
    L5:
        monitor-enter(this);
        boolean r13 = false;
        if (r10 == true) goto L46;
    L13:
        if (r11 == true) goto L15;
    L33:
        boolean r14 = false;
    L34:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        if (r13 == false) goto L40;
        this.exchange = null;
        RealConnection r16 = this.connection;
        if (r16 == null) goto L40;
        r16.incrementSuccessCount$okhttp();
    L40:
        if (r14 == true) goto L42;
        return r12;
    L42:
        return (E) callDone(r12);
    L11:
        th = move-exception;
        throw th;
    L15:
        if (this.responseBodyOpen == false) goto L33;
    L16:
        if (r10 == false) goto L18;
        this.requestBodyOpen = false;     // Catch: Throwable -> L11
    L18:
        if (r11 == false) goto L20;
        this.responseBodyOpen = false;     // Catch: Throwable -> L11
    L20:
        boolean r17 = this.requestBodyOpen;     // Catch: Throwable -> L11
        if (r17 == false) goto L23;
    L25:
        boolean r18 = false;
    L26:
        if (r17 == false) goto L28;
    L32:
        r14 = r13;
        r13 = r18;
        goto L34
    L28:
        if (this.responseBodyOpen == true) goto L32;
        if (this.expectMoreExchanges == true) goto L32;
        r13 = true;
        goto L32
    L23:
        if (this.responseBodyOpen == true) goto L25;
        r18 = true;
        goto L26
    L46:
        if (this.requestBodyOpen == true) goto L16;
        goto L16
    }

    public final IOException noMoreExchanges$okhttp(IOException r5) {
        monitor-enter(this);
        boolean r10 = false;
        if (this.expectMoreExchanges == false) goto L12;
        this.expectMoreExchanges = false;     // Catch: Throwable -> L10
        if (this.requestBodyOpen == true) goto L12;
        if (this.responseBodyOpen == true) goto L12;
        r10 = true;
    L12:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r10 == true) goto L16;
        return r5;
    L16:
        return callDone(r5);
    L10:
        th = move-exception;
        throw th;
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().i();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection r5 = this.connection;
        Intrinsics.checkNotNull(r5);
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        List<Reference<RealCall>> r10 = r5.getCalls();
        Iterator<Reference<RealCall>> r11 = r10.iterator();
        boolean r12 = false;
        int r13 = 0;
    L11:
        if (r11.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(r11.next().get(), this) == true) goto L17;
        r13 = r13 + 1;
    L17:
        if (r13 == (-1)) goto L19;
        r12 = true;
    L19:
        if (r12 == false) goto L28;
        r10.remove(r13);
        this.connection = null;
        if (r10.isEmpty() == false) goto L26;
        r5.setIdleAtNs$okhttp(System.nanoTime());
        if (this.connectionPool.connectionBecameIdle(r5) == false) goto L26;
        return r5.socket();
    L26:
        return null;
    L28:
        throw new IllegalStateException("Check failed.");
    L16:
        r13 = -1;
        goto L17
    L5:
        if (Thread.holdsLock(r5) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r5);
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder r5 = this.exchangeFinder;
        Intrinsics.checkNotNull(r5);
        return r5.retryAfterFailure();
    }

    public final void setConnectionToCancel(RealConnection r5) {
        this.connectionToCancel = r5;
    }

    @Override // okhttp3.Call
    public /* bridge */ /* synthetic */ f0 timeout() {
        return timeout();
    }

    public final void timeoutEarlyExit() {
        if (this.timeoutEarlyExit == true) goto L7;
        this.timeoutEarlyExit = true;
        exit();
        return;
    L7:
        throw new IllegalStateException("Check failed.");
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Call m1642clone() {
        return m1643clone();
    }

    @Override // okhttp3.Call
    public e timeout() {
        return this.timeout;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public RealCall m1643clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
