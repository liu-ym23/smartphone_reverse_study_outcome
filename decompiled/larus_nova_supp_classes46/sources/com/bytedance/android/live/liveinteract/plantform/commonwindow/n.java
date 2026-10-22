package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.config.ub0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Deprecated(message = "已废弃，后续请使用LayoutConfigGeckoResManager")
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(int r3) {
        if (r3 != 7) goto L5;
    L27:
        return 0;
    L5:
        if (r3 == 25) goto L27;
        if (r3 == 29) goto L27;
        MultiLinkFrequencyOptConfig r2 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.k(0, Integer.valueOf(r3)) == true) goto L27;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.g(0, Integer.valueOf(r3)) == true) goto L27;
        if (r3 == 4) goto L27;
        if (aj0.b.c(r3) == true) goto L27;
        if (r3 == 21) goto L27;
        if (r3 == 22) goto L27;
        if (r3 == 27) goto L27;
        if (r3 == 26) goto L27;
        return s1.f(((Float) ub0.a.getValue()).floatValue());
    }

    public static o b(m r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        int r0 = c1.a;
        if (c1.a(0, Integer.valueOf(r3.getUiLayout())) == true) goto L5;
        o r6 = new o();
        r6.a = 0;
        r6.b = 0;
        r6.c = 0;
        r6.d = 0;
        return r6;
    L5:
        if (r3.f() != 0) goto L8;
        int r7 = s1.f(95.0f);
        int r1 = s1.f(93.0f);
        int r8 = (r4 - r7) - s1.f(12.0f);
        int r2 = r1 * 2;
        int r9 = (r5 - r2) - s1.f(87.0f);
        o r10 = new o();
        r10.a = r8;
        r10.b = r9;
        r10.c = r7;
        r10.d = r2;
        return r10;
    L8:
        int r11 = s1.f(90.0f);
        int r12 = s1.f(90.0f);
        int r13 = s1.f(14.0f);
        if (PadConfigUtils.c() == false) goto L11;
        int r14 = s1.f(230.0f);
    L12:
        int r15 = r12 * 2;
        int r16 = (r5 - r15) - r14;
        o r17 = new o();
        r17.a = r13;
        r17.b = r16;
        r17.c = r11;
        r17.d = r15;
        return r17;
    L11:
        r14 = s1.f(65.0f);
        goto L12
    }
}
