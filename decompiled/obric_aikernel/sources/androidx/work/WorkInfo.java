package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class WorkInfo {
    private final int mGeneration;

    @NonNull
    private UUID mId;

    @NonNull
    private Data mOutputData;

    @NonNull
    private Data mProgress;
    private int mRunAttemptCount;

    @NonNull
    private State mState;

    @NonNull
    private Set<String> mTags;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BLOCKED = null;
        public static final State CANCELLED = null;
        public static final State ENQUEUED = null;
        public static final State FAILED = null;
        public static final State RUNNING = null;
        public static final State SUCCEEDED = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{ENQUEUED, RUNNING, SUCCEEDED, FAILED, BLOCKED, CANCELLED};
        }

        static {
            ENQUEUED = new State("ENQUEUED", 0);
            RUNNING = new State("RUNNING", 1);
            SUCCEEDED = new State("SUCCEEDED", 2);
            FAILED = new State("FAILED", 3);
            BLOCKED = new State("BLOCKED", 4);
            CANCELLED = new State("CANCELLED", 5);
            $VALUES = $values();
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public boolean isFinished() {
            if (this != SUCCEEDED) goto L5;
        L10:
            return true;
        L5:
            if (this == FAILED) goto L10;
            if (this == CANCELLED) goto L10;
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkInfo(@NonNull UUID r10, @NonNull State r11, @NonNull Data r12, @NonNull List<String> r13, @NonNull Data r14, int r15, int r16) {
        this.mId = r10;
        this.mState = r11;
        this.mOutputData = r12;
        this.mTags = new HashSet(r13);
        this.mProgress = r14;
        this.mRunAttemptCount = r15;
        this.mGeneration = r16;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L30:
        return false;
    L8:
        if (WorkInfo.class != r10.getClass()) goto L30;
        WorkInfo r11 = (WorkInfo) r10;
        if (this.mRunAttemptCount == r11.mRunAttemptCount) goto L14;
        return false;
    L14:
        if (this.mGeneration == r11.mGeneration) goto L17;
        return false;
    L17:
        if (this.mId.equals(r11.mId) == true) goto L20;
        return false;
    L20:
        if (this.mState == r11.mState) goto L23;
        return false;
    L23:
        if (this.mOutputData.equals(r11.mOutputData) == true) goto L26;
        return false;
    L26:
        if (this.mTags.equals(r11.mTags) == true) goto L29;
        return false;
    L29:
        return this.mProgress.equals(r11.mProgress);
    }

    public int getGeneration() {
        return this.mGeneration;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    public Data getOutputData() {
        return this.mOutputData;
    }

    @NonNull
    public Data getProgress() {
        return this.mProgress;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    @NonNull
    public State getState() {
        return this.mState;
    }

    @NonNull
    public Set<String> getTags() {
        return this.mTags;
    }

    public int hashCode() {
        return (((((((((((this.mId.hashCode() * 31) + this.mState.hashCode()) * 31) + this.mOutputData.hashCode()) * 31) + this.mTags.hashCode()) * 31) + this.mProgress.hashCode()) * 31) + this.mRunAttemptCount) * 31) + this.mGeneration;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.mId + "', mState=" + this.mState + ", mOutputData=" + this.mOutputData + ", mTags=" + this.mTags + ", mProgress=" + this.mProgress + '}';
    }
}
