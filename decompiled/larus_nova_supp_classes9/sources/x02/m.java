package x02;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.SendGiftRelationService;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends d0 {
    public m() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final void c(com.bytedance.android.livesdk.gift.platform.core.model.t r5, p2 r6, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r7, Function1<? super y, Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r7, "listener");
        Intrinsics.checkNotNullParameter(r8, "nextPlugin");
        Object r9 = null;
        if (r6 == null) goto L24;
        i12.e r10 = i12.o.b();
        if (r10 == null) goto L7;
        Object r11 = com.bytedance.android.scope.m.e.d(r10, GiftDataStorageService.class);
    L8:
        GiftDataStorageService r13 = (GiftDataStorageService) r11;
        if (r13 == null) goto L24;
        long r0 = r6.getRepeatCount();
        h1 r14 = r6.getGift();
        if (r14 == null) goto L13;
        Integer r15 = Integer.valueOf(r14.getType());
    L14:
        if (r15 != null) goto L17;
    L18:
        if (r15 == null) goto L24;
        if (r15.intValue() != 13) goto L24;
    L22:
        r13.e += r0;
        goto L24
    L17:
        if (r15.intValue() == 2) goto L22;
    L13:
        r15 = null;
        goto L14
    L7:
        r11 = null;
    L24:
        if (r5.a().b <= 0) goto L32;
        i12.e r16 = i12.o.b();
        if (r16 == null) goto L28;
        r9 = com.bytedance.android.scope.m.e.d(r16, SendGiftRelationService.class);
    L28:
        SendGiftRelationService r17 = (SendGiftRelationService) r9;
        if (r17 == null) goto L33;
        r17.g(r5.i().g(), r5.i().c);
        return;
    L33:
        return;
    }
}
