package com.larus.bmhome.chat.component.list;

import com.bytedance.router.SmartRouter;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u5 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ ChatListComponent a;

    public final void cancel() {
        SmartRouter.buildRoute(a.c(this.a).getContext(), "//flow/setting_account_info").d();
    }

    public u5(ChatListComponent r1) {
        this.a = r1;
    }
}
