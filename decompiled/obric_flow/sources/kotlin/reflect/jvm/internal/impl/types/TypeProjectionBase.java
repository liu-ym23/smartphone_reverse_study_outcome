package kotlin.reflect.jvm.internal.impl.types;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeProjectionBase implements TypeProjection {
    public TypeProjectionBase() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TypeProjection) == true) goto L8;
        return false;
    L8:
        TypeProjection r10 = (TypeProjection) r5;
        if (isStarProjection() == r10.isStarProjection()) goto L12;
        return false;
    L12:
        if (getProjectionKind() == r10.getProjectionKind()) goto L15;
        return false;
    L15:
        if (getType().equals(r10.getType()) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r5 = getProjectionKind().hashCode();
        if (TypeUtils.noExpectedType(getType()) == true) goto L11;
        int r10 = r5 * 31;
        if (isStarProjection() == false) goto L8;
        int r11 = 17;
    L10:
        return r10 + r11;
    L8:
        r11 = getType().hashCode();
        goto L10
    L11:
        return (r5 * 31) + 19;
    }

    public String toString() {
        if (isStarProjection() == false) goto L7;
        return XPath.WILDCARD;
    L7:
        if (getProjectionKind() != Variance.INVARIANT) goto L11;
        return getType().toString();
    L11:
        return getProjectionKind() + " " + getType();
    }
}
