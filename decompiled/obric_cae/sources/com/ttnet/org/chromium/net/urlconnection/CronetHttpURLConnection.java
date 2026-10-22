package com.ttnet.org.chromium.net.urlconnection;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
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
import defpackage.b;
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
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    private static final String CONTENT_LENGTH = "Content-Length";
    public static final String SS_COOKIE = "X-SS-Cookie";
    private static final String TAG = "CronetHttpURLConnection";
    private CookieHandler mCookieHandler;
    private final CronetEngine mCronetEngine;
    private IOException mException;
    private boolean mHasResponseHeadersOrCompleted;
    private CronetInputStream mInputStream;
    private int mInputStreamBufferSize;
    private final MessageLoop mMessageLoop;
    private boolean mOnRedirectCalled;
    private CronetOutputStream mOutputStream;
    private UrlRequest mRequest;
    private RequestFinishedInfo mRequestFinishedInfo;
    private int mRequestFlag;
    private final List<Pair<String, String>> mRequestHeaders;
    private volatile String mRequestLog;
    private CountDownLatch mRequestLogCountDownLatch;
    private int mRequestPriority;
    private int mRequestTimeout;
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

    public class CronetUrlRequestCallback extends UrlRequest.Callback {
        final /* synthetic */ CronetHttpURLConnection this$0;

        public CronetUrlRequestCallback(CronetHttpURLConnection r8) {
            this.this$0 = r8;
        }

        private void setRequestEnd() {
            CronetHttpURLConnection r8 = this.this$0;
            CronetHttpURLConnection.access$1602(r8, CronetHttpURLConnection.access$1100(r8).getRequestLog());
        L20:
            th = move-exception;
            th.printStackTrace();
        L22:
            CronetHttpURLConnection.access$102(this.this$0, true);
            CronetHttpURLConnection.access$500(this.this$0).quit();
            return;
        L4:
            if (CronetHttpURLConnection.access$1300(this.this$0) == null) goto L22;
            if (CronetHttpURLConnection.access$1500(this.this$0) != null) goto L8;
        L12:
            String r10 = null;
        L14:
            if (TextUtils.isEmpty(r10) == true) goto L22;
            String r11 = CronetHttpURLConnection.access$1300(this.this$0).getMessage();     // Catch: Throwable -> L20
            StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L20
            r12.append(r10);     // Catch: Throwable -> L20
            r12.append("|");     // Catch: Throwable -> L20
            if (r11 != null) goto L18;
            r11 = "null";
        L18:
            r12.append(r11);     // Catch: Throwable -> L20
            Reflect.on(CronetHttpURLConnection.access$1300(this.this$0)).set("detailMessage", r12.toString());     // Catch: Throwable -> L20
            goto L22
        L8:
            if (CronetHttpURLConnection.access$1500(this.this$0).getMetrics() == null) goto L12;
            if (CronetHttpURLConnection.access$1500(this.this$0).getMetrics().getPeerAddr() == null) goto L12;
            r10 = CronetHttpURLConnection.access$1500(this.this$0).getMetrics().getPeerAddr() + BdimCategoryConstants.SEPARATOR_COLON + CronetHttpURLConnection.access$1500(this.this$0).getMetrics().getPeerPort();     // Catch: Throwable -> L20
            goto L14
        }

        private void setResponseDataCompleted(IOException r8, boolean r10) {
            CronetHttpURLConnection.access$1302(this.this$0, r8);
            if (CronetHttpURLConnection.access$1800(this.this$0) == null) goto L6;
            CronetHttpURLConnection.access$1800(this.this$0).setResponseDataCompleted(r8);
        L6:
            if (CronetHttpURLConnection.access$1900(this.this$0) == null) goto L8;
            CronetHttpURLConnection.access$1900(this.this$0).setRequestCompleted(r8);
        L8:
            CronetHttpURLConnection.access$102(this.this$0, true);
            if (r10 == true) goto L12;
            setRequestEnd();
            return;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r8, UrlResponseInfo r10) {
            CronetHttpURLConnection.access$002(this.this$0, r10);
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onCanceled loop quit url = " + this.this$0.getURL().toString());
        L6:
            if (CronetHttpURLConnection.access$1300(this.this$0) != null) goto L8;
            CronetHttpURLConnection.access$1302(this.this$0, new TTRequestCanceledException("request canceled, ErrorCode=11, InternalErrorCode=-999"));
        L8:
            setResponseDataCompleted(CronetHttpURLConnection.access$1300(this.this$0), false);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r8, UrlResponseInfo r10, CronetException r11) {
            if (r11 == null) goto L9;
            CronetHttpURLConnection.access$002(this.this$0, r10);
            CronetHttpURLConnection r12 = this.this$0;
            CronetHttpURLConnection.access$1302(r12, CronetHttpURLConnection.access$1400(r12, r11));
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onFailed url = " + this.this$0.getURL().toString());
        L6:
            setResponseDataCompleted(r11, true);
            return;
        L9:
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onMetricsCollected(UrlRequest r8, RequestFinishedInfo r10) {
            CronetHttpURLConnection.access$1502(this.this$0, r10);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onMetricsCollected loop quit url = " + this.this$0.getURL().toString());
        L5:
            setRequestEnd();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r8, UrlResponseInfo r10, ByteBuffer r11) {
            CronetHttpURLConnection.access$002(this.this$0, r10);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onReadCompleted loop quit url = " + this.this$0.getURL().toString());
        L5:
            CronetHttpURLConnection.access$500(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r8, UrlResponseInfo r10, String r11) {
            CronetHttpURLConnection.access$602(this.this$0, true);
            URL r12 = new URL(r11);     // Catch: MalformedURLException -> L28
            boolean r13 = r12.getHost().equals(CronetHttpURLConnection.access$700(this.this$0).getHost());     // Catch: MalformedURLException -> L28
            if (CronetHttpURLConnection.access$800(this.this$0) == false) goto L7;
            CronetHttpURLConnection.access$902(this.this$0, r12);     // Catch: MalformedURLException -> L28
        L7:
            if (CronetHttpURLConnection.access$1000(this.this$0) == false) goto L21;
            if (CronetHttpURLConnection.access$1100(this.this$0) == null) goto L32;
            if (r13 == true) goto L19;
            CronetHttpURLConnection.access$1100(this.this$0).RemoveRequestCookieHeader();     // Catch: MalformedURLException -> L28
            URL r14 = new URL(r11);     // Catch: MalformedURLException -> L28
            CronetHttpURLConnection r15 = this.this$0;     // Catch: MalformedURLException -> L28
            Map r16 = CronetHttpURLConnection.access$1200(r15, r15.uri(r14));     // Catch: MalformedURLException -> L28
            if (r16 == null) goto L19;
            if (r16.isEmpty() == true) goto L19;
            Iterator r17 = r16.entrySet().iterator();     // Catch: MalformedURLException -> L28
        L17:
            if (r17.hasNext() == false) goto L19;
            Map.Entry r18 = (Map.Entry) r17.next();     // Catch: MalformedURLException -> L28
            CronetHttpURLConnection.access$1100(this.this$0).AddRequestCookieHeader((String) r18.getKey(), (String) r18.getValue());     // Catch: MalformedURLException -> L28
        L19:
            CronetHttpURLConnection.access$1100(this.this$0).followRedirect();     // Catch: MalformedURLException -> L28
            return;
        L32:
            return;
        L21:
            CronetHttpURLConnection.access$002(this.this$0, r10);
            if (CronetHttpURLConnection.access$1100(this.this$0) == null) goto L25;
            setResponseDataCompleted(null, false);
        L25:
            if (Logger.debug() == false) goto L33;
            Logger.d("CronetHttpURLConnection", "onRedirectReceived loop quit url = " + this.this$0.getURL().toString());
            return;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRequestLogCollected(String r8, RequestFinishedInfo r10) {
            CronetHttpURLConnection.access$1602(this.this$0, r8);
            CronetHttpURLConnection.access$1502(this.this$0, r10);
            CronetHttpURLConnection.access$1700(this.this$0).countDown();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r8, UrlResponseInfo r10, String r11) {
            CronetHttpURLConnection.access$002(this.this$0, r10);
            CronetHttpURLConnection.access$102(this.this$0, true);
        L15:
            e = move-exception;
            if (Logger.debug() == false) goto L20;
            Logger.d(CronetHttpURLConnection.access$400(), "Saving cookies failed for " + this.this$0.getURL().toString() + " e = " + e.getMessage());
        L20:
            if (Logger.debug() == false) goto L22;
            Logger.d("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.this$0.getURL().toString());
        L22:
            CronetHttpURLConnection.access$500(this.this$0).quit();
            return;
        L4:
            if (CronetHttpURLConnection.access$000(this.this$0) == null) goto L20;
            Map<String, List<String>> r12 = CronetHttpURLConnection.access$200(this.this$0);     // Catch: Exception -> L15
            if (CronetHttpURLConnection.access$300(this.this$0) != null) goto L9;
            CronetHttpURLConnection.access$302(this.this$0, CookieHandler.getDefault());     // Catch: Exception -> L15
        L9:
            if (CronetHttpURLConnection.access$300(this.this$0) == null) goto L20;
            if (TextUtils.isEmpty(r11) == false) goto L13;
            CookieHandler r13 = CronetHttpURLConnection.access$300(this.this$0);     // Catch: Exception -> L15
            CronetHttpURLConnection r14 = this.this$0;     // Catch: Exception -> L15
            r13.put(r14.uri(r14.getURL()), r12);     // Catch: Exception -> L15
            goto L20
        L13:
            CronetHttpURLConnection.access$300(this.this$0).put(this.this$0.uri(new URL(r11)), r12);     // Catch: Exception -> L15
            goto L20
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r8, UrlResponseInfo r10) {
            CronetHttpURLConnection.access$002(this.this$0, r10);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onSucceeded url = " + this.this$0.getURL().toString());
        L5:
            setResponseDataCompleted(null, true);
        }
    }

    public CronetHttpURLConnection(URL r8, CronetEngine r10) {
        super(r8);
        this.mCronetEngine = r10;
        this.mMessageLoop = new MessageLoop();
        this.mInputStream = new CronetInputStream(this);
        this.mRequestHeaders = new ArrayList();
        this.mCookieHandler = CookieHandler.getDefault();
        this.mRequestLogCountDownLatch = new CountDownLatch(1);
    }

    private Map<String, String> GetCookieMap(URI r8) {
        HashMap r10 = new HashMap();
        HashMap r11 = new HashMap();
        List<Pair<String, String>> r12 = this.mRequestHeaders;
        if (r12 == null) goto L11;
        Iterator<Pair<String, String>> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        Pair<String, String> r14 = r13.next();
        String r15 = (String) r14.first;
        String r16 = (String) r14.second;
        List r17 = (List) r11.get(r15);
        if (r17 != null) goto L10;
        r17 = new LinkedList();
    L10:
        r17.add(r16);
        r11.put(r15, r17);
    L11:
        Map<String, List<String>> r18 = null;
    L19:
        e = move-exception;
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L23:
        if (r18 != null) goto L25;
    L45:
        return r10;
    L25:
        if (r18.size() <= 0) goto L45;
        Iterator<Map.Entry<String, List<String>>> r19 = r18.entrySet().iterator();
    L28:
        if (r19.hasNext() == false) goto L45;
        Map.Entry<String, List<String>> r20 = r19.next();
        String r21 = r20.getKey();
        StringBuilder r22 = new StringBuilder();
        if (SS_COOKIE.equalsIgnoreCase(r21) == true) goto L36;
        if ("Cookie".equalsIgnoreCase(r21) == true) goto L36;
        if ("Cookie2".equalsIgnoreCase(r21) == false) goto L28;
    L36:
        if (r20.getValue().isEmpty() == true) goto L28;
        Iterator<String> r23 = r20.getValue().iterator();
        int r24 = 0;
    L39:
        if (r23.hasNext() == false) goto L44;
        String r25 = r23.next();
        if (r24 <= 0) goto L43;
        r22.append("; ");
    L43:
        r22.append(r25);
        r24 = r24 + 1;
        goto L39
    L44:
        r10.put(r21, r22.toString());
        goto L28
    L13:
        if (this.mCookieHandler != null) goto L15;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L19
    L15:
        CookieHandler r26 = this.mCookieHandler;     // Catch: Exception -> L19
        if (r26 == null) goto L23;
        r18 = r26.get(r8, r11);     // Catch: Exception -> L19
        goto L23
    }

    public static /* synthetic */ UrlResponseInfo access$000(CronetHttpURLConnection r8) {
        return r8.mResponseInfo;
    }

    public static /* synthetic */ UrlResponseInfo access$002(CronetHttpURLConnection r8, UrlResponseInfo r10) {
        r8.mResponseInfo = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1000(CronetHttpURLConnection r8) {
        return ((HttpURLConnection) r8).instanceFollowRedirects;
    }

    public static /* synthetic */ boolean access$102(CronetHttpURLConnection r8, boolean r10) {
        r8.mHasResponseHeadersOrCompleted = r10;
        return r10;
    }

    public static /* synthetic */ UrlRequest access$1100(CronetHttpURLConnection r8) {
        return r8.mRequest;
    }

    public static /* synthetic */ Map access$1200(CronetHttpURLConnection r8, URI r10) {
        return r8.GetCookieMap(r10);
    }

    public static /* synthetic */ IOException access$1300(CronetHttpURLConnection r8) {
        return r8.mException;
    }

    public static /* synthetic */ IOException access$1302(CronetHttpURLConnection r8, IOException r10) {
        r8.mException = r10;
        return r10;
    }

    public static /* synthetic */ IOException access$1400(CronetHttpURLConnection r8, CronetException r10) {
        return r8.tryConvertCronetException(r10);
    }

    public static /* synthetic */ RequestFinishedInfo access$1500(CronetHttpURLConnection r8) {
        return r8.mRequestFinishedInfo;
    }

    public static /* synthetic */ RequestFinishedInfo access$1502(CronetHttpURLConnection r8, RequestFinishedInfo r10) {
        r8.mRequestFinishedInfo = r10;
        return r10;
    }

    public static /* synthetic */ String access$1602(CronetHttpURLConnection r8, String r10) {
        r8.mRequestLog = r10;
        return r10;
    }

    public static /* synthetic */ CountDownLatch access$1700(CronetHttpURLConnection r8) {
        return r8.mRequestLogCountDownLatch;
    }

    public static /* synthetic */ CronetInputStream access$1800(CronetHttpURLConnection r8) {
        return r8.mInputStream;
    }

    public static /* synthetic */ CronetOutputStream access$1900(CronetHttpURLConnection r8) {
        return r8.mOutputStream;
    }

    public static /* synthetic */ Map access$200(CronetHttpURLConnection r8) {
        return r8.getAllHeaders();
    }

    public static /* synthetic */ CookieHandler access$300(CronetHttpURLConnection r8) {
        return r8.mCookieHandler;
    }

    public static /* synthetic */ CookieHandler access$302(CronetHttpURLConnection r8, CookieHandler r10) {
        r8.mCookieHandler = r10;
        return r10;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ MessageLoop access$500(CronetHttpURLConnection r8) {
        return r8.mMessageLoop;
    }

    public static /* synthetic */ boolean access$602(CronetHttpURLConnection r8, boolean r10) {
        r8.mOnRedirectCalled = r10;
        return r10;
    }

    public static /* synthetic */ URL access$700(CronetHttpURLConnection r8) {
        return ((HttpURLConnection) r8).url;
    }

    public static /* synthetic */ boolean access$800(CronetHttpURLConnection r8) {
        return ((HttpURLConnection) r8).instanceFollowRedirects;
    }

    public static /* synthetic */ URL access$902(CronetHttpURLConnection r8, URL r10) {
        ((HttpURLConnection) r8).url = r10;
        return r10;
    }

    private void checkHasResponseHeaders() {
        if (this.mHasResponseHeadersOrCompleted == false) goto L13;
        IOException r8 = this.mException;
        if (r8 == null) goto L7;
        throw r8;
    L7:
        if (this.mResponseInfo == null) goto L10;
        return;
    L10:
        throw new NullPointerException("Response info is null when there is no exception.");
    L13:
        throw new IllegalStateException("No response.");
    }

    private void cronet_loop(int r8) {
        this.mMessageLoop.loop(r8);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L16:
        return;
    L8:
        UrlRequest r10 = this.mRequest;
        if (r10 == null) goto L15;
        r10.appTimeout();
    L7:
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r8 / 2);
        return;
    L15:
        return;
    L4:
        e = move-exception;
        setException(new IOException("Unexpected request usage, caught in CronetHttpURLConnection, caused by " + e));
        if (this.mRequest != null) goto L7;
    }

    private int findRequestProperty(String r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.mRequestHeaders.size()) goto L9;
        if (((String) this.mRequestHeaders.get(r10).first).equalsIgnoreCase(r8) == true) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return r10;
    L9:
        return -1;
    }

    private Map<String, List<String>> getAllHeaders() {
        Map<String, List<String>> r8 = this.mResponseHeadersMap;
        if (r8 == null) goto L5;
        return r8;
    L5:
        TreeMap r10 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Map.Entry<String, String>> r11 = getAllHeadersAsList().iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<String, String> r12 = r11.next();
        ArrayList r13 = new ArrayList();
        if (r10.containsKey(r12.getKey()) == false) goto L11;
        r13.addAll((Collection) r10.get(r12.getKey()));
    L11:
        r13.add(r12.getValue());
        r10.put(r12.getKey(), Collections.unmodifiableList(r13));
        goto L7
    L12:
        Map<String, List<String>> r14 = Collections.unmodifiableMap(r10);
        this.mResponseHeadersMap = r14;
        return r14;
    }

    private List<Map.Entry<String, String>> getAllHeadersAsList() {
        List<Map.Entry<String, String>> r8 = this.mResponseHeadersList;
        if (r8 == null) goto L5;
        return r8;
    L5:
        this.mResponseHeadersList = new ArrayList();
        Iterator<Map.Entry<String, String>> r10 = this.mResponseInfo.getAllHeadersAsList().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<String, String> r11 = r10.next();
        this.mResponseHeadersList.add(new AbstractMap.SimpleImmutableEntry(r11));
        goto L7
    L9:
        List<Map.Entry<String, String>> r12 = Collections.unmodifiableList(this.mResponseHeadersList);
        this.mResponseHeadersList = r12;
        return r12;
    }

    private Map.Entry<String, String> getHeaderFieldEntry(int r8) {
        getResponse();     // Catch: IOException -> L9
        List<Map.Entry<String, String>> r10 = getAllHeadersAsList();
        if (r8 < r10.size()) goto L8;
        return null;
    L8:
        return r10.get(r8);
    L9:
        return null;
    }

    private void getResponse() {
        CronetOutputStream r8 = this.mOutputStream;
        if (r8 == null) goto L8;
        r8.checkReceivedEnoughContent();
        if (isChunkedUpload() == false) goto L8;
        this.mOutputStream.close();
    L8:
        if (this.mHasResponseHeadersOrCompleted == true) goto L13;
        startRequest();
        if (Logger.debug() == false) goto L12;
        Logger.d("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
    L12:
        cronet_loop(getReadTimeout() + getConnectTimeout());
        this.mHasResponseHeadersOrCompleted = true;
    L13:
        checkHasResponseHeaders();
    }

    @SuppressLint({"NewApi"})
    private long getStreamingModeContentLength() {
        long r8 = ((HttpURLConnection) this).fixedContentLength;
        long r10 = getClass().getField("fixedContentLengthLong").getLong(this);     // Catch: Throwable -> L8
        if (r10 != (-1)) goto L7;
        return r8;
    L7:
        return r10;
    L12:
        return r8;
    }

    private boolean isChunkedUpload() {
        if (((HttpURLConnection) this).chunkLength <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setRequestPropertyInternal(String r8, String r10, boolean r11) {
        if (((HttpURLConnection) this).connected == true) goto L13;
        int r12 = findRequestProperty(r8);
        if (r12 < 0) goto L10;
        if (r11 == false) goto L9;
        this.mRequestHeaders.remove(r12);
        goto L10
    L9:
        throw new UnsupportedOperationException(b.d("Cannot add multiple headers of the same key, ", r8, ". crbug.com/432719."));
    L10:
        this.mRequestHeaders.add(Pair.create(r8, r10));
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
        ExperimentalUrlRequest.Builder r8 = (ExperimentalUrlRequest.Builder) this.mCronetEngine.newUrlRequestBuilder(getURL().toString(), new CronetUrlRequestCallback(this), this.mMessageLoop);
        if (((HttpURLConnection) this).doOutput == true) goto L11;
    L27:
        Map<String, String> r10 = GetCookieMap(uri(getURL()));
        if (r10 != null) goto L30;
    L35:
        Iterator<Pair<String, String>> r11 = this.mRequestHeaders.iterator();
    L37:
        if (r11.hasNext() == false) goto L40;
        Pair<String, String> r12 = r11.next();
        r8.addHeader((String) r12.first, (String) r12.second);
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r8.disableCache();
    L42:
        r8.setHttpMethod(((HttpURLConnection) this).method);
        if (this.mTrafficStatsTagSet == false) goto L46;
        r8.setTrafficStatsTag(this.mTrafficStatsTag);
    L46:
        if (this.mTrafficStatsUidSet == false) goto L48;
        r8.setTrafficStatsUid(this.mTrafficStatsUid);
    L48:
        r8.setPriority(this.mRequestPriority);
        r8.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r8.setSocketReadTimeout(this.mSocketReadTimeout);
        r8.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r8.setRequestTimeout(this.mRequestTimeout);
        ExperimentalUrlRequest r13 = r8.build();
        this.mRequest = r13;
        int r14 = this.mRequestFlag;
        if (r14 == 0) goto L51;
        r13.setRequestFlag(r14);
    L51:
        this.mRequest.start();
        long r15 = this.mThrottleNetSpeed;
        if (r15 <= 0) goto L54;
        this.mRequest.setThrottleNetSpeed(r15);
    L54:
        ((HttpURLConnection) this).connected = true;
        return;
    L30:
        if (r10.isEmpty() == true) goto L35;
        Iterator<Map.Entry<String, String>> r16 = r10.entrySet().iterator();
    L33:
        if (r16.hasNext() == false) goto L35;
        Map.Entry<String, String> r17 = r16.next();
        r8.addHeader(r17.getKey(), r17.getValue());
        goto L33
    L11:
        if (((HttpURLConnection) this).method.equals(HttpMethodContrants.GET) == false) goto L13;
        ((HttpURLConnection) this).method = HttpMethodContrants.POST;
    L13:
        CronetOutputStream r18 = this.mOutputStream;
        if (r18 == null) goto L22;
        r8.setUploadDataProvider(r18.getUploadDataProvider(), this.mMessageLoop);
        if (getRequestProperty(CONTENT_LENGTH) == null) goto L18;
    L20:
        this.mOutputStream.setConnected();
    L25:
        if (getRequestProperty("Content-Type") != null) goto L27;
        addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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

    private IOException tryConvertCronetException(CronetException r8) {
        if ((r8 instanceof NetworkException) == true) goto L6;
        return r8;
    L6:
        switch(((NetworkException) r8).getErrorCode()) {
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
        IOException r10 = new NoRouteToHostException(r8.getMessage());
    L16:
        return r10;
    L9:
        r10 = new SocketException("reset by peer " + r8.getMessage());
        goto L16
    L10:
        r10 = new ConnectTimeoutException(r8.getMessage());
        goto L16
    L11:
        r10 = new ConnectException(r8.getMessage());
        goto L16
    L12:
        r10 = new SocketTimeoutException(r8.getMessage());
        goto L16
    L13:
        r10 = new ConnectException(r8.getMessage());
        goto L16
    L14:
        r10 = new UnknownHostException(r8.getMessage());
        goto L16
    L17:
        return r8;
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r8, String r10) {
        setRequestPropertyInternal(r8, r10, false);
    }

    @Override // java.net.URLConnection
    public void connect() {
        getOutputStream();
        startRequest();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected == false) goto L8;
        UrlRequest r8 = this.mRequest;
        if (r8 == null) goto L9;
        r8.cancel();
        return;
    L9:
        return;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        getResponse();     // Catch: IOException -> L9
        if (this.mResponseInfo.getHttpStatusCode() < 400) goto L8;
        return this.mInputStream;
    L8:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int r8) {
        Map.Entry<String, String> r10 = getHeaderFieldEntry(r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getValue();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r8) {
        Map.Entry<String, String> r10 = getHeaderFieldEntry(r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getKey();
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

    public void getMoreData(ByteBuffer r8) {
        UrlRequest r10 = this.mRequest;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.read(r8);
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
        long r8 = getStreamingModeContentLength();
        if (r8 == (-1)) goto L20;
        CronetFixedModeOutputStream r10 = new CronetFixedModeOutputStream(this, r8, this.mMessageLoop);
        this.mOutputStream = r10;
        if (r8 != 0) goto L11;
        setFixedLengthStreamingMode((int) r10.getUploadDataProvider().getLength());
        if (getRequestProperty(CONTENT_LENGTH) != null) goto L19;
        addRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L11
    L19:
        setRequestProperty(CONTENT_LENGTH, Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L11
    L20:
        String r11 = getRequestProperty(CONTENT_LENGTH);
        if (r11 != null) goto L23;
        this.mOutputStream = new CronetBufferedOutputStream(this);
        goto L27
    L23:
        this.mOutputStream = new CronetBufferedOutputStream(this, Long.parseLong(r11));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.mOutputStream;
    }

    public RequestFinishedInfo getRequestFinishedInfo() {
        if (((HttpURLConnection) this).connected == false) goto L13;
        if (this.mRequest == null) goto L13;
        if (this.mRequestFinishedInfo != null) goto L13;
        this.mRequestLogCountDownLatch.await(50, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
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
        TreeMap r8 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Pair<String, String>> r10 = this.mRequestHeaders.iterator();
    L6:
        if (r10.hasNext() == false) goto L13;
        Pair<String, String> r11 = r10.next();
        if (r8.containsKey(r11.first) == true) goto L11;
        ArrayList r12 = new ArrayList();
        r12.add((String) r11.second);
        r8.put((String) r11.first, Collections.unmodifiableList(r12));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r8);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r8) {
        int r10 = findRequestProperty(r8);
        if (r10 >= 0) goto L5;
        return null;
    L5:
        return (String) this.mRequestHeaders.get(r10).second;
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
        UrlRequest r8 = this.mRequest;
        if (r8 == null) goto L6;
        r8.appTimeout();
        return;
    }

    @Override // java.net.URLConnection
    @UsedByReflection("SsCronetHttpClient.java")
    public void setConnectTimeout(int r8) {
        super.setConnectTimeout(r8);
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setException(IOException r8) {
        CronetInputStream r10 = this.mInputStream;
        if (r10 == null) goto L5;
        r10.setResponseDataCompleted(r8);
    L5:
        CronetOutputStream r11 = this.mOutputStream;
        if (r11 == null) goto L8;
        r11.setRequestCompleted(r8);
    L8:
        this.mHasResponseHeadersOrCompleted = true;
        this.mException = r8;
        UrlRequest r12 = this.mRequest;
        if (r12 == null) goto L12;
        r12.cancel();
        return;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setInputStreamBufferSize(int r8) {
        this.mInputStreamBufferSize = r8;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestFlag(int r8) {
        this.mRequestFlag = r8;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestPriority(int r8) {
        this.mRequestPriority = r8;
    }

    @Override // java.net.URLConnection
    @UsedByReflection("SsCronetHttpClient.java")
    public final void setRequestProperty(String r8, String r10) {
        setRequestPropertyInternal(r8, r10, true);
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestTimeout(int r8) {
        this.mRequestTimeout = r8;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketConnectTimeout(int r8) {
        this.mSocketConnectTimeout = r8;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketReadTimeout(int r8) {
        this.mSocketReadTimeout = r8;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketWriteTimeout(int r8) {
        this.mSocketWriteTimeout = r8;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setThrottleNetSpeed(long r8) {
        this.mThrottleNetSpeed = r8;
        UrlRequest r10 = this.mRequest;
        if (r10 == null) goto L6;
        r10.setThrottleNetSpeed(r8);
        return;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setTrafficStatsTag(int r8) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r8;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setTrafficStatsUid(int r8) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r8;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    public URI uri(URL r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = r8.toString();
        return new URI(r10);
    L8:
        e = move-exception;
        return URI.create(r10.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return URI.create(r10.substring(0, r10.indexOf("?")));
    L14:
        throw new RuntimeException(e);
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r8) {
        getResponse();     // Catch: IOException -> L9
        Map<String, List<String>> r10 = getAllHeaders();
        if (r10.containsKey(r8) == true) goto L7;
        return null;
    L7:
        List<String> r11 = r10.get(r8);
        return r11.get(r11.size() - 1);
    L9:
        return null;
    }
}
