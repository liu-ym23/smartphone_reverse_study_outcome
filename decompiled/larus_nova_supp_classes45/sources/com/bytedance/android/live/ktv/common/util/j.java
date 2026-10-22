package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public static final void j(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public static final String c() {
        return jc1.k.n(IInteractService.class).getFunctionType2();
    }

    public static final String d() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        return f(r1);
    L7:
        return "";
    }

    public static final String g() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L6;
        return "anchor";
    L6:
        if (jc1.k.n(IInteractService.class).isAudienceLinkEngineOn() == false) goto L9;
        return "guest";
    L9:
        if (a.g() == false) goto L11;
        return "admin";
    L11:
        return "user";
    }

    public static final boolean i() {
        return Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
    }

    public static final String a(DataCenter r2) {
        if (r2 == null) goto L6;
        Integer r3 = (Integer) r2.get("data_link_state", 0);
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
    L8:
        if (gd0.v.a(r4, 8) == false) goto L11;
        return "radio";
    L11:
        return GamePromoteDataContext.LIVE;
    L6:
        r4 = jc1.k.n(IInteractService.class).getLinkMode();
        goto L8
    }

    public static final String b(DataCenter r2) {
        if (r2 == null) goto L6;
        Integer r3 = (Integer) r2.get("data_link_state", 0);
        if (r3 == null) goto L6;
        int r4 = r3.intValue();
    L8:
        if (r4 != 0) goto L11;
        return "";
    L11:
        if (gd0.v.a(r4, 64) == false) goto L15;
        return "anchor";
    L15:
        if (gd0.v.a(r4, 2) == false) goto L17;
        return "audience";
    L17:
        if (gd0.v.a(r4, 8) == false) goto L19;
        return "audience";
    L19:
        if (gd0.v.a(r4, 32) == false) goto L22;
        return "audience";
    L22:
        if (gd0.v.a(r4, 4) == false) goto L33;
        int r5 = ((IMultiLinkServiceExternal) jc1.k.n(IMultiLinkServiceExternal.class)).getMultiDataHolderExternal().getMatchType();
        if (r5 != 0) goto L26;
        return "invite_pk";
    L26:
        if (r5 != 1) goto L35;
        return "random_pk";
    L35:
        return "";
    L33:
        return "";
    L6:
        r4 = jc1.k.n(IInteractService.class).getLinkMode();
        goto L8
    }

    public static final String e(DataCenter r2) {
        if (r2 == null) goto L6;
        IRoom r3 = (IRoom) r2.get("data_room", null);
        if (r3 == null) goto L6;
        return f(r3);
    L6:
        com.bytedance.android.livesdk.chatroom.o r4 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        Intrinsics.checkNotNullParameter(r4, "$this$liveTypeStr");
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L11;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L11;
        return f(r6);
    L11:
        return "";
    }

    public static final String f(IRoom r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$liveTypeStr");
        if (KtvUtilsKt.v() == false) goto L6;
        return "game";
    L6:
        if (r1.isLiveTypeAudio() == false) goto L8;
        return "voice_live";
    L8:
        return "video_live";
    }

    public static final String h(com.bytedance.android.livesdk.chatroom.o r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$userTypeStr");
        if (Intrinsics.areEqual(r1.isAnchor(), Boolean.TRUE) == false) goto L6;
        return "anchor";
    L6:
        if (jc1.k.n(IInteractService.class).isAudienceLinkEngineOn() == false) goto L8;
        return "guest";
    L8:
        return "user";
    }
}
