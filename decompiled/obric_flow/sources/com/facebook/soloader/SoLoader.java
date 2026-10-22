package com.facebook.soloader;

import ai.j0;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.StrictMode;
import android.util.Log;
import androidx.constraintlayout.motion.widget.a;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.lynx.tasm.utils.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class SoLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f8478a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SoFileLoader f8479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantReadWriteLock f8480c = null;
    public static volatile SoSource[] d;
    public static final AtomicInteger e = null;
    public static ApplicationSoSource f;
    public static final String[] g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f8481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f8482i;

    static {
        f8480c = new ReentrantReadWriteLock();
        d = null;
        e = new AtomicInteger(0);
        new HashSet();
        new HashMap();
        Collections.newSetFromMap(new ConcurrentHashMap());
        g = new String[]{System.mapLibraryName("breakpad")};
        f8482i = 0;
        f8478a = true;
    }

    public static void a(Context r10, int r11, String[] r12) {
        if (d == null) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r5 = f8480c;
        r5.writeLock().lock();
        if (d == null) goto L63;
        r5.writeLock().unlock();
        return;
    L63:
        f8481h = r11;     // Catch: Throwable -> L17
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L17
        a(r13, r12);     // Catch: Throwable -> L17
        int r14 = 0;
        if (r10 != null) goto L13;
    L33:
        SoSource[] r15 = (SoSource[]) r13.toArray(new SoSource[r13.size()]);     // Catch: Throwable -> L17
        r5.writeLock().lock();     // Catch: Throwable -> L17
    L36:
        if ((f8481h & 2) == 0) goto L38;
        r14 = 1;
    L38:
        r5.writeLock().unlock();     // Catch: Throwable -> L17
        int r16 = r15.length;     // Catch: Throwable -> L17
    L39:
        int r17 = r16 - 1;     // Catch: Throwable -> L17
        if (r16 <= 0) goto L51;
        if (Log.isLoggable("SoLoader", 3) == false) goto L44;
        Log.d("SoLoader", "Preparing SO source: " + r15[r17]);     // Catch: Throwable -> L17
    L44:
        boolean r18 = f8478a;     // Catch: Throwable -> L17
        if (r18 == false) goto L47;
        Api18TraceUtils.a(r15[r17].getClass().getSimpleName());     // Catch: Throwable -> L17
    L47:
        r15[r17].a(r14);     // Catch: Throwable -> L17
        if (r18 == false) goto L50;
        Api18TraceUtils.a();     // Catch: Throwable -> L17
    L50:
        r16 = r17;
        goto L39
    L51:
        d = r15;     // Catch: Throwable -> L17
        e.getAndIncrement();     // Catch: Throwable -> L17
        if (Log.isLoggable("SoLoader", 3) == false) goto L54;
        Log.d("SoLoader", "init finish: " + d.length + " SO sources prepared");     // Catch: Throwable -> L17
    L54:
        f8480c.writeLock().unlock();
        return;
    L56:
        th = move-exception;
        f8480c.writeLock().unlock();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L13:
        if ((r11 & 1) == 0) goto L21;
        if (Log.isLoggable("SoLoader", 3) == false) goto L19;
        Log.d("SoLoader", "adding exo package source: lib-main");     // Catch: Throwable -> L17
    L19:
        r13.add(0, new ExoSoSource(r10));     // Catch: Throwable -> L17
        goto L33
    L21:
        if ((r11 & 64) == 0) goto L23;
        b(r10, r13);     // Catch: Throwable -> L17
    L23:
        int r19 = f8482i;     // Catch: Throwable -> L17
        if (r19 == 1) goto L31;
        if (r19 == 2) goto L30;
        if (r19 == 3) goto L30;
        throw new RuntimeException("Unsupported app type, we should not reach here");     // Catch: Throwable -> L17
    L30:
        int r20 = 1;
    L32:
        a(r10, r13, r20);     // Catch: Throwable -> L17
        a(r10, r13);     // Catch: Throwable -> L17
        goto L33
    L31:
        r20 = 0;
    L17:
        th = move-exception;
        f8480c.writeLock().unlock();
        throw th;
    }

    public static void b(Context r10, ArrayList r11) {
        if (r10.getApplicationInfo().splitSourceDirs != null) goto L5;
    L13:
        DirectApkSoSource r5 = new DirectApkSoSource(r10);
        if (Log.isLoggable("SoLoader", 3) == false) goto L16;
        Log.d("SoLoader", "adding directApk source: " + r5.toString());
    L16:
        r11.add(0, r5);
        return;
    L5:
        if (Log.isLoggable("SoLoader", 3) == false) goto L7;
        Log.d("SoLoader", "adding directApk sources from split apks");
    L7:
        String[] r12 = r10.getApplicationInfo().splitSourceDirs;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        DirectApkSoSource r15 = new DirectApkSoSource(new File(r12[r14]));
        if (Log.isLoggable("SoLoader", 3) == false) goto L12;
        Log.d("SoLoader", "adding directApk source: " + r15.toString());
    L12:
        r11.add(0, r15);
        r14 = r14 + 1;
        goto L8
    }

    public static void init(Context r5, int r10) {
        String[] r11 = g;
        boolean r12 = true;
        if (d != null) goto L11;
        ReentrantReadWriteLock r13 = f8480c;
        r13.readLock().lock();
        if (d != null) goto L10;
        r12 = false;
    L10:
        r13.readLock().unlock();
    L37:
        th = move-exception;
        f8480c.readLock().unlock();
        throw th;
    L11:
        if (r12 == false) goto L13;
        return;
    L13:
        StrictMode.ThreadPolicy r14 = StrictMode.allowThreadDiskWrites();
        int r15 = a(r5, r10);     // Catch: Throwable -> L19
        f8482i = r15;     // Catch: Throwable -> L19
        if ((r10 & 128) == 0) goto L17;
    L21:
        a();     // Catch: Throwable -> L19
        a(r5, r10, r11);     // Catch: Throwable -> L19
        NativeLoaderToSoLoaderDelegate r16 = new NativeLoaderToSoLoaderDelegate();     // Catch: Throwable -> L19
        monitor-enter(NativeLoader.class);     // Catch: Throwable -> L19
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L24:
        if (NativeLoader.a() == true) goto L30;
        NativeLoader.a(r16);     // Catch: Throwable -> L28
        monitor-exit(NativeLoader.class);     // Catch: Throwable -> L28
    L31:
        StrictMode.setThreadPolicy(r14);
        return;
    L30:
        monitor-exit(NativeLoader.class);     // Catch: Throwable -> L19
        goto L31
    L17:
        if (SysUtil.MarshmallowSysdeps.a(r5, r15) == false) goto L21;
        r10 = r10 | 72;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        StrictMode.setThreadPolicy(r14);
        throw th;
    }

    public static void a(Context r5, ArrayList r10, int r11) {
        f = new ApplicationSoSource(r5, r11);
        if (Log.isLoggable("SoLoader", 3) == false) goto L5;
        Log.d("SoLoader", "adding application source: " + f.f8460b.toString());
    L5:
        r10.add(0, f);
    }

    public static void a(Context r12, ArrayList r13) {
        if ((f8481h & 8) == 0) goto L10;
        File r14 = new File(j0.q(new StringBuilder(), r12.getApplicationInfo().dataDir, "/lib-main"));
        SysUtil.a(r14);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        Log.w("SoLoader", "Failed to delete " + r14.getCanonicalPath(), e);
        return;
    L10:
        File r5 = new File(r12.getApplicationInfo().sourceDir);
        ArrayList r10 = new ArrayList();
        ApkSoSource r11 = new ApkSoSource(r12, r5, "lib-main");
        r10.add(r11);
        if (Log.isLoggable("SoLoader", 3) == false) goto L14;
        Log.d("SoLoader", "adding backup source from : " + r11.toString());
    L14:
        if (r12.getApplicationInfo().splitSourceDirs != null) goto L16;
    L24:
        UnpackingSoSource[] r15 = (UnpackingSoSource[]) r10.toArray(new UnpackingSoSource[r10.size()]);
        r13.addAll(0, r10);
        return;
    L16:
        if (Log.isLoggable("SoLoader", 3) == false) goto L18;
        Log.d("SoLoader", "adding backup sources from split apks");
    L18:
        String[] r16 = r12.getApplicationInfo().splitSourceDirs;
        int r17 = r16.length;
        int r18 = 0;
        int r19 = 0;
    L19:
        if (r18 >= r17) goto L24;
        File r110 = new File(r16[r18]);
        StringBuilder r20 = new StringBuilder("lib-");
        int r111 = r19 + 1;
        r20.append(r19);
        ApkSoSource r21 = new ApkSoSource(r12, r110, r20.toString());
        if (Log.isLoggable("SoLoader", 3) == false) goto L23;
        Log.d("SoLoader", "adding backup source: " + r21.toString());
    L23:
        r10.add(r21);
        r18 = r18 + 1;
        r19 = r111;
        goto L19
    }

    public static void a(ArrayList r5, String[] r10) {
        if (SysUtil.b() == false) goto L5;
        String r11 = "/system/lib64:/vendor/lib64";
    L6:
        String r12 = System.getenv("LD_LIBRARY_PATH");
        if (r12 != null) goto L9;
    L11:
        Iterator r13 = new HashSet(Arrays.asList(r11.split(":"))).iterator();
    L13:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        if (Log.isLoggable("SoLoader", 3) == false) goto L17;
        a.A("adding system library source: ", r14, "SoLoader");
    L17:
        r5.add(new DirectorySoSource(new File(r14), r10));
        goto L13
    L18:
        return;
    L9:
        if (r12.equals("") == true) goto L11;
        r11 = k.j(r11, ":", r12);
        goto L11
    L5:
        r11 = "/system/lib:/vendor/lib";
        goto L6
    }

    public static synchronized void a() {
        monitor-enter(SoLoader.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f8479b == null) goto L8;
        monitor-exit(SoLoader.class);
        return;
    L8:
        Runtime.getRuntime();     // Catch: Throwable -> L11
        f8479b = new AnonymousClass1();     // Catch: Throwable -> L11
        monitor-exit(SoLoader.class);
    }

    public static int a(Context r5, int r10) {
        int r11 = f8482i;
        if (r11 == 0) goto L5;
        return r11;
    L5:
        int r12 = 1;
        if ((r10 & 32) != 0) goto L19;
        if (r5 == null) goto L19;
        ApplicationInfo r13 = r5.getApplicationInfo();
        int r14 = r13.flags;
        if ((r14 & 1) == 0) goto L17;
        if ((r14 & 128) == 0) goto L15;
        r12 = 3;
        goto L17
    L15:
        r12 = 2;
    L17:
        if (Log.isLoggable("SoLoader", 3) == false) goto L19;
        Log.d("SoLoader", "ApplicationInfo.flags is: " + r13.flags + " appType is: " + r12);
    L19:
        return r12;
    }
}
