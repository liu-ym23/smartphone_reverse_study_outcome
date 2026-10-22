package com.obric.assistant.reporter.utils;

import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.oauto.b;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.reporter.utils.ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1", f = "ObricLaunchReportManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1(Continuation<? super ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        IOAutoApi r4 = b.a();
        boolean r0 = false;
        if (r4 == null) goto L10;
        if (r4.b() != true) goto L10;
        r0 = true;
    L10:
        return Boxing.boxBoolean(r0);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
