package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import defpackage.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@JNINamespace("cronet")
public final class CronetUploadDataStream extends UploadDataSink {
    private static final String TAG = "CronetUploadDataStream";
    private ByteBuffer mByteBuffer;
    private long mByteBufferLimit;
    private volatile boolean mClosed;
    private final VersionSafeCallbacks.UploadDataProviderWrapper mDataProvider;

    @GuardedBy("mLock")
    private boolean mDestroyAdapterPostponed;
    private final Executor mExecutor;

    @GuardedBy("mLock")
    private int mInWhichUserCallback;
    private long mLength;
    private final Object mLock;
    private Runnable mOnDestroyedCallbackForTesting;
    private final Runnable mReadTask;
    private long mRemainingLength;
    private final CronetUrlRequest mRequest;

    @GuardedBy("mLock")
    private long mUploadDataStreamAdapter;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserCallback {
        public static final int GET_LENGTH = 2;
        public static final int NOT_IN_CALLBACK = 3;
        public static final int READ = 0;
        public static final int REWIND = 1;
    }

    public CronetUploadDataStream(UploadDataProvider r8, Executor r10, CronetUrlRequest r11) {
        this.mReadTask = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mInWhichUserCallback = 3;
        this.mExecutor = r10;
        this.mDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(r8);
        this.mRequest = r11;
        this.mClosed = false;
    }

    public static /* synthetic */ Object access$000(CronetUploadDataStream r8) {
        return r8.mLock;
    }

    public static /* synthetic */ long access$100(CronetUploadDataStream r8) {
        return r8.mUploadDataStreamAdapter;
    }

    public static /* synthetic */ void access$200(CronetUploadDataStream r8, int r10) {
        r8.checkState(r10);
    }

    public static /* synthetic */ ByteBuffer access$300(CronetUploadDataStream r8) {
        return r8.mByteBuffer;
    }

    public static /* synthetic */ int access$402(CronetUploadDataStream r8, int r10) {
        r8.mInWhichUserCallback = r10;
        return r10;
    }

    public static /* synthetic */ void access$500(CronetUploadDataStream r8) {
        r8.checkCallingThread();
    }

    public static /* synthetic */ VersionSafeCallbacks.UploadDataProviderWrapper access$600(CronetUploadDataStream r8) {
        return r8.mDataProvider;
    }

    public static /* synthetic */ void access$700(CronetUploadDataStream r8, Throwable r10) {
        r8.onError(r10);
    }

    public static /* synthetic */ boolean access$800(CronetUploadDataStream r8) {
        return r8.mClosed;
    }

    public static /* synthetic */ String access$900() {
        return TAG;
    }

    private void checkCallingThread() {
        this.mRequest.checkCallingThread();
    }

    @GuardedBy("mLock")
    private void checkState(int r8) {
        if (this.mInWhichUserCallback != r8) goto L5;
        return;
    L5:
        StringBuilder r10 = b.f("Expected ", r8, ", but was ");
        r10.append(this.mInWhichUserCallback);
        throw new IllegalStateException(r10.toString());
    }

