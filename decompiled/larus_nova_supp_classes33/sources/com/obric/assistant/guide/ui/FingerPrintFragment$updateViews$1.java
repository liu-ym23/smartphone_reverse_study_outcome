package com.obric.assistant.guide.ui;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.assistant.impl.databinding.ObricGuideForFingerprintBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.guide.ui.FingerPrintFragment$updateViews$1", f = "FingerPrintFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FingerPrintFragment$updateViews$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FingerPrintFragment this$0;

    public FingerPrintFragment$updateViews$1(FingerPrintFragment r1, Continuation<? super FingerPrintFragment$updateViews$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FingerPrintFragment$updateViews$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r3);
        ObricGuideForFingerprintBinding r4 = this.this$0.d;
        if (r4 == null) goto L9;
        OCheckBoxLayout r5 = r4.c;
        if (r5 == null) goto L9;
        r5.setVisibility(8);
    L9:
        ObricGuideForFingerprintBinding r6 = this.this$0.d;
        if (r6 == null) goto L14;
        TextView r7 = r6.g;
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        ObricGuideForFingerprintBinding r8 = this.this$0.d;
        if (r8 == null) goto L19;
        TextView r9 = r8.h;
        if (r9 == null) goto L19;
        r9.setVisibility(8);
    L19:
        ObricGuideForFingerprintBinding r10 = this.this$0.d;
        if (r10 == null) goto L24;
        OButton r11 = r10.l;
        if (r11 == null) goto L24;
        r11.setVisibility(8);
    L24:
        ObricGuideForFingerprintBinding r12 = this.this$0.d;
        if (r12 == null) goto L29;
        OButton r13 = r12.f;
        if (r13 == null) goto L29;
        r13.setVisibility(8);
    L29:
        ObricGuideForFingerprintBinding r14 = this.this$0.d;
        if (r14 == null) goto L34;
        OButton r15 = r14.k;
        if (r15 == null) goto L34;
        r15.setVisibility(0);
    L34:
        ObricGuideForFingerprintBinding r16 = this.this$0.d;
        if (r16 == null) goto L39;
        ConstraintLayout r17 = r16.j;
        if (r17 == null) goto L39;
        r17.setVisibility(8);
    L39:
        ObricGuideForFingerprintBinding r18 = this.this$0.d;
        if (r18 == null) goto L44;
        TextView r19 = r18.d;
        if (r19 == null) goto L44;
        r19.setVisibility(0);
    L44:
        ObricGuideForFingerprintBinding r20 = this.this$0.d;
        if (r20 == null) goto L49;
        TextView r21 = r20.e;
        if (r21 == null) goto L49;
        r21.setVisibility(8);
    L49:
        ObricGuideForFingerprintBinding r22 = this.this$0.d;
        if (r22 == null) goto L55;
        TextView r23 = r22.b;
        if (r23 == null) goto L55;
        r23.setVisibility(0);
    L55:
        return Unit.INSTANCE;
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
