package zja;

import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.TaskKnowledge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lzja/b;", "", "", "taskType", "I", "getTaskType", "()I", "", "taskId", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "instruct", "getInstruct", "setInstruct", "shortInstruct", "getShortInstruct", "setShortInstruct", "taskMode", "Ljava/lang/Integer;", "getTaskMode", "()Ljava/lang/Integer;", "setTaskMode", "(Ljava/lang/Integer;)V", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "setTaskKnowledge", "(Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;)V", "src", "getSrc", "setSrc", "", "isTryRun", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setTryRun", "(Ljava/lang/Boolean;)V", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    @SerializedName("ext")
    private Map<String, String> ext;

    @SerializedName("instruct")
    private String instruct;

    @SerializedName("isTryRun")
    private Boolean isTryRun;

    @SerializedName("shortInstruct")
    private String shortInstruct;

    @SerializedName("src")
    private Integer src;

    @SerializedName("taskId")
    private String taskId;

    @SerializedName("taskKnowledge")
    private TaskKnowledge taskKnowledge;

    @SerializedName("taskMode")
    private Integer taskMode;

    @SerializedName("taskType")
    private final int taskType;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.taskType == r6.taskType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.instruct, r6.instruct) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shortInstruct, r6.shortInstruct) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskMode, r6.taskMode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskKnowledge, r6.taskKnowledge) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.src, r6.src) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isTryRun, r6.isTryRun) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.taskType * 31;
        String r1 = this.taskId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.instruct;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.shortInstruct;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.taskMode;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        TaskKnowledge r14 = this.taskKnowledge;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.src;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.isTryRun;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Map<String, String> r23 = this.ext;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "EventTaskInfo(taskType=" + this.taskType + ", taskId=" + this.taskId + ", instruct=" + this.instruct + ", shortInstruct=" + this.shortInstruct + ", taskMode=" + this.taskMode + ", taskKnowledge=" + this.taskKnowledge + ", src=" + this.src + ", isTryRun=" + this.isTryRun + ", ext=" + this.ext + ')';
    }
}
