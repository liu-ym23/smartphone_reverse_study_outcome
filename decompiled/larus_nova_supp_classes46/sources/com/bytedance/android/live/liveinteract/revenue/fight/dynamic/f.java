package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public f(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        if (r3 != null) goto L5;
        return;
    L5:
        mi0.b r4 = (mi0.b) r3;
        i0 r5 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1(r4.b);
        li0.b r6 = li0.b.b;
        li0.b.g(r4.a, r4.b);
        this.a.d3(r4.a);
    }
}
