package com.obric.assistant.interaction.impl.essentialtask.task;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.essentialtask.TaskUtils;
import com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask;
import com.obric.assistant.interaction.impl.essentialtask.base.ExecuteResult;
import com.volcengine.zeus.Zeus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0094@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/InstallInternalPluginTask;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalNeedExecute", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstallInternalPluginTask extends EssentialTask {
    private final CoroutineScope coroutineScope;

    public boolean internalNeedExecute() {
        Iterator r0 = TaskUtils.INSTANCE.getPlugins().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Zeus.getPlugin((String) r0.next()).shouldInstallInternalPlugin(false, true) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public InstallInternalPluginTask(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, "install_internal_plugin");
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public Object internalExecute(Continuation<? super ExecuteResult> r13) {
        if ((r13 instanceof internalExecute.1) == false) goto L7;
        internalExecute.1 r0 = (internalExecute.1) r13;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        Iterator r4 = (Iterator) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L14 CancellationException -> L16
    L27:
        if (r4.hasNext() == false) goto L38;
        Deferred r5 = (Deferred) r4.next();
        r0.L$0 = r4;     // Catch: CancellationException -> L16 Exception -> L32
        r0.label = 1;     // Catch: CancellationException -> L16 Exception -> L32
        if (r5.await(r0) != r2) goto L27;
        return r2;
    L32:
        e = move-exception;
        InstallInternalPluginTask r6 = this;
        Exception e = e;
    L34:
        FLogger.a.e(r6.getTaskName(), "install internal plugin failed");
        return new ExecuteResult.Failed(e.getMessage());
    L38:
        return new ExecuteResult.Succeed();
    L16:
        e = move-exception;
        throw e;
    L14:
        e = e;
        r6 = this;
        goto L34
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r14);
        ArrayList r15 = new ArrayList();
        Iterator r7 = TaskUtils.INSTANCE.getPlugins().iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        String r8 = (String) r7.next();
        r15.add(BuildersKt.async$default(this.coroutineScope, null, null, new internalExecute.2.1(r8, null), 3, null));
        goto L22
    L24:
        r4 = r15.iterator();
    L7:
        r0 = new internalExecute.1(this, r13);
        goto L8
    }
}
