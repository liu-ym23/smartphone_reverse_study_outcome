package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class BenchmarkOperation {

    @RequiresApi(api = 21)
    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File getCodeCacheDir(Context r10) {
            return r10.getCodeCacheDir();
        }
    }

    @RequiresApi(api = 24)
    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static File getDeviceProtectedCodeCacheDir(Context r10) {
            return r10.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    private BenchmarkOperation() {
    }

    static boolean deleteFilesRecursively(File r10) {
        if (r10.isDirectory() == false) goto L16;
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L7;
        return false;
    L7:
        int r12 = r11.length;
        int r13 = 0;
        boolean r14 = true;
    L8:
        if (r13 >= r12) goto L15;
        if (deleteFilesRecursively(r11[r13]) == false) goto L13;
        if (r14 == false) goto L13;
        r14 = true;
    L14:
        r13 = r13 + 1;
    L13:
        r14 = false;
        goto L14
    L15:
        return r14;
    L16:
        r10.delete();
        return true;
    }

    static void dropShaderCache(@NonNull Context r10, @NonNull ProfileInstallReceiver.ResultDiagnostics r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 24) goto L6;
        File r13 = Api24ContextHelper.getDeviceProtectedCodeCacheDir(r10);
    L10:
        if (deleteFilesRecursively(r13) == false) goto L12;
        int r14 = 14;
    L13:
        r11.onResultReceived(r14, null);
        return;
    L12:
        r14 = 15;
        goto L13
    L6:
        if (r12 < 23) goto L8;
        r13 = Api21ContextHelper.getCodeCacheDir(r10);
        goto L10
    L8:
        r13 = r10.getCacheDir();
        goto L10
    }
}
