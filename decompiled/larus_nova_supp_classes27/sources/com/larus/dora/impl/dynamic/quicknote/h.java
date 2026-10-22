package com.larus.dora.impl.dynamic.quicknote;

import com.bytedance.router.SmartRouter;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h<T> implements FlowCollector {
    public final /* synthetic */ QuickNoteDetailFragment a;

    public h(QuickNoteDetailFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        String r3 = (String) r1;
        if (o0.d(r3) == false) goto L6;
        com.bytedance.router.i r4 = SmartRouter.buildRoute(this.a.getContext(), r3);
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.d();
    L6:
        return Unit.INSTANCE;
    }
}
