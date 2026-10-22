package com.bytedance.crash.dumper.tools;

import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: loaded from: classes2.dex */
class NativeStringDumperImpl implements IStringDumperImpl {
    final long mNativePointer;

    NativeStringDumperImpl(long r1) {
        this.mNativePointer = r1;
    }

    static NativeStringDumperImpl create(String r2, int r3) {
        long r4 = NativeBridge.stringDumperCreate(r2, r3);
        if (r4 != 0) goto L5;
        return null;
    L5:
        return new NativeStringDumperImpl(r4);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpByteArray(byte[] r3, int r4) {
        NativeBridge.stringDumperDumpByteArray(this.mNativePointer, r3, r4);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpCharArray(char[] r3, int r4) {
        NativeBridge.stringDumperDumpCharArray(this.mNativePointer, r3, r4);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpInt(int r1) {
        dumpString(Integer.toString(r1));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpLong(long r1) {
        dumpString(Long.toString(r1));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpString(String r3) {
        NativeBridge.stringDumperDumpString(this.mNativePointer, r3, r3.length());
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void flush() {
        NativeBridge.stringDumperFlushBuffer(this.mNativePointer);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void release() {
        NativeBridge.stringDumperRelease(this.mNativePointer);
    }
}
