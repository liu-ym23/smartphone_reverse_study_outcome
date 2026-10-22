package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public class g {
    public static Throwable a(Object[] r2) {
        if (r2 != null) goto L5;
    L11:
        return null;
    L5:
        if (r2.length == 0) goto L11;
        Object r3 = r2[r2.length - 1];
        if (ZeusTransformUtils.instanceOf(r3, Throwable.class) == false) goto L11;
        return (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin");
    }

    public static Object[] b(Object[] r3) {
        if (r3 == null) goto L10;
        if (r3.length == 0) goto L10;
        int r0 = r3.length - 1;
        Object[] r1 = new Object[r0];
        if (r0 <= 0) goto L8;
        System.arraycopy(r3, 0, r1, 0, r0);
    L8:
        return r1;
    L10:
        throw new IllegalStateException("non-sensical empty or null argument array");
    }
}
