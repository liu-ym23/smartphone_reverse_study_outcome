package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r {
    public static final int a = 0;
    public static final int b = 0;

    static {
        a = ((Number) vm2.h.y5.getValue(null, vm2.h.a[335(0x14f, float:4.7E-43)])).intValue();
        b = ((Number) vm2.d.v.getValue(null, vm2.d.a[19])).intValue();
    }

    public static boolean a() {
        int r0 = b;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean b(IRoom r3) {
        if (r3 != null) goto L5;
    L7:
        if (r3 == null) goto L11;
        Map r4 = r3.getAnchorABMap();
        if (r4 == null) goto L11;
        String r5 = (String) r4.get("opt_audience_linkmic");
    L13:
        if (Intrinsics.areEqual(r5, String.valueOf(1)) == false) goto L15;
    L16:
        return true;
    L15:
        if (Intrinsics.areEqual(r5, String.valueOf(3)) == true) goto L16;
        return false;
    L11:
        r5 = null;
        goto L13
    L5:
        if (r3.isThirdParty() != true) goto L7;
        return false;
    }
}
