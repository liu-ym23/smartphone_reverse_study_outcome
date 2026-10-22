package com.bytedance.android.livesdk.gift.platform.business.tray2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.m;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VSGiftMessageManager {
    public static final Lazy e = null;
    public y a;
    public y b;
    public final ArrayList<NormalGiftMessage> c;
    public final p02.a d;

    public static final class a {
        public static VSGiftMessageManager a() {
            return (VSGiftMessageManager) VSGiftMessageManager.e.getValue();
        }
    }

    static {
        e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, VSGiftMessageManager$Companion$INSTANCE$2.INSTANCE);
    }

    public VSGiftMessageManager() {
        this.c = new ArrayList();
        this.d = new p02.a();
    }

    public final void b(NormalGiftMessage r5) {
        r5.h = System.currentTimeMillis();
        if (this.c.isEmpty() == false) goto L6;
        this.c.add(r5);
        return;
    L6:
        int r1 = 0;
        if ((r5.t instanceof k6) == false) goto L20;
        int r0 = this.c.size();
    L9:
        if (r1 >= r0) goto L18;
        NormalGiftMessage r2 = (NormalGiftMessage) ListProtector.get(this.c, r1);
        if ((r2.t instanceof k6) == true) goto L17;
        if ((r2 instanceof m) == true) goto L17;
        ListProtector.add(this.c, r1, r5);
        return;
    L17:
        r1 = r1 + 1;
        goto L9
    L18:
        this.c.add(r5);
        return;
    L20:
        if (r5.v == false) goto L41;
        int r3 = this.c.size();
    L22:
        if (r1 >= r3) goto L40;
        NormalGiftMessage r4 = (NormalGiftMessage) ListProtector.get(this.c, r1);
        if ((r4.t instanceof k6) == true) goto L39;
        if ((r4 instanceof m) == true) goto L39;
        if (r4.v == false) goto L37;
        if (c22.a.a(r4, r5) == true) goto L39;
        if (r5.g <= r4.g) goto L39;
        ListProtector.add(this.c, r1, r5);
        return;
    L37:
        ListProtector.add(this.c, r1, r5);
        return;
    L39:
        r1 = r1 + 1;
        goto L22
    L40:
        this.c.add(r5);
        return;
    L41:
        int r6 = this.c.size();
    L42:
        if (r1 >= r6) goto L56;
        NormalGiftMessage r7 = (NormalGiftMessage) ListProtector.get(this.c, r1);
        if ((r7.t instanceof k6) == true) goto L55;
        if (r7.v == true) goto L55;
        if ((r7 instanceof m) == true) goto L55;
        if (r5.g <= r7.g) goto L55;
        ListProtector.add(this.c, r1, r5);
        return;
    L55:
        r1 = r1 + 1;
        goto L42
    L56:
        this.c.add(r5);
    }

    public final void c(int r10) {
        if (this.c.size() <= 0) goto L50;
        NormalGiftMessage r0 = (NormalGiftMessage) ListProtector.get(this.c, 0);
        boolean r3 = true;
        m r4 = null;
        if ((r0 instanceof m) == false) goto L23;
        if (r10 == 2) goto L9;
        return;
    L9:
        y r11 = this.a;
        if (r11 != null) goto L12;
    L14:
        r3 = false;
    L15:
        if (r3 == true) goto L17;
    L43:
        if (r3 == true) goto L45;
        return;
    L45:
        if (this.c.size() <= 0) goto L52;
        ListProtector.remove(this.c, 0);
        if (r4 == null) goto L53;
        ListProtector.add(this.c, 0, r4);
        return;
    L53:
        return;
    L52:
        return;
    L17:
        if (this.c.size() <= 0) goto L43;
        if (((NormalGiftMessage) ListProtector.get(this.c, 0)).equals(r0) == false) goto L43;
        ListProtector.remove(this.c, 0);
        c(0);
        return;
    L12:
        if (r11.Lc(r0) != true) goto L14;
    L23:
        if ((r0 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L37;
        y r13 = this.a;
        if (r13 != null) goto L27;
    L42:
        r3 = false;
        goto L43
    L27:
        if (r13.Lc(r0) != true) goto L42;
        y r14 = this.b;
        if (r14 == null) goto L34;
        if (r14.Lc(r0) != true) goto L34;
        r4 = new m(r0.a, r0.b);
    L34:
        if (this.c.size() <= 0) goto L42;
        ListProtector.remove(this.c, 0);
        c(0);
        return;
    L37:
        y r15 = this.a;
        if (r15 == null) goto L42;
        if (r15.Lc(r0) != true) goto L42;
    }

    public final void a(gm2.d r6, IBaseUser r7) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        if ((r6 instanceof o7) == false) goto L25;
        o7 r8 = (o7) r6;
        if (r8.getGift() != null) goto L11;
        h1 r0 = GiftManagerKt.j(r8.getGiftId(), null);
        if (r0 != null) goto L9;
        return;
    L9:
        r8.setGift(r0);
    L11:
        if (r8.isBannedInTray() == false) goto L13;
        return;
    L13:
        p02.a r1 = this.d;
        h1 r2 = r8.getGift();
        if (r2 != null) goto L16;
        r2 = (h1) vh7.f.c(h1.class);
    L16:
        h1 r3 = r2;
        h1 r4 = r8.getGift();
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        b(r1.a(r8, r3, r7, r5));
    L27:
        c(0);
        return;
    L19:
        if (r4.getType() != 2) goto L22;
        r5 = false;
        goto L23
    L25:
        if ((r6 instanceof k6) == false) goto L27;
        this.d.getClass();
        b(p02.a.b((k6) r6, r7));
        goto L27
    }
}
