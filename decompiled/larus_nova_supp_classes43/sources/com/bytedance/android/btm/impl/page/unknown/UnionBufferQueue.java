package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UnionBufferQueue {
    public static UnionBufferBtm a;

    static {
    }

    public static boolean a(final UnionData r10) {
        if (BtmSetting.d.c().c().L() == 1) goto L5;
        return false;
    L5:
        ALogger.l(ALogger.d, "UnionBufferQueue_consume", new UnionBufferQueue$consumeUnionBuffer$1(r10));
        if (r10.getUnionStep() <= 0) goto L8;
        return false;
    L8:
        UnionBufferBtm r0 = a;
        if (r0 != null) goto L11;
        r10.setUnionStep(1);
        r10.setUnionPre(null);
        return false;
    L11:
        if (Intrinsics.areEqual(r0.getPageId(), r10.getPageId()) == false) goto L13;
        return false;
    L13:
        r10.setUnionStep(r0.getUnionStep() + 1);
        r10.setUnionPre(r0.getBtm());
        if ((r10 instanceof UnknownPageInfo) == true) goto L16;
        r10 = null;
    L16:
        UnknownPageInfo r11 = (UnknownPageInfo) r10;
        if (r11 == null) goto L19;
        r11.setBufferBtm(r0.getBufferBtm());
    L19:
        return true;
    }

    public static void b(final UnionData r10, final BufferBtm r11) {
        BtmSetting r0 = BtmSetting.d;
        if (r0.c().c().L() == 1) goto L5;
        return;
    L5:
        ALogger.l(ALogger.d, "UnionBufferQueue_set", new UnionBufferQueue$setUnionBuffer$1(r10, r11));
        if (r10.getUnionStep() < 1) goto L30;
        String r1 = r10.getPageBtm();
        if (r1 != null) goto L10;
    L13:
        boolean r12 = true;
    L14:
        if (r12 == true) goto L31;
        Lazy r13 = BtmFormatUtils.a;
        String r14 = r10.getPageBtm();
        if (r14 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        String r15 = BtmFormatUtils.a(r14);
        if ((r10 instanceof UnknownPageInfo) == false) goto L22;
        ((UnknownPageInfo) r10).getMountBtmIds().add(r15);
    L22:
        Lazy r16 = UnionChainRecorder.a;
        String r17 = r10.getUnionPre();
        if (r0.c().c().L() != 1) goto L28;
        if (r15 == null) goto L28;
        if (r17 == null) goto L28;
        UnionChainRecorder.d.put(r15, r17);
    L28:
        a = new UnionBufferBtm(r15, r10.getUnionStep(), r10.getPageId(), r11);
        return;
    L31:
        return;
    L10:
        if (r1.length() == 0) goto L13;
        r12 = false;
        goto L14
    }
}
