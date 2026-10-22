package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/clarification/ClarificationSubmissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "FINISH", "CANCEL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ClarificationSubmissionStatus extends Enum<ClarificationSubmissionStatus> {
    public static final ClarificationSubmissionStatus CANCEL = null;
    public static final ClarificationSubmissionStatus FINISH = null;
    public static final /* synthetic */ ClarificationSubmissionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ClarificationSubmissionStatus> getEntries() {
        return b;
    }

    static {
        ClarificationSubmissionStatus r0 = new ClarificationSubmissionStatus("FINISH", 0);
        FINISH = r0;
        ClarificationSubmissionStatus r1 = new ClarificationSubmissionStatus("CANCEL", 1);
        CANCEL = r1;
        ClarificationSubmissionStatus[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ClarificationSubmissionStatus[] values() {
        return (ClarificationSubmissionStatus[]) a.clone();
    }

    public static ClarificationSubmissionStatus valueOf(String r1) {
        return (ClarificationSubmissionStatus) r27.a.a(ClarificationSubmissionStatus.class, r1);
    }

    public ClarificationSubmissionStatus(String r1, int r2) {
        super(r1, r2);
    }
}
