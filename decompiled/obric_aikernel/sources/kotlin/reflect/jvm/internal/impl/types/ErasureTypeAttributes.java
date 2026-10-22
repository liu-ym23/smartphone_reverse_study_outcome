package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage r10, Set<? extends TypeParameterDescriptor> r11, SimpleType r12) {
        Intrinsics.checkNotNullParameter(r10, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = r10;
        this.visitedTypeParameters = r11;
        this.defaultType = r12;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ErasureTypeAttributes) == true) goto L5;
        return false;
    L5:
        ErasureTypeAttributes r11 = (ErasureTypeAttributes) r10;
        if (Intrinsics.areEqual(r11.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r11.getHowThisTypeIsUsed() != getHowThisTypeIsUsed()) goto L12;
        return true;
    L12:
        return false;
    }

    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public int hashCode() {
        SimpleType r10 = getDefaultType();
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return r11 + ((r11 * 31) + getHowThisTypeIsUsed().hashCode());
    L5:
        r11 = 0;
        goto L7
    }

    public ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "typeParameter");
        TypeUsage r11 = getHowThisTypeIsUsed();
        Set<TypeParameterDescriptor> r12 = getVisitedTypeParameters();
        if (r12 == null) goto L6;
        Set r13 = SetsKt.plus(r12, r10);
        if (r13 == null) goto L6;
    L8:
        return new ErasureTypeAttributes(r11, r13, getDefaultType());
    L6:
        r13 = SetsKt.setOf(r10);
        goto L8
    }
}
