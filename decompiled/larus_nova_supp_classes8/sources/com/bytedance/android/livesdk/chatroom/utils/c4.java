package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session.LiveRoomSlideTipsBusiness;
import com.bytedance.android.livesdk.config.ng1;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c4 {
    public static String a = "live.pref.SHOW_SCROLL_TIPS";
    public static int b;
    public static boolean c;
    public static final List<String> d = null;

    static {
        ArrayList r0 = new ArrayList();
        d = r0;
        r0.add("tv_broadcast_feed_card");
        r0.add("tv_broadcast_task");
    }

    public static boolean a() {
        if (ng1.a.getValue().intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void b(String r3, ILiveRoomListProvider r4, boolean r5, LiveRoomSlideTipsBusiness.b r6) {
        if (tb1.c.a == true) goto L5;
        return;
    L5:
        if (a() == false) goto L7;
    L9:
        c = false;
        a = "live.pref.SHOW_SCROLL_TIPS";
        b = 0;
        if (r4 != null) goto L12;
    L22:
        b = 1;
        if (SharedPrefHelper.b(com.bytedance.android.live.core.utils.s1.getContext()).f("live.pref.SHOW_SCROLL_TIPS", true) == false) goto L31;
        if (r4 != null) goto L26;
        return;
    L26:
        if (r4.size() > 1) goto L33;
        c = true;
        return;
    L33:
        return;
    L31:
        return;
    L12:
        if (r4.size() <= 1) goto L22;
        if (r6 == null) goto L22;
        if (r5 == false) goto L17;
        b = 1;
        return;
    L17:
        SharedPrefHelper r7 = SharedPrefHelper.b(com.bytedance.android.live.core.utils.s1.getContext());
        if (r7.f("live.pref.SHOW_SCROLL_TIPS", true) == true) goto L21;
        r6.a(false);
        return;
    L21:
        r7.l("live.pref.SHOW_SCROLL_TIPS", Boolean.FALSE);
        r7.a();
        r6.a(true);
        b = 2;
        return;
    L7:
        if (((ArrayList) d).contains(r3) == true) goto L9;
    }
}
