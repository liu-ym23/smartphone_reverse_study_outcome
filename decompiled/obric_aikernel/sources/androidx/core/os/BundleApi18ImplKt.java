package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
final class BundleApi18ImplKt {
    public static final BundleApi18ImplKt INSTANCE = null;

    static {
        INSTANCE = new BundleApi18ImplKt();
    }

    private BundleApi18ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final void putBinder(Bundle r10, String r11, IBinder r12) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        Intrinsics.checkNotNullParameter(r11, "key");
        r10.putBinder(r11, r12);
    }
}
