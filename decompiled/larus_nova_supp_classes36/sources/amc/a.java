package amc;

import kotlin.jvm.internal.Intrinsics;
import vlc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final o a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getUrlSwitcher");
        if ((r2 instanceof h) == true) goto L5;
        r2 = null;
    L5:
        h r3 = (h) r2;
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.o();
    }
}
