package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\\\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0005J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "Landroid/os/Parcelable;", "taskId", "", "taskType", "", "message", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "createdTime", "", "progress", "ext", "", "<init>", "(Ljava/lang/String;ILcom/obric/aiagent/assistant/idl/bean/IMMessage;JLjava/lang/Integer;Ljava/util/Map;)V", "getTaskId", "()Ljava/lang/String;", "getTaskType", "()I", "getMessage", "()Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "getCreatedTime", "()J", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;ILcom/obric/aiagent/assistant/idl/bean/IMMessage;JLjava/lang/Integer;Ljava/util/Map;)Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class DMTaskInfo implements Parcelable {
    public static final Parcelable.Creator<DMTaskInfo> CREATOR = null;
    private final long createdTime;
    private final Map<String, String> ext;
    private final IMMessage message;
    private final Integer progress;
    private final String taskId;
    private final int taskType;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DMTaskInfo copy$default(DMTaskInfo r5, String r6, int r7, IMMessage r8, long r9, Integer r11, Map r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.taskId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.taskType;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.message;
    L11:
        IMMessage r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.createdTime;
    L14:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.progress;
    L17:
        Integer r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.ext;
    L20:
        String r10 = r6;
        return r5.copy(r10, r15, r0, r1, r3, r12);
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.taskType;
    }

    public final IMMessage component3() {
        return this.message;
    }

    public final long component4() {
        return this.createdTime;
    }

    public final Integer component5() {
        return this.progress;
    }

    public final Map<String, String> component6() {
        return this.ext;
    }

    public final DMTaskInfo copy(String r10, int r11, IMMessage r12, long r13, Integer r15, Map<String, String> r16) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        return new DMTaskInfo(r10, r11, r12, r13, r15, r16);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DMTaskInfo) == true) goto L8;
        return false;
    L8:
        DMTaskInfo r9 = (DMTaskInfo) r8;
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L12;
        return false;
    L12:
        if (this.taskType == r9.taskType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r9.message) == true) goto L18;
        return false;
    L18:
        if (this.createdTime == r9.createdTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.progress, r9.progress) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.taskId.hashCode() * 31) + this.taskType) * 31;
        IMMessage r1 = this.message;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        long r4 = this.createdTime;
        int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        Integer r6 = this.progress;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        Map<String, String> r9 = this.ext;
        if (r9 == null) goto L15;
        r2 = r9.hashCode();
    L15:
        return r8 + r2;
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DMTaskInfo(taskId=" + this.taskId + ", taskType=" + this.taskType + ", message=" + this.message + ", createdTime=" + this.createdTime + ", progress=" + this.progress + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.taskId);
        r6.writeInt(this.taskType);
        IMMessage r0 = this.message;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        r6.writeLong(this.createdTime);
        Integer r8 = this.progress;
        if (r8 != null) goto L9;
        r6.writeInt(0);
    L10:
        Map<String, String> r9 = this.ext;
        if (r9 != null) goto L13;
        r6.writeInt(0);
        return;
    L13:
        r6.writeInt(1);
        r6.writeInt(r9.size());
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        Map.Entry<String, String> r1 = r10.next();
        r6.writeString(r1.getKey());
        r6.writeString(r1.getValue());
        goto L15
    L19:
        return;
    L9:
        r6.writeInt(1);
        r6.writeInt(r8.intValue());
        goto L10
    L5:
        r6.writeInt(1);
        r0.writeToParcel(r6, r7);
        goto L6
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final IMMessage getMessage() {
        return this.message;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public DMTaskInfo(String r2, int r3, IMMessage r4, long r5, Integer r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.taskId = r2;
        this.taskType = r3;
        this.message = r4;
        this.createdTime = r5;
        this.progress = r7;
        this.ext = r8;
    }

    public /* synthetic */ DMTaskInfo(String r11, int r12, IMMessage r13, long r14, Integer r16, Map r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 4) == 0) goto L5;
        IMMessage r5 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        Integer r8 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        Map r9 = null;
    L14:
        this(r11, r12, r5, r14, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }
}
