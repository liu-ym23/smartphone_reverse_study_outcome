package com.bytedance.android.live.livepkaudience.list;

import am2.x;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUserInfo;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import dl0.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends me.drakeet.multitype.b<LinkPlayerInfo, PkGuestViewHolder> {
    public final xk0.c b;
    public final int c;

    public i(xk0.c r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r19, Object r20) {
        final PkGuestViewHolder r0 = (PkGuestViewHolder) r19;
        final LinkPlayerInfo r1 = (LinkPlayerInfo) r20;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r1, "item");
        final boolean r5 = false;
        if (this.c != 1) goto L17;
        int r3 = r1.listUserType;
        int r7 = BasePkAudienceInviteListFragment.A;
        if (r3 != 1) goto L17;
        if (r1.mHasExposed == true) goto L17;
        int r4 = al0.d.a;
        IBaseUser r6 = r1.getUser();
        if (r6 == null) goto L11;
        String r8 = r6.getIdString();
    L12:
        long r9 = d5.c(r8);
        boolean r10 = r1.isActive;
        boolean r11 = r1.isHasInvited;
        IBaseUser r12 = r1.getUser();
        if (r12 == null) goto L15;
        boolean r13 = r12.isSubscriber();
    L16:
        al0.d.c(false, r9, r10, r11, r13);
        r1.mHasExposed = true;
        goto L17
    L15:
        r13 = false;
        goto L16
    L11:
        r8 = null;
    L17:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "linkPlayerInfo");
        xk0.c r14 = r0.u;
        if (r14 == null) goto L21;
        r14.isGame();
    L21:
        if (r0.s == false) goto L23;
        ((RecyclerView.ViewHolder) r0).itemView.setBackgroundColor(s1.h(2131107196));
    L23:
        UtilityKotlinExtentionsKt.t(r0.b);
        vh7.c r15 = r1.getUser();
        if (r15 == null) goto L186;
        final User r16 = jm2.a.e(r15);
        if (r16 == null) goto L186;
        r0.d.setText(r16.getNickName());
        ImageUtil.loadRoundImage(r0.c, r16.getAvatarThumb());
        r0.c.setOnClickListener(x0.a(new PkGuestViewHolder$bindView$$inlined$let$lambda$1(r16, r0, r1, r5)));
        if (TextUtils.isEmpty(r1.location) == true) goto L30;
    L32:
        r0.l.setVisibility(0);
    L34:
        if (r0.t != 1) goto L37;
        UtilityKotlinExtentionsKt.t(r0.m);
    L37:
        if (r16.getGender() != 1) goto L40;
        r0.h.setVisibility(0);
        r0.h.setImageResource(2131250688);
    L43:
        LinearLayout r17 = r0.e;
        r17.removeViews(1, r17.getChildCount() - 1);
        dl0.a[] r18 = new dl0.a[5];
        s r110 = s.c;
        s.b = new WeakReference(r16);
        if (r110.d() == true) goto L47;
        r110 = null;
    L47:
        r18[0] = r110;
        dl0.g r111 = dl0.g.c;
        dl0.g.b = new WeakReference(r16);
        if (r111.d() == true) goto L51;
        r111 = null;
    L51:
        r18[1] = r111;
        dl0.o r112 = dl0.o.c;
        dl0.o.a = new WeakReference(r16);
        if (r112.d() == true) goto L55;
        r112 = null;
    L55:
        r18[2] = r112;
        dl0.i r113 = dl0.i.c;
        WeakReference<LinkPlayerInfo> r114 = new WeakReference(r1);
        dl0.i.b = r114;
        LinkPlayerInfo r115 = r114.get();
        if (r115 == null) goto L65;
        MicPosTagInfo r116 = r115.micPosTagInfo;
        if (r116 == null) goto L65;
        if (r116.getTagType() <= 0) goto L65;
        int r117 = k81.c.a;
        if (k81.c.b(r116.getPositionTagName()) == false) goto L65;
        boolean r118 = true;
    L66:
        if (r118 == true) goto L69;
        r113 = null;
    L69:
        r18[3] = r113;
        dl0.e r119 = dl0.e.c;
        dl0.e.b = new WeakReference(dl0.e.d(r16));
        if (r119.e() == true) goto L73;
        r119 = null;
    L73:
        r18[4] = r119;
        List r21 = CollectionsKt.filterNotNull(CollectionsKt.mutableListOf(r18));
        boolean r120 = jc1.k.n(IKtvService.class).isKtvComponentOpen();
        int r121 = dl0.b.a;
        Iterator r22 = dl0.b.d(r21, r120).iterator();
    L75:
        if (r22.hasNext() == false) goto L88;
        dl0.a r122 = (dl0.a) r22.next();
        View r123 = r0.v.get(r122.b());
        if (r123 == null) goto L75;
        if ((r122 instanceof dl0.g) == false) goto L87;
        py.d r124 = r16.getUserHonor();
        if (r124 == null) goto L85;
        String r125 = String.valueOf(r124.getLevel());
        if (r125 == null) goto L85;
    L86:
        r0.n = r125;
    L85:
        r125 = "null";
    L87:
        r122.c(r123);
        r0.e.addView(r123);
        goto L75
    L88:
        r0.g.setOnClickListener(x0.a(new PkGuestViewHolder$bindView$$inlined$let$lambda$2(r0, r1, r5)));
        if (HostEnv.b() == false) goto L91;
    L94:
        TextView r23 = r0.f;
        long r24 = 1000;
        String r126 = "";
        String r25 = TimeUtils.getTimeDescription(s1.getContext(), r1.getModifyTime() * r24, tc0.c.h().Q * r24);
        if (r1.listUserFromType == 4) goto L97;
        SpannableString r26 = new SpannableString(r25);
    L106:
        r23.setText(r26);
    L107:
        r0.i.setText(r1.location);
        if (TextUtils.isEmpty(r1.location) == false) goto L110;
        r0.i.setVisibility(8);
        r0.j.setVisibility(8);
        r0.k.setVisibility(8);
        int r27 = 0;
    L115:
        if (r0.t != 0) goto L181;
        r0.f.setVisibility(r27);
        TextView r28 = r0.m;
        com.bytedance.android.livesdk.sharedpref.e r29 = com.bytedance.android.livesdk.sharedpref.c.t1;
        if (((Boolean) r29.getValue()).booleanValue() == false) goto L119;
        int r127 = 8;
    L120:
        r28.setVisibility(r127);
        TextView r30 = r0.m;
        if (r30 == null) goto L123;
        Integer r31 = Integer.valueOf(r30.getVisibility());
    L125:
        if (r31.intValue() != 0) goto L131;
        TextView r32 = r0.m;
        if (r0.getAdapterPosition() >= r0.a) goto L129;
        String r128 = String.valueOf(r0.getAdapterPosition());
    L130:
        r32.setText(r128);
        goto L131
    L129:
        r128 = "99+";
    L131:
        TextView r33 = r0.g;
        if (((Boolean) r29.getValue()).booleanValue() == false) goto L134;
    L137:
        int r34 = 0;
    L138:
        r33.setVisibility(r34);
        if (r1.isHasApplied == false) goto L141;
        r0.g.setText(s1.B(2131919209));
        r0.g.setBackgroundResource(2131249430);
        boolean r35 = false;
        boolean r36 = false;
    L142:
        if (r35 == false) goto L185;
        int r37 = al0.b.a;
        String r38 = r16.getIdStr();
        WaitingListUserInfo r39 = r1.waitingListUserInfo;
        if (r39 == null) goto L146;
        String r40 = r39.applyReason;
    L147:
        boolean r41 = r0.s;
        String r42 = String.valueOf(r1.getFanTicket());
        String r129 = r1.getRelationship();
        String r130 = r1.getTopR();
        String r131 = r0.n;
        Long r132 = Long.valueOf(com.bytedance.android.live.liveinteract.plantform.model.n.b(r1));
        Intrinsics.checkNotNullParameter("list", "page");
        Intrinsics.checkNotNullParameter(r42, "fanTicket");
        Intrinsics.checkNotNullParameter(r129, "relationship");
        Intrinsics.checkNotNullParameter(r130, "topPos");
        Intrinsics.checkNotNullParameter(r131, "userLevel");
        HashMap r133 = new HashMap();
        r133.put("live_type", "video_live");
        if (r38 != null) goto L151;
        r38 = r126;
    L151:
        r133.put("applicant_id", r38);
        if (r36 == false) goto L154;
        Object r43 = "1";
    L155:
        r133.put("is_application_valid", r43);
        if (r41 == false) goto L158;
        String r44 = "anchor";
    L159:
        r133.put("pass_type", r44);
        if (TextUtils.isEmpty(r40) == false) goto L162;
        r133.put("is_application", "0");
    L166:
        r133.put("request_page", "list");
        if (r41 == false) goto L169;
    L170:
        Integer r2 = (Integer) com.bytedance.android.livesdk.sharedpref.c.x1.getValue();
        if (r2 != null) goto L174;
    L176:
        String r45 = "time_first";
    L177:
        r133.put("ordering_mode", r45);
        r133.put("money", r42);
        r133.put("relationship", r129);
        r133.put("top_r", r130);
        r133.put("contribution_level", r131);
    L178:
        if (r132 == null) goto L180;
        r132.longValue();
        r133.put("tag_type", String.valueOf(r132));
    L180:
        al0.b.a(r133);
        al0.b.c(r133);
        u.l().sendLog("livesdk_anchor_audience_connection_pass_show", r133, new Object[]{Room.class, x.class});
        goto L185
    L174:
        if (r2.intValue() != 41) goto L176;
        r45 = "money_first";
        goto L177
    L169:
        if (dl0.n.c() == false) goto L178;
    L162:
        r133.put("is_application", "1");
        if (r40 != null) goto L165;
        r40 = r126;
    L165:
        r133.put("application_message", r40);
        goto L166
    L158:
        r44 = "administrator";
        goto L159
    L154:
        r43 = "0";
        goto L155
    L146:
        r40 = null;
    L185:
        r1.mHasExposed = true;
        goto L186
    L141:
        r0.g.setText(s1.B(2131919204));
        r0.g.setBackgroundResource(2131249467);
        r35 = true;
        r36 = true;
        goto L142
    L134:
        if (r1.applyTypeNew == LinkApplyType.PREPARE_APPLY.getValue()) goto L137;
        r34 = 8;
        goto L138
    L123:
        r31 = null;
        goto L125
    L119:
        r127 = 0;
        goto L120
    L181:
        r0.f.setVisibility(8);
        if (r1.isHasInvited == false) goto L184;
        r0.g.setText(s1.B(2131919321));
        r0.g.setBackgroundResource(2131249430);
        goto L185
    L184:
        r0.g.setText(s1.B(2131919316));
        r0.g.setBackgroundResource(2131249467);
        goto L185
    L110:
        r27 = 0;
        r0.i.setVisibility(0);
        r0.j.setVisibility(0);
        if (r0.t != 0) goto L113;
        r0.k.setVisibility(0);
        goto L115
    L113:
        r0.k.setVisibility(8);
        goto L115
    L97:
        IBaseUser r46 = r1.getInvitor();
        if (r46 == null) goto L101;
        String r47 = r46.getNickName();
        if (r47 == null) goto L101;
    L103:
        if (r47.length() <= 8) goto L105;
        r47 = r47.substring(0, 8) + "...";
    L105:
        SpannableString r134 = new SpannableString(r25 + ("被 " + r47 + " 邀请"));
        r134.setSpan(new StyleSpan(1), r25.length() + 2, (r25.length() + 2) + r47.length(), 18);
        r26 = r134;
    L101:
        r47 = r126;
        goto L103
    L91:
        if (HostEnv.c() == true) goto L94;
        r0.f.setText(TimeUtils.getTimeDescription(s1.getContext(), ((long) 1000) * r1.getModifyTime()));
        r126 = "";
    L65:
        r118 = false;
        goto L66
    L40:
        if (r16.getGender() != 2) goto L42;
        r0.h.setVisibility(0);
        r0.h.setImageResource(2131250687);
        goto L43
    L42:
        r0.h.setVisibility(8);
        goto L43
    L30:
        if (r0.t != 1) goto L32;
        r0.l.setVisibility(8);
    L186:
        List<KtvMusic> r48 = r1.songList;
        List<KtvMusic> r49 = r48;
        if (r49 != null) goto L189;
    L192:
        boolean r135 = true;
    L193:
        if (r135 == true) goto L208;
        r0.l.setVisibility(8);
        r0.o.setVisibility(0);
        long r50 = r1.orderedSongCount;
        if (((int) r50) != 1) goto L197;
        r0.r.setVisibility(8);
    L198:
        r0.p.setText(((KtvMusic) ListProtector.get(r48, 0)).getMTitle());
        if (r1.listUserFromType != 2) goto L209;
        r0.q.setBackground(s1.m(2131251746));
        return;
    L209:
        return;
    L197:
        r0.r.setText(s1.C(2131919483, new Object[]{Long.valueOf(r50)}));
        r0.r.setVisibility(0);
        goto L198
    L208:
        return;
    L189:
        if (r49.isEmpty() == true) goto L192;
        r135 = false;
        goto L193
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        View r10 = r8.inflate(2131566286, r9, false);
        List r0 = CollectionsKt.listOf(new dl0.a[]{s.c, dl0.o.c, dl0.g.c, dl0.e.c, dl0.i.c});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        dl0.a r3 = (dl0.a) r1.next();
        Pair r4 = new Pair(r3.b(), r3.a(r8.getContext(), (ViewGroup) r10.findViewById(2131380597)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L7:
        return new PkGuestViewHolder(r10, this.c, this.b, r2);
    }
}
