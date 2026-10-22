package com.bytedance.android.livesdk.gift.platform.business.normal.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.configmodel.o2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.o3;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.l;
import com.bytedance.android.livesdk.gift.platform.business.tray.m;
import com.bytedance.android.livesdk.message.model.o7;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import l01.d;
import n12.f;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void a(NormalGiftMessage r25, f r26) {
        Intrinsics.checkNotNullParameter(r26, "strategy");
        if (r25 != null) goto L5;
        return;
    L5:
        List<n3> r2 = r25.F;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L45;
        long r4 = r25.getTotalMoney() * r25.k;
        int r1 = r26.c(r4);
        long r7 = r25.m + ((long) r25.n);
        long r14 = r25.k;
        List<n3> r9 = r25.F;
        if (r9 == null) goto L44;
        Iterator<n3> r23 = r9.iterator();
    L19:
        if (r23.hasNext() == false) goto L115;
        n3 r10 = r23.next();
        h1 r11 = r10.getGift();
        if (r11 == null) goto L23;
        String r13 = r11.getName();
    L24:
        o3 r15 = r10.getSeriesTrayInfo();
        if (r15 == null) goto L42;
        k r16 = r15.getStaticImage();
        if (r16 == null) goto L42;
        com.bytedance.android.livesdk.revenue.service.interactivity.b r17 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class);
        String r18 = r25.u();
        IBaseUser r19 = r25.e;
        if (r19 == null) goto L32;
        String r110 = r19.getIdString();
    L33:
        boolean r5 = TextUtils.equals(r110, com.bytedance.android.live.revenue.core.util.f.a(d.class).getCurrentUserId());
        StringBuilder r111 = new StringBuilder();
        IBaseUser r6 = r25.e;
        if (r6 == null) goto L36;
        String r8 = r6.getNickName();
    L37:
        r111.append(r8);
        r111.append(' ');
        r111.append(r13);
        String r112 = r111.toString();
        String r113 = String.valueOf(r7);
        boolean r20 = r25 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a;
        h2 r114 = r25.w;
        if (r114 == null) goto L40;
        boolean r115 = r114.isForFansClub();
    L41:
        long r24 = r14;
        r17.ze(r18, r5, r16, r112, r1, r24, r113, r20, r115, r4);
    L43:
        r14 = r24;
        goto L19
    L40:
        r115 = false;
        goto L41
    L36:
        r8 = null;
        goto L37
    L32:
        r110 = null;
    L42:
        r24 = r14;
        goto L43
    L23:
        r13 = null;
        goto L24
    L115:
        return;
    L44:
        return;
    L45:
        long r21 = ((long) r25.g) * r25.k;
        int r116 = r26.c(r21);
        String r27 = r25.c;
        if (r27 != null) goto L48;
    L51:
        boolean r28 = true;
    L52:
        if (r28 == false) goto L67;
        o7 r29 = r25.r();
        if (r29 == null) goto L58;
        h1 r30 = r29.getGift();
        if (r30 == null) goto L58;
        r27 = r30.getName();
    L59:
        if (r27 != null) goto L61;
    L64:
        boolean r31 = true;
    L65:
        if (r31 == false) goto L67;
        r27 = vh6.c.b(ur2.a.class).Lf(r25.getTrayDisplayText(), null).toString();
        goto L67
    L61:
        if (StringsKt.isBlank(r27) == true) goto L64;
        r31 = false;
    L58:
        r27 = null;
    L67:
        long r33 = r25.m + ((long) r25.n);
        String r34 = String.valueOf(r33);
        long r117 = r25.k;
        boolean r35 = r25 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a;
        if (r35 == true) goto L70;
        long r210 = r21;
        if ((r25 instanceof l) == false) goto L84;
    L86:
        boolean r36 = false;
    L87:
        int r37 = b02.a.g(r25);
        if (r36 == true) goto L90;
    L95:
        String r118 = r34;
    L96:
        com.bytedance.android.livesdk.revenue.service.interactivity.b r119 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class);
        String r120 = r25.u();
        IBaseUser r38 = r25.e;
        if (r38 == null) goto L99;
        String r39 = r38.getIdString();
    L100:
        boolean r121 = TextUtils.equals(r39, com.bytedance.android.live.revenue.core.util.f.a(d.class).getCurrentUserId());
        k r40 = r25.o;
        StringBuilder r41 = new StringBuilder();
        IBaseUser r43 = r25.e;
        if (r43 == null) goto L103;
        String r44 = r43.getNickName();
    L104:
        r41.append(r44);
        r41.append(' ');
        r41.append(r27);
        String r45 = r41.toString();
        h2 r46 = r25.w;
        if (r46 == null) goto L107;
        boolean r211 = r46.isForFansClub();
    L108:
        r119.ze(r120, r121, r40, r45, r116, r117, r118, r35, r211, r210);
        IBaseUser r0 = r25.e;
        if (r0 == null) goto L116;
        r0.getNickName();
        return;
    L116:
        return;
    L107:
        r211 = false;
        goto L108
    L103:
        r44 = null;
        goto L104
    L99:
        r39 = null;
        goto L100
    L90:
        if (((o2) t02.a.b.getValue(null, t02.a.a[0])).a() == false) goto L95;
        if (r37 <= 0) goto L95;
        if (r33 <= r37) goto L95;
        StringCompanionObject r47 = StringCompanionObject.INSTANCE;
        r34 = String.format("%d+", Arrays.copyOf(new Object[]{Integer.valueOf(r37)}, 1));
        goto L95
    L84:
        if ((r25 instanceof m) == true) goto L86;
        r36 = true;
        goto L87
    L70:
        if (b02.a.d(r25) == false) goto L77;
        int r122 = b02.a.f(r25);
        r210 = r21;
        if (r122 <= 0) goto L95;
        if (r33 <= r122) goto L95;
        StringCompanionObject r48 = StringCompanionObject.INSTANCE;
        r34 = String.format("%d+", Arrays.copyOf(new Object[]{Integer.valueOf(r122)}, 1));
    L80:
        r118 = r34;
        goto L96
    L77:
        r210 = r21;
        if (b02.a.b(r25) == true) goto L80;
        r34 = "1";
        goto L80
    L48:
        if (StringsKt.isBlank(r27) == true) goto L51;
        r28 = false;
        goto L52
    L8:
        if (r2.isEmpty() == true) goto L11;
        r3 = false;
        goto L13
    }

    @JvmStatic
    public static final void b(NormalGiftMessage r2, f r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        if (r2 != null) goto L6;
        return;
    L6:
        if ((r2 instanceof l) == false) goto L8;
        return;
    L8:
        IBaseUser r0 = r2.e;
        if (r0 == null) goto L11;
        String r1 = r0.getIdString();
    L13:
        if (TextUtils.equals(r1, com.bytedance.android.live.revenue.core.util.f.a(d.class).getCurrentUserId()) == true) goto L16;
        a(r2, r3);
        return;
    L16:
        return;
    L11:
        r1 = null;
        goto L13
    }

    @JvmStatic
    public static final void c(NormalGiftMessage r2, f r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        if (r2 != null) goto L6;
        return;
    L6:
        if ((r2 instanceof l) == false) goto L8;
        return;
    L8:
        IBaseUser r0 = r2.e;
        if (r0 == null) goto L11;
        String r1 = r0.getIdString();
    L13:
        if (TextUtils.equals(r1, com.bytedance.android.live.revenue.core.util.f.a(d.class).getCurrentUserId()) == false) goto L16;
        a(r2, r3);
        return;
    L16:
        return;
    L11:
        r1 = null;
        goto L13
    }
}
