package f4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final e3.d r10, final boolean r11, final Class r12, final String r13, final f3.h r14) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "resultClass");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r14, "callback");
        p2.c.d(new p(r10, r13, r14, r11, r12));
    }
}
