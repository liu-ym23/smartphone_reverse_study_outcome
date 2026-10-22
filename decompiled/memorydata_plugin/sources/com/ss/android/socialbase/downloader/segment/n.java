package com.ss.android.socialbase.downloader.segment;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class n {
    public static long a(List<i> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        int r0 = r9.size();
        long r2 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L10;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r9.get(r4), i.class, "com.obric.memorydata.plugin");
        if (r5.c() > r2) goto L10;
        if (r5.e() <= r2) goto L9;
        r2 = r5.e();
    L9:
        r4 = r4 + 1;
    L10:
        return r2;
    }

    public static long b(List<i> r14) {
        Iterator r15 = ((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin")).iterator();
        long r10 = 0;
    L3:
        long r6 = -1;
        long r8 = -1;
    L5:
        if (r15.hasNext() == false) goto L21;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r15.next(), i.class, "com.obric.memorydata.plugin");
        if (r6 == (-1)) goto L9;
        if (r0.c() > r8) goto L17;
        if (r0.d() <= r8) goto L5;
    L11:
        r8 = r0.d();
        goto L5
    L17:
        r10 = r10 + (r8 - r6);
        if (r0.a() <= 0) goto L3;
    L10:
        r6 = r0.c();
        goto L11
    L9:
        if (r0.a() <= 0) goto L5;
    L21:
        if (r6 >= 0) goto L23;
        return r10;
    L23:
        if (r8 > r6) goto L25;
        return r10;
    L25:
        return r10 + (r8 - r6);
    }
}
