package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.g0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<OWNER extends BaseMVIDataStore<?>, T> implements com.bytedance.android.anya.t<OWNER, T>, ReadOnlyProperty {
    public String a;
    public final BaseMVIDataStore<?> b;
    public final boolean c;

    public final T a() {
        T r0 = (T) ((ConcurrentHashMap) this.b.d).get(this);
        if (this.c == false) goto L11;
        if (Intrinsics.areEqual(r0, g0.a) == true) goto L9;
        if (r0 != null) goto L11;
    L9:
        throw new NullPointerException("value of property [" + this.a + "] is not set.");
    L11:
        if (Intrinsics.areEqual(r0, g0.a) == false) goto L14;
        return null;
    L14:
        return r0;
    }

    public final Object getValue(Object r1, KProperty r10) {
        BaseMVIDataStore r11 = (BaseMVIDataStore) r1;
        return a();
    }

    public n(BaseMVIDataStore<?> r1, T r10, boolean r11) {
        this.b = r1;
        this.c = r11;
        this.a = "unknown";
        Map<Object, Object> r12 = r1.d;
        if (r10 != null) goto L6;
        r10 = (T) g0.a;
    L6:
        ((ConcurrentHashMap) r12).put(this, r10);
    }

    public final void setValue(Object r1, KProperty r10, Object r11) {
        BaseMVIDataStore r12 = (BaseMVIDataStore) r1;
        Map<Object, Object> r13 = this.b.d;
        if (r11 != null) goto L6;
        r11 = g0.a;
    L6:
        ((ConcurrentHashMap) r13).put(this, r11);
    }
}
