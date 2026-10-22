package com.bytedance.crash.dumper.tools;

import androidx.annotation.Nullable;
import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: loaded from: classes.dex */
class NativeStringDumperImpl implements IStringDumperImpl {
    final long mNativePointer;

    NativeStringDumperImpl(long r10) {
        this.mNativePointer = r10;
    }

    @Nullable
    static NativeStringDumperImpl create(String r10, int r11) {
        long r12 = NativeBridge.stringDumperCreate(r10, r11);
        if (r12 != 0) goto L5;
        return null;
    L5:
        return new NativeStringDumperImpl(r12);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpByteArray(byte[] r10, int r11) {
        NativeBridge.stringDumperDumpByteArray(this.mNativePointer, r10, r11);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpCharArray(char[] r10, int r11) {
        NativeBridge.stringDumperDumpCharArray(this.mNativePointer, r10, r11);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpInt(int r10) {
        dumpString(Integer.toString(r10));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpLong(long r10) {
        dumpString(Long.toString(r10));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpString(String r10) {
        NativeBridge.stringDumperDumpString(this.mNativePointer, r10, r10.length());
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
