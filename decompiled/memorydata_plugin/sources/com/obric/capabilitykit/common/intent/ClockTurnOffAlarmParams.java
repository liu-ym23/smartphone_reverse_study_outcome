package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.b.a;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ8\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockTurnOffAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "turnOffAll", "", ObricSecurityGuardStub.PermissionLevel.PERMISSION_LEVEL_ALWAYS, "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAlways", "()Ljava/lang/Boolean;", "setAlways", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "getTurnOffAll", "setTurnOffAll", "component1", "component2", "component3", "copy", "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ClockTurnOffAlarmParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockTurnOffAlarmParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<ClockTurnOffAlarmParams> CREATOR = null;
    private Boolean always;
    private AlarmEntity[] targets;
    private Boolean turnOffAll;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockTurnOffAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockTurnOffAlarmParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            Boolean r2 = null;
            if (r10.readInt() != 0) goto L5;
            AlarmEntity[] r4 = null;
        L8:
            int r5 = 1;
            if (r10.readInt() != 0) goto L12;
            Boolean r1 = null;
        L17:
            if (r10.readInt() != 0) goto L20;
        L24:
            ClockTurnOffAlarmParams r6 = new ClockTurnOffAlarmParams(r4, r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
        L25:
            if (r5 > r3) goto L27;
            r5 = r5 + 1;
        L27:
            if (r5 > r0) goto L29;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L27
        L29:
            return r6;
        L20:
            if (r10.readInt() == 0) goto L22;
            boolean r7 = true;
        L23:
            r2 = Boolean.valueOf(r7);
            goto L24
        L22:
            r7 = false;
            goto L23
        L12:
            if (r10.readInt() == 0) goto L14;
            boolean r8 = true;
        L15:
            r1 = Boolean.valueOf(r8);
            goto L17
        L14:
            r8 = false;
            goto L15
        L5:
            int r11 = r10.readInt();
            r4 = new AlarmEntity[r11];
            int r12 = 0;
        L6:
            if (r12 == r11) goto L8;
            r4[r12] = (AlarmEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(ClockTurnOffAlarmParams.class.getClassLoader()), AlarmEntity.class, "com.obric.memorydata.plugin");
            r12 = r12 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockTurnOffAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockTurnOffAlarmParams[] newArray(int r1) {
            return new ClockTurnOffAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockTurnOffAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ClockTurnOffAlarmParams() {
        this(null, null, null, 7, null);
    }

    public ClockTurnOffAlarmParams(AlarmEntity[] r1, Boolean r2, Boolean r3) {
        this.targets = r1;
        this.turnOffAll = r2;
        this.always = r3;
    }

    public /* synthetic */ ClockTurnOffAlarmParams(AlarmEntity[] r2, Boolean r3, Boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ ClockTurnOffAlarmParams copy$default(ClockTurnOffAlarmParams r0, AlarmEntity[] r1, Boolean r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.turnOffAll;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.always;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final AlarmEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.turnOffAll;
    }

    public final Boolean component3() {
        return this.always;
    }

    public final ClockTurnOffAlarmParams copy(AlarmEntity[] r1, Boolean r2, Boolean r3) {
        return new ClockTurnOffAlarmParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClockTurnOffAlarmParams.class) == true) goto L8;
        return false;
    L8:
        ClockTurnOffAlarmParams r6 = (ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.targets, r6.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.turnOffAll, r6.turnOffAll) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.always, r6.always) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Boolean getAlways() {
        return this.always;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final AlarmEntity[] getTargets() {
        return this.targets;
    }

    public final Boolean getTurnOffAll() {
        return this.turnOffAll;
    }

    public int hashCode() {
        AlarmEntity[] r0 = this.targets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.turnOffAll;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.always;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, ClockTurnOffAlarmParams.class) == true) goto L7;
        Object r4 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r4;
    L7:
        AlarmEntity[] r1 = this.targets;
        if (r1 != null) goto L10;
        r1 = ((ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.memorydata.plugin")).targets;
    L10:
        Boolean r3 = this.turnOffAll;
        if (r3 != null) goto L13;
        r3 = ((ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.memorydata.plugin")).turnOffAll;
    L13:
        Boolean r6 = this.always;
        if (r6 != null) goto L16;
        r6 = ((ClockTurnOffAlarmParams) ZeusTransformUtils.preCheckCast(r5, ClockTurnOffAlarmParams.class, "com.obric.memorydata.plugin")).always;
    L16:
        r4 = ZeusTransformUtils.preCheckCast(new ClockTurnOffAlarmParams(r1, r3, r6), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setAlways(Boolean r1) {
        this.always = r1;
    }

    public final void setTargets(AlarmEntity[] r1) {
        this.targets = r1;
    }

    public final void setTurnOffAll(Boolean r1) {
        this.turnOffAll = r1;
    }

    public String toString() {
        return "ClockTurnOffAlarmParams(targets=" + Arrays.toString(this.targets) + ", turnOffAll=" + this.turnOffAll + ", always=" + this.always + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r9, int r10) {
        r9.writeInt(0);
        Intrinsics.checkNotNullParameter(r9, "out");
        AlarmEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r9.writeInt(0);
    L8:
        Boolean r11 = this.turnOffAll;
        if (r11 != null) goto L11;
        r9.writeInt(0);
    L12:
        Boolean r8 = this.always;
        if (r8 != null) goto L15;
        r9.writeInt(0);
        return;
    L15:
        r9.writeInt(1);
        r9.writeInt(r8.booleanValue() ? 1 : 0);
        return;
    L11:
        r9.writeInt(1);
        r9.writeInt(r11.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r9.writeInt(1);
        int r3 = r1.length;
        r9.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1[r4], Parcelable.class, "com.obric.memorydata.plugin"), r10);
        r4 = r4 + 1;
        goto L6
    }
}
