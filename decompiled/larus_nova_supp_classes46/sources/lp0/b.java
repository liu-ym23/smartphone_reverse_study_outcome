package lp0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final mp0.a a(j r2) {
        m r0 = m.e;
        if (r2 != null) goto L5;
        r0.getClass();
        r2 = m.d;
    L5:
        a r3 = (a) r0.a(r2, a.class);
        if (r3 != null) goto L10;
        return null;
    L10:
        return (mp0.a) r0.d(r3, mp0.a.class);
    }

    public static final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c c(a r0) {
        if (r0 == null) goto L6;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r1 = r0.getRoot();
        if (r1 == null) goto L6;
        return r1.dE();
    L6:
        return null;
    }

    public static final boolean d(a r0) {
        if (r0 == null) goto L8;
        so0.a r1 = r0.w();
        if (r1 == null) goto L8;
        OpenPlatformContext r2 = r1.a();
        if (r2 == null) goto L8;
        return r2.isInLive();
    L8:
        return false;
    }

    public static final <T extends OpenPlatformContextService> T b(a r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "cls");
        if (r1 == null) goto L9;
        so0.a r3 = r1.w();
        if (r3 == null) goto L9;
        OpenPlatformContext r4 = r3.a();
        if (r4 == null) goto L9;
        return (T) r4.getService(r2);
    L9:
        return null;
    }
}
