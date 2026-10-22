package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes6.dex */
public final class CallbackController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ArrayList<WeakReference<Cancelable>> mCancelables;
    private final ReentrantLock mReentrantLock;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.CallbackController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AutoCloseableLock implements AutoCloseable {
        private boolean mIsLocked;
        private final Lock mLock;

        private AutoCloseableLock(Lock r3, boolean r4) {
            this.mLock = (Lock) ZeusTransformUtils.wrapperContextForParams(r3, Lock.class, "com.obric.memorydata.plugin");
            this.mIsLocked = r4;
        }

        static AutoCloseableLock lock(Lock r2) {
            Lock r3 = (Lock) ZeusTransformUtils.wrapperContextForParams(r2, Lock.class, "com.obric.memorydata.plugin");
            r3.lock();
            return new AutoCloseableLock(r3, true);
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

    private class CancelableCallback<T> implements Callback<T>, Cancelable {
        private Callback<T> mCallback;
        final /* synthetic */ CallbackController this$0;

        private CancelableCallback(CallbackController r3, Callback<T> r4) {
            Callback<T> r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mCallback = r5;
        }

        /* synthetic */ CancelableCallback(CallbackController r2, Callback r3, AnonymousClass1 r4) {
            this(r2, (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mCallback = null;
        }

        @Override // com.ttnet.org.chromium.base.Callback
        public void onResult(T r2) {
            AutoCloseableLock r0 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Callback<T> r1 = this.mCallback;     // Catch: Throwable -> L9
            if (r1 == null) goto L6;
            r1.onResult(r2);     // Catch: Throwable -> L9
        L6:
            if (r0 == null) goto L20;
            r0.close();
            return;
        L20:
            return;
        L9:
            th = move-exception;
            if (r0 != null) goto L18;
        L15:
            throw th;
        L18:
            r0.close();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.addSuppressed(th);
            goto L15
        }
    }

    private class CancelableRunnable implements Cancelable, Runnable {
        private Runnable mRunnable;
        final /* synthetic */ CallbackController this$0;

        private CancelableRunnable(CallbackController r3, Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mRunnable = r5;
        }

        /* synthetic */ CancelableRunnable(CallbackController r2, Runnable r3, AnonymousClass1 r4) {
            this(r2, (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.ttnet.org.chromium.base.CallbackController.Cancelable
        public void cancel() {
            this.mRunnable = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoCloseableLock r0 = AutoCloseableLock.lock(CallbackController.access$000(this.this$0));
            Runnable r1 = this.mRunnable;     // Catch: Throwable -> L9
            if (r1 == null) goto L6;
            r1.run();     // Catch: Throwable -> L9
        L6:
            if (r0 == null) goto L20;
            r0.close();
            return;
        L20:
            return;
        L9:
            th = move-exception;
            if (r0 != null) goto L18;
        L15:
            throw th;
        L18:
            r0.close();     // Catch: Throwable -> L13
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

    static /* synthetic */ ReentrantLock access$000(CallbackController r0) {
        return r0.mReentrantLock;
    }

    private void checkNotCanceled() {
        if (this.mCancelables == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("This CallbackController has already been destroyed.");
    }

    public void destroy() {
        AutoCloseableLock r0 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L11
        Iterator r1 = CollectionUtil.strengthen(this.mCancelables).iterator();     // Catch: Throwable -> L11
    L5:
        if (r1.hasNext() == false) goto L7;
        ((Cancelable) ZeusTransformUtils.preCheckCast(r1.next(), Cancelable.class, "com.obric.memorydata.plugin")).cancel();     // Catch: Throwable -> L11
        goto L5
    L7:
        this.mCancelables = null;     // Catch: Throwable -> L11
        if (r0 == null) goto L23;
        r0.close();
        return;
    L23:
        return;
    L11:
        th = move-exception;
        if (r0 != null) goto L20;
    L17:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public <T> Callback<T> makeCancelable(Callback<T> r4) {
        Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        AutoCloseableLock r0 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableCallback r1 = new CancelableCallback(this, r5, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r1));     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L14;
    L13:
        throw th;
    L14:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public Runnable makeCancelable(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        AutoCloseableLock r0 = AutoCloseableLock.lock(this.mReentrantLock);
        checkNotCanceled();     // Catch: Throwable -> L7
        CancelableRunnable r1 = new CancelableRunnable(this, r5, null);     // Catch: Throwable -> L7
        this.mCancelables.add(new WeakReference(r1));     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L14;
    L13:
        throw th;
    L14:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
