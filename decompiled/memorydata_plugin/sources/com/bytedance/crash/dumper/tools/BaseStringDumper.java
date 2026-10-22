package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseStringDumper {
    IStringDumperImpl mDumpImpl;

    BaseStringDumper() {
    }

    abstract void append(char r1);

    abstract void append(int r1);

    abstract void append(long r1);

    abstract void append(String r1);

    abstract void append(byte[] r1);

    abstract void append(char[] r1);

    IStringDumperImpl createImpl(String r1, int r2) {
        NativeStringDumperImpl r0 = NativeStringDumperImpl.create(r1, r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return JavaStringDumperImpl.create(r1);
    }

    abstract void flush();

    abstract void release();
}
