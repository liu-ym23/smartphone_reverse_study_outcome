package za;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.h;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, Function0 r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        b(3, r1, r10);
    }

    public static void b(int r10, String r11, Function0 r12) {
        if (r10 != 3) goto L8;
        if (h.h.a == false) goto L8;
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.f(r11, (String) r12.invoke(), null, 12);
        return;
    L8:
        if (r10 != 4) goto L10;
    L11:
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.m(r11, (String) r12.invoke(), null, null, 12);
        return;
    L10:
        if (r10 == 5) goto L11;
    }
}
