package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final KTypeParameterOwnerImpl container;
    private final TypeParameterDescriptor descriptor;
    private final ReflectProperties.LazySoftVal upperBounds$delegate;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[Variance.values().length];
            r10[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl r10, TypeParameterDescriptor r11) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        this.descriptor = r11;
        this.upperBounds$delegate = ReflectProperties.lazySoft(new KTypeParameterImpl$upperBounds$2(this));
        if (r10 != null) goto L24;
        DeclarationDescriptor r12 = getDescriptor().getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.containingDeclaration");
        if ((r12 instanceof ClassDescriptor) == false) goto L8;
        Object r13 = toKClassImpl((ClassDescriptor) r12);
    L19:
        Intrinsics.checkNotNullExpressionValue(r13, "when (val declaration = … $declaration\")\n        }");
        r10 = (KTypeParameterOwnerImpl) r13;
        goto L24
    L8:
        if ((r12 instanceof CallableMemberDescriptor) == false) goto L23;
        DeclarationDescriptor r14 = ((CallableMemberDescriptor) r12).getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r14, "declaration.containingDeclaration");
        if ((r14 instanceof ClassDescriptor) == false) goto L13;
        KClassImpl<?> r15 = toKClassImpl((ClassDescriptor) r14);
    L18:
        r13 = r12.accept(new CreateKCallableVisitor(r15), Unit.INSTANCE);
        goto L19
    L13:
        if ((r12 instanceof DeserializedMemberDescriptor) == false) goto L15;
        DeserializedMemberDescriptor r16 = (DeserializedMemberDescriptor) r12;
    L16:
        if (r16 == null) goto L21;
        KClass r17 = JvmClassMappingKt.getKotlinClass(getContainerClass(r16));
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        r15 = (KClassImpl) r17;
        goto L18
    L21:
        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + r12);
    L15:
        r16 = null;
        goto L16
    L23:
        throw new KotlinReflectionInternalError("Unknown type parameter container: " + r12);
    L24:
        this.container = r10;
    }

    private final Class<?> getContainerClass(DeserializedMemberDescriptor r10) {
        DeserializedContainerSource r11 = r10.getContainerSource();
        KotlinJvmBinaryClass r12 = null;
        if ((r11 instanceof JvmPackagePartSource) == true) goto L5;
        r11 = null;
    L5:
        JvmPackagePartSource r13 = (JvmPackagePartSource) r11;
        if (r13 == null) goto L8;
        KotlinJvmBinaryClass r14 = r13.getKnownJvmBinaryClass();
    L10:
        if ((r14 instanceof ReflectKotlinClass) == false) goto L13;
        r12 = r14;
    L13:
        ReflectKotlinClass r15 = (ReflectKotlinClass) r12;
        if (r15 == null) goto L19;
        Class<?> r16 = r15.getKlass();
        if (r16 == null) goto L19;
        return r16;
    L19:
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + r10);
    L8:
        r14 = null;
        goto L10
    }

    private final KClassImpl<?> toKClassImpl(ClassDescriptor r10) {
        Class<?> r11 = UtilKt.toJavaClass(r10);
        if (r11 == null) goto L5;
        KClass r12 = JvmClassMappingKt.getKotlinClass(r11);
    L6:
        KClassImpl<?> r13 = (KClassImpl) r12;
        if (r13 == null) goto L10;
        return r13;
    L10:
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + r10.getContainingDeclaration());
    L5:
        r12 = null;
        goto L6
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof KTypeParameterImpl) == false) goto L9;
        KTypeParameterImpl r11 = (KTypeParameterImpl) r10;
        if (Intrinsics.areEqual(this.container, r11.container) == false) goto L9;
        if (Intrinsics.areEqual(getName(), r11.getName()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDescriptor() {
        return getDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        String r10 = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(r10, "descriptor.name.asString()");
        return r10;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        T r10 = this.upperBounds$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(r10, "<get-upperBounds>(...)");
        return (List) r10;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        Variance r10 = getDescriptor().getVariance();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L15;
        if (r11 != 3) goto L10;
        return KVariance.OUT;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return KVariance.IN;
    L13:
        return KVariance.INVARIANT;
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return getDescriptor().isReified();
    }

    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }
}
