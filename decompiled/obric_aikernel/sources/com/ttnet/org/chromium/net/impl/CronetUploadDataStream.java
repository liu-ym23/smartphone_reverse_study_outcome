package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
@VisibleForTesting
public final class CronetUploadDataStream extends UploadDataSink {
    private static final String TAG = "CronetUploadDataStream";
    private ByteBuffer mByteBuffer;
    private long mByteBufferLimit;
    private volatile boolean mClosed;
    private final VersionSafeCallbacks.UploadDataProviderWrapper mDataProvider;
    private boolean mDestroyAdapterPostponed;
    private final Executor mExecutor;
    private int mInWhichUserCallback;
    private long mLength;
    private final Object mLock;
    private Runnable mOnDestroyedCallbackForTesting;
    private final Runnable mReadTask;
    private long mRemainingLength;
    private final CronetUrlRequest mRequest;
    private long mUploadDataStreamAdapter;

    interface Natives {
        long attachUploadDataToRequest(CronetUploadDataStream r10, long r11, long r12);

        long createAdapterForTesting(CronetUploadDataStream r10);

        long createUploadDataStreamForTesting(CronetUploadDataStream r10, long r11, long r12);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void destroy(long r10);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onReadSucceeded(long r10, CronetUploadDataStream r11, int r12, boolean r13);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onRewindSucceeded(long r10, CronetUploadDataStream r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface UserCallback {
        public static final int GET_LENGTH = 2;
        public static final int NOT_IN_CALLBACK = 3;
        public static final int READ = 0;
        public static final int REWIND = 1;
    }

    static {
    }

    public CronetUploadDataStream(UploadDataProvider r10, Executor r11, CronetUrlRequest r12) {
        this.mReadTask = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mInWhichUserCallback = 3;
        this.mExecutor = r11;
        this.mDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(r10);
        this.mRequest = r12;
        this.mClosed = false;
    }

    static /* synthetic */ Object access$000(CronetUploadDataStream r10) {
        return r10.mLock;
    }

    static /* synthetic */ long access$100(CronetUploadDataStream r10) {
        return r10.mUploadDataStreamAdapter;
    }

    static /* synthetic */ void access$200(CronetUploadDataStream r10, int r11) {
        r10.checkState(r11);
    }

    static /* synthetic */ ByteBuffer access$300(CronetUploadDataStream r10) {
        return r10.mByteBuffer;
    }

    static /* synthetic */ int access$402(CronetUploadDataStream r10, int r11) {
        r10.mInWhichUserCallback = r11;
        return r11;
    }

    static /* synthetic */ void access$500(CronetUploadDataStream r10) {
        r10.checkCallingThread();
    }

    static /* synthetic */ VersionSafeCallbacks.UploadDataProviderWrapper access$600(CronetUploadDataStream r10) {
        return r10.mDataProvider;
    }

    static /* synthetic */ void access$700(CronetUploadDataStream r10, Throwable r11) {
        r10.onError(r11);
    }

    static /* synthetic */ boolean access$800(CronetUploadDataStream r10) {
        return r10.mClosed;
    }

    static /* synthetic */ String access$900() {
        return TAG;
    }

    private void checkCallingThread() {
        this.mRequest.checkCallingThread();
    }

    private void checkState(int r10) {
        if (this.mInWhichUserCallback != r10) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r10 + ", but was " + this.mInWhichUserCallback);
    }

