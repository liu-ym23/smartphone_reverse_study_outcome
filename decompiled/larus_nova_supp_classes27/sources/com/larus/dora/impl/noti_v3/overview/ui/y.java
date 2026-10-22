package com.larus.dora.impl.noti_v3.overview.ui;

import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y<T> implements FlowCollector {
    public final /* synthetic */ NotificationBroadcastV3Fragment a;

    public y(NotificationBroadcastV3Fragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        Boolean r5 = (Boolean) r3;
        NotificationBroadcastV3Fragment r6 = this.a;
        LarusDoraPageNotiV3Binding r0 = r6.f;
        if (r0 == null) goto L8;
        if (r5 != null) goto L6;
        e1.o(r0.u);
        r6.aa0(false);
        goto L8
    L6:
        e1.x(r0.u);
        r0.u.getToggleView().setChecked(r5.booleanValue());
        r6.aa0(true);
    L8:
        return Unit.INSTANCE;
    }
}
