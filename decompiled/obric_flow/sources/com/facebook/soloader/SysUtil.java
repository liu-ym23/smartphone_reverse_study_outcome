package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SysUtil {

    @DoNotOptimize
    @TargetApi(14)
    public static class Api14Utils {
        public Api14Utils() {
        }

        public static String a() {
            ClassLoader r5 = SoLoader.class.getClassLoader();
            if (r5 != null) goto L5;
        L14:
            return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", null).invoke((BaseDexClassLoader) r5, null);
        L11:
            e = move-exception;
            throw new RuntimeException("Cannot call getLdLibraryPath", e);
        L5:
            if ((r5 instanceof BaseDexClassLoader) == true) goto L14;
            throw new IllegalStateException("ClassLoader " + r5.getClass().getName() + " should be of type BaseDexClassLoader");
        }
    }

    @DoNotOptimize
    @TargetApi(21)
    public static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        @DoNotOptimize
        public static void fallocateIfSupported(FileDescriptor r5, long r10) {
            Os.posix_fallocate(r5, 0, r10);     // Catch: ErrnoException -> L5
            return;
        L5:
            e = move-exception;
            if (e.errno == OsConstants.EOPNOTSUPP) goto L15;
            int r11 = e.errno;
            if (r11 != OsConstants.ENOSYS) goto L11;
            return;
        L11:
            if (r11 != OsConstants.EINVAL) goto L14;
            return;
        L14:
            throw new IOException(e.toString(), e);
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            String[] r5 = Build.SUPPORTED_ABIS;
            TreeSet r10 = new TreeSet();
        L6:
            e = move-exception;
            Log.e("SysUtil", String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", new Object[]{Arrays.toString(r5), Integer.valueOf(e.errno), e.getMessage()}));
            return Build.SUPPORTED_ABIS;
        L4:
            if (is64Bit() == false) goto L8;
            r10.add("arm64-v8a");     // Catch: ErrnoException -> L6
            r10.add("x86_64");     // Catch: ErrnoException -> L6
        L9:
            ArrayList r11 = new ArrayList();
            int r12 = r5.length;
            int r13 = 0;
        L10:
            if (r13 >= r12) goto L16;
            String r14 = r5[r13];
            if (r10.contains(r14) == false) goto L14;
            r11.add(r14);
        L14:
            r13 = r13 + 1;
            goto L10
        L16:
            return (String[]) r11.toArray(new String[r11.size()]);
        L8:
            r10.add("armeabi-v7a");     // Catch: ErrnoException -> L6
            r10.add("x86");     // Catch: ErrnoException -> L6
            goto L9
        }

        @DoNotOptimize
        public static boolean is64Bit() {
            return Os.readlink("/proc/self/exe").contains("64");
        }
    }

    @DoNotOptimize
    @TargetApi(23)
    public static final class MarshmallowSysdeps {
        private MarshmallowSysdeps() {
        }

        public static boolean a(Context r5, int r10) {
            boolean r11 = true;
            if (r10 != 2) goto L29;
            ZipFile r12 = new ZipFile(new File(r5.getApplicationInfo().sourceDir));
            Enumeration<? extends ZipEntry> r13 = r12.entries();     // Catch: Throwable -> L20
        L7:
            if (r13.hasMoreElements() == false) goto L22;
            ZipEntry r14 = r13.nextElement();     // Catch: Throwable -> L20
            if (r14 == null) goto L7;
            if (r14.getName().endsWith(".so") == false) goto L7;
            if (r14.getName().contains("/lib") == false) goto L7;
            if (r14.getMethod() == 0) goto L18;
            r11 = false;
        L18:
            r12.close();
            return r11;
        L22:
            r12.close();
            return false;
        L20:
            th = move-exception;
            r12.close();     // Catch: Throwable -> L26
        L28:
            throw th;
        L26:
            th = move-exception;
            th.addSuppressed(th);
            goto L28
        L29:
            if (r5 != null) goto L31;
        L33:
            return false;
        L31:
            if ((r5.getApplicationInfo().flags & 268435456) != 0) goto L33;
            return true;
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            String[] r5 = Build.SUPPORTED_ABIS;
            TreeSet r10 = new TreeSet();
            if (is64Bit() == false) goto L5;
            r10.add("arm64-v8a");
            r10.add("x86_64");
        L6:
            ArrayList r11 = new ArrayList();
            int r12 = r5.length;
            int r13 = 0;
        L7:
            if (r13 >= r12) goto L13;
            String r14 = r5[r13];
            if (r10.contains(r14) == false) goto L11;
            r11.add(r14);
        L11:
            r13 = r13 + 1;
            goto L7
        L13:
            return (String[]) r11.toArray(new String[r11.size()]);
        L5:
            r10.add("armeabi-v7a");
            r10.add("x86");
            goto L6
        }

        @DoNotOptimize
        public static boolean is64Bit() {
            return Process.is64Bit();
        }
    }

    public static FileLocker a(File r10, File r11, boolean r12) {
        FileLocker r5 = null;
        boolean r13 = true;
        if (r12 == true) goto L5;
        FileLocker r14 = new FileLocker(r11, true);     // Catch: Throwable -> L6 FileNotFoundException -> L8
        if (r14.f8477b != null) goto L14;
        r14.close();     // Catch: Throwable -> L6 FileNotFoundException -> L8
        return null;
    L14:
        return r14;
    L5:
        return new FileLocker(r11, false);
    L8:
        e = move-exception;
    L24:
        th = th;
    L36:
        if (r13 == true) goto L38;
    L40:
        throw th;
    L38:
        if (r10.setWritable(false) == true) goto L40;
        Log.w("SysUtil", "error removing " + r10.getCanonicalPath() + " write permission");
        goto L40
    L17:
        if (r10.setWritable(true) == false) goto L35;
        if (r12 == false) goto L26;
        FileLocker r15 = new FileLocker(r11, false);     // Catch: Throwable -> L24
        if (r10.setWritable(false) == true) goto L23;
        Log.w("SysUtil", "error removing " + r10.getCanonicalPath() + " write permission");
    L23:
        return r15;
    L26:
        FileLocker r16 = new FileLocker(r11, true);     // Catch: Throwable -> L24
        if (r16.f8477b != null) goto L30;
        r16.close();     // Catch: Throwable -> L24
    L32:
        if (r10.setWritable(false) == true) goto L34;
        Log.w("SysUtil", "error removing " + r10.getCanonicalPath() + " write permission");
    L34:
        return r5;
    L30:
        r5 = r16;
        goto L32
    L35:
        throw e;     // Catch: Throwable -> L24
    L6:
        th = th;
        r13 = false;
        goto L36
    }

    public static void b(File r5) {
        if (r5.isDirectory() == false) goto L13;
        File[] r10 = r5.listFiles();
        if (r10 == null) goto L11;
        int r11 = 0;
    L8:
        if (r11 >= r10.length) goto L30;
        b(r10[r11]);
        r11 = r11 + 1;
        goto L8
    L30:
        return;
    L11:
        throw new IOException("cannot list directory " + r5);
    L13:
        if (r5.getPath().endsWith("_lock") == false) goto L15;
        return;
    L15:
        RandomAccessFile r12 = new RandomAccessFile(r5, "r");
        r12.getFD().sync();     // Catch: Throwable -> L19
        r12.close();
        return;
    L19:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L22
    L24:
        throw th;
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    public static boolean b() {
        return MarshmallowSysdeps.is64Bit();
    }

    public static String[] a() {
        return MarshmallowSysdeps.getSupportedAbis();
    }

    public static void a(File r5) {
        if (r5.isDirectory() == false) goto L10;
        File[] r10 = r5.listFiles();
        if (r10 == null) goto L26;
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L10;
        a(r10[r12]);
        r12 = r12 + 1;
        goto L8
    L26:
        return;
    L10:
        File r13 = r5.getParentFile();
        if (r13 == null) goto L18;
        if (r13.canWrite() == true) goto L18;
        if (r13.setWritable(true) == true) goto L18;
        Log.e("SysUtil", "Enable write permission failed: " + r13);
    L18:
        if (r5.delete() == false) goto L20;
        return;
    L20:
        if (r5.exists() == true) goto L23;
        return;
    L23:
        throw new IOException("Could not delete file " + r5);
    }
}
