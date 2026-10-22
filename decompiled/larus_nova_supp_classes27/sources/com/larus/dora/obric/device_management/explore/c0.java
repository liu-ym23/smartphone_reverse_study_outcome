package com.larus.dora.obric.device_management.explore;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public c0() {
    }

    public static x0 b(String r2) {
        return new x0(r2, DoraObricGlassesImagePageType.BASIC_DETAIL);
    }

    public static x0 d(String r2) {
        return new x0(r2, DoraObricGlassesImagePageType.DETAIL);
    }

    public static x0 e(String r2) {
        return new x0(r2, DoraObricGlassesImagePageType.EXPLORE);
    }

    public static b0 a(String r6, int r7, Integer r8, Map r9, DoraObricGlassesExploreActionStateType r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r7 = 2131903544;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r8 = 2131903543;
    L9:
        if ((r11 & 8) == 0) goto L11;
        r9 = MapsKt.emptyMap();
    L11:
        Map r4 = r9;
        if ((r11 & 16) == 0) goto L14;
        DoraObricGlassesExploreActionStateType r5 = null;
    L15:
        d1 r2 = new d1(r7);
        if (r8 == null) goto L18;
        d1 r3 = new d1(r8.intValue());
    L20:
        return new b0(r6, r2, r3, r4, r5);
    L18:
        r3 = null;
        goto L20
    L14:
        r5 = r10;
        goto L15
    }

    public static z c(String r10, int r11, int r12, String r13, List r14, List r15, b0 r16, int r17) {
        if ((r17 & 32) == 0) goto L5;
        List r5 = CollectionsKt.emptyList();
    L7:
        if ((r17 & 64) == 0) goto L9;
        List r6 = CollectionsKt.emptyList();
    L11:
        if ((r17 & 256) == 0) goto L13;
        b0 r7 = null;
    L15:
        return new z(r10, new d1(r11), new d1(r12), null, r5, r6, r7, r13);
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
