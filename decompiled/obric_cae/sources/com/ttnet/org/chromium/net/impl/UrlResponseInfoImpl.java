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

        public HeaderBlockImpl(List<Map.Entry<String, String>> r8) {
            this.mAllHeadersList = r8;
        }

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public List<Map.Entry<String, String>> getAsList() {
            return this.mAllHeadersList;
        }

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public Map<String, List<String>> getAsMap() {
            Map<String, List<String>> r8 = this.mHeadersMap;
            if (r8 == null) goto L5;
            return r8;
        L5:
            TreeMap r10 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator<Map.Entry<String, String>> r11 = this.mAllHeadersList.iterator();
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
            this.mHeadersMap = r14;
            return r14;
        }
    }

    @Deprecated
    public UrlResponseInfoImpl(List<String> r11, int r12, String r13, List<Map.Entry<String, String>> r14, boolean r15, String r16, String r17) {
        this(r11, r12, r13, r14, r15, r16, r17, 0);
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
        List<String> r8 = this.mResponseInfoUrlChain;
        return r8.get(r8.size() - 1);
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public List<String> getUrlChain() {
        return this.mResponseInfoUrlChain;
    }

    public void setReceivedByteCount(long r8) {
        this.mReceivedByteCount.set(r8);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", new Object[]{Integer.toHexString(System.identityHashCode(this)), getUrl(), getUrlChain().toString(), Integer.valueOf(getHttpStatusCode()), getHttpStatusText(), getAllHeadersAsList().toString(), Boolean.valueOf(wasCached()), getNegotiatedProtocol(), getProxyServer(), Long.valueOf(getReceivedByteCount())});
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public boolean wasCached() {
        return this.mWasCached;
    }

    public UrlResponseInfoImpl(List<String> r8, int r10, String r11, List<Map.Entry<String, String>> r12, boolean r13, String r14, String r15, long r16) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(r8);
        this.mHttpStatusCode = r10;
        this.mHttpStatusText = r11;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(r12));
        this.mWasCached = r13;
        this.mNegotiatedProtocol = r14;
        this.mProxyServer = r15;
        this.mReceivedByteCount = new AtomicLong(r16);
    }
}
