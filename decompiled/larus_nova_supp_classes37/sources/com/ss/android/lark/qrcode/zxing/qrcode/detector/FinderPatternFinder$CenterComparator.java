package com.ss.android.lark.qrcode.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
final class FinderPatternFinder$CenterComparator implements Comparator<a>, Serializable {
    private final float average;

    public FinderPatternFinder$CenterComparator(float r1, b r2) {
        this.average = r1;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(a r2, a r3) {
        r3.getClass();
        r2.getClass();
        int r4 = Integer.compare(0, 0);
        if (r4 == 0) goto L5;
        return r4;
    L5:
        return Float.compare(Math.abs(0.0f - this.average), Math.abs(0.0f - this.average));
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(a r1, a r2) {
        return compare2(r1, r2);
    }
}
