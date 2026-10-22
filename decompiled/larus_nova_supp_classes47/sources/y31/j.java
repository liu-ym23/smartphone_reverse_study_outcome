package y31;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKListUserViewHolder;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.a3;
import com.bytedance.android.livesdk.link.model.m0;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n0;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdk.link.model.p2;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends me.drakeet.multitype.b<k, PKListUserViewHolder> {
    public final com.bytedance.android.live.revlink.impl.pk.utils.m b;
    public final x31.l c;
    public final DataCenter d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public final void g(RecyclerView.ViewHolder r2) {
        PKListUserViewHolder r3 = (PKListUserViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.l.c = 0;
    }

    public final void b(RecyclerView.ViewHolder r20, Object r22) {
        PKListUserViewHolder r6 = (PKListUserViewHolder) r20;
        k r7 = (k) r22;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        IRoom r0 = r7.b;
        if (r0 == null) goto L212;
        r6.L = r7;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L212;
        r6.C = r7.b;
        r6.E = r7.i;
        r6.K = r7.r;
        r6.z = r7.e;
        m2 r2 = r7.a;
        r6.F = r2;
        r6.H = r7.q;
        IRivalExtraInfo r3 = r7.f;
        if (r3 == null) goto L11;
        r6.D = r3;
    L11:
        r6.J = r7.p;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNull(r2);
        n2 r9 = r2.getInviteButton();
    L15:
        a1.x(r6.b, r1.getAvatarThumbKt(), r6.b.getWidth(), r6.b.getHeight(), 2131250965);
        r6.c.setVisibility(0);
        if (r1.getGender() != 1) goto L19;
        r6.c.setImageResource(2131250688);
        r6.c.setContentDescription(s1.B(2131917070));
    L22:
        r6.d.setText(r1.getNickName());
        r6.d.setTextColor(ColorProtector.parseColor("#404040"));
        r6.d.setAlpha(1.0f);
        IRoom r4 = r7.b;
        if (r4 == null) goto L25;
        r6.f.setVisibility(0);
        r6.g.setVisibility(0);
        TextView r5 = r6.f;
        Resources r8 = r5.getContext().getResources();
        Intrinsics.checkNotNull(r4);
        r5.setText(r8.getString(2131917963, new Object[]{IESUIUtils.getDisplayCountChinese(r4.getUserCount())}));
        r6.f.setTextColor(s1.h(2131107359));
    L25:
        r6.l.setOldTag(true);
        ArrayList r14 = new ArrayList();
        if (r7.k.length() != 0) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == true) goto L35;
        m2 r12 = r7.a;
        if (r12 == null) goto L35;
        Intrinsics.checkNotNull(r12);
        if (r12.getActivityUser() == null) goto L35;
        m2 r13 = r7.a;
        Intrinsics.checkNotNull(r13);
        n0 r15 = r13.getActivityUser();
        Intrinsics.checkNotNull(r15);
        List r16 = r15.getLabelList();
        Intrinsics.checkNotNull(r16);
        r14.addAll(r16);
    L35:
        List<? extends IBattleRivalTag> r17 = r7.h;
        Intrinsics.checkNotNull(r17);
        r14.addAll(r17);
        r6.I = r14;
        IBattleRivalTag.a r18 = IBattleRivalTag.Companion;
        HashMap<String, String> r19 = r6.B;
        r18.getClass();
        IBattleRivalTag.a.a(r14, r19);
        r6.l.e(r14, r6.C, 9, "banner", false);
        r6.n.setVisibility(0);
        IRivalExtraInfo r23 = r6.D;
        if (r23 != null) goto L38;
    L46:
        boolean r24 = false;
    L47:
        if (r24 == false) goto L49;
        r6.s.setVisibility(0);
        r6.k.setVisibility(8);
    L50:
        if (r23 == null) goto L52;
        String r25 = r23.getText();
    L53:
        if (r25 != null) goto L55;
    L60:
        r6.e.setVisibility(8);
        r6.k.setVisibility(8);
    L61:
        m2 r26 = r7.a;
        if (r26 == null) goto L66;
        Intrinsics.checkNotNull(r26);
        if (r26.getActivityMedal() == null) goto L66;
        r6.o.setVisibility(0);
        HSImageView r27 = r6.p;
        m2 r28 = r7.a;
        Intrinsics.checkNotNull(r28);
        a3 r29 = r28.getActivityMedal();
        Intrinsics.checkNotNull(r29);
        ImageUtil.loadImage(r27, r29.getGradeMedal(), 0);
        HSImageView r30 = r6.q;
        m2 r32 = r7.a;
        Intrinsics.checkNotNull(r32);
        a3 r33 = r32.getActivityMedal();
        Intrinsics.checkNotNull(r33);
        ImageUtil.loadImage(r30, r33.getLevelImage(), 0);
    L67:
        r6.m.removeAllViews();
        m2 r34 = r7.a;
        if (r34 == null) goto L70;
        Intrinsics.checkNotNull(r34);
        List r35 = r34.getSemiFriendTags();
    L71:
        HashMap<String, String> r36 = r6.B;
        m2 r37 = r7.a;
        if (r37 == null) goto L80;
        List r38 = r37.getSemiFriendTags();
        if (r38 == null) goto L79;
        IBattleRivalTag r39 = (IBattleRivalTag) CollectionsKt.getOrNull(r38, 0);
        if (r39 == null) goto L79;
        String r40 = r39.getTagDesc();
        if (r40 == null) goto L79;
    L81:
        r36.put("relationship_tag_type", r40);
        if (r35 != null) goto L84;
    L90:
        IRoom r42 = r7.b;
        String r43 = r7.k;
        m0 r44 = r7.l;
        boolean r45 = r7.m;
        String r110 = r7.c;
        if (r45 == true) goto L96;
        Intrinsics.checkNotNull(r42);
        if (r6.T3(r42.getOwner()) == true) goto L96;
        boolean r46 = false;
    L97:
        r6.h.setClickable(true);
        if (r43.length() <= 0) goto L100;
        boolean r47 = true;
    L101:
        if (r47 == false) goto L125;
        if (r44 == null) goto L104;
        py.k r48 = r44.getInviteButtonImage();
    L105:
        if (r48 == null) goto L125;
        py.k r49 = r44.getInviteButtonImage();
        if (r49 == null) goto L109;
        List r50 = r49.getUrls();
    L110:
        if (r50 == null) goto L124;
        py.k r52 = r44.getInviteButtonImage();
        if (r52 == null) goto L124;
        List r53 = r52.getUrls();
        if (r53 == null) goto L124;
        if ((!r53.isEmpty()) != true) goto L124;
        HSImageView r54 = r6.i;
        py.k r55 = r44.getInviteButtonImage();
        if (r55 == null) goto L122;
        List r56 = r55.getUrls();
        if (r56 == null) goto L122;
        String r57 = (String) ListProtector.get(r56, 0);
    L123:
        ImageLoader.bindImage(r54, r57);
    L122:
        r57 = null;
    L124:
        ViewGroup.LayoutParams r58 = r6.j.getLayoutParams();
        r58.width = s1.f(80.0f);
        r6.j.setLayoutParams(r58);
        r6.h.setText(r44.getInviteButtonText());
        r6.r.setVisibility(8);
        r6.h.setVisibility(0);
    L132:
        if (r2.a(r110) == false) goto L134;
        r6.h.setText(r110);
    L134:
        if (r9 != null) goto L136;
    L138:
        r6.j.setAlpha(1.0f);
    L139:
        m2 r59 = r6.F;
        if (r59 == null) goto L146;
        Intrinsics.checkNotNull(r59);
        if (r59.getPkStageMedal() == null) goto L146;
        HSImageView r60 = r6.G;
        m2 r62 = r6.F;
        Intrinsics.checkNotNull(r62);
        ImageUtil.loadImage(r60, r62.getPkStageMedal(), 0);
        r6.G.setVisibility(0);
        m2 r63 = r6.F;
        Intrinsics.checkNotNull(r63);
        if (TextUtils.isEmpty(r63.getPkStageDesc()) == true) goto L146;
        HSImageView r64 = r6.G;
        m2 r65 = r6.F;
        Intrinsics.checkNotNull(r65);
        r3.a(r64, r65.getPkStageDesc());
    L146:
        yz0.k r66 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r66 == null) goto L149;
        IRoom r67 = r66.getRoom();
    L150:
        if (r67 == null) goto L154;
        IRivalExtraInfo r68 = r7.f;
        if (r68 == null) goto L154;
        int r69 = r68.getAnchorLayer();
    L155:
        IRivalExtraInfo r70 = r6.D;
        IRoom r72 = r7.b;
        int r73 = r7.e;
        if (r70 == null) goto L179;
        r6.A.put("connection_type", "manual_pk");
        Intrinsics.checkNotNull(r72);
        if (r72.getOwner() == null) goto L160;
        String r74 = iz.a.a(r72.getOwner());
    L161:
        HashMap<String, String> r75 = r6.A;
        if (r73 != 1) goto L165;
        String r76 = "mutual_follow";
    L168:
        r75.put("invitee_list", r76);
        if (r70.getText_type() != IRivalExtraInfo.TextType.Distance.ordinal()) goto L172;
        String r77 = "distance";
    L175:
        r6.A.put("inviter_level", String.valueOf(r69));
        HashMap r78 = new HashMap();
        r78.put(r77, r70.getText());
        r6.A.put("anchor_info", com.bytedance.android.live.revlink.impl.utils.e.b(r78));
        if ((!Intrinsics.areEqual(r6.J, DataType.FALSE)) == false) goto L178;
        r6.A.put("invite_mode", "activity_pk");
        r6.A.put("pk_activity_type", r6.J);
    L178:
        IBattleRivalTag.a r79 = IBattleRivalTag.Companion;
        List<? extends IBattleRivalTag> r80 = r6.I;
        HashMap<String, String> r82 = r6.A;
        r79.getClass();
        IBattleRivalTag.a.a(r80, r82);
        mz0.n r83 = new mz0.n();
        Map<String, String> r84 = r83.a;
        Intrinsics.checkNotNullParameter(r84, "map");
        HashMap<String, String> r85 = r6.A;
        Intrinsics.checkNotNullParameter(r85, "map");
        r84.putAll(r85);
        mz0.m r86 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r87 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r87, "linkInfoLog");
        r87.f(r74);
        ((ArrayList) r86.a).add(r87.a);
        r86.b(LogCommon.ROOM);
        ((ArrayList) r83.b).addAll(r86.a);
        cy0.e.a.getClass();
        cy0.j r88 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r89 = com.bytedance.android.scope.m.b(r88).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r89);
        ((mz0.i) ((f80.a) r89)).w3("livesdk_connection_invite_show", r83.a, r83.b);
        goto L179
    L172:
        if (r70.getText_type() != IRivalExtraInfo.TextType.DistanceCity.ordinal()) goto L174;
        r77 = "city";
        goto L175
    L174:
        r77 = "money";
        goto L175
    L165:
        if (r73 != 110) goto L167;
        r76 = "custom_preference";
        goto L168
    L167:
        r76 = "recommend";
        goto L168
    L160:
        r74 = null;
    L179:
        r6.h.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.k(r6, r7, r6.D, r69, r9));
        IRoom r90 = r7.b;
        String r92 = r7.i;
        int r93 = r7.n;
        String r94 = r7.p;
        HashMap r95 = new HashMap();
        Intrinsics.checkNotNull(r90);
        r95.put("right_user_id", String.valueOf(r90.getAnchorId()));
        r95.put("right_room_id", r90.getIdStr());
        r95.put("connection_type", "manual_pk");
        r95.put("request_id", r92);
        int r96 = UserListInviteType.a;
        r95.put("invitee_list", UserListInviteType.a(r6.z, null));
        r95.put("list_num", String.valueOf(r6.K + 1));
        r95.put("list_type", UserListInviteType.a(r6.z, null));
        if (r9 == null) goto L182;
        r95.put("right_user_status", String.valueOf(r9.getType()));
    L184:
        if ((!Intrinsics.areEqual(r94, DataType.FALSE)) == false) goto L186;
        r95.put("flex_activity_id", r94.toString());
        r95.put("list_type", r94);
        r95.put("invite_status", "live");
    L186:
        r95.put("source", String.valueOf(r93));
        r6.B.putAll(r95);
        m2 r97 = r7.a;
        if (r97 != null) goto L189;
    L196:
        m2 r98 = r7.a;
        if (r98 == null) goto L203;
        p2 r99 = r98.getRankSeasonInfo();
        if (r99 == null) goto L203;
        ImageLoader.bindImage(r6.x, r99.getRankBadge());
        TextView r100 = r6.y;
        if (r100 == null) goto L203;
        r100.setText(r99.getRankDetail());
    L203:
        LinearLayout r101 = r6.w;
        if (r101 == null) goto L212;
        m2 r102 = r7.a;
        if (r102 == null) goto L210;
        p2 r103 = r102.getRankSeasonInfo();
        if (r103 == null) goto L210;
        String r104 = r103.getRankDetail();
    L211:
        ViewUtilsKt.g(r101, !TextUtils.isEmpty(r104));
    L210:
        r104 = null;
        goto L211
    L189:
        if (r2.a(r97.getCanReserve()) == false) goto L195;
        r6.t.setVisibility(0);
        if (r2.a(r97.getReserveDesc()) == false) goto L193;
        r6.u.setText(r97.getReserveDesc());
        r6.u.setVisibility(0);
    L194:
        r6.v.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.j(r6));
        ((TextView) ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131384407)).setText(r97.getCanReserve());
        r6.U3("livesdk_pk_invite_entrance_show");
        goto L196
    L193:
        r6.u.setVisibility(8);
        goto L194
    L195:
        r6.t.setVisibility(8);
        goto L196
    L182:
        r95.put("right_user_status", "2");
    L154:
        r69 = 0;
        goto L155
    L149:
        r67 = null;
        goto L150
    L136:
        if (r9.getForbidden() == false) goto L138;
        r6.j.setAlpha(0.5f);
        goto L139
    L109:
        r50 = null;
        goto L110
    L104:
        r48 = null;
    L125:
        if (r46 == false) goto L128;
        r6.i.setImageResource(2131249790);
        r6.h.setText(2131914739);
        r6.h.setTextColor(s1.h(2131108025));
        r6.r.setVisibility(8);
        r6.h.setVisibility(0);
        goto L132
    L128:
        if (r6.M.isRequesting(r42) == false) goto L130;
        r6.r.setAnimation(AnimationUtils.loadAnimation(r6.r.getContext(), 2130772708));
        r6.r.setVisibility(0);
        r6.h.setVisibility(8);
        goto L132
    L130:
        r6.r.setVisibility(8);
        r6.h.setVisibility(0);
        r6.i.setImageResource(2131249467);
        r6.h.setTextColor(-1);
        ViewGroup.LayoutParams r105 = r6.j.getLayoutParams();
        r105.width = s1.f(64.0f);
        r6.j.setLayoutParams(r105);
        r6.h.setText(2131919636);
        goto L132
    L100:
        r47 = false;
    L96:
        r46 = true;
        goto L97
    L84:
        if (r35.size() == 0) goto L90;
        Context r106 = r6.m.getContext();
        Iterator r107 = r35.iterator();
    L88:
        if (r107.hasNext() == false) goto L90;
        IBattleRivalTag r108 = (IBattleRivalTag) r107.next();
        View r111 = new View(r106);
        r111.setBackgroundColor(ColorProtector.parseColor("#D9D9D9"));
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(s1.f(0.5f), s1.f(7.0f));
        r112.leftMargin = s1.f(4.0f);
        r6.m.addView(r111, r112);
        TextView r113 = new TextView(r106);
        r113.setText(r108.getContent());
        r113.setTextColor(ColorProtector.parseColor("#C0161823"));
        r113.setTextSize(1, 12.0f);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-2, -1);
        r109.leftMargin = s1.f(4.0f);
        r6.m.addView(r113, r109);
    L79:
        r40 = "none";
        goto L81
    L80:
        r40 = "";
        goto L81
    L70:
        r35 = null;
    L66:
        r6.o.setVisibility(8);
        goto L67
    L55:
        if (r23.getText().length() != 0) goto L57;
        boolean r114 = true;
    L58:
        if (r114 == true) goto L60;
        r6.e.setVisibility(0);
        r6.e.setText(r23.getText());
        r6.e.setTextColor(s1.h(2131107359));
        goto L61
    L57:
        r114 = false;
        goto L58
    L52:
        r25 = null;
        goto L53
    L49:
        r6.s.setVisibility(8);
        r6.k.setVisibility(0);
        goto L50
    L38:
        if (r23.getText_type() == IRivalExtraInfo.TextType.Distance.ordinal()) goto L42;
        if (r23.getText_type() != IRivalExtraInfo.TextType.DistanceCity.ordinal()) goto L46;
    L42:
        if (r23.getText() == null) goto L46;
        if (r23.getText().length() <= 0) goto L46;
        r24 = true;
        goto L47
    L28:
        r10 = false;
        goto L29
    L19:
        if (r1.getGender() != 2) goto L21;
        r6.c.setImageResource(2131250687);
        r6.c.setContentDescription(s1.B(2131917069));
        goto L22
    L21:
        r6.c.setVisibility(8);
        goto L22
    L14:
        r9 = null;
    L212:
        com.bytedance.android.live.revlink.impl.pk.utils.m r115 = this.b;
        if (r115 == null) goto L217;
        r115.b();
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "parent");
        if (this.f == false) goto L12;
        LinkRevPanelDataContext r0 = LinkRevPanelDataContext.Companion.getContext();
        if (r0 == null) goto L11;
        Deque<View> r1 = r0.getItemAsyncViews();
        if (r1 == null) goto L11;
        View r2 = r1.poll();
        if (r2 == null) goto L11;
        r2.setLayoutParams(new RecyclerView.LayoutParams(-1, UtilityKotlinExtentionsKt.i(66)));
        Unit r10 = Unit.INSTANCE;
    L14:
        return new PKListUserViewHolder(r2, this.c, this.d, this.e, this.g);
    L11:
        r2 = r8.inflate(2131566289, r9, false);
        goto L14
    L12:
        r2 = r8.inflate(2131566289, r9, false);
        goto L14
    }

    public /* synthetic */ j(com.bytedance.android.live.revlink.impl.pk.utils.m r8, x31.l r9, DataCenter r10, boolean r12, int r13) {
        if ((r13 & 32) == 0) goto L5;
        boolean r6 = false;
    L6:
        this(r8, r9, r10, false, false, r6);
        return;
    L5:
        r6 = r12;
        goto L6
    }

    public j(com.bytedance.android.live.revlink.impl.pk.utils.m r2, x31.l r3, DataCenter r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "mListener");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
