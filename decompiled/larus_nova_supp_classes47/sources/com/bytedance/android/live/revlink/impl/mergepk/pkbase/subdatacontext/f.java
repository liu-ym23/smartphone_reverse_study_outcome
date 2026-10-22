package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import com.bytedance.android.live.revlink.impl.utils.s;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final PkBaseResult a(Map<String, ? extends PkBaseResult> r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$selfAnchorPkResult");
        if (r2 == null) goto L7;
        s r3 = r2.getRevLinkCommonUtil();
        if (r3 == null) goto L7;
        String r4 = r3.c();
    L8:
        PkBaseResult r5 = r1.get(r4);
        if (r5 == null) goto L11;
        return r5;
    L11:
        return PkBaseResult.NOT_FINISH;
    L7:
        r4 = null;
        goto L8
    }
}
