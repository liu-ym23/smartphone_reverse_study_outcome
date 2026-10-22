package com.obric.assistant.ipc;

import com.larus.account.base.api.UserAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class IpcMessenger$b$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[UserAction.values().length];
        r0[UserAction.ACCOUNT_SWITCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[UserAction.USER_LOGOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
