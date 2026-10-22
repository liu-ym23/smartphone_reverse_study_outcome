package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J5\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u000e0\u000e \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J)\u0010\u0016\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u0018\u001a\n \u000b*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J)\u0010\u0019\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0013H\u0096\u0001J)\u0010\u001c\u001a\u00020\b2\u000e\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentTaskAppIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentTaskAppIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentTaskAppIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "addTaskManagerShortcut", "", "resultCallback", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "getShortcutRecommendItems", "", "Lcom/obric/aiagent/assistant/idl/bean/ShortcutRecommendItem;", "", "limit", "", "hasShortcutForMessage", "", "messageId", "", "openEventTaskDetailPage", "taskId", "enterFrom", "runShortcutTaskFromRecommendPanel", "source", "shouldShowAddTaskManagerIconGuide", "testRunConditionTask", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class AgentTaskAppIDLStub extends IAgentTaskAppIDL.Stub {
    private final /* synthetic */ IAgentTaskAppIDL $$delegate_0;

    public void addTaskManagerShortcut(PendingIntent r2) {
        this.$$delegate_0.addTaskManagerShortcut(r2);
    }

    public List<ShortcutRecommendItem> getShortcutRecommendItems(int r2) {
        return this.$$delegate_0.getShortcutRecommendItems(r2);
    }

    public boolean hasShortcutForMessage(String r2) {
        return this.$$delegate_0.hasShortcutForMessage(r2);
    }

    public void openEventTaskDetailPage(String r2, String r3) {
        this.$$delegate_0.openEventTaskDetailPage(r2, r3);
    }

    public void runShortcutTaskFromRecommendPanel(String r2, String r3) {
        this.$$delegate_0.runShortcutTaskFromRecommendPanel(r2, r3);
    }

    public boolean shouldShowAddTaskManagerIconGuide() {
        return this.$$delegate_0.shouldShowAddTaskManagerIconGuide();
    }

    public void testRunConditionTask(String r2, String r3) {
        this.$$delegate_0.testRunConditionTask(r2, r3);
    }

    public AgentTaskAppIDLStub() {
        IAgentTaskAppIDL r0 = (IAgentTaskAppIDLSPI) ServiceManager.get().getService(IAgentTaskAppIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IAgentTaskAppIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
