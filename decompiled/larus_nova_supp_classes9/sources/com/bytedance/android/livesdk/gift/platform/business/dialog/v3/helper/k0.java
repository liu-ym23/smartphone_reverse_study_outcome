package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(w1 r7) {
        if (((Boolean) nz1.a.I.getValue(null, nz1.a.a[33])).booleanValue() == true) goto L5;
        return;
    L5:
        if (r7 != null) goto L7;
        return;
    L7:
        HashSet r0 = (HashSet) ay1.b.g0.getValue(null, ay1.b.a[70]);
        Iterator<h1> r8 = r7.getGifts().iterator();
    L9:
        if (r8.hasNext() == false) goto L16;
        h1 r1 = r8.next();
        if (r1.isDisplayedOnPanel() == false) goto L9;
        if (((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).g1(r1.getPrimaryEffectId()) == false) goto L9;
        r0.add(String.valueOf(r1.getId()));
        goto L9
    L16:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ay1.b.g0.setValue(null, ay1.b.a[70], r0);
    }
}
