package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerCelebi {
    private QuantizerCelebi() {
    }

    public static Map<Integer, Integer> quantize(int[] r5, int r10) {
        Set<Integer> r11 = new QuantizerWu().quantize(r5, r10).colorToCount.keySet();
        int[] r12 = new int[r11.size()];
        Iterator<Integer> r13 = r11.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L7;
        r12[r14] = r13.next().intValue();
        r14 = r14 + 1;
        goto L4
    L7:
        return QuantizerWsmeans.quantize(r5, r12, r10);
    }
}
