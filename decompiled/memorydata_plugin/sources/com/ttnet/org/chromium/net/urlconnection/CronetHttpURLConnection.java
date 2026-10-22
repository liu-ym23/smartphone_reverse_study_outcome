package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.PriorityLevel;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.base.ParamChecker;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes6.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    private static final String BYPASS_COOKIE_HEADER = "x-ttnet-bypass-cookie";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final int DO_NOT_SEND_COOKIE = 2;
    private static final String GET_REQUEST_COOKIE_SOURCE_FLAG = "x-tt-get-cookie-source";
    public static final String SS_COOKIE = "X-SS-Cookie";
    private static final String TAG = "CronetHttpURLConnection";
    private static final String TT_COOKIE_REL_METRIC_FLAG = "x-tt-cookie-rel-metric";
    private static final String WEBVIEW_COOKIE = "webview-origin-url";
    private static final int WEBVIEW_REQUEST = 1;
    private static final String WEBVIEW_REQUEST_FLAG = "x-tt-webview-request";
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private CookieHandler mCookieHandler;
    private String mCookieRelMetric;
    private final CronetEngine mCronetEngine;
    private final AtomicBoolean mDisconnected;
    private IOException mException;
    private boolean mFixCancelRequestReport;
    private boolean mHasResponseHeadersOrCompleted;
    private CronetInputStream mInputStream;
    private int mInputStreamBufferSize;
    private final MessageLoop mMessageLoop;
    private boolean mOnRedirectCalled;
    private CronetOutputStream mOutputStream;
    private int mOutputStreamBufferSize;
    private UrlRequest mRequest;
    private final AtomicBoolean mRequestCompleted;
    private int mRequestCookieSource;
    private RequestFinishedInfo.Listener mRequestFinishedListener;
    private int mRequestFlag;
    private final List<Pair<String, String>> mRequestHeaders;
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

        public CronetUrlRequestCallback(CronetHttpURLConnection r1) {
            this.this$0 = r1;
        }

        private void setResponseDataCompleted(IOException r2) {
            CronetHttpURLConnection.access$1202(this.this$0, r2);
            if (CronetHttpURLConnection.access$1400(this.this$0) == null) goto L6;
            CronetHttpURLConnection.access$1400(this.this$0).setResponseDataCompleted(r2);
        L6:
            if (CronetHttpURLConnection.access$1500(this.this$0) == null) goto L8;
            CronetHttpURLConnection.access$1500(this.this$0).setRequestCompleted(r2);
        L8:
            CronetHttpURLConnection.access$102(this.this$0, true);
            CronetHttpURLConnection.access$1600(this.this$0).set(true);
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r2, UrlResponseInfo r3) {
            CronetHttpURLConnection.access$002(this.this$0, r3);
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onCanceled loop quit url = " + this.this$0.getURL().toString());
        L6:
            if (CronetHttpURLConnection.access$1200(this.this$0) == null) goto L8;
        L10:
            setResponseDataCompleted(CronetHttpURLConnection.access$1200(this.this$0));
            return;
        L8:
            if (CronetHttpURLConnection.access$500(this.this$0) == true) goto L10;
            StringBuilder r4 = new StringBuilder("request canceled");
            r4.append(", ErrorCode=").append(11).append(", InternalErrorCode=").append(PriorityLevel.INVALID);
            CronetHttpURLConnection.access$1202(this.this$0, new TTRequestCanceledException(r4.toString()));
            goto L10
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r2, UrlResponseInfo r3, CronetException r4) {
            if (r4 == null) goto L6;
            CronetHttpURLConnection r5 = this.this$0;
            CronetHttpURLConnection.access$1202(r5, CronetHttpURLConnection.access$1300(r5, r4));
            CronetHttpURLConnection.access$002(this.this$0, r3);
            setResponseDataCompleted(r4);
            return;
        L6:
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r1, UrlResponseInfo r2, ByteBuffer r3) {
            CronetHttpURLConnection.access$002(this.this$0, r2);
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r5, UrlResponseInfo r6, String r7, String r8) {
            boolean r1 = true;
            CronetHttpURLConnection.access$502(this.this$0, true);
            if (r6 == null) goto L5;
            CronetHttpURLConnection.access$300(this.this$0, r8, r6.getAllHeaders());
        L5:
            URL r0 = CronetHttpURLConnection.access$600(this.this$0);
            if (TextUtils.isEmpty(r8) == true) goto L43;
            r0 = new URL(r8);     // Catch: Throwable -> L39
        L43:
            URL r9 = new URL(r7);     // Catch: MalformedURLException -> L40
            if (CronetHttpURLConnection.access$700(this.this$0) == false) goto L13;
            CronetHttpURLConnection.access$802(this.this$0, r9);     // Catch: MalformedURLException -> L40
        L13:
            if (CronetHttpURLConnection.access$900(this.this$0) == false) goto L35;
            if (CronetHttpURLConnection.access$1000(this.this$0) != null) goto L17;
            return;
        L17:
            if ("http".equals(r9.getProtocol()) == true) goto L19;
        L21:
            r1 = false;
        L23:
            if (r9.getHost().equals(r0.getHost()) == false) goto L25;
            if (r1 == true) goto L25;
        L33:
            CronetHttpURLConnection.access$1000(this.this$0).followRedirect();     // Catch: MalformedURLException -> L40
            return;
        L25:
            CronetHttpURLConnection.access$1000(this.this$0).RemoveRequestCookieHeader();     // Catch: MalformedURLException -> L40
            URL r10 = new URL(r7);     // Catch: MalformedURLException -> L40
            CronetHttpURLConnection r11 = this.this$0;     // Catch: MalformedURLException -> L40
            Map r12 = CronetHttpURLConnection.access$1100(r11, r11.uri(r10));     // Catch: MalformedURLException -> L40
            if (r12 == null) goto L33;
            if (r12.isEmpty() == true) goto L33;
            Iterator r13 = r12.entrySet().iterator();     // Catch: MalformedURLException -> L40
        L31:
            if (r13.hasNext() == false) goto L33;
            Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: MalformedURLException -> L40
            CronetHttpURLConnection.access$1000(this.this$0).AddRequestCookieHeader((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: MalformedURLException -> L40
            goto L31
        L19:
            if (LocationInfoConst.HTTPS.equals(r0.getProtocol()) == false) goto L21;
        L35:
            CronetHttpURLConnection.access$002(this.this$0, r6);
            if (CronetHttpURLConnection.access$1000(this.this$0) == null) goto L47;
            CronetHttpURLConnection.access$1000(this.this$0).cancel();
            return;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r4, UrlResponseInfo r5, String r6) {
            CronetHttpURLConnection.access$002(this.this$0, r5);
            CronetHttpURLConnection.access$102(this.this$0, true);
            if (CronetHttpURLConnection.access$000(this.this$0) == null) goto L8;
            long r0 = System.nanoTime();
            CronetHttpURLConnection r7 = this.this$0;
            CronetHttpURLConnection.access$300(r7, r6, CronetHttpURLConnection.access$200(r7));
            long r8 = (System.nanoTime() - r0) / 1000;
            if (r4 == null) goto L8;
            r4.setSaveCookieCostUs(r8);
        L8:
            if (Logger.debug() == false) goto L10;
            Logger.d("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.this$0.getURL().toString());
        L10:
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r1, UrlResponseInfo r2) {
            CronetHttpURLConnection.access$002(this.this$0, r2);
            setResponseDataCompleted(null);
        }
    }

    static {
    }

    public CronetHttpURLConnection(URL r2, CronetEngine r3, boolean r4) {
        super(r2);
        this.mDisconnected = new AtomicBoolean(false);
        this.mRequestCompleted = new AtomicBoolean(false);
        this.mFixCancelRequestReport = false;
        this.mCronetEngine = r3;
        this.mMessageLoop = new MessageLoop();
        if (r4 == false) goto L5;
        CronetInputStream r5 = new CronetInputStreamWithTTBuffer(this);
    L6:
        this.mInputStream = r5;
        this.mRequestHeaders = new ArrayList();
        this.mCookieHandler = CookieHandler.getDefault();
        this.mRequestCookieSource = -1;
        return;
    L5:
        r5 = new CronetInputStream(this);
        goto L6
    }

    private Map<String, String> GetCookieMap(URI r11) {
        HashMap r0 = new HashMap();
        if ((this.mRequestTypeFlags & 2) > 0) goto L67;
        if (isAllowCredentials() == false) goto L67;
        HashMap r1 = new HashMap();
        List<Pair<String, String>> r2 = this.mRequestHeaders;
        if (r2 == null) goto L16;
        Iterator<Pair<String, String>> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r1.get(r5), List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L15;
        r7 = new LinkedList();
    L15:
        r7.add(r6);
        r1.put(r5, r7);
    L16:
        r1.put(GET_REQUEST_COOKIE_SOURCE_FLAG, new LinkedList());
        r1.put(TT_COOKIE_REL_METRIC_FLAG, new LinkedList());
        if ((this.mRequestTypeFlags & 1) == 0) goto L19;
        r1.put(WEBVIEW_REQUEST_FLAG, new LinkedList());
    L19:
        Map<String, List<String>> r8 = null;
    L27:
        e = move-exception;
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L31:
        if (r8 != null) goto L33;
    L65:
        return r0;
    L33:
        if (r8.size() <= 0) goto L65;
        Iterator<Map.Entry<String, List<String>>> r12 = r8.entrySet().iterator();
    L36:
        if (r12.hasNext() == false) goto L65;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");
        int r13 = 0;
        if (GET_REQUEST_COOKIE_SOURCE_FLAG.equals(r10) == false) goto L45;
        if (((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L45;
        this.mRequestCookieSource = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin")).get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
    L49:
        StringBuilder r14 = new StringBuilder();
        if (SS_COOKIE.equalsIgnoreCase(r10) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r10) == true) goto L56;
        if ("Cookie2".equalsIgnoreCase(r10) == false) goto L36;
    L56:
        if (((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L36;
        Iterator r15 = ((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L59:
        if (r15.hasNext() == false) goto L64;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r13 <= 0) goto L63;
        r14.append("; ");
    L63:
        r14.append(r16);
        r13 = r13 + 1;
        goto L59
    L64:
        r0.put(r10, r14.toString());
    L43:
        this.mRequestCookieSource = -1;
    L45:
        if (TT_COOKIE_REL_METRIC_FLAG.equals(r10) == false) goto L49;
        if (((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L49;
        this.mCookieRelMetric = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin")).get(0), String.class, "com.obric.memorydata.plugin");
        goto L49
    L21:
        if (this.mCookieHandler != null) goto L23;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L27
    L23:
        CookieHandler r17 = this.mCookieHandler;     // Catch: Exception -> L27
        if (r17 == null) goto L31;
        r8 = r17.get(r11, r1);     // Catch: Exception -> L27
    L67:
        if (Logger.debug() == false) goto L69;
        Logger.d(TAG, "Do not read cookie from TTNet, url:" + r11);
    L69:
        return r0;
    }

    static /* synthetic */ UrlResponseInfo access$000(CronetHttpURLConnection r0) {
        return r0.mResponseInfo;
    }

    static /* synthetic */ UrlResponseInfo access$002(CronetHttpURLConnection r0, UrlResponseInfo r1) {
        r0.mResponseInfo = r1;
        return r1;
    }

    static /* synthetic */ UrlRequest access$1000(CronetHttpURLConnection r0) {
        return r0.mRequest;
    }

    static /* synthetic */ boolean access$102(CronetHttpURLConnection r0, boolean r1) {
        r0.mHasResponseHeadersOrCompleted = r1;
        return r1;
    }

    static /* synthetic */ Map access$1100(CronetHttpURLConnection r0, URI r1) {
        return r0.GetCookieMap(r1);
    }

    static /* synthetic */ IOException access$1200(CronetHttpURLConnection r0) {
        return r0.mException;
    }

    static /* synthetic */ IOException access$1202(CronetHttpURLConnection r0, IOException r1) {
        r0.mException = r1;
        return r1;
    }

    static /* synthetic */ IOException access$1300(CronetHttpURLConnection r0, CronetException r1) {
        return r0.tryConvertCronetException(r1);
    }

    static /* synthetic */ CronetInputStream access$1400(CronetHttpURLConnection r0) {
        return r0.mInputStream;
    }

    static /* synthetic */ CronetOutputStream access$1500(CronetHttpURLConnection r0) {
        return r0.mOutputStream;
    }

    static /* synthetic */ AtomicBoolean access$1600(CronetHttpURLConnection r0) {
        return r0.mRequestCompleted;
    }

    static /* synthetic */ Map access$200(CronetHttpURLConnection r0) {
        return r0.getAllHeaders();
    }

    static /* synthetic */ void access$300(CronetHttpURLConnection r2, String r3, Map r4) {
        r2.saveResponseCookie(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ MessageLoop access$400(CronetHttpURLConnection r0) {
        return r0.mMessageLoop;
    }

    static /* synthetic */ boolean access$500(CronetHttpURLConnection r0) {
        return r0.mOnRedirectCalled;
    }

    static /* synthetic */ boolean access$502(CronetHttpURLConnection r0, boolean r1) {
        r0.mOnRedirectCalled = r1;
        return r1;
    }

    static /* synthetic */ URL access$600(CronetHttpURLConnection r0) {
        return r0.url;
    }

    static /* synthetic */ boolean access$700(CronetHttpURLConnection r0) {
        return r0.instanceFollowRedirects;
    }

    static /* synthetic */ URL access$802(CronetHttpURLConnection r0, URL r1) {
        r0.url = r1;
        return r1;
    }

    static /* synthetic */ boolean access$900(CronetHttpURLConnection r0) {
        return r0.instanceFollowRedirects;
    }

    private void checkHasResponseHeaders() {
        if (this.mHasResponseHeadersOrCompleted == false) goto L10;
        IOException r0 = this.mException;
        if (r0 != null) goto L8;
        Objects.requireNonNull(this.mResponseInfo, "Response info is null when there is no exception.");
        return;
    L8:
        throw r0;
    L10:
        throw new IllegalStateException("No response.");
    }

    private boolean checkTrafficStatsTag() {
        if (this.mTrafficStatsTagSet == false) goto L5;
        return true;
    L5:
        int r0 = TrafficStats.getThreadStatsTag();
        if (r0 == (-1)) goto L9;
        this.mTrafficStatsTag = r0;
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
        int r0 = TrafficStats.getThreadStatsUid();
        if (r0 == (-1)) goto L13;
        this.mTrafficStatsUid = r0;
        this.mTrafficStatsUidSet = true;
    L13:
        return this.mTrafficStatsUidSet;
    }

    private void executeMessageLoop(int r3) {
        this.mMessageLoop.loop(r3);     // Catch: Exception -> L4 SocketTimeoutException -> L7
    L14:
        return;
    L7:
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L13;
        r0.appTimeout();
    L6:
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r3 / 2);
        return;
    L13:
        return;
    L4:
        e = move-exception;
        cancelWithException("Unexpected request usage, caught in CronetHttpURLConnection.", e);
        goto L6
    }

    private int findRequestProperty(String r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mRequestHeaders.size()) goto L9;
        if (((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.mRequestHeaders.get(r0), Pair.class, "com.obric.memorydata.plugin")).first, String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(r5) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private Map<String, List<String>> getAllHeaders() {
        Map<String, List<String>> r0 = this.mResponseHeadersMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        TreeMap r1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Map.Entry<String, String>> r2 = getAllHeadersAsList().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ArrayList r4 = new ArrayList();
        if (r1.containsKey(r3.getKey()) == false) goto L11;
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r1.get(r3.getKey()), Collection.class, "com.obric.memorydata.plugin"));
    L11:
        r4.add((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin"));
        r1.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), Collections.unmodifiableList(r4));
        goto L7
    L12:
        Map<String, List<String>> r5 = Collections.unmodifiableMap(r1);
        this.mResponseHeadersMap = r5;
        return r5;
    }

    private List<Map.Entry<String, String>> getAllHeadersAsList() {
        List<Map.Entry<String, String>> r0 = this.mResponseHeadersList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        this.mResponseHeadersList = new ArrayList();
        Iterator<Map.Entry<String, String>> r1 = this.mResponseInfo.getAllHeadersAsList().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.mResponseHeadersList.add(new AbstractMap.SimpleImmutableEntry(r2));
        goto L7
    L9:
        List<Map.Entry<String, String>> r3 = Collections.unmodifiableList(this.mResponseHeadersList);
        this.mResponseHeadersList = r3;
        return r3;
    }

    private Map.Entry<String, String> getHeaderFieldEntry(int r3) {
        getResponse();     // Catch: IOException -> L9
        List<Map.Entry<String, String>> r2 = getAllHeadersAsList();
        if (r3 < r2.size()) goto L8;
        return null;
    L8:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r2.get(r3), Map.Entry.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    private void getResponse() {
        CronetOutputStream r0 = this.mOutputStream;
        if (r0 == null) goto L8;
        r0.checkReceivedEnoughContent();
        if (isChunkedUpload() == false) goto L8;
        this.mOutputStream.close();
    L8:
        if (this.mHasResponseHeadersOrCompleted == true) goto L13;
        startRequest();
        if (Logger.debug() == false) goto L12;
        Logger.d("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
    L12:
        executeMessageLoop(getConnectTimeout() + getReadTimeout());
        this.mHasResponseHeadersOrCompleted = true;
    L13:
        checkHasResponseHeaders();
    }

    private long getStreamingModeContentLength() {
        long r0 = this.fixedContentLength;
        if (this.fixedContentLengthLong != (-1)) goto L5;
        return r0;
    L5:
        return this.fixedContentLengthLong;
    }

    private boolean isAllowCredentials() {
        String r1 = getRequestProperty("x-ttnet-bypass-cookie");
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return true;
    L5:
        if ("0".equals(r1) == false) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isChunkedUpload() {
        if (this.chunkLength <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void saveResponseCookie(String r4, Map<String, List<String>> r5) {
        Map<String, List<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (isAllowCredentials() == true) goto L9;
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Do not write cookie from TTNet, url:" + r4);
        return;
    L37:
        return;
    L9:
        if (Logger.debug() == false) goto L36;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder().append("Saving cookies for url: ");
        if (TextUtils.isEmpty(r4) == false) goto L13;
        String r2 = getURL().toString();
    L14:
        Logger.d(r0, r1.append(r2).toString());
        goto L36
    L13:
        r2 = r4;
    L36:
    L28:
        e = move-exception;
        if (Logger.debug() == false) goto L41;
        String r3 = TAG;
        StringBuilder r7 = new StringBuilder().append("Saving cookies failed for ");
        if (TextUtils.isEmpty(r4) == false) goto L34;
        r4 = getURL().toString();
    L34:
        Logger.d(r3, r7.append(r4).append(" e = ").append(e.getMessage()).toString());
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
        if (TextUtils.isEmpty(r4) == false) goto L23;
        this.mCookieHandler.put(uri(getURL()), r6);     // Catch: Exception -> L28
        return;
    L23:
        URI r8 = uri(new URL(r4));     // Catch: Exception -> L28
        if ((this.mRequestTypeFlags & 1) == 0) goto L26;
        TreeMap r9 = new TreeMap(r6);     // Catch: Exception -> L28
        r9.put(WEBVIEW_COOKIE, Collections.singletonList(getURL().getHost()));     // Catch: Exception -> L28
        this.mCookieHandler.put(r8, r9);     // Catch: Exception -> L28
        return;
    L26:
        this.mCookieHandler.put(r8, r6);     // Catch: Exception -> L28
    }

    private final void setRequestPropertyInternal(String r2, String r3, boolean r4) {
        if (this.connected == true) goto L13;
        int r0 = findRequestProperty(r2);
        if (r0 < 0) goto L10;
        if (r4 == false) goto L9;
        this.mRequestHeaders.remove(r0);
        goto L10
    L9:
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + r2 + ". crbug.com/432719.");
    L10:
        this.mRequestHeaders.add(Pair.create(r2, r3));
        return;
    L13:
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }

    private void startRequest() {
        if (this.connected == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("CronetHttpURLConnection", "start request url = " + getURL().toString());
    L8:
        ExperimentalUrlRequest.Builder r0 = (ExperimentalUrlRequest.Builder) ZeusTransformUtils.preCheckCast(this.mCronetEngine.newUrlRequestBuilder(getURL().toString(), new CronetUrlRequestCallback(this), this.mMessageLoop), ExperimentalUrlRequest.Builder.class, "com.obric.memorydata.plugin");
        if (this.doOutput == true) goto L11;
    L27:
        long r3 = System.nanoTime();
        Map<String, String> r1 = GetCookieMap(uri(getURL()));
        if (r1 != null) goto L30;
    L35:
        long r5 = (System.nanoTime() - r3) / 1000;
        Iterator<Pair<String, String>> r2 = this.mRequestHeaders.iterator();
    L37:
        if (r2.hasNext() == false) goto L40;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        r0.addHeader((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.memorydata.plugin"));
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r0.disableCache();
    L42:
        r0.setHttpMethod(this.method);
        if (checkTrafficStatsTag() == false) goto L46;
        r0.setTrafficStatsTag(this.mTrafficStatsTag);
    L46:
        if (checkTrafficStatsUid() == false) goto L48;
        r0.setTrafficStatsUid(this.mTrafficStatsUid);
    L48:
        r0.setPriority(this.mRequestPriority);
        r0.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r0.setSocketReadTimeout(this.mSocketReadTimeout);
        r0.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r0.setRequestTimeout(this.mRequestTimeout);
        r0.setRequestFinishedListener(this.mRequestFinishedListener);
        ExperimentalUrlRequest r6 = r0.build();
        this.mRequest = r6;
        int r7 = this.mRequestFlag;
        if (r7 == 0) goto L51;
        r6.setRequestFlag(r7);
    L51:
        int r8 = this.mRequestTypeFlags;
        if (r8 <= 0) goto L54;
        this.mRequest.setRequestTypeFlags(r8);
    L54:
        String r9 = this.mAuthCertUsername;
        if (r9 == null) goto L59;
        String r10 = this.mAuthCertPassword;
        if (r10 == null) goto L59;
        this.mRequest.setAuthCredentials(r9, r10);
    L59:
        this.mRequest.setAddCookieCostUs(r5);
        this.mRequest.setRequestCookieSource(this.mRequestCookieSource);
        this.mRequest.setCookieRelMetric(this.mCookieRelMetric);
        this.mRequest.start();
        long r11 = this.mThrottleNetSpeed;
        if (r11 <= 0) goto L62;
        this.mRequest.setThrottleNetSpeed(r11);
    L62:
        this.connected = true;
        return;
    L30:
        if (r1.isEmpty() == true) goto L35;
        Iterator<Map.Entry<String, String>> r12 = r1.entrySet().iterator();
    L33:
        if (r12.hasNext() == false) goto L35;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.addHeader((String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r13.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L33
    L11:
        if (this.method.equals(HttpMethodContrants.GET) == false) goto L13;
        this.method = "POST";
    L13:
        CronetOutputStream r14 = this.mOutputStream;
        if (r14 == null) goto L22;
        r0.setUploadDataProvider(r14.getUploadDataProvider(), this.mMessageLoop);
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
        addRequestProperty(CONTENT_LENGTH, "0");
        goto L25
    }

    private IOException tryConvertCronetException(CronetException r3) {
        if (ZeusTransformUtils.instanceOf(r3, NetworkException.class) == true) goto L6;
        return r3;
    L6:
        switch(((NetworkException) ZeusTransformUtils.preCheckCast(r3, NetworkException.class, "com.obric.memorydata.plugin")).getErrorCode()) {
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
        IOException r2 = new NoRouteToHostException(r3.getMessage());
    L16:
        return r2;
    L9:
        r2 = new SocketException("reset by peer " + r3.getMessage());
        goto L16
    L10:
        r2 = new ConnectTimeoutException(r3.getMessage());
        goto L16
    L11:
        r2 = new ConnectException(r3.getMessage());
        goto L16
    L12:
        r2 = new SocketTimeoutException(r3.getMessage());
        goto L16
    L13:
        r2 = new ConnectException(r3.getMessage());
        goto L16
    L14:
        r2 = new UnknownHostException(r3.getMessage());
        goto L16
    L17:
        return r3;
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r2, String r3) {
        setRequestPropertyInternal(r2, r3, false);
    }

    public void cancelWithException(String r1, Throwable r2) {
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.cancelWithException(r1, r2);
        return;
    }

    public void configureConnection(String r6, Object... r7) {
        r6.hashCode();
        byte r4 = -1;
        switch(r6.hashCode()) {
            case -2098478356: goto L50;
            case -1400774487: goto L46;
            case -1262337831: goto L42;
            case -976756188: goto L38;
            case -722926986: goto L34;
            case -534987466: goto L30;
            case -107284268: goto L26;
            case 166051698: goto L22;
            case 423591456: goto L18;
            case 1221363607: goto L14;
            case 1880243345: goto L10;
            case 2141877079: goto L6;
            default: goto L54;
        };
    L6:
        if (r6.equals("enableFixCancelRequestReport") == false) goto L54;
        r4 = 11;
        goto L54
    L10:
        if (r6.equals("setRequestPriority") == false) goto L54;
        r4 = 10;
        goto L54
    L14:
        if (r6.equals("setSocketWriteTimeout") == false) goto L54;
        r4 = 9;
        goto L54
    L18:
        if (r6.equals("setRequestTypeFlags") == false) goto L54;
        r4 = 8;
        goto L54
    L22:
        if (r6.equals("setAuthCredentials") == false) goto L54;
        r4 = 7;
        goto L54
    L26:
        if (r6.equals("setRequestTimeout") == false) goto L54;
        r4 = 6;
        goto L54
    L30:
        if (r6.equals("setSocketReadTimeout") == false) goto L54;
        r4 = 5;
        goto L54
    L34:
        if (r6.equals("setThrottleNetSpeed") == false) goto L54;
        r4 = 4;
        goto L54
    L38:
        if (r6.equals("setOutputStreamBufferSize") == false) goto L54;
        r4 = 3;
        goto L54
    L42:
        if (r6.equals("setRequestFlag") == false) goto L54;
        r4 = 2;
        goto L54
    L46:
        if (r6.equals("setInputStreamBufferSize") == false) goto L54;
        r4 = 1;
        goto L54
    L50:
        if (r6.equals("setSocketConnectTimeout") == false) goto L54;
        r4 = 0;
    L54:
        switch(r4) {
            case 0: goto L70;
            case 1: goto L69;
            case 2: goto L68;
            case 3: goto L67;
            case 4: goto L64;
            case 5: goto L63;
            case 6: goto L62;
            case 7: goto L61;
            case 8: goto L60;
            case 9: goto L59;
            case 10: goto L58;
            case 11: goto L57;
            default: goto L56;
        };
    L57:
        ParamChecker.check(new Class[0], r7);
        this.mFixCancelRequestReport = true;
        return;
    L58:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestPriority = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L59:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mSocketWriteTimeout = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L60:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestTypeFlags = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L61:
        ParamChecker.check(new Class[]{String.class, String.class}, r7);
        this.mAuthCertUsername = (String) ZeusTransformUtils.preCheckCast(r7[0], String.class, "com.obric.memorydata.plugin");
        this.mAuthCertPassword = (String) ZeusTransformUtils.preCheckCast(r7[1], String.class, "com.obric.memorydata.plugin");
        return;
    L62:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestTimeout = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L63:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mSocketReadTimeout = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L64:
        ParamChecker.check(new Class[]{Long.TYPE}, r7);
        long r8 = ((Long) ZeusTransformUtils.preCheckCast(r7[0], Long.class, "com.obric.memorydata.plugin")).longValue();
        this.mThrottleNetSpeed = r8;
        UrlRequest r5 = this.mRequest;
        if (r5 == null) goto L79;
        r5.setThrottleNetSpeed(r8);
        return;
    L79:
        return;
    L67:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mOutputStreamBufferSize = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L68:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mRequestFlag = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L69:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mInputStreamBufferSize = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L70:
        ParamChecker.check(new Class[]{Integer.TYPE}, r7);
        this.mSocketConnectTimeout = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L56:
        throw new IllegalArgumentException("Unknown method name: " + r6);
    }

    @Override // java.net.URLConnection
    public void connect() {
        getOutputStream();
        startRequest();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected == false) goto L27;
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L28;
        r0.cancel();
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        if (this.mDisconnected.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        if (this.mFixCancelRequestReport == true) goto L14;
        return;
    L14:
        if (this.mRequestCompleted.get() == false) goto L17;
        return;
    L17:
        if (this.mMessageLoop.onValidThread() == true) goto L19;
        return;
    L19:
        if (this.mMessageLoop.isRunning() == true) goto L30;
        this.mMessageLoop.loop(50);     // Catch: Exception -> L22
        return;
    L30:
        return;
    L28:
        return;
    }

    public void enableFixCancelRequestReport() {
        this.mFixCancelRequestReport = true;
    }

    public int getCronetInternalErrorCode() {
        if (ZeusTransformUtils.instanceOf(this.mException, NetworkException.class) == false) goto L7;
        return ((NetworkException) ZeusTransformUtils.preCheckCast(this.mException, NetworkException.class, "com.obric.memorydata.plugin")).getCronetInternalErrorCode();
    L7:
        if (ZeusTransformUtils.instanceOf(this.mException, TTRequestCanceledException.class) == true) goto L9;
        return 0;
    L9:
        return ((TTRequestCanceledException) ZeusTransformUtils.preCheckCast(this.mException, TTRequestCanceledException.class, "com.obric.memorydata.plugin")).getCronetInternalErrorCode();
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
    public final String getHeaderField(int r2) {
        Map.Entry<String, String> r1 = getHeaderFieldEntry(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r3) {
        getResponse();     // Catch: IOException -> L9
        Map<String, List<String>> r2 = getAllHeaders();
        if (r2.containsKey(r3) == true) goto L7;
        return null;
    L7:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2.get(r3), List.class, "com.obric.memorydata.plugin");
        return (String) ZeusTransformUtils.preCheckCast(r4.get(r4.size() - 1), String.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r2) {
        Map.Entry<String, String> r1 = getHeaderFieldEntry(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
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
        if (this.instanceFollowRedirects == true) goto L10;
        if (this.mOnRedirectCalled == false) goto L10;
        throw new IOException("Cannot read response body of a redirect.");
    L10:
        if (this.mResponseInfo.getHttpStatusCode() >= 400) goto L14;
        return this.mInputStream;
    L14:
        throw new FileNotFoundException(this.url.toString());
    }

    public int getInputStreamBufferSize() {
        return this.mInputStreamBufferSize;
    }

    void getMoreData(ByteBuffer r2) {
        UrlRequest r0 = this.mRequest;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.read(r2);
        executeMessageLoop(getReadTimeout());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        if (this.mOutputStream != null) goto L27;
        if (this.doOutput == false) goto L27;
        if (this.connected == true) goto L25;
        if (isChunkedUpload() == false) goto L12;
        this.mOutputStream = new CronetChunkedOutputStream(this, this.chunkLength, this.mMessageLoop);
    L11:
        startRequest();
        goto L27
    L12:
        long r0 = getStreamingModeContentLength();
        if (r0 == (-1)) goto L20;
        CronetFixedModeOutputStream r2 = new CronetFixedModeOutputStream(this, r0, this.mOutputStreamBufferSize, this.mMessageLoop);
        this.mOutputStream = r2;
        if (r0 != 0) goto L11;
        setFixedLengthStreamingMode((int) r2.getUploadDataProvider().getLength());
        if (getRequestProperty(CONTENT_LENGTH) != null) goto L19;
        addRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L11
    L19:
        setRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L11
    L20:
        Log.d(TAG, "Outputstream is being buffered in memory.", new Object[0]);
        String r1 = getRequestProperty(CONTENT_LENGTH);
        if (r1 != null) goto L23;
        this.mOutputStream = new CronetBufferedOutputStream(this);
        goto L27
    L23:
        this.mOutputStream = new CronetBufferedOutputStream(this, Long.parseLong(r1));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.mOutputStream;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (this.connected == true) goto L15;
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Pair<String, String>> r6 = this.mRequestHeaders.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin");
        if (r0.containsKey(r1.first) == true) goto L11;
        ArrayList r2 = new ArrayList();
        r2.add((String) ZeusTransformUtils.preCheckCast(r1.second, String.class, "com.obric.memorydata.plugin"));
        r0.put((String) ZeusTransformUtils.preCheckCast(r1.first, String.class, "com.obric.memorydata.plugin"), Collections.unmodifiableList(r2));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r0);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r2) {
        int r3 = findRequestProperty(r2);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.mRequestHeaders.get(r3), Pair.class, "com.obric.memorydata.plugin")).second, String.class, "com.obric.memorydata.plugin");
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
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.appTimeout();
        return;
    }

    public void setAuthCredentials(String r1, String r2) {
        this.mAuthCertUsername = r1;
        this.mAuthCertPassword = r2;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r1) {
        super.setConnectTimeout(r1);
    }

    public void setInputStreamBufferSize(int r1) {
        this.mInputStreamBufferSize = r1;
    }

    public void setOutputStreamBufferSize(int r1) {
        this.mOutputStreamBufferSize = r1;
    }

    public void setRequestFinishedListener(RequestFinishedInfo.Listener r1) {
        this.mRequestFinishedListener = r1;
    }

    public void setRequestFlag(int r1) {
        this.mRequestFlag = r1;
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r2) {
        if (HttpMethodContrants.PATCH.equals(r2) == true) goto L5;
        super.setRequestMethod(r2);
        return;
    L5:
        if (this.connected == true) goto L8;
        this.method = r2;
        return;
    L8:
        throw new ProtocolException("Can't reset method: already connected");
    }

    public void setRequestPriority(int r1) {
        this.mRequestPriority = r1;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String r2, String r3) {
        setRequestPropertyInternal(r2, r3, true);
    }

    public void setRequestTimeout(int r1) {
        this.mRequestTimeout = r1;
    }

    public void setRequestTypeFlags(int r2) {
        this.mRequestTypeFlags = r2 | this.mRequestTypeFlags;
    }

    public void setSocketConnectTimeout(int r1) {
        this.mSocketConnectTimeout = r1;
    }

    public void setSocketReadTimeout(int r1) {
        this.mSocketReadTimeout = r1;
    }

    public void setSocketWriteTimeout(int r1) {
        this.mSocketWriteTimeout = r1;
    }

    public void setThrottleNetSpeed(long r1) {
        this.mThrottleNetSpeed = r1;
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.setThrottleNetSpeed(r1);
        return;
    }

    public void setTrafficStatsTag(int r2) {
        if (this.connected == true) goto L7;
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    public void setTrafficStatsUid(int r2) {
        if (this.connected == true) goto L7;
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    public URI uri(URL r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r2 = r3.toString();
        return new URI(r2);
    L8:
        e = move-exception;
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L16:
        return URI.create(r2.substring(0, r2.indexOf("?")));
    L15:
        throw new RuntimeException(e);
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }
}
