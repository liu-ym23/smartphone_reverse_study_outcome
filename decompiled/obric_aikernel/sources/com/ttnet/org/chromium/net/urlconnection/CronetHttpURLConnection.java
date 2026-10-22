package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.base.Reflect;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    private static final String BYPASS_COOKIE_HEADER = "x-ttnet-bypass-cookie";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final int DO_NOT_SEND_COOKIE = 2;
    private static final String GET_REQUEST_COOKIE_SOURCE_FLAG = "x-tt-get-cookie-source";
    public static final String SS_COOKIE = "X-SS-Cookie";
    private static final String TAG = null;
    private static final String WEBVIEW_COOKIE = "webview-origin-url";
    private static final int WEBVIEW_REQUEST = 1;
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private CookieHandler mCookieHandler;
    private final CronetEngine mCronetEngine;
    private volatile boolean mDisconnected;
    private IOException mException;
    private boolean mHasResponseHeadersOrCompleted;
    private CronetInputStream mInputStream;
    private int mInputStreamBufferSize;
    private final MessageLoop mMessageLoop;
    private boolean mOnRedirectCalled;
    private CronetOutputStream mOutputStream;
    private int mOutputStreamBufferSize;
    private UrlRequest mRequest;
    private int mRequestCookieSource;
    private RequestFinishedInfo mRequestFinishedInfo;
    private int mRequestFlag;
    private final List<Pair<String, String>> mRequestHeaders;
    private volatile String mRequestLog;
    private CountDownLatch mRequestLogCountDownLatch;
    private int mRequestPriority;
    private int mRequestTimeout;
    private int mRequestTypeFlags;
    private List<Map.Entry<String, String>> mResponseHeadersList;
    private Map<String, List<String>> mResponseHeadersMap;
    private UrlResponseInfo mResponseInfo;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private long mThrottleNetSpeed;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;

    private class CronetUrlRequestCallback extends UrlRequest.Callback {
        final /* synthetic */ CronetHttpURLConnection this$0;

        public CronetUrlRequestCallback(CronetHttpURLConnection r10) {
            this.this$0 = r10;
        }

        private void setRequestEnd() {
            CronetHttpURLConnection r10 = this.this$0;
            CronetHttpURLConnection.access$1502(r10, CronetHttpURLConnection.access$1000(r10).getRequestLog());
        L19:
            th = move-exception;
            th.printStackTrace();
        L21:
            CronetHttpURLConnection.access$102(this.this$0, true);
            CronetHttpURLConnection.access$400(this.this$0).quit();
            return;
        L4:
            if (CronetHttpURLConnection.access$1200(this.this$0) == null) goto L21;
            String r11 = null;
            if (CronetHttpURLConnection.access$1400(this.this$0) == null) goto L13;
            if (CronetHttpURLConnection.access$1400(this.this$0).getMetrics() == null) goto L13;
            if (CronetHttpURLConnection.access$1400(this.this$0).getMetrics().getPeerAddr() == null) goto L13;
            r11 = CronetHttpURLConnection.access$1400(this.this$0).getMetrics().getPeerAddr() + ":" + CronetHttpURLConnection.access$1400(this.this$0).getMetrics().getPeerPort();     // Catch: Throwable -> L19
        L13:
            if (TextUtils.isEmpty(r11) == true) goto L21;
            String r12 = CronetHttpURLConnection.access$1200(this.this$0).getMessage();     // Catch: Throwable -> L19
            StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L19
            r13.append(r11);     // Catch: Throwable -> L19
            r13.append("|");     // Catch: Throwable -> L19
            if (r12 != null) goto L17;
            r12 = "null";
        L17:
            r13.append(r12);     // Catch: Throwable -> L19
            Reflect.on(CronetHttpURLConnection.access$1200(this.this$0)).set("detailMessage", r13.toString());     // Catch: Throwable -> L19
            goto L21
        }

        private void setResponseDataCompleted(IOException r10, boolean r11) {
            CronetHttpURLConnection.access$1202(this.this$0, r10);
            if (CronetHttpURLConnection.access$1700(this.this$0) == null) goto L6;
            CronetHttpURLConnection.access$1700(this.this$0).setResponseDataCompleted(r10);
        L6:
            if (CronetHttpURLConnection.access$1800(this.this$0) == null) goto L8;
            CronetHttpURLConnection.access$1800(this.this$0).setRequestCompleted(r10);
        L8:
            CronetHttpURLConnection.access$102(this.this$0, true);
            if (r11 == true) goto L12;
            setRequestEnd();
            return;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r10, UrlResponseInfo r11) {
            CronetHttpURLConnection.access$002(this.this$0, r11);
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onCanceled loop quit url = " + this.this$0.getURL().toString());
        L6:
            if (CronetHttpURLConnection.access$1200(this.this$0) != null) goto L8;
            CronetHttpURLConnection.access$1202(this.this$0, new TTRequestCanceledException("request canceled, ErrorCode=11, InternalErrorCode=-999"));
        L8:
            setResponseDataCompleted(CronetHttpURLConnection.access$1200(this.this$0), false);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r10, UrlResponseInfo r11, CronetException r12) {
            if (r12 == null) goto L9;
            CronetHttpURLConnection.access$002(this.this$0, r11);
            CronetHttpURLConnection r13 = this.this$0;
            CronetHttpURLConnection.access$1202(r13, CronetHttpURLConnection.access$1300(r13, r12));
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onFailed url = " + this.this$0.getURL().toString());
        L6:
            setResponseDataCompleted(r12, true);
            return;
        L9:
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onMetricsCollected(UrlRequest r10, RequestFinishedInfo r11) {
            CronetHttpURLConnection.access$1402(this.this$0, r11);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onMetricsCollected loop quit url = " + this.this$0.getURL().toString());
        L5:
            setRequestEnd();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r10, UrlResponseInfo r11, ByteBuffer r12) {
            CronetHttpURLConnection.access$002(this.this$0, r11);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onReadCompleted loop quit url = " + this.this$0.getURL().toString());
        L5:
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r10, UrlResponseInfo r11, String r12, String r13) {
            boolean r14 = true;
            CronetHttpURLConnection.access$502(this.this$0, true);
            if (r11 == null) goto L5;
            CronetHttpURLConnection.access$300(this.this$0, r13, r11.getAllHeaders());
        L5:
            URL r15 = CronetHttpURLConnection.access$600(this.this$0);
            if (TextUtils.isEmpty(r13) == true) goto L47;
            r15 = new URL(r13);     // Catch: Throwable -> L43
        L47:
            URL r16 = new URL(r12);     // Catch: MalformedURLException -> L44
            if (CronetHttpURLConnection.access$700(this.this$0) == false) goto L14;
            CronetHttpURLConnection.access$802(this.this$0, r16);     // Catch: MalformedURLException -> L44
        L14:
            if (CronetHttpURLConnection.access$900(this.this$0) == false) goto L36;
            if (CronetHttpURLConnection.access$1000(this.this$0) != null) goto L18;
            return;
        L18:
            if ("http".equals(r16.getProtocol()) == true) goto L20;
        L22:
            r14 = false;
        L24:
            if (r16.getHost().equals(r15.getHost()) == false) goto L26;
            if (r14 == true) goto L26;
        L34:
            CronetHttpURLConnection.access$1000(this.this$0).followRedirect();     // Catch: MalformedURLException -> L44
            return;
        L26:
            CronetHttpURLConnection.access$1000(this.this$0).RemoveRequestCookieHeader();     // Catch: MalformedURLException -> L44
            URL r17 = new URL(r12);     // Catch: MalformedURLException -> L44
            CronetHttpURLConnection r18 = this.this$0;     // Catch: MalformedURLException -> L44
            Map r19 = CronetHttpURLConnection.access$1100(r18, r18.uri(r17));     // Catch: MalformedURLException -> L44
            if (r19 == null) goto L34;
            if (r19.isEmpty() == true) goto L34;
            Iterator r20 = r19.entrySet().iterator();     // Catch: MalformedURLException -> L44
        L32:
            if (r20.hasNext() == false) goto L34;
            Map.Entry r21 = (Map.Entry) r20.next();     // Catch: MalformedURLException -> L44
            CronetHttpURLConnection.access$1000(this.this$0).AddRequestCookieHeader((String) r21.getKey(), (String) r21.getValue());     // Catch: MalformedURLException -> L44
            goto L32
        L20:
            if ("https".equals(r15.getProtocol()) == false) goto L22;
        L36:
            CronetHttpURLConnection.access$002(this.this$0, r11);
            if (CronetHttpURLConnection.access$1000(this.this$0) == null) goto L40;
            setResponseDataCompleted(null, false);
        L40:
            if (Logger.debug() == false) goto L51;
            Logger.d("CronetHttpURLConnection", "onRedirectReceived loop quit url = " + this.this$0.getURL().toString());
            return;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRequestLogCollected(String r10, RequestFinishedInfo r11) {
            CronetHttpURLConnection.access$1502(this.this$0, r10);
            CronetHttpURLConnection.access$1402(this.this$0, r11);
            CronetHttpURLConnection.access$1600(this.this$0).countDown();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r10, UrlResponseInfo r11, String r12) {
            CronetHttpURLConnection.access$002(this.this$0, r11);
            CronetHttpURLConnection.access$102(this.this$0, true);
            if (CronetHttpURLConnection.access$000(this.this$0) == null) goto L8;
            long r13 = System.nanoTime();
            CronetHttpURLConnection r14 = this.this$0;
            CronetHttpURLConnection.access$300(r14, r12, CronetHttpURLConnection.access$200(r14));
            long r15 = (System.nanoTime() - r13) / 1000;
            if (r10 == null) goto L8;
            r10.setSaveCookieCostUs(r15);
        L8:
            if (Logger.debug() == false) goto L10;
            Logger.d("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.this$0.getURL().toString());
        L10:
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r10, UrlResponseInfo r11) {
            CronetHttpURLConnection.access$002(this.this$0, r11);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onSucceeded url = " + this.this$0.getURL().toString());
        L5:
            setResponseDataCompleted(null, true);
        }
    }

    static {
        TAG = CronetHttpURLConnection.class.getSimpleName();
    }

    public CronetHttpURLConnection(URL r10, CronetEngine r11, boolean r12) {
        super(r10);
        this.mCronetEngine = r11;
        this.mMessageLoop = new MessageLoop();
        if (r12 == false) goto L5;
        CronetInputStream r13 = new CronetInputStreamWithTTBuffer(this);
    L6:
        this.mInputStream = r13;
        this.mRequestHeaders = new ArrayList();
        this.mCookieHandler = CookieHandler.getDefault();
        this.mRequestLogCountDownLatch = new CountDownLatch(1);
        this.mDisconnected = false;
        this.mRequestCookieSource = -1;
        return;
    L5:
        r13 = new CronetInputStream(this);
        goto L6
    }

    private Map<String, String> GetCookieMap(URI r10) {
        HashMap r11 = new HashMap();
        if ((this.mRequestTypeFlags & 2) > 0) goto L59;
        if (isAllowCredentials() == false) goto L59;
        HashMap r12 = new HashMap();
        List<Pair<String, String>> r13 = this.mRequestHeaders;
        if (r13 == null) goto L16;
        Iterator<Pair<String, String>> r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L16;
        Pair<String, String> r15 = r14.next();
        String r16 = (String) r15.first;
        String r17 = (String) r15.second;
        List r18 = (List) r12.get(r16);
        if (r18 != null) goto L15;
        r18 = new LinkedList();
    L15:
        r18.add(r17);
        r12.put(r16, r18);
    L16:
        r12.put(GET_REQUEST_COOKIE_SOURCE_FLAG, new LinkedList());
        Map<String, List<String>> r19 = null;
    L24:
        e = move-exception;
        if (Logger.debug() == false) goto L28;
        Logger.d(TAG, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L28:
        if (r19 != null) goto L30;
    L57:
        return r11;
    L30:
        if (r19.size() <= 0) goto L57;
        Iterator<Map.Entry<String, List<String>>> r20 = r19.entrySet().iterator();
    L33:
        if (r20.hasNext() == false) goto L57;
        Map.Entry<String, List<String>> r21 = r20.next();
        String r22 = r21.getKey();
        int r23 = 0;
        if (GET_REQUEST_COOKIE_SOURCE_FLAG.equals(r22) == true) goto L37;
    L41:
        StringBuilder r24 = new StringBuilder();
        if (SS_COOKIE.equalsIgnoreCase(r22) == true) goto L48;
        if ("Cookie".equalsIgnoreCase(r22) == true) goto L48;
        if ("Cookie2".equalsIgnoreCase(r22) == false) goto L33;
    L48:
        if (r21.getValue().isEmpty() == true) goto L33;
        Iterator<String> r25 = r21.getValue().iterator();
    L51:
        if (r25.hasNext() == false) goto L56;
        String r26 = r25.next();
        if (r23 <= 0) goto L55;
        r24.append("; ");
    L55:
        r24.append(r26);
        r23 = r23 + 1;
        goto L51
    L56:
        r11.put(r22, r24.toString());
        goto L33
    L37:
        if (r21.getValue().isEmpty() == true) goto L41;
        this.mRequestCookieSource = Integer.parseInt(r21.getValue().get(0));     // Catch: Throwable -> L40
    L40:
        this.mRequestCookieSource = -1;
        goto L41
    L18:
        if (this.mCookieHandler != null) goto L20;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L24
    L20:
        CookieHandler r27 = this.mCookieHandler;     // Catch: Exception -> L24
        if (r27 == null) goto L28;
        r19 = r27.get(r10, r12);     // Catch: Exception -> L24
    L59:
        if (Logger.debug() == false) goto L61;
        Logger.d(TAG, "Do not read cookie from TTNet, url:" + r10);
    L61:
        return r11;
    }

    static /* synthetic */ UrlResponseInfo access$000(CronetHttpURLConnection r10) {
        return r10.mResponseInfo;
    }

    static /* synthetic */ UrlResponseInfo access$002(CronetHttpURLConnection r10, UrlResponseInfo r11) {
        r10.mResponseInfo = r11;
        return r11;
    }

    static /* synthetic */ UrlRequest access$1000(CronetHttpURLConnection r10) {
        return r10.mRequest;
    }

    static /* synthetic */ boolean access$102(CronetHttpURLConnection r10, boolean r11) {
        r10.mHasResponseHeadersOrCompleted = r11;
        return r11;
    }

    static /* synthetic */ Map access$1100(CronetHttpURLConnection r10, URI r11) {
        return r10.GetCookieMap(r11);
    }

    static /* synthetic */ IOException access$1200(CronetHttpURLConnection r10) {
        return r10.mException;
    }

    static /* synthetic */ IOException access$1202(CronetHttpURLConnection r10, IOException r11) {
        r10.mException = r11;
        return r11;
    }

    static /* synthetic */ IOException access$1300(CronetHttpURLConnection r10, CronetException r11) {
        return r10.tryConvertCronetException(r11);
    }

    static /* synthetic */ RequestFinishedInfo access$1400(CronetHttpURLConnection r10) {
        return r10.mRequestFinishedInfo;
    }

    static /* synthetic */ RequestFinishedInfo access$1402(CronetHttpURLConnection r10, RequestFinishedInfo r11) {
        r10.mRequestFinishedInfo = r11;
        return r11;
    }

    static /* synthetic */ String access$1502(CronetHttpURLConnection r10, String r11) {
        r10.mRequestLog = r11;
        return r11;
    }

    static /* synthetic */ CountDownLatch access$1600(CronetHttpURLConnection r10) {
        return r10.mRequestLogCountDownLatch;
    }

    static /* synthetic */ CronetInputStream access$1700(CronetHttpURLConnection r10) {
        return r10.mInputStream;
    }

    static /* synthetic */ CronetOutputStream access$1800(CronetHttpURLConnection r10) {
        return r10.mOutputStream;
    }

    static /* synthetic */ Map access$200(CronetHttpURLConnection r10) {
        return r10.getAllHeaders();
    }

    static /* synthetic */ void access$300(CronetHttpURLConnection r10, String r11, Map r12) {
        r10.saveResponseCookie(r11, r12);
    }

    static /* synthetic */ MessageLoop access$400(CronetHttpURLConnection r10) {
        return r10.mMessageLoop;
    }

    static /* synthetic */ boolean access$502(CronetHttpURLConnection r10, boolean r11) {
        r10.mOnRedirectCalled = r11;
        return r11;
    }

    static /* synthetic */ URL access$600(CronetHttpURLConnection r10) {
        return ((HttpURLConnection) r10).url;
    }

    static /* synthetic */ boolean access$700(CronetHttpURLConnection r10) {
        return ((HttpURLConnection) r10).instanceFollowRedirects;
    }

    static /* synthetic */ URL access$802(CronetHttpURLConnection r10, URL r11) {
        ((HttpURLConnection) r10).url = r11;
        return r11;
    }

    static /* synthetic */ boolean access$900(CronetHttpURLConnection r10) {
        return ((HttpURLConnection) r10).instanceFollowRedirects;
    }

    private void checkHasResponseHeaders() {
        if (this.mHasResponseHeadersOrCompleted == false) goto L10;
        IOException r10 = this.mException;
        if (r10 != null) goto L8;
        Objects.requireNonNull(this.mResponseInfo, "Response info is null when there is no exception.");
        return;
    L8:
        throw r10;
    L10:
        throw new IllegalStateException("No response.");
    }

    private boolean checkTrafficStatsTag() {
        if (this.mTrafficStatsTagSet == false) goto L5;
        return true;
    L5:
        int r10 = TrafficStats.getThreadStatsTag();
        if (r10 == (-1)) goto L9;
        this.mTrafficStatsTag = r10;
        this.mTrafficStatsTagSet = true;
    L9:
        return this.mTrafficStatsTagSet;
    }

    private boolean checkTrafficStatsUid() {
        if (this.mTrafficStatsUidSet == false) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        return false;
    L9:
        int r10 = TrafficStats.getThreadStatsUid();
        if (r10 == (-1)) goto L13;
        this.mTrafficStatsUid = r10;
        this.mTrafficStatsUidSet = true;
    L13:
        return this.mTrafficStatsUidSet;
    }

    private void cronet_loop(int r10) {
        this.mMessageLoop.loop(r10);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L16:
        return;
    L8:
        UrlRequest r11 = this.mRequest;
        if (r11 == null) goto L15;
        r11.appTimeout();
    L7:
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r10 / 2);
        return;
    L15:
        return;
    L4:
        e = move-exception;
        setException(new IOException("Unexpected request usage, caught in CronetHttpURLConnection, caused by " + e));
        if (this.mRequest != null) goto L7;
    }

    private int findRequestProperty(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mRequestHeaders.size()) goto L9;
        if (((String) this.mRequestHeaders.get(r11).first).equalsIgnoreCase(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return -1;
    }

    private Map<String, List<String>> getAllHeaders() {
        Map<String, List<String>> r10 = this.mResponseHeadersMap;
        if (r10 == null) goto L5;
        return r10;
    L5:
        TreeMap r11 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Map.Entry<String, String>> r12 = getAllHeadersAsList().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, String> r13 = r12.next();
        ArrayList r14 = new ArrayList();
        if (r11.containsKey(r13.getKey()) == false) goto L11;
        r14.addAll((Collection) r11.get(r13.getKey()));
    L11:
        r14.add(r13.getValue());
        r11.put(r13.getKey(), Collections.unmodifiableList(r14));
        goto L7
    L12:
        Map<String, List<String>> r15 = Collections.unmodifiableMap(r11);
        this.mResponseHeadersMap = r15;
        return r15;
    }

    private List<Map.Entry<String, String>> getAllHeadersAsList() {
        List<Map.Entry<String, String>> r10 = this.mResponseHeadersList;
        if (r10 == null) goto L5;
        return r10;
    L5:
        this.mResponseHeadersList = new ArrayList();
        Iterator<Map.Entry<String, String>> r11 = this.mResponseInfo.getAllHeadersAsList().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<String, String> r12 = r11.next();
        this.mResponseHeadersList.add(new AbstractMap.SimpleImmutableEntry(r12));
        goto L7
    L9:
        List<Map.Entry<String, String>> r13 = Collections.unmodifiableList(this.mResponseHeadersList);
        this.mResponseHeadersList = r13;
        return r13;
    }

    private Map.Entry<String, String> getHeaderFieldEntry(int r10) {
        getResponse();     // Catch: IOException -> L9
        List<Map.Entry<String, String>> r11 = getAllHeadersAsList();
        if (r10 < r11.size()) goto L8;
        return null;
    L8:
        return r11.get(r10);
    L9:
        return null;
    }

    private void getResponse() {
        CronetOutputStream r10 = this.mOutputStream;
        if (r10 == null) goto L8;
        r10.checkReceivedEnoughContent();
        if (isChunkedUpload() == false) goto L8;
        this.mOutputStream.close();
    L8:
        if (this.mHasResponseHeadersOrCompleted == true) goto L13;
        startRequest();
        if (Logger.debug() == false) goto L12;
        Logger.d("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
    L12:
        cronet_loop(getConnectTimeout() + getReadTimeout());
        this.mHasResponseHeadersOrCompleted = true;
    L13:
        checkHasResponseHeaders();
    }

    private long getStreamingModeContentLength() {
        long r10 = ((HttpURLConnection) this).fixedContentLength;
        long r11 = ((HttpURLConnection) this).fixedContentLengthLong;
        if (r11 != (-1)) goto L5;
        return r10;
    L5:
        return r11;
    }

    private boolean isAllowCredentials() {
        String r10 = getRequestProperty(BYPASS_COOKIE_HEADER);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return true;
    L5:
        if (NetConst.NOT_ENCRYPT_VERISON_CODE.equals(r10) == false) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isChunkedUpload() {
        if (((HttpURLConnection) this).chunkLength <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void saveResponseCookie(String r10, Map<String, List<String>> r11) {
        if (isAllowCredentials() == true) goto L9;
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Do not write cookie from TTNet, url:" + r10);
        return;
    L37:
        return;
    L9:
        if (Logger.debug() == false) goto L36;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder();
        r13.append("Saving cookies for url: ");
        if (TextUtils.isEmpty(r10) == false) goto L13;
        String r14 = getURL().toString();
    L14:
        r13.append(r14);
        Logger.d(r12, r13.toString());
        goto L36
    L13:
        r14 = r10;
    L36:
    L28:
        e = move-exception;
        if (Logger.debug() == false) goto L41;
        String r15 = TAG;
        StringBuilder r16 = new StringBuilder();
        r16.append("Saving cookies failed for ");
        if (TextUtils.isEmpty(r10) == false) goto L34;
        r10 = getURL().toString();
    L34:
        r16.append(r10);
        r16.append(" e = ");
        r16.append(e.getMessage());
        Logger.d(r15, r16.toString());
        return;
    L41:
        return;
    L16:
        if (this.mCookieHandler != null) goto L19;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L28
    L19:
        if (this.mCookieHandler != null) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r10) == false) goto L23;
        this.mCookieHandler.put(uri(getURL()), r11);     // Catch: Exception -> L28
        return;
    L23:
        URI r17 = uri(new URL(r10));     // Catch: Exception -> L28
        if ((this.mRequestTypeFlags & 1) != 1) goto L26;
        TreeMap r18 = new TreeMap(r11);     // Catch: Exception -> L28
        r18.put(WEBVIEW_COOKIE, Collections.singletonList(getURL().getHost()));     // Catch: Exception -> L28
        this.mCookieHandler.put(r17, r18);     // Catch: Exception -> L28
        return;
    L26:
        this.mCookieHandler.put(r17, r11);     // Catch: Exception -> L28
    }

    private final void setRequestPropertyInternal(String r10, String r11, boolean r12) {
        if (((HttpURLConnection) this).connected == true) goto L13;
        int r13 = findRequestProperty(r10);
        if (r13 < 0) goto L10;
        if (r12 == false) goto L9;
        this.mRequestHeaders.remove(r13);
        goto L10
    L9:
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + r10 + ". crbug.com/432719.");
    L10:
        this.mRequestHeaders.add(Pair.create(r10, r11));
        return;
    L13:
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }

    private void startRequest() {
        if (((HttpURLConnection) this).connected == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("CronetHttpURLConnection", "start request url = " + getURL().toString());
    L8:
        ExperimentalUrlRequest.Builder r10 = (ExperimentalUrlRequest.Builder) this.mCronetEngine.newUrlRequestBuilder(getURL().toString(), new CronetUrlRequestCallback(this), this.mMessageLoop);
        if (((HttpURLConnection) this).doOutput == true) goto L11;
    L27:
        long r11 = System.nanoTime();
        Map<String, String> r12 = GetCookieMap(uri(getURL()));
        if (r12 != null) goto L30;
    L35:
        long r13 = (System.nanoTime() - r11) / 1000;
        Iterator<Pair<String, String>> r14 = this.mRequestHeaders.iterator();
    L37:
        if (r14.hasNext() == false) goto L40;
        Pair<String, String> r15 = r14.next();
        r10.addHeader((String) r15.first, (String) r15.second);
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r10.disableCache();
    L42:
        r10.setHttpMethod(((HttpURLConnection) this).method);
        if (checkTrafficStatsTag() == false) goto L46;
        r10.setTrafficStatsTag(this.mTrafficStatsTag);
    L46:
        if (checkTrafficStatsUid() == false) goto L48;
        r10.setTrafficStatsUid(this.mTrafficStatsUid);
    L48:
        r10.setPriority(this.mRequestPriority);
        r10.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r10.setSocketReadTimeout(this.mSocketReadTimeout);
        r10.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r10.setRequestTimeout(this.mRequestTimeout);
        ExperimentalUrlRequest r16 = r10.build();
        this.mRequest = r16;
        int r17 = this.mRequestFlag;
        if (r17 == 0) goto L51;
        r16.setRequestFlag(r17);
    L51:
        int r18 = this.mRequestTypeFlags;
        if (r18 <= 0) goto L54;
        this.mRequest.setRequestTypeFlags(r18);
    L54:
        String r19 = this.mAuthCertUsername;
        if (r19 == null) goto L59;
        String r20 = this.mAuthCertPassword;
        if (r20 == null) goto L59;
        this.mRequest.setAuthCredentials(r19, r20);
    L59:
        this.mRequest.setAddCookieCostUs(r13);
        this.mRequest.setRequestCookieSource(this.mRequestCookieSource);
        this.mRequest.start();
        long r21 = this.mThrottleNetSpeed;
        if (r21 <= 0) goto L62;
        this.mRequest.setThrottleNetSpeed(r21);
    L62:
        ((HttpURLConnection) this).connected = true;
        return;
    L30:
        if (r12.isEmpty() == true) goto L35;
        Iterator<Map.Entry<String, String>> r22 = r12.entrySet().iterator();
    L33:
        if (r22.hasNext() == false) goto L35;
        Map.Entry<String, String> r23 = r22.next();
        r10.addHeader(r23.getKey(), r23.getValue());
        goto L33
    L11:
        if (((HttpURLConnection) this).method.equals("GET") == false) goto L13;
        ((HttpURLConnection) this).method = CloudConfig.REQUEST_TYPE_POST;
    L13:
        CronetOutputStream r24 = this.mOutputStream;
        if (r24 == null) goto L22;
        r10.setUploadDataProvider(r24.getUploadDataProvider(), this.mMessageLoop);
        if (getRequestProperty(CONTENT_LENGTH) == null) goto L18;
    L20:
        this.mOutputStream.setConnected();
    L25:
        if (getRequestProperty(NetConst.KEY_CONTENT_TYPE) != null) goto L27;
        addRequestProperty(NetConst.KEY_CONTENT_TYPE, "application/x-www-form-urlencoded");
        goto L27
    L18:
        if (isChunkedUpload() == true) goto L20;
        addRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L20
    L22:
        if (getRequestProperty(CONTENT_LENGTH) != null) goto L25;
        addRequestProperty(CONTENT_LENGTH, NetConst.NOT_ENCRYPT_VERISON_CODE);
        goto L25
    }

    private IOException tryConvertCronetException(CronetException r10) {
        if ((r10 instanceof NetworkException) == true) goto L6;
        return r10;
    L6:
        switch(((NetworkException) r10).getErrorCode()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r11 = new NoRouteToHostException(r10.getMessage());
    L16:
        return r11;
    L9:
        r11 = new SocketException("reset by peer " + r10.getMessage());
        goto L16
    L10:
        r11 = new ConnectTimeoutException(r10.getMessage());
        goto L16
    L11:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L12:
        r11 = new SocketTimeoutException(r10.getMessage());
        goto L16
    L13:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L14:
        r11 = new UnknownHostException(r10.getMessage());
        goto L16
    L17:
        return r10;
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r10, String r11) {
        setRequestPropertyInternal(r10, r11, false);
    }

    @Override // java.net.URLConnection
    public void connect() {
        getOutputStream();
        startRequest();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected == false) goto L8;
        UrlRequest r10 = this.mRequest;
        if (r10 == null) goto L9;
        r10.cancel();
        this.mDisconnected = true;
        return;
    L9:
        return;
    }

    public int getCronetInternalErrorCode() {
        IOException r10 = this.mException;
        if ((r10 instanceof NetworkException) == false) goto L7;
        return ((NetworkException) r10).getCronetInternalErrorCode();
    L7:
        if ((r10 instanceof TTRequestCanceledException) == true) goto L9;
        return 0;
    L9:
        return ((TTRequestCanceledException) r10).getCronetInternalErrorCode();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        getResponse();     // Catch: IOException -> L9
        if (this.mResponseInfo.getHttpStatusCode() < 400) goto L8;
        return this.mInputStream;
    L8:
        return null;
    }

    public String getFinalUrl() {
        return this.mRequest.getFinalUrl();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int r10) {
        Map.Entry<String, String> r11 = getHeaderFieldEntry(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getValue();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r10) {
        getResponse();     // Catch: IOException -> L9
        Map<String, List<String>> r11 = getAllHeaders();
        if (r11.containsKey(r10) == true) goto L7;
        return null;
    L7:
        List<String> r12 = r11.get(r10);
        return r12.get(r12.size() - 1);
    L9:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r10) {
        Map.Entry<String, String> r11 = getHeaderFieldEntry(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getKey();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        getResponse();     // Catch: IOException -> L5
        return getAllHeaders();
    L6:
        return Collections.emptyMap();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() {
        getResponse();
        if (((HttpURLConnection) this).instanceFollowRedirects == true) goto L10;
        if (this.mOnRedirectCalled == false) goto L10;
        throw new IOException("Cannot read response body of a redirect.");
    L10:
        if (this.mResponseInfo.getHttpStatusCode() >= 400) goto L14;
        return this.mInputStream;
    L14:
        throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
    }

    public int getInputStreamBufferSize() {
        return this.mInputStreamBufferSize;
    }

    void getMoreData(ByteBuffer r10) {
        UrlRequest r11 = this.mRequest;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.read(r10);
        cronet_loop(getReadTimeout());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        if (this.mOutputStream != null) goto L27;
        if (((HttpURLConnection) this).doOutput == false) goto L27;
        if (((HttpURLConnection) this).connected == true) goto L25;
        if (isChunkedUpload() == false) goto L12;
        this.mOutputStream = new CronetChunkedOutputStream(this, ((HttpURLConnection) this).chunkLength, this.mMessageLoop);
    L11:
        startRequest();
        goto L27
    L12:
        long r10 = getStreamingModeContentLength();
        if (r10 == (-1)) goto L20;
        CronetFixedModeOutputStream r11 = new CronetFixedModeOutputStream(this, r10, this.mOutputStreamBufferSize, this.mMessageLoop);
        this.mOutputStream = r11;
        if (r10 != 0) goto L11;
        setFixedLengthStreamingMode((int) r11.getUploadDataProvider().getLength());
        if (getRequestProperty(CONTENT_LENGTH) != null) goto L19;
        addRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L11
    L19:
        setRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L11
    L20:
        Log.d(TAG, "Outputstream is being buffered in memory.", new Object[0]);
        String r12 = getRequestProperty(CONTENT_LENGTH);
        if (r12 != null) goto L23;
        this.mOutputStream = new CronetBufferedOutputStream(this);
        goto L27
    L23:
        this.mOutputStream = new CronetBufferedOutputStream(this, Long.parseLong(r12));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.mOutputStream;
    }

    public RequestFinishedInfo getRequestFinishedInfo() {
        if (this.mRequestFinishedInfo != null) goto L11;
        if (this.mDisconnected == false) goto L11;
        this.mRequestLogCountDownLatch.await(50, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return this.mRequestFinishedInfo;
    }

    public String getRequestLog() {
        if (this.mRequestLog != null) goto L5;
        return "";
    L5:
        return this.mRequestLog;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (((HttpURLConnection) this).connected == true) goto L15;
        TreeMap r10 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Pair<String, String>> r11 = this.mRequestHeaders.iterator();
    L6:
        if (r11.hasNext() == false) goto L13;
        Pair<String, String> r12 = r11.next();
        if (r10.containsKey(r12.first) == true) goto L11;
        ArrayList r13 = new ArrayList();
        r13.add((String) r12.second);
        r10.put((String) r12.first, Collections.unmodifiableList(r13));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r10);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r10) {
        int r11 = findRequestProperty(r10);
        if (r11 >= 0) goto L5;
        return null;
    L5:
        return (String) this.mRequestHeaders.get(r11).second;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        getResponse();
        return this.mResponseInfo.getHttpStatusCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        getResponse();
        return this.mResponseInfo.getHttpStatusText();
    }

    public void onUploadTimeout() {
        UrlRequest r10 = this.mRequest;
        if (r10 == null) goto L6;
        r10.appTimeout();
        return;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setAuthCredentials(String r10, String r11) {
        this.mAuthCertUsername = r10;
        this.mAuthCertPassword = r11;
    }

    @Override // java.net.URLConnection
    @UsedByReflection("SsCronetHttpClient.java")
    public void setConnectTimeout(int r10) {
        super.setConnectTimeout(r10);
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setException(IOException r10) {
        CronetInputStream r11 = this.mInputStream;
        if (r11 == null) goto L5;
        r11.setResponseDataCompleted(r10);
    L5:
        CronetOutputStream r12 = this.mOutputStream;
        if (r12 == null) goto L8;
        r12.setRequestCompleted(r10);
    L8:
        this.mHasResponseHeadersOrCompleted = true;
        this.mException = r10;
        UrlRequest r13 = this.mRequest;
        if (r13 == null) goto L12;
        r13.cancel();
        return;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setInputStreamBufferSize(int r10) {
        this.mInputStreamBufferSize = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setOutputStreamBufferSize(int r10) {
        this.mOutputStreamBufferSize = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestFlag(int r10) {
        this.mRequestFlag = r10;
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r10) {
        if ("PATCH".equals(r10) == true) goto L5;
        super.setRequestMethod(r10);
        return;
    L5:
        if (((HttpURLConnection) this).connected == true) goto L8;
        ((HttpURLConnection) this).method = r10;
        return;
    L8:
        throw new ProtocolException("Can't reset method: already connected");
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestPriority(int r10) {
        this.mRequestPriority = r10;
    }

    @Override // java.net.URLConnection
    @UsedByReflection("SsCronetHttpClient.java")
    public final void setRequestProperty(String r10, String r11) {
        setRequestPropertyInternal(r10, r11, true);
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestTimeout(int r10) {
        this.mRequestTimeout = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestTypeFlags(int r10) {
        this.mRequestTypeFlags = r10 | this.mRequestTypeFlags;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketConnectTimeout(int r10) {
        this.mSocketConnectTimeout = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketReadTimeout(int r10) {
        this.mSocketReadTimeout = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketWriteTimeout(int r10) {
        this.mSocketWriteTimeout = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setThrottleNetSpeed(long r10) {
        this.mThrottleNetSpeed = r10;
        UrlRequest r11 = this.mRequest;
        if (r11 == null) goto L6;
        r11.setThrottleNetSpeed(r10);
        return;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setTrafficStatsTag(int r10) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r10;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setTrafficStatsUid(int r10) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r10;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    public URI uri(URL r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = r10.toString();
        return new URI(r11);
    L8:
        e = move-exception;
        return URI.create(r11.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L16:
        return URI.create(r11.substring(0, r11.indexOf("?")));
    L15:
        throw new RuntimeException(e);
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }
}
