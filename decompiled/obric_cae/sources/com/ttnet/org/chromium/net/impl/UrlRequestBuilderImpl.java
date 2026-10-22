package com.ttnet.org.chromium.net.impl;

import android.util.Pair;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
    private String mMethod;
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

    public UrlRequestBuilderImpl(String r8, UrlRequest.Callback r10, Executor r11, CronetEngineBase r12) {
        this.mRequestHeaders = new ArrayList();
        this.mPriority = 3;
        if (r8 == null) goto L16;
        if (r10 == null) goto L14;
        if (r11 == null) goto L12;
        if (r12 == null) goto L10;
        this.mUrl = r8;
        this.mCallback = r10;
        this.mExecutor = r11;
        this.mCronetEngine = r12;
        return;
    L10:
        throw new NullPointerException("CronetEngine is required.");
    L12:
        throw new NullPointerException("Executor is required.");
    L14:
        throw new NullPointerException("Callback is required.");
    L16:
        throw new NullPointerException("URL is required.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addHeader(String r8, String r10) {
        return addHeader(r8, r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addRequestAnnotation(Object r8) {
        return addRequestAnnotation(r8);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableConnectionMigration() {
        return disableConnectionMigration();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public ExperimentalUrlRequest.Builder setHttpMethod(String r8) {
        if (r8 == null) goto L6;
        this.mMethod = r8;
        return this;
    L6:
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setPriority(int r8) {
        return setPriority(r8);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setRequestFinishedListener(RequestFinishedInfo.Listener r8) {
        return setRequestFinishedListener(r8);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setRequestTimeout(int r8) {
        return setRequestTimeout(r8);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketConnectTimeout(int r8) {
        return setSocketConnectTimeout(r8);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketReadTimeout(int r8) {
        return setSocketReadTimeout(r8);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketWriteTimeout(int r8) {
        return setSocketWriteTimeout(r8);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsTag(int r8) {
        return setTrafficStatsTag(r8);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsUid(int r8) {
        return setTrafficStatsUid(r8);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setUploadDataProvider(UploadDataProvider r8, Executor r10) {
        return setUploadDataProvider(r8, r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder addHeader(String r8, String r10) {
        return addHeader(r8, r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl addRequestAnnotation(Object r8) {
        if (r8 == null) goto L9;
        if (this.mRequestAnnotations != null) goto L6;
        this.mRequestAnnotations = new ArrayList();
    L6:
        this.mRequestAnnotations.add(r8);
        return this;
    L9:
        throw new NullPointerException("Invalid metrics annotation.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl disableConnectionMigration() {
        this.mDisableConnectionMigration = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setHttpMethod(String r8) {
        return setHttpMethod(r8);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setPriority(int r8) {
        return setPriority(r8);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setRequestFinishedListener(RequestFinishedInfo.Listener r8) {
        this.mRequestFinishedListener = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setRequestTimeout(int r8) {
        this.mRequestTimeout = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketConnectTimeout(int r8) {
        this.mSocketConnectTimeout = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketReadTimeout(int r8) {
        this.mSocketReadTimeout = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketWriteTimeout(int r8) {
        this.mSocketWriteTimeout = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsTag(int r8) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsUid(int r8) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setUploadDataProvider(UploadDataProvider r8, Executor r10) {
        return setUploadDataProvider(r8, r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String r8, String r10) {
        if (r8 == null) goto L9;
        if (r10 == null) goto L7;
        this.mRequestHeaders.add(Pair.create(r8, r10));
        return this;
    L7:
        throw new NullPointerException("Invalid header value.");
    L9:
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl allowDirectExecutor() {
        this.mAllowDirectExecutor = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBase build() {
        UrlRequestBase r8 = this.mCronetEngine.createRequest(this.mUrl, this.mCallback, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.mAllowDirectExecutor, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mRequestFinishedListener);
        String r10 = this.mMethod;
        if (r10 == null) goto L5;
        r8.setHttpMethod(r10);
    L5:
        Iterator<Pair<String, String>> r11 = this.mRequestHeaders.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Pair<String, String> r12 = r11.next();
        r8.addHeader((String) r12.first, (String) r12.second);
        goto L7
    L9:
        UploadDataProvider r13 = this.mUploadDataProvider;
        if (r13 == null) goto L12;
        r8.setUploadDataProvider(r13, this.mUploadDataProviderExecutor);
    L12:
        r8.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r8.setSocketReadTimeout(this.mSocketReadTimeout);
        r8.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r8.setRequestTimeout(this.mRequestTimeout);
        return r8;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.mDisableCache = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int r8) {
        this.mPriority = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setUploadDataProvider(UploadDataProvider r8, Executor r10) {
        if (r8 == null) goto L12;
        if (r10 == null) goto L10;
        if (this.mMethod != null) goto L7;
        this.mMethod = HttpMethodContrants.POST;
    L7:
        this.mUploadDataProvider = r8;
        this.mUploadDataProviderExecutor = r10;
        return this;
    L10:
        throw new NullPointerException("Invalid UploadDataProvider Executor.");
    L12:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }
}
