package com.bytedance.apm.launch.evil;

import com.bytedance.monitor.collector.BinderMonitor;
import com.bytedance.monitor.collector.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static long a() {
        long r1 = 0;
        if (com.bytedance.apm.launch.a.a().c().b() == true) goto L5;
    L15:
        return r1;
    L5:
        if (com.bytedance.apm.internal.a.b(2) == false) goto L15;
        List<BinderMonitor.a> r0 = k.a().k();
        if (r0 != null) goto L9;
    L14:
        com.bytedance.apm.launch.a.a().b("binder cost when launch: " + r1);
        goto L15
    L9:
        if (r0.isEmpty() == true) goto L14;
        Iterator<BinderMonitor.a> r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        BinderMonitor.a r3 = (BinderMonitor.a) ZeusTransformUtils.preCheckCast(r2.next(), BinderMonitor.a.class, "com.obric.memorydata.plugin");
        long r4 = r3.b() - r3.a();
        r1 = r1 + r4;
        a(r4, a(r3.c()));
        goto L12
    }

    private static void a(final long r2, final StackTraceElement[] r4) {
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(r4, r2));
    }

    private static StackTraceElement[] a(StackTraceElement[] r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        if (r4.length == 0) goto L21;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L13;
        if ("saveBinderInfo".equals(r4[r1].getMethodName()) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r0 = r1;
    L13:
        int r2 = r0 + 1;
        if (r2 <= r4.length) goto L16;
        return r4;
    L16:
        return (StackTraceElement[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r4, r2, r4.length), StackTraceElement[].class, "com.obric.memorydata.plugin");
    L21:
        return r4;
    }
}
