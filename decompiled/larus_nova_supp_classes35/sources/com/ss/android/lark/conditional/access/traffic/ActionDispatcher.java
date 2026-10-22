package com.ss.android.lark.conditional.access.traffic;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import s8b.g;
import s8b.h;
import s8b.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ActionDispatcher {
    public static final Lazy a = null;
    public static final Set<Class<? extends q8b.c>> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = LazyKt.lazy(ActionDispatcher$condAccessHandlers$2.INSTANCE);
        b = SetsKt.setOf(new Class[]{i.class, s8b.b.class, s8b.f.class, s8b.c.class, g.class, s8b.e.class, h.class});
        c = LazyKt.lazy(ActionDispatcher$filePolicyHandlers$2.INSTANCE);
        d = LazyKt.lazy(ActionDispatcher$handlers$2.INSTANCE);
    }
}
