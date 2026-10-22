package com.larus.contextwindow.impl.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ContextWindowEntryFeature$onParentViewCreated$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ContextWindowEntryFeature$onParentViewCreated$1(Object r8) {
        super(0, r8, ContextWindowEntryFeature.class, "refreshDecision", "refreshDecision()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m19invoke() {
        ContextWindowEntryFeature r0 = (ContextWindowEntryFeature) ((CallableReference) this).receiver;
        int r1 = ContextWindowEntryFeature.z;
        r0.L2();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m19invoke();
        return Unit.INSTANCE;
    }
}
