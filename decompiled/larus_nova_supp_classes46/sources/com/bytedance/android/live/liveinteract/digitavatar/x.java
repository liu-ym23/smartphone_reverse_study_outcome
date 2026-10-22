package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        c(r0, r3);
        r0.put("request_page", r4);
        j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_model_reset_click", r0, new Object[]{am2.x.class, IRoom.class});
    }

    public static void c(Map r3, boolean r4) {
        int r0 = je0.d.f();
        List<KtvMusic> r1 = je0.d.k0(jc1.k.n(IMiddlewareUserService.class).user().n());
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        TalkRoomLogUtils.I0(r3, r0);
        TalkRoomLogUtils.D0(r3, Integer.valueOf(r0), !r2);
        TalkRoomLogUtils.B0(r3, Integer.valueOf(r0), null, 4);
        if (r4 == false) goto L12;
        String r5 = "anchor";
    L13:
        r3.put("user_type", r5);
        return;
    L12:
        r5 = "guest";
        goto L13
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public static void a(boolean r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        LinkedHashMap r0 = new LinkedHashMap();
        c(r0, r2);
        if (r3 == false) goto L5;
        String r5 = "reset";
    L6:
        r0.put("request_page", r5);
        r0.put("avatar_selection", r4);
        j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_set_mode_click", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r5 = "panel";
        goto L6
    }
}
