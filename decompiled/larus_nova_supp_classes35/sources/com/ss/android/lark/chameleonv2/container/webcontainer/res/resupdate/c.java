package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.text.TextUtils;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import swb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static VFSPath k() {
        return LarkFileStorage.b().b(f.d, new com.ss.android.lark.storage.d(new String[]{"chameleon"}));
    }

    public static void a(Closeable r1) {
        if (r1 == null) goto L10;
        r1.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);
        return;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777316), block:B:29:0x0064 */
    public static String b(InputStream r8) {
        StringBuffer r0 = new StringBuffer();
        Closeable r2 = null;
        if (r8 != null) goto L35;
    L18:
        j.b(ChameleonResUtils.TAG, "convertString()... steam is invalid");     // Catch: Throwable -> L21 IOException -> L23
        String r1 = r0.toString();     // Catch: Throwable -> L21 IOException -> L23
        a(r8);
        return r1;
    L35:
    L23:
        e = move-exception;
        BufferedReader r3 = null;
        IOException e = e;
    L25:
        j.d(ChameleonResUtils.TAG, e);     // Catch: Throwable -> L28
    L26:
        a(r8);
        a(r3);
        return r0.toString();
    L21:
        th = th;
    L30:
        a(r8);
        a(r2);
        throw th;
    L5:
        if (r8.available() <= 0) goto L18;
        r3 = new BufferedReader(new InputStreamReader(r8));     // Catch: Throwable -> L21 IOException -> L23
        String r4 = null;
    L33:
        String r5 = r3.readLine();     // Catch: IOException -> L16 Throwable -> L28
        if (r5 == null) goto L12;
        r4 = r5;
    L13:
        if (r5 == null) goto L26;
        r0.append(r4 + System.getProperty("line.separator"));     // Catch: IOException -> L16 Throwable -> L28
        goto L33
    L12:
        r5 = null;
    L16:
        e = e;
    L28:
        th = th;
        r2 = r3;
        goto L30
    }

    public static VFSFile c(ChameleonConfig r1) {
        VFSPath r0 = k();
        if (r1 == null) goto L7;
        String r2 = r1.getBizName();
        if (r2 == null) goto L7;
        r0 = r0.subPath(r2);
    L7:
        VFSPath r3 = r0.subPath(ChameleonAssertResManager.ASSET_FOLDER);
        if (com.suite.lark.component.storage.ext.b.b(r3) == false) goto L13;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        VFSFiles.b.getClass();
        if (VFSFiles.a(r3).isFile(r3) == false) goto L12;
        com.suite.lark.component.storage.ext.b.delete(r3);
    L12:
        com.suite.lark.component.storage.ext.b.d(r3);
    L15:
        return r3.toFile();
    L13:
        com.suite.lark.component.storage.ext.b.d(r3);
        goto L15
    }

    public static String d(VFSFile r11) {
        VFSFile r1 = null;
        if (r11 != null) goto L39;
        VFSFile[] r12 = null;
    L9:
        if (r12 != null) goto L11;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L21;
        j.e(ChameleonResUtils.TAG, "getLatestResourceVersion(): resourceRootDir is empty");     // Catch: IOException -> L5
        return BuildConfig.FLAVOR;
    L21:
        ArrayList r6 = new ArrayList();     // Catch: IOException -> L5
        int r7 = r12.length;     // Catch: IOException -> L5
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L30;
        VFSFile r9 = r12[r8];     // Catch: IOException -> L5
        String r10 = r9.getName();     // Catch: IOException -> L5
        if (TextUtils.isEmpty(r10) == false) goto L26;
        boolean r13 = false;
    L27:
        if (r13 == false) goto L29;
        r6.add(r9);     // Catch: IOException -> L5
    L29:
        r8 = r8 + 1;     // Catch: IOException -> L5
        goto L22
    L26:
        r13 = Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", r10);     // Catch: IOException -> L5
        goto L27
    L30:
        Collections.sort(r6, new swb.f());     // Catch: IOException -> L5
        if ((!r6.isEmpty()) == false) goto L33;
        r1 = (VFSFile) ListProtector.remove(r6, 0);     // Catch: IOException -> L5
    L33:
        if (r1 != null) goto L36;
        return BuildConfig.FLAVOR;
    L36:
        return r1.getName();
    L11:
        if (r12.length != 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == true) goto L17;
        r5 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L39:
        r12 = r11.listFiles();     // Catch: IOException -> L5
    L5:
        e = move-exception;
        j.c(ChameleonResUtils.TAG, "getLatestResourceVersion(): failed ", e);
        return BuildConfig.FLAVOR;
    }

    public static String e(VFSPath r2) {
        if (r2 == null) goto L15;
        VFSPath r3 = r2.subPath(ChameleonResConstants.TEMPLATE_VERSION);
        if (r3.toFile().isFile() == true) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if (r3.toFile().exists() == false) goto L17;
        return f(new BufferedReader(new PolarisFileReaderWrapper(r3.toFile())));
    L9:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);
        return BuildConfig.FLAVOR;
    L17:
        return BuildConfig.FLAVOR;
    L15:
        return BuildConfig.FLAVOR;
    }

    public static String f(BufferedReader r7) {
    L43:
        String r1 = r7.readLine();     // Catch: Throwable -> L35 Exception -> L37
        if (r1 == null) goto L39;
        boolean r3 = false;
        if (StringsKt.startsWith$default(r1, Keys.API_RETURN_KEY_VERSION, false, 2, null) != true) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L43;
        List r4 = new Regex(":").split(r1, 0);     // Catch: Throwable -> L35 Exception -> L37
        if (r4 != null) goto L13;
    L26:
        String[] r5 = null;
    L27:
        if (r5 != null) goto L29;
    L31:
        if (r3 == false) goto L43;
        String r0 = r5[1];     // Catch: Throwable -> L35 Exception -> L37
        a(r7);
        return r0;
    L29:
        if (r5.length != 2) goto L31;
        r3 = true;
        goto L31
    L13:
        if (r4.isEmpty() == true) goto L23;
        ListIterator r6 = r4.listIterator(r4.size());     // Catch: Throwable -> L35 Exception -> L37
    L16:
        if (r6.hasPrevious() == false) goto L23;
        if (((String) r6.previous()).length() != 0) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == true) goto L16;
        List r9 = CollectionsKt.take(r4, r6.nextIndex() + 1);     // Catch: Throwable -> L35 Exception -> L37
    L24:
        if (r9 == null) goto L26;
        r5 = (String[]) r9.toArray(new String[0]);     // Catch: Throwable -> L35 Exception -> L37
        goto L27
    L20:
        r8 = false;
    L23:
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L35 Exception -> L37
        goto L24
    L8:
        r2 = false;
    L39:
        a(r7);
        return null;
    L35:
        th = move-exception;
        a(r7);
        throw th;
    L37:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);     // Catch: Throwable -> L35
        goto L39
    }

    public static b g(BufferedReader r8) {
        b r0 = new b(0);
    L42:
        String r2 = r8.readLine();     // Catch: Throwable -> L34 IOException -> L36
        if (r2 == null) goto L38;
        String[] r4 = null;
        if (StringsKt.startsWith$default(r2, Keys.API_RETURN_KEY_VERSION, false, 2, null) != true) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L42;
        List r5 = new Regex(":").split(r2, 0);     // Catch: Throwable -> L34 IOException -> L36
        if (r5 != null) goto L13;
    L26:
        if (r4 != null) goto L28;
    L30:
        boolean r6 = false;
    L31:
        if (r6 == false) goto L42;
        r0.b = r4[1];     // Catch: Throwable -> L34 IOException -> L36
        goto L42
    L28:
        if (r4.length != 2) goto L30;
        r6 = true;
        goto L31
    L13:
        if (r5.isEmpty() == true) goto L23;
        ListIterator r7 = r5.listIterator(r5.size());     // Catch: Throwable -> L34 IOException -> L36
    L16:
        if (r7.hasPrevious() == false) goto L23;
        if (((String) r7.previous()).length() != 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == true) goto L16;
        List r10 = CollectionsKt.take(r5, r7.nextIndex() + 1);     // Catch: Throwable -> L34 IOException -> L36
    L24:
        if (r10 == null) goto L26;
        r4 = (String[]) r10.toArray(new String[0]);     // Catch: Throwable -> L34 IOException -> L36
        goto L26
    L20:
        r9 = false;
    L23:
        r10 = CollectionsKt.emptyList();     // Catch: Throwable -> L34 IOException -> L36
        goto L24
    L8:
        r3 = false;
    L38:
        a(r8);
        return r0;
    L34:
        th = move-exception;
        a(r8);
        throw th;
    L36:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);     // Catch: Throwable -> L34
        goto L38
    }

    public static b h(ChameleonConfig r9, String r10) {
        StringBuilder r1 = new StringBuilder();
        if (r9 == null) goto L12;
        ResConfig r11 = r9.getResConfig();
        if (r11 == null) goto L12;
        String r3 = r11.getOfflineZipName();
        if (r3 == null) goto L12;
        List r12 = StringsKt.split$default(r3, new String[]{"."}, false, 0, 6, null);
        if (r12 == null) goto L12;
        String r13 = (String) ListProtector.get(r12, 0);
        if (r13 == null) goto L12;
    L13:
        r1.append(r13);
        r1.append(File.separator);
        r1.append(ChameleonResConstants.TEMPLATE_VERSION);
        String r14 = r1.toString();
        String r2 = m.a;
        String r4 = null;
        if (TextUtils.isEmpty(r10) == false) goto L16;
    L35:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r4) == false) goto L25;
        int r5 = -1;
    L26:
        r15.put(ChameleonOpenTracker.ParamKey.RESULT, r5);     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r4) == false) goto L30;
        j.b(ChameleonResUtils.TAG, "get versioninfo is null");     // Catch: Exception -> L32
        return new b(0);
    L30:
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L32
        return g(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r4.getBytes(Charsets.UTF_8)))));
    L25:
        r5 = 0;
    L32:
        e = move-exception;
        j.b(ChameleonResUtils.TAG, "getResInfoOf7z: report event fails:" + e);
        return new b(0);
    L16:
        if (TextUtils.isEmpty(r14) == true) goto L35;
        r4 = Archive.extractEntryToString(r10, r14, null);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        j.b(m.a, "extractEntry :" + r14 + " fails : " + e + " message:" + e.getMessage());
    L12:
        r13 = BuildConfig.FLAVOR;
        goto L13
    }

    public static VFSFile i(ChameleonConfig r1, String r2) throws IOException {
        VFSPath r0 = k();
        if (r1 == null) goto L7;
        String r3 = r1.getBizName();
        if (r3 == null) goto L7;
        r0 = r0.subPath(r3);
    L7:
        if (r2 == null) goto L10;
        r0 = r0.subPath(r2);
    L10:
        if (com.suite.lark.component.storage.ext.b.b(r0) == false) goto L15;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        VFSFiles.b.getClass();
        if (VFSFiles.a(r0).isFile(r0) == false) goto L14;
        com.suite.lark.component.storage.ext.b.delete(r0);
    L14:
        com.suite.lark.component.storage.ext.b.d(r0);
    L17:
        return r0.toFile();
    L15:
        com.suite.lark.component.storage.ext.b.d(r0);
        goto L17
    }

    public static VFSFile j(ChameleonConfig r1, UpdatePackage r2) {
        Intrinsics.checkNotNullParameter(r1, "chameleonConfig");
        String r3 = r2.getChannel();
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        return null;
    L13:
        return i(r1, r3);
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
