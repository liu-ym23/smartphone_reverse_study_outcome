package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.constraintlayout.motion.widget.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\ndescriptorBasedTypeSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 descriptorBasedTypeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/DescriptorBasedTypeSignatureMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,198:1\n1#2:199\n*E\n"})
public final class DescriptorBasedTypeSignatureMappingKt {
    public static final String computeInternalName(ClassDescriptor r5, TypeMappingConfiguration<?> r10) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        Intrinsics.checkNotNullParameter(r10, "typeMappingConfiguration");
        String r11 = r10.getPredefinedFullInternalNameForClass(r5);
        if (r11 == null) goto L5;
        return r11;
    L5:
        DeclarationDescriptor r12 = r5.getContainingDeclaration();
        String r13 = SpecialNames.safeIdentifier(r5.getName()).getIdentifier();
        if ((r12 instanceof PackageFragmentDescriptor) == false) goto L13;
        FqName r14 = ((PackageFragmentDescriptor) r12).getFqName();
        if (r14.isRoot() == false) goto L11;
        return r13;
    L11:
        return StringsKt.E(r14.asString(), '.', '/') + '/' + r13;
    L13:
        if ((r12 instanceof ClassDescriptor) == false) goto L15;
        ClassDescriptor r15 = (ClassDescriptor) r12;
    L16:
        if (r15 == null) goto L23;
        String r16 = r10.getPredefinedInternalNameForClass(r15);
        if (r16 != null) goto L21;
        r16 = computeInternalName(r15, r10);
    L21:
        return a.m(r16, Typography.dollar, r13);
    L23:
        throw new IllegalArgumentException("Unexpected container: " + r12 + " for " + r5);
    L15:
        r15 = null;
        goto L16
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor r5, TypeMappingConfiguration r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = TypeMappingConfigurationImpl.INSTANCE;
    L6:
        return computeInternalName(r5, r10);
    }

    public static final boolean hasVoidReturnType(CallableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if ((r5 instanceof ConstructorDescriptor) == false) goto L5;
        return true;
    L5:
        KotlinType r10 = r5.getReturnType();
        Intrinsics.checkNotNull(r10);
        if (KotlinBuiltIns.isUnit(r10) == false) goto L12;
        KotlinType r11 = r5.getReturnType();
        Intrinsics.checkNotNull(r11);
        if (TypeUtils.isNullableType(r11) == true) goto L12;
        if ((r5 instanceof PropertyGetterDescriptor) == true) goto L12;
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
        KotlinType r5 = r13.preprocessType(r10);
        if (r5 == null) goto L7;
        return (T) mapType(r5, r11, r12, r13, r14, r15);
    L7:
        if (FunctionTypesKt.isSuspendFunctionType(r10) == true) goto L9;
        SimpleClassicTypeSystemContext r16 = SimpleClassicTypeSystemContext.INSTANCE;
        Object r17 = TypeSignatureMappingKt.mapBuiltInType(r16, r10, r11, r12);
        if (r17 == null) goto L14;
        ?? r18 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(r11, r17, r12.getNeedPrimitiveBoxing());
        r15.invoke(r10, r18, r12);
        return r18;
    L14:
        TypeConstructor r19 = r10.getConstructor();
        if ((r19 instanceof IntersectionTypeConstructor) == false) goto L21;
        IntersectionTypeConstructor r20 = (IntersectionTypeConstructor) r19;
        KotlinType r21 = r20.getAlternativeType();
        if (r21 != null) goto L20;
        r21 = r13.commonSupertype(r20.mo1403getSupertypes());
    L20:
        return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(r21), r11, r12, r13, r14, r15);
    L21:
        ClassifierDescriptor r22 = r19.mo1402getDeclarationDescriptor();
        if (r22 == null) goto L90;
        if (ErrorUtils.isError(r22) == false) goto L29;
        T r23 = (T) r11.createObjectType("error/NonExistentClass");
        r13.processErrorType(r10, (ClassDescriptor) r22);
        if (r14 == 0) goto L28;
        r14.writeClass(r23);
    L28:
        return r23;
    L29:
        boolean r24 = r22 instanceof ClassDescriptor;
        if (r24 == true) goto L32;
    L49:
        if (r24 == false) goto L73;
        if (InlineClassesUtilsKt.isInlineClass(r22) == false) goto L59;
        if (r12.getNeedInlineClassWrapping() == true) goto L59;
        KotlinType r25 = (KotlinType) ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(r16, r10);
        if (r25 == null) goto L59;
        return (T) mapType(r25, r11, r12.wrapInlineClassesMode(), r13, r14, r15);
    L59:
        if (r12.isForAnnotationParameter() == true) goto L61;
    L63:
        ClassDescriptor r26 = (ClassDescriptor) r22;
        T r110 = r13.getPredefinedTypeForClass(r26.getOriginal());
        if (r110 == null) goto L66;
        T r27 = (Object) r110;
    L70:
        r15.invoke(r10, r27, r12);
        return r27;
    L66:
        if (r26.getKind() != ClassKind.ENUM_ENTRY) goto L68;
        DeclarationDescriptor r111 = r26.getContainingDeclaration();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        r26 = (ClassDescriptor) r111;
    L68:
        r27 = (Object) r11.createObjectType(computeInternalName(r26.getOriginal(), r13));
        goto L70
    L61:
        if (KotlinBuiltIns.isKClass((ClassDescriptor) r22) == false) goto L63;
        r27 = (Object) r11.getJavaLangClassType();
        goto L70
    L73:
        if ((r22 instanceof TypeParameterDescriptor) == false) goto L82;
        KotlinType r112 = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) r22);
        if (r10.isMarkedNullable() == false) goto L77;
        r112 = TypeUtilsKt.makeNullable(r112);
    L77:
        T r28 = (T) mapType(r112, r11, r12, r13, null, FunctionsKt.getDO_NOTHING_3());
        if (r14 == 0) goto L80;
        r14.writeTypeVariable(r22.getName(), r28);
    L80:
        return r28;
    L82:
        if ((r22 instanceof TypeAliasDescriptor) == false) goto L88;
        if (r12.getMapTypeAliases() == false) goto L88;
        return (T) mapType(((TypeAliasDescriptor) r22).getExpandedType(), r11, r12, r13, r14, r15);
    L88:
        throw new UnsupportedOperationException("Unknown type " + r10);
    L32:
        if (KotlinBuiltIns.isArray(r10) == false) goto L49;
        if (r10.getArguments().size() != 1) goto L48;
        TypeProjection r29 = r10.getArguments().get(0);
        KotlinType r30 = r29.getType();
        if (r29.getProjectionKind() != Variance.IN_VARIANCE) goto L40;
        Object r31 = r11.createObjectType("java/lang/Object");
        if (r14 == 0) goto L46;
        r14.writeArrayType();
        r14.writeClass(r31);
        r14.writeArrayEnd();
    L46:
        return (T) r11.createFromString("[" + r11.toString(r31));
    L40:
        if (r14 == 0) goto L42;
        r14.writeArrayType();
    L42:
        r31 = mapType(r30, r11, r12.toGenericArgumentMode(r29.getProjectionKind(), true), r13, r14, r15);
        if (r14 == 0) goto L46;
        r14.writeArrayEnd();
        goto L46
    L48:
        throw new UnsupportedOperationException("arrays must have one type argument");
    L90:
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
