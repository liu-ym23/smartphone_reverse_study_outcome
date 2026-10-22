package com.larus.slides.impl.select;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.slides.biz.impl.databinding.LarusSlidesPageGenerateImageBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageFragment$bindObservers$1", f = "GenerateImageFragment.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
final class GenerateImageFragment$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenerateImageFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenerateImageFragment a;

        public a(GenerateImageFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object emit(Object r10, Continuation r11) {
            final p r12 = (p) r10;
            final GenerateImageFragment r13 = this.a;
            LarusSlidesPageGenerateImageBinding r0 = r13.e;
            if (r0 == null) goto L35;
            GenerateImageAdapter r1 = r13.h;
            if (r1 == null) goto L30;
            List<GenerateImageViewHolder.b> r2 = r12.a;
            Function1<? super Boolean, Unit> r3 = new d(r13, r12);
            Intrinsics.checkNotNullParameter(r2, "data");
            r1.f = r3;
            Integer r14 = r1.a;
            if (r14 != null) goto L9;
        L27:
            ArrayList r4 = r2;
        L28:
            DiffUtil.calculateDiff(new GenerateImageAdapter.DiffCallback(r1.c, r4), false).dispatchUpdatesTo(r1);
            r1.c = r2;
            goto L30
        L9:
            if (r14.intValue() <= 0) goto L27;
            Integer r15 = r1.b;
            if (r15 == null) goto L27;
            if (r15.intValue() <= 0) goto L27;
            List<GenerateImageViewHolder.b> r16 = r2;
            r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r17 = r16.iterator();
        L16:
            if (r17.hasNext() == false) goto L28;
            GenerateImageViewHolder.b r5 = (GenerateImageViewHolder.b) r17.next();
            Integer r6 = r5.h;
            if (r6 != null) goto L20;
        L25:
            r5 = GenerateImageViewHolder.b.a(r5, null, r1.a, r1.b, 127);
        L26:
            r4.add(r5);
            goto L16
        L20:
            if (r6.intValue() <= 0) goto L25;
            Integer r7 = r5.i;
            if (r7 == null) goto L25;
            if (r7.intValue() > 0) goto L26;
        L30:
            if (r12.a.size() >= 2) goto L32;
            e1.q(r0.c);
        L33:
            Unit r18 = Unit.INSTANCE;
            goto L35
        L32:
            e1.x(r0.c);
        L35:
            return Unit.INSTANCE;
        }
    }

    public GenerateImageFragment$bindObservers$1(GenerateImageFragment r1, Continuation<? super GenerateImageFragment$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenerateImageFragment$bindObservers$1(this.this$0, r3);
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
        GenerateImageFragment r6 = this.this$0;
        int r2 = GenerateImageFragment.n;
        i1<p> r7 = r6.V90().getUiState();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
