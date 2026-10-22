package ew1;

import com.bytedance.android.live.core.utils.f0;
import com.bytedance.crash.d;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void a(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "error");
        int r1 = f0.a;
        String r4 = "DrawerHistoryExpCollect->".concat(r2);
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r3, "error");
        d.d(r3, r4);
    }
}
