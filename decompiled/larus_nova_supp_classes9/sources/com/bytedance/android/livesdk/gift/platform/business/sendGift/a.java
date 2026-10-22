package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Comparator {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r2, Object r3) {
        com.bytedance.android.livesdk.gift.model.m r4 = (com.bytedance.android.livesdk.gift.model.m) r2;
        com.bytedance.android.livesdk.gift.model.m r5 = (com.bytedance.android.livesdk.gift.model.m) r3;
        Intrinsics.checkNotNullParameter(r4, "o1");
        Intrinsics.checkNotNullParameter(r5, "o2");
        return r5.leftGiftCount - r4.leftGiftCount;
    }
}
