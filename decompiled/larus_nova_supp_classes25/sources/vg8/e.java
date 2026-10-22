package vg8;

import android.view.View;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(new b());
        b = LazyKt.lazy(new c());
        c = LazyKt.lazy(new d());
    }

    public static boolean b() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static uvc.b a(uvc.b r3) {
        uvc.b r0 = com.larus.business.markdown.impl.widget.f.c(r3);
        if (r0 != null) goto L5;
        return null;
    L5:
        r0.f = r3.f;
        uvc.b r4 = r3.b;
    L6:
        if (r4 == null) goto L11;
        uvc.b r2 = a(r4);
        if (r2 == null) goto L9;
        r0.b(r2);
        r4 = r4.e;
        goto L6
    L9:
        return null;
    L11:
        return r0;
    }

    public static void c(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (b() == true) goto L5;
        return;
    L5:
        ((Map) c.getValue()).remove(r1);
    }
}
