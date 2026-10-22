package y7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import y0.d;
import z7.i;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f14041m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f14042n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f14043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f14044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f14045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f14046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f14047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public File f14048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ZipFile[] f14049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ApplicationInfo f14051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap f14052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String[] f14053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f14054l;

    /* JADX INFO: renamed from: y7.a$a, reason: collision with other inner class name */
    public static class C0199a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14055a;

        public C0199a() {
            this.f14055a = false;
        }

        public final String toString() {
            return Boolean.toString(this.f14055a);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RandomAccessFile f14056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FileLock f14057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FileChannel f14058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File f14059d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f14060e;

        public b(a r8, File r10) {
            this.f14060e = r8;
            this.f14059d = r10;
        }

        public final void a() {
            FileLock r8 = this.f14057b;
            if (r8 != null) goto L8;
        L5:
            a r10 = this.f14060e;
            d r11 = r10.f14044b;
            String r12 = "released lock " + this.f14059d.getPath();
            r11.getClass();
            d.e(r12);
            r10.c(this.f14058c);
            r10.c(this.f14056a);
            return;
        L8:
            r8.release();     // Catch: IOException -> L7
            goto L5
        }

        public final void b() {
            a r8 = this.f14060e;
            File r10 = this.f14059d;
            RandomAccessFile r11 = new RandomAccessFile(r10, "rw");
            this.f14056a = r11;
            this.f14058c = r11.getChannel();     // Catch: IOException -> L10
            d r12 = r8.f14044b;     // Catch: IOException -> L7
            String r13 = "blocking on lock " + r10.getPath();     // Catch: IOException -> L7
            r12.getClass();     // Catch: IOException -> L7
            d.e(r13);     // Catch: IOException -> L7
            this.f14057b = this.f14058c.lock();     // Catch: IOException -> L7
            d r14 = r8.f14044b;     // Catch: IOException -> L10
            String r15 = "acquired on lock " + r10.getPath();     // Catch: IOException -> L10
            r14.getClass();     // Catch: IOException -> L10
            d.e(r15);     // Catch: IOException -> L10
            return;
        L7:
            e = move-exception;
            r8.c(this.f14058c);     // Catch: IOException -> L10
            throw e;     // Catch: IOException -> L10
        L10:
            e = move-exception;
            r8.c(this.f14056a);
            throw e;
        }
    }

    static {
        f14042n = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r8 = d.f13904a;
        a r10 = null;
        d.f13904a = null;
        if (r8 == null) goto L27;
        ApplicationInfo r11 = r8.getApplicationInfo();
        File r12 = r8.getDir("librarian", 0);
        if (r12.exists() == true) goto L7;
        r12.mkdirs();
    L7:
        File r13 = new File(r11.sourceDir);
        StringBuilder r14 = android.aimedia.a.k("default.version", ".");
        r14.append(r13.lastModified() >> 8);
        File r15 = new File(r12, r14.toString());
        File[] r16 = r12.listFiles();
        if (r16 == null) goto L21;
        int r17 = r16.length;
        int r18 = 0;
    L10:
        if (r18 >= r17) goto L21;
        File r19 = r16[r18];
        if (r15.getName().equals(r19.getName()) == true) goto L20;
        File[] r20 = r19.listFiles();
        if (r20 == null) goto L19;
        int r21 = r20.length;
        int r110 = 0;
    L17:
        if (r110 >= r21) goto L19;
        r20[r110].delete();
        r110 = r110 + 1;
    L19:
        r19.delete();
    L20:
        r18 = r18 + 1;
    L21:
        r15.mkdirs();
        if (r15.exists() == false) goto L24;
        r10 = new a(r11, r15, new d());
    L24:
        f14041m = r10;
        return;
    L27:
        throw new y7.b("you should call init first or use loadLibraryForModule.");
    }

    public a(ApplicationInfo r8, File r10, d r11) {
        this.f14043a = r10;
        this.f14044b = r11;
        this.f14051i = r8;
        this.f14046d = new File(r10, "process.lock");
        this.f14045c = new HashMap();
    }

    public final void a() {
        if (this.f14047e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L7:
        if (this.f14047e == true) goto L32;
        File r8 = new File(this.f14051i.sourceDir);     // Catch: Throwable -> L34
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L34
        r10.add(r8);     // Catch: Throwable -> L34
        String[] r11 = this.f14051i.splitSourceDirs;     // Catch: Throwable -> L34
        if (r11 != null) goto L11;
    L15:
        ZipFile[] r12 = new ZipFile[r10.size()];     // Catch: Throwable -> L34
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L34
        int r14 = 0;
    L17:
        if (r13.hasNext() == false) goto L25;
        File r15 = (File) r13.next();     // Catch: Throwable -> L34
        int r16 = r14 + 1;
        r12[r14] = new ZipFile(r15);     // Catch: IOException -> L22 Throwable -> L34
    L24:
        r14 = r16;
    L22:
        e = move-exception;
        new y7.b("fail to get zip file " + r15.getName(), e).printStackTrace();     // Catch: Throwable -> L34
        goto L24
    L25:
        this.f14049g = r12;     // Catch: Throwable -> L34
        this.f14048f = new File(this.f14051i.nativeLibraryDir);     // Catch: Throwable -> L34
        HashMap r17 = new HashMap();     // Catch: Throwable -> L34
        this.f14052j = r17;     // Catch: Throwable -> L34
        r17.put("arm64-v8a", "arm64");     // Catch: Throwable -> L34
        this.f14052j.put("armeabi-v7a", "arm");     // Catch: Throwable -> L34
        this.f14052j.put("armeabi", "arm");     // Catch: Throwable -> L34
        String r18 = null;
        Class<?> r19 = Class.forName("dalvik.system.VMRuntime");     // Catch: Exception -> L29 Throwable -> L34
        r18 = (String) r19.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r19.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L29 Throwable -> L34
    L31:
        this.f14050h = r18;     // Catch: Throwable -> L34
        d r20 = this.f14044b;     // Catch: Throwable -> L34
        String r21 = "vm instruction set: " + this.f14050h;     // Catch: Throwable -> L34
        r20.getClass();     // Catch: Throwable -> L34
        d.e(r21);     // Catch: Throwable -> L34
        this.f14053k = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L34
        this.f14047e = true;     // Catch: Throwable -> L34
        goto L32
    L29:
        e = move-exception;
        this.f14044b.getClass();     // Catch: Throwable -> L34
        Log.w("librarian", "fail to get vm instruction set", e);     // Catch: Throwable -> L34
        goto L31
    L11:
        if (r11.length == 0) goto L15;
        int r22 = r11.length;     // Catch: Throwable -> L34
        int r23 = 0;
    L13:
        if (r23 >= r22) goto L15;
        r10.add(new File(r11[r23]));     // Catch: Throwable -> L34
        r23 = r23 + 1;     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);     // Catch: Throwable -> L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.StringBuilder] */
    public final boolean b(File r13) {
        boolean r8 = r13.exists();
        d r10 = this.f14044b;
        if (r8 == true) goto L5;
        StringBuilder this = new StringBuilder("file is not exist: ");
        this.append(r13.getPath());
    L31:
        String r12 = this.toString();
        r10.getClass();
        d.f(r12);
        return false;
    L5:
        d(r13.getName());
        String r11 = "lib/" + this.f14054l + "/" + r13.getName();
        ZipFile[] r14 = this.f14049g;
        int r15 = r14.length;
        int r16 = 0;
    L6:
        long r17 = 0;
        if (r16 >= r15) goto L12;
        ZipEntry r18 = r14[r16].getEntry(r11);
        if (r18 != null) goto L10;
        r16 = r16 + 1;
        goto L6
    L10:
        long r19 = r18.getCrc();
    L13:
        byte[] r20 = new byte[8192];
        CheckedInputStream r21 = null;
        CheckedInputStream r22 = null;
        CheckedInputStream r23 = new CheckedInputStream(new FileInputStream(r13), new CRC32());     // Catch: IOException -> L23 Throwable -> L33
    L41:
        int r24 = r23.read(r20);     // Catch: Throwable -> L19 IOException -> L21
        if (r24 >= 0) goto L41;
        r17 = r23.getChecksum().getValue();     // Catch: Throwable -> L19 IOException -> L21
        c(r23);
        r21 = r24;
    L27:
        if (r19 != r17) goto L30;
        r10.getClass();
        d.e(r11 + " compare crc ok: entry is " + r19 + ", file is " + r17);
        return true;
    L30:
        this = new StringBuilder();
        this.append(r11);
        this.append(" crc is wrong: entry is ");
        this.append(r19);
        this.append(", file is ");
        this.append(r17);
        goto L31
    L21:
        e = e;
        r22 = r23;
    L24:
        String r110 = "fail to check sum for " + r13.getPath();     // Catch: Throwable -> L33
        r10.getClass();     // Catch: Throwable -> L33
        Log.w("librarian", r110, e);     // Catch: Throwable -> L33
        c(r22);
        r21 = r22;
    L19:
        th = th;
    L35:
        this.c(r23);
        throw th;
    L33:
        th = th;
        r23 = r21;
    L23:
        e = e;
        goto L24
    L12:
        r19 = 0;
        goto L13
    }

    public final void c(Closeable r8) {
        if (r8 != null) goto L9;
        return;
    L9:
        r8.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.f14044b.getClass();
        Log.w("librarian", "failed to close resource", e);
    }

    public final void d(String r11) {
        if (this.f14054l == null) goto L5;
        return;
    L5:
        String[] r8 = this.f14053k;
        int r10 = r8.length;
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L25;
        String r14 = r8[r13];
        if (this.f14050h != null) goto L10;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L24;
        String r16 = defpackage.b.e("lib/", r14, "/", r11);
        ZipFile[] r17 = this.f14049g;
        int r18 = r17.length;
        int r19 = 0;
    L18:
        if (r19 >= r18) goto L24;
        if (r17[r19].getEntry(r16) != null) goto L21;
        r19 = r19 + 1;
        goto L18
    L21:
        this.f14054l = r14;
        String r110 = defpackage.b.c("ensure that abi is ", r14);
        this.f14044b.getClass();
        d.e(r110);
        return;
    L24:
        r13 = r13 + 1;
        goto L6
    L10:
        String r20 = (String) this.f14052j.get(r14);
        String r21 = this.f14050h;
        if (r20 != null) goto L14;
        r20 = r14;
    L14:
        r15 = r21.equals(r20);
        goto L15
    L25:
        StringBuilder r111 = defpackage.b.h("can not ensure abi for ", r11, ", check ");
        r111.append(this.f14050h);
        r111.append(", apks ");
        StringBuilder r22 = new StringBuilder("[");
        ZipFile[] r112 = this.f14049g;
        int r23 = r112.length;
    L26:
        if (r12 >= r23) goto L28;
        ZipFile r24 = r112[r12];
        String r25 = r24.getName();
        File r26 = new File(r25);
        r22.append(r25);
        r22.append("#");
        r22.append(r24.size());
        r22.append(BdimCategoryConstants.SEPARATOR_COLON);
        r22.append(r26.length());
        r22.append(" ");
        r12 = r12 + 1;
        goto L26
    L28:
        r22.append("]");
        r111.append(r22.toString());
        throw new y7.b(r111.toString());
    }

    public final boolean e(File r8) {
        d(r8.getName());
        String r10 = "lib/" + this.f14054l + "/" + r8.getName();
        ZipFile[] r11 = this.f14049g;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L14;
        ZipFile r14 = r11[r13];
        ZipEntry r15 = r14.getEntry(r10);
        if (r15 != null) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        InputStream r16 = r14.getInputStream(r15);
        g(r16, r8);     // Catch: Throwable -> L11
        d r17 = this.f14044b;     // Catch: Throwable -> L11
        String r18 = "get lib file " + r8.getPath() + " from " + r10 + " of " + r14.getName();     // Catch: Throwable -> L11
        r17.getClass();     // Catch: Throwable -> L11
        d.e(r18);     // Catch: Throwable -> L11
        c(r16);
        return true;
    L11:
        th = move-exception;
        c(r16);
        throw th;
    L14:
        return false;
    }

    public final void f(String r11) {
        HashMap r8 = this.f14045c;
        monitor-enter(r8);
        C0199a r10 = (C0199a) this.f14045c.get(r11);     // Catch: Throwable -> L81
        if (r10 != null) goto L7;
        r10 = new C0199a();     // Catch: Throwable -> L81
        this.f14045c.put(r11, r10);     // Catch: Throwable -> L81
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L81
        monitor-enter(r10);
    L78:
        th = move-exception;
        throw th;
    L14:
        if (r10.f14055a == false) goto L18;
        this.f14044b.getClass();     // Catch: Throwable -> L78
        d.e("lib was already loaded before: " + r11);     // Catch: Throwable -> L78
        monitor-exit(r10);     // Catch: Throwable -> L78
        return;
    L18:
        File r12 = new File(this.f14043a, "lib" + r11 + ".so");     // Catch: Throwable -> L78
        boolean r13 = r12.exists();     // Catch: Throwable -> L78
        if (r13 == false) goto L22;
        d r14 = this.f14044b;     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
        String r15 = r12.getPath();     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
        r14.getClass();     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
        System.load(r15);     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
    L23:
        this.f14044b.getClass();     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
        d.e("lib is loaded: " + r11);     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
        r10.f14055a = true;     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
        monitor-exit(r10);     // Catch: Throwable -> L78
        return;
    L22:
        this.f14044b.getClass();     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
        System.loadLibrary(r11);     // Catch: UnsatisfiedLinkError -> L26 Throwable -> L78
    L26:
        e = move-exception;
        d r16 = this.f14044b;     // Catch: Throwable -> L78
        String r17 = "fail to load " + r12.getName() + ", out lib exists: " + r13;     // Catch: Throwable -> L78
        r16.getClass();     // Catch: Throwable -> L78
        Log.w("librarian", r17, e);     // Catch: Throwable -> L78
        a();     // Catch: Throwable -> L78
        if (r13 == true) goto L89;
        File r18 = new File(this.f14048f, "lib" + r11 + ".so");     // Catch: Throwable -> L78
        if (b(r18) == true) goto L45;
        b r19 = new b(this, this.f14046d);     // Catch: Throwable -> L78
        r19.b();     // Catch: Throwable -> L38 IOException -> L40
        if (e(r12) == false) goto L37;
        r19.a();     // Catch: Throwable -> L78
        goto L89
    L37:
        throw new y7.b("fail to find " + r11);     // Catch: Throwable -> L38 IOException -> L40
    L40:
        e = move-exception;
        throw new y7.b("fail to extract " + r11, e);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r19.a();     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L45:
        r12 = r18;
    L89:
        i r20 = new i(r12);     // Catch: Throwable -> L72
        List<String> r21 = r20.a();     // Catch: Throwable -> L70
        Collections.sort(r21);     // Catch: Throwable -> L70
        c(r20);     // Catch: IOException -> L61 Throwable -> L78
        Iterator<String> r22 = r21.iterator();     // Catch: IOException -> L61 Throwable -> L78
    L50:
        if (r22.hasNext() == false) goto L85;
        String r23 = r22.next();     // Catch: IOException -> L61 Throwable -> L78
        String r24 = r23.substring(3, r23.length() - 3);     // Catch: IOException -> L61 Throwable -> L78
        String[] r25 = f14042n;     // Catch: IOException -> L61 Throwable -> L78
        boolean r26 = false;
        int r27 = 0;
    L53:
        if (r27 >= 14) goto L58;
        if (r25[r27].equals(r24) == true) goto L56;
        r27 = r27 + 1;     // Catch: IOException -> L61 Throwable -> L78
        goto L53
    L56:
        r26 = true;
    L58:
        if (r26 == true) goto L50;
        this.f14044b.getClass();     // Catch: IOException -> L61 Throwable -> L78
        d.e("to load depended lib " + r24);     // Catch: IOException -> L61 Throwable -> L78
        f(r24);     // Catch: IOException -> L61 Throwable -> L78
        goto L50
    L85:
        d r28 = this.f14044b;     // Catch: UnsatisfiedLinkError -> L67 Throwable -> L78
        String r29 = r12.getPath();     // Catch: UnsatisfiedLinkError -> L67 Throwable -> L78
        r28.getClass();     // Catch: UnsatisfiedLinkError -> L67 Throwable -> L78
        System.load(r29);     // Catch: UnsatisfiedLinkError -> L67 Throwable -> L78
        this.f14044b.getClass();     // Catch: UnsatisfiedLinkError -> L67 Throwable -> L78
        d.e("loaded the lib " + r11);     // Catch: UnsatisfiedLinkError -> L67 Throwable -> L78
        r10.f14055a = true;     // Catch: Throwable -> L78
        return;
    L67:
        e = move-exception;
        throw new y7.b("finally fail to load " + r12.getPath(), e);     // Catch: Throwable -> L78
    L70:
        th = th;
    L74:
        c(r20);     // Catch: IOException -> L61 Throwable -> L78
        throw th;     // Catch: IOException -> L61 Throwable -> L78
    L61:
        e = move-exception;
        throw new y7.b("fail to load depended lib", e);     // Catch: Throwable -> L78
    L72:
        th = th;
        r20 = null;
        goto L74
    L7:
        if (r10.f14055a == false) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L81
        return;
    L81:
        th = move-exception;
        throw th;
    }

    public final void g(InputStream r8, File r10) {
        File r11 = File.createTempFile("tmp-", r10.getName(), r10.getParentFile());
        String r12 = "extracting " + r11.getPath();
        this.f14044b.getClass();
        d.e(r12);
        FileOutputStream r13 = new FileOutputStream(r11);
        byte[] r14 = new byte[8192];     // Catch: Throwable -> L17
    L4:
        int r15 = r8.read(r14);     // Catch: Throwable -> L17
        if (r15 == (-1)) goto L8;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L17
        goto L4
    L8:
        if (r11.setReadOnly() == false) goto L16;
        d.e("renaming to " + r10.getPath());     // Catch: Throwable -> L17
        if (r11.renameTo(r10) == false) goto L14;
        c(r13);
        r11.delete();
        return;
    L14:
        throw new IOException("failed to rename \"" + r11.getAbsolutePath() + "\" to \"" + r10.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r11.getAbsolutePath() + "\" (tmp of \"" + r10.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        c(r13);
        r11.delete();
        throw th;
    }
}
