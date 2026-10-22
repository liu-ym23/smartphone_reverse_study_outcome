package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.w0;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture;
        SafeFuture<T> future;
        Object tag;

        public Completer() {
            this.cancellationFuture = ResolvableFuture.create();
        }

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public void addCancellationListener(@NonNull Runnable r5, @NonNull Executor r10) {
            ResolvableFuture<Void> r11 = this.cancellationFuture;
            if (r11 == null) goto L6;
            r11.addListener(r5, r10);
            return;
        }

        public void finalize() {
            SafeFuture<T> r5 = this.future;
            if (r5 == null) goto L8;
            if (r5.isDone() == true) goto L8;
            r5.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
        L8:
            if (this.attemptedSetting == true) goto L13;
            ResolvableFuture<Void> r10 = this.cancellationFuture;
            if (r10 == null) goto L14;
            r10.set(null);
            return;
        L14:
            return;
        }

        public void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(T r5) {
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
            if (r11.set(r5) == false) goto L7;
            goto L7
        }

        public boolean setCancelled() {
            boolean r5 = true;
            this.attemptedSetting = true;
            SafeFuture<T> r10 = this.future;
            if (r10 != null) goto L5;
        L7:
            r5 = false;
        L8:
            if (r5 == false) goto L10;
            setCompletedNormally();
        L10:
            return r5;
        L5:
            if (r10.cancelWithoutNotifyingCompleter(true) == false) goto L7;
            goto L7
        }

        public boolean setException(@NonNull Throwable r5) {
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
            if (r11.setException(r5) == false) goto L7;
            goto L7
        }
    }

    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String r5) {
            super(r5);
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
        Object attachCompleter(@NonNull Completer<T> r5) throws Exception;
    }

    public static final class SafeFuture<T> implements w0 {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate;

        public SafeFuture(Completer<T> r5) {
            this.delegate = new AnonymousClass1(this);
            this.completerWeakReference = new WeakReference(r5);
        }

        @Override // com.google.common.util.concurrent.w0
        public void addListener(@NonNull Runnable r5, @NonNull Executor r10) {
            this.delegate.addListener(r5, r10);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean r5) {
            Completer<T> r10 = this.completerWeakReference.get();
            boolean r11 = this.delegate.cancel(r5);
            if (r11 == false) goto L6;
            if (r10 == null) goto L6;
            r10.fireCancellationListeners();
        L6:
            return r11;
        }

        public boolean cancelWithoutNotifyingCompleter(boolean r5) {
            return this.delegate.cancel(r5);
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegate.isDone();
        }

        public boolean set(T r5) {
            return this.delegate.set(r5);
        }

        public boolean setException(Throwable r5) {
            return this.delegate.setException(r5);
        }

        public String toString() {
            return this.delegate.toString();
        }

        @Override // java.util.concurrent.Future
        public T get(long r5, @NonNull TimeUnit r10) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(r5, r10);
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> w0 getFuture(@NonNull Resolver<T> r5) {
        Completer<T> r10 = new Completer();
        SafeFuture<T> r11 = new SafeFuture(r10);
        r10.future = r11;
        r10.tag = r5.getClass();
        Object r12 = r5.attachCompleter(r10);     // Catch: Exception -> L7
        if (r12 == null) goto L9;
        r10.tag = r12;     // Catch: Exception -> L7
    L9:
        return r11;
    L7:
        e = move-exception;
        r11.setException(e);
        goto L9
    }
}
