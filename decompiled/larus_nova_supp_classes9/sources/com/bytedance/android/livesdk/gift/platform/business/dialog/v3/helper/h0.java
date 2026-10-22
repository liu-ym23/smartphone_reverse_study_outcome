package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(List r6, List r7, GiftListRepository r8) {
        Intrinsics.checkNotNullParameter(r6, "seriesGiftList");
        Intrinsics.checkNotNullParameter(r8, "giftListRepository");
        if (r7 == null) goto L9;
        ArrayList r1 = new ArrayList();
        Iterator r9 = r7.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        CollectionsKt.addAll(r1, ((com.bytedance.android.livesdk.gift.platform.core.giftlist.j) r9.next()).l);
        goto L6
    L8:
        Set r10 = CollectionsKt.toSet(r1);
    L10:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r11 = r6.iterator();
    L12:
        if (r11.hasNext() == false) goto L20;
        k3 r3 = (k3) r11.next();
        if (r10 == null) goto L12;
        if (r10.contains(Long.valueOf(r3.getGiftId())) != true) goto L12;
        h1 r4 = r8.o4(r3.getGiftId(), null);
        if (r4 == null) goto L12;
        r2.put(Long.valueOf(r3.getGiftId()), r4);
        goto L12
    L20:
        return r2;
    L9:
        r10 = null;
        goto L10
    }
}
