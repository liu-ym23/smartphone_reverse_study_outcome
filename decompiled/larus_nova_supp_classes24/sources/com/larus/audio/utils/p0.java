package com.larus.audio.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p0 {
    static {
        BigInteger r0 = BigInteger.valueOf(1024);
        r0.multiply(r0.multiply(r0.multiply(r0.multiply(r0.multiply(r0)))));
        Charset.forName("UTF-8");
        char r1 = File.separatorChar;
    }

    public static void a(PolarisFileWrapper r14, PolarisFileWrapper r15) throws IOException {
        if (r14 == null) goto L72;
        if (r15 == null) goto L70;
        if (r14.exists() == false) goto L68;
        if (r14.isDirectory() == true) goto L66;
        if (Intrinsics.areEqual(r14.getCanonicalPath(), r15.getCanonicalPath()) == true) goto L64;
        File r0 = r15.getParentFile();
        if (r0 == null) goto L20;
        if (r0.mkdirs() == true) goto L20;
        if (r0.isDirectory() == true) goto L20;
        throw new IOException("Destination '" + r0 + "' directory cannot be created");
    L20:
        if (r15.exists() == false) goto L27;
        if (r15.canWrite() == true) goto L27;
        throw new IOException("Destination '" + r15 + "' exists but is read-only");
    L27:
        if (r15.exists() == true) goto L29;
    L33:
        FileChannel r1 = null;
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r14);     // Catch: Throwable -> L58
        PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r15);     // Catch: Throwable -> L56
        FileChannel r9 = r2.getChannel();     // Catch: Throwable -> L54
        r1 = r3.getChannel();     // Catch: Throwable -> L52
        long r10 = r9.size();     // Catch: Throwable -> L52
        long r12 = 0;
    L39:
        if (r12 >= r10) goto L46;
        long r4 = r10 - r12;     // Catch: Throwable -> L52
        if (r4 <= 31457280) goto L43;
        long r7 = 31457280;
    L44:
        r12 = r12 + r1.transferFrom(r9, r12, r7);
        goto L39
    L43:
        r7 = r4;
        goto L44
    L46:
        k0.a(r1);
        k0.a(r3);
        k0.a(r9);
        k0.a(r2);
        if (r14.length() != r15.length()) goto L51;
        r15.setLastModified(r14.lastModified());
        return;
    L51:
        throw new IOException("Failed to copy full contents from '" + r14 + "' to '" + r15 + '\'');
    L52:
        th = th;
    L61:
        k0.a(r1);
        k0.a(r3);
        k0.a(r9);
        k0.a(r2);
        throw th;
    L54:
        th = th;
        r9 = null;
    L56:
        th = th;
    L60:
        r3 = null;
        r9 = null;
    L58:
        th = th;
        r2 = null;
        goto L60
    L29:
        if (r15.isDirectory() == false) goto L33;
        throw new IOException("Destination '" + r15 + "' exists but is a directory");
    L64:
        throw new IOException("Source '" + r14 + "' and destination '" + r15 + "' are the same");
    L66:
        throw new IOException("Source '" + r14 + "' exists but is a directory");
    L68:
        throw new FileNotFoundException("Source '" + r14 + "' does not exist");
    L70:
        throw new NullPointerException("Destination must not be null");
    L72:
        throw new NullPointerException("Source must not be null");
    }

    @JvmStatic
    public static final void b(File r4, boolean r5) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "dir");
        File[] r0 = r4.listFiles();
        if (r0 != null) goto L8;
        if (r5 == false) goto L7;
        return;
    L7:
        throw new IOException("not a readable directory: " + r4);
    L8:
        int r6 = r0.length;
        int r1 = 0;
    L9:
        if (r1 >= r6) goto L20;
        File r2 = r0[r1];
        if (r2.isDirectory() == false) goto L14;
        Intrinsics.checkNotNull(r2);
        b(r2, r5);
    L14:
        if (r2.delete() == true) goto L19;
        if (r5 == true) goto L19;
        throw new IOException("failed to delete file: " + r2);
    L19:
        r1 = r1 + 1;
        goto L9
    }

    @JvmStatic
    public static final boolean c(PolarisFileWrapper r4, PolarisFileWrapper r5) {
        Intrinsics.checkNotNullParameter(r4, "src");
        Intrinsics.checkNotNullParameter(r5, "dest");
        if (r4.renameTo(r5) == false) goto L14;
        return true;
    L14:
        a(r4, r5);     // Catch: Exception -> L11
        r4.delete();     // Catch: Exception -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        int r6 = c68.b.a;     // Catch: Exception -> L11
        c68.b.b("FileUtil", "renameTo delete error " + e);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        int r7 = c68.b.a;
        c68.b.b("FileUtil", "renameTo error " + e);
        return false;
    }
}
