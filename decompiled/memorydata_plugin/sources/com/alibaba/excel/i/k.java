package com.alibaba.excel.i;

import com.alibaba.excel.metadata.format.DataFormatter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<DataFormatter> f216a = null;

    static {
        f216a = new ThreadLocal();
    }

    public static String a(BigDecimal r6, Short r7, String r8, com.alibaba.excel.metadata.j r9) {
        if (r9 != null) goto L6;
        Boolean r3 = null;
        Locale r4 = null;
        Boolean r5 = null;
    L5:
        return a(r6, r7, r8, r3, r4, r5);
    L6:
        r3 = r9.b();
        r4 = r9.c();
        r5 = r9.d();
        goto L5
    }

    public static String a(BigDecimal r4, Short r5, String r6, Boolean r7, Locale r8, Boolean r9) {
        ThreadLocal<DataFormatter> r0 = f216a;
        DataFormatter r1 = (DataFormatter) ZeusTransformUtils.preCheckCast(r0.get(), DataFormatter.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        r1 = new DataFormatter(r7, r8, r9);
        r0.set(r1);
    L6:
        return r1.a(r4, r5, r6);
    }

    public static void a() {
        f216a.remove();
    }
}
