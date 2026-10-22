package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.dumper.Scraps;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.Transmitter;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0002\u0010\u0012J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\nH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", "interceptors", "", "Lokhttp3/Interceptor;", "transmitter", "Lokhttp3/internal/connection/Transmitter;", "exchange", "Lokhttp3/internal/connection/Exchange;", "index", "", Ext.KEY_REQUEST, "Lokhttp3/Request;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "connectTimeout", "readTimeout", "writeTimeout", "(Ljava/util/List;Lokhttp3/internal/connection/Transmitter;Lokhttp3/internal/connection/Exchange;ILokhttp3/Request;Lokhttp3/Call;III)V", "calls", "connectTimeoutMillis", WsConstants.KEY_CONNECTION, "Lokhttp3/Connection;", "proceed", "Lokhttp3/Response;", "readTimeoutMillis", "withConnectTimeout", LocationMonitorConst.TIMEOUT, Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "writeTimeoutMillis", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int connectTimeout;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final Request request;
    private final Transmitter transmitter;
    private final int writeTimeout;

    public RealInterceptorChain(List<? extends Interceptor> r3, Transmitter r4, Exchange r5, int r6, Request r7, Call r8, int r9, int r10, int r11) {
        List<Interceptor> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Call r13 = (Call) ZeusTransformUtils.wrapperContextForParams(r8, Call.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r12, "interceptors");
        Intrinsics.checkParameterIsNotNull(r4, "transmitter");
        Intrinsics.checkParameterIsNotNull(r7, Ext.KEY_REQUEST);
        Intrinsics.checkParameterIsNotNull(r13, NotificationCompat.CATEGORY_CALL);
        this.interceptors = r12;
        this.transmitter = r4;
        this.exchange = r5;
        this.index = r6;
        this.request = r7;
        this.call = r13;
        this.connectTimeout = r9;
        this.readTimeout = r10;
        this.writeTimeout = r11;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange r2 = this.exchange;
        if (r2 == null) goto L5;
        RealConnection r3 = r2.connection();
    L7:
        return (Connection) ZeusTransformUtils.preCheckCast(r3, Connection.class, "com.obric.memorydata.plugin");
    L5:
        r3 = null;
        goto L7
    }

    public final Exchange exchange() {
        Exchange r0 = this.exchange;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r0;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request r3) {
        Intrinsics.checkParameterIsNotNull(r3, Ext.KEY_REQUEST);
        return proceed(r3, this.transmitter, this.exchange);
    }

    public final Response proceed(Request r18, Transmitter r19, Exchange r20) {
        Intrinsics.checkParameterIsNotNull(r18, Ext.KEY_REQUEST);
        Intrinsics.checkParameterIsNotNull(r19, "transmitter");
        if (this.index >= this.interceptors.size()) goto L53;
        boolean r13 = true;
        this.calls++;
        Exchange r1 = this.exchange;
        if (r1 == null) goto L13;
        RealConnection r2 = r1.connection();
        if (r2 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        if (r2.supportsUrl(r18.url()) == true) goto L13;
        boolean r3 = false;
    L15:
        if (r3 == false) goto L51;
        if (this.exchange != null) goto L19;
    L22:
        boolean r4 = true;
    L24:
        if (r4 == false) goto L49;
        RealInterceptorChain r5 = new RealInterceptorChain(this.interceptors, r19, r20, this.index + 1, r18, this.call, this.connectTimeout, this.readTimeout, this.writeTimeout);
        Interceptor r6 = (Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index), Interceptor.class, "com.obric.memorydata.plugin");
        Response r7 = r6.intercept((Interceptor.Chain) ZeusTransformUtils.preCheckCast(r5, Interceptor.Chain.class, "com.obric.memorydata.plugin"));
        if (r7 == null) goto L47;
        if (r20 != null) goto L29;
    L34:
        boolean r0 = true;
    L35:
        if (r0 == false) goto L45;
        if (r7.body() != null) goto L40;
        r13 = false;
    L40:
        if (r13 == false) goto L43;
        return r7;
    L43:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("interceptor " + r6 + " returned a response with no body").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L45:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("network interceptor " + r6 + " must call proceed() exactly once").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L29:
        if ((this.index + 1) >= this.interceptors.size()) goto L34;
        if (r5.calls == 1) goto L34;
        r0 = false;
        goto L35
    L47:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NullPointerException("interceptor " + r6 + " returned null"), Throwable.class, "com.obric.memorydata.plugin"));
    L49:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("network interceptor " + ((Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index - 1), Interceptor.class, "com.obric.memorydata.plugin")) + " must call proceed() exactly once").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        if (this.calls <= 1) goto L22;
        r4 = false;
        goto L24
    L51:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("network interceptor " + ((Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index - 1), Interceptor.class, "com.obric.memorydata.plugin")) + " must retain the same host and port").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        r3 = true;
        goto L15
    L53:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    public final Transmitter transmitter() {
        return this.transmitter;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int r13, TimeUnit r14) {
        Intrinsics.checkParameterIsNotNull(r14, Scraps.INNER_UNIT);
        return (Interceptor.Chain) ZeusTransformUtils.preCheckCast(new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, Util.checkDuration(LocationMonitorConst.TIMEOUT, r13, r14), this.readTimeout, this.writeTimeout), Interceptor.Chain.class, "com.obric.memorydata.plugin");
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int r13, TimeUnit r14) {
        Intrinsics.checkParameterIsNotNull(r14, Scraps.INNER_UNIT);
        return (Interceptor.Chain) ZeusTransformUtils.preCheckCast(new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, Util.checkDuration(LocationMonitorConst.TIMEOUT, r13, r14), this.writeTimeout), Interceptor.Chain.class, "com.obric.memorydata.plugin");
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int r13, TimeUnit r14) {
        Intrinsics.checkParameterIsNotNull(r14, Scraps.INNER_UNIT);
        return (Interceptor.Chain) ZeusTransformUtils.preCheckCast(new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, this.readTimeout, Util.checkDuration(LocationMonitorConst.TIMEOUT, r13, r14)), Interceptor.Chain.class, "com.obric.memorydata.plugin");
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }
}
