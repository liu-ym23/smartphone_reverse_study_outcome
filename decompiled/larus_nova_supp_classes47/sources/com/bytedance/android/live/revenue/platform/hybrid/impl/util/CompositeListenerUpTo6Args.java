package com.bytedance.android.live.revenue.platform.hybrid.impl.util;

import java.util.ArrayList;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CompositeListenerUpTo6Args<R, F extends Function<? extends R>> {
    public final ArrayList<F> a;

    public final void b() {
        if (this.a.isEmpty() == false) goto L5;
        return;
    L5:
        SequencesKt.count(d(null));
    }

    public CompositeListenerUpTo6Args() {
        this.a = new ArrayList(0);
    }

    public final void a(F r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        this.a.add(r2);
    }

    public final void c(Object... r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        if (this.a.isEmpty() == false) goto L5;
        return;
    L5:
        SequencesKt.count(d(r2));
    }

    public final Sequence<R> d(final Object[] r5) {
        final int r0 = TypeIntrinsics.getFunctionArity(CollectionsKt.first(this.a));
        boolean r1 = true;
        if (r0 != 0) goto L21;
        if (r5 != null) goto L6;
    L12:
        if (r1 == true) goto L20;
        StringBuilder r2 = new StringBuilder("function requires 0 params, but received ");
        if (r5 == null) goto L16;
        Integer r6 = Integer.valueOf(r5.length);
    L17:
        r2.append(r6);
        throw new IllegalArgumentException(r2.toString().toString());
    L16:
        r6 = null;
        goto L17
    L20:
        return SequencesKt.map(CollectionsKt.asSequence(this.a), CompositeListenerUpTo6Args$transformFunctionCalls$2.INSTANCE);
    L6:
        if (r5.length != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r1 = false;
        goto L12
    L8:
        r3 = false;
        goto L9
    L21:
        if (r5 == null) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L44;
        if (r5.length == r0) goto L29;
        r1 = false;
    L29:
        if (r1 == false) goto L42;
        Sequence r7 = CollectionsKt.asSequence(this.a);
        switch(r0) {
            case 1: goto L40;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L46;
            case 6: goto L45;
            default: goto L33;
        };
    L33:
        throw new IllegalStateException(("Failed to transform function call typed: " + ((Function) CollectionsKt.first(this.a)).getClass()).toString());
    L45:
        return SequencesKt.map(r7, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$6(this, r0, r5));
    L46:
        return SequencesKt.map(r7, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$5(this, r0, r5));
    L47:
        return SequencesKt.map(r7, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$4(this, r0, r5));
    L48:
        return SequencesKt.map(r7, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$3(this, r0, r5));
    L49:
        return SequencesKt.map(r7, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$2(this, r0, r5));
    L40:
        return SequencesKt.map(r7, new CompositeListenerUpTo6Args$transformFunctionCalls$$inlined$run$lambda$1(this, r0, r5));
    L42:
        throw new IllegalArgumentException(("function requires " + r0 + " params, but received " + r5.length).toString());
    L44:
        throw new IllegalArgumentException(("received null for args, but need " + r0).toString());
    L23:
        r4 = false;
        goto L24
    }
}
