package com.larus.bmhome.bot.utils;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final MutableSharedFlow<e> a = null;
    public static final MutableSharedFlow<String> b = null;

    static {
        a = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }
}
