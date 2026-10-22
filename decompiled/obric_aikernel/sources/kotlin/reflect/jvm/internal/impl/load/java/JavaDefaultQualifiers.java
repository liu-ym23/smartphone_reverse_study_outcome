package kotlin.reflect.jvm.internal.impl.load.java;

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
    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r10, Collection<? extends AnnotationQualifierApplicabilityType> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r11, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = r10;
        this.qualifierApplicabilityTypes = r11;
        this.definitelyNotNull = r12;
    }

    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r10, Collection r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) != 0) goto L5;
    L8:
        this(r10, r11, r12);
        return;
    L5:
        if (r10.getQualifier() != NullabilityQualifier.NOT_NULL) goto L7;
        r12 = true;
        goto L8
    L7:
        r12 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers r10, NullabilityQualifierWithMigrationStatus r11, Collection r12, boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.nullabilityQualifier;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.qualifierApplicabilityTypes;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.definitelyNotNull;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final JavaDefaultQualifiers copy(NullabilityQualifierWithMigrationStatus r10, Collection<? extends AnnotationQualifierApplicabilityType> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r11, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof JavaDefaultQualifiers) == true) goto L8;
        return false;
    L8:
        JavaDefaultQualifiers r11 = (JavaDefaultQualifiers) r10;
        if (Intrinsics.areEqual(this.nullabilityQualifier, r11.nullabilityQualifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.qualifierApplicabilityTypes, r11.qualifierApplicabilityTypes) == true) goto L15;
        return false;
    L15:
        if (this.definitelyNotNull == r11.definitelyNotNull) goto L17;
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
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r10 = ((this.nullabilityQualifier.hashCode() * 31) + this.qualifierApplicabilityTypes.hashCode()) * 31;
        boolean r11 = this.definitelyNotNull;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return r10 + r12;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ", definitelyNotNull=" + this.definitelyNotNull + ')';
    }
}
