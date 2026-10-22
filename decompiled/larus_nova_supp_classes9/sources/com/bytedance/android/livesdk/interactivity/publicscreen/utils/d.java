package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(DataCenter r4) {
        if (r4 == null) goto L4;
        Boolean r0 = (Boolean) r4.get("data_is_anchor", Boolean.FALSE);
    L6:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L27;
        if (y3.m(r4).n(ToolbarButton.COMMERCE) == false) goto L10;
        return true;
    L10:
        if (y3.m(r4).n(ToolbarButton.TRANSFORM_WIDGET) == false) goto L12;
        return true;
    L12:
        if (y3.m(r4).n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == false) goto L14;
        return true;
    L14:
        if (y3.m(r4).n(ToolbarButton.WELFARE) == false) goto L16;
        return true;
    L16:
        if (y3.m(r4).n(ToolbarButton.GAME_PROMOTE) == false) goto L18;
        return true;
    L18:
        if (y3.m(r4).n(ToolbarButton.GROUP_PURCHASE) == false) goto L20;
        return true;
    L20:
        if (y3.m(r4).n(ToolbarButton.TICKET_SALE_ANCHOR) == false) goto L22;
        return true;
    L22:
        if (y3.m(r4).n(ToolbarButton.LITTLE_GAME) == true) goto L54;
        return false;
    L54:
        return true;
    L27:
        if (y3.m(r4).n(ToolbarButton.COMMERCE) == false) goto L29;
        return true;
    L29:
        if (y3.m(r4).n(ToolbarButton.COMMERCE_LIVE_AD) == false) goto L31;
        return true;
    L31:
        if (y3.m(r4).n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == false) goto L33;
        return true;
    L33:
        if (y3.m(r4).n(ToolbarButton.GAME_PROMOTE_AUDIENCE) == false) goto L35;
        return true;
    L35:
        if (y3.m(r4).n(ToolbarButton.WELFARE) == false) goto L37;
        return true;
    L37:
        if (y3.m(r4).n(ToolbarButton.OPEN_PLATFORM_MINI_GAME) == false) goto L39;
        return true;
    L39:
        if (y3.m(r4).n(ToolbarButton.GROUP_PURCHASE_AUDIENCE) == false) goto L41;
        return true;
    L41:
        if (y3.m(r4).n(ToolbarButton.TICKET_SALE) == false) goto L43;
        return true;
    L43:
        if (y3.m(r4).n(ToolbarButton.LITTLE_GAME) == true) goto L63;
        return false;
    L63:
        return true;
    L4:
        r0 = null;
        goto L6
    }
}
