package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.s;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import j40.n;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    @JvmStatic
    public static final boolean b() {
        if (((CommunityFoldFixConfig) n.a.getValue()).getEnableInteractivity() == true) goto L5;
    L7:
        return false;
    L5:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.i) n0.a.getValue()).fixGiftTrayPos == false) goto L7;
        return true;
    }

    public static int d() {
        if (PublicScreenABHelper.K == true) goto L5;
        return 0;
    L5:
        if (FoldScreenUtils.f() == false) goto L8;
        return 0;
    L8:
        return ((Number) PublicScreenABHelper.L.getValue()).intValue();
    }

    static {
    }

    @JvmStatic
    public static final boolean a(LiveRoomEnvStateHolder r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r4) {
        Intrinsics.checkNotNullParameter(r3, "roomStatus");
        Intrinsics.checkNotNullParameter(r4, "uiContext");
        if (r3.isAnchor() == false) goto L5;
    L25:
        return false;
    L5:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f.a().enable == false) goto L25;
        if (r4.g1() == true) goto L11;
        return false;
    L11:
        if (PadConfigUtils.c() == false) goto L16;
        if (r3.isVSRoom() != true) goto L16;
        return false;
    L16:
        if (r3.O() == true) goto L18;
    L24:
        return true;
    L18:
        if (r3.k0() == false) goto L22;
        if (r3.m() == 8) goto L24;
    L22:
        if (r3.H() == true) goto L24;
        return false;
    }

    @JvmStatic
    public static final int c(int r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r4, LiveRoomEnvStateHolder r5, c52.b r6) {
        Intrinsics.checkNotNullParameter(r4, "uiContext");
        Intrinsics.checkNotNullParameter(r5, "roomStatus");
        Intrinsics.checkNotNullParameter(r6, "heightSettingStrategy");
        int r7 = r4.pT();
        int r8 = ((Number) r6.b(r6.a().b())).intValue();
        int r0 = s.a;
        String r1 = "adjuster use height: " + r8;
        Intrinsics.checkNotNullParameter(r1, "string");
        ALogger.i("PublicScreenStyleSetting", r1);
        int r2 = com.bytedance.android.livesdk.interactivity.api.entity.n.a;
        int r9 = r7 - ((r8 + r3) + r2);
        if (r5.B() == false) goto L6;
        r9 = Math.max(r9, o22.a.e);
    L6:
        if (r5.d0() == false) goto L9;
        r9 = Math.max(r9, r5.o() + com.bytedance.android.livesdk.interactivity.api.entity.n.b);
    L9:
        if (r5.t() == false) goto L12;
        r9 = Math.max(r9, r5.i());
    L12:
        return ((r7 - r9) - r2) - r3;
    }
}
