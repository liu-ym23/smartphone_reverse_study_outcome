package com.ss.android.lark.chameleon.container.webcontainer.util;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CommonResUtils {
    public static final String TAG = "CommonResUtils";
    public static final int VERSION_ERROR = -2;
    public static final int VERSION_UPDATE = -1;

    public CommonResUtils() {
    }

    public static boolean isValidVersion(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", r1);
    }

    public static void sortValidFiles(List<File> r1) {
        Collections.sort(r1, new AnonymousClass1());
    }

    public static int compareVersions(String r7, String r8) {
    L36:
        return -2;
    L4:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return -2;
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return -1;
    L10:
        if (TextUtils.equals(r7, r8) == false) goto L12;
        return 0;
    L12:
        String[] r9 = r7.split("\\.");     // Catch: Exception -> L36
        String[] r10 = r8.split("\\.");     // Catch: Exception -> L36
        int r0 = Math.min(r9.length, r10.length);     // Catch: Exception -> L36
        int r2 = 0;
        int r5 = 0;
    L13:
        if (r2 >= r0) goto L18;
        r5 = CastIntegerProtector.parseInt(r9[r2]) - CastIntegerProtector.parseInt(r10[r2]);     // Catch: Exception -> L36
        if (r5 != 0) goto L18;
        r2 = r2 + 1;     // Catch: Exception -> L36
    L18:
        if (r5 != 0) goto L33;
        int r6 = r2;
    L21:
        if (r6 >= r9.length) goto L26;
        if (CastIntegerProtector.parseInt(r9[r6]) > 0) goto L24;
        r6 = r6 + 1;     // Catch: Exception -> L36
        goto L21
    L24:
        return 1;
    L26:
        if (r2 >= r10.length) goto L32;
        if (CastIntegerProtector.parseInt(r10[r2]) > 0) goto L30;
        r2 = r2 + 1;
        goto L26
    L30:
        return -1;
    L32:
        return 0;
    L33:
        if (r5 <= 0) goto L45;
        return 1;
    L45:
        return -1;
    }
}
