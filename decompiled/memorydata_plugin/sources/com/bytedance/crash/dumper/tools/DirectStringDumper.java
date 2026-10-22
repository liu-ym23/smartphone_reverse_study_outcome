package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes2.dex */
class DirectStringDumper extends BaseStringDumper {
    DirectStringDumper(String r2) {
        this.mDumpImpl = createImpl(r2, 0);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char r1) {
        this.mDumpImpl.dumpString(String.valueOf(r1));
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(int r1) {
        this.mDumpImpl.dumpInt(r1);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(long r1) {
        this.mDumpImpl.dumpLong(r1);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(String r1) {
        this.mDumpImpl.dumpString(r1);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(byte[] r2) {
        this.mDumpImpl.dumpByteArray(r2, r2.length);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char[] r2) {
        this.mDumpImpl.dumpCharArray(r2, r2.length);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void flush() {
        this.mDumpImpl.flush();
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void release() {
        this.mDumpImpl.release();
    }
}
