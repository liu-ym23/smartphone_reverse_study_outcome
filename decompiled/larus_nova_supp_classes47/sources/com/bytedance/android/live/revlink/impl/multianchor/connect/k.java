package com.bytedance.android.live.revlink.impl.multianchor.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revenuelink.connect.ConnectAutoRejectType;
import com.bytedance.android.live.revenuelink.connect.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements q {
    public final ld.a a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public k(ld.a r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.q
    public final int a(i6 r14, ey.f r15) {
        Intrinsics.checkNotNullParameter(r14, "_linkerMessage");
        i6 r16 = (i6) r14.castTo(i6.class);
        if (((int) i1.b(r16)) == 7) goto L5;
        return 0;
    L5:
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        PkReserveBattleDataContext.b r1 = null;
        if (r0 == null) goto L8;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r0.Do();
    L10:
        if (r2 != null) goto L12;
    L33:
        boolean r3 = false;
    L34:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.b;
        if (r5 == null) goto L37;
        v r6 = r5.getMultiLinkMonitor();
    L38:
        if (r6 == null) goto L69;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.b;
        if (r7 == null) goto L42;
        w r8 = r7.getMultiLinkUtil();
    L43:
        if (r8 != null) goto L45;
    L47:
        boolean r9 = false;
    L48:
        LinkedHashMap r10 = new LinkedHashMap();
        ld.a r12 = r6.b;
        if (r12 == null) goto L54;
        NextLiveData r13 = r12.Fc();
        if (r13 == null) goto L54;
        Boolean r17 = (Boolean) r13.getValue();
        if (r17 == null) goto L54;
    L55:
        boolean r18 = r17.booleanValue();
        ld.a r19 = r6.b;
        if (r19 == null) goto L61;
        NextLiveData r20 = r19.z9();
        if (r20 == null) goto L61;
        Boolean r22 = (Boolean) r20.getValue();
        if (r22 == null) goto L61;
    L62:
        boolean r23 = r22.booleanValue();
        int r110 = n41.a.b();
        if (r9 == false) goto L69;
        if (r110 <= 0) goto L67;
        boolean r111 = true;
    L68:
        r10.put("error_msg", "rtc=" + r9 + ",pkUserCnt=" + r111);
        r10.put("self_has_audience_join", Boolean.valueOf(r18));
        r10.put("guest_has_audience_join", Boolean.valueOf(r23));
        r10.put("pk_user_with_audience", Boolean.valueOf(r111));
        r6.b(r10);
        r6.H("check_pk_with_audience_condition", r10);
        goto L69
    L67:
        r111 = false;
    L61:
        r22 = Boolean.FALSE;
    L54:
        r17 = Boolean.FALSE;
        goto L55
    L45:
        if (r8.g() != true) goto L47;
        r9 = true;
        goto L48
    L42:
        r8 = null;
    L69:
        if (r3 == false) goto L73;
        b(ConnectAutoRejectType.IS_LINK_WITH_AUDIENCE, r16);
        return 4;
    L73:
        if (com.bytedance.android.live.revenuelink.connect.b.a(r16) == true) goto L75;
        if (r15 == null) goto L123;
        long r24 = r15.a;
        if (r24 == 0) goto L123;
        Intrinsics.checkNotNullParameter(r16, "$this$linkerIdExt");
        if (r24 != r16.getLinkerId()) goto L123;
        com.bytedance.android.live.revlink.impl.global.c r112 = this.b;
        if (r112 == null) goto L111;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r113 = r112.u5();
    L112:
        if (r113 == null) goto L114;
        String r114 = r113.ij();
    L115:
        g1 r4 = r16.getInvite();
        if (r4 == null) goto L118;
        g1 r25 = r4;
        Intrinsics.checkNotNullParameter(r25, "$this$fromUid");
        String r26 = r25.get_fromUid();
    L120:
        if ((!Intrinsics.areEqual(r114, r26)) == false) goto L123;
        b(ConnectAutoRejectType.CHANNEL_ID_SAME, r16);
        return 4;
    L118:
        r26 = null;
        goto L120
    L114:
        r114 = null;
        goto L115
    L111:
        r113 = null;
    L123:
        com.bytedance.android.live.revlink.impl.global.c r115 = this.b;
        if (r115 == null) goto L131;
        com.bytedance.android.live.revlink.impl.pk.service.g r116 = r115.jo();
        if (r116 == null) goto L131;
        LiveData<PkReserveBattleDataContext.b> r117 = r116.getBattleReserveState();
        if (r117 == null) goto L131;
        r1 = (PkReserveBattleDataContext.b) r117.getValue();
    L131:
        if (Intrinsics.areEqual(r1, PkReserveBattleDataContext.b.C0178b.a) == false) goto L135;
        b51.b r118 = b51.b.c0;
        r118.getClass();
        if (((Boolean) b51.b.g.getValue(r118, b51.b.a[5])).booleanValue() == false) goto L135;
        return 4;
    L135:
        return 0;
    L75:
        if (r15 != null) goto L77;
    L101:
        b(ConnectAutoRejectType.MULTI_INVITE_NOT_LINKING, r16);
        return 3;
    L77:
        if (r15.d != 4) goto L101;
        com.bytedance.android.live.revlink.impl.global.c r119 = this.b;
        if (r119 == null) goto L82;
        w r120 = r119.getMultiLinkUtil();
    L84:
        if (r120 != null) goto L86;
    L89:
        com.bytedance.android.live.revlink.impl.global.c r121 = this.b;
        if (r121 == null) goto L92;
        w r122 = r121.getMultiLinkUtil();
    L93:
        if (r122 == null) goto L95;
        int r123 = r122.h();
    L96:
        if (r123 < 3) goto L123;
        if (r41.f.a == true) goto L123;
        b(ConnectAutoRejectType.MULTI_INVITE_LINK_ANCHOR_CNT, r16);
        return 9;
    L95:
        r123 = 0;
        goto L96
    L92:
        r122 = null;
        goto L93
    L86:
        if (r120.g() != true) goto L89;
        b(ConnectAutoRejectType.MULTI_INVITE_PK_WITH_AUDIENCE, r16);
        return 9;
    L82:
        r120 = null;
        goto L84
    L37:
        r6 = null;
        goto L38
    L12:
        if (r2.k0(4) != true) goto L33;
        com.bytedance.android.live.revlink.impl.global.c r27 = this.b;
        if (r27 == null) goto L16;
        AnchorLinkOptUtils r28 = r27.vk();
    L17:
        if (r28 == null) goto L33;
        if (r28.c() == true) goto L21;
    L23:
        boolean r29 = false;
    L24:
        if (r29 != true) goto L33;
        com.bytedance.android.live.revlink.impl.global.c r30 = this.b;
        if (r30 == null) goto L28;
        w r32 = r30.getMultiLinkUtil();
    L29:
        if (r32 == null) goto L33;
        if (r32.g() != true) goto L33;
        r3 = true;
        goto L34
    L28:
        r32 = null;
        goto L29
    L21:
        if (r28.b().t3() == false) goto L23;
        r29 = true;
        goto L24
    L16:
        r28 = null;
        goto L17
    L8:
        r2 = null;
        goto L10
    }

    public final void b(ConnectAutoRejectType r13, i6 r14) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        com.bytedance.android.live.revenuelink.connect.k r1 = null;
        if (r0 == null) goto L5;
        d31.f r2 = r0.y2();
    L6:
        if (r2 == null) goto L8;
        int r4 = r13.ordinal();
        String r5 = r13.name();
        Intrinsics.checkNotNullParameter(r14, "$this$sceneExt");
        d31.f.f(r2, "connect_auto_reject_invite", r4, r5, (int) r14.getScene(), 0, null, null, null, 240);
    L8:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.b;
        if (r3 == null) goto L11;
        r1 = r3.z0();
    L11:
        if (r1 == null) goto L14;
        r1.c(r13, r14);
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
