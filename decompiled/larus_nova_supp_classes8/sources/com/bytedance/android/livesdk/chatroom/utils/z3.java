package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z3 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r1, ShortTermIcon r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r2, "icon");
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.j0.l().c(IRoom.class);
        if (r3 == null) goto L8;
        Map r4 = r3.getMap();
        if (r4 == null) goto L8;
        String r5 = (String) r4.get("anchor_id");
        if (r5 == null) goto L8;
    L9:
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.user.e r6 = r0.user();
        if (r6 == null) goto L14;
        String r7 = r6.n();
    L16:
        if (Intrinsics.areEqual(r5, r7) == false) goto L18;
        String r8 = "1";
    L19:
        r1.put("is_anchor", r8);
        return;
    L18:
        r8 = "0";
    L14:
        r7 = null;
    L8:
        r5 = "";
        goto L9
    }
}
