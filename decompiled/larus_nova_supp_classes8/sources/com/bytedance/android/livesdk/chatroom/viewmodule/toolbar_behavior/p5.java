package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p5 implements View.OnClickListener {
    public final /* synthetic */ ToolbarTransformWidgetBehavior a;

    public p5(ToolbarTransformWidgetBehavior r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ToolbarTransformWidgetBehavior r4 = this.a;
        yo2.e r0 = r4.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h() != true) goto L11;
        yo2.e r5 = r4.d;
        if (r5 == null) goto L12;
        r5.d();
        return;
    L12:
        return;
    }
}
