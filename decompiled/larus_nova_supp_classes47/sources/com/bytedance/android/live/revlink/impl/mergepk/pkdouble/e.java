package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.utils.s;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final cf2.a a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        Object r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r0.Ig();
    L6:
        if (r2 == null) goto L29;
        LiveData<List<cf2.a>> r3 = r2.getBaseScoreState();
        if (r3 == null) goto L30;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L31;
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L25;
        Object r6 = r5.next();
        String r7 = ((cf2.a) r6).c;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.a;
        if (r8 == null) goto L17;
        s r9 = r8.getRevLinkCommonUtil();
    L18:
        if (r9 == null) goto L20;
        String r10 = r9.c();
    L22:
        if ((!Intrinsics.areEqual(r7, r10)) == false) goto L13;
        r1 = r6;
        goto L25
    L20:
        r10 = null;
        goto L22
    L17:
        r9 = null;
    L25:
        return (cf2.a) r1;
    L31:
        return null;
    L30:
        return null;
    L29:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public e(LinkFakeGlobalService r1) {
        this.a = r1;
    }
}
