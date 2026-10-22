package com.larus.bmhome.chat.component.title;

import com.larus.im.bean.IMConnectState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public /* synthetic */ class ChatTitleComponent$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[IMConnectState.values().length];
        r0[IMConnectState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[IMConnectState.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[IMConnectState.CONNECTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
