package sia;

import android.graphics.BlurMaskFilter;
import android.widget.TextView;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "dir");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);
        if (r0.isDirectory() == true) goto L6;
        FLogger.a.i("EnrollFileUtils", "createDirIfNotExists with " + r4);
        r0.mkdirs();
        return;
    }

    @JvmStatic
    public static final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "filePath");
        PolarisFileWrapper r2 = new PolarisFileWrapper(r4);     // Catch: Exception -> L18
        if (r2.isDirectory() == false) goto L15;
        File[] r5 = r2.listFiles();     // Catch: Exception -> L18
        if (r5 == null) goto L12;
        Iterator r6 = ArrayIteratorKt.iterator(r5);     // Catch: Exception -> L18
    L9:
        if (r6.hasNext() == false) goto L12;
        b(((File) r6.next()).getPath());     // Catch: Exception -> L18
    L12:
        if (r2.delete() == true) goto L23;
        FLogger.a.e("EnrollFileUtils", "Fails to delete directory = " + r2.getPath());     // Catch: Exception -> L18
        return;
    L23:
        return;
    L15:
        if (r2.delete() == true) goto L25;
        FLogger.a.e("EnrollFileUtils", "Fails to delete file = " + r2.getPath());     // Catch: Exception -> L18
        return;
    L25:
        return;
    L18:
        e = move-exception;
        FLogger.a.e("EnrollFileUtils", "deleteFile error: " + e.getMessage());
    }

    @JvmStatic
    public static final void c(TextView r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        FLogger.a.i("EnrollFileUtils", "setBlur radius: " + r4);
        r3.getPaint().setMaskFilter(new BlurMaskFilter(r4, BlurMaskFilter.Blur.NORMAL));
        r3.postInvalidate();
    }
}
