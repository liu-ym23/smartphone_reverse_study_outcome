package q21;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.MultiAnchorInviteListUserViewHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.utils.m;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.a3;
import com.bytedance.android.livesdk.link.model.m0;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n0;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdk.link.model.o2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i extends me.drakeet.multitype.b<y31.k, MultiAnchorInviteListUserViewHolder> {
    public final m b;
    public final x31.m c;
    public final DataCenter d;

    public final void f(RecyclerView.ViewHolder r2) {
        MultiAnchorInviteListUserViewHolder r3 = (MultiAnchorInviteListUserViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.a.setVisibility(0);
    }

    public final void g(RecyclerView.ViewHolder r2) {
        MultiAnchorInviteListUserViewHolder r3 = (MultiAnchorInviteListUserViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.k.c = 0;
    }

    public final void b(RecyclerView.ViewHolder r25, Object r26) {
        MultiAnchorInviteListUserViewHolder r6 = (MultiAnchorInviteListUserViewHolder) r25;
        y31.k r7 = (y31.k) r26;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        IRoom r0 = r7.b;
        if (r0 == null) goto L195;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L195;
        r6.u = r7.b;
        r6.w = r7.i;
        r6.A = r7.r;
        r6.q = r7.e;
        r6.r = r7.j;
        m2 r2 = r7.a;
        r6.x = r2;
        r6.y = r7.o;
        IRivalExtraInfo r3 = r7.f;
        if (r3 == null) goto L11;
        r6.v = r3;
    L11:
        if (r2 == null) goto L13;
        Intrinsics.checkNotNull(r2);
        n2 r8 = r2.getInviteButton();
    L14:
        a1.x(r6.b, r1.getAvatarThumbKt(), r6.b.getWidth(), r6.b.getHeight(), 2131250965);
        r6.c.setVisibility(0);
        int r10 = 8;
        if (r1.getGender() != 1) goto L18;
        r6.c.setImageResource(2131250688);
    L21:
        r6.d.setText(r1.getNickName());
        IRoom r4 = r7.b;
        if (r4 == null) goto L24;
        r6.f.setVisibility(0);
        r6.e.setVisibility(0);
        TextView r5 = r6.e;
        Resources r9 = r5.getContext().getResources();
        Intrinsics.checkNotNull(r4);
        r5.setText(r9.getString(2131917963, new Object[]{IESUIUtils.getDisplayCountChinese(r4.getUserCount())}));
    L24:
        r6.k.setOldTag(true);
        ArrayList r13 = new ArrayList();
        if (r7.k.length() != 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == true) goto L34;
        m2 r14 = r7.a;
        if (r14 == null) goto L34;
        Intrinsics.checkNotNull(r14);
        if (r14.getActivityUser() == null) goto L34;
        m2 r15 = r7.a;
        Intrinsics.checkNotNull(r15);
        n0 r16 = r15.getActivityUser();
        Intrinsics.checkNotNull(r16);
        List r17 = r16.getLabelList();
        Intrinsics.checkNotNull(r17);
        r13.addAll(r17);
    L34:
        List<? extends IBattleRivalTag> r18 = r7.h;
        Intrinsics.checkNotNull(r18);
        r13.addAll(r18);
        PkTagsContainerView.f(r6.k, r13, true, r6.u, 9, "banner", 32);
        m2 r19 = r7.a;
        if (r19 == null) goto L39;
        Intrinsics.checkNotNull(r19);
        if (r19.getActivityMedal() == null) goto L39;
        r6.l.setVisibility(0);
        HSImageView r20 = r6.m;
        m2 r22 = r7.a;
        Intrinsics.checkNotNull(r22);
        a3 r23 = r22.getActivityMedal();
        Intrinsics.checkNotNull(r23);
        ImageUtil.loadImage(r20, r23.getGradeMedal(), 0);
        HSImageView r24 = r6.n;
        m2 r27 = r7.a;
        Intrinsics.checkNotNull(r27);
        a3 r28 = r27.getActivityMedal();
        Intrinsics.checkNotNull(r28);
        ImageUtil.loadImage(r24, r28.getLevelImage(), 0);
    L40:
        IRoom r29 = r7.b;
        String r30 = r7.k;
        m0 r32 = r7.l;
        boolean r33 = r7.m;
        r6.g.setClickable(true);
        m2 r110 = r6.x;
        Intrinsics.checkNotNull(r110);
        String r111 = r110.getLinkText();
        if (TextUtils.isEmpty(r111) == true) goto L44;
        r6.i.setVisibility(4);
        r6.p.setVisibility(0);
        r6.p.setText(r111);
    L61:
        IBaseUser r34 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (iz.a.a(r34) == null) goto L66;
        String r35 = iz.a.a(r34);
        Intrinsics.checkNotNull(r29);
        if (TextUtils.equals(r35, iz.a.a(r29.getOwner())) == false) goto L66;
        r6.i.setVisibility(4);
        r6.p.setText(2131917948);
        r6.p.setVisibility(0);
    L66:
        if (r8 == null) goto L70;
        if (r8.getForbidden() == false) goto L70;
    L71:
        r6.i.setAlpha(0.5f);
    L73:
        m2 r36 = r7.a;
        String r112 = "";
        if (r36 != null) goto L76;
    L141:
        r6.o.setVisibility(8);
    L142:
        yz0.k r37 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r37 == null) goto L145;
        IRoom r38 = r37.getRoom();
    L146:
        if (r38 == null) goto L150;
        IRivalExtraInfo r39 = r7.f;
        if (r39 == null) goto L150;
        int r40 = r39.getAnchorLayer();
    L151:
        IRivalExtraInfo r42 = r6.v;
        IRoom r43 = r7.b;
        int r44 = r7.e;
        if (r42 == null) goto L169;
        r6.s.put("connection_type", "manual_pk");
        HashMap<String, String> r45 = r6.s;
        if (r44 != 1) goto L156;
        String r46 = "mutual_follow";
    L157:
        r45.put("invitee_list", r46);
        if (r42.getText_type() != IRivalExtraInfo.TextType.Distance.ordinal()) goto L161;
        String r47 = "distance";
    L164:
        r6.s.put("inviter_level", String.valueOf(r40));
        HashMap r48 = new HashMap();
        r48.put(r47, r42.getText());
        r6.s.put("anchor_info", com.bytedance.android.live.revlink.impl.utils.e.b(r48));
        n r49 = new n();
        Map<String, String> r50 = r49.a;
        Intrinsics.checkNotNullParameter(r50, "map");
        HashMap<String, String> r52 = r6.s;
        Intrinsics.checkNotNullParameter(r52, "map");
        r50.putAll(r52);
        mz0.m r53 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r54 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r54, "linkInfoLog");
        if (r43 == null) goto L167;
        IBaseUser r55 = r43.getOwner();
    L168:
        r54.f(iz.a.a(r55));
        ((ArrayList) r53.a).add(r54.a);
        r53.b(LogCommon.ROOM);
        ((ArrayList) r49.b).addAll(r53.a);
        cy0.e.a.getClass();
        cy0.j r56 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r57 = com.bytedance.android.scope.m.b(r56).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r57);
        ((mz0.i) ((f80.a) r57)).w3("livesdk_connection_invite_show", r49.a, r49.b);
        goto L169
    L167:
        r55 = null;
        goto L168
    L161:
        if (r42.getText_type() != IRivalExtraInfo.TextType.DistanceCity.ordinal()) goto L163;
        r47 = "city";
        goto L164
    L163:
        r47 = "money";
        goto L164
    L156:
        r46 = "recommend";
    L169:
        r6.g.setOnClickListener(new com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.f(r6, r7, r6.v, r40, r8));
        View r58 = r6.j;
        if (r7.d == false) goto L172;
        r10 = 0;
    L172:
        r58.setVisibility(r10);
        IRoom r59 = r7.b;
        String r60 = r7.i;
        int r62 = r7.n;
        boolean r63 = r7.m;
        LinkedHashMap r64 = new LinkedHashMap();
        if (r59 == null) goto L178;
        IBaseUser r65 = r59.getOwner();
        if (r65 == null) goto L178;
        String r66 = iz.a.a(r65);
        if (r66 == null) goto L178;
    L179:
        r64.put("right_user_id", r66);
        if (r59 == null) goto L185;
        String r67 = r59.getIdStr();
        if (r67 == null) goto L185;
        r112 = r67;
    L185:
        r64.put("right_room_id", r112);
        d31.d r68 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r68 == null) goto L188;
        r68.r(r64);
    L188:
        r64.put("request_id", r60);
        int r69 = UserListInviteType.a;
        int r70 = r6.q;
        Map<Integer, String> r72 = r6.z;
        Intrinsics.checkNotNullParameter(r72, "inviteTypeToListType");
        r64.put("list_type", UserListInviteType.a(r70, r72));
        int r73 = r6.q;
        Map<Integer, String> r74 = r6.z;
        Intrinsics.checkNotNullParameter(r74, "inviteTypeToListType");
        r64.put("invitee_list", UserListInviteType.a(r73, r74));
        r64.put("list_num", String.valueOf(r6.A + 1));
        if (r63 == false) goto L191;
        r64.put("right_user_status", "3");
    L194:
        r64.put("source", String.valueOf(r62));
        r6.t.putAll(r64);
        r6.a.setVisibility(0);
        goto L195
    L191:
        if (r8 == null) goto L193;
        r64.put("right_user_status", String.valueOf(r8.getType()));
        goto L194
    L193:
        r64.put("right_user_status", "2");
    L178:
        r66 = "";
    L150:
        r40 = 0;
        goto L151
    L145:
        r38 = null;
        goto L146
    L76:
        if (o2.a(r36) == false) goto L141;
        List r75 = r36.getParticipantRooms();
        if (r75 == null) goto L142;
        int r76 = Math.min(r75.size(), 1);
        ArrayList r77 = new ArrayList();
        int r113 = 0;
    L82:
        if (r113 >= r76) goto L92;
        IRoom r114 = (IRoom) ListProtector.get(r75, r113);
        if (r114 == null) goto L90;
        IBaseUser r115 = r114.getOwner();
        if (r115 == null) goto L90;
        r77.add(r115);
    L90:
        r113 = r113 + 1;
        goto L82
    L92:
        if (r77.isEmpty() == false) goto L94;
        r6.o.setVisibility(8);
        goto L142
    L94:
        VHeadView r116 = r6.o.getIvAnchorAvatar1();
        if (r116 == null) goto L97;
        r116.setVisibility(8);
    L97:
        VHeadView r117 = r6.o.getIvAnchorAvatar2();
        if (r117 == null) goto L100;
        r117.setVisibility(8);
    L100:
        VHeadView r118 = r6.o.getIvAnchorAvatar3();
        if (r118 == null) goto L103;
        r118.setVisibility(8);
    L103:
        int r119 = r77.size();
        if (r119 == 0) goto L140;
        if (r119 != 1) goto L111;
        r6.o.setVisibility(0);
        VHeadView r120 = r6.o.getIvAnchorAvatar1();
        if (r120 == null) goto L110;
        r120.setVisibility(0);
    L110:
        ImageUtil.loadRoundImage(r6.o.getIvAnchorAvatar1(), ((IBaseUser) ListProtector.get(r77, 0)).getAvatarThumbKt());
    L111:
        int r121 = ColorProtector.parseColor("#C0161823");
        SpannableStringBuilder r122 = new SpannableStringBuilder();
        ArrayList r123 = new ArrayList();
        Iterator r78 = r77.iterator();
    L113:
        if (r78.hasNext() == false) goto L124;
        String r79 = ((IBaseUser) r78.next()).getNickName();
        int r124 = 6 - r76;
        if (r79 != null) goto L117;
        r79 = "";
    L121:
        if (r79 == null) goto L113;
        r123.add(r79);
        goto L113
    L117:
        if (r79.length() <= r124) goto L121;
        r79 = r79.subSequence(0, r124 - 1).toString() + "...";
        goto L121
    L124:
        String r80 = CollectionsKt.joinToString$default(r123, "、", null, null, 0, null, null, 62, null);
        if (r75.size() <= 1) goto L127;
        com.bytedance.live.kmp.util.c r82 = com.bytedance.live.kmp.util.c.a;
        int r83 = w11.a.a;
        String r84 = com.bytedance.live.kmp.util.c.a(2131914769, new Object[]{Integer.valueOf(r75.size())});
    L129:
        if (r36.getRoomScene() != 7) goto L131;
        r122.append("正与");
        r122.append(r80);
        r122.append(r84);
        r122.append("连线");
        r122.setSpan(new ForegroundColorSpan(r121), 2, r80.length() + 2, 33);
    L136:
        TextView r85 = r6.o.getTvAnchorLinkInfo();
        if (r85 == null) goto L139;
        r85.setText(r122);
    L139:
        r10 = 8;
        goto L142
    L131:
        r122.append("正与");
        r122.append(r80);
        r122.append(r84);
        if (TextUtils.isEmpty(r36.getRoomStatusDesc()) == true) goto L134;
        String r86 = r36.getRoomStatusDesc();
    L135:
        r122.append(r86);
        r122.setSpan(new ForegroundColorSpan(r121), 2, r80.length() + 2, 33);
        goto L136
    L134:
        r86 = "寻找多人玩法对手";
        goto L135
    L127:
        r84 = "";
        goto L129
    L140:
        r10 = 8;
        r6.o.setVisibility(8);
    L70:
        if (TextUtils.isEmpty(r111) == false) goto L71;
        r6.i.setAlpha(1.0f);
        goto L73
    L44:
        if (r30.length() != 0) goto L46;
        boolean r87 = true;
    L48:
        if (r87 == true) goto L58;
        if (r32 == null) goto L58;
        if (r32.getInviteButtonImage() == null) goto L58;
        r6.i.setVisibility(0);
        r6.p.setVisibility(8);
        py.k r88 = r32.getInviteButtonImage();
        Intrinsics.checkNotNull(r88);
        if (r88.getUrls() == null) goto L57;
        py.k r89 = r32.getInviteButtonImage();
        Intrinsics.checkNotNull(r89);
        if (r89.getUrls().size() <= 0) goto L57;
        HSImageView r90 = r6.h;
        py.k r92 = r32.getInviteButtonImage();
        Intrinsics.checkNotNull(r92);
        ImageLoader.bindImage(r90, (String) ListProtector.get(r92.getUrls(), 0));
    L57:
        ViewGroup.LayoutParams r93 = r6.i.getLayoutParams();
        r93.width = s1.f(80.0f);
        r6.i.setLayoutParams(r93);
        r6.g.setText(r32.getInviteButtonText());
    L58:
        if (r33 == false) goto L60;
        r6.i.setVisibility(0);
        r6.p.setVisibility(8);
        r6.h.setImageResource(2131249714);
        r6.g.setText(2131914739);
        r6.g.setTextColor(s1.h(2131107895));
        goto L61
    L60:
        r6.i.setVisibility(0);
        r6.p.setVisibility(8);
        r6.h.setImageResource(2131249467);
        ViewGroup.LayoutParams r94 = r6.i.getLayoutParams();
        r94.width = s1.f(80.0f);
        r6.i.setLayoutParams(r94);
        r6.g.setText(2131917780);
        r6.g.setTextColor(s1.h(2131109391));
        goto L61
    L46:
        r87 = false;
    L39:
        r6.l.setVisibility(8);
        goto L40
    L27:
        r12 = false;
        goto L28
    L18:
        if (r1.getGender() != 2) goto L20;
        r6.c.setImageResource(2131250687);
        goto L21
    L20:
        r6.c.setVisibility(8);
        goto L21
    L13:
        r8 = null;
    L195:
        m r95 = this.b;
        if (r95 == null) goto L206;
        r95.b();
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new MultiAnchorInviteListUserViewHolder(r4.inflate(2131566330, r5, false), this.c, this.d);
    }

    public i(m r2, x31.m r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "mListener");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
