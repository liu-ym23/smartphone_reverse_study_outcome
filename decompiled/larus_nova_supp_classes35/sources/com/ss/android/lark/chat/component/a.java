package com.ss.android.lark.chat.component;

import android.content.Intent;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin;
import com.ss.android.lark.platform.dispatcher.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements d {
    public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c.b a;

    public a(FlowMessageSelectPlugin.b r1) {
        this.a = r1;
    }

    public final boolean onActivityResult(int r2, int r3, Intent r4) {
        return this.a.b(r2, r3, r4);
    }
}
