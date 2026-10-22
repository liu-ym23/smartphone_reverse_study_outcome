package com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.utils.g1;
import com.bytedance.android.live.liveinteract.utils.r;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.live.datacontext.m;
import fj0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import py.k;
import tc0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkApplyUserViewBinder extends me.drakeet.multitype.b<ILinkPlayerInfoBridge, ViewHolder> {
    public final IRoom b;
    public final boolean c;
    public final Function1<ILinkPlayerInfoBridge, Unit> d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/interact/viewholder/LinkApplyUserViewBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout a;
        public final VHeadView b;
        public final VHeadView c;
        public final LinearLayout d;
        public final TextView e;
        public final TextView f;
        public final HSImageView g;
        public final HSImageView h;
        public final LinearLayout i;
        public final TextView j;
        public final TextView k;
        public final TextView l;
        public final TextView m;
        public final LinearLayout n;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (FrameLayout) r2.findViewById(2131375129);
            this.b = r2.findViewById(2131363180);
            this.c = r2.findViewById(2131363183);
            this.d = (LinearLayout) r2.findViewById(2131392037);
            this.e = (TextView) r2.findViewById(2131364636);
            LinearLayout r0 = (LinearLayout) r2.findViewById(2131392032);
            this.f = (TextView) r2.findViewById(2131391677);
            this.g = r2.findViewById(2131375161);
            this.h = r2.findViewById(2131375150);
            this.i = (LinearLayout) r2.findViewById(2131375146);
            this.j = (TextView) r2.findViewById(2131375145);
            this.k = (TextView) r2.findViewById(2131390774);
            this.l = (TextView) r2.findViewById(2131390525);
            this.m = (TextView) r2.findViewById(2131390162);
            this.n = (LinearLayout) r2.findViewById(2131363195);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkApplyUserViewBinder(boolean r2, Function1<? super ILinkPlayerInfoBridge, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onAccept");
        this.c = r2;
        this.d = r3;
        m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L5;
        IRoom r5 = (IRoom) r4.getValue();
    L6:
        this.b = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void h(LinkApplyUserViewBinder r1, IBaseUser r2) {
        r1.getClass();
        if (r2 == null) goto L7;
        xs2.b.a().post(new UserProfileEvent(r2).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
        return;
    }

    public final void b(RecyclerView.ViewHolder r19, Object r20) {
        final ViewHolder r1 = (ViewHolder) r19;
        final ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r20;
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "info");
        if (this.c == true) goto L5;
    L10:
        VHeadView r3 = r1.b;
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L13;
        k r6 = r5.getAvatarThumbKt();
    L14:
        ImageUtil.loadRoundImage(r3, r6);
        r1.d.setOnClickListener(x0.a(new LinkApplyUserViewBinder$onBindViewHolder$$inlined$apply$lambda$1(this, r2, r1)));
        r1.b.setOnClickListener(x0.a(new LinkApplyUserViewBinder$onBindViewHolder$$inlined$apply$lambda$2(this, r2, r1)));
        IBaseUser r4 = r2.getUser();
        if (r4 != null) goto L17;
    L19:
        IBaseUser r7 = r2.getUser();
        if (r7 != null) goto L22;
    L24:
        r1.c.setVisibility(8);
    L25:
        TextView r8 = r1.f;
        IBaseUser r9 = r2.getUser();
        if (r9 == null) goto L28;
        String r10 = r9.getNickName();
    L29:
        r8.setText(r10);
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        r11.element = true;
        if (r2.isHasApplied() == false) goto L32;
        r11.element = false;
        r1.e.setText(s1.B(2131919209));
        r1.e.setBackgroundResource(2131250663);
        boolean r12 = false;
    L41:
        r1.e.setOnClickListener(new b(r1, r11, this, r2));
        TextView r13 = r1.l;
        o0 r14 = r2.getWaitingListUserInfo();
        if (r14 == null) goto L44;
        String r15 = r14.getLast7DaysGiftCountTxt();
    L45:
        r13.setText(r15);
        IBaseUser r16 = r2.getUser();
        if (r16 == null) goto L50;
        List r17 = r16.getBadgeImageListV2();
        if (r17 == null) goto L50;
        List r18 = CollectionsKt.toMutableList(r17);
    L51:
        List r110 = r18;
        if (r110 != null) goto L54;
    L57:
        boolean r111 = true;
    L59:
        if (r111 == false) goto L61;
        LinkedHashMap r112 = new LinkedHashMap();
    L94:
        if (r112.containsKey(23) == false) goto L96;
        ImageUtil.loadImage(r1.g, (k) r112.get(23), 0);
        r1.g.setVisibility(0);
        float r21 = 27 + 0.0f;
    L98:
        if (r112.containsKey(1) == false) goto L100;
        ImageUtil.loadImage(r1.h, (k) r112.get(1), 0);
        r1.h.setVisibility(0);
        r21 = r21 + 35;
    L102:
        if (r112.containsKey(53) == false) goto L105;
        k r22 = (k) r112.get(53);
        LinearLayout r113 = r1.i;
        TextView r114 = r1.j;
        r113.setVisibility(0);
        int r115 = a3.d;
        a3.a.a(r113, r22, new com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.viewholder.a(r114, r22), 0.0f);
        int r23 = 61;
    L110:
        r21 = r21 + r23;
    L113:
        if (r21 <= 0) goto L115;
        r1.f.setMaxWidth(s1.y() - s1.f(162 + r21));
    L115:
        o0 r24 = r2.getWaitingListUserInfo();
        if (r24 == null) goto L118;
        String r25 = r24.getApplyReason();
    L120:
        if (StringUtils.isEmpty(r25) == true) goto L126;
        TextView r26 = r1.m;
        o0 r27 = r2.getWaitingListUserInfo();
        if (r27 == null) goto L124;
        String r28 = r27.getApplyReason();
    L125:
        r26.setText(r28);
        r1.n.setVisibility(0);
    L127:
        if (r12 == false) goto L134;
        int r29 = jf0.b.a;
        IBaseUser r30 = r2.getUser();
        Intrinsics.checkNotNull(r30);
        String r31 = r30.getIdString();
        boolean r116 = r11.element;
        o0 r32 = r2.getWaitingListUserInfo();
        if (r32 == null) goto L131;
        String r117 = r32.getApplyReason();
    L132:
        jf0.b.l(r31, r116, r117, "list", this.c, null, null, null, 8160);
        goto L134
    L131:
        r117 = null;
    L134:
        if (e.g(this.b) == true) goto L136;
    L138:
        boolean r33 = false;
    L139:
        if (r33 == true) goto L141;
    L145:
        r1.b.setBackgroundColor(s1.h(2131107196));
    L147:
        if (e.g(this.b) == true) goto L149;
    L151:
        boolean r34 = false;
    L152:
        if (r34 == false) goto L170;
        r1.l.setVisibility(8);
        o0 r35 = r2.getWaitingListUserInfo();
        if (r35 == null) goto L156;
        String r36 = r35.getApplyReason();
    L158:
        if (TextUtils.isEmpty(r36) == true) goto L164;
        r1.k.setVisibility(8);
        r1.n.setVisibility(0);
        TextView r37 = r1.m;
        Object[] r38 = new Object[1];
        o0 r39 = r2.getWaitingListUserInfo();
        if (r39 == null) goto L162;
        String r40 = r39.getApplyReason();
    L163:
        r38[0] = r40;
        r37.setText(s1.C(2131917985, r38));
    L166:
        if (r2.isAddPrice() == false) goto L168;
        r1.k.setText(TimeUtils.getTimeDescription(s1.getContext(), r2.getAddPriceTime(), c.h().Q * ((long) 1000)));
    L169:
        int r41 = 8;
    L172:
        if (g1.c(r2) == false) goto L184;
        r1.l.setVisibility(r41);
        r1.n.setVisibility(r41);
        r1.k.setVisibility(0);
        r1.k.setText(r2.getPaidAmount() + r3.b());
        return;
    L184:
        return;
    L168:
        long r42 = 1000;
        r1.k.setText(TimeUtils.getTimeDescription(s1.getContext(), r2.getModifyTime() * r42, c.h().Q * r42));
        goto L169
    L162:
        r40 = null;
        goto L163
    L164:
        r1.k.setVisibility(0);
        r1.n.setVisibility(8);
        goto L166
    L156:
        r36 = null;
        goto L158
    L170:
        r1.l.setVisibility(0);
        r41 = 8;
        r1.k.setVisibility(8);
        goto L172
    L149:
        if (e.f() == false) goto L151;
        r34 = true;
        goto L152
    L141:
        if (r2.isAddPrice() == false) goto L145;
        if (g1.c(r2) == true) goto L145;
        r1.b.setBackgroundColor(s1.h(2131107204));
        goto L147
    L136:
        if (e.f() == false) goto L138;
        r33 = true;
        goto L139
    L124:
        r28 = null;
        goto L125
    L126:
        r1.n.setVisibility(8);
        goto L127
    L118:
        r25 = null;
        goto L120
    L105:
        if (r112.containsKey(52) == false) goto L108;
        k r43 = (k) r112.get(52);
        LinearLayout r118 = r1.i;
        TextView r119 = r1.j;
        r118.setVisibility(0);
        int r120 = a3.d;
        a3.a.a(r118, r43, new com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.viewholder.a(r119, r43), 0.0f);
        r23 = 59;
        goto L110
    L108:
        if (r112.containsKey(51) == false) goto L111;
        k r44 = (k) r112.get(51);
        LinearLayout r121 = r1.i;
        TextView r122 = r1.j;
        r121.setVisibility(0);
        int r123 = a3.d;
        a3.a.a(r121, r44, new com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.viewholder.a(r122, r44), 0.0f);
        r23 = 50;
        goto L110
    L111:
        r1.i.setVisibility(8);
        goto L113
    L100:
        r1.h.setVisibility(8);
        goto L102
    L96:
        r1.g.setVisibility(8);
        r21 = 0.0f;
        goto L98
    L61:
        List r124 = r18;
        ArrayList r45 = new ArrayList();
        Iterator r125 = r124.iterator();
    L63:
        if (r125.hasNext() == false) goto L77;
        Object r46 = r125.next();
        Integer r126 = ((k) r46).getImageType();
        Intrinsics.checkNotNull(r126);
        int r47 = r126.intValue();
        if (r47 == 1) goto L72;
        if (r47 == 23) goto L72;
        if (r47 == 51) goto L72;
        if (r47 == 52) goto L72;
        if (r47 == 53) goto L72;
        boolean r48 = false;
    L74:
        if ((!r48) == false) goto L63;
        r45.add(r46);
    L72:
        r48 = true;
        goto L74
    L77:
        Iterator r49 = r45.iterator();
    L79:
        if (r49.hasNext() == false) goto L81;
        r18.remove((k) r49.next());
        goto L79
    L81:
        r112 = new LinkedHashMap();
        Iterator r50 = r124.iterator();
    L83:
        if (r50.hasNext() == false) goto L94;
        k r51 = (k) r50.next();
        List r52 = r51.getUrls();
        if (r52 != null) goto L87;
    L90:
        boolean r53 = true;
    L91:
        if (r53 == true) goto L83;
        Integer r54 = r51.getImageType();
        Intrinsics.checkNotNull(r54);
        r112.put(r54, r51);
        goto L83
    L87:
        if (r52.isEmpty() == true) goto L90;
        r53 = false;
        goto L91
    L54:
        if (r110.isEmpty() == true) goto L57;
        r111 = false;
    L50:
        r18 = null;
        goto L51
    L44:
        r15 = null;
        goto L45
    L32:
        o0 r55 = r2.getWaitingListUserInfo();
        if (r55 != null) goto L35;
    L39:
        r1.e.setText(s1.B(2131919204));
        r1.e.setBackgroundResource(2131250664);
    L40:
        r12 = true;
        goto L41
    L35:
        if (r55.isHasExpired() != true) goto L39;
        if (r.a() == false) goto L39;
        r11.element = false;
        r1.e.setText(s1.B(2131917657));
        r1.e.setBackgroundResource(2131250663);
        goto L40
    L28:
        r10 = null;
        goto L29
    L22:
        if (r7.getGender() != 2) goto L24;
        r1.c.setImageResource(2131250687);
        r1.c.setVisibility(0);
        goto L25
    L17:
        if (r4.getGender() != 1) goto L19;
        r1.c.setImageResource(2131250688);
        r1.c.setVisibility(0);
        goto L25
    L13:
        r6 = null;
        goto L14
    L5:
        if (r2.isAddPrice() == true) goto L7;
    L9:
        ((RecyclerView.ViewHolder) r1).itemView.setBackgroundColor(s1.h(2131107196));
        goto L10
    L7:
        if (g1.c(r2) == true) goto L9;
        ((RecyclerView.ViewHolder) r1).itemView.setBackgroundColor(s1.h(2131107203));
        goto L10
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566415, r5, false));
    }
}
