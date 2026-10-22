package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {
    public static final Companion Companion = null;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(Class<? extends ListenableWorker> r10, long r11, TimeUnit r12) {
            Intrinsics.checkNotNullParameter(r10, "workerClass");
            Intrinsics.checkNotNullParameter(r12, "repeatIntervalTimeUnit");
            super(r10);
            getWorkSpec$work_runtime_release().setPeriodic(r12.toMillis(r11));
        }

        public Builder(Class<? extends ListenableWorker> r10, long r11, TimeUnit r12, long r13, TimeUnit r14) {
            Intrinsics.checkNotNullParameter(r10, "workerClass");
            Intrinsics.checkNotNullParameter(r12, "repeatIntervalTimeUnit");
            Intrinsics.checkNotNullParameter(r14, "flexIntervalTimeUnit");
            super(r10);
            getWorkSpec$work_runtime_release().setPeriodic(r12.toMillis(r11), r14.toMillis(r13));
        }

        @RequiresApi(26)
        public Builder(Class<? extends ListenableWorker> r10, Duration r11) {
            Intrinsics.checkNotNullParameter(r10, "workerClass");
            Intrinsics.checkNotNullParameter(r11, "repeatInterval");
            super(r10);
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(r11));
        }

        @RequiresApi(26)
        public Builder(Class<? extends ListenableWorker> r10, Duration r11, Duration r12) {
            Intrinsics.checkNotNullParameter(r10, "workerClass");
            Intrinsics.checkNotNullParameter(r11, "repeatInterval");
            Intrinsics.checkNotNullParameter(r12, "flexInterval");
            super(r10);
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(r11), DurationApi26Impl.toMillisCompat(r12));
        }

        @Override // androidx.work.WorkRequest.Builder
        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            if (getBackoffCriteriaSet$work_runtime_release() == true) goto L5;
        L10:
            boolean r10 = true;
        L11:
            if (r10 == false) goto L19;
            if ((!getWorkSpec$work_runtime_release().expedited) == false) goto L17;
            return new PeriodicWorkRequest(this);
        L17:
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
        L19:
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        L5:
            if (Build.VERSION.SDK_INT < 23) goto L10;
            if (getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle() == false) goto L10;
            r10 = false;
            goto L11
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest buildInternal$work_runtime_release() {
            return buildInternal$work_runtime_release();
        }

        @Override // androidx.work.WorkRequest.Builder
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest.Builder getThisObject$work_runtime_release() {
            return getThisObject$work_runtime_release();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PeriodicWorkRequest(Builder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10.getId$work_runtime_release(), r10.getWorkSpec$work_runtime_release(), r10.getTags$work_runtime_release());
    }
}
