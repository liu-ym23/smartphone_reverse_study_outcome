package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.widget.CompoundButton;
import com.bytedance.android.livesdk.chatroom.ui.t9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ q.b a;

    public r(q.b r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        k82.a r3 = this.a.c.c;
        if (r3 == null) goto L8;
        t9 r4 = r3.s();
        if (r4 == null) goto L9;
        r4.q = r2;
        return;
    L9:
        return;
    }
}
