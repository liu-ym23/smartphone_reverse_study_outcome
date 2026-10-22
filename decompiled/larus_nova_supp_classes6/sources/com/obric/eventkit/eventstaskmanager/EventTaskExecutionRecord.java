package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0081\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00066"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "Landroid/os/Parcelable;", "id", "", "taskType", "", "taskMode", "taskId", "", "query", "triggerTime", "duration", "resultCode", "resultMessage", "ext", "", "(JIILjava/lang/String;Ljava/lang/String;JJILjava/lang/String;Ljava/util/Map;)V", "getDuration", "()J", "getExt", "()Ljava/util/Map;", "getId", "getQuery", "()Ljava/lang/String;", "getResultCode", "()I", "getResultMessage", "getTaskId", "getTaskMode", "getTaskType", "getTriggerTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EventTaskExecutionRecord implements Parcelable {
    public static final Parcelable.Creator<EventTaskExecutionRecord> CREATOR = null;
    private final long duration;
    private final Map<String, String> ext;
    private final long id;
    private final String query;
    private final int resultCode;
    private final String resultMessage;
    private final String taskId;
    private final int taskMode;
    private final int taskType;
    private final long triggerTime;

    static {
        CREATOR = new a();
    }

    public EventTaskExecutionRecord(long r1, int r3, int r4, String r5, String r6, long r7, long r9, int r11, String r12, Map<String, String> r13) {
        this.id = r1;
        this.taskType = r3;
        this.taskMode = r4;
        this.taskId = r5;
        this.query = r6;
        this.triggerTime = r7;
        this.duration = r9;
        this.resultCode = r11;
        this.resultMessage = r12;
        this.ext = r13;
    }

    public /* synthetic */ EventTaskExecutionRecord(long r17, int r19, int r20, String r21, String r22, long r23, long r25, int r27, String r28, Map r29, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 1) == 0) goto L5;
        long r3 = 0;
    L6:
        this(r3, r19, r20, r21, r22, r23, r25, r27, r28, r29);
        return;
    L5:
        r3 = r17;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTaskExecutionRecord copy$default(EventTaskExecutionRecord r14, long r15, int r17, int r18, String r19, String r20, long r21, long r23, int r25, String r26, Map r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        long r2 = r14.id;
    L7:
        if ((r28 & 2) == 0) goto L9;
        int r4 = r14.taskType;
    L11:
        if ((r28 & 4) == 0) goto L13;
        int r5 = r14.taskMode;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r6 = r14.taskId;
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r7 = r14.query;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r8 = r14.triggerTime;
    L27:
        if ((r28 & 64) == 0) goto L29;
        long r10 = r14.duration;
    L31:
        if ((r28 & 128) == 0) goto L33;
        int r12 = r14.resultCode;
    L35:
        if ((r28 & ISmModel.VERSION_0100) == 0) goto L37;
        String r13 = r14.resultMessage;
    L39:
        if ((r28 & ISmModel.VERSION_0200) == 0) goto L41;
        Map r1 = r14.ext;
    L43:
        return r14.copy(r2, r4, r5, r6, r7, r8, r10, r12, r13, r1);
    L41:
        r1 = r27;
        goto L43
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = r25;
        goto L35
    L29:
        r10 = r23;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final int component2() {
        return this.taskType;
    }

    public final int component3() {
        return this.taskMode;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.query;
    }

    public final long component6() {
        return this.triggerTime;
    }

    public final long component7() {
        return this.duration;
    }

    public final int component8() {
        return this.resultCode;
    }

    public final String component9() {
        return this.resultMessage;
    }

    public final EventTaskExecutionRecord copy(long r16, int r18, int r19, String r20, String r21, long r22, long r24, int r26, String r27, Map<String, String> r28) {
        return new EventTaskExecutionRecord(r16, r18, r19, r20, r21, r22, r24, r26, r27, r28);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof EventTaskExecutionRecord) == true) goto L8;
        return false;
    L8:
        EventTaskExecutionRecord r9 = (EventTaskExecutionRecord) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (this.taskType == r9.taskType) goto L15;
        return false;
    L15:
        if (this.taskMode == r9.taskMode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.query, r9.query) == true) goto L24;
        return false;
    L24:
        if (this.triggerTime == r9.triggerTime) goto L27;
        return false;
    L27:
        if (this.duration == r9.duration) goto L30;
        return false;
    L30:
        if (this.resultCode == r9.resultCode) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.resultMessage, r9.resultMessage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.id;
    }

    public final String getQuery() {
        return this.query;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getResultMessage() {
        return this.resultMessage;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.taskType) * 31) + this.taskMode) * 31;
        String r2 = this.taskId;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.query;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        long r8 = this.triggerTime;
        int r9 = (((r5 + r7) * 31) + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.duration;
        int r11 = (((r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.resultCode) * 31;
        String r12 = this.resultMessage;
        if (r12 != null) goto L13;
        int r13 = 0;
    L14:
        int r14 = (r11 + r13) * 31;
        Map<String, String> r15 = this.ext;
        if (r15 == null) goto L19;
        r3 = r15.hashCode();
    L19:
        return r14 + r3;
    L13:
        r13 = r12.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "EventTaskExecutionRecord(id=" + this.id + ", taskType=" + this.taskType + ", taskMode=" + this.taskMode + ", taskId=" + this.taskId + ", query=" + this.query + ", triggerTime=" + this.triggerTime + ", duration=" + this.duration + ", resultCode=" + this.resultCode + ", resultMessage=" + this.resultMessage + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeLong(this.id);
        r3.writeInt(this.taskType);
        r3.writeInt(this.taskMode);
        r3.writeString(this.taskId);
        r3.writeString(this.query);
        r3.writeLong(this.triggerTime);
        r3.writeLong(this.duration);
        r3.writeInt(this.resultCode);
        r3.writeString(this.resultMessage);
        Map<String, String> r0 = this.ext;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<Map.Entry<String, String>> r5 = r0.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Map.Entry<String, String> r1 = r5.next();
        r3.writeString(r1.getKey());
        r3.writeString(r1.getValue());
        goto L7
    }
}
