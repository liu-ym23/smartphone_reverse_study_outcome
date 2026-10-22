package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.constraintlayout.motion.widget.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;
    private final NullabilityQualifier qualifier;

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "qualifier");
        this.qualifier = r5;
        this.isForWarningOnly = r10;
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus r5, NullabilityQualifier r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.qualifier;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.isForWarningOnly;
    L9:
        return r5.copy(r10, r11);
    }

    public final NullabilityQualifierWithMigrationStatus copy(NullabilityQualifier r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NullabilityQualifierWithMigrationStatus) == true) goto L8;
        return false;
    L8:
        NullabilityQualifierWithMigrationStatus r10 = (NullabilityQualifierWithMigrationStatus) r5;
        if (this.qualifier == r10.qualifier) goto L12;
        return false;
    L12:
        if (this.isForWarningOnly == r10.isForWarningOnly) goto L14;
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
        int r5 = this.qualifier.hashCode() * 31;
        boolean r10 = this.isForWarningOnly;
        ?? r11 = r10;
        if (r10 == false) goto L6;
        r11 = 1;
    L6:
        return r5 + r11;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("NullabilityQualifierWithMigrationStatus(qualifier=");
        r5.append(this.qualifier);
        r5.append(", isForWarningOnly=");
        return a.w(r5, this.isForWarningOnly, ')');
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier r5, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = false;
    L5:
        this(r5, r10);
    }
}
