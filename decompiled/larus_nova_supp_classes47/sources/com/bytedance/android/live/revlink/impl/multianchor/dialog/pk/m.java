package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorTeamPkRandomView;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ MultiAnchorTeamPkUserInviteDialog a;

    public m(MultiAnchorTeamPkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        List r8 = (List) r7;
        if (this.a.isViewValid() == false) goto L98;
        StringBuilder r0 = new StringBuilder("teamPkInvitePanel listDataModel updated ");
        Integer r1 = null;
        if (r8 == null) goto L8;
        Integer r2 = Integer.valueOf(r8.size());
    L9:
        r0.append(r2);
        jy0.b.f("ttlive_anchor_link_panel", r0.toString(), null, 4);
        if (this.a.S90(2131392080).e == false) goto L12;
        this.a.o.postDelayed(new l(this), 300);
    L12:
        ArrayList r3 = new ArrayList();
        if (r8 == null) goto L16;
        r3.addAll(r8);
    L16:
        if (r3.isEmpty() == false) goto L18;
        ((PkItemExposeRecyclerView) this.a.S90(2131384076)).setVisibility(8);
        ((LinearLayout) this.a.S90(2131390556)).setVisibility(0);
    L19:
        MultiTypeAdapter r9 = this.a.m;
        if (r9 == null) goto L22;
        r9.a = r3;
    L22:
        if (r9 == null) goto L24;
        r9.notifyDataSetChanged();
    L24:
        View r10 = this.a.g;
        if (r10 == null) goto L27;
        r10.setVisibility(8);
    L27:
        View r12 = this.a.h;
        if (r12 == null) goto L30;
        r12.setVisibility(8);
    L30:
        Toolbar r13 = this.a.S90(2131385286);
        if (r13 == null) goto L34;
        r13.setVisibility(0);
    L34:
        if (this.a.T90().getRandomMatchDataModel().getValue() == null) goto L38;
        ConstraintLayout r14 = (MultiAnchorTeamPkRandomView) this.a.S90(2131362584);
        if (r14 == null) goto L38;
        r14.setVisibility(0);
    L38:
        MultiAnchorTeamPkUserInviteDialog r15 = this.a;
        if (r15.r == true) goto L93;
        r15.r = true;
        HashMap r4 = new HashMap();
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L44;
        Long r6 = Long.valueOf(r5.c());
    L45:
        r4.put("channel_id", String.valueOf(r6));
        w31.c r16 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r16 == null) goto L48;
        Long r17 = Long.valueOf(r16.i());
    L49:
        r4.put("pk_id", String.valueOf(r17));
        if (r15.T90().getCurrentScene() != 1) goto L52;
        r1 = 2;
    L57:
        r4.put("anchor_connect_status", String.valueOf(r1));
        d31.d r18 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r19 = "";
        if (r18 == null) goto L60;
        String r20 = r18.c();
    L61:
        r4.put("connection_type", r20);
        d31.d r22 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r22 == null) goto L64;
        String r23 = r22.b();
    L65:
        r4.put("connection_sub_type", r23);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r24 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r24 == null) goto L69;
        String r25 = r24.a;
        if (r25 == null) goto L69;
    L70:
        r4.put("source", r25);
        d31.d r26 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r26 == null) goto L73;
        String r27 = r26.f();
    L74:
        r4.put("invite_mode", r27);
        d31.d r28 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r28 == null) goto L77;
        String r29 = r28.d();
    L78:
        r4.put("battle_mode", r29);
        r4.put("enter_button", "team");
        com.bytedance.android.live.revlink.impl.pk.utils.i r30 = r15.T90().getListExtraInfo();
        if (r30 == null) goto L81;
        int r32 = r30.a;
    L82:
        r4.put("friends_cnt", String.valueOf(r32));
        com.bytedance.android.live.revlink.impl.pk.utils.i r33 = r15.T90().getListExtraInfo();
        if (r33 == null) goto L85;
        int r34 = r33.b;
    L86:
        r4.put("total_friends_num", String.valueOf(r34));
        d31.d r35 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r35 == null) goto L89;
        r19 = r35.s();
    L89:
        r4.put("room_status", r19);
        mz0.n r36 = new mz0.n();
        Map<String, String> r37 = r36.a;
        Intrinsics.checkNotNullParameter(r37, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r37.putAll(r4);
        mz0.m r38 = new mz0.m();
        r38.b(LogCommon.ROOM);
        ((ArrayList) r36.b).addAll(r38.a);
        cy0.e.a.getClass();
        cy0.j r39 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r40 = com.bytedance.android.scope.m.b(r39).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r40);
        ((mz0.i) ((f80.a) r40)).w3("livesdk_connection_invite_banner_show", r36.a, r36.b);
        d31.e r42 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r42 == null) goto L92;
        i97.a r43 = i97.a.a;
        r42.a = System.currentTimeMillis();
        r42.c = 0;
    L92:
        com.bytedance.android.live.revlink.impl.pk.utils.e.c();
        goto L93
    L85:
        r34 = 0;
        goto L86
    L81:
        r32 = 0;
        goto L82
    L77:
        r29 = "";
        goto L78
    L73:
        r27 = "";
    L69:
        r25 = "";
        goto L70
    L64:
        r23 = "";
        goto L65
    L60:
        r20 = "";
        goto L61
    L52:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r44 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r44 == null) goto L57;
        i11.b r45 = r44.getLinkUserCenter();
        if (r45 == null) goto L57;
        r1 = Integer.valueOf(r45.c());
        goto L57
    L48:
        r17 = null;
        goto L49
    L44:
        r6 = null;
    L93:
        com.bytedance.android.live.revlink.impl.pk.utils.i r46 = this.a.T90().getListExtraInfo();
        if (r46 == null) goto L97;
        this.a.s.f(r46);
        return;
    L97:
        return;
    L18:
        ((PkItemExposeRecyclerView) this.a.S90(2131384076)).setVisibility(0);
        ((LinearLayout) this.a.S90(2131390556)).setVisibility(8);
        goto L19
    L8:
        r2 = null;
        goto L9
    }
}
