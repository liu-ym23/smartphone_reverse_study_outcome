package androidx.core.content;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ContextCompat$Api24Impl {
    private ContextCompat$Api24Impl() {
    }

    public static Context createDeviceProtectedStorageContext(Context r0) {
        return r0.createDeviceProtectedStorageContext();
    }

    public static File getDataDir(Context r0) {
        return r0.getDataDir();
    }

    public static boolean isDeviceProtectedStorage(Context r0) {
        return r0.isDeviceProtectedStorage();
    }
}
