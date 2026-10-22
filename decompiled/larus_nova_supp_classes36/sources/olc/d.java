package olc;

import android.graphics.Bitmap;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements Comparator<Bitmap> {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Bitmap r2, Bitmap r3) {
        Bitmap r4 = r2;
        Bitmap r5 = r3;
        if (Intrinsics.areEqual(r4, r5) == false) goto L5;
        return 0;
    L5:
        int r6 = r4.getByteCount() - r5.getByteCount();
        if (r6 != 0) goto L10;
        return -1;
    L10:
        return r6;
    }
}
