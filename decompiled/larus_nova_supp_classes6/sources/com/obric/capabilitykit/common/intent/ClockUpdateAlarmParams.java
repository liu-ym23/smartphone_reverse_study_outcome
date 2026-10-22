package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#Jh\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u00020\nHÖ\u0001J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000109H\u0016J\t\u0010=\u001a\u00020\u0006HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\nHÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "time", "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "repeatType", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getRepeatType$annotations", "()V", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ClockUpdateAlarmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockUpdateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    Integer repeatType;
    private AlarmEntity target;
    private String time;

    static {
        CREATOR = new a();
    }

    public ClockUpdateAlarmParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ClockUpdateAlarmParams copy$default(ClockUpdateAlarmParams r5, AlarmEntity r6, String r7, String r8, Integer[] r9, Boolean r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.target;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.time;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.date;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.repeatDayOfWeek;
    L14:
        Integer[] r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.closeInHoliday;
    L17:
        Boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.name;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.repeatType;
    L23:
        AlarmEntity r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public static /* synthetic */ void getRepeatType$annotations() {
    }

    public final AlarmEntity component1() {
        return this.target;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.date;
    }

    public final Integer[] component4() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component5() {
        return this.closeInHoliday;
    }

    public final String component6() {
        return this.name;
    }

    public final Integer component7() {
        return this.repeatType;
    }

    public final ClockUpdateAlarmParams copy(AlarmEntity r10, String r11, String r12, Integer[] r13, Boolean r14, String r15, Integer r16) {
        return new ClockUpdateAlarmParams(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClockUpdateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockUpdateAlarmParams r6 = (ClockUpdateAlarmParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.repeatDayOfWeek, r6.repeatDayOfWeek) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.closeInHoliday, r6.closeInHoliday) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.repeatType, r6.repeatType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        AlarmEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.time;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.date;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer[] r10 = this.repeatDayOfWeek;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.closeInHoliday;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.name;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.repeatType;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = Arrays.hashCode(r10);
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ClockUpdateAlarmParams(target=" + this.target + ", time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ", repeatType=" + this.repeatType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(1);
        Intrinsics.checkNotNullParameter(r6, "out");
        r6.writeParcelable(this.target, r7);
        r6.writeString(this.time);
        r6.writeString(this.date);
        Integer[] r8 = this.repeatDayOfWeek;
        if (r8 != null) goto L5;
        r6.writeInt(0);
    L8:
        Boolean r9 = this.closeInHoliday;
        if (r9 != null) goto L11;
        r6.writeInt(0);
    L12:
        r6.writeString(this.name);
        r6.writeValue(this.repeatType);
        return;
    L11:
        r6.writeInt(1);
        r6.writeInt(r9.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r6.writeInt(1);
        int r2 = r8.length;
        r6.writeInt(r2);
        int r3 = 0;
    L6:
        if (r3 == r2) goto L8;
        r6.writeInt(r8[r3].intValue());
        r3 = r3 + 1;
        goto L6
    }

    public final Boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer[] getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final Integer getRepeatType() {
        return this.repeatType;
    }

    public final AlarmEntity getTarget() {
        return this.target;
    }

    public final String getTime() {
        return this.time;
    }

    public IntentParams mergeParams(Object r10) {
        if ((r10 instanceof ClockUpdateAlarmParams) == true) goto L5;
        return this;
    L5:
        AlarmEntity r0 = this.target;
        if (r0 != null) goto L8;
        r0 = ((ClockUpdateAlarmParams) r10).target;
    L8:
        AlarmEntity r2 = r0;
        String r1 = this.time;
        if (r1 != null) goto L11;
        r1 = ((ClockUpdateAlarmParams) r10).time;
    L11:
        String r3 = r1;
        String r4 = this.date;
        if (r4 != null) goto L14;
        r4 = ((ClockUpdateAlarmParams) r10).date;
    L14:
        String r5 = r4;
        Integer[] r6 = this.repeatDayOfWeek;
        if (r6 != null) goto L17;
        r6 = ((ClockUpdateAlarmParams) r10).repeatDayOfWeek;
    L17:
        Integer[] r7 = r6;
        Boolean r8 = this.closeInHoliday;
        if (r8 != null) goto L20;
        r8 = ((ClockUpdateAlarmParams) r10).closeInHoliday;
    L20:
        Boolean r9 = r8;
        String r11 = this.name;
        if (r11 != null) goto L23;
        r11 = ((ClockUpdateAlarmParams) r10).name;
    L23:
        String r12 = r11;
        Integer r13 = this.repeatType;
        if (r13 != null) goto L26;
        Integer r14 = ((ClockUpdateAlarmParams) r10).repeatType;
    L28:
        return new ClockUpdateAlarmParams(r2, r3, r5, r7, r9, r12, r14);
    L26:
        r14 = r13;
        goto L28
    }

    public final void setCloseInHoliday(Boolean r1) {
        this.closeInHoliday = r1;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setRepeatDayOfWeek(Integer[] r1) {
        this.repeatDayOfWeek = r1;
    }

    public final void setRepeatType(Integer r1) {
        this.repeatType = r1;
    }

    public final void setTarget(AlarmEntity r1) {
        this.target = r1;
    }

    public final void setTime(String r1) {
        this.time = r1;
    }

    public ClockUpdateAlarmParams(AlarmEntity r1, String r2, String r3, Integer[] r4, Boolean r5, String r6, Integer r7) {
        this.target = r1;
        this.time = r2;
        this.date = r3;
        this.repeatDayOfWeek = r4;
        this.closeInHoliday = r5;
        this.name = r6;
        this.repeatType = r7;
    }

    public /* synthetic */ ClockUpdateAlarmParams(AlarmEntity r7, String r8, String r9, Integer[] r10, Boolean r11, String r12, Integer r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        AlarmEntity r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Integer[] r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Boolean r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        Integer r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
