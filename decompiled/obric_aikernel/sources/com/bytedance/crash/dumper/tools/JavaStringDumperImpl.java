package com.bytedance.crash.dumper.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class JavaStringDumperImpl implements IStringDumperImpl {
    private final FileOutputStream mFileOutputStream;

    private JavaStringDumperImpl(String r10) {
        FileOutputStream r11 = new FileOutputStream(new File(r10));     // Catch: IOException -> L5
    L6:
        this.mFileOutputStream = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static JavaStringDumperImpl create(String r10) {
        return new JavaStringDumperImpl(r10);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpByteArray(byte[] r10, int r11) {
        FileOutputStream r12 = this.mFileOutputStream;
        if (r12 == null) goto L9;
        r12.write(r10);     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpCharArray(char[] r10, int r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        dumpString(r12.toString());
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
        FileOutputStream r11 = this.mFileOutputStream;
        if (r11 == null) goto L9;
        r11.write(r10.getBytes());     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void flush() {
        FileOutputStream r10 = this.mFileOutputStream;
        if (r10 == null) goto L9;
        r10.flush();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void release() {
        FileOutputStream r10 = this.mFileOutputStream;
        if (r10 == null) goto L9;
        r10.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }
}
