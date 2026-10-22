package com.obric.assistant.login;

import com.larus.account.base.model.AccountStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class LoginStateImpl$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AccountStatus.values().length];
        r0[AccountStatus.LOGGED_IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[AccountStatus.LOGGED_OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
