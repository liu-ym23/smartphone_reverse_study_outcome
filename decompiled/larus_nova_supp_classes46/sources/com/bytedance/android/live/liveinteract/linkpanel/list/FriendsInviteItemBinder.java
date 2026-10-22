package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.VHeadView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class FriendsInviteItemBinder extends me.drakeet.multitype.b<ILinkPlayerInfoBridge, ViewHolder> {
    public final boolean b;
    public final Function1<ILinkPlayerInfoBridge, Unit> c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/FriendsInviteItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout a;
        public final VHeadView b;
        public final VHeadView c;
        public final TextView d;
        public final TextView e;
        public final HSImageView f;
        public final HSImageView g;
        public final LinearLayout h;
        public final TextView i;
        public final TextView j;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (FrameLayout) r2.findViewById(2131375129);
            this.b = r2.findViewById(2131375623);
            this.c = r2.findViewById(2131375624);
            this.d = (TextView) r2.findViewById(2131364745);
            this.e = (TextView) r2.findViewById(2131391677);
            this.f = r2.findViewById(2131375161);
            this.g = r2.findViewById(2131375150);
            this.h = (LinearLayout) r2.findViewById(2131375146);
            this.i = (TextView) r2.findViewById(2131375145);
            this.j = (TextView) r2.findViewById(2131390525);
        }
    }

    public static boolean h(ILinkPlayerInfoBridge r6) {
        int r0 = vm2.d.i();
        if (r6.getLastInvitedTimeMillis() >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((p6.b() - r6.getLastInvitedTimeMillis()) > (r0 * 1000)) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendsInviteItemBinder(boolean r2, Function1<? super ILinkPlayerInfoBridge, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onInvite");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r18, Object r19) {
        ViewHolder r1 = (ViewHolder) r18;
        final ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r19;
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "info");
        VHeadView r3 = r1.b;
        IBaseUser r4 = r2.getUser();
        if (r4 == null) goto L5;
        py.k r5 = r4.getAvatarThumbKt();
    L6:
        ImageUtil.loadRoundImage(r3, r5);
        r1.a.setOnClickListener(x0.a(new FriendsInviteItemBinder$onBindViewHolder$$inlined$apply$lambda$1(this, r2)));
        IBaseUser r6 = r2.getUser();
        if (r6 != null) goto L9;
    L11:
        IBaseUser r7 = r2.getUser();
        if (r7 != null) goto L14;
    L16:
        r1.c.setVisibility(8);
    L17:
        TextView r8 = r1.e;
        IBaseUser r9 = r2.getUser();
        if (r9 == null) goto L20;
        String r10 = r9.getRealNickName();
    L21:
        r8.setText(r10);
        VHeadView r11 = r1.c;
        StringBuilder r12 = new StringBuilder();
        r12.append(s1.B(2131917068));
        IBaseUser r13 = r2.getUser();
        if (r13 != null) goto L24;
    L26:
        int r14 = 2131917069;
    L27:
        r12.append(s1.B(r14));
        r3.a(r11, r12.toString());
        TextView r15 = r1.d;
        if (h(r2) == false) goto L30;
        r15.setText(s1.B(2131919316));
        r15.setBackgroundResource(2131250664);
        r15.setOnClickListener(new h(this, r2));
    L31:
        TextView r16 = r1.j;
        com.bytedance.android.live.liveinteract.plantform.model.i r17 = r2.getInviteListUserInfo();
        if (r17 == null) goto L34;
        String r20 = r17.getLast7DaysGiftCountTxt();
    L35:
        r16.setText(r20);
        IBaseUser r21 = r2.getUser();
        if (r21 == null) goto L40;
        List r22 = r21.getBadgeImageListV2();
        if (r22 == null) goto L40;
        List r23 = CollectionsKt.toMutableList(r22);
    L41:
        List r24 = r23;
        if (r24 != null) goto L44;
    L47:
        boolean r25 = true;
    L49:
        if (r25 == false) goto L51;
        LinkedHashMap r26 = new LinkedHashMap();
    L153:
        if (r26.containsKey(23) == false) goto L155;
        ImageUtil.loadImage(r1.f, (py.k) r26.get(23), 0);
        r1.f.setVisibility(0);
        float r27 = 27 + 0.0f;
    L157:
        if (r26.containsKey(1) == false) goto L159;
        ImageUtil.loadImage(r1.g, (py.k) r26.get(1), 0);
        r1.g.setVisibility(0);
        r27 = r27 + 35;
    L161:
        if (r26.containsKey(53) == false) goto L164;
        py.k r28 = (py.k) r26.get(53);
        LinearLayout r29 = r1.h;
        TextView r30 = r1.i;
        r29.setVisibility(0);
        int r110 = a3.d;
        a3.a.a(r29, r28, new g(r30, r28), 0.0f);
        int r31 = 61;
    L169:
        r27 = r27 + r31;
    L172:
        if (r27 <= 0) goto L174;
        r1.e.setMaxWidth(s1.y() - s1.f(162 + r27));
    L174:
        IBaseUser r32 = r2.getUser();
        if (r32 == null) goto L207;
        boolean r33 = !this.b;
        String r34 = r32.getIdString();
        boolean r35 = r2.isActive();
        boolean r111 = h(r2);
        IBaseUser r36 = r2.getUser();
        Intrinsics.checkNotNull(r36);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.i(r33, r34, r35, r111, r36.isSubscriber(), "mutual");
        return;
    L207:
        return;
    L164:
        if (r26.containsKey(52) == false) goto L167;
        py.k r37 = (py.k) r26.get(52);
        LinearLayout r38 = r1.h;
        TextView r39 = r1.i;
        r38.setVisibility(0);
        int r112 = a3.d;
        a3.a.a(r38, r37, new g(r39, r37), 0.0f);
        r31 = 59;
        goto L169
    L167:
        if (r26.containsKey(51) == false) goto L170;
        py.k r40 = (py.k) r26.get(51);
        LinearLayout r41 = r1.h;
        TextView r42 = r1.i;
        r41.setVisibility(0);
        int r113 = a3.d;
        a3.a.a(r41, r40, new g(r42, r40), 0.0f);
        r31 = 50;
        goto L169
    L170:
        r1.h.setVisibility(8);
        goto L172
    L159:
        r1.g.setVisibility(8);
        goto L161
    L155:
        r1.f.setVisibility(8);
        r27 = 0.0f;
        goto L157
    L51:
        List r43 = r23;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r43.iterator();
    L53:
        if (r115.hasNext() == false) goto L67;
        Object r44 = r115.next();
        Integer r116 = ((py.k) r44).getImageType();
        Intrinsics.checkNotNull(r116);
        int r45 = r116.intValue();
        if (r45 == 1) goto L62;
        if (r45 == 23) goto L62;
        if (r45 == 51) goto L62;
        if (r45 == 52) goto L62;
        if (r45 == 53) goto L62;
        boolean r46 = false;
    L64:
        if ((!r46) == false) goto L53;
        r114.add(r44);
    L62:
        r46 = true;
        goto L64
    L67:
        Iterator r47 = r114.iterator();
    L69:
        if (r47.hasNext() == false) goto L71;
        r23.remove((py.k) r47.next());
        goto L69
    L71:
        Iterator r48 = r43.iterator();
    L73:
        if (r48.hasNext() == false) goto L83;
        Object r49 = r48.next();
        Integer r50 = ((py.k) r49).getImageType();
        if (r50 != null) goto L78;
    L80:
        boolean r51 = false;
    L81:
        if (r51 == false) goto L73;
    L85:
        if (r49 == null) goto L106;
        Iterator r52 = r43.iterator();
    L88:
        if (r52.hasNext() == false) goto L98;
        Object r53 = r52.next();
        Integer r117 = ((py.k) r53).getImageType();
        if (r117 != null) goto L93;
    L95:
        boolean r118 = false;
    L96:
        if (r118 == false) goto L88;
    L99:
        py.k r54 = (py.k) r53;
        if (r54 != null) goto L102;
        r54 = null;
    L102:
        if (r24 == null) goto L105;
        TypeIntrinsics.asMutableCollection(r24).remove(r54);
        goto L106
    L105:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L93:
        if (r117.intValue() != 51) goto L95;
        r118 = true;
        goto L96
    L98:
        r53 = null;
    L106:
        Iterator r55 = r43.iterator();
    L108:
        if (r55.hasNext() == false) goto L118;
        Object r56 = r55.next();
        Integer r119 = ((py.k) r56).getImageType();
        if (r119 != null) goto L113;
    L115:
        boolean r120 = false;
    L116:
        if (r120 == false) goto L108;
    L119:
        if (r56 == null) goto L140;
        Iterator r57 = r43.iterator();
    L122:
        if (r57.hasNext() == false) goto L132;
        Object r58 = r57.next();
        Integer r121 = ((py.k) r58).getImageType();
        if (r121 != null) goto L127;
    L129:
        boolean r122 = false;
    L130:
        if (r122 == false) goto L122;
    L133:
        py.k r59 = (py.k) r58;
        if (r59 != null) goto L136;
        r59 = null;
    L136:
        if (r24 == null) goto L139;
        TypeIntrinsics.asMutableCollection(r24).remove(r59);
        goto L140
    L139:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L127:
        if (r121.intValue() != 52) goto L129;
        r122 = true;
        goto L130
    L132:
        r58 = null;
    L140:
        r26 = new LinkedHashMap();
        Iterator r60 = r43.iterator();
    L142:
        if (r60.hasNext() == false) goto L153;
        py.k r61 = (py.k) r60.next();
        List r62 = r61.getUrls();
        if (r62 != null) goto L146;
    L149:
        boolean r63 = true;
    L150:
        if (r63 == true) goto L142;
        Integer r65 = r61.getImageType();
        Intrinsics.checkNotNull(r65);
        r26.put(r65, r61);
        goto L142
    L146:
        if (r62.isEmpty() == true) goto L149;
        r63 = false;
        goto L150
    L113:
        if (r119.intValue() != 53) goto L115;
        r120 = true;
        goto L116
    L118:
        r56 = null;
        goto L119
    L78:
        if (r50.intValue() != 52) goto L80;
        r51 = true;
        goto L81
    L83:
        r49 = null;
        goto L85
    L44:
        if (r24.isEmpty() == true) goto L47;
        r25 = false;
    L40:
        r23 = null;
        goto L41
    L34:
        r20 = null;
        goto L35
    L30:
        r15.setOnClickListener(null);
        r15.setText(s1.B(2131919321));
        r15.setBackgroundResource(2131250663);
        goto L31
    L24:
        if (r13.getGender() != 1) goto L26;
        r14 = 2131917070;
        goto L27
    L20:
        r10 = null;
        goto L21
    L14:
        if (r7.getGender() != 2) goto L16;
        r1.c.setImageResource(2131250687);
        r1.c.setVisibility(0);
        goto L17
    L9:
        if (r6.getGender() != 1) goto L11;
        r1.c.setImageResource(2131250688);
        r1.c.setVisibility(0);
        goto L17
    L5:
        r5 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566410, r5, false));
    }
}
