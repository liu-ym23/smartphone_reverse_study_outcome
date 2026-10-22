package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ OptionNormalView a;

    public d(OptionNormalView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        TextView r0 = this.a.getTvTitle();
        if (r0 == null) goto L6;
        r0.setText(r3);
        return;
    }
}
