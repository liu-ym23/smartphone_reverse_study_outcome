package py8;

import android.companion.CompanionDeviceManager;
import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final b a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L17;
        CompanionDeviceManager r3 = (CompanionDeviceManager) r2.getSystemService(CompanionDeviceManager.class);
        if (r3 == null) goto L15;
        if (r0 < 33) goto L10;
        return new f(r3);
    L10:
        if (r0 < 31) goto L13;
        return new e(r3);
    L13:
        return new d(r3);
    L15:
        return new g();
    L17:
        return new g();
    }
}
