package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.recharge.util.SendGiftNoBalanceScene;
import com.bytedance.android.live.recharge.utils.t;
import com.bytedance.android.live.revenue.common.s;
import com.bytedance.android.live.revlink.api.ILinkService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final boolean b() {
        int r0 = w.a;
        if (v.a() == true) goto L5;
    L7:
        p11.h r1 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r1.d() == RevPkState.PK) goto L10;
    L12:
        return false;
    L10:
        if (r1.isInBreakThrough() == true) goto L12;
        return true;
    L5:
        if (((Boolean) t.n.getValue(null, t.a[12])).booleanValue() == false) goto L7;
        return true;
    }

    public static final boolean a(com.bytedance.android.live.recharge.model.d r3) {
        if (r3 == null) goto L11;
        com.bytedance.android.live.recharge.model.b r4 = r3.j;
        if (r4 == null) goto L11;
        com.bytedance.android.live.recharge.model.a r5 = r4.g;
        if (r5 == null) goto L11;
        s r0 = r5.a;
        KProperty r1 = com.bytedance.android.live.recharge.model.a.d[0];
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "thisRef");
        Intrinsics.checkNotNullParameter(r1, "property");
        Object r6 = r5.get(r0.a);
        if (r6 != null) goto L10;
        r6 = r0.b.invoke();
    L10:
        String r7 = (String) r6;
    L13:
        return Intrinsics.areEqual(r7, SendGiftNoBalanceScene.FANS_CLUB_LIGHT_BOARD.getSceneName());
    L11:
        r7 = null;
        goto L13
    }

    public static final boolean c(com.bytedance.android.live.recharge.model.d r1) {
        if (r1 == null) goto L4;
        String r2 = r1.b;
    L6:
        return Intrinsics.areEqual(r2, NoPasswordScene.SCENE_FANS_CLUB_JOIN.getValue());
    L4:
        r2 = null;
        goto L6
    }
}
