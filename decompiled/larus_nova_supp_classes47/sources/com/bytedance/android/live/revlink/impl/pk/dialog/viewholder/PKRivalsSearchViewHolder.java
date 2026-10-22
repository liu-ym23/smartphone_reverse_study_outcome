package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKRivalsSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int r = 0;
    public final VHeadView a;
    public final VHeadView b;
    public final ImageView c;
    public final HSImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final View h;
    public final HSImageView i;
    public final TextView j;
    public final TextView k;
    public int l;
    public final PkTagsContainerView m;
    public x8 n;
    public boolean o;
    public int p;
    public final x31.g q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        x8 r0 = this.n;
        if (r0 == null) goto L8;
        String r1 = r0.getSecUid();
        if (r1 == null) goto L10;
        return r1;
    L10:
        return "";
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r6) {
        Intrinsics.checkNotNullParameter(r6, "panelType");
        x8 r0 = this.n;
        if (r0 == null) goto L38;
        Intrinsics.checkNotNull(r0);
        if (r0.getRoom() == null) goto L39;
        x8 r1 = this.n;
        Intrinsics.checkNotNull(r1);
        if (r1.getRoomId() == 0) goto L40;
        x8 r2 = this.n;
        Intrinsics.checkNotNull(r2);
        IRoom r3 = r2.getRoom();
        HashMap r4 = new HashMap();
        r4.put("right_user_id", String.valueOf(r3.getAnchorId()));
        r4.put("right_room_id", r3.getIdStr());
        r4.put("connection_type", "manual_pk");
        int r5 = UserListInviteType.a;
        String r7 = null;
        r4.put("list_type", UserListInviteType.a(this.l, null));
        if (this.o == false) goto L12;
        String r8 = "2";
    L13:
        r4.put("right_user_status", r8);
        String r9 = "";
        if (com.bytedance.android.live.revlink.impl.global.b.f() == null) goto L18;
        com.bytedance.android.live.revlink.impl.control.d r10 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r10 == null) goto L19;
        r7 = r10.getRequestId();
    L19:
        if (r7 != null) goto L21;
        r7 = "";
    L21:
        r4.put("request_id", r7);
        r4.put("invitee_list", "search");
        r4.put("list_num", String.valueOf(this.p + 1));
        r4.put("enter_from", r6);
        r4.put("source", "pk_banner");
        d31.d r12 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r12 == null) goto L24;
        String r13 = r12.f();
    L25:
        r4.put("invite_mode", r13);
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L28;
        String r15 = r14.d();
    L29:
        r4.put("battle_mode", r15);
        d31.d r16 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r16 == null) goto L32;
        String r17 = r16.s();
    L33:
        r4.put("room_status", r17);
        d31.d r18 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r18 == null) goto L36;
        r9 = r18.b();
    L36:
        r4.put("connection_sub_type", r9);
        mz0.n r19 = new mz0.n();
        Map<String, String> r20 = r19.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r20.putAll(r4);
        mz0.m r22 = new mz0.m();
        r22.b(LogCommon.ROOM);
        List<Object> r23 = r19.b;
        ArrayList r24 = (ArrayList) r23;
        r24.addAll(r22.a);
        cy0.e.a.getClass();
        cy0.j r25 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r26 = com.bytedance.android.scope.m.b(r25).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r26);
        ((mz0.i) ((f80.a) r26)).w3("livesdk_connectioninvite_anchoricon_show", r19.a, r19.b);
        return;
    L32:
        r17 = "";
        goto L33
    L28:
        r15 = "";
        goto L29
    L24:
        r13 = "";
        goto L25
    L18:
        r7 = "";
        goto L19
    L12:
        r8 = DataType.TRUE;
        goto L13
    L40:
        return;
    L39:
        return;
    }

    public final boolean T3(String r3) {
        i11.b r0 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r0 == null) goto L11;
        Iterator<IBaseUser> r1 = r0.getInviteeList().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        if (TextUtils.equals(iz.a.a(r1.next()), r3) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public PKRivalsSearchViewHolder(View r2, x31.g r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "mListener");
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        super(r2);
        this.q = r3;
        this.a = r2.findViewById(2131374267);
        this.b = r2.findViewById(2131392206);
        this.c = (ImageView) r2.findViewById(2131378545);
        this.d = r2.findViewById(2131378543);
        this.e = (TextView) r2.findViewById(2131390993);
        this.f = (TextView) r2.findViewById(2131391425);
        this.g = (TextView) r2.findViewById(2131390604);
        this.h = r2.findViewById(2131375598);
        this.i = r2.findViewById(2131376326);
        this.j = (TextView) r2.findViewById(2131390810);
        this.k = (TextView) r2.findViewById(2131391655);
        this.m = (PkTagsContainerView) r2.findViewById(2131388160);
    }
}
