package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/BatteryCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "percent", "", "isCharging", "", "(DZ)V", "()Z", "getPercent", "()D", "component1", "component2", "copy", "describeContents", "", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BatteryCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<BatteryCondition> CREATOR = null;
    private final boolean isCharging;
    private final double percent;

    public static final class a implements Parcelable.Creator<BatteryCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BatteryCondition createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            double r2 = r8.readDouble();
            int r6 = 1;
            if (r8.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            BatteryCondition r1 = new BatteryCondition(r2, r4);
            int r3 = Math.min(r0, 0);
            ClassLoader r5 = a.class.getClassLoader();
        L7:
            if (r6 > r3) goto L9;
            r6 = r6 + 1;
        L9:
            if (r6 > r0) goto L11;
            joa.a.d(r8, r5);
            r6 = r6 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r4 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BatteryCondition[] newArray(int r1) {
            return new BatteryCondition[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BatteryCondition(double r1, boolean r3) {
        this.percent = r1;
        this.isCharging = r3;
    }

    public /* synthetic */ BatteryCondition(double r1, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r3);
    }

    public static /* synthetic */ BatteryCondition copy$default(BatteryCondition r0, double r1, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.percent;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.isCharging;
    L9:
        return r0.copy(r1, r3);
    }

    public final double component1() {
        return this.percent;
    }

    public final boolean component2() {
        return this.isCharging;
    }

    public final BatteryCondition copy(double r2, boolean r4) {
        return new BatteryCondition(r2, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof BatteryCondition) == true) goto L8;
        return false;
    L8:
        BatteryCondition r9 = (BatteryCondition) r8;
        if (Double.compare(this.percent, r9.percent) == 0) goto L12;
        return false;
    L12:
        if (this.isCharging == r9.isCharging) goto L14;
        return false;
    L14:
        return true;
    }

    public final double getPercent() {
        return this.percent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.percent);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        boolean r2 = this.isCharging;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r1 + r3;
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    public String toString() {
        return "BatteryCondition(percent=" + this.percent + ", isCharging=" + this.isCharging + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeDouble(this.percent);
        r3.writeInt(this.isCharging ? 1 : 0);
    }
}
