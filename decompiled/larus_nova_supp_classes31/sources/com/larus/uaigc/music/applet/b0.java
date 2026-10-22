package com.larus.uaigc.music.applet;

import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 {
    public static final MutableSharedFlow<w1> a = null;
    public static final kotlinx.coroutines.flow.a1 b = null;
    public static final MutableSharedFlow<v1> c = null;
    public static final kotlinx.coroutines.flow.a1 d = null;

    static {
        MutableSharedFlow<w1> r4 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        a = r4;
        b = kotlinx.coroutines.flow.e.a(r4);
        MutableSharedFlow<v1> r0 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        c = r0;
        d = kotlinx.coroutines.flow.e.a(r0);
    }
}
