package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import android.util.Pair;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class UrlRequestBuilderImpl extends ExperimentalUrlRequest.Builder {
    private static final String TAG = "UrlRequestBuilderImpl";
    private boolean mAllowDirectExecutor;
    private final UrlRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDisableCache;
    private boolean mDisableConnectionMigration;
    private final Executor mExecutor;
    private int mIdempotency;
    private String mMethod;
    private long mNetworkHandle;
    private int mPriority;
    private Collection<Object> mRequestAnnotations;
    private RequestFinishedInfo.Listener mRequestFinishedListener;
    private final ArrayList<Pair<String, String>> mRequestHeaders;
    private int mRequestTimeout;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;
    private UploadDataProvider mUploadDataProvider;
    private Executor mUploadDataProviderExecutor;
    private final String mUrl;

    static {
    }

    UrlRequestBuilderImpl(String r10, UrlRequest.Callback r11, Executor r12, CronetEngineBase r13) {
        this.mRequestHeaders = new ArrayList();
        this.mPriority = 3;
        this.mNetworkHandle = -1;
        this.mIdempotency = 0;
        Objects.requireNonNull(r10, "URL is required.");
        Objects.requireNonNull(r11, "Callback is required.");
        Objects.requireNonNull(r12, "Executor is required.");
        Objects.requireNonNull(r13, "CronetEngine is required.");
        this.mUrl = r10;
        this.mCallback = r11;
        this.mExecutor = r12;
        this.mCronetEngine = r13;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addHeader(String r10, String r11) {
        return addHeader(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder addHeader(String r10, String r11) {
        return addHeader(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String r10, String r11) {
        Objects.requireNonNull(r10, "Invalid header name.");
        Objects.requireNonNull(r11, "Invalid header value.");
        this.mRequestHeaders.add(Pair.create(r10, r11));
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addRequestAnnotation(Object r10) {
        return addRequestAnnotation(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl addRequestAnnotation(Object r10) {
        Objects.requireNonNull(r10, "Invalid metrics annotation.");
        if (this.mRequestAnnotations != null) goto L5;
        this.mRequestAnnotations = new ArrayList();
    L5:
        this.mRequestAnnotations.add(r10);
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl allowDirectExecutor() {
        this.mAllowDirectExecutor = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder bindToNetwork(long r10) {
        return bindToNetwork(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl bindToNetwork(long r10) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r10;
        return this;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBase build() {
        UrlRequestBase r10 = this.mCronetEngine.createRequest(this.mUrl, this.mCallback, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.mAllowDirectExecutor, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mRequestFinishedListener, this.mIdempotency, this.mNetworkHandle);
        String r11 = this.mMethod;
        if (r11 == null) goto L5;
        r10.setHttpMethod(r11);
    L5:
        Iterator<Pair<String, String>> r12 = this.mRequestHeaders.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Pair<String, String> r13 = r12.next();
        r10.addHeader((String) r13.first, (String) r13.second);
        goto L7
    L9:
        UploadDataProvider r14 = this.mUploadDataProvider;
        if (r14 == null) goto L12;
        r10.setUploadDataProvider(r14, this.mUploadDataProviderExecutor);
    L12:
        r10.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r10.setSocketReadTimeout(this.mSocketReadTimeout);
        r10.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r10.setRequestTimeout(this.mRequestTimeout);
        return r10;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.mDisableCache = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableConnectionMigration() {
        return disableConnectionMigration();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl disableConnectionMigration() {
        this.mDisableConnectionMigration = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public ExperimentalUrlRequest.Builder setHttpMethod(String r10) {
        Objects.requireNonNull(r10, "Method is required.");
        this.mMethod = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setHttpMethod(String r10) {
        return setHttpMethod(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setIdempotency(int r10) {
        return setIdempotency(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setIdempotency(int r10) {
        this.mIdempotency = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setPriority(int r10) {
        return setPriority(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setPriority(int r10) {
        return setPriority(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int r10) {
        this.mPriority = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setRequestFinishedListener(RequestFinishedInfo.Listener r10) {
        return setRequestFinishedListener(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setRequestFinishedListener(RequestFinishedInfo.Listener r10) {
        this.mRequestFinishedListener = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setRequestTimeout(int r10) {
        return setRequestTimeout(r10);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setRequestTimeout(int r10) {
        this.mRequestTimeout = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketConnectTimeout(int r10) {
        return setSocketConnectTimeout(r10);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketConnectTimeout(int r10) {
        this.mSocketConnectTimeout = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketReadTimeout(int r10) {
        return setSocketReadTimeout(r10);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketReadTimeout(int r10) {
        this.mSocketReadTimeout = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketWriteTimeout(int r10) {
        return setSocketWriteTimeout(r10);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketWriteTimeout(int r10) {
        this.mSocketWriteTimeout = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsTag(int r10) {
        return setTrafficStatsTag(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsTag(int r10) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsUid(int r10) {
        return setTrafficStatsUid(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsUid(int r10) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setUploadDataProvider(UploadDataProvider r10, Executor r11) {
        return setUploadDataProvider(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setUploadDataProvider(UploadDataProvider r10, Executor r11) {
        return setUploadDataProvider(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setUploadDataProvider(UploadDataProvider r10, Executor r11) {
        Objects.requireNonNull(r10, "Invalid UploadDataProvider.");
        Objects.requireNonNull(r11, "Invalid UploadDataProvider Executor.");
        if (this.mMethod != null) goto L5;
        this.mMethod = CloudConfig.REQUEST_TYPE_POST;
    L5:
        this.mUploadDataProvider = r10;
        this.mUploadDataProviderExecutor = r11;
        return this;
    }
}
