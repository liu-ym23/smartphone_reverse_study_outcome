package com.ttnet.org.chromium.net;

import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RequestFinishedInfo {
    public static final int CANCELED = 2;
    public static final int FAILED = 1;
    public static final int SUCCEEDED = 0;

    public static abstract class Listener {
        private final Executor mExecutor;

        public Listener(Executor r10) {
            if (r10 == null) goto L7;
            this.mExecutor = r10;
            return;
        L7:
            throw new IllegalStateException("Executor must not be null");
        }

        public Executor getExecutor() {
            return this.mExecutor;
        }

        public abstract void onRequestFinished(RequestFinishedInfo r10);
    }

    public static abstract class Metrics {
        public Metrics() {
        }

        @Nullable
        public abstract Long getAddCookieCostUs();

        public abstract boolean getBypassApiReport();

        @Nullable
        public abstract Date getConnectEnd();

        @Nullable
        public abstract Date getConnectStart();

        @Nullable
        public abstract Date getDnsEnd();

        @Nullable
        public abstract Date getDnsStart();

        @Nullable
        public abstract String getPeerAddr();

        @Nullable
        public abstract Long getPeerPort();

        @Nullable
        public abstract Date getPostTaskStartMs();

        public abstract boolean getPreSamplingReportable();

        @Nullable
        public abstract Date getPushEnd();

        @Nullable
        public abstract Date getPushStart();

        @Nullable
        public abstract Long getReceivedByteCount();

        @Nullable
        public abstract Integer getRequestCookieSource();

        @Nullable
        public abstract Date getRequestEnd();

        @Nullable
        public abstract String getRequestHeaders();

        @Nullable
        public abstract Date getRequestStart();

        @Nullable
        public abstract String getResponseHeaders();

        @Nullable
        public abstract Date getResponseStart();

        @Nullable
        public abstract Long getRetryAttempts();

        @Nullable
        public abstract Long getSaveCookieCostUs();

        @Nullable
        public abstract Date getSendingEnd();

        @Nullable
        public abstract Date getSendingStart();

        @Nullable
        public abstract Long getSentByteCount();

        public abstract boolean getSocketReused();

        @Nullable
        public abstract Date getSslEnd();

        @Nullable
        public abstract Date getSslStart();

        @Nullable
        public abstract Long getTotalTimeMs();

        @Nullable
        public abstract Long getTtfbMs();
    }

    public RequestFinishedInfo() {
    }

    public abstract Collection<Object> getAnnotations();

    @Nullable
    public abstract CronetException getException();

    public abstract int getFinishedReason();

    public abstract Metrics getMetrics();

    @Nullable
    public abstract UrlResponseInfo getResponseInfo();

    public abstract String getUrl();
}
