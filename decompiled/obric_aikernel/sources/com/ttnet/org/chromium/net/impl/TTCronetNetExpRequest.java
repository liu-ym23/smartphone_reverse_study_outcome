package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public final class TTCronetNetExpRequest extends TTNetDiagnosisRequest {
    private static final String TAG = "TTCronetNetExpRequest";
    private final TTNetDiagnosisRequest.Callback mCallback;
    private Executor mExecutor;
    private int mMultiNetAction;
    private int mNetDetectActions;
    private long mNetDiagnosisRequestAdapter;
    private final Object mNetDiagnosisRequestAdapterLock;
    private CronetUrlRequestContext mRequestContext;
    private int mRequestType;
    private boolean mStarted;
    private List<String> mTargets;
    private int mTimeoutMs;

    interface Natives {
        long createRequestAdapter(TTCronetNetExpRequest r10, long r11, int r12, String[] r13, int r14, int r15, int r16);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void destroy(long r10, TTCronetNetExpRequest r11);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void doExtraCommand(long r10, TTCronetNetExpRequest r11, String r12, String r13);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void start(long r10, TTCronetNetExpRequest r11);
    }

    static {
    }

    public TTCronetNetExpRequest(CronetUrlRequestContext r10, TTNetDiagnosisRequest.Callback r11, Executor r12, int r13, List<String> r14, int r15, int r16, int r17) {
        this.mNetDiagnosisRequestAdapterLock = new Object();
        this.mRequestContext = r10;
        this.mCallback = r11;
        this.mExecutor = r12;
        this.mRequestType = r13;
        this.mTargets = r14;
        this.mNetDetectActions = r15;
        this.mMultiNetAction = r16;
        this.mTimeoutMs = r17;
    }

    static /* synthetic */ Object access$000(TTCronetNetExpRequest r10) {
        return r10.mNetDiagnosisRequestAdapterLock;
    }

    static /* synthetic */ boolean access$100(TTCronetNetExpRequest r10) {
        return r10.isDoneLocked();
    }

    static /* synthetic */ void access$200(TTCronetNetExpRequest r10) {
        r10.destroyRequestAdapterLocked();
    }

    static /* synthetic */ TTNetDiagnosisRequest.Callback access$300(TTCronetNetExpRequest r10) {
        return r10.mCallback;
    }

    static /* synthetic */ String access$400() {
        return TAG;
    }

    private void destroyRequestAdapterLocked() {
        if (this.mNetDiagnosisRequestAdapter != 0) goto L5;
        return;
    L5:
        TTCronetNetExpRequestJni.get().destroy(this.mNetDiagnosisRequestAdapter, this);
        this.mNetDiagnosisRequestAdapter = 0;
    }

    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNetDiagnosisRequestAdapter != 0) goto L7;
        return true;
    }

    @CalledByNative
    private void onNetExpRequestComplete(final String r10, final boolean r11) {
        postTaskToExecutor(new AnonymousClass1(this, r11, r10));
    }

    private void postTaskToExecutor(Runnable r10) {
        Executor r11 = this.mExecutor;     // Catch: RejectedExecutionException -> L7
        if (r11 == null) goto L5;
        r11.execute(r10);     // Catch: RejectedExecutionException -> L7
    L10:
        return;
    L5:
        new Thread(r10, "NetExpCallback").start();     // Catch: RejectedExecutionException -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void cancel() {
        Object r10 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked();     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void doExtraCommand(String r10, String r11) {
        Object r12 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        TTCronetNetExpRequestJni.get().doExtraCommand(this.mNetDiagnosisRequestAdapter, this, r10, r11);     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void start() {
        Object r10 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L8:
        Natives r11 = TTCronetNetExpRequestJni.get();     // Catch: Throwable -> L15
        long r12 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: Throwable -> L15
        int r13 = this.mRequestType;     // Catch: Throwable -> L15
        List<String> r14 = this.mTargets;     // Catch: Throwable -> L15
        long r15 = r11.createRequestAdapter(this, r12, r13, (String[]) r14.toArray(new String[r14.size()]), this.mNetDetectActions, this.mMultiNetAction, this.mTimeoutMs);     // Catch: Throwable -> L15
        this.mNetDiagnosisRequestAdapter = r15;     // Catch: Throwable -> L15
        if (r15 == 0) goto L14;
        this.mStarted = true;     // Catch: Throwable -> L15
        TTCronetNetExpRequestJni.get().start(this.mNetDiagnosisRequestAdapter, this);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L14:
        throw new NullPointerException("Create native net exp request adapter failed.");     // Catch: Throwable -> L15
    }
}
