package com.larus.common.account.platform.larkauth;

import com.larus.common.account.platform.larkauth.model.LarkAuthAccountKind;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class LarkAuthTokenFetcher$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LarkAuthAccountKind.values().length];
        r0[LarkAuthAccountKind.LOGIN_B.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[LarkAuthAccountKind.LOGIN_C.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[LarkAuthAccountKind.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
