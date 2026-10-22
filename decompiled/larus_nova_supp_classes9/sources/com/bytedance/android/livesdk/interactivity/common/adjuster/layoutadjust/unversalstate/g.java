package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final float c = 0.0f;
    public static final float d = 0.0f;
    public static final float e = 0.0f;
    public static final float f = 0.0f;
    public static final g g = null;

    public g() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadPkHeightAdjust";
    }

    static {
        g = new g();
        c = s1.e(118.0f);
        d = s1.e(30.0f);
        e = s1.e(32.0f);
        float r0 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
        f = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        if (r2.e0() == true) goto L5;
    L7:
        return false;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r10, int r11, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r13, Room r14, LiveRoomEnvStateHolder r15) {
        Intrinsics.checkNotNullParameter(r13, "uiContext");
        Intrinsics.checkNotNullParameter(r14, "room");
        Intrinsics.checkNotNullParameter(r15, "roomStatus");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r3 = null;
        if (PadConfigUtils.c() == false) goto L13;
        r13.g1();
        if (r15.isAnchor() == true) goto L13;
        if (e5.n() == true) goto L13;
        int r0 = r13.pT();
        int r4 = r13.DM();
        if (r4 <= 0) goto L13;
        RoomAuthStatus r5 = r14.getRoomAuthStatus();
        if (r5 != null) goto L17;
    L19:
        float r6 = d;
    L20:
        boolean r7 = TextMessageTracer.a;
        TextMessageTracer.A("pad height adjust, interactHeight is " + r0 + ", videoBottom is " + r4 + ", videoGap is " + r6 + ", currentMarginBottom is " + r11);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r16 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) (((r0 - r4) - r6) - r11), 0, 14);
    L21:
        if (r16 == null) goto L24;
        return r16;
    L24:
        if (PadConfigUtils.c() == true) goto L27;
    L31:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r17 = null;
    L33:
        if (r17 == null) goto L36;
        return r17;
    L36:
        if (r14.isMediaRoom() == false) goto L38;
    L39:
        r3 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r10, 0, 14);
    L40:
        if (r3 == null) goto L43;
        return r3;
    L43:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) f.g, 0, 14);
    L38:
        if (r13.g1() == true) goto L40;
    L27:
        if (r15.isAnchor() == true) goto L31;
        if (e5.n() == false) goto L31;
        r17 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) (s1.w() * 0.28f), (int) (e + f), 12);
        goto L33
    L17:
        if (r5.getEnableGift() != true) goto L19;
        r6 = c;
    L13:
        r16 = null;
        goto L21
    }
}
