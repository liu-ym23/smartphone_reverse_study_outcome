package com.obric.assistant.task;

import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.task.ObricTaskStatusManager$init$1", f = "ObricTaskStatusManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricTaskStatusManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricTaskStatusManager$init$1(Continuation<? super ObricTaskStatusManager$init$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricTaskStatusManager$init$1 r0 = new ObricTaskStatusManager$init$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        IAgentDMStateManagerIDL r8 = f.a(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class));     // Catch: Throwable -> L11
        if (r8 == null) goto L8;
        DMStateInfo r9 = r8.getCurrentDMSteate();     // Catch: Throwable -> L11
    L9:
        ObricTaskStatusManager.f.setValue(r9);     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L16;
        FLogger.a.w("ObricTaskStatusManager", "get current dm state failed, " + r11.getMessage(), r11);
    L16:
        ObricTaskStatusManager.a.getClass();
        f.b(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class), new a());
        Uri r12 = y0.j("content://com.obric.assistantaiagent.OAutoStateProvider");
        if (r12 != null) goto L27;
        FLogger.a.e("ObricTaskStatusManager", "onViewCreated, URL.toUri() is null");
    L24:
        return Unit.INSTANCE;
    L27:
        AppHost.a.getApplication().getApplicationContext().getContentResolver().registerContentObserver(r12, true, ObricTaskStatusManager.k);     // Catch: Exception -> L20
        FLogger.a.i("ObricTaskStatusManager", "onViewCreated, registerContentObserver success");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        FLogger.a.e("ObricTaskStatusManager", "onViewCreated, registerContentObserver failed", e);
        goto L24
    L8:
        r9 = null;
    L11:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
