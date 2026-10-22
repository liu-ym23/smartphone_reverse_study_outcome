package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.f0;
import okhttp3.g0;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.n;
import okhttp3.s0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011JM\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0018J\u001f\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0018J\u001f\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020 H\u0016¢\u0006\u0004\b\u0003\u0010!J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010'R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.R\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u0010\"R\u001a\u0010\r\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b1\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b2\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b3\u0010\u0018¨\u00064"}, d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/f0;", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "", "Lokhttp3/g0;", "interceptors", "", "index", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/Request;", "request", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "copy$okhttp", "(ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)Lokhttp3/internal/http/RealInterceptorChain;", "copy", "Lokhttp3/n;", WsConstants.KEY_CONNECTION, "()Lokhttp3/n;", "()I", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "withConnectTimeout", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/f0;", "withReadTimeout", "withWriteTimeout", "Lokhttp3/Call;", "()Lokhttp3/Call;", "()Lokhttp3/Request;", "Lokhttp3/s0;", "proceed", "(Lokhttp3/Request;)Lokhttp3/s0;", "calls", "I", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "Ljava/util/List;", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "Lokhttp3/Request;", "getRequest$okhttp", "getConnectTimeoutMillis$okhttp", "getReadTimeoutMillis$okhttp", "getWriteTimeoutMillis$okhttp", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealInterceptorChain implements f0 {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<g0> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall r5, List<? extends g0> r10, int r11, Exchange r12, Request r13, int r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "interceptors");
        Intrinsics.checkNotNullParameter(r13, "request");
        this.call = r5;
        this.interceptors = r10;
        this.index = r11;
        this.exchange = r12;
        this.request = r13;
        this.connectTimeoutMillis = r14;
        this.readTimeoutMillis = r15;
        this.writeTimeoutMillis = r16;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain r5, int r10, Exchange r11, Request r12, int r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.index;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.exchange;
    L8:
        Exchange r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.request;
    L11:
        Request r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.connectTimeoutMillis;
    L14:
        int r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.readTimeoutMillis;
    L17:
        int r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.writeTimeoutMillis;
    L20:
        int r22 = r10;
        return r5.copy$okhttp(r22, r18, r19, r20, r21, r15);
    }

    @Override // okhttp3.f0
    public Call call() {
        return this.call;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.f0
    public n connection() {
        Exchange r5 = this.exchange;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getConnection$okhttp();
    }

    public final RealInterceptorChain copy$okhttp(int r12, Exchange r13, Request r14, int r15, int r16, int r17) {
        Intrinsics.checkNotNullParameter(r14, "request");
        return new RealInterceptorChain(this.call, this.interceptors, r12, r13, r14, r15, r16, r17);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.f0
    public s0 proceed(Request r15) throws IOException {
        Intrinsics.checkNotNullParameter(r15, "request");
        boolean r5 = false;
        if (this.index >= this.interceptors.size()) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L46;
        this.calls++;
        Exchange r11 = this.exchange;
        if (r11 != null) goto L10;
    L21:
        RealInterceptorChain r16 = copy$okhttp$default(this, this.index + 1, null, r15, 0, 0, 0, 58, null);
        g0 r12 = this.interceptors.get(this.index);
        s0 r13 = r12.intercept(r16);
        if (r13 == null) goto L44;
        if (this.exchange == null) goto L37;
        if ((this.index + 1) < this.interceptors.size()) goto L28;
    L31:
        boolean r14 = true;
    L32:
        if (r14 == true) goto L37;
        throw new IllegalStateException(("network interceptor " + r12 + " must call proceed() exactly once").toString());
    L28:
        if (r16.calls == 1) goto L31;
        r14 = false;
    L37:
        if (r13.f20748h == null) goto L39;
        r5 = true;
    L39:
        if (r5 == false) goto L42;
        return r13;
    L42:
        throw new IllegalStateException(("interceptor " + r12 + " returned a response with no body").toString());
    L44:
        throw new NullPointerException("interceptor " + r12 + " returned null");
    L10:
        if (r11.getFinder$okhttp().sameHostAndPort(r15.url()) == false) goto L20;
        if (this.calls != 1) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == true) goto L21;
        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
    L14:
        r17 = false;
        goto L15
    L20:
        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
    L46:
        throw new IllegalStateException("Check failed.");
    L5:
        r10 = false;
        goto L6
    }

    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.f0
    public Request request() {
        return this.request;
    }

    public f0 withConnectTimeout(int r13, TimeUnit r14) {
        Intrinsics.checkNotNullParameter(r14, "unit");
        if (this.exchange != null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", r13, r14), 0, 0, 55, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    L5:
        r5 = false;
        goto L6
    }

    public f0 withReadTimeout(int r13, TimeUnit r14) {
        Intrinsics.checkNotNullParameter(r14, "unit");
        if (this.exchange != null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", r13, r14), 0, 47, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    L5:
        r5 = false;
        goto L6
    }

    public f0 withWriteTimeout(int r13, TimeUnit r14) {
        Intrinsics.checkNotNullParameter(r14, "unit");
        if (this.exchange != null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", r13, r14), 31, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    L5:
        r5 = false;
        goto L6
    }

    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
