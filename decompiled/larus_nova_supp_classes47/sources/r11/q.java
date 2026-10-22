package r11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public static final float a(p r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getValidRatio");
        if (Float.compare(0.0f, r2.getRatio()) < 0) goto L6;
        return 0.72f;
    L6:
        return r2.getRatio();
    }
}
