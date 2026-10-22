package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u00020\rHÖ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\rHÖ\u0001J\u0012\u0010:\u001a\u00020\u00012\b\u0010;\u001a\u0004\u0018\u000108H\u0016J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\rHÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R(\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010)\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006B"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSearchMeetingParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "startTime", "", "endTime", "timeType", "room", "participants", "", "agenda", "participantsId", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)V", "getAgenda", "()Ljava/lang/String;", "setAgenda", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getParticipants", "()[Ljava/lang/String;", "setParticipants", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getParticipantsId$annotations", "()V", "getParticipantsId", "setParticipantsId", "getRoom", "setRoom", "getStartTime", "setStartTime", "getTimeType", "setTimeType", "getVersion$annotations", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeSearchMeetingParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeSearchMeetingParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<OfficeSearchMeetingParams> CREATOR = null;
    private String agenda;
    private String endTime;
    private String[] participants;
    String[] participantsId;
    private String room;
    private String startTime;
    private String timeType;
    Integer version;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OfficeSearchMeetingParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchMeetingParams createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            Intrinsics.checkNotNullParameter(r14, "parcel");
            OfficeSearchMeetingParams r1 = new OfficeSearchMeetingParams(r14.readString(), r14.readString(), r14.readString(), r14.readString(), r14.createStringArray(), r14.readString(), null, null, 192, null);
            int r3 = Math.min(r0, 2);
            ClassLoader r13 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L14;
            if (r5 != 1) goto L9;
            Object r7 = a.b(r14, r13);
            if (r7 == null) goto L13;
            r1.participantsId = (String[]) ZeusTransformUtils.preCheckCast(r7, String[].class, "com.obric.memorydata.plugin");
        L13:
            r5 = r5 + 1;
            goto L3
        L9:
            if (r5 != 2) goto L13;
            Object r8 = a.b(r14, r13);
            if (r8 == null) goto L13;
            r1.version = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
        L14:
            if (r5 > r0) goto L16;
            a.a(r14, r13);
            r5 = r5 + 1;
            goto L14
        L16:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchMeetingParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchMeetingParams[] newArray(int r1) {
            return new OfficeSearchMeetingParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchMeetingParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public OfficeSearchMeetingParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public OfficeSearchMeetingParams(String r1, String r2, String r3, String r4, String[] r5, String r6, String[] r7, Integer r8) {
        this.startTime = r1;
        this.endTime = r2;
        this.timeType = r3;
        this.room = r4;
        this.participants = r5;
        this.agenda = r6;
        this.participantsId = r7;
        this.version = r8;
    }

    public /* synthetic */ OfficeSearchMeetingParams(String r2, String r3, String r4, String r5, String[] r6, String r7, String[] r8, Integer r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ OfficeSearchMeetingParams copy$default(OfficeSearchMeetingParams r9, String r10, String r11, String r12, String r13, String[] r14, String r15, String[] r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.startTime;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.endTime;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.timeType;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.room;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String[] r6 = r9.participants;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.agenda;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String[] r8 = r9.participantsId;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.version;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public static /* synthetic */ void getParticipantsId$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.startTime;
    }

    public final String component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.timeType;
    }

    public final String component4() {
        return this.room;
    }

    public final String[] component5() {
        return this.participants;
    }

    public final String component6() {
        return this.agenda;
    }

    public final String[] component7() {
        return this.participantsId;
    }

    public final Integer component8() {
        return this.version;
    }

    public final OfficeSearchMeetingParams copy(String r11, String r12, String r13, String r14, String[] r15, String r16, String[] r17, Integer r18) {
        return new OfficeSearchMeetingParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeSearchMeetingParams.class) == true) goto L8;
        return false;
    L8:
        OfficeSearchMeetingParams r6 = (OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r5, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timeType, r6.timeType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.room, r6.room) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.participants, r6.participants) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.agenda, r6.agenda) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.participantsId, r6.participantsId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String[] getParticipants() {
        return this.participants;
    }

    public final String[] getParticipantsId() {
        return this.participantsId;
    }

    public final String getRoom() {
        return this.room;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final String getTimeType() {
        return this.timeType;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        String r0 = this.startTime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.endTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.timeType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.room;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String[] r13 = this.participants;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.agenda;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String[] r19 = this.participantsId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.version;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = Arrays.hashCode(r19);
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = Arrays.hashCode(r13);
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r13) {
        if (ZeusTransformUtils.instanceOf(r13, OfficeSearchMeetingParams.class) == false) goto L5;
        String r1 = this.startTime;
        if (r1 != null) goto L9;
        r1 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).startTime;
    L9:
        String r4 = r1;
        String r2 = this.endTime;
        if (r2 != null) goto L12;
        r2 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).endTime;
    L12:
        String r5 = r2;
        String r3 = this.timeType;
        if (r3 != null) goto L15;
        r3 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).timeType;
    L15:
        String r6 = r3;
        String r7 = this.room;
        if (r7 != null) goto L18;
        r7 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).room;
    L18:
        String r8 = r7;
        String[] r9 = this.participants;
        if (r9 != null) goto L21;
        r9 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).participants;
    L21:
        String[] r10 = r9;
        String r11 = this.agenda;
        if (r11 != null) goto L24;
        r11 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).agenda;
    L24:
        String r12 = r11;
        String[] r14 = this.participantsId;
        if (r14 != null) goto L27;
        r14 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).participantsId;
    L27:
        String[] r15 = r14;
        Integer r16 = this.version;
        if (r16 != null) goto L30;
        r16 = ((OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r13, OfficeSearchMeetingParams.class, "com.obric.memorydata.plugin")).version;
    L30:
        OfficeSearchMeetingParams this = new OfficeSearchMeetingParams(r4, r5, r6, r8, r10, r12, r15, r16);
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    }

    public final void setAgenda(String r1) {
        this.agenda = r1;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final void setParticipants(String[] r1) {
        this.participants = r1;
    }

    public final void setParticipantsId(String[] r1) {
        this.participantsId = r1;
    }

    public final void setRoom(String r1) {
        this.room = r1;
    }

    public final void setStartTime(String r1) {
        this.startTime = r1;
    }

    public final void setTimeType(String r1) {
        this.timeType = r1;
    }

    public final void setVersion(Integer r1) {
        this.version = r1;
    }

    public String toString() {
        return "OfficeSearchMeetingParams(startTime=" + this.startTime + ", endTime=" + this.endTime + ", timeType=" + this.timeType + ", room=" + this.room + ", participants=" + Arrays.toString(this.participants) + ", agenda=" + this.agenda + ", participantsId=" + Arrays.toString(this.participantsId) + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
        r1.writeString(this.timeType);
        r1.writeString(this.room);
        r1.writeStringArray(this.participants);
        r1.writeString(this.agenda);
        r1.writeValue(this.participantsId);
        r1.writeValue(this.version);
    }
}
