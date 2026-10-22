package com.larus.dora.impl.noti_v3.overview.ui;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v<T> implements FlowCollector {
    public final /* synthetic */ NotificationBroadcastV3Fragment a;

    public v(NotificationBroadcastV3Fragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        if (((Boolean) r1).booleanValue() == false) goto L6;
        NotificationBroadcastV3Fragment r3 = this.a;
        int r4 = NotificationBroadcastV3Fragment.l;
        r3.X90();
    L6:
        return Unit.INSTANCE;
    }
}
