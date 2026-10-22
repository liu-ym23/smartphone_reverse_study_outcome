package com.bytedance.android.live.revlink.impl.intercomment;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public long a;
    public final int b;

    public e(int r1) {
        this.b = r1;
    }

    public final void a(Map<String, String> r9) {
        IRoomEx r3 = null;
        Object r4 = null;
        r3 = null;
        if (this.b == 1) goto L36;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r0 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r0 == null) goto L35;
        i11.b r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L35;
        List<com.bytedance.android.livesdk.link.model.p> r2 = r1.getOnlineUserList();
        if (r2 == null) goto L35;
        Iterator<T> r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        IBaseUser r7 = ((com.bytedance.android.livesdk.link.model.p) r6).getUser();
        if (r7 == null) goto L16;
        String r8 = r7.getIdString();
    L18:
        if ((!Intrinsics.areEqual(r8, u.e())) == false) goto L12;
        r4 = r6;
        goto L20
    L16:
        r8 = null;
    L20:
        com.bytedance.android.livesdk.link.model.p r10 = (com.bytedance.android.livesdk.link.model.p) r4;
        if (r10 == null) goto L35;
        IBaseUser r12 = r10.getUser();
        String r13 = "";
        if (r12 == null) goto L27;
        String r14 = iz.a.a(r12);
        if (r14 == null) goto L27;
    L28:
        HashMap r15 = (HashMap) r9;
        r15.put("other_anchor_id", r14);
        IBaseUser r16 = r10.getUser();
        if (r16 == null) goto L34;
        String r17 = String.valueOf(r16.getLiveRoomId());
        if (r17 == null) goto L34;
        r13 = r17;
    L34:
        r15.put("other_room_id", r13);
    L27:
        r14 = "";
    L35:
        ((HashMap) r9).put("is_media_room", DataType.FALSE);
        return;
    L36:
        w31.c r18 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r18 != null) goto L39;
    L45:
        w31.c r19 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r19 == null) goto L62;
        IPKLinkBizDataService r20 = r19.g();
        if (r20 == null) goto L52;
        IPKLinkBizDataService.c r22 = r20.getGuestInfo();
        if (r22 == null) goto L52;
        r3 = r22.d;
    L52:
        if (r3 == null) goto L63;
        HashMap r23 = (HashMap) r9;
        r23.put("other_anchor_id", String.valueOf(iz.a.a(r3.getOwner())));
        r23.put("other_room_id", String.valueOf(r3.getRoomId()));
        return;
    L63:
        return;
    L62:
        return;
    L39:
        if (r18.e() != true) goto L45;
        w31.c r24 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r24 == null) goto L59;
        IRoom r25 = r24.k();
        if (r25 == null) goto L60;
        HashMap r26 = (HashMap) r9;
        r26.put("other_anchor_id", String.valueOf(iz.a.a(r25.getOwner())));
        r26.put("other_room_id", String.valueOf(r25.getRoomId()));
        return;
    L60:
        return;
    }

    public final void c(boolean r4) {
        HashMap r0 = new HashMap();
        if (r4 == false) goto L5;
        String r5 = "host";
    L6:
        r0.put("anchor_type", r5);
        a(r0);
        mz0.n r6 = new mz0.n();
        Map<String, String> r1 = r6.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r1.putAll(r0);
        mz0.m r2 = new mz0.m();
        r2.b(LogCommon.ROOM);
        List<Object> r3 = r6.b;
        ArrayList r7 = (ArrayList) r3;
        r7.addAll(r2.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((mz0.i) ((f80.a) r9)).w3("livesdk_comment_interflow_introduction_click", r6.a, r6.b);
        return;
    L5:
        r5 = "guest";
        goto L6
    }

    public final void b(int r7, boolean r8) {
        HashMap r0 = new HashMap();
        if (this.b != 1) goto L5;
        String r1 = "pk";
    L6:
        r0.put("connection_scene", r1);
        LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
        Long r3 = null;
        if (r2 == null) goto L9;
        Long r4 = Long.valueOf(r2.c());
    L10:
        r0.put("channel_id", String.valueOf(r4));
        if (this.b != 17) goto L13;
        boolean r5 = ((Boolean) l51.a.K.getValue(null, l51.a.a[37])).booleanValue();
    L14:
        w31.c r6 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r6 == null) goto L17;
        r3 = Long.valueOf(r6.i());
    L17:
        r0.put("pk_id", String.valueOf(r3));
        String r9 = DataType.TRUE;
        if (r5 == false) goto L20;
        Object r10 = DataType.TRUE;
    L21:
        r0.put("is_remind_panel_show", r10);
        if (r7 == 4) goto L27;
        if (r7 != 1) goto L26;
        r9 = "2";
        goto L27
    L26:
        r9 = DataType.FALSE;
    L27:
        r0.put("is_interflowing", r9);
        a(r0);
        if (r8 == false) goto L30;
        String r12 = "livesdk_comment_interflow_icon_click";
    L31:
        mz0.n r13 = new mz0.n();
        Map<String, String> r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r14.putAll(r0);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        r15.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r13.b).addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3(r12, r13.a, r13.b);
        return;
    L30:
        r12 = "livesdk_comment_interflow_icon_click_audience";
        goto L31
    L20:
        r10 = DataType.FALSE;
        goto L21
    L13:
        r5 = l51.a.n();
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = "connection";
        goto L6
    }

    public final void d(boolean r6, boolean r7) {
        HashMap r0 = new HashMap();
        if (this.b != 1) goto L5;
        String r1 = "pk";
    L6:
        r0.put("connection_scene", r1);
        LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
        Long r3 = null;
        if (r2 == null) goto L9;
        Long r4 = Long.valueOf(r2.c());
    L10:
        r0.put("channel_id", String.valueOf(r4));
        w31.c r5 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r5 == null) goto L13;
        r3 = Long.valueOf(r5.i());
    L13:
        r0.put("pk_id", String.valueOf(r3));
        String r8 = DataType.TRUE;
        if (r6 == false) goto L16;
        Object r9 = DataType.TRUE;
    L17:
        r0.put("is_remind_panel_show", r9);
        if (r6 == true) goto L20;
        r8 = "2";
    L23:
        r0.put("is_no_more_remind_panel", r8);
        a(r0);
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r12.putAll(r0);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.ROOM);
        ((ArrayList) r10.b).addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_comment_interflow_invite", r10.a, r10.b);
        return;
    L20:
        if (r7 == true) goto L23;
        r8 = DataType.FALSE;
        goto L23
    L16:
        r9 = DataType.FALSE;
        goto L17
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = "connection";
        goto L6
    }
}
