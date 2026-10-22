package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import iub.l;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final MutableSharedFlow<l> a;
    public final a1 b;
    public boolean c;
    public boolean d;

    public b() {
        MutableSharedFlow<l> r0 = SharedFlowKt.MutableSharedFlow$default(0, 16, null, 5, null);
        this.a = r0;
        this.b = e.a(r0);
    }
}
