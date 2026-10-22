package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u0006\u0012\u0002\b\u00030#*\u00020$H\u0002J\u0010\u0010%\u001a\u0006\u0012\u0002\b\u00030&*\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final KTypeParameterOwnerImpl container;
    private final TypeParameterDescriptor descriptor;
    private final ReflectProperties.LazySoftVal upperBounds$delegate;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Variance.values().length];
            r5[Variance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[Variance.IN_VARIANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[Variance.OUT_VARIANCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl r5, TypeParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        this.descriptor = r10;
        this.upperBounds$delegate = ReflectProperties.lazySoft(new KTypeParameterImpl$upperBounds$2(this));
        if (r5 != null) goto L24;
        DeclarationDescriptor r11 = getDescriptor().getContainingDeclaration();
        if ((r11 instanceof ClassDescriptor) == false) goto L8;
        Object r12 = toKClassImpl((ClassDescriptor) r11);
    L19:
        r5 = (KTypeParameterOwnerImpl) r12;
        goto L24
    L8:
        if ((r11 instanceof CallableMemberDescriptor) == false) goto L23;
        DeclarationDescriptor r13 = ((CallableMemberDescriptor) r11).getContainingDeclaration();
        if ((r13 instanceof ClassDescriptor) == false) goto L13;
        KClassImpl<?> r14 = toKClassImpl((ClassDescriptor) r13);
    L18:
        r12 = r11.accept(new CreateKCallableVisitor(r14), Unit.INSTANCE);
        goto L19
    L13:
        if ((r11 instanceof DeserializedMemberDescriptor) == false) goto L15;
        DeserializedMemberDescriptor r15 = (DeserializedMemberDescriptor) r11;
    L16:
        if (r15 == null) goto L21;
        KClass r16 = JvmClassMappingKt.getKotlinClass(getContainerClass(r15));
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        r14 = (KClassImpl) r16;
        goto L18
    L21:
        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + r11);
    L15:
        r15 = null;
        goto L16
    L23:
        throw new KotlinReflectionInternalError("Unknown type parameter container: " + r11);
    L24:
        this.container = r5;
    }

    private final Class<?> getContainerClass(DeserializedMemberDescriptor r5) {
        DeserializedContainerSource r10 = r5.getContainerSource();
        ReflectKotlinClass r11 = null;
        if ((r10 instanceof JvmPackagePartSource) == false) goto L5;
        JvmPackagePartSource r12 = (JvmPackagePartSource) r10;
    L6:
        if (r12 == null) goto L8;
        KotlinJvmBinaryClass r13 = r12.getKnownJvmBinaryClass();
    L10:
        if ((r13 instanceof ReflectKotlinClass) == false) goto L12;
        r11 = (ReflectKotlinClass) r13;
    L12:
        if (r11 == null) goto L17;
        Class<?> r14 = r11.getKlass();
        if (r14 == null) goto L17;
        return r14;
    L17:
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + r5);
    L8:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    private final KClassImpl<?> toKClassImpl(ClassDescriptor r5) {
        Class<?> r10 = UtilKt.toJavaClass(r5);
        if (r10 == null) goto L5;
        KClass r11 = JvmClassMappingKt.getKotlinClass(r10);
    L6:
        KClassImpl<?> r12 = (KClassImpl) r11;
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + r5.getContainingDeclaration());
    L5:
        r11 = null;
        goto L6
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof KTypeParameterImpl) == false) goto L9;
        KTypeParameterImpl r10 = (KTypeParameterImpl) r5;
        if (Intrinsics.areEqual(this.container, r10.container) == false) goto L9;
        if (Intrinsics.areEqual(getName(), r10.getName()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDescriptor() {
        return getDescriptor();
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return getDescriptor().getName().asString();
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        return (List) this.upperBounds$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        Variance r5 = getDescriptor().getVariance();
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L15;
        if (r10 != 3) goto L10;
        return KVariance.OUT;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return KVariance.IN;
    L13:
        return KVariance.INVARIANT;
    }

    public int hashCode() {
        int r5 = this.container.hashCode() * 31;
        return getName().hashCode() + r5;
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return getDescriptor().isReified();
    }

    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }
}
