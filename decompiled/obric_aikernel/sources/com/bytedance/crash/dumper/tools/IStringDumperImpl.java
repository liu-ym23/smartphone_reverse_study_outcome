package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes.dex */
interface IStringDumperImpl {
    void dumpByteArray(byte[] r10, int r11);

    void dumpCharArray(char[] r10, int r11);

    void dumpInt(int r10);

    void dumpLong(long r10);

    void dumpString(String r10);

    void flush();

    void release();
}
