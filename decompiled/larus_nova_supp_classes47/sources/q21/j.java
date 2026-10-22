package q21;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.MultiLinkRivalsSearchViewHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.revlink.impl.pk.utils.m;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.t5;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends me.drakeet.multitype.b<a, MultiLinkRivalsSearchViewHolder> {
    public final m b;
    public final x31.g c;
    public final DataCenter d;
    public final SearchSourceFlag e;

    public static final class a {
        public x8 a;
        public int b;

        public a() {
        }
    }

    public final void g(RecyclerView.ViewHolder r2) {
        MultiLinkRivalsSearchViewHolder r3 = (MultiLinkRivalsSearchViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.n.c = 0;
    }

    public final void b(RecyclerView.ViewHolder r25, Object r26) {
        MultiLinkRivalsSearchViewHolder r1 = (MultiLinkRivalsSearchViewHolder) r25;
        a r2 = (a) r26;
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "item");
        x8 r3 = r2.a;
        SearchSourceFlag r4 = this.e;
        int r5 = r2.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "searchSourceFlag");
        if (r3 == null) goto L163;
        r1.m = r4;
        r1.l = 5;
        r1.s = r3;
        r1.u = r5;
        a1.x(r1.a, r3.getAvatarThumb(), r1.a.getWidth(), r1.a.getHeight(), 2131250965);
        r1.e.setText(r3.getNickName());
        KmpEnv r6 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L8;
        r1.f.setText(s1.C(2131917782, new Object[]{r3.getDisplayId()}));
        r1.f.setVisibility(0);
    L9:
        r1.g.setText(s1.C(2131917783, new Object[]{IESUIUtils.getDisplayCount(r3.getFansNum(), "w")}));
        if (r3.getRoomId() == 0) goto L12;
        r1.d.setVisibility(0);
    L14:
        if (StringUtils.isEmpty(r3.getCustomVerify()) == true) goto L16;
        r1.b.setVisibility(0);
    L18:
        if (r3.getGender() != 1) goto L21;
        r1.c.setImageResource(2131250688);
        r1.c.setVisibility(0);
    L24:
        r1.i.setImageResource(2131249467);
        r1.j.setText(2131917780);
        r1.j.setTextColor(ColorProtector.parseColor("#ffffff"));
        if (r3.getRoomId() != 0) goto L27;
        r1.h.setVisibility(8);
        r1.k.setText(2131917949);
        r1.k.setVisibility(0);
    L27:
        ViewGroup.LayoutParams r7 = r1.h.getLayoutParams();
        r7.width = s1.f(64.0f);
        r1.h.setLayoutParams(r7);
        ArrayList r8 = new ArrayList();
        Long r23 = null;
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L60;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r15 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r15 == null) goto L32;
        i11.b r16 = r15.getLinkUserCenter();
    L33:
        if (r16 == null) goto L60;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r17 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r17 == null) goto L163;
        i11.b r18 = r17.getLinkUserCenter();
        if (r18 == null) goto L163;
        List<p> r19 = r18.d();
        String r9 = r3.getUserId();
        if (r19 == null) goto L52;
        Iterator<p> r110 = r19.iterator();
    L44:
        if (r110.hasNext() == false) goto L52;
        p r111 = r110.next();
        IBaseUser r112 = r111.getUser();
        if (r112 == null) goto L52;
        if (TextUtils.equals(iz.a.a(r112), r9) == false) goto L44;
    L53:
        if (r111 == null) goto L60;
        if (r111.getStatus() != 2) goto L58;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131914731);
        goto L60
    L58:
        if (r111.getStatus() != 1) goto L60;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131914827);
    L52:
        r111 = null;
        goto L53
    L32:
        r16 = null;
    L60:
        List r10 = r3.getTags();
        Intrinsics.checkNotNull(r10);
        r8.addAll(r10);
        r1.n.setOldTag(true);
        PkTagsContainerView.f(r1.n, r8, false, null, 9, "", 32);
        ArrayList r12 = new ArrayList();
        if (r3.getRivalExtraInfo() == null) goto L72;
        IRivalExtraInfo r13 = r3.getRivalExtraInfo();
        Intrinsics.checkNotNull(r13);
        if (r13.getLinkerInfo() == null) goto L72;
        IRivalExtraInfo r14 = r3.getRivalExtraInfo();
        Intrinsics.checkNotNull(r14);
        d6 r20 = r14.getLinkerInfo();
        Intrinsics.checkNotNull(r20);
        if (Lists.isEmpty(r20.getLinkedUserInfos()) == true) goto L72;
        IRivalExtraInfo r22 = r3.getRivalExtraInfo();
        Intrinsics.checkNotNull(r22);
        d6 r24 = r22.getLinkerInfo();
        Intrinsics.checkNotNull(r24);
        List r27 = r24.getLinkedUserInfos();
        Intrinsics.checkNotNull(r27);
        Iterator r28 = r27.iterator();
    L68:
        if (r28.hasNext() == false) goto L72;
        t5 r113 = (t5) r28.next();
        if (TextUtils.equals(r113.getUserId(), r3.getUserId()) == true) goto L68;
        r12.add(r113);
    L72:
        String r114 = "";
        if (r12.size() != 0) goto L76;
        r1.o.setVisibility(8);
    L80:
        String r29 = "";
    L82:
        if (r12.size() <= 1) goto L84;
        com.bytedance.live.kmp.util.c r30 = com.bytedance.live.kmp.util.c.a;
        int r32 = w11.a.a;
        r114 = com.bytedance.live.kmp.util.c.a(2131914769, new Object[]{Integer.valueOf(r12.size())});
    L84:
        StringBuilder r33 = new StringBuilder();
        com.bytedance.live.kmp.util.c r115 = com.bytedance.live.kmp.util.c.a;
        int r116 = w11.a.a;
        r33.append(com.bytedance.live.kmp.util.c.a(2131914768, new Object[]{r29}));
        r33.append(r114);
        r33.append(r3.getRoomStatusDesc());
        SpannableStringBuilder r117 = new SpannableStringBuilder(r33.toString());
        r117.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#161823")), 2, r29.length() + 2, 33);
        IRoom r34 = r3.getRoom();
        r1.o.getTvAnchorLinkInfo().setText(r117);
        r1.h.setOnClickListener(new com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.m(r1, r3));
        if (r3.getRoomId() == 0) goto L159;
        if (TextUtils.isEmpty(r3.getLinkText()) == true) goto L92;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(r3.getLinkText());
        r1.t = 7;
        if (r3.getLinkStatus() != 4) goto L159;
        r1.t = 5;
        goto L159
    L92:
        if (r34.getLinkMap() == null) goto L154;
        if (r34.getLinkMap().isEmpty() == true) goto L154;
        if (r34.getLinkMap().containsKey(String.valueOf(4)) == false) goto L100;
        if (r34.getLinkMap().size() == 1) goto L154;
    L100:
        if (((IRoomLinkExt) r34.castTo(IRoomLinkExt.class)).getLinkerDetail() == null) goto L109;
        z5 r35 = ((IRoomLinkExt) r34.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r35 == null) goto L104;
        String r36 = r35.getFunctionType2();
    L106:
        if (TextUtils.equals(r36, "new_audience") == false) goto L109;
    L104:
        r36 = null;
    L109:
        if (r34.getLinkMap().containsKey(String.valueOf(7)) == false) goto L159;
        z5 r37 = ((IRoomLinkExt) r34.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r37 == null) goto L117;
        List r38 = r37.getPlayModes();
        if (r38 == null) goto L117;
        if (r38.contains(27L) != true) goto L117;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131914811);
        r1.t = 8;
    L117:
        z5 r39 = ((IRoomLinkExt) r34.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r39 == null) goto L124;
        List r40 = r39.getPlayModes();
        if (r40 == null) goto L124;
        if (r40.contains(3L) != true) goto L124;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131914788);
        r1.t = 1;
    L124:
        z5 r42 = ((IRoomLinkExt) r34.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r42 == null) goto L130;
        if (r42.getForbidApplyFromOther() != true) goto L130;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131920532);
    L130:
        if (r4 != SearchSourceFlag.INVITE_LINKING) goto L136;
        if (r12.size() != (r41.f.b - 1)) goto L134;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131914724);
        r1.t = 6;
        goto L159
    L134:
        r1.h.setVisibility(0);
        r1.k.setVisibility(8);
        r1.i.setImageResource(2131249467);
        r1.j.setText(2131917780);
        r1.j.setTextColor(ColorProtector.parseColor("#ffffff"));
        r1.t = 3;
        goto L159
    L136:
        if (r12.size() != (r41.f.b - 1)) goto L139;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131914724);
        r1.t = 6;
        goto L159
    L139:
        if (r1.V3(r34.getOwner()) == false) goto L141;
        r1.h.setVisibility(0);
        r1.k.setVisibility(8);
        r1.i.setImageResource(2131249714);
        r1.j.setText(2131914738);
        r1.j.setTextColor(ColorProtector.parseColor("#161823"));
    L152:
        r1.t = 4;
        goto L159
    L141:
        LinkCrossRoomDataHolder r43 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r43 != null) goto L144;
    L145:
        Long r44 = (Long) r34.getLinkMap().get(String.valueOf(7));
        LinkCrossRoomDataHolder r45 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r45 == null) goto L149;
        r23 = Long.valueOf(r45.c());
    L149:
        if (Intrinsics.areEqual(r44, r23) == false) goto L151;
        r1.h.setVisibility(8);
        r1.k.setVisibility(0);
        r1.k.setText(2131914731);
    L151:
        r1.h.setVisibility(0);
        r1.k.setVisibility(8);
        r1.i.setImageResource(2131249467);
        r1.j.setText(2131914726);
        r1.j.setTextColor(ColorProtector.parseColor("#ffffff"));
        goto L152
    L144:
        if (r43.c() == 0) goto L151;
    L154:
        if (r1.W3(r34.getOwner()) == false) goto L156;
        r1.h.setVisibility(0);
        r1.k.setVisibility(8);
        r1.i.setImageResource(2131249714);
        r1.j.setText(2131914739);
        r1.j.setTextColor(ColorProtector.parseColor("#161823"));
    L157:
        r1.t = 3;
        goto L159
    L156:
        r1.h.setVisibility(0);
        r1.k.setVisibility(8);
        r1.i.setImageResource(2131249467);
        r1.j.setText(2131917780);
        r1.j.setTextColor(ColorProtector.parseColor("#ffffff"));
    L159:
        if (iz.a.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b()) == null) goto L163;
        if (TextUtils.equals(iz.a.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b()), r3.getUserId()) == false) goto L163;
        r1.h.setVisibility(8);
        r1.k.setText(2131917948);
        r1.k.setVisibility(0);
        goto L163
    L76:
        if (r12.size() < 1) goto L80;
        r1.o.setVisibility(0);
        r1.o.getIvAnchorAvatar1().setVisibility(0);
        a1.x(r1.o.getIvAnchorAvatar1(), ((t5) ListProtector.get(r12, 0)).getAvatarThumb(), r1.o.getIvAnchorAvatar1().getWidth(), r1.o.getIvAnchorAvatar1().getHeight(), 2131250965);
        r29 = ((t5) ListProtector.get(r12, 0)).getNickName();
        if (r29.length() <= 10) goto L82;
        r29 = r29.substring(0, 9) + "...";
        goto L82
    L21:
        if (r3.getGender() != 2) goto L23;
        r1.c.setImageResource(2131250687);
        r1.c.setVisibility(0);
        goto L24
    L23:
        r1.c.setVisibility(8);
        goto L24
    L16:
        r1.b.setVisibility(8);
        goto L18
    L12:
        r1.d.setVisibility(8);
        goto L14
    L8:
        r1.f.setVisibility(8);
    L163:
        m r46 = this.b;
        if (r46 == null) goto L175;
        r46.b();
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new MultiLinkRivalsSearchViewHolder(r4.inflate(2131566332, r5, false), this.c, this.d);
    }

    public j(m r2, x31.g r3, DataCenter r4, SearchSourceFlag r5) {
        Intrinsics.checkNotNullParameter(r3, "mListener");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "searchSourceFlag");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
