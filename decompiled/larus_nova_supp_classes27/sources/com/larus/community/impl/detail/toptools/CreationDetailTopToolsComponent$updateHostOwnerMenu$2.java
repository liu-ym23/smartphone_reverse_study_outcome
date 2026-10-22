package com.larus.community.impl.detail.toptools;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CreationDetailTopToolsComponent$updateHostOwnerMenu$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public CreationDetailTopToolsComponent$updateHostOwnerMenu$2(Object r8) {
        super(0, r8, CreationDetailTopToolsComponent.class, "deleteCreation", "deleteCreation()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m9invoke() {
        CreationDetailTopToolsComponent r0 = (CreationDetailTopToolsComponent) ((CallableReference) this).receiver;
        int r1 = CreationDetailTopToolsComponent.w;
        r0.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new CreationDetailTopToolsComponent$deleteCreation$1(r0, null), 3, null);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m9invoke();
        return Unit.INSTANCE;
    }
}
