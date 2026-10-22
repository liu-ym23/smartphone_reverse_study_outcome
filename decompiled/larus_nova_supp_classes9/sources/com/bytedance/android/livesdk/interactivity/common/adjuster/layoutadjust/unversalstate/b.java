package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.config.hx;
import com.bytedance.android.livesdk.config.ix;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final int c = 0;
    public static final int d = 0;
    public static final b e = null;

    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "VideoChorusHeightAdjust";
    }

    static {
        e = new b();
        c = s1.f(48.0f);
        d = s1.f(28.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        r2.k();
        if (r2.k() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r6, int r7, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r8, Room r9, LiveRoomEnvStateHolder r10) {
        Intrinsics.checkNotNullParameter(r8, "uiContext");
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r10, "roomStatus");
        if (r8.g1() == false) goto L5;
        int r11 = s1.w();
    L7:
        if (r10.isAnchor() == false) goto L9;
        Boolean r13 = (Boolean) r10.G.get("status_bar_is_visible", Boolean.TRUE);
        if (r13 == null) goto L15;
        boolean r14 = r13.booleanValue();
    L16:
        if (r14 == true) goto L19;
        r11 = r11 + StatusBarUtil.getStatusBarHeight(s1.getContext());
    L19:
        if (PadConfigUtils.a() == false) goto L21;
        int r15 = (int) com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
    L22:
        int r16 = r11 - UtilityKotlinExtentionsKt.i(r10.k());
        int r17 = c;
        int r0 = d;
        int r18 = (r16 - r17) - r0;
        InteractionWidgetsPosContext r19 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r9.getRoomId(), 1);
        if (r19 == null) goto L28;
        m r20 = r19.getEqualVideoTalkGiftTrayPos();
        if (r20 == null) goto L28;
        r20.setValue(new ok1.a((r17 + r18) + r0, 1));
    L28:
        if (((Boolean) hx.a.getValue()).booleanValue() == false) goto L35;
        if (FoldScreenUtils.f() == false) goto L35;
        if (FoldScreenUtils.a() != 0) goto L35;
        r18 = r18 - UtilityKotlinExtentionsKt.i(((Integer) ix.a.getValue()).intValue());
    L35:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r18, r15, 12);
    L21:
        r15 = c;
    L15:
        r14 = true;
        goto L16
    L9:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L15;
        r14 = false;
        goto L16
    L5:
        r11 = Math.min(s1.w(), s1.y());
        goto L7
    }
}
