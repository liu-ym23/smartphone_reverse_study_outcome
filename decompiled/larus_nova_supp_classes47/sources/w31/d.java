package w31;

import com.bytedance.android.live.revlink.impl.model.BizType;
import ey.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final boolean a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isClassicDouble");
        if (r2.c != BizType.PK.ordinal()) goto L5;
    L8:
        return true;
    L5:
        if (r2.c == BizType.OpenGame.ordinal()) goto L8;
        return false;
    }
}
