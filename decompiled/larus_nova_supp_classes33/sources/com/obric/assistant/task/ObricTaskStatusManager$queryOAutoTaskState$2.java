package com.obric.assistant.task;

import android.os.Build;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.task.ObricTaskStatusManager$queryOAutoTaskState$2", f = "ObricTaskStatusManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricTaskStatusManager$queryOAutoTaskState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
    int label;

    public ObricTaskStatusManager$queryOAutoTaskState$2(Continuation<? super ObricTaskStatusManager$queryOAutoTaskState$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricTaskStatusManager$queryOAutoTaskState$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<String, String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        String r1 = null;
        if (Build.VERSION.SDK_INT >= 29) goto L20;
    L10:
        Bundle r6 = null;
    L11:
        if (r6 == null) goto L13;
        String r0 = r6.getString("state");
    L14:
        if (r6 == null) goto L17;
        r1 = r6.getString("o_task_source");
    L17:
        return TuplesKt.to(r0, r1);
    L13:
        r0 = null;
        goto L14
    L20:
        r6 = AppHost.a.getApplication().getApplicationContext().getContentResolver().call("com.obric.assistantaiagent.OAutoStateProvider", "get_current_state", null, null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        FLogger.a.e("ObricTaskStatusManager", "queryOAutoTaskState, call failed", e);
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
