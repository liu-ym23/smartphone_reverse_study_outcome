package com.bytedance.android.livesdk.clearscreen.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.live.datacontext.m;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final a b = null;

    public a() {
    }

    static {
        b = new a();
        a = new com.bytedance.android.livesdk.log.b("ClearScreenFromPinchInjector", null);
    }

    public final void Rd() {
        a.a("added");
    }

    public final void onRemove() {
        a.a("removed");
    }

    public final void L9(String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "params");
        switch(r7.hashCode()) {
            case -1115849514: goto L24;
            case -1103263308: goto L21;
            case -804282046: goto L18;
            case 21313630: goto L15;
            case 516631638: goto L12;
            case 1499179894: goto L9;
            case 2041791848: goto L6;
            default: goto L53;
        };
    L53:
        return;
    L6:
        if (r7.equals("livesdk_like") == false) goto L46;
    L25:
        RoomContext.a r9 = RoomContext.Companion;
        Boolean r0 = null;
        RoomContext r4 = RoomContext.a.c(r9, null, 0, 3);
        boolean r5 = true;
        if (r4 == null) goto L31;
        m r6 = r4.getPinchEnterRoom();
        if (r6 == null) goto L31;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L31;
    L39:
        Boolean r10 = Boolean.valueOf(r5);
        if (r10.booleanValue() == false) goto L42;
        r0 = r10;
    L42:
        if (r0 == null) goto L44;
        r0.booleanValue();
        r8.put("is_pinch_enter", "1");
    L44:
        a.a("inject is_pinch_enter: " + r5);
        return;
    L31:
        RoomContext r11 = RoomContext.a.c(r9, null, 0, 3);
        if (r11 == null) goto L38;
        m r12 = r11.getPinchLog();
        if (r12 == null) goto L38;
        if (((Boolean) r12.getValue()).booleanValue() == true) goto L39;
    L38:
        r5 = false;
        goto L39
    L46:
        return;
    L9:
        if (r7.equals("livesdk_live_play") == true) goto L25;
        return;
    L12:
        if (r7.equals("livesdk_send_gift") == true) goto L25;
        return;
    L15:
        if (r7.equals("livesdk_audience_live_message") == true) goto L25;
        return;
    L18:
        if (r7.equals("livesdk_follow") == true) goto L25;
        return;
    L21:
        if (r7.equals("livesdk_dislike") == true) goto L25;
        return;
    L24:
        if (r7.equals("livesdk_live_duration") == true) goto L25;
    }
}
