package com.obric.aiagent.assistant.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public /* synthetic */ class a$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PrivacyApprovalStatus.values().length];
        r0[PrivacyApprovalStatus.NotApproved.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[PrivacyApprovalStatus.CannotObtain.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[PrivacyApprovalStatus.Timeout.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[PrivacyApprovalStatus.Approved.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
