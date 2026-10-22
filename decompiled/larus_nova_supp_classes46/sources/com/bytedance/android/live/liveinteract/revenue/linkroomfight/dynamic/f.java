package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements ne0.a {
    public f() {
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        if (r3 == null) goto L7;
        LinkRoomFightContext.Companion.getClass();
        LinkRoomFightContext.a.b((ti6.f) r3, false);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.livelink.kmp.api.core.mixer.MixRegion");
    }
}
