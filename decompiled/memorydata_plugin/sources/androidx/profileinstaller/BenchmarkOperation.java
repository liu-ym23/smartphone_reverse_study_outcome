package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class BenchmarkOperation {

    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File getCodeCacheDir(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getCodeCacheDir();
        }
    }

    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static File getDeviceProtectedCodeCacheDir(Context r2) {
            return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).createDeviceProtectedStorageContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCodeCacheDir();
        }
    }

    private BenchmarkOperation() {
    }

    static boolean deleteFilesRecursively(File r6) {
        if (r6.isDirectory() == false) goto L16;
        File[] r7 = r6.listFiles();
        if (r7 != null) goto L7;
        return false;
    L7:
        int r2 = r7.length;
        int r3 = 0;
        boolean r4 = true;
    L8:
        if (r3 >= r2) goto L15;
        if (deleteFilesRecursively(r7[r3]) == false) goto L13;
        if (r4 == false) goto L13;
        r4 = true;
    L14:
        r3 = r3 + 1;
    L13:
        r4 = false;
        goto L14
    L15:
        return r4;
    L16:
        r6.delete();
        return true;
    }

    static void dropShaderCache(Context r2, ProfileInstallReceiver.ResultDiagnostics r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        File r5 = Api24ContextHelper.getDeviceProtectedCodeCacheDir(r4);
    L10:
        if (deleteFilesRecursively(r5) == false) goto L12;
        int r6 = 14;
    L13:
        r3.onResultReceived(r6, null);
        return;
    L12:
        r6 = 15;
        goto L13
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r5 = Api21ContextHelper.getCodeCacheDir(r4);
        goto L10
    L8:
        r5 = r4.getCacheDir();
        goto L10
    }
}
