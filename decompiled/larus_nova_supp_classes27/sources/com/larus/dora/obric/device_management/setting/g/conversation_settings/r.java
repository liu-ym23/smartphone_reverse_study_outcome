package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public r(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        com.larus.dora.impl.device.ailab.u r5 = (com.larus.dora.impl.device.ailab.u) r3;
        DoraObricGDoubaoConversationSettingsFragment r6 = this.a;
        r6.n = r5;
        r6.ba0(r5);
        if ((r5 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L5;
        com.larus.dora.impl.device.ailab.u.b r7 = (com.larus.dora.impl.device.ailab.u.b) r5;
    L6:
        if (r7 == null) goto L9;
        boolean r8 = r7.e;
        r6.aa0(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND, r8, new l(r6));
    L9:
        return Unit.INSTANCE;
    L5:
        r7 = null;
        goto L6
    }
}
