package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/cocreationreview/FeedbackMediaSubmissionDecision;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "UPLOAD", "WAIT", "SUBMIT_FEEDBACK", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackMediaSubmissionDecision extends Enum<FeedbackMediaSubmissionDecision> {
    public static final FeedbackMediaSubmissionDecision SUBMIT_FEEDBACK = null;
    public static final FeedbackMediaSubmissionDecision UPLOAD = null;
    public static final FeedbackMediaSubmissionDecision WAIT = null;
    public static final /* synthetic */ FeedbackMediaSubmissionDecision[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedbackMediaSubmissionDecision> getEntries() {
        return b;
    }

    static {
        FeedbackMediaSubmissionDecision r0 = new FeedbackMediaSubmissionDecision("UPLOAD", 0);
        UPLOAD = r0;
        FeedbackMediaSubmissionDecision r1 = new FeedbackMediaSubmissionDecision("WAIT", 1);
        WAIT = r1;
        FeedbackMediaSubmissionDecision r3 = new FeedbackMediaSubmissionDecision("SUBMIT_FEEDBACK", 2);
        SUBMIT_FEEDBACK = r3;
        FeedbackMediaSubmissionDecision[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FeedbackMediaSubmissionDecision[] values() {
        return (FeedbackMediaSubmissionDecision[]) a.clone();
    }

    public static FeedbackMediaSubmissionDecision valueOf(String r1) {
        return (FeedbackMediaSubmissionDecision) r27.a.a(FeedbackMediaSubmissionDecision.class, r1);
    }

    public FeedbackMediaSubmissionDecision(String r1, int r2) {
        super(r1, r2);
    }
}
