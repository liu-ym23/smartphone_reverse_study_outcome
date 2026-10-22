package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class WorkQuery {
    private final List<UUID> mIds;
    private final List<WorkInfo.State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    public static final class Builder {
        List<UUID> mIds;
        List<WorkInfo.State> mStates;
        List<String> mTags;
        List<String> mUniqueWorkNames;

        private Builder() {
            this.mIds = new ArrayList();
            this.mUniqueWorkNames = new ArrayList();
            this.mTags = new ArrayList();
            this.mStates = new ArrayList();
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromIds(@NonNull List<UUID> r10) {
            Builder r11 = new Builder();
            r11.addIds(r10);
            return r11;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromStates(@NonNull List<WorkInfo.State> r10) {
            Builder r11 = new Builder();
            r11.addStates(r10);
            return r11;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromTags(@NonNull List<String> r10) {
            Builder r11 = new Builder();
            r11.addTags(r10);
            return r11;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public static Builder fromUniqueWorkNames(@NonNull List<String> r10) {
            Builder r11 = new Builder();
            r11.addUniqueWorkNames(r10);
            return r11;
        }

        @NonNull
        public Builder addIds(@NonNull List<UUID> r10) {
            this.mIds.addAll(r10);
            return this;
        }

        @NonNull
        public Builder addStates(@NonNull List<WorkInfo.State> r10) {
            this.mStates.addAll(r10);
            return this;
        }

        @NonNull
        public Builder addTags(@NonNull List<String> r10) {
            this.mTags.addAll(r10);
            return this;
        }

        @NonNull
        public Builder addUniqueWorkNames(@NonNull List<String> r10) {
            this.mUniqueWorkNames.addAll(r10);
            return this;
        }

        @NonNull
        public WorkQuery build() {
            if (this.mIds.isEmpty() == false) goto L14;
            if (this.mUniqueWorkNames.isEmpty() == false) goto L14;
            if (this.mTags.isEmpty() == false) goto L14;
            if (this.mStates.isEmpty() == false) goto L14;
            throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
        L14:
            return new WorkQuery(this);
        }
    }

    WorkQuery(@NonNull Builder r10) {
        this.mIds = r10.mIds;
        this.mUniqueWorkNames = r10.mUniqueWorkNames;
        this.mTags = r10.mTags;
        this.mStates = r10.mStates;
    }

    @NonNull
    public static WorkQuery fromIds(@NonNull List<UUID> r10) {
        return Builder.fromIds(r10).build();
    }

    @NonNull
    public static WorkQuery fromIds(@NonNull UUID... r10) {
        return fromIds(Arrays.asList(r10));
    }

    @NonNull
    public static WorkQuery fromStates(@NonNull List<WorkInfo.State> r10) {
        return Builder.fromStates(r10).build();
    }

    @NonNull
    public static WorkQuery fromStates(@NonNull WorkInfo.State... r10) {
        return Builder.fromStates(Arrays.asList(r10)).build();
    }

    @NonNull
    public static WorkQuery fromTags(@NonNull List<String> r10) {
        return Builder.fromTags(r10).build();
    }

    @NonNull
    public static WorkQuery fromTags(@NonNull String... r10) {
        return fromTags(Arrays.asList(r10));
    }

    @NonNull
    public static WorkQuery fromUniqueWorkNames(@NonNull List<String> r10) {
        return Builder.fromUniqueWorkNames(r10).build();
    }

    @NonNull
    public static WorkQuery fromUniqueWorkNames(@NonNull String... r10) {
        return Builder.fromUniqueWorkNames(Arrays.asList(r10)).build();
    }

    @NonNull
    public List<UUID> getIds() {
        return this.mIds;
    }

    @NonNull
    public List<WorkInfo.State> getStates() {
        return this.mStates;
    }

    @NonNull
    public List<String> getTags() {
        return this.mTags;
    }

    @NonNull
    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }
}
