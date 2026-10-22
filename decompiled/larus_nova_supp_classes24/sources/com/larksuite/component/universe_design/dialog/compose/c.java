package com.larksuite.component.universe_design.dialog.compose;

import java.util.Comparator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r6, T r7) {
        UDDialogActionRole r8 = ((b) r6).c;
        int[] r0 = UDDialogKt.a.a;
        int r9 = r0[r8.ordinal()];
        int r1 = 0;
        if (r9 == 1) goto L9;
        if (r9 == 2) goto L9;
        if (r9 != 3) goto L8;
        int r10 = 1;
    L10:
        Integer r11 = Integer.valueOf(r10);
        int r12 = r0[((b) r7).c.ordinal()];
        if (r12 == 1) goto L18;
        if (r12 == 2) goto L18;
        if (r12 != 3) goto L16;
        r1 = 1;
        goto L18
    L16:
        throw new NoWhenBranchMatchedException();
    L18:
        return ComparisonsKt.compareValues(r11, Integer.valueOf(r1));
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r10 = 0;
        goto L10
    }
}
