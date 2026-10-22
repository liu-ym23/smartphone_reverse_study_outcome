package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.settings.config.k0;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public PSMessageHeatState a;
    public int b;
    public int c;
    public PSMessageHeatState d;
    public boolean e;
    public final int f;
    public final Queue<Integer> g;
    public final boolean h;
    public final k0 i;

    public static final class a {
    }

    static {
    }

    public final boolean a(PSMessageHeatState r5) {
        if (this.c != this.i.heatStatusChangeThreshold) goto L10;
        boolean r0 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        String r1 = "当前计数为" + this.c + "，热度状态从" + this.a.name() + "切换到" + r5.name() + ", 重置计数和记录状态";
        Intrinsics.checkNotNullParameter(r1, "successReason");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == false) goto L8;
        ALogger.e("PS_MESSAGE_HEAT", r1);
    L8:
        ALogger.i("PS_MESSAGE_HEAT", "heat state transform from " + this.a.name() + " to " + r5.name() + ", reset record status");
        this.a = r5;
        this.c = 0;
        this.d = null;
        return true;
    L10:
        boolean r6 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        String r7 = "状态更新失败，当前计数为" + this.c + ", 切换状态计数阈值为" + this.i.heatStatusChangeThreshold;
        Intrinsics.checkNotNullParameter(r7, "failReason");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == false) goto L14;
        ALogger.e("PS_MESSAGE_HEAT", r7);
    L14:
        return false;
    }

    public l(int r8, k0 r9) {
        Intrinsics.checkNotNullParameter(r9, "heatConfig");
        this.i = r9;
        this.e = true;
        int r1 = r9.chatCountDuration;
        int r2 = r9.heatStatusCalculateInterval;
        if (r2 > 0) goto L5;
        r2 = 5;
    L5:
        this.f = Math.max(1, r1 / r2);
        this.g = new ArrayDeque();
        if (r9.heatStateMockValue == 0) goto L27;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L27;
        PSMessageHeatState.a r10 = PSMessageHeatState.Companion;
        int r11 = r9.heatStateMockValue;
        r10.getClass();
        PSMessageHeatState[] r13 = PSMessageHeatState.values();
        int r3 = r13.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L18;
        PSMessageHeatState r5 = r13[r4];
        if (r5.getValue() != r11) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L19;
        r4 = r4 + 1;
    L19:
        if (r5 != null) goto L21;
        r5 = PSMessageHeatState.NORMAL;
    L21:
        this.a = r5;
        boolean r14 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        Intrinsics.checkNotNullParameter(r5, "heatState");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == false) goto L25;
        ALogger.e("PS_MESSAGE_HEAT", "mock的热度状态为" + r5);
    L25:
        this.h = true;
        return;
    L14:
        r6 = false;
        goto L15
    L18:
        r5 = null;
    L27:
        if (r8 < r9.acuHotThreshold) goto L30;
        PSMessageHeatState r15 = PSMessageHeatState.HOT;
    L33:
        this.a = r15;
        ALogger.i("PS_MESSAGE_HEAT", "init user count is " + r8 + ", heat state is " + this.a.name());
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.c(this.a, r8);
        this.h = false;
        return;
    L30:
        if (r8 >= r9.acuColdThreshold) goto L32;
        r15 = PSMessageHeatState.COLD;
        goto L33
    L32:
        r15 = PSMessageHeatState.NORMAL;
        goto L33
    }
}
