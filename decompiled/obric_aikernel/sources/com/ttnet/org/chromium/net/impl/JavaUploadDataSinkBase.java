package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JavaUploadDataSinkBase extends UploadDataSink {
    public static final int DEFAULT_UPLOAD_BUFFER_SIZE = 8192;
    private ByteBuffer mBuffer;
    private final Executor mExecutor;
    private final AtomicInteger mSinkState;
    private long mTotalBytes;
    private final UploadDataProvider mUploadProvider;
    private final Executor mUserUploadExecutor;
    private long mWrittenBytes;

    @Retention(RetentionPolicy.SOURCE)
    @interface SinkState {
        public static final int AWAITING_READ_RESULT = 0;
        public static final int AWAITING_REWIND_RESULT = 1;
        public static final int NOT_STARTED = 3;
        public static final int UPLOADING = 2;
    }

    public JavaUploadDataSinkBase(final Executor r10, Executor r11, UploadDataProvider r12) {
        this.mSinkState = new AtomicInteger(3);
        this.mUserUploadExecutor = new AnonymousClass1(this, r10);
        this.mExecutor = r11;
        this.mUploadProvider = r12;
    }

    static /* synthetic */ ByteBuffer access$000(JavaUploadDataSinkBase r10) {
        return r10.mBuffer;
    }

    static /* synthetic */ ByteBuffer access$002(JavaUploadDataSinkBase r10, ByteBuffer r11) {
        r10.mBuffer = r11;
        return r11;
    }

    static /* synthetic */ long access$100(JavaUploadDataSinkBase r10) {
        return r10.mTotalBytes;
    }

    static /* synthetic */ long access$102(JavaUploadDataSinkBase r10, long r11) {
        r10.mTotalBytes = r11;
        return r11;
    }

    static /* synthetic */ long access$200(JavaUploadDataSinkBase r10) {
        return r10.mWrittenBytes;
    }

    static /* synthetic */ long access$214(JavaUploadDataSinkBase r10, long r11) {
        long r12 = r10.mWrittenBytes + r11;
        r10.mWrittenBytes = r12;
        return r12;
    }

    static /* synthetic */ AtomicInteger access$300(JavaUploadDataSinkBase r10) {
        return r10.mSinkState;
    }

    static /* synthetic */ UploadDataProvider access$400(JavaUploadDataSinkBase r10) {
        return r10.mUploadProvider;
    }

    static /* synthetic */ void access$500(JavaUploadDataSinkBase r10, JavaUrlRequestUtils.CheckedRunnable r11) {
        r10.executeOnUploadExecutor(r11);
    }

    static /* synthetic */ void access$600(JavaUploadDataSinkBase r10) {
        r10.startRead();
    }

    private void executeOnUploadExecutor(JavaUrlRequestUtils.CheckedRunnable r10) {
        this.mUserUploadExecutor.execute(getUploadErrorSettingRunnable(r10));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        processUploadError(e);
    }

    private void startRead() {
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass3(this)));
    }

    protected abstract void finish();

    protected abstract Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r10);

    protected abstract Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r10);

    protected abstract void initializeRead();

    protected abstract void initializeStart(long r10);

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadError(Exception r10) {
        processUploadError(r10);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadSucceeded(final boolean r10) {
        if (this.mSinkState.compareAndSet(0, 2) == false) goto L7;
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass2(this, r10)));
        return;
    L7:
        throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.mSinkState.get());
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindError(Exception r10) {
        processUploadError(r10);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        if (this.mSinkState.compareAndSet(1, 2) == false) goto L7;
        startRead();
        return;
    L7:
        throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.mSinkState.get());
    }

    protected abstract int processSuccessfulRead(ByteBuffer r10);

    protected abstract void processUploadError(Throwable r10);

    public void start(final boolean r10) {
        executeOnUploadExecutor(new AnonymousClass4(this, r10));
    }
}
