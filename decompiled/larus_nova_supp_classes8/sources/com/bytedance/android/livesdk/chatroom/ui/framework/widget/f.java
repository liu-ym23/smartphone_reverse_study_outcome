package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ CastScreenCompositeWidget a;

    public f(CastScreenCompositeWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        h70.b r3 = this.a.getComponentContext();
        if (r3 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.widget.landscape.u r4 = ho1.a.h(r3);
    L6:
        if (r4 == null) goto L9;
        r4.setVisibility(false);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
