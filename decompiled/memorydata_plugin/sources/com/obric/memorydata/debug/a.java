package com.obric.memorydata.debug;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretData;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.google.gson.GsonBuilder;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.utils.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012JH\u0010\u0018\u001a:\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001a0\u0019j\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001a`\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J2\u0010\u000f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010#\u001a\u00020\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0005H\u0002J \u0010*\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u0010-\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0003J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010/\u001a\u000200H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0010H\u0003J\u001a\u00102\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u00122\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0003J \u00104\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\t¨\u00066"}, d2 = {"Lcom/obric/memorydata/debug/BackupDataUtils;", "", "<init>", "()V", "TAG", "", "backupFileList", "", "getBackupFileList", "()Ljava/util/List;", "backupFileList$delegate", "Lkotlin/Lazy;", "dbBlackList", "getDbBlackList", "dbBlackList$delegate", "backupFiles", "Ljava/io/File;", "context", "Landroid/content/Context;", "saveFileName", "importDatabases", "", "backupZipPath", "generateBackupFileName", "getDatabaseFiles", "Ljava/util/HashMap;", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "generateZipInfo", "Lcom/obric/memorydata/debug/BackupZipInfo;", "getPassPhrase", "dbName", "", "appDataDir", "filesToBackup", "backupZipFile", "comment", "zipFile", "zos", "Ljava/util/zip/ZipOutputStream;", "file", "relativePath", "zipDirectory", "folder", "parentFolder", "restoreFiles", "resolveZipEntryTarget", "zipEntry", "Ljava/util/zip/ZipEntry;", "readComment", "importDbPassPhrase", "phraseJson", "updatePassPhrase", "passPhrase", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f9863b = null;
    private static final Lazy c = null;

    static {
        f9862a = new a();
        f9863b = LazyKt.lazy($$Lambda$a$jVXxg59yTjVJgcvlBW_RA6u91Kw.INSTANCE);
        c = LazyKt.lazy($$Lambda$a$O7rYE6FqgOKn9Uqyki6fx00OmIU.INSTANCE);
    }

    private a() {
    }

    private final File a(File r8, ZipEntry r9) {
        String r7 = r9.getName();
        Intrinsics.checkNotNull(r7);
        boolean r1 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L33;
        if (StringsKt.startsWith$default(r7, "/", false, 2, null) == false) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == false) goto L31;
        if ((!StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("..", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null)) == false) goto L29;
        if ((!new Regex("^[A-Za-z]:").containsMatchIn((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L27;
        File r11 = new File(r8, r7).getCanonicalFile();
        String r0 = r8.getPath() + File.separator;
        if (Intrinsics.areEqual(r11.getPath(), r8.getPath()) == true) goto L21;
        String r12 = r11.getPath();
        Intrinsics.checkNotNullExpressionValue(r12, "getPath(...)");
        if (StringsKt.startsWith$default(r12, r0, false, 2, null) == true) goto L21;
        r1 = false;
    L21:
        if (r1 == false) goto L25;
        Intrinsics.checkNotNull(r11);
        return r11;
    L25:
        throw new IllegalArgumentException(("zip entry escapes app data dir: " + r7).toString());
    L27:
        throw new IllegalArgumentException(("windows absolute zip entry is not allowed: " + r7).toString());
    L29:
        throw new IllegalArgumentException(("parent traversal zip entry is not allowed: " + r7).toString());
    L31:
        throw new IllegalArgumentException(("absolute zip entry is not allowed: " + r7).toString());
    L7:
        if (StringsKt.startsWith$default(r7, "\\", false, 2, null) == true) goto L9;
        r10 = true;
        goto L10
    L33:
        throw new IllegalArgumentException("empty zip entry name".toString());
    }

    @JvmStatic
    private static final String a(File r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r2), Closeable.class, "com.obric.memorydata.plugin");
        String r0 = ((ZipFile) ZeusTransformUtils.preCheckCast(r3, ZipFile.class, "com.obric.memorydata.plugin")).getComment();     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r3, null);
        return r0;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    private final List<String> a() {
        return (List) ZeusTransformUtils.preCheckCast(f9863b.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    private static final void a(Context r12, String r13, String r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        r0.putInt("query_mode", 2);
        Object r7 = null;
        if (am.f13169a.c() == false) goto L17;
        SecretDataManager r2 = SecretDataManager.getInstance();
        SecretData r11 = new SecretData();
        r11.alias = r13;
        r11.dataType = "DBKey";
        r11.secretData = r14;
        QueryResult r16 = r2.queryData(r15, r13, r0);
        if (r16 == null) goto L10;
        List<SecretData> r17 = r16.getDataList();
        if (r17 == null) goto L10;
        r7 = (SecretData) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r17), SecretData.class, "com.obric.memorydata.plugin");
    L10:
        if (r7 != null) goto L16;
        Log.d("SafeUtils", r13 + " never has passPhrase, will add it");
        AddResult r18 = r2.addData(r15, r11, new Bundle());
        if (r18.getResultCode() == 0) goto L32;
        Log.e("SafeUtils", "save passPhrase failed, code: " + r18.getResultCode());
        throw new RuntimeException("save passPhrase failed, code: " + r18.getResultCode());
    L32:
        return;
    L16:
        Log.d("SafeUtils", r13 + " already has passPhrase, will update it");
        int r19 = r2.updateData(r15, r11, new Bundle());
        StringBuilder r110 = new StringBuilder();
    L30:
        Log.d("SafeUtils", r110.append("updatePassPhrase for ").append(r13).append(" return ").append(r19).toString());
        return;
    L17:
        com.obric.security.secretdata.SecretDataManager r3 = com.obric.security.secretdata.SecretDataManager.getInstance();
        com.obric.security.secretdata.SecretData r111 = new com.obric.security.secretdata.SecretData();
        r111.alias = r13;
        r111.dataType = "DBKey";
        r111.secretData = r14;
        com.obric.security.secretdata.QueryResult r112 = r3.queryData(r15, r13, r0);
        if (r112 == null) goto L23;
        List<com.obric.security.secretdata.SecretData> r113 = r112.getDataList();
        if (r113 == null) goto L23;
        r7 = (com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r113), com.obric.security.secretdata.SecretData.class, "com.obric.memorydata.plugin");
    L23:
        if (r7 != null) goto L29;
        Log.d("SafeUtils", r13 + " never has passPhrase, will add it");
        com.obric.security.secretdata.AddResult r114 = r3.addData(r15, r111, new Bundle());
        if (r114.getResultCode() == 0) goto L33;
        Log.e("SafeUtils", "save passPhrase failed, code: " + r114.getResultCode());
        throw new RuntimeException("save passPhrase failed, code: " + r114.getResultCode());
    L33:
        return;
    L29:
        Log.d("SafeUtils", r13 + " already has passPhrase, will update it");
        r19 = r3.updateData(r15, r111, new Bundle());
        r110 = new StringBuilder();
        goto L30
    }

    @JvmStatic
    private static final void a(File r8, File r9) {
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipInputStream((InputStream) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r8), InputStream.class, "com.obric.memorydata.plugin")), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        ZipInputStream r0 = (ZipInputStream) ZeusTransformUtils.preCheckCast(r10, ZipInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        ZipEntry r1 = r0.getNextEntry();     // Catch: Throwable -> L25
        File r11 = r9.getCanonicalFile();     // Catch: Throwable -> L25
    L5:
        if (r1 == null) goto L22;
        a r4 = f9862a;     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L25
        File r5 = r4.a(r11, r1);     // Catch: Throwable -> L25
        if (r1.isDirectory() == false) goto L9;
        r5.mkdirs();     // Catch: Throwable -> L25
    L15:
        r0.closeEntry();     // Catch: Throwable -> L25
        r1 = r0.getNextEntry();     // Catch: Throwable -> L25
        goto L5
    L9:
        File r2 = r5.getParentFile();     // Catch: Throwable -> L25
        if (r2 == null) goto L12;
        r2.mkdirs();     // Catch: Throwable -> L25
    L12:
        r5.delete();     // Catch: Throwable -> L25
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r5), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        BufferedOutputStream r6 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r3, BufferedOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Long.valueOf(ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r0, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r6, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null));     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L25
        goto L15
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L22:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r10, null);
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private final void a(File r4, List<String> r5, File r6, String r7) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), OutputStream.class, "com.obric.memorydata.plugin")), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        ZipOutputStream r9 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r8, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r1 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        r9.setComment(r7);     // Catch: Throwable -> L24
    L12:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L24
    L14:
        if (r10.hasNext() == false) goto L21;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        File r12 = new File(r4, r11);     // Catch: Throwable -> L24
        if (r12.exists() == false) goto L14;
        if (r12.isDirectory() == true) goto L19;
        f9862a.a(r9, r12, r11);     // Catch: Throwable -> L24
        goto L14
    L19:
        f9862a.b(r9, r12, r11);     // Catch: Throwable -> L24
        goto L14
    L21:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r8, null);
        return;
    L6:
        if (r1.length() == 0) goto L9;
        r2 = false;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    }

    private final void a(ZipOutputStream r7, File r8, String r9) {
        if (r8.exists() == true) goto L8;
        StringBuilder r6 = new StringBuilder();
        String r10 = "zipFile: file not exist: ";
    L5:
        Log.w("ReleaseBackupDataUtils", r6.append(r10).append(r8).toString());
        return;
    L8:
        if (r8.canRead() == true) goto L11;
        r6 = new StringBuilder();
        r10 = "zipFile: file can not read: ";
        goto L5
    L11:
        if (r8.length() != 0) goto L39;
        r6 = new StringBuilder();
        r10 = "zipFile: file is empty: ";
        goto L5
    L39:
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r8), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L29
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r0, FileInputStream.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        BufferedInputStream r3 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r2, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r7.putNextEntry(new ZipEntry(r9));     // Catch: Throwable -> L19
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r7, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L19
        r7.closeEntry();     // Catch: Throwable -> L19
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L24
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r0, null);     // Catch: IOException -> L29
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: IOException -> L29
        throw th;     // Catch: IOException -> L29
    L29:
        e = move-exception;
        Log.e("ReleaseBackupDataUtils", "zip file " + r8.getAbsolutePath() + " failed");
        e.printStackTrace();
    }

    private final String b(Context r9, String r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Bundle r11 = new Bundle();
        r11.putInt("query_mode", 2);
        boolean r2 = false;
        String r7 = null;
        if (am.f13169a.c() == false) goto L19;
        QueryResult r12 = SecretDataManager.getInstance().queryData(r8, r10, r11);
        if (r12 == null) goto L9;
        List<SecretData> r13 = r12.getDataList();
        if (r13 == null) goto L9;
        SecretData r14 = (SecretData) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r13), SecretData.class, "com.obric.memorydata.plugin");
    L10:
        if (r14 == null) goto L12;
        r7 = r14.secretData;
    L12:
        StringBuilder r15 = new StringBuilder().append("getPassPhrase for ").append(r10).append(" return ");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L15;
    L16:
        r2 = true;
    L17:
        Log.i("ReleaseBackupDataUtils", r15.append(!r2).toString());
        return r7;
    L15:
        if (r16.length() != 0) goto L17;
    L9:
        r14 = null;
        goto L10
    L19:
        com.obric.security.secretdata.QueryResult r17 = com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r8, r10, r11);
        if (r17 == null) goto L24;
        List<com.obric.security.secretdata.SecretData> r18 = r17.getDataList();
        if (r18 == null) goto L24;
        com.obric.security.secretdata.SecretData r19 = (com.obric.security.secretdata.SecretData) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r18), com.obric.security.secretdata.SecretData.class, "com.obric.memorydata.plugin");
    L25:
        if (r19 == null) goto L27;
        r7 = r19.secretData;
    L27:
        r15 = new StringBuilder().append("getPassPhrase for ").append(r10).append(" return ");
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L16;
        if (r20.length() != 0) goto L17;
    L24:
        r19 = null;
        goto L25
    }

    private final HashMap<String, Pair<File, String>> b(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        HashMap<String, Pair<File, String>> r0 = new HashMap();
        Iterator r2 = ArrayIteratorKt.iterator(r10.databaseList());
    L4:
        if (r2.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        if (StringsKt.endsWith$default(r3, "-wal", false, 2, null) == true) goto L4;
        if (StringsKt.endsWith$default(r3, "-shm", false, 2, null) == true) goto L4;
        if (StringsKt.endsWith$default(r3, "-journal", false, 2, null) == true) goto L4;
        if (StringsKt.startsWith$default(r3, "OSE_", false, 2, null) == true) goto L4;
        if (b().contains(r3) == true) goto L4;
        String r4 = b(r10, r3);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r3, new Pair(r10.getDatabasePath(r3), r4));
        goto L4
    L18:
        return r0;
    }

    private final List<String> b() {
        return (List) ZeusTransformUtils.preCheckCast(c.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    private final void b(ZipOutputStream r5, File r6, String r7) {
        File[] r4 = r6.listFiles();
        if (r4 == null) goto L11;
        int r8 = 0;
        int r0 = r4.length;
    L5:
        if (r8 >= r0) goto L15;
        File r1 = r4[r8];
        String r2 = r7 + '/' + r1.getName();
        if (r1.isDirectory() == false) goto L9;
        a r3 = f9862a;
        Intrinsics.checkNotNull(r1);
        r3.b(r5, r1, r2);
    L10:
        r8 = r8 + 1;
        goto L5
    L9:
        a r9 = f9862a;
        Intrinsics.checkNotNull(r1);
        r9.a(r5, r1, r2);
        goto L10
    L15:
        return;
    }

    private final b c(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        HashMap<String, Pair<File, String>> r0 = b(r10);
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L3:
        boolean r4 = false;
        if (r1.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3.getValue(), Pair.class, "com.obric.memorydata.plugin")).second, String.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
    L9:
        r4 = true;
    L10:
        if (r4 == true) goto L3;
        r2.add(new c(r6, r5));
        goto L3
    L8:
        if (r7.length() != 0) goto L10;
    L12:
        String r8 = b(r10, "memory_vector_db_encrypt");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L15;
    L16:
        r4 = true;
    L17:
        if (r4 == true) goto L20;
        r2.add(new c("memory_vector_db_encrypt", r8));
    L20:
        return new b(r2);
    L15:
        if (r11.length() != 0) goto L17;
        goto L16
    }

    private static final List c() {
        return PersonalContextAPI.INSTANCE.getDbBackupFileList();
    }

    @JvmStatic
    private static final void c(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(new GsonBuilder().serializeNulls().create().fromJson(r4, b.class), b.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin");
        a(r5, r0.a(), r0.b());
        goto L7
    }

    private static final List d() {
        return PersonalContextAPI.INSTANCE.getDbBlackList();
    }

    public static /* synthetic */ List lambda$O7rYE6FqgOKn9Uqyki6fx00OmIU() {
        return d();
    }

    public static /* synthetic */ List lambda$jVXxg59yTjVJgcvlBW_RA6u91Kw() {
        return c();
    }

    public final File a(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r8, "saveFileName");
        File r0 = r9.getFilesDir().getParentFile();
        if (r0 != null) goto L5;
        return null;
    L5:
        File r2 = new File(r9.getCacheDir(), StringsKt.substringAfterLast$default(r8, File.separatorChar, null, 2, null));
        if (r2.exists() == false) goto L8;
        r2.delete();
    L8:
        b r10 = c(r9);
        String r11 = new GsonBuilder().serializeNulls().create().toJson(r10);
        a(r0, a(), r2, r11);
        return r2;
    }

    public final String a(Context r3) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "context");
        return "memory-ReleaseAdb-Backup-" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".zip";
    }

    public final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "backupZipPath");
        Log.d("ReleaseBackupDataUtils", "import file " + r10);
        boolean r1 = true;
        boolean r2 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L21;
        File r11 = new File(r10);
        if (r11.exists() == true) goto L10;
    L20:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "ReleaseBackupDataUtils";
        String r5 = "importDatabases failed, file not exist or not zip file";
    L22:
        IRunLog.a.b(r3, r4, r5, r6, r7, r8);
        return false;
    L10:
        if (StringsKt.endsWith$default(r10, ".zip", false, 2, null) == false) goto L20;
        File r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getParentFile();
        if (r12 == null) goto L18;
        a(r11, r12);
        String r13 = a(r11);
        if (r13 == null) goto L16;
        c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13);
    L17:
        r2 = r1;
        goto L18
    L16:
        r1 = false;
    L18:
        r11.delete();
        return r2;
    L21:
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "ReleaseBackupDataUtils";
        r5 = "importDatabases failed, file path is empty";
        goto L22
    L5:
        r9 = false;
        goto L6
    }
}
