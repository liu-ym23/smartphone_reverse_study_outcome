package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MultiDynamicManager$layoutManager$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public MultiDynamicManager$layoutManager$1(MultiDynamicManager r8) {
        super(0, r8, MultiDynamicManager.class, "notifyLayoutChange", "notifyLayoutChange()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m657invoke() {
        MultiDynamicManager r0 = (MultiDynamicManager) ((CallableReference) this).receiver;
        Iterator<T> r1 = r0.c.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.v((com.bytedance.android.live.revlink.impl.lynxcontainer.b) r1.next());
        goto L4
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m657invoke();
        return Unit.INSTANCE;
    }
}
