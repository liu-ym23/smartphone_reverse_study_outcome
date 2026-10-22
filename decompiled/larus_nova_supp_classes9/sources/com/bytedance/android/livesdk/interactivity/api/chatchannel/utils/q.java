package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(RoomContext r1) {
        PublicScreenAreaPageType r0 = null;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r2 = a.a(r1, null);
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r3 = r2.getState();
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.base.d r4 = (com.bytedance.android.livesdk.interactivity.api.base.d) r3.getValue();
        if (r4 == null) goto L10;
        r0 = r4.a;
    L10:
        if (r0 != PublicScreenAreaPageType.Square) goto L12;
        return true;
    L12:
        return false;
    }

    public static void a(boolean r2, DataCenter r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        k.b("disableGiftAndEnterAnim disable=" + r2);
        if (r2 == false) goto L5;
        j32.a r5 = new j32.a();
        r5.a = r4;
        r5.b = false;
        Unit r6 = Unit.INSTANCE;
        r3.put("cmd_enter_widget_visible_change", r5);
        return;
    L5:
        j32.a r7 = new j32.a();
        r7.a = r4;
        r7.b = true;
        Unit r8 = Unit.INSTANCE;
        r3.put("cmd_enter_widget_visible_change", r7);
    }
}
