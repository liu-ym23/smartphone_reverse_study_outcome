package com.bytedance.android.annie.card;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements y6.d {
    public y6.e a;
    public final List<WeakReference<f>> b;

    @Override // y6.d
    public final void fZ() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        f r1 = (f) ((WeakReference) r0.next()).get();
        if (r1 == null) goto L4;
        r1.onRefresh();
        goto L4
    }

    public g() {
        this.b = new ArrayList();
    }

    @Override // y6.d
    public final y6.e w1() {
        return this.a;
    }

    @Override // y6.d
    public final void DY(y6.e r10) {
        this.a = r10;
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        f r1 = (f) ((WeakReference) r0.next()).get();
        if (r1 == null) goto L4;
        r1.onInjectShareInfo(r10);
        goto L4
    }

    public final void a(f r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        List<WeakReference<f>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new WeakReference(r10));
    }
}
