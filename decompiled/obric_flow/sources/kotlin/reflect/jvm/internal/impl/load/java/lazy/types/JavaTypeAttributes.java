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

    public /* synthetic */ JavaTypeAttributes(TypeUsage r10, JavaTypeFlexibility r11, boolean r12, boolean r13, Set r14, SimpleType r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        r11 = JavaTypeFlexibility.INFLEXIBLE;
    L5:
        JavaTypeFlexibility r5 = r11;
        if ((r16 & 4) == 0) goto L8;
        boolean r18 = false;
    L10:
        if ((r16 & 8) == 0) goto L12;
        boolean r19 = false;
    L14:
        if ((r16 & 16) == 0) goto L16;
        Set r20 = null;
    L18:
        if ((r16 & 32) == 0) goto L20;
        SimpleType r21 = null;
    L21:
        this(r10, r5, r18, r19, r20, r21);
        return;
    L20:
        r21 = r15;
        goto L21
    L16:
        r20 = r14;
        goto L18
    L12:
        r19 = r13;
        goto L14
    L8:
        r18 = r12;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes r5, TypeUsage r10, JavaTypeFlexibility r11, boolean r12, boolean r13, Set r14, SimpleType r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.howThisTypeIsUsed;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.flexibility;
    L8:
        JavaTypeFlexibility r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.isRaw;
    L11:
        boolean r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.isForAnnotationParameter;
    L14:
        boolean r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.visitedTypeParameters;
    L17:
        Set r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.defaultType;
    L20:
        TypeUsage r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final JavaTypeAttributes copy(TypeUsage r10, JavaTypeFlexibility r11, boolean r12, boolean r13, Set<? extends TypeParameterDescriptor> r14, SimpleType r15) {
        Intrinsics.checkNotNullParameter(r10, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r11, "flexibility");
        return new JavaTypeAttributes(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public boolean equals(Object r5) {
        if ((r5 instanceof JavaTypeAttributes) == true) goto L5;
        return false;
    L5:
        JavaTypeAttributes r10 = (JavaTypeAttributes) r5;
        if (Intrinsics.areEqual(r10.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r10.getHowThisTypeIsUsed() == getHowThisTypeIsUsed()) goto L10;
        return false;
    L10:
        if (r10.flexibility == this.flexibility) goto L12;
        return false;
    L12:
        if (r10.isRaw == this.isRaw) goto L14;
        return false;
    L14:
        if (r10.isForAnnotationParameter != this.isForAnnotationParameter) goto L21;
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
        SimpleType r5 = getDefaultType();
        if (r5 == null) goto L5;
        int r10 = r5.hashCode();
    L6:
        int r11 = getHowThisTypeIsUsed().hashCode();
        int r12 = (r11 + (r10 * 31)) + r10;
        int r13 = this.flexibility.hashCode();
        int r14 = (r13 + (r12 * 31)) + r12;
        int r15 = ((r14 * 31) + (this.isRaw ? 1 : 0)) + r14;
        return ((r15 * 31) + (this.isForAnnotationParameter ? 1 : 0)) + r15;
    L5:
        r10 = 0;
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
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.howThisTypeIsUsed + ", flexibility=" + this.flexibility + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + this.visitedTypeParameters + ", defaultType=" + this.defaultType + ')';
    }

    public JavaTypeAttributes withDefaultType(SimpleType r10) {
        return copy$default(this, null, null, false, false, null, r10, 31, null);
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility r11) {
        Intrinsics.checkNotNullParameter(r11, "flexibility");
        return copy$default(this, null, r11, false, false, null, null, 61, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public /* bridge */ /* synthetic */ ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r5) {
        return withNewVisitedTypeParameter(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "typeParameter");
        if (getVisitedTypeParameters() == null) goto L6;
        Set r11 = SetsKt.plus(getVisitedTypeParameters(), r10);
    L8:
        return copy$default(this, null, null, false, false, r11, null, 47, null);
    L6:
        r11 = SetsKt.setOf(r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeAttributes(TypeUsage r5, JavaTypeFlexibility r10, boolean r11, boolean r12, Set<? extends TypeParameterDescriptor> r13, SimpleType r14) {
        Intrinsics.checkNotNullParameter(r5, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r10, "flexibility");
        super(r5, r13, r14);
        this.howThisTypeIsUsed = r5;
        this.flexibility = r10;
        this.isRaw = r11;
        this.isForAnnotationParameter = r12;
        this.visitedTypeParameters = r13;
        this.defaultType = r14;
    }
}
