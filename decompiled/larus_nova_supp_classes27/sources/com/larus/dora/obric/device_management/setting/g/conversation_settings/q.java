package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public q(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        com.larus.dora.impl.device.ailab.a r4 = (com.larus.dora.impl.device.ailab.a) r2;
        if (r4 == null) goto L10;
        boolean r5 = r4.d;
        DoraObricGDoubaoConversationSettingsFragment r6 = this.a;
        if (r6.p == r5) goto L9;
        r6.p = r5;
        r6.ja0();
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }
}
