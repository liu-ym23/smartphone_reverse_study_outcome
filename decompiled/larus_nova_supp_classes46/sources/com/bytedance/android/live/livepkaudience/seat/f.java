package com.bytedance.android.live.livepkaudience.seat;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final Map<String, PkSeatAnimationView> a;

    public f() {
        this.a = new LinkedHashMap();
    }

    public final void a(c r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Map<String, PkSeatAnimationView> r1 = this.a;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        PkSeatAnimationView r3 = (PkSeatAnimationView) r2.get(r4.a.a.getIdString());
        if (r3 == null) goto L5;
        SeatAnimTaskState r5 = r3.getTaskState();
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5 != SeatAnimTaskState.LINK_SUC_ANIM) goto L10;
        return;
    L10:
        if (r5 == SeatAnimTaskState.GUEST_BATTLE_ANIM) goto L22;
        Map<String, PkSeatAnimationView> r6 = this.a;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        PkSeatAnimationView r8 = (PkSeatAnimationView) r7.get(r4.a.a.getIdString());
        if (r8 == null) goto L20;
        Intrinsics.checkNotNullParameter(r4, "event");
        g r9 = r8.a;
        if (r9 == null) goto L21;
        Intrinsics.checkNotNullParameter(r4, "event");
        r9.b.a(r4);
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
