package swb;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
        new HashSet(Arrays.asList(new String[]{".tar.gz", ".tar.xz", ".tar.bz2"}));
    }

    public static void b(VFSPath r4) throws IOException {
        if (r4.toFile().exists() == false) goto L23;
        if (r4.toFile().isDirectory() == false) goto L21;
        VFSFile[] r0 = r4.toFile().listFiles();
        if (r0 == null) goto L19;
        int r5 = r0.length;
        IOException e = null;
        int r2 = 0;
    L9:
        if (r2 >= r5) goto L15;
        h(r0[r2].getVfsPath());     // Catch: IOException -> L13
    L14:
        r2 = r2 + 1;
    L13:
        e = e;
        goto L14
    L15:
        if (e != null) goto L17;
        return;
    L17:
        throw e;
    L19:
        throw new IOException("Failed to list contents of " + r4.getRealPath());
    L21:
        throw new IllegalArgumentException(r4.getRealPath() + " is not a directory");
    L23:
        throw new IllegalArgumentException(r4.getRealPath() + " does not exist");
    }

    public static void c(Closeable... r4) {
        if (r4.length <= 0) goto L15;
        int r0 = r4.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L22;
        Closeable r2 = r4[r1];
        if (r2 == null) goto L14;
        r2.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", th.toString());
    L14:
        r1 = r1 + 1;
        goto L6
    L22:
        return;
    }

    public static void f(VFSPath r2) throws IOException {
        if (r2.toFile().exists() == true) goto L5;
        return;
    L5:
        b(r2);
        if (r2.toFile().delete() == false) goto L9;
        return;
    L9:
        throw new IOException("Unable to delete directory " + r2.getRealPath() + ".");
    }

    public static void g(VFSPath r1) throws IOException {
        if (r1.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r1.toFile().isDirectory() == false) goto L9;
        f(r1);
        return;
    L9:
        if (r1.toFile().isFile() == false) goto L13;
        h(r1);
        return;
    }

    public static void h(VFSPath r3) throws IOException {
        if (r3.toFile().exists() == true) goto L6;
        return;
    L6:
        if (r3.toFile().isDirectory() == false) goto L8;
        f(r3);
        return;
    L8:
        boolean r0 = r3.toFile().exists();
        if (r3.toFile().delete() == true) goto L16;
        if (r0 == true) goto L14;
        throw new FileNotFoundException("File does not exist: " + r3.getRealPath());
    L14:
        throw new IOException("Unable to delete file: " + r3.getRealPath());
    }

    public static String i(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return "*/*";
    L6:
        if (r3.lastIndexOf(".") <= 0) goto L8;
        String r4 = r3.substring(r3.lastIndexOf(".") + 1, r3.length()).toLowerCase();
    L9:
        String r5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r4);
        if (r5 != null) goto L13;
        r5 = "*/*";
    L13:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return "*/*";
    L16:
        return r5;
    L8:
        r4 = "";
        goto L9
    }

    public static void a(VFSPath r2, VFSPath r3) throws FileNotFoundException {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r2.toFile().exists() == false) goto L8;
        return;
    L8:
        throw new FileNotFoundException("Source '" + r2.getRealPath() + "' does not exist");
    L10:
        throw new NullPointerException("Destination must not be null");
    L12:
        throw new NullPointerException("Source must not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(VFSPath r34, VFSPath r35) throws IOException {
        a(r34, r35);
        if (r34.toFile().isDirectory() == false) goto L115;
        if (r34.toFile().getCanonicalPath().equals(r35.toFile().getCanonicalPath()) == true) goto L113;
        String r4 = "' exists but is read-only";
        String r5 = "Destination '";
        if (r35.toFile().exists() == true) goto L9;
    L13:
        String[] r6 = r34.toFile().list();
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.length <= 0) goto L140;
        int r7 = r6.length;
        int r9 = 0;
    L18:
        if (r9 >= r7) goto L141;
        String r0 = r6[r9];
        VFSPath r11 = r34.subPath(r0);
        VFSPath r13 = r35.subPath(r0);
        if (r11.toFile().isDirectory() == false) goto L22;
        r13.toFile().mkdirs();
        e(r11, r13);
        String r20 = r4;
        r5 = r5;
        r6 = r6;
        r7 = r7;
    L94:
        r9 = r9 + 1;
        r4 = r20;
        r5 = r5;
        r6 = r6;
        r7 = r7;
        goto L18
    L22:
        a(r11, r13);
        if (r11.toFile().isDirectory() == true) goto L110;
        if (r11.toFile().getCanonicalPath().equals(r13.toFile().getCanonicalPath()) == true) goto L108;
        File r1 = r13.toFile().getParentFile();
        if (r1 == null) goto L36;
        if (r1.mkdirs() == true) goto L36;
        if (r1.isDirectory() == true) goto L36;
        throw new IOException(r5 + r1 + "' directory cannot be created");
    L36:
        if (r13.toFile().exists() == true) goto L38;
    L42:
        VFSFile r15 = r11.toFile();
        VFSFile r8 = r13.toFile();
        if (r8.exists() == true) goto L45;
    L49:
        FileChannel r18 = null;
        PolarisFileInputStreamWrapper r14 = new PolarisFileInputStreamWrapper(r15);     // Catch: Throwable -> L80 IOException -> L84
        r20 = r4;
        PolarisFileOutputStreamWrapper r10 = new PolarisFileOutputStreamWrapper(r8);     // Catch: Throwable -> L75 IOException -> L77
    L125:
        FileChannel r27 = r14.getChannel();     // Catch: Throwable -> L71 IOException -> L73
        r18 = r10.getChannel();     // Catch: Throwable -> L67 IOException -> L69
        long r28 = r27.size();     // Catch: Throwable -> L67 IOException -> L69
        long r32 = 0;
    L56:
        if (r32 >= r28) goto L66;
        long r21 = r28 - r32;     // Catch: Throwable -> L67 IOException -> L69
        if (r21 <= 31457280) goto L60;
        long r25 = 31457280;
    L61:
        long r22 = r18.transferFrom(r27, r32, r25);     // Catch: Throwable -> L67 IOException -> L69
    L63:
        if (r22 == 0) goto L66;
        r32 = r32 + r22;
        goto L56
    L60:
        r25 = r21;
    L66:
        r5 = r5;
        c(new Closeable[]{r18, r10, r27, r14});
        r6 = r6;
        boolean r16 = true;
    L90:
        long r12 = r15.length();
        long r17 = r8.length();
        if (r12 != r17) goto L98;
        r8.setLastModified(r15.lastModified());
        if (r16 == true) goto L94;
        throw new IOException("copyFile Error " + r11.getRealPath() + " " + r13.getRealPath());
    L98:
        throw new IOException("Failed to copy full contents from '" + r15 + "' to '" + r8 + "' Expected length: " + r12 + " Actual: " + r17);
    L69:
        e = e;
        r5 = r5;
        PolarisFileOutputStreamWrapper r19 = r10;
        FileChannel r23 = r18;
        r18 = r27;
    L116:
    L102:
        e = move-exception;
        throw e;     // Catch: Throwable -> L100
    L100:
        th = th;
        r27 = r18;
        int r2 = 4;
        r18 = r23;
        r10 = r19;
    L105:
        Closeable[] r3 = new Closeable[r2];
        r3[0] = r18;
        r3[1] = r10;
        r3[2] = r27;
        r3[3] = r14;
        c(r3);
        throw th;
    L87:
        if (Build.VERSION.SDK_INT < 26) goto L99;
        com.ss.android.lark.officesdk.utils.di.j.e("FileUtil", "Use Files copy method");     // Catch: Throwable -> L100 IOException -> L102
        Files.copy(r15.toPath(), r8.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});     // Catch: Throwable -> L100 IOException -> L102
        c(new Closeable[]{r23, r19, r18, r14});
        r16 = false;
        goto L90
    L99:
        throw e;     // Catch: Throwable -> L100 IOException -> L102
    L67:
        th = th;
    L83:
        r2 = 4;
        goto L105
    L73:
        e = e;
    L79:
        r19 = r10;
        r23 = null;
    L71:
        th = th;
        r27 = null;
    L77:
        e = e;
        r10 = null;
    L75:
        th = th;
    L82:
        r10 = null;
        r27 = null;
        goto L83
    L84:
        e = e;
        r20 = r4;
        r5 = r5;
        r23 = null;
        r19 = null;
        r14 = null;
    L80:
        th = th;
        r14 = null;
        goto L82
    L45:
        if (r8.isDirectory() == false) goto L49;
        throw new IOException(r5 + r8 + "' exists but is a directory");
    L38:
        if (r13.toFile().canWrite() == true) goto L42;
        throw new IOException(r5 + r13.getRealPath() + r4);
    L108:
        throw new IOException("Source '" + r11.getRealPath() + "' and destination '" + r13.getRealPath() + "' are the same");
    L110:
        throw new IOException("Source '" + r11.getRealPath() + "' exists but is a directory");
    L141:
        return;
    L140:
        return;
    L9:
        if (r35.toFile().canWrite() == true) goto L13;
        throw new IOException("Destination '" + r35.getRealPath() + "' exists but is read-only");
    L113:
        throw new IOException("Source '" + r34.getRealPath() + "' and destination '" + r35.getRealPath() + "' are the same");
    L115:
        throw new IOException("Source '" + r34.getRealPath() + "' exists but is not a directory");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(Context r12, String r13, String r14) {
        InputStream r4 = null;
        String[] r5 = r12.getAssets().list(r13);     // Catch: Throwable -> L30 Exception -> L32
        if (r5 != null) goto L6;
    L11:
        InputStream r15 = r12.getAssets().open(r13);     // Catch: Throwable -> L30 Exception -> L32
        PolarisFileOutputStreamWrapper r16 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r14));     // Catch: Throwable -> L26 Exception -> L28
    L44:
        byte[] r17 = new byte[1024];     // Catch: Throwable -> L22 Exception -> L24
    L15:
        int r0 = r15.read(r17);     // Catch: Throwable -> L22 Exception -> L24
        if (r0 == (-1)) goto L18;
        r16.write(r17, 0, r0);     // Catch: Throwable -> L22 Exception -> L24
        goto L15
    L18:
        r16.flush();     // Catch: Throwable -> L22 Exception -> L24
        r15.close();     // Catch: Throwable -> L22 Exception -> L24
        r16.close();     // Catch: Throwable -> L22 Exception -> L24
        r4 = r15;
    L20:
        c(new Closeable[]{r4, r16});
        return true;
    L24:
        e = move-exception;
        r4 = r15;
        e = e;
    L40:
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());     // Catch: Throwable -> L37
        c(new Closeable[]{r4, r16});
        return false;
    L37:
        th = th;
    L38:
        c(new Closeable[]{r4, r16});
        throw th;
    L22:
        th = move-exception;
        r4 = r15;
        th = th;
    L28:
        e = move-exception;
        r4 = r15;
        e = e;
        r16 = null;
    L26:
        th = move-exception;
        r4 = r15;
        th = th;
        r16 = null;
        goto L38
    L6:
        if (r5.length <= 0) goto L11;
        new PolarisFileWrapper(r14).mkdirs();     // Catch: Throwable -> L30 Exception -> L32
        int r6 = r5.length;     // Catch: Throwable -> L30 Exception -> L32
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L10;
        String r8 = r5[r7];     // Catch: Throwable -> L30 Exception -> L32
        d(r12, r13 + "/" + r8, r14 + "/" + r8);     // Catch: Throwable -> L30 Exception -> L32
        r7 = r7 + 1;     // Catch: Throwable -> L30 Exception -> L32
        goto L8
    L10:
        r16 = null;
    L32:
        e = e;
        r16 = null;
    L30:
        th = th;
        r16 = null;
        goto L38
    }
}
