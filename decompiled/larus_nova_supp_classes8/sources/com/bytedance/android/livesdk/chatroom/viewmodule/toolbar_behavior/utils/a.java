package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements js0.b {
    public final /* synthetic */ ToolbarButton a;
    public final /* synthetic */ List b;
    public final /* synthetic */ DataCenter c;

    public final void onSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "track");
        int r3 = b.a;
        Object r4 = b.b(this.a, this.b);
        if ((r4 instanceof e2) == false) goto L6;
        y3.f(this.c).J((e2) r4);
        return;
    }

    public a(ToolbarButton r1, List r2, DataCenter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
