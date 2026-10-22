package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.b.a;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#Jh\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u00020\nHÖ\u0001J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000109H\u0016J\t\u0010=\u001a\u00020\u0006HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\nHÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", TypedValues.AttributesType.S_TARGET, "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", OaidModel.KEY_TIME, "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", ActivityLifecycle.NAME, "repeatType", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getRepeatType$annotations", "()V", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockUpdateAlarmParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ClockUpdateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    Integer repeatType;
    private AlarmEntity target;
    private String time;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockUpdateAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams createFromParcel(Parcel r17) {
            int r1 = r17.readInt();
            Intrinsics.checkNotNullParameter(r17, "parcel");
            AlarmEntity r6 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r17.readParcelable(ClockUpdateAlarmParams.class.getClassLoader()), AlarmEntity.class, "com.obric.memorydata.plugin");
            String r7 = r17.readString();
            String r8 = r17.readString();
            boolean r5 = false;
            if (r17.readInt() != 0) goto L5;
            Integer[] r9 = null;
        L9:
            if (r17.readInt() != 0) goto L12;
            Boolean r10 = null;
        L15:
            ClockUpdateAlarmParams r2 = new ClockUpdateAlarmParams(r6, r7, r8, r9, r10, r17.readString(), null, 64, null);
            int r3 = Math.min(r1, 1);
            ClassLoader r11 = getClass().getClassLoader();
            int r12 = 1;
        L16:
            if (r12 > r3) goto L22;
            if (r12 != 1) goto L21;
            Object r13 = a.b(r17, r11);
            if (r13 == null) goto L21;
            r2.repeatType = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.memorydata.plugin");
        L21:
            r12 = r12 + 1;
        L22:
            if (r12 > r1) goto L24;
            a.a(r17, r11);
            r12 = r12 + 1;
            goto L22
        L24:
            return r2;
        L12:
            if (r17.readInt() == 0) goto L14;
            r5 = true;
        L14:
            r10 = Boolean.valueOf(r5);
            goto L15
        L5:
            int r4 = r17.readInt();
            r9 = new Integer[r4];
            int r14 = 0;
        L6:
            if (r14 == r4) goto L9;
            r9[r14] = Integer.valueOf(r17.readInt());
            r14 = r14 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams[] newArray(int r1) {
            return new ClockUpdateAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockUpdateAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ClockUpdateAlarmParams() {
        this(null, null, null, null, null, null, null, 127, null);
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

    public /* synthetic */ ClockUpdateAlarmParams(AlarmEntity r2, String r3, String r4, Integer[] r5, Boolean r6, String r7, Integer r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
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

    public final ClockUpdateAlarmParams copy(AlarmEntity r9, String r10, String r11, Integer[] r12, Boolean r13, String r14, Integer r15) {
        return new ClockUpdateAlarmParams(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClockUpdateAlarmParams.class) == true) goto L8;
        return false;
    L8:
        ClockUpdateAlarmParams r6 = (ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin");
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final AlarmEntity getTarget() {
        return this.target;
    }

    public final String getTime() {
        return this.time;
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r12) {
        if (ZeusTransformUtils.instanceOf(r12, ClockUpdateAlarmParams.class) == false) goto L5;
        AlarmEntity r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin")).target;
    L9:
        AlarmEntity r4 = r1;
        String r2 = this.time;
        if (r2 != null) goto L12;
        r2 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin")).time;
    L12:
        String r5 = r2;
        String r3 = this.date;
        if (r3 != null) goto L15;
        r3 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin")).date;
    L15:
        String r6 = r3;
        Integer[] r7 = this.repeatDayOfWeek;
        if (r7 != null) goto L18;
        r7 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin")).repeatDayOfWeek;
    L18:
        Integer[] r8 = r7;
        Boolean r9 = this.closeInHoliday;
        if (r9 != null) goto L21;
        r9 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin")).closeInHoliday;
    L21:
        Boolean r10 = r9;
        String r11 = this.name;
        if (r11 != null) goto L24;
        r11 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin")).name;
    L24:
        String r13 = r11;
        Integer r14 = this.repeatType;
        if (r14 != null) goto L27;
        r14 = ((ClockUpdateAlarmParams) ZeusTransformUtils.preCheckCast(r12, ClockUpdateAlarmParams.class, "com.obric.memorydata.plugin")).repeatType;
    L27:
        ClockUpdateAlarmParams this = new ClockUpdateAlarmParams(r4, r5, r6, r8, r10, r13, r14);
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
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

    public String toString() {
        return "ClockUpdateAlarmParams(target=" + this.target + ", time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ", repeatType=" + this.repeatType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        r6.writeInt(1);
        Intrinsics.checkNotNullParameter(r6, "out");
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.target, Parcelable.class, "com.obric.memorydata.plugin"), r7);
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
}
