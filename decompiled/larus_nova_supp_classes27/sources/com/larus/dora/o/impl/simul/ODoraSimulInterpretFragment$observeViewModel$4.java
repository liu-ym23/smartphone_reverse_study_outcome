package com.larus.dora.o.impl.simul;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
@DebugMetadata(c = "com.larus.dora.o.impl.simul.ODoraSimulInterpretFragment$observeViewModel$4", f = "ODoraSimulInterpretFragment.kt", i = {}, l = {515}, m = "invokeSuspend", n = {}, s = {})
final class ODoraSimulInterpretFragment$observeViewModel$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ODoraSimulInterpretFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.simul.ODoraSimulInterpretFragment$observeViewModel$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "translating", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.simul.ODoraSimulInterpretFragment$observeViewModel$4$1", f = "ODoraSimulInterpretFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ ODoraSimulInterpretFragment this$0;

        public AnonymousClass1(ODoraSimulInterpretFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L51;
            ResultKt.throwOnFailure(r7);
            boolean r8 = this.Z$0;
            ODoraSimulInterpretFragment r0 = this.this$0;
            DoraOFragmentSimulInterpretBinding r1 = r0.d;
            if (r1 == null) goto L49;
            if (r0.Y90() == OSimulDeviceForm.UNKNOWN) goto L10;
            r1.y.setImageResource(r0.Y90().getTopIconRes());
            r1.c.setImageResource(r0.Y90().getBottomIconRes());
        L10:
            LinearLayout r2 = r1.r;
            int r3 = 8;
            if (r8 == false) goto L13;
            int r5 = 8;
        L14:
            r2.setVisibility(r5);
            ConstraintLayout r4 = r1.C;
            if (r8 == false) goto L17;
            int r6 = 0;
        L18:
            r4.setVisibility(r6);
            TextView r9 = r1.p;
            if (r8 == true) goto L21;
        L23:
            int r10 = 8;
        L24:
            r9.setVisibility(r10);
            TextView r11 = r1.g;
            if (r8 == true) goto L27;
        L29:
            int r12 = 8;
        L30:
            r11.setVisibility(r12);
            OButton r13 = r1.v;
            if (r8 == false) goto L33;
            int r14 = 8;
        L34:
            r13.setVisibility(r14);
            LinearLayout r15 = r1.D;
            if (r8 == false) goto L37;
            int r16 = 0;
        L38:
            r15.setVisibility(r16);
            OButton r17 = r1.n;
            if (r0.aa0() == true) goto L42;
            r3 = 0;
        L42:
            r17.setVisibility(r3);
            if (r8 == false) goto L45;
        L47:
            r0.U90(r0.aa0(), false);
            goto L49
        L45:
            if (r0.n == false) goto L47;
            r0.n = false;
            r1.x.setRotation(0.0f);
            goto L47
        L37:
            r16 = 8;
            goto L38
        L33:
            r14 = 0;
            goto L34
        L27:
            if (r0.g.getItemCount() != 0) goto L29;
            r12 = 0;
            goto L30
        L21:
            if (r0.f.getItemCount() != 0) goto L23;
            r10 = 0;
            goto L24
        L17:
            r6 = 4;
            goto L18
        L13:
            r5 = 0;
        L49:
            return Unit.INSTANCE;
        L51:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ODoraSimulInterpretFragment$observeViewModel$4(ODoraSimulInterpretFragment r1, Continuation<? super ODoraSimulInterpretFragment$observeViewModel$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ODoraSimulInterpretFragment$observeViewModel$4(this.this$0, r3);
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
        i1<Boolean> r8 = r7.Z90().isTranslating();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
