package com.larus.canvas.feature.component.title;

import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.canvas.feature.component.title.widget.DropdownListAdapter;
import com.skydoves.balloon.Balloon;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.title.CreationTitleComponent$bindObservers$2", f = "CreationTitleComponent.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
final class CreationTitleComponent$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationTitleComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationTitleComponent a;

        public a(CreationTitleComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.canvas.feature.component.title.b] */
        public final Object emit(Object r14, Continuation r15) {
            m r16 = (m) r14;
            if ((r16 instanceof m.a) == false) goto L29;
            final CreationTitleComponent r17 = this.a;
            int r0 = CreationTitleComponent.v;
            AppCompatImageView r1 = r17.m3().getBinding().d;
            List<ly8.g> r18 = ((m.a) r16).a;
            Balloon r2 = r17.s;
            if (r2 != null) goto L7;
        L9:
            boolean r3 = false;
        L11:
            if (r3 == false) goto L15;
            if (r2 == null) goto L14;
            r2.h();
        L14:
            r17.s = null;
        L27:
            return Unit.INSTANCE;
        L15:
            View r4 = LayoutInflater.from(r17.getContext()).inflate(2131561862, null);
            final RecyclerView r12 = r4.findViewById(2131382753);
            DropdownListAdapter r5 = new DropdownListAdapter(new b(r17));
            r12.setAdapter(r5);
            r5.submitList(r18);
            com.larus.bmhome.view.screenmenu.d r6 = com.larus.bmhome.view.screenmenu.d.a;
            Intrinsics.checkNotNull(r4);
            r17.s = com.larus.bmhome.view.screenmenu.d.a(r6, r1, r4, false, null, null, null, new c(r17, r12), 48);
            int r19 = r12.getItemDecorationCount();
            int r7 = 0;
            boolean r8 = false;
        L16:
            if (r7 >= r19) goto L21;
            if (Intrinsics.areEqual(r12.getItemDecorationAt(r7), (CreationTitleComponent$widthFixItemDecoration$2$1) r17.u.getValue()) == false) goto L20;
            r8 = true;
        L20:
            r7 = r7 + 1;
            goto L16
        L21:
            if (r8 == true) goto L23;
            r12.addItemDecoration((CreationTitleComponent$widthFixItemDecoration$2$1) r17.u.getValue());
        L23:
            int r110 = ((Number) i5.U0.getValue()).intValue();
            Balloon r111 = r17.s;
            if (r111 == null) goto L27;
            r111.v(r1, 0, r110);
            goto L27
        L7:
            if (r2.g != true) goto L9;
            r3 = true;
            goto L11
        L29:
            throw new NoWhenBranchMatchedException();
        }
    }

    public CreationTitleComponent$bindObservers$2(CreationTitleComponent r1, Continuation<? super CreationTitleComponent$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationTitleComponent$bindObservers$2(this.this$0, r3);
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
        CreationTitleComponent r6 = this.this$0;
        int r2 = CreationTitleComponent.v;
        MutableSharedFlow<E> r3 = r6.o;
        a r4 = new a(r6);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L12;
        return r0;
    }
}
