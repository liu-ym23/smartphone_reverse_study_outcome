package kotlin.reflect.jvm.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u0006H\u0000\u001a(\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a.\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0014H\u0000\u001a\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0018H\u0000\u001a\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0017*\u00020\u001bH\u0002\u001a\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d*\u00020 2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a%\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u0010\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010)*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010\u001dH\u0000\u001al\u00101\u001a\u0002H2\"\b\b\u0000\u00103*\u000204\"\b\b\u0001\u00102*\u00020.2\n\u00105\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u00106\u001a\u0002H32\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u001d\u0010=\u001a\u0019\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H20>¢\u0006\u0002\b@H\u0000¢\u0006\u0002\u0010A\u001a\u0012\u0010H\u001a\u0004\u0018\u00010\u001d2\u0006\u0010I\u001a\u00020JH\u0000\u001a;\u0010K\u001a\u0004\u0018\u00010L*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000f2\u001a\u0010N\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050O\"\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0002\u0010P\u001a\u001a\u0010Q\u001a\u0004\u0018\u00010R*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000fH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010,\u001a\u0004\u0018\u00010-*\u00020.8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u0010B\u001a\u00020C*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010E\"\u0018\u0010F\u001a\u00020C*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "toJavaClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "arrayDimensions", "", DBDefinition.PACKAGE_NAME, "", "className", "createArrayType", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "unwrapRepeatableAnnotations", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toRuntimeValue", "", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "needsMultiFieldValueClassFlattening", "getNeedsMultiFieldValueClassFlattening", "defaultPrimitiveValue", EffectConfiguration.KEY_TYPE, "Ljava/lang/reflect/Type;", "getDeclaredMethodOrNull", "Ljava/lang/reflect/Method;", DBDefinition.NAME, "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDeclaredFieldOrNull", "Ljava/lang/reflect/Field;", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class UtilKt {
    private static final FqName JVM_STATIC = null;

    static {
        JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final KCallableImpl<?> asKCallableImpl(Object r1) {
        if ((r1 instanceof KCallableImpl) == false) goto L5;
        KCallableImpl<?> r0 = (KCallableImpl) r1;
    L6:
        if (r0 != null) goto L12;
        KFunctionImpl r2 = asKFunctionImpl(r1);
        if (r2 == null) goto L11;
        return r2;
    L11:
        return asKPropertyImpl(r1);
    L12:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final KFunctionImpl asKFunctionImpl(Object r2) {
        if ((r2 instanceof KFunctionImpl) == false) goto L5;
        KFunctionImpl r0 = (KFunctionImpl) r2;
    L6:
        if (r0 != null) goto L18;
        if ((r2 instanceof FunctionReference) == false) goto L10;
        FunctionReference r3 = (FunctionReference) r2;
    L11:
        if (r3 == null) goto L13;
        KCallable r4 = r3.compute();
    L15:
        if ((r4 instanceof KFunctionImpl) == true) goto L20;
        return null;
    L20:
        return (KFunctionImpl) r4;
    L13:
        r4 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    L18:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object r2) {
        if ((r2 instanceof KPropertyImpl) == false) goto L5;
        KPropertyImpl<?> r0 = (KPropertyImpl) r2;
    L6:
        if (r0 != null) goto L18;
        if ((r2 instanceof PropertyReference) == false) goto L10;
        PropertyReference r3 = (PropertyReference) r2;
    L11:
        if (r3 == null) goto L13;
        KCallable r4 = r3.compute();
    L15:
        if ((r4 instanceof KPropertyImpl) == true) goto L20;
        return null;
    L20:
        return (KPropertyImpl) r4;
    L13:
        r4 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    L18:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final List<Annotation> computeAnnotations(Annotated r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Annotations r5 = r4.getAnnotations();
        ArrayList r0 = new ArrayList();
        Iterator<AnnotationDescriptor> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L21;
        AnnotationDescriptor r1 = r6.next();
        RuntimeSourceElementFactory.RuntimeSourceElement r2 = r1.getSource();
        if ((r2 instanceof ReflectAnnotationSource) == false) goto L9;
        Annotation r3 = ((ReflectAnnotationSource) r2).getAnnotation();
    L18:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L9:
        if ((r2 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L17;
        ReflectJavaAnnotation r7 = r2.getJavaElement();
        if ((r7 instanceof ReflectJavaAnnotation) == false) goto L13;
        ReflectJavaAnnotation r8 = r7;
    L14:
        if (r8 == null) goto L16;
        r3 = r8.getAnnotation();
        goto L18
    L16:
        r3 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L17:
        r3 = toAnnotationInstance(r1);
        goto L18
    L21:
        return unwrapRepeatableAnnotations(r0);
    }

    public static final Class<?> createArrayType(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Array.newInstance(r1, 0).getClass();
    }

    public static final Object defaultPrimitiveValue(Type r3) {
        Intrinsics.checkNotNullParameter(r3, EffectConfiguration.KEY_TYPE);
        if ((r3 instanceof Class) == false) goto L36;
        Class r0 = (Class) r3;
        if (r0.isPrimitive() == false) goto L36;
        if (Intrinsics.areEqual(r0, Boolean.TYPE) == false) goto L10;
        return Boolean.FALSE;
    L10:
        if (Intrinsics.areEqual(r0, Character.TYPE) == false) goto L13;
        return (char) 0;
    L13:
        if (Intrinsics.areEqual(r0, Byte.TYPE) == false) goto L16;
        return (byte) 0;
    L16:
        if (Intrinsics.areEqual(r0, Short.TYPE) == false) goto L19;
        return (short) 0;
    L19:
        if (Intrinsics.areEqual(r0, Integer.TYPE) == false) goto L22;
        return 0;
    L22:
        if (Intrinsics.areEqual(r0, Float.TYPE) == false) goto L25;
        return Float.valueOf(0.0f);
    L25:
        if (Intrinsics.areEqual(r0, Long.TYPE) == false) goto L28;
        return 0L;
    L28:
        if (Intrinsics.areEqual(r0, Double.TYPE) == false) goto L31;
        return Double.valueOf(0.0d);
    L31:
        if (Intrinsics.areEqual(r0, Void.TYPE) == false) goto L35;
        throw new IllegalStateException("Parameter with void type is illegal");
    L35:
        throw new UnsupportedOperationException("Unknown primitive: " + r3);
    L36:
        return null;
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getDispatchReceiverParameter() == null) goto L5;
        DeclarationDescriptor r2 = r1.getContainingDeclaration();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) r2).getThisAsReceiverParameter();
    L5:
        return null;
    }

    public static final boolean getNeedsMultiFieldValueClassFlattening(KType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof KTypeImpl) == false) goto L5;
        KTypeImpl r3 = (KTypeImpl) r2;
    L7:
        if (r3 == null) goto L14;
        KotlinType r4 = r3.getType();
        if (r4 != null) goto L11;
        return false;
    L11:
        if (InlineClassesUtilsKt.needsMfvcFlattening(r4) != true) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean isInlineClassType(KType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof KTypeImpl) == false) goto L5;
        KTypeImpl r3 = (KTypeImpl) r2;
    L7:
        if (r3 == null) goto L14;
        KotlinType r4 = r3.getType();
        if (r4 != null) goto L11;
        return false;
    L11:
        if (InlineClassesUtilsKt.isInlineClassType(r4) != true) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor r6) {
        ClassDescriptor r0 = DescriptorUtilsKt.getAnnotationClass(r6);
        if (r0 == null) goto L5;
        Class<?> r1 = toJavaClass(r0);
    L7:
        if ((r1 instanceof Class) == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        return null;
    L12:
        Set r7 = r6.getAllValueArguments().entrySet();
        ArrayList r2 = new ArrayList();
        Iterator r8 = r7.iterator();
    L14:
        if (r8.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) r8.next();
        Name r4 = (Name) r3.getKey();
        Object r5 = toRuntimeValue((ConstantValue) r3.getValue(), r1.getClassLoader());
        if (r5 == null) goto L18;
        Pair r9 = TuplesKt.to(r4.asString(), r5);
    L19:
        if (r9 == null) goto L14;
        r2.add(r9);
        goto L14
    L18:
        r9 = null;
        goto L19
    L22:
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(r1, MapsKt.toMap(r2), null, 4, null);
    L5:
        r1 = null;
        goto L7
    }

    public static final Class<?> toJavaClass(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        RuntimeSourceElementFactory.RuntimeSourceElement r0 = r2.getSource();
        if ((r0 instanceof KotlinJvmBinarySourceElement) == false) goto L6;
        KotlinJvmBinaryClass r3 = ((KotlinJvmBinarySourceElement) r0).getBinaryClass();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        return ((ReflectKotlinClass) r3).getKlass();
    L6:
        if ((r0 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L8;
        ReflectJavaClass r4 = r0.getJavaElement();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        return r4.getElement();
    L8:
        ClassId r1 = DescriptorUtilsKt.getClassId(r2);
        if (r1 != null) goto L13;
        return null;
    L13:
        return loadClass(ReflectClassUtilKt.getSafeClassLoader(r2.getClass()), r1, 0);
    }

    public static final KVisibility toKVisibility(DescriptorVisibility r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.PUBLIC) == false) goto L6;
        return KVisibility.PUBLIC;
    L6:
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.PROTECTED) == false) goto L9;
        return KVisibility.PROTECTED;
    L9:
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.INTERNAL) == false) goto L12;
        return KVisibility.INTERNAL;
    L12:
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.PRIVATE) == true) goto L18;
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.PRIVATE_TO_THIS) == true) goto L18;
        return null;
    L18:
        return KVisibility.PRIVATE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List<? extends java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList, java.util.Collection] */
    private static final List<Annotation> unwrapRepeatableAnnotations(List<? extends Annotation> r7) {
        Iterable r0 = (Iterable) r7;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) r1.next())).getSimpleName(), "Container") == false) goto L9;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L24;
        r7 = new ArrayList();
        Iterator r3 = r0.iterator();
    L16:
        if (r3.hasNext() == false) goto L24;
        Annotation r4 = (Annotation) r3.next();
        Class r5 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r4));
        if (Intrinsics.areEqual(r5.getSimpleName(), "Container") == true) goto L20;
    L22:
        List r6 = CollectionsKt.listOf(r4);
    L23:
        CollectionsKt.addAll(r7, r6);
        goto L16
    L20:
        if (r5.getAnnotation(RepeatableContainer.class) == null) goto L22;
        Object r8 = r5.getDeclaredMethod("value", new Class[0]).invoke(r4, new Object[0]);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
        r6 = ArraysKt.asList((Annotation[]) r8);
    L24:
        return r7;
    L6:
        r2 = false;
        goto L13
    L5:
        if (((Collection) r0).isEmpty() == false) goto L7;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v16, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    private static final Object arrayToRuntimeValue(ArrayValue r6, ClassLoader r7) {
        if ((r6 instanceof TypedArrayValue) == false) goto L5;
        TypedArrayValue r0 = (TypedArrayValue) r6;
    L6:
        if (r0 == null) goto L77;
        KotlinType r1 = r0.getType();
        if (r1 == null) goto L77;
        Iterable r2 = (Iterable) r6.getValue();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.add(toRuntimeValue((ConstantValue) r4.next(), r7));
        goto L12
    L14:
        PrimitiveType r5 = KotlinBuiltIns.getPrimitiveArrayElementType(r1);
        if (r5 != null) goto L17;
        int r8 = -1;
    L18:
        int r9 = 0;
        switch(r8) {
            case -1: goto L47;
            case 0: goto L21;
            case 1: goto L43;
            case 2: goto L40;
            case 3: goto L37;
            case 4: goto L34;
            case 5: goto L31;
            case 6: goto L28;
            case 7: goto L25;
            case 8: goto L22;
            default: goto L21;
        };
    L22:
        int r10 = ((List) r6.getValue()).size();
        Object r11 = new double[r10];
    L23:
        if (r9 >= r10) goto L71;
        Object r12 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Double");
        r11[r9] = ((Double) r12).doubleValue();
        r9 = r9 + 1;
    L71:
        return r11;
    L25:
        int r13 = ((List) r6.getValue()).size();
        r11 = new long[r13];
    L26:
        if (r9 >= r13) goto L71;
        Object r14 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Long");
        r11[r9] = ((Long) r14).longValue();
        r9 = r9 + 1;
        goto L26
    L28:
        int r15 = ((List) r6.getValue()).size();
        r11 = new float[r15];
    L29:
        if (r9 >= r15) goto L71;
        Object r16 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Float");
        r11[r9] = ((Float) r16).floatValue();
        r9 = r9 + 1;
        goto L29
    L31:
        int r17 = ((List) r6.getValue()).size();
        r11 = new int[r17];
    L32:
        if (r9 >= r17) goto L71;
        Object r18 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Int");
        r11[r9] = ((Integer) r18).intValue();
        r9 = r9 + 1;
        goto L32
    L34:
        int r19 = ((List) r6.getValue()).size();
        r11 = new short[r19];
    L35:
        if (r9 >= r19) goto L71;
        Object r20 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Short");
        r11[r9] = ((Short) r20).shortValue();
        r9 = r9 + 1;
        goto L35
    L37:
        int r21 = ((List) r6.getValue()).size();
        r11 = new byte[r21];
    L38:
        if (r9 >= r21) goto L71;
        Object r22 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Byte");
        r11[r9] = ((Byte) r22).byteValue();
        r9 = r9 + 1;
        goto L38
    L40:
        int r23 = ((List) r6.getValue()).size();
        r11 = new char[r23];
    L41:
        if (r9 >= r23) goto L71;
        Object r24 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.Char");
        r11[r9] = ((Character) r24).charValue();
        r9 = r9 + 1;
        goto L41
    L43:
        int r25 = ((List) r6.getValue()).size();
        r11 = new boolean[r25];
    L44:
        if (r9 >= r25) goto L71;
        Object r26 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type kotlin.Boolean");
        r11[r9] = ((Boolean) r26).booleanValue();
        r9 = r9 + 1;
        goto L44
    L21:
        throw new NoWhenBranchMatchedException();
    L47:
        if (KotlinBuiltIns.isArray(r1) == false) goto L76;
        KotlinType r27 = ((TypeProjection) CollectionsKt.single(r1.getArguments())).getType();
        ClassifierDescriptor r28 = r27.getConstructor().getDeclarationDescriptor();
        if ((r28 instanceof ClassDescriptor) == false) goto L51;
        ClassDescriptor r29 = (ClassDescriptor) r28;
    L52:
        if (r29 == null) goto L74;
        if (KotlinBuiltIns.isString(r27) == false) goto L59;
        int r30 = ((List) r6.getValue()).size();
        r11 = new String[r30];
    L56:
        if (r9 >= r30) goto L71;
        Object r31 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type kotlin.String");
        r11[r9] = r31;
        r9 = r9 + 1;
        goto L56
    L59:
        if (KotlinBuiltIns.isKClass(r29) == false) goto L63;
        int r32 = ((List) r6.getValue()).size();
        r11 = new Class[r32];
    L61:
        if (r9 >= r32) goto L71;
        Object r33 = ListProtector.get(r3, r9);
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type java.lang.Class<*>");
        r11[r9] = r33;
        r9 = r9 + 1;
        goto L61
    L63:
        ClassId r34 = DescriptorUtilsKt.getClassId(r29);
        if (r34 == null) goto L72;
        Class r35 = loadClass$default(r7, r34, 0, 4, null);
        if (r35 == null) goto L72;
        Object r36 = Array.newInstance(r35, ((List) r6.getValue()).size());
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
        r11 = (Object[]) r36;
        int r37 = r3.size();
    L69:
        if (r9 >= r37) goto L71;
        r11[r9] = ListProtector.get(r3, r9);
        r9 = r9 + 1;
    L72:
        return null;
    L74:
        throw new IllegalStateException(("Not a class type: " + r27).toString());
    L51:
        r29 = null;
        goto L52
    L76:
        throw new IllegalStateException(("Not an array type: " + r1).toString());
    L17:
        r8 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
    L77:
        return null;
    L5:
        r0 = null;
        goto L6
    }

    public static final Field getDeclaredFieldOrNull(Class<?> r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        return r1.getDeclaredField(r2);
    L5:
        return null;
    }

    private static final Object toRuntimeValue(ConstantValue<?> r4, ClassLoader r5) {
        if ((r4 instanceof AnnotationValue) == false) goto L6;
        return toAnnotationInstance((AnnotationDescriptor) ((AnnotationValue) r4).getValue());
    L6:
        if ((r4 instanceof ArrayValue) == false) goto L9;
        return arrayToRuntimeValue((ArrayValue) r4, r5);
    L9:
        if ((r4 instanceof EnumValue) == false) goto L15;
        Pair r6 = (Pair) ((EnumValue) r4).getValue();
        ClassId r0 = (ClassId) r6.component1();
        Name r7 = (Name) r6.component2();
        Class r8 = loadClass$default(r5, r0, 0, 4, null);
        if (r8 == null) goto L39;
        return Util.getEnumConstantByName(r8, r7.asString());
    L39:
        return null;
    L15:
        if ((r4 instanceof KClassValue) == false) goto L30;
        KClassValue.Value.NormalClass r9 = (KClassValue.Value) ((KClassValue) r4).getValue();
        if ((r9 instanceof KClassValue.Value.NormalClass) == false) goto L20;
        KClassValue.Value.NormalClass r10 = r9;
        return loadClass(r5, r10.getClassId(), r10.getArrayDimensions());
    L20:
        if ((r9 instanceof KClassValue.Value.LocalClass) == false) goto L28;
        ClassifierDescriptor r11 = ((KClassValue.Value.LocalClass) r9).getType().getConstructor().getDeclarationDescriptor();
        if ((r11 instanceof ClassDescriptor) == false) goto L24;
        ClassDescriptor r12 = (ClassDescriptor) r11;
    L25:
        if (r12 == null) goto L39;
        return toJavaClass(r12);
    L24:
        r12 = null;
        goto L25
    L28:
        throw new NoWhenBranchMatchedException();
    L30:
        if ((r4 instanceof ErrorValue) == true) goto L39;
        if ((r4 instanceof NullValue) == true) goto L39;
        return r4.getValue();
    }

    public static final Method getDeclaredMethodOrNull(Class<?> r1, String r2, Class<?>... r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "parameterTypes");
        return r1.getDeclaredMethod(r2, (Class[]) Arrays.copyOf(r3, r3.length));
    L5:
        return null;
    }

    private static final Class<?> loadClass(ClassLoader r2, ClassId r3, int r4) {
        ClassId r0 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r3.asSingleFqName().toUnsafe());
        if (r0 == null) goto L7;
        r3 = r0;
    L7:
        return loadClass(r2, r3.getPackageFqName().asString(), r3.getRelativeClassName().asString(), r4);
    }

    private static final Class<?> loadClass(ClassLoader r7, String r8, String r9, int r10) {
        if (Intrinsics.areEqual(r8, "kotlin") == true) goto L5;
    L52:
        StringBuilder r0 = new StringBuilder();
        boolean r1 = false;
        if (r10 <= 0) goto L59;
        int r2 = 0;
    L55:
        if (r2 >= r10) goto L57;
        r0.append("[");
        r2 = r2 + 1;
        goto L55
    L57:
        r0.append("L");
    L59:
        if (r8.length() <= 0) goto L61;
        r1 = true;
    L61:
        if (r1 == false) goto L63;
        r0.append(r8 + '.');
    L63:
        r0.append(StringsKt.replace$default(r9, '.', '$', false, 4, null));
        if (r10 <= 0) goto L67;
        r0.append(";");
    L67:
        return ReflectJavaClassFinderKt.tryLoadClass(r7, r0.toString());
    L5:
        switch(r9.hashCode()) {
            case -901856463: goto L48;
            case -763279523: goto L43;
            case -755911549: goto L38;
            case -74930671: goto L33;
            case 22374632: goto L28;
            case 63537721: goto L23;
            case 601811914: goto L18;
            case 948852093: goto L13;
            case 2104330525: goto L8;
            default: goto L52;
        };
    L8:
        if (r9.equals("LongArray") == false) goto L52;
        return long[].class;
    L13:
        if (r9.equals("FloatArray") == false) goto L52;
        return float[].class;
    L18:
        if (r9.equals("IntArray") == false) goto L52;
        return int[].class;
    L23:
        if (r9.equals("Array") == false) goto L52;
        return Object[].class;
    L28:
        if (r9.equals("DoubleArray") == false) goto L52;
        return double[].class;
    L33:
        if (r9.equals("ByteArray") == false) goto L52;
        return byte[].class;
    L38:
        if (r9.equals("CharArray") == false) goto L52;
        return char[].class;
    L43:
        if (r9.equals("ShortArray") == false) goto L52;
        return short[].class;
    L48:
        if (r9.equals("BooleanArray") == false) goto L52;
        return boolean[].class;
    }

    public static /* synthetic */ Class loadClass$default(ClassLoader r0, ClassId r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return loadClass(r0, r1, r2);
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> r14, M r15, NameResolver r16, TypeTable r17, BinaryVersion r18, Function2<? super MemberDeserializer, ? super M, ? extends D> r19) {
        Intrinsics.checkNotNullParameter(r14, "moduleAnchor");
        Intrinsics.checkNotNullParameter(r15, "proto");
        Intrinsics.checkNotNullParameter(r16, "nameResolver");
        Intrinsics.checkNotNullParameter(r17, "typeTable");
        Intrinsics.checkNotNullParameter(r18, "metadataVersion");
        Intrinsics.checkNotNullParameter(r19, "createDescriptor");
        RuntimeModuleData r2 = ModuleByClassLoaderKt.getOrCreateModule(r14);
        if ((r15 instanceof ProtoBuf$Function) == false) goto L7;
        List<ProtoBuf$TypeParameter> r3 = ((ProtoBuf$Function) r15).getTypeParameterList();
    L5:
        List<ProtoBuf$TypeParameter> r12 = r3;
        DeserializationComponents r4 = r2.getDeserialization();
        ModuleDescriptor r6 = r2.getModule();
        VersionRequirementTable r8 = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkNotNull(r12);
        return (D) r19.invoke(new MemberDeserializer(new DeserializationContext(r4, r16, r6, r17, r8, r18, null, null, r12)), r15);
    L7:
        if ((r15 instanceof ProtoBuf$Property) == false) goto L12;
        r3 = ((ProtoBuf$Property) r15).getTypeParameterList();
        goto L5
    L12:
        throw new IllegalStateException(("Unsupported message: " + r15).toString());
    }
}
