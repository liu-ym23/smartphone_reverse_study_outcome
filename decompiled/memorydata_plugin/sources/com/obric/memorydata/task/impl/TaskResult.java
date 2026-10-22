package com.obric.memorydata.task.impl;

import androidx.core.app.NotificationCompat;
import com.obric.memorydata.task.AbsTaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001d\u001a\u00020\u0005H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/obric/memorydata/task/impl/TaskResult;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "output", "Lorg/json/JSONObject;", "nextTaskRequestList", "", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(ILjava/lang/String;Lorg/json/JSONObject;Ljava/util/List;)V", "getCode", "()I", "setCode", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getOutput", "()Lorg/json/JSONObject;", "setOutput", "(Lorg/json/JSONObject;)V", "getNextTaskRequestList", "()Ljava/util/List;", "setNextTaskRequestList", "(Ljava/util/List;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskResult {
    public static final int CANCELLED = 2;
    public static final Companion Companion = null;
    public static final int EXCEPTION = 90001;
    public static final int FAIL = 1;
    public static final int MODEL_NOT_READY = 1005;
    public static final int PACKAGE_NOT_READY = 1004;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 3;
    public static final int UNKNOWN = -1;
    private int code;
    private String msg;
    private List<? extends AbsTaskRequest> nextTaskRequestList;
    private JSONObject output;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskResult$Companion;", "", "<init>", "()V", "UNKNOWN", "", "SUCCESS", "FAIL", "CANCELLED", "TIMEOUT", "PACKAGE_NOT_READY", "MODEL_NOT_READY", "EXCEPTION", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public TaskResult(int r3, String r4, JSONObject r5, List<? extends AbsTaskRequest> r6) {
        List<? extends AbsTaskRequest> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r5, "output");
        Intrinsics.checkNotNullParameter(r7, "nextTaskRequestList");
        this.code = r3;
        this.msg = r4;
        this.output = r5;
        this.nextTaskRequestList = r7;
    }

    public /* synthetic */ TaskResult(int r2, String r3, JSONObject r4, List r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = new JSONObject();
    L9:
        if ((r6 & 8) == 0) goto L11;
        r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L11:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ TaskResult copy$default(TaskResult r1, int r2, String r3, JSONObject r4, List r5, int r6, Object r7) {
        List<? extends AbsTaskRequest> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.code;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.msg;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.output;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.nextTaskRequestList;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final JSONObject component3() {
        return this.output;
    }

    public final List<AbsTaskRequest> component4() {
        return this.nextTaskRequestList;
    }

    public final TaskResult copy(int r2, String r3, JSONObject r4, List<? extends AbsTaskRequest> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "output");
        Intrinsics.checkNotNullParameter(r1, "nextTaskRequestList");
        return new TaskResult(r2, r3, r4, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskResult.class) == true) goto L8;
        return false;
    L8:
        TaskResult r6 = (TaskResult) ZeusTransformUtils.preCheckCast(r5, TaskResult.class, "com.obric.memorydata.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.output, r6.output) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nextTaskRequestList, r6.nextTaskRequestList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final List<AbsTaskRequest> getNextTaskRequestList() {
        return this.nextTaskRequestList;
    }

    public final JSONObject getOutput() {
        return this.output;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31) + this.output.hashCode()) * 31) + this.nextTaskRequestList.hashCode();
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.msg = r2;
    }

    public final void setNextTaskRequestList(List<? extends AbsTaskRequest> r3) {
        List<? extends AbsTaskRequest> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.nextTaskRequestList = r4;
    }

    public final void setOutput(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.output = r2;
    }

    public String toString() {
        return "TaskResult:{ code: " + this.code + " msg: " + this.msg + " output " + this.output + " nextTaskSize: " + this.nextTaskRequestList.size() + " }";
    }
}
