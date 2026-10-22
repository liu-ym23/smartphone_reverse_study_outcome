package androidx.core.os;

import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void cancel(Object r10) {
            ((android.os.CancellationSignal) r10).cancel();
        }

        @DoNotInline
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
        OnCancelListener r10 = this.mOnCancelListener;     // Catch: Throwable -> L33
        Object r11 = this.mCancellationSignalObj;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        if (r10 != null) goto L36;
    L14:
        if (r11 != null) goto L16;
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
        Api16Impl.cancel(r11);     // Catch: Throwable -> L12
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
        r10.onCancel();     // Catch: Throwable -> L12
        goto L14
    }

    @Nullable
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
        android.os.CancellationSignal r10 = Api16Impl.createCancellationSignal();     // Catch: Throwable -> L15
        this.mCancellationSignalObj = r10;     // Catch: Throwable -> L15
        if (this.mIsCanceled == false) goto L12;
        Api16Impl.cancel(r10);     // Catch: Throwable -> L15
    L12:
        Object r11 = this.mCancellationSignalObj;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r11;
    }

    public boolean isCanceled() {
        monitor-enter(this);
        boolean r10 = this.mIsCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void setOnCancelListener(@Nullable OnCancelListener r10) {
        monitor-enter(this);
        waitForCancelFinishedLocked();     // Catch: Throwable -> L16
        if (this.mOnCancelListener != r10) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L7:
        this.mOnCancelListener = r10;     // Catch: Throwable -> L16
        if (this.mIsCanceled == false) goto L14;
        if (r10 == null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L16
        r10.onCancel();
        return;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
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
