package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class CronetMetrics extends RequestFinishedInfo.Metrics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mConnectEndMs;
    private final long mConnectStartMs;
    private final long mDnsEndMs;
    private final long mDnsStartMs;
    private final String mPeerAddr;
    private final Long mPeerPort;
    private final long mPostTaskStartMs;
    private final long mPushEndMs;
    private final long mPushStartMs;
    private final Long mReceivedByteCount;
    private final long mRequestEndMs;
    private final String mRequestHeaders;
    private final long mRequestStartMs;
    private final String mResponseHeaders;
    private final long mResponseStartMs;
    private final Long mRetryAttempts;
    private final long mSendingEndMs;
    private final long mSendingStartMs;
    private final Long mSentByteCount;
    private final boolean mSocketReused;
    private final long mSslEndMs;
    private final long mSslStartMs;
    private final Long mTotalTimeMs;
    private final Long mTtfbMs;

    public CronetMetrics(long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, boolean r40, long r41, long r43, long r45, String r47, long r48, long r50, String r52, String r53) {
        this.mRequestStartMs = r14;
        this.mDnsStartMs = r16;
        this.mDnsEndMs = r18;
        this.mConnectStartMs = r20;
        this.mConnectEndMs = r22;
        this.mSslStartMs = r24;
        this.mSslEndMs = r26;
        this.mSendingStartMs = r28;
        this.mSendingEndMs = r30;
        this.mPushStartMs = r32;
        this.mPushEndMs = r34;
        this.mResponseStartMs = r36;
        this.mRequestEndMs = r38;
        this.mSocketReused = r40;
        this.mPostTaskStartMs = r45;
        this.mSentByteCount = Long.valueOf(r41);
        this.mReceivedByteCount = Long.valueOf(r43);
        this.mPeerAddr = r47;
        this.mPeerPort = Long.valueOf(r48);
        this.mRetryAttempts = Long.valueOf(r50);
        if (r30 != (-1)) goto L5;
    L7:
        this.mTtfbMs = null;
    L9:
        if (r14 != (-1)) goto L11;
    L13:
        this.mTotalTimeMs = null;
    L14:
        this.mRequestHeaders = r52;
        this.mResponseHeaders = r53;
        return;
    L11:
        if (r38 == (-1)) goto L13;
        this.mTotalTimeMs = Long.valueOf(r38 - r14);
        goto L14
    L5:
        if (r36 == (-1)) goto L7;
        this.mTtfbMs = Long.valueOf(r36 - r30);
        goto L9
    }

    private static boolean checkOrder(long r8, long r10) {
        if (r10 < r8) goto L7;
        if (r8 == (-1)) goto L7;
    L8:
        return true;
    L7:
        if (r10 == (-1)) goto L8;
        return false;
    }

    private static Date toDate(long r8) {
        if (r8 != (-1)) goto L5;
        return null;
    L5:
        return new Date(r8);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getConnectEnd() {
        return toDate(this.mConnectEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getConnectStart() {
        return toDate(this.mConnectStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getDnsEnd() {
        return toDate(this.mDnsEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getDnsStart() {
        return toDate(this.mDnsStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getPeerAddr() {
        return this.mPeerAddr;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getPeerPort() {
        return this.mPeerPort;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getPostTaskStartMs() {
        return toDate(this.mPostTaskStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getPushEnd() {
        return toDate(this.mPushEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getPushStart() {
        return toDate(this.mPushStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getReceivedByteCount() {
        return this.mReceivedByteCount;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getRequestEnd() {
        return toDate(this.mRequestEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getRequestHeaders() {
        return this.mRequestHeaders;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getRequestStart() {
        return toDate(this.mRequestStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getResponseHeaders() {
        return this.mResponseHeaders;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getResponseStart() {
        return toDate(this.mResponseStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getRetryAttempts() {
        return this.mRetryAttempts;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSendingEnd() {
        return toDate(this.mSendingEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSendingStart() {
        return toDate(this.mSendingStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getSentByteCount() {
        return this.mSentByteCount;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public boolean getSocketReused() {
        return this.mSocketReused;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSslEnd() {
        return toDate(this.mSslEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSslStart() {
        return toDate(this.mSslStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getTotalTimeMs() {
        return this.mTotalTimeMs;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getTtfbMs() {
        return this.mTtfbMs;
    }

    public CronetMetrics(Long r8, Long r10, Long r11, Long r12) {
        this.mTtfbMs = r8;
        this.mTotalTimeMs = r10;
        this.mSentByteCount = r11;
        this.mReceivedByteCount = r12;
        this.mRequestStartMs = -1;
        this.mDnsStartMs = -1;
        this.mDnsEndMs = -1;
        this.mConnectStartMs = -1;
        this.mConnectEndMs = -1;
        this.mSslStartMs = -1;
        this.mSslEndMs = -1;
        this.mSendingStartMs = -1;
        this.mSendingEndMs = -1;
        this.mPushStartMs = -1;
        this.mPushEndMs = -1;
        this.mResponseStartMs = -1;
        this.mRequestEndMs = -1;
        this.mSocketReused = false;
        this.mPostTaskStartMs = -1;
        this.mPeerAddr = "";
        this.mPeerPort = 0L;
        this.mRetryAttempts = 0L;
        this.mRequestHeaders = "";
        this.mResponseHeaders = "";
    }
}
