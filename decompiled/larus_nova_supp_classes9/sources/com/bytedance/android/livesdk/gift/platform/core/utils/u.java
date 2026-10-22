package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.configmodel.x2;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u {
    public static final IBaseUser a() {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 != null) goto L5;
        int r1 = com.bytedance.android.live.revenue.core.util.i.a;
        com.bytedance.android.scope.q r2 = com.bytedance.android.scope.m.b;
        r0 = null;
    L5:
        if (r0 == null) goto L10;
        IRoom r3 = r0.getRoom();
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getOwner();
    L10:
        return null;
    }

    public static final float g() {
        com.bytedance.android.livesdk.revenue.service.performance.c r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        if (r0.getMaxMusicVolume() > 0) goto L5;
        return -1.0f;
    L5:
        return r0.getCurrentMusicVolume() / r0.getMaxMusicVolume();
    }

    public static final yz0.k h() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
    }

    public static final boolean j() {
        int r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.m.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[11])).booleanValue() == true) goto L5;
    L11:
        return false;
    L5:
        if (r0 != 5) goto L7;
    L10:
        return true;
    L7:
        if (r0 == 8) goto L10;
        if (r0 != 12) goto L11;
        goto L10
    }

    public static final boolean m() {
        return com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin();
    }

    public static final boolean n() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.p4() != true) goto L7;
        return true;
    }

    public static final boolean p() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L6:
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.i3() != true) goto L10;
        return true;
    L5:
        if (r0.p4() != true) goto L6;
        return true;
    }

    public static final boolean q() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L6:
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.isVSVerticalStream() != true) goto L10;
        return true;
    L5:
        if (r0.Yd() != true) goto L6;
        return true;
    }

    public static final boolean r() {
        n01.a r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r0 != null) goto L5;
    L6:
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.i3() != true) goto L10;
        return true;
    L5:
        if (r0.p4() != true) goto L6;
        return true;
    }

    public static final boolean s() {
        if (q() == true) goto L7;
        return false;
    L7:
        return !((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.n.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[12])).booleanValue();
    }

    public static final boolean t() {
        if (p() == true) goto L5;
        return true;
    L5:
        com.bytedance.android.live.revenue.core.a r0 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r0 == null) goto L29;
        n01.a r1 = com.bytedance.android.live.revenue.core.util.f.c(r0, n01.a.class);
        if (r1 == null) goto L31;
        Episode r2 = r1.cl();
        if (r2 == null) goto L32;
        IRoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 != null) goto L14;
        return false;
    L14:
        if (r3.getEnableGift() != true) goto L36;
        x2 r4 = (x2) com.bytedance.android.livesdk.gift.platform.core.h.w.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[21]);
        if (x.d() == false) goto L21;
        if (r4.c() == false) goto L21;
    L28:
        return true;
    L21:
        if (x.c() == false) goto L25;
        if (r4.b() == true) goto L28;
    L25:
        if (x.b() == true) goto L27;
        return false;
    L27:
        if (r4.a() == true) goto L28;
        return false;
    L36:
        return false;
    L32:
        return false;
    L31:
        return false;
    L29:
        return false;
    }

    public static final h1 b(o7 r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.getClientGiftSource() == 1) goto L8;
    L21:
        IBaseUser r1 = r3.getToUser();
        if (r1 == null) goto L24;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r1);
    L24:
        h1 r2 = d(r3.getGiftId());
        if (r2 != null) goto L28;
        return GiftManagerKt.j(r3.getGiftId(), null);
    L28:
        return r2;
    L8:
        if (r3.getGift() == null) goto L21;
        if (f0.a == true) goto L29;
        IBaseUser r4 = r3.getToUser();
        if (r4 == null) goto L15;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r4);
    L15:
        h1 r5 = d(r3.getGiftId());
        if (r5 != null) goto L18;
        r5 = GiftManagerKt.j(r3.getGiftId(), null);
    L18:
        if (r5 == null) goto L30;
        r3.getGift();
    L30:
        return r3.getGift();
    L29:
        return r3.getGift();
    }

    public static final int c(ReceiverType r4) {
        Intrinsics.checkNotNullParameter(r4, "currentReceiverType");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r0 = s.c();
        if (r0 == null) goto L6;
        IBaseUser r1 = r0.a;
        if (r1 == null) goto L6;
    L8:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(r1) == false) goto L10;
        return 4;
    L10:
        IRoomBase r2 = x.a();
        if (r2 == null) goto L16;
        if (x12.a.b(r2) != true) goto L16;
        return 128;
    L16:
        if (x.d() == false) goto L19;
        return 16;
    L19:
        if (x.c() == false) goto L22;
        return 32;
    L22:
        if (x.b() == false) goto L25;
        return 64;
    L25:
        if (r4 != ReceiverType.AllMic) goto L28;
        return 512;
    L28:
        if (r4 != ReceiverType.Audience) goto L31;
        return 1024;
    L31:
        if (r4 != ReceiverType.GroupLive) goto L34;
        return 128;
    L34:
        if (r4 == ReceiverType.OtherAnchor) goto L44;
        return 1;
    L44:
        return 4;
    L6:
        r1 = vh7.f.c(IBaseUser.class);
        goto L8
    }

    public static final h1 d(long r2) {
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).o4(r2, null);
    }

    public static final h2 e(EffectMessage r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.D != 1) goto L10;
        h1 r0 = r2.C;
        if (r0 == null) goto L10;
        return r0;
    L10:
        IBaseUser r1 = r2.h;
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r1);
    L13:
        h1 r3 = d(r2.l);
        if (r3 == null) goto L17;
        return r3;
    L17:
        return GiftManagerKt.l(r2.l);
    }

    public static final h2 f(o7 r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.getClientGiftSource() == 1) goto L8;
    L10:
        IBaseUser r0 = r2.getToUser();
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r0);
    L13:
        h1 r1 = d(r2.getGiftId());
        if (r1 == null) goto L17;
        return r1;
    L17:
        return GiftManagerKt.l(r2.getGiftId());
    L8:
        if (r2.getGift() == null) goto L10;
        return r2.getGift();
    }

    public static final boolean i(w1 r1) {
        if (r1 == null) goto L8;
        py.k r2 = r1.getBackgroundImage();
        if (r2 == null) goto L8;
        if (r2.isValid() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static final int k(boolean r1) {
        if (r1 == true) goto L6;
        return 0;
    L6:
        if (com.bytedance.android.live.incentive.exchange.j.a() == true) goto L8;
        return 0;
    L8:
        KmpEnv r2 = KmpEnv.a;
        KmpEnv.b();
        return 2;
    }

    public static final boolean o(long r3) {
        Calendar r0 = Calendar.getInstance();
        Calendar r1 = Calendar.getInstance();
        r1.setTimeInMillis(r3);
        if (r0.get(1) == r1.get(1)) goto L5;
    L9:
        return false;
    L5:
        if (r0.get(2) != r1.get(2)) goto L9;
        if (r0.get(5) != r1.get(5)) goto L9;
        return true;
    }

    public static final boolean l(boolean r1, ds2.d r2) {
        if (k(r1) == 2) goto L5;
    L12:
        return false;
    L5:
        if (m() == false) goto L12;
        if (r2 != null) goto L8;
    L11:
        return true;
    L8:
        if (r2.b == null) goto L12;
        if (r2.a == false) goto L12;
        goto L11
    }
}
