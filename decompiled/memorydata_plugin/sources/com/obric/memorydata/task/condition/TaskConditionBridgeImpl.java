package com.obric.memorydata.task.condition;

import com.obric.memorydata.middleware.api.bridge.ITaskConditionBridgeApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/task/condition/TaskConditionBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/ITaskConditionBridgeApi;", "<init>", "()V", "getInst", "isSatisfied", "", "conditionNames", "", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskConditionBridgeImpl implements ITaskConditionBridgeApi {
    public static final TaskConditionBridgeImpl INSTANCE = null;

    static {
        INSTANCE = new TaskConditionBridgeImpl();
    }

    private TaskConditionBridgeImpl() {
    }

    @JvmStatic
    public static final TaskConditionBridgeImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ITaskConditionBridgeApi
    public boolean isSatisfied(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "conditionNames");
        return com.obric.memorydata.task.scheduler.impl.c.f12961a.e().a().a(r1);
    }
}
