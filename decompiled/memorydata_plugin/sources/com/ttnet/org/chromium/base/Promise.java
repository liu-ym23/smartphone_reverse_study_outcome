package com.ttnet.org.chromium.base;

import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
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
        public UnhandledRejectionException(String r1, Throwable r2) {
            super(r1, r2);
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

    private void checkThread() {
    }

    private void exceptInner(Callback<Exception> r3) {
        Callback<S> r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        int r0 = this.mState;
        if (r0 != 2) goto L5;
        postCallbackToLooper(r4, this.mRejectReason);
        return;
    L5:
        if (r0 != 0) goto L9;
        this.mRejectCallbacks.add((Callback<Exception>) r4);
        return;
    }

    public static <T> Promise<T> fulfilled(T r1) {
        Promise<T> r0 = new Promise();
        r0.fulfill(r1);
        return r0;
    }

    static /* synthetic */ void lambda$then$0(Exception r2) {
        throw new UnhandledRejectionException("Promise was rejected without a rejection handler.", r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$then$1(Promise r2, Function r3, Object r4) {
        r2.fulfill(((Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin")).apply(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r2.reject(e);
    }

    static /* synthetic */ void lambda$then$2(AsyncFunction r2, final Promise r3, Object r4) {
        Promise r5 = (Promise) ZeusTransformUtils.preCheckCast(((AsyncFunction) ZeusTransformUtils.wrapperContextForParams(r2, AsyncFunction.class, "com.obric.memorydata.plugin")).apply(r4), Promise.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Objects.requireNonNull(r3);     // Catch: Exception -> L5
        Callback<T> r6 = new $$Lambda$9Upca4gyXIiOJEcVqy3DvlA5Mhk(r3);     // Catch: Exception -> L5
        Objects.requireNonNull(r3);     // Catch: Exception -> L5
        r5.then(r6, new $$Lambda$EZnZNrcCA72vS8z3mA_yvnO1EPY(r3));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r3.reject(e);
    }

    private <S> void postCallbackToLooper(Callback<S> r3, S r4) {
        Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        this.mHandler.post(r5.bind(r4));
    }

    public static <T> Promise<T> rejected() {
        Promise<T> r0 = new Promise();
        r0.reject();
        return r0;
    }

    private void thenInner(Callback<T> r3) {
        Callback<S> r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        int r0 = this.mState;
        if (r0 != 1) goto L5;
        postCallbackToLooper(r4, this.mResult);
        return;
    L5:
        if (r0 != 0) goto L9;
        this.mFulfillCallbacks.add((Callback<T>) r4);
        return;
    }

    public void except(Callback<Exception> r3) {
        Callback<Exception> r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        checkThread();
        exceptInner(r4);
    }

    public void fulfill(T r5) {
        checkThread();
        this.mState = 1;
        this.mResult = r5;
        Iterator<Callback<T>> r0 = this.mFulfillCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        postCallbackToLooper((Callback) ZeusTransformUtils.preCheckCast(r0.next(), Callback.class, "com.obric.memorydata.plugin"), r5);
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

    public void reject(Exception r5) {
        checkThread();
        this.mState = 2;
        this.mRejectReason = r5;
        Iterator<Callback<Exception>> r0 = this.mRejectCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        postCallbackToLooper((Callback) ZeusTransformUtils.preCheckCast(r0.next(), Callback.class, "com.obric.memorydata.plugin"), r5);
        goto L4
    L6:
        this.mRejectCallbacks.clear();
    }

    public <RT> Promise<RT> then(Function<T, RT> r3) {
        final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        checkThread();
        final Promise<RT> r0 = new Promise();
        thenInner(new $$Lambda$Promise$BdlXl1gVJPVxA4MV1jHG_wEmmdc(r0, r4));
        Objects.requireNonNull(r0);
        exceptInner(new $$Lambda$EZnZNrcCA72vS8z3mA_yvnO1EPY(r0));
        return r0;
    }

    public <RT> Promise<RT> then(AsyncFunction<T, RT> r3) {
        final AsyncFunction r4 = (AsyncFunction) ZeusTransformUtils.wrapperContextForParams(r3, AsyncFunction.class, "com.obric.memorydata.plugin");
        checkThread();
        final Promise<RT> r0 = new Promise();
        thenInner(new $$Lambda$Promise$nfdCgZP_WT4HpOavcmXZLpvo3M(r4, r0));
        Objects.requireNonNull(r0);
        exceptInner(new $$Lambda$EZnZNrcCA72vS8z3mA_yvnO1EPY(r0));
        return r0;
    }

    public void then(Callback<T> r3) {
        Callback<T> r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        checkThread();
        if (this.mThrowingRejectionHandler == false) goto L6;
        thenInner(r4);
        return;
    L6:
        then(r4, $$Lambda$Promise$xPAeeNuwimVFIzNGIpt4RjZw4uc.INSTANCE);
        this.mThrowingRejectionHandler = true;
    }

    public void then(Callback<T> r3, Callback<Exception> r4) {
        Callback<T> r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        Callback<Exception> r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        checkThread();
        thenInner(r5);
        exceptInner(r6);
    }
}
