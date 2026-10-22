package com.bytedance.ai.bridge.doubao.task;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/task/AbsCreateTaskMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/doubao/task/AbsCreateTaskMethodIDL$CreateTaskRequestModel;", "Lcom/bytedance/ai/bridge/doubao/task/AbsCreateTaskMethodIDL$CreateTaskResponseModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "CreateTaskRequestModel", "CreateTaskResponseModel", "TaskType", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCreateTaskMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/task/AbsCreateTaskMethodIDL$TaskType;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL", "REMOTE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TaskType extends Enum<TaskType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TaskType[] $VALUES = null;

        @SerializedName("local")
        public static final TaskType LOCAL = null;

        @SerializedName("remote")
        public static final TaskType REMOTE = null;

        private static final /* synthetic */ TaskType[] $values() {
            return new TaskType[]{LOCAL, REMOTE};
        }

        public static EnumEntries<TaskType> getEntries() {
            return $ENTRIES;
        }

        static {
            LOCAL = new TaskType("LOCAL", 0);
            REMOTE = new TaskType("REMOTE", 1);
            TaskType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static TaskType[] values() {
            return (TaskType[]) $VALUES.clone();
        }

        public static TaskType valueOf(String r1) {
            return (TaskType) r27.a.a(TaskType.class, r1);
        }

        private TaskType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "outTaskId", required = true)
        String getOutTaskId();

        @AIBridgeParamField(keyPath = "taskDetail", required = true)
        String getTaskDetail();

        @AIBridgeParamField(keyPath = "taskTemplate", required = true)
        String getTaskTemplate();

        @AIBridgeParamField(keyPath = "taskType", required = true)
        TaskType getTaskType();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "expiresIn", required = false)
        void setExpiresIn(Integer r1);

        @AIBridgeParamField(keyPath = "taskId", required = true)
        void setTaskId(String r1);

        @AIBridgeParamField(keyPath = BdpShareBaseInfo.CHANNEL_TOKEN, required = false)
        void setToken(String r1);
    }

    public AbsCreateTaskMethodIDL() {
        this.a = "doubao.createTask";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
