package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003Ji\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u00061"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveSubscriptionTaskDto;", "Landroid/os/Parcelable;", "taskId", "", "taskDescription", "taskState", "sourceTaskId", "subscriptionId", "triggerCondition", "origin", "created", "", "updated", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getTaskId", "()Ljava/lang/String;", "getTaskDescription", "getTaskState", "getSourceTaskId", "getSubscriptionId", "getTriggerCondition", "getOrigin", "getCreated", "()J", "getUpdated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveSubscriptionTaskDto implements Parcelable {
    public static final Parcelable.Creator<ProactiveSubscriptionTaskDto> CREATOR = null;
    private final long created;
    private final String origin;
    private final String sourceTaskId;
    private final String subscriptionId;
    private final String taskDescription;
    private final String taskId;
    private final String taskState;
    private final String triggerCondition;
    private final long updated;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveSubscriptionTaskDto> {
        public a() {
        }

        public final ProactiveSubscriptionTaskDto a(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            return new ProactiveSubscriptionTaskDto(r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readLong(), r13.readLong());
        }

        public final ProactiveSubscriptionTaskDto[] a(int r1) {
            return new ProactiveSubscriptionTaskDto[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveSubscriptionTaskDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveSubscriptionTaskDto[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ProactiveSubscriptionTaskDto(String r2, String r3, String r4, String r5, String r6, String r7, String r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskDescription");
        Intrinsics.checkNotNullParameter(r4, "taskState");
        Intrinsics.checkNotNullParameter(r8, "origin");
        this.taskId = r2;
        this.taskDescription = r3;
        this.taskState = r4;
        this.sourceTaskId = r5;
        this.subscriptionId = r6;
        this.triggerCondition = r7;
        this.origin = r8;
        this.created = r9;
        this.updated = r11;
    }

    public static /* synthetic */ ProactiveSubscriptionTaskDto copy$default(ProactiveSubscriptionTaskDto r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, long r21, long r23, int r25, Object r26) {
        if ((r25 & 1) == 0) goto L5;
        String r2 = r13.taskId;
    L7:
        if ((r25 & 2) == 0) goto L9;
        String r3 = r13.taskDescription;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r4 = r13.taskState;
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r5 = r13.sourceTaskId;
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r6 = r13.subscriptionId;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r7 = r13.triggerCondition;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r8 = r13.origin;
    L31:
        if ((r25 & 128) == 0) goto L33;
        long r9 = r13.created;
    L35:
        if ((r25 & 256) == 0) goto L37;
        long r11 = r13.updated;
    L39:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r11);
    L37:
        r11 = r23;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.taskDescription;
    }

    public final String component3() {
        return this.taskState;
    }

    public final String component4() {
        return this.sourceTaskId;
    }

    public final String component5() {
        return this.subscriptionId;
    }

    public final String component6() {
        return this.triggerCondition;
    }

    public final String component7() {
        return this.origin;
    }

    public final long component8() {
        return this.created;
    }

    public final long component9() {
        return this.updated;
    }

    public final ProactiveSubscriptionTaskDto copy(String r14, String r15, String r16, String r17, String r18, String r19, String r20, long r21, long r23) {
        Intrinsics.checkNotNullParameter(r14, "taskId");
        Intrinsics.checkNotNullParameter(r15, "taskDescription");
        Intrinsics.checkNotNullParameter(r16, "taskState");
        Intrinsics.checkNotNullParameter(r20, "origin");
        return new ProactiveSubscriptionTaskDto(r14, r15, r16, r17, r18, r19, r20, r21, r23);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveSubscriptionTaskDto.class) == true) goto L8;
        return false;
    L8:
        ProactiveSubscriptionTaskDto r10 = (ProactiveSubscriptionTaskDto) ZeusTransformUtils.preCheckCast(r9, ProactiveSubscriptionTaskDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.taskId, r10.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskDescription, r10.taskDescription) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskState, r10.taskState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceTaskId, r10.sourceTaskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subscriptionId, r10.subscriptionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.triggerCondition, r10.triggerCondition) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.origin, r10.origin) == true) goto L30;
        return false;
    L30:
        if (this.created == r10.created) goto L33;
        return false;
    L33:
        if (this.updated == r10.updated) goto L35;
        return false;
    L35:
        return true;
    }

    public final long getCreated() {
        return this.created;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getSourceTaskId() {
        return this.sourceTaskId;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getTaskDescription() {
        return this.taskDescription;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskState() {
        return this.taskState;
    }

    public final String getTriggerCondition() {
        return this.triggerCondition;
    }

    public final long getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        int r0 = ((((this.taskId.hashCode() * 31) + this.taskDescription.hashCode()) * 31) + this.taskState.hashCode()) * 31;
        String r1 = this.sourceTaskId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.subscriptionId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.triggerCondition;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((r7 + r2) * 31) + this.origin.hashCode()) * 31) + Long.hashCode(this.created)) * 31) + Long.hashCode(this.updated);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ProactiveSubscriptionTaskDto(taskId=" + this.taskId + ", taskDescription=" + this.taskDescription + ", taskState=" + this.taskState + ", sourceTaskId=" + this.sourceTaskId + ", subscriptionId=" + this.subscriptionId + ", triggerCondition=" + this.triggerCondition + ", origin=" + this.origin + ", created=" + this.created + ", updated=" + this.updated + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.taskId);
        r3.writeString(this.taskDescription);
        r3.writeString(this.taskState);
        r3.writeString(this.sourceTaskId);
        r3.writeString(this.subscriptionId);
        r3.writeString(this.triggerCondition);
        r3.writeString(this.origin);
        r3.writeLong(this.created);
        r3.writeLong(this.updated);
    }
}
