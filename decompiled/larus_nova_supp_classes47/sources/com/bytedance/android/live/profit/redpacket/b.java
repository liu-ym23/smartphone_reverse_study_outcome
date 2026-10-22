package com.bytedance.android.live.profit.redpacket;

import android.util.Property;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> extends Property<Unit, T> {
    public T a;

    public static final class a {
    }

    static {
    }

    @Override // android.util.Property
    public final Object get(Unit r1) {
        return this.a;
    }

    public b(T r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "TClass");
        super(r3, "dummyProperty");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public final void set(Unit r1, Object r2) {
        this.a = r2;
    }
}
