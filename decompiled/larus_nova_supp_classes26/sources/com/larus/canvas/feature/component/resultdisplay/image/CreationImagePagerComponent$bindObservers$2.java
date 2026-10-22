package com.larus.canvas.feature.component.resultdisplay.image;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.resultdisplay.image.CreationImagePagerComponent$bindObservers$2", f = "CreationImagePagerComponent.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
final class CreationImagePagerComponent$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationImagePagerComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationImagePagerComponent a;

        public a(CreationImagePagerComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            t r6 = (t) r4;
            CreationImagePagerComponent r7 = this.a;
            int r0 = CreationImagePagerComponent.B;
            r7.getClass();
            if ((r6 instanceof t.a) == false) goto L11;
            RecyclerView.Adapter r1 = r7.p3().getAdapter();
            if (r1 == null) goto L7;
            int r2 = r1.getItemCount();
        L8:
            t.a r8 = (t.a) r6;
            r7.p3().setCurrentItem(RangesKt.coerceIn(r8.a, 0, RangesKt.coerceAtLeast(r2 - 1, 0)), r8.b);
            return Unit.INSTANCE;
        L7:
            r2 = 0;
            goto L8
        L11:
            throw new NoWhenBranchMatchedException();
        }
    }

    public CreationImagePagerComponent$bindObservers$2(CreationImagePagerComponent r1, Continuation<? super CreationImagePagerComponent$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationImagePagerComponent$bindObservers$2(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationImagePagerComponent r6 = this.this$0;
        int r2 = CreationImagePagerComponent.B;
        MutableSharedFlow<E> r3 = r6.o;
        a r4 = new a(r6);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L12;
        return r0;
    }
}
