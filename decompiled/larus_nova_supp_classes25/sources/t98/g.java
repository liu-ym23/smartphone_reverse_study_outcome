package t98;

import com.larus.avlink.gallery.power.policy.AlbumThermalLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final AlbumThermalLevel a;
    public final boolean b;
    public final Boolean c;
    public final Integer d;
    public final Boolean e;
    public final Double f;
    public final Double g;
    public final Boolean h;
    public final Long i;
    public final Integer j;
    public final Integer k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        Boolean r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        Integer r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Double r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Double r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Long r23 = this.i;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.j;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.k;
        if (r29 == null) goto L42;
        r5 = r29.hashCode();
    L42:
        int r30 = (r28 + r5) * 31;
        if (this.l == false) goto L45;
        int r31 = 1231;
    L46:
        int r32 = (r30 + r31) * 31;
        if (this.m == false) goto L49;
        int r33 = 1231;
    L50:
        int r34 = (r32 + r33) * 31;
        if (this.n == false) goto L53;
        int r35 = 1231;
    L54:
        int r36 = (r34 + r35) * 31;
        if (this.o == true) goto L59;
        r2 = 1237;
    L59:
        return r36 + r2;
    L53:
        r35 = 1237;
        goto L54
    L49:
        r33 = 1237;
        goto L50
    L45:
        r31 = 1237;
        goto L46
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AlbumPowerSnapshot(thermalLevel=" + this.a + ", thermalAvailable=" + this.b + ", powerSaveMode=" + this.c + ", batteryLevelPercent=" + this.d + ", isCharging=" + this.e + ", appCpuUsagePercent=" + this.f + ", appCpuSpeedPercent=" + this.g + ", isLowMemory=" + this.h + ", availableMemoryBytes=" + this.i + ", logicalCoreCount=" + this.j + ", bigCoreCount=" + this.k + ", cpuAvailable=" + this.l + ", memoryAvailable=" + this.m + ", batteryAvailable=" + this.n + ", staticCpuAvailable=" + this.o + ')';
    }

    public g(AlbumThermalLevel r4, boolean r5, Boolean r6, Integer r7, Boolean r8, Double r9, Double r10, Boolean r11, Long r12, Integer r13, Integer r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r4, "thermalLevel");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
    }
}
