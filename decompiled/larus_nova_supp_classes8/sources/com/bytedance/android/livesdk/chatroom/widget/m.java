package com.bytedance.android.livesdk.chatroom.widget;

import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends com.bytedance.android.live.core.utils.q0 {
    public final /* synthetic */ ImageView a;

    public m(ImageView r1) {
        this.a = r1;
    }

    public final void h(py.k r2, int r3, int r4) {
        ViewGroup.LayoutParams r5 = this.a.getLayoutParams();
        int r0 = com.bytedance.android.live.core.utils.s1.j(2131168541);
        if (r5 == null) goto L5;
        r5.height = r0;
    L5:
        if (r5 == null) goto L7;
        r5.width = (r3 / r4) * r0;
    L7:
        this.a.setLayoutParams(r5);
    }
}
