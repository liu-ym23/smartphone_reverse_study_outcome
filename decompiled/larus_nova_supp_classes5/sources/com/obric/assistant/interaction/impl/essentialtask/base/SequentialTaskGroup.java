package com.obric.assistant.interaction.impl.essentialtask.base;

import android.content.Context;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\rH\u0094@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/base/SequentialTaskGroup;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", "context", "Landroid/content/Context;", "taskName", "", "taskList", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "getTaskList", "()Ljava/util/List;", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalNeedExecute", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SequentialTaskGroup extends EssentialTask {
    public static final Companion Companion = null;
    private static final String TAG = "EssentialTaskSequentialTaskGroup";
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bf -> B:48:0x00c8). Please report as a decompilation issue!!! */
    public Object internalExecute(Continuation<? super ExecuteResult> r15) {
        if ((r15 instanceof internalExecute.1) == false) goto L7;
        internalExecute.1 r0 = (internalExecute.1) r15;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        long r7 = r0.J$0;
        EssentialTask r4 = (EssentialTask) r0.L$2;
        Iterator r9 = (Iterator) r0.L$1;
        Iterable r10 = (Iterable) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L44
        Iterable r11 = r10;
        Iterator r12 = r9;
        long r8 = r7;
        EssentialTask r13 = r4;
        Object r5 = r2;
        internalExecute.1 r6 = r0;
        SequentialTaskGroup r14 = this;
    L48:
        ExecuteResult r17 = (ExecuteResult) r16;     // Catch: Throwable -> L37
        if (r17.isSuccess() == true) goto L36;
        FLogger r18 = FLogger.a;     // Catch: Throwable -> L37
        r18.w(TAG, "task " + r13 + " execute failed");     // Catch: Throwable -> L37
        r18.i(TAG, "SequentialTaskGroup " + r14.getTaskName() + " finished. execute time: " + (SystemClock.elapsedRealtime() - r8));
        return r17;
    L36:
        SequentialTaskGroup r19 = r14;
        r0 = r6;
        r2 = r5;
        long r20 = r8;
        Iterator r21 = r12;
        Iterable r110 = r11;
    L51:
    L42:
        th = move-exception;
        r14 = r19;
        th = th;
    L46:
        FLogger.a.i(TAG, "SequentialTaskGroup " + r14.getTaskName() + " finished. execute time: " + (SystemClock.elapsedRealtime() - r20));
        throw th;
    L26:
        if (r21.hasNext() == false) goto L39;
        EssentialTask r22 = (EssentialTask) r21.next();     // Catch: Throwable -> L42
        r0.L$0 = r110;     // Catch: Throwable -> L42
        r0.L$1 = r21;     // Catch: Throwable -> L42
        r0.L$2 = r22;     // Catch: Throwable -> L42
        r0.J$0 = r20;     // Catch: Throwable -> L42
        r0.label = 1;     // Catch: Throwable -> L42
        Object r111 = r22.execute(r0);     // Catch: Throwable -> L42
        if (r111 != r2) goto L30;
        return r2;
    L30:
        internalExecute.1 r112 = r0;
        r14 = r19;
        r16 = r111;
        r11 = r110;
        r12 = r21;
        r8 = r20;
        r13 = r22;
        r5 = r2;
        r6 = r112;
        goto L48
    L39:
        List r113 = (List) r110;     // Catch: Throwable -> L42
        FLogger.a.i(TAG, "SequentialTaskGroup " + r19.getTaskName() + " finished. execute time: " + (SystemClock.elapsedRealtime() - r20));
        return new ExecuteResult.Succeed();
    L37:
        th = th;
        r20 = r8;
        goto L46
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        FLogger.a.i(TAG, "SequentialTaskGroup " + getTaskName() + " start execute. taskList size: " + this.taskList.size());
        r20 = SystemClock.elapsedRealtime();
        List<EssentialTask> r114 = this.taskList;     // Catch: Throwable -> L44
        ArrayList r23 = new ArrayList();     // Catch: Throwable -> L44
        Iterator<T> r115 = r114.iterator();     // Catch: Throwable -> L44
    L19:
        if (r115.hasNext() == false) goto L24;
        Object r24 = r115.next();     // Catch: Throwable -> L44
        if (((EssentialTask) r24).needExecute() == false) goto L19;
        r23.add(r24);     // Catch: Throwable -> L44
        goto L19
    L24:
        r21 = r23.iterator();     // Catch: Throwable -> L44
        r110 = r23;
        r19 = this;
    L44:
        th = th;
        r14 = this;
    L7:
        r0 = new internalExecute.1(this, r15);
        goto L8
    }

    public SequentialTaskGroup(Context r2, String r3, List<? extends EssentialTask> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskName");
        Intrinsics.checkNotNullParameter(r4, "taskList");
        super(r2, r3);
        this.taskList = r4;
    }
}
