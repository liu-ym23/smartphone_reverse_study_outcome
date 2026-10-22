package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorBasedTypeSignatureMappingKt {
    public static final String computeInternalName(ClassDescriptor r10, TypeMappingConfiguration<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        Intrinsics.checkNotNullParameter(r11, "typeMappingConfiguration");
        String r12 = r11.getPredefinedFullInternalNameForClass(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        DeclarationDescriptor r13 = r10.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r13, "klass.containingDeclaration");
        String r14 = SpecialNames.safeIdentifier(r10.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(r14, "safeIdentifier(klass.name).identifier");
        if ((r13 instanceof PackageFragmentDescriptor) == false) goto L13;
        FqName r15 = ((PackageFragmentDescriptor) r13).getFqName();
        if (r15.isRoot() == true) goto L24;
        StringBuilder r16 = new StringBuilder();
        String r17 = r15.asString();
        Intrinsics.checkNotNullExpressionValue(r17, "fqName.asString()");
        r16.append(StringsKt.replace$default(r17, '.', '/', false, 4, null));
        r16.append('/');
        r16.append(r14);
        return r16.toString();
    L24:
        return r14;
    L13:
        if ((r13 instanceof ClassDescriptor) == false) goto L15;
        ClassDescriptor r18 = (ClassDescriptor) r13;
    L16:
        if (r18 == null) goto L23;
        String r19 = r11.getPredefinedInternalNameForClass(r18);
        if (r19 != null) goto L21;
        r19 = computeInternalName(r18, r11);
    L21:
        return r19 + Typography.dollar + r14;
    L23:
        throw new IllegalArgumentException("Unexpected container: " + r13 + " for " + r10);
    L15:
        r18 = null;
        goto L16
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor r10, TypeMappingConfiguration r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = TypeMappingConfigurationImpl.INSTANCE;
    L6:
        return computeInternalName(r10, r11);
    }

    public static final boolean hasVoidReturnType(CallableDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        if ((r10 instanceof ConstructorDescriptor) == false) goto L5;
        return true;
    L5:
        KotlinType r11 = r10.getReturnType();
        Intrinsics.checkNotNull(r11);
        if (KotlinBuiltIns.isUnit(r11) == false) goto L12;
        KotlinType r12 = r10.getReturnType();
        Intrinsics.checkNotNull(r12);
        if (TypeUtils.isNullableType(r12) == true) goto L12;
        if ((r10 instanceof PropertyGetterDescriptor) == true) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType r10, JvmTypeFactory<T> r11, TypeMappingMode r12, TypeMappingConfiguration<? extends T> r13, JvmDescriptorTypeWriter<T> r14, Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "kotlinType");
        Intrinsics.checkNotNullParameter(r11, "factory");
        Intrinsics.checkNotNullParameter(r12, "mode");
        Intrinsics.checkNotNullParameter(r13, "typeMappingConfiguration");
        Intrinsics.checkNotNullParameter(r15, "writeGenericType");
        KotlinType r16 = r13.preprocessType(r10);
        if (r16 == null) goto L7;
        return (T) mapType(r16, r11, r12, r13, r14, r15);
    L7:
        if (FunctionTypesKt.isSuspendFunctionType(r10) == true) goto L9;
        SimpleClassicTypeSystemContext r17 = SimpleClassicTypeSystemContext.INSTANCE;
        Object r18 = TypeSignatureMappingKt.mapBuiltInType(r17, r10, r11, r12);
        if (r18 == null) goto L14;
        ?? r19 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(r11, r18, r12.getNeedPrimitiveBoxing());
        r15.invoke(r10, r19, r12);
        return r19;
    L14:
        TypeConstructor r20 = r10.getConstructor();
        if ((r20 instanceof IntersectionTypeConstructor) == false) goto L21;
        IntersectionTypeConstructor r21 = (IntersectionTypeConstructor) r20;
        KotlinType r22 = r21.getAlternativeType();
        if (r22 != null) goto L20;
        r22 = r13.commonSupertype(r21.mo1324getSupertypes());
    L20:
        return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(r22), r11, r12, r13, r14, r15);
    L21:
        ClassifierDescriptor r23 = r20.mo1323getDeclarationDescriptor();
        if (r23 == null) goto L91;
        if (ErrorUtils.isError(r23) == false) goto L29;
        T r24 = (T) r11.createObjectType("error/NonExistentClass");
        r13.processErrorType(r10, (ClassDescriptor) r23);
        if (r14 == 0) goto L28;
        r14.writeClass(r24);
    L28:
        return r24;
    L29:
        boolean r25 = r23 instanceof ClassDescriptor;
        if (r25 == true) goto L32;
    L50:
        if (r25 == false) goto L74;
        if (InlineClassesUtilsKt.isInlineClass(r23) == false) goto L60;
        if (r12.getNeedInlineClassWrapping() == true) goto L60;
        KotlinType r26 = (KotlinType) ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(r17, r10);
        if (r26 == null) goto L60;
        return (T) mapType(r26, r11, r12.wrapInlineClassesMode(), r13, r14, r15);
    L60:
        if (r12.isForAnnotationParameter() == true) goto L62;
    L64:
        ClassDescriptor r27 = (ClassDescriptor) r23;
        ClassDescriptor r110 = r27.getOriginal();
        Intrinsics.checkNotNullExpressionValue(r110, "descriptor.original");
        T r111 = r13.getPredefinedTypeForClass(r110);
        if (r111 == null) goto L67;
        T r28 = (Object) r111;
    L71:
        r15.invoke(r10, r28, r12);
        return r28;
    L67:
        if (r27.getKind() != ClassKind.ENUM_ENTRY) goto L69;
        DeclarationDescriptor r112 = r27.getContainingDeclaration();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        r27 = (ClassDescriptor) r112;
    L69:
        ClassDescriptor r113 = r27.getOriginal();
        Intrinsics.checkNotNullExpressionValue(r113, "enumClassIfEnumEntry.original");
        r28 = (Object) r11.createObjectType(computeInternalName(r113, r13));
        goto L71
    L62:
        if (KotlinBuiltIns.isKClass((ClassDescriptor) r23) == false) goto L64;
        r28 = (Object) r11.getJavaLangClassType();
        goto L71
    L74:
        if ((r23 instanceof TypeParameterDescriptor) == false) goto L83;
        KotlinType r114 = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) r23);
        if (r10.isMarkedNullable() == false) goto L78;
        r114 = TypeUtilsKt.makeNullable(r114);
    L78:
        T r29 = (T) mapType(r114, r11, r12, r13, null, FunctionsKt.getDO_NOTHING_3());
        if (r14 == 0) goto L81;
        Name r30 = r23.getName();
        Intrinsics.checkNotNullExpressionValue(r30, "descriptor.getName()");
        r14.writeTypeVariable(r30, r29);
    L81:
        return r29;
    L83:
        if ((r23 instanceof TypeAliasDescriptor) == false) goto L89;
        if (r12.getMapTypeAliases() == false) goto L89;
        return (T) mapType(((TypeAliasDescriptor) r23).getExpandedType(), r11, r12, r13, r14, r15);
    L89:
        throw new UnsupportedOperationException("Unknown type " + r10);
    L32:
        if (KotlinBuiltIns.isArray(r10) == false) goto L50;
        if (r10.getArguments().size() != 1) goto L49;
        TypeProjection r31 = r10.getArguments().get(0);
        KotlinType r32 = r31.getType();
        Intrinsics.checkNotNullExpressionValue(r32, "memberProjection.type");
        if (r31.getProjectionKind() != Variance.IN_VARIANCE) goto L41;
        Object r33 = r11.createObjectType("java/lang/Object");
        if (r14 == 0) goto L47;
        r14.writeArrayType();
        r14.writeClass(r33);
    L40:
        r14.writeArrayEnd();
    L47:
        return (T) r11.createFromString('[' + r11.toString(r33));
    L41:
        if (r14 == 0) goto L43;
        r14.writeArrayType();
    L43:
        Variance r34 = r31.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r34, "memberProjection.projectionKind");
        r33 = mapType(r32, r11, r12.toGenericArgumentMode(r34, true), r13, r14, r15);
        if (r14 == 0) goto L47;
    L49:
        throw new UnsupportedOperationException("arrays must have one type argument");
    L91:
        throw new UnsupportedOperationException("no descriptor for type constructor of " + r10);
    L9:
        return (T) mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(r10), r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Object mapType$default(KotlinType r10, JvmTypeFactory r11, TypeMappingMode r12, TypeMappingConfiguration r13, JvmDescriptorTypeWriter r14, Function3 r15, int r16, Object r17) {
        if ((r16 & 32) == 0) goto L6;
        r15 = FunctionsKt.getDO_NOTHING_3();
    L6:
        return mapType(r10, r11, r12, r13, r14, r15);
    }
}
