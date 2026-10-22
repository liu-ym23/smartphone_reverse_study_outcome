package com.ss.android.lark.chameleon.util;

import android.text.TextUtils;
import com.bytedance.ee.bear.libarchive.Archive;
import com.ss.android.lark.chameleon.idependency.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LzmaUtils {
    private static final String TAG = null;

    public LzmaUtils() {
    }

    static {
        TAG = "LzmaUtils";
    }

    public static int extract7z(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L14:
        return -1;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
    L12:
        e = move-exception;
        Log.e(TAG, "extractAll fails : " + e + "  message:" + e.getMessage());
        goto L14
    L8:
        if (r4.endsWith("/") == true) goto L10;
        r4 = r4 + File.separator;     // Catch: IOException -> L12
    L10:
        return Archive.extractAll(r3, r4, null, 0);
    }

    public static String extract7zEntry(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        return Archive.extractEntryToString(r4, r5, null);
    L9:
        e = move-exception;
        Log.e(TAG, "extractEntry :" + r5 + " fails : " + e + " message:" + e.getMessage());
        goto L11
    }
}
