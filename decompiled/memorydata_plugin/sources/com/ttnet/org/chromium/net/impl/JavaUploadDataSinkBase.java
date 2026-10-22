package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
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

    public JavaUploadDataSinkBase(Executor r3, Executor r4, UploadDataProvider r5) {
        final Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        this.mSinkState = new AtomicInteger(3);
        this.mUserUploadExecutor = new AnonymousClass1(this, r6);
        this.mExecutor = r7;
        this.mUploadProvider = r5;
    }

    static /* synthetic */ ByteBuffer access$000(JavaUploadDataSinkBase r0) {
        return r0.mBuffer;
    }

    static /* synthetic */ ByteBuffer access$002(JavaUploadDataSinkBase r0, ByteBuffer r1) {
        r0.mBuffer = r1;
        return r1;
    }

    static /* synthetic */ long access$100(JavaUploadDataSinkBase r2) {
        return r2.mTotalBytes;
    }

    static /* synthetic */ long access$102(JavaUploadDataSinkBase r0, long r1) {
        r0.mTotalBytes = r1;
        return r1;
    }

    static /* synthetic */ long access$200(JavaUploadDataSinkBase r2) {
        return r2.mWrittenBytes;
    }

    static /* synthetic */ long access$214(JavaUploadDataSinkBase r2, long r3) {
        long r0 = r2.mWrittenBytes + r3;
        r2.mWrittenBytes = r0;
        return r0;
    }

    static /* synthetic */ AtomicInteger access$300(JavaUploadDataSinkBase r0) {
        return r0.mSinkState;
    }

    static /* synthetic */ UploadDataProvider access$400(JavaUploadDataSinkBase r0) {
        return r0.mUploadProvider;
    }

    static /* synthetic */ void access$500(JavaUploadDataSinkBase r2, JavaUrlRequestUtils.CheckedRunnable r3) {
        r2.executeOnUploadExecutor((JavaUrlRequestUtils.CheckedRunnable) ZeusTransformUtils.wrapperContextForParams(r3, JavaUrlRequestUtils.CheckedRunnable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$600(JavaUploadDataSinkBase r0) {
        r0.startRead();
    }

    private void executeOnUploadExecutor(JavaUrlRequestUtils.CheckedRunnable r3) {
        JavaUrlRequestUtils.CheckedRunnable r4 = (JavaUrlRequestUtils.CheckedRunnable) ZeusTransformUtils.wrapperContextForParams(r3, JavaUrlRequestUtils.CheckedRunnable.class, "com.obric.memorydata.plugin");
        this.mUserUploadExecutor.execute(getUploadErrorSettingRunnable(r4));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        processUploadError(e);
    }

    private void startRead() {
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass3(this)));
    }

    public abstract void finish();

    public abstract Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r1);

    public abstract Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r1);

    public abstract void initializeRead();

    public abstract void initializeStart(long r1);

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadError(Exception r1) {
        processUploadError(r1);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadSucceeded(final boolean r4) {
        if (this.mSinkState.compareAndSet(0, 2) == false) goto L7;
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass2(this, r4)));
        return;
    L7:
        throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.mSinkState.get());
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindError(Exception r1) {
        processUploadError(r1);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        if (this.mSinkState.compareAndSet(1, 2) == false) goto L7;
        startRead();
        return;
    L7:
        throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.mSinkState.get());
    }

    public abstract int processSuccessfulRead(ByteBuffer r1);

    public abstract void processUploadError(Throwable r1);

    public void start(final boolean r2) {
        executeOnUploadExecutor(new AnonymousClass4(this, r2));
    }
}
