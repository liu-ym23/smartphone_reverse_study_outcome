package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class u5 implements View.OnClickListener {
    public static boolean b = true;
    public static final t5 c = null;
    public final long a;

    public abstract void a(View r1);

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.livesdk.chatroom.ui.t5] */
    static {
        c = new t5();
    }

    public u5() {
        this.a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (b == false) goto L6;
        b = false;
        r4.postDelayed(c, this.a);
        a(r4);
        return;
    }
}
