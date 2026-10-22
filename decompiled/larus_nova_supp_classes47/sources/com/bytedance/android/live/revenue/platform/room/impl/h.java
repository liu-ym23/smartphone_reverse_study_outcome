package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.scope.o;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class h implements o, yz0.n, yz0.o {
    public final com.bytedance.android.scope.a<g> a;

    public void onStart() {
    }

    public final void onStop() {
    }

    @Override // yz0.o
    public final void Ci() {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).onViewReady();
        goto L4
    }

    @Override // yz0.o
    public final void E() {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).onWidgetLoaded();
        goto L4
    }

    @Override // yz0.o
    public final void n8() {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).i();
        goto L4
    }

    @Override // yz0.o
    public final void x() {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).x();
        goto L4
    }

    public h(e33.a r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStateDispatcher");
        this.a = r2;
    }
}
