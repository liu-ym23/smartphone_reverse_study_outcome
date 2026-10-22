package com.bytedance.android.livesdk.gift.platform.business.tray2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public static final /* synthetic */ int c = 0;
    public IBaseUser a;
    public final p02.a b;

    public static final class a {
    }

    static {
    }

    public k() {
        this.b = new p02.a();
    }

    public static h2 b(o7 r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        h2 r2 = u.f(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return vh7.f.c(h1.class);
    }

    public final NormalGiftMessage a(gm2.d r14) {
        long r1 = 0;
        Integer r3 = null;
        if ((r14 instanceof o7) == false) goto L30;
        o7 r15 = (o7) r14;
        h2 r0 = u.f(r15);
        if (r0 == null) goto L7;
        r3 = Integer.valueOf(r0.getType());
    L7:
        GiftType r2 = GiftManagerKt.u(r3);
        List r4 = r15.getSeriesGiftData();
        if (r4 == null) goto L10;
        r4.isEmpty();
    L10:
        boolean r5 = false;
        if (r2 == GiftType.MIDDLE_GIFT) goto L53;
        if (r2 == GiftType.SPECIAL_GIFT) goto L53;
        if (r2 == GiftType.STICKER_GIFT) goto L53;
        if (r2 == GiftType.INTERACT_GIFT) goto L53;
        if (r2 == GiftType.UNKNOWN) goto L53;
        if (r2 != GiftType.MULTI_INTERACT) goto L27;
        Intrinsics.checkNotNullParameter(r15, "$this$trayFromServer");
        if ((r15.getForceDisplayEffects() & 2) == 0) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == true) goto L53;
    L25:
        r6 = false;
    L27:
        r5 = true;
    L53:
        return this.b.a(r15, b(r15), this.a, r5);
    L30:
        if ((r14 instanceof k6) == false) goto L33;
        p02.a r7 = this.b;
        IBaseUser r8 = this.a;
        r7.getClass();
        return p02.a.b((k6) r14, r8);
    L33:
        if ((r14 instanceof i6) == false) goto L40;
        i6 r16 = (i6) r14;
        this.b.getClass();
        if (r16.getCommonData() == null) goto L37;
        com.bytedance.android.livesdk.gift.platform.business.tray.a r9 = new com.bytedance.android.livesdk.gift.platform.business.tray.a(r16.getCommonData().getMessageId(), 0, false);
    L38:
        com.bytedance.android.livesdk.gift.platform.business.tray.a r10 = r9;
        r10.t = r16;
        r10.P = r16.isRtcRoomMessage();
        return r10;
    L37:
        r9 = new com.bytedance.android.livesdk.gift.platform.business.tray.a(0, 0, false);
        goto L38
    L40:
        if ((r14 instanceof q8) == false) goto L56;
        q8 r17 = (q8) r14;
        this.b.getClass();
        h1 r11 = r17.getGift();
        if (r11 == null) goto L44;
        r1 = r11.getId();
    L44:
        long r13 = r1;
        if (r17.getCommonData() == null) goto L47;
        com.bytedance.android.livesdk.gift.platform.business.tray.a r18 = new com.bytedance.android.livesdk.gift.platform.business.tray.a(r17.getCommonData().getMessageId(), r13, false);
    L48:
        r18.t = r17;
        long r19 = System.currentTimeMillis();
        if (r18.s() == null) goto L51;
        r18.L = r19;
    L51:
        r18.P = r17.isRtcRoomMessage();
        return r18;
    L47:
        r18 = new com.bytedance.android.livesdk.gift.platform.business.tray.a(0, r13, false);
        goto L48
    L56:
        return null;
    }
}
