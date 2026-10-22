package kotlin.reflect.jvm.internal.impl.load.java;

import androidx.constraintlayout.motion.widget.a;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaDefaultQualifiers {
    private final boolean definitelyNotNull;
    private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    private final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r5, Collection<? extends AnnotationQualifierApplicabilityType> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r10, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = r5;
        this.qualifierApplicabilityTypes = r10;
        this.definitelyNotNull = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers r5, NullabilityQualifierWithMigrationStatus r10, Collection r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.nullabilityQualifier;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.qualifierApplicabilityTypes;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.definitelyNotNull;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final JavaDefaultQualifiers copy(NullabilityQualifierWithMigrationStatus r5, Collection<? extends AnnotationQualifierApplicabilityType> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r10, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JavaDefaultQualifiers) == true) goto L8;
        return false;
    L8:
        JavaDefaultQualifiers r10 = (JavaDefaultQualifiers) r5;
        if (Intrinsics.areEqual(this.nullabilityQualifier, r10.nullabilityQualifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.qualifierApplicabilityTypes, r10.qualifierApplicabilityTypes) == true) goto L15;
        return false;
    L15:
        if (this.definitelyNotNull == r10.definitelyNotNull) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r5 = this.nullabilityQualifier.hashCode() * 31;
        int r10 = (this.qualifierApplicabilityTypes.hashCode() + r5) * 31;
        boolean r11 = this.definitelyNotNull;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return r10 + r12;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("JavaDefaultQualifiers(nullabilityQualifier=");
        r5.append(this.nullabilityQualifier);
        r5.append(", qualifierApplicabilityTypes=");
        r5.append(this.qualifierApplicabilityTypes);
        r5.append(", definitelyNotNull=");
        return a.w(r5, this.definitelyNotNull, ')');
    }

    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r5, Collection r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) != 0) goto L5;
    L8:
        this(r5, r10, r11);
        return;
    L5:
        if (r5.getQualifier() != NullabilityQualifier.NOT_NULL) goto L7;
        r11 = true;
        goto L8
    L7:
        r11 = false;
        goto L8
    }
}
