package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import swb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final a a = null;
    public static final ConcurrentHashMap<String, b> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new ConcurrentHashMap();
    }

    public static VFSFile a(ChameleonConfig r4, Context r5) {
        VFSFiles.b.getClass();
        boolean r0 = true;
        h r1 = VFSFiles.b(true);
        String r2 = c.c(r4).getVfsPath().getRealPath();
        StringBuilder r3 = new StringBuilder(n.a(r5));
        r3.append("-");
        if (r4 == null) goto L8;
        ResConfig r6 = r4.getResConfig();
        if (r6 == null) goto L8;
        String r7 = r6.getOfflineZipName();
        if (r7 == null) goto L8;
    L9:
        r3.append(r7);
        VFSFile r8 = r1.v(r2, r3.toString());
        File r9 = r8.getParentFile();
        if (r9 != null) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == true) goto L19;
        File r10 = r8.getParentFile();
        if (r10 == null) goto L19;
        r10.mkdirs();
    L19:
        return r8;
    L12:
        if (r9.exists() != true) goto L14;
    L8:
        r7 = BuildConfig.FLAVOR;
        goto L9
    }

    public static b b(ChameleonConfig r14, Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        if (r14 == null) goto L56;
        String r4 = r14.getBizName();
        if (r4 == null) goto L56;
        String r5 = ThreadMethodProxy.currentThread().getName();
        if (r14.getResConfig() != null) goto L10;
        j.e(ChameleonAssertResManager.TAG, "getResInfo, chameleonConfig resConfig is null, return");
        return new b(0);
    L10:
        a.getClass();
        File r6 = a(r14, r15);
        String r8 = null;
        if (r6.exists() == false) goto L18;
        ConcurrentHashMap<String, b> r16 = b;
        b r0 = r16.get(r4);
        if (r0 == null) goto L15;
        r8 = r0.b;
    L15:
        if (r8 != null) goto L60;
        int r1 = c.a;
        b r2 = c.h(r14, r6.getAbsolutePath());
        r16.put(r4, r2);
        return r2;
    L60:
        return r0;
    L18:
        j.e(ChameleonAssertResManager.TAG, "getResInfo: bizName is " + r4 + " local asset not exist,begin copy thread:" + r5);
        monitor-enter(a.class);
    L52:
        th = move-exception;
        throw th;
    L21:
        if (r6.exists() == false) goto L29;
        ConcurrentHashMap<String, b> r17 = b;     // Catch: Throwable -> L52
        b r3 = r17.get(r4);     // Catch: Throwable -> L52
        if (r3 == null) goto L25;
        r8 = r3.b;     // Catch: Throwable -> L52
    L25:
        if (r8 != null) goto L27;
        int r7 = c.a;     // Catch: Throwable -> L52
        r3 = c.h(r14, r6.getAbsolutePath());     // Catch: Throwable -> L52
        r17.put(r4, r3);     // Catch: Throwable -> L52
    L27:
        monitor-exit(a.class);
        return r3;
    L29:
        VFSFiles.b.getClass();     // Catch: Throwable -> L52
        h r9 = VFSFiles.b(true);     // Catch: Throwable -> L52
        String r10 = c.c(r14).getVfsPath().getRealPath();     // Catch: Throwable -> L52
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L52
        r11.append(System.currentTimeMillis());     // Catch: Throwable -> L52
        ResConfig r12 = r14.getResConfig();     // Catch: Throwable -> L52
        if (r12 == null) goto L32;
        r8 = r12.getOfflineZipName();     // Catch: Throwable -> L52
    L32:
        r11.append(r8);     // Catch: Throwable -> L52
        VFSFile r13 = r9.v(r10, r11.toString());     // Catch: Throwable -> L52
        j.e(ChameleonAssertResManager.TAG, "getResInfo: clean directory thread:" + r5);     // Catch: IOException -> L35 Throwable -> L52
        swb.j.b(r13.getVfsPath().getParent());     // Catch: IOException -> L35 Throwable -> L52
    L37:
        ResConfig r18 = r14.getResConfig();     // Catch: Throwable -> L52
        if (r18 == null) goto L41;
        String r19 = r18.getOfflineZipName();     // Catch: Throwable -> L52
        if (r19 == null) goto L41;
    L43:
        if (swb.j.d(r15, r19, r13.getAbsolutePath()) == true) goto L45;
    L49:
        r13.deleteOnExit();     // Catch: Throwable -> L52
        j.e(ChameleonAssertResManager.TAG, "getResInfo: asset copy to local fails thread:" + r5);     // Catch: Throwable -> L52
        b r110 = new b(0);     // Catch: Throwable -> L52
        monitor-exit(a.class);
        return r110;
    L45:
        if (r13.exists() == false) goto L49;
        r13.renameTo(r6);     // Catch: Throwable -> L52
        j.e(ChameleonAssertResManager.TAG, "getResInfo: rename to :" + r6.getAbsolutePath() + " thread:" + r5);     // Catch: Throwable -> L52
        int r111 = c.a;     // Catch: Throwable -> L52
        b r112 = c.h(r14, r6.getAbsolutePath());     // Catch: Throwable -> L52
        b.put(r4, r112);     // Catch: Throwable -> L52
        monitor-exit(a.class);
        return r112;
    L41:
        r19 = BuildConfig.FLAVOR;
        goto L43
    L35:
        e = move-exception;
        j.b(ChameleonAssertResManager.TAG, r5 + " => getResInfo: clean directory fails : " + e);     // Catch: Throwable -> L52
    L56:
        return new b(0);
    }
}
