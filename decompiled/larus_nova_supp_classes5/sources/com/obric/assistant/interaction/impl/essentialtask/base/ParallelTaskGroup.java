package com.obric.assistant.interaction.impl.essentialtask.base;

import android.content.Context;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\rH\u0094@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/ParallelTaskGroup;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", "context", "Landroid/content/Context;", "taskName", "", "taskList", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "getTaskList", "()Ljava/util/List;", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalNeedExecute", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParallelTaskGroup extends EssentialTask {
    public static final Companion Companion = null;
    private static final String TAG = "EssentialTaskParallelTaskGroup";
    private final List<EssentialTask> taskList;

    static {
        Companion = new Companion(null);
    }

    public boolean internalNeedExecute() {
        List<EssentialTask> r0 = this.taskList;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((EssentialTask) r1.next()).needExecute() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final List<EssentialTask> getTaskList() {
        return this.taskList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.interaction.impl.essentialtask.base.ParallelTaskGroup$internalExecute$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public Object internalExecute(Continuation<? super ExecuteResult> r11) {
        if ((r11 instanceof internalExecute.1) == false) goto L7;
        internalExecute.1 r0 = (internalExecute.1) r11;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
        long r2 = r0;
    L8:
        Object r12 = ((internalExecute.1) r2).result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = ((internalExecute.1) r2).label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r5 = ((internalExecute.1) r2).J$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14 CancellationException -> L34
    L23:
        ExecuteResult.Succeed r13 = new ExecuteResult.Succeed();     // Catch: Throwable -> L14 CancellationException -> L34
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("executeParallelTaskGroup ");
    L30:
        r7.append(getTaskName());
        r7.append(" finished. execute time: ");
        r7.append(SystemClock.elapsedRealtime() - r5);
        r6.i(TAG, r7.toString());
        return r13;
    L28:
        r13 = new ExecuteResult(false, null, 2, null);     // Catch: Throwable -> L14
        r6 = FLogger.a;
        r7 = new StringBuilder("executeParallelTaskGroup ");
        goto L30
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        FLogger.a.i(TAG, "executeParallelTaskGroup " + getTaskName() + " start execute. taskList size: " + this.taskList.size());
        long r8 = SystemClock.elapsedRealtime();
        internalExecute.2 r14 = new internalExecute.2(this, null);     // Catch: Throwable -> L25 CancellationException -> L27
        ((internalExecute.1) r2).J$0 = r8;     // Catch: Throwable -> L25 CancellationException -> L27
        ((internalExecute.1) r2).label = 1;     // Catch: Throwable -> L25 CancellationException -> L27
        if (CoroutineScopeKt.coroutineScope(r14, r2) != r3) goto L22;
        return r3;
    L22:
        r5 = r8;
        goto L23
    L27:
        r5 = r8;
    L25:
        th = th;
        r2 = r8;
    L32:
        FLogger.a.i(TAG, "executeParallelTaskGroup " + getTaskName() + " finished. execute time: " + (SystemClock.elapsedRealtime() - r2));
        throw th;
    L14:
        th = th;
    L7:
        r2 = new internalExecute.1(this, r11);
        goto L8
    }

    public ParallelTaskGroup(Context r2, String r3, List<? extends EssentialTask> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskName");
        Intrinsics.checkNotNullParameter(r4, "taskList");
        super(r2, r3);
        this.taskList = r4;
    }
}
