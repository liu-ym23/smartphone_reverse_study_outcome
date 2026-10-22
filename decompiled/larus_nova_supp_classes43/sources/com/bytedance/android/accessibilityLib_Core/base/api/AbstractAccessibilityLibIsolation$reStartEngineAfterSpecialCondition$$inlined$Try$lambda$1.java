package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.tool.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/accessibilityLib_Core/base/api/AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$1$1", f = "AbstractAccessibilityLibIsolation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition $condition$inlined;
    int label;
    final /* synthetic */ AbstractAccessibilityLibIsolation this$0;

    public AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1(Continuation r1, AbstractAccessibilityLibIsolation r10, AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition r11) {
        this.this$0 = r10;
        this.$condition$inlined = r11;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1(r11, this.this$0, this.$condition$inlined);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r10);
        if (("reStartEngineAfterSpecialCondition " + this.$condition$inlined) == null) goto L7;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L7:
        AbstractAccessibilityLibIsolation r12 = this.this$0;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a();
        r12.getClass();
        boolean r13 = b.a(r0);
        boolean r1 = this.this$0.f();
        AbstractAccessibilityLibIsolation r14 = this.this$0;
        r14.c = r13;
        if (r1 == true) goto L12;
        if (r13 == false) goto L12;
        r14.l();
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
