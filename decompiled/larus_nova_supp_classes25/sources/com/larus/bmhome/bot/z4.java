package com.larus.bmhome.bot;

import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z4 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ CommonSettingFragment a;

    public final void cancel() {
        this.a.l.getClass();
        com.larus.platform.service.o.a.b("click_clear_message_cancel", com.larus.utils.f.c(new Pair[0]));
    }

    public z4(CommonSettingFragment r1) {
        this.a = r1;
    }
}
