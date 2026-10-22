package com.ss.android.lark.chameleon.util;

import android.os.Environment;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/util/ExternalStorageUtils;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "getExternalStoragePath", "Ljava/io/File;", "dirName", "getFileNameFromPath", "filePath", "getUniqueFileNameWithNumber", "fileName", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExternalStorageUtils {
    public static final ExternalStorageUtils INSTANCE = null;
    private static final String TAG = "ExternalStorageUtils";

    static {
        INSTANCE = new ExternalStorageUtils();
    }

    private ExternalStorageUtils() {
    }

    private final File getExternalStoragePath(String r4) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().toString() + File.separator + r4);
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    @JvmStatic
    public static final String getFileNameFromPath(String r4) {
        if (r4 == null) goto L27;
        String r5 = StringsKt.trim(r4).toString();     // Catch: Exception -> L24
        if (r5 == null) goto L28;
        boolean r2 = true;
        if (r5.length() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        return null;
    L13:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r5);     // Catch: Exception -> L24
        if (StringsKt.isBlank(r3.getName()) == false) goto L16;
        return null;
    L16:
        String r6 = StringsKt.trim(r3.getName()).toString();     // Catch: Exception -> L24
        if (r6.length() == 0) goto L20;
        r2 = false;
    L20:
        if (r2 == false) goto L23;
        return null;
    L23:
        return r6;
    L10:
        r1 = false;
        goto L11
    L28:
        return null;
    L30:
        return null;
    L27:
        return null;
    }

    @JvmStatic
    public static final String getUniqueFileNameWithNumber(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "dirName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        String r12 = new Regex(PatternProtector.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]")).replace(r11, "_");
        File r13 = INSTANCE.getExternalStoragePath(r10);     // Catch: Exception -> L28
        if (r13.mkdirs() == false) goto L6;
    L9:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r13, r12);     // Catch: Exception -> L28
        Integer r2 = Integer.valueOf(StringsKt.lastIndexOf$default(r12, '.', 0, false, 6, null));     // Catch: Exception -> L28
        int r4 = 0;
        if (r2.intValue() < 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L18;
        int r5 = r2.intValue();     // Catch: Exception -> L28
    L19:
        String r6 = r12;
    L21:
        if (r1.exists() == false) goto L24;
        if (r4 >= 100) goto L24;
        r4 = r4 + 1;     // Catch: Exception -> L28
        StringBuilder r7 = new StringBuilder(r12);     // Catch: Exception -> L28
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L28
        r8.append('(');     // Catch: Exception -> L28
        r8.append(r4);     // Catch: Exception -> L28
        r8.append(')');     // Catch: Exception -> L28
        r6 = r7.insert(r5, r8.toString()).toString();     // Catch: Exception -> L28
        r1 = new PolarisFileWrapper(r13, r6);     // Catch: Exception -> L28
    L24:
        if (r4 < 100) goto L26;
        Log.w(TAG, "failed maxRetryCount 100 ");     // Catch: Exception -> L28
        StringBuilder r14 = new StringBuilder(r12);     // Catch: Exception -> L28
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L28
        r9.append('(');     // Catch: Exception -> L28
        r9.append(100);     // Catch: Exception -> L28
        r9.append(')');     // Catch: Exception -> L28
        r6 = r14.insert(r5, r9.toString()).toString();     // Catch: Exception -> L28
    L26:
        Log.i(TAG, "new file name ：" + r6 + "，count：" + r4);     // Catch: Exception -> L28
        return r6;
    L18:
        r5 = r12.length();     // Catch: Exception -> L28
        goto L19
    L12:
        r3 = false;
        goto L13
    L6:
        if (r13.exists() == true) goto L9;
        Log.i(TAG, " use default legal file name：" + r13.getAbsolutePath());     // Catch: Exception -> L28
        return r12;
    L28:
        e = move-exception;
        Log.e(TAG, "error:", e);
        return r12;
    }
}
