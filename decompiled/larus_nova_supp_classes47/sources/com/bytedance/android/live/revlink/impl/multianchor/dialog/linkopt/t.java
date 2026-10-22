package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorRandomView;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public t(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        List r12 = (List) r10;
        if (this.a.isViewValid() == false) goto L105;
        StringBuilder r0 = new StringBuilder("linkingInvitePanel listDataModel updated ");
        Integer r1 = null;
        if (r12 == null) goto L8;
        Integer r2 = Integer.valueOf(r12.size());
    L9:
        r0.append(r2);
        jy0.b.f("ttlive_anchor_link_panel", r0.toString(), null, 4);
        if (this.a.S90(2131392080).e == false) goto L12;
        this.a.p.postDelayed(new s(this), 300);
    L12:
        ArrayList r3 = new ArrayList();
        if (r12 == null) goto L16;
        r3.addAll(r12);
    L16:
        if (r3.isEmpty() == false) goto L18;
        ((PkItemExposeRecyclerView) this.a.S90(2131384076)).setVisibility(8);
        ((LinearLayout) this.a.S90(2131390556)).setVisibility(0);
    L19:
        MultiTypeAdapter r13 = this.a.n;
        if (r13 == null) goto L22;
        r13.a = r3;
    L22:
        if (r13 == null) goto L24;
        r13.notifyDataSetChanged();
    L24:
        View r14 = this.a.h;
        if (r14 == null) goto L27;
        r14.setVisibility(4);
    L27:
        View r15 = this.a.i;
        if (r15 == null) goto L30;
        r15.setVisibility(8);
    L30:
        Toolbar r16 = this.a.S90(2131385286);
        if (r16 == null) goto L34;
        r16.setVisibility(0);
    L34:
        if (this.a.U90().getRandomMatchDataModel().getValue() == null) goto L39;
        ConstraintLayout r17 = (MultiAnchorRandomView) this.a.S90(2131362584);
        if (r17 == null) goto L39;
        r17.setVisibility(0);
    L39:
        if (this.a.r == true) goto L41;
    L45:
        MultiAnchorLinkUserInviteDialog r18 = this.a;
        if (r18.v == true) goto L100;
        r18.v = true;
        HashMap r4 = new HashMap();
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L51;
        Long r6 = Long.valueOf(r5.c());
    L52:
        r4.put("channel_id", String.valueOf(r6));
        w31.c r7 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r7 == null) goto L55;
        Long r8 = Long.valueOf(r7.i());
    L56:
        r4.put("pk_id", String.valueOf(r8));
        if (r18.U90().getCurrentScene() != 1) goto L59;
        r1 = 2;
    L64:
        r4.put("anchor_connect_status", String.valueOf(r1));
        d31.d r9 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r19 = "";
        if (r9 == null) goto L67;
        String r20 = r9.c();
    L68:
        r4.put("connection_type", r20);
        d31.d r22 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r22 == null) goto L71;
        String r23 = r22.b();
    L72:
        r4.put("connection_sub_type", r23);
        e r24 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r24 == null) goto L76;
        String r25 = r24.a;
        if (r25 == null) goto L76;
    L77:
        r4.put("source", r25);
        d31.d r26 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r26 == null) goto L80;
        String r27 = r26.f();
    L81:
        r4.put("invite_mode", r27);
        d31.d r28 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r28 == null) goto L84;
        String r29 = r28.d();
    L85:
        r4.put("battle_mode", r29);
        r4.put("enter_button", "find");
        d31.d r30 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r30 == null) goto L88;
        r19 = r30.s();
    L88:
        r4.put("room_status", r19);
        com.bytedance.android.live.revlink.impl.pk.utils.i r32 = r18.U90().getListExtraInfo();
        if (r32 == null) goto L91;
        int r33 = r32.a;
    L92:
        r4.put("friends_cnt", String.valueOf(r33));
        com.bytedance.android.live.revlink.impl.pk.utils.i r110 = r18.U90().getListExtraInfo();
        if (r110 == null) goto L95;
        int r111 = r110.b;
    L96:
        r4.put("total_friends_num", String.valueOf(r111));
        mz0.n r112 = new mz0.n();
        Map<String, String> r34 = r112.a;
        Intrinsics.checkNotNullParameter(r34, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r34.putAll(r4);
        mz0.m r35 = new mz0.m();
        r35.b(LogCommon.ROOM);
        ((ArrayList) r112.b).addAll(r35.a);
        cy0.e.a.getClass();
        cy0.j r36 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r37 = com.bytedance.android.scope.m.b(r36).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r37);
        ((mz0.i) ((f80.a) r37)).w3("livesdk_connection_invite_banner_show", r112.a, r112.b);
        d31.e r113 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r113 == null) goto L99;
        i97.a r38 = i97.a.a;
        r113.a = System.currentTimeMillis();
        r113.c = 0;
    L99:
        com.bytedance.android.live.revlink.impl.pk.utils.e.c();
        goto L100
    L95:
        r111 = 0;
        goto L96
    L91:
        r33 = 0;
        goto L92
    L84:
        r29 = "";
        goto L85
    L80:
        r27 = "";
    L76:
        r25 = "";
        goto L77
    L71:
        r23 = "";
        goto L72
    L67:
        r20 = "";
        goto L68
    L59:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r39 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r39 == null) goto L64;
        i11.b r40 = r39.getLinkUserCenter();
        if (r40 == null) goto L64;
        r1 = Integer.valueOf(r40.c());
        goto L64
    L55:
        r8 = null;
        goto L56
    L51:
        r6 = null;
    L100:
        com.bytedance.android.live.revlink.impl.pk.utils.i r114 = this.a.U90().getListExtraInfo();
        if (r114 == null) goto L104;
        this.a.u.f(r114);
        return;
    L104:
        return;
    L41:
        if ((!r3.isEmpty()) == false) goto L45;
        this.a.r = false;
        d31.f r115 = com.bytedance.android.live.revlink.impl.global.b.e0();
        if (r115 == null) goto L45;
        long r42 = com.bytedance.android.live.revlink.impl.utils.t.a(this.a.q);
        Intrinsics.checkNotNullParameter("linking_invite_panel_first_refresh_duration", "eventType");
        LinkedHashMap r43 = new LinkedHashMap();
        r43.put("event_type", "linking_invite_panel_first_refresh_duration");
        r43.put(Constants.Keys.duration, String.valueOf(r42));
        r115.b(r43);
        mz0.n r116 = new mz0.n();
        Map<String, String> r44 = r116.a;
        Intrinsics.checkNotNullParameter(r44, "map");
        Intrinsics.checkNotNullParameter(r43, "map");
        r44.putAll(r43);
        cy0.e.a.getClass();
        cy0.j r45 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r46 = com.bytedance.android.scope.m.b(r45).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r46);
        ((mz0.i) ((f80.a) r46)).w3("livesdk_rd_revenue_link_metrics", r116.a, r116.b);
        goto L45
    L18:
        ((PkItemExposeRecyclerView) this.a.S90(2131384076)).setVisibility(0);
        ((LinearLayout) this.a.S90(2131390556)).setVisibility(8);
        goto L19
    L8:
        r2 = null;
        goto L9
    }
}
