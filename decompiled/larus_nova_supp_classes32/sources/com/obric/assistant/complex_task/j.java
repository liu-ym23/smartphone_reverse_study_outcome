package com.obric.assistant.complex_task;

import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class j implements com.obric.aiagent.ipc.utils.g.b {
    public /* synthetic */ j() {
    }

    public final void a(Object r10) {
        IAgentDMStateManagerIDL r11 = (IAgentDMStateManagerIDL) r10;
        Intrinsics.checkNotNullParameter(r11, "ipc");
        FLogger r0 = FLogger.a;
        r0.i("ComplexTaskManager", "registerDMStateListener");
        DMStateInfo r2 = r11.getCurrentDMSteate();
        if (r2 == null) goto L26;
        List r3 = r2.getActiveTasks();
        if (r3 == null) goto L26;
        ArrayList r4 = new ArrayList();
        Iterator r1 = r3.iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        Object r5 = r1.next();
        DMTaskInfo r6 = ((DMTaskState) r5).getTaskInfo();
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L8;
        r4.add(r5);
        goto L8
    L12:
        if (r6.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L14;
        r7 = true;
        goto L15
    L17:
        FLogger.a.i("ComplexTaskManager", "initActiveTasks, active tasks size is " + r3.size() + ", complex task size = " + r4.size());
        Iterator r8 = r4.iterator();
    L19:
        if (r8.hasNext() == false) goto L27;
        DMTaskState r9 = (DMTaskState) r8.next();
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("initActiveTasks, taskId = ");
        r13.append(r9.getTaskId());
        r13.append(", state = ");
        t r14 = ComplexTaskManager.a;
        r13.append(ComplexTaskManager.c(Integer.valueOf(r9.getState())));
        r12.i("ComplexTaskManager", r13.toString());
        DMTaskInfo r15 = r9.getTaskInfo();
        if (r15 != null) goto L22;
        r12.i("ComplexTaskManager", "initActiveTasks, task info is null " + r9.getTaskId());
        goto L19
    L22:
        ComplexTaskManager.d(r15, null, r9, r4, ComplexTaskManager.UpdateSource.MANAGER_INIT);
        if (r9.getState() != DMConstData.DMComplexTaskState.Queueing.ordinal()) goto L19;
        ComplexTaskManager.f(r9.getTaskId(), r3);
    L27:
        IBinder r16 = r11.asBinder();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L30
        r16.linkToDeath(new k(), 0);     // Catch: Throwable -> L30
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        r11.registerDMStateListener(ComplexTaskManager.d);
        return;
    L30:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        r0.i("ComplexTaskManager", "initActiveTasks, active tasks is null");
        goto L27
    }
}
