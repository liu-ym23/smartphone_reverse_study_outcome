package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.FrameMetricsAggregator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003Jk\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u000100H\u0096\u0002J\b\u00101\u001a\u00020\u0007H\u0016J\t\u00102\u001a\u00020\tHÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R&\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\r\u0010\u0011\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u00068"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "Landroid/os/Parcelable;", "daily", "", "weekly", "", "monthly", "", "yearly", "", "everyOffDay", "everyWorkDay", "expireDate", "isSingleTask", "startDate", "(Z[IILjava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;)V", "getDaily", "()Z", "getEveryOffDay", "getEveryWorkDay", "getExpireDate$annotations", "()V", "getExpireDate", "()Ljava/lang/String;", "setExpireDate", "(Ljava/lang/String;)V", "isSingleTask$annotations", "setSingleTask", "(Z)V", "getMonthly", "()I", "getStartDate", "getWeekly", "()[I", "getYearly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PeriodicPolicy implements Parcelable {
    public static final Parcelable.Creator<PeriodicPolicy> CREATOR = null;
    private final boolean daily;
    private final boolean everyOffDay;
    private final boolean everyWorkDay;
    public String expireDate;
    public boolean isSingleTask;
    private final int monthly;
    private final String startDate;
    private final int[] weekly;
    private final String yearly;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<PeriodicPolicy> {
        public a() {
        }

        public final PeriodicPolicy a(Parcel r18) {
            int r1 = r18.readInt();
            Intrinsics.checkNotNullParameter(r18, "parcel");
            if (r18.readInt() == 0) goto L5;
            boolean r5 = true;
        L6:
            int[] r6 = r18.createIntArray();
            int r7 = r18.readInt();
            String r8 = r18.readString();
            if (r18.readInt() == 0) goto L9;
            boolean r9 = true;
        L11:
            if (r18.readInt() == 0) goto L13;
            boolean r10 = true;
        L14:
            boolean r4 = r5;
            boolean r11 = r9;
            boolean r12 = r10;
            PeriodicPolicy r2 = new PeriodicPolicy(r4, r6, r7, r8, r11, r12, null, false, r18.readString(), 192, null);
            int r13 = Math.min(r1, 2);
            ClassLoader r14 = a.class.getClassLoader();
            int r15 = 1;
        L15:
            if (r15 > r13) goto L26;
            if (r15 != 1) goto L21;
            Object r16 = com.obric.b.a.b(r18, r14);
            if (r16 == null) goto L25;
            r2.expireDate = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
        L25:
            r15 = r15 + 1;
            goto L15
        L21:
            if (r15 != 2) goto L25;
            Object r17 = com.obric.b.a.b(r18, r14);
            if (r17 == null) goto L25;
            r2.isSingleTask = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L26:
            if (r15 > r1) goto L28;
            com.obric.b.a.a(r18, r14);
            r15 = r15 + 1;
            goto L26
        L28:
            return r2;
        L13:
            r10 = false;
            goto L14
        L9:
            r9 = false;
            goto L11
        L5:
            r5 = false;
            goto L6
        }

        public final PeriodicPolicy[] a(int r1) {
            return new PeriodicPolicy[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PeriodicPolicy createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PeriodicPolicy[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public PeriodicPolicy() {
        this(false, null, 0, null, false, false, null, false, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public PeriodicPolicy(boolean r1, int[] r2, int r3, String r4, boolean r5, boolean r6, String r7, boolean r8, String r9) {
        this.daily = r1;
        this.weekly = r2;
        this.monthly = r3;
        this.yearly = r4;
        this.everyOffDay = r5;
        this.everyWorkDay = r6;
        this.expireDate = r7;
        this.isSingleTask = r8;
        this.startDate = r9;
    }

    public /* synthetic */ PeriodicPolicy(boolean r3, int[] r4, int r5, String r6, boolean r7, boolean r8, String r9, boolean r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r8 = false;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r10 = false;
    L27:
        if ((r12 & 256) == 0) goto L29;
        r11 = null;
    L29:
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ PeriodicPolicy copy$default(PeriodicPolicy r10, boolean r11, int[] r12, int r13, String r14, boolean r15, boolean r16, String r17, boolean r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        boolean r2 = r10.daily;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int[] r3 = r10.weekly;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.monthly;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.yearly;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = r10.everyOffDay;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r7 = r10.everyWorkDay;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.expireDate;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.isSingleTask;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.startDate;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public static /* synthetic */ void getExpireDate$annotations() {
    }

    public static /* synthetic */ void isSingleTask$annotations() {
    }

    public final boolean component1() {
        return this.daily;
    }

    public final int[] component2() {
        return this.weekly;
    }

    public final int component3() {
        return this.monthly;
    }

    public final String component4() {
        return this.yearly;
    }

    public final boolean component5() {
        return this.everyOffDay;
    }

    public final boolean component6() {
        return this.everyWorkDay;
    }

    public final String component7() {
        return this.expireDate;
    }

    public final boolean component8() {
        return this.isSingleTask;
    }

    public final String component9() {
        return this.startDate;
    }

    public final PeriodicPolicy copy(boolean r12, int[] r13, int r14, String r15, boolean r16, boolean r17, String r18, boolean r19, String r20) {
        return new PeriodicPolicy(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r2 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(PeriodicPolicy.class, r2) == true) goto L11;
        return false;
    L11:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.PeriodicPolicy");
        PeriodicPolicy r6 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r5, PeriodicPolicy.class, "com.obric.memorydata.plugin");
        if (this.daily == r6.daily) goto L15;
        return false;
    L15:
        if (this.monthly == r6.monthly) goto L18;
        return false;
    L18:
        if (Arrays.equals(this.weekly, r6.weekly) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.yearly, r6.yearly) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.expireDate, r6.expireDate) == true) goto L27;
        return false;
    L27:
        if (this.everyOffDay == r6.everyOffDay) goto L30;
        return false;
    L30:
        if (this.everyWorkDay == r6.everyWorkDay) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.startDate, r6.startDate) == true) goto L35;
        return false;
    L35:
        return true;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean getDaily() {
        return this.daily;
    }

    public final boolean getEveryOffDay() {
        return this.everyOffDay;
    }

    public final boolean getEveryWorkDay() {
        return this.everyWorkDay;
    }

    public final String getExpireDate() {
        return this.expireDate;
    }

    public final int getMonthly() {
        return this.monthly;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final int[] getWeekly() {
        return this.weekly;
    }

    public final String getYearly() {
        return this.yearly;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.daily) * 31) + this.monthly) * 31;
        int[] r1 = this.weekly;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = Arrays.hashCode(r1);
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.yearly;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((((r4 + r6) * 31) + Boolean.hashCode(this.everyOffDay)) * 31) + Boolean.hashCode(this.everyWorkDay)) * 31;
        String r8 = this.expireDate;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (((r7 + r9) * 31) + Boolean.hashCode(this.isSingleTask)) * 31;
        String r11 = this.startDate;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final boolean isSingleTask() {
        return this.isSingleTask;
    }

    public final void setExpireDate(String r1) {
        this.expireDate = r1;
    }

    public final void setSingleTask(boolean r1) {
        this.isSingleTask = r1;
    }

    public String toString() {
        return "PeriodicPolicy(daily=" + this.daily + ", weekly=" + Arrays.toString(this.weekly) + ", monthly=" + this.monthly + ", yearly=" + this.yearly + ", everyOffDay=" + this.everyOffDay + ", everyWorkDay=" + this.everyWorkDay + ", expireDate=" + this.expireDate + ", isSingleTask=" + this.isSingleTask + ", startDate=" + this.startDate + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeInt(this.daily ? 1 : 0);
        r1.writeIntArray(this.weekly);
        r1.writeInt(this.monthly);
        r1.writeString(this.yearly);
        r1.writeInt(this.everyOffDay ? 1 : 0);
        r1.writeInt(this.everyWorkDay ? 1 : 0);
        r1.writeString(this.startDate);
        r1.writeValue(this.expireDate);
        r1.writeValue(Boolean.valueOf(this.isSingleTask));
    }
}
