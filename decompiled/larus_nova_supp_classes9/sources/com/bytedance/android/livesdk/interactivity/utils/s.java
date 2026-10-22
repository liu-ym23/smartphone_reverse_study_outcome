package com.bytedance.android.livesdk.interactivity.utils;

import android.net.Uri;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.bd;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(com.bytedance.android.livesdk.interactivity.api.entity.l r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        com.bytedance.android.live.base.model.message.t r3 = r2.b;
        String r1 = null;
        if ((r3 instanceof bd) == true) goto L5;
        r3 = null;
    L5:
        bd r4 = (bd) r3;
        if (r4 == null) goto L11;
        com.bytedance.android.live.base.model.data.m r5 = r4.itemStyle;
        if (r5 == null) goto L11;
        r1 = r5.itemType;
    L11:
        return Intrinsics.areEqual(r1, "micro_app");
    }

    public static boolean b(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r1 = null;
        Uri r5 = UriProtector.parse(r4);     // Catch: Throwable -> L8
    L9:
        if (r5 == null) goto L11;
        String r2 = r5.getHost();
    L13:
        if (Intrinsics.areEqual(r2, "microapp") == true) goto L18;
        if (r5 == null) goto L17;
        r1 = r5.getHost();
    L17:
        if (Intrinsics.areEqual(r1, "microgame") == true) goto L18;
        return false;
    L18:
        return true;
    L11:
        r2 = null;
    L8:
        r5 = null;
        goto L9
    }

    public static boolean c(com.bytedance.android.livesdk.interactivity.api.entity.l r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        com.bytedance.android.live.base.model.message.t r3 = r2.b;
        String r1 = null;
        if ((r3 instanceof h0) == true) goto L5;
        r3 = null;
    L5:
        h0 r4 = (h0) r3;
        if (r4 == null) goto L9;
        r1 = r4.getMessageMethod();
    L9:
        return Intrinsics.areEqual(r1, "WebcastVideoShareMessage");
    }

    public static void d(String r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L11;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L11;
        r2.booleanValue();
    L11:
        Pair r13 = com.bytedance.android.livesdk.interactivity.p.b(r11, "live_other", g4.d(), "comment_card", "comment_card", LaunchParamConstant.Scene.c);
        if (r13 != null) goto L14;
        return;
    L14:
        com.bytedance.android.livesdk.log.u.l().h("mp_click", (Map) r13.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().openMiniApp((String) r13.getFirst(), null);
    }
}
