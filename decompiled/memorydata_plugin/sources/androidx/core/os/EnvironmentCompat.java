package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    static class Api19Impl {
        private Api19Impl() {
        }

        static String getStorageState(File r0) {
            return Environment.getStorageState(r0);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getExternalStorageState(File r0) {
            return Environment.getExternalStorageState(r0);
        }
    }

    private EnvironmentCompat() {
    }

    public static String getStorageState(File r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getExternalStorageState(r2);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed to resolve canonical path: " + e);
        return "unknown";
    L11:
        if (r2.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) == false) goto L20;
        return Environment.getExternalStorageState();
    L20:
        return "unknown";
    L9:
        return Api19Impl.getStorageState(r2);
    }
}
