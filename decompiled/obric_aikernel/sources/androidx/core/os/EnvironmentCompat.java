package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static String getStorageState(File r10) {
            return Environment.getStorageState(r10);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String getExternalStorageState(File r10) {
            return Environment.getExternalStorageState(r10);
        }
    }

    private EnvironmentCompat() {
    }

    @NonNull
    public static String getStorageState(@NonNull File r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 21) goto L7;
        return Api21Impl.getExternalStorageState(r10);
    L7:
        if (r11 >= 19) goto L9;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed to resolve canonical path: " + e);
        return "unknown";
    L11:
        if (r10.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) == false) goto L20;
        return Environment.getExternalStorageState();
    L20:
        return "unknown";
    L9:
        return Api19Impl.getStorageState(r10);
    }
}
