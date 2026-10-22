package y31;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKRivalsRankViewHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.t5;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o extends me.drakeet.multitype.b<a, PKRivalsRankViewHolder> {
    public final com.bytedance.android.live.revlink.impl.pk.utils.m b;
    public final x31.h c;
    public final DataCenter d;

    public static final class a {
        public int a;
        public m2 b;
        public SearchSourceFlag c;
        public int d;

        public a() {
            this.a = 6;
            this.c = SearchSourceFlag.UNDEFINE;
        }
    }

    public final void g(RecyclerView.ViewHolder r3) {
        PKRivalsRankViewHolder r4 = (PKRivalsRankViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.l.c = 0;
        r4.m = null;
    }

    public final void b(RecyclerView.ViewHolder r24, Object r25) {
        PKRivalsRankViewHolder r6 = (PKRivalsRankViewHolder) r24;
        a r0 = (a) r25;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r0, "item");
        int r1 = r0.a;
        m2 r7 = r0.b;
        SearchSourceFlag r5 = r0.c;
        int r2 = r0.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "searchSourceFlag");
        if (r7 == null) goto L203;
        IRoom r8 = r7.getRoom();
        IBaseUser r3 = r8.getOwner();
        if (r3 == null) goto L203;
        r6.t = r5;
        r6.u = r2;
        if (r5 != SearchSourceFlag.INVITE_LINKING) goto L11;
    L14:
        boolean r4 = true;
    L15:
        r6.s = r4;
        List r12 = r7.getBattleRivalTagList();
        if (r12 == null) goto L18;
        r6.l.setOldTag(true);
        PkTagsContainerView.f(r6.l, r12, false, null, 9, "", 32);
    L18:
        r6.k = r1;
        a1.x(r6.a, r3.getAvatarThumbKt(), r6.a.getWidth(), r6.a.getHeight(), 2131250965);
        if (r3.getGender() != 1) goto L22;
        r6.b.setImageResource(2131250688);
        r6.b.setVisibility(0);
    L25:
        r6.c.setText(r3.getNickName());
        r6.e.setVisibility(0);
        r6.i.setVisibility(0);
        TextView r9 = r6.e;
        r9.setText(r9.getContext().getResources().getString(2131917963, new Object[]{IESUIUtils.getDisplayCountChinese(r8.getUserCount())}));
        IRivalExtraInfo r10 = r7.getRivalExtraInfo();
        if (r10 != null) goto L28;
    L36:
        boolean r13 = false;
    L37:
        if (r13 == false) goto L39;
        r6.h.setVisibility(0);
        r6.j.setVisibility(8);
    L40:
        if (r10 == null) goto L42;
        String r14 = r10.getText();
    L43:
        if (r14 != null) goto L45;
    L50:
        r6.d.setVisibility(8);
        r6.j.setVisibility(8);
    L51:
        r6.f.setClickable(true);
        r6.f.setBackgroundResource(2131249713);
        r6.f.setTextColor(s1.h(2131108435));
        if (r6.s == false) goto L146;
        r6.f.setText(2131917780);
        IBaseUser r15 = r8.getOwner();
        if (r15 == null) goto L158;
        ArrayList r16 = new ArrayList();
        if (r10 == null) goto L59;
        d6 r17 = r10.getLinkerInfo();
    L60:
        if (r17 == null) goto L70;
        d6 r18 = r10.getLinkerInfo();
        Intrinsics.checkNotNull(r18);
        if (Lists.isEmpty(r18.getLinkedUserInfos()) == true) goto L70;
        d6 r19 = r10.getLinkerInfo();
        Intrinsics.checkNotNull(r19);
        List r110 = r19.getLinkedUserInfos();
        Intrinsics.checkNotNull(r110);
        Iterator r111 = r110.iterator();
    L65:
        if (r111.hasNext() == false) goto L70;
        t5 r112 = (t5) r111.next();
        if (TextUtils.equals(r112.getUserId(), iz.a.a(r15)) == false) goto L65;
        r16.add(r112);
    L70:
        a9 r20 = ((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkMicInfo();
        if (r20 == null) goto L75;
        ILinkMicBattleSetting r22 = r20.getBattleSetting();
        if (r22 == null) goto L75;
        long r113 = r22.getDuration();
    L77:
        if (r113 <= 0) goto L80;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914788);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
    L133:
        if (((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkerDetail() == null) goto L158;
        z5 r23 = ((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r23 == null) goto L137;
        List r26 = r23.getPlayModes();
    L138:
        if (r26 == null) goto L158;
        z5 r27 = ((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r27 == null) goto L158;
        List r28 = r27.getPlayModes();
        if (r28 == null) goto L158;
        if (r28.contains(3L) != true) goto L158;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914788);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        goto L158
    L137:
        r26 = null;
        goto L138
    L80:
        if (((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkMicInfo() == null) goto L83;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914788);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        goto L133
    L83:
        if (r8.getLinkMap() == null) goto L129;
        if (r8.getLinkMap().isEmpty() == true) goto L129;
        if (r8.getLinkMap().containsKey(String.valueOf(4)) == false) goto L91;
        if (r8.getLinkMap().size() == 1) goto L129;
    L91:
        if (((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkerDetail() == null) goto L100;
        z5 r114 = ((IRoomLinkExt) r8.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r114 == null) goto L95;
        String r115 = r114.getFunctionType2();
    L97:
        if (TextUtils.equals(r115, "new_audience") == false) goto L100;
    L95:
        r115 = null;
    L100:
        if (r8.getLinkMap().containsKey(String.valueOf(7)) == false) goto L123;
        if (r16.size() != (r41.f.b - 1)) goto L105;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914724);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        goto L133
    L105:
        if (r6.t != SearchSourceFlag.INVITE_LINKING) goto L108;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914731);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        goto L133
    L108:
        if (r6.V3(r8.getOwner()) == false) goto L110;
        r6.f.setBackgroundResource(2131248802);
        r6.f.setText(2131914738);
        r6.f.setTextColor(s1.h(2131106807));
        goto L133
    L110:
        LinkCrossRoomDataHolder r29 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r29 != null) goto L113;
    L114:
        Long r30 = (Long) r8.getLinkMap().get(String.valueOf(7));
        LinkCrossRoomDataHolder r32 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r32 == null) goto L117;
        Long r33 = Long.valueOf(r32.c());
    L119:
        if (Intrinsics.areEqual(r30, r33) == false) goto L121;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914731);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
    L121:
        r6.f.setBackgroundResource(2131248803);
        r6.f.setText(2131914726);
        r6.f.setTextColor(ColorProtector.parseColor("#ffffff"));
        goto L133
    L117:
        r33 = null;
        goto L119
    L113:
        if (r29.c() == 0) goto L121;
    L123:
        if (r8.getLinkMap().containsKey(String.valueOf(8)) == false) goto L126;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914731);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
        goto L133
    L126:
        if (r8.getLinkMap().containsKey(String.valueOf(1)) == false) goto L133;
        r6.f.setBackgroundResource(2131248805);
        r6.f.setText(2131914788);
        r6.f.setTextColor(ColorProtector.parseColor("#b0b0b0"));
    L129:
        if (r6.W3(r8.getOwner()) == false) goto L131;
        r6.f.setBackgroundResource(2131248802);
        r6.f.setText(2131914739);
        r6.f.setTextColor(s1.h(2131106807));
        goto L133
    L131:
        r6.f.setBackgroundResource(2131248803);
        r6.f.setText(2131917780);
        r6.f.setTextColor(ColorProtector.parseColor("#ffffff"));
    L75:
        r113 = 0;
        goto L77
    L59:
        r17 = null;
    L158:
        r6.f.setVisibility(0);
        r6.g.setVisibility(8);
        if (r10 == null) goto L161;
        com.bytedance.android.livesdk.link.model.h r34 = r10.getAnchorBattleSetting();
    L162:
        if (r34 == null) goto L182;
        com.bytedance.android.livesdk.link.model.h r35 = r10.getAnchorBattleSetting();
        Intrinsics.checkNotNull(r35);
        if (r35.isTurnOn() == false) goto L182;
        if (PKRivalsRankViewHolder.Y3(r8) == true) goto L182;
        if (r6.Z3(r8) == false) goto L172;
        if (com.bytedance.android.live.revlink.impl.pk.utils.n.a() == false) goto L182;
    L172:
        if (r6.X3(r8) == true) goto L182;
        if (r8.getLinkMap() != null) goto L176;
    L178:
        boolean r36 = false;
    L179:
        if (r36 == true) goto L182;
        boolean r37 = true;
    L183:
        if (r37 == false) goto L185;
    L187:
        r6.f.setAlpha(1.0f);
    L188:
        com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.r r116 = new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.r(r6, r8, r7, r10, r5);
        r6.f.setOnClickListener(r116);
        r6.g.setOnClickListener(r116);
        r6.m = r7;
        r6.n = r8;
        HashMap<String, String> r38 = r6.r;
        SearchSourceFlag r39 = r6.t;
        if (r39 == null) goto L195;
        int r40 = com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.l.a[r39.ordinal()];
        if (r40 != 1) goto L194;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r42 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r42 == null) goto L201;
        String r43 = r42.a;
        if (r43 == null) goto L201;
    L202:
        r38.put("source", r43);
    L201:
        r43 = "";
        goto L202
    L194:
        if (r40 != 2) goto L195;
        r43 = "link_banner";
    L195:
        r43 = "pk_banner";
        goto L202
    L185:
        if (r6.s == true) goto L187;
        r6.f.setAlpha(0.5f);
        goto L188
    L176:
        if (r8.getLinkMap().containsKey(String.valueOf(5)) == false) goto L178;
        r36 = true;
    L182:
        r37 = false;
        goto L183
    L161:
        r34 = null;
        goto L162
    L146:
        String r44 = iz.a.a(r3);
        i11.b r45 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r45 == null) goto L154;
        Iterator<IBaseUser> r46 = r45.getInviteeList().iterator();
    L150:
        if (r46.hasNext() == false) goto L154;
        if (TextUtils.equals(iz.a.a(r46.next()), r44) == false) goto L150;
        boolean r47 = true;
    L155:
        if (r47 == false) goto L157;
        r6.f.setBackgroundResource(2131249714);
        r6.f.setText(2131914739);
        r6.f.setTextColor(ColorProtector.parseColor("#161823"));
        goto L158
    L157:
        r6.f.setBackgroundResource(2131249713);
        r6.f.setText(2131919636);
        r6.f.setTextColor(s1.h(2131108435));
    L154:
        r47 = false;
        goto L155
    L45:
        if (r10.getText().length() != 0) goto L47;
        boolean r117 = true;
    L48:
        if (r117 == true) goto L50;
        r6.d.setText(r10.getText());
        goto L51
    L47:
        r117 = false;
        goto L48
    L42:
        r14 = null;
        goto L43
    L39:
        r6.h.setVisibility(8);
        r6.j.setVisibility(0);
        goto L40
    L28:
        if (r10.getText_type() == IRivalExtraInfo.TextType.Distance.ordinal()) goto L32;
        if (r10.getText_type() != IRivalExtraInfo.TextType.DistanceCity.ordinal()) goto L36;
    L32:
        if (r10.getText() == null) goto L36;
        if (r10.getText().length() <= 0) goto L36;
        r13 = true;
        goto L37
    L22:
        if (r3.getGender() != 2) goto L24;
        r6.b.setImageResource(2131250687);
        r6.b.setVisibility(0);
        goto L25
    L24:
        r6.b.setVisibility(8);
        goto L25
    L11:
        if (r5 == SearchSourceFlag.MAIN_LINK) goto L14;
        r4 = false;
    L203:
        com.bytedance.android.live.revlink.impl.pk.utils.m r48 = this.b;
        if (r48 == null) goto L213;
        r48.b();
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r7, ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Intrinsics.checkNotNullParameter(r8, "parent");
        View r9 = r7.inflate(2131566364, r8, false);
        float r10 = s1.y() / s1.f(375.0f);
        ViewGroup.LayoutParams r1 = null;
        if (r10 <= 1.0f) goto L6;
        Float r12 = null;
    L9:
        if (r12 == null) goto L47;
        float r13 = r12.floatValue();
        View r0 = r9.findViewById(2131374267);
        int r2 = (int) (s1.f(16.0f) * r13);
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r3 = null;
    L13:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L16;
        r4.leftMargin = r2;
    L16:
        View r5 = r9.findViewById(2131384666);
        int r6 = (int) (s1.f(8.0f) * r13);
        ViewGroup.LayoutParams r14 = r5.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r14 = null;
    L19:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L22;
        r15.leftMargin = r6;
    L22:
        View r16 = r9.findViewById(2131388160);
        int r17 = (int) (s1.f(4.0f) * r13);
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L25;
        r18 = null;
    L25:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L28;
        r19.leftMargin = r17;
    L28:
        View r20 = r9.findViewById(2131388160);
        int r22 = (int) (s1.f(4.0f) * r13);
        ViewGroup.LayoutParams r23 = r20.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == true) goto L31;
        r23 = null;
    L31:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        if (r24 == null) goto L34;
        r24.rightMargin = r22;
    L34:
        View r25 = r9.findViewById(2131364600);
        int r26 = (int) (s1.f(18.0f) * r13);
        ViewGroup.LayoutParams r27 = r25.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L37;
        r27 = null;
    L37:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L40;
        r28.rightMargin = r26;
    L40:
        View r29 = r9.findViewById(2131391655);
        int r30 = (int) (s1.f(22.0f) * r13);
        ViewGroup.LayoutParams r32 = r29.getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
        r1 = r32;
    L44:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r1;
        if (r33 == null) goto L47;
        r33.rightMargin = r30;
    L47:
        Unit r34 = Unit.INSTANCE;
        return new PKRivalsRankViewHolder(r9, this.c, this.d);
    L6:
        if (r10 >= 0.6666667f) goto L8;
        r12 = Float.valueOf(0.6666667f);
        goto L9
    L8:
        r12 = Float.valueOf(r10);
        goto L9
    }

    public o(com.bytedance.android.live.revlink.impl.pk.utils.m r2, x31.h r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "mListener");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
