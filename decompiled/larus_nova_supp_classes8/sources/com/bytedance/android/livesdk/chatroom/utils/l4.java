package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.utils.r6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l4 {
    public static final List<ExtendedToolbarButton> c = null;
    public final DataCenter a;
    public final c0 b;

    public static final class a {
    }

    static {
        c = CollectionsKt.listOf(new ExtendedToolbarButton[]{ToolbarButton.COMMERCE.extended(), ToolbarButton.COMMERCE_LIVE_AD.extended(), ToolbarButton.GROUP_PURCHASE_AUDIENCE.extended(), ToolbarButton.GAME_PROMOTE_AUDIENCE.extended(), ToolbarButton.OPEN_PLATFORM_MINI_APP.extended(), ToolbarButton.WELFARE.extended(), ToolbarButton.OPEN_PLATFORM_MINI_GAME.extended(), ToolbarButton.TICKET_SALE.extended(), ToolbarButton.OPEN_PLATFORM_GAME.extended(), ToolbarButton.EASTER_EGG.extended()});
    }

    public final boolean b() {
        DataCenter r0 = this.a;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_is_portrait");
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return true;
    }

    public static boolean a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r2) {
        Intrinsics.checkNotNullParameter(r2, "tbm");
        Iterator<T> r0 = c.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r2.y((ExtendedToolbarButton) r0.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public l4(DataCenter r2, c0 r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "mutextHelper");
        this.a = r2;
        this.b = r3;
    }

    public final void c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r2, ExtendedToolbarButton r3) {
        Intrinsics.checkNotNullParameter(r2, "tbm");
        Intrinsics.checkNotNullParameter(r3, "buttonRemove");
        if (c.contains(r3) == true) goto L5;
        return;
    L5:
        if (b() == false) goto L16;
        int r4 = r6.a;
        if (r6.a.a() == false) goto L9;
        return;
    L9:
        if (r6.a.c() == false) goto L12;
        this.b.a(r2, ToolbarButton.FAST_GIFT.extended());
        return;
    L12:
        if (r6.a.b() == false) goto L19;
        this.b.f(r2, ToolbarButton.FAST_GIFT.extended());
        return;
    L19:
        return;
    }
}
