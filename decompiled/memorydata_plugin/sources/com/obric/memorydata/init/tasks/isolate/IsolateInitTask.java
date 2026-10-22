package com.obric.memorydata.init.tasks.isolate;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.isolate.api.IISolateApi;
import com.obric.memorydata.isolate.api.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/init/tasks/isolate/IsolateInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IsolateInitTask extends IInitTask {
    public IsolateInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IISolateApi r0 = a.a();
        if (r0 == null) goto L6;
        r0.init();
        return;
    }
}
