package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeAttributes extends ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final JavaTypeFlexibility flexibility;
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final boolean isRaw;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeAttributes(TypeUsage r10, JavaTypeFlexibility r11, boolean r12, boolean r13, Set<? extends TypeParameterDescriptor> r14, SimpleType r15) {
        Intrinsics.checkNotNullParameter(r10, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r11, "flexibility");
        super(r10, r14, r15);
        this.howThisTypeIsUsed = r10;
        this.flexibility = r11;
        this.isRaw = r12;
        this.isForAnnotationParameter = r13;
        this.visitedTypeParameters = r14;
        this.defaultType = r15;
    }

    public /* synthetic */ JavaTypeAttributes(TypeUsage r10, JavaTypeFlexibility r11, boolean r12, boolean r13, Set r14, SimpleType r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        r11 = JavaTypeFlexibility.INFLEXIBLE;
    L5:
        JavaTypeFlexibility r18 = r11;
        if ((r16 & 4) == 0) goto L8;
        boolean r19 = false;
    L10:
        if ((r16 & 8) == 0) goto L12;
        boolean r20 = false;
    L14:
        if ((r16 & 16) == 0) goto L16;
        Set r21 = null;
    L18:
        if ((r16 & 32) == 0) goto L20;
        SimpleType r22 = null;
    L21:
        this(r10, r18, r19, r20, r21, r22);
        return;
    L20:
        r22 = r15;
        goto L21
    L16:
        r21 = r14;
        goto L18
    L12:
        r20 = r13;
        goto L14
    L8:
        r19 = r12;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes r10, TypeUsage r11, JavaTypeFlexibility r12, boolean r13, boolean r14, Set r15, SimpleType r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.getHowThisTypeIsUsed();
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.flexibility;
    L8:
        JavaTypeFlexibility r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.isRaw;
    L11:
        boolean r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.isForAnnotationParameter;
    L14:
        boolean r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.getVisitedTypeParameters();
    L17:
        Set r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.getDefaultType();
    L20:
        TypeUsage r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    public final JavaTypeAttributes copy(TypeUsage r10, JavaTypeFlexibility r11, boolean r12, boolean r13, Set<? extends TypeParameterDescriptor> r14, SimpleType r15) {
        Intrinsics.checkNotNullParameter(r10, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r11, "flexibility");
        return new JavaTypeAttributes(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public boolean equals(Object r10) {
        if ((r10 instanceof JavaTypeAttributes) == true) goto L5;
        return false;
    L5:
        JavaTypeAttributes r11 = (JavaTypeAttributes) r10;
        if (Intrinsics.areEqual(r11.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r11.getHowThisTypeIsUsed() == getHowThisTypeIsUsed()) goto L10;
        return false;
    L10:
        if (r11.flexibility == this.flexibility) goto L12;
        return false;
    L12:
        if (r11.isRaw == this.isRaw) goto L14;
        return false;
    L14:
        if (r11.isForAnnotationParameter != this.isForAnnotationParameter) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public int hashCode() {
        SimpleType r10 = getDefaultType();
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 + ((r11 * 31) + getHowThisTypeIsUsed().hashCode());
        int r13 = r12 + ((r12 * 31) + this.flexibility.hashCode());
        int r14 = r13 + ((r13 * 31) + (this.isRaw ? 1 : 0));
        return r14 + ((r14 * 31) + (this.isForAnnotationParameter ? 1 : 0));
    L5:
        r11 = 0;
        goto L6
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final JavaTypeAttributes markIsRaw(boolean r10) {
        return copy$default(this, null, null, r10, false, null, null, 59, null);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + getHowThisTypeIsUsed() + ", flexibility=" + this.flexibility + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + getVisitedTypeParameters() + ", defaultType=" + getDefaultType() + ')';
    }

    public JavaTypeAttributes withDefaultType(SimpleType r10) {
        return copy$default(this, null, null, false, false, null, r10, 31, null);
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility r11) {
        Intrinsics.checkNotNullParameter(r11, "flexibility");
        return copy$default(this, null, r11, false, false, null, null, 61, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "typeParameter");
        if (getVisitedTypeParameters() == null) goto L5;
        Set r11 = SetsKt.plus(getVisitedTypeParameters(), r10);
    L7:
        return copy$default(this, null, null, false, false, r11, null, 47, null);
    L5:
        r11 = SetsKt.setOf(r10);
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public /* bridge */ /* synthetic */ ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r10) {
        return withNewVisitedTypeParameter(r10);
    }
}
