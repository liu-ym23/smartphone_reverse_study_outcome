package com.larksuite.framework.utils;

import android.content.Context;
import android.os.Environment;
import com.larksuite.framework.utils.file.direct.DirectFileAccess;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l {
    public static String a(Context r11) {
        int r0 = DirectFileAccess.a.i;
        DirectFileAccess.a.C0054a r1 = new DirectFileAccess.a.C0054a();
        r1.d = r11;
        r1.b = DirectFileAccess.StorageLocation.EXTERNAL;
        r1.c = DirectFileAccess.PathType.CACHE;
        DirectFileAccess.c r2 = DirectFileAccess.a;
        Intrinsics.checkNotNullParameter(r1, "paramsBuilder");
        File r3 = DirectFileAccess.a(new DirectFileAccess.a(r1.a, r1.b, r1.c, null, r1.d, r1.e, r1.f, null));
        if (r3 != null) goto L5;
        r3 = r11.getCacheDir();
    L5:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3.getPath();
    }

    public static String b(Context r11) {
        int r0 = DirectFileAccess.a.i;
        DirectFileAccess.a.C0054a r1 = new DirectFileAccess.a.C0054a();
        r1.d = r11;
        r1.b = DirectFileAccess.StorageLocation.EXTERNAL;
        r1.c = DirectFileAccess.PathType.FILES;
        DirectFileAccess.c r2 = DirectFileAccess.a;
        Intrinsics.checkNotNullParameter(r1, "paramsBuilder");
        File r3 = DirectFileAccess.a(new DirectFileAccess.a(r1.a, r1.b, r1.c, null, r1.d, r1.e, r1.f, null));
        if (r3 != null) goto L5;
        r3 = r11.getFilesDir();
    L5:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3.getPath();
    }

    public static String c(Context r0) {
        File r1 = r0.getFilesDir();
        if (r1 != null) goto L7;
        return "";
    L7:
        return r1.getPath();
    }

    public static String d(Context r2) {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L5;
        File r0 = Environment.getExternalStorageDirectory();
    L6:
        if (r0 != null) goto L8;
        r0 = r2.getFilesDir();
    L8:
        if (r0 != null) goto L12;
        return "";
    L12:
        return r0.getPath();
    L5:
        r0 = null;
        goto L6
    }
}
