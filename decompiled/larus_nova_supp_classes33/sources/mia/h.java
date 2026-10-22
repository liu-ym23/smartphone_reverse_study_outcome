package mia;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h {
    public static Context a;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    static {
        b = LazyKt.lazy(new b());
        c = LazyKt.lazy(new c());
        d = LazyKt.lazy(new d());
        e = LazyKt.lazy(new e());
        f = LazyKt.lazy(new f());
        g = LazyKt.lazy(new g());
    }

    public final Context getContext() {
        return a;
    }

    public static float a(int r1) {
        Context r0 = a;
        if (r0 == null) goto L7;
        Resources r2 = r0.getResources();
        if (r2 == null) goto L7;
        return r2.getDimension(r1);
    L7:
        return 0.0f;
    }
}
