package k69;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import g49.d;
import java.io.File;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r6, String[] r7) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6);
        if (r0.exists() == true) goto L5;
    L25:
        return false;
    L5:
        if (r0.isDirectory() == false) goto L25;
        File[] r8 = r0.listFiles();
        if (r8 == null) goto L23;
        Iterator r9 = ArrayIteratorKt.iterator(r8);
    L11:
        if (r9.hasNext() == false) goto L37;
        File r1 = (File) r9.next();
        if (r1.isDirectory() == true) goto L15;
        if (ArraysKt.contains(r7, r1.getName()) == true) goto L19;
        boolean r2 = r1.delete();
        d.d("DoraOTAUtils", "deleteAllFilesInDirectory: " + r1.getAbsolutePath() + ' ' + r2);
        if (r2 == true) goto L11;
        return false;
    L19:
        d.d("DoraOTAUtils", "deleteAllFilesInDirectory: " + r1.getAbsolutePath() + " exclude");
        goto L11
    L15:
        if (a(r1.getAbsolutePath(), r7) == true) goto L11;
        return false;
    L37:
        return true;
    L23:
        return true;
    }
}
