package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.h;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import swb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonDefaultResFetcher {
    public static final /* synthetic */ int b = 0;
    public final ConcurrentHashMap<String, VFSPath> a;

    public static final class a {
    }

    static {
    }

    public ChameleonDefaultResFetcher() {
        this.a = new ConcurrentHashMap();
    }

    public final VFSPath a(ChameleonConfig r12, Context r13, String r14) {
        String r0 = null;
        if (r12 == null) goto L5;
        String r1 = r12.getBizName();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        ConcurrentHashMap<String, VFSPath> r2 = this.a;
        if (r12 == null) goto L11;
        String r3 = r12.getBizName();
    L12:
        VFSPath r4 = r2.get(r3);
        if (r4 == null) goto L18;
        StringBuilder r15 = new StringBuilder("getResource from memory cache, ChameleonId is ");
        if (r12 == null) goto L17;
        r0 = r12.getBizName();
    L17:
        r15.append(r0);
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, r15.toString());
        return r4;
    L18:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChameleonDefaultResFetcher$asyncGetResource$1(this, r12, r13, r14, null), 2, null);
        return null;
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final VFSPath b(ChameleonConfig r20, Context r21, String r22) {
        StringBuilder r5 = new StringBuilder("getResourceInternal ChameleonId is ");
        if (r20 == null) goto L5;
        String r7 = r20.getBizName();
    L6:
        r5.append(r7);
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, r5.toString());
        if (r21 != null) goto L9;
        return null;
    L9:
        if (r20 == null) goto L12;
        String r4 = r20.getBizName();
        if (r4 == null) goto L12;
    L14:
        monitor-enter(ChameleonDefaultResFetcher.class);
        if (r20 != null) goto L107;
    L20:
        String r8 = BuildConfig.FLAVOR;
    L21:
        VFSFile r6 = c.i(r20, r4);     // Catch: Throwable -> L95
        VFSFiles.b.getClass();     // Catch: Throwable -> L95
        boolean r9 = true;
        File r10 = VFSFiles.b(true).D(r6, r8);     // Catch: Throwable -> L95
        h r11 = VFSFiles.b(true);     // Catch: Throwable -> L95
        if (r20 == null) goto L31;
        ResConfig r12 = r20.getResConfig();     // Catch: Throwable -> L95
        if (r12 == null) goto L31;
        String r13 = r12.getOfflineZipName();     // Catch: Throwable -> L95
        if (r13 == null) goto L31;
        List r14 = StringsKt.split$default(r13, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L95
        if (r14 == null) goto L31;
        String r15 = (String) r14.get(0);     // Catch: Throwable -> L95
        if (r15 == null) goto L31;
    L32:
        VFSPath r16 = r11.H(r10, r15);     // Catch: Throwable -> L95
        String r17 = c.e(r16);     // Catch: Throwable -> L95
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): path " + r16.getRealPath() + "  localVersion: " + r17 + "  assetVersion: " + r8);     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r8) == false) goto L35;
    L39:
        VFSFile r3 = c.c(r20);     // Catch: Throwable -> L95
        if (r3.isDirectory() == false) goto L45;
        VFSFile[] r18 = r3.listFiles();     // Catch: Throwable -> L95
        int r19 = r18.length;     // Catch: Throwable -> L95
        int r110 = 0;
    L42:
        if (r110 >= r19) goto L45;
        swb.j.g(r18[r110].getVfsPath());     // Catch: Throwable -> L95
        r110 = r110 + 1;     // Catch: Throwable -> L95
    L45:
        if (r6.isDirectory() == false) goto L49;
        VFSFile[] r23 = r6.listFiles();     // Catch: Throwable -> L95
        int r111 = r23.length;     // Catch: Throwable -> L95
        int r112 = 0;
    L47:
        if (r112 >= r111) goto L49;
        swb.j.g(r23[r112].getVfsPath());     // Catch: Throwable -> L95
        r112 = r112 + 1;     // Catch: Throwable -> L95
    L49:
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.a.getClass();     // Catch: Throwable -> L95
        b r24 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.b(r20, r21);     // Catch: Throwable -> L95
        if (r24 != null) goto L52;
    L59:
        boolean r25 = false;
    L60:
        if (r25 == false) goto L65;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResourceInternal resInfo is null, return");     // Catch: Throwable -> L95
        monitor-exit(ChameleonDefaultResFetcher.class);
    L99:
        return null;
    L65:
        if (r10.exists() == true) goto L83;
        u1b.a.C0305a r26 = u1b.a.a(r22);     // Catch: Throwable -> L95
        if (r26 == null) goto L69;
        u1b.a.C0305a.e(r26, ChameleonOpenTracker.Stage.UNZIP);     // Catch: Throwable -> L95
    L69:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResourceInternal clearOldResource");     // Catch: Throwable -> L95
        VFSFile r27 = VFSFiles.b(true).D(r6, r8 + '_' + System.currentTimeMillis() + "__temp");     // Catch: Throwable -> L95
        r27.mkdir();     // Catch: Throwable -> L95
        Intrinsics.checkNotNullParameter(r21, "context");     // Catch: Throwable -> L95
        Intrinsics.checkNotNullParameter(r27, "destFile");     // Catch: Throwable -> L95
        j.e(ChameleonAssertResManager.TAG, "extractSimAssetToLocal: begin extract local assets");     // Catch: Throwable -> L95
        if (m.a(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.a(r20, r21).getAbsolutePath(), r27.getAbsolutePath()) == 0) goto L73;
        r9 = false;
    L73:
        if (r9 == true) goto L77;
        monitor-exit(ChameleonDefaultResFetcher.class);
        goto L99
    L77:
        if (r10.exists() == false) goto L79;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): destParentFile exists() after unzip delete temp file");     // Catch: Throwable -> L95
        swb.j.g(r27.getVfsPath());     // Catch: Throwable -> L95
    L80:
        u1b.a.C0305a r1 = u1b.a.a(r22);     // Catch: Throwable -> L95
        if (r1 == null) goto L84;
        r1.c(ChameleonOpenTracker.Stage.UNZIP, System.currentTimeMillis());     // Catch: Throwable -> L95
    L84:
        if (r20 == null) goto L93;
        String r0 = r20.getBizName();     // Catch: Throwable -> L95
        if (r0 == null) goto L93;
        VFSPath r2 = this.a.put(r0, r16);     // Catch: Throwable -> L90
    L90:
        th = th;
    L105:
        j.c(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "Chameleon getResourceInternal(): failed ", th);     // Catch: Throwable -> L100
        monitor-exit(ChameleonDefaultResFetcher.class);
    L100:
        th = move-exception;
        throw th;
    L93:
        monitor-exit(ChameleonDefaultResFetcher.class);
        return r16;
    L79:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): rename result = " + r27.renameTo(r10));     // Catch: Throwable -> L95
        goto L80
    L83:
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): destParentFile exists()");     // Catch: Throwable -> L95
        goto L84
    L52:
        if (TextUtils.isEmpty(r24.a) == true) goto L54;
    L56:
        boolean r28 = false;
    L57:
        if (r28 != true) goto L59;
        r25 = true;
        goto L60
    L54:
        if (TextUtils.isEmpty(r24.b) == false) goto L56;
        r28 = true;
        goto L57
    L35:
        if (TextUtils.isEmpty(r17) == true) goto L39;
        if (TextUtils.equals(r8, r17) == false) goto L39;
        j.e(com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher.TAG, "getResource(): assetVersion == localVersion");     // Catch: Throwable -> L95
    L31:
        r15 = BuildConfig.FLAVOR;
        goto L32
    L107:
        ResConfig r29 = r20.getResConfig();     // Catch: Throwable -> L95
        if (r29 == null) goto L20;
        r8 = r29.getResVersion();     // Catch: Throwable -> L95
        if (r8 != null) goto L21;
    L95:
        th = th;
    L12:
        r4 = ChameleonChannel.DEFAULT_CHANNEL.getValue();
        goto L14
    L5:
        r7 = null;
        goto L6
    }
}
