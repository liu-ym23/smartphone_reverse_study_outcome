package com.obric.memorydata.memory.review.model;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "PENDING", "SUBMITTED", "SUBMITTING", RawObservationEntity.STATE_FAILED, "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryReviewFeedbackState extends Enum<MemoryReviewFeedbackState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryReviewFeedbackState[] $VALUES = null;
    public static final a Companion = null;
    public static final MemoryReviewFeedbackState FAILED = null;
    public static final MemoryReviewFeedbackState PENDING = null;
    public static final MemoryReviewFeedbackState SUBMITTED = null;
    public static final MemoryReviewFeedbackState SUBMITTING = null;
    private final String key;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState$Companion;", "", "<init>", "()V", "fromKey", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MemoryReviewFeedbackState a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "key");
            MemoryReviewFeedbackState[] r4 = MemoryReviewFeedbackState.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            MemoryReviewFeedbackState r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getKey(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ MemoryReviewFeedbackState[] $values() {
        return new MemoryReviewFeedbackState[]{PENDING, SUBMITTED, SUBMITTING, FAILED};
    }

    static {
        PENDING = new MemoryReviewFeedbackState("PENDING", 0, "pending");
        SUBMITTED = new MemoryReviewFeedbackState("SUBMITTED", 1, "submitted");
        SUBMITTING = new MemoryReviewFeedbackState("SUBMITTING", 2, "submitting");
        FAILED = new MemoryReviewFeedbackState(RawObservationEntity.STATE_FAILED, 3, "failed");
        MemoryReviewFeedbackState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemoryReviewFeedbackState(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }

    public static EnumEntries<MemoryReviewFeedbackState> getEntries() {
        return $ENTRIES;
    }

    public static MemoryReviewFeedbackState valueOf(String r2) {
        return (MemoryReviewFeedbackState) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryReviewFeedbackState.class, r2), MemoryReviewFeedbackState.class, "com.obric.memorydata.plugin");
    }

    public static MemoryReviewFeedbackState[] values() {
        return (MemoryReviewFeedbackState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryReviewFeedbackState[].class, "com.obric.memorydata.plugin");
    }

    public final String getKey() {
        return this.key;
    }
}
