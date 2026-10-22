package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public t(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        int r4 = ((Number) r2).intValue();
        DoraObricGDoubaoConversationSettingsFragment r5 = this.a;
        int r0 = DoraObricGDoubaoConversationSettingsFragment.w;
        r5.na0(r4);
        return Unit.INSTANCE;
    }
}
