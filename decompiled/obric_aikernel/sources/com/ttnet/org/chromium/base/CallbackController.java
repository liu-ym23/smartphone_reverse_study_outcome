package com.ttnet.org.chromium.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class CallbackController {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private ArrayList<WeakReference<Cancelable>> mCancelables;
    private final ReentrantLock mReentrantLock;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.CallbackController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AutoCloseableLock implements AutoCloseable {
        private boolean mIsLocked;
        private final Lock mLock;

        private AutoCloseableLock(Lock r10, boolean r11) {
            this.mLock = r10;
            this.mIsLocked = r11;
        }

        static AutoCloseableLock lock(Lock r10) {
            r10.lock();
            return new AutoCloseableLock(r10, true);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.mIsLocked == false) goto L7;
            this.mIsLocked = false;
            this.mLock.unlock();
            return;
        L7:
            throw new IllegalStateException("mLock isn't locked.");
        }
    }

    private interface Cancelable {
        void cancel();
    }

    private class CancelableCallback<T> implements Cancelable, Callback<T> {
        private Callback<T> mCallback;
        final /* synthetic */ CallbackController this$0;

        private CancelableCallback(@NonNull CallbackController r10, Callback<T> r11) {
            this.this$0 = r10;
            this.mCallback = r11;
        }

        /* synthetic */ CancelableCallback(CallbackController r10, Callback r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mCallback = null;
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(T r10) {
            AutoCloseableLock r11 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Callback<T> r12 = this.mCallback;     // Catch: Throwable -> L9
            if (r12 == null) goto L6;
            r12.onResult(r10);     // Catch: Throwable -> L9
        L6:
            if (r11 == null) goto L20;
            r11.close();
            return;
        L20:
            return;
        L9:
            th = move-exception;
            if (r11 != null) goto L18;
        L15:
            throw th;
        L18:
            r11.close();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.addSuppressed(th);
            goto L15
        }
    }

    private class CancelableRunnable implements Cancelable, Runnable {
        private Runnable mRunnable;
        final /* synthetic */ CallbackController this$0;

        private CancelableRunnable(@NonNull CallbackController r10, Runnable r11) {
            this.this$0 = r10;
            this.mRunnable = r11;
        }

        /* synthetic */ CancelableRunnable(CallbackController r10, Runnable r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mRunnable = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoCloseableLock r10 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Runnable r11 = this.mRunnable;     // Catch: Throwable -> L9
            if (r11 == null) goto L6;
            r11.run();     // Catch: Throwable -> L9
        L6:
            if (r10 == null) goto L20;
            r10.close();
            return;
        L20:
            return;
        L9:
            th = move-exception;
            if (r10 != null) goto L18;
        L15:
            throw th;
        L18:
            r10.close();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.addSuppressed(th);
            goto L15
        }
    }

    static {
    }

    public CallbackController() {
        this.mCancelables = new ArrayList();
        this.mReentrantLock = new ReentrantLock(true);
    }

    static /* synthetic */ ReentrantLock access$000(CallbackController r10) {
        return r10.mReentrantLock;
    }

    private void checkNotCanceled() {
        if (this.mCancelables == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("This CallbackController has already been destroyed.");
    }

    public void destroy() {
        AutoCloseableLock r10 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L11
        Iterator r11 = CollectionUtil.strengthen(this.mCancelables).iterator();     // Catch: Throwable -> L11
    L5:
        if (r11.hasNext() == false) goto L7;
        ((Cancelable) r11.next()).cancel();     // Catch: Throwable -> L11
        goto L5
    L7:
        this.mCancelables = null;     // Catch: Throwable -> L11
        if (r10 == null) goto L23;
        r10.close();
        return;
    L23:
        return;
    L11:
        th = move-exception;
        if (r10 != null) goto L18;
    L17:
        throw th;
    L18:
        r10.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public <T> Callback<T> makeCancelable(@NonNull Callback<T> r10) {
        AutoCloseableLock r11 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableCallback r12 = new CancelableCallback(this, r10, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r12));     // Catch: Throwable -> L7
        if (r11 == null) goto L6;
        r11.close();
    L6:
        return r12;
    L7:
        th = move-exception;
        if (r11 != null) goto L14;
    L13:
        throw th;
    L14:
        r11.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public Runnable makeCancelable(@NonNull Runnable r10) {
        AutoCloseableLock r11 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableRunnable r12 = new CancelableRunnable(this, r10, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r12));     // Catch: Throwable -> L7
        if (r11 == null) goto L6;
        r11.close();
    L6:
        return r12;
    L7:
        th = move-exception;
        if (r11 != null) goto L14;
    L13:
        throw th;
    L14:
        r11.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
