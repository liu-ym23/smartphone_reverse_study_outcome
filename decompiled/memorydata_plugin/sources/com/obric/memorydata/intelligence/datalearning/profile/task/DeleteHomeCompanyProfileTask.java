package com.obric.memorydata.intelligence.datalearning.profile.task;

import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/task/DeleteHomeCompanyProfileTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeleteHomeCompanyProfileTask extends NativeTask {
    public static final a Companion = null;
    private static final String TAG = "DeleteHomeCompanyMiddleProfileTask";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/task/DeleteHomeCompanyProfileTask$Companion;", "", "<init>", "()V", "TAG", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public DeleteHomeCompanyProfileTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run DeleteHomeCompanyMiddleProfileTask", false, 4, null);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteByUriKey(ProfileLabel.HOME_GPS.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteByUriKey(ProfileLabel.COMPANY_GPS.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteByUriKey(ProfileLabel.HOME_CELL_ID.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteByUriKey(ProfileLabel.COMPANY_CELL_ID.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteByUriKey(ProfileLabel.HOME_BSS_ID.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteByUriKey(ProfileLabel.COMPANY_BSS_ID.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMiddleUserProfileDao().deleteByUriKey(ProfileLabel.HOME_GPS_FENCE_LIST.toString());
        return new TaskResult(0, null, null, null, 14, null);
    }
}
