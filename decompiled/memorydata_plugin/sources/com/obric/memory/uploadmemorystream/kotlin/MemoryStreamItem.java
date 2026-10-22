package com.obric.memory.uploadmemorystream.kotlin;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u00069"}, d2 = {"Lcom/obric/memory/uploadmemorystream/kotlin/MemoryStreamItem;", "Ljava/io/Serializable;", OaidModel.KEY_ID, "", "createTime", "timestamp", "dataId", "eventContent", "", "importance", "type", AILabCheckPermissionTask.KEY_SOURCE, "groupId", TypedValues.AttributesType.S_TARGET, "(JJJJLjava/lang/String;JJLjava/lang/String;JLjava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getDataId", "setDataId", "getEventContent", "()Ljava/lang/String;", "setEventContent", "(Ljava/lang/String;)V", "getGroupId", "setGroupId", "getId", "setId", "getImportance", "setImportance", "getSource", "setSource", "getTarget", "setTarget", "getTimestamp", "setTimestamp", "getType", "setType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class MemoryStreamItem implements Serializable {

    @SerializedName("create_time")
    private long createTime;

    @SerializedName("data_id")
    private long dataId;

    @SerializedName("event_content")
    private String eventContent;

    @SerializedName("group_id")
    private long groupId;

    @SerializedName(OaidModel.KEY_ID)
    private long id;

    @SerializedName("importance")
    private long importance;

    @SerializedName(AILabCheckPermissionTask.KEY_SOURCE)
    private String source;

    @SerializedName(TypedValues.AttributesType.S_TARGET)
    private String target;

    @SerializedName("timestamp")
    private long timestamp;

    @SerializedName("type")
    private long type;

    public MemoryStreamItem(long r7, long r9, long r11, long r13, String r15, long r16, long r18, String r20, long r21, String r23) {
        Intrinsics.checkParameterIsNotNull(r15, "eventContent");
        Intrinsics.checkParameterIsNotNull(r20, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r23, TypedValues.AttributesType.S_TARGET);
        this.id = r7;
        this.createTime = r9;
        this.timestamp = r11;
        this.dataId = r13;
        this.eventContent = r15;
        this.importance = r16;
        this.type = r18;
        this.source = r20;
        this.groupId = r21;
        this.target = r23;
    }

    public static /* synthetic */ MemoryStreamItem copy$default(MemoryStreamItem r16, long r17, long r19, long r21, long r23, String r25, long r26, long r28, String r30, long r31, String r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r34 & 2) == 0) goto L9;
        long r4 = r16.createTime;
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r6 = r16.timestamp;
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r8 = r16.dataId;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r10 = r16.eventContent;
    L23:
        if ((r34 & 32) == 0) goto L25;
        long r11 = r16.importance;
    L27:
        if ((r34 & 64) == 0) goto L29;
        long r13 = r16.type;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r15 = r16.source;
    L34:
        String r32 = r15;
        long r29 = r13;
        if ((r34 & 256) == 0) goto L37;
        long r14 = r16.groupId;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r1 = r16.target;
    L43:
        return r16.copy(r2, r4, r6, r8, r10, r11, r29, r32, r14, r1);
    L41:
        r1 = r33;
        goto L43
    L37:
        r14 = r31;
        goto L39
    L33:
        r15 = r30;
        goto L34
    L29:
        r13 = r28;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.target;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final long component4() {
        return this.dataId;
    }

    public final String component5() {
        return this.eventContent;
    }

    public final long component6() {
        return this.importance;
    }

    public final long component7() {
        return this.type;
    }

    public final String component8() {
        return this.source;
    }

    public final long component9() {
        return this.groupId;
    }

    public final MemoryStreamItem copy(long r20, long r22, long r24, long r26, String r28, long r29, long r31, String r33, long r34, String r36) {
        Intrinsics.checkParameterIsNotNull(r28, "eventContent");
        Intrinsics.checkParameterIsNotNull(r33, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r36, TypedValues.AttributesType.S_TARGET);
        return new MemoryStreamItem(r20, r22, r24, r26, r28, r29, r31, r33, r34, r36);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, MemoryStreamItem.class) == false) goto L27;
        MemoryStreamItem r6 = (MemoryStreamItem) ZeusTransformUtils.preCheckCast(r5, MemoryStreamItem.class, "com.obric.memorydata.plugin");
        if (this.id == r6.id) goto L9;
        return false;
    L9:
        if (this.createTime == r6.createTime) goto L11;
        return false;
    L11:
        if (this.timestamp == r6.timestamp) goto L13;
        return false;
    L13:
        if (this.dataId == r6.dataId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.eventContent, r6.eventContent) == true) goto L17;
        return false;
    L17:
        if (this.importance == r6.importance) goto L19;
        return false;
    L19:
        if (this.type == r6.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L23;
        return false;
    L23:
        if (this.groupId == r6.groupId) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L41;
        return false;
    L41:
        return true;
    L27:
        return false;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getDataId() {
        return this.dataId;
    }

    public final String getEventContent() {
        return this.eventContent;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final long getId() {
        return this.id;
    }

    public final long getImportance() {
        return this.importance;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTarget() {
        return this.target;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.timestamp)) * 31) + Long.hashCode(this.dataId)) * 31;
        String r1 = this.eventContent;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((((r0 + r3) * 31) + Long.hashCode(this.importance)) * 31) + Long.hashCode(this.type)) * 31;
        String r5 = this.source;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + Long.hashCode(this.groupId)) * 31;
        String r8 = this.target;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final void setDataId(long r1) {
        this.dataId = r1;
    }

    public final void setEventContent(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.eventContent = r2;
    }

    public final void setGroupId(long r1) {
        this.groupId = r1;
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public final void setImportance(long r1) {
        this.importance = r1;
    }

    public final void setSource(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.source = r2;
    }

    public final void setTarget(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.target = r2;
    }

    public final void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public final void setType(long r1) {
        this.type = r1;
    }

    public String toString() {
        return "MemoryStreamItem(id=" + this.id + ", createTime=" + this.createTime + ", timestamp=" + this.timestamp + ", dataId=" + this.dataId + ", eventContent=" + this.eventContent + ", importance=" + this.importance + ", type=" + this.type + ", source=" + this.source + ", groupId=" + this.groupId + ", target=" + this.target + ")";
    }
}
