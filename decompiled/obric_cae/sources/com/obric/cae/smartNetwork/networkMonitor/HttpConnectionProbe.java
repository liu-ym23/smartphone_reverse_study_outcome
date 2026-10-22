package com.obric.cae.smartNetwork.networkMonitor;

import android.net.Network;
import android.os.SystemClock;
import androidx.emoji2.text.g;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.SocketFactory;
import we.a0;
import we.d;
import we.n;
import we.o;
import we.p;
import we.r;
import we.v;
import we.w;
import we.x;
import we.y;
import xe.c;

/* JADX INFO: loaded from: classes2.dex */
public class HttpConnectionProbe {
    private static final boolean DEBUG = true;
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.32 Safari/537.36";
    public static final int ERROR_CODE_HTTP_PROBE_ENFORCE_TIMEOUT = 5;
    public static final int ERROR_CODE_HTTP_PROBE_SOCKET_TIMEOUT = 4;
    public static final int ERROR_CODE_HTTP_PROBE_UNKNOWN_HOST = 3;
    public static final int ERROR_CODE_HTTP_PROBE_URL_INVALID = 2;
    public static final int ERROR_CODE_NETWORK_NOT_AVAILABLE = 1;
    public static final int ERROR_CODE_UNKNOWN = 0;
    public static final int FAILED_RESPONSE_CODE = 599;
    private static final int HTTP_PROBE_ENFORCE_TIMEOUT_MILLIS = 10000;
    private static final int HTTP_PROBE_SOCKET_TIMEOUT_MILLIS = 8000;
    public static final int SUCCESS_RESPONSE_CODE_200 = 200;
    public static final int SUCCESS_RESPONSE_CODE_204 = 204;
    private static final String TAG = "CaeNetworkMonitor";
    private final Network mNetwork;
    private String mUrl;
    private final ExecutorService probeExecutor;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkMonitor.HttpConnectionProbe$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface HttpProbeListener {
        default void onProbeFailure(int r8, int r10) {
        }

        default void onProbePortal(int r8, String r10) {
        }

        default void onProbeSuccess(int r8, int r10) {
        }

        default void onProbeFailure(int r8, int r10, int r11, HttpProbeTiming r12) {
            onProbeFailure(r8, r10);
        }

        default void onProbePortal(int r8, String r10, int r11, HttpProbeTiming r12) {
            onProbePortal(r8, r10);
        }

        default void onProbeSuccess(int r8, int r10, HttpProbeTiming r11) {
            onProbeSuccess(r8, r10);
        }
    }

    public static class HttpProbeTiming {
        private int connectTimeMs;
        private int dnsTimeMs;
        private long mCallStart;
        private long mConnectStart;
        private long mDnsStart;
        private long mRequestHeadersEnd;
        private long mTlsStart;
        private int tlsTimeMs;
        private int totalTimeMs;
        private int ttfbDurationMs;

        public HttpProbeTiming() {
        }

        public static /* synthetic */ void access$000(HttpProbeTiming r8) {
            r8.finishIfNeeded();
        }

        public static /* synthetic */ void access$1100(HttpProbeTiming r8) {
            r8.markTlsStart();
        }

        public static /* synthetic */ void access$1200(HttpProbeTiming r8) {
            r8.markTlsEnd();
        }

        public static /* synthetic */ void access$1300(HttpProbeTiming r8) {
            r8.markConnectEnd();
        }

        public static /* synthetic */ void access$1400(HttpProbeTiming r8) {
            r8.markRequestHeadersEnd();
        }

        public static /* synthetic */ void access$1500(HttpProbeTiming r8) {
            r8.markResponseHeadersEnd();
        }

        public static /* synthetic */ void access$500(HttpProbeTiming r8) {
            r8.markCallStart();
        }

        public static /* synthetic */ void access$600(HttpProbeTiming r8) {
            r8.markDnsStart();
        }

        public static /* synthetic */ void access$700(HttpProbeTiming r8) {
            r8.markDnsEnd();
        }

        public static /* synthetic */ void access$800(HttpProbeTiming r8) {
            r8.markConnectStart();
        }

        private static int elapsed(long r8, long r10) {
            if (r8 > 0) goto L5;
            return 0;
        L5:
            if (r10 >= r8) goto L8;
            return 0;
        L8:
            return (int) (r10 - r8);
        }

