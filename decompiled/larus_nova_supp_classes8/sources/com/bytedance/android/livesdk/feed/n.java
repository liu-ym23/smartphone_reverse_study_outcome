package com.bytedance.android.livesdk.feed;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n<T> implements k<T> {
    public n() {
    }

    @Override // com.bytedance.android.livesdk.feed.k
    public final boolean a(List<T> r6, List<T> r7) {
        if (r6 != null) goto L6;
        if (r7 != null) goto L6;
        return true;
    L6:
        if (r6 != r7) goto L9;
        return true;
    L9:
        if (r6 == null) goto L30;
        if (r7 == null) goto L30;
        if (r6.size() != r7.size()) goto L30;
        int r2 = 0;
    L16:
        if (r2 >= r6.size()) goto L29;
        Object r3 = ListProtector.get(r6, r2);
        Object r4 = ListProtector.get(r7, r2);
        if (r3 != null) goto L21;
        if (r4 != null) goto L21;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L27;
        r2 = r2 + 1;
        goto L16
    L27:
        return false;
    L21:
        if (r3 == null) goto L25;
        if (r4 == null) goto L25;
        r5 = r3.equals(r4);
    L25:
        r5 = false;
        goto L26
    L29:
        return true;
    L30:
        return false;
    }
}
