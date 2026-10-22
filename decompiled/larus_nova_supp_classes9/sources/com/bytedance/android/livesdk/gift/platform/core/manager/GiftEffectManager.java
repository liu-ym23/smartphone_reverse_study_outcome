package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zg1.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftEffectManager {
    public static boolean a;
    public static WeakReference<DataCenter> b;
    public static long c;
    public static boolean d;
    public static boolean e;
    public static final CompositeDisposable f = null;
    public static final Lazy g = null;

    static {
        a = true;
        f = new CompositeDisposable();
        g = LazyKt.lazy(GiftEffectManager$giftEffectSwitchObserver$2.INSTANCE);
    }

    public static boolean a(IBaseUser r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        return !Intrinsics.areEqual(r2.getIdString(), com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString());
    }

    @JvmStatic
    public static final boolean b(Object r7, IRoom r8) {
        if (a == false) goto L7;
        if (d == true) goto L7;
    L54:
        return false;
    L7:
        if (e == true) goto L54;
        if (r7 == null) goto L54;
        Integer r1 = null;
        if ((r7 instanceof o7) == false) goto L43;
        o7 r9 = (o7) r7;
        if (r9.isBannedInChat() == true) goto L56;
        if (a(r9.getFromUser()) == false) goto L56;
        if (r8 == null) goto L56;
        h1 r0 = r9.getGift();
        if (r0 == null) goto L21;
        r1 = Integer.valueOf(r0.getType());
    L21:
        if (GiftManagerKt.u(r1) != GiftType.NORMAL_GIFT) goto L56;
        if (r9.getRepeatEnd() != 1) goto L56;
        m0 r2 = r9.getCommonData();
        p02.a r3 = new p02.a();
        h1 r4 = r9.getGift();
        if (r4 == null) goto L56;
        NormalGiftMessage r10 = r3.a(r9, r4, r8.getOwner(), true);
        x1 r5 = new x1(r10.e, r10.q, r10.b);
        r5.k = r2;
        r5.l = r9.isBannedInChat();
        r5.g = r9.getGiftTimeStamp();
        r5.h = r9.getReceiveTime();
        r5.m = r9.getPublicAreaCommon();
        r5.i = r9.getUseRoomMessage();
        if (r9.getClientGiftSource() == 1) goto L30;
    L32:
        h1 r11 = GiftManagerKt.l(r9.getGiftId());
    L33:
        if (r11 != null) goto L35;
    L36:
        r5.j = r11;
        WeakReference<DataCenter> r13 = b;
        if (r13 == null) goto L56;
        DataCenter r14 = r13.get();
        if (r14 == null) goto L56;
        r14.put("data_normal_gift_end_event", r5);
        goto L56
    L35:
        if (r11.getType() == 8) goto L56;
    L30:
        if (r9.getGift() == null) goto L32;
        r11 = r9.getGift();
    L56:
        return a(r9.getFromUser());
    L43:
        if ((r7 instanceof o6) == false) goto L49;
        o7 r15 = ((o6) r7).getGiftMessage();
        if (r15 == null) goto L57;
        r1 = r15.getFromUser();
    L57:
        return a(r1);
    L49:
        if ((r7 instanceof k6) == false) goto L52;
        return a(((k6) r7).getFromUser());
    L52:
        if ((r7 instanceof NormalGiftMessage) == false) goto L54;
        return a(((NormalGiftMessage) r7).e);
    }
}
