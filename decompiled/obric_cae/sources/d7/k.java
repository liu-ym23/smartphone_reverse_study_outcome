package d7;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import we.a0;
import we.w;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class k extends we.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final we.o f6867b;

    public k(we.o r8, l r10) {
        this.f6867b = r8;
        this.f6866a = r10;
    }

    public static int a(IOException r8) {
        if ((r8 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r8 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r8 instanceof SSLProtocolException) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if ((r8 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r8 instanceof UnknownHostException) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if ((r8 instanceof ConnectException) == false) goto L21;
        return NetError.ERR_CONNECTION_FAILED;
    L21:
        if ((r8 instanceof PortUnreachableException) == false) goto L24;
        return NetError.ERR_ADDRESS_INVALID;
    L24:
        if ((r8 instanceof NoRouteToHostException) == false) goto L27;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L27:
        if ((r8 instanceof BindException) == false) goto L30;
        return NetError.ERR_ADDRESS_IN_USE;
    L30:
        if ((r8 instanceof MalformedURLException) == false) goto L33;
        return NetError.ERR_INVALID_URL;
    L33:
        if ((r8 instanceof SocketTimeoutException) == false) goto L36;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L36:
        if ((r8 instanceof ProtocolException) == false) goto L39;
    L47:
        return -1;
    L39:
        if ((r8 instanceof HttpRetryException) == true) goto L47;
        if ((r8 instanceof UnknownServiceException) == true) goto L47;
        if ("java.io.IOException: Exception in connect".equals(r8.getMessage()) == false) goto L47;
        return -15;
    }

    @Override // we.o
    public final void callEnd(we.d r8) {
        super.callEnd(r8);
        we.o r10 = this.f6867b;
        if (r10 == null) goto L5;
        r10.callEnd(r8);
    L5:
        long r11 = System.currentTimeMillis();
        l r12 = this.f6866a;
        r12.f6882o = r11;
        r12.J = d.f6851a;
        r12.M = s.f6936b;
    }

    @Override // we.o
    public final void callFailed(we.d r8, IOException r10) {
        super.callFailed(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.callFailed(r8, r10);
    L5:
        long r12 = System.currentTimeMillis();
        l r13 = this.f6866a;
        r13.f6882o = r12;
        r13.J = d.f6851a;
        if ("Canceled".equals(r10.getMessage()) == false) goto L8;
        s r14 = s.f6938n;
    L9:
        r13.M = r14;
        r13.L = a(r10);
        return;
    L8:
        r14 = s.f6939o;
        goto L9
    }

    @Override // we.o
    public final void callStart(we.d r8) {
        super.callStart(r8);
        we.o r10 = this.f6867b;
        if (r10 == null) goto L5;
        r10.callStart(r8);
    L5:
        long r11 = System.currentTimeMillis();
        l r12 = this.f6866a;
        r12.f6868a = r11;
        r12.M = s.f6937m;
    }

    @Override // we.o
    public final void connectEnd(we.d r8, InetSocketAddress r10, Proxy r11, w r12) {
        super.connectEnd(r8, r10, r11, r12);
        we.o r13 = this.f6867b;
        if (r13 == null) goto L5;
        r13.connectEnd(r8, r10, r11, r12);
    L5:
        System.currentTimeMillis();
        l r14 = this.f6866a;
        r14.getClass();
        if (r11 == null) goto L9;
        r14.f6886s = r11.type();
        return;
    }

    @Override // we.o
    public final void connectFailed(we.d r8, InetSocketAddress r10, Proxy r11, w r12, IOException r13) {
        super.connectFailed(r8, r10, r11, r12, r13);
        we.o r14 = this.f6867b;
        if (r14 == null) goto L5;
        r14.connectFailed(r8, r10, r11, r12, r13);
    L5:
        if (r10 == null) goto L8;
        this.f6866a.f6885r.add(new Pair(r10, Integer.valueOf(a(r13))));
        return;
    }

    @Override // we.o
    public final void connectStart(we.d r8, InetSocketAddress r10, Proxy r11) {
        super.connectStart(r8, r10, r11);
        we.o r12 = this.f6867b;
        if (r12 == null) goto L5;
        r12.connectStart(r8, r10, r11);
    L5:
        long r13 = System.currentTimeMillis();
        l r14 = this.f6866a;
        r14.f6871d = r13;
        r14.J = d.f6853m;
    }

    @Override // we.o
    public final void connectionAcquired(we.d r8, we.h r10) {
        super.connectionAcquired(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.connectionAcquired(r8, r10);
    L5:
        l r12 = this.f6866a;
        if (r10 == null) goto L15;
        ze.d r13 = (ze.d) r10;
        Socket r14 = r13.f14376e;
        if (r14 != null) goto L10;
    L14:
        r12.E = r13.f14376e;
        goto L15
    L10:
        if (r14.getInetAddress() == null) goto L14;
        if (r13.f14376e.getInetAddress().getHostAddress() == null) goto L14;
        r12.D = r13.f14376e.getInetAddress().getHostAddress();
    L15:
        r12.f6883p = System.currentTimeMillis();
    }

    @Override // we.o
    public final void connectionReleased(we.d r8, we.h r10) {
        super.connectionReleased(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L6;
        r11.connectionReleased(r8, r10);
        return;
    }

    @Override // we.o
    public final void dnsEnd(we.d r8, String r10, List<InetAddress> r11) {
        super.dnsEnd(r8, r10, r11);
        we.o r12 = this.f6867b;
        if (r12 == null) goto L5;
        r12.dnsEnd(r8, r10, r11);
    L5:
        l r13 = this.f6866a;
        r13.f6870c = System.currentTimeMillis();
    }

    @Override // we.o
    public final void dnsStart(we.d r8, String r10) {
        super.dnsStart(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.dnsStart(r8, r10);
    L5:
        long r12 = System.currentTimeMillis();
        l r13 = this.f6866a;
        r13.f6869b = r12;
        r13.J = d.f6852b;
    }

    @Override // we.o
    public final void requestBodyEnd(we.d r8, long r10) {
        super.requestBodyEnd(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.requestBodyEnd(r8, r10);
    L5:
        long r12 = System.currentTimeMillis();
        l r13 = this.f6866a;
        r13.f6877j = r12;
        r13.f6890w = r10;
    }

    @Override // we.o
    public final void requestBodyStart(we.d r8) {
        super.requestBodyStart(r8);
        we.o r10 = this.f6867b;
        if (r10 == null) goto L5;
        r10.requestBodyStart(r8);
    L5:
        l r11 = this.f6866a;
        r11.f6876i = System.currentTimeMillis();
    }

    @Override // we.o
    public final void requestHeadersEnd(we.d r8, y r10) {
        super.requestHeadersEnd(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.requestHeadersEnd(r8, r10);
    L5:
        long r12 = System.currentTimeMillis();
        l r13 = this.f6866a;
        r13.f6875h = r12;
        if (r10 == null) goto L8;
        r13.f6891x = r10.f13340d;
    L8:
        r13.J = d.f6856p;
    }

    @Override // we.o
    public final void requestHeadersStart(we.d r8) {
        super.requestHeadersStart(r8);
        we.o r10 = this.f6867b;
        if (r10 == null) goto L5;
        r10.requestHeadersStart(r8);
    L5:
        d r11 = d.f6855o;
        l r12 = this.f6866a;
        r12.J = r11;
        r12.f6874g = System.currentTimeMillis();
    }

    @Override // we.o
    public final void responseBodyEnd(we.d r8, long r10) {
        super.responseBodyEnd(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.responseBodyEnd(r8, r10);
    L5:
        long r12 = System.currentTimeMillis();
        l r13 = this.f6866a;
        r13.f6881n = r12;
        r13.f6893z = r10;
    }

    @Override // we.o
    public final void responseBodyStart(we.d r8) {
        super.responseBodyStart(r8);
        we.o r10 = this.f6867b;
        if (r10 == null) goto L5;
        r10.responseBodyStart(r8);
    L5:
        d r11 = d.f6857q;
        l r12 = this.f6866a;
        r12.J = r11;
        r12.f6880m = System.currentTimeMillis();
    }

    @Override // we.o
    public final void responseHeadersEnd(we.d r8, a0 r10) {
        super.responseHeadersEnd(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.responseHeadersEnd(r8, r10);
    L5:
        long r12 = System.currentTimeMillis();
        l r13 = this.f6866a;
        r13.f6879l = r12;
        if (r13.f6873f == (-1)) goto L8;
        c r14 = c.f6849m;
    L9:
        r13.f6887t = r14;
        if (r10 != null) goto L12;
        return;
    L12:
        int r15 = r10.f13116m;
        r13.f6892y = r15;
        r13.A = r10.f13115b;
        we.p r16 = r10.f13118o;
        if (r16 == null) goto L16;
        r13.f6888u = r16.f13234a;
        r13.f6889v = r16.f13235b;
    L16:
        if (r15 != 307) goto L18;
        boolean r17 = true;
    L22:
        if (r17 == false) goto L28;
        r13.H++;
        n r18 = new n();
        r18.f6894a = r15;
        r18.f6895b = r10.f13114a.f13339c;
        String r19 = r10.n(LocationMonitorConst.LOCATION);
        if (TextUtils.isEmpty(r19) == true) goto L26;
        r18.f6896c = r19;
    L26:
        r13.I.add(r18);
    L28:
        if (r10.r() == false) goto L32;
        String r20 = r10.n("content-type");
        if (TextUtils.isEmpty(r20) == true) goto L32;
        r13.G = r20;
    L32:
        r13.F = r10.f13119p;
        return;
    L18:
        if (r15 == 308) goto L34;
        switch(r15) {
            case 300: goto L35;
            case 301: goto L35;
            case 302: goto L35;
            case 303: goto L35;
            default: goto L20;
        };
    L20:
        r17 = false;
        goto L22
    L35:
        r17 = true;
        goto L22
    L34:
        r17 = true;
        goto L22
    L8:
        r14 = c.f6848b;
        goto L9
    }

    @Override // we.o
    public final void responseHeadersStart(we.d r8) {
        super.responseHeadersStart(r8);
        we.o r10 = this.f6867b;
        if (r10 == null) goto L5;
        r10.responseHeadersStart(r8);
    L5:
        l r11 = this.f6866a;
        r11.f6878k = System.currentTimeMillis();
    }

    @Override // we.o
    public final void secureConnectEnd(we.d r8, we.p r10) {
        super.secureConnectEnd(r8, r10);
        we.o r11 = this.f6867b;
        if (r11 == null) goto L5;
        r11.secureConnectEnd(r8, r10);
    L5:
        l r12 = this.f6866a;
        r12.f6873f = System.currentTimeMillis();
    }

    @Override // we.o
    public final void secureConnectStart(we.d r8) {
        super.secureConnectStart(r8);
        we.o r10 = this.f6867b;
        if (r10 == null) goto L5;
        r10.secureConnectStart(r8);
    L5:
        long r11 = System.currentTimeMillis();
        l r12 = this.f6866a;
        r12.f6872e = r11;
        r12.J = d.f6854n;
    }
}
