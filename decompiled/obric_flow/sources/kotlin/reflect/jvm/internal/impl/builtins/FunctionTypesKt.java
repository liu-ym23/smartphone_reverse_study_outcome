package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nfunctionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 functionTypes.kt\norg/jetbrains/kotlin/builtins/FunctionTypesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,293:1\n1#2:294\n1549#3:295\n1620#3,3:296\n223#3,2:299\n1549#3:301\n1620#3,3:302\n1549#3:305\n1620#3,3:306\n1590#3,4:309\n*S KotlinDebug\n*F\n+ 1 functionTypes.kt\norg/jetbrains/kotlin/builtins/FunctionTypesKt\n*L\n152#1:295\n152#1:296,3\n187#1:299,2\n192#1:301\n192#1:302,3\n214#1:305\n214#1:306,3\n217#1:309,4\n*E\n"})
public final class FunctionTypesKt {
    public static final int contextFunctionTypeParamsCount(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        AnnotationDescriptor r10 = r5.getAnnotations().mo1397findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (r10 != null) goto L6;
        return 0;
    L6:
        ConstantValue r11 = (ConstantValue) MapsKt.getValue(r10.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((IntValue) r11).getValue().intValue();
    }

    @JvmOverloads
    public static final SimpleType createFunctionType(KotlinBuiltIns r10, Annotations r11, KotlinType r12, List<? extends KotlinType> r13, List<? extends KotlinType> r14, List<Name> r15, KotlinType r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r13, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(r14, "parameterTypes");
        Intrinsics.checkNotNullParameter(r16, "returnType");
        List<TypeProjection> r18 = getFunctionTypeArgumentProjections(r12, r13, r14, r15, r16, r10);
        int r19 = r14.size();
        int r110 = r13.size() + r19;
        if (r12 != null) goto L5;
        int r111 = 0;
    L6:
        ClassDescriptor r112 = getFunctionDescriptor(r10, r110 + r111, r17);
        if (r12 == null) goto L10;
        r11 = withExtensionFunctionAnnotation(r11, r10);
    L10:
        if (r13.isEmpty() == true) goto L13;
        r11 = withContextReceiversFunctionAnnotation(r11, r10, r13.size());
    L13:
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(r11), r112, r18);
    L5:
        r111 = 1;
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

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        AnnotationDescriptor r10 = r5.getAnnotations().mo1397findAnnotation(StandardNames.FqNames.parameterName);
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = CollectionsKt.singleOrNull(r10.getAllValueArguments().values());
        if ((r11 instanceof StringValue) == false) goto L8;
        StringValue r12 = (StringValue) r11;
    L9:
        if (r12 == null) goto L19;
        String r13 = r12.getValue();
        if (r13 == null) goto L19;
        if (Name.isValidIdentifier(r13) == true) goto L16;
        r13 = null;
    L16:
        if (r13 == null) goto L19;
        return Name.identifier(r13);
    L19:
        return null;
    L8:
        r12 = null;
        goto L9
    }

    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        isBuiltinFunctionalType(r5);
        int r10 = contextFunctionTypeParamsCount(r5);
        if (r10 == 0) goto L12;
        List<TypeProjection> r11 = r5.getArguments().subList(0, r10);
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L10;
        r12.add(((TypeProjection) r13.next()).getType());
        goto L7
    L10:
        return r12;
    L12:
        return CollectionsKt.emptyList();
    }

    public static final ClassDescriptor getFunctionDescriptor(KotlinBuiltIns r5, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "builtIns");
        if (r11 == false) goto L6;
        return r5.getSuspendFunction(r10);
    L6:
        return r5.getFunction(r10);
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType r10, List<? extends KotlinType> r11, List<? extends KotlinType> r12, List<Name> r13, KotlinType r14, KotlinBuiltIns r15) {
        Intrinsics.checkNotNullParameter(r11, "contextReceiverTypes");
        Intrinsics.checkNotNullParameter(r12, "parameterTypes");
        Intrinsics.checkNotNullParameter(r14, "returnType");
        Intrinsics.checkNotNullParameter(r15, "builtIns");
        int r5 = r11.size() + r12.size();
        int r16 = 0;
        if (r10 == null) goto L5;
        int r17 = 1;
    L6:
        ArrayList r18 = new ArrayList((r5 + r17) + 1);
        ArrayList r19 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r20 = r11.iterator();
    L8:
        if (r20.hasNext() == false) goto L10;
        r19.add(TypeUtilsKt.asTypeProjection((KotlinType) r20.next()));
        goto L8
    L10:
        r18.addAll(r19);
        if (r10 == null) goto L13;
        TypeProjection r21 = TypeUtilsKt.asTypeProjection(r10);
    L14:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r18, r21);
        Iterator<T> r22 = r12.iterator();
    L16:
        if (r22.hasNext() == false) goto L31;
        Object r23 = r22.next();
        int r24 = r16 + 1;
        if (r16 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        KotlinType r25 = (KotlinType) r23;
        if (r13 == null) goto L27;
        Name r26 = r13.get(r16);
        if (r26 == null) goto L27;
        if (r26.isSpecial() == true) goto L27;
    L28:
        if (r26 == null) goto L30;
        r25 = TypeUtilsKt.replaceAnnotations(r25, Annotations.Companion.create(CollectionsKt.plus(r25.getAnnotations(), new BuiltInAnnotationDescriptor(r15, StandardNames.FqNames.parameterName, MapsKt.mapOf(TuplesKt.to(Name.identifier("name"), new StringValue(r26.asString())))))));
    L30:
        r18.add(TypeUtilsKt.asTypeProjection(r25));
        r16 = r24;
    L27:
        r26 = null;
        goto L28
    L31:
        r18.add(TypeUtilsKt.asTypeProjection(r14));
        return r18;
    L13:
        r21 = null;
        goto L14
    L5:
        r17 = 0;
        goto L6
    }

    public static final FunctionClassKind getFunctionalClassKind(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof ClassDescriptor) == true) goto L6;
        return null;
    L6:
        if (KotlinBuiltIns.isUnderKotlinPackage(r5) == true) goto L9;
        return null;
    L9:
        return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(r5));
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        isBuiltinFunctionalType(r5);
        if (isTypeAnnotatedWithExtensionFunctionType(r5) == true) goto L6;
        return null;
    L6:
        int r10 = contextFunctionTypeParamsCount(r5);
        return r5.getArguments().get(r10).getType();
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        isBuiltinFunctionalType(r5);
        return ((TypeProjection) CollectionsKt.last(r5.getArguments())).getType();
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        isBuiltinFunctionalType(r5);
        List<TypeProjection> r10 = r5.getArguments();
        return r10.subList((isBuiltinExtensionFunctionalType(r5) ? 1 : 0) + contextFunctionTypeParamsCount(r5), r10.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (isBuiltinFunctionalType(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (isTypeAnnotatedWithExtensionFunctionType(r5) == false) goto L7;
        return true;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FunctionClassKind r10 = getFunctionalClassKind(r5);
        if (r10 != FunctionClassKind.Function) goto L5;
    L8:
        return true;
    L5:
        if (r10 == FunctionClassKind.SuspendFunction) goto L8;
        return false;
    }

    public static final boolean isBuiltinFunctionalType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (isBuiltinFunctionalClassDescriptor(r10) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean isFunctionType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 == null) goto L5;
        FunctionClassKind r11 = getFunctionalClassKind(r10);
    L7:
        if (r11 != FunctionClassKind.Function) goto L9;
        return true;
    L9:
        return false;
    L5:
        r11 = null;
        goto L7
    }

    public static final boolean isSuspendFunctionType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 == null) goto L5;
        FunctionClassKind r11 = getFunctionalClassKind(r10);
    L7:
        if (r11 != FunctionClassKind.SuspendFunction) goto L9;
        return true;
    L9:
        return false;
    L5:
        r11 = null;
        goto L7
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType r5) {
        if (r5.getAnnotations().mo1397findAnnotation(StandardNames.FqNames.extensionFunctionType) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Annotations withContextReceiversFunctionAnnotation(Annotations r5, KotlinBuiltIns r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        FqName r12 = StandardNames.FqNames.contextFunctionTypeParams;
        if (r5.hasAnnotation(r12) == false) goto L6;
        return r5;
    L6:
        return Annotations.Companion.create(CollectionsKt.plus(r5, new BuiltInAnnotationDescriptor(r10, r12, MapsKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(r11))))));
    }

    public static final Annotations withExtensionFunctionAnnotation(Annotations r5, KotlinBuiltIns r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        FqName r11 = StandardNames.FqNames.extensionFunctionType;
        if (r5.hasAnnotation(r11) == false) goto L6;
        return r5;
    L6:
        return Annotations.Companion.create(CollectionsKt.plus(r5, new BuiltInAnnotationDescriptor(r10, r11, MapsKt.emptyMap())));
    }

    private static final FunctionClassKind getFunctionalClassKind(FqNameUnsafe r5) {
        if (r5.isSafe() == true) goto L5;
        return null;
    L5:
        if (r5.isRoot() == false) goto L8;
        return null;
    L8:
        return FunctionClassKind.Companion.getFunctionalClassKind(r5.shortName().asString(), r5.toSafe().parent());
    }
}
