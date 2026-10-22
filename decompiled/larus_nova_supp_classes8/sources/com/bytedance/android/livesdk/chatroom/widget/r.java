package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ u a;
    public final /* synthetic */ boolean b;

    public r(u r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        u r4 = this.a;
        u.b r0 = r4.B;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == false) goto L12;
        String r1 = r4.z;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r0.Lf(r1, r4.getRoomDecoration());
        return;
    }
}
