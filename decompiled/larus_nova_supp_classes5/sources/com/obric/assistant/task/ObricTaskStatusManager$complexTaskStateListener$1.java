package com.obric.assistant.task;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.assistant.utils.l;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/obric/assistant/task/ObricTaskStatusManager$complexTaskStateListener$1", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL$Stub;", "onDMStateChanged", "", "dmState", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "onTaskAdded", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "onTaskEnd", "onTaskStateChanged", "previousState", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "newState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskStatusManager$complexTaskStateListener$1 extends IAgentDMStateListenerIDL.Stub {
    public void onTaskStateChanged(DMTaskInfo r1, DMTaskState r2, DMTaskState r3) {
    }

    public ObricTaskStatusManager$complexTaskStateListener$1() {
    }

    public void onDMStateChanged(DMStateInfo r8) {
        ObricTaskStatusManager.f.setValue(r8);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDMStateChanged: activeTaskSize ");
        int r2 = 0;
        if (r8 == null) goto L7;
        List r3 = r8.getActiveTasks();
        if (r3 == null) goto L7;
        int r4 = r3.size();
    L8:
        r1.append(r4);
        r0.i("ObricTaskStatusManager", r1.toString());
        if (r8 == null) goto L19;
        List r9 = r8.getActiveTasks();
        if (r9 == null) goto L23;
        Iterator r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L24;
        Object r5 = r10.next();
        int r6 = r2 + 1;
        if (r2 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        FLogger.a.i("ObricTaskStatusManager", "index: " + r2 + ", " + l.g((DMTaskState) r5));
        r2 = r6;
        goto L14
    L24:
        return;
    L23:
        return;
    L19:
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public void onTaskAdded(DMTaskInfo r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onTaskAdded: taskId: ");
        String r2 = null;
        if (r6 == null) goto L5;
        String r3 = r6.getTaskId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r1.append(r3);
        r1.append(", omniTaskId: ");
        if (r6 == null) goto L12;
        r2 = l.c(r6);
    L12:
        if (r2 == null) goto L15;
        r4 = r2;
    L15:
        r1.append(r4);
        r0.i("ObricTaskStatusManager", r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void onTaskEnd(DMTaskInfo r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onTaskEnd: taskId: ");
        String r2 = null;
        if (r6 == null) goto L5;
        String r3 = r6.getTaskId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r1.append(r3);
        r1.append(", omniTaskId: ");
        if (r6 == null) goto L12;
        r2 = l.c(r6);
    L12:
        if (r2 == null) goto L15;
        r4 = r2;
    L15:
        r1.append(r4);
        r0.i("ObricTaskStatusManager", r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }
}
