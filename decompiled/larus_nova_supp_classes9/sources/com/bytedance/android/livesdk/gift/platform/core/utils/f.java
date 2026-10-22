package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordService;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public f() {
    }

    static {
    }

    public static void a(Collection r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L7;
        IRoom r1 = r0.getRoom();
    L8:
        if (r1 != null) goto L20;
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L28;
        Object r2 = r6.next();
        if ((r2 instanceof h1) == true) goto L15;
        r2 = null;
    L15:
        h1 r3 = (h1) r2;
        if (r3 == null) goto L11;
        GiftManagerKt r4 = GiftManagerKt.z;
        long r7 = r3.getId();
        r4.getClass();
        if (GiftManagerKt.z(r7) == false) goto L11;
        r6.remove();
        goto L11
    L28:
        return;
    L20:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @JvmStatic
    public static final void d(Collection<? extends h1> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Iterator<? extends h1> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        h1 r0 = r3.next();
        if ((r0 instanceof h1) == true) goto L10;
        r0 = null;
    L10:
        h1 r1 = r0;
        if (r1 == null) goto L6;
        if (r1.isDisplayedOnPanel() == true) goto L6;
        r3.remove();
        goto L6
    }

    @JvmStatic
    public static final int c(Collection<? extends h1> r1, boolean r2, Function1<? super h1, Unit> r3) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r4 = e(r1, r2, r3);
        Iterator<? extends h1> r5 = r1.iterator();
    L7:
        if (r5.hasNext() == false) goto L16;
        h1 r6 = r5.next();
        if ((r6 instanceof h1) == true) goto L11;
        r6 = null;
    L11:
        h1 r7 = r6;
        if (r7 == null) goto L7;
        if (r7.isForLinkMic() == true) goto L7;
        r5.remove();
        goto L7
    L16:
        return r4;
    }

    @JvmStatic
    public static final int e(Collection<? extends h1> r16, boolean r17, Function1<? super h1, Unit> r18) {
        if (r16 != null) goto L5;
        return 0;
    L5:
        v1 r2 = com.bytedance.android.livesdk.gift.platform.business.i.m();
        Iterator<? extends h1> r3 = r16.iterator();
        boolean r4 = AssetsUtils.b(r17);
        AssetsService r5 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        ResourceRecordService r6 = (ResourceRecordService) com.bytedance.android.live.revenue.core.util.f.a(ResourceRecordService.class);
        int r7 = 0;
    L7:
        if (r3.hasNext() == false) goto L118;
        h1 r8 = r3.next();
        if ((r8 instanceof h1) == true) goto L11;
        r8 = null;
    L11:
        h1 r9 = r8;
        if (r9 == null) goto L7;
        if (r9.getId() != 998) goto L17;
        r3.remove();
        goto L7
    L17:
        if (r4 == false) goto L19;
        r9.setFreeDisplay(true);
        goto L7
    L19:
        int r11 = -1;
        if (r2.b5() == false) goto L37;
        if (r2.getEnable() == false) goto L37;
        com.bytedance.android.live.core.resources.e r10 = r5.G1(r9.getPrimaryEffectId());
        if (r10 == null) goto L26;
        int r13 = r10.getResourceType();
    L28:
        if (r2.s3().contains(Integer.valueOf(r9.getType())) == true) goto L37;
        if (r2.z5().contains(Integer.valueOf(r13)) == true) goto L37;
        List<Long> r14 = r2.f2();
        if (r14 != null) goto L34;
    L35:
        r9.setFreeDisplay(true);
        goto L7
    L34:
        if (r14.contains(Long.valueOf(r9.getId())) == true) goto L37;
    L26:
        r13 = -1;
    L37:
        if (r9.getType() != 2) goto L39;
    L46:
        List<Long> r15 = r9.getAssetIds();
        Iterator<Long> r19 = r15.iterator();
    L48:
        if (r19.hasNext() == false) goto L63;
        long r110 = r19.next().longValue();
        com.bytedance.android.live.core.resources.e r111 = r5.G1(r110);
        if (r111 != null) goto L52;
    L54:
        List<Long> r1 = r9.getOptionalAssetIds();
        if (r1 == null) goto L60;
        if (r1.contains(Long.valueOf(r110)) == true) goto L48;
    L60:
        if (r5.g1(r110) == true) goto L48;
        boolean r20 = false;
    L64:
        if (r20 == false) goto L66;
    L90:
        if (r9.getType() != 4) goto L7;
        if (r17 == false) goto L7;
        if (r9.getGiftSource() == 1) goto L7;
        if (r4 == true) goto L7;
        if (r5.g1(r9.getPrimaryEffectId()) == true) goto L7;
        if (r2.getEnable() == false) goto L114;
        com.bytedance.android.live.core.resources.e r21 = r5.G1(r9.getPrimaryEffectId());
        if (r21 == null) goto L103;
        r11 = r21.getResourceType();
    L103:
        if (r2.s3().contains(Integer.valueOf(r9.getType())) == false) goto L105;
    L111:
        if (r18 == null) goto L113;
        r18.invoke(r9);
    L113:
        r7 = r7 + 1;
        r3.remove();
        goto L7
    L105:
        if (r2.z5().contains(Integer.valueOf(r11)) == true) goto L111;
        List<Long> r23 = r2.f2();
        if (r23 != null) goto L109;
    L110:
        r9.setFreeDisplay(true);
        goto L7
    L109:
        if (r23.contains(Long.valueOf(r9.getId())) == true) goto L111;
    L114:
        if (r18 == null) goto L116;
        r18.invoke(r9);
    L116:
        r7 = r7 + 1;
        r3.remove();
        goto L7
    L66:
        if (r2.getEnable() == false) goto L86;
        com.bytedance.android.live.core.resources.e r24 = r5.G1(r9.getPrimaryEffectId());
        if (r24 == null) goto L70;
        int r25 = r24.getResourceType();
    L72:
        if (r2.s3().contains(Integer.valueOf(r9.getType())) == false) goto L74;
    L80:
        Iterator<Long> r26 = r15.iterator();
    L82:
        if (r26.hasNext() == false) goto L86;
        long r112 = r26.next().longValue();
        String r113 = r5.D1(r112);
        if (r113 == null) goto L82;
        r6.x(r113, true, r112);
        goto L82
    L74:
        if (r2.z5().contains(Integer.valueOf(r25)) == true) goto L80;
        List<Long> r27 = r2.f2();
        if (r27 != null) goto L78;
    L79:
        r9.setFreeDisplay(true);
        goto L7
    L78:
        if (r27.contains(Long.valueOf(r9.getId())) == true) goto L80;
    L70:
        r25 = -1;
    L86:
        if (r18 == null) goto L88;
        r18.invoke(r9);
    L88:
        r3.remove();
        r7 = r7 + 1;
        goto L90
    L52:
        if (r111.getDownloadType() != 3) goto L54;
        jy0.b.a("GiftListFilterHelper", "打开礼物面板直接展示懒下载礼物，资源id：" + r110);
    L63:
        r20 = true;
        goto L64
    L39:
        if (r9.getType() == 8) goto L46;
        if (r9.getType() == 11) goto L46;
        if (r9.getType() == 13) goto L46;
        if (r9.getType() != 15) goto L90;
    L118:
        return r7;
    }

    public static void b(Collection r2, boolean r3, boolean r4, boolean r5) {
        if (r4 == true) goto L8;
        if (r5 == true) goto L8;
        c(r2, r3, null);
        d(r2);
        a(r2);
        return;
    L8:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.F.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[30])).booleanValue() == false) goto L10;
        d(r2);
        e(r2, r3, null);
        a(r2);
        return;
    L10:
        e(r2, r3, null);
        d(r2);
        a(r2);
    }
}
