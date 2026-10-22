package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.librarian.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f2814a = null;
    private static final String[] q = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String[] f2815b;
    private final File c;
    private final c d;
    private final Map<String, a> e;
    private final File f;
    private ApplicationInfo g;
    private File h;
    private volatile boolean i;
    private final List<ZipFile> j;
    private final List<ZipFile> k;
    private List<ZipFile> l;
    private String m;
    private Map<String, String> n;
    private String[] o;
    private String p;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2816a;

        a() {
            this.f2816a = false;
        }

        public String toString() {
            return Boolean.toString(this.f2816a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.librarian.b$b, reason: collision with other inner class name */
    class C0144b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f2817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RandomAccessFile f2818b;
        private FileLock c;
        private FileChannel d;
        private File e;

        C0144b(b r1, File r2) {
            this.f2817a = r1;
            this.e = r2;
        }

        void a() {
            RandomAccessFile r0 = new RandomAccessFile(this.e, "rw");
            this.f2818b = r0;
            this.d = r0.getChannel();     // Catch: IOException -> L10
            b.a(this.f2817a).a("blocking on lock " + this.e.getPath());     // Catch: IOException -> L7
            this.c = this.d.lock();     // Catch: IOException -> L7
            b.a(this.f2817a).a("acquired on lock " + this.e.getPath());     // Catch: IOException -> L10
            return;
        L7:
            e = move-exception;
            b.a(this.f2817a, this.d);     // Catch: IOException -> L10
            throw e;     // Catch: IOException -> L10
        L10:
            e = move-exception;
            b.a(this.f2817a, this.f2818b);
            throw e;
        }

        void b() {
            FileLock r0 = this.c;
            if (r0 != null) goto L8;
        L5:
            b.a(this.f2817a).a("released lock " + this.e.getPath());
            b.a(this.f2817a, this.d);
            b.a(this.f2817a, this.f2818b);
            return;
        L8:
            r0.release();     // Catch: IOException -> L7
            goto L5
        }
    }

    static {
        q = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r0 = com.bytedance.librarian.a.f2803a;
        if (r0 == null) goto L35;
        ApplicationInfo r1 = r0.getApplicationInfo();
        File r2 = r0.getDir("librarian", 0);
        if (r2.exists() == true) goto L8;
        r2.mkdirs();
    L8:
        if (com.bytedance.librarian.a.f2804b == null) goto L10;
        String r3 = com.bytedance.librarian.a.f2804b;
    L11:
        File r4 = new File(r2, r3 + "." + (new File(r1.sourceDir).lastModified() >> 8));
        File[] r5 = r2.listFiles();
        if (r5 == null) goto L25;
        int r6 = r5.length;
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L25;
        File r8 = r5[r7];
        if (r4.getName().equals(r8.getName()) == true) goto L24;
        File[] r9 = r8.listFiles();
        if (r9 == null) goto L23;
        int r10 = r9.length;
        int r11 = 0;
    L21:
        if (r11 >= r10) goto L23;
        r9[r11].delete();
        r11 = r11 + 1;
    L23:
        r8.delete();
    L24:
        r7 = r7 + 1;
    L25:
        r4.mkdirs();
        if (r4.exists() == true) goto L28;
        f2814a = null;
        return;
    L28:
        if (com.bytedance.librarian.a.c == null) goto L30;
        c r12 = com.bytedance.librarian.a.c;
    L31:
        f2814a = new b(r4, r12);
        return;
    L30:
        r12 = new c();
        goto L31
    L10:
        r3 = "default.version";
        goto L11
    L35:
        throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
    }

    private b(File r3, c r4) {
        this.j = new CopyOnWriteArrayList();
        this.k = new ArrayList();
        this.f2815b = new String[]{"/system/lib64", "/vendor/lib64"};
        this.c = r3;
        this.d = r4;
        this.g = com.bytedance.librarian.a.f2803a.getApplicationInfo();
        this.h = new File(this.g.nativeLibraryDir);
        this.f = new File(r3, "process.lock");
        this.e = new HashMap();
    }

    static /* synthetic */ c a(b r0) {
        return r0.d;
    }

    private File a(InputStream r6, File r7) {
        File r0 = File.createTempFile("tmp-", r7.getName(), r7.getParentFile());
        this.d.a("extracting " + r0.getPath());
        FileOutputStream r1 = new FileOutputStream(r0);
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L17
    L4:
        int r3 = r6.read(r2);     // Catch: Throwable -> L17
        if (r3 == (-1)) goto L8;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L17
        goto L4
    L8:
        if (r0.setReadOnly() == false) goto L16;
        this.d.a("renaming to " + r7.getPath());     // Catch: Throwable -> L17
        if (r0.renameTo(r7) == false) goto L14;
        a(r1);
        r0.delete();
        return r7;
    L14:
        throw new IOException("failed to rename \"" + r0.getAbsolutePath() + "\" to \"" + r7.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r0.getAbsolutePath() + "\" (tmp of \"" + r7.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        a(r1);
        r0.delete();
        throw th;
    }

    private File a(String r3, File r4, boolean r5) {
        File r0 = new File(this.h, f(r3));
        if (a(r0) == false) goto L5;
        return r0;
    L5:
        a(r4, r5);
        return r4;
    }

    private void a() {
        if (this.i == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (this.i == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L10:
        b();     // Catch: Throwable -> L24
        HashMap r0 = new HashMap();     // Catch: Throwable -> L24
        this.n = r0;     // Catch: Throwable -> L24
        r0.put("arm64-v8a", "arm64");     // Catch: Throwable -> L24
        this.n.put("armeabi-v7a", "arm");     // Catch: Throwable -> L24
        this.n.put("armeabi", "arm");     // Catch: Throwable -> L24
        String r2 = null;
        if (Build.VERSION.SDK_INT >= 21) goto L27;
    L17:
        this.m = r2;     // Catch: Throwable -> L24
        this.d.a("vm instruction set: " + this.m);     // Catch: Throwable -> L24
        if (Build.VERSION.SDK_INT >= 21) goto L20;
        String[] r1 = {Build.CPU_ABI, Build.CPU_ABI2};     // Catch: Throwable -> L24
    L21:
        this.o = r1;     // Catch: Throwable -> L24
        this.i = true;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L20:
        r1 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L24
        goto L21
    L27:
        Class r3 = ZeusTransformUtils.forName("dalvik.system.VMRuntime", "com.obric.memorydata.plugin");     // Catch: Exception -> L15 Throwable -> L24
        r2 = (String) ZeusTransformUtils.preCheckCast(r3.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r3.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15 Throwable -> L24
        goto L17
    L15:
        e = move-exception;
        this.d.a("fail to process vm abi previously", new LibrarianUnsatisfiedLinkError("reflect err", e));     // Catch: Throwable -> L24
        goto L17
    }

    static /* synthetic */ void a(b r2, Closeable r3) {
        r2.a((Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.memorydata.plugin"));
    }

    private void a(Closeable r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        r4.close();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.d.a("failed to close resource", e);
    }

    private void a(File r5, boolean r6) {
        String r0 = r5.getName();
        monitor-enter(this);
        C0144b r1 = new C0144b(this, this.f);     // Catch: Throwable -> L21
        r1.a();     // Catch: Throwable -> L14 IOException -> L16
        if (d(r5) == true) goto L11;
        if (r6 == false) goto L10;
        this.d.a("may be system lib, no found " + r0);     // Catch: Throwable -> L14 IOException -> L16
        goto L11
    L10:
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r0);     // Catch: Throwable -> L14 IOException -> L16
    L11:
        r1.b();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L16:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r0, e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r1.b();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private void a(File[] r2, int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        File r1 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r1;
    }

    private boolean a(File r9) {
        if (r9.exists() == true) goto L7;
        c r8 = this.d;
        StringBuilder r10 = new StringBuilder().append("file is not exist: ").append(r9.getPath());
    L5:
        r8.b(r10.toString());
        return false;
    L7:
        d(r9.getName());
        long r2 = 0;
        String r0 = "lib/" + this.p + "/" + r9.getName();
        Iterator<ZipFile> r4 = c().iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        ZipEntry r5 = ((ZipFile) ZeusTransformUtils.preCheckCast(r4.next(), ZipFile.class, "com.obric.memorydata.plugin")).getEntry(r0);
        if (r5 == null) goto L9;
        r2 = r5.getCrc();
    L13:
        long r6 = c(r9);
        r8 = this.d;
        if (r2 != r6) goto L17;
        r8.a(r0 + " compare crc ok: entry is " + r2 + ", file is " + r6);
        return true;
    L17:
        r10 = new StringBuilder().append(r0).append(" crc is wrong: entry is ").append(r2).append(", file is ").append(r6);
        goto L5
    }

    private boolean a(File r4, String r5, boolean r6) {
        this.d.d(r4.getPath());     // Catch: UnsatisfiedLinkError -> L5
        this.d.a("loaded the extracted lib " + r5);     // Catch: UnsatisfiedLinkError -> L5
        return true;
    L5:
        e = move-exception;
        if (r6 == true) goto L10;
        this.d.a("fail to load " + r4.getName() + ", out lib exists", e);
        return false;
    L10:
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r4.getPath(), e);
    }

    private boolean a(String r17) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        String r3 = this.m;
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L18;
        return false;
    L18:
        this.d.a("try to opt native lib dirs on L");
        BaseDexClassLoader r5 = (BaseDexClassLoader) ZeusTransformUtils.preCheckCast(getClass().getClassLoader(), BaseDexClassLoader.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L56
        Field r6 = BaseDexClassLoader.class.getDeclaredField("pathList");     // Catch: Exception -> L56
        r6.setAccessible(true);     // Catch: Exception -> L56
        Object r7 = r6.get(r5);     // Catch: Exception -> L56
        Field r8 = r7.getClass().getDeclaredField("nativeLibraryDirectories");     // Catch: Exception -> L56
        r8.setAccessible(true);     // Catch: Exception -> L56
        File[] r0 = (File[]) ZeusTransformUtils.preCheckCast((File[]) ZeusTransformUtils.preCheckCast(r8.get(r7), File[].class, "com.obric.memorydata.plugin"), File[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L56
        int r9 = r0.length;     // Catch: Exception -> L56
        File[] r10 = new File[r9];     // Catch: Exception -> L56
        System.arraycopy(r0, 0, r10, 0, r9);     // Catch: Exception -> L56
        int r11 = -1;
        int r12 = -1;
        int r13 = -1;
        int r14 = 0;
    L20:
        if (r14 >= r9) goto L31;
        File r15 = r10[r14];     // Catch: Exception -> L56
        if (this.c.equals(r15) == false) goto L25;
        r11 = r14;
    L30:
        r14 = r14 + 1;     // Catch: Exception -> L56
        goto L20
    L25:
        if (this.h.equals(r15) == false) goto L28;
        r13 = r14;
        goto L30
    L28:
        if (new File(r15, f(r17)).exists() == false) goto L30;
        r12 = r14;
        goto L30
    L31:
        if (r11 == (-1)) goto L33;
        File[] r16 = new File[r9];     // Catch: Exception -> L56
        a(r10, 0, r11);     // Catch: Exception -> L56
        int r18 = 1;
    L34:
        if (r12 == (-1)) goto L36;
        a(r10, r18, r12);     // Catch: Exception -> L56
        r18 = r18 + 1;     // Catch: Exception -> L56
    L36:
        if (r13 == (-1)) goto L38;
        a(r10, r18, r13);     // Catch: Exception -> L56
        r18 = r18 + 1;     // Catch: Exception -> L56
    L38:
        int r19 = r9 - this.f2815b.length;     // Catch: Exception -> L56
    L39:
        if (r19 >= r9) goto L51;
        if (b(r10[r19].getAbsolutePath()) == true) goto L50;
        int r110 = r18;
    L45:
        if (r110 >= (r9 - 2)) goto L50;
        if (b(r10[r110].getAbsolutePath()) == false) goto L49;
        a(r10, r19, r110);     // Catch: Exception -> L56
    L49:
        r110 = r110 + 1;     // Catch: Exception -> L56
    L50:
        r19 = r19 + 1;     // Catch: Exception -> L56
        goto L39
    L51:
        if (r11 == (-1)) goto L53;
        System.arraycopy(r10, 0, r16, 0, r9);     // Catch: Exception -> L56
    L54:
        r8.set(r7, r16);     // Catch: Exception -> L56
        this.d.a("success to insert path " + r5);     // Catch: Exception -> L56
        return true;
    L53:
        System.arraycopy(r10, 0, r16, 1, r9);     // Catch: Exception -> L56
        goto L54
    L33:
        r16 = new File[r9 + 1];     // Catch: Exception -> L56
        r16[0] = this.c;     // Catch: Exception -> L56
        r18 = 0;
    L56:
        e = move-exception;
        this.d.a("fail to insert path", new LibrarianUnsatisfiedLinkError("opt lib dir err", e));
        return false;
    L13:
        if (r3.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L15;
        r4 = true;
        goto L16
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        r2 = true;
        goto L8
    }

    private boolean a(String r6, String r7) {
        this.d.c(r6);     // Catch: UnsatisfiedLinkError -> L6
        this.d.a("loaded the origin lib " + r6 + ", tag: " + r7);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        this.d.a("fail to load " + r6 + ", tag: " + r7, e);
        LibrarianUnsatisfiedLinkError.recordOriginError(e);
        File r0 = new File(com.bytedance.librarian.a.f2803a.getApplicationInfo().nativeLibraryDir);
        if (this.h.equals(r0) == false) goto L12;
        return false;
    L12:
        throw new LibrarianUnsatisfiedLinkError("System.loadLibrary(\"" + r6 + "\") failed, because ApplicationInfo changed. nativeLibraryDir from " + this.h.getAbsolutePath() + " to " + r0.getAbsolutePath(), e);
    }

    private List<String> b(File r3) {
        Closeable r0 = null;
        f r1 = new f(r3);     // Catch: Throwable -> L9
        List<String> r4 = r1.b();     // Catch: Throwable -> L7
        Collections.sort(r4);     // Catch: Throwable -> L7
        a(r1);
        return r4;
    L7:
        th = th;
        r0 = r1;
    L10:
        a(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private void b() {
        this.j.clear();
        File r0 = new File(this.g.sourceDir);
        ArrayList r1 = new ArrayList();
        r1.add(r0);
        if (Build.VERSION.SDK_INT < 21) goto L11;
        String[] r2 = this.g.splitSourceDirs;
        if (r2 == null) goto L11;
        if (r2.length == 0) goto L11;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L11;
        String r5 = r2[r4];
        r1.add(new File(r5));
        this.d.a("split source dir: " + r5);
        r4 = r4 + 1;
    L11:
        Iterator r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L19;
        File r7 = (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.memorydata.plugin");
        this.j.add(new ZipFile(r7));     // Catch: IOException -> L17
    L17:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r7.getName() + ", size " + r7.length() + ", exists " + r7.exists(), e).printStackTrace();
        goto L13
    }

    private void b(File r5, boolean r6) {
        Iterator<String> r7 = b(r5).iterator();     // Catch: IOException -> L10
    L4:
        if (r7.hasNext() == false) goto L9;
        String r0 = g((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L10
        if (c(r0) == true) goto L4;
        this.d.a("to load depended lib " + r0);     // Catch: IOException -> L10
        a(r0, r6);     // Catch: IOException -> L10
        goto L4
    L9:
        return;
    L10:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);
    }

    private void b(String r7, boolean r8) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        int r0 = 12;
    L6:
        int r1 = 0;
        LibrarianUnsatisfiedLinkError r2 = null;
        LibrarianUnsatisfiedLinkError e = null;
    L7:
        if (r1 >= r0) goto L15;
        c(r7, r8);     // Catch: LibrarianUnsatisfiedLinkError -> L10
    L16:
        if (r2 != null) goto L18;
        return;
    L18:
        throw r2;
    L10:
        e = e;
        if (this.h.equals(new File(com.bytedance.librarian.a.f2803a.getApplicationInfo().nativeLibraryDir)) == true) goto L15;
        this.g = com.bytedance.librarian.a.f2803a.getApplicationInfo();
        this.h = new File(this.g.nativeLibraryDir);
        b();
        this.l = null;
        r1 = r1 + 1;
    L15:
        r2 = e;
        goto L16
    L5:
        r0 = 1;
        goto L6
    }

    private boolean b(String r5) {
        String[] r4 = this.f2815b;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private long c(File r6) {
        byte[] r0 = new byte[8192];
        Closeable r1 = null;
        CheckedInputStream r2 = new CheckedInputStream(new FileInputStream(r6), new CRC32());     // Catch: Throwable -> L13 IOException -> L15
    L25:
    L11:
        e = e;
        r1 = r2;
    L16:
        this.d.a("fail to check sum for " + r6.getPath(), e);     // Catch: Throwable -> L13
        a(r1);
        return 0;
    L9:
        th = th;
        r1 = r2;
    L19:
        a(r1);
        throw th;
    L5:
        if (r2.read(r0) >= 0) goto L25;
        long r3 = r2.getChecksum().getValue();     // Catch: Throwable -> L9 IOException -> L11
        a(r2);
        return r3;
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    private List<ZipFile> c() {
        List<ZipFile> r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        List<ZipFile> r1 = this.k;
        monitor-enter(r1);
        ArrayList r2 = new ArrayList(this.j.size() + this.k.size());     // Catch: Throwable -> L11
        r2.addAll(this.j);     // Catch: Throwable -> L11
        r2.addAll(this.k);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        this.l = r2;
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    private void c(String r7, boolean r8) {
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r0 = true;
    L6:
        File r3 = new File(this.c, f(r7));
        if (r0 == true) goto L9;
        if (r8 == false) goto L29;
    L31:
        a();
        a(r3, r8);
        b(r3, r8);
    L32:
        a(r3, r7, true);
        return;
    L29:
        if (a(r7, "preload lower version device") == false) goto L31;
        return;
    L9:
        if (a(r7, "preload") == false) goto L12;
        return;
    L12:
        if (r3.exists() == true) goto L14;
    L16:
        a();
        if (a(r7) == true) goto L19;
    L21:
        File r1 = a(r7, r3, r8);
        b(r1, r8);
        if (r1 == r3) goto L32;
        if (a(r7, "after loading dep libs") == false) goto L26;
        return;
    L26:
        a(r3, r8);
        goto L32
    L19:
        if (a(r7, "lollipop") == false) goto L21;
        return;
    L14:
        if (a(r3, r7, false) == false) goto L16;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private boolean c(String r5) {
        String[] r4 = q;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private String d() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        Iterator<ZipFile> r5 = c().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        ZipFile r1 = (ZipFile) ZeusTransformUtils.preCheckCast(r5.next(), ZipFile.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        String r2 = r1.getName();
        File r3 = new File(r2);
        r0.append(r2).append("#").append(r1.size()).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r3.length()).append("|");
        goto L4
    L8:
        r0.append("]");
        return r0.toString();
    }

    private void d(String r10) {
        if (this.p == null) goto L5;
        return;
    L5:
        String[] r0 = this.o;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L21;
        String r3 = r0[r2];
        if (e(r3) == false) goto L19;
        String r4 = "lib/" + r3 + "/" + r10;
        Iterator<ZipFile> r5 = c().iterator();
    L12:
        if (r5.hasNext() == false) goto L19;
        ZipFile r6 = (ZipFile) ZeusTransformUtils.preCheckCast(r5.next(), ZipFile.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        if (r6.getEntry(r4) == null) goto L12;
        this.p = r3;
        this.d.a("ensure that abi is " + r3);
        return;
    L19:
        r2 = r2 + 1;
        goto L6
    L21:
        throw new LibrarianUnsatisfiedLinkError("can not ensure abi for " + r10 + ", check " + this.m + ", apks " + d());
    }

    private boolean d(File r7) {
        d(r7.getName());
        String r0 = "lib/" + this.p + "/" + r7.getName();
        Iterator<ZipFile> r1 = c().iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        ZipFile r2 = (ZipFile) ZeusTransformUtils.preCheckCast(r1.next(), ZipFile.class, "com.obric.memorydata.plugin");
        ZipEntry r3 = r2.getEntry(r0);
        if (r3 == null) goto L4;
        InputStream r4 = r2.getInputStream(r3);
        a(r4, r7);     // Catch: Throwable -> L12
        this.d.a("get lib file " + r7.getPath() + " from " + r0 + " of " + r2.getName());     // Catch: Throwable -> L12
        a(r4);
        return true;
    L12:
        th = move-exception;
        a(r4);
        throw th;
    L15:
        return false;
    }

    private boolean e(String r4) {
        if (this.m != null) goto L6;
        return true;
    L6:
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.n.get(r4), String.class, "com.obric.memorydata.plugin");
        String r3 = this.m;
        if (r0 == null) goto L10;
        r4 = r0;
    L10:
        return r3.equals(r4);
    }

    private static String f(String r2) {
        return "lib" + r2 + ".so";
    }

    private static String g(String r2) {
        return r2.substring(3, r2.length() - 3);
    }

    void a(String r5, boolean r6) {
        Map<String, a> r0 = this.e;
        monitor-enter(r0);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.e.get(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r1 != null) goto L7;
        r1 = new a();     // Catch: Throwable -> L24
        this.e.put(r5, r1);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L24
        monitor-enter(r1);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (r1.f2816a == false) goto L18;
        this.d.a("lib was already loaded before: " + r5);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L18:
        b(r5, r6);     // Catch: Throwable -> L21
        r1.f2816a = true;     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L7:
        if (r1.f2816a == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
