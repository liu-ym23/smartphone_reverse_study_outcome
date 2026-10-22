package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class VersionSafeCallbacks {

    public static final class BidirectionalStreamCallback extends BidirectionalStream.Callback {
        private final BidirectionalStream.Callback mWrappedCallback;

        public BidirectionalStreamCallback(BidirectionalStream.Callback r10) {
            this.mWrappedCallback = r10;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onCanceled(BidirectionalStream r10, UrlResponseInfo r11) {
            this.mWrappedCallback.onCanceled(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onFailed(BidirectionalStream r10, UrlResponseInfo r11, CronetException r12) {
            this.mWrappedCallback.onFailed(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onReadCompleted(BidirectionalStream r10, UrlResponseInfo r11, ByteBuffer r12, boolean r13) {
            this.mWrappedCallback.onReadCompleted(r10, r11, r12, r13);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseHeadersReceived(BidirectionalStream r10, UrlResponseInfo r11) {
            this.mWrappedCallback.onResponseHeadersReceived(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseTrailersReceived(BidirectionalStream r10, UrlResponseInfo r11, UrlResponseInfo.HeaderBlock r12) {
            this.mWrappedCallback.onResponseTrailersReceived(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onStreamReady(BidirectionalStream r10) {
            this.mWrappedCallback.onStreamReady(r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onSucceeded(BidirectionalStream r10, UrlResponseInfo r11) {
            this.mWrappedCallback.onSucceeded(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onWriteCompleted(BidirectionalStream r10, UrlResponseInfo r11, ByteBuffer r12, boolean r13) {
            this.mWrappedCallback.onWriteCompleted(r10, r11, r12, r13);
        }
    }

    public static final class LibraryLoader extends CronetEngine.Builder.LibraryLoader {
        private final CronetEngine.Builder.LibraryLoader mWrappedLoader;

        public LibraryLoader(CronetEngine.Builder.LibraryLoader r10) {
            this.mWrappedLoader = r10;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder.LibraryLoader
        public void loadLibrary(String r10) {
            this.mWrappedLoader.loadLibrary(r10);
        }
    }

    public static final class NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
        private final NetworkQualityRttListener mWrappedListener;

        public NetworkQualityRttListenerWrapper(NetworkQualityRttListener r10) {
            super(r10.getExecutor());
            this.mWrappedListener = r10;
        }

        public boolean equals(Object r10) {
            if (r10 != null) goto L4;
            return false;
        L4:
            if ((r10 instanceof NetworkQualityRttListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityRttListenerWrapper) r10).mWrappedListener);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public void onRttObservation(int r10, long r11, int r12) {
            this.mWrappedListener.onRttObservation(r10, r11, r12);
        }
    }

    public static final class NetworkQualityThroughputListenerWrapper extends NetworkQualityThroughputListener {
        private final NetworkQualityThroughputListener mWrappedListener;

        public NetworkQualityThroughputListenerWrapper(NetworkQualityThroughputListener r10) {
            super(r10.getExecutor());
            this.mWrappedListener = r10;
        }

        public boolean equals(Object r10) {
            if (r10 != null) goto L4;
            return false;
        L4:
            if ((r10 instanceof NetworkQualityThroughputListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityThroughputListenerWrapper) r10).mWrappedListener);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public void onThroughputObservation(int r10, long r11, int r12) {
            this.mWrappedListener.onThroughputObservation(r10, r11, r12);
        }
    }

    public static final class RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
        private final RequestFinishedInfo.Listener mWrappedListener;

        public RequestFinishedInfoListener(RequestFinishedInfo.Listener r10) {
            super(r10.getExecutor());
            this.mWrappedListener = r10;
        }

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public void onRequestFinished(RequestFinishedInfo r10) {
            this.mWrappedListener.onRequestFinished(r10);
        }
    }

    public static final class UploadDataProviderWrapper extends UploadDataProvider {
        private final UploadDataProvider mWrappedProvider;

        public UploadDataProviderWrapper(UploadDataProvider r10) {
            this.mWrappedProvider = r10;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mWrappedProvider.close();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.mWrappedProvider.getLength();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r10, ByteBuffer r11) {
            this.mWrappedProvider.read(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r10) {
            this.mWrappedProvider.rewind(r10);
        }
    }

    public static final class UrlRequestCallback extends UrlRequest.Callback {
        private final UrlRequest.Callback mWrappedCallback;

        public UrlRequestCallback(UrlRequest.Callback r10) {
            this.mWrappedCallback = r10;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r10, UrlResponseInfo r11) {
            this.mWrappedCallback.onCanceled(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r10, UrlResponseInfo r11, CronetException r12) {
            this.mWrappedCallback.onFailed(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onMetricsCollected(UrlRequest r10, RequestFinishedInfo r11) {
            this.mWrappedCallback.onMetricsCollected(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r10, UrlResponseInfo r11, ByteBuffer r12) {
            this.mWrappedCallback.onReadCompleted(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r10, UrlResponseInfo r11, String r12, String r13) {
            this.mWrappedCallback.onRedirectReceived(r10, r11, r12, r13);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRequestLogCollected(String r10, RequestFinishedInfo r11) {
            this.mWrappedCallback.onRequestLogCollected(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r10, UrlResponseInfo r11, String r12) {
            this.mWrappedCallback.onResponseStarted(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r10, UrlResponseInfo r11) {
            this.mWrappedCallback.onSucceeded(r10, r11);
        }
    }

    public static final class UrlRequestStatusListener extends UrlRequest.StatusListener {
        private final UrlRequest.StatusListener mWrappedListener;

        public UrlRequestStatusListener(UrlRequest.StatusListener r10) {
            this.mWrappedListener = r10;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int r10) {
            this.mWrappedListener.onStatus(r10);
        }
    }

    public VersionSafeCallbacks() {
    }
}
