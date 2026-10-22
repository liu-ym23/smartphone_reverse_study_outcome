package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;
    private final NullabilityQualifier qualifier;

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "qualifier");
        this.qualifier = r10;
        this.isForWarningOnly = r11;
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        this(r10, r11);
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus r10, NullabilityQualifier r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.qualifier;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.isForWarningOnly;
    L9:
        return r10.copy(r11, r12);
    }

    public final NullabilityQualifierWithMigrationStatus copy(NullabilityQualifier r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NullabilityQualifierWithMigrationStatus) == true) goto L8;
        return false;
    L8:
        NullabilityQualifierWithMigrationStatus r11 = (NullabilityQualifierWithMigrationStatus) r10;
        if (this.qualifier == r11.qualifier) goto L12;
        return false;
    L12:
        if (this.isForWarningOnly == r11.isForWarningOnly) goto L14;
        return false;
    L14:
        return true;
    }

    public final NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int r10 = this.qualifier.hashCode() * 31;
        boolean r11 = this.isForWarningOnly;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return r10 + r12;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.qualifier + ", isForWarningOnly=" + this.isForWarningOnly + ')';
    }
}
