package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import com.bytedance.android.livesdk.gift.configmodel.r2;
import com.bytedance.android.livesdk.gift.configmodel.t2;
import com.bytedance.android.livesdk.gift.configmodel.u2;
import com.bytedance.android.livesdk.gift.configmodel.v2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.u3;
import com.bytedance.android.livesdk.gift.model.w3;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.zj;
import com.bytedance.android.livesdk.revenue.experience.RevExpBizScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public static final v2 a = null;

    static {
        a = (v2) com.bytedance.android.livesdk.gift.platform.business.e.w.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[21]);
    }

    @JvmStatic
    public static final boolean a() {
        com.bytedance.android.livesdk.revenue.experience.c r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.experience.c.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.revenue.experience.f r1 = r0.Mg(null, RevExpBizScene.DEGRADE_BUSINESS_REVENUE_GIFT_TRAY_ANIMATION);
        if (r1 == null) goto L9;
        if (r1.a != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b() {
        if (((List) com.bytedance.android.livesdk.gift.platform.business.e.i.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[7])).contains(Integer.valueOf(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene())) == false) goto L11;
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isGiftDialogOpen();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        return true;
    L11:
        return false;
    }

    @JvmStatic
    public static final boolean c() {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == true) goto L5;
        return false;
    L5:
        if ((((Number) com.bytedance.android.livesdk.gift.platform.business.e.p.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[14])).intValue() & 1) != 1) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L20;
        yz0.k r2 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L21;
        IRoom r3 = r2.getRoom();
        if (r3 == null) goto L22;
        IRoomCart r4 = r3.getRoomCart();
        if (r4 != null) goto L16;
        return false;
    L16:
        if (r4.getShowCartExt() != 1) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    @JvmStatic
    public static final boolean d(boolean r4) {
        if (b() == true) goto L10;
        ReadOnlyProperty r0 = com.bytedance.android.livesdk.gift.platform.business.e.j;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.platform.business.e.a;
        if (((Boolean) r0.getValue(null, r1[8])).booleanValue() == true) goto L9;
        if (r4 == false) goto L10;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.k.getValue(null, r1[9])).booleanValue() == false) goto L10;
    L9:
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean e(NormalGiftMessage r4) {
        if (r4 == null) goto L35;
        o7 r0 = r4.r();
        if (r0 == null) goto L37;
        o0 r1 = r0.getTrayInfo();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.getUserHighLayer() == true) goto L10;
        return false;
    L10:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.l.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[10])).booleanValue() == true) goto L12;
        return false;
    L12:
        if (b() == true) goto L46;
        o7 r2 = r4.r();
        if (r2 == null) goto L24;
        o0 r3 = r2.getTrayInfo();
        if (r3 == null) goto L24;
        w3 r5 = r3.getTrayPreEffect();
        if (r5 == null) goto L24;
        py.k r6 = r5.getPreEffectImg();
        if (r6 == null) goto L24;
        if (r6.isValid() != true) goto L24;
    L34:
        return true;
    L24:
        o7 r7 = r4.r();
        if (r7 == null) goto L41;
        o0 r8 = r7.getTrayInfo();
        if (r8 == null) goto L42;
        u3 r9 = r8.getTrayPostEffect();
        if (r9 == null) goto L43;
        py.k r10 = r9.getPostEffectImg();
        if (r10 != null) goto L33;
        return false;
    L33:
        if (r10.isValid() == true) goto L34;
        return false;
    L43:
        return false;
    L42:
        return false;
    L41:
        return false;
    L46:
        return false;
    L37:
        return false;
    L35:
        return false;
    }

    @JvmStatic
    public static final boolean f(Integer r3) {
        if (CollectionsKt.contains((List) com.bytedance.android.livesdk.gift.platform.business.e.u.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[19]), r3) == false) goto L6;
        return false;
    L6:
        return true;
    }

    @JvmStatic
    public static final Integer g(NormalGiftMessage r8) {
        if (r8 != null) goto L5;
        return 0;
    L5:
        List r2 = (List) com.bytedance.android.livesdk.gift.platform.business.e.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[13]);
        int r9 = (int) r8.t(true);
        if (r2 == null) goto L32;
        Iterator r3 = r2.iterator();
        int r4 = 0;
    L9:
        if (r3.hasNext() == false) goto L32;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        r2 r7 = (r2) r5;
        if (r7 == null) goto L31;
        List<Integer> r10 = r7.a();
        if (r10 == null) goto L20;
        Integer r11 = (Integer) CollectionsKt.getOrNull(r10, 0);
        if (r11 == null) goto L20;
        int r13 = r11.intValue();
    L21:
        if (r9 < r13) goto L31;
        List<Integer> r14 = r7.a();
        if (r14 == null) goto L27;
        Integer r15 = (Integer) CollectionsKt.getOrNull(r14, 1);
        if (r15 == null) goto L27;
        int r16 = r15.intValue();
    L28:
        if (r9 >= r16) goto L31;
        return Integer.valueOf(r4);
    L27:
        r16 = Integer.MIN_VALUE;
    L20:
        r13 = Integer.MAX_VALUE;
    L31:
        r4 = r6;
    L32:
        return 0;
    }

    @JvmStatic
    public static final py.k h(NormalGiftMessage r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        py.k r1 = vh7.f.c(py.k.class);
        List r2 = (List) com.bytedance.android.livesdk.gift.platform.business.e.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[13]);
        int r8 = (int) r7.t(true);
        if (r2 == null) goto L44;
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L46;
        r2 r4 = (r2) r3.next();
        if (r4 == null) goto L9;
        List<Integer> r5 = r4.a();
        if (r5 == null) goto L17;
        Integer r6 = (Integer) CollectionsKt.getOrNull(r5, 0);
        if (r6 == null) goto L17;
        int r9 = r6.intValue();
    L18:
        if (r8 < r9) goto L9;
        List<Integer> r10 = r4.a();
        if (r10 == null) goto L24;
        Integer r11 = (Integer) CollectionsKt.getOrNull(r10, 1);
        if (r11 == null) goto L24;
        int r13 = r11.intValue();
    L25:
        if (r8 >= r13) goto L9;
        List<String> r14 = r4.b();
        if (r14 == null) goto L31;
        List r15 = CollectionsKt.shuffled(r14);
        if (r15 == null) goto L31;
    L32:
        r1.setUrls(r15);
        if (r1.isValid() == true) goto L35;
        return null;
    L35:
        return r1;
    L31:
        r15 = CollectionsKt.emptyList();
    L24:
        r13 = Integer.MIN_VALUE;
    L17:
        r9 = Integer.MAX_VALUE;
        goto L18
    L46:
        return null;
    L44:
        return null;
    }

    @JvmStatic
    public static final float i(NormalGiftMessage r9) {
        if (r9 == null) goto L52;
        o7 r1 = r9.r();
        if (r1 == null) goto L52;
        v2 r2 = a;
        if (r2.a() == true) goto L18;
        o0 r10 = r1.getTrayInfo();
        if (r10 == null) goto L66;
        Intrinsics.checkNotNullParameter(r10, "$this$getRealTraySlideRate");
        if (r10.getTraySlideRate() > 0) goto L14;
        Float r11 = Float.valueOf(1.0f);
    L15:
        if (r11 != null) goto L17;
        return 1.0f;
    L17:
        return r11.floatValue();
    L14:
        r11 = Float.valueOf(r10.getTraySlideRate() / 100.0f);
        goto L15
    L66:
        return 1.0f;
    L18:
        int r13 = (int) r9.getTotalMoney();
        int r3 = r2.getType();
        int r6 = -1;
        if (r3 != 1) goto L23;
        zj r4 = r1.getRoomHotInfo();
        if (r4 == null) goto L27;
        r6 = r4.a();
    L27:
        Iterator<T> r5 = r2.b().iterator();
    L29:
        if (r5.hasNext() == false) goto L36;
        Object r7 = r5.next();
        if (((t2) r7).a() != r6) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L29;
    L37:
        t2 r14 = (t2) r7;
        if (r14 == null) goto L52;
        List<u2> r15 = r14.b();
        if (r15 == null) goto L52;
        Iterator<T> r16 = r15.iterator();
    L43:
        if (r16.hasNext() == false) goto L52;
        u2 r17 = (u2) r16.next();
        if (r17.a().size() != 2) goto L43;
        int r18 = ((Number) ListProtector.get(r17.a(), 0)).intValue();
        int r19 = ((Number) ListProtector.get(r17.a(), 1)).intValue();
        if (r18 > r13) goto L43;
        if (r19 <= r13) goto L43;
        return r17.b() / 100.0f;
    L33:
        r8 = false;
        goto L34
    L36:
        r7 = null;
        goto L37
    L23:
        if (r3 != 2) goto L27;
        zj r20 = r1.getRoomHotInfo();
        if (r20 == null) goto L27;
        r6 = r20.b();
    L52:
        return 1.0f;
    }
}
