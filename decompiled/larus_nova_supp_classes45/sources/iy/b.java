package iy;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final boolean a = false;

    static {
        a = ((Boolean) vm2.d.e.getValue(null, vm2.d.a[3])).booleanValue();
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (a == true) goto L7;
        ALogger.e("AnchorModeLinkDynamicWidget", r1);
        return;
    }

    public static void d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (a == true) goto L7;
        ALogger.i("AnchorModeLinkDynamicWidget", r1);
        return;
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (a == true) goto L7;
        ALogger.d(r1, r2);
        return;
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (a == true) goto L7;
        ALogger.e(r1, r2);
        return;
    }

    public static void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (a == true) goto L7;
        ALogger.i(r1, r2);
        return;
    }
}
