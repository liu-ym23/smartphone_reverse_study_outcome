package com.obric.assistant.live.island;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.f;
import com.obric.assistant.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/obric/assistant/live/island/ComplexTaskQueueingAndCompletionIslandMonitor$mListener$1", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL$Stub;", "onDMStateChanged", "", "dmState", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "onTaskAdded", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "onTaskEnd", "onTaskStateChanged", "previousState", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "newState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskQueueingAndCompletionIslandMonitor$mListener$1 extends IAgentDMStateListenerIDL.Stub {
    public void onTaskAdded(DMTaskInfo r1) {
    }

    public void onTaskEnd(DMTaskInfo r1) {
    }

    public ComplexTaskQueueingAndCompletionIslandMonitor$mListener$1() {
    }

    public void onDMStateChanged(DMStateInfo r8) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDMStateChanged, activeTaskSize=");
        int r2 = 0;
        if (r8 == null) goto L7;
        List r3 = r8.getActiveTasks();
        if (r3 == null) goto L7;
        int r4 = r3.size();
    L8:
        r1.append(r4);
        r1.append(", activeTaskIds=");
        List r5 = null;
        if (r8 == null) goto L22;
        List r6 = r8.getActiveTasks();
        if (r6 == null) goto L22;
        List r7 = r6;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r10 = r7.iterator();
    L14:
        if (r10.hasNext() == false) goto L23;
        DMTaskInfo r11 = ((DMTaskState) r10.next()).getTaskInfo();
        if (r11 == null) goto L18;
        String r12 = r11.getTaskId();
    L19:
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        r9.add(r12);
        goto L14
    L18:
        r12 = null;
    L23:
        r1.append(r9);
        r0.i("ComplexTaskQueueingAndCompletionIslandMonitor", r1.toString());
        ComplexTaskQueueingAndCompletionIslandMonitor r13 = ComplexTaskQueueingAndCompletionIslandMonitor.a;
        if (r8 == null) goto L26;
        r5 = r8.getActiveTasks();
    L26:
        r13.getClass();
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("updateCompletedCardSummaries, activeTaskSize=");
        if (r5 == null) goto L29;
        r2 = r5.size();
    L29:
        r15.append(r2);
        r14.i("ComplexTaskQueueingAndCompletionIslandMonitor", r15.toString());
        if (r5 == null) goto L35;
        Iterator r16 = r5.iterator();
    L33:
        if (r16.hasNext() == false) goto L40;
        DMTaskState r17 = (DMTaskState) r16.next();
        ComplexTaskQueueingAndCompletionIslandMonitor r18 = ComplexTaskQueueingAndCompletionIslandMonitor.a;
        DMTaskInfo r19 = r17.getTaskInfo();
        r18.getClass();
        ComplexTaskQueueingAndCompletionIslandMonitor.a(r19);
        goto L33
    L40:
        return;
    L35:
        return;
    L22:
        r9 = null;
    L7:
        r4 = 0;
        goto L8
    }

    public void onTaskStateChanged(DMTaskInfo r8, DMTaskState r9, DMTaskState r10) {
        ComplexTaskQueueingAndCompletionIslandMonitor.a.getClass();
        int r0 = 0;
        Integer r1 = null;
        if (r8 != null) goto L5;
    L10:
        DMTaskInfo r2 = null;
    L12:
        if (r2 != null) goto L22;
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("onTaskStateChanged skipped, taskInfo is null or not complex, taskId=");
        if (r8 == null) goto L16;
        String r3 = r8.getTaskId();
    L17:
        r12.append(r3);
        r12.append(", taskType=");
        if (r8 == null) goto L20;
        r1 = Integer.valueOf(r8.getTaskType());
    L20:
        r12.append(r1);
        r11.i("ComplexTaskQueueingAndCompletionIslandMonitor", r12.toString());
        return;
    L16:
        r3 = null;
        goto L17
    L22:
        if (r10 != null) goto L25;
        FLogger.a.i("ComplexTaskQueueingAndCompletionIslandMonitor", "onTaskStateChanged skipped, newState is null, taskId=" + r2.getTaskId());
        return;
    L25:
        IAgentDMStateManagerIDL r13 = f.a(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class));
        if (r13 == null) goto L28;
        DMStateInfo r14 = r13.getCurrentDMSteate();
    L29:
        if (r14 == null) goto L31;
        List r15 = r14.getActiveTasks();
    L32:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("onTaskStateChanged, taskId=");
        r5.append(r2.getTaskId());
        r5.append(", omniTaskId=");
        r5.append(l.c(r2));
        r5.append(", previousState=");
        if (r9 == null) goto L35;
        r1 = Integer.valueOf(r9.getState());
    L35:
        r5.append(r1);
        r5.append(", currentState=");
        r5.append(r10.getState());
        r5.append(", activeTaskSize=");
        if (r15 == null) goto L38;
        r0 = r15.size();
    L38:
        r5.append(r0);
        r4.i("ComplexTaskQueueingAndCompletionIslandMonitor", r5.toString());
        ComplexTaskQueueingAndCompletionIslandMonitor.b.update(r15);
        ComplexTaskQueueingAndCompletionIslandMonitor.a(r2);
        return;
    L31:
        r15 = null;
        goto L32
    L28:
        r14 = null;
        goto L29
    L5:
        if (r8.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        r2 = r8;
        goto L12
    L7:
        r6 = false;
        goto L8
    }
}
