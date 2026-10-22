package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/BatteryCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "percent", "", "isCharging", "", "(DZ)V", "()Z", "getPercent", "()D", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BatteryCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<BatteryCondition> CREATOR = null;
    private final boolean isCharging;
    private final double percent;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<BatteryCondition> {
        public a() {
        }

        public final BatteryCondition a(Parcel r7) {
            int r6 = r7.readInt();
            Intrinsics.checkNotNullParameter(r7, "parcel");
            double r1 = r7.readDouble();
            int r5 = 1;
            if (r7.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            BatteryCondition r0 = new BatteryCondition(r1, r3);
            int r2 = Math.min(r6, 0);
            ClassLoader r4 = a.class.getClassLoader();
        L7:
            if (r5 > r2) goto L9;
            r5 = r5 + 1;
        L9:
            if (r5 > r6) goto L11;
            com.obric.b.a.a(r7, r4);
            r5 = r5 + 1;
            goto L9
        L11:
            return r0;
        L5:
            r3 = false;
            goto L6
        }

        public final BatteryCondition[] a(int r1) {
            return new BatteryCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ BatteryCondition createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ BatteryCondition[] newArray(int r1) {
            return a(r1);
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

    public final BatteryCondition copy(double r1, boolean r3) {
        return new BatteryCondition(r1, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, BatteryCondition.class) == true) goto L8;
        return false;
    L8:
        BatteryCondition r10 = (BatteryCondition) ZeusTransformUtils.preCheckCast(r9, BatteryCondition.class, "com.obric.memorydata.plugin");
        if (Double.compare(this.percent, r10.percent) == 0) goto L12;
        return false;
    L12:
        if (this.isCharging == r10.isCharging) goto L14;
        return false;
    L14:
        return true;
    }

    public final double getPercent() {
        return this.percent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = Double.hashCode(this.percent) * 31;
        boolean r2 = this.isCharging;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
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
