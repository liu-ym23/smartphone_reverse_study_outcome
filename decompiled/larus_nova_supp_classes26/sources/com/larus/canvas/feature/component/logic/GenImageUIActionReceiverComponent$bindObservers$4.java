package com.larus.canvas.feature.component.logic;

import android.view.View;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageUIActionReceiverComponent$bindObservers$4", f = "GenImageUIActionReceiverComponent.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
final class GenImageUIActionReceiverComponent$bindObservers$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImageUIActionReceiverComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageUIActionReceiverComponent a;

        public a(GenImageUIActionReceiverComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            com.larus.canvas.feature.component.resultdisplay.image.u r4 = (com.larus.canvas.feature.component.resultdisplay.image.u) r2;
            if (r4.a.size() >= 2) goto L19;
            com.larus.canvas.feature.component.resultdisplay.image.y r5 = (com.larus.canvas.feature.component.resultdisplay.image.y) CollectionsKt.firstOrNull(r4.a);
            List r6 = CollectionsKt.listOf(Boxing.boxInt(0));
            if (r5 == null) goto L7;
            Integer r7 = Boxing.boxInt(r5.f);
        L9:
            if (CollectionsKt.contains(r6, r7) == false) goto L16;
            View r8 = (View) this.a.v.getValue();
            if (r8 == null) goto L13;
            com.larus.utils.e1.x(r8);
        L13:
            View r9 = (View) this.a.v.getValue();
            if (r9 == null) goto L23;
            final GenImageUIActionReceiverComponent r10 = this.a;
            r9.setOnTouchListener(new i2(r10));
        L23:
            return Unit.INSTANCE;
        L16:
            View r11 = (View) this.a.v.getValue();
            if (r11 == null) goto L23;
            com.larus.utils.e1.o(r11);
            goto L23
        L7:
            r7 = null;
            goto L9
        L19:
            View r12 = (View) this.a.v.getValue();
            if (r12 == null) goto L23;
            com.larus.utils.e1.o(r12);
            goto L23
        }
    }

    public GenImageUIActionReceiverComponent$bindObservers$4(GenImageUIActionReceiverComponent r1, Continuation<? super GenImageUIActionReceiverComponent$bindObservers$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImageUIActionReceiverComponent$bindObservers$4(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GenImageUIActionReceiverComponent r6 = this.this$0;
        int r2 = GenImageUIActionReceiverComponent.y;
        com.larus.canvas.feature.component.resultdisplay.image.r r7 = r6.D3();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.i1<com.larus.canvas.feature.component.resultdisplay.image.u> r8 = r7.lb();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
