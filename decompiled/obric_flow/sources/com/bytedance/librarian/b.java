package com.bytedance.librarian;

import ai.j0;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import lf.c;
import wc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f6775m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f6776n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f6777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f6778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f6779c;
    public final File d;
    public volatile boolean e;
    public File f;
    public ZipFile[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ApplicationInfo f6781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap f6782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String[] f6783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6784l;

    static {
        f6776n = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r5 = io.reactivex.exceptions.a.f17607c;
        io.reactivex.exceptions.a.f17607c = null;
        if (r5 == null) goto L27;
        ApplicationInfo r10 = r5.getApplicationInfo();
        File r11 = r5.getDir("librarian", 0);
        if (r11.exists() == true) goto L7;
        r11.mkdirs();
    L7:
        File r12 = new File(r10.sourceDir);
        StringBuilder r13 = j0.w("default.version", ".");
        r13.append(r12.lastModified() >> 8);
        File r14 = new File(r11, r13.toString());
        File[] r15 = r11.listFiles();
        if (r15 == null) goto L21;
        int r16 = r15.length;
        int r17 = 0;
    L10:
        if (r17 >= r16) goto L21;
        File r18 = r15[r17];
        if (r14.getName().equals(r18.getName()) == true) goto L20;
        File[] r19 = r18.listFiles();
        if (r19 == null) goto L19;
        int r20 = r19.length;
        int r110 = 0;
    L17:
        if (r110 >= r20) goto L19;
        r19[r110].delete();
        r110 = r110 + 1;
    L19:
        r18.delete();
    L20:
        r17 = r17 + 1;
    L21:
        r14.mkdirs();
        if (r14.exists() == false) goto L24;
        f6775m = new b(r10, r14, new f(6));
        return;
    L24:
        f6775m = null;
        return;
    L27:
        throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
    }

    public b(ApplicationInfo r5, File r10, f r11) {
        this.f6777a = r10;
        this.f6778b = r11;
        this.f6781i = r5;
        this.d = new File(r10, "process.lock");
        this.f6779c = new HashMap();
    }

    public final void a() {
        if (this.e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.e == true) goto L34;
        File r5 = new File(this.f6781i.sourceDir);     // Catch: Throwable -> L15
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L15
        r10.add(r5);     // Catch: Throwable -> L15
        String[] r11 = this.f6781i.splitSourceDirs;     // Catch: Throwable -> L15
        int r12 = 0;
        if (r11 != null) goto L11;
    L17:
        ZipFile[] r13 = new ZipFile[r10.size()];     // Catch: Throwable -> L15
        Iterator r14 = r10.iterator();     // Catch: Throwable -> L15
    L19:
        if (r14.hasNext() == false) goto L27;
        File r15 = (File) r14.next();     // Catch: Throwable -> L15
        int r16 = r12 + 1;
        r13[r12] = new ZipFile(r15);     // Catch: Throwable -> L15 IOException -> L24
    L26:
        r12 = r16;
    L24:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r15.getName(), e).printStackTrace();     // Catch: Throwable -> L15
        goto L26
    L27:
        this.g = r13;     // Catch: Throwable -> L15
        this.f = new File(this.f6781i.nativeLibraryDir);     // Catch: Throwable -> L15
        HashMap r17 = new HashMap();     // Catch: Throwable -> L15
        this.f6782j = r17;     // Catch: Throwable -> L15
        r17.put("arm64-v8a", "arm64");     // Catch: Throwable -> L15
        this.f6782j.put("armeabi-v7a", "arm");     // Catch: Throwable -> L15
        this.f6782j.put("armeabi", "arm");     // Catch: Throwable -> L15
        String r18 = null;
        Class<?> r19 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L15 Exception -> L31
        r18 = (String) r19.getDeclaredMethod("vmInstructionSet", null).invoke(r19.getDeclaredMethod("getRuntime", null).invoke(null, null), null);     // Catch: Throwable -> L15 Exception -> L31
    L33:
        this.f6780h = r18;     // Catch: Throwable -> L15
        f.g("vm instruction set: " + this.f6780h);     // Catch: Throwable -> L15
        this.f6783k = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L15
        this.e = true;     // Catch: Throwable -> L15
        goto L34
    L31:
        e = move-exception;
        Log.w("librarian", "fail to get vm instruction set", e);     // Catch: Throwable -> L15
        goto L33
    L11:
        if (r11.length == 0) goto L17;
        int r20 = r11.length;     // Catch: Throwable -> L15
        int r21 = 0;
    L13:
        if (r21 >= r20) goto L17;
        r10.add(new File(r11[r21]));     // Catch: Throwable -> L15
        r21 = r21 + 1;     // Catch: Throwable -> L15
    L34:
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    public final boolean b(File r13) {
        if (r13.exists() == true) goto L6;
        Log.w("librarian", "file is not exist: " + r13.getPath());
        return false;
    L6:
        d(r13.getName());
        String r5 = "lib/" + this.f6784l + "/" + r13.getName();
        ZipFile[] r10 = this.g;
        int r11 = r10.length;
        int r12 = 0;
    L7:
        long r14 = 0;
        if (r12 >= r11) goto L13;
        ZipEntry r15 = r10[r12].getEntry(r5);
        if (r15 != null) goto L11;
        r12 = r12 + 1;
        goto L7
    L11:
        long r16 = r15.getCrc();
    L14:
        byte[] r17 = new byte[8192];
        Closeable r18 = null;
        CheckedInputStream r19 = new CheckedInputStream(new FileInputStream(r13), new CRC32());     // Catch: Throwable -> L24 IOException -> L26
    L40:
    L22:
        e = e;
        r18 = r19;
    L27:
        Log.w("librarian", "fail to check sum for " + r13.getPath(), e);     // Catch: Throwable -> L24
        c(r18);
    L30:
        if (r16 != r14) goto L33;
        f.g(r5 + " compare crc ok: entry is " + r16 + ", file is " + r14);
        return true;
    L33:
        Log.w("librarian", r5 + " crc is wrong: entry is " + r16 + ", file is " + r14);
        return false;
    L20:
        th = th;
        r18 = r19;
    L35:
        c(r18);
        throw th;
    L17:
        if (r19.read(r17) >= 0) goto L40;
        r14 = r19.getChecksum().getValue();     // Catch: Throwable -> L20 IOException -> L22
        c(r19);
        goto L30
    L26:
        e = e;
    L24:
        th = th;
        goto L35
    L13:
        r16 = 0;
        goto L14
    }

    public final void c(Closeable r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        r5.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Log.w("librarian", "failed to close resource", e);
    }

    public final void d(String r11) {
        if (this.f6784l == null) goto L5;
        return;
    L5:
        String[] r5 = this.f6783k;
        int r10 = r5.length;
        int r12 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L25;
        String r14 = r5[r13];
        if (this.f6780h != null) goto L10;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L24;
        String r16 = androidx.constraintlayout.motion.widget.a.p("lib/", r14, "/", r11);
        ZipFile[] r17 = this.g;
        int r18 = r17.length;
        int r19 = 0;
    L18:
        if (r19 >= r18) goto L24;
        if (r17[r19].getEntry(r16) != null) goto L21;
        r19 = r19 + 1;
        goto L18
    L21:
        this.f6784l = r14;
        f.g("ensure that abi is " + r14);
        return;
    L24:
        r13 = r13 + 1;
        goto L6
    L10:
        String r20 = (String) this.f6782j.get(r14);
        String r21 = this.f6780h;
        if (r20 != null) goto L14;
        r20 = r14;
    L14:
        r15 = r21.equals(r20);
        goto L15
    L25:
        StringBuilder r110 = j0.x("can not ensure abi for ", r11, ", check ");
        r110.append(this.f6780h);
        r110.append(", apks ");
        StringBuilder r22 = new StringBuilder("[");
        ZipFile[] r111 = this.g;
        int r23 = r111.length;
    L26:
        if (r12 >= r23) goto L28;
        ZipFile r24 = r111[r12];
        String r25 = r24.getName();
        File r26 = new File(r25);
        r22.append(r25);
        r22.append("#");
        r22.append(r24.size());
        r22.append(":");
        r22.append(r26.length());
        r22.append(" ");
        r12 = r12 + 1;
        goto L26
    L28:
        r22.append("]");
        r110.append(r22.toString());
        throw new LibrarianUnsatisfiedLinkError(r110.toString());
    }

    public final boolean e(File r10) {
        d(r10.getName());
        String r5 = "lib/" + this.f6784l + "/" + r10.getName();
        ZipFile[] r11 = this.g;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L14;
        ZipFile r14 = r11[r13];
        ZipEntry r15 = r14.getEntry(r5);
        if (r15 != null) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        InputStream r16 = r14.getInputStream(r15);
        g(r10, r16);     // Catch: Throwable -> L11
        f.g("get lib file " + r10.getPath() + " from " + r5 + " of " + r14.getName());     // Catch: Throwable -> L11
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
        HashMap r5 = this.f6779c;
        monitor-enter(r5);
        a r10 = (a) this.f6779c.get(r11);     // Catch: Throwable -> L10
        if (r10 != null) goto L7;
        r10 = new a();     // Catch: Throwable -> L10
        r10.f6774a = false;     // Catch: Throwable -> L10
        this.f6779c.put(r11, r10);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L10
        monitor-enter(r10);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (r10.f6774a == false) goto L22;
        f.g("lib was already loaded before: " + r11);     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L22:
        File r12 = new File(this.f6777a, "lib" + r11 + ".so");     // Catch: Throwable -> L20
        boolean r13 = r12.exists();     // Catch: Throwable -> L20
        if (r13 == false) goto L28;
        System.load(r12.getPath());     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L26
    L29:
        f.g("lib is loaded: " + r11);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L26
        r10.f6774a = true;     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L26
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L28:
        System.loadLibrary(r11);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L26
    L26:
        e = move-exception;
        Log.w("librarian", "fail to load " + r12.getName() + ", out lib exists: " + r13, e);     // Catch: Throwable -> L20
        a();     // Catch: Throwable -> L20
        if (r13 == true) goto L51;
        File r14 = new File(this.f, "lib" + r11 + ".so");     // Catch: Throwable -> L20
        if (b(r14) == true) goto L50;
        File r15 = this.d;     // Catch: Throwable -> L20
        z4.a r16 = new z4.a();     // Catch: Throwable -> L20
        r16.e = this;     // Catch: Throwable -> L20
        r16.d = r15;     // Catch: Throwable -> L20
        r16.h();     // Catch: Throwable -> L43 IOException -> L45
        if (e(r12) == false) goto L42;
        r16.g();     // Catch: Throwable -> L20
        goto L51
    L42:
        throw new LibrarianUnsatisfiedLinkError("fail to find " + r11);     // Catch: Throwable -> L43 IOException -> L45
    L43:
        th = move-exception;
        r16.g();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L45:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r11, e);     // Catch: Throwable -> L43
    L50:
        r12 = r14;
    L51:
        Closeable r17 = null;
        c r18 = new c(r12);     // Catch: Throwable -> L77
        List r19 = r18.b();     // Catch: Throwable -> L75
        Collections.sort(r19);     // Catch: Throwable -> L75
        c(r18);     // Catch: Throwable -> L20 IOException -> L66
        Iterator r20 = r19.iterator();     // Catch: Throwable -> L20 IOException -> L66
    L56:
        if (r20.hasNext() == false) goto L94;
        String r21 = (String) r20.next();     // Catch: Throwable -> L20 IOException -> L66
        String r22 = r21.substring(3, r21.length() - 3);     // Catch: Throwable -> L20 IOException -> L66
        String[] r23 = f6776n;     // Catch: Throwable -> L20 IOException -> L66
        int r24 = 0;
    L59:
        if (r24 >= 14) goto L64;
        if (r23[r24].equals(r22) == true) goto L56;
        r24 = r24 + 1;     // Catch: Throwable -> L20 IOException -> L66
        goto L59
    L64:
        f.g("to load depended lib " + r22);     // Catch: Throwable -> L20 IOException -> L66
        f(r22);     // Catch: Throwable -> L20 IOException -> L66
        goto L56
    L94:
        System.load(r12.getPath());     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L72
        f.g("loaded the lib " + r11);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L72
        r10.f6774a = true;     // Catch: Throwable -> L20
        return;
    L72:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r12.getPath(), e);     // Catch: Throwable -> L20
    L75:
        th = th;
        r17 = r18;
    L78:
        c(r17);     // Catch: Throwable -> L20 IOException -> L66
        throw th;     // Catch: Throwable -> L20 IOException -> L66
    L77:
        th = th;
    L66:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);     // Catch: Throwable -> L20
    L7:
        if (r10.f6774a == false) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void g(File r10, InputStream r11) {
        File r5 = File.createTempFile("tmp-", r10.getName(), r10.getParentFile());
        f.g("extracting " + r5.getPath());
        FileOutputStream r12 = new FileOutputStream(r5);
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L7
        int r14 = r11.read(r13);     // Catch: Throwable -> L7
    L5:
        if (r14 == (-1)) goto L10;
        r12.write(r13, 0, r14);     // Catch: Throwable -> L7
        r14 = r11.read(r13);     // Catch: Throwable -> L7
        goto L5
    L10:
        if (r5.setReadOnly() == false) goto L18;
        f.g("renaming to " + r10.getPath());     // Catch: Throwable -> L7
        if (r5.renameTo(r10) == false) goto L16;
        c(r12);
        r5.delete();
        return;
    L16:
        throw new IOException("failed to rename \"" + r5.getAbsolutePath() + "\" to \"" + r10.getAbsolutePath() + "\"");     // Catch: Throwable -> L7
    L18:
        throw new IOException("failed to mark readonly \"" + r5.getAbsolutePath() + "\" (tmp of \"" + r10.getAbsolutePath() + "\")");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        c(r12);
        r5.delete();
        throw th;
    }
}
