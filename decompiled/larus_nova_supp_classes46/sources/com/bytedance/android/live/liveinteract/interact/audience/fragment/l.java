package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends me.drakeet.multitype.b<ILinkPlayerInfoBridge, InteractAudienceViewHolder> {
    public final IRoom b;
    public final boolean c;
    public final com.bytedance.android.live.liveinteract.linkpanel.list.o d;
    public final int e;

    public static final class a {
    }

    static {
    }

    public final int getType() {
        return this.e;
    }

    public l(com.bytedance.android.live.liveinteract.linkpanel.list.o r1, int r2) {
        this.d = r1;
        this.e = r2;
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L5;
        IRoom r4 = (IRoom) r3.getValue();
    L6:
        this.b = r4;
        Boolean r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r5 == null) goto L9;
        boolean r6 = r5.booleanValue();
    L10:
        this.c = r6;
        return;
    L9:
        r6 = false;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void b(RecyclerView.ViewHolder r20, Object r21) {
        final InteractAudienceViewHolder r1 = (InteractAudienceViewHolder) r20;
        final ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r21;
        Intrinsics.checkNotNullParameter(r1, "viewHolder");
        Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        final IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L147;
        r1.b.setText(r3.getNickName());
        ImageUtil.loadRoundImage(r1.a, r3.getAvatarThumbKt());
        r1.a.setOnClickListener(new n(r3, this, r2));
        boolean r5 = true;
        String r9 = null;
        if (com.bytedance.android.live.liveinteract.utils.r.a() == true) goto L7;
    L20:
        r1.n.setVisibility(4);
        r1.o.setVisibility(0);
        UIUtils.updateLayoutMargin(r1.p, -3, UtilityKotlinExtentionsKt.i(20), -3, -3);
    L22:
        if (r3.getGender() != 1) goto L25;
        r1.e.setVisibility(0);
        r1.e.setImageResource(2131250688);
    L28:
        com.bytedance.android.live.profit.fansclub.o r4 = yt0.c.c();
        if (r4 == null) goto L33;
        com.bytedance.android.live.profit.fansclub.g r6 = r4.P5(r3);
        if (r6 == null) goto L33;
        com.bytedance.android.live.profit.fansclub.b r7 = r6.a;
    L34:
        if (r7 == null) goto L36;
        py.k r10 = r7.b();
    L38:
        if (r3.getFollowInfo() == null) goto L44;
        py.j r11 = r3.getFollowInfo();
        if (r11 == null) goto L44;
        if (r11.getFollowStatus() != 2) goto L44;
        r1.g.setVisibility(8);
        r1.i.setVisibility(0);
        r1.h.setBackgroundResource(2131248877);
        r1.h.setText(s1.B(2131923026));
    L54:
        py.d r8 = r3.getUserHonor();
        if (r8 == null) goto L57;
        py.k r12 = r8.getNewImIconWithLevel();
    L58:
        if (r12 != null) goto L60;
        r1.f.setVisibility(8);
    L61:
        r1.d.setOnClickListener(x0.a(new InteractAudienceItemBinder$onBindViewHolder$$inlined$let$lambda$2(r3, this, r1, r2)));
        r1.c.setText(TimeUtils.getTimeDescription(s1.getContext(), r2.getModifyTime() * ((long) 1000)));
        r1.k.setText(r2.getLocation());
        if (TextUtils.isEmpty(r2.getLocation()) == false) goto L64;
        r1.k.setVisibility(8);
        r1.l.setVisibility(8);
        r1.m.setVisibility(8);
    L69:
        if (this.e != 0) goto L87;
        r1.c.setVisibility(0);
        if (r2.isHasApplied() == false) goto L73;
        r1.d.setText(s1.B(2131919209));
        r1.d.setBackgroundResource(2131249430);
    L80:
        r5 = false;
        boolean r13 = false;
    L82:
        if (r5 == false) goto L148;
        int r14 = jf0.b.a;
        String r15 = r3.getIdString();
        o0 r16 = r2.getWaitingListUserInfo();
        if (r16 == null) goto L86;
        r9 = r16.getApplyReason();
    L86:
        jf0.b.l(r15, r13, r9, "list", this.c, null, null, null, 8160);
        return;
    L148:
        return;
    L73:
        o0 r17 = r2.getWaitingListUserInfo();
        if (r17 != null) goto L76;
    L81:
        r1.d.setText(s1.B(2131919204));
        r1.d.setBackgroundResource(2131249467);
        r13 = true;
        goto L82
    L76:
        if (r17.isHasExpired() != true) goto L81;
        if (com.bytedance.android.live.liveinteract.utils.r.a() == false) goto L81;
        r1.d.setText(s1.B(2131917657));
        r1.d.setBackgroundResource(2131249430);
        goto L80
    L87:
        r1.c.setVisibility(8);
        if (r2.isHasInvited() == false) goto L90;
        r1.d.setText(s1.B(2131919321));
        r1.d.setBackgroundResource(2131249430);
    L91:
        int r18 = com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.a;
        IRoom r19 = this.b;
        if (r19 != null) goto L94;
    L96:
        boolean r22 = false;
    L97:
        IBaseUser r23 = r2.getUser();
        Intrinsics.checkNotNull(r23);
        String r24 = r23.getIdString();
        boolean r25 = r2.isActive();
        boolean r26 = r2.isHasInvited();
        IBaseUser r27 = r2.getUser();
        Intrinsics.checkNotNull(r27);
        boolean r28 = r27.isSubscriber();
        Intrinsics.checkNotNullParameter(r24, "inviteeId");
        Boolean r110 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        Boolean r111 = Boolean.TRUE;
        if (Intrinsics.areEqual(r110, r111) == false) goto L100;
    L103:
        boolean r112 = true;
    L104:
        if (r112 == false) goto L150;
        HashMap r113 = new HashMap();
        if (r22 == false) goto L108;
        String r29 = "voice_live";
    L109:
        r113.put("live_type", r29);
        TalkRoomLogUtils.B0(r113, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), null, 4);
        r113.put("invitee_id", r24.toString());
        r113.put("invitee_type", "audience");
        if (r25 == false) goto L112;
        String r30 = "online";
    L113:
        r113.put("online_status", r30);
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), r111) == false) goto L116;
        String r31 = "anchor";
    L117:
        r113.put("user_type", r31);
        String r32 = "1";
        if (r26 == false) goto L120;
        Object r33 = "1";
    L121:
        r113.put("icon_type", r33);
        li0.b r34 = li0.b.b;
        li0.b.k(r113);
        if (r28 == false) goto L124;
        Object r35 = "1";
    L125:
        r113.put("if_invitee_subscribe", r35);
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() == 1) goto L130;
        r5 = false;
    L130:
        if (r5 == false) goto L132;
        String r36 = String.valueOf(jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
    L133:
        r113.put("pk_id", r36);
        if (r5 == false) goto L136;
        Object r37 = "1";
    L137:
        r113.put("is_in_pk", r37);
        if (je0.d.Y() == false) goto L140;
        String r38 = je0.d.b0().toString();
    L141:
        r113.put("admin_id", r38);
        if (je0.d.Y() == true) goto L145;
        r32 = "0";
    L145:
        r113.put("is_admin", r32);
        r113.put("label_name_live", "");
        r113.put("module_type", "");
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.f("livesdk_anchor_invitee_show", r113, new Object[0]);
        return;
    L140:
        r38 = "";
        goto L141
    L136:
        r37 = "0";
        goto L137
    L132:
        r36 = "";
        goto L133
    L124:
        r35 = "0";
        goto L125
    L120:
        r33 = "0";
        goto L121
    L116:
        r31 = "admin";
        goto L117
    L112:
        r30 = "offline";
        goto L113
    L108:
        r29 = "video_live";
        goto L109
    L150:
        return;
    L100:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L103;
        r112 = false;
        goto L104
    L94:
        if (r19.isLiveTypeAudio() != true) goto L96;
        r22 = true;
        goto L97
    L90:
        r1.d.setText(s1.B(2131919316));
        r1.d.setBackgroundResource(2131249467);
        goto L91
    L64:
        r1.k.setVisibility(0);
        r1.l.setVisibility(0);
        if (this.e != 0) goto L67;
        r1.m.setVisibility(0);
        goto L69
    L67:
        r1.m.setVisibility(8);
        goto L69
    L60:
        r1.f.setVisibility(0);
        ImageUtil.loadImage(r1.f, r12, 0);
        goto L61
    L57:
        r12 = null;
    L44:
        if (r10 == null) goto L47;
        r1.g.setVisibility(0);
        r1.i.setVisibility(8);
        int r114 = a3.d;
        a3.a.a(r1.g, r10, new m(r1, r7), 0.0f);
        goto L54
    L47:
        if (r3.getFollowInfo() == null) goto L53;
        py.j r39 = r3.getFollowInfo();
        if (r39 == null) goto L53;
        if (r39.getFollowStatus() != 3) goto L53;
        r1.g.setVisibility(8);
        r1.i.setVisibility(0);
        r1.h.setBackgroundResource(2131248876);
        r1.h.setText(s1.B(2131923024));
    L53:
        r1.g.setVisibility(8);
        r1.i.setVisibility(8);
        goto L54
    L36:
        r10 = null;
    L33:
        r7 = null;
        goto L34
    L25:
        if (r3.getGender() != 2) goto L27;
        r1.e.setVisibility(0);
        r1.e.setImageResource(2131250687);
        goto L28
    L27:
        r1.e.setVisibility(8);
        goto L28
    L7:
        if (this.e != 0) goto L20;
        r1.n.setVisibility(0);
        r1.o.setVisibility(4);
        o0 r40 = r2.getWaitingListUserInfo();
        if (r40 == null) goto L11;
        String r41 = r40.getApplyReason();
    L13:
        if (TextUtils.isEmpty(r41) == true) goto L19;
        TextView r42 = r1.n;
        Object[] r43 = new Object[1];
        o0 r115 = r2.getWaitingListUserInfo();
        if (r115 == null) goto L17;
        String r116 = r115.getApplyReason();
    L18:
        r43[0] = r116;
        r42.setText(s1.C(2131917985, r43));
        UIUtils.updateLayoutMargin(r1.p, -3, UtilityKotlinExtentionsKt.i(12), -3, -3);
        goto L22
    L17:
        r116 = null;
        goto L18
    L19:
        UIUtils.updateLayoutMargin(r1.p, -3, UtilityKotlinExtentionsKt.i(20), -3, -3);
        goto L22
    L11:
        r41 = null;
        goto L13
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new InteractAudienceViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131566274, r5, false));
    }
}
