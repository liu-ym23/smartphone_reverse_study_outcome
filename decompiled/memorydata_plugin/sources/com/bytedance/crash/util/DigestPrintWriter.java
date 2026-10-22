package com.bytedance.crash.util;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class DigestPrintWriter extends PrintWriter {
    private Charset mCharset;
    private MessageDigest mDigest;
    private IShouldDigest mShouldDigest;

    public static class IShouldDigest {
        public IShouldDigest() {
        }

        public boolean shouldDigest(String r1) {
            return true;
        }
    }

    public DigestPrintWriter(OutputStream r1, MessageDigest r2, IShouldDigest r3) {
        super(r1);
        this.mDigest = r2;
        this.mShouldDigest = r3;
        if (r2 == null) goto L6;
        this.mCharset = Charset.defaultCharset();
        return;
    }

    public DigestPrintWriter(Writer r1, MessageDigest r2) {
        super(r1);
        this.mDigest = r2;
        if (r2 == null) goto L6;
        this.mCharset = Charset.defaultCharset();
        return;
    }

    public static String getMd5(String r0) {
        return Digest.getMD5(r0);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int r1) {
        super.write(r1);
        MessageDigest r0 = this.mDigest;
        if (r0 == null) goto L6;
        r0.update((byte) r1);
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String r2, int r3, int r4) {
        super.write(r2, r3, r4);
        if (this.mDigest == null) goto L10;
        IShouldDigest r0 = this.mShouldDigest;
        if (r0 != null) goto L7;
    L8:
        this.mDigest.update(this.mCharset.encode(CharBuffer.wrap(r2, r3, r4 + r3)).array());
        return;
    L7:
        if (r0.shouldDigest(r2) == true) goto L8;
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] r1, int r2, int r3) {
        super.write(r1, r2, r3);
        MessageDigest r4 = this.mDigest;
        if (r4 == null) goto L6;
        r4.update(this.mCharset.encode(CharBuffer.wrap(r1)).array());
        return;
    }
}
