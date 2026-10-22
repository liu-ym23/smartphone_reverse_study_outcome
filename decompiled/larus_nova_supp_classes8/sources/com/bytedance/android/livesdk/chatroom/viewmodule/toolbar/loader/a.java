package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements js0.b {
    public final /* synthetic */ AnchorConfigCompatFixLoader a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ List c;

    public final void onSuccess(String r4) {
        Intrinsics.checkNotNullParameter(r4, "track");
        this.b.removeAll(this.c);
        ArrayList r5 = this.b;
        ToolbarButton r0 = ToolbarButton.BROADCAST_INFO;
        r5.add(r0);
        List r6 = CollectionsKt.listOf(this.c);
        y3.f(this.a.a).p(r0.extended(), com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.b.b(r0, r6));
    }

    public a(AnchorConfigCompatFixLoader r1, ArrayList r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
