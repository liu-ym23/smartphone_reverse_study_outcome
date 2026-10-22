package com.bytedance.android.live.ktv.common.music.control;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements h {
    public final boolean a;

    public f() {
        this.a = ((Boolean) vm2.h.K1.getValue(null, vm2.h.a[139(0x8b, float:1.95E-43)])).booleanValue();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.h
    public final boolean a(IMusicControlNode r3, CopyOnWriteArrayList<IMusicControlNode> r4, CopyOnWriteArrayList<IMusicControlNode> r5) {
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r4, "waitingList");
        Intrinsics.checkNotNullParameter(r5, "runningList");
        boolean r6 = true;
        boolean r7 = !r5.isEmpty();
        Iterator<T> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r0 = r8.next();
        if ((((IMusicControlNode) r0) instanceof c) == false) goto L4;
    L9:
        if (r0 != null) goto L13;
        r6 = false;
    L13:
        if (this.a == true) goto L15;
        return r7;
    L15:
        return r6;
    L8:
        r0 = null;
        goto L9
    }
}
