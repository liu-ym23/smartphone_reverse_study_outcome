package org.jsoup.helper;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class ValidationException extends IllegalArgumentException {
    public static final String Validator = null;

    static {
        Validator = b.class.getName();
    }

    public ValidationException(String r1) {
        super(r1);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        super.fillInStackTrace();     // Catch: Throwable -> L13
        StackTraceElement[] r0 = getStackTrace();     // Catch: Throwable -> L13
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L13
        int r2 = r0.length;     // Catch: Throwable -> L13
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L10;
        StackTraceElement r5 = r0[r4];     // Catch: Throwable -> L13
        if (r5.getClassName().equals(Validator) == true) goto L9;
        r1.add(r5);     // Catch: Throwable -> L13
    L9:
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L4
    L10:
        setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(r1.toArray(new StackTraceElement[0]), StackTraceElement[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        monitor-exit(this);
        return this;
    L13:
        th = move-exception;
        throw th;
    }
}
