package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ne0.a {
    public final /* synthetic */ DynamicLinkRoomFightWidget a;

    public e(DynamicLinkRoomFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "store");
        if (r5 != null) goto L5;
        return;
    L5:
        bj0.c r6 = (bj0.c) r5;
        JsonObject r7 = new JsonObject();
        r7.addProperty("type", "open_icon_click");
        JsonObject r0 = new JsonObject();
        r0.addProperty("request_page", r6.a);
        r0.addProperty("source", r6.b);
        r7.add("extra", r0);
        DynamicLinkRoomFightWidget r8 = this.a;
        int r1 = DynamicLinkRoomFightWidget.h;
        r8.xq("playmode_action", r7);
    }
}
