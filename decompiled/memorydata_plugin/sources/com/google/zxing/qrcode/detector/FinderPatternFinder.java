package com.google.zxing.qrcode.detector;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class FinderPatternFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final EstimatedModuleComparator f5096a = null;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.detector.FinderPatternFinder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class EstimatedModuleComparator implements Serializable, Comparator<a> {
        private EstimatedModuleComparator() {
        }

        /* synthetic */ EstimatedModuleComparator(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(a r1, a r2) {
            return Float.compare(r1.c(), r2.c());
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(a r3, a r4) {
            return compare2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f5096a = new EstimatedModuleComparator(null);
    }
}
