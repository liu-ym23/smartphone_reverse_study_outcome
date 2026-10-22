package com.ss.android.lark.qrcode.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
final class FinderPatternFinder$FurthestFromAverageComparator implements Comparator<a>, Serializable {
    private final float average;

    public FinderPatternFinder$FurthestFromAverageComparator(float r1, b r2) {
        this.average = r1;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(a r2, a r3) {
        r3.getClass();
        float r4 = Math.abs(0.0f - this.average);
        r2.getClass();
        return Float.compare(r4, Math.abs(0.0f - this.average));
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(a r1, a r2) {
        return compare2(r1, r2);
    }
}
