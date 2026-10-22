package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.a;
import com.google.zxing.qrcode.detector.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class MultiFinderPatternFinder extends FinderPatternFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b[] f5083a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a[] f5084b = null;
    private static final a[][] c = null;

    /* JADX INFO: renamed from: com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ModuleSizeComparator implements Serializable, Comparator<a> {
        private ModuleSizeComparator() {
        }

        /* synthetic */ ModuleSizeComparator(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(a r3, a r4) {
            double r2 = r4.c() - r3.c();
            if (r2 >= 0.0d) goto L6;
            return -1;
        L6:
            if (r2 <= 0.0d) goto L8;
            return 1;
        L8:
            return 0;
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(a r3, a r4) {
            return compare2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f5083a = new b[0];
        f5084b = new a[0];
        c = new a[0][];
    }
}
