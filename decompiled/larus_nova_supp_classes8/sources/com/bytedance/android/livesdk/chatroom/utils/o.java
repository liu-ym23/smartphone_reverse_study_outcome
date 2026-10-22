package com.bytedance.android.livesdk.chatroom.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session.LiveRoomSlideTipsBusiness;
import com.bytedance.android.livesdk.config.gr;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        com.bytedance.android.livesdk.log.filter.n0 r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r0 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L10;
        String r1 = r0.d;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r1, "true") == true) goto L9;
        return false;
    L9:
        return gr.a.getValue().booleanValue();
    L10:
        return false;
    }

    static {
    }

    public static void b(int r4, LiveRoomSlideTipsBusiness.a r5) {
        if (gr.a.getValue().booleanValue() == false) goto L18;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r4 != 0) goto L9;
        String r1 = "live.pref.SHOW_CHAT_AUTO_JOIN_TIPS";
    L12:
        SharedPrefHelper r2 = SharedPrefHelper.b(com.bytedance.android.live.core.utils.s1.getContext());
        if (r2.f(r1, true) == true) goto L16;
        r5.a(r4, false);
        return;
    L16:
        r2.l(r1, Boolean.FALSE);
        r2.a();
        r5.a(r4, true);
        return;
    L9:
        if (r4 != 1) goto L11;
        r1 = "live.pref.SHOW_SCROLL_CHAT_AUTO_JOIN_TIPS";
        goto L12
    L11:
        r1 = null;
        goto L12
    }
}
