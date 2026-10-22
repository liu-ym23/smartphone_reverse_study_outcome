package com.alibaba.excel.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class o {
    public static boolean a(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        return false;
    }

    public static boolean b(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        int r1 = r6.length();
        if (r1 == 0) goto L13;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L13;
        if (Character.isWhitespace(r6.charAt(r3)) == false) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    public static boolean c(CharSequence r2) {
        return !b((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
