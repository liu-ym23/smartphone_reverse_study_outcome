package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoView;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00042\u00020\u0005:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/MultiLinkRivalsSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkRivalsSearchViewHolder extends RecyclerView.ViewHolder implements Observer<KVData>, com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int w = 0;
    public final VHeadView a;
    public final VHeadView b;
    public final VHeadView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final View h;
    public final HSImageView i;
    public final TextView j;
    public final TextView k;
    public int l;
    public SearchSourceFlag m;
    public final PkTagsContainerView n;
    public final AnchorLinkInfoView o;
    public final Context p;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a q;
    public final com.bytedance.android.live.revlink.impl.pk.service.b r;
    public x8 s;
    public int t;
    public int u;
    public final x31.g v;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        x8 r0 = this.s;
        if (r0 == null) goto L8;
        String r1 = r0.getSecUid();
        if (r1 == null) goto L10;
        return r1;
    L10:
        return "";
    L8:
        return "";
    }

    public static final com.bytedance.android.live.revenuelink.connect.n T3(MultiLinkRivalsSearchViewHolder r4) {
        r4.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.getCurrentMode();
    L7:
        if (v.a(r2, 64) == false) goto L9;
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r3 = r4.q;
        if (r3 == null) goto L22;
        com.bytedance.android.live.revenuelink.connect.n r5 = r3.getLinkOutManagerFn();
    L23:
        if (r5 != null) goto L25;
        return null;
    L25:
        return r4.q.getLinkOutManagerFn();
    L22:
        r5 = null;
        goto L23
    L9:
        if (r4.m != SearchSourceFlag.MAIN_LINK) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.b r6 = r4.r;
        if (r6 == null) goto L16;
        com.bytedance.android.live.revenuelink.connect.n r7 = r6.getLinkOutManagerFn();
    L17:
        if (r7 != null) goto L27;
        return null;
    L27:
        return r4.r.getLinkOutManagerFn();
    L16:
        r7 = null;
        goto L17
    L5:
        r2 = 0;
        goto L7
    }

    public static final int U3(MultiLinkRivalsSearchViewHolder r3) {
        r3.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.getCurrentMode();
    L7:
        if (v.a(r2, 64) == false) goto L9;
    L12:
        return 7;
    L9:
        if (r3.m != SearchSourceFlag.MAIN_LINK) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L12;
        return 1;
    L5:
        r2 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r6) {
        Intrinsics.checkNotNullParameter(r6, "panelType");
        x8 r0 = this.s;
        if (r0 == null) goto L49;
        Intrinsics.checkNotNull(r0);
        if (r0.getRoom() == null) goto L50;
        x8 r1 = this.s;
        Intrinsics.checkNotNull(r1);
        if (r1.getRoomId() == 0) goto L51;
        x8 r2 = this.s;
        Intrinsics.checkNotNull(r2);
        IRoom r3 = r2.getRoom();
        LinkedHashMap r4 = new LinkedHashMap();
        String r5 = iz.a.a(r3.getOwner());
        String r7 = "";
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r4.put("right_user_id", r5);
        r4.put("right_room_id", r3.getIdStr());
        int r8 = UserListInviteType.a;
        r4.put("list_type", UserListInviteType.a(this.l, null));
        r4.put("right_user_status", String.valueOf(this.t));
        r4.put("invitee_list", "search");
        r4.put("list_num", String.valueOf(this.u + 1));
        if (com.bytedance.android.live.revlink.impl.global.b.f() == null) goto L18;
        com.bytedance.android.live.revlink.impl.control.d r9 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r9 == null) goto L18;
        String r10 = r9.getRequestId();
        if (r10 == null) goto L18;
    L19:
        r4.put("request_id", r10);
        r4.put("enter_from", r6);
        SearchSourceFlag r12 = this.m;
        if (r12 != null) goto L23;
    L24:
        String r13 = "link_banner";
    L30:
        r4.put("source", r13);
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L33;
        String r15 = r14.f();
    L34:
        r4.put("invite_mode", r15);
        d31.d r16 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r16 == null) goto L37;
        String r17 = r16.d();
    L38:
        r4.put("battle_mode", r17);
        d31.d r18 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r18 == null) goto L42;
        r18.r(r4);
    L42:
        if (y.b() == true) goto L44;
        r4.put("connection_type", "manual_link");
    L44:
        d31.d r19 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r19 == null) goto L47;
        r7 = r19.s();
    L47:
        r4.put("room_status", r7);
        mz0.n r20 = new mz0.n();
        Map<String, String> r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r22.putAll(r4);
        mz0.m r23 = new mz0.m();
        r23.b(LogCommon.ROOM);
        List<Object> r24 = r20.b;
        ArrayList r25 = (ArrayList) r24;
        r25.addAll(r23.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((mz0.i) ((f80.a) r27)).w3("livesdk_connectioninvite_anchoricon_show", r20.a, r20.b);
        return;
    L37:
        r17 = "";
        goto L38
    L33:
        r15 = "";
        goto L34
    L23:
        if (g.a[r12.ordinal()] != 1) goto L24;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r28 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r28 == null) goto L29;
        r13 = r28.a;
        if (r13 != null) goto L30;
    L29:
        r13 = "";
    L18:
        r10 = "";
        goto L19
    L51:
        return;
    L50:
        return;
    }

    public final boolean V3(IBaseUser r4) {
        i11.b r0 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r0 == null) goto L12;
        if (r4 == null) goto L17;
        Iterator<IBaseUser> r1 = r0.n().iterator();
    L7:
        if (r1.hasNext() == false) goto L18;
        if (TextUtils.equals(iz.a.a(r1.next()), iz.a.a(r4)) == false) goto L7;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        return false;
    }

    public final boolean W3(IBaseUser r4) {
        i11.b r0 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r0 == null) goto L12;
        if (r4 == null) goto L17;
        Iterator<IBaseUser> r1 = r0.getInviteeList().iterator();
    L7:
        if (r1.hasNext() == false) goto L18;
        if (TextUtils.equals(iz.a.a(r1.next()), iz.a.a(r4)) == false) goto L7;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        return false;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    public MultiLinkRivalsSearchViewHolder(View r2, x31.g r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "mListener");
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        super(r2);
        this.v = r3;
        this.a = r2.findViewById(2131374267);
        this.b = r2.findViewById(2131392206);
        this.c = r2.findViewById(2131376272);
        this.d = (ImageView) r2.findViewById(2131378545);
        this.e = (TextView) r2.findViewById(2131390993);
        this.f = (TextView) r2.findViewById(2131391425);
        this.g = (TextView) r2.findViewById(2131390604);
        this.h = r2.findViewById(2131375598);
        this.i = r2.findViewById(2131376326);
        this.j = (TextView) r2.findViewById(2131390810);
        this.k = (TextView) r2.findViewById(2131391655);
        this.n = (PkTagsContainerView) r2.findViewById(2131388160);
        this.o = (AnchorLinkInfoView) r2.findViewById(2131392543);
        this.p = r2.getContext();
        this.q = com.bytedance.android.live.revlink.impl.global.b.t();
        this.r = com.bytedance.android.live.revlink.impl.global.b.N();
    }
}
