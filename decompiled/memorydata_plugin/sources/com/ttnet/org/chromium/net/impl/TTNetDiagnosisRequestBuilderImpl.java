package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public class TTNetDiagnosisRequestBuilderImpl extends TTNetDiagnosisRequest.Builder {
    private static final String TAG = "TTNetDiagnosisRequestBuilderImpl";
    private final TTNetDiagnosisRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private final Executor mExecutor;
    private int mMultiNetAction;
    private int mNetDetectType;
    private int mReqType;
    private List<String> mTargets;
    private int mTimeoutMs;

    static {
    }

    TTNetDiagnosisRequestBuilderImpl(TTNetDiagnosisRequest.Callback r3, Executor r4, CronetEngineBase r5) {
        TTNetDiagnosisRequest.Callback r6 = (TTNetDiagnosisRequest.Callback) ZeusTransformUtils.wrapperContextForParams(r3, TTNetDiagnosisRequest.Callback.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        this.mCronetEngine = r5;
        this.mCallback = r6;
        this.mExecutor = r7;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest build() {
        return this.mCronetEngine.createNetDiagnosisRequest(this.mCallback, this.mExecutor, this.mReqType, this.mTargets, this.mNetDetectType, this.mMultiNetAction, this.mTimeoutMs);
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setMultiNetAction(int r1) {
        this.mMultiNetAction = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setNetDetectType(int r1) {
        this.mNetDetectType = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setRequestType(int r1) {
        this.mReqType = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setTargets(List<String> r3) {
        this.mTargets = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setTimeout(int r1) {
        this.mTimeoutMs = r1;
        return this;
    }
}
