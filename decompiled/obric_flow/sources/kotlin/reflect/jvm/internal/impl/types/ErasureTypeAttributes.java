package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nErasureTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErasureTypeAttributes.kt\norg/jetbrains/kotlin/types/ErasureTypeAttributes\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
public class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage r5, Set<? extends TypeParameterDescriptor> r10, SimpleType r11) {
        Intrinsics.checkNotNullParameter(r5, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = r5;
        this.visitedTypeParameters = r10;
        this.defaultType = r11;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ErasureTypeAttributes) == true) goto L5;
        return false;
    L5:
        ErasureTypeAttributes r10 = (ErasureTypeAttributes) r5;
        if (Intrinsics.areEqual(r10.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r10.getHowThisTypeIsUsed() != getHowThisTypeIsUsed()) goto L12;
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
        SimpleType r5 = getDefaultType();
        if (r5 == null) goto L5;
        int r10 = r5.hashCode();
    L6:
        int r11 = getHowThisTypeIsUsed().hashCode();
        return (r11 + (r10 * 31)) + r10;
    L5:
        r10 = 0;
        goto L6
    }

    public ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "typeParameter");
        TypeUsage r10 = getHowThisTypeIsUsed();
        Set<TypeParameterDescriptor> r11 = getVisitedTypeParameters();
        if (r11 == null) goto L6;
        Set r12 = SetsKt.plus(r11, r5);
        if (r12 == null) goto L6;
    L8:
        return new ErasureTypeAttributes(r10, r12, getDefaultType());
    L6:
        r12 = SetsKt.setOf(r5);
        goto L8
    }
}
