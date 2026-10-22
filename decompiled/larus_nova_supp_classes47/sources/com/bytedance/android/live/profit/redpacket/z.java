package com.bytedance.android.live.profit.redpacket;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z<T> implements Comparator {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r3, Object r4) {
        RedPacketIconHelpersKt$generateEntryList$topUsers$2.a r5 = (RedPacketIconHelpersKt$generateEntryList$topUsers$2.a) r3;
        RedPacketIconHelpersKt$generateEntryList$topUsers$2.a r6 = (RedPacketIconHelpersKt$generateEntryList$topUsers$2.a) r4;
        int r0 = r5.a;
        int r1 = r6.a;
        if (r0 == r1) goto L6;
        return Intrinsics.compare(r1, r0);
    L6:
        return r5.b.f.a(r6.b.f);
    }
}
