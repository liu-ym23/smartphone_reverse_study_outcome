package com.obric.matrix.platform.sdk.ones.init;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class BaseComponentInitHelper {
    public static final BaseComponentInitHelper a = null;
    public static final AtomicBoolean b = null;
    public static final Lazy c = null;

    public BaseComponentInitHelper() {
    }

    static {
        a = new BaseComponentInitHelper();
        new AtomicBoolean(false);
        b = new AtomicBoolean(false);
        new AtomicBoolean(true);
        new AtomicBoolean(false);
        c = LazyKt.lazy(BaseComponentInitHelper$initExecutor$2.INSTANCE);
    }
}
