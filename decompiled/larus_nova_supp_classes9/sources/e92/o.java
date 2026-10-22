package e92;

import com.bytedance.android.livesdkapi.model.SeiRegion;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements Comparator {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r8, Object r9) {
        SeiRegion r10 = (SeiRegion) r8;
        SeiRegion r11 = (SeiRegion) r9;
        Intrinsics.checkNotNullParameter(r10, "regionL");
        Intrinsics.checkNotNullParameter(r11, "regionR");
        if (r10.getY() == r11.getY()) goto L8;
        if (r10.getY() >= r11.getY()) goto L14;
    L6:
        return -1;
    L14:
        return 1;
    L8:
        if (r10.getX() != r11.getX()) goto L10;
        return 0;
    L10:
        if (r10.getX() < r11.getX()) goto L6;
        return 1;
    }
}
