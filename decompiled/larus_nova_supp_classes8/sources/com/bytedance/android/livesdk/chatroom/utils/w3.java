package com.bytedance.android.livesdk.chatroom.utils;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w3 implements cc2.n<cc2.b> {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    public w3(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(Object r1, Boolean r2) {
        cc2.b r3 = (cc2.b) r1;
        View r4 = this.a;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
    L5:
        View r5 = this.b;
        if (r5 == null) goto L9;
        r5.setVisibility(0);
        return;
    }

    public final void b(Object r1, Boolean r2) {
        cc2.b r3 = (cc2.b) r1;
        View r4 = this.a;
        if (r4 == null) goto L5;
        r4.setVisibility(4);
    L5:
        View r5 = this.b;
        if (r5 == null) goto L9;
        r5.setVisibility(4);
        return;
    }
}
