package com.larus.canvas.feature.component.resultdisplay.image;

import com.larus.canvas.feature.component.resultdisplay.image.widget.ImagePagerAdapter;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.resultdisplay.image.CreationImagePagerComponent$bindObservers$1", f = "CreationImagePagerComponent.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
final class CreationImagePagerComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationImagePagerComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationImagePagerComponent a;

        public a(CreationImagePagerComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            u r5 = (u) r3;
            CreationImagePagerComponent r6 = this.a;
            int r0 = CreationImagePagerComponent.B;
            ImagePagerAdapter r7 = (ImagePagerAdapter) r6.z.getValue();
            v r1 = r5.b;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r1, "action");
            v r2 = r7.k;
            r7.k = r1;
            if (Intrinsics.areEqual(r2, r1) == false) goto L5;
        L7:
            final ImagePagerAdapter r8 = (ImagePagerAdapter) this.a.z.getValue();
            List<y> r9 = r5.a;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r9, "list");
            r8.l.submitList(r9, new com.larus.canvas.feature.component.resultdisplay.image.widget.c(r8));
            return Unit.INSTANCE;
        L5:
            if (r7.getItemCount() <= 0) goto L7;
            r7.notifyItemRangeChanged(0, r7.getItemCount());
            goto L7
        }
    }

    public CreationImagePagerComponent$bindObservers$1(CreationImagePagerComponent r1, Continuation<? super CreationImagePagerComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationImagePagerComponent$bindObservers$1(this.this$0, r3);
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
        b1 r2 = r6.n;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
