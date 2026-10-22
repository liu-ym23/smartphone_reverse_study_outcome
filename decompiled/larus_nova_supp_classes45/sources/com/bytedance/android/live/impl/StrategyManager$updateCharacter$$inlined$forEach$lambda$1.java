package com.bytedance.android.live.impl;

import com.bytedance.android.live.impl.processor.BaseFactorProcessor;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/live/impl/StrategyManager$updateCharacter$3$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.impl.StrategyManager$updateCharacter$3$1", f = "StrategyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StrategyManager$updateCharacter$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $characterCache$inlined;
    final /* synthetic */ Ref.ObjectRef $data;
    final /* synthetic */ String $faName;
    final /* synthetic */ boolean $isHandleRoom$inlined;
    int label;

    public StrategyManager$updateCharacter$$inlined$forEach$lambda$1(String r1, Ref.ObjectRef r2, Continuation r3, boolean r4, Ref.ObjectRef r5) {
        this.$faName = r1;
        this.$data = r2;
        this.$isHandleRoom$inlined = r4;
        this.$characterCache$inlined = r5;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "completion");
        return new StrategyManager$updateCharacter$$inlined$forEach$lambda$1(this.$faName, this.$data, r8, this.$isHandleRoom$inlined, this.$characterCache$inlined);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        Strategy r6 = StrategyManager.a;
        Map<String, BaseFactorProcessor> r7 = StrategyManager.b;
        if (r7.containsKey(this.$faName) == false) goto L9;
        LinkedHashMap r8 = (LinkedHashMap) r7;
        BaseFactorProcessor r9 = (BaseFactorProcessor) r8.get(this.$faName);
        if (r9 == null) goto L11;
        r9.update(this.$faName, (StrategyMutableLiveData) this.$data.element, (Map) this.$characterCache$inlined.element, StrategyManager.k);
    L11:
        return Unit.INSTANCE;
    L9:
        StrategyManager.c.update(this.$faName, (StrategyMutableLiveData) this.$data.element, (Map) this.$characterCache$inlined.element, StrategyManager.k);
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
