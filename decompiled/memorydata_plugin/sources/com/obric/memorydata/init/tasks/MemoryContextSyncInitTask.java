package com.obric.memorydata.init.tasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.memory.contextsync.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/init/tasks/MemoryContextSyncInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryContextSyncInitTask extends IInitTask {
    public MemoryContextSyncInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        f.f10102a.a();
    }
}
