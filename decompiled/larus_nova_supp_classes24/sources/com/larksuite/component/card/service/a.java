package com.larksuite.component.card.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class a {
    public boolean a;
    public final Map<Class<? extends c>, c> b;

    public final void a() {
        Iterator r0 = ((HashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) ((Map.Entry) r0.next()).getValue()).destroy();
        goto L4
    L6:
        ((HashMap) this.b).clear();
        this.a = true;
    }

    public a() {
        this.b = new HashMap();
    }

    public final <T extends c> T b(Class<T> r2, Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "serviceClass");
        Intrinsics.checkNotNullParameter(r3, "initBlock");
        T r0 = (T) ((HashMap) this.b).get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        T r4 = (T) r3.invoke();
        ((HashMap) this.b).put(r2, r4);
        return r4;
    }
}
