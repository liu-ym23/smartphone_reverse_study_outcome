package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TTWebsocketConnectionBuilderImpl extends TTWebsocketConnection.Builder {
    private static final String TAG = null;
    private int mAppId;
    private String mAppKey;
    private String mAppToken;
    private int mAppVersion;
    private final TTWebsocketConnection.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private long mDeviceId;
    private final Executor mExecutor;
    private int mFpid;
    private Map<String, String> mHeaders;
    private long mInstallId;
    private Map<String, String> mParams;
    private String mSessionId;
    private boolean mSharedConnection;
    private List<String> mUrlList;
    private boolean mUseFrontier;

    static {
        TAG = "TTWebsocketConnectionBuilderImpl";
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection build() {
        if (this.mUseFrontier == false) goto L7;
        return this.mCronetEngine.createWebsocketConnection(this.mCallback, this.mExecutor, this.mUrlList, this.mAppId, this.mAppKey, this.mDeviceId, this.mFpid, this.mInstallId, this.mSessionId, this.mAppVersion, this.mAppToken, this.mParams, this.mHeaders, this.mSharedConnection);
    L7:
        return this.mCronetEngine.createWebsocketConnection(this.mCallback, this.mExecutor, this.mUrlList, this.mParams, this.mHeaders, this.mSharedConnection);
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppId(int r1) {
        this.mAppId = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppKey(String r1) {
        this.mAppKey = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppToken(String r1) {
        this.mAppToken = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppVersion(int r1) {
        this.mAppVersion = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setCustomizedHeaders(Map<String, String> r1) {
        this.mHeaders = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setCustomizedParams(Map<String, String> r1) {
        this.mParams = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setDeviceId(long r1) {
        this.mDeviceId = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setFpid(int r1) {
        this.mFpid = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setInstallId(long r1) {
        this.mInstallId = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setSessionId(String r1) {
        this.mSessionId = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setSharedConnection(boolean r1) {
        this.mSharedConnection = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setUrlList(List<String> r1) {
        this.mUrlList = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder useFrontierProtocol(boolean r1) {
        this.mUseFrontier = r1;
        return this;
    }

    public TTWebsocketConnectionBuilderImpl(TTWebsocketConnection.Callback r2, Executor r3, CronetEngineBase r4) {
        this.mSharedConnection = true;
        this.mUseFrontier = true;
        this.mCronetEngine = r4;
        this.mCallback = r2;
        this.mExecutor = r3;
    }
}
