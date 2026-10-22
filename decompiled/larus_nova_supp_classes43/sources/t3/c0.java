package t3;

import com.bytedance.ai.bridge.context.RefType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 {
    public static final y a(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RefType r0 = RefType.NORMAL;
        Object r1 = r10.d(y.class);
        if (r1 != null) goto L6;
        r1 = new y(r10);
        r10.b(y.class, r1, r0);
    L6:
        return (y) r1;
    }
}
