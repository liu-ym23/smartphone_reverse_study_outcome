package r11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final boolean a(e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isForceDegradeEnable");
        if (r1.getEnable() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.V6() == false) goto L9;
        if (r1.g2() == false) goto L9;
        return true;
    }
}
