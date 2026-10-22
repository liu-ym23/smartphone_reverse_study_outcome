package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.t5;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkUserViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int k = 0;
    public final t21.a a;
    public final MutableLiveData<r21.a> b;
    public final LinkCrossRoomDataHolder c;
    public int d;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a e;
    public q21.g.a f;
    public IRoom g;
    public final HashMap<String, String> h;
    public int i;
    public final i21.b j;

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        IRoom r0 = this.g;
        if (r0 == null) goto L10;
        if (r0 == null) goto L11;
        String r1 = r0.getIdStr();
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L11:
        return "";
    L10:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r8) {
        Intrinsics.checkNotNullParameter(r8, "panelType");
        q21.g.a r0 = this.f;
        if (r0 == null) goto L7;
        String r1 = r0.h;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        this.h.put("enter_from", r8);
        this.h.put("source", r1);
        HashMap<String, String> r9 = this.h;
        d31.d r2 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r2 == null) goto L11;
        String r3 = r2.f();
    L12:
        r9.put("invite_mode", r3);
        HashMap<String, String> r10 = this.h;
        d31.d r4 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r4 == null) goto L15;
        String r5 = r4.d();
    L16:
        r10.put("battle_mode", r5);
        HashMap<String, String> r12 = this.h;
        d31.d r6 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r6 == null) goto L19;
        String r7 = r6.s();
    L20:
        r12.put("room_status", r7);
        HashMap<String, String> r13 = this.h;
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L23;
        String r15 = r14.b();
    L24:
        r13.put("connection_sub_type", r15);
        HashMap<String, String> r16 = this.h;
        IRoom r17 = this.g;
        py.j r18 = null;
        if (r17 == null) goto L27;
        LiveMode r19 = r17.getStreamType();
    L28:
        LiveMode r20 = LiveMode.SCREEN_RECORD;
        String r22 = DataType.TRUE;
        if (r19 != r20) goto L31;
        String r23 = DataType.TRUE;
    L32:
        r16.put("is_game", r23);
        HashMap<String, String> r24 = this.h;
        IRoom r25 = u.a();
        if (r25 == null) goto L35;
        LiveMode r26 = r25.getStreamType();
    L36:
        if (r26 == r20) goto L39;
        r22 = DataType.FALSE;
    L39:
        r24.put("is_anchor_game", r22);
        this.h.put("channel_id", "");
        this.h.put("pk_id", "");
        q21.g.a r27 = this.f;
        if (r27 == null) goto L60;
        IRoom r28 = r27.a;
        if (r28 == null) goto L60;
        HashMap<String, String> r29 = this.h;
        if (r28 == null) goto L46;
        Long r30 = Long.valueOf(r28.getUserCount());
    L47:
        r29.put("watch_uv", String.valueOf(r30));
        q21.g.a r32 = this.f;
        if (r32 == null) goto L50;
        IRoom r33 = r32.a;
    L51:
        if (r33 == null) goto L53;
        IBaseUser r34 = r33.getOwner();
    L54:
        if (r34 == null) goto L60;
        IBaseUser r35 = r33.getOwner();
        if (r35 == null) goto L58;
        r18 = r35.getFollowInfo();
    L58:
        if (r18 == null) goto L60;
        HashMap<String, String> r36 = this.h;
        IBaseUser r37 = r33.getOwner();
        Intrinsics.checkNotNull(r37);
        py.j r38 = r37.getFollowInfo();
        Intrinsics.checkNotNull(r38);
        r36.put("recommend_anchor_fans", String.valueOf(r38.getFollowerCount()));
        goto L60
    L53:
        r34 = null;
        goto L54
    L50:
        r33 = null;
        goto L51
    L46:
        r30 = null;
    L60:
        q21.g.a r39 = this.f;
        if (r39 == null) goto L63;
        this.h.put("available_cnt", String.valueOf(Integer.valueOf(r39.j)));
    L63:
        mz0.n r40 = new mz0.n();
        Map<String, String> r42 = r40.a;
        Intrinsics.checkNotNullParameter(r42, "map");
        HashMap<String, String> r43 = this.h;
        Intrinsics.checkNotNullParameter(r43, "map");
        r42.putAll(r43);
        mz0.m r44 = new mz0.m();
        r44.b(LogCommon.ROOM);
        ((ArrayList) r40.b).addAll(r44.a);
        cy0.e.a.getClass();
        cy0.j r45 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r46 = com.bytedance.android.scope.m.b(r45).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r46);
        ((mz0.i) ((f80.a) r46)).w3("livesdk_connectioninvite_anchoricon_show", r40.a, r40.b);
        return;
    L35:
        r26 = null;
        goto L36
    L31:
        r23 = DataType.FALSE;
        goto L32
    L27:
        r19 = null;
        goto L28
    L23:
        r15 = "";
        goto L24
    L19:
        r7 = "";
        goto L20
    L15:
        r5 = "";
        goto L16
    L11:
        r3 = "";
        goto L12
    L7:
        r1 = "link_banner";
        goto L8
    }

    public final boolean T3(IBaseUser r4) {
        com.bytedance.android.live.revlink.impl.multianchor.service.a r0 = this.e;
        if (r0 == null) goto L11;
        Iterator<IBaseUser> r1 = r0.getLinkUserCenter().n().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        if (TextUtils.equals(iz.a.a(r1.next()), iz.a.a(r4)) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public final boolean U3(IBaseUser r5) {
        com.bytedance.android.live.revenuelink.connect.g r0 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.w1() != true) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r1 = this.e;
        if (r1 == null) goto L20;
        Iterator<IBaseUser> r2 = r1.getLinkUserCenter().getInviteeList().iterator();
    L11:
        if (r2.hasNext() == false) goto L22;
        if (TextUtils.equals(iz.a.a(r2.next()), iz.a.a(r5)) == false) goto L11;
        return true;
    L22:
        return false;
    L20:
        return false;
    L21:
        return false;
    }

    public AnchorLinkUserViewHolder(t21.a r3, i21.b r4) {
        Intrinsics.checkNotNullParameter(r3, "uiStyle");
        Intrinsics.checkNotNullParameter(r4, "listener");
        View r0 = r3.getView();
        Intrinsics.checkNotNull(r0);
        super(r0);
        MutableLiveData<r21.a> r1 = new MutableLiveData();
        this.b = r1;
        this.c = com.bytedance.android.live.revlink.impl.global.b.j();
        this.e = com.bytedance.android.live.revlink.impl.global.b.t();
        this.h = new HashMap();
        this.a = r3;
        r3.b(r1);
        this.j = r4;
    }

    public final void V3(final q21.g.a r17, final IRoom r18, final m2 r19, IRivalExtraInfo r20, final int r22, final List<? extends IBattleRivalTag> r23, int r24) {
        Intrinsics.checkNotNullParameter(r17, "item");
        if (r18 != null) goto L5;
        return;
    L5:
        this.b.setValue(new r21.b().a());
        final IBaseUser r2 = r18.getOwner();
        if (r2 != null) goto L8;
        return;
    L8:
        this.f = r17;
        this.g = r18;
        this.d = r22;
        this.i = r24;
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = null;
        if (r20 == null) goto L11;
        r9.element = r20;
    L11:
        final ArrayList r14 = new ArrayList();
        IRivalExtraInfo r1 = (IRivalExtraInfo) r9.element;
        if (r1 != null) goto L14;
    L32:
        final Ref.IntRef r10 = new Ref.IntRef();
        r10.element = 0;
        yz0.k r3 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r3 == null) goto L35;
        IRoom r4 = r3.getRoom();
    L36:
        if (r4 == null) goto L40;
        r4.getId();
        if (r20 == null) goto L40;
        r10.element = r20.getAnchorLayer();
    L40:
        Function1<r21.b, Unit> r15 = new AnchorLinkUserViewHolder$onBindViewHolder$1(this, r2, r23, r22, r18, r17, r14, r19, r9, r10);
        r21.b r0 = new r21.b();
        r21.a r5 = (r21.a) this.b.getValue();
        if (r5 == null) goto L43;
        py.k r6 = r5.a;
    L44:
        r0.a = r6;
        if (r5 == null) goto L47;
        String r7 = r5.b;
    L48:
        r0.b = r7;
        if (r5 == null) goto L51;
        Integer r8 = r5.c;
    L52:
        r0.c = r8;
        if (r5 == null) goto L55;
        List<IBattleRivalTag> r12 = r5.d;
    L56:
        r0.d = r12;
        if (r5 == null) goto L59;
        Integer r13 = r5.e;
    L60:
        r0.e = r13;
        if (r5 == null) goto L63;
        Integer r16 = r5.f;
    L64:
        r0.f = r16;
        if (r5 == null) goto L67;
        Long r25 = r5.g;
    L68:
        r0.g = r25;
        if (r5 == null) goto L71;
        Boolean r26 = r5.h;
    L72:
        r0.h = r26;
        if (r5 == null) goto L75;
        List<t5> r27 = r5.i;
    L76:
        r0.i = r27;
        if (r5 == null) goto L79;
        Boolean r28 = r5.j;
    L80:
        r0.j = r28;
        if (r5 == null) goto L83;
        Boolean r29 = r5.k;
    L84:
        r0.k = r29;
        if (r5 == null) goto L87;
        Boolean r30 = r5.l;
    L88:
        r0.l = r30;
        if (r5 == null) goto L91;
        Map<String, Long> r32 = r5.m;
    L92:
        r0.m = r32;
        if (r5 == null) goto L95;
        String r33 = r5.n;
    L96:
        r0.n = r33;
        if (r5 == null) goto L99;
        Boolean r34 = r5.o;
    L100:
        r0.o = r34;
        if (r5 == null) goto L103;
        Boolean r35 = r5.p;
    L104:
        r0.p = r35;
        if (r5 == null) goto L107;
        Boolean r36 = r5.q;
    L108:
        r0.q = r36;
        if (r5 == null) goto L111;
        Runnable r37 = r5.r;
    L112:
        r0.r = r37;
        if (r5 == null) goto L115;
        String r38 = r5.s;
    L116:
        r0.s = r38;
        r15.invoke(r0);
        this.b.setValue(r0.a());
        r14.size();
        HashMap r39 = new HashMap();
        String r40 = iz.a.a(r18.getOwner());
        String r42 = "";
        if (r40 != null) goto L119;
        r40 = "";
    L119:
        r39.put("right_user_id", r40);
        r39.put("right_room_id", r18.getIdStr());
        r39.put("connection_type", "manual_link");
        int r43 = UserListInviteType.a;
        r39.put("list_type", UserListInviteType.a(this.d, null));
        r39.put("invitee_list", UserListInviteType.a(this.d, null));
        r39.put("list_num", String.valueOf(this.i + 1));
        if (((IRoomLinkExt) r18.castTo(IRoomLinkExt.class)).getLinkMicInfo() == null) goto L122;
    L125:
        r39.put("right_user_status", DataType.TRUE);
    L126:
        d31.d r44 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r44 == null) goto L132;
        String r45 = r44.a();
        if (r45 == null) goto L132;
        r42 = r45;
    L132:
        r39.put("anchor_connect_status", r42);
        q21.g.a r46 = this.f;
        if (r46 == null) goto L137;
        String r47 = r46.g;
        if (r47 == null) goto L137;
        r39.put("request_id", r47);
    L137:
        this.h.putAll(r39);
        return;
    L122:
        if (r18.getLinkMap().containsKey(String.valueOf(8)) == true) goto L125;
        r39.put("right_user_status", "2");
        goto L126
    L115:
        r38 = null;
        goto L116
    L111:
        r37 = null;
        goto L112
    L107:
        r36 = null;
        goto L108
    L103:
        r35 = null;
        goto L104
    L99:
        r34 = null;
        goto L100
    L95:
        r33 = null;
        goto L96
    L91:
        r32 = null;
        goto L92
    L87:
        r30 = null;
        goto L88
    L83:
        r29 = null;
        goto L84
    L79:
        r28 = null;
        goto L80
    L75:
        r27 = null;
        goto L76
    L71:
        r26 = null;
        goto L72
    L67:
        r25 = null;
        goto L68
    L63:
        r16 = null;
        goto L64
    L59:
        r13 = null;
        goto L60
    L55:
        r12 = null;
        goto L56
    L51:
        r8 = null;
        goto L52
    L47:
        r7 = null;
        goto L48
    L43:
        r6 = null;
        goto L44
    L35:
        r4 = null;
        goto L36
    L14:
        if (r1.getLinkerInfo() == null) goto L32;
        d6 r48 = ((IRivalExtraInfo) r9.element).getLinkerInfo();
        if (r48 == null) goto L18;
        List r49 = r48.getLinkedUserInfos();
    L20:
        if (Lists.isEmpty(r49) == true) goto L32;
        d6 r50 = ((IRivalExtraInfo) r9.element).getLinkerInfo();
        if (r50 == null) goto L25;
        List r52 = r50.getLinkedUserInfos();
        if (r52 == null) goto L25;
    L26:
        Iterator r53 = r52.iterator();
    L28:
        if (r53.hasNext() == false) goto L32;
        t5 r54 = (t5) r53.next();
        if (TextUtils.equals(r54.getUserId(), iz.a.a(r2)) == true) goto L28;
        r14.add(r54);
    L25:
        r52 = CollectionsKt.emptyList();
        goto L26
    L18:
        r49 = null;
        goto L20
    }
}
