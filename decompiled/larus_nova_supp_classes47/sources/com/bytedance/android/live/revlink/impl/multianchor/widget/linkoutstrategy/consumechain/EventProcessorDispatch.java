package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class EventProcessorDispatch<T> {
    public final List<a<T>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public EventProcessorDispatch(List<? extends a<T>> r2) {
        Intrinsics.checkNotNullParameter(r2, "processorList");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(T r7) {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r7;
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = false;
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        ((a) r1.next()).a(r0.element, new EventProcessorDispatch$dispatch$$inlined$forEach$lambda$1(r0, r8), new EventProcessorDispatch$dispatch$$inlined$forEach$lambda$2(r0, r8));
        if (r8.element == false) goto L4;
        return;
    }
}
