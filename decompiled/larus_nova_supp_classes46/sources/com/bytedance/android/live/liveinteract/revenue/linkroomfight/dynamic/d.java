package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements ne0.a {
    public final /* synthetic */ DynamicLinkRoomFightWidget a;

    public d(DynamicLinkRoomFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "store");
        if (r9 != null) goto L5;
        return;
    L5:
        String r0 = null;
        if ((r9 instanceof Map) == true) goto L8;
        r9 = null;
    L8:
        Map r10 = (Map) r9;
        JsonObject r11 = new JsonObject();
        r11.addProperty("type", "open_icon_click");
        JsonObject r1 = new JsonObject();
        if (r10 == null) goto L11;
        String r3 = (String) r10.get("request_page");
    L12:
        r1.addProperty("request_page", r3);
        if (r10 == null) goto L15;
        String r4 = (String) r10.get("request_source");
    L16:
        r1.addProperty("request_source", r4);
        if (r10 == null) goto L19;
        String r5 = (String) r10.get("match_type");
    L20:
        r1.addProperty("match_type", r5);
        JsonObject r6 = new JsonObject();
        if (r10 == null) goto L23;
        String r7 = (String) r10.get("request_page");
    L24:
        r6.addProperty("request_page", r7);
        if (r10 == null) goto L27;
        String r2 = (String) r10.get("request_source");
    L28:
        r6.addProperty("request_source", r2);
        if (r10 == null) goto L31;
        r0 = (String) r10.get("match_type");
    L31:
        r6.addProperty("match_type", r0);
        r1.add("params", r6);
        r11.add("extra", r1);
        DynamicLinkRoomFightWidget r12 = this.a;
        int r13 = DynamicLinkRoomFightWidget.h;
        r12.xq("playmode_action", r11);
        return;
    L27:
        r2 = null;
        goto L28
    L23:
        r7 = null;
        goto L24
    L19:
        r5 = null;
        goto L20
    L15:
        r4 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    }
}
