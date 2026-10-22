package com.ttnet.org.chromium.base;

import android.os.Handler;
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

    public interface AsyncFunction<A, RT> extends Function<A, Promise<RT>> {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface PromiseState {
        public static final int FULFILLED = 1;
        public static final int REJECTED = 2;
        public static final int UNFULFILLED = 0;
    }

    public static class UnhandledRejectionException extends RuntimeException {
        public UnhandledRejectionException(String r10, Throwable r11) {
            super(r10, r11);
        }
    }

    static {
    }

    public Promise() {
        this.mState = 0;
        this.mFulfillCallbacks = new LinkedList();
        this.mRejectCallbacks = new LinkedList();
        this.mThread = Thread.currentThread();
        this.mHandler = new Handler();
    }

    public static /* synthetic */ void a(Promise r10, Function r11, Object r12) {
        lambda$then$1(r10, r11, r12);
    }

    public static /* synthetic */ void b(AsyncFunction r10, Promise r11, Object r12) {
        lambda$then$2(r10, r11, r12);
    }

    public static /* synthetic */ void c(Exception r10) {
        lambda$then$0(r10);
    }

    private void checkThread() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void exceptInner(Callback<Exception> r10) {
        int r11 = this.mState;
        if (r11 != 2) goto L5;
        postCallbackToLooper(r10, this.mRejectReason);
        return;
    L5:
        if (r11 != 0) goto L9;
        this.mRejectCallbacks.add(r10);
        return;
    }

    public static <T> Promise<T> fulfilled(T r10) {
        Promise<T> r11 = new Promise();
        r11.fulfill(r10);
        return r11;
    }

    private static /* synthetic */ void lambda$then$0(Exception r10) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$then$1(Promise r10, Function r11, Object r12) {
        r10.fulfill(r11.apply(r12));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r10.reject(e);
    }

    private static /* synthetic */ void lambda$then$2(AsyncFunction r10, final Promise r11, Object r12) {
        Promise r13 = r10.apply(r12);     // Catch: Exception -> L4
        Objects.requireNonNull(r11);     // Catch: Exception -> L4
        r13.then(new g(r11), new f(r11));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r11.reject(e);
    }

    private <S> void postCallbackToLooper(Callback<S> r10, S r11) {
        this.mHandler.post(r10.bind(r11));
    }

    public static <T> Promise<T> rejected() {
        Promise<T> r10 = new Promise();
        r10.reject();
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void thenInner(Callback<T> r10) {
        int r11 = this.mState;
        if (r11 != 1) goto L5;
        postCallbackToLooper(r10, this.mResult);
        return;
    L5:
        if (r11 != 0) goto L9;
        this.mFulfillCallbacks.add(r10);
        return;
    }

    public void except(Callback<Exception> r10) {
        checkThread();
        exceptInner(r10);
    }

    public void fulfill(T r10) {
        checkThread();
        this.mState = 1;
        this.mResult = r10;
        Iterator<Callback<T>> r11 = this.mFulfillCallbacks.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        postCallbackToLooper(r11.next(), r10);
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

    public void reject(Exception r10) {
        checkThread();
        this.mState = 2;
        this.mRejectReason = r10;
        Iterator<Callback<Exception>> r11 = this.mRejectCallbacks.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        postCallbackToLooper((Callback) r11.next(), r10);
        goto L4
    L6:
        this.mRejectCallbacks.clear();
    }

    public <RT> Promise<RT> then(final Function<T, RT> r10) {
        checkThread();
        final Promise<RT> r11 = new Promise();
        thenInner(new h(r11, r10));
        exceptInner(new f(r11));
        return r11;
    }

    public <RT> Promise<RT> then(final AsyncFunction<T, RT> r10) {
        checkThread();
        final Promise<RT> r11 = new Promise();
        thenInner(new e(r10, r11));
        exceptInner(new f(r11));
        return r11;
    }

    public void then(Callback<T> r10) {
        checkThread();
        if (this.mThrowingRejectionHandler == false) goto L6;
        thenInner(r10);
        return;
    L6:
        then(r10, i.f8414c);
        this.mThrowingRejectionHandler = true;
    }

    public void then(Callback<T> r10, Callback<Exception> r11) {
        checkThread();
        thenInner(r10);
        exceptInner(r11);
    }
}
