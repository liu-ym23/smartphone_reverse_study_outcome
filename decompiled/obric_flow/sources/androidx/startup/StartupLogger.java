package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void e(@NonNull String r5, @Nullable Throwable r10) {
        Log.e(TAG, r5, r10);
    }

    public static void i(@NonNull String r5) {
        Log.i(TAG, r5);
    }

    public static void w(@NonNull String r5) {
        Log.w(TAG, r5);
    }
}
