package com.obric.cae.smartBluetooth.a2dpJitterML;

import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterMlAoiBoardCallbackController {
    private static final String TAG = "A2dpJitterMlAoiBoardCb";
    private final AoiBoardCallback mCallback;
    private final Object mLock;
    private boolean mStarted;
    private final ZppInnerCallback mZppInnerCallback;

    public interface AoiBoardCallback {
        void onAoiBoardInfoChange(AoiBoard r8);
    }

    public final class ZppInnerCallback extends InnerAwareInfoCallback {
        final /* synthetic */ A2dpJitterMlAoiBoardCallbackController this$0;

        public ZppInnerCallback(A2dpJitterMlAoiBoardCallbackController r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onAoiBoardEvent(AoiBoard r8) {
            CaeLog.i(A2dpJitterMlAoiBoardCallbackController.TAG, "onAoiBoardEvent: " + r8);
            AoiBoardCallback r10 = A2dpJitterMlAoiBoardCallbackController.access$000(this.this$0);
            if (r10 == null) goto L6;
            r10.onAoiBoardInfoChange(r8);
            return;
        }
    }

    public A2dpJitterMlAoiBoardCallbackController(AoiBoardCallback r8) {
        this.mLock = new Object();
        this.mZppInnerCallback = new ZppInnerCallback(this);
        this.mCallback = r8;
    }

    public static /* synthetic */ AoiBoardCallback access$000(A2dpJitterMlAoiBoardCallbackController r8) {
        return r8.mCallback;
    }

    public void start() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        UserAwareManager.getInstance().registerInnerCallback(this.mZppInnerCallback);     // Catch: Throwable -> L11
        this.mStarted = true;     // Catch: Throwable -> L11
        CaeLog.i(TAG, "aoiBoard callback registered.");     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }

    public void stop() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        UserAwareManager.getInstance().unregisterInnerCallback(this.mZppInnerCallback);     // Catch: Throwable -> L11
        this.mStarted = false;     // Catch: Throwable -> L11
        CaeLog.i(TAG, "aoiBoard callback unregistered.");     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }
}
