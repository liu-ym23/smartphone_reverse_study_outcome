package com.bytedance.apm.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class s {
    public static String a(Throwable r7, int r8) {
        StackTraceElement[] r9 = r7.getStackTrace();
        StringBuilder r0 = new StringBuilder();
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L9;
        StackTraceElement r4 = r9[r2];
        r3 = r3 + 1;
        r0.append("\tat " + r4.getClassName());
        r0.append(".");
        r0.append(r4.getMethodName());
        r0.append("(");
        r0.append(r4.getFileName());
        r0.append(":");
        r0.append(r4.getLineNumber());
        r0.append(")\n");
        if (r3 > r8) goto L9;
        r2 = r2 + 1;
    L9:
        return r0.toString();
    }
}
