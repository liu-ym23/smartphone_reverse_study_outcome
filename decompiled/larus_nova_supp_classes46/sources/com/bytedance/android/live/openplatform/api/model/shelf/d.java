package com.bytedance.android.live.openplatform.api.model.shelf;

import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.live.datacontext.n;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final AtomicLong a = null;

    static {
        a = new AtomicLong(1);
    }

    public static final int a(long r7) {
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r0 = MiniAppDataContext.a.a();
        if (r0 == null) goto L23;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L23;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L23;
        List<ShelfCardInfo> r3 = r2.cardInfoList;
        if (r3 == null) goto L23;
        ListIterator<ShelfCardInfo> r4 = r3.listIterator(r3.size());
    L12:
        if (r4.hasPrevious() == false) goto L19;
        ShelfCardInfo r5 = r4.previous();
        if (r5.cardId != r7) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L12;
    L20:
        ShelfCardInfo r8 = r5;
        if (r8 == null) goto L23;
        return r3.indexOf(r8) + 1;
    L16:
        r6 = false;
        goto L17
    L19:
        r5 = null;
    L23:
        return -1;
    }
}
