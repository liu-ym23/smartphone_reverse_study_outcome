package com.ss.android.lark.forseti.chain;

import com.ss.android.lark.forseti.node.ForsetiNode;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Function2<ForsetiNode, Integer, Unit> {
    public final /* synthetic */ ForsetiChainFragment a;

    public e(ForsetiChainFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, Object r5) {
        ForsetiNode r6 = (ForsetiNode) r4;
        int r7 = ((Number) r5).intValue();
        Intrinsics.checkNotNullParameter(r6, "node");
        Iterator r0 = ((ArrayList) this.a.r).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((Function2) r0.next()).invoke(r6, Integer.valueOf(r7));
        goto L4
    L7:
        return Unit.INSTANCE;
    }
}
