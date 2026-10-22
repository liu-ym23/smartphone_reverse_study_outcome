package com.bytedance.android.live.openplatform.api.model.shelf;

import com.bytedance.android.livesdk.utils.r2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final ShelfCardInfo a(ShelfInfo r7) {
        Object r0 = null;
        if (r7 == null) goto L22;
        List<ShelfCardInfo> r8 = r7.cardInfoList;
        if (r8 == null) goto L23;
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L16;
        Object r1 = r9.next();
        if (((ShelfCardInfo) r1).status != 1) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L8;
        r0 = r1;
        goto L16
    L12:
        r2 = false;
    L16:
        return (ShelfCardInfo) r0;
    L23:
        return null;
    L22:
        return null;
    }

    public static final int b(ShelfInfo r2) {
        int r0 = 0;
        if (r2 == null) goto L19;
        List<ShelfCardInfo> r3 = r2.cardInfoList;
        if (r3 == null) goto L19;
        List<ShelfCardInfo> r4 = r3;
        if ((r4 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L19;
        if (r2.a(((ShelfCardInfo) r5.next()).sellingPoint) == false) goto L13;
        r0 = r0 + 1;
        if (r0 >= 0) goto L13;
        CollectionsKt.throwCountOverflow();
        goto L13
    L9:
        if (r4.isEmpty() == false) goto L11;
    L19:
        return r0;
    }

    public static final boolean c(ShelfInfo r1) {
        if (r1 == null) goto L5;
        int r2 = r1.coexistRoom;
    L6:
        if (r2 == 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r2 = 0;
        goto L6
    }

    public static final boolean d(ShelfInfo r3) {
        Object r0 = null;
        if (r3 == null) goto L13;
        List<ShelfCardInfo> r4 = r3.cardInfoList;
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r1 = r5.next();
        if (((ShelfCardInfo) r1).v0() == false) goto L8;
        r0 = r1;
    L12:
        r0 = (ShelfCardInfo) r0;
    L13:
        if (r0 == null) goto L15;
        return true;
    L15:
        return false;
    }
}
