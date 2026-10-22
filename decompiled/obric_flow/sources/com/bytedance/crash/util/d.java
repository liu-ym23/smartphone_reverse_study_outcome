package com.bytedance.crash.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends PrintWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageDigest f4175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f4176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wc.f f4177c;

    public d(PrintStream r5, MessageDigest r10, wc.f r11) {
        super(r5);
        this.f4175a = r10;
        this.f4177c = r11;
        if (r10 == null) goto L6;
        this.f4176b = Charset.defaultCharset();
        return;
    }

    public static String b(String r5) {
        MessageDigest r10 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L6
        r10.update(r5.getBytes());     // Catch: Throwable -> L6
        return h.b(r10.digest());
    L6:
        return null;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(char[] r5, int r10, int r11) {
        super.write(r5, r10, r11);
        MessageDigest r12 = this.f4175a;
        if (r12 == null) goto L6;
        r12.update(this.f4176b.encode(CharBuffer.wrap(r5)).array());
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(int r5) {
        super.write(r5);
        MessageDigest r10 = this.f4175a;
        if (r10 == null) goto L6;
        r10.update((byte) r5);
        return;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(String r5, int r10, int r11) {
        super.write(r5, r10, r11);
        MessageDigest r12 = this.f4175a;
        if (r12 == null) goto L10;
        wc.f r13 = this.f4177c;
        if (r13 != null) goto L7;
    L8:
        CharBuffer r14 = CharBuffer.wrap(r5, r10, r11 + r10);
        r12.update(this.f4176b.encode(r14).array());
        return;
    L7:
        if (r13.f(r5) == true) goto L8;
        return;
    }
}
