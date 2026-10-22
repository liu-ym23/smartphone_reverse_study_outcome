package com.bytedance.geckox.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000bJ\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000bJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0007J\"\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/geckox/utils/MD5Utils;", "", "()V", "HEX_CHARS", "", "check", "", "file", "Ljava/io/File;", "md5", "", "check$geckox_noasanRelease", "inputStream", "Ljava/io/InputStream;", "getHash", "hashType", "inStream", "getMD5", "getMD5$geckox_noasanRelease", "stringToMd5", "str", "toHexString", "bytes", "", "off", "", "len", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class MD5Utils {
    private static final char[] HEX_CHARS = null;
    public static final MD5Utils INSTANCE = null;

    static {
        INSTANCE = new MD5Utils();
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private MD5Utils() {
    }

    private final String getHash(File r5, String r10) {
        FileInputStream r11 = null;
        FileInputStream r12 = new FileInputStream(r5);     // Catch: Throwable -> L9
        String r13 = getHash(r12, r10);     // Catch: Throwable -> L7
        d.c(r12);
        return r13;
    L7:
        th = th;
        r11 = r12;
    L10:
        d.c(r11);
        throw th;
    L9:
        th = th;
        goto L10
    }

    @JvmStatic
    public static final String stringToMd5(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return "";
    L6:
        MessageDigest r10 = MessageDigest.getInstance("MD5");
        r10.update(r5.getBytes(Charsets.UTF_8));
        byte[] r11 = r10.digest();
        return INSTANCE.toHexString(r11, 0, r11.length);
    }

    private final String toHexString(byte[] r10, int r11, int r12) {
        if (r10 == null) goto L14;
        if (r11 < 0) goto L12;
        if ((r11 + r12) > r10.length) goto L12;
        int r13 = r12 * 2;
        char[] r5 = new char[r13];
        int r14 = 0;
        int r15 = 0;
    L7:
        if (r14 >= r12) goto L10;
        byte r16 = r10[r14 + r11];
        int r17 = r16 & UByte.MAX_VALUE;
        int r18 = r15 + 1;
        char[] r19 = HEX_CHARS;
        r5[r15] = r19[r17 >> 4];
        r15 = r15 + 2;
        r5[r18] = r19[r16 & 15];
        r14 = r14 + 1;
        goto L7
    L10:
        return new String(r5, 0, r13);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }

    public final void check$geckox_noasanRelease(InputStream r5, String r10) {
        if (r10 == null) goto L9;
        String r11 = getMD5(r5);
        if (Intrinsics.areEqual(r11, r10) == false) goto L7;
        return;
    L7:
        throw new RuntimeException(com.lynx.tasm.utils.b.j("md5 check failed file: local md5:", r11, " expect md5:", r10));
    L9:
        throw new RuntimeException("md5 check failed: md5 == null");
    }

    public final String getMD5(InputStream r5) {
        return getHash(r5, "MD5");
    }

    public final String getMD5$geckox_noasanRelease(File r5) {
        return getHash(r5, "MD5");
    }

    private final String getHash(InputStream r5, String r10) {
        byte[] r11 = new byte[8192];
        MessageDigest r12 = MessageDigest.getInstance(r10);     // Catch: Throwable -> L7 Exception -> L9
    L4:
        int r13 = r5.read(r11);     // Catch: Throwable -> L7 Exception -> L9
        if (r13 == (-1)) goto L11;
        r12.update(r11, 0, r13);     // Catch: Throwable -> L7 Exception -> L9
        goto L4
    L11:
        byte[] r14 = r12.digest();     // Catch: Throwable -> L7 Exception -> L9
        String r15 = toHexString(r14, 0, r14.length);     // Catch: Throwable -> L7 Exception -> L9
        d.c(r5);
        return r15;
    L7:
        th = move-exception;
        d.c(r5);
        throw th;
    L9:
        e = move-exception;
        throw new RuntimeException("getHash error: " + e.getMessage());     // Catch: Throwable -> L7
    }

    public final void check$geckox_noasanRelease(File r5, String r10) {
        if (r5.isFile() == false) goto L11;
        if (r10 == null) goto L11;
        String r11 = getMD5$geckox_noasanRelease(r5);
        if (Intrinsics.areEqual(r11, r10) == false) goto L9;
        return;
    L9:
        throw new RuntimeException("md5 check failed file:" + r5.getPath() + ", local md5:" + r11 + ", expect md5:" + r10);
    L11:
        throw new RuntimeException("md5 check failed: file.isFile() == false || md5 == null");
    }
}
