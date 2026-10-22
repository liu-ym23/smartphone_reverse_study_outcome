package lf;

import cf.l;
import com.bytedance.android.ec.base.service.ECServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(boolean r1) {
        boolean r0 = ECServiceManager.a;
        l r10 = (l) ECServiceManager.c(l.class);
        if (r10 == null) goto L6;
        r10.Oa(r1);
        return;
    }

    public static void a(int r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, "upon");
        boolean r0 = ECServiceManager.a;
        l r11 = (l) ECServiceManager.c(l.class);
        if (r11 == null) goto L6;
        r11.Aa(r1, r10);
        return;
    }
}
