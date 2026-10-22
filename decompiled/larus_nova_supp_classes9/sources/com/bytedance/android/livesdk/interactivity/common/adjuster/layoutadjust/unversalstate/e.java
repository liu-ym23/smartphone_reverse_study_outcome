package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.y;
import com.bytedance.android.livesdk.config.xu;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final e i = null;

    public e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadEqualTalkAdjust";
    }

    static {
        i = new e();
        c = s1.f(118.0f);
        float r0 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
        d = (int) com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
        e = s1.f(28.0f);
        f = s1.f(110.0f);
        g = s1.f(88.0f);
        h = s1.f(12.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        return r2.I();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r6, int r7, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r8, Room r9, LiveRoomEnvStateHolder r10) {
        Intrinsics.checkNotNullParameter(r8, "uiContext");
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r10, "roomStatus");
        int r11 = r8.pT();
        int r13 = y.b(r9.getRoomId());
        if (r10.g0() == false) goto L5;
        r13 = r13 + h;
    L5:
        long r14 = r9.getRoomId();
        int r15 = r11 - r13;
        int r16 = d;
        int r17 = e;
        int r18 = (r15 - r16) - r17;
        m r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L16;
        m r1 = r0.getRoom();
        if (r1 == null) goto L16;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L16;
        if (r2.isLiveTypeAudio() != true) goto L16;
        InteractionWidgetsPosContext r19 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r14, 1);
        if (r19 == null) goto L19;
        r4 = r19.getAudioGiftTrayPos();
    L19:
        int r20 = c;
        if (r18 < r20) goto L27;
        if (r4 == null) goto L31;
        if (((Boolean) xu.a.getValue()).booleanValue() == false) goto L25;
        int r21 = g;
    L26:
        r4.setValue(new ok1.a((r16 + r18) - r21, 2));
        goto L31
    L25:
        r21 = f;
    L31:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r18, r16, 12);
    L27:
        if (r4 == null) goto L29;
        r4.setValue(new ok1.a((r16 + r20) + r17, 1));
    L29:
        r18 = r20;
    L16:
        InteractionWidgetsPosContext r23 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r14, 1);
        if (r23 == null) goto L19;
        r4 = r23.getEqualVideoTalkGiftTrayPos();
        goto L19
    }
}
