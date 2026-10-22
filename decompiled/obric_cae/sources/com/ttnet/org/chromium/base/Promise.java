package com.ttnet.org.chromium.base;

import android.os.Handler;
import androidx.appcompat.app.r;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class Promise<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<Callback<T>> mFulfillCallbacks;
    private final Handler mHandler;
    private final List<Callback<Exception>> mRejectCallbacks;
    private Exception mRejectReason;
    private T mResult;
    private int mState;
    private final Thread mThread;
    private boolean mThrowingRejectionHandler;

    public interface AsyncFunction<A, R> {
        Promise<R> apply(A r8);
    }

    public interface Function<A, R> {
        R apply(A r8);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PromiseState {
        public static final int FULFILLED = 1;
        public static final int REJECTED = 2;
        public static final int UNFULFILLED = 0;
    }

    public static class UnhandledRejectionException extends RuntimeException {
        public UnhandledRejectionException(String r8, Throwable r10) {
            super(r8, r10);
        }
    }

    public Promise() {
        this.mState = 0;
        this.mFulfillCallbacks = new LinkedList();
        this.mRejectCallbacks = new LinkedList();
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
    }

    public static /* synthetic */ void a(Promise r8, Function r10, Object r11) {
        lambda$then$1(r8, r10, r11);
    }

    public static /* synthetic */ void b(Callback r8, Object r10) {
        lambda$postCallbackToLooper$3(r8, r10);
    }

    public static /* synthetic */ void c(AsyncFunction r8, Promise r10, Object r11) {
        lambda$then$2(r8, r10, r11);
    }

    private void checkThread() {
    }

    public static /* synthetic */ void d(Exception r8) {
        lambda$then$0(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void exceptInner(Callback<Exception> r8) {
        int r10 = this.mState;
        if (r10 != 2) goto L5;
        postCallbackToLooper(r8, this.mRejectReason);
        return;
    L5:
        if (r10 != 0) goto L9;
        this.mRejectCallbacks.add(r8);
        return;
    }

    public static <T> Promise<T> fulfilled(T r8) {
        Promise<T> r10 = new Promise();
        r10.fulfill(r8);
        return r10;
    }

    private static /* synthetic */ void lambda$postCallbackToLooper$3(Callback r8, Object r10) {
        r8.onResult(r10);
    }

    private static /* synthetic */ void lambda$then$0(Exception r8) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$then$1(Promise r8, Function r10, Object r11) {
        r8.fulfill(r10.apply(r11));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r8.reject(e);
    }

    private static /* synthetic */ void lambda$then$2(AsyncFunction r8, final Promise r10, Object r11) {
        Promise r12 = r8.apply(r11);     // Catch: Exception -> L4
        Objects.requireNonNull(r10);     // Catch: Exception -> L4
        r12.then(new d(r10), new e(r10, 0));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r10.reject(e);
    }

    private <S> void postCallbackToLooper(Callback<S> r8, S r10) {
        this.mHandler.post(new r(23, r8, r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void thenInner(Callback<T> r8) {
        int r10 = this.mState;
        if (r10 != 1) goto L5;
        postCallbackToLooper(r8, this.mResult);
        return;
    L5:
        if (r10 != 0) goto L9;
        this.mFulfillCallbacks.add(r8);
        return;
    }

    public void except(Callback<Exception> r8) {
        checkThread();
        exceptInner(r8);
    }

    public void fulfill(T r8) {
        checkThread();
        this.mState = 1;
        this.mResult = r8;
        Iterator<Callback<T>> r10 = this.mFulfillCallbacks.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        postCallbackToLooper(r10.next(), r8);
        goto L4
    L6:
        this.mFulfillCallbacks.clear();
    }

    public T getResult() {
        return this.mResult;
    }

    public boolean isFulfilled() {
        checkThread();
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isRejected() {
        checkThread();
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void reject() {
        reject(null);
    }

    public <R> Promise<R> then(final AsyncFunction<T, R> r8) {
        checkThread();
        final Promise<R> r10 = new Promise();
        thenInner(new b(r8, r10));
        exceptInner(new c(r10));
        return r10;
    }

    public void reject(Exception r8) {
        checkThread();
        this.mState = 2;
        this.mRejectReason = r8;
        Iterator<Callback<Exception>> r10 = this.mRejectCallbacks.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        postCallbackToLooper((Callback) r10.next(), r8);
        goto L4
    L6:
        this.mRejectCallbacks.clear();
    }

    public <R> Promise<R> then(final Function<T, R> r8) {
        checkThread();
        final Promise<R> r10 = new Promise();
        thenInner(new f(r10, r8));
        exceptInner(new e(r10, 1));
        return r10;
    }

    public void then(Callback<T> r8) {
        checkThread();
        if (this.mThrowingRejectionHandler == false) goto L6;
        thenInner(r8);
        return;
    L6:
        then(r8, new g());
        this.mThrowingRejectionHandler = true;
    }

    public void then(Callback<T> r8, Callback<Exception> r10) {
        checkThread();
        thenInner(r8);
        exceptInner(r10);
    }
}
