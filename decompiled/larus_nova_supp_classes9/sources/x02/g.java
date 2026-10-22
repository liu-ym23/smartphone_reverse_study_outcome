package x02;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftSendPreCheckService;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends d0 {
    public g() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y b(com.bytedance.android.livesdk.gift.platform.core.model.t r11, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r13, Function1<? super y, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "info");
        Intrinsics.checkNotNullParameter(r13, "listener");
        Intrinsics.checkNotNullParameter(r14, "nextPlugin");
        h2 r2 = GiftManagerKt.l(r11.i().b);
        i12.e r15 = i12.o.b();
        Integer r16 = null;
        if (r15 == null) goto L5;
        Object r17 = com.bytedance.android.scope.m.e.d(r15, PropListService.class);
    L6:
        PropListService r18 = (PropListService) r17;
        if (r18 == null) goto L9;
        l2 r3 = r18.f(Long.valueOf(r11.i().b));
    L10:
        i12.e r19 = i12.o.b();
        if (r19 == null) goto L13;
        Object r110 = com.bytedance.android.scope.m.e.d(r19, GiftSendPreCheckService.class);
    L14:
        GiftSendPreCheckService r0 = (GiftSendPreCheckService) r110;
        if (r0 == null) goto L20;
        IBaseUser r1 = r11.i().f();
        ReceiverType r111 = r11.i().u;
        if (r111 != null) goto L19;
        r111 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.d();
    L19:
        r16 = Integer.valueOf(GiftSendPreCheckService.f(r0, r1, r2, r3, r111, r11.i().w, r11.i().c, null, null, 192));
    L20:
        if (r16 == null) goto L25;
        if (r16.intValue() != 0) goto L25;
        return y.d.c;
    L25:
        if (r16 == null) goto L27;
        int r112 = r16.intValue();
    L29:
        return new y.c.a.e(r112, "precheckSendGiftFailed, example: lock or disconnect");
    L27:
        r112 = 201;
        goto L29
    L13:
        r110 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r17 = null;
        goto L6
    }
}
