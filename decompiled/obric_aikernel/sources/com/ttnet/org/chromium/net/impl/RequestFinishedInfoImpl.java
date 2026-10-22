package com.ttnet.org.chromium.net.impl;

import androidx.annotation.Nullable;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    private final Collection<Object> mAnnotations;

    @Nullable
    private final CronetException mException;
    private final int mFinishedReason;
    private final RequestFinishedInfo.Metrics mMetrics;

    @Nullable
    private final UrlResponseInfo mResponseInfo;
    private final String mUrl;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FinishedReason {
    }

    public RequestFinishedInfoImpl(String r10, Collection<Object> r11, RequestFinishedInfo.Metrics r12, int r13, @Nullable UrlResponseInfo r14, @Nullable CronetException r15) {
        this.mUrl = r10;
        this.mAnnotations = r11;
        this.mMetrics = r12;
        this.mFinishedReason = r13;
        this.mResponseInfo = r14;
        this.mException = r15;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public Collection<Object> getAnnotations() {
        Collection<Object> r10 = this.mAnnotations;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyList();
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    @Nullable
    public CronetException getException() {
        return this.mException;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public int getFinishedReason() {
        return this.mFinishedReason;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public RequestFinishedInfo.Metrics getMetrics() {
        return this.mMetrics;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    @Nullable
    public UrlResponseInfo getResponseInfo() {
        return this.mResponseInfo;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public String getUrl() {
        return this.mUrl;
    }
}
