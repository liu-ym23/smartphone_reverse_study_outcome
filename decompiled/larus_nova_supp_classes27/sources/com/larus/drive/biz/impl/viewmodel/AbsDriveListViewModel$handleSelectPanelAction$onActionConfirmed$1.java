package com.larus.drive.biz.impl.viewmodel;

import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AbsDriveListViewModel$handleSelectPanelAction$onActionConfirmed$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public AbsDriveListViewModel$handleSelectPanelAction$onActionConfirmed$1(Object r8) {
        super(0, r8, AbsDriveListFragment.class, "exitSelectModeAfterActionConfirmed", "exitSelectModeAfterActionConfirmed()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m367invoke() {
        o79.g r0 = ((AbsDriveListFragment) ((CallableReference) this).receiver).U90();
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m367invoke();
        return Unit.INSTANCE;
    }
}
