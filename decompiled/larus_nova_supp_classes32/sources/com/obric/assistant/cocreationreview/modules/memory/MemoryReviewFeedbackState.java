package com.obric.assistant.cocreationreview.modules.memory;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewFeedbackState;", NameKeys.UnloadStrategy_No_Strategy, "raw", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "PENDING", "SUBMITTED", "SUBMITTING", "FAILED", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryReviewFeedbackState extends Enum<MemoryReviewFeedbackState> {
    public static final a Companion = null;
    public static final MemoryReviewFeedbackState FAILED = null;
    public static final MemoryReviewFeedbackState PENDING = null;
    public static final MemoryReviewFeedbackState SUBMITTED = null;
    public static final MemoryReviewFeedbackState SUBMITTING = null;
    public static final /* synthetic */ MemoryReviewFeedbackState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String raw;

    public static final class a {
        public a() {
        }

        public static MemoryReviewFeedbackState a(String r5) {
            MemoryReviewFeedbackState[] r0 = MemoryReviewFeedbackState.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            MemoryReviewFeedbackState r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getRaw(), r5) == true) goto L9;
            r2 = r2 + 1;
        L9:
            if (r3 == null) goto L11;
            return r3;
        L11:
            return MemoryReviewFeedbackState.PENDING;
        L8:
            r3 = null;
            goto L9
        }
    }

    public static EnumEntries<MemoryReviewFeedbackState> getEntries() {
        return b;
    }

    static {
        MemoryReviewFeedbackState r0 = new MemoryReviewFeedbackState("PENDING", 0, "pending");
        PENDING = r0;
        MemoryReviewFeedbackState r1 = new MemoryReviewFeedbackState("SUBMITTED", 1, "submitted");
        SUBMITTED = r1;
        MemoryReviewFeedbackState r3 = new MemoryReviewFeedbackState("SUBMITTING", 2, "submitting");
        SUBMITTING = r3;
        MemoryReviewFeedbackState r5 = new MemoryReviewFeedbackState("FAILED", 3, "failed");
        FAILED = r5;
        MemoryReviewFeedbackState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static MemoryReviewFeedbackState[] values() {
        return (MemoryReviewFeedbackState[]) a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static MemoryReviewFeedbackState valueOf(String r1) {
        return (MemoryReviewFeedbackState) r27.a.a(MemoryReviewFeedbackState.class, r1);
    }

    public MemoryReviewFeedbackState(String r1, int r2, String r3) {
        super(r1, r2);
        this.raw = r3;
    }
}
