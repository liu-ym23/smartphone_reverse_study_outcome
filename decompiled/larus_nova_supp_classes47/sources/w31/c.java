package w31;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.j1;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.vm.g;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.scope.m;
import cy0.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final com.bytedance.android.livesdk.revenue.room.a a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public final String b() {
        e51.b r0 = e51.b.d;
        r0.getClass();
        if (((Boolean) e51.b.c.getValue(r0, e51.b.a[1])).booleanValue() == true) goto L5;
        com.bytedance.android.live.revlink.impl.pk.service.d r1 = h();
        if (r1 == null) goto L21;
        String r2 = r1.guestLinkMicId();
        if (r2 != null) goto L18;
        return "";
    L18:
        return r2;
    L21:
        return "";
    L5:
        if (n() == false) goto L20;
        com.bytedance.android.live.revlink.impl.pk.service.d r3 = h();
        if (r3 == null) goto L19;
        r2 = r3.guestLinkMicId();
        if (r2 != null) goto L18;
        return "";
    L19:
        return "";
    L20:
        return vh6.c.b(qr2.c.class).getGuestAnchorLinkMicId();
    }

    public final int d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        w r1 = null;
        if (r0 == null) goto L5;
        f r2 = r0.getLinkPlayHelper();
    L7:
        if (r2 != null) goto L9;
    L12:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.c;
        if (r3 == null) goto L15;
        r1 = r3.getMultiLinkUtil();
    L15:
        if (r1 == null) goto L21;
        if (r1.c() != true) goto L21;
        return IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInLinkMic.ordinal();
    L21:
        if (j() == null) goto L23;
        int r4 = n41.a.b();
    L24:
        if (r4 <= 0) goto L28;
        return IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInAudienceLinkMic.ordinal();
    L28:
        return IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusUnknown.ordinal();
    L23:
        r4 = 0;
        goto L24
    L9:
        if (r2.c() != true) goto L12;
        return IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInPK.ordinal();
    L5:
        r2 = null;
        goto L7
    }

    public final Map<String, String> f() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.room.a r1 = this.a;
        g r2 = null;
        String r3 = null;
        if (r1 == null) goto L5;
        IRoomBase r4 = r1.getCommonRoom();
    L6:
        IRoom r5 = (IRoom) r4;
        com.bytedance.android.live.revlink.impl.global.c r6 = this.c;
        if (r6 == null) goto L9;
        LinkCrossRoomDataHolder r7 = r6.getLinkCrossRoomDataHolder();
    L10:
        String r8 = "";
        if (r7 == null) goto L14;
        String r9 = String.valueOf(r7.c());
        if (r9 == null) goto L14;
    L15:
        r0.put("channel_id", r9);
        com.bytedance.android.live.revlink.impl.global.c r10 = this.c;
        if (r10 == null) goto L18;
        c r12 = r10.getPkLinkUtils();
    L19:
        if (r12 == null) goto L21;
        Long r13 = Long.valueOf(r12.i());
    L22:
        r0.put("pk_id", String.valueOf(r13));
        if (r5 == null) goto L25;
        LiveMode r14 = IRoomKtKt.getStreamType(r5);
    L26:
        r0.put("live_type", j1.a(r14));
        com.bytedance.android.live.revlink.impl.global.c r15 = this.c;
        if (r15 == null) goto L29;
        LinkCrossRoomDataHolder r16 = r15.getLinkCrossRoomDataHolder();
    L31:
        if (r16 == null) goto L33;
        String r17 = r16.l();
    L39:
        if (r17 != null) goto L41;
        r17 = "";
    L41:
        r0.put("request_id", r17);
        d31.d r18 = j();
        if (r18 == null) goto L44;
        String r19 = r18.f();
    L45:
        r0.put("invite_mode", r19);
        d31.d r20 = j();
        if (r20 == null) goto L49;
        String r22 = r20.a();
        if (r22 == null) goto L49;
    L50:
        r0.put("anchor_connect_status", r22);
        d31.d r23 = j();
        if (r23 == null) goto L53;
        String r24 = r23.s();
    L54:
        r0.put("room_status", r24);
        d31.d r25 = j();
        if (r25 == null) goto L57;
        String r26 = r25.c();
    L58:
        r0.put("connection_type", r26);
        d31.d r27 = j();
        if (r27 == null) goto L61;
        String r28 = r27.b();
    L62:
        r0.put("connection_sub_type", r28);
        com.bytedance.android.live.revlink.impl.global.c r29 = this.c;
        if (r29 == null) goto L65;
        f r30 = r29.getLinkPlayHelper();
    L66:
        if (r30 != null) goto L68;
    L84:
        d31.d r32 = j();
        if (r32 == null) goto L94;
        com.bytedance.android.live.revlink.impl.global.c r33 = this.c;
        if (r33 == null) goto L89;
        r2 = r33.getMultiAnchorLinkContextObj();
    L89:
        if (r2 == null) goto L91;
        int r34 = r2.b();
    L92:
        r3 = r32.p(r34);
        if (r3 == null) goto L94;
    L95:
        r0.put("invitee_list", r3);
        d31.d r35 = j();
        if (r35 == null) goto L98;
        String r36 = r35.g();
    L99:
        r0.put("is_oncemore", r36);
        d31.d r37 = j();
        if (r37 == null) goto L102;
        r8 = r37.o();
    L102:
        r0.put("is_manager", r8);
        return r0;
    L98:
        r36 = "";
        goto L99
    L91:
        r34 = 0;
    L94:
        r3 = "";
        goto L95
    L68:
        if (r30.f() != true) goto L84;
        com.bytedance.android.live.revlink.impl.global.c r38 = this.c;
        if (r38 == null) goto L72;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r39 = r38.el();
    L73:
        if (r39 == null) goto L94;
        com.bytedance.android.live.revlink.impl.global.c r40 = r39.a;
        if (r40 == null) goto L77;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r42 = r40.K8();
    L78:
        if (r42 == null) goto L94;
        int r43 = r42.getInviteType();
        d31.d r44 = j();
        if (r44 == null) goto L82;
        r3 = r44.p(r43);
    L82:
        if (r3 != null) goto L95;
    L77:
        r42 = null;
        goto L78
    L72:
        r39 = null;
        goto L73
    L65:
        r30 = null;
        goto L66
    L61:
        r28 = "";
        goto L62
    L57:
        r26 = "";
        goto L58
    L53:
        r24 = "";
    L49:
        r22 = "";
        goto L50
    L44:
        r19 = "";
        goto L45
    L33:
        mz0.e<?> r45 = mz0.d.b(LogCommon.ROOM);
        if (r45 == null) goto L38;
        Map<String, String> r46 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r45).getMap();
        if (r46 == null) goto L38;
        r17 = r46.get("request_id");
    L38:
        r17 = null;
        goto L39
    L29:
        r16 = null;
        goto L31
    L25:
        r14 = null;
        goto L26
    L21:
        r13 = null;
        goto L22
    L18:
        r12 = null;
    L14:
        r9 = "";
        goto L15
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final IPKLinkBizDataService g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    public final com.bytedance.android.live.revlink.impl.pk.service.d h() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o9();
    }

    public final long i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.Ig();
    L6:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.getPkId();
    L5:
        r1 = null;
        goto L6
    }

    public final d31.d j() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    public final String m() {
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        com.bytedance.android.livesdk.revenue.service.user.a r2 = (com.bytedance.live.kmp.core.c) r0;
        if (r2 == null) goto L7;
        IBaseUser r3 = r2.b();
        if (r3 == null) goto L7;
        String r4 = r3.getIdString();
    L8:
        IPKLinkBizDataService r5 = g();
        if (r5 != null) goto L11;
    L20:
        return "";
    L11:
        if (e() == false) goto L13;
        String r6 = r5.getTransformReason(c(), r4);
    L15:
        if (r6.length() <= 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        return r6;
    L17:
        r7 = false;
        goto L18
    L13:
        r6 = r5.getTransformReason(r4, c());
    L7:
        r4 = null;
        goto L8
    }

    public final boolean n() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getCommonIsAnchor();
    }

    public final boolean o() {
        int r0 = com.bytedance.android.live.utils.c.a;
        com.bytedance.android.live.revlink.impl.global.c r1 = this.c;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r1.Do();
    L6:
        if (r2 == null) goto L8;
        int r3 = r2.getCurrentMode();
    L10:
        return com.bytedance.android.live.utils.c.a(r3, 4);
    L8:
        r3 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final boolean p() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        com.bytedance.android.live.revenuelink.connect.g r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.g r2 = r0.getAnchorConnectUtils();
    L6:
        if (r2 == null) goto L24;
        LiveData<ey.f> r3 = r2.connectState();
        if (r3 == null) goto L24;
        ey.f r4 = (ey.f) r3.getValue();
        if (r4 == null) goto L24;
        if (d.a(r4) != true) goto L24;
        com.bytedance.android.live.revlink.impl.global.c r5 = this.c;
        if (r5 == null) goto L16;
        r1 = r5.getAnchorConnectUtils();
    L16:
        if (r1 == null) goto L24;
        LiveData<ey.f> r6 = r1.connectState();
        if (r6 == null) goto L24;
        ey.f r7 = (ey.f) r6.getValue();
        if (r7 == null) goto L24;
        if (r7.d != 1) goto L24;
        return true;
    L24:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final int a() {
        if (n() == false) goto L9;
        IPKLinkBizDataService r0 = g();
        if (r0 == null) goto L15;
        IPKLinkBizDataService.d r1 = r0.getLinkTypeParams();
        if (r1 == null) goto L15;
        return r1.c;
    L15:
        return 0;
    L9:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.c;
        if (r2 == null) goto L12;
        com.bytedance.android.live.revlink.impl.pk.service.f r3 = r2.Aa();
    L13:
        if (r3 == null) goto L15;
        return r3.duration();
    L12:
        r3 = null;
        goto L13
    }

    public final String c() {
        if (n() == false) goto L9;
        IPKLinkBizDataService r0 = g();
        if (r0 == null) goto L16;
        IPKLinkBizDataService.c r1 = r0.getGuestInfo();
        if (r1 != null) goto L18;
        return null;
    L18:
        return r1.b;
    L16:
        return null;
    L9:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.c;
        if (r2 == null) goto L12;
        com.bytedance.android.live.revlink.impl.pk.service.f r3 = r2.Aa();
    L13:
        if (r3 != null) goto L15;
        return null;
    L15:
        return r3.guestUserId();
    L12:
        r3 = null;
        goto L13
    }

    public final boolean e() {
        IPKLinkBizDataService r0 = g();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getIsStarter();
    }

    public final IRoom k() {
        IPKLinkBizDataService r0 = g();
        if (r0 == null) goto L7;
        IPKLinkBizDataService.c r1 = r0.getGuestInfo();
        if (r1 == null) goto L7;
        return r1.d;
    L7:
        return null;
    }

    public final String l() {
        if (n() == false) goto L11;
        IPKLinkBizDataService r0 = g();
        if (r0 == null) goto L18;
        IPKLinkBizDataService.d r1 = r0.getLinkTypeParams();
        if (r1 == null) goto L18;
        String r2 = r1.d;
        if (r2 == null) goto L18;
        return r2;
    L18:
        return "";
    L11:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.c;
        if (r3 == null) goto L14;
        com.bytedance.android.live.revlink.impl.pk.service.f r4 = r3.Aa();
    L15:
        if (r4 == null) goto L18;
        String r5 = r4.theme();
        if (r5 == null) goto L18;
        return r5;
    L14:
        r4 = null;
        goto L15
    }

    public final boolean q() {
        IPKLinkBizDataService r0 = g();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getIsSwitchFromLink();
    }

    public final String r() {
        IPKLinkBizDataService r0 = g();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getIsSwitchGameFromLink();
    }

    public c(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.b = r1;
        this.c = r2;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r3 = r1.getRoomContext();
    L6:
        this.a = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }
}
