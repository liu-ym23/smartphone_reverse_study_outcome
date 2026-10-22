package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.advance.AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1", f = "AdvanceVoiceInputComponent.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
final class AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $r;
    int label;
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1(b r1, a r2, Continuation<? super AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1> r3) {
        this.this$0 = r1;
        this.$r = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AdvanceVoiceInputComponent$recordListener$1$onRecordTimeTooShort$1(this.this$0, this.$r, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L17;
        ResultKt.throwOnFailure(r3);
        Object r4 = ((g) r3).a;
        g.c r1 = g.b;
        if ((!(r4 instanceof g.c)) == false) goto L15;
        Boolean r5 = (Boolean) g.b(r4);
        if (r5 == null) goto L15;
        a r2 = this.$r;
        if (r5.booleanValue() == true) goto L15;
        r2.getClass();
        throw null;
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        this.this$0.getClass();
        this.label = 1;
        throw null;
    }
}
