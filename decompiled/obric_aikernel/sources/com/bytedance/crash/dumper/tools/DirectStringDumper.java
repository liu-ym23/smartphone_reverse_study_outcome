package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes.dex */
class DirectStringDumper extends BaseStringDumper {
    DirectStringDumper(String r10) {
        this.mDumpImpl = createImpl(r10, 0);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char r10) {
        this.mDumpImpl.dumpString(String.valueOf(r10));
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(int r10) {
        this.mDumpImpl.dumpInt(r10);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(long r10) {
        this.mDumpImpl.dumpLong(r10);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(String r10) {
        this.mDumpImpl.dumpString(r10);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(byte[] r10) {
        this.mDumpImpl.dumpByteArray(r10, r10.length);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    void append(char[] r10) {
        this.mDumpImpl.dumpCharArray(r10, r10.length);
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
