package com.larus.bmhome.bot;

import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c6 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ ServiceBotSettingFragment a;

    public final void cancel() {
        this.a.h.getClass();
        com.larus.platform.service.o.a.b("click_clear_message_cancel", com.larus.utils.f.c(new Pair[0]));
    }

    public c6(ServiceBotSettingFragment r1) {
        this.a = r1;
    }
}
