package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.profit.miniplay.SupportLiveScene;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static int a() {
        su0.a r0 = yt0.c.g();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.pf();
    }

    static {
    }

    public static boolean e(List r1) {
        Intrinsics.checkNotNullParameter(r1, "supportLiveScene");
        if (r1.contains(Integer.valueOf(SupportLiveScene.VIDEO_AUDIENCE_LINK.getValue())) == false) goto L5;
    L16:
        return true;
    L5:
        if (r1.contains(Integer.valueOf(SupportLiveScene.VIDEO_CHAT_ROOM.getValue())) == true) goto L16;
        if (r1.contains(Integer.valueOf(SupportLiveScene.VIDEO_EQUAL_CHAT_ROOM.getValue())) == true) goto L16;
        if (r1.contains(Integer.valueOf(SupportLiveScene.AUDIO_CHAT_ROOM.getValue())) == true) goto L16;
        if (r1.contains(Integer.valueOf(SupportLiveScene.AUDIO_KTV_ROOM.getValue())) == true) goto L16;
        if (r1.contains(Integer.valueOf(SupportLiveScene.AUDIO_LINK_ROOM.getValue())) == true) goto L16;
        return false;
    }

    public static u c(long r5, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        List r8 = (List) r7.get("data_broadcast_game_list", null);
        List r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L18;
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L18;
        u r2 = (u) r9.next();
        r r3 = r2.c();
        if (r3 == null) goto L12;
        if (r3.p() != r5) goto L12;
        return r2;
    L18:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static u d(String r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "appid");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        List r5 = (List) r4.get("data_broadcast_new_game_list", null);
        List r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L20;
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L20;
        u r2 = (u) r6.next();
        r r7 = r2.c();
        if (r7 == null) goto L16;
        String r8 = r7.b();
    L18:
        if (Intrinsics.areEqual(r8, r3) == false) goto L12;
        return r2;
    L16:
        r8 = null;
    L20:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean b(List r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "supportLiveScene");
        if (r2 != 10) goto L6;
        return false;
    L6:
        su0.a r0 = yt0.c.g();
        if (r0 == null) goto L9;
        Integer r4 = Integer.valueOf(r0.X9(r3, r2));
    L11:
        return r1.contains(r4);
    L9:
        r4 = null;
        goto L11
    }
}
