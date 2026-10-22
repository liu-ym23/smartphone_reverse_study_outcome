package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class m implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f393b = false;

    static {
        f392a = new m();
        f393b = Boolean.getBoolean("com.alibaba.excel.support.cglib.test.stressHashCodes");
    }

    public m() {
    }

    public String a() {
        return "ByCGLIB";
    }

    @Override // com.alibaba.excel.support.cglib.core.z
    public String a(String r3, String r4, Object r5, ab r6) {
        ab r7 = (ab) ZeusTransformUtils.wrapperContextForParams(r6, ab.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        r3 = "com.alibaba.excel.support.cglib.empty.Object";
    L8:
        StringBuilder r2 = new StringBuilder().append(r3).append("$$").append(r4.substring(r4.lastIndexOf(46) + 1)).append(a()).append("$$");
        if (f393b == false) goto L11;
        int r8 = 0;
    L12:
        String r9 = r2.append(Integer.toHexString(r8)).toString();
        int r10 = 2;
        String r11 = r9;
    L14:
        if (r7.a(r11) == false) goto L16;
        r11 = r9 + "_" + r10;
        r10 = r10 + 1;
        goto L14
    L16:
        return r11;
    L11:
        r8 = r5.hashCode();
        goto L12
    L6:
        if (r3.startsWith("java") == false) goto L8;
        r3 = "$" + r3;
        goto L8
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, m.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.memorydata.plugin")).a().equals(a()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return a().hashCode();
    }
}
