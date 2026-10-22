package com.larus.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n0<T> {
    public final Function0<T> a;
    public final List<T> b;
    public int c;

    public final T a() {
        if (this.c >= ((ArrayList) this.b).size()) goto L6;
        List<T> r0 = this.b;
        int r1 = this.c;
        this.c = r1 + 1;
        return (T) ListProtector.get(r0, r1);
    L6:
        T r2 = (T) this.a.invoke();
        this.c++;
        ((ArrayList) this.b).add(r2);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        this.a = r2;
        this.b = new ArrayList();
    }
}
