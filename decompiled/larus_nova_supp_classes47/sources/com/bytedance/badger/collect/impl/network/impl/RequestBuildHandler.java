package com.bytedance.badger.collect.impl.network.impl;

import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.utils.KLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RequestBuildHandler implements IChainHandler {
    public RequestBuildHandler() {
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ long getRetryDelay(int r3) {
        return IChainHandler.CC.$default$getRetryDelay(this, r3);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public final /* synthetic */ boolean shouldRetry(TTResponse r1, int r2) {
        return IChainHandler.CC.$default$shouldRetry(this, r1, r2);
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public TTResponse handle(IChainHandler.IChain r4) throws Exception {
        TTRequest r0 = r4.getRequest();
        r0.setBaseUrl(appendParamsToUrl(r0.getBaseUrl(), r0.getQueryParams()));
        if (BadgerCollectApi.commonConfig == null) goto L8;
        if (BadgerCollectApi.commonConfig.getRequestHeaderTag() == null) goto L8;
        r0.getHeaders().putAll(BadgerCollectApi.commonConfig.getRequestHeaderTag());     // Catch: Throwable -> L10
    L8:
        KLog.d(Constants.TAGS.NETWORK, "RequestBuildHandler# build a request - " + r0);
        return r4.process(r0);
    }

    public String appendParamsToUrl(String r5, Map<String, String> r6) throws UnsupportedEncodingException {
        if (r6 != null) goto L4;
        return r5;
    L4:
        if (r6.isEmpty() == true) goto L17;
        StringBuilder r0 = new StringBuilder(r5);
        String r1 = "?";
        if (r5.contains("?") == false) goto L9;
        r1 = "&";
    L9:
        r0.append(r1);
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        Map.Entry<String, String> r8 = r7.next();
        String r2 = URLEncoder.encode(r8.getKey(), "UTF-8");
        String r9 = URLEncoder.encode(r8.getValue(), "UTF-8");
        r0.append(r2);
        r0.append("=");
        r0.append(r9);
        r0.append("&");
        goto L11
    L13:
        r0.deleteCharAt(r0.length() - 1);
        return r0.toString();
    L17:
        return r5;
    }
}
