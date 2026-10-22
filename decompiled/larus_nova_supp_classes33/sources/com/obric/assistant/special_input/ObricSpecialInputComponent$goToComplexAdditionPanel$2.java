package com.obric.assistant.special_input;

import androidx.appcompat.widget.AppCompatTextView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.util.VContextMessageExKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$goToComplexAdditionPanel$2", f = "ObricSpecialInputComponent.kt", i = {}, l = {2563}, m = "invokeSuspend", n = {}, s = {})
final class ObricSpecialInputComponent$goToComplexAdditionPanel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatTextView $content;
    final /* synthetic */ StateInfo $stateInfo;
    int label;
    final /* synthetic */ ObricSpecialInputComponent this$0;

    public ObricSpecialInputComponent$goToComplexAdditionPanel$2(ObricSpecialInputComponent r1, StateInfo r2, AppCompatTextView r3, Continuation<? super ObricSpecialInputComponent$goToComplexAdditionPanel$2> r4) {
        this.this$0 = r1;
        this.$stateInfo = r2;
        this.$content = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricSpecialInputComponent$goToComplexAdditionPanel$2(this.this$0, this.$stateInfo, this.$content, r5);
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
        StateInfo r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L15:
        Message r6 = (Message) r5;
        StateInfo r3 = this.$stateInfo;
        laa.v r4 = (laa.v) this.this$0.P.getValue();
        if (r4 == null) goto L19;
        r2 = r4.b;
    L19:
        if (Intrinsics.areEqual(r3, r2) == false) goto L27;
        AppCompatTextView r7 = this.$content;
        if (r7 == null) goto L27;
        if (r6 == null) goto L24;
        String r8 = com.larus.bmhome.chat.bean.d.H(r6);
    L25:
        r7.setText(r8);
        goto L27
    L24:
        r8 = AppHost.a.getApplication().getString(2131908670);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        t1a.b r9 = s1a.d.a(this.this$0);
        StateInfo r10 = this.$stateInfo;
        if (r10 == null) goto L11;
        String r11 = r10.getRefMessageId();
    L12:
        this.label = 1;
        r5 = VContextMessageExKt.a(r9, r11, this);
        if (r5 != r0) goto L15;
        return r0;
    L11:
        r11 = null;
        goto L12
    }
}
