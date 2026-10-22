package com.obric.memorydata.task;

import com.obric.memorydata.task.impl.TaskInfo;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/task/BatchTaskCallBack;", "", "onOneTaskFinished", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "onAllTaskFinished", "batchTaskResult", "", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {
    void a(TaskInfo r1);

    void a(Map<String, TaskInfo> r1);
}
