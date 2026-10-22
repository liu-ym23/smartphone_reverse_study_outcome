package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeProjectionBase implements TypeProjection {
    public TypeProjectionBase() {
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TypeProjection) == true) goto L8;
        return false;
    L8:
        TypeProjection r11 = (TypeProjection) r10;
        if (isStarProjection() == r11.isStarProjection()) goto L12;
        return false;
    L12:
        if (getProjectionKind() == r11.getProjectionKind()) goto L15;
        return false;
    L15:
        if (getType().equals(r11.getType()) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r10 = getProjectionKind().hashCode();
        int r11 = r10 * 31;
        if (TypeUtils.noExpectedType(getType()) == false) goto L6;
        return r11 + 19;
    L6:
        if (isStarProjection() == false) goto L8;
        int r12 = 17;
    L10:
        return r11 + r12;
    L8:
        r12 = getType().hashCode();
        goto L10
    }

    public String toString() {
        if (isStarProjection() == false) goto L7;
        return "*";
    L7:
        if (getProjectionKind() != Variance.INVARIANT) goto L11;
        return getType().toString();
    L11:
        return getProjectionKind() + " " + getType();
    }
}
