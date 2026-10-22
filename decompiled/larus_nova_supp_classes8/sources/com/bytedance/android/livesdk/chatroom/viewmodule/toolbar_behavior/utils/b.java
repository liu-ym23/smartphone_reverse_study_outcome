package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static c0.b a(ToolbarButton r1) {
        return b(r1, CollectionsKt.emptyList());
    }

    public static c0.b b(ToolbarButton r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "button");
        Intrinsics.checkNotNullParameter(r3, "args");
        Object r4 = ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).provideToolbarBehavior(r2.ordinal(), r3);
        if ((r4 instanceof c0.b) == true) goto L6;
        r4 = null;
    L6:
        return (c0.b) r4;
    }
}
