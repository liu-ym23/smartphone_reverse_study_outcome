package com.larus.bmhome.clarification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/clarification/ClarificationAttachmentReleasePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "DETACH_ONLY", "DETACH_AND_KEEP_FOR_RESULT", "DISMISS_AND_DELETE_TEMP_RESOURCES", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ClarificationAttachmentReleasePolicy extends Enum<ClarificationAttachmentReleasePolicy> {
    public static final ClarificationAttachmentReleasePolicy DETACH_AND_KEEP_FOR_RESULT = null;
    public static final ClarificationAttachmentReleasePolicy DETACH_ONLY = null;
    public static final ClarificationAttachmentReleasePolicy DISMISS_AND_DELETE_TEMP_RESOURCES = null;
    public static final /* synthetic */ ClarificationAttachmentReleasePolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ClarificationAttachmentReleasePolicy> getEntries() {
        return b;
    }

    static {
        ClarificationAttachmentReleasePolicy r0 = new ClarificationAttachmentReleasePolicy("DETACH_ONLY", 0);
        DETACH_ONLY = r0;
        ClarificationAttachmentReleasePolicy r1 = new ClarificationAttachmentReleasePolicy("DETACH_AND_KEEP_FOR_RESULT", 1);
        DETACH_AND_KEEP_FOR_RESULT = r1;
        ClarificationAttachmentReleasePolicy r3 = new ClarificationAttachmentReleasePolicy("DISMISS_AND_DELETE_TEMP_RESOURCES", 2);
        DISMISS_AND_DELETE_TEMP_RESOURCES = r3;
        ClarificationAttachmentReleasePolicy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ClarificationAttachmentReleasePolicy[] values() {
        return (ClarificationAttachmentReleasePolicy[]) a.clone();
    }

    public static ClarificationAttachmentReleasePolicy valueOf(String r1) {
        return (ClarificationAttachmentReleasePolicy) r27.a.a(ClarificationAttachmentReleasePolicy.class, r1);
    }

    public ClarificationAttachmentReleasePolicy(String r1, int r2) {
        super(r1, r2);
    }
}
