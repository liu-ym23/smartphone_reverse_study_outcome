package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.us0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.j;
import com.bytedance.android.livesdk.interactivity.common.adjuster.logical.CommentLpHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public final c52.a c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "CommonAudienceHeightAdjust";
    }

    public c() {
        this.c = c52.a.g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r11, int r13, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r14, Room r15, LiveRoomEnvStateHolder r16) {
        Intrinsics.checkNotNullParameter(r14, "uiContext");
        Intrinsics.checkNotNullParameter(r15, "room");
        Intrinsics.checkNotNullParameter(r16, "roomStatus");
        if (PublicScreenABHelper.f().enable == false) goto L8;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r17 = CommentLpHelper.d(r14, r13, r16, r15);
        if (r17 == null) goto L27;
        return r17;
    L27:
        if (j.a(r16, r14) == false) goto L29;
        int r18 = j.c(r13, r14, r16, this.c);
        String r19 = "default";
    L30:
        int r2 = r18;
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c(r2 + com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.a, r2, 0, j.d(), r19, 4);
    L29:
        r19 = r16.A;
        r18 = y.a() + r16.z;
        goto L30
    L8:
        if (((Boolean) us0.a.getValue()).booleanValue() == false) goto L22;
        int r110 = r14.pT();
        int r1 = r14.WN();
        double r3 = r1;
        double r4 = (((double) r110) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3));
        boolean r111 = true;
        if (r3 >= r4) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
    L18:
        r111 = false;
    L19:
        if (r111 == false) goto L22;
        int r112 = r14.pT() - r14.WN();
        int r113 = i72.a.a;
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((r112 - s1.j(2131168725)) - r13, 0, 14);
    L15:
        if (r14.g1() == false) goto L18;
        if (r1 <= 0) goto L18;
    L12:
        r5 = false;
    L22:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r114 = CommentLpHelper.c(r14, r13, r15, r16);
        if (r114 == null) goto L27;
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c((((r14.pT() - r14.WN()) - r13) + 0) - com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.b, r114.a, 0, 0, null, 28);
    }
}
