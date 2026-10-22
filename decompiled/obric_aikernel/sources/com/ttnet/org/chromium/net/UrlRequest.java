package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UrlRequest {

    public static abstract class Builder {
        public static final int REQUEST_PRIORITY_HIGHEST = 4;
        public static final int REQUEST_PRIORITY_IDLE = 0;
        public static final int REQUEST_PRIORITY_LOW = 2;
        public static final int REQUEST_PRIORITY_LOWEST = 1;
        public static final int REQUEST_PRIORITY_MEDIUM = 3;

        public Builder() {
        }

        public abstract Builder addHeader(String r10, String r11);

        public abstract Builder allowDirectExecutor();

        public abstract UrlRequest build();

        public abstract Builder disableCache();

        public abstract Builder setHttpMethod(String r10);

        public abstract Builder setPriority(int r10);

        public abstract Builder setRequestTimeout(int r10);

        public abstract Builder setSocketConnectTimeout(int r10);

        public abstract Builder setSocketReadTimeout(int r10);

        public abstract Builder setSocketWriteTimeout(int r10);

        public abstract Builder setUploadDataProvider(UploadDataProvider r10, Executor r11);
    }

    public static abstract class Callback {
        public Callback() {
        }

        public void onCanceled(UrlRequest r10, UrlResponseInfo r11) {
        }

        public abstract void onFailed(UrlRequest r10, UrlResponseInfo r11, CronetException r12);

        public void onMetricsCollected(UrlRequest r10, RequestFinishedInfo r11) {
        }

        public abstract void onReadCompleted(UrlRequest r10, UrlResponseInfo r11, ByteBuffer r12);

        public abstract void onRedirectReceived(UrlRequest r10, UrlResponseInfo r11, String r12, String r13);

        public void onRequestLogCollected(String r10, RequestFinishedInfo r11) {
        }

        public abstract void onResponseStarted(UrlRequest r10, UrlResponseInfo r11, String r12);

        public abstract void onSucceeded(UrlRequest r10, UrlResponseInfo r11);
    }

    public static class Status {
        public static final int CONNECTING = 10;
        public static final int DOWNLOADING_PAC_FILE = 5;
        public static final int ESTABLISHING_PROXY_TUNNEL = 8;
        public static final int IDLE = 0;
        public static final int INVALID = -1;
        public static final int READING_RESPONSE = 14;
        public static final int RESOLVING_HOST = 9;
        public static final int RESOLVING_HOST_IN_PAC_FILE = 7;
        public static final int RESOLVING_PROXY_FOR_URL = 6;
        public static final int SENDING_REQUEST = 12;
        public static final int SSL_HANDSHAKE = 11;
        public static final int WAITING_FOR_AVAILABLE_SOCKET = 2;
        public static final int WAITING_FOR_CACHE = 4;
        public static final int WAITING_FOR_DELEGATE = 3;
        public static final int WAITING_FOR_RESPONSE = 13;
        public static final int WAITING_FOR_STALLED_SOCKET_POOL = 1;

        private Status() {
        }
    }

    public static abstract class StatusListener {
        public StatusListener() {
        }

        public abstract void onStatus(int r10);
    }

    public UrlRequest() {
    }

    public abstract void AddRequestCookieHeader(String r10, String r11);

    public abstract void RemoveRequestCookieHeader();

    public void appTimeout() {
    }

    public abstract void cancel();

    public abstract void followRedirect();

    public abstract String getFinalUrl();

    public abstract String getRequestLog();

    public abstract void getStatus(StatusListener r10);

    public abstract boolean isDone();

    public abstract void read(ByteBuffer r10);

    public abstract void setAddCookieCostUs(long r10);

    public abstract void setAuthCredentials(String r10, String r11);

    public abstract void setRequestCookieSource(int r10);

    public void setRequestFlag(int r10) {
    }

    public abstract void setRequestTypeFlags(int r10);

    public abstract void setSaveCookieCostUs(long r10);

    public abstract void setThrottleNetSpeed(long r10);

    public abstract void start();

    public abstract void stopRedirect();
}
