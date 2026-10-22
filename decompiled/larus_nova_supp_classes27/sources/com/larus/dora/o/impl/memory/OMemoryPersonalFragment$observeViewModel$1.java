package com.larus.dora.o.impl.memory;

import android.widget.TextView;
import com.larus.dora.o.impl.databinding.DoraOFragmentMemoryPersonalBinding;
import com.larus.settings.value.e10;
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
@DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalFragment$observeViewModel$1", f = "OMemoryPersonalFragment.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
final class OMemoryPersonalFragment$observeViewModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OMemoryPersonalFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.memory.OMemoryPersonalFragment$observeViewModel$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/dora/o/impl/memory/OMemoryPersonalViewModel$ListState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryPersonalFragment$observeViewModel$1$1", f = "OMemoryPersonalFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<OMemoryPersonalViewModel.a, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OMemoryPersonalFragment this$0;

        public AnonymousClass1(OMemoryPersonalFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(OMemoryPersonalViewModel.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((OMemoryPersonalViewModel.a) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r8);
            OMemoryPersonalViewModel.a r9 = (OMemoryPersonalViewModel.a) this.L$0;
            OMemoryPersonalFragment r0 = this.this$0;
            DoraOFragmentMemoryPersonalBinding r1 = r0.e;
            if (r1 == null) goto L23;
            if ((r9 instanceof OMemoryPersonalViewModel.a.c) == false) goto L11;
            r1.e.setVisibility(0);
            r1.f.setVisibility(8);
            r1.b.setVisibility(8);
            goto L23
        L11:
            if ((r9 instanceof OMemoryPersonalViewModel.a.b) == false) goto L14;
            r1.e.setVisibility(8);
            r1.f.setVisibility(0);
            r1.b.setVisibility(8);
            goto L23
        L14:
            if ((r9 instanceof OMemoryPersonalViewModel.a.C0097a) == false) goto L25;
            r1.e.setVisibility(8);
            r1.f.setVisibility(8);
            r1.b.setVisibility(0);
            OMemoryPersonalAdapter r2 = r0.g;
            if (r2 == null) goto L19;
            List<o0> r5 = ((OMemoryPersonalViewModel.a.C0097a) r9).a;
            Intrinsics.checkNotNullParameter(r5, "newEntries");
            ((ArrayList) r2.d).clear();
            ((ArrayList) r2.d).addAll(r5);
            r2.y2();
            r2.notifyDataSetChanged();
        L19:
            if ((!((OMemoryPersonalViewModel.a.C0097a) r9).a.isEmpty()) == false) goto L21;
            TextView r10 = r1.c;
            e10 r4 = e10.a;
            r10.setText(r0.getString(2131903463, new Object[]{Integer.valueOf(e10.O())}));
            r1.c.setVisibility(0);
            goto L23
        L21:
            r1.c.setVisibility(8);
            goto L23
        L25:
            throw new NoWhenBranchMatchedException();
        L23:
            return Unit.INSTANCE;
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OMemoryPersonalFragment$observeViewModel$1(OMemoryPersonalFragment r1, Continuation<? super OMemoryPersonalFragment$observeViewModel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OMemoryPersonalFragment$observeViewModel$1(this.this$0, r3);
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
        OMemoryPersonalFragment r7 = this.this$0;
        int r2 = OMemoryPersonalFragment.h;
        i1<OMemoryPersonalViewModel.a> r8 = r7.U90().getListState();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