    private void destroyAdapter() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback != 0) goto L10;
        this.mDestroyAdapterPostponed = true;     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L10:
        if (this.mUploadDataStreamAdapter != 0) goto L13;
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L13:
        CronetUploadDataStreamJni.get().destroy(this.mUploadDataStreamAdapter);     // Catch: Throwable -> L19
        this.mUploadDataStreamAdapter = 0;     // Catch: Throwable -> L19
        Runnable r11 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        r11.run();     // Catch: Throwable -> L19
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L19
        postTaskToExecutor(new AnonymousClass3(this));
    }

    private void destroyAdapterIfPostponed() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback == 0) goto L12;
        if (this.mDestroyAdapterPostponed == false) goto L9;
        destroyAdapter();     // Catch: Throwable -> L13
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Method should not be called when read has not completed.");     // Catch: Throwable -> L13
    }

    private void onError(Throwable r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        int r12 = this.mInWhichUserCallback;     // Catch: Throwable -> L21
        if (r12 == 3) goto L20;
        if (r12 != 2) goto L9;
        boolean r13 = true;
    L10:
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L21
        this.mByteBuffer = null;     // Catch: Throwable -> L21
        destroyAdapterIfPostponed();     // Catch: Throwable -> L21
        monitor-exit(r11);     // Catch: Throwable -> L21
        if (r13 == true) goto L24;
    L17:
        this.mRequest.onUploadException(r10);
        return;
    L24:
        this.mDataProvider.close();     // Catch: Exception -> L15
        this.mClosed = true;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e(TAG, "Failure closing data provider", new Object[]{e});
        goto L17
    L9:
        r13 = false;
        goto L10
    L20:
        throw new IllegalStateException("There is no read or rewind or length check in progress.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    void attachNativeAdapterToRequest(long r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mUploadDataStreamAdapter = CronetUploadDataStreamJni.get().attachUploadDataToRequest(this, r10, this.mLength);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public long createUploadDataStreamForTesting() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mUploadDataStreamAdapter = CronetUploadDataStreamJni.get().createAdapterForTesting(this);     // Catch: Throwable -> L7
        long r11 = this.mDataProvider.getLength();     // Catch: Throwable -> L7
        this.mLength = r11;     // Catch: Throwable -> L7
        this.mRemainingLength = r11;     // Catch: Throwable -> L7
        long r12 = CronetUploadDataStreamJni.get().createUploadDataStreamForTesting(this, this.mLength, this.mUploadDataStreamAdapter);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    void initializeWithRequest() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mInWhichUserCallback = 2;     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        this.mRequest.checkCallingThread();     // Catch: Throwable -> L9
        long r11 = this.mDataProvider.getLength();     // Catch: Throwable -> L9
        this.mLength = r11;     // Catch: Throwable -> L9
        this.mRemainingLength = r11;     // Catch: Throwable -> L9
    L11:
        Object r12 = this.mLock;
        monitor-enter(r12);
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        onError(th);
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadError(Exception r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkState(0);     // Catch: Throwable -> L8
        onError(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    @SuppressLint({"DefaultLocale"})
    public void onReadSucceeded(boolean r12) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkState(0);     // Catch: Throwable -> L30
        if (this.mByteBufferLimit != this.mByteBuffer.limit()) goto L29;
        if (r12 == true) goto L10;
    L14:
        int r11 = this.mByteBuffer.position();     // Catch: Throwable -> L30
        long r13 = this.mRemainingLength - ((long) r11);     // Catch: Throwable -> L30
        this.mRemainingLength = r13;     // Catch: Throwable -> L30
        if (r13 < 0) goto L17;
    L21:
        this.mByteBuffer.position(0);     // Catch: Throwable -> L30
        this.mByteBuffer = null;     // Catch: Throwable -> L30
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L30
        destroyAdapterIfPostponed();     // Catch: Throwable -> L30
        if (this.mUploadDataStreamAdapter != 0) goto L25;
        monitor-exit(r10);     // Catch: Throwable -> L30
        return;
    L25:
        CronetUploadDataStreamJni.get().onReadSucceeded(this.mUploadDataStreamAdapter, this, r11, r12);     // Catch: Throwable -> L30
        monitor-exit(r10);     // Catch: Throwable -> L30
        return;
    L17:
        if (this.mLength < 0) goto L21;
        throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", new Object[]{Long.valueOf(this.mLength - this.mRemainingLength), Long.valueOf(this.mLength)}));     // Catch: Throwable -> L30
    L10:
        if (this.mLength < 0) goto L14;
        throw new IllegalArgumentException("Non-chunked upload can't have last chunk");     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("ByteBuffer limit changed");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindError(Exception r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkState(1);     // Catch: Throwable -> L8
        onError(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkState(1);     // Catch: Throwable -> L12
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L12
        this.mRemainingLength = this.mLength;     // Catch: Throwable -> L12
        if (this.mUploadDataStreamAdapter != 0) goto L9;
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L9:
        CronetUploadDataStreamJni.get().onRewindSucceeded(this.mUploadDataStreamAdapter, this);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    void postTaskToExecutor(Runnable r10) {
        this.mExecutor.execute(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CronetUrlRequest r11 = this.mRequest;
        if (r11 == null) goto L10;
        r11.onUploadException(th);
        return;
    L10:
        throw new IllegalStateException("Unexpected request usage, caught in CronetUploadDataStream, caused by " + th);
    }

    @CalledByNative
    void readData(ByteBuffer r10) {
        this.mByteBuffer = r10;
        this.mByteBufferLimit = r10.limit();
        postTaskToExecutor(this.mReadTask);
    }

    @CalledByNative
    void rewind() {
        postTaskToExecutor(new AnonymousClass2(this));
    }

    @VisibleForTesting
    void setOnDestroyedCallbackForTesting(Runnable r10) {
        this.mOnDestroyedCallbackForTesting = r10;
    }
}
