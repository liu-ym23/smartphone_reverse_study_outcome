package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$11 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ xs8.d $currentController;
    final /* synthetic */ Ref.ObjectRef<i0> $panelContent;

    public CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$11(xs8.d r7, Ref.ObjectRef<i0> r8) {
        this.$currentController = r7;
        this.$panelContent = r8;
        super(0, Intrinsics.Kotlin.class, "renderSelectors", "showPanelIfNeeded$renderSelectors(Lcom/larus/bmhome/view/actionbar/edit/controller/CollaboratedMultiFeatureSelectorController;Lkotlin/jvm/internal/Ref$ObjectRef;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m25invoke() {
        xs8.d r0 = this.$currentController;
        Ref.ObjectRef<i0> r1 = this.$panelContent;
        t1 r2 = CollaboratedMultiFeatureSelectorWidget.o;
        com.larus.bmhome.actionbar.model.a0 r3 = r0.s();
        if (r3 == null) goto L10;
        Object r4 = r1.element;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("panelContent");
        i0 r5 = null;
    L8:
        r5.g(r3);
        return;
    L7:
        r5 = (i0) r4;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m25invoke();
        return Unit.INSTANCE;
    }
}
