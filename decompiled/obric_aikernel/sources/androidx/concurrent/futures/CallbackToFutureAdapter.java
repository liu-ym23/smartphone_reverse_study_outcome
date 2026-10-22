package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c6.a;
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

        public void addCancellationListener(@NonNull Runnable r10, @NonNull Executor r11) {
            ResolvableFuture<Void> r12 = this.cancellationFuture;
            if (r12 == null) goto L6;
            r12.addListener(r10, r11);
            return;
        }

        protected void finalize() {
            SafeFuture<T> r10 = this.future;
            if (r10 == null) goto L8;
            if (r10.isDone() == true) goto L8;
            r10.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
        L8:
            if (this.attemptedSetting == true) goto L13;
            ResolvableFuture<Void> r11 = this.cancellationFuture;
            if (r11 == null) goto L14;
            r11.set(null);
            return;
        L14:
            return;
        }

        void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T r10) {
            boolean r11 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r12 = this.future;
            if (r12 != null) goto L5;
        L7:
            r11 = false;
        L8:
            if (r11 == false) goto L10;
            setCompletedNormally();
        L10:
            return r11;
        L5:
            if (r12.set(r10) == false) goto L7;
            goto L7
        }

        public boolean setCancelled() {
            boolean r10 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r11 = this.future;
            if (r11 != null) goto L5;
        L7:
            r10 = false;
        L8:
            if (r10 == false) goto L10;
            setCompletedNormally();
        L10:
            return r10;
        L5:
            if (r11.cancelWithoutNotifyingCompleter(true) == false) goto L7;
            goto L7
        }

        public boolean setException(@NonNull Throwable r10) {
            boolean r11 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r12 = this.future;
            if (r12 != null) goto L5;
        L7:
            r11 = false;
        L8:
            if (r11 == false) goto L10;
            setCompletedNormally();
        L10:
            return r11;
        L5:
            if (r12.setException(r10) == false) goto L7;
            goto L7
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String r10) {
            super(r10);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }
    }

    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> r10);
    }

    private static final class SafeFuture<T> implements a<T> {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate;

        SafeFuture(Completer<T> r10) {
            this.delegate = (AbstractResolvableFuture<T>) new AnonymousClass1(this);
            this.completerWeakReference = new WeakReference(r10);
        }

        @Override // c6.a
        public void addListener(@NonNull Runnable r10, @NonNull Executor r11) {
            this.delegate.addListener(r10, r11);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean r10) {
            Completer<T> r11 = this.completerWeakReference.get();
            boolean r12 = this.delegate.cancel(r10);
            if (r12 == false) goto L6;
            if (r11 == null) goto L6;
            r11.fireCancellationListeners();
        L6:
            return r12;
        }

        boolean cancelWithoutNotifyingCompleter(boolean r10) {
            return this.delegate.cancel(r10);
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.delegate.get();
        }

        @Override // java.util.concurrent.Future
        public T get(long r10, @NonNull TimeUnit r11) {
            return this.delegate.get(r10, r11);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegate.isDone();
        }

        boolean set(T r10) {
            return this.delegate.set(r10);
        }

        boolean setException(Throwable r10) {
            return this.delegate.setException(r10);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> a<T> getFuture(@NonNull Resolver<T> r10) {
        Completer<T> r11 = new Completer();
        SafeFuture<T> r12 = new SafeFuture(r11);
        r11.future = r12;
        r11.tag = r10.getClass();
        Object r13 = r10.attachCompleter(r11);     // Catch: Exception -> L7
        if (r13 == null) goto L9;
        r11.tag = r13;     // Catch: Exception -> L7
    L9:
        return r12;
    L7:
        e = move-exception;
        r12.setException(e);
        goto L9
    }
}
