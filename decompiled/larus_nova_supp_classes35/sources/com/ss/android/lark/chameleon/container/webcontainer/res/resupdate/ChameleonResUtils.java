package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.util.CommonResUtils;
import com.ss.android.lark.chameleon.container.webcontainer.util.Storage;
import com.ss.android.lark.chameleon.container.webcontainer.util.StorageUtils;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.LzmaUtils;
import com.ss.ttvideoengine.superresolution.SRStrategy;
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
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J3\u0010\u001e\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\"j\b\u0012\u0004\u0012\u00020\u000e`#H\u0002¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResUtils;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "closeSafe", BuildConfig.FLAVOR, "closeable", "Ljava/io/Closeable;", "convertString", "inputStream", "Ljava/io/InputStream;", "getLatestResourceVersion", "resourceRootDir", "Ljava/io/File;", "getOfflineFileVersion", "path", "getOfflineParentDir", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "channel", "getOfflineResVersion", SRStrategy.MEDIAINFO_KEY_BITRATE, "Ljava/io/BufferedReader;", "getResInfo", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResInfo;", "getResInfoOf7z", "resPath", "getResourceRootDir", "getWebcontainerRootDir", "pickUpFiles", "files", BuildConfig.FLAVOR, "validFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "([Ljava/io/File;Ljava/util/ArrayList;)V", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonResUtils {
    public static final ChameleonResUtils INSTANCE = null;
    public static final String TAG = "CML_TAG_RestUtils";

    static {
        INSTANCE = new ChameleonResUtils();
    }

    private ChameleonResUtils() {
    }

    public final String getWebcontainerRootDir() {
        return new PolarisFileWrapper(StorageUtils.composeStoragePath(Env.getApplication(), ChameleonResConstants.WEBCONAINER_ROOT_DIR, BuildConfig.FLAVOR, Storage.Type.INNER_FILES, null)).getCanonicalPath();
    }

    private final void closeSafe(Closeable r3) {
        if (r3 == null) goto L13;
        r3.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r0 = e.getMessage();
        if (r0 != null) goto L9;
        r0 = "Unknown error";
    L9:
        Log.e(TAG, r0, e);
        return;
    }

    private final String getLatestResourceVersion(File r7) {
        File r1 = null;
        if (r7 != null) goto L30;
        File[] r8 = null;
    L9:
        if (r8 != null) goto L11;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L21;
        Log.i(TAG, "getLatestResourceVersion(): resourceRootDir is empty");     // Catch: IOException -> L5
        return BuildConfig.FLAVOR;
    L21:
        ArrayList<File> r6 = new ArrayList();     // Catch: IOException -> L5
        pickUpFiles(r8, r6);     // Catch: IOException -> L5
        CommonResUtils.sortValidFiles(r6);     // Catch: IOException -> L5
        if ((!r6.isEmpty()) == false) goto L24;
        r1 = (File) ListProtector.remove(r6, 0);     // Catch: IOException -> L5
    L24:
        if (r1 != null) goto L27;
        return BuildConfig.FLAVOR;
    L27:
        return r1.getName();
    L11:
        if (r8.length != 0) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == true) goto L17;
        r5 = false;
        goto L18
    L13:
        r9 = false;
        goto L14
    L30:
        r8 = r7.listFiles();     // Catch: IOException -> L5
    L5:
        e = move-exception;
        Log.e(TAG, "getLatestResourceVersion(): failed ", e);
        return BuildConfig.FLAVOR;
    }

    private final String getOfflineResVersion(BufferedReader r8) {
        if (r8 != null) goto L48;
    L47:
        return null;
    L48:
        String r1 = r8.readLine();     // Catch: Throwable -> L37 Exception -> L39
        if (r1 == null) goto L36;
        boolean r4 = false;
        if (StringsKt.startsWith$default(r1, Keys.API_RETURN_KEY_VERSION, false, 2, null) != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L48;
        List r3 = new Regex(":").split(r1, 0);     // Catch: Throwable -> L37 Exception -> L39
        if (r3 != null) goto L14;
    L27:
        String[] r5 = null;
    L28:
        if (r5 != null) goto L30;
    L32:
        if (r4 == false) goto L48;
        String r0 = r5[1];     // Catch: Throwable -> L37 Exception -> L39
        closeSafe(r8);
        return r0;
    L30:
        if (r5.length != 2) goto L32;
        r4 = true;
        goto L32
    L14:
        if (r3.isEmpty() == true) goto L24;
        ListIterator r6 = r3.listIterator(r3.size());     // Catch: Throwable -> L37 Exception -> L39
    L17:
        if (r6.hasPrevious() == false) goto L24;
        if (((String) r6.previous()).length() != 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L17;
        List r9 = CollectionsKt.take(r3, r6.nextIndex() + 1);     // Catch: Throwable -> L37 Exception -> L39
    L25:
        if (r9 == null) goto L27;
        r5 = (String[]) r9.toArray(new String[0]);     // Catch: Throwable -> L37 Exception -> L39
        goto L28
    L21:
        r7 = false;
    L24:
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L37 Exception -> L39
        goto L25
    L9:
        r2 = false;
    L36:
        closeSafe(r8);
    L39:
        e = move-exception;
        String r10 = e.getMessage();     // Catch: Throwable -> L37
        if (r10 != null) goto L43;
        r10 = "Unknown error";
    L43:
        Log.e(TAG, r10, e);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        closeSafe(r8);
        throw th;
    }

    private final ChameleonResInfo getResInfo(BufferedReader r9) {
        ChameleonResInfo r0 = new ChameleonResInfo(null, null, 3, null);
        if (r9 != null) goto L47;
    L46:
        return r0;
    L47:
        String r1 = r9.readLine();     // Catch: Throwable -> L36 IOException -> L38
        if (r1 == null) goto L35;
        boolean r5 = false;
        if (StringsKt.startsWith$default(r1, Keys.API_RETURN_KEY_VERSION, false, 2, null) != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L47;
        List r2 = new Regex(":").split(r1, 0);     // Catch: Throwable -> L36 IOException -> L38
        if (r2 != null) goto L14;
    L27:
        String[] r4 = null;
    L28:
        if (r4 != null) goto L30;
    L32:
        if (r5 == false) goto L47;
        r0.setVersion(r4[1]);     // Catch: Throwable -> L36 IOException -> L38
        goto L47
    L30:
        if (r4.length != 2) goto L32;
        r5 = true;
        goto L32
    L14:
        if (r2.isEmpty() == true) goto L24;
        ListIterator r6 = r2.listIterator(r2.size());     // Catch: Throwable -> L36 IOException -> L38
    L17:
        if (r6.hasPrevious() == false) goto L24;
        if (((String) r6.previous()).length() != 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L17;
        List r8 = CollectionsKt.take(r2, r6.nextIndex() + 1);     // Catch: Throwable -> L36 IOException -> L38
    L25:
        if (r8 == null) goto L27;
        r4 = (String[]) r8.toArray(new String[0]);     // Catch: Throwable -> L36 IOException -> L38
        goto L28
    L21:
        r7 = false;
    L24:
        r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L36 IOException -> L38
        goto L25
    L9:
        r3 = false;
    L35:
        INSTANCE.closeSafe(r9);
        goto L46
    L36:
        th = move-exception;
        INSTANCE.closeSafe(r9);
        throw th;
    L38:
        e = move-exception;
        String r10 = e.getMessage();     // Catch: Throwable -> L36
        if (r10 != null) goto L42;
        r10 = "Unknown error";
    L42:
        Log.e(TAG, r10, e);     // Catch: Throwable -> L36
        goto L35
    }

    public final String convertString(InputStream r9) {
        StringBuffer r0 = new StringBuffer();
        Closeable r2 = null;
        if (r9 != null) goto L38;
    L22:
        Log.e(TAG, "convertString()... steam is invalid");     // Catch: Throwable -> L18 IOException -> L20
        String r1 = r0.toString();     // Catch: Throwable -> L18 IOException -> L20
        closeSafe(r9);
        closeSafe(null);
        return r1;
    L38:
    L20:
        e = move-exception;
        BufferedReader r3 = null;
        IOException e = e;
    L25:
        String r4 = e.getMessage();     // Catch: Throwable -> L31
        if (r4 != null) goto L28;
        r4 = "Unknown error";
    L28:
        Log.e(TAG, r4, e);     // Catch: Throwable -> L31
    L29:
        closeSafe(r9);
        closeSafe(r3);
        return r0.toString();
    L31:
        th = th;
        r2 = r3;
    L33:
        closeSafe(r9);
        closeSafe(r2);
        throw th;
    L18:
        th = th;
        goto L33
    L5:
        if (r9.available() <= 0) goto L22;
        r3 = new BufferedReader(new InputStreamReader(r9));     // Catch: Throwable -> L18 IOException -> L20
        String r5 = null;
    L35:
        String r6 = r3.readLine();     // Catch: IOException -> L16 Throwable -> L31
        if (r6 == null) goto L12;
        r5 = r6;
    L13:
        if (r6 == null) goto L29;
        r0.append(r5 + System.getProperty("line.separator"));     // Catch: IOException -> L16 Throwable -> L31
        goto L35
    L12:
        r6 = null;
    L16:
        e = e;
        goto L25
    }

    public final String getOfflineFileVersion(String r3) {
        if (r3 == null) goto L18;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3, ChameleonResConstants.TEMPLATE_VERSION);
        if (r0.isFile() == true) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if (r0.exists() == false) goto L20;
        return getOfflineResVersion(new BufferedReader(new PolarisFileReaderWrapper(r0)));
    L9:
        e = move-exception;
        String r1 = e.getMessage();
        if (r1 != null) goto L13;
        r1 = "Unknown error";
    L13:
        Log.e(TAG, r1, e);
        return BuildConfig.FLAVOR;
    L20:
        return BuildConfig.FLAVOR;
    L18:
        return BuildConfig.FLAVOR;
    }

    private final File getOfflineParentDir(ChameleonConfig r3, String r4) {
        File r0 = new PolarisFileWrapper(getWebcontainerRootDir());
        if (r3 == null) goto L9;
        ResConfig r5 = r3.getResConfig();
        if (r5 == null) goto L9;
        String r6 = r5.getRootPath();
        if (r6 == null) goto L9;
        r0 = new PolarisFileWrapper(r0, r6);
    L9:
        if (r4 == null) goto L12;
        r0 = new PolarisFileWrapper(r0, r4);
    L12:
        if (r0.exists() == true) goto L14;
        r0.mkdirs();
    L18:
        return r0;
    L14:
        if (r0.isFile() == false) goto L16;
        r0.delete();
    L16:
        r0.mkdirs();
        goto L18
    }

    private final void pickUpFiles(File[] r5, ArrayList<File> r6) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        File r2 = r5[r1];
        if (CommonResUtils.isValidVersion(r2.getName()) == false) goto L7;
        r6.add(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public final ChameleonResInfo getResInfoOf7z(ChameleonConfig r10, String r11) {
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
        if (r10 == null) goto L12;
        ResConfig r12 = r10.getResConfig();
        if (r12 == null) goto L12;
        String r3 = r12.getOfflineZipName();
        if (r3 == null) goto L12;
        List r13 = StringsKt.split$default(r3, new String[]{"."}, false, 0, 6, null);
        if (r13 == null) goto L12;
        String r14 = (String) ListProtector.get(r13, 0);
        if (r14 == null) goto L12;
    L13:
        r1.append(r14);
        r1.append(File.separator);
        r1.append(ChameleonResConstants.TEMPLATE_VERSION);
        String r15 = LzmaUtils.extract7zEntry(r11, r1.toString());
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r15) == false) goto L17;
        r2 = -1;
    L17:
        r4.put(ChameleonOpenTracker.ParamKey.RESULT, r2);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r15) == false) goto L22;
        Log.e(TAG, "get versioninfo is null");     // Catch: Exception -> L23
        return new ChameleonResInfo(null, null, 3, null);
    L22:
        return getResInfo(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r15.getBytes(Charsets.UTF_8)))));
    L23:
        e = move-exception;
        Log.e(TAG, "getResInfoOf7z: report event fails:" + e);
        return new ChameleonResInfo(null, null, 3, null);
    L12:
        r14 = BuildConfig.FLAVOR;
        goto L13
    }

    public final File getResourceRootDir(ChameleonConfig r1, String r2) throws IOException {
        return getOfflineParentDir(r1, r2);
    }
}
