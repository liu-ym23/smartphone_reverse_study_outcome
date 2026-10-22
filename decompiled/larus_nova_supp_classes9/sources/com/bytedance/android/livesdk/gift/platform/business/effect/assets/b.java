package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import java.io.File;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements dy0.c, com.bytedance.android.scope.o {

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            long r0 = ((com.bytedance.android.livesdk.gift.platform.core.scope.service.l) r5).f - ((com.bytedance.android.livesdk.gift.platform.core.scope.service.l) r4).f;
            if (r0 <= 0) goto L5;
            return 1;
        L5:
            if (r0 != 0) goto L7;
            return 0;
        L7:
            return -1;
        }
    }

    public b() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static PriorityQueue a(File[] r17, long r18) {
        long r1 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        PriorityQueue r3 = new PriorityQueue(20, a.a);
        int r4 = r17.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L14;
        File r6 = r17[r5];
        if (r6.exists() == false) goto L13;
        String r11 = r6.getName();
        if (r11.equals("zip") == true) goto L13;
        long r14 = r1 - com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r11);
        if (r14 <= r18) goto L13;
        r3.add(new com.bytedance.android.livesdk.gift.platform.core.scope.service.l(0, r11, null, r6.getPath(), r14, 11));
    L13:
        r5 = r5 + 1;
        goto L3
    L14:
        return r3;
    }
}
