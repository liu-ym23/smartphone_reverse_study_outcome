package com.bytedance.ai.resource;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001*\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager$getAllInstalledAppletInfo$2", f = "AIManager.kt", i = {}, l = {525, 527}, m = "invokeSuspend", n = {}, s = {})
final class AIManager$getAllInstalledAppletInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HashMap<String, Object>>>, Object> {
    int label;

    public AIManager$getAllInstalledAppletInfo$2(Continuation<? super AIManager$getAllInstalledAppletInfo$2> r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        return new AIManager$getAllInstalledAppletInfo$2(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends HashMap<String, Object>>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L20:
        return (List) r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L21:
        return (List) r10;
    L10:
        ResultKt.throwOnFailure(r10);
        AIManager r11 = AIManager.a;
        if (AIManager.l == false) goto L16;
        this.label = 1;
        r10 = AIManager.b(r11, this);
        if (r10 != r0) goto L21;
        return r0;
    L16:
        this.label = 2;
        r10 = AIManager.a(r11, this);
        if (r10 != r0) goto L20;
        return r0;
    }
}
