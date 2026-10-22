package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0002¨\u0006\t"}, d2 = {"createMutableCollectionKType", "Lkotlin/reflect/KType;", "type", "createNothingType", "createPlatformKType", "lowerBound", "upperBound", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\ntypeOfImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeOfImpl.kt\nkotlin/reflect/jvm/internal/TypeOfImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class TypeOfImplKt {
    public static final KType createMutableCollectionKType(KType r11) {
        Intrinsics.checkNotNullParameter(r11, "type");
        KotlinType r5 = ((KTypeImpl) r11).getType();
        if ((r5 instanceof SimpleType) == false) goto L14;
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r12 = (ClassDescriptor) r10;
    L8:
        if (r12 == null) goto L12;
        return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) r5, null, readOnlyToMutable(r12).getTypeConstructor(), null, false, 26, null), null, 2, null);
    L12:
        throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + r11);
    L7:
        r12 = null;
        goto L8
    L14:
        throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + r11).toString());
    }

    public static final KType createNothingType(KType r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        KotlinType r5 = ((KTypeImpl) r10).getType();
        if ((r5 instanceof SimpleType) == false) goto L7;
        return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) r5, null, TypeUtilsKt.getBuiltIns(r5).getNothing().getTypeConstructor(), null, false, 26, null), null, 2, null);
    L7:
        throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + r10).toString());
    }

    public static final KType createPlatformKType(KType r5, KType r10) {
        Intrinsics.checkNotNullParameter(r5, "lowerBound");
        Intrinsics.checkNotNullParameter(r10, "upperBound");
        KotlinType r11 = ((KTypeImpl) r5).getType();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r12 = ((KTypeImpl) r10).getType();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) r11, (SimpleType) r12), null, 2, null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor r5) {
        FqName r10 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(r5));
        if (r10 == null) goto L7;
        return DescriptorUtilsKt.getBuiltIns(r5).getBuiltInClassByFqName(r10);
    L7:
        throw new IllegalArgumentException("Not a readonly collection: " + r5);
    }
}
