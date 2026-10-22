package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l implements Function1 {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public /* synthetic */ l(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        DoraObricGDoubaoConversationSettingsFragment r0 = this.a;
        boolean r4 = ((Boolean) r3).booleanValue();
        int r1 = DoraObricGDoubaoConversationSettingsFragment.w;
        r0.ea0().updateConvStartEndSoundEnable(r4);
        return Unit.INSTANCE;
    }
}
