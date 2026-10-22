package com.bytedance.android.anya;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0015\u0010\b\u001a\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Llb/e;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "flowTracer", "p1", "", "invoke", "(Llb/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final /* synthetic */ class BaseMVIComposableViewModel$initializeInternal$1$2 extends FunctionReference implements Function1<lb.e, Unit> {
    public BaseMVIComposableViewModel$initializeInternal$1$2(BaseMVIComposableViewModel r10) {
        super(1, r10);
    }

    public final String getName() {
        return "triggerDiffConsumers";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BaseMVIComposableViewModel.class);
    }

    public final String getSignature() {
        return "triggerDiffConsumers$runtime_release(Lcom/bytedance/android/anya/trace/AnyaFlowCompositeTracer;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((lb.e) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(lb.e r10) {
        ((BaseMVIComposableViewModel) ((CallableReference) this).receiver).N0(r10);
    }
}
