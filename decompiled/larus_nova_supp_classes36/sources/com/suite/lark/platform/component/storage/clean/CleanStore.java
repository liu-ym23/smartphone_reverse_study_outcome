package com.suite.lark.platform.component.storage.clean;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CleanStore {
    public static final HashMap<String, Object> a = null;
    public static final HashMap<String, CleanRequest<? extends f>> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = new HashMap();
        b = new HashMap();
        c = LazyKt.lazy(CleanStore$diskCacheRepo$2.INSTANCE);
        d = LazyKt.lazy(CleanStore$gson$2.INSTANCE);
    }
}
