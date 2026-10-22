package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.gz0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n3 {
    @JvmStatic
    public static final vlc.d b() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (vlc.d) r1.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final boolean h() {
        im2.k r4 = null;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L38;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L39;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 != null) goto L10;
        return false;
    L10:
        if ((r2 instanceof vlc.e) == true) goto L12;
        r2 = null;
    L12:
        vlc.e r3 = (vlc.e) r2;
        if (r3 == null) goto L15;
        amc.e r5 = r3.q();
    L17:
        if ((r5 instanceof hm2.h) == true) goto L19;
        r5 = null;
    L19:
        hm2.h r6 = (hm2.h) r5;
        if (r6 == null) goto L40;
        im2.k r7 = r6.o;
        if ((r7 instanceof im2.k) == false) goto L25;
        r4 = r7;
    L25:
        im2.k r8 = r4;
        if (r8 == null) goto L34;
        im2.k.d r9 = r8.d;
        if (r9 == null) goto L34;
        LiveWsBridge r10 = r9.a.a;
        if (r10 == null) goto L34;
        if (r10.isConnected() != true) goto L34;
        boolean r11 = true;
    L35:
        if (r11 != true) goto L41;
        return true;
    L41:
        return false;
    L34:
        r11 = false;
        goto L35
    L40:
        return false;
    L15:
        r5 = null;
        goto L17
    L39:
        return false;
    L38:
        return false;
    }

    static {
    }

    @JvmStatic
    public static final ylc.e a(long r4) {
        com.bytedance.android.livesdk.config.setting.q r0 = gz0.a.getValue();
        return new ylc.e(r4, new ylc.d(r0.a(), CollectionsKt.toSet(r0.b())), new bc2.e());
    }

    @JvmStatic
    public static final vlc.d c(long r3) {
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, r3, 1);
        if (r4 == null) goto L8;
        com.bytedance.live.datacontext.j r5 = r4.getMessageManager();
        if (r5 != null) goto L7;
        return null;
    L7:
        return (vlc.d) r5.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final vlc.d d(MiddlewareRoomContext r0) {
        if (r0 == null) goto L6;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L6;
        return (vlc.d) r1.getValue();
    L6:
        return null;
    }

    @JvmStatic
    public static final vlc.d e(DataCenter r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (vlc.d) r2.get("data_message_manager", null);
    }

    public static /* synthetic */ ylc.e g(MiddlewareRoomContext r2) {
        return f(r2, ((Room) r2.getRoom().getValue()).getRoomId());
    }

    @JvmStatic
    public static final ylc.e f(MiddlewareRoomContext r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        ylc.e r1 = (ylc.e) r2.getWrdsManager().getValue();
        if (r1 != null) goto L7;
        r1 = a(r3);
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r1, "wrdsManager");
        if (r2.isCleared() == true) goto L7;
        r2.getWrdsManager().d(r1);
    L7:
        return r1;
    }
}
