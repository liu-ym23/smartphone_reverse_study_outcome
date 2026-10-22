package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DiggItem {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static np1.b a(final np1.c r7) {
        Intrinsics.checkNotNullParameter(r7, "panelContext");
        Intrinsics.checkNotNullParameter(r7, "panelContext");
        DataCenter r0 = r7.getDataCenter();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L19:
        if (r2 == true) goto L21;
        return null;
    L21:
        np1.b.a r1 = np1.b.a;
        Function0<g> r3 = new DiggItem$provide$1(r7);
        Function1<g, Unit> r4 = new DiggItem$provide$2(r7);
        r1.getClass();
        return np1.b.a.a(r3, r4);
    L5:
        if (z.e(r0, false) == true) goto L19;
        if (z.m(r0, true) == false) goto L19;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L19;
        m r6 = r5.getRoom();
        if (r6 == null) goto L19;
        Room r8 = (Room) r6.getValue();
        if (r8 == null) goto L19;
        RoomAuthStatus r9 = r8.getRoomAuthStatus();
        if (r9 == null) goto L19;
        if (r9.getEnableDigg() != true) goto L19;
        r2 = true;
        goto L19
    }
}
