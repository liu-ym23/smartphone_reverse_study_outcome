package com.bytedance.android.ec.core.imagex.opt;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "p1", "", "", "invoke", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECImageMainHandlerOpt$configKeys$3 extends FunctionReferenceImpl implements Function2<List<? extends String>, Continuation<? super Unit>, Object>, SuspendFunction {
    public ECImageMainHandlerOpt$configKeys$3(ECImageMainHandlerOpt r10) {
        super(2, r10, ECImageMainHandlerOpt.class, "onInitConfig", "onInitConfig(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(List<String> r10, Continuation<? super Unit> r11) {
        ECImageMainHandlerOpt r0 = (ECImageMainHandlerOpt) ((CallableReference) this).receiver;
        KProperty[] r1 = ECImageMainHandlerOpt.a;
        return r0.b(r10, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((List) r1, (Continuation) r10);
    }
}
