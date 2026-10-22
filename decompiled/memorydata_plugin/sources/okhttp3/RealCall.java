package okhttp3;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002&'B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lokhttp3/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "getClient", "()Lokhttp3/OkHttpClient;", "executed", "getExecuted", "()Z", "setExecuted", "(Z)V", "getForWebSocket", "getOriginalRequest", "()Lokhttp3/Request;", "transmitter", "Lokhttp3/internal/connection/Transmitter;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "clone", "enqueue", "responseCallback", "Lokhttp3/Callback;", "execute", "Lokhttp3/Response;", "getResponseWithInterceptorChain", "isCanceled", "isExecuted", "redactedUrl", "", Ext.KEY_REQUEST, LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "toLoggableString", "AsyncCall", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class RealCall implements Call {
    public static final Companion Companion = null;
    private final OkHttpClient client;
    private boolean executed;
    private final boolean forWebSocket;
    private final Request originalRequest;
    private Transmitter transmitter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u00020\b2\n\u0010\u0012\u001a\u00060\u0000R\u00020\fJ\b\u0010\u0013\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/RealCall;Lokhttp3/Callback;)V", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "get", "Lokhttp3/RealCall;", "host", "", Ext.KEY_REQUEST, "Lokhttp3/Request;", "reuseCallsPerHostFrom", "other", "run", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall r3, Callback r4) {
            Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "responseCallback");
            this.this$0 = r3;
            this.responseCallback = r5;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        public final void executeOn(ExecutorService r5) {
            ExecutorService r6 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r5, ExecutorService.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "executorService");
            Thread.holdsLock(this.this$0.getClient().dispatcher());
            r6.execute((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5 RejectedExecutionException -> L7
        L16:
            return;
        L7:
            e = move-exception;
            InterruptedIOException r0 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L5
            r0.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            RealCall.access$getTransmitter$p(this.this$0).noMoreExchanges((IOException) ZeusTransformUtils.preCheckCast(r0, IOException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            this.responseCallback.onFailure((Call) ZeusTransformUtils.preCheckCast(this.this$0, Call.class, "com.obric.memorydata.plugin"), (IOException) ZeusTransformUtils.preCheckCast(r0, IOException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            this.this$0.getClient().dispatcher().finished$okhttp(this);
            return;
        L5:
            th = move-exception;
            this.this$0.getClient().dispatcher().finished$okhttp(this);
            throw th;
        }

        public final RealCall get() {
            return this.this$0;
        }

        public final String host() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request request() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall r2) {
            Intrinsics.checkParameterIsNotNull(r2, "other");
            this.callsPerHost = r2.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r1 = "OkHttp " + this.this$0.redactedUrl();
            Thread r2 = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(r2, "currentThread");
            String r3 = r2.getName();
            r2.setName(r1);
            RealCall.access$getTransmitter$p(this.this$0).timeoutEnter();     // Catch: Throwable -> L25
            boolean r4 = true;
            this.responseCallback.onResponse((Call) ZeusTransformUtils.preCheckCast(this.this$0, Call.class, "com.obric.memorydata.plugin"), this.this$0.getResponseWithInterceptorChain());     // Catch: IOException -> L10 Throwable -> L12
            Dispatcher r0 = this.this$0.getClient().dispatcher();     // Catch: Throwable -> L25
        L8:
            r0.finished$okhttp(this);     // Catch: Throwable -> L25
            r2.setName(r3);
            return;
        L10:
            IOException e = e;
        L16:
            if (r4 == false) goto L18;
            Platform.Companion.get().log(4, "Callback failure for " + this.this$0.toLoggableString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        L19:
            r0 = this.this$0.getClient().dispatcher();     // Catch: Throwable -> L25
            goto L8
        L18:
            this.responseCallback.onFailure((Call) ZeusTransformUtils.preCheckCast(this.this$0, Call.class, "com.obric.memorydata.plugin"), e);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            this.this$0.getClient().dispatcher().finished$okhttp(this);     // Catch: Throwable -> L25
            throw th;     // Catch: Throwable -> L25
        L14:
            e = move-exception;
            r4 = false;
            e = e;
        L25:
            th = move-exception;
            r2.setName(r3);
            throw th;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lokhttp3/RealCall$Companion;", "", "()V", "newRealCall", "Lokhttp3/RealCall;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final RealCall newRealCall(OkHttpClient r2, Request r3, boolean r4) {
            Intrinsics.checkParameterIsNotNull(r2, "client");
            Intrinsics.checkParameterIsNotNull(r3, "originalRequest");
            RealCall r1 = new RealCall(r2, r3, r4, null);
            RealCall.access$setTransmitter$p(r1, new Transmitter(r2, (Call) ZeusTransformUtils.preCheckCast(r1, Call.class, "com.obric.memorydata.plugin")));
            return r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private RealCall(OkHttpClient r1, Request r2, boolean r3) {
        this.client = r1;
        this.originalRequest = r2;
        this.forWebSocket = r3;
    }

    public /* synthetic */ RealCall(OkHttpClient r1, Request r2, boolean r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public static final /* synthetic */ Transmitter access$getTransmitter$p(RealCall r1) {
        Transmitter r2 = r1.transmitter;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$setTransmitter$p(RealCall r0, Transmitter r1) {
        r0.transmitter = r1;
    }

    @Override // okhttp3.Call
    public void cancel() {
        Transmitter r1 = this.transmitter;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L5:
        r1.cancel();
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // okhttp3.Call
    public /* synthetic */ Call clone() {
        return (Call) ZeusTransformUtils.preCheckCast(clone(), Call.class, "com.obric.memorydata.plugin");
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return Companion.newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // okhttp3.Call
    public void enqueue(Callback r3) {
        Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "responseCallback");
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if ((!this.executed) == false) goto L14;
        this.executed = true;     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        Transmitter r1 = this.transmitter;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L11:
        r1.callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, r4));
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Already Executed".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    }

    @Override // okhttp3.Call
    public Response execute() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if ((!this.executed) == false) goto L21;
        this.executed = true;     // Catch: Throwable -> L22
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        Transmitter r1 = this.transmitter;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L10:
        r1.timeoutEnter();
        Transmitter r2 = this.transmitter;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L13:
        r2.callStart();
        this.client.dispatcher().executed$okhttp(this);     // Catch: Throwable -> L17
        Response r3 = getResponseWithInterceptorChain();     // Catch: Throwable -> L17
        this.client.dispatcher().finished$okhttp(this);
        return r3;
    L17:
        th = move-exception;
        this.client.dispatcher().finished$okhttp(this);
        throw th;
    L21:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Already Executed".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final boolean getExecuted() {
        return this.executed;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final Response getResponseWithInterceptorChain() {
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.client.interceptors(), Iterable.class, "com.obric.memorydata.plugin"));
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(new RetryAndFollowUpInterceptor(this.client));
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(new BridgeInterceptor(this.client.cookieJar()));
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(new CacheInterceptor(this.client.cache()));
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(ConnectInterceptor.INSTANCE);
        if (this.forWebSocket == true) goto L5;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.client.networkInterceptors(), Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(new CallServerInterceptor(this.forWebSocket));
        Transmitter r5 = this.transmitter;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L8:
        RealInterceptorChain r0 = new RealInterceptorChain(r4, r5, null, 0, this.originalRequest, (Call) ZeusTransformUtils.preCheckCast(this, Call.class, "com.obric.memorydata.plugin"), this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        Response r1 = r0.proceed(this.originalRequest);     // Catch: Throwable -> L21 IOException -> L23
        Transmitter r6 = this.transmitter;     // Catch: Throwable -> L21 IOException -> L23
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");     // Catch: Throwable -> L21 IOException -> L23
    L13:
        if (r6.isCanceled() == true) goto L19;
        Transmitter r13 = this.transmitter;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L17:
        r13.noMoreExchanges(null);
        return r1;
    L19:
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21 IOException -> L23
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Canceled"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21 IOException -> L23
    L23:
        e = move-exception;
        Transmitter r7 = this.transmitter;     // Catch: Throwable -> L21
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");     // Catch: Throwable -> L21
    L28:
        IOException r2 = r7.noMoreExchanges(e);     // Catch: Throwable -> L21
        if (r2 != null) goto L33;
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L21
    L33:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (0 != 0) goto L39;
        Transmitter r14 = this.transmitter;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L38:
        r14.noMoreExchanges(null);
    L39:
        throw th;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        Transmitter r1 = this.transmitter;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L6:
        return r1.isCanceled();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r0 = this.executed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    public final void setExecuted(boolean r1) {
        this.executed = r1;
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        Transmitter r1 = this.transmitter;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("transmitter");
    L6:
        return r1.timeout();
    }

    public final String toLoggableString() {
        StringBuilder r0 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r1 = "canceled ";
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.forWebSocket == false) goto L9;
        String r3 = "web socket";
    L11:
        return r2.append(r3).append(" to ").append(redactedUrl()).toString();
    L9:
        r3 = NotificationCompat.CATEGORY_CALL;
        goto L11
    L5:
        r1 = "";
        goto L6
    }
}
