package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.Keys;
import f4b.d;
import kotlin.jvm.internal.Intrinsics;
import yya.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.chat.message.menu.b {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.message.menu.b
    public final void a(i r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        if (r3 == true) goto L5;
        return;
    L5:
        Log.i("FullActionPanelManager", "select action " + r2.getType().name() + " for messageId " + this.a.e.b.getId());
    }
}
