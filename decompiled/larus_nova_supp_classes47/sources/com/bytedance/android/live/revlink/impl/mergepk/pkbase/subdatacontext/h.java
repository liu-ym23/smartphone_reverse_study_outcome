package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import com.bytedance.android.livesdk.link.model.a1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final List<cf2.a> a(List<? extends a1> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$convertToWrapperList");
        ArrayList r0 = new ArrayList();
        Iterator<? extends a1> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(new cf2.a(r5.next(), null, null, null));
        goto L4
    L6:
        return r0;
    }
}
