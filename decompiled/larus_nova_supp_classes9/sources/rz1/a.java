package rz1;

import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.scope.m;
import i12.e;
import i12.o;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final g0 a(Long r4) {
        e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, GiftExtraRepo.class);
    L6:
        GiftExtraRepo r2 = (GiftExtraRepo) r1;
        if (r2 == null) goto L11;
        if (r4 != null) goto L10;
        return null;
    L10:
        return r2.q(r4.longValue());
    L11:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final h2 b(Long r3) {
        g0 r0 = a(r3);
        boolean r1 = false;
        if (r0 == null) goto L13;
        if (r0.getSubscribeGiftPackInfo() == null) goto L13;
        q3 r2 = r0.getSubscribeGiftPackInfo();
        if (r2 == null) goto L9;
        int r4 = r2.getLeftScores();
    L10:
        if (r4 <= 0) goto L13;
        r1 = true;
        goto L13
    L9:
        r4 = 0;
    L13:
        if (r1 == true) goto L15;
        return null;
    L15:
        g0 r5 = a(r3);
        if (r5 != null) goto L18;
    L25:
        return null;
    L18:
        if (r5.getSubscribeGiftPackInfo() == null) goto L25;
        q3 r6 = r5.getSubscribeGiftPackInfo();
        if (r6 == null) goto L22;
        long r7 = r6.getRelatedGiftId();
    L24:
        return GiftManagerKt.l(r7);
    L22:
        r7 = 0;
        goto L24
    }
}
