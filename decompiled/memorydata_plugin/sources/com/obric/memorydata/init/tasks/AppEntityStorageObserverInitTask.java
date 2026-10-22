package com.obric.memorydata.init.tasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/AppEntityStorageObserverInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "executeTask", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppEntityStorageObserverInitTask extends IInitTask {
    public AppEntityStorageObserverInitTask() {
    }

    private final void a() {
        ThreadPoolContainer.Companion.execute($$Lambda$AppEntityStorageObserverInitTask$FCP1aRE2GpOmZ0QL3WElgg67Y_o.INSTANCE);
    }

    private static final void b() {
        com.obric.memorydata.personalcontext.storage.e.f12343a.a();
    }

    public static /* synthetic */ void lambda$FCP1aRE2GpOmZ0QL3WElgg67Y_o() {
        b();
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
