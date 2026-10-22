package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class UrlResponseInfoImpl extends UrlResponseInfo {
    private final HeaderBlockImpl mHeaders;
    private final int mHttpStatusCode;
    private final String mHttpStatusText;
    private final String mNegotiatedProtocol;
    private final String mProxyServer;
    private final AtomicLong mReceivedByteCount;
    private final List<String> mResponseInfoUrlChain;
    private final boolean mWasCached;

    public static final class HeaderBlockImpl extends UrlResponseInfo.HeaderBlock {
        private final List<Map.Entry<String, String>> mAllHeadersList;
        private Map<String, List<String>> mHeadersMap;

        HeaderBlockImpl(List<Map.Entry<String, String>> r10) {
            this.mAllHeadersList = r10;
        }

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public List<Map.Entry<String, String>> getAsList() {
            return this.mAllHeadersList;
        }

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public Map<String, List<String>> getAsMap() {
            Map<String, List<String>> r10 = this.mHeadersMap;
            if (r10 == null) goto L5;
            return r10;
        L5:
            TreeMap r11 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator<Map.Entry<String, String>> r12 = this.mAllHeadersList.iterator();
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
            this.mHeadersMap = r15;
            return r15;
        }
    }

    @Deprecated
    public UrlResponseInfoImpl(List<String> r11, int r12, String r13, List<Map.Entry<String, String>> r14, boolean r15, String r16, String r17) {
        this(r11, r12, r13, r14, r15, r16, r17, 0);
    }

    public UrlResponseInfoImpl(List<String> r10, int r11, String r12, List<Map.Entry<String, String>> r13, boolean r14, String r15, String r16, long r17) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(r10);
        this.mHttpStatusCode = r11;
        this.mHttpStatusText = r12;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(r13));
        this.mWasCached = r14;
        this.mNegotiatedProtocol = r15;
        this.mProxyServer = r16;
        this.mReceivedByteCount = new AtomicLong(r17);
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public Map<String, List<String>> getAllHeaders() {
        return this.mHeaders.getAsMap();
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public List<Map.Entry<String, String>> getAllHeadersAsList() {
        return this.mHeaders.getAsList();
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getHttpStatusText() {
        return this.mHttpStatusText;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getNegotiatedProtocol() {
        return this.mNegotiatedProtocol;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getProxyServer() {
        return this.mProxyServer;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public long getReceivedByteCount() {
        return this.mReceivedByteCount.get();
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getUrl() {
        List<String> r10 = this.mResponseInfoUrlChain;
        return r10.get(r10.size() - 1);
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public List<String> getUrlChain() {
        return this.mResponseInfoUrlChain;
    }

    public void setReceivedByteCount(long r10) {
        this.mReceivedByteCount.set(r10);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", new Object[]{Integer.toHexString(System.identityHashCode(this)), getUrl(), getUrlChain().toString(), Integer.valueOf(getHttpStatusCode()), getHttpStatusText(), getAllHeadersAsList().toString(), Boolean.valueOf(wasCached()), getNegotiatedProtocol(), getProxyServer(), Long.valueOf(getReceivedByteCount())});
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public boolean wasCached() {
        return this.mWasCached;
    }
}
