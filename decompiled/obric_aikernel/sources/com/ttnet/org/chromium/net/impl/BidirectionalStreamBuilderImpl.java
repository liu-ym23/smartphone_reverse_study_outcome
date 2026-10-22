package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import android.os.Build;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class BidirectionalStreamBuilderImpl extends ExperimentalBidirectionalStream.Builder {
    private final BidirectionalStream.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDelayRequestHeadersUntilFirstFlush;
    private final Executor mExecutor;
    private String mHttpMethod;
    private long mNetworkHandle;
    private int mPriority;
    private Collection<Object> mRequestAnnotations;
    private final ArrayList<Map.Entry<String, String>> mRequestHeaders;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;
    private final String mUrl;

    BidirectionalStreamBuilderImpl(String r10, BidirectionalStream.Callback r11, Executor r12, CronetEngineBase r13) {
        this.mRequestHeaders = new ArrayList();
        this.mHttpMethod = CloudConfig.REQUEST_TYPE_POST;
        this.mPriority = 3;
        this.mNetworkHandle = -1;
        Objects.requireNonNull(r10, "URL is required.");
        Objects.requireNonNull(r11, "Callback is required.");
        Objects.requireNonNull(r12, "Executor is required.");
        Objects.requireNonNull(r13, "CronetEngine is required.");
        this.mUrl = r10;
        this.mCallback = r11;
        this.mExecutor = r12;
        this.mCronetEngine = r13;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder addHeader(String r10, String r11) {
        return addHeader(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder addHeader(String r10, String r11) {
        return addHeader(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl addHeader(String r10, String r11) {
        Objects.requireNonNull(r10, "Invalid header name.");
        Objects.requireNonNull(r11, "Invalid header value.");
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r10, r11));
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder addRequestAnnotation(Object r10) {
        Objects.requireNonNull(r10, "Invalid metrics annotation.");
        if (this.mRequestAnnotations != null) goto L5;
        this.mRequestAnnotations = new ArrayList();
    L5:
        this.mRequestAnnotations.add(r10);
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder bindToNetwork(long r10) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r10;
        return this;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    @SuppressLint({"WrongConstant"})
    public /* bridge */ /* synthetic */ BidirectionalStream build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    @SuppressLint({"WrongConstant"})
    public ExperimentalBidirectionalStream build() {
        return this.mCronetEngine.createBidirectionalStream(this.mUrl, this.mCallback, this.mExecutor, this.mHttpMethod, this.mRequestHeaders, this.mPriority, this.mDelayRequestHeadersUntilFirstFlush, this.mRequestAnnotations, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mNetworkHandle);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r10) {
        return delayRequestHeadersUntilFirstFlush(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r10) {
        return delayRequestHeadersUntilFirstFlush(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl delayRequestHeadersUntilFirstFlush(boolean r10) {
        this.mDelayRequestHeadersUntilFirstFlush = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder setHttpMethod(String r10) {
        return setHttpMethod(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder setHttpMethod(String r10) {
        return setHttpMethod(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl setHttpMethod(String r10) {
        Objects.requireNonNull(r10, "Method is required.");
        this.mHttpMethod = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder setPriority(int r10) {
        return setPriority(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder setPriority(int r10) {
        return setPriority(r10);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl setPriority(int r10) {
        this.mPriority = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder setTrafficStatsTag(int r10) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder setTrafficStatsUid(int r10) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r10;
        return this;
    }
}
