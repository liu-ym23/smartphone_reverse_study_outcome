package com.larus.dora.o.impl.memory;

import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.o.impl.databinding.DoraOFragmentMemoryEventBinding;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryEventFragment$observeViewModel$1", f = "OMemoryEventFragment.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
final class OMemoryEventFragment$observeViewModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OMemoryEventFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryEventFragment$observeViewModel$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel$ListState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryEventFragment$observeViewModel$1$1", f = "OMemoryEventFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<OMemoryEventViewModel.a, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OMemoryEventFragment this$0;

        public AnonymousClass1(OMemoryEventFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(OMemoryEventViewModel.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((OMemoryEventViewModel.a) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r8);
            OMemoryEventViewModel.a r9 = (OMemoryEventViewModel.a) this.L$0;
            OMemoryEventFragment r0 = this.this$0;
            DoraOFragmentMemoryEventBinding r1 = r0.e;
            if (r1 == null) goto L26;
            int r3 = 0;
            r1.e.setRefreshing(false);
            if ((r9 instanceof OMemoryEventViewModel.a.c) == false) goto L11;
            r1.d.setVisibility(0);
            r1.f.setVisibility(8);
            r1.b.setVisibility(8);
            r1.c.setVisibility(8);
            goto L26
        L11:
            if ((r9 instanceof OMemoryEventViewModel.a.b) == false) goto L14;
            r1.d.setVisibility(8);
            r1.f.setVisibility(0);
            r1.b.setVisibility(8);
            r1.c.setVisibility(8);
            goto L26
        L14:
            if ((r9 instanceof OMemoryEventViewModel.a.C0096a) == false) goto L28;
            r1.d.setVisibility(8);
            r1.f.setVisibility(8);
            OMemoryEventViewModel.a.C0096a r10 = (OMemoryEventViewModel.a.C0096a) r9;
            boolean r2 = r10.a.isEmpty();
            TextView r5 = r1.b;
            if (r2 == false) goto L18;
            int r6 = 0;
        L19:
            r5.setVisibility(r6);
            RecyclerView r4 = r1.c;
            if (r2 == false) goto L22;
            r3 = 8;
        L22:
            r4.setVisibility(r3);
            final OMemoryEventAdapter r7 = r0.g;
            if (r7 == null) goto L26;
            final List<b0> r11 = r10.a;
            Intrinsics.checkNotNullParameter(r11, "newItems");
            DiffUtil.DiffResult r12 = DiffUtil.calculateDiff(new OMemoryEventAdapter$submitList$diff$1(r7, r11));
            ((ArrayList) r7.c).clear();
            ArrayList r13 = (ArrayList) r7.c;
            r13.addAll(r11);
            r12.dispatchUpdatesTo(r7);
            goto L26
        L18:
            r6 = 8;
            goto L19
        L28:
            throw new NoWhenBranchMatchedException();
        L26:
            return Unit.INSTANCE;
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OMemoryEventFragment$observeViewModel$1(OMemoryEventFragment r1, Continuation<? super OMemoryEventFragment$observeViewModel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OMemoryEventFragment$observeViewModel$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        OMemoryEventFragment r7 = this.this$0;
        int r2 = OMemoryEventFragment.k;
        i1<OMemoryEventViewModel.a> r8 = r7.U90().getListState();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
