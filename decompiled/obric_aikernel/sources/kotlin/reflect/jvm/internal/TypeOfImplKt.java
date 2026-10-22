package kotlin.reflect.jvm.internal;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeOfImplKt {
    public static final KType createMutableCollectionKType(KType r11) {
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        KotlinType r10 = ((KTypeImpl) r11).getType();
        if ((r10 instanceof SimpleType) == false) goto L14;
        ClassifierDescriptor r12 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r12 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r13 = (ClassDescriptor) r12;
    L8:
        if (r13 == null) goto L12;
        SimpleType r14 = (SimpleType) r10;
        TypeConstructor r15 = readOnlyToMutable(r13).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r15, "classifier.readOnlyToMutable().typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(r14, null, r15, null, false, 26, null), null, 2, null);
    L12:
        throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + r11);
    L7:
        r13 = null;
        goto L8
    L14:
        throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + r11).toString());
    }

    public static final KType createNothingType(KType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        KotlinType r11 = ((KTypeImpl) r10).getType();
        if ((r11 instanceof SimpleType) == false) goto L7;
        SimpleType r12 = (SimpleType) r11;
        TypeConstructor r13 = TypeUtilsKt.getBuiltIns(r11).getNothing().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r13, "kotlinType.builtIns.nothing.typeConstructor");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default(r12, null, r13, null, false, 26, null), null, 2, null);
    L7:
        throw new IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + r10).toString());
    }

    public static final KType createPlatformKType(KType r10, KType r11) {
        Intrinsics.checkNotNullParameter(r10, "lowerBound");
        Intrinsics.checkNotNullParameter(r11, "upperBound");
        KotlinType r12 = ((KTypeImpl) r10).getType();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r13 = ((KTypeImpl) r11).getType();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) r12, (SimpleType) r13), null, 2, null);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor r10) {
        FqName r11 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(r10));
        if (r11 == null) goto L7;
        ClassDescriptor r12 = DescriptorUtilsKt.getBuiltIns(r10).getBuiltInClassByFqName(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "builtIns.getBuiltInClassByFqName(fqName)");
        return r12;
    L7:
        throw new IllegalArgumentException("Not a readonly collection: " + r10);
    }
}
