package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncDifferConfig<T> {

    @NonNull
    private final Executor mBackgroundThreadExecutor;

    @NonNull
    private final DiffUtil.ItemCallback<T> mDiffCallback;

    @Nullable
    private final Executor mMainThreadExecutor;

    public static final class Builder<T> {
        private static Executor sDiffExecutor;
        private static final Object sExecutorLock = null;
        private Executor mBackgroundThreadExecutor;
        private final DiffUtil.ItemCallback<T> mDiffCallback;

        @Nullable
        private Executor mMainThreadExecutor;

        static {
            sExecutorLock = new Object();
        }

        public Builder(@NonNull DiffUtil.ItemCallback<T> r5) {
            this.mDiffCallback = r5;
        }

        @NonNull
        public AsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor != null) goto L16;
            Object r5 = sExecutorLock;
            monitor-enter(r5);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (sDiffExecutor != null) goto L11;
            sDiffExecutor = Executors.newFixedThreadPool(2);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L9
            this.mBackgroundThreadExecutor = sDiffExecutor;
        L16:
            return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
        }

        @NonNull
        public Builder<T> setBackgroundThreadExecutor(@Nullable Executor r5) {
            this.mBackgroundThreadExecutor = r5;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder<T> setMainThreadExecutor(@Nullable Executor r5) {
            this.mMainThreadExecutor = r5;
            return this;
        }
    }

    public AsyncDifferConfig(@Nullable Executor r5, @NonNull Executor r10, @NonNull DiffUtil.ItemCallback<T> r11) {
        this.mMainThreadExecutor = r5;
        this.mBackgroundThreadExecutor = r10;
        this.mDiffCallback = r11;
    }

    @NonNull
    public Executor getBackgroundThreadExecutor() {
        return this.mBackgroundThreadExecutor;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.mDiffCallback;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }
}
