package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[FileAuthResultFrom.values().length];
        r0[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L19:
        r0[FileAuthResultFrom.COME_FROM_DLP_CONTENT_DETECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L27:
        r0[FileAuthResultFrom.COME_FROM_DLP_CONTENT_SENSITIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L21:
        r0[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[FileAuthResultFrom.COME_FROM_TT_BLOCK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L17:
        r0[FileAuthResultFrom.COME_FROM_UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L9:
        a = r0;
    }
}
