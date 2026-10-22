package com.obric.memorydata.personalcontext.task;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.memorydata.aikernelcore.h;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/PapayaUpdateTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PapayaUpdateTask extends NativeTask {
    public static final Companion Companion = null;
    public static final String NAME = "PapayaUpdateTask";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/PapayaUpdateTask$Companion;", "", "<init>", "()V", "NAME", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PapayaUpdateTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        RunLog.INSTANCE.debug(NAME, "updateAllPackageInfo");
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L6;
        h.f8481a.b();
        return new TaskResult(0, null, null, null, 14, null);
    L6:
        return new TaskResult(1, "network unavailable", null, null, 12, null);
    }
}
