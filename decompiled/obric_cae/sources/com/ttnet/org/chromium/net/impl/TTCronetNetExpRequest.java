package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public final class TTCronetNetExpRequest extends TTNetDiagnosisRequest {
    private static final String TAG = "TTCronetNetExpRequest";
    private final TTNetDiagnosisRequest.Callback mCallback;
    private Executor mExecutor;
    private int mNetDetectActions;

    @GuardedBy("mNetDiagnosisRequestAdapterLock")
    private long mNetDiagnosisRequestAdapter;
    private final Object mNetDiagnosisRequestAdapterLock;
    private CronetUrlRequestContext mRequestContext;
    private int mRequestType;

    @GuardedBy("mNetDiagnosisRequestAdapterLock")
    private boolean mStarted;
    private List<String> mTargets;
    private int mTimeoutMs;

    public TTCronetNetExpRequest(CronetUrlRequestContext r8, TTNetDiagnosisRequest.Callback r10, Executor r11, int r12, List<String> r13, int r14, int r15) {
        this.mNetDiagnosisRequestAdapterLock = new Object();
        this.mRequestContext = r8;
        this.mCallback = r10;
        this.mExecutor = r11;
        this.mRequestType = r12;
        this.mTargets = r13;
        this.mNetDetectActions = r14;
        this.mTimeoutMs = r15;
    }

    public static /* synthetic */ Object access$000(TTCronetNetExpRequest r8) {
        return r8.mNetDiagnosisRequestAdapterLock;
    }

    public static /* synthetic */ boolean access$100(TTCronetNetExpRequest r8) {
        return r8.isDoneLocked();
    }

    public static /* synthetic */ void access$200(TTCronetNetExpRequest r8) {
        r8.destroyRequestAdapterLocked();
    }

    public static /* synthetic */ TTNetDiagnosisRequest.Callback access$300(TTCronetNetExpRequest r8) {
        return r8.mCallback;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    @GuardedBy("mNetDiagnosisRequestAdapterLock")
    private void destroyRequestAdapterLocked() {
        long r8 = this.mNetDiagnosisRequestAdapter;
        if (r8 != 0) goto L5;
        return;
    L5:
        nativeDestroy(r8);
        this.mNetDiagnosisRequestAdapter = 0;
    }

    @GuardedBy("mNetDiagnosisRequestAdapterLock")
    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNetDiagnosisRequestAdapter != 0) goto L7;
        return true;
    }

    private native long nativeCreateRequestAdapter(long r8, int r10, String[] r11, int r12, int r13);

    @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
    private native void nativeDestroy(long r8);

    @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
    private native void nativeDoExtraCommand(long r8, String r10, String r11);

    @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
    private native void nativeStart(long r8);

    @CalledByNative
    private void onNetExpRequestComplete(final String r8, final boolean r10) {
        postTaskToExecutor(new AnonymousClass1(this, r10, r8));
    }

    private void postTaskToExecutor(Runnable r8) {
        Executor r10 = this.mExecutor;     // Catch: RejectedExecutionException -> L7
        if (r10 == null) goto L5;
        r10.execute(r8);     // Catch: RejectedExecutionException -> L7
    L10:
        return;
    L5:
        new Thread(r8, "NetExpCallback").start();     // Catch: RejectedExecutionException -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void cancel() {
        Object r8 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked();     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void doExtraCommand(String r8, String r10) {
        Object r11 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        nativeDoExtraCommand(this.mNetDiagnosisRequestAdapter, r8, r10);     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void start() {
        Object r8 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r8);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L8:
        long r10 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: Throwable -> L15
        int r11 = this.mRequestType;     // Catch: Throwable -> L15
        List<String> r12 = this.mTargets;     // Catch: Throwable -> L15
        long r13 = nativeCreateRequestAdapter(r10, r11, (String[]) r12.toArray(new String[r12.size()]), this.mNetDetectActions, this.mTimeoutMs);     // Catch: Throwable -> L15
        this.mNetDiagnosisRequestAdapter = r13;     // Catch: Throwable -> L15
        if (r13 == 0) goto L14;
        this.mStarted = true;     // Catch: Throwable -> L15
        nativeStart(r13);     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L14:
        throw new NullPointerException("Create native net exp request adapter failed.");     // Catch: Throwable -> L15
    }
}
