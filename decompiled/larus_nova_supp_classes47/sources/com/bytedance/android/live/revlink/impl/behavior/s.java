package com.bytedance.android.live.revlink.impl.behavior;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.BubbleOpenLocalPanel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ ToolbarPkBehavior a;
    public final /* synthetic */ yo2.d b;
    public final /* synthetic */ zr2.e c;

    public s(ToolbarPkBehavior r1, yo2.e r2, zr2.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        ToolbarPkBehavior r12 = this.a;
        yo2.d r0 = this.b;
        r12.getClass();
        if (r0 == null) goto L5;
        r0.d();
    L5:
        ToolbarPkBehavior r13 = this.a;
        zr2.e r1 = this.c;
        r13.getClass();
        BubbleOpenLocalPanel r2 = r1.k;
        if (r2 != null) goto L8;
        String r3 = r1.c;
        if (TextUtils.isEmpty(r3) == false) goto L20;
    L23:
        HashMap r4 = new HashMap();
        r4.put("location_from", "pk_icon");
        r4.put("bubble_info", "activity");
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L26;
        Long r6 = Long.valueOf(r5.c());
    L27:
        r4.put("channel_id", String.valueOf(r6));
        d31.d r7 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r8 = "";
        if (r7 == null) goto L31;
        String r9 = r7.a();
        if (r9 == null) goto L31;
    L32:
        r4.put("anchor_connect_status", r9);
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L35;
        String r15 = r14.o();
    L36:
        r4.put("is_manager", r15);
        r4.put("to_user_group", "entertainment_less_pk");
        r4.put("message_type", "link_msg_guide");
        int r16 = r1.h;
        if (r16 != 12) goto L39;
    L42:
        r4.put("message_type", "to_cohost_game");
        r4.put("to_user_group", "cohost_game_fitted");
        Map r17 = r1.i;
        if (r17 == null) goto L47;
        Intrinsics.checkNotNull(r17);
        if (r17.containsKey("open_game_app_id") == false) goto L47;
        Map r18 = r1.i;
        Intrinsics.checkNotNull(r18);
        String r19 = (String) r18.get("open_game_app_id");
    L49:
        if (TextUtils.isEmpty(r19) == true) goto L55;
        if (r19 == null) goto L53;
        r8 = r19;
    L53:
        r4.put("open_game_app_id", r8);
    L55:
        if (r13.e == false) goto L57;
        String r110 = DataType.TRUE;
    L58:
        r4.put("is_anchor", r110);
        Map r111 = r1.i;
        if (r111 == null) goto L61;
        r4.putAll(r111);
    L61:
        mz0.n r112 = new mz0.n();
        Map<String, String> r20 = r112.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r20.putAll(r4);
        mz0.m r22 = new mz0.m();
        r22.b(LogCommon.ROOM);
        List<Object> r23 = r112.b;
        ArrayList r24 = (ArrayList) r23;
        r24.addAll(r22.a);
        cy0.e.a.getClass();
        cy0.j r25 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r26 = com.bytedance.android.scope.m.b(r25).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r26);
        ((mz0.i) ((f80.a) r26)).w3("livesdk_room_bubble_click", r112.a, r112.b);
        return;
    L57:
        r110 = DataType.FALSE;
    L47:
        r19 = "";
        goto L49
    L39:
        if (r16 == 13) goto L42;
        r4.put("to_user_group", "entertainment_less_pk");
        r4.put("message_type", "link_msg_guide");
        goto L55
    L35:
        r15 = "";
    L31:
        r9 = "";
        goto L32
    L26:
        r6 = null;
        goto L27
    L20:
        if (r13.d == null) goto L23;
        if (r3 == null) goto L23;
        pq2.a r27 = com.bytedance.android.live.revenue.core.util.e.a(pq2.a.class);
        Context r28 = r13.d;
        Intrinsics.checkNotNull(r28);
        r27.handleSchema(r28, r3);
        goto L23
    L8:
        if (r2 != BubbleOpenLocalPanel.PkPanel) goto L13;
        if (r13.y == null) goto L13;
        pq2.a r29 = com.bytedance.android.live.revenue.core.util.e.a(pq2.a.class);
        Context r30 = r13.d;
        Intrinsics.checkNotNull(r30);
        r29.handleSchema(r30, "sslocal://webcast_open_pk_panel");
        r13.x.a();
    L13:
        if (r2 == BubbleOpenLocalPanel.LinkPanel) goto L15;
        return;
    L15:
        if (r13.y == null) goto L64;
        pq2.a r32 = com.bytedance.android.live.revenue.core.util.e.a(pq2.a.class);
        Context r33 = r13.d;
        Intrinsics.checkNotNull(r33);
        r32.handleSchema(r33, "sslocal://webcast_open_pk_panel?tab_type=1");
        r13.x.a();
        return;
    }
}
