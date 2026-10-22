package com.obric.assistant.component.clicktalk;

import android.content.Context;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ ChatClickTalkComponent a;

    public /* synthetic */ u(ChatClickTalkComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatClickTalkComponent r0 = this.a;
        int r1 = ChatClickTalkComponent.L0;
        t19.s r2 = t19.s.a;
        Context r3 = r0.getContext();
        String r4 = AppHost.a.getApplication().getString(2131907356);
        r2.getClass();
        t19.s.t(r3, r4);
    }
}
