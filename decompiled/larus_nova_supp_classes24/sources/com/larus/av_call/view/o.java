package com.larus.av_call.view;

import android.os.Handler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o<T> {
    public final Function2<T, Integer, Unit> a;
    public Function2<? super T, ? super Integer, Unit> b;
    public Function2<? super T, ? super Integer, Unit> c;
    public Handler d;
    public List<? extends T> e;
    public long f;
    public int g;
    public final n h;

    public final void a() {
        Handler r0 = this.d;
        if (r0 != null) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        com.larus.utils.l0.b(new j(r0));
        this.a.invoke(null, -1);
        this.g = 0;
        List<? extends T> r1 = this.e;
        if (r1.isEmpty() == false) goto L11;
        return;
    L11:
        long r2 = this.f;
        if (r2 > 0) goto L14;
        return;
    L14:
        b(r0, r1, r2);
    }

    public o(f r3) {
        Intrinsics.checkNotNullParameter(r3, "onUpdateText");
        this.a = r3;
        this.b = new l();
        this.c = new m();
        this.e = CollectionsKt.emptyList();
        this.f = 5000;
        this.h = new n(this);
    }

    public final void b(final Handler r8, final List<? extends T> r9, final long r10) {
        int r0 = this.g;
        this.g = r0 + 1;
        int r1 = r0 % r9.size();
        this.a.invoke(ListProtector.get(r9, r1), Integer.valueOf(r1));
        this.c.invoke(ListProtector.get(r9, r1), Integer.valueOf(r1));
        if (this.g < r9.size()) goto L5;
        this.g = 0;
    L5:
        r8.postDelayed(new k(this, r8, r9, r10), r10);
    }
}
