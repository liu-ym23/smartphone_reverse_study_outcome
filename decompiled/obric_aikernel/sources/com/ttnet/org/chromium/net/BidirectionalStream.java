package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BidirectionalStream {

    public static abstract class Builder {
        public static final int STREAM_PRIORITY_HIGHEST = 4;
        public static final int STREAM_PRIORITY_IDLE = 0;
        public static final int STREAM_PRIORITY_LOW = 2;
        public static final int STREAM_PRIORITY_LOWEST = 1;
        public static final int STREAM_PRIORITY_MEDIUM = 3;

        public Builder() {
        }

        public abstract Builder addHeader(String r10, String r11);

        @SuppressLint({"WrongConstant"})
        public abstract BidirectionalStream build();

        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r10);

        public abstract Builder setHttpMethod(String r10);

        public abstract Builder setPriority(int r10);
    }

    public static abstract class Callback {
        public Callback() {
        }

        public void onCanceled(BidirectionalStream r10, UrlResponseInfo r11) {
        }

        public abstract void onFailed(BidirectionalStream r10, UrlResponseInfo r11, CronetException r12);

        public abstract void onReadCompleted(BidirectionalStream r10, UrlResponseInfo r11, ByteBuffer r12, boolean r13);

        public abstract void onResponseHeadersReceived(BidirectionalStream r10, UrlResponseInfo r11);

        public void onResponseTrailersReceived(BidirectionalStream r10, UrlResponseInfo r11, UrlResponseInfo.HeaderBlock r12) {
        }

        public abstract void onStreamReady(BidirectionalStream r10);

        public abstract void onSucceeded(BidirectionalStream r10, UrlResponseInfo r11);

        public abstract void onWriteCompleted(BidirectionalStream r10, UrlResponseInfo r11, ByteBuffer r12, boolean r13);
    }

    public BidirectionalStream() {
    }

    public abstract void cancel();

    public abstract void flush();

    public abstract boolean isDone();

    public abstract void read(ByteBuffer r10);

    public abstract void start();

    public abstract void write(ByteBuffer r10, boolean r11);
}
