package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003Jk\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u000100H\u0096\u0002J\b\u00101\u001a\u00020\u0007H\u0016J\t\u00102\u001a\u00020\tHÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R&\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\r\u0010\u0011\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u00068"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "Landroid/os/Parcelable;", "daily", "", "weekly", "", "monthly", "", "yearly", "", "everyOffDay", "everyWorkDay", "expireDate", "isSingleTask", "startDate", "(Z[IILjava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;)V", "getDaily", "()Z", "getEveryOffDay", "getEveryWorkDay", "getExpireDate$annotations", "()V", "getExpireDate", "()Ljava/lang/String;", "setExpireDate", "(Ljava/lang/String;)V", "isSingleTask$annotations", "setSingleTask", "(Z)V", "getMonthly", "()I", "getStartDate", "getWeekly", "()[I", "getYearly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
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

    static {
        CREATOR = new a();
    }

    public PeriodicPolicy() {
        this(false, null, 0, null, false, false, null, false, null, 511, null);
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

    public /* synthetic */ PeriodicPolicy(boolean r12, int[] r13, int r14, String r15, boolean r16, boolean r17, String r18, boolean r19, String r20, int r21, DefaultConstructorMarker r22) {
        boolean r2 = false;
        if ((r21 & 1) == 0) goto L5;
        boolean r1 = false;
    L6:
        String r4 = null;
        if ((r21 & 2) == 0) goto L9;
        int[] r3 = null;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r21 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r21 & 32) == 0) goto L25;
        boolean r8 = false;
    L27:
        if ((r21 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r21 & 128) != 0) goto L35;
        r2 = r19;
    L35:
        if ((r21 & ISmModel.VERSION_0100) != 0) goto L38;
        r4 = r20;
    L38:
        this(r1, r3, r5, r6, r7, r8, r9, r2, r4);
        return;
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L6
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
        if ((r20 & ISmModel.VERSION_0100) == 0) goto L37;
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
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(PeriodicPolicy.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.PeriodicPolicy");
        PeriodicPolicy r6 = (PeriodicPolicy) r5;
        if (this.daily == r6.daily) goto L16;
        return false;
    L16:
        if (this.monthly == r6.monthly) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.weekly, r6.weekly) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.yearly, r6.yearly) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.expireDate, r6.expireDate) == true) goto L28;
        return false;
    L28:
        if (this.everyOffDay == r6.everyOffDay) goto L31;
        return false;
    L31:
        if (this.everyWorkDay == r6.everyWorkDay) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.startDate, r6.startDate) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        r2 = null;
        goto L10
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
        int r1 = 1231;
        if (this.daily == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.monthly) * 31;
        int[] r3 = this.weekly;
        int r4 = 0;
        if (r3 == null) goto L9;
        int r5 = Arrays.hashCode(r3);
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.yearly;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.everyOffDay == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.everyWorkDay == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        String r14 = this.expireDate;
        if (r14 == null) goto L25;
        int r15 = r14.hashCode();
    L26:
        int r16 = (r13 + r15) * 31;
        if (this.isSingleTask == true) goto L30;
        r1 = 1237;
    L30:
        int r17 = (r16 + r1) * 31;
        String r18 = this.startDate;
        if (r18 == null) goto L34;
        r4 = r18.hashCode();
    L34:
        return r17 + r4;
    L25:
        r15 = 0;
        goto L26
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r0 = 1237;
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
