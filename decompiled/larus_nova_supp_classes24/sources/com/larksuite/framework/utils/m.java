package com.larksuite.framework.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m {
    public static Uri a(Context r2, File r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return FileProvider.getUriForFile(r2, r2.getPackageName() + ".common.fileprovider", r3);
    L6:
        return Uri.fromFile(r3);
    }
}
