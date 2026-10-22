package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements ReadWriteProperty<Object, T> {
    public final String a;
    public final T b;
    public final w0<T> c;

    public static final class a {
    }

    static {
    }

    public final T getValue(Object r2, KProperty<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        return (T) this.c.a.invoke(this.a, this.b);
    L5:
        e = move-exception;
        ALogger.e("HybridProperties", "error reading value of " + this.a + ": " + e);
        return this.b;
    }

    public m(String r2, T r3, w0<T> r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void setValue(Object r2, KProperty<?> r3, T r4) {
        Intrinsics.checkNotNullParameter(r2, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        this.c.b.invoke(this.a, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("HybridProperties", "error writing value of " + this.a + ": " + e);
    }
}
