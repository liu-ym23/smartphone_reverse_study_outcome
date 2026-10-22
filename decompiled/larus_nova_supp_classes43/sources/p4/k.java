package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CreateRemoteTaskRequest;", "", "appKey", "", "outTaskId", "taskTemplate", "taskDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "getOutTaskId", "getTaskTemplate", "getTaskDetail", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("out_task_id")
    private final String outTaskId;

    @SerializedName("task_detail")
    private final String taskDetail;

    @SerializedName("task_template")
    private final String taskTemplate;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k) == true) goto L8;
        return false;
    L8:
        k r11 = (k) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.outTaskId, r11.outTaskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskTemplate, r11.taskTemplate) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskDetail, r11.taskDetail) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.appKey.hashCode() * 31) + this.outTaskId.hashCode()) * 31) + this.taskTemplate.hashCode()) * 31) + this.taskDetail.hashCode();
    }

    public final String toString() {
        return "CreateRemoteTaskRequest(appKey=" + this.appKey + ", outTaskId=" + this.outTaskId + ", taskTemplate=" + this.taskTemplate + ", taskDetail=" + this.taskDetail + ')';
    }

    public k(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        Intrinsics.checkNotNullParameter(r11, "outTaskId");
        Intrinsics.checkNotNullParameter(r12, "taskTemplate");
        Intrinsics.checkNotNullParameter(r13, "taskDetail");
        this.appKey = r10;
        this.outTaskId = r11;
        this.taskTemplate = r12;
        this.taskDetail = r13;
    }
}
