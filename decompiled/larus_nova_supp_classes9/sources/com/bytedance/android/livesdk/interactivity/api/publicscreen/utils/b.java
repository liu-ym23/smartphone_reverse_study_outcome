package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(DataCenter r2) {
        c0 r3 = y3.m(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.n(ToolbarButton.COMMERCE) == false) goto L9;
        return String.valueOf(1);
    L9:
        if (r3.n(ToolbarButton.TRANSFORM_WIDGET) == false) goto L12;
        return String.valueOf(2);
    L12:
        if (r3.n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == false) goto L15;
        return String.valueOf(3);
    L15:
        if (r3.n(ToolbarButton.WELFARE) == false) goto L18;
        return String.valueOf(4);
    L18:
        if (r3.n(ToolbarButton.GAME_PROMOTE) == false) goto L21;
        return String.valueOf(5);
    L21:
        if (r3.n(ToolbarButton.TICKET_SALE_ANCHOR) == false) goto L24;
        return String.valueOf(8);
    L24:
        if (r3.n(ToolbarButton.GROUP_PURCHASE) == false) goto L27;
        return String.valueOf(7);
    L27:
        if (r3.n(ToolbarButton.LITTLE_GAME) == false) goto L30;
        return String.valueOf(9);
    L30:
        if (r3.n(ToolbarButton.OPEN_PLATFORM_MINI_GAME) == true) goto L32;
        return null;
    L32:
        return String.valueOf(6);
    }

    public static void a(Map r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "map");
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        String r1 = r0.getFunctionType2();
    L6:
        r2.put("function_type2", r1);
        String r4 = b(r3);
        if (r4 == null) goto L10;
        r2.put("bind_component_type", r4);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
