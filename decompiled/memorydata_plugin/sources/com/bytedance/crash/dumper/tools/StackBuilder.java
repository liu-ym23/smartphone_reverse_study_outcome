package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes2.dex */
public class StackBuilder {
    private static final char[] NATIVE_METHOD = null;
    private static final char[] UNKOWN_SOURCE = null;
    private static final char[] UNKOWN_SOURCE_COLON = null;
    private final StringDumper mStringDumper;

    static {
        NATIVE_METHOD = new char[]{'(', 'N', 'a', 't', 'i', 'v', 'e', ' ', 'M', 'e', 't', 'h', 'o', 'd', ')'};
        UNKOWN_SOURCE = new char[]{'(', 'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'S', 'o', 'u', 'r', 'c', 'e', ')'};
        UNKOWN_SOURCE_COLON = new char[]{'(', 'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'S', 'o', 'u', 'r', 'c', 'e', ':'};
    }

    StackBuilder(StringDumper r1) {
        this.mStringDumper = r1;
    }

    StackBuilder append(char r2) {
        this.mStringDumper.append(r2);
        return this;
    }

    StackBuilder append(int r2) {
        this.mStringDumper.append(r2);
        return this;
    }

    StackBuilder append(StackTraceElement r7) {
        String r0 = r7.getClassName();
        String r1 = r7.getMethodName();
        String r2 = r7.getFileName();
        int r3 = r7.getLineNumber();
        boolean r4 = r7.isNativeMethod();
        append(r0).append('.').append(r1);
        if (r4 == false) goto L6;
        append(NATIVE_METHOD);
    L16:
        return this;
    L6:
        if (r2 != null) goto L8;
        if (r3 < 0) goto L15;
        StackBuilder r8 = append(UNKOWN_SOURCE_COLON);
    L13:
        StackBuilder r9 = r8.append(r3);
    L14:
        r9.append(')');
        goto L16
    L15:
        append(UNKOWN_SOURCE);
        goto L16
    L8:
        if (r7.getLineNumber() < 0) goto L10;
        r8 = append('(').append(r2).append(':');
        goto L13
    L10:
        r9 = append('(').append(r2);
        goto L14
    }

    StackBuilder append(String r2) {
        if (r2.length() == 0) goto L5;
        this.mStringDumper.append(r2);
    L5:
        return this;
    }

    StackBuilder append(Throwable r2) {
        this.mStringDumper.append(r2);
        return this;
    }

    StackBuilder append(char[] r2) {
        if (r2.length == 0) goto L5;
        this.mStringDumper.append(r2);
    L5:
        return this;
    }

    StackBuilder appendTabs(int r4) {
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.mStringDumper.append('\t');
        r0 = r0 + 1;
        goto L3
    L5:
        return this;
    }
}
