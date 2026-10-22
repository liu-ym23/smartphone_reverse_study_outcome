package e72;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(List r4) {
        Intrinsics.checkNotNullParameter(r4, "fileList");
        if ((!r4.isEmpty()) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L12;
        a r0 = new a();
        String[][] r1 = new String[1][];
        Object[] r5 = r4.toArray(new String[0]);
        if (r5 == null) goto L11;
        r1[0] = (String[]) r5;
        r0.execute1(r1);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L12:
        ALogger.d("HighlightBacktrackUtil", "delete all temp file");
    }

    public static boolean b(String r2) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        if (r0.exists() == false) goto L9;
        if (r0.isDirectory() == false) goto L9;
        return true;
    L9:
        if (r0.exists() == false) goto L15;
        if (r0.delete() == true) goto L15;
        Logger.e("HighlightBacktrackUtil", "Can not delete file: " + r0.getAbsolutePath());
        return false;
    L15:
        return r0.mkdirs();
    }

    public static String c(Context r3) {
        if (r3 != null) goto L20;
    L10:
        String r4 = null;
    L11:
        if (r4 != null) goto L13;
        return null;
    L13:
        String r5 = r4 + File.separator + "highlight";     // Catch: Exception -> L17
        if (b(r5) == true) goto L16;
        return null;
    L16:
        return r5;
    L17:
        e = move-exception;
        Logger.e("HighlightBacktrackUtil", "get backtrack cache file path error: " + e.toString());
        return null;
    L20:
        File r1 = r3.getExternalCacheDir();     // Catch: Exception -> L17
        if (r1 != null) goto L8;
        r1 = r3.getCacheDir();     // Catch: Exception -> L17
    L8:
        if (r1 == null) goto L10;
        r4 = r1.getAbsolutePath();     // Catch: Exception -> L17
        goto L11
    }
}