        private void finishIfNeeded() {
            if (this.totalTimeMs == 0) goto L5;
            return;
        L5:
            if (this.mCallStart <= 0) goto L9;
            this.totalTimeMs = (int) (SystemClock.elapsedRealtime() - this.mCallStart);
            return;
        }

        private void markCallStart() {
            this.mCallStart = SystemClock.elapsedRealtime();
        }

        private void markConnectEnd() {
            long r8 = this.mConnectStart;
            if (r8 <= 0) goto L6;
            this.connectTimeMs += elapsed(r8, SystemClock.elapsedRealtime());
            this.mConnectStart = 0;
            return;
        }

        private void markConnectStart() {
            this.mConnectStart = SystemClock.elapsedRealtime();
        }

        private void markDnsEnd() {
            this.dnsTimeMs = elapsed(this.mDnsStart, SystemClock.elapsedRealtime());
        }

        private void markDnsStart() {
            this.mDnsStart = SystemClock.elapsedRealtime();
        }

        private void markRequestHeadersEnd() {
            this.mRequestHeadersEnd = SystemClock.elapsedRealtime();
        }

        private void markResponseHeadersEnd() {
            this.ttfbDurationMs = elapsed(this.mRequestHeadersEnd, SystemClock.elapsedRealtime());
        }

        private void markTlsEnd() {
            this.tlsTimeMs = elapsed(this.mTlsStart, SystemClock.elapsedRealtime());
        }

        private void markTlsStart() {
            this.mTlsStart = SystemClock.elapsedRealtime();
        }

        public void fillMissingStages() {
            long r8 = SystemClock.elapsedRealtime();
            if (this.dnsTimeMs != 0) goto L7;
            long r10 = this.mDnsStart;
            if (r10 <= 0) goto L7;
            this.dnsTimeMs = elapsed(r10, r8);
        L7:
            long r11 = this.mConnectStart;
            if (r11 <= 0) goto L11;
            this.connectTimeMs += elapsed(r11, r8);
            this.mConnectStart = 0;
        L11:
            if (this.tlsTimeMs != 0) goto L16;
            long r12 = this.mTlsStart;
            if (r12 <= 0) goto L16;
            this.tlsTimeMs = elapsed(r12, r8);
        L16:
            if (this.ttfbDurationMs != 0) goto L21;
            long r13 = this.mRequestHeadersEnd;
            if (r13 <= 0) goto L22;
            this.ttfbDurationMs = elapsed(r13, r8);
            return;
        L22:
            return;
        }

        public int getConnectTimeMs() {
            return this.connectTimeMs;
        }

        public int getDnsTimeMs() {
            return this.dnsTimeMs;
        }

        public int getTlsTimeMs() {
            return this.tlsTimeMs;
        }

        public int getTotalTimeMs() {
            return this.totalTimeMs;
        }

        public int getTtfbDurationMs() {
            return this.ttfbDurationMs;
        }

        public String toString() {
            return "dnsTimeMs=" + this.dnsTimeMs + ", connectTimeMs=" + this.connectTimeMs + ", tlsTimeMs=" + this.tlsTimeMs + ", ttfbDurationMs=" + this.ttfbDurationMs + ", totalTimeMs=" + this.totalTimeMs;
        }
    }

    public class NetworkDns implements n {
        final /* synthetic */ HttpConnectionProbe this$0;

        private NetworkDns(HttpConnectionProbe r8) {
            this.this$0 = r8;
        }

        @Override // we.n
        public List<InetAddress> lookup(String r8) {
            long r10 = SystemClock.elapsedRealtime();
            List<InetAddress> r11 = HttpConnectionProbe.access$300(Arrays.asList(HttpConnectionProbe.access$200(this.this$0).getAllByName(r8)));
            CaeLog.i(HttpConnectionProbe.TAG, "probe dns result, netId: " + HttpConnectionProbe.access$200(this.this$0) + ", hostname: " + r8 + ", dnsTime: " + (SystemClock.elapsedRealtime() - r10) + "ms, ips: " + HttpConnectionProbe.access$400(r11));
            return r11;
        }

