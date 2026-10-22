package androidx.concurrent.futures;

import com.google.common.util.concurrent.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture;
        SafeFuture<T> future;
        Object tag;

        Completer() {
            this.cancellationFuture = ResolvableFuture.create();
        }

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public void addCancellationListener(Runnable r3, Executor r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            ResolvableFuture<Void> r2 = this.cancellationFuture;
            if (r2 == null) goto L6;
            r2.addListener(r5, r6);
            return;
        }

        public void finalize() {
            SafeFuture<T> r0 = this.future;
            if (r0 == null) goto L8;
            if (r0.isDone() == true) goto L8;
            r0.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
        L8:
            if (this.attemptedSetting == true) goto L13;
            ResolvableFuture<Void> r4 = this.cancellationFuture;
            if (r4 == null) goto L14;
            r4.set(null);
            return;
        L14:
            return;
        }

        void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T r3) {
            boolean r0 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r1 = this.future;
            if (r1 != null) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L10;
            setCompletedNormally();
        L10:
            return r0;
        L5:
            if (r1.set(r3) == false) goto L7;
            goto L7
        }

        public boolean setCancelled() {
            boolean r0 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r1 = this.future;
            if (r1 != null) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L10;
            setCompletedNormally();
        L10:
            return r0;
        L5:
            if (r1.cancelWithoutNotifyingCompleter(true) == false) goto L7;
            goto L7
        }

        public boolean setException(Throwable r3) {
            boolean r0 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r1 = this.future;
            if (r1 != null) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L10;
            setCompletedNormally();
        L10:
            return r0;
        L5:
            if (r1.setException(r3) == false) goto L7;
            goto L7
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String r1) {
            super(r1);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }
    }

    public interface Resolver<T> {
        Object attachCompleter(Completer<T> r1);
    }

    private static final class SafeFuture<T> implements l<T> {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate;

        SafeFuture(Completer<T> r2) {
            this.delegate = new AnonymousClass1(this);
            this.completerWeakReference = new WeakReference(r2);
        }

        @Override // com.google.common.util.concurrent.l
        public void addListener(Runnable r3, Executor r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.delegate.addListener(r5, r6);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean r4) {
            Completer r0 = (Completer) ZeusTransformUtils.preCheckCast(this.completerWeakReference.get(), Completer.class, "com.obric.memorydata.plugin");
            boolean r3 = this.delegate.cancel(r4);
            if (r3 == false) goto L6;
            if (r0 == null) goto L6;
            r0.fireCancellationListeners();
        L6:
            return r3;
        }

        boolean cancelWithoutNotifyingCompleter(boolean r1) {
            return this.delegate.cancel(r1);
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.delegate.get();
        }

        @Override // java.util.concurrent.Future
        public T get(long r1, TimeUnit r3) {
            return this.delegate.get(r1, r3);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegate.isDone();
        }

        boolean set(T r1) {
            return this.delegate.set(r1);
        }

        boolean setException(Throwable r1) {
            return this.delegate.setException(r1);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private CallbackToFutureAdapter() {
    }

    public static <T> l<T> getFuture(Resolver<T> r3) {
        Resolver r4 = (Resolver) ZeusTransformUtils.wrapperContextForParams(r3, Resolver.class, "com.obric.memorydata.plugin");
        Completer<T> r0 = new Completer();
        SafeFuture<T> r1 = new SafeFuture(r0);
        r0.future = r1;
        r0.tag = r4.getClass();
        Object r5 = r4.attachCompleter(r0);     // Catch: Exception -> L7
        if (r5 == null) goto L9;
        r0.tag = r5;     // Catch: Exception -> L7
    L9:
        return r1;
    L7:
        e = move-exception;
        r1.setException(e);
        goto L9
    }
}
