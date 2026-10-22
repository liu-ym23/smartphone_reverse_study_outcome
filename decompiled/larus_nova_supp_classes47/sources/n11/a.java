package n11;

import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static double a(List r7) {
        Intrinsics.checkNotNullParameter(r7, "grids");
        if (r7.isEmpty() == false) goto L5;
    L28:
        double r0 = 0.0d;
    L30:
        return r0 - c(r7);
    L5:
        if (ListProtector.get(r7, 0) == null) goto L28;
        IntRange r1 = CollectionsKt.getIndices(r7);
        ArrayList r2 = new ArrayList();
        IntIterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L22;
        RevSeiRegion r4 = (RevSeiRegion) ListProtector.get(r7, r3.nextInt());
        if (r4 == null) goto L19;
        float r5 = (float) r4.getWidth();
        float r6 = (float) r4.getHeight();
        double r8 = r4.getY();
        if (r5 <= 0.0f) goto L19;
        if (r6 <= 0.0f) goto L19;
        Double r9 = Double.valueOf(r8 + ((double) r6));
    L20:
        if (r9 == null) goto L9;
        r2.add(r9);
    L19:
        r9 = null;
        goto L20
    L22:
        List r10 = CollectionsKt.sorted(r2);
        if (r10.isEmpty() == true) goto L28;
        Double r12 = (Double) CollectionsKt.lastOrNull(r10);
        if (r12 == null) goto L28;
        r0 = r12.doubleValue();
        goto L30
    }

    public static double b(List r9) {
        Intrinsics.checkNotNullParameter(r9, "grids");
        if (r9.isEmpty() == false) goto L5;
        return 0.0d;
    L5:
        if (ListProtector.get(r9, 0) == null) goto L36;
        IntRange r0 = CollectionsKt.getIndices(r9);
        ArrayList r3 = new ArrayList();
        IntIterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L22;
        RevSeiRegion r4 = (RevSeiRegion) ListProtector.get(r9, r1.nextInt());
        if (r4 == null) goto L19;
        float r5 = (float) r4.getWidth();
        float r6 = (float) r4.getHeight();
        double r7 = r4.getX();
        if (r5 <= 0.0f) goto L19;
        if (r6 <= 0.0f) goto L19;
        Double r8 = Double.valueOf(r7);
    L20:
        if (r8 == null) goto L9;
        r3.add(r8);
    L19:
        r8 = null;
        goto L20
    L22:
        List r10 = CollectionsKt.sorted(r3);
        if (r10.isEmpty() == false) goto L25;
        return 0.0d;
    L25:
        Double r12 = (Double) CollectionsKt.firstOrNull(r10);
        if (r12 != null) goto L28;
        return 0.0d;
    L28:
        return r12.doubleValue();
    L36:
        return 0.0d;
    }

    public static double c(List r9) {
        Intrinsics.checkNotNullParameter(r9, "grids");
        if (r9.isEmpty() == false) goto L5;
        return 0.0d;
    L5:
        if (ListProtector.get(r9, 0) == null) goto L36;
        IntRange r0 = CollectionsKt.getIndices(r9);
        ArrayList r3 = new ArrayList();
        IntIterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L22;
        RevSeiRegion r4 = (RevSeiRegion) ListProtector.get(r9, r1.nextInt());
        if (r4 == null) goto L19;
        float r5 = (float) r4.getWidth();
        float r6 = (float) r4.getHeight();
        double r7 = r4.getY();
        if (r5 <= 0.0f) goto L19;
        if (r6 <= 0.0f) goto L19;
        Double r8 = Double.valueOf(r7);
    L20:
        if (r8 == null) goto L9;
        r3.add(r8);
    L19:
        r8 = null;
        goto L20
    L22:
        List r10 = CollectionsKt.sorted(r3);
        if (r10.isEmpty() == false) goto L25;
        return 0.0d;
    L25:
        Double r12 = (Double) CollectionsKt.firstOrNull(r10);
        if (r12 != null) goto L28;
        return 0.0d;
    L28:
        return r12.doubleValue();
    L36:
        return 0.0d;
    }

    public static double d(List r8) {
        Intrinsics.checkNotNullParameter(r8, "grids");
        if (r8.isEmpty() == false) goto L5;
    L28:
        double r0 = 0.0d;
    L30:
        return r0 - b(r8);
    L5:
        if (ListProtector.get(r8, 0) == null) goto L28;
        IntRange r1 = CollectionsKt.getIndices(r8);
        ArrayList r2 = new ArrayList();
        IntIterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L22;
        RevSeiRegion r4 = (RevSeiRegion) ListProtector.get(r8, r3.nextInt());
        if (r4 == null) goto L19;
        float r5 = (float) r4.getWidth();
        float r6 = (float) r4.getHeight();
        double r7 = r4.getX();
        if (r5 <= 0.0f) goto L19;
        if (r6 <= 0.0f) goto L19;
        Double r9 = Double.valueOf(r7 + ((double) r5));
    L20:
        if (r9 == null) goto L9;
        r2.add(r9);
    L19:
        r9 = null;
        goto L20
    L22:
        List r10 = CollectionsKt.sorted(r2);
        if (r10.isEmpty() == true) goto L28;
        Double r12 = (Double) CollectionsKt.lastOrNull(r10);
        if (r12 == null) goto L28;
        r0 = r12.doubleValue();
        goto L30
    }
}
