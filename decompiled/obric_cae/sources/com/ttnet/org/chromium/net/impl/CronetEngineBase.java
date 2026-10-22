package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CronetEngineBase extends ExperimentalCronetEngine {

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestPriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamPriority {
    }

    public CronetEngineBase() {
    }

    public abstract ExperimentalBidirectionalStream createBidirectionalStream(String r8, BidirectionalStream.Callback r10, Executor r11, String r12, List<Map.Entry<String, String>> r13, int r14, boolean r15, Collection<Object> r16, boolean r17, int r18, boolean r19, int r110);

    public abstract TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r8, Executor r10, int r11, List<String> r12, int r13, int r14);

    public abstract UrlRequestBase createRequest(String r8, UrlRequest.Callback r10, Executor r11, int r12, Collection<Object> r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, boolean r19, int r110, RequestFinishedInfo.Listener r111);

    public abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r8, Executor r10, List<String> r11, int r12, String r13, long r14, int r15, long r16, String r17, int r18, String r19, Map<String, String> r110, Map<String, String> r111, boolean r112);

    public abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r8, Executor r10, List<String> r11, Map<String, String> r12, Map<String, String> r13, boolean r14);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r8, Executor r10) {
        return new TTNetDiagnosisRequestBuilderImpl(r8, r10, this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r8, UrlRequest.Callback r10, Executor r11) {
        return new UrlRequestBuilderImpl(r8, r10, r11, this);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r8, Executor r10) {
        return new TTWebsocketConnectionBuilderImpl(r8, r10, this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r8, UrlRequest.Callback r10, Executor r11) {
        return newUrlRequestBuilder(r8, r10, r11);
    }
}
