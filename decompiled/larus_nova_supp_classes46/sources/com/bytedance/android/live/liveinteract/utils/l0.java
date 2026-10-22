package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 {
    public static final l0 a = null;

    public l0() {
    }

    static {
        a = new l0();
    }

    @JvmStatic
    public static final int a() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public static void b(Map r6) {
        Integer r0 = Integer.valueOf(a());
        Intrinsics.checkNotNullParameter(r6, "logMap");
        if (r0 != null) goto L6;
    L14:
        if (r0 != null) goto L17;
    L19:
        if (r0 != null) goto L22;
    L24:
        if (r0 != null) goto L27;
    L29:
        if (r0 != null) goto L32;
    L34:
        if (r0 != null) goto L37;
        return;
    L37:
        if (r0.intValue() != 12) goto L48;
        r6.put("function_type", "party");
        return;
    L48:
        return;
    L32:
        if (r0.intValue() != 4) goto L34;
        r6.put("function_type", "audience");
        return;
    L27:
        if (r0.intValue() != 10) goto L29;
        r6.put("function_type", "watch");
        return;
    L22:
        if (r0.intValue() != 9) goto L24;
        r6.put("function_type", "ktv");
        return;
    L17:
        if (r0.intValue() != 8) goto L19;
        r6.put("function_type", "radio");
        return;
    L6:
        if (r0.intValue() != 5) goto L14;
        r6.put("function_type", "radio");
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L40;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 != null) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r2) == false) goto L42;
        r6.put("function_type", "party");
        return;
    L42:
        return;
    }

    public static void c(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        if (r1 == null) goto L9;
        LiveMode r3 = r1.getStreamType();
        int r4 = com.bytedance.android.live.core.utils.h1.a;
        String r5 = (String) r2.put("live_type", com.bytedance.android.live.core.utils.i1.a(r3));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void d(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        if (r1 == null) goto L9;
        LiveMode r3 = r1.getStreamType();
        int r4 = com.bytedance.android.live.core.utils.h1.a;
        String r5 = (String) r2.put("live_type", com.bytedance.android.live.core.utils.i1.a(r3));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final void e(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r1.t();
        if (r3 == null) goto L17;
        List r4 = r3.b;
        if (r4 != null) goto L11;
        return;
    L11:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r4) == false) goto L13;
        r2.put("seat_fit_status", "on");
        return;
    L13:
        r2.put("seat_fit_status", "off");
        return;
    L17:
        return;
    L16:
        return;
    }
}
