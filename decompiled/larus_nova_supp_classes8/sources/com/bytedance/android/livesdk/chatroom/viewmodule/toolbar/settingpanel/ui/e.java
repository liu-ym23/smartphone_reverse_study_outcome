package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ OptionNormalView a;

    public e(OptionNormalView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        TextView r0 = this.a.getTvDesc();
        if (r0 == null) goto L5;
        r0.setText(r4);
    L5:
        TextView r1 = this.a.getTvDesc();
        if (r1 == null) goto L18;
        int r2 = 0;
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r2 = 8;
    L16:
        r1.setVisibility(r2);
        return;
    L10:
        if (r4.length() == 0) goto L13;
        r5 = false;
        goto L14
    }
}
