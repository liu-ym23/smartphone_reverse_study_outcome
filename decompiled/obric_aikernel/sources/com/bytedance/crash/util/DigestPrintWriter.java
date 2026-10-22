package com.bytedance.crash.util;

import androidx.annotation.NonNull;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class DigestPrintWriter extends PrintWriter {
    private Charset mCharset;
    private MessageDigest mDigest;
    private IShouldDigest mShouldDigest;

    public static class IShouldDigest {
        public IShouldDigest() {
        }

        public boolean shouldDigest(String r10) {
            return true;
        }
    }

    public DigestPrintWriter(@NonNull OutputStream r10, MessageDigest r11, IShouldDigest r12) {
        super(r10);
        this.mDigest = r11;
        this.mShouldDigest = r12;
        if (r11 == null) goto L6;
        this.mCharset = Charset.defaultCharset();
        return;
    }

    public DigestPrintWriter(@NonNull Writer r10, MessageDigest r11) {
        super(r10);
        this.mDigest = r11;
        if (r11 == null) goto L6;
        this.mCharset = Charset.defaultCharset();
        return;
    }

    public static String getMd5(String r10) {
        return Digest.getMD5(r10);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int r10) {
        super.write(r10);
        MessageDigest r11 = this.mDigest;
        if (r11 == null) goto L6;
        r11.update((byte) r10);
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(@NonNull String r10, int r11, int r12) {
        super.write(r10, r11, r12);
        if (this.mDigest == null) goto L10;
        IShouldDigest r13 = this.mShouldDigest;
        if (r13 != null) goto L7;
    L8:
        this.mDigest.update(this.mCharset.encode(CharBuffer.wrap(r10, r11, r12 + r11)).array());
        return;
    L7:
        if (r13.shouldDigest(r10) == true) goto L8;
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(@NonNull char[] r10, int r11, int r12) {
        super.write(r10, r11, r12);
        MessageDigest r13 = this.mDigest;
        if (r13 == null) goto L6;
        r13.update(this.mCharset.encode(CharBuffer.wrap(r10)).array());
        return;
    }
}
