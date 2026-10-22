package com.bytedance.android.anniex.lite.task;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLatchTask$work$2", f = "AnnieXLatchTask.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXLatchTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.base.model.a $input;
    int label;
    final /* synthetic */ b this$0;

    public static final class a implements FlowCollector<j> {
        public a() {
        }

        public final Object emit(Object r1, Continuation r10) {
            j r11 = (j) r1;
            if (r11 == null) goto L5;
            r11.a.getOriginUrl();
            com.bytedance.android.anniex.assemble.a r12 = com.bytedance.android.anniex.assemble.a.a;
            throw null;
        L5:
            return Unit.INSTANCE;
        }
    }

    public AnnieXLatchTask$work$2(com.bytedance.android.anniex.lite.flow.base.model.a r1, b r10, Continuation<? super AnnieXLatchTask$work$2> r11) {
        this.$input = r1;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnnieXLatchTask$work$2(this.$input, null, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        b1 r11 = ((qa.b) this.$input.a(qa.b.class)).c;
        a r12 = new a();
        this.label = 1;
        if (r11.collect(r12, this) != r0) goto L12;
        return r0;
    }
}
