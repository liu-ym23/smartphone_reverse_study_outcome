package com.obric.sva.sdk.effectplatform;

import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.google.gson.Gson;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0005H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J.\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0005J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005J\u0016\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectUtils;", "", "<init>", "()V", "TAG", "", "asFile", "Ljava/io/File;", "updateCurrentConfig", "", "targetDir", "restoreDefaultConfig", "", "getRelativePath", "baseDir", "checkContentValid", "path", "copyDir", "sourceDir", "overwrite", "checkDigest", "dir", "manifest", "Lcom/obric/sva/sdk/effectplatform/ModelManifest;", "checkRawFileMd5", "group", "modelFile", "keyFile", "rawMd5", "compareMd5", "file", "md5", "loadManifest", "unzipFile", "zipFilePath", "toDir", "findSubDirContainManifest", "extractDir", "compareVersion", "", "version1", "version2", "sameManifest", "latestManifest", "contentManifest", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EffectUtils {
    public static final EffectUtils INSTANCE = null;
    public static final String TAG = "EffectUtils";

    static {
        INSTANCE = new EffectUtils();
    }

    private EffectUtils() {
    }

    public final void restoreDefaultConfig() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(EffectConstant.INSTANCE.getBaseRoot() + File.separator + EffectConstant.CURRENT_CONFIG_JSON);
        if (r0.exists() == true) goto L6;
        r0.createNewFile();
    L6:
        if (r0.exists() == false) goto L15;
        JSONObject r1 = new JSONObject();
        r1.put("config", "./default_config.json");
        r1.put("owner", "default");
        PolarisFileWriterWrapper r4 = new PolarisFileWriterWrapper(r0);
        r4.write(r1.toString());     // Catch: Throwable -> L10
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r4, null);
        LogUtils.d(TAG, "restoreDefaultConfig success content is " + r1, new Object[0]);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L15:
        LogUtils.d(TAG, "restoreDefaultConfig not exist of " + r0.getAbsolutePath(), new Object[0]);
    }

    private final File asFile(String r2) {
        return new PolarisFileWrapper(r2);
    }

    public final boolean checkContentValid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        return checkDigest(r2, loadManifest(r2));
    }

    public final String findSubDirContainManifest(String r7) {
        Intrinsics.checkNotNullParameter(r7, "extractDir");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r7);
        if (r0.exists() == true) goto L5;
    L21:
        return null;
    L5:
        if (r0.isDirectory() == false) goto L21;
        File[] r8 = r0.listFiles();
        if (r8 != null) goto L10;
        return null;
    L10:
        int r1 = r8.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L21;
        File r3 = r8[r2];
        if (r3.isDirectory() == false) goto L20;
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3, EffectConstant.MODEL_MANIFEST_FILE_NAME);
        if (r4.exists() == false) goto L20;
        if (r4.isFile() == false) goto L20;
        return r3.getAbsolutePath();
    L20:
        r2 = r2 + 1;
        goto L11
    }

    public final ModelManifest loadManifest(String r6) {
        Intrinsics.checkNotNullParameter(r6, "dir");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6, EffectConstant.MODEL_MANIFEST_FILE_NAME);
        if (r0.exists() == true) goto L5;
        return null;
    L5:
        if (r0.isFile() == false) goto L30;
        Gson r7 = new Gson();     // Catch: Exception -> L20
        Charset r2 = Charsets.UTF_8;     // Catch: Exception -> L20
        Reader r3 = new InputStreamReader(new PolarisFileInputStreamWrapper(r0), r2);     // Catch: Exception -> L20
        if ((r3 instanceof BufferedReader) == false) goto L11;
        BufferedReader r4 = (BufferedReader) r3;     // Catch: Exception -> L20
    L24:
        ModelManifest r8 = (ModelManifest) r7.fromJson(r4, ModelManifest.class);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L20
        return r8;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L20
        throw th;     // Catch: Exception -> L20
    L11:
        r4 = new BufferedReader(r3, 8192);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    L30:
        return null;
    }

    public final boolean updateCurrentConfig(String r8) {
        Intrinsics.checkNotNullParameter(r8, "targetDir");
        File r0 = asFile(r8);
        EffectConstant r1 = EffectConstant.INSTANCE;
        String r2 = getRelativePath(r0, asFile(r1.getBaseRoot()));
        StringBuilder r3 = new StringBuilder();
        r3.append(r1.getBaseRoot());
        String r4 = File.separator;
        r3.append(r4);
        r3.append(EffectConstant.CURRENT_CONFIG_JSON);
        PolarisFileWrapper r5 = new PolarisFileWrapper(r3.toString());
        File r6 = asFile(r8 + r4 + EffectConstant.MODEL_MANIFEST_FILE_NAME);
        if (r5.exists() == true) goto L5;
    L15:
        LogUtils.d(TAG, "updateCurrentConfig not exist of " + r5.getAbsolutePath(), new Object[0]);
        return false;
    L5:
        if (r6.exists() == false) goto L15;
        String r9 = "." + r4 + r2 + r4 + EffectConstant.MODEL_MANIFEST_FILE_NAME;
        JSONObject r7 = new JSONObject();
        r7.put("config", r9);
        r7.put("owner", "alternative");
        PolarisFileWriterWrapper r10 = new PolarisFileWriterWrapper(r5);
        r10.write(r7.toString());     // Catch: Throwable -> L10
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r10, null);
        LogUtils.d(TAG, "updateCurrentConfig success content is " + r7, new Object[0]);
        return true;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private final String getRelativePath(File r3, File r4) {
        if (Build.VERSION.SDK_INT < 26) goto L10;
        return r4.getAbsoluteFile().toPath().relativize(r3.getAbsoluteFile().toPath()).toString();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        return r3.getAbsolutePath();
    }

    public final boolean checkDigest(String r12, ModelManifest r13) {
        Intrinsics.checkNotNullParameter(r12, "dir");
        StringBuilder r0 = new StringBuilder("checkDigest in ");
        r0.append(r12);
        r0.append(" version ");
        if (r13 == null) goto L5;
        String r1 = r13.getVersion();
    L6:
        r0.append(r1);
        LogUtils.d(TAG, r0.toString(), new Object[0]);
        if (r13 != null) goto L9;
        return false;
    L9:
        String r2 = r13.getSidModelMd5();
        String r3 = r13.getSidKeyMd5();
        String r4 = r13.getKwsModelMd5();
        String r5 = r13.getKwsKeyMd5();
        boolean r6 = checkRawFileMd5("sid", r13.getSidModelFile(), r13.getSidKeyFile(), r13.getSidRawFileMd5());
        boolean r7 = checkRawFileMd5("kws", r13.getKwsModelFile(), r13.getKwsKeyFile(), r13.getKwsRawFileMd5());
        boolean r8 = compareMd5(r12, r13.getSidModelFile(), r2);
        boolean r9 = compareMd5(r12, r13.getSidKeyFile(), r3);
        boolean r10 = compareMd5(r12, r13.getKwsModelFile(), r4);
        boolean r14 = compareMd5(r12, r13.getKwsKeyFile(), r5);
        if (r8 == false) goto L17;
        if (r9 == false) goto L17;
        if (r6 == false) goto L17;
        if (r10 == false) goto L17;
        if (r14 == false) goto L17;
        if (r7 == false) goto L17;
        LogUtils.d(TAG, "##### checkDigest ##### ALL FILES TEST PASS ! ✅", new Object[0]);
    L18:
        LogUtils.d(TAG, "checkDigest in model : kws [ " + r10 + ' ' + r14 + " raw=" + r7 + " ] sid [" + r8 + ' ' + r9 + " raw=" + r6 + ']', new Object[0]);
        if (r8 == false) goto L27;
        if (r9 == false) goto L28;
        if (r6 == false) goto L29;
        if (r10 == false) goto L30;
        if (r14 == false) goto L31;
        if (r7 == false) goto L32;
        return true;
    L32:
        return false;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L17:
        LogUtils.d(TAG, "##### checkDigest ##### ANY FILES TEST FAIL ! ❌", new Object[0]);
        goto L18
    L5:
        r1 = null;
        goto L6
    }

    public final int compareVersion(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "version1");
        Intrinsics.checkNotNullParameter(r13, "version2");
        List r14 = StringsKt.split$default(r12, new String[]{"."}, false, 0, 6, null);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L3:
        int r4 = 0;
        if (r15.hasNext() == false) goto L9;
        Integer r3 = StringsKt.toIntOrNull((String) r15.next());
        if (r3 == null) goto L8;
        r4 = r3.intValue();
    L8:
        r1.add(Integer.valueOf(r4));
        goto L3
    L9:
        List r16 = StringsKt.split$default(r13, new String[]{"."}, false, 0, 6, null);
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L11:
        if (r18.hasNext() == false) goto L17;
        Integer r0 = StringsKt.toIntOrNull((String) r18.next());
        if (r0 == null) goto L15;
        int r2 = r0.intValue();
    L16:
        r17.add(Integer.valueOf(r2));
        goto L11
    L15:
        r2 = 0;
        goto L16
    L17:
        int r19 = Math.max(r1.size(), r17.size());
        int r5 = 0;
    L18:
        if (r5 >= r19) goto L34;
        if (r5 >= r1.size()) goto L22;
        int r6 = ((Number) ListProtector.get(r1, r5)).intValue();
    L24:
        if (r5 >= r17.size()) goto L26;
        int r7 = ((Number) ListProtector.get(r17, r5)).intValue();
    L27:
        if (r6 > r7) goto L28;
        if (r6 < r7) goto L31;
        r5 = r5 + 1;
        goto L18
    L31:
        return -1;
    L28:
        return 1;
    L26:
        r7 = 0;
        goto L27
    L22:
        r6 = 0;
        goto L24
    L34:
        return 0;
    }

    public final boolean sameManifest(ModelManifest r3, ModelManifest r4) {
        Intrinsics.checkNotNullParameter(r3, "latestManifest");
        Intrinsics.checkNotNullParameter(r4, "contentManifest");
        boolean r5 = r3.sameAs(r4);
        LogUtils.d(TAG, "sameManifest ?  " + r5, new Object[0]);
        return r5;
    }

    public final boolean unzipFile(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "zipFilePath");
        Intrinsics.checkNotNullParameter(r13, "toDir");
        PolarisFileWrapper r1 = new PolarisFileWrapper(r12);
        PolarisFileWrapper r14 = new PolarisFileWrapper(r13);
        if (r1.exists() == true) goto L5;
    L74:
        LogUtils.d(TAG, "ERROR：ZIP file is invalid -> " + r1.getAbsolutePath(), new Object[0]);
        return false;
    L5:
        if (r1.isFile() == false) goto L74;
        if (StringsKt.endsWith(r1.getName(), ".zip", true) == true) goto L14;
        if (StringsKt.endsWith(r1.getName(), "_model", true) == true) goto L14;
        LogUtils.d(TAG, "ERROR：NOT .ZIP OR _MODEL FILE -> " + r1.getAbsolutePath(), new Object[0]);
        return false;
    L14:
        if (r14.exists() == false) goto L17;
        rna.c.b(r13);
    L17:
        if (r14.exists() == false) goto L19;
    L22:
        LogUtils.d(TAG, "START UNZIP！！", new Object[0]);
        ZipFile r15 = null;
        ZipFile r2 = new PolarisZipFileWrapper(r1);     // Catch: Throwable -> L62 IOException -> L64
        Enumeration<? extends ZipEntry> r5 = r2.entries();     // Catch: Throwable -> L58 IOException -> L60
    L26:
        if (r5.hasMoreElements() == false) goto L55;
        ZipEntry r7 = r5.nextElement();     // Catch: Throwable -> L58 IOException -> L60
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.util.zip.ZipEntry");     // Catch: Throwable -> L58 IOException -> L60
        ZipEntry r8 = r7;     // Catch: Throwable -> L58 IOException -> L60
        PolarisFileWrapper r9 = new PolarisFileWrapper(r14, r8.getName());     // Catch: Throwable -> L58 IOException -> L60
        if (r8.isDirectory() == true) goto L30;
        File r10 = r9.getParentFile();     // Catch: Throwable -> L58 IOException -> L60
        if (r10.exists() == false) goto L35;
    L39:
        InputStream r11 = r2.getInputStream(r8);     // Catch: Throwable -> L58 IOException -> L60
        PolarisFileOutputStreamWrapper r16 = new PolarisFileOutputStreamWrapper(r9);     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L45
        ByteStreamsKt.copyTo$default(r11, r16, 0, 2, null);     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L58 IOException -> L60
        goto L26
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L58 IOException -> L60
        throw th;     // Catch: Throwable -> L58 IOException -> L60
    L35:
        if (r10.mkdirs() == true) goto L39;
        LogUtils.d(TAG, "ERROR：FAILED TO CREATE PARENT DIR -> " + r10.getAbsolutePath(), new Object[0]);     // Catch: Throwable -> L58 IOException -> L60
        r2.close();
        LogUtils.d(TAG, "UNZIP END ！！", new Object[0]);
        return false;
    L30:
        if (r9.mkdirs() == true) goto L26;
        LogUtils.d(TAG, "ERROR：CREATE DIR FAILED -> " + r9.getAbsolutePath(), new Object[0]);     // Catch: Throwable -> L58 IOException -> L60
        goto L26
    L55:
        LogUtils.d(TAG, "UNZIP OK：" + r1.getAbsolutePath() + " -> " + r14.getAbsolutePath(), new Object[0]);     // Catch: Throwable -> L58 IOException -> L60
        r2.close();
        LogUtils.d(TAG, "UNZIP END ！！", new Object[0]);
        return true;
    L60:
        e = e;
        r15 = r2;
    L65:
        LogUtils.d(TAG, "UNZIP FAIL：" + e.getMessage(), new Object[0]);     // Catch: Throwable -> L62
        e.printStackTrace();     // Catch: Throwable -> L62
        if (r15 == null) goto L68;
        r15.close();
    L68:
        LogUtils.d(TAG, "UNZIP END ！！", new Object[0]);
        return false;
    L58:
        th = th;
        r15 = r2;
    L70:
        if (r15 == null) goto L72;
        r15.close();
    L72:
        LogUtils.d(TAG, "UNZIP END ！！", new Object[0]);
        throw th;
    L64:
        e = e;
    L62:
        th = th;
        goto L70
    L19:
        if (r14.mkdirs() == true) goto L22;
        LogUtils.d(TAG, "ERROR：FAILED TO CREATE DIR -> " + r14.getAbsolutePath(), new Object[0]);
        return false;
    }

    private final boolean compareMd5(String r7, String r8, String r9) {
        LogUtils.d(TAG, "compareMd5 baseDir " + r7 + " , fileName " + r8 + " compare to " + r9, new Object[0]);
        boolean r0 = true;
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L19;
        if (r9 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        LogUtils.d(TAG, "compareMd5 return caused by empty file name and md5", new Object[0]);
        return true;
    L12:
        if (r9.length() == 0) goto L15;
        r3 = false;
    L19:
        if (r8 != null) goto L21;
    L24:
        boolean r4 = true;
    L25:
        if (r4 == true) goto L45;
        if (r9 != null) goto L28;
    L31:
        boolean r5 = true;
    L32:
        if (r5 == true) goto L45;
        if (r9.length() > 0) goto L38;
        r0 = false;
    L38:
        if (r0 == true) goto L40;
    L42:
        boolean r10 = false;
    L43:
        LogUtils.d(TAG, "compareMd5 " + r9 + " with " + r8 + " result is " + r10, new Object[0]);
        return r10;
    L40:
        if (r9.length() != 32) goto L42;
        String r11 = KtUtils.md5(r7 + File.separator + r8);
        Locale r1 = Locale.ROOT;
        String r12 = r11.toLowerCase(r1);
        LogUtils.d(TAG, "compareMd5 file md5 is " + r12 + ' ', new Object[0]);
        r10 = Intrinsics.areEqual(r9.toLowerCase(r1), r12);
        goto L43
    L28:
        if (r9.length() == 0) goto L31;
        r5 = false;
    L45:
        LogUtils.d(TAG, "compareMd5 return false caused by different file name and md5", new Object[0]);
        return false;
    L21:
        if (r8.length() == 0) goto L24;
        r4 = false;
        goto L25
    L5:
        if (r8.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean copyDir(String r11, String r12, boolean r13) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "sourceDir");
        Intrinsics.checkNotNullParameter(r12, "targetDir");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r11);
        PolarisFileWrapper r14 = new PolarisFileWrapper(r12);
        if (r0.exists() == true) goto L6;
        return false;
    L6:
        if (r0.isDirectory() == true) goto L9;
        return false;
    L9:
        if (r14.exists() == false) goto L11;
    L13:
        File[] r15 = r0.listFiles();
        if (r15 != null) goto L16;
        LogUtils.d(TAG, "无法读取源目录内容: " + r0.getAbsolutePath(), new Object[0]);
        r15 = new File[0];
    L16:
        int r1 = r15.length;
        int r3 = 0;
        int r4 = 0;
    L17:
        if (r3 >= r1) goto L38;
        File r5 = r15[r3];
        PolarisFileWrapper r6 = new PolarisFileWrapper(r14, r5.getName());
        if (r5.isDirectory() == false) goto L22;
        copyDir(r5.getAbsolutePath(), r6.getAbsolutePath(), r13);
    L37:
        r3 = r3 + 1;
        goto L17
    L22:
        if (Build.VERSION.SDK_INT < 26) goto L37;
        ArrayList r7 = new ArrayList();
        if (r13 == false) goto L26;
        r7.add(StandardCopyOption.REPLACE_EXISTING);
    L26:
        String r8 = KtUtils.md5(r5.getAbsolutePath());
        if (Intrinsics.areEqual(r8, KtUtils.md5(r6.getAbsolutePath())) == false) goto L41;
        LogUtils.d(TAG, "copyDir ignore due to same md5 , source " + r5.getAbsolutePath() + " target " + r6.getAbsolutePath() + " with md5 " + r8, new Object[0]);
        goto L37
    L41:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L31
        Path r10 = r5.toPath();     // Catch: Throwable -> L31
        Path r16 = r6.toPath();     // Catch: Throwable -> L31
        StandardCopyOption[] r17 = (StandardCopyOption[]) r7.toArray(new StandardCopyOption[0]);     // Catch: Throwable -> L31
        Object r18 = Result.constructor-impl(Files.copy(r10, r16, (CopyOption[]) Arrays.copyOf(r17, r17.length)));     // Catch: Throwable -> L31
    L34:
        if (Result.isSuccess-impl(r18) == false) goto L36;
        Path r19 = (Path) r18;
        r4 = r4 + 1;
    L36:
        Result.box-impl(r18);
    L31:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L38:
        if (r4 <= 0) goto L48;
        return true;
    L48:
        return false;
    L11:
        if (r14.mkdirs() == true) goto L13;
        LogUtils.d(TAG, "无法创建目标目录: " + r14.getAbsolutePath(), new Object[0]);
        goto L13
    }

    private final boolean checkRawFileMd5(String r5, String r6, String r7, String r8) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L18;
        if (r7 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        return true;
    L12:
        if (r7.length() == 0) goto L15;
        r3 = false;
    L18:
        if (r8 != null) goto L20;
    L23:
        boolean r4 = true;
    L24:
        if (r4 == false) goto L26;
    L28:
        r0 = false;
    L29:
        if (r0 == true) goto L35;
        StringBuilder r9 = new StringBuilder("checkRawFileMd5 ");
        r9.append(r5);
        r9.append(" fail model=");
        r9.append(r6);
        r9.append(" key=");
        r9.append(r7);
        r9.append(" rawMd5Len=");
        if (r8 == null) goto L33;
        int r10 = r8.length();
    L34:
        r9.append(r10);
        LogUtils.d(TAG, r9.toString(), new Object[0]);
        goto L35
    L33:
        r10 = 0;
    L35:
        return r0;
    L26:
        if (r8.length() != 32) goto L28;
    L20:
        if (r8.length() == 0) goto L23;
        r4 = false;
        goto L24
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static /* synthetic */ boolean copyDir$default(EffectUtils r0, String r1, String r2, boolean r3, int r4, Object r5) throws IOException {
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        return r0.copyDir(r1, r2, r3);
    }
}
