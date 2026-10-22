package v98;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    static {
    }

    public static double a(List r7) {
        Intrinsics.checkNotNullParameter(r7, "filePaths");
        Intrinsics.checkNotNullParameter(r7, "filePaths");
        Iterator r8 = r7.iterator();
        long r0 = 0;
    L4:
        if (r8.hasNext() == false) goto L15;
        String r2 = (String) r8.next();
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);     // Catch: Exception -> L12
        if (r3.exists() == false) goto L4;
        if (r3.isFile() == false) goto L4;
        r0 = r0 + r3.length();
    L12:
        e = move-exception;
        FLogger.a.w("FilePathsSizeCalculator", "Error getting size for " + r2 + ": " + e.getMessage());
        goto L4
    L15:
        return r0 / 1048576.0d;
    }
}
