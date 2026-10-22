package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes.dex */
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

    StackBuilder(StringDumper r10) {
        this.mStringDumper = r10;
    }

    StackBuilder append(char r10) {
        this.mStringDumper.append(r10);
        return this;
    }

    StackBuilder append(int r10) {
        this.mStringDumper.append(r10);
        return this;
    }

    StackBuilder append(StackTraceElement r10) {
        String r11 = r10.getClassName();
        String r12 = r10.getMethodName();
        String r13 = r10.getFileName();
        int r14 = r10.getLineNumber();
        boolean r15 = r10.isNativeMethod();
        append(r11).append('.').append(r12);
        if (r15 == false) goto L6;
        append(NATIVE_METHOD);
    L16:
        return this;
    L6:
        if (r13 != null) goto L8;
        if (r14 < 0) goto L15;
        StackBuilder r16 = append(UNKOWN_SOURCE_COLON);
    L13:
        StackBuilder r17 = r16.append(r14);
    L14:
        r17.append(')');
        goto L16
    L15:
        append(UNKOWN_SOURCE);
        goto L16
    L8:
        if (r10.getLineNumber() < 0) goto L10;
        r16 = append('(').append(r13).append(':');
        goto L13
    L10:
        r17 = append('(').append(r13);
        goto L14
    }

    StackBuilder append(String r10) {
        if (r10.length() == 0) goto L5;
        this.mStringDumper.append(r10);
    L5:
        return this;
    }

    StackBuilder append(Throwable r10) {
        this.mStringDumper.append(r10);
        return this;
    }

    StackBuilder append(char[] r10) {
        if (r10.length == 0) goto L5;
        this.mStringDumper.append(r10);
    L5:
        return this;
    }

    StackBuilder appendTabs(int r10) {
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mStringDumper.append('\t');
        r11 = r11 + 1;
        goto L3
    L5:
        return this;
    }
}
