package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k1 implements View.OnClickListener {
    public final /* synthetic */ ToolbarCompositeWidget a;

    public k1(ToolbarCompositeWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.livesdk.chatroom.widget.landscape.u r3 = ho1.a.h(this.a.getComponentContext());
        if (r3 == null) goto L6;
        r3.setVisibility(false);
        return;
    }
}
