package com.bytedance.android.live.profile.seeselftransition;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class NewProfileSeeSelfTransitionDialogLauncher$ensureTransitionDialogHolder$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public NewProfileSeeSelfTransitionDialogLauncher$ensureTransitionDialogHolder$1$1(NewProfileSeeSelfTransitionDialogLauncher r8) {
        super(0, r8, NewProfileSeeSelfTransitionDialogLauncher.class, "onSeeSelfTransitionDialogHolderDestroy", "onSeeSelfTransitionDialogHolderDestroy()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m20invoke() {
        ((NewProfileSeeSelfTransitionDialogLauncher) ((CallableReference) this).receiver).c = null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m20invoke();
        return Unit.INSTANCE;
    }
}
