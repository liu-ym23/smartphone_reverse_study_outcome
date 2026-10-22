package com.larus.bmhome.auth;

import com.bytedance.keva.Keva;
import com.larus.platform.service.o2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 {
    public static final Keva a = null;

    public l0() {
    }

    static {
        a = Keva.getRepo(o2.a.e(), 0);
    }

    public static void a(LaunchInfo r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        boolean r0 = false;
        if (r3 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r3.b0(), Boolean.TRUE);
    L6:
        if (r1 == false) goto L9;
        ColdStartTtsType r5 = ColdStartTtsType.DISABLED;
    L23:
        a.storeInt("launch_info_cold_start_tts_type" + r4, r5.getType());
        return;
    L9:
        if (r3 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        r5 = ColdStartTtsType.DISABLED;
        goto L23
    L16:
        if (r3 != null) goto L18;
    L20:
        if (r0 == false) goto L22;
        r5 = ColdStartTtsType.ENABLED;
        goto L23
    L22:
        r5 = ColdStartTtsType.INVALID;
        goto L23
    L18:
        if (r3.z() != true) goto L20;
        r0 = true;
        goto L20
    L11:
        if (r3.z() == true) goto L13;
        r2 = true;
        goto L14
    L5:
        r1 = false;
        goto L6
    }
}
