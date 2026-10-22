package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ToolbarLiteCommerceBehavior a;
    public final /* synthetic */ Context b;

    public o3(ToolbarLiteCommerceBehavior r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        ToolbarLiteCommerceBehavior r5 = this.a;
        Context r0 = this.b;
        int r1 = ToolbarLiteCommerceBehavior.g;
        r5.a(r0);
        r3.cancel();
    }
}
