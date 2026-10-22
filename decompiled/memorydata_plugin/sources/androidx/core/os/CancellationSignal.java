package androidx.core.os;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    static class Api16Impl {
        private Api16Impl() {
        }

        static void cancel(Object r2) {
            ((android.os.CancellationSignal) ZeusTransformUtils.preCheckCast(r2, android.os.CancellationSignal.class, "com.obric.memorydata.plugin")).cancel();
        }

        static android.os.CancellationSignal createCancellationSignal() {
            return new android.os.CancellationSignal();
        }
    }

    public interface OnCancelListener {
        void onCancel();
    }

    public CancellationSignal() {
    }

    private void waitForCancelFinishedLocked() {
    L3:
        if (this.mCancelInProgress == false) goto L6;
        wait();     // Catch: InterruptedException -> L7
        goto L3
    }

    public void cancel() {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsCanceled == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L33
        return;
    L7:
        this.mIsCanceled = true;     // Catch: Throwable -> L33
        this.mCancelInProgress = true;     // Catch: Throwable -> L33
        OnCancelListener r0 = this.mOnCancelListener;     // Catch: Throwable -> L33
        Object r1 = this.mCancellationSignalObj;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r0 != null) goto L36;
    L14:
        if (r1 != null) goto L16;
    L26:
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L30
        notifyAll();     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L16:
        if (Build.VERSION.SDK_INT < 16) goto L26;
        Api16Impl.cancel(r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L23
        notifyAll();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L36:
        r0.onCancel();     // Catch: Throwable -> L12
        goto L14
    }

    public Object getCancellationSignalObject() {
        if (Build.VERSION.SDK_INT >= 16) goto L6;
        return null;
    L6:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.mCancellationSignalObj != null) goto L12;
        android.os.CancellationSignal r0 = Api16Impl.createCancellationSignal();     // Catch: Throwable -> L15
        this.mCancellationSignalObj = r0;     // Catch: Throwable -> L15
        if (this.mIsCanceled == false) goto L12;
        Api16Impl.cancel(r0);     // Catch: Throwable -> L15
    L12:
        Object r1 = this.mCancellationSignalObj;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r1;
    }

    public boolean isCanceled() {
        monitor-enter(this);
        boolean r0 = this.mIsCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void setOnCancelListener(OnCancelListener r3) {
        OnCancelListener r4 = (OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, OnCancelListener.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        waitForCancelFinishedLocked();     // Catch: Throwable -> L17
        if (this.mOnCancelListener != r4) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L8:
        this.mOnCancelListener = r4;     // Catch: Throwable -> L17
        if (this.mIsCanceled == false) goto L15;
        if (r4 == null) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L17
        r4.onCancel();
        return;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void throwIfCanceled() {
        if (isCanceled() == true) goto L6;
        return;
    L6:
        throw new OperationCanceledException();
    }
}
