package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0081\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00066"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/EventTaskExecutionRecord;", "Landroid/os/Parcelable;", OaidModel.KEY_ID, "", "taskType", "", "taskMode", "taskId", "", ChatMessage.TYPE_QUERY, "triggerTime", "duration", "resultCode", "resultMessage", "ext", "", "(JIILjava/lang/String;Ljava/lang/String;JJILjava/lang/String;Ljava/util/Map;)V", "getDuration", "()J", "getExt", "()Ljava/util/Map;", "getId", "getQuery", "()Ljava/lang/String;", "getResultCode", "()I", "getResultMessage", "getTaskId", "getTaskMode", "getTaskType", "getTriggerTime", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<EventTaskExecutionRecord> {
        public a() {
        }

        public final EventTaskExecutionRecord a(Parcel r19) {
            int r1 = r19.readInt();
            Intrinsics.checkNotNullParameter(r19, "parcel");
            long r4 = r19.readLong();
            int r6 = r19.readInt();
            int r7 = r19.readInt();
            String r8 = r19.readString();
            String r9 = r19.readString();
            long r10 = r19.readLong();
            long r12 = r19.readLong();
            int r14 = r19.readInt();
            String r15 = r19.readString();
            if (r19.readInt() != 0) goto L5;
            int r17 = r1;
            LinkedHashMap r16 = null;
        L9:
            EventTaskExecutionRecord r0 = new EventTaskExecutionRecord(r4, r6, r7, r8, r9, r10, r12, r14, r15, r16);
            int r2 = r17;
            int r3 = Math.min(r2, 0);
            ClassLoader r5 = a.class.getClassLoader();
            int r11 = 1;
        L10:
            if (r11 > r3) goto L12;
            r11 = r11 + 1;
        L12:
            if (r11 > r2) goto L14;
            com.obric.b.a.a(r19, r5);
            r11 = r11 + 1;
            goto L12
        L14:
            return r0;
        L5:
            int r13 = r19.readInt();
            LinkedHashMap r18 = new LinkedHashMap(r13);
            int r20 = 0;
        L6:
            if (r20 == r13) goto L8;
            r18.put(r19.readString(), r19.readString());
            r20 = r20 + 1;
            r13 = r13;
            r1 = r1;
            goto L6
        L8:
            r17 = r1;
            r16 = r18;
            goto L9
        }

        public final EventTaskExecutionRecord[] a(int r1) {
            return new EventTaskExecutionRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTaskExecutionRecord createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EventTaskExecutionRecord[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public EventTaskExecutionRecord(long r3, int r5, int r6, String r7, String r8, long r9, long r11, int r13, String r14, Map<String, String> r15) {
        Map<String, String> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        this.id = r3;
        this.taskType = r5;
        this.taskMode = r6;
        this.taskId = r7;
        this.query = r8;
        this.triggerTime = r9;
        this.duration = r11;
        this.resultCode = r13;
        this.resultMessage = r14;
        this.ext = r16;
    }

    public /* synthetic */ EventTaskExecutionRecord(long r16, int r18, int r19, String r20, String r21, long r22, long r24, int r26, String r27, Map r28, int r29, DefaultConstructorMarker r30) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        if ((r29 & 1) == 0) goto L5;
        long r2 = 0;
    L6:
        this(r2, r18, r19, r20, r21, r22, r24, r26, r27, r14);
        return;
    L5:
        r2 = r16;
        goto L6
    }

    public static /* synthetic */ EventTaskExecutionRecord copy$default(EventTaskExecutionRecord r15, long r16, int r18, int r19, String r20, String r21, long r22, long r24, int r26, String r27, Map r28, int r29, Object r30) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        if ((r29 & 1) == 0) goto L5;
        long r3 = r15.id;
    L7:
        if ((r29 & 2) == 0) goto L9;
        int r5 = r15.taskType;
    L11:
        if ((r29 & 4) == 0) goto L13;
        int r6 = r15.taskMode;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r7 = r15.taskId;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r8 = r15.query;
    L23:
        if ((r29 & 32) == 0) goto L25;
        long r9 = r15.triggerTime;
    L27:
        if ((r29 & 64) == 0) goto L29;
        long r11 = r15.duration;
    L31:
        if ((r29 & 128) == 0) goto L33;
        int r13 = r15.resultCode;
    L35:
        if ((r29 & 256) == 0) goto L37;
        String r14 = r15.resultMessage;
    L39:
        if ((r29 & 512) == 0) goto L41;
        Map<String, String> r1 = r15.ext;
    L43:
        return r15.copy(r3, r5, r6, r7, r8, r9, r11, r13, r14, r1);
    L41:
        r1 = r2;
        goto L43
    L37:
        r14 = r27;
        goto L39
    L33:
        r13 = r26;
        goto L35
    L29:
        r11 = r24;
        goto L31
    L25:
        r9 = r22;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r3 = r16;
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
        return new EventTaskExecutionRecord(r16, r18, r19, r20, r21, r22, r24, r26, r27, (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EventTaskExecutionRecord.class) == true) goto L8;
        return false;
    L8:
        EventTaskExecutionRecord r10 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r9, EventTaskExecutionRecord.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.taskType == r10.taskType) goto L15;
        return false;
    L15:
        if (this.taskMode == r10.taskMode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r10.taskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.query, r10.query) == true) goto L24;
        return false;
    L24:
        if (this.triggerTime == r10.triggerTime) goto L27;
        return false;
    L27:
        if (this.duration == r10.duration) goto L30;
        return false;
    L30:
        if (this.resultCode == r10.resultCode) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.resultMessage, r10.resultMessage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ext, r10.ext) == true) goto L38;
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
        int r0 = ((((Long.hashCode(this.id) * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.taskMode)) * 31;
        String r1 = this.taskId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.query;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + Long.hashCode(this.triggerTime)) * 31) + Long.hashCode(this.duration)) * 31) + Integer.hashCode(this.resultCode)) * 31;
        String r8 = this.resultMessage;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.ext;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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

    public String toString() {
        return "EventTaskExecutionRecord(id=" + this.id + ", taskType=" + this.taskType + ", taskMode=" + this.taskMode + ", taskId=" + this.taskId + ", query=" + this.query + ", triggerTime=" + this.triggerTime + ", duration=" + this.duration + ", resultCode=" + this.resultCode + ", resultMessage=" + this.resultMessage + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeLong(this.id);
        r4.writeInt(this.taskType);
        r4.writeInt(this.taskMode);
        r4.writeString(this.taskId);
        r4.writeString(this.query);
        r4.writeLong(this.triggerTime);
        r4.writeLong(this.duration);
        r4.writeInt(this.resultCode);
        r4.writeString(this.resultMessage);
        Map<String, String> r3 = this.ext;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r3.size());
        Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeString((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin"));
        r4.writeString((String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    }
}
