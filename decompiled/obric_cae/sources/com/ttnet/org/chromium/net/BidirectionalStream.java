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

        public abstract Builder addHeader(String r8, String r10);

        @SuppressLint({"WrongConstant"})
        public abstract BidirectionalStream build();

        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r8);

        public abstract Builder setHttpMethod(String r8);

        public abstract Builder setPriority(int r8);
    }

    public static abstract class Callback {
        public Callback() {
        }

        public void onCanceled(BidirectionalStream r8, UrlResponseInfo r10) {
        }

        public abstract void onFailed(BidirectionalStream r8, UrlResponseInfo r10, CronetException r11);

        public abstract void onReadCompleted(BidirectionalStream r8, UrlResponseInfo r10, ByteBuffer r11, boolean r12);

        public abstract void onResponseHeadersReceived(BidirectionalStream r8, UrlResponseInfo r10);

        public void onResponseTrailersReceived(BidirectionalStream r8, UrlResponseInfo r10, UrlResponseInfo.HeaderBlock r11) {
        }

        public abstract void onStreamReady(BidirectionalStream r8);

        public abstract void onSucceeded(BidirectionalStream r8, UrlResponseInfo r10);

        public abstract void onWriteCompleted(BidirectionalStream r8, UrlResponseInfo r10, ByteBuffer r11, boolean r12);
    }

    public BidirectionalStream() {
    }

    public abstract void cancel();

    public abstract void flush();

    public abstract boolean isDone();

    public abstract void read(ByteBuffer r8);

    public abstract void start();

    public abstract void write(ByteBuffer r8, boolean r10);
}
