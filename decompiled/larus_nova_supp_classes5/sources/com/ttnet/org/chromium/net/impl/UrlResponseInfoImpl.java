package com.ttnet.org.chromium.net.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public Map<String, List<String>> getAsMap() {
            Map<String, List<String>> r0 = this.mHeadersMap;
            if (r0 == null) goto L5;
            return r0;
        L5:
            TreeMap r1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator<Map.Entry<String, String>> r2 = this.mAllHeadersList.iterator();
        L7:
            if (r2.hasNext() == false) goto L12;
            Map.Entry<String, String> r3 = r2.next();
            ArrayList r4 = new ArrayList();
            if (r1.containsKey(r3.getKey()) == false) goto L11;
            r4.addAll((Collection) r1.get(r3.getKey()));
        L11:
            r4.add(r3.getValue());
            r1.put(r3.getKey(), Collections.unmodifiableList(r4));
            goto L7
        L12:
            Map<String, List<String>> r5 = Collections.unmodifiableMap(r1);
            this.mHeadersMap = r5;
            return r5;
        }

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public List<Map.Entry<String, String>> getAsList() {
            return this.mAllHeadersList;
        }

        public HeaderBlockImpl(List<Map.Entry<String, String>> r1) {
            this.mAllHeadersList = r1;
        }
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
    public long getReceivedByteCount() {
        return this.mReceivedByteCount.get();
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public String getUrl() {
        List<String> r0 = this.mResponseInfoUrlChain;
        return (String) ListProtector.get(r0, r0.size() - 1);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", new Object[]{Integer.toHexString(System.identityHashCode(this)), getUrl(), getUrlChain().toString(), Integer.valueOf(getHttpStatusCode()), getHttpStatusText(), getAllHeadersAsList().toString(), Boolean.valueOf(wasCached()), getNegotiatedProtocol(), getProxyServer(), Long.valueOf(getReceivedByteCount())});
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
    public List<String> getUrlChain() {
        return this.mResponseInfoUrlChain;
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public boolean wasCached() {
        return this.mWasCached;
    }

    public void setReceivedByteCount(long r2) {
        this.mReceivedByteCount.set(r2);
    }

    public UrlResponseInfoImpl(List<String> r11, int r12, String r13, List<Map.Entry<String, String>> r14, boolean r15, String r16, String r17) {
        this(r11, r12, r13, r14, r15, r16, r17, 0);
    }

    public UrlResponseInfoImpl(List<String> r1, int r2, String r3, List<Map.Entry<String, String>> r4, boolean r5, String r6, String r7, long r8) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(r1);
        this.mHttpStatusCode = r2;
        this.mHttpStatusText = r3;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(r4));
        this.mWasCached = r5;
        this.mNegotiatedProtocol = r6;
        this.mProxyServer = r7;
        this.mReceivedByteCount = new AtomicLong(r8);
    }
}
