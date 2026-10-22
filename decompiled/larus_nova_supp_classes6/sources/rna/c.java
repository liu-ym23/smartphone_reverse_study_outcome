package rna;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c {
    public c() {
    }

    static {
    }

    public static void a(String r1) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r1);
        if (r0.isDirectory() == true) goto L6;
        r0.mkdirs();
        return;
    }

    public static void b(String r4) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);     // Catch: Exception -> L14
        if (r0.isDirectory() == false) goto L11;
        File[] r5 = r0.listFiles();     // Catch: Exception -> L14
        int r1 = r5.length;     // Catch: Exception -> L14
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        b(r5[r2].getPath());     // Catch: Exception -> L14
        r2 = r2 + 1;     // Catch: Exception -> L14
        goto L5
    L8:
        if (r0.delete() == true) goto L19;
        r0.getPath();     // Catch: Exception -> L14
        return;
    L19:
        return;
    L11:
        if (r0.delete() == true) goto L21;
        r0.getPath();     // Catch: Exception -> L14
        return;
    L21:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean c(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return new PolarisFileWrapper(r1).exists();
    }

    public static byte[] d(String r6) throws IOException {
        RandomAccessFile r7 = new RandomAccessFile(new PolarisFileWrapper(r6), "r");
        long r0 = r7.length();     // Catch: Throwable -> L10
        int r2 = (int) r0;     // Catch: Throwable -> L10
        if (r2 != r0) goto L9;
        byte[] r1 = new byte[r2];     // Catch: Throwable -> L10
        r7.readFully(r1);     // Catch: Throwable -> L10
        r7.close();
        return r1;
    L9:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r7.close();
        throw th;
    }

    public static ByteBuffer e(String r6) throws IOException {
        RandomAccessFile r7 = new RandomAccessFile(new PolarisFileWrapper(r6), "r");
        long r0 = r7.length();     // Catch: Throwable -> L10
        int r2 = (int) r0;     // Catch: Throwable -> L10
        if (r2 != r0) goto L9;
        byte[] r1 = new byte[r2];     // Catch: Throwable -> L10
        r7.readFully(r1);     // Catch: Throwable -> L10
        ByteBuffer r3 = ByteBuffer.allocateDirect(r2);     // Catch: Throwable -> L10
        r3.put(r1);     // Catch: Throwable -> L10
        r7.close();
        return r3;
    L9:
        throw new IOException("File size >= 2 GB");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r7.close();
        throw th;
    }
}
