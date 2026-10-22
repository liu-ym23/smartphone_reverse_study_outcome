package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.livesdk.config.fj1;
import com.bytedance.android.livesdk.config.gj1;
import com.bytedance.android.livesdk.config.up;
import com.bytedance.android.livesdk.config.vi1;
import com.bytedance.android.livesdk.config.wi1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
        Integer r0 = (Integer) vi1.a.getValue();
        Integer r1 = (Integer) fj1.a.getValue();
        Integer r2 = (Integer) gj1.a.getValue();
        Integer r3 = (Integer) wi1.a.getValue();
    }

    public static final boolean a() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        IRoom r2 = null;
        if (r0 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r1.t();
        if (r3 == null) goto L16;
        List r4 = r3.b;
        if (r4 == null) goto L16;
        if (r4.contains(4) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L16;
        boolean r5 = true;
    L17:
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r6 == null) goto L20;
        r2 = (IRoom) r6.getValue();
    L20:
        if (r2 == null) goto L24;
        Map r7 = r2.getAnchorABMap();
        if (r7 == null) goto L24;
        String r8 = (String) r7.get("live_anchor_enable_custom_position");
    L24:
        int r9 = o.d();
        if (((Boolean) up.a.getValue()).booleanValue() == false) goto L36;
        int r10 = o.d();
        if (r10 == 11) goto L33;
        if (r10 == 12) goto L33;
        if (r10 == 3) goto L33;
        boolean r11 = false;
    L34:
        if (r11 == false) goto L36;
        r5 = false;
    L33:
        r11 = true;
    L36:
        int r12 = o.c();
        if (r12 == 8) goto L39;
    L43:
        boolean r13 = false;
    L44:
        if (r12 == 8) goto L52;
        if (r12 == 12) goto L52;
        if (r12 == 5) goto L52;
        if (r12 == 16) goto L52;
        boolean r14 = false;
    L53:
        if (r5 == true) goto L58;
        if (r14 == false) goto L59;
        if (r13 == true) goto L60;
        return true;
    L60:
        return false;
    L59:
        return false;
    L58:
        return false;
    L52:
        r14 = true;
        goto L53
    L39:
        if (r9 != 102) goto L41;
    L42:
        r13 = true;
        goto L44
    L41:
        if (r9 != 103) goto L43;
    L16:
        r5 = false;
        goto L17
    }

    public static final boolean b(IRoom r2) {
        if (r2 == null) goto L9;
        Map r3 = r2.getAnchorABMap();
        if (r3 == null) goto L9;
        String r4 = (String) r3.get("ktv_auto_mute_self");
        if (r4 == null) goto L9;
        int r5 = CastIntegerProtector.parseInt(r4);
    L11:
        if (r5 != 1) goto L14;
        return true;
    L14:
        return false;
    L9:
        r5 = 0;
        goto L11
    }
}
