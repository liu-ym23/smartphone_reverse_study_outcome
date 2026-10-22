package com.obric.oui.button;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final /* synthetic */ class OButtonGroup$AnimationBatch$start$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public OButtonGroup$AnimationBatch$start$1$1(Object r8) {
        super(0, r8, OButtonGroup.a.class, "done", "done()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m240invoke() {
        OButtonGroup.a r0 = (OButtonGroup.a) ((CallableReference) this).receiver;
        if (r0.d == false) goto L13;
        boolean r1 = r0.e;
        if (r1 == true) goto L15;
        int r2 = r0.c - 1;
        r0.c = r2;
        if (r2 != 0) goto L14;
        if (r1 == true) goto L16;
        r0.e = true;
        r0.a.invoke();
        return;
    L16:
        return;
    L14:
        return;
    L15:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m240invoke();
        return Unit.INSTANCE;
    }
}
