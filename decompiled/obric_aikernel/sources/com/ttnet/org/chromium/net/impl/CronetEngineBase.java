package com.ttnet.org.chromium.net.impl;

import androidx.annotation.Nullable;
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
    protected static final long DEFAULT_NETWORK_HANDLE = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Idempotency {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestPriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamPriority {
    }

    public CronetEngineBase() {
    }

    protected abstract ExperimentalBidirectionalStream createBidirectionalStream(String r10, BidirectionalStream.Callback r11, Executor r12, String r13, List<Map.Entry<String, String>> r14, int r15, boolean r16, Collection<Object> r17, boolean r18, int r19, boolean r110, int r111, long r112);

    protected abstract TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r10, Executor r11, int r12, List<String> r13, int r14, int r15, int r16);

    protected abstract UrlRequestBase createRequest(String r10, UrlRequest.Callback r11, Executor r12, int r13, Collection<Object> r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, boolean r110, int r111, @Nullable RequestFinishedInfo.Listener r112, int r113, long r114);

    protected abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r10, Executor r11, List<String> r12, int r13, String r14, long r15, int r16, long r17, String r18, int r19, String r110, Map<String, String> r111, Map<String, String> r112, boolean r113);

    protected abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r10, Executor r11, List<String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r10, Executor r11) {
        return new TTNetDiagnosisRequestBuilderImpl(r10, r11, this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r10, UrlRequest.Callback r11, Executor r12) {
        return new UrlRequestBuilderImpl(r10, r11, r12, this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r10, UrlRequest.Callback r11, Executor r12) {
        return newUrlRequestBuilder(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r10, Executor r11) {
        return new TTWebsocketConnectionBuilderImpl(r10, r11, this);
    }
}
