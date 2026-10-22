package androidx.core.os;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

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
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsCanceled == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mIsCanceled = true;     // Catch: Throwable -> L7
        this.mCancelInProgress = true;     // Catch: Throwable -> L7
        OnCancelListener r5 = this.mOnCancelListener;     // Catch: Throwable -> L7
        Object r10 = this.mCancellationSignalObj;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r5 != null) goto L38;
    L16:
        if (r10 == null) goto L26;
        ((android.os.CancellationSignal) r10).cancel();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L23
        notifyAll();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L26:
        monitor-enter(this);
        this.mCancelInProgress = false;     // Catch: Throwable -> L30
        notifyAll();     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L38:
        r5.onCancel();     // Catch: Throwable -> L14
        goto L16
    }

    @Nullable
    public Object getCancellationSignalObject() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mCancellationSignalObj != null) goto L10;
        android.os.CancellationSignal r5 = new android.os.CancellationSignal();     // Catch: Throwable -> L8
        this.mCancellationSignalObj = r5;     // Catch: Throwable -> L8
        if (this.mIsCanceled == false) goto L10;
        r5.cancel();     // Catch: Throwable -> L8
    L10:
        Object r10 = this.mCancellationSignalObj;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r10;
    }

    public boolean isCanceled() {
        monitor-enter(this);
        boolean r5 = this.mIsCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public void setOnCancelListener(@Nullable OnCancelListener r5) {
        monitor-enter(this);
        waitForCancelFinishedLocked();     // Catch: Throwable -> L7
        if (this.mOnCancelListener != r5) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mOnCancelListener = r5;     // Catch: Throwable -> L7
        if (this.mIsCanceled == false) goto L16;
        if (r5 == null) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L7
        r5.onCancel();
        return;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
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
