package com.larus.business.multitask_management.impl.view;

import com.larus.multitask_management.api.customize.ITaskUIFactory;
import com.larus.multitask_management.api.data.TaskUITemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/DefaultTaskUIFactory;", "Lcom/larus/multitask_management/api/customize/ITaskUIFactory;", "<init>", "()V", "priority", "", "getPriority", "()I", "createTaskUI", "Lcom/larus/multitask_management/api/customize/ITaskView;", "context", "Lcom/larus/multitask_management/api/customize/TaskUIContext;", "Lcom/larus/multitask_management/api/customize/ITaskContext;", "taskUITemplate", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultTaskUIFactory implements ITaskUIFactory {
    public DefaultTaskUIFactory() {
    }

    public final int getPriority() {
        return 0;
    }

    public final jl9.a P2(jl9.b r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 != TaskUITemplate.SINGLE_ICON.getValue()) goto L6;
        return z.a;
    L6:
        return e.a;
    }
}
