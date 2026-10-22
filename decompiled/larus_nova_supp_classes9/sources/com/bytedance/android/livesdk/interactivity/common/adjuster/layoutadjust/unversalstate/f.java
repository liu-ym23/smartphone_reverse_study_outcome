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
public final class f implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final float c = 0.0f;
    public static final float d = 0.0f;
    public static final float e = 0.0f;
    public static final float f = 0.0f;
    public static final float g = 0.0f;
    public static final float h = 0.0f;
    public static final f i = null;

    public f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "MultiAnchorConnect";
    }

    static {
        i = new f();
        c = s1.e(130.0f);
        d = s1.e(30.0f);
        e = s1.e(32.0f);
        float r0 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
        f = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
        g = s1.e(160.0f);
        h = s1.e(126.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        if (r2.o == true) goto L5;
    L7:
        return false;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r7, int r8, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r9, Room r10, LiveRoomEnvStateHolder r11) {
        Intrinsics.checkNotNullParameter(r9, "uiContext");
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r11, "roomStatus");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r0 = null;
        if (PadConfigUtils.c() == true) goto L6;
    L13:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r13 = null;
    L29:
        if (r13 == null) goto L32;
        return r13;
    L32:
        if (PadConfigUtils.c() == true) goto L35;
    L41:
        if (r0 == null) goto L44;
        return r0;
    L44:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) g, (int) f, 12);
    L35:
        if (r11.isAnchor() == true) goto L41;
        if (e5.n() == false) goto L41;
        r0 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) (s1.w() * 0.28f), (int) (e + f), 12);
        goto L41
    L6:
        if (r11.isAnchor() == true) goto L13;
        if (e5.n() == true) goto L13;
        int r14 = r9.pT();
        int r15 = r11.p;
        int r1 = r11.q;
        if (r15 <= 0) goto L13;
        RoomAuthStatus r16 = r10.getRoomAuthStatus();
        if (r16 != null) goto L17;
    L22:
        float r17 = d;
    L23:
        float r2 = f;
        int r3 = (int) r2;
        float r4 = ((r14 - r15) - r17) - r3;
        if (PadConfigUtils.c() == false) goto L28;
        float r5 = h;
        if (r4 >= r5) goto L28;
        r4 = r5;
    L28:
        boolean r6 = TextMessageTracer.a;
        TextMessageTracer.A("pad height adjust, interactHeight is " + r14 + ", videoBottom is " + r15 + ", videoGap is " + r17 + ", multiAnchorDefaultMargin is " + r2);
        r13 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) r4, r3, 12);
        goto L29
    L17:
        if (r16.getEnableGift() != true) goto L22;
        if (r1 >= 3) goto L21;
        r17 = c;
        goto L23
    L21:
        r17 = d;
        goto L23
    }
}
