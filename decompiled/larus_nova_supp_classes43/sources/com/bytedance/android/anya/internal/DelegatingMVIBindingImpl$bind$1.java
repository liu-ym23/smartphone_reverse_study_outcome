package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.a0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u000e\u001a\u00020\u000b\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\u0014\b\u0002\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0015\u0010\n\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Lcom/bytedance/android/anya/BaseMVIView;", "VIEW", "Lcom/bytedance/android/anya/a0;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "e", "p1", "", "invoke", "(Lcom/bytedance/android/anya/a0;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final /* synthetic */ class DelegatingMVIBindingImpl$bind$1 extends FunctionReference implements Function1<a0, Boolean> {
    public DelegatingMVIBindingImpl$bind$1(BaseMVIView r10) {
        super(1, r10);
    }

    public final String getName() {
        return "handleEffect";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BaseMVIView.class);
    }

    public final String getSignature() {
        return "handleEffect(Lcom/bytedance/android/anya/MVIViewEffect;)Z";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((a0) r1));
    }

    public final boolean invoke(a0 r10) {
        return ((BaseMVIView) ((CallableReference) this).receiver).d(r10);
    }
}
