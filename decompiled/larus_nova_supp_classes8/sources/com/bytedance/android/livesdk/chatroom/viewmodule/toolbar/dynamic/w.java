package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class w {
    public final ToolbarButton a;
    public final ToolbarButton b;
    public final ToolbarButton c;
    public final ToolbarButton d;

    public w() {
        ToolbarButton r0 = null;
        this(r0, r0, 15);
    }

    public /* synthetic */ w(ToolbarButton r3, ToolbarButton r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this(r3, r4, null, null);
    }

    public w(ToolbarButton r1, ToolbarButton r2, ToolbarButton r3, ToolbarButton r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
