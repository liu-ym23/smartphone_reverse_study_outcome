package com.obric.assistant.network.impl;

import com.obric.assistant.network.api.bean.IntentShortLinkType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class ObricNetworkServiceImpl$d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[IntentShortLinkType.values().length];
        r0[IntentShortLinkType.COMPENSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[IntentShortLinkType.ASYNC_NOTIFY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[IntentShortLinkType.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
