package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.wa;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> a = null;

    static {
        if (b().a() <= 0) goto L5;
        boolean r1 = true;
    L6:
        a = new com.bytedance.android.livesdk.sharedpref.e("live_anchor_asr_show_bubble", Boolean.valueOf(r1));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static ms1.a b() {
        return (ms1.a) wa.a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        if (b().a() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean c(RoomContext r5) {
        if (fm3.c.b == false) goto L5;
        return false;
    L5:
        if (PadConfigUtils.c() == true) goto L38;
        if (r5 != null) goto L9;
        r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L9:
        if (r5 != null) goto L12;
        return false;
    L12:
        if (((Boolean) r5.isAnchor().getValue()).booleanValue() == true) goto L15;
        return false;
    L15:
        if (b().a() != 0) goto L17;
        return false;
    L17:
        RoomAuthStatus r0 = ((Room) r5.getRoom().getValue()).getRoomAuthStatus();
        if (r0 != null) goto L20;
        return false;
    L20:
        if (r0.isEnableAnchorAsr() == true) goto L22;
        return false;
    L22:
        if (e.b() == true) goto L25;
        return false;
    L25:
        if (r5.isVSRoom() == false) goto L27;
        return false;
    L27:
        if (r5.isMediaRoom() == false) goto L29;
        return false;
    L29:
        if (((Room) r5.getRoom().getValue()).getStreamType() == LiveMode.SCREEN_RECORD) goto L37;
        return true;
    L37:
        return false;
    L38:
        return false;
    }
}
