package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ne0.a {
    public final /* synthetic */ DynamicLinkRoomFightWidget a;

    public c(DynamicLinkRoomFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "store");
        ne0.c r3 = this.a.getStore();
        if (r3 == null) goto L6;
        r3.onDestory();
        return;
    }
}
