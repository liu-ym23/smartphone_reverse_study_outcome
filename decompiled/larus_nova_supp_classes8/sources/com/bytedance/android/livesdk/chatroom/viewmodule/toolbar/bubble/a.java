package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a implements h {
    public final BubbleEnv a;

    public final void a() {
        y3.m(this.a.c).b(ToolbarButton.MORE, new l(T8()));
    }

    public a(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.a = r2;
    }
}
