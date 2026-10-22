package com.obric.oui.orecyclerview.widget;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object r10, Object r11) {
        n r12 = (n) r10;
        n r13 = (n) r11;
        RecyclerView r5 = r12.d;
        if (r5 != null) goto L5;
        boolean r14 = true;
    L7:
        if (r13.d != null) goto L9;
        boolean r15 = true;
    L11:
        if (r14 == r15) goto L15;
        if (r5 != null) goto L26;
    L25:
        return 1;
    L26:
        return -1;
    L15:
        boolean r16 = r12.f13867a;
        if (r16 == r13.f13867a) goto L19;
        if (r16 == false) goto L25;
    L19:
        int r17 = r13.f13868b - r12.f13868b;
        if (r17 != 0) goto L27;
        r17 = r12.f13869c - r13.f13869c;
        if (r17 != 0) goto L27;
        return 0;
    L27:
        return r17;
    L9:
        r15 = false;
        goto L11
    L5:
        r14 = false;
        goto L7
    }
}
