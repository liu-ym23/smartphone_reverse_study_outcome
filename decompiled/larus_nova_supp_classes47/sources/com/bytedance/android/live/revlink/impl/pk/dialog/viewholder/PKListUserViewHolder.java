package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKListUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKListUserViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int Q = 0;
    public final HashMap<String, String> A;
    public final HashMap<String, String> B;
    public IRoom C;
    public IRivalExtraInfo D;
    public String E;
    public m2 F;
    public final HSImageView G;
    public boolean H;
    public List<? extends IBattleRivalTag> I;
    public String J;
    public int K;
    public y31.k L;
    public final x31.l M;
    public final DataCenter N;
    public final boolean O;
    public final boolean P;
    public final com.bytedance.android.live.revlink.impl.pk.service.b a;
    public final VHeadView b;
    public final VHeadView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;
    public final HSImageView i;
    public final View j;
    public final ImageView k;
    public final PkTagsContainerView l;
    public final LinearLayout m;
    public final View n;
    public final View o;
    public final HSImageView p;
    public final HSImageView q;
    public final ImageView r;
    public final View s;
    public final View t;
    public final TextView u;
    public final View v;
    public final LinearLayout w;
    public final HSImageView x;
    public final TextView y;
    public int z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        IRoom r0 = this.C;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return r0.getIdStr();
    L5:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r8) {
        Intrinsics.checkNotNullParameter(r8, "panelType");
        if (r8 != "PK") goto L16;
        if (this.z == 1) goto L16;
        IRoom r2 = this.C;
        if (r2 == null) goto L16;
        Intrinsics.checkNotNull(r2);
        if (TextUtils.isEmpty(r2.getIdStr()) == true) goto L16;
        LinkRevPanelDataContext r3 = LinkRevPanelDataContext.Companion.getContext();
        if (r3 == null) goto L16;
        com.bytedance.android.live.revlink.impl.control.dialog.b r4 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r3.getLoader().getValue();
        if (r4 == null) goto L16;
        IRoom r5 = this.C;
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getIdStr();
        Intrinsics.checkNotNullParameter(r6, "roomId");
        ((HashSet) r4.q.getValue()).add(r6);
    L16:
        if (r8 == "PK") goto L18;
    L40:
        if (r8 == "PK") goto L42;
    L58:
        com.bytedance.android.live.revlink.impl.control.dialog.e r0 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), this.J);
        if (r0 == null) goto L63;
        Map<String, String> r1 = r0.f;
        if (r1 == null) goto L63;
        this.B.putAll(r1);
    L63:
        this.B.put("enter_from", r8);
        this.B.put("source", "pk_banner");
        HashMap<String, String> r9 = this.B;
        d31.d r7 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r10 = "";
        if (r7 == null) goto L66;
        String r12 = r7.f();
    L67:
        r9.put("invite_mode", r12);
        HashMap<String, String> r13 = this.B;
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L70;
        String r15 = r14.d();
    L71:
        r13.put("battle_mode", r15);
        HashMap<String, String> r16 = this.B;
        d31.d r17 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r17 == null) goto L74;
        String r18 = r17.s();
    L75:
        r16.put("room_status", r18);
        HashMap<String, String> r19 = this.B;
        d31.d r20 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r20 == null) goto L78;
        r10 = r20.b();
    L78:
        r19.put("connection_sub_type", r10);
        mz0.n r22 = new mz0.n();
        Map<String, String> r23 = r22.a;
        Intrinsics.checkNotNullParameter(r23, "map");
        HashMap<String, String> r24 = this.B;
        Intrinsics.checkNotNullParameter(r24, "map");
        r23.putAll(r24);
        mz0.m r25 = new mz0.m();
        r25.b(LogCommon.ROOM);
        ((ArrayList) r22.b).addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((mz0.i) ((f80.a) r27)).w3("livesdk_connectioninvite_anchoricon_show", r22.a, r22.b);
        if (this.H == false) goto L95;
        yz0.k r28 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r28 == null) goto L83;
        IRoom r29 = r28.getRoom();
    L84:
        if (r29 == null) goto L86;
        IBaseUser r30 = r29.getOwner();
    L87:
        if (r30 == null) goto L92;
        if (r29 == null) goto L92;
        IBaseUser r32 = r29.getOwner();
        if (r32 == null) goto L92;
        String r33 = iz.a.a(r32);
    L93:
        com.bytedance.tools.kcp.spongepreference.runtime.a r34 = l51.a.b0;
        KProperty[] r35 = l51.a.a;
        HashSet r36 = (HashSet) r34.getValue(null, r35[61]);
        r36.add(String.valueOf(r33));
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r34.setValue(null, r35[61], r36);
        return;
    L92:
        r33 = null;
        goto L93
    L86:
        r30 = null;
        goto L87
    L83:
        r29 = null;
        goto L84
    L95:
        return;
    L74:
        r18 = "";
        goto L75
    L70:
        r15 = "";
        goto L71
    L66:
        r12 = "";
        goto L67
    L42:
        if (this.z != 2) goto L58;
        IRoom r37 = this.C;
        if (r37 == null) goto L56;
        Intrinsics.checkNotNull(r37);
        if (r37.getOwner() == null) goto L56;
        IRoom r38 = this.C;
        Intrinsics.checkNotNull(r38);
        IBaseUser r39 = r38.getOwner();
        Intrinsics.checkNotNull(r39);
        if (r39.getFollowInfo() == null) goto L56;
        IRoom r40 = this.C;
        if (r40 == null) goto L56;
        IBaseUser r42 = r40.getOwner();
        if (r42 == null) goto L56;
        py.j r43 = r42.getFollowInfo();
        if (r43 == null) goto L56;
        long r44 = r43.getFollowerCount();
    L57:
        this.B.put("recommend_anchor_fans", String.valueOf(r44));
    L56:
        r44 = 0;
        goto L57
    L18:
        if (this.z != 1) goto L40;
        com.bytedance.android.live.revlink.impl.control.dialog.e r45 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal(), DataType.FALSE);
        if (r45 == null) goto L24;
        IRivalRankRecommendResponse r46 = r45.c;
        if (r46 == null) goto L24;
        s2 r47 = r46.getTabRivals();
    L26:
        if (r47 == null) goto L36;
        s2 r48 = r45.c.getTabRivals();
        Intrinsics.checkNotNull(r48);
        if (r48.getGroupRivals() == null) goto L36;
        s2 r49 = r45.c.getTabRivals();
        Intrinsics.checkNotNull(r49);
        Map r50 = r49.getGroupRivals();
        Intrinsics.checkNotNull(r50);
        IGroupRivals r52 = (IGroupRivals) r50.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r52 == null) goto L32;
        List r53 = r52.getRivals();
    L33:
        if (r53 == null) goto L35;
        HashMap<String, String> r54 = this.B;
        List r55 = r52.getRivals();
        Intrinsics.checkNotNull(r55);
        r54.put("available_cnt", String.valueOf(r55.size()));
    L37:
        IRoom r56 = this.C;
        if (r56 == null) goto L58;
        HashMap<String, String> r57 = this.B;
        Intrinsics.checkNotNull(r56);
        r57.put("watch_uv", String.valueOf(r56.getUserCount()));
        goto L58
    L35:
        this.B.put("available_cnt", DataType.FALSE);
        goto L37
    L32:
        r53 = null;
    L36:
        this.B.put("available_cnt", DataType.FALSE);
    L24:
        r47 = null;
        goto L26
    }

    public final boolean T3(IBaseUser r6) {
        com.bytedance.android.live.revenuelink.connect.g r0 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r0 != null) goto L5;
    L15:
        return false;
    L5:
        if (r0.v1() != true) goto L15;
        com.bytedance.android.live.revlink.impl.pk.service.b r1 = this.a;
        if (r1 == null) goto L15;
        i11.b r2 = r1.getLinkUserCenter();
        Intrinsics.checkNotNull(r2);
        Iterator<IBaseUser> r3 = r2.getInviteeList().iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        if (TextUtils.equals(iz.a.a(r3.next()), iz.a.a(r6)) == false) goto L11;
        return true;
    }

    public final void U3(String r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        y31.k r1 = this.L;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.i;
        if (r3 == null) goto L6;
    L7:
        r0.put("request_id", r3);
        r0.put("anchor_connect_status", DataType.FALSE);
        y31.k r4 = this.L;
        if (r4 == null) goto L12;
        m2 r5 = r4.a;
        if (r5 == null) goto L12;
        n2 r6 = r5.getInviteButton();
    L14:
        if (r6 == null) goto L24;
        y31.k r7 = this.L;
        if (r7 == null) goto L22;
        m2 r8 = r7.a;
        if (r8 == null) goto L22;
        n2 r10 = r8.getInviteButton();
        if (r10 == null) goto L22;
        Long r12 = Long.valueOf(r10.getType());
    L23:
        r0.put("right_user_status", String.valueOf(r12));
    L25:
        y31.k r13 = this.L;
        if (r13 == null) goto L33;
        IRoom r14 = r13.b;
        if (r14 == null) goto L33;
        IBaseUser r15 = r14.getOwner();
        if (r15 == null) goto L33;
        String r16 = r15.getUserId();
        if (r16 == null) goto L33;
    L34:
        r0.put("right_user_id", r16);
        y31.k r17 = this.L;
        if (r17 == null) goto L40;
        IRoom r18 = r17.b;
        if (r18 == null) goto L40;
        String r19 = String.valueOf(r18.getRoomId());
        if (r19 == null) goto L40;
    L41:
        r0.put("right_room_id", r19);
        r0.put("source", "pk_banner");
        r0.put("channel_id", "");
        r0.put("pk_id", DataType.FALSE);
        y31.k r20 = this.L;
        if (r20 == null) goto L47;
        String r22 = String.valueOf(r20.r);
        if (r22 == null) goto L47;
        r2 = r22;
    L47:
        r0.put("list_num", r2);
        int r23 = UserListInviteType.a;
        y31.k r24 = this.L;
        if (r24 == null) goto L50;
        int r25 = r24.e;
    L51:
        r0.put("invitee_list", UserListInviteType.a(r25, null));
        mz0.n r26 = new mz0.n();
        Map<String, String> r27 = r26.a;
        Intrinsics.checkNotNullParameter(r27, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r27.putAll(r0);
        mz0.m r28 = new mz0.m();
        r28.b(LogCommon.ROOM);
        ((ArrayList) r26.b).addAll(r28.a);
        cy0.e.a.getClass();
        cy0.j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r30 = com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r30);
        ((mz0.i) ((f80.a) r30)).w3(r9, r26.a, r26.b);
        return;
    L50:
        r25 = 0;
    L40:
        r19 = "";
    L33:
        r16 = "";
    L22:
        r12 = null;
        goto L23
    L24:
        r0.put("right_user_status", "2");
    L12:
        r6 = null;
    L6:
        r3 = "";
        goto L7
    }

    public PKListUserViewHolder(View r2, x31.l r3, DataCenter r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "mListener");
        super(r2);
        this.M = r3;
        this.N = r4;
        this.O = r5;
        this.P = r6;
        this.a = com.bytedance.android.live.revlink.impl.global.b.N();
        this.b = r2.findViewById(2131374267);
        this.c = r2.findViewById(2131373623);
        this.d = (TextView) r2.findViewById(2131390993);
        this.e = (TextView) r2.findViewById(2131390632);
        this.f = (TextView) r2.findViewById(2131389459);
        this.g = (ImageView) r2.findViewById(2131389458);
        this.h = (TextView) r2.findViewById(2131390810);
        this.i = r2.findViewById(2131376326);
        this.j = r2.findViewById(2131375598);
        this.k = (ImageView) r2.findViewById(2131374680);
        this.l = (PkTagsContainerView) r2.findViewById(2131388160);
        this.m = (LinearLayout) r2.findViewById(2131384201);
        this.n = r2.findViewById(2131377500);
        this.o = r2.findViewById(2131373881);
        this.p = r2.findViewById(2131376275);
        this.q = r2.findViewById(2131376355);
        this.r = (ImageView) r2.findViewById(2131376554);
        this.s = r2.findViewById(2131389650);
        this.t = r2.findViewById(2131384410);
        this.u = (TextView) r2.findViewById(2131384413);
        this.v = r2.findViewById(2131384408);
        this.w = (LinearLayout) r2.findViewById(2131385654);
        this.x = r2.findViewById(2131383684);
        this.y = (TextView) r2.findViewById(2131383685);
        this.A = new HashMap();
        this.B = new HashMap();
        this.G = r2.findViewById(2131382365);
        this.I = new ArrayList();
        this.J = DataType.FALSE;
    }
}
