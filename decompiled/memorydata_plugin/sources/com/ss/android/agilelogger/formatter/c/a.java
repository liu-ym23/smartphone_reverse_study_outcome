package com.ss.android.agilelogger.formatter.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.agilelogger.formatter.a
    public /* synthetic */ String a(Object r3) {
        return a((StackTraceElement[]) ZeusTransformUtils.preCheckCast(r3, StackTraceElement[].class, "com.obric.memorydata.plugin"));
    }

    public String a(StackTraceElement[] r5) {
        StringBuilder r4 = new StringBuilder(256);
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length == 0) goto L28;
        int r1 = 0;
        if (r5.length == 1) goto L10;
        int r0 = r5.length;
    L12:
        if (r1 >= r0) goto L22;
        String r2 = "\n";
        if (r1 != 0) goto L17;
        r4.append("\n");
    L17:
        if (r1 == (r0 - 1)) goto L19;
        r4.append("\t├ ");
        r4.append(r5[r1].toString());
    L20:
        r4.append(r2);
        r1 = r1 + 1;
        goto L12
    L19:
        r4.append("\t└ ");
        r2 = r5[r1].toString();
        goto L20
    L22:
        return r4.toString();
    L10:
        return "\t─ " + r5[0].toString();
    L28:
        return null;
    }
}
