package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseStringDumper {
    IStringDumperImpl mDumpImpl;

    BaseStringDumper() {
    }

    abstract void append(char r10);

    abstract void append(int r10);

    abstract void append(long r10);

    abstract void append(String r10);

    abstract void append(byte[] r10);

    abstract void append(char[] r10);

    IStringDumperImpl createImpl(String r10, int r11) {
        NativeStringDumperImpl r12 = NativeStringDumperImpl.create(r10, r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        return JavaStringDumperImpl.create(r10);
    }

    abstract void flush();

    abstract void release();
}
