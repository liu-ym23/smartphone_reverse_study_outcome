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

        public BidirectionalStreamCallback(BidirectionalStream.Callback r8) {
            this.mWrappedCallback = r8;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onCanceled(BidirectionalStream r8, UrlResponseInfo r10) {
            this.mWrappedCallback.onCanceled(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onFailed(BidirectionalStream r8, UrlResponseInfo r10, CronetException r11) {
            this.mWrappedCallback.onFailed(r8, r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onReadCompleted(BidirectionalStream r8, UrlResponseInfo r10, ByteBuffer r11, boolean r12) {
            this.mWrappedCallback.onReadCompleted(r8, r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseHeadersReceived(BidirectionalStream r8, UrlResponseInfo r10) {
            this.mWrappedCallback.onResponseHeadersReceived(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseTrailersReceived(BidirectionalStream r8, UrlResponseInfo r10, UrlResponseInfo.HeaderBlock r11) {
            this.mWrappedCallback.onResponseTrailersReceived(r8, r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onStreamReady(BidirectionalStream r8) {
            this.mWrappedCallback.onStreamReady(r8);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onSucceeded(BidirectionalStream r8, UrlResponseInfo r10) {
            this.mWrappedCallback.onSucceeded(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onWriteCompleted(BidirectionalStream r8, UrlResponseInfo r10, ByteBuffer r11, boolean r12) {
            this.mWrappedCallback.onWriteCompleted(r8, r10, r11, r12);
        }
    }

    public static final class LibraryLoader extends CronetEngine.Builder.LibraryLoader {
        private final CronetEngine.Builder.LibraryLoader mWrappedLoader;

        public LibraryLoader(CronetEngine.Builder.LibraryLoader r8) {
            this.mWrappedLoader = r8;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder.LibraryLoader
        public void loadLibrary(String r8) {
            this.mWrappedLoader.loadLibrary(r8);
        }
    }

    public static final class NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
        private final NetworkQualityRttListener mWrappedListener;

        public NetworkQualityRttListenerWrapper(NetworkQualityRttListener r8) {
            super(r8.getExecutor());
            this.mWrappedListener = r8;
        }

        public boolean equals(Object r8) {
            if (r8 != null) goto L4;
            return false;
        L4:
            if ((r8 instanceof NetworkQualityRttListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityRttListenerWrapper) r8).mWrappedListener);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public void onRttObservation(int r8, long r10, int r11) {
            this.mWrappedListener.onRttObservation(r8, r10, r11);
        }
    }

    public static final class NetworkQualityThroughputListenerWrapper extends NetworkQualityThroughputListener {
        private final NetworkQualityThroughputListener mWrappedListener;

        public NetworkQualityThroughputListenerWrapper(NetworkQualityThroughputListener r8) {
            super(r8.getExecutor());
            this.mWrappedListener = r8;
        }

        public boolean equals(Object r8) {
            if (r8 != null) goto L4;
            return false;
        L4:
            if ((r8 instanceof NetworkQualityThroughputListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityThroughputListenerWrapper) r8).mWrappedListener);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public void onThroughputObservation(int r8, long r10, int r11) {
            this.mWrappedListener.onThroughputObservation(r8, r10, r11);
        }
    }

    public static final class RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
        private final RequestFinishedInfo.Listener mWrappedListener;

        public RequestFinishedInfoListener(RequestFinishedInfo.Listener r8) {
            super(r8.getExecutor());
            this.mWrappedListener = r8;
        }

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public void onRequestFinished(RequestFinishedInfo r8) {
            this.mWrappedListener.onRequestFinished(r8);
        }
    }

    public static final class UploadDataProviderWrapper extends UploadDataProvider {
        private final UploadDataProvider mWrappedProvider;

        public UploadDataProviderWrapper(UploadDataProvider r8) {
            this.mWrappedProvider = r8;
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
        public void read(UploadDataSink r8, ByteBuffer r10) {
            this.mWrappedProvider.read(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r8) {
            this.mWrappedProvider.rewind(r8);
        }
    }

    public static final class UrlRequestCallback extends UrlRequest.Callback {
        private final UrlRequest.Callback mWrappedCallback;

        public UrlRequestCallback(UrlRequest.Callback r8) {
            this.mWrappedCallback = r8;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r8, UrlResponseInfo r10) {
            this.mWrappedCallback.onCanceled(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r8, UrlResponseInfo r10, CronetException r11) {
            this.mWrappedCallback.onFailed(r8, r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onMetricsCollected(UrlRequest r8, RequestFinishedInfo r10) {
            this.mWrappedCallback.onMetricsCollected(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r8, UrlResponseInfo r10, ByteBuffer r11) {
            this.mWrappedCallback.onReadCompleted(r8, r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r8, UrlResponseInfo r10, String r11) {
            this.mWrappedCallback.onRedirectReceived(r8, r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRequestLogCollected(String r8, RequestFinishedInfo r10) {
            this.mWrappedCallback.onRequestLogCollected(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r8, UrlResponseInfo r10, String r11) {
            this.mWrappedCallback.onResponseStarted(r8, r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r8, UrlResponseInfo r10) {
            this.mWrappedCallback.onSucceeded(r8, r10);
        }
    }

    public static final class UrlRequestStatusListener extends UrlRequest.StatusListener {
        private final UrlRequest.StatusListener mWrappedListener;

        public UrlRequestStatusListener(UrlRequest.StatusListener r8) {
            this.mWrappedListener = r8;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int r8) {
            this.mWrappedListener.onStatus(r8);
        }
    }

    public VersionSafeCallbacks() {
    }
}
