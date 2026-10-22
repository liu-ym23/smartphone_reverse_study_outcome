package com.ss.android.lark.chameleonv2.debug;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements v0b.f {
    public final /* synthetic */ f a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ChameleonConfig c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    @Override // v0b.f
    public final void onStart() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_D_CmlDebugManager", "onStart");
        f r0 = this.a;
        Context r1 = this.b;
        r0.getClass();
        Lazy r2 = ThreadUtil.a;
        ThreadUtil.a.g(new l(r0, r1, "开始下载"));
    }

    @Override // v0b.f
    public final void a(int r4) {
        com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_D_CmlDebugManager", "onProgressUpdate:" + r4);
        f r0 = this.a;
        Context r1 = this.b;
        String r5 = String.valueOf(r4);
        r0.getClass();
        Lazy r2 = ThreadUtil.a;
        ThreadUtil.a.g(new l(r0, r1, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.util.ArrayList] */
    @Override // v0b.f
    public final void b(VFSPath r21) {
        StringBuilder r0 = new StringBuilder("onDownloadComplete:");
        String r2 = null;
        if (r21 == null) goto L5;
        String r3 = r21.getAbsolutePath();
    L6:
        r0.append(r3);
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_D_CmlDebugManager", r0.toString());
        int r1 = v0b.e.a;
        ChameleonConfig r4 = this.c;
        String r5 = BuildConfig.FLAVOR;
        boolean r8 = false;
        VFSFiles.b.getClass();     // Catch: IOException -> L64
        com.ss.android.lark.vfs.h r10 = VFSFiles.b(true);     // Catch: IOException -> L64
        String r11 = v0b.e.d(r4);     // Catch: IOException -> L64
        if (r4 == null) goto L13;
        ResConfig r12 = r4.getResConfig();     // Catch: IOException -> L64
        if (r12 == null) goto L13;
        String r13 = r12.getOfflineZipName();     // Catch: IOException -> L64
        if (r13 == null) goto L13;
    L14:
        VFSFile r14 = r10.v(r11, r13);     // Catch: IOException -> L64
        if (r14 != null) goto L17;
    L19:
        boolean r15 = false;
    L20:
        if (r15 == true) goto L23;
        if (r14 == null) goto L23;
        r14.mkdirs();     // Catch: IOException -> L64
    L23:
        VFSPath r16 = VFSFiles.b(true).t(r14);     // Catch: IOException -> L64
        VFSFile r17 = VFSFiles.b(true).i(v0b.e.f(r4));     // Catch: IOException -> L64
        if (r17.exists() == false) goto L30;
        v0b.e.b(r17.getVfsPath());     // Catch: IOException -> L64
        StringBuilder r18 = new StringBuilder("dir exists, delete：");     // Catch: IOException -> L64
        VFSPath r7 = r17.getVfsPath();     // Catch: IOException -> L64
        if (r7 == null) goto L29;
        r2 = r7.getAbsolutePath();     // Catch: IOException -> L64
    L29:
        r18.append(r2);     // Catch: IOException -> L64
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_D_ChameleonFileUtils", r18.toString());     // Catch: IOException -> L64
    L30:
        r17.mkdirs();     // Catch: IOException -> L64
        int r6 = swb.m.a(r16.getAbsolutePath(), VFSFiles.b(true).t(r17).getAbsolutePath());     // Catch: IOException -> L64
        if (r4 == null) goto L40;
        ResConfig r9 = r4.getResConfig();     // Catch: IOException -> L64
        if (r9 == null) goto L40;
        String r19 = r9.getOfflineZipName();     // Catch: IOException -> L64
        if (r19 == null) goto L40;
        List r20 = StringsKt.split$default(r19, new String[]{"."}, false, 0, 6, null);     // Catch: IOException -> L64
        if (r20 == null) goto L40;
        String r22 = (String) ListProtector.get(r20, 0);     // Catch: IOException -> L64
        if (r22 == null) goto L40;
    L41:
        if (r6 == 0) goto L43;
    L62:
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_D_Downloader", "unzip error:" + r6 + " or resDirName is null");     // Catch: IOException -> L64
    L67:
        if (r5.length() <= 0) goto L69;
        r8 = true;
    L69:
        if (r8 == true) goto L71;
        f.a(this.a, this.b, "解压失败");
    L77:
        f r23 = this.a;
        r23.getClass();
        Lazy r24 = ThreadUtil.a;
        ThreadUtil.a.g(new j(r23));
        return;
    L71:
        if (Intrinsics.areEqual(this.d, "lark") == true) goto L73;
    L75:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_D_CmlDebugManager", "unzip success:" + r5);
        CmlDebugSettingUtil.b("chameleon_specific_res_path", r5);
        f.a(this.a, this.b, "设置离线资源包成功，重启后生效");
        goto L77
    L73:
        if (Intrinsics.areEqual(this.e, ChameleonBizType.BIZ_DOCS.getType()) == false) goto L75;
        r5 = VFSFiles.b.v(r5, "/eesz").getAbsolutePath();
        goto L75
    L43:
        if (r22.length() != 0) goto L45;
        boolean r25 = true;
    L46:
        if (r25 == true) goto L62;
        File[] r26 = r17.listFiles();     // Catch: IOException -> L64
        if (r26 == null) goto L56;
        ?? r27 = new ArrayList();     // Catch: IOException -> L64
        int r28 = r26.length;     // Catch: IOException -> L64
        int r29 = 0;
    L51:
        if (r29 >= r28) goto L58;
        File r110 = r26[r29];     // Catch: IOException -> L64
        if (r110.isDirectory() == false) goto L55;
        r27.add(r110);     // Catch: IOException -> L64
    L55:
        r29 = r29 + 1;     // Catch: IOException -> L64
    L58:
        if (r27.size() != 1) goto L60;
        String r30 = ((VFSFile) ListProtector.get(r27, 0)).getAbsolutePath();     // Catch: IOException -> L64
    L61:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_D_ChameleonFileUtils", "unzip success, destDirPath：" + r30);     // Catch: IOException -> L64
        Intrinsics.checkNotNull(r30);     // Catch: IOException -> L64
        r5 = r30;
        goto L67
    L60:
        r30 = r17.getAbsolutePath();     // Catch: IOException -> L64
        goto L61
    L56:
        r27 = CollectionsKt.emptyList();     // Catch: IOException -> L64
        goto L58
    L45:
        r25 = false;
    L40:
        r22 = BuildConfig.FLAVOR;
        goto L41
    L17:
        if (r14.exists() != true) goto L19;
        r15 = true;
    L13:
        r13 = BuildConfig.FLAVOR;
    L64:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_D_Downloader", "unzip err:" + e);
        goto L67
    L5:
        r3 = null;
        goto L6
    }

    @Override // v0b.f
    public final void c(Exception r5) {
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_D_CmlDebugManager", "onDownloadError:" + r5);
        f r0 = this.a;
        r0.getClass();
        Lazy r1 = ThreadUtil.a;
        ThreadUtil.a.g(new j(r0));
        f r2 = this.a;
        Context r3 = this.b;
        StringBuilder r4 = new StringBuilder("下载失败 ");
        if (r5 == null) goto L5;
        String r6 = r5.getMessage();
    L6:
        r4.append(r6);
        f.a(r2, r3, r4.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }

    public g(f r1, Context r2, ChameleonConfig r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
