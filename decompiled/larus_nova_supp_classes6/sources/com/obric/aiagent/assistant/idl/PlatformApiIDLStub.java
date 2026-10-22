package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JM\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\u000b0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0001J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/assistant/idl/PlatformApiIDLStub;", "Lcom/obric/aiagent/assistant/idl/IPlatformApiIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IPlatformApiIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getTasksPackages", "", "", "kotlin.jvm.PlatformType", "", "maxNum", "", "filterOnlyVisibleRecents", "", "keepIntentExtra", "displayId", "moveTaskToDisplay", "taskId", "isTop", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class PlatformApiIDLStub extends IPlatformApiIDL.Stub {
    private final /* synthetic */ IPlatformApiIDL $$delegate_0;

    public List<String> getTasksPackages(int r2, boolean r3, boolean r4, int r5) {
        return this.$$delegate_0.getTasksPackages(r2, r3, r4, r5);
    }

    public boolean moveTaskToDisplay(int r2, int r3, boolean r4) {
        return this.$$delegate_0.moveTaskToDisplay(r2, r3, r4);
    }

    public PlatformApiIDLStub() {
        IPlatformApiIDL r0 = (IPlatformApiIDLSPI) ServiceManager.get().getService(IPlatformApiIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IPlatformApiIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
