package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiDynamicContextImpl$localComponentManager$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public MultiDynamicContextImpl$localComponentManager$1(MultiDynamicContextImpl r8) {
        super(1, r8, MultiDynamicContextImpl.class, "notifyDynamicConfigRefresh", "notifyDynamicConfigRefresh(I)V", 0);
    }

    public final void invoke(int r2) {
        e r0 = ((MultiDynamicContextImpl) ((CallableReference) this).receiver).n;
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.k<Integer> r1 = r0.getRefreshWidgetEvent();
        if (r1 == null) goto L9;
        r1.post(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
