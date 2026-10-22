package x02;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.ChangeReceiverSource;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends d0 {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r2, y r3, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r4, Function1<? super y, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "nextPlugin");
        if ((r3 instanceof y.c.a.b) == false) goto L18;
        String r6 = r2.i().c();
        i12.e r7 = i12.o.b();
        if (r7 == null) goto L7;
        Object r8 = com.bytedance.android.scope.m.e.d(r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.class);
    L8:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r9 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y) r8;
        if (r9 == null) goto L11;
        r9.a(r6, ChangeReceiverSource.Other);
    L11:
        com.bytedance.android.livesdk.gift.platform.business.g r10 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r10 == null) goto L16;
        Context r11 = r10.getContext();
        if (r11 == null) goto L16;
        com.bytedance.android.live.revenue.common.k.a(r11, ((y.c.a.b) r3).d);
    L16:
        y.c.a.b r13 = (y.c.a.b) r3;
        r13.getClass();
        return new y.c.a.C0067a(r13.d, true, r13.c);
    L7:
        r8 = null;
        goto L8
    L18:
        return r3;
    }
}