        public /* synthetic */ NetworkDns(HttpConnectionProbe r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static class OkHttpProbeEventListener extends o {
        private final Network mNetwork;
        private final HttpProbeTiming mTiming;

        public OkHttpProbeEventListener(Network r8, HttpProbeTiming r10) {
            this.mNetwork = r8;
            this.mTiming = r10;
        }

        @Override // we.o
        public void callEnd(d r8) {
            HttpProbeTiming.access$000(this.mTiming);
        }

        @Override // we.o
        public void callFailed(d r8, IOException r10) {
            this.mTiming.fillMissingStages();
            HttpProbeTiming.access$000(this.mTiming);
        }

        @Override // we.o
        public void callStart(d r8) {
            HttpProbeTiming.access$500(this.mTiming);
        }

        @Override // we.o
        public void connectEnd(d r8, InetSocketAddress r10, Proxy r11, w r12) {
            HttpProbeTiming.access$1300(this.mTiming);
            CaeLog.i(HttpConnectionProbe.TAG, "http probe connect end, netId: " + this.mNetwork + ", ip: " + HttpConnectionProbe.access$900(r10.getAddress()) + ", port: " + r10.getPort() + ", family: " + HttpConnectionProbe.access$1000(r10.getAddress()) + ", protocol: " + r12);
        }

        @Override // we.o
        public void connectFailed(d r8, InetSocketAddress r10, Proxy r11, w r12, IOException r13) {
            HttpProbeTiming.access$1300(this.mTiming);
            CaeLog.i(HttpConnectionProbe.TAG, "http probe connect failed, netId: " + this.mNetwork + ", family: " + HttpConnectionProbe.access$1000(r10.getAddress()) + ", protocol: " + r12 + ", error: " + r13.getMessage());
        }

        @Override // we.o
        public void connectStart(d r8, InetSocketAddress r10, Proxy r11) {
            HttpProbeTiming.access$800(this.mTiming);
            CaeLog.i(HttpConnectionProbe.TAG, "http probe connect start, netId: " + this.mNetwork + ", ip: " + HttpConnectionProbe.access$900(r10.getAddress()) + ", port: " + r10.getPort() + ", family: " + HttpConnectionProbe.access$1000(r10.getAddress()));
        }

        @Override // we.o
        public void dnsEnd(d r8, String r10, List<InetAddress> r11) {
            HttpProbeTiming.access$700(this.mTiming);
        }

        @Override // we.o
        public void dnsStart(d r8, String r10) {
            HttpProbeTiming.access$600(this.mTiming);
        }

        @Override // we.o
        public void requestHeadersEnd(d r8, y r10) {
            HttpProbeTiming.access$1400(this.mTiming);
        }

        @Override // we.o
        public void responseHeadersEnd(d r8, a0 r10) {
            HttpProbeTiming.access$1500(this.mTiming);
        }

        @Override // we.o
        public void secureConnectEnd(d r8, p r10) {
            HttpProbeTiming.access$1200(this.mTiming);
        }

        @Override // we.o
        public void secureConnectStart(d r8) {
            HttpProbeTiming.access$1100(this.mTiming);
        }
    }

    public HttpConnectionProbe(Network r8) {
        this.probeExecutor = Executors.newCachedThreadPool();
        this.mNetwork = r8;
    }

    public static /* synthetic */ void a(HttpConnectionProbe r8, URL r10, HttpProbeListener r11) {
        r8.lambda$executeHttpProbe$0(r10, r11);
    }

    public static /* synthetic */ String access$1000(InetAddress r8) {
        return getIpFamily(r8);
    }

    public static /* synthetic */ Network access$200(HttpConnectionProbe r8) {
        return r8.mNetwork;
    }

    public static /* synthetic */ List access$300(List r8) {
        return sortIpv4First(r8);
    }

    public static /* synthetic */ String access$400(List r8) {
        return formatIpAddresses(r8);
    }

    public static /* synthetic */ String access$900(InetAddress r8) {
        return formatIpAddress(r8);
    }

    public static /* synthetic */ void b(HttpConnectionProbe r8, URL r10, HttpProbeTiming r11, AtomicReference r12, AtomicBoolean r13, HttpProbeListener r14) {
        r8.lambda$sendHttpProbe$1(r10, r11, r12, r13, r14);
    }

    private static String formatIpAddress(InetAddress r8) {
        if (r8 != null) goto L5;
        return "unknown";
    L5:
        return r8.getHostAddress();
    }

    private static String formatIpAddresses(List<InetAddress> r8) {
        if (r8 != null) goto L4;
        return "[]";
    L4:
        if (r8.isEmpty() == true) goto L19;
        StringBuilder r10 = new StringBuilder("[");
        int r11 = 0;
    L8:
        if (r11 >= r8.size()) goto L12;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        r10.append(formatIpAddress(r8.get(r11)));
        r11 = r11 + 1;
        goto L8
    L12:
        r10.append("]");
        return r10.toString();
    L19:
        return "[]";
    }

    private static String getIpFamily(InetAddress r8) {
        if (r8 != null) goto L6;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L6:
        if ((r8 instanceof Inet4Address) == false) goto L8;
        return "IPv4";
    L8:
        return "IPv6";
    }

    public static boolean isFailedCode(int r8) {
        if (isSuccessCode(r8) == false) goto L5;
    L7:
        return false;
    L5:
        if (isPortalCode(r8) == true) goto L7;
        return true;
    }

    public static boolean isPortalCode(int r8) {
        if (isSuccessCode(r8) == false) goto L5;
    L9:
        return false;
    L5:
        if (r8 < 200) goto L9;
        if (r8 > 399) goto L9;
        return true;
    }

    public static boolean isSuccessCode(int r8) {
        if (r8 != 204) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$executeHttpProbe$0(URL r8, HttpProbeListener r10) {
        sendHttpProbe(r8, r10);
    }

    private void lambda$sendHttpProbe$1(URL r8, HttpProbeTiming r10, AtomicReference r11, AtomicBoolean r12, HttpProbeListener r13) {
        int r14 = 0;
        int r15 = FAILED_RESPONSE_CODE;
        y.a r16 = new y.a();     // Catch: IOException -> L28
        if (r8 == null) goto L27;
        String r17 = r8.toString();     // Catch: IOException -> L28
        r.a r18 = new r.a();     // Catch: IOException -> L28
        r18.b(null, r17);     // Catch: IOException -> L28
        r16.f(r18.a());     // Catch: IOException -> L28
        r16.f13347d.d("Connection", "close");     // Catch: IOException -> L28
        r16.f13347d.d("User-Agent", DEFAULT_USER_AGENT);     // Catch: IOException -> L28
        y r19 = r16.a();     // Catch: IOException -> L28
        v r20 = makeProbeClient(r10);     // Catch: IOException -> L28
        r20.getClass();     // Catch: IOException -> L28
        x r21 = x.f(r20, r19, false);     // Catch: IOException -> L28
        r11.set(r21);     // Catch: IOException -> L28
        a0 r22 = r21.d();     // Catch: IOException -> L28
        r15 = r22.f13116m;     // Catch: Throwable -> L20
        String r110 = r22.n(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L20
        r22.close();     // Catch: IOException -> L28
        HttpProbeTiming.access$000(r10);
        if (r12.get() == true) goto L44;
        CaeLog.i(TAG, "netId = " + this.mNetwork.toString() + ", probe done. ret=" + r15 + " timing=" + r10);
        if (isSuccessCode(r15) == false) goto L14;
        r13.onProbeSuccess(r15, r10.getTotalTimeMs(), r10);
        return;
    L14:
        if (isPortalCode(r15) == false) goto L17;
        r13.onProbePortal(r15, (String) Optional.ofNullable(r110).orElse(this.mUrl), r10.getTotalTimeMs(), r10);
        return;
    L17:
        if (isFailedCode(r15) == false) goto L47;
        r13.onProbeFailure(r15, 0, r10.getTotalTimeMs(), r10);
        return;
    L47:
        return;
    L44:
        return;
    L20:
        th = move-exception;
        r22.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L28
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L28
        goto L25
    L27:
        throw new NullPointerException("url == null");     // Catch: IOException -> L28
    L28:
        e = move-exception;
        if (r12.get() == true) goto L48;
        CaeLog.e(TAG, "netId = " + this.mNetwork.toString() + ", http probe failed: " + e.getMessage());
        r10.fillMissingStages();
        HttpProbeTiming.access$000(r10);
        if ((e instanceof UnknownHostException) == false) goto L35;
        r14 = 3;
    L37:
        r13.onProbeFailure(r15, r14, r10.getTotalTimeMs(), r10);
        return;
    L35:
        if ((e instanceof SocketTimeoutException) == false) goto L37;
        r14 = 4;
        goto L37
    }

    private v makeProbeClient(HttpProbeTiming r8) {
        v.b r10 = new v.b();
        SocketFactory r11 = this.mNetwork.getSocketFactory();
        if (r11 == null) goto L7;
        r10.f13302j = r11;
        r10.f13310r = new NetworkDns(this, null);
        r10.f13299g = o.factory(new OkHttpProbeEventListener(this.mNetwork, r8));
        r10.f13312t = false;
        r10.f13311s = false;
        TimeUnit r12 = TimeUnit.MILLISECONDS;
        r10.f13315w = c.d(8000, r12);
        r10.f13316x = c.d(8000, r12);
        r10.f13317y = c.d(8000, r12);
        return new v(r10);
    L7:
        throw new NullPointerException("socketFactory == null");
    }

    private URL makeURL(String r8) {
        if (r8 == null) goto L10;
        return new URL(r8);
    L5:
        CaeLog.e(TAG, "Bad URL: ".concat(r8));
        return null;
    L10:
        return null;
    }

    private void sendHttpProbe(final URL r17, final HttpProbeListener r18) {
        ExecutorService r12 = Executors.newSingleThreadExecutor();
        final AtomicBoolean r13 = new AtomicBoolean(false);
        final AtomicReference r15 = new AtomicReference();
        final HttpProbeTiming r8 = new HttpProbeTiming();
        Future<?> r10 = r12.submit(new a(this, r17, r8, r15, r13, r18));
        r10.get(10000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L5 Throwable -> L7 TimeoutException -> L12
    L4:
        r12.shutdownNow();
        return;
    L5:
        th = move-exception;
        r12.shutdownNow();
        throw th;
    L7:
        e = move-exception;
        if ((e instanceof InterruptedException) == false) goto L11;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L5
    L11:
        CaeLog.e(TAG, "netId = " + this.mNetwork.toString() + ", http probe task failed. " + e.getMessage());     // Catch: Throwable -> L5
        r8.fillMissingStages();     // Catch: Throwable -> L5
        HttpProbeTiming.access$000(r8);     // Catch: Throwable -> L5
        r18.onProbeFailure(FAILED_RESPONSE_CODE, 0, r8.getTotalTimeMs(), r8);     // Catch: Throwable -> L5
    L12:
        e = move-exception;
        CaeLog.e(TAG, "netId = " + this.mNetwork.toString() + ", http probe task timeout and cancel task. " + e.getMessage());     // Catch: Throwable -> L5
        r13.set(true);     // Catch: Throwable -> L5
        d r11 = (d) r15.get();     // Catch: Throwable -> L5
        if (r11 == null) goto L16;
        r11.cancel();     // Catch: Throwable -> L5
    L16:
        r10.cancel(true);     // Catch: Throwable -> L5
        r8.fillMissingStages();     // Catch: Throwable -> L5
        HttpProbeTiming.access$000(r8);     // Catch: Throwable -> L5
        r18.onProbeFailure(FAILED_RESPONSE_CODE, 5, r8.getTotalTimeMs(), r8);     // Catch: Throwable -> L5
        goto L4
    }

    private static List<InetAddress> sortIpv4First(List<InetAddress> r8) {
        ArrayList r10 = new ArrayList();
        Iterator<InetAddress> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        InetAddress r12 = r11.next();
        if ((r12 instanceof Inet4Address) == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        Iterator<InetAddress> r13 = r8.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        InetAddress r14 = r13.next();
        if ((r14 instanceof Inet4Address) == true) goto L10;
        r10.add(r14);
        goto L10
    L14:
        return r10;
    }

    public void executeHttpProbe(String r8, HttpProbeListener r10) {
        this.mUrl = r8;
        if (this.mNetwork != null) goto L6;
        r10.onProbeFailure(FAILED_RESPONSE_CODE, 1, 0, new HttpProbeTiming());
        CaeLog.e(TAG, "network is null.");
        return;
    L6:
        URL r11 = makeURL(r8);
        if (r11 != null) goto L10;
        r10.onProbeFailure(FAILED_RESPONSE_CODE, 2, 0, new HttpProbeTiming());
        CaeLog.e(TAG, "url is invalid: " + r8);
        return;
    L10:
        this.probeExecutor.execute(new g(this, r11, r10, 4));
    }
}
