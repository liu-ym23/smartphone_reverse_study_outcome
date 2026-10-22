package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
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
import n3.i;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final b f2127p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f2128q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f2129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f2130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, a> f2131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f2132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ApplicationInfo f2133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f2134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f2135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<ZipFile> f2136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<ZipFile> f2137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<ZipFile> f2138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, String> f2140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String[] f2141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f2142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final String[] f2143o;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2144a;

        a() {
            this.f2144a = false;
        }

        public String toString() {
            return Boolean.toString(this.f2144a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.librarian.b$b, reason: collision with other inner class name */
    class C0063b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RandomAccessFile f2145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FileLock f2146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private FileChannel f2147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private File f2148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f2149e;

        C0063b(b r10, File r11) {
            this.f2149e = r10;
            this.f2148d = r11;
        }

        void a() {
            FileLock r10 = this.f2146b;
            if (r10 != null) goto L8;
        L5:
            b.a(this.f2149e).a("released lock " + this.f2148d.getPath());
            b.b(this.f2149e, this.f2147c);
            b.b(this.f2149e, this.f2145a);
            return;
        L8:
            r10.release();     // Catch: IOException -> L7
            goto L5
        }

        void b() {
            RandomAccessFile r10 = new RandomAccessFile(this.f2148d, "rw");
            this.f2145a = r10;
            this.f2147c = r10.getChannel();     // Catch: IOException -> L10
            b.a(this.f2149e).a("blocking on lock " + this.f2148d.getPath());     // Catch: IOException -> L7
            this.f2146b = this.f2147c.lock();     // Catch: IOException -> L7
            b.a(this.f2149e).a("acquired on lock " + this.f2148d.getPath());     // Catch: IOException -> L10
            return;
        L7:
            e = move-exception;
            b.b(this.f2149e, this.f2147c);     // Catch: IOException -> L10
            throw e;     // Catch: IOException -> L10
        L10:
            e = move-exception;
            b.b(this.f2149e, this.f2145a);
            throw e;
        }
    }

    static {
        f2128q = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r10 = com.bytedance.librarian.a.f2124a;
        if (r10 == null) goto L35;
        ApplicationInfo r11 = r10.getApplicationInfo();
        File r12 = r10.getDir("librarian", 0);
        if (r12.exists() == true) goto L8;
        r12.mkdirs();
    L8:
        if (com.bytedance.librarian.a.f2125b == null) goto L10;
        String r13 = com.bytedance.librarian.a.f2125b;
    L11:
        File r14 = new File(r12, r13 + "." + (new File(r11.sourceDir).lastModified() >> 8));
        File[] r15 = r12.listFiles();
        if (r15 == null) goto L25;
        int r16 = r15.length;
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L25;
        File r18 = r15[r17];
        if (r14.getName().equals(r18.getName()) == true) goto L24;
        File[] r19 = r18.listFiles();
        if (r19 == null) goto L23;
        int r20 = r19.length;
        int r21 = 0;
    L21:
        if (r21 >= r20) goto L23;
        r19[r21].delete();
        r21 = r21 + 1;
    L23:
        r18.delete();
    L24:
        r17 = r17 + 1;
    L25:
        r14.mkdirs();
        if (r14.exists() == false) goto L32;
        c r22 = com.bytedance.librarian.a.f2126c;
        if (r22 != null) goto L31;
        r22 = new c();
    L31:
        f2127p = new b(r14, r22);
        return;
    L32:
        f2127p = null;
        return;
    L10:
        r13 = "default.version";
        goto L11
    L35:
        throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
    }

    private b(File r10, c r11) {
        this.f2136h = new CopyOnWriteArrayList();
        this.f2137i = new ArrayList();
        this.f2143o = new String[]{"/system/lib64", "/vendor/lib64"};
        this.f2129a = r10;
        this.f2130b = r11;
        this.f2133e = com.bytedance.librarian.a.f2124a.getApplicationInfo();
        this.f2134f = new File(this.f2133e.nativeLibraryDir);
        this.f2132d = new File(r10, "process.lock");
        this.f2131c = new HashMap();
    }

    private void A(File[] r10, int r11, int r12) {
        if (r11 != r12) goto L4;
        return;
    L4:
        File r13 = r10[r11];
        r10[r11] = r10[r12];
        r10[r12] = r13;
    }

    private boolean B(String r17) {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 21) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == true) goto L10;
        return false;
    L10:
        String r12 = this.f2139k;
        if (r12 != null) goto L13;
    L15:
        boolean r13 = false;
    L16:
        if (r13 == true) goto L18;
        return false;
    L18:
        this.f2130b.a("try to opt native lib dirs on L");
        BaseDexClassLoader r14 = (BaseDexClassLoader) b.class.getClassLoader();     // Catch: Exception -> L56
        Field r15 = BaseDexClassLoader.class.getDeclaredField("pathList");     // Catch: Exception -> L56
        r15.setAccessible(true);     // Catch: Exception -> L56
        Object r16 = r15.get(r14);     // Catch: Exception -> L56
        Field r18 = r16.getClass().getDeclaredField("nativeLibraryDirectories");     // Catch: Exception -> L56
        r18.setAccessible(true);     // Catch: Exception -> L56
        File[] r19 = (File[]) r18.get(r16);     // Catch: Exception -> L56
        int r20 = r19.length;     // Catch: Exception -> L56
        File[] r21 = new File[r20];     // Catch: Exception -> L56
        System.arraycopy(r19, 0, r21, 0, r20);     // Catch: Exception -> L56
        int r22 = 0;
        int r110 = -1;
        int r111 = -1;
        int r112 = -1;
    L20:
        if (r22 >= r20) goto L31;
        File r113 = r21[r22];     // Catch: Exception -> L56
        if (this.f2129a.equals(r113) == false) goto L25;
        r110 = r22;
    L30:
        r22 = r22 + 1;     // Catch: Exception -> L56
        goto L20
    L25:
        if (this.f2134f.equals(r113) == false) goto L28;
        r112 = r22;
        goto L30
    L28:
        if (new File(r113, m(r17)).exists() == false) goto L30;
        r111 = r22;
        goto L30
    L31:
        if (r110 == (-1)) goto L33;
        File[] r23 = new File[r20];     // Catch: Exception -> L56
        A(r21, 0, r110);     // Catch: Exception -> L56
        int r114 = 1;
    L34:
        if (r111 == (-1)) goto L36;
        A(r21, r114, r111);     // Catch: Exception -> L56
        r114 = r114 + 1;     // Catch: Exception -> L56
    L36:
        if (r112 == (-1)) goto L38;
        A(r21, r114, r112);     // Catch: Exception -> L56
        r114 = r114 + 1;     // Catch: Exception -> L56
    L38:
        int r115 = r20 - this.f2143o.length;     // Catch: Exception -> L56
    L39:
        if (r115 >= r20) goto L51;
        if (p(r21[r115].getAbsolutePath()) == true) goto L50;
        int r116 = r114;
    L45:
        if (r116 >= (r20 - 2)) goto L50;
        if (p(r21[r116].getAbsolutePath()) == false) goto L49;
        A(r21, r115, r116);     // Catch: Exception -> L56
    L49:
        r116 = r116 + 1;     // Catch: Exception -> L56
    L50:
        r115 = r115 + 1;     // Catch: Exception -> L56
        goto L39
    L51:
        if (r110 == (-1)) goto L53;
        System.arraycopy(r21, 0, r23, 0, r20);     // Catch: Exception -> L56
    L54:
        r18.set(r16, r23);     // Catch: Exception -> L56
        this.f2130b.a("success to insert path " + r14);     // Catch: Exception -> L56
        return true;
    L53:
        System.arraycopy(r21, 0, r23, 1, r20);     // Catch: Exception -> L56
        goto L54
    L33:
        r23 = new File[r20 + 1];     // Catch: Exception -> L56
        r23[0] = this.f2129a;     // Catch: Exception -> L56
        r114 = 0;
    L56:
        e = move-exception;
        this.f2130b.c("fail to insert path", new LibrarianUnsatisfiedLinkError("opt lib dir err", e));
        return false;
    L13:
        if (r12.contains("64") == false) goto L15;
        r13 = true;
        goto L16
    L5:
        if (r10 >= 23) goto L7;
        r11 = true;
        goto L8
    }

    static /* synthetic */ c a(b r10) {
        return r10.f2130b;
    }

    static /* synthetic */ void b(b r10, Closeable r11) {
        r10.f(r11);
    }

    private void c() {
        if (this.f2135g == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (this.f2135g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L10:
        n();     // Catch: Throwable -> L24
        HashMap r10 = new HashMap();     // Catch: Throwable -> L24
        this.f2140l = r10;     // Catch: Throwable -> L24
        r10.put("arm64-v8a", "arm64");     // Catch: Throwable -> L24
        this.f2140l.put("armeabi-v7a", "arm");     // Catch: Throwable -> L24
        this.f2140l.put("armeabi", "arm");     // Catch: Throwable -> L24
        String r11 = null;
        if (Build.VERSION.SDK_INT >= 21) goto L27;
    L17:
        this.f2139k = r11;     // Catch: Throwable -> L24
        this.f2130b.a("vm instruction set: " + this.f2139k);     // Catch: Throwable -> L24
        if (Build.VERSION.SDK_INT >= 21) goto L20;
        String[] r12 = {Build.CPU_ABI, Build.CPU_ABI2};     // Catch: Throwable -> L24
    L21:
        this.f2141m = r12;     // Catch: Throwable -> L24
        this.f2135g = true;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L20:
        r12 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L24
        goto L21
    L27:
        Class<?> r13 = Class.forName("dalvik.system.VMRuntime");     // Catch: Exception -> L15 Throwable -> L24
        r11 = (String) r13.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r13.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L15 Throwable -> L24
        goto L17
    L15:
        e = move-exception;
        this.f2130b.c("fail to process vm abi previously", new LibrarianUnsatisfiedLinkError("reflect err", e));     // Catch: Throwable -> L24
        goto L17
    }

    private boolean d(File r10) {
        if (r10.exists() == true) goto L7;
        c r11 = this.f2130b;
        String r12 = "file is not exist: " + r10.getPath();
    L5:
        r11.b(r12);
        return false;
    L7:
        i(r10.getName());
        long r13 = 0;
        String r14 = "lib/" + this.f2142n + "/" + r10.getName();
        Iterator<ZipFile> r15 = w().iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        ZipEntry r16 = r15.next().getEntry(r14);
        if (r16 == null) goto L9;
        r13 = r16.getCrc();
    L13:
        long r17 = h(r10);
        r11 = this.f2130b;
        if (r13 != r17) goto L17;
        r11.a(r14 + " compare crc ok: entry is " + r13 + ", file is " + r17);
        return true;
    L17:
        r12 = r14 + " crc is wrong: entry is " + r13 + ", file is " + r17;
        goto L5
    }

    private boolean e(String r10) {
        if (this.f2139k != null) goto L6;
        return true;
    L6:
        String r11 = this.f2140l.get(r10);
        String r12 = this.f2139k;
        if (r11 == null) goto L10;
        r10 = r11;
    L10:
        return r12.equals(r10);
    }

    private void f(Closeable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        r10.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.f2130b.c("failed to close resource", e);
    }

    private boolean g(File r10) {
        i(r10.getName());
        String r11 = "lib/" + this.f2142n + "/" + r10.getName();
        Iterator<ZipFile> r12 = w().iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        ZipFile r13 = r12.next();
        ZipEntry r14 = r13.getEntry(r11);
        if (r14 == null) goto L4;
        InputStream r15 = r13.getInputStream(r14);
        y(r15, r10);     // Catch: Throwable -> L12
        this.f2130b.a("get lib file " + r10.getPath() + " from " + r11 + " of " + r13.getName());     // Catch: Throwable -> L12
        f(r15);
        return true;
    L12:
        th = move-exception;
        f(r15);
        throw th;
    L15:
        return false;
    }

    private long h(File r10) {
        byte[] r11 = new byte[8192];
        Closeable r12 = null;
        CheckedInputStream r13 = new CheckedInputStream(new FileInputStream(r10), new CRC32());     // Catch: Throwable -> L13 IOException -> L15
    L25:
    L11:
        e = e;
        r12 = r13;
    L16:
        this.f2130b.c("fail to check sum for " + r10.getPath(), e);     // Catch: Throwable -> L13
        f(r12);
        return 0;
    L9:
        th = th;
        r12 = r13;
    L19:
        f(r12);
        throw th;
    L5:
        if (r13.read(r11) >= 0) goto L25;
        long r14 = r13.getChecksum().getValue();     // Catch: Throwable -> L9 IOException -> L11
        f(r13);
        return r14;
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    private void i(String r10) {
        if (this.f2142n == null) goto L5;
        return;
    L5:
        String[] r11 = this.f2141m;
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L21;
        String r14 = r11[r13];
        if (e(r14) == false) goto L19;
        String r15 = "lib/" + r14 + "/" + r10;
        Iterator<ZipFile> r16 = w().iterator();
    L12:
        if (r16.hasNext() == false) goto L19;
        ZipFile r17 = r16.next();
        if (r17 == null) goto L12;
        if (r17.getEntry(r15) == null) goto L12;
        this.f2142n = r14;
        this.f2130b.a("ensure that abi is " + r14);
        return;
    L19:
        r13 = r13 + 1;
        goto L6
    L21:
        throw new LibrarianUnsatisfiedLinkError("can not ensure abi for " + r10 + ", check " + this.f2139k + ", apks " + k());
    }

    private void j(File r10, boolean r11) {
        String r12 = r10.getName();
        monitor-enter(this);
        C0063b r13 = new C0063b(this, this.f2132d);     // Catch: Throwable -> L21
        r13.b();     // Catch: Throwable -> L14 IOException -> L16
        if (g(r10) == true) goto L11;
        if (r11 == false) goto L10;
        this.f2130b.a("may be system lib, no found " + r12);     // Catch: Throwable -> L14 IOException -> L16
        goto L11
    L10:
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r12);     // Catch: Throwable -> L14 IOException -> L16
    L11:
        r13.a();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L14:
        th = move-exception;
        r13.a();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L16:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r12, e);     // Catch: Throwable -> L14
    L21:
        th = move-exception;
        throw th;
    }

    private String k() {
        StringBuilder r10 = new StringBuilder();
        r10.append("[");
        Iterator<ZipFile> r11 = w().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ZipFile r12 = r11.next();
        if (r12 == null) goto L4;
        String r13 = r12.getName();
        File r14 = new File(r13);
        r10.append(r13);
        r10.append("#");
        r10.append(r12.size());
        r10.append(":");
        r10.append(r14.length());
        r10.append("|");
        goto L4
    L8:
        r10.append("]");
        return r10.toString();
    }

    private static String l(String r10) {
        return r10.substring(3, r10.length() - 3);
    }

    private static String m(String r10) {
        return "lib" + r10 + ".so";
    }

    private void n() {
        this.f2136h.clear();
        File r10 = new File(this.f2133e.sourceDir);
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        if (Build.VERSION.SDK_INT < 21) goto L11;
        String[] r12 = this.f2133e.splitSourceDirs;
        if (r12 == null) goto L11;
        if (r12.length == 0) goto L11;
        int r13 = r12.length;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L11;
        String r15 = r12[r14];
        r11.add(new File(r15));
        this.f2130b.a("split source dir: " + r15);
        r14 = r14 + 1;
    L11:
        Iterator r16 = r11.iterator();
    L13:
        if (r16.hasNext() == false) goto L19;
        File r17 = (File) r16.next();
        this.f2136h.add(new ZipFile(r17));     // Catch: IOException -> L17
    L17:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r17.getName() + ", size " + r17.length() + ", exists " + r17.exists(), e).printStackTrace();
        goto L13
    }

    private boolean o(String r10) {
        String[] r11 = f2128q;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11[r13].equals(r10) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean p(String r10) {
        String[] r11 = this.f2143o;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11[r13].equals(r10) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void q(File r10, boolean r11) {
        Iterator<String> r12 = x(r10).iterator();     // Catch: IOException -> L10
    L4:
        if (r12.hasNext() == false) goto L9;
        String r13 = l(r12.next());     // Catch: IOException -> L10
        if (o(r13) == true) goto L4;
        this.f2130b.a("to load depended lib " + r13);     // Catch: IOException -> L10
        s(r13, r11);     // Catch: IOException -> L10
        goto L4
    L9:
        return;
    L10:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);
    }

    private boolean r(File r10, String r11, boolean r12) {
        this.f2130b.d(r10.getPath());     // Catch: UnsatisfiedLinkError -> L5
        this.f2130b.a("loaded the extracted lib " + r11);     // Catch: UnsatisfiedLinkError -> L5
        return true;
    L5:
        e = move-exception;
        if (r12 == true) goto L10;
        this.f2130b.c("fail to load " + r10.getName() + ", out lib exists", e);
        return false;
    L10:
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r10.getPath(), e);
    }

    private void t(String r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r12 = true;
    L6:
        File r13 = new File(this.f2129a, m(r10));
        if (r12 == true) goto L9;
        if (r11 == false) goto L29;
    L31:
        c();
        j(r13, r11);
        q(r13, r11);
    L32:
        r(r13, r10, true);
        return;
    L29:
        if (v(r10, "preload lower version device") == false) goto L31;
        return;
    L9:
        if (v(r10, "preload") == false) goto L12;
        return;
    L12:
        if (r13.exists() == true) goto L14;
    L16:
        c();
        if (B(r10) == true) goto L19;
    L21:
        File r14 = z(r10, r13, r11);
        q(r14, r11);
        if (r14 == r13) goto L32;
        if (v(r10, "after loading dep libs") == false) goto L26;
        return;
    L26:
        j(r13, r11);
        goto L32
    L19:
        if (v(r10, "lollipop") == false) goto L21;
        return;
    L14:
        if (r(r13, r10, false) == false) goto L16;
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void u(String r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        int r12 = 12;
    L6:
        int r13 = 0;
        LibrarianUnsatisfiedLinkError r14 = null;
        LibrarianUnsatisfiedLinkError e10 = null;
    L7:
        if (r13 >= r12) goto L15;
        t(r10, r11);     // Catch: LibrarianUnsatisfiedLinkError -> L10
    L16:
        if (r14 != null) goto L18;
        return;
    L18:
        throw r14;
    L10:
        e10 = e;
        if (this.f2134f.equals(new File(com.bytedance.librarian.a.f2124a.getApplicationInfo().nativeLibraryDir)) == true) goto L15;
        this.f2133e = com.bytedance.librarian.a.f2124a.getApplicationInfo();
        this.f2134f = new File(this.f2133e.nativeLibraryDir);
        n();
        this.f2138j = null;
        r13 = r13 + 1;
    L15:
        r14 = e10;
        goto L16
    L5:
        r12 = 1;
        goto L6
    }

    private boolean v(String r10, String r11) {
        this.f2130b.e(r10);     // Catch: UnsatisfiedLinkError -> L6
        this.f2130b.a("loaded the origin lib " + r10 + ", tag: " + r11);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        this.f2130b.c("fail to load " + r10 + ", tag: " + r11, e);
        LibrarianUnsatisfiedLinkError.recordOriginError(e);
        File r12 = new File(com.bytedance.librarian.a.f2124a.getApplicationInfo().nativeLibraryDir);
        if (this.f2134f.equals(r12) == false) goto L12;
        return false;
    L12:
        throw new LibrarianUnsatisfiedLinkError("System.loadLibrary(\"" + r10 + "\") failed, because ApplicationInfo changed. nativeLibraryDir from " + this.f2134f.getAbsolutePath() + " to " + r12.getAbsolutePath(), e);
    }

    private List<ZipFile> w() {
        List<ZipFile> r10 = this.f2138j;
        if (r10 == null) goto L5;
        return r10;
    L5:
        List<ZipFile> r11 = this.f2137i;
        monitor-enter(r11);
        ArrayList r12 = new ArrayList(this.f2136h.size() + this.f2137i.size());     // Catch: Throwable -> L11
        r12.addAll(this.f2136h);     // Catch: Throwable -> L11
        r12.addAll(this.f2137i);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        this.f2138j = r12;
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    private List<String> x(File r10) {
        Closeable r11 = null;
        i r12 = new i(r10);     // Catch: Throwable -> L9
        List<String> r13 = r12.f();     // Catch: Throwable -> L7
        Collections.sort(r13);     // Catch: Throwable -> L7
        f(r12);
        return r13;
    L7:
        th = th;
        r11 = r12;
    L10:
        f(r11);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private File y(InputStream r10, File r11) {
        File r12 = File.createTempFile("tmp-", r11.getName(), r11.getParentFile());
        this.f2130b.a("extracting " + r12.getPath());
        FileOutputStream r13 = new FileOutputStream(r12);
        byte[] r14 = new byte[8192];     // Catch: Throwable -> L17
    L4:
        int r15 = r10.read(r14);     // Catch: Throwable -> L17
        if (r15 == (-1)) goto L8;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L17
        goto L4
    L8:
        if (r12.setReadOnly() == false) goto L16;
        this.f2130b.a("renaming to " + r11.getPath());     // Catch: Throwable -> L17
        if (r12.renameTo(r11) == false) goto L14;
        f(r13);
        r12.delete();
        return r11;
    L14:
        throw new IOException("failed to rename \"" + r12.getAbsolutePath() + "\" to \"" + r11.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r12.getAbsolutePath() + "\" (tmp of \"" + r11.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        f(r13);
        r12.delete();
        throw th;
    }

    private File z(String r10, File r11, boolean r12) {
        File r13 = new File(this.f2134f, m(r10));
        if (d(r13) == false) goto L5;
        return r13;
    L5:
        j(r11, r12);
        return r11;
    }

    void s(String r10, boolean r11) {
        Map<String, a> r12 = this.f2131c;
        monitor-enter(r12);
        a r13 = this.f2131c.get(r10);     // Catch: Throwable -> L24
        if (r13 != null) goto L7;
        r13 = new a();     // Catch: Throwable -> L24
        this.f2131c.put(r10, r13);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L24
        monitor-enter(r13);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (r13.f2144a == false) goto L18;
        this.f2130b.a("lib was already loaded before: " + r10);     // Catch: Throwable -> L21
        monitor-exit(r13);     // Catch: Throwable -> L21
        return;
    L18:
        u(r10, r11);     // Catch: Throwable -> L21
        r13.f2144a = true;     // Catch: Throwable -> L21
        monitor-exit(r13);     // Catch: Throwable -> L21
        return;
    L7:
        if (r13.f2144a == false) goto L11;
        monitor-exit(r12);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
