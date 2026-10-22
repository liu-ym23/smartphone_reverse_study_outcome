package com.obric.assistant.cocreationreview;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$taskCenterRenderer$2$5 extends FunctionReferenceImpl implements Function0<Unit> {
    public CocreationReviewActivity$taskCenterRenderer$2$5(Object r8) {
        super(0, r8, CocreationReviewActivity.class, "loadCenterTasks", "loadCenterTasks()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m416invoke() {
        CocreationReviewActivity r0 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        Set<String> r1 = CocreationReviewActivity.P1;
        r0.k2();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m416invoke();
        return Unit.INSTANCE;
    }
}
