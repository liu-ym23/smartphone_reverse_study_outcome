package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UrlResponseInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
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

        HeaderBlockImpl(List<Map.Entry<String, String>> r3) {
            this.mAllHeadersList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ttnet.org.chromium.net.UrlResponseInfo.HeaderBlock
        public List<Map.Entry<String, String>> getAsList() {
            return this.mAllHeadersList;
        }

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
            this.mHeadersMap = r5;
            return r5;
        }
    }

    @Deprecated
    public UrlResponseInfoImpl(List<String> r13, int r14, String r15, List<Map.Entry<String, String>> r16, boolean r17, String r18, String r19) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"), r14, r15, (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin"), r17, r18, r19, 0);
    }

    public UrlResponseInfoImpl(List<String> r3, int r4, String r5, List<Map.Entry<String, String>> r6, boolean r7, String r8, String r9, long r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.mResponseInfoUrlChain = Collections.unmodifiableList(r11);
        this.mHttpStatusCode = r4;
        this.mHttpStatusText = r5;
        this.mHeaders = new HeaderBlockImpl(Collections.unmodifiableList(r12));
        this.mWasCached = r7;
        this.mNegotiatedProtocol = r8;
        this.mProxyServer = r9;
        this.mReceivedByteCount = new AtomicLong(r10);
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
        List<String> r2 = this.mResponseInfoUrlChain;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public List<String> getUrlChain() {
        return this.mResponseInfoUrlChain;
    }

    public void setReceivedByteCount(long r1) {
        this.mReceivedByteCount.set(r1);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", new Object[]{Integer.toHexString(System.identityHashCode(this)), getUrl(), getUrlChain().toString(), Integer.valueOf(getHttpStatusCode()), getHttpStatusText(), getAllHeadersAsList().toString(), Boolean.valueOf(wasCached()), getNegotiatedProtocol(), getProxyServer(), Long.valueOf(getReceivedByteCount())});
    }

    @Override // com.ttnet.org.chromium.net.UrlResponseInfo
    public boolean wasCached() {
        return this.mWasCached;
    }
}
