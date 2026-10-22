package com.ss.android.lark.imageocr.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DrawObjectsPool {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;

    static {
        a = LazyKt.lazy(DrawObjectsPool$dp05$2.INSTANCE);
        b = LazyKt.lazy(DrawObjectsPool$dp1$2.INSTANCE);
        c = LazyKt.lazy(DrawObjectsPool$dp2$2.INSTANCE);
        d = LazyKt.lazy(DrawObjectsPool$dp12$2.INSTANCE);
        e = LazyKt.lazy(DrawObjectsPool$dp16$2.INSTANCE);
        f = LazyKt.lazy(DrawObjectsPool$hollowUnselectedStrokePaint$2.INSTANCE);
        g = LazyKt.lazy(DrawObjectsPool$hollowSelectedStrokePaint$2.INSTANCE);
        h = LazyKt.lazy(DrawObjectsPool$hollowSelectedFillPaint$2.INSTANCE);
        i = LazyKt.lazy(DrawObjectsPool$paint$2.INSTANCE);
        j = LazyKt.lazy(DrawObjectsPool$rectF$2.INSTANCE);
        k = LazyKt.lazy(DrawObjectsPool$rect$2.INSTANCE);
        l = LazyKt.lazy(DrawObjectsPool$path$2.INSTANCE);
        m = LazyKt.lazy(DrawObjectsPool$path2$2.INSTANCE);
        n = LazyKt.lazy(DrawObjectsPool$matrix$2.INSTANCE);
        o = LazyKt.lazy(DrawObjectsPool$region$2.INSTANCE);
    }

    public static float a() {
        return ((Number) c.getValue()).floatValue();
    }
}
