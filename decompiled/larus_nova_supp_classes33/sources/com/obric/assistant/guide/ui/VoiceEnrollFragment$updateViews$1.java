package com.obric.assistant.guide.ui;

import android.widget.TextView;
import com.obric.assistant.impl.databinding.ObricGuideForVoiceEnrollBinding;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.guide.ui.VoiceEnrollFragment$updateViews$1", f = "VoiceEnrollFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollFragment$updateViews$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceEnrollFragment this$0;

    public VoiceEnrollFragment$updateViews$1(VoiceEnrollFragment r1, Continuation<? super VoiceEnrollFragment$updateViews$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoiceEnrollFragment$updateViews$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r3);
        ObricGuideForVoiceEnrollBinding r4 = this.this$0.d;
        if (r4 == null) goto L9;
        OButton r5 = r4.d;
        if (r5 == null) goto L9;
        r5.setVisibility(0);
    L9:
        ObricGuideForVoiceEnrollBinding r6 = this.this$0.d;
        if (r6 == null) goto L14;
        OButton r7 = r6.e;
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        ObricGuideForVoiceEnrollBinding r8 = this.this$0.d;
        if (r8 == null) goto L19;
        OButton r9 = r8.j;
        if (r9 == null) goto L19;
        r9.setVisibility(8);
    L19:
        ObricGuideForVoiceEnrollBinding r10 = this.this$0.d;
        if (r10 == null) goto L24;
        TextView r11 = r10.g;
        if (r11 == null) goto L24;
        r11.setVisibility(0);
    L24:
        ObricGuideForVoiceEnrollBinding r12 = this.this$0.d;
        if (r12 == null) goto L29;
        TextView r13 = r12.h;
        if (r13 == null) goto L29;
        r13.setVisibility(8);
    L29:
        ObricGuideForVoiceEnrollBinding r14 = this.this$0.d;
        if (r14 == null) goto L35;
        TextView r15 = r14.b;
        if (r15 == null) goto L35;
        r15.setVisibility(0);
    L35:
        return Unit.INSTANCE;
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
