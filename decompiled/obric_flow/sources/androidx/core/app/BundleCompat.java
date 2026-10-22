package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class BundleCompat {
    private BundleCompat() {
    }

    @Nullable
    public static IBinder getBinder(@NonNull Bundle r5, @Nullable String r10) {
        return r5.getBinder(r10);
    }

    public static void putBinder(@NonNull Bundle r5, @Nullable String r10, @Nullable IBinder r11) {
        r5.putBinder(r10, r11);
    }
}
