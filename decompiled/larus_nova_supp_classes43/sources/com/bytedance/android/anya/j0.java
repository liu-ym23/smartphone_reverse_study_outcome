package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j0<STATE extends MVIState<?>> {
    public final Set<j0<?>> a;
    public boolean b;
    public final Map<Object, Integer> c;
    public final Map<Object, Integer> d;
    public com.bytedance.android.anya.internal.p e;
    public j0<?> f;
    public final l0<STATE> g;

    public static final class a extends k0<MVIState<?>, a> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public final void a() {
        this.b = true;
        j0<?> r0 = this.f;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void b() {
        ((LinkedHashMap) this.d).clear();
        ((LinkedHashMap) this.c).clear();
        this.b = false;
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((j0) r0.next()).b();
        goto L4
    }

    public final com.bytedance.android.anya.internal.p getContext() {
        com.bytedance.android.anya.internal.p r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r0;
    }

    public j0(l0<STATE> r1) {
        this.g = r1;
        this.a = new LinkedHashSet();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }
}
