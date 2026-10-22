package com.bytedance.android.live.profit.fansclub.widget.entrance;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.e;
import com.bytedance.android.live.profit.fansclub.f;
import com.bytedance.android.live.profit.fansclub.l;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.profit.fansclub.widget.entrance.data.i;
import com.bytedance.android.live.profit.fansclub.widget.entrance.data.k;
import com.bytedance.android.live.revenue.core.a;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import eu0.j0;
import fu0.b;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import yt0.c;
import yt0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class EntranceUtilsKt {
    public static final j0 a() {
        String r2 = s1.B(2131919072);
        Object[] r3 = new Object[2];
        o r4 = c.c();
        if (r4 == null) goto L9;
        m<e> r5 = r4.getParticipateIncentive();
        if (r5 == null) goto L9;
        e r6 = (e) r5.getValue();
        if (r6 == null) goto L9;
        long r7 = r6.a;
    L10:
        r3[0] = Long.valueOf(r7);
        o r8 = c.c();
        if (r8 == null) goto L18;
        m<e> r9 = r8.getParticipateIncentive();
        if (r9 == null) goto L18;
        e r10 = (e) r9.getValue();
        if (r10 == null) goto L18;
        String r12 = r10.b;
        if (r12 == null) goto L18;
    L19:
        r3[1] = r12;
        return new j0(new k(r2, s1.C(2131919071, r3)));
    L18:
        r12 = s1.B(2131917125);
    L9:
        r7 = 0;
        goto L10
    }

    public static final void b(final a r18, DataCenter r19) {
        Intrinsics.checkNotNullParameter(r18, "inst");
        i r1 = b.a(r19);
        if (r1 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r1, "dataSource");
        boolean r3 = false;
        if (iy0.e.b(r1.getRoom()) == true) goto L8;
    L27:
        if (r3 == false) goto L31;
        FansClubEntranceParams.Page r2 = FansClubEntranceParams.Page.FansGroup;
    L34:
        final FansClubEntranceParams r4 = new FansClubEntranceParams(r2, r1.L(), "fans_club_button", "top", FansClubEntranceParams.Entrance.UserInfoFansClubWidget, false, null, 464);
        UtilityKotlinExtentionsKt.s(0, false, false, new EntranceUtilsKt$openLiveFansClubPanel$1(r18, r4), 7);
        return;
    L31:
        if (com.bytedance.android.live.profit.fansclub.i.a() == false) goto L33;
        r2 = FansClubEntranceParams.Page.FansClub;
        goto L34
    L33:
        r2 = FansClubEntranceParams.Page.Default;
        goto L34
    L8:
        if (((String) com.bytedance.android.live.profit.fansclub.i.q.getValue(null, com.bytedance.android.live.profit.fansclub.i.a[14])).length() != 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L27;
        o r6 = d.a(r1.f).a();
        if (r6 == null) goto L18;
        m<? extends l> r7 = r6.getFansGroupInfo();
        if (r7 == null) goto L18;
        l r8 = (l) r7.getValue();
    L19:
        if (r8 == null) goto L27;
        if (r8.a == false) goto L27;
        String r9 = r1.n().getCurrentUserId();
        com.bytedance.tools.kcp.spongepreference.runtime.a r10 = f.e;
        KProperty[] r12 = f.a;
        List r13 = (List) r10.getValue(null, r12[3]);
        if (r13.contains(r9) == true) goto L26;
        r13.add(r9);
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r10.setValue(null, r12[3], r13);
        r3 = true;
        goto L27
    L26:
        r3 = !r8.c;
    L18:
        r8 = null;
        goto L19
    L10:
        r5 = false;
        goto L11
    }
}
