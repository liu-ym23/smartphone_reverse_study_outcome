package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.livead.GroupPurchaseItem;
import com.bytedance.android.livehostapi.business.depend.livead.IGroupPurchaseItemCallback;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d3 implements IGroupPurchaseItemCallback {
    public final /* synthetic */ ToolbarGroupPurchaseAudienceBehavior a;

    public d3(ToolbarGroupPurchaseAudienceBehavior r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r2) {
        if (r2 == null) goto L4;
        r2.printStackTrace();
    L4:
        if (r2 == null) goto L6;
        String r3 = r2.getMessage();
    L8:
        if (Intrinsics.areEqual(r3, "empty data") == false) goto L11;
        ToolbarGroupPurchaseAudienceBehavior.a(this.a, 4);
        return;
    L11:
        return;
    L6:
        r3 = null;
        goto L8
    }

    public final void onSuccess(GroupPurchaseItem r10) {
        ToolbarGroupPurchaseAudienceBehavior r0 = this.a;
        r0.d = r10;
        boolean r11 = r0.g();
        int r1 = 2;
        boolean r2 = false;
        List r4 = null;
        if (r11 == false) goto L50;
        GroupPurchaseItem r12 = this.a.d;
        if (r12 == null) goto L7;
        UrlModel r13 = r12.getDynamicIconUrl();
    L8:
        if (r13 == null) goto L50;
        GroupPurchaseItem r14 = this.a.d;
        if (r14 == null) goto L14;
        UrlModel r15 = r14.getDynamicIconUrl();
        if (r15 == null) goto L14;
        List r16 = r15.getUrlList();
    L15:
        List r17 = r16;
        if (r17 != null) goto L18;
    L21:
        boolean r18 = true;
    L22:
        if (r18 == true) goto L50;
        ToolbarGroupPurchaseAudienceBehavior r19 = this.a;
        if (r19.h == true) goto L77;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, r19.a, 0, 2);
        if (r3 == null) goto L32;
        com.bytedance.live.datacontext.j r5 = r3.getCompactTbLoader();
        if (r5 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r6 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r5.getValue();
    L34:
        if ((r6 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == true) goto L36;
        r6 = null;
    L36:
        if (r6 != null) goto L38;
    L40:
        if (r2 == true) goto L42;
        r19.e(true);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r19.a).c(ToolbarButton.GROUP_PURCHASE_AUDIENCE.extended());
        r19.h();
        return;
    L42:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("error_code", String.valueOf(5));
        IHostLiveLocalLife r8 = r19.d();
        if (r8 == null) goto L75;
        DataCenter r110 = r19.a;
        if (r110 == null) goto L48;
        String r111 = com.bytedance.android.live.core.utils.z.d(r110, null);
        if (r111 == null) goto L48;
    L49:
        r8.sendLog(r111, "live_life_icon_show_error", r7);
        return;
    L48:
        r111 = "";
        goto L49
    L75:
        return;
    L38:
        if (r6.isComponentShowing(7) != true) goto L40;
        r2 = true;
    L32:
        r6 = null;
        goto L34
    L77:
        return;
    L18:
        if (r17.isEmpty() == true) goto L21;
        r18 = false;
    L14:
        r16 = null;
        goto L15
    L7:
        r13 = null;
    L50:
        ToolbarGroupPurchaseAudienceBehavior r112 = this.a;
        if (r112.g() == false) goto L72;
        GroupPurchaseItem r9 = r112.d;
        if (r9 == null) goto L56;
        UrlModel r20 = r9.getDynamicIconUrl();
    L57:
        if (r20 == null) goto L71;
        GroupPurchaseItem r21 = r112.d;
        if (r21 == null) goto L63;
        UrlModel r22 = r21.getDynamicIconUrl();
        if (r22 == null) goto L63;
        r4 = r22.getUrlList();
    L63:
        List r23 = r4;
        if (r23 != null) goto L66;
    L67:
        r2 = true;
    L68:
        if (r2 == true) goto L71;
        r1 = -1;
        goto L72
    L66:
        if (r23.isEmpty() == false) goto L68;
    L71:
        r1 = 5;
        goto L72
    L56:
        r20 = null;
    L72:
        ToolbarGroupPurchaseAudienceBehavior.a(r112, r1);
    }
}
