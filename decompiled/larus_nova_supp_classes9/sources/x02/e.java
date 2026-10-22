package x02;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends d0 {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r13, y r14, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r15, Function1<? super y, Unit> r16) {
        Intrinsics.checkNotNullParameter(r13, "info");
        Intrinsics.checkNotNullParameter(r14, "response");
        Intrinsics.checkNotNullParameter(r15, "listener");
        Intrinsics.checkNotNullParameter(r16, "nextPlugin");
        if ((r14 instanceof y.c.a.C0067a) == false) goto L35;
        y.c.a.C0067a r17 = (y.c.a.C0067a) r14;
        if (r17.d.getErrorCode() == 43011) goto L7;
        return r14;
    L7:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.d.f.getValue(null, com.bytedance.android.livesdk.gift.platform.business.d.a[4])).booleanValue() == true) goto L9;
    L11:
        boolean r18 = false;
    L12:
        if (r18 == false) goto L37;
        IRoom r19 = r13.i().H;
        String r9 = r13.i().g();
        if (nz1.a.c() == false) goto L16;
        FansClubEntranceParams.Page r110 = FansClubEntranceParams.Page.FansClub;
    L17:
        FansClubEntranceParams.Page r3 = r110;
        com.bytedance.android.live.profit.fansclub.o r111 = yt0.c.c();
        if (r111 == null) goto L22;
        com.bytedance.android.live.profit.fansclub.p r112 = r111.Z8(new FansClubEntranceParams(r3, false, "fans_gift", null, null, false, r9, 250));
        if (r112 == null) goto L22;
        r112.show();
    L22:
        ToastUtil.a(2131917147, 0);
        HashMap r113 = new HashMap();
        String r114 = "0";
        if (r19 == null) goto L26;
        String r1 = r19.getAnchorId();
        if (r1 == null) goto L26;
    L27:
        r113.put("anchor_id", r1);
        if (r19 == null) goto L33;
        String r115 = String.valueOf(r19.getId());
        if (r115 == null) goto L33;
        r114 = r115;
    L33:
        r113.put("room_id", r114);
        mz0.n r116 = new mz0.n();
        Map r117 = r116.a;
        Intrinsics.checkNotNullParameter(r117, "map");
        Intrinsics.checkNotNullParameter(r113, "map");
        r117.putAll(r113);
        cy0.e.a.getClass();
        cy0.j r118 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r119 = com.bytedance.android.scope.m.b(r118).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r119);
        ((f80.a) r119).w3("livesdk_fans_club_gift_notfan_click", r116.a, r116.b);
        return new y.c.a.C0067a(r17.d, true, r17.c);
    L26:
        r1 = "0";
        goto L27
    L16:
        r110 = FansClubEntranceParams.Page.Default;
        goto L17
    L37:
        return r14;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == true) goto L11;
        r18 = true;
        goto L12
    L35:
        return r14;
    }
}
