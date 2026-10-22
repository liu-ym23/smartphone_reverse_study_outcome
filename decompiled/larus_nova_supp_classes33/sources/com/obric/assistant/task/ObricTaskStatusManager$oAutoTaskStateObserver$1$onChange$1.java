package com.obric.assistant.task;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.actionbar.statemanager.state.ObricOAutoTaskState;
import com.obric.assistant.performance.IObricMemoryReportService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.task.ObricTaskStatusManager$oAutoTaskStateObserver$1$onChange$1", f = "ObricTaskStatusManager.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class ObricTaskStatusManager$oAutoTaskStateObserver$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricTaskStatusManager$oAutoTaskStateObserver$1$onChange$1(Continuation<? super ObricTaskStatusManager$oAutoTaskStateObserver$1$onChange$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricTaskStatusManager$oAutoTaskStateObserver$1$onChange$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Pair r8 = (Pair) r7;
        String r2 = (String) r8.component1();
        String r9 = (String) r8.component2();
        FLogger.a.i("ObricTaskStatusManager", "onChange, oauto task state changed to " + r2 + ", taskSource=" + r9);
        if (r2 == null) goto L30;
        Intrinsics.checkNotNullParameter(r2, "originState");
        Iterator r10 = ObricOAutoTaskState.getEntries().iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        Object r4 = r10.next();
        if (StringsKt.equals(StringsKt.trim(((ObricOAutoTaskState) r4).getValue()).toString(), StringsKt.trim(r2).toString(), true) == false) goto L15;
        r3 = r4;
    L19:
        ObricOAutoTaskState r5 = (ObricOAutoTaskState) r3;
        if (r5 != null) goto L22;
        r5 = ObricOAutoTaskState.IDLE;
    L22:
        IObricMemoryReportService.a.getClass();
        IObricMemoryReportService r11 = IObricMemoryReportService.a.a();
        if (r11 == null) goto L30;
        if (r5 != ObricOAutoTaskState.IDLE) goto L27;
        String r6 = "";
    L28:
        r11.a(r6, false);
        goto L30
    L27:
        r6 = "oauto";
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ObricTaskStatusManager r12 = ObricTaskStatusManager.a;
        this.label = 1;
        r12.getClass();
        r7 = BuildersKt.withContext(Dispatchers.getIO(), new ObricTaskStatusManager$queryOAutoTaskState$2(null), this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
