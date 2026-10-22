package zr0;

import android.content.res.Configuration;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.utils.e5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final b03.b a(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toPlatformCfg");
        int r1 = r5.orientation;
        boolean r3 = true;
        if (r1 != (-1)) goto L8;
        if (e5.n() == false) goto L9;
    L10:
        boolean r2 = false;
    L12:
        if (FoldScreenUtils.f() == true) goto L14;
    L16:
        r3 = false;
    L18:
        return new b03.b(r2, r3);
    L14:
        if (FoldScreenUtils.c(r5) != 0) goto L16;
    L9:
        r2 = true;
        goto L12
    L8:
        if (e5.o(r1) == true) goto L10;
        goto L9
    }
}