    private void destroyAdapter() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback != 0) goto L9;
        this.mDestroyAdapterPostponed = true;     // Catch: Throwable -> L19
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L9:
        long r10 = this.mUploadDataStreamAdapter;     // Catch: Throwable -> L19
        if (r10 != 0) goto L13;
        monitor-exit(r8);     // Catch: Throwable -> L19
        return;
    L13:
        nativeDestroy(r10);     // Catch: Throwable -> L19
        this.mUploadDataStreamAdapter = 0;     // Catch: Throwable -> L19
        Runnable r11 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        r11.run();     // Catch: Throwable -> L19
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L19
        postTaskToExecutor(new AnonymousClass3(this));
    }

    private void destroyAdapterIfPostponed() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback == 0) goto L12;
        if (this.mDestroyAdapterPostponed == false) goto L9;
        destroyAdapter();     // Catch: Throwable -> L13
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Method should not be called when read has not completed.");     // Catch: Throwable -> L13
    }

    private native long nativeAttachUploadDataToRequest(long r8, long r10);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long r8, long r10);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    private static native void nativeDestroy(long r8);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    private native void nativeOnReadSucceeded(long r8, int r10, boolean r11);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    private native void nativeOnRewindSucceeded(long r8);

    private void onError(Throwable r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        int r11 = this.mInWhichUserCallback;     // Catch: Throwable -> L21
        if (r11 == 3) goto L20;
        if (r11 != 2) goto L9;
        boolean r12 = true;
    L10:
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L21
        this.mByteBuffer = null;     // Catch: Throwable -> L21
        destroyAdapterIfPostponed();     // Catch: Throwable -> L21
        monitor-exit(r10);     // Catch: Throwable -> L21
        if (r12 == true) goto L25;
    L17:
        this.mRequest.onUploadException(r8);
        return;
    L25:
        this.mDataProvider.close();     // Catch: Exception -> L15
        this.mClosed = true;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e(TAG, "Failure closing data provider", new Object[]{e});
        goto L17
    L9:
        r12 = false;
        goto L10
    L20:
        throw new IllegalStateException("There is no read or rewind or length check in progress.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public void attachNativeAdapterToRequest(long r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mUploadDataStreamAdapter = nativeAttachUploadDataToRequest(r8, this.mLength);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public long createUploadDataStreamForTesting() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mUploadDataStreamAdapter = nativeCreateAdapterForTesting();     // Catch: Throwable -> L7
        long r10 = this.mDataProvider.getLength();     // Catch: Throwable -> L7
        this.mLength = r10;     // Catch: Throwable -> L7
        this.mRemainingLength = r10;     // Catch: Throwable -> L7
        long r11 = nativeCreateUploadDataStreamForTesting(r10, this.mUploadDataStreamAdapter);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public void initializeWithRequest() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        this.mInWhichUserCallback = 2;     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        this.mRequest.checkCallingThread();     // Catch: Throwable -> L9
        long r10 = this.mDataProvider.getLength();     // Catch: Throwable -> L9
        this.mLength = r10;     // Catch: Throwable -> L9
        this.mRemainingLength = r10;     // Catch: Throwable -> L9
    L11:
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
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
    public void onReadError(Exception r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkState(0);     // Catch: Throwable -> L8
        onError(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    @SuppressLint({"DefaultLocale"})
    public void onReadSucceeded(boolean r10) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        checkState(0);     // Catch: Throwable -> L30
        if (this.mByteBufferLimit != this.mByteBuffer.limit()) goto L29;
        if (r10 == true) goto L10;
    L14:
        int r11 = this.mByteBuffer.position();     // Catch: Throwable -> L30
        long r12 = this.mRemainingLength - ((long) r11);     // Catch: Throwable -> L30
        this.mRemainingLength = r12;     // Catch: Throwable -> L30
        if (r12 < 0) goto L17;
    L21:
        this.mByteBuffer.position(0);     // Catch: Throwable -> L30
        this.mByteBuffer = null;     // Catch: Throwable -> L30
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L30
        destroyAdapterIfPostponed();     // Catch: Throwable -> L30
        long r13 = this.mUploadDataStreamAdapter;     // Catch: Throwable -> L30
        if (r13 != 0) goto L25;
        monitor-exit(r8);     // Catch: Throwable -> L30
        return;
    L25:
        nativeOnReadSucceeded(r13, r11, r10);     // Catch: Throwable -> L30
        monitor-exit(r8);     // Catch: Throwable -> L30
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
    public void onRewindError(Exception r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkState(1);     // Catch: Throwable -> L8
        onError(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        checkState(1);     // Catch: Throwable -> L12
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L12
        this.mRemainingLength = this.mLength;     // Catch: Throwable -> L12
        long r10 = this.mUploadDataStreamAdapter;     // Catch: Throwable -> L12
        if (r10 != 0) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L12
        return;
    L9:
        nativeOnRewindSucceeded(r10);     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    public void postTaskToExecutor(Runnable r8) {
        this.mExecutor.execute(r8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CronetUrlRequest r10 = this.mRequest;
        if (r10 == null) goto L10;
        r10.onUploadException(th);
        return;
    L10:
        throw new IllegalStateException("Unexpected request usage, caught in CronetUploadDataStream, caused by " + th);
    }

    @CalledByNative
    public void readData(ByteBuffer r8) {
        this.mByteBuffer = r8;
        this.mByteBufferLimit = r8.limit();
        postTaskToExecutor(this.mReadTask);
    }

    @CalledByNative
    public void rewind() {
        postTaskToExecutor(new AnonymousClass2(this));
    }

    @VisibleForTesting
    public void setOnDestroyedCallbackForTesting(Runnable r8) {
        this.mOnDestroyedCallbackForTesting = r8;
    }
}
