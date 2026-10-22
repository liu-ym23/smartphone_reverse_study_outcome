package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerMap implements Quantizer {
    Map<Integer, Integer> colorToCount;

    public QuantizerMap() {
    }

    public Map<Integer, Integer> getColorToCount() {
        return this.colorToCount;
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] r10, int r11) {
        LinkedHashMap r12 = new LinkedHashMap();
        int r5 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L9;
        int r14 = r10[r13];
        Integer r15 = (Integer) r12.get(Integer.valueOf(r14));
        int r16 = 1;
        if (r15 == null) goto L8;
        r16 = 1 + r15.intValue();
    L8:
        r12.put(Integer.valueOf(r14), Integer.valueOf(r16));
        r13 = r13 + 1;
        goto L3
    L9:
        this.colorToCount = r12;
        return new QuantizerResult(r12);
    }
}
