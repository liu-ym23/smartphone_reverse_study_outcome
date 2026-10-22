package com.bytedance.crash.dumper.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class JavaStringDumperImpl implements IStringDumperImpl {
    private final FileOutputStream mFileOutputStream;

    private JavaStringDumperImpl(String r3) {
        FileOutputStream r0 = new FileOutputStream(new File(r3));     // Catch: IOException -> L5
    L6:
        this.mFileOutputStream = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static JavaStringDumperImpl create(String r1) {
        return new JavaStringDumperImpl(r1);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpByteArray(byte[] r1, int r2) {
        FileOutputStream r0 = this.mFileOutputStream;
        if (r0 == null) goto L9;
        r0.write(r1);     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpCharArray(char[] r1, int r2) {
        dumpString(new StringBuilder().append(r1).toString());
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
    public void dumpString(String r1) {
        FileOutputStream r0 = this.mFileOutputStream;
        if (r0 == null) goto L9;
        r0.write(r1.getBytes());     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void flush() {
        FileOutputStream r0 = this.mFileOutputStream;
        if (r0 == null) goto L9;
        r0.flush();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void release() {
        FileOutputStream r0 = this.mFileOutputStream;
        if (r0 == null) goto L9;
        r0.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }
}
