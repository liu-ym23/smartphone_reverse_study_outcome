package com.obric.memorydata.task.bridge;

import com.obric.memorydata.middleware.api.bridge.ITaskProgressBridgeAPI;
import com.obric.memorydata.task.scheduler.impl.c;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/task/bridge/TaskProgressBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/ITaskProgressBridgeAPI;", "<init>", "()V", "getInst", "notifyProgress", "", "taskId", "", "payload", "Lorg/json/JSONObject;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskProgressBridgeAPIImpl implements ITaskProgressBridgeAPI {
    public static final TaskProgressBridgeAPIImpl INSTANCE = null;

    static {
        INSTANCE = new TaskProgressBridgeAPIImpl();
    }

    private TaskProgressBridgeAPIImpl() {
    }

    @JvmStatic
    public static final TaskProgressBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ITaskProgressBridgeAPI
    public void notifyProgress(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "payload");
        c.f12961a.d().a(r1, r2);
    }
}
