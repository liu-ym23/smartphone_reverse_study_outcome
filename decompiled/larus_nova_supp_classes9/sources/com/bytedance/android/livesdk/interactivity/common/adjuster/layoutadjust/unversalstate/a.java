package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.config.mz;
import com.bytedance.android.livesdk.config.ol0;
import com.bytedance.android.livesdk.config.pl0;
import com.bytedance.android.livesdk.config.sm;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GroupLiveGameConfig;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final a g = null;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "DanmuGameHeightAdjust";
    }

    static {
        g = new a();
        c = s1.f(((Number) pl0.a.getValue()).intValue());
        d = s1.f(((Number) ol0.a.getValue()).intValue());
        mz r0 = mz.a;
        e = s1.f(((GroupLiveGameConfig) r0.getValue()).getLivePublicScreenHeightPhone());
        f = s1.f(((GroupLiveGameConfig) r0.getValue()).getLivePublicScreenHeightPad());
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        if (r2.F() == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.L() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r4, int r5, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r6, Room r7, LiveRoomEnvStateHolder r8) {
        Intrinsics.checkNotNullParameter(r6, "uiContext");
        Intrinsics.checkNotNullParameter(r7, "room");
        Intrinsics.checkNotNullParameter(r8, "roomStatus");
        if (PadConfigUtils.a() == false) goto L5;
        int r9 = (int) com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
    L7:
        if (PadConfigUtils.a() == false) goto L13;
        if (r8.F() == false) goto L11;
        int r10 = d;
    L17:
        if (r7.isLiveTypeAudio() == false) goto L24;
        InteractionWidgetsPosContext r11 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r7.getRoomId(), 1);
        if (r11 == null) goto L24;
        m r13 = r11.getAudioGiftTrayPos();
        if (r13 == null) goto L24;
        r13.setValue(new ok1.a((r10 + r9) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
    L24:
        if (((Boolean) sm.a.getValue()).booleanValue() == false) goto L27;
        r8.G.put("data_voice_chat_public_screen_height", Integer.valueOf(r10));
    L27:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r10, r9, 12);
    L11:
        r10 = f;
        goto L17
    L13:
        if (r8.F() == false) goto L15;
        r10 = c;
        goto L17
    L15:
        r10 = e;
        goto L17
    L5:
        InteractionWidgetsPosContext.Companion.getClass();
        r9 = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        goto L7
    }
}
