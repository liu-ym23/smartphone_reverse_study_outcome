package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(HashMap r4, String r5) {
        Intrinsics.checkNotNullParameter("ttlive_apply_sticker_all", "eventName");
        Intrinsics.checkNotNullParameter(r4, "logMap");
        Intrinsics.checkNotNullParameter(r5, "eventPage");
        r4.put("event_page", r5);
        if (Intrinsics.areEqual(r5, "live_take_page") == false) goto L5;
        r4.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        r4.put("room_id", "");
        u.l().sendLog("ttlive_apply_sticker_all", r4, new Object[0]);
        return;
    L5:
        u.l().sendLog("ttlive_apply_sticker_all", r4, new Object[]{Room.class});
    }
}
