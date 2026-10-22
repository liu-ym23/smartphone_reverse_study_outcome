package com.ss.android.lark.forseti.global;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements yua.c {
    public final List<yua.b> a;
    public final yua.b b;

    public final yua.b a() {
        return this.b;
    }

    public final List<yua.b> getPieces() {
        return this.a;
    }

    public g(List<? extends yua.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "pieces");
        this.a = r4;
        ArrayList r5 = (ArrayList) r4;
        ListIterator r6 = r5.listIterator(r5.size());
    L4:
        if (r6.hasPrevious() == false) goto L8;
        Object r0 = r6.previous();
        if (((yua.b) r0).getFragment().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
    L9:
        this.b = (yua.b) r0;
        return;
    L8:
        r0 = null;
        goto L9
    }
}
