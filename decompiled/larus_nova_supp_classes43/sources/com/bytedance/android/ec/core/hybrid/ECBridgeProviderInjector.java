package com.bytedance.android.ec.core.hybrid;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import ti.h;
import ti.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECBridgeProviderInjector implements h {
    public static final Lazy b = null;
    public final List<i> a;

    public static final class a {
        public static ECBridgeProviderInjector a() {
            return (ECBridgeProviderInjector) ECBridgeProviderInjector.b.getValue();
        }
    }

    static {
        b = LazyKt.lazy(ECBridgeProviderInjector$Companion$INSTANCE$2.INSTANCE);
    }

    public ECBridgeProviderInjector() {
        this.a = new CopyOnWriteArrayList();
    }
}
