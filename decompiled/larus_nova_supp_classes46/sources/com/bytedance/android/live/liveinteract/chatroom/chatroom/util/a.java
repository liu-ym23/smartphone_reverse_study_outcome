package com.bytedance.android.live.liveinteract.chatroom.chatroom.util;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final boolean a = false;

    static {
        a = ((Boolean) vm2.d.P1.getValue(null, vm2.d.a[143(0x8f, float:2.0E-43)])).booleanValue();
    }

    @JvmStatic
    public static final boolean a() {
        j r0 = m.d().getVideoTalkRoomSubScene();
        IRoom r1 = null;
        if (r0 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L16;
        List r4 = r3.b;
        if (r4 == null) goto L16;
        if (r4.contains(4) == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L16;
        boolean r5 = true;
    L17:
        com.bytedance.live.datacontext.m r6 = m.i().getRoom();
        if (r6 == null) goto L20;
        r1 = (IRoom) r6.getValue();
    L20:
        if (r1 == null) goto L24;
        Map r7 = r1.getAnchorABMap();
        if (r7 == null) goto L24;
        String r8 = (String) r7.get("live_anchor_enable_custom_position");
    L24:
        int r9 = je0.d.f();
        Integer r10 = je0.d.h();
        MultiLinkFrequencyOptConfig r11 = f.a;
        Integer r12 = Integer.valueOf(r9);
        if (r10 == null) goto L27;
        int r13 = r10.intValue();
    L29:
        if (f.l(r12, 0, Integer.valueOf(r13)) == false) goto L32;
        r5 = false;
    L32:
        if (r9 != 8) goto L34;
    L41:
        boolean r14 = true;
    L42:
        if (r5 == true) goto L45;
        if (r14 == false) goto L45;
        return true;
    L45:
        return false;
    L34:
        if (r9 == 12) goto L41;
        if (r9 == 5) goto L41;
        if (r9 == 16) goto L41;
        r14 = false;
        goto L42
    L27:
        r13 = 0;
    L16:
        r5 = false;
        goto L17
    }

    @JvmStatic
    public static final boolean c() {
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        if (r1 == null) goto L10;
        Map r2 = r1.getAnchorABMap();
        if (r2 == null) goto L10;
        String r3 = (String) r2.get("live_anchor_enable_custom_position");
    L10:
        int r4 = je0.d.f();
        if (r4 != 8) goto L13;
    L20:
        return true;
    L13:
        if (r4 == 12) goto L20;
        if (r4 == 5) goto L20;
        if (r4 == 16) goto L20;
        return false;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean b(int r2, List<Integer> r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "playModes");
        if (d0.e(r3) == false) goto L5;
    L14:
        boolean r6 = true;
    L15:
        if (r5 == false) goto L18;
        return true;
    L18:
        if (a == true) goto L21;
        if (r4 == false) goto L21;
        return false;
    L21:
        if (r6 == true) goto L23;
        if (r4 == false) goto L23;
    L24:
        return true;
    L23:
        if (r5 == true) goto L24;
        return false;
    L5:
        if (r2 == 2) goto L14;
        if (r2 == 7) goto L14;
        if (r2 == 11) goto L14;
        if (r2 == 12) goto L14;
        r6 = false;
        goto L15
    }
}
