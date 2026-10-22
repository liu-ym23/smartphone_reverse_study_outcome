package com.obric.assistant.special_input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.special_input.util.SpecialTrackEventUtilsKt;
import com.obric.oui.text.OTextView;
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
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$addAddIconTipsBar$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {2472}, m = "invokeSuspend", n = {}, s = {})
final class ObricSpecialInputComponent$addAddIconTipsBar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ ViewGroup $titleContainer;
    int label;
    final /* synthetic */ ObricSpecialInputComponent this$0;

    public ObricSpecialInputComponent$addAddIconTipsBar$1(ObricSpecialInputComponent r1, ViewGroup r2, ViewGroup r3, Continuation<? super ObricSpecialInputComponent$addAddIconTipsBar$1> r4) {
        this.this$0 = r1;
        this.$container = r2;
        this.$titleContainer = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricSpecialInputComponent$addAddIconTipsBar$1(this.this$0, this.$container, this.$titleContainer, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        if (((Boolean) r8).booleanValue() == true) goto L16;
        ObricSpecialInputComponent r9 = this.this$0;
        int r2 = ObricSpecialInputComponent.G1;
        r9.w5();
        return Unit.INSTANCE;
    L16:
        if (((Boolean) this.this$0.L.getValue()).booleanValue() == true) goto L18;
    L63:
        this.this$0.w5();
        return Unit.INSTANCE;
    L18:
        if (ObricSpecialInputComponent.V4((laa.v) this.this$0.P.getValue()) == false) goto L63;
        ObricSpecialInputComponent r10 = this.this$0;
        if (r10.S == true) goto L63;
        View r11 = r10.k1;
        ConstraintLayout.LayoutParams r3 = null;
        if (r11 == null) goto L25;
        ViewParent r12 = r11.getParent();
    L26:
        if (r12 == null) goto L29;
        FLogger.a.i("ObricSpecialInputComponent", "addAddIconTipsBar: already shown, skip");
        return Unit.INSTANCE;
    L29:
        ObricSpecialInputComponent r13 = this.this$0;
        View r4 = r13.k1;
        if (r4 != null) goto L38;
        r4 = LayoutInflater.from(r13.getContext()).inflate(2131564051, this.$container, false);
        final ObricSpecialInputComponent r14 = this.this$0;
        int r5 = ContextCompat.getColor(r4.getContext(), 2131103685);
        OTextView r6 = r4.findViewById(2131381145);
        if (r6 == null) goto L34;
        com.larus.utils.e1.d(r6, new i0(r14));
        r6.setOverridePressColor(r5);
        r6.setChangeAlphaWhenPress(true);
    L34:
        OTextView r7 = r4.findViewById(2131381147);
        if (r7 == null) goto L37;
        com.larus.utils.e1.d(r7, new j0(r14));
        r7.setOverridePressColor(r5);
        r7.setChangeAlphaWhenPress(true);
    L37:
        this.this$0.k1 = r4;
    L38:
        ViewGroup r15 = this.$container;
        ViewGroup r16 = this.$titleContainer;
        ViewGroup.LayoutParams r17 = r4.getLayoutParams();
        if ((r17 instanceof ConstraintLayout.LayoutParams) == false) goto L41;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
    L42:
        if (r18 != null) goto L44;
        r18 = new ConstraintLayout.LayoutParams(-1, -2);
    L44:
        r18.startToStart = 0;
        r18.endToEnd = 0;
        r18.topToBottom = r16.getId();
        r18.setMarginStart(i5.h());
        r18.setMarginEnd(i5.h());
        r4.setLayoutParams(r18);
        r15.addView(r4);
        ScrollView r19 = this.this$0.Z3();
        if (r19 == null) goto L47;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
    L49:
        if ((r20 instanceof ConstraintLayout.LayoutParams) == false) goto L51;
        r3 = (ConstraintLayout.LayoutParams) r20;
    L51:
        if (r3 == null) goto L61;
        ObricSpecialInputComponent r21 = this.this$0;
        if (r21.p1 != null) goto L56;
        r21.p1 = Boxing.boxInt(r3.topToBottom);
    L56:
        if (r21.v1 != null) goto L58;
        r21.v1 = Boxing.boxInt(((ViewGroup.MarginLayoutParams) r3).topMargin);
    L58:
        r3.topToBottom = r4.getId();
        ((ViewGroup.MarginLayoutParams) r3).topMargin = i5.h();
        ScrollView r22 = r21.Z3();
        if (r22 == null) goto L61;
        r22.setLayoutParams(r3);
    L61:
        SpecialTrackEventUtilsKt.c();
        return Unit.INSTANCE;
    L47:
        r20 = null;
        goto L49
    L41:
        r18 = null;
        goto L42
    L25:
        r12 = null;
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        ObricSpecialInputComponent r23 = this.this$0;
        this.label = 1;
        r8 = ObricSpecialInputComponent.h3(r23, this);
        if (r8 != r0) goto L12;
        return r0;
    }
}
