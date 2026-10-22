package zz1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements oc6.k, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void openJoinFansClubPage() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.a r0 = this.a;
        com.bytedance.android.live.profit.fansclub.o r1 = r0.e;
        if (r1 == null) goto L10;
        if (r1.R2() != FansClubUserStatus.Inactive.getValue()) goto L10;
        if (by0.b.a(r0.g.d()) == false) goto L10;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(s1.getContext(), r0.g.d());
        return;
    L10:
        if (nz1.a.c() == false) goto L12;
        FansClubEntranceParams.Page r2 = FansClubEntranceParams.Page.FansClub;
    L13:
        FansClubEntranceParams.Page r3 = r2;
        String r9 = r0.j.a.getIdString();
        com.bytedance.android.live.profit.fansclub.o r4 = r0.e;
        if (r4 == null) goto L18;
        p r5 = r4.Z8(new FansClubEntranceParams(r3, false, "bar_guide", null, null, false, r9, 250));
        if (r5 == null) goto L18;
        r5.show();
    L18:
        u1 r6 = r0.h;
        String r7 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId();
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.m<Boolean> r10 = r8.isVS();
        if (r10 == null) goto L25;
        if (((Boolean) r10.getValue()).booleanValue() != true) goto L25;
        String r11 = "1";
    L26:
        com.bytedance.android.live.profit.fansclub.o r13 = r0.e;
        if (r13 == null) goto L29;
        int r14 = r13.R2();
    L30:
        r6.X(r7, r11, r14);
        OpenDialogService.d(r0.i, 0, null, 3);
        return;
    L29:
        r14 = 0;
    L25:
        r11 = "0";
        goto L26
    L12:
        r2 = FansClubEntranceParams.Page.Default;
        goto L13
    }

    public f(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.a r2) {
        Intrinsics.checkNotNullParameter(r2, "fansClubDataStore");
        this.a = r2;
    }
}
