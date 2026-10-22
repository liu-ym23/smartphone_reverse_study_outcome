package com.obric.assistant.special_input;

import java.util.Map;
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
@DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputTaskImpl$requestToShowComplexTaskPanel$1", f = "SpecialInputTaskImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpecialInputTaskImpl$requestToShowComplexTaskPanel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ ObricComplexTaskPanelType $panelType;
    int label;
    final /* synthetic */ SpecialInputTaskImpl this$0;

    public SpecialInputTaskImpl$requestToShowComplexTaskPanel$1(SpecialInputTaskImpl r1, ObricComplexTaskPanelType r2, Map<String, String> r3, Continuation<? super SpecialInputTaskImpl$requestToShowComplexTaskPanel$1> r4) {
        this.this$0 = r1;
        this.$panelType = r2;
        this.$ext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SpecialInputTaskImpl$requestToShowComplexTaskPanel$1(this.this$0, this.$panelType, this.$ext, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r9);
        SpecialInputTaskImpl r1 = this.this$0;
        int r2 = this.$panelType.getValue();
        Map<String, String> r10 = this.$ext;
        if (r10 == null) goto L7;
        String r4 = r10.get("content");
    L8:
        Map<String, String> r11 = this.$ext;
        if (r11 == null) goto L11;
        String r5 = r11.get("o_reference_msg_id");
    L12:
        ISpecialInputTask$a.a(r1, com.obric.assistant.special_input.util.j.c(r2, true, r4, r5, this.$ext, 16), false, false, false, null, 28);
        return Unit.INSTANCE;
    L11:
        r5 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
