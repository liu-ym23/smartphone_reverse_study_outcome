package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.config.ww0;
import com.bytedance.android.livesdk.config.xw0;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VideoChorusHeightStateManager implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final Lazy c = null;
    public static final int d = 0;
    public static final VideoChorusHeightStateManager e = null;

    public VideoChorusHeightStateManager() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "VideoChorusHeightAdjust";
    }

    static {
        e = new VideoChorusHeightStateManager();
        c = LazyKt.lazy(VideoChorusHeightStateManager$targetBottomMargin$2.INSTANCE);
        InteractionWidgetsPosContext.Companion.getClass();
        d = InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        return r2.i0();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r2, int r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r4, Room r5, LiveRoomEnvStateHolder r6) {
        Intrinsics.checkNotNullParameter(r4, "uiContext");
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r6, "roomStatus");
        if (r4.g1() == false) goto L5;
        int r7 = s1.w();
    L7:
        if (FoldScreenUtils.e() == false) goto L9;
    L12:
        float r8 = r7;
        float r9 = ((Float) xw0.a.getValue()).floatValue();
    L13:
        int r10 = (int) (r8 * r9);
        InteractionWidgetsPosContext r11 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r5.getRoomId(), 1);
        if (r11 == null) goto L17;
        r11.getVideoChorusGiftTrayPos().setValue(new ok1.a((((Number) c.getValue()).intValue() + r10) - d, 2));
    L17:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r10, ((Number) c.getValue()).intValue(), 12);
    L9:
        if (PadConfigUtils.c() == true) goto L12;
        r8 = r7;
        r9 = ((Float) ww0.a.getValue()).floatValue();
        goto L13
    L5:
        r7 = Math.min(s1.w(), s1.y());
        goto L7
    }
}
