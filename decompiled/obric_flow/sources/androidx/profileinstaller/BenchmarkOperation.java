package androidx.profileinstaller;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class BenchmarkOperation {

    @RequiresApi(api = 21)
    public static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        public static File getCodeCacheDir(Context r5) {
            return r5.getCodeCacheDir();
        }
    }

    @RequiresApi(api = 24)
    public static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        public static File getDeviceProtectedCodeCacheDir(Context r5) {
            return r5.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    private BenchmarkOperation() {
    }

    public static boolean deleteFilesRecursively(File r10) {
        if (r10.isDirectory() == false) goto L16;
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L7;
        return false;
    L7:
        int r5 = r11.length;
        int r12 = 0;
        boolean r13 = true;
    L8:
        if (r12 >= r5) goto L15;
        if (deleteFilesRecursively(r11[r12]) == false) goto L13;
        if (r13 == false) goto L13;
        r13 = true;
    L14:
        r12 = r12 + 1;
    L13:
        r13 = false;
        goto L14
    L15:
        return r13;
    L16:
        r10.delete();
        return true;
    }

    public static void dropShaderCache(@NonNull Context r5, @NonNull ProfileInstallReceiver.ResultDiagnostics r10) {
        if (deleteFilesRecursively(Api24ContextHelper.getDeviceProtectedCodeCacheDir(r5)) == false) goto L5;
        r10.onResultReceived(14, null);
        return;
    L5:
        r10.onResultReceived(15, null);
    }
}
