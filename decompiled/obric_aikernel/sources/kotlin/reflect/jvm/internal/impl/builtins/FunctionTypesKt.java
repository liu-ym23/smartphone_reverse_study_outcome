package kotlin.reflect.jvm.internal.impl.builtins;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FunctionTypesKt {
    public static final int contextFunctionTypeParamsCount(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AnnotationDescriptor r11 = r10.getAnnotations().mo1318findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (r11 != null) goto L6;
        return 0;
    L6:
        ConstantValue r12 = (ConstantValue) MapsKt.getValue(r11.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((IntValue) r12).getValue().intValue();
    }

    @JvmOverloads
    public static final SimpleType createFunctionType(KotlinBuiltIns r10, Annotations r11, KotlinType r12, List<? extends KotlinType> r13, List<? extends KotlinType> r14, List<Name> r15, KotlinType r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r13, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(r14, "parameterTypes");
        Intrinsics.checkNotNullParameter(r16, "returnType");
        List<TypeProjection> r18 = getFunctionTypeArgumentProjections(r12, r13, r14, r15, r16, r10);
        int r19 = r14.size() + r13.size();
        if (r12 != null) goto L5;
        int r20 = 0;
    L6:
        ClassDescriptor r110 = getFunctionDescriptor(r10, r19 + r20, r17);
        if (r12 == null) goto L10;
        r11 = withExtensionFunctionAnnotation(r11, r10);
    L10:
        if ((!r13.isEmpty()) == false) goto L13;
        r11 = withContextReceiversFunctionAnnotation(r11, r10, r13.size());
    L13:
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(r11), r110, r18);
    L5:
        r20 = 1;
        goto L6
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns r10, Annotations r11, KotlinType r12, List r13, List r14, List r15, KotlinType r16, boolean r17, int r18, Object r19) {
        if ((r18 & 128) == 0) goto L5;
        boolean r20 = false;
    L7:
        return createFunctionType(r10, r11, r12, r13, r14, r15, r16, r20);
    L5:
        r20 = r17;
        goto L7
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AnnotationDescriptor r11 = r10.getAnnotations().mo1318findAnnotation(StandardNames.FqNames.parameterName);
        if (r11 != null) goto L5;
        return null;
    L5:
        Object r12 = CollectionsKt.singleOrNull(r11.getAllValueArguments().values());
        if ((r12 instanceof StringValue) == false) goto L8;
        StringValue r13 = (StringValue) r12;
    L9:
        if (r13 == null) goto L19;
        String r14 = r13.getValue();
        if (r14 == null) goto L19;
        if (Name.isValidIdentifier(r14) == true) goto L16;
        r14 = null;
    L16:
        if (r14 == null) goto L19;
        return Name.identifier(r14);
    L19:
        return null;
    L8:
        r13 = null;
        goto L9
    }

    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        isBuiltinFunctionalType(r10);
        int r11 = contextFunctionTypeParamsCount(r10);
        if (r11 == 0) goto L12;
        List<TypeProjection> r12 = r10.getArguments().subList(0, r11);
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L10;
        KotlinType r15 = ((TypeProjection) r14.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r15, "it.type");
        r13.add(r15);
        goto L7
    L10:
        return r13;
    L12:
        return CollectionsKt.emptyList();
    }

    public static final ClassDescriptor getFunctionDescriptor(KotlinBuiltIns r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        if (r12 == false) goto L5;
        ClassDescriptor r13 = r10.getSuspendFunction(r11);
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return r13;
    L5:
        r13 = r10.getFunction(r11);
        goto L6
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType r10, List<? extends KotlinType> r11, List<? extends KotlinType> r12, List<Name> r13, KotlinType r14, KotlinBuiltIns r15) {
        Intrinsics.checkNotNullParameter(r11, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(r12, "parameterTypes");
        Intrinsics.checkNotNullParameter(r14, "returnType");
        Intrinsics.checkNotNullParameter(r15, "builtIns");
        int r16 = r12.size() + r11.size();
        int r17 = 0;
        if (r10 == null) goto L5;
        int r18 = 1;
    L6:
        ArrayList r19 = new ArrayList((r16 + r18) + 1);
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r21 = r11.iterator();
    L8:
        if (r21.hasNext() == false) goto L10;
        r20.add(TypeUtilsKt.asTypeProjection((KotlinType) r21.next()));
        goto L8
    L10:
        r19.addAll(r20);
        if (r10 == null) goto L13;
        TypeProjection r22 = TypeUtilsKt.asTypeProjection(r10);
    L14:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r19, r22);
        Iterator<T> r23 = r12.iterator();
    L16:
        if (r23.hasNext() == false) goto L31;
        Object r110 = r23.next();
        int r24 = r17 + 1;
        if (r17 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        KotlinType r111 = (KotlinType) r110;
        if (r13 == null) goto L27;
        Name r25 = r13.get(r17);
        if (r25 == null) goto L27;
        if (r25.isSpecial() == true) goto L27;
    L28:
        if (r25 == null) goto L30;
        FqName r26 = StandardNames.FqNames.parameterName;
        Name r27 = Name.identifier(ActivityLifecycle.NAME);
        String r28 = r25.asString();
        Intrinsics.checkNotNullExpressionValue(r28, "name.asString()");
        r111 = TypeUtilsKt.replaceAnnotations(r111, Annotations.Companion.create(CollectionsKt.plus(r111.getAnnotations(), new BuiltInAnnotationDescriptor(r15, r26, MapsKt.mapOf(TuplesKt.to(r27, new StringValue(r28)))))));
    L30:
        r19.add(TypeUtilsKt.asTypeProjection(r111));
        r17 = r24;
    L27:
        r25 = null;
        goto L28
    L31:
        r19.add(TypeUtilsKt.asTypeProjection(r14));
        return r19;
    L13:
        r22 = null;
        goto L14
    L5:
        r18 = 0;
        goto L6
    }

    public static final FunctionClassKind getFunctionalClassKind(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ClassDescriptor) == true) goto L6;
        return null;
    L6:
        if (KotlinBuiltIns.isUnderKotlinPackage(r10) == true) goto L9;
        return null;
    L9:
        return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(r10));
    }

    private static final FunctionClassKind getFunctionalClassKind(FqNameUnsafe r10) {
        if (r10.isSafe() == true) goto L5;
        return null;
    L5:
        if (r10.isRoot() == true) goto L11;
        FunctionClassKind.Companion r11 = FunctionClassKind.Companion;
        String r12 = r10.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(r12, "shortName().asString()");
        FqName r13 = r10.toSafe().parent();
        Intrinsics.checkNotNullExpressionValue(r13, "toSafe().parent()");
        return r11.getFunctionalClassKind(r12, r13);
    L11:
        return null;
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        isBuiltinFunctionalType(r10);
        if (isTypeAnnotatedWithExtensionFunctionType(r10) == true) goto L6;
        return null;
    L6:
        int r11 = contextFunctionTypeParamsCount(r10);
        return r10.getArguments().get(r11).getType();
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        isBuiltinFunctionalType(r10);
        KotlinType r11 = ((TypeProjection) CollectionsKt.last(r10.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(r11, "arguments.last().type");
        return r11;
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        isBuiltinFunctionalType(r10);
        List<TypeProjection> r11 = r10.getArguments();
        return r11.subList(contextFunctionTypeParamsCount(r10) + (isBuiltinExtensionFunctionalType(r10) ? 1 : 0), r11.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (isBuiltinFunctionalType(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isTypeAnnotatedWithExtensionFunctionType(r10) == false) goto L7;
        return true;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FunctionClassKind r11 = getFunctionalClassKind(r10);
        if (r11 != FunctionClassKind.Function) goto L5;
    L8:
        return true;
    L5:
        if (r11 == FunctionClassKind.SuspendFunction) goto L8;
        return false;
    }

    public static final boolean isBuiltinFunctionalType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 == null) goto L8;
        if (isBuiltinFunctionalClassDescriptor(r11) != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean isFunctionType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 == null) goto L5;
        FunctionClassKind r12 = getFunctionalClassKind(r11);
    L7:
        if (r12 != FunctionClassKind.Function) goto L9;
        return true;
    L9:
        return false;
    L5:
        r12 = null;
        goto L7
    }

    public static final boolean isSuspendFunctionType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 == null) goto L5;
        FunctionClassKind r12 = getFunctionalClassKind(r11);
    L7:
        if (r12 != FunctionClassKind.SuspendFunction) goto L9;
        return true;
    L9:
        return false;
    L5:
        r12 = null;
        goto L7
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType r10) {
        if (r10.getAnnotations().mo1318findAnnotation(StandardNames.FqNames.extensionFunctionType) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Annotations withContextReceiversFunctionAnnotation(Annotations r10, KotlinBuiltIns r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builtIns");
        FqName r13 = StandardNames.FqNames.contextFunctionTypeParams;
        if (r10.hasAnnotation(r13) == false) goto L6;
        return r10;
    L6:
        return Annotations.Companion.create(CollectionsKt.plus(r10, new BuiltInAnnotationDescriptor(r11, r13, MapsKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(r12))))));
    }

    public static final Annotations withExtensionFunctionAnnotation(Annotations r10, KotlinBuiltIns r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builtIns");
        FqName r12 = StandardNames.FqNames.extensionFunctionType;
        if (r10.hasAnnotation(r12) == false) goto L6;
        return r10;
    L6:
        return Annotations.Companion.create(CollectionsKt.plus(r10, new BuiltInAnnotationDescriptor(r11, r12, MapsKt.emptyMap())));
    }
}
