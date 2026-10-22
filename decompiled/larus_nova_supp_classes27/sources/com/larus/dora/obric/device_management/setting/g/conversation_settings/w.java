package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public w(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        boolean r4 = ((Boolean) r2).booleanValue();
        DoraObricGDoubaoConversationSettingsFragment r5 = this.a;
        r5.r = r4;
        Object r6 = r5.fa0().getEnvStateFlow().getValue();
        if ((r6 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L5;
        com.larus.dora.impl.device.settings.lab.c.b r7 = (com.larus.dora.impl.device.settings.lab.c.b) r6;
    L6:
        if (r7 == null) goto L10;
        r5.Z90(r7);
    L10:
        return Unit.INSTANCE;
    L5:
        r7 = null;
        goto L6
    }
}
