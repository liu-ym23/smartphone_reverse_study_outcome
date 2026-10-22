package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes2.dex */
interface IStringDumperImpl {
    void dumpByteArray(byte[] r1, int r2);

    void dumpCharArray(char[] r1, int r2);

    void dumpInt(int r1);

    void dumpLong(long r1);

    void dumpString(String r1);

    void flush();

    void release();
}
