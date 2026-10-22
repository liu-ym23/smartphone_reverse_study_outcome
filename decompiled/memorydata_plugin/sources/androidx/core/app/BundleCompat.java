package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle r0, String r1) {
        return androidx.core.os.BundleCompat.getBinder(r0, r1);
    }

    public static void putBinder(Bundle r2, String r3, IBinder r4) {
        androidx.core.os.BundleCompat.putBinder(r2, r3, (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin"));
    }
}
