package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\\\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u00020\bHÖ\u0001J\u0013\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\n\u00103\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u00104\u001a\u00020\bHÖ\u0001J\u0012\u00105\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u000102H\u0016J\t\u00107\u001a\u00020\u0004HÖ\u0001J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\bHÖ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010$\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u0006="}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "time", "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "repeatType", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getRepeatType$annotations", "()V", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "describeContents", "equals", "other", "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ClockCreateAlarmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockCreateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    Integer repeatType;
    private String time;

    static {
        CREATOR = new a();
    }

    public ClockCreateAlarmParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ClockCreateAlarmParams copy$default(ClockCreateAlarmParams r4, String r5, String r6, Integer[] r7, Boolean r8, String r9, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.time;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.date;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.repeatDayOfWeek;
    L11:
        Integer[] r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.closeInHoliday;
    L14:
        Boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.name;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.repeatType;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public static /* synthetic */ void getRepeatType$annotations() {
    }

    public final String component1() {
        return this.time;
    }

    public final String component2() {
        return this.date;
    }

    public final Integer[] component3() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component4() {
        return this.closeInHoliday;
    }

    public final String component5() {
        return this.name;
    }

    public final Integer component6() {
        return this.repeatType;
    }

    public final ClockCreateAlarmParams copy(String r9, String r10, Integer[] r11, Boolean r12, String r13, Integer r14) {
        return new ClockCreateAlarmParams(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClockCreateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockCreateAlarmParams r6 = (ClockCreateAlarmParams) r5;
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.repeatDayOfWeek, r6.repeatDayOfWeek) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.closeInHoliday, r6.closeInHoliday) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.repeatType, r6.repeatType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.time;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.date;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer[] r7 = this.repeatDayOfWeek;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.closeInHoliday;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.name;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.repeatType;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = Arrays.hashCode(r7);
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
        return "ClockCreateAlarmParams(time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ", repeatType=" + this.repeatType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(1);
        Intrinsics.checkNotNullParameter(r6, "out");
        r6.writeString(this.time);
        r6.writeString(this.date);
        Integer[] r0 = this.repeatDayOfWeek;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L8:
        Boolean r1 = this.closeInHoliday;
        if (r1 != null) goto L11;
        r6.writeInt(0);
    L12:
        r6.writeString(this.name);
        r6.writeValue(this.repeatType);
        return;
    L11:
        r6.writeInt(1);
        r6.writeInt(r1.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r6.writeInt(1);
        int r2 = r0.length;
        r6.writeInt(r2);
        int r3 = 0;
    L6:
        if (r3 == r2) goto L8;
        r6.writeInt(r0[r3].intValue());
        r3 = r3 + 1;
        goto L6
    }

    public String getSubActionValue() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.time;
        String r2 = null;
        if (r1 != null) goto L6;
        r1 = null;
    L6:
        r0.append(r1);
        r0.append('|');
        String r3 = this.date;
        if (r3 != null) goto L10;
        r3 = null;
    L10:
        r0.append(r3);
        r0.append('|');
        Integer[] r4 = this.repeatDayOfWeek;
        if (r4 == null) goto L13;
        r2 = ArraysKt.joinToString$default(r4, null, null, null, 0, null, null, 63, null);
    L13:
        r0.append(r2);
        return r0.toString();
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

    public final String getTime() {
        return this.time;
    }

    public IntentParams mergeParams(Object r9) {
        if ((r9 instanceof ClockCreateAlarmParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.time;
        if (r0 != null) goto L8;
        r0 = ((ClockCreateAlarmParams) r9).time;
    L8:
        String r2 = r0;
        String r1 = this.date;
        if (r1 != null) goto L11;
        r1 = ((ClockCreateAlarmParams) r9).date;
    L11:
        String r3 = r1;
        Integer[] r4 = this.repeatDayOfWeek;
        if (r4 != null) goto L14;
        r4 = ((ClockCreateAlarmParams) r9).repeatDayOfWeek;
    L14:
        Integer[] r5 = r4;
        Boolean r6 = this.closeInHoliday;
        if (r6 != null) goto L17;
        r6 = ((ClockCreateAlarmParams) r9).closeInHoliday;
    L17:
        Boolean r7 = r6;
        String r8 = this.name;
        if (r8 != null) goto L20;
        r8 = ((ClockCreateAlarmParams) r9).name;
    L20:
        String r10 = r8;
        Integer r11 = this.repeatType;
        if (r11 != null) goto L23;
        Integer r12 = ((ClockCreateAlarmParams) r9).repeatType;
    L25:
        return new ClockCreateAlarmParams(r2, r3, r5, r7, r10, r12);
    L23:
        r12 = r11;
        goto L25
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

    public final void setTime(String r1) {
        this.time = r1;
    }

    public ClockCreateAlarmParams(String r1, String r2, Integer[] r3, Boolean r4, String r5, Integer r6) {
        this.time = r1;
        this.date = r2;
        this.repeatDayOfWeek = r3;
        this.closeInHoliday = r4;
        this.name = r5;
        this.repeatType = r6;
    }

    public /* synthetic */ ClockCreateAlarmParams(String r6, String r7, Integer[] r8, Boolean r9, String r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Integer[] r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        Integer r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
