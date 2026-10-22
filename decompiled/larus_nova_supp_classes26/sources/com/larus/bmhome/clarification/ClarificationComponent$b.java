package com.larus.bmhome.clarification;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public /* synthetic */ class ClarificationComponent$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ClarificationAttachmentReleasePolicy.values().length];
        r0[ClarificationAttachmentReleasePolicy.DETACH_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[ClarificationAttachmentReleasePolicy.DETACH_AND_KEEP_FOR_RESULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[ClarificationAttachmentReleasePolicy.DISMISS_AND_DELETE_TEMP_RESOURCES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
