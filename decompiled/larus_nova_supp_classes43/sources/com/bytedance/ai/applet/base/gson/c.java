package com.bytedance.ai.applet.base.gson;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
    }

    public static final Gson a() {
        return (Gson) a.getValue();
    }
}
