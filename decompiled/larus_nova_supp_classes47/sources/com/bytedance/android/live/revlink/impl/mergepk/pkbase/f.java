package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.utils.s;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final cf2.a a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        Object r1 = null;
        if (r0 == null) goto L5;
        e r2 = r0.Ig();
    L6:
        if (r2 == null) goto L28;
        LiveData<List<cf2.a>> r3 = r2.getBaseScoreState();
        if (r3 == null) goto L29;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L30;
        com.bytedance.android.live.revlink.impl.global.c r5 = this.a;
        Intrinsics.checkNotNullParameter(r4, "$this$selfAnchorScore");
        Iterator r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();
        String r8 = ((cf2.a) r7).c;
        if (r5 == null) goto L19;
        s r9 = r5.getRevLinkCommonUtil();
        if (r9 == null) goto L19;
        String r10 = r9.c();
    L21:
        if (Intrinsics.areEqual(r8, r10) == false) goto L13;
        r1 = r7;
    L19:
        r10 = null;
    L24:
        return (cf2.a) r1;
    L30:
        return null;
    L29:
        return null;
    L28:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public f(LinkFakeGlobalService r1) {
        this.a = r1;
    }
}
