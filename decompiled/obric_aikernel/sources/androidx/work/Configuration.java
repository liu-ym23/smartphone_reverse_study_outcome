package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class Configuration {

    @SuppressLint({"MinMaxConstant"})
    public static final int MIN_SCHEDULER_LIMIT = 20;

    @Nullable
    final String mDefaultProcessName;

    @Nullable
    final Consumer<Throwable> mExceptionHandler;

    @NonNull
    final Executor mExecutor;

    @NonNull
    final InputMergerFactory mInputMergerFactory;
    private final boolean mIsUsingDefaultTaskExecutor;
    final int mLoggingLevel;
    final int mMaxJobSchedulerId;
    final int mMaxSchedulerLimit;
    final int mMinJobSchedulerId;

    @NonNull
    final RunnableScheduler mRunnableScheduler;

    @Nullable
    final Consumer<Throwable> mSchedulingExceptionHandler;

    @NonNull
    final Executor mTaskExecutor;

    @NonNull
    final WorkerFactory mWorkerFactory;

    public static final class Builder {

        @Nullable
        String mDefaultProcessName;

        @Nullable
        Consumer<Throwable> mExceptionHandler;
        Executor mExecutor;
        InputMergerFactory mInputMergerFactory;
        int mLoggingLevel;
        int mMaxJobSchedulerId;
        int mMaxSchedulerLimit;
        int mMinJobSchedulerId;
        RunnableScheduler mRunnableScheduler;

        @Nullable
        Consumer<Throwable> mSchedulingExceptionHandler;
        Executor mTaskExecutor;
        WorkerFactory mWorkerFactory;

        public Builder() {
            this.mLoggingLevel = 4;
            this.mMinJobSchedulerId = 0;
            this.mMaxJobSchedulerId = Integer.MAX_VALUE;
            this.mMaxSchedulerLimit = 20;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull Configuration r10) {
            this.mExecutor = r10.mExecutor;
            this.mWorkerFactory = r10.mWorkerFactory;
            this.mInputMergerFactory = r10.mInputMergerFactory;
            this.mTaskExecutor = r10.mTaskExecutor;
            this.mLoggingLevel = r10.mLoggingLevel;
            this.mMinJobSchedulerId = r10.mMinJobSchedulerId;
            this.mMaxJobSchedulerId = r10.mMaxJobSchedulerId;
            this.mMaxSchedulerLimit = r10.mMaxSchedulerLimit;
            this.mRunnableScheduler = r10.mRunnableScheduler;
            this.mExceptionHandler = r10.mExceptionHandler;
            this.mSchedulingExceptionHandler = r10.mSchedulingExceptionHandler;
            this.mDefaultProcessName = r10.mDefaultProcessName;
        }

        @NonNull
        public Configuration build() {
            return new Configuration(this);
        }

        @NonNull
        public Builder setDefaultProcessName(@NonNull String r10) {
            this.mDefaultProcessName = r10;
            return this;
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor r10) {
            this.mExecutor = r10;
            return this;
        }

        @NonNull
        public Builder setInitializationExceptionHandler(@NonNull Consumer<Throwable> r10) {
            this.mExceptionHandler = r10;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setInitializationExceptionHandler(@NonNull final InitializationExceptionHandler r10) {
            Objects.requireNonNull(r10);
            this.mExceptionHandler = new a(r10);
            return this;
        }

        @NonNull
        public Builder setInputMergerFactory(@NonNull InputMergerFactory r10) {
            this.mInputMergerFactory = r10;
            return this;
        }

        @NonNull
        public Builder setJobSchedulerJobIdRange(int r10, int r11) {
            if ((r11 - r10) < 1000) goto L7;
            this.mMinJobSchedulerId = r10;
            this.mMaxJobSchedulerId = r11;
            return this;
        L7:
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        @NonNull
        public Builder setMaxSchedulerLimit(int r10) {
            if (r10 < 20) goto L7;
            this.mMaxSchedulerLimit = Math.min(r10, 50);
            return this;
        L7:
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        @NonNull
        public Builder setMinimumLoggingLevel(int r10) {
            this.mLoggingLevel = r10;
            return this;
        }

        @NonNull
        public Builder setRunnableScheduler(@NonNull RunnableScheduler r10) {
            this.mRunnableScheduler = r10;
            return this;
        }

        @NonNull
        public Builder setSchedulingExceptionHandler(@NonNull Consumer<Throwable> r10) {
            this.mSchedulingExceptionHandler = r10;
            return this;
        }

        @NonNull
        public Builder setTaskExecutor(@NonNull Executor r10) {
            this.mTaskExecutor = r10;
            return this;
        }

        @NonNull
        public Builder setWorkerFactory(@NonNull WorkerFactory r10) {
            this.mWorkerFactory = r10;
            return this;
        }
    }

    public interface Provider {
        @NonNull
        Configuration getWorkManagerConfiguration();
    }

    Configuration(@NonNull Builder r10) {
        Executor r11 = r10.mExecutor;
        if (r11 != null) goto L5;
        r11 = createDefaultExecutor(false);
    L5:
        this.mExecutor = r11;
        Executor r12 = r10.mTaskExecutor;
        if (r12 != null) goto L8;
        this.mIsUsingDefaultTaskExecutor = true;
        r12 = createDefaultExecutor(true);
    L9:
        this.mTaskExecutor = r12;
        WorkerFactory r13 = r10.mWorkerFactory;
        if (r13 != null) goto L12;
        r13 = WorkerFactory.getDefaultWorkerFactory();
    L12:
        this.mWorkerFactory = r13;
        InputMergerFactory r14 = r10.mInputMergerFactory;
        if (r14 != null) goto L15;
        r14 = InputMergerFactory.getDefaultInputMergerFactory();
    L15:
        this.mInputMergerFactory = r14;
        RunnableScheduler r15 = r10.mRunnableScheduler;
        if (r15 != null) goto L18;
        r15 = new DefaultRunnableScheduler();
    L18:
        this.mRunnableScheduler = r15;
        this.mLoggingLevel = r10.mLoggingLevel;
        this.mMinJobSchedulerId = r10.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = r10.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = r10.mMaxSchedulerLimit;
        this.mExceptionHandler = r10.mExceptionHandler;
        this.mSchedulingExceptionHandler = r10.mSchedulingExceptionHandler;
        this.mDefaultProcessName = r10.mDefaultProcessName;
        return;
    L8:
        this.mIsUsingDefaultTaskExecutor = false;
        goto L9
    }

    @NonNull
    private Executor createDefaultExecutor(boolean r10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), createDefaultThreadFactory(r10));
    }

    @NonNull
    private ThreadFactory createDefaultThreadFactory(final boolean r10) {
        return new AnonymousClass1(this, r10);
    }

    @Nullable
    public String getDefaultProcessName() {
        return this.mDefaultProcessName;
    }

    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @Nullable
    public Consumer<Throwable> getInitializationExceptionHandler() {
        return this.mExceptionHandler;
    }

    @NonNull
    public InputMergerFactory getInputMergerFactory() {
        return this.mInputMergerFactory;
    }

    public int getMaxJobSchedulerId() {
        return this.mMaxJobSchedulerId;
    }

    @IntRange(from = 20, to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxSchedulerLimit() {
        int r10 = Build.VERSION.SDK_INT;
        int r11 = this.mMaxSchedulerLimit;
        if (r10 == 23) goto L5;
        return r11;
    L5:
        return r11 / 2;
    }

    public int getMinJobSchedulerId() {
        return this.mMinJobSchedulerId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMinimumLoggingLevel() {
        return this.mLoggingLevel;
    }

    @NonNull
    public RunnableScheduler getRunnableScheduler() {
        return this.mRunnableScheduler;
    }

    @Nullable
    public Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.mSchedulingExceptionHandler;
    }

    @NonNull
    public Executor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    @NonNull
    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isUsingDefaultTaskExecutor() {
        return this.mIsUsingDefaultTaskExecutor;
    }
}
