package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class BundleApi21ImplKt {
    public static final BundleApi21ImplKt INSTANCE = null;

    static {
        INSTANCE = new BundleApi21ImplKt();
    }

    private BundleApi21ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final void putSize(Bundle r10, String r11, Size r12) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        Intrinsics.checkNotNullParameter(r11, "key");
        r10.putSize(r11, r12);
    }

    @JvmStatic
    @DoNotInline
    public static final void putSizeF(Bundle r10, String r11, SizeF r12) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        Intrinsics.checkNotNullParameter(r11, "key");
        r10.putSizeF(r11, r12);
    }
}
