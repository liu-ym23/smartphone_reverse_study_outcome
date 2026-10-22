package com.larus.uaigc.createpage.component.digitalavatar;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.uaigc.impl.databinding.LarusLayoutDigitalAvatarCreateBtnBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initCreateAvatarBtn$2", f = "DigitalAvatarComponent.kt", i = {}, l = {804}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarComponent$initCreateAvatarBtn$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DigitalAvatarComponent a;

        public a(DigitalAvatarComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            boolean r7 = ((Boolean) r5).booleanValue();
            DigitalAvatarComponent r8 = this.a;
            int r0 = DigitalAvatarComponent.C;
            RoundConstraintLayout r9 = ((LarusLayoutDigitalAvatarCreateBtnBinding) r8.r.getValue()).a;
            if ((!r7) == false) goto L5;
            int r1 = 0;
        L6:
            r9.setVisibility(r1);
            ConstraintLayout r10 = this.a.F2();
            if ((r10 instanceof ConstraintLayout) == false) goto L9;
            ConstraintLayout r11 = r10;
        L10:
            if (r11 == null) goto L28;
            if (r7 == false) goto L20;
            ConstraintSet r12 = new ConstraintSet();
            r12.clone(r11);
            r12.connect(2131388328, 4, 2131384813, 4);
            r12.applyTo(r11);
            View r13 = r11.findViewById(2131388328);
            if (r13 == null) goto L28;
            ViewGroup.LayoutParams r14 = r13.getLayoutParams();
            if (r14 == null) goto L19;
            ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
            r15.bottomMargin = c7.b(Boxing.boxInt(12));
            r13.setLayoutParams(r15);
            goto L28
        L19:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L20:
            View r16 = r11.findViewById(2131388328);
            if (r16 == null) goto L28;
            ViewGroup.LayoutParams r17 = r16.getLayoutParams();
            if (r17 == null) goto L26;
            ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
            r18.bottomMargin = 0;
            r16.setLayoutParams(r18);
            goto L28
        L26:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L28:
            return Unit.INSTANCE;
        L9:
            r11 = null;
            goto L10
        L5:
            r1 = 8;
            goto L6
        }
    }

    public DigitalAvatarComponent$initCreateAvatarBtn$2(DigitalAvatarComponent r1, Continuation<? super DigitalAvatarComponent$initCreateAvatarBtn$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DigitalAvatarComponent$initCreateAvatarBtn$2(this.this$0, r3);
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
        DigitalAvatarComponent r6 = this.this$0;
        b1 r2 = r6.n;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
