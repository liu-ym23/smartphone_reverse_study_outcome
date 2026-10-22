package v3;

import com.bytedance.ai.bridge.context.RefType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final h a(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RefType r0 = RefType.NORMAL;
        Object r1 = r10.d(h.class);
        if (r1 != null) goto L6;
        r1 = new h(r10);
        r10.b(h.class, r1, r0);
    L6:
        return (h) r1;
    }
}
