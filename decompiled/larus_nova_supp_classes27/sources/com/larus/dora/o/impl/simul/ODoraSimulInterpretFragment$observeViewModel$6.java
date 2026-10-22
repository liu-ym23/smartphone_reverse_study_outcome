package com.larus.dora.o.impl.simul;

import android.widget.TextView;
import com.larus.dora.o.impl.databinding.DoraOFragmentSimulInterpretBinding;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.simul.ODoraSimulInterpretFragment$observeViewModel$6", f = "ODoraSimulInterpretFragment.kt", i = {}, l = {527}, m = "invokeSuspend", n = {}, s = {})
final class ODoraSimulInterpretFragment$observeViewModel$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ODoraSimulInterpretFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.simul.ODoraSimulInterpretFragment$observeViewModel$6$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "language", "Lcom/larus/avlink/api/DoraSimulLanguage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.simul.ODoraSimulInterpretFragment$observeViewModel$6$1", f = "ODoraSimulInterpretFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<w88.j, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODoraSimulInterpretFragment this$0;

        public AnonymousClass1(ODoraSimulInterpretFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((w88.j) r1, (Continuation) r2);
        }

        public final Object invoke(w88.j r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L37;
            ResultKt.throwOnFailure(r6);
            w88.j r7 = (w88.j) this.L$0;
            DoraOFragmentSimulInterpretBinding r0 = this.this$0.d;
            String r1 = "";
            String r2 = null;
            if (r0 == null) goto L14;
            OButton r3 = r0.f;
            if (r3 == null) goto L14;
            if (r7 == null) goto L10;
            String r4 = r7.a;
        L11:
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            r3.setText(r4);
            goto L14
        L10:
            r4 = null;
        L14:
            ODoraSimulInterpretFragment r5 = this.this$0;
            DoraOFragmentSimulInterpretBinding r8 = r5.d;
            if (r8 == null) goto L24;
            OButton r9 = r8.e;
            if (r9 == null) goto L24;
            if (r7 == null) goto L20;
            String r10 = r7.a;
        L21:
            if (r10 != null) goto L23;
            r10 = "";
        L23:
            r9.setText(ODoraSimulInterpretFragment.S90(r5, r10));
            goto L24
        L20:
            r10 = null;
        L24:
            DoraOFragmentSimulInterpretBinding r11 = this.this$0.d;
            if (r11 == null) goto L35;
            TextView r12 = r11.g;
            if (r12 == null) goto L35;
            if (r7 == null) goto L30;
            r2 = r7.c;
        L30:
            if (r2 == null) goto L33;
            r1 = r2;
        L33:
            r12.setText(r1);
        L35:
            return Unit.INSTANCE;
        L37:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ODoraSimulInterpretFragment$observeViewModel$6(ODoraSimulInterpretFragment r1, Continuation<? super ODoraSimulInterpretFragment$observeViewModel$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ODoraSimulInterpretFragment$observeViewModel$6(this.this$0, r3);
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
        ODoraSimulInterpretFragment r7 = this.this$0;
        int r2 = ODoraSimulInterpretFragment.q;
        i1<w88.j> r8 = r7.Z90().getBottomLanguage();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
