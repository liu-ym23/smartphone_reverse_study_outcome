package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkRequest {
    public static final Companion Companion = null;
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    private final UUID id;
    private final Set<String> tags;
    private final WorkSpec workSpec;

    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        private UUID id;
        private final Set<String> tags;
        private WorkSpec workSpec;
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(Class<? extends ListenableWorker> r10) {
            Intrinsics.checkNotNullParameter(r10, "workerClass");
            this.workerClass = r10;
            UUID r11 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(r11, "randomUUID()");
            this.id = r11;
            String r12 = this.id.toString();
            Intrinsics.checkNotNullExpressionValue(r12, "id.toString()");
            String r13 = r10.getName();
            Intrinsics.checkNotNullExpressionValue(r13, "workerClass.name");
            this.workSpec = new WorkSpec(r12, r13);
            String r14 = r10.getName();
            Intrinsics.checkNotNullExpressionValue(r14, "workerClass.name");
            this.tags = SetsKt.mutableSetOf(new String[]{r14});
        }

        public final B addTag(String r10) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            this.tags.add(r10);
            return (B) getThisObject$work_runtime_release();
        }

        public final W build() {
            W r10 = (W) buildInternal$work_runtime_release();
            Constraints r11 = this.workSpec.constraints;
            int r12 = Build.VERSION.SDK_INT;
            boolean r13 = false;
            if (r12 < 24) goto L7;
            if (r11.hasContentUriTriggers() == false) goto L7;
        L16:
            boolean r14 = true;
        L17:
            WorkSpec r15 = this.workSpec;
            if (r15.expedited == true) goto L20;
        L30:
            UUID r16 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(r16, "randomUUID()");
            setId(r16);
            return r10;
        L20:
            if ((!r14) == false) goto L29;
            if (r15.initialDelay > 0) goto L24;
            r13 = true;
        L24:
            if (r13 == true) goto L30;
            throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
        L29:
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
        L7:
            if (r11.requiresBatteryNotLow() == true) goto L16;
            if (r11.requiresCharging() == true) goto L16;
            if (r12 >= 23) goto L13;
        L15:
            r14 = false;
            goto L17
        L13:
            if (r11.requiresDeviceIdle() == false) goto L15;
            goto L15
        }

        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        public abstract B getThisObject$work_runtime_release();

        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        public final B keepResultsForAtLeast(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            WorkSpec r12 = this.workSpec;
            r12.minimumRetentionDuration = r11.toMillis(r10);
            return (B) getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public final B keepResultsForAtLeast(Duration r10) {
            Intrinsics.checkNotNullParameter(r10, "duration");
            WorkSpec r11 = this.workSpec;
            r11.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(r10);
            return (B) getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy r10, long r11, TimeUnit r12) {
            Intrinsics.checkNotNullParameter(r10, "backoffPolicy");
            Intrinsics.checkNotNullParameter(r12, "timeUnit");
            this.backoffCriteriaSet = true;
            WorkSpec r13 = this.workSpec;
            r13.backoffPolicy = r10;
            r13.setBackoffDelayDuration(r12.toMillis(r11));
            return (B) getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public final B setBackoffCriteria(BackoffPolicy r10, Duration r11) {
            Intrinsics.checkNotNullParameter(r10, "backoffPolicy");
            Intrinsics.checkNotNullParameter(r11, "duration");
            this.backoffCriteriaSet = true;
            WorkSpec r12 = this.workSpec;
            r12.backoffPolicy = r10;
            r12.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(r11));
            return (B) getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean r10) {
            this.backoffCriteriaSet = r10;
        }

        public final B setConstraints(Constraints r10) {
            Intrinsics.checkNotNullParameter(r10, "constraints");
            this.workSpec.constraints = r10;
            return (B) getThisObject$work_runtime_release();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public B setExpedited(OutOfQuotaPolicy r10) {
            Intrinsics.checkNotNullParameter(r10, "policy");
            WorkSpec r11 = this.workSpec;
            r11.expedited = true;
            r11.outOfQuotaPolicy = r10;
            return (B) getThisObject$work_runtime_release();
        }

        public final B setId(UUID r10) {
            Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
            this.id = r10;
            String r11 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r11, "id.toString()");
            this.workSpec = new WorkSpec(r11, this.workSpec);
            return (B) getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(UUID r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.id = r10;
        }

        public B setInitialDelay(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            WorkSpec r12 = this.workSpec;
            r12.initialDelay = r11.toMillis(r10);
            if ((Long.MAX_VALUE - System.currentTimeMillis()) <= this.workSpec.initialDelay) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L10;
            return (B) getThisObject$work_runtime_release();
        L10:
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        L5:
            r13 = false;
            goto L6
        }

        @RequiresApi(26)
        public B setInitialDelay(Duration r10) {
            Intrinsics.checkNotNullParameter(r10, "duration");
            WorkSpec r11 = this.workSpec;
            r11.initialDelay = DurationApi26Impl.toMillisCompat(r10);
            if ((Long.MAX_VALUE - System.currentTimeMillis()) <= this.workSpec.initialDelay) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L10;
            return (B) getThisObject$work_runtime_release();
        L10:
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        L5:
            r12 = false;
            goto L6
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialRunAttemptCount(int r10) {
            this.workSpec.runAttemptCount = r10;
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialState(WorkInfo.State r10) {
            Intrinsics.checkNotNullParameter(r10, "state");
            this.workSpec.state = r10;
            return (B) getThisObject$work_runtime_release();
        }

        public final B setInputData(Data r10) {
            Intrinsics.checkNotNullParameter(r10, "inputData");
            this.workSpec.input = r10;
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setLastEnqueueTime(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            WorkSpec r12 = this.workSpec;
            r12.lastEnqueueTime = r11.toMillis(r10);
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setScheduleRequestedAt(long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            WorkSpec r12 = this.workSpec;
            r12.scheduleRequestedAt = r11.toMillis(r10);
            return (B) getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(WorkSpec r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.workSpec = r10;
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

    public WorkRequest(UUID r10, WorkSpec r11, Set<String> r12) {
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r11, "workSpec");
        Intrinsics.checkNotNullParameter(r12, "tags");
        this.id = r10;
        this.workSpec = r11;
        this.tags = r12;
    }

    public UUID getId() {
        return this.id;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStringId() {
        String r10 = getId().toString();
        Intrinsics.checkNotNullExpressionValue(r10, "id.toString()");
        return r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> getTags() {
        return this.tags;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }
}
