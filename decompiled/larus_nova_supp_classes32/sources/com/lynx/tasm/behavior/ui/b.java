package com.lynx.tasm.behavior.ui;

import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Comparator {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Object r4, Object r5) {
        Rect r6 = ((c.a) r4).c;
        Rect r7 = ((c.a) r5).c;
        int r0 = this.a.a;
        if (r0 != 0) goto L5;
        int r1 = r6.top - r7.top;
    L6:
        int r8 = r6.left - r7.left;
        if (r1 == 0) goto L9;
        return r1;
    L9:
        return r8;
    L5:
        r1 = (r6.top / r0) - (r7.top / r0);
        goto L6
    }
}
