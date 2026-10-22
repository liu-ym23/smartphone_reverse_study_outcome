package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e3 extends com.bytedance.android.livesdk.chatroom.ui.u5 {
    public final /* synthetic */ ToolbarGroupPurchaseAudienceBehavior d;

    public e3(ToolbarGroupPurchaseAudienceBehavior r1) {
        this.d = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.u5
    public final void a(View r10) {
        ToolbarGroupPurchaseAudienceBehavior r11 = this.d;
        int r0 = ToolbarGroupPurchaseAudienceBehavior.p;
        r11.getClass();
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("program_type", "little_windmill");
        r12.put("source", "bottom_toolbar");
        ToolbarGroupPurchaseAudienceBehavior.j(r12, new String[]{"enter_from_merge", "enter_method"});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_small_program_audience_icon_click", r12, new Object[]{Room.class});
        ILivePreviewBusinessBridge r13 = this.d.i;
        if (r13 == null) goto L7;
        ILivePreviewBusinessSession r14 = r13.getSession();
        if (r14 == null) goto L7;
        ILiveEnterRoomScene r15 = r14.getScene();
    L9:
        if (Intrinsics.areEqual(r15, ILiveEnterRoomScene.PreviewToolbar.INSTANCE) == false) goto L21;
        HashMap r16 = new HashMap();
        r16.put("module_name", "local_service");
        ILivePreviewBusinessBridge r1 = this.d.i;
        if (r1 == null) goto L13;
        r1.sendLogger("livesdk_preview_guide_click", r16);
    L13:
        HashMap r17 = new HashMap();
        r17.put("icon_type", "house");
        r17.put("event_page", "live_window_interact_area");
        ILivePreviewBusinessBridge r2 = this.d.i;
        if (r2 == null) goto L16;
        r2.sendLogger("livesdk_toolbar_icon_click", r17);
    L16:
        ToolbarGroupPurchaseAudienceBehavior r18 = this.d;
        ToolbarGroupPurchaseAudienceBehavior.d r3 = r18.j;
        if (r3 == null) goto L60;
        ILivePreviewBusinessBridge r19 = r18.i;
        if (r19 == null) goto L60;
        r19.enterRoom(r3);
    L60:
        IHostLiveLocalLife r110 = this.d.d();
        if (r110 == null) goto L69;
        IHostLiveLocalLife.-CC.log$default(r110, "icon_click", null, 2, null);
        return;
    L69:
        return;
    L21:
        com.bytedance.android.livesdk.chatroom.utils.o1 r111 = com.bytedance.android.livesdk.chatroom.utils.o1.d();
        DataCenter r4 = this.d.a;
        ExtendedToolbarButton r5 = ToolbarButton.GROUP_PURCHASE_AUDIENCE.extended();
        r111.getClass();
        if (r5 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r112 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r4);
        if (r112.l == true) goto L27;
        com.bytedance.android.livesdk.chatroom.utils.o1.g("livesdk_toolbar_icon_click", r5, r112.v(r5));
    L27:
        com.bytedance.android.livesdk.chatroom.utils.o1 r113 = com.bytedance.android.livesdk.chatroom.utils.o1.d();
        ToolbarGroupPurchaseAudienceBehavior r6 = this.d;
        DataCenter r7 = r6.a;
        RoomContext r8 = r6.b;
        if (r8 == null) goto L44;
        com.bytedance.live.datacontext.n r9 = r8.getCurToolbarList();
        if (r9 == null) goto L44;
        List r20 = (List) r9.getValue();
        if (r20 == null) goto L44;
        Iterator r21 = r20.iterator();
    L35:
        if (r21.hasNext() == false) goto L42;
        Object r22 = r21.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) r22).a != 7) goto L39;
        boolean r23 = true;
    L40:
        if (r23 == false) goto L35;
    L43:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r24 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) r22;
    L45:
        r113.getClass();
        com.bytedance.android.livesdk.chatroom.utils.o1.f(r7, "livesdk_toolbar_icon_click", 7, r24);
        Room r114 = this.d.c;
        if (r114 == null) goto L48;
        String r115 = r114.getOwnerUserIdString();
    L49:
        IUserService r25 = jc1.k.f(IUserService.class);
        if (r25 == null) goto L54;
        com.bytedance.android.livesdk.user.f r26 = r25.user();
        if (r26 == null) goto L54;
        String r27 = r26.n();
    L55:
        if (r115 != null) goto L57;
    L59:
        this.d.i(false, null, null);
        goto L60
    L57:
        if (r115.equals(r27) != true) goto L59;
        ToolbarGroupPurchaseAudienceBehavior.b(this.d);
    L54:
        r27 = null;
        goto L55
    L48:
        r115 = null;
        goto L49
    L39:
        r23 = false;
        goto L40
    L42:
        r22 = null;
    L44:
        r24 = null;
    L7:
        r15 = null;
        goto L9
    }
}
