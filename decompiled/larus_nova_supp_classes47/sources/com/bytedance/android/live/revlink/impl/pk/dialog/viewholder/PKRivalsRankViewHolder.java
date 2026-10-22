package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKRivalsRankViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsRankViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public final VHeadView a;
    public final VHeadView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final Button f;
    public final TextView g;
    public final View h;
    public final View i;
    public final View j;
    public int k;
    public final PkTagsContainerView l;
    public m2 m;
    public IRoom n;
    public final Context o;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a p;
    public final com.bytedance.android.live.revlink.impl.pk.service.b q;
    public final HashMap<String, String> r;
    public boolean s;
    public SearchSourceFlag t;
    public int u;
    public final x31.h v;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        IRoom r0 = this.n;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return r0.getIdStr();
    L5:
        return "";
    }

    public static final com.bytedance.android.live.revenuelink.connect.n T3(PKRivalsRankViewHolder r4) {
        r4.getClass();
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.getCurrentMode();
    L7:
        if (v.a(r2, 64) == false) goto L9;
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r3 = r4.p;
        if (r3 == null) goto L22;
        com.bytedance.android.live.revenuelink.connect.n r5 = r3.getLinkOutManagerFn();
    L23:
        if (r5 != null) goto L25;
        return null;
    L25:
        return r4.p.getLinkOutManagerFn();
    L22:
        r5 = null;
        goto L23
    L9:
        if (r4.t != SearchSourceFlag.MAIN_LINK) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.b r6 = r4.q;
        if (r6 == null) goto L16;
        com.bytedance.android.live.revenuelink.connect.n r7 = r6.getLinkOutManagerFn();
    L17:
        if (r7 != null) goto L27;
        return null;
    L27:
        return r4.q.getLinkOutManagerFn();
    L16:
        r7 = null;
        goto L17
    L5:
        r2 = 0;
        goto L7
    }

    public static final int U3(PKRivalsRankViewHolder r3) {
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
        if (r3.t != SearchSourceFlag.MAIN_LINK) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L12;
        return 1;
    L5:
        r2 = 0;
        goto L7
    }

    public static boolean Y3(IRoom r2) {
        if (r2.getLinkMap() != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getLinkMap().containsKey(String.valueOf(1)) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r6) {
        Intrinsics.checkNotNullParameter(r6, "panelType");
        m2 r0 = this.m;
        if (r0 == null) goto L42;
        Intrinsics.checkNotNull(r0);
        if (r0.getRoom() == null) goto L43;
        m2 r1 = this.m;
        Intrinsics.checkNotNull(r1);
        IRoom r2 = r1.getRoom();
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("right_user_id", String.valueOf(r2.getAnchorId()));
        r3.put("right_room_id", r2.getIdStr());
        r3.put("connection_type", "manual_pk");
        int r4 = UserListInviteType.a;
        r3.put("list_type", UserListInviteType.a(this.k, null));
        if (Y3(r2) == false) goto L10;
    L15:
        r3.put("right_user_status", DataType.TRUE);
    L16:
        String r5 = "";
        if (com.bytedance.android.live.revlink.impl.global.b.f() == null) goto L22;
        com.bytedance.android.live.revlink.impl.control.d r7 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r7 == null) goto L21;
        String r8 = r7.getRequestId();
    L23:
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        r3.put("request_id", r8);
        r3.put("enter_from", r6);
        d31.d r9 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r9 == null) goto L28;
        String r10 = r9.f();
    L29:
        r3.put("invite_mode", r10);
        d31.d r12 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r12 == null) goto L32;
        String r13 = r12.d();
    L33:
        r3.put("battle_mode", r13);
        r3.put("invitee_list", UserListInviteType.a(this.k, null));
        r3.put("list_num", String.valueOf(this.u + 1));
        r3.putAll(this.r);
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L36;
        String r15 = r14.s();
    L37:
        r3.put("room_status", r15);
        d31.d r16 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r16 == null) goto L40;
        r5 = r16.b();
    L40:
        r3.put("connection_sub_type", r5);
        mz0.n r17 = new mz0.n();
        Map<String, String> r18 = r17.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r18.putAll(r3);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        ((ArrayList) r17.b).addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_connectioninvite_anchoricon_show", r17.a, r17.b);
        return;
    L36:
        r15 = "";
        goto L37
    L32:
        r13 = "";
        goto L33
    L28:
        r10 = "";
        goto L29
    L21:
        r8 = null;
        goto L23
    L22:
        r8 = "";
        goto L23
    L10:
        if (Z3(r2) == true) goto L15;
        if (X3(r2) == true) goto L15;
        r3.put("right_user_status", "2");
        goto L16
    L43:
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

    public final boolean X3(IRoom r2) {
        if (r2.getLinkMap() != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getLinkMap().containsKey(String.valueOf(7)) == false) goto L7;
        return true;
    }

    public final boolean Z3(IRoom r2) {
        if (r2.getLinkMap() != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getLinkMap().containsKey(String.valueOf(8)) == false) goto L7;
        return true;
    }

    public PKRivalsRankViewHolder(View r2, x31.h r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "mListener");
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        super(r2);
        this.v = r3;
        this.a = r2.findViewById(2131374267);
        this.b = r2.findViewById(2131373623);
        this.c = (TextView) r2.findViewById(2131390993);
        this.d = (TextView) r2.findViewById(2131390632);
        this.e = (TextView) r2.findViewById(2131389459);
        this.f = (Button) r2.findViewById(2131364600);
        this.g = (TextView) r2.findViewById(2131391655);
        this.h = r2.findViewById(2131389650);
        this.i = r2.findViewById(2131376010);
        this.j = r2.findViewById(2131376245);
        this.l = (PkTagsContainerView) r2.findViewById(2131388160);
        this.o = r2.getContext();
        this.p = com.bytedance.android.live.revlink.impl.global.b.t();
        this.q = com.bytedance.android.live.revlink.impl.global.b.N();
        this.r = new HashMap();
    }
}
