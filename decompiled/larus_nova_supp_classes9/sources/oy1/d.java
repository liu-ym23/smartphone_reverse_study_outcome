package oy1;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.scope.m;
import i12.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements a {
    public d() {
    }

    @Override // oy1.a
    public final boolean a(h1 r4) {
        Intrinsics.checkNotNullParameter(r4, "gift");
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L14;
        i12.e r5 = o.b();
        if (r5 == null) goto L7;
        Object r6 = m.e.d(r5, GiftInRoomService.class);
    L8:
        GiftInRoomService r7 = (GiftInRoomService) r6;
        if (r7 == null) goto L11;
        r7.a(1001);
    L12:
        return false;
    L11:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1001));
        goto L12
    L7:
        r6 = null;
        goto L8
    L14:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).interceptOperation("gift") == false) goto L16;
        return false;
    L16:
        return true;
    }
}
