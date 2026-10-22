package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoView;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/MultiAnchorInviteListUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorInviteListUserViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int D = 0;
    public int A;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.d B;
    public final x31.m C;
    public final View a;
    public final VHeadView b;
    public final VHeadView c;
    public final TextView d;
    public final TextView e;
    public final ImageView f;
    public final TextView g;
    public final HSImageView h;
    public final View i;
    public final View j;
    public final PkTagsContainerView k;
    public final View l;
    public final HSImageView m;
    public final HSImageView n;
    public final AnchorLinkInfoView o;
    public final TextView p;
    public int q;
    public boolean r;
    public final HashMap<String, String> s;
    public final Map<String, String> t;
    public IRoom u;
    public IRivalExtraInfo v;
    public String w;
    public m2 x;
    public boolean y;
    public final Map<Integer, String> z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        IRoom r0 = this.u;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return r0.getIdStr();
    L5:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r4) {
        Intrinsics.checkNotNullParameter(r4, "panelType");
        if (this.C != null) goto L5;
    L11:
        this.t.put("enter_button", r4);
        this.t.put("enter_from", r4);
        Map<String, String> r5 = this.t;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r0 = com.bytedance.android.live.revlink.impl.global.b.H();
        String r1 = "";
        if (r0 == null) goto L14;
        String r2 = r0.i(this.y);
    L15:
        r5.put("random_npk_status", r2);
        Map<String, String> r6 = this.t;
        if (com.bytedance.android.live.revlink.impl.global.b.v() == null) goto L18;
        String r3 = q.e(this.x);
    L19:
        r6.put("invite_status", r3);
        Map<String, String> r7 = this.t;
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L22;
        String r8 = "pk_participate";
    L23:
        r7.put("source", r8);
        Map<String, String> r9 = this.t;
        d31.d r10 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r10 == null) goto L26;
        String r12 = r10.f();
    L27:
        r9.put("invite_mode", r12);
        Map<String, String> r13 = this.t;
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L30;
        String r15 = r14.d();
    L31:
        r13.put("battle_mode", r15);
        Map<String, String> r16 = this.t;
        d31.d r17 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r17 == null) goto L34;
        String r18 = r17.s();
    L35:
        r16.put("room_status", r18);
        Map<String, String> r19 = this.t;
        d31.d r20 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r20 == null) goto L38;
        r1 = r20.b();
    L38:
        r19.put("connection_sub_type", r1);
        mz0.n r22 = new mz0.n();
        Map<String, String> r23 = r22.a;
        Intrinsics.checkNotNullParameter(r23, "map");
        Map<String, String> r24 = this.t;
        Intrinsics.checkNotNullParameter(r24, "map");
        r23.putAll(r24);
        mz0.m r25 = new mz0.m();
        r25.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder.a r26 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r25);
        List<Object> r27 = r22.b;
        ArrayList r28 = (ArrayList) r27;
        r28.addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r30 = com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r30);
        ((mz0.i) ((f80.a) r30)).w3("livesdk_connectioninvite_anchoricon_show", r22.a, r22.b);
        return;
    L34:
        r18 = "";
        goto L35
    L30:
        r15 = "";
        goto L31
    L26:
        r12 = "";
        goto L27
    L22:
        r8 = "link_participate";
        goto L23
    L18:
        r3 = "";
        goto L19
    L14:
        r2 = "";
        goto L15
    L5:
        if (r4 != "find") goto L11;
        IRoom r32 = this.u;
        if (r32 == null) goto L11;
        Intrinsics.checkNotNull(r32);
        if (TextUtils.isEmpty(r32.getIdStr()) == true) goto L11;
        x31.m r33 = this.C;
        IRoom r34 = this.u;
        Intrinsics.checkNotNull(r34);
        r33.UC(r34.getIdStr(), this.q);
        goto L11
    }

    public MultiAnchorInviteListUserViewHolder(View r2, x31.m r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        super(r2);
        this.C = r3;
        this.a = r2.findViewById(2131374268);
        VHeadView r5 = r2.findViewById(2131382434);
        this.b = r2.findViewById(2131374267);
        this.c = r2.findViewById(2131373623);
        this.d = (TextView) r2.findViewById(2131390993);
        this.e = (TextView) r2.findViewById(2131389459);
        this.f = (ImageView) r2.findViewById(2131389458);
        this.g = (TextView) r2.findViewById(2131390810);
        this.h = r2.findViewById(2131376326);
        this.i = r2.findViewById(2131375598);
        this.j = r2.findViewById(2131369197);
        this.k = (PkTagsContainerView) r2.findViewById(2131388160);
        this.l = r2.findViewById(2131373881);
        this.m = r2.findViewById(2131376275);
        this.n = r2.findViewById(2131376355);
        this.o = (AnchorLinkInfoView) r2.findViewById(2131384665);
        this.p = (TextView) r2.findViewById(2131391655);
        this.s = new HashMap();
        this.t = new LinkedHashMap();
        this.y = true;
        LinkedHashMap r6 = new LinkedHashMap();
        this.z = r6;
        this.B = com.bytedance.android.live.revlink.impl.global.b.z();
        r6.put(101, "mutual_follow");
        r6.put(102, "recommend");
    }
}
