package kotlin.reflect.jvm.internal;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
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
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
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
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class UtilKt {
    private static final FqName JVM_STATIC = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[PrimitiveType.values().length];
            r10[PrimitiveType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r10[PrimitiveType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r10[PrimitiveType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r10[PrimitiveType.SHORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r10[PrimitiveType.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r10[PrimitiveType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r10[PrimitiveType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r10[PrimitiveType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v16, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    private static final Object arrayToRuntimeValue(ArrayValue r10, ClassLoader r11) {
        if ((r10 instanceof DeserializedArrayValue) == false) goto L5;
        DeserializedArrayValue r12 = (DeserializedArrayValue) r10;
    L6:
        if (r12 == null) goto L77;
        KotlinType r13 = r12.getType();
        if (r13 == null) goto L77;
        List<? extends ConstantValue<?>> r14 = r10.getValue();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r15.add(toRuntimeValue((ConstantValue) r16.next(), r11));
        goto L12
    L14:
        PrimitiveType r17 = KotlinBuiltIns.getPrimitiveArrayElementType(r13);
        if (r17 != null) goto L17;
        int r18 = -1;
    L18:
        int r19 = 0;
        switch(r18) {
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
        int r20 = r10.getValue().size();
        Object r21 = new double[r20];
    L23:
        if (r19 >= r20) goto L71;
        Object r22 = r15.get(r19);
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Double");
        r21[r19] = ((Double) r22).doubleValue();
        r19 = r19 + 1;
    L71:
        return r21;
    L25:
        int r23 = r10.getValue().size();
        r21 = new long[r23];
    L26:
        if (r19 >= r23) goto L71;
        Object r24 = r15.get(r19);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.Long");
        r21[r19] = ((Long) r24).longValue();
        r19 = r19 + 1;
        goto L26
    L28:
        int r25 = r10.getValue().size();
        r21 = new float[r25];
    L29:
        if (r19 >= r25) goto L71;
        Object r26 = r15.get(r19);
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type kotlin.Float");
        r21[r19] = ((Float) r26).floatValue();
        r19 = r19 + 1;
        goto L29
    L31:
        int r27 = r10.getValue().size();
        r21 = new int[r27];
    L32:
        if (r19 >= r27) goto L71;
        Object r28 = r15.get(r19);
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type kotlin.Int");
        r21[r19] = ((Integer) r28).intValue();
        r19 = r19 + 1;
        goto L32
    L34:
        int r29 = r10.getValue().size();
        r21 = new short[r29];
    L35:
        if (r19 >= r29) goto L71;
        Object r30 = r15.get(r19);
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type kotlin.Short");
        r21[r19] = ((Short) r30).shortValue();
        r19 = r19 + 1;
        goto L35
    L37:
        int r31 = r10.getValue().size();
        r21 = new byte[r31];
    L38:
        if (r19 >= r31) goto L71;
        Object r32 = r15.get(r19);
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type kotlin.Byte");
        r21[r19] = ((Byte) r32).byteValue();
        r19 = r19 + 1;
        goto L38
    L40:
        int r33 = r10.getValue().size();
        r21 = new char[r33];
    L41:
        if (r19 >= r33) goto L71;
        Object r34 = r15.get(r19);
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type kotlin.Char");
        r21[r19] = ((Character) r34).charValue();
        r19 = r19 + 1;
        goto L41
    L43:
        int r35 = r10.getValue().size();
        r21 = new boolean[r35];
    L44:
        if (r19 >= r35) goto L71;
        Object r36 = r15.get(r19);
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type kotlin.Boolean");
        r21[r19] = ((Boolean) r36).booleanValue();
        r19 = r19 + 1;
        goto L44
    L21:
        throw new NoWhenBranchMatchedException();
    L47:
        if (KotlinBuiltIns.isArray(r13) == false) goto L76;
        KotlinType r37 = ((TypeProjection) CollectionsKt.single(r13.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(r37, "type.arguments.single().type");
        ClassifierDescriptor r38 = r37.getConstructor().mo1323getDeclarationDescriptor();
        if ((r38 instanceof ClassDescriptor) == false) goto L51;
        ClassDescriptor r39 = (ClassDescriptor) r38;
    L52:
        if (r39 == null) goto L74;
        if (KotlinBuiltIns.isString(r37) == false) goto L59;
        int r40 = r10.getValue().size();
        r21 = new String[r40];
    L56:
        if (r19 >= r40) goto L71;
        Object r41 = r15.get(r19);
        Intrinsics.checkNotNull(r41, "null cannot be cast to non-null type kotlin.String");
        r21[r19] = (String) r41;
        r19 = r19 + 1;
        goto L56
    L59:
        if (KotlinBuiltIns.isKClass(r39) == false) goto L63;
        int r42 = r10.getValue().size();
        r21 = new Class[r42];
    L61:
        if (r19 >= r42) goto L71;
        Object r43 = r15.get(r19);
        Intrinsics.checkNotNull(r43, "null cannot be cast to non-null type java.lang.Class<*>");
        r21[r19] = (Class) r43;
        r19 = r19 + 1;
        goto L61
    L63:
        ClassId r44 = DescriptorUtilsKt.getClassId(r39);
        if (r44 == null) goto L72;
        Class r45 = loadClass$default(r11, r44, 0, 4, null);
        if (r45 == null) goto L72;
        Object r46 = Array.newInstance(r45, r10.getValue().size());
        Intrinsics.checkNotNull(r46, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
        r21 = (Object[]) r46;
        int r47 = r15.size();
    L69:
        if (r19 >= r47) goto L71;
        r21[r19] = r15.get(r19);
        r19 = r19 + 1;
    L72:
        return null;
    L74:
        throw new IllegalStateException(("Not a class type: " + r37).toString());
    L51:
        r39 = null;
        goto L52
    L76:
        throw new IllegalStateException(("Not an array type: " + r13).toString());
    L17:
        r18 = WhenMappings.$EnumSwitchMapping$0[r17.ordinal()];
    L77:
        return null;
    L5:
        r12 = null;
        goto L6
    }

    public static final KCallableImpl<?> asKCallableImpl(Object r10) {
        if ((r10 instanceof KCallableImpl) == false) goto L5;
        KCallableImpl<?> r11 = (KCallableImpl) r10;
    L6:
        if (r11 != null) goto L12;
        KFunctionImpl r12 = asKFunctionImpl(r10);
        if (r12 == null) goto L11;
        return r12;
    L11:
        return asKPropertyImpl(r10);
    L12:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public static final KFunctionImpl asKFunctionImpl(Object r10) {
        if ((r10 instanceof KFunctionImpl) == false) goto L5;
        KFunctionImpl r11 = (KFunctionImpl) r10;
    L6:
        if (r11 != null) goto L18;
        if ((r10 instanceof FunctionReference) == false) goto L10;
        FunctionReference r12 = (FunctionReference) r10;
    L11:
        if (r12 == null) goto L13;
        KCallable r13 = r12.compute();
    L15:
        if ((r13 instanceof KFunctionImpl) == true) goto L20;
        return null;
    L20:
        return (KFunctionImpl) r13;
    L13:
        r13 = null;
        goto L15
    L10:
        r12 = null;
        goto L11
    L18:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object r10) {
        if ((r10 instanceof KPropertyImpl) == false) goto L5;
        KPropertyImpl<?> r11 = (KPropertyImpl) r10;
    L6:
        if (r11 != null) goto L18;
        if ((r10 instanceof PropertyReference) == false) goto L10;
        PropertyReference r12 = (PropertyReference) r10;
    L11:
        if (r12 == null) goto L13;
        KCallable r13 = r12.compute();
    L15:
        if ((r13 instanceof KPropertyImpl) == true) goto L20;
        return null;
    L20:
        return (KPropertyImpl) r13;
    L13:
        r13 = null;
        goto L15
    L10:
        r12 = null;
        goto L11
    L18:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public static final List<Annotation> computeAnnotations(Annotated r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Annotations r11 = r10.getAnnotations();
        ArrayList r12 = new ArrayList();
        Iterator<AnnotationDescriptor> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L20;
        AnnotationDescriptor r14 = r13.next();
        SourceElement r15 = r14.getSource();
        Annotation r16 = null;
        if ((r15 instanceof ReflectAnnotationSource) == false) goto L9;
        r16 = ((ReflectAnnotationSource) r15).getAnnotation();
    L17:
        if (r16 == null) goto L4;
        r12.add(r16);
        goto L4
    L9:
        if ((r15 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L16;
        ReflectJavaElement r17 = ((RuntimeSourceElementFactory.RuntimeSourceElement) r15).getJavaElement();
        if ((r17 instanceof ReflectJavaAnnotation) == false) goto L13;
        ReflectJavaAnnotation r18 = (ReflectJavaAnnotation) r17;
    L14:
        if (r18 == null) goto L17;
        r16 = r18.getAnnotation();
        goto L17
    L13:
        r18 = null;
        goto L14
    L16:
        r16 = toAnnotationInstance(r14);
        goto L17
    L20:
        return unwrapRepeatableAnnotations(r12);
    }

    public static final Class<?> createArrayType(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Array.newInstance(r10, 0).getClass();
    }

    public static final Object defaultPrimitiveValue(Type r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if ((r10 instanceof Class) == true) goto L5;
    L36:
        return null;
    L5:
        if (((Class) r10).isPrimitive() == false) goto L36;
        if (Intrinsics.areEqual(r10, Boolean.TYPE) == false) goto L10;
        return Boolean.FALSE;
    L10:
        if (Intrinsics.areEqual(r10, Character.TYPE) == false) goto L13;
        return (char) 0;
    L13:
        if (Intrinsics.areEqual(r10, Byte.TYPE) == false) goto L16;
        return (byte) 0;
    L16:
        if (Intrinsics.areEqual(r10, Short.TYPE) == false) goto L19;
        return (short) 0;
    L19:
        if (Intrinsics.areEqual(r10, Integer.TYPE) == false) goto L22;
        return 0;
    L22:
        if (Intrinsics.areEqual(r10, Float.TYPE) == false) goto L25;
        return Float.valueOf(0.0f);
    L25:
        if (Intrinsics.areEqual(r10, Long.TYPE) == false) goto L28;
        return 0L;
    L28:
        if (Intrinsics.areEqual(r10, Double.TYPE) == false) goto L31;
        return Double.valueOf(0.0d);
    L31:
        if (Intrinsics.areEqual(r10, Void.TYPE) == false) goto L35;
        throw new IllegalStateException("Parameter with void type is illegal");
    L35:
        throw new UnsupportedOperationException("Unknown primitive: " + r10);
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> r14, M r15, NameResolver r16, TypeTable r17, BinaryVersion r18, Function2<? super MemberDeserializer, ? super M, ? extends D> r19) {
        Intrinsics.checkNotNullParameter(r14, "moduleAnchor");
        Intrinsics.checkNotNullParameter(r15, "proto");
        Intrinsics.checkNotNullParameter(r16, "nameResolver");
        Intrinsics.checkNotNullParameter(r17, "typeTable");
        Intrinsics.checkNotNullParameter(r18, "metadataVersion");
        Intrinsics.checkNotNullParameter(r19, "createDescriptor");
        RuntimeModuleData r10 = ModuleByClassLoaderKt.getOrCreateModule(r14);
        if ((r15 instanceof ProtoBuf.Function) == false) goto L7;
        List<ProtoBuf.TypeParameter> r11 = ((ProtoBuf.Function) r15).getTypeParameterList();
    L5:
        List<ProtoBuf.TypeParameter> r12 = r11;
        DeserializationComponents r13 = r10.getDeserialization();
        ModuleDescriptor r20 = r10.getModule();
        VersionRequirementTable r21 = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkNotNullExpressionValue(r12, "typeParameters");
        return r19.invoke(new MemberDeserializer(new DeserializationContext(r13, r16, r20, r17, r21, r18, null, null, r12)), r15);
    L7:
        if ((r15 instanceof ProtoBuf.Property) == false) goto L12;
        r11 = ((ProtoBuf.Property) r15).getTypeParameterList();
        goto L5
    L12:
        throw new IllegalStateException(("Unsupported message: " + r15).toString());
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getDispatchReceiverParameter() == null) goto L5;
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) r11).getThisAsReceiverParameter();
    L5:
        return null;
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final boolean isInlineClassType(KType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KTypeImpl) == false) goto L5;
        KTypeImpl r11 = (KTypeImpl) r10;
    L7:
        if (r11 == null) goto L14;
        KotlinType r12 = r11.getType();
        if (r12 == null) goto L14;
        if (InlineClassesUtilsKt.isInlineClassType(r12) != true) goto L14;
        return true;
    L14:
        return false;
    L5:
        r11 = null;
        goto L7
    }

    private static final Class<?> loadClass(ClassLoader r10, String r11, String r12, int r13) {
        if (Intrinsics.areEqual(r11, "kotlin") == true) goto L5;
    L52:
        String r14 = r11 + '.' + StringsKt.replace$default(r12, '.', Typography.dollar, false, 4, null);
        if (r13 <= 0) goto L56;
        r14 = StringsKt.repeat("[", r13) + 'L' + r14 + ';';
    L56:
        return ReflectJavaClassFinderKt.tryLoadClass(r10, r14);
    L5:
        switch(r12.hashCode()) {
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
        if (r12.equals("LongArray") == false) goto L52;
        return long[].class;
    L13:
        if (r12.equals("FloatArray") == false) goto L52;
        return float[].class;
    L18:
        if (r12.equals("IntArray") == false) goto L52;
        return int[].class;
    L23:
        if (r12.equals("Array") == false) goto L52;
        return Object[].class;
    L28:
        if (r12.equals("DoubleArray") == false) goto L52;
        return double[].class;
    L33:
        if (r12.equals("ByteArray") == false) goto L52;
        return byte[].class;
    L38:
        if (r12.equals("CharArray") == false) goto L52;
        return char[].class;
    L43:
        if (r12.equals("ShortArray") == false) goto L52;
        return short[].class;
    L48:
        if (r12.equals("BooleanArray") == false) goto L52;
        return boolean[].class;
    }

    private static final Class<?> loadClass(ClassLoader r10, ClassId r11, int r12) {
        JavaToKotlinClassMap r13 = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe r14 = r11.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r14, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId r15 = r13.mapKotlinToJava(r14);
        if (r15 == null) goto L6;
        r11 = r15;
    L6:
        String r16 = r11.getPackageFqName().asString();
        Intrinsics.checkNotNullExpressionValue(r16, "javaClassId.packageFqName.asString()");
        String r17 = r11.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r17, "javaClassId.relativeClassName.asString()");
        return loadClass(r10, r16, r17, r12);
    }

    static /* synthetic */ Class loadClass$default(ClassLoader r10, ClassId r11, int r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = 0;
    L6:
        return loadClass(r10, r11, r12);
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor r10) {
        ClassDescriptor r11 = DescriptorUtilsKt.getAnnotationClass(r10);
        if (r11 == null) goto L5;
        Class<?> r12 = toJavaClass(r11);
    L7:
        if ((r12 instanceof Class) == true) goto L10;
        r12 = null;
    L10:
        if (r12 != null) goto L12;
        return null;
    L12:
        Set<Map.Entry<Name, ConstantValue<?>>> r13 = r10.getAllValueArguments().entrySet();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L14:
        if (r15.hasNext() == false) goto L22;
        Map.Entry r16 = (Map.Entry) r15.next();
        Name r17 = (Name) r16.getKey();
        ConstantValue r18 = (ConstantValue) r16.getValue();
        ClassLoader r19 = r12.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(r19, "annotationClass.classLoader");
        Object r20 = toRuntimeValue(r18, r19);
        if (r20 == null) goto L18;
        Pair r21 = TuplesKt.to(r17.asString(), r20);
    L19:
        if (r21 == null) goto L14;
        r14.add(r21);
        goto L14
    L18:
        r21 = null;
        goto L19
    L22:
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(r12, MapsKt.toMap(r14), null, 4, null);
    L5:
        r12 = null;
        goto L7
    }

    public static final Class<?> toJavaClass(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SourceElement r11 = r10.getSource();
        Intrinsics.checkNotNullExpressionValue(r11, "source");
        if ((r11 instanceof KotlinJvmBinarySourceElement) == false) goto L6;
        KotlinJvmBinaryClass r12 = ((KotlinJvmBinarySourceElement) r11).getBinaryClass();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        return ((ReflectKotlinClass) r12).getKlass();
    L6:
        if ((r11 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L8;
        ReflectJavaElement r13 = ((RuntimeSourceElementFactory.RuntimeSourceElement) r11).getJavaElement();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        return ((ReflectJavaClass) r13).getElement();
    L8:
        ClassId r14 = DescriptorUtilsKt.getClassId(r10);
        if (r14 != null) goto L13;
        return null;
    L13:
        return loadClass(ReflectClassUtilKt.getSafeClassLoader(r10.getClass()), r14, 0);
    }

    public static final KVisibility toKVisibility(DescriptorVisibility r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10, DescriptorVisibilities.PUBLIC) == false) goto L6;
        return KVisibility.PUBLIC;
    L6:
        if (Intrinsics.areEqual(r10, DescriptorVisibilities.PROTECTED) == false) goto L9;
        return KVisibility.PROTECTED;
    L9:
        if (Intrinsics.areEqual(r10, DescriptorVisibilities.INTERNAL) == false) goto L12;
        return KVisibility.INTERNAL;
    L12:
        if (Intrinsics.areEqual(r10, DescriptorVisibilities.PRIVATE) == false) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == true) goto L22;
        return null;
    L22:
        return KVisibility.PRIVATE;
    L14:
        r11 = Intrinsics.areEqual(r10, DescriptorVisibilities.PRIVATE_TO_THIS);
        goto L15
    }

    private static final Object toRuntimeValue(ConstantValue<?> r10, ClassLoader r11) {
        if ((r10 instanceof AnnotationValue) == false) goto L6;
        return toAnnotationInstance(((AnnotationValue) r10).getValue());
    L6:
        if ((r10 instanceof ArrayValue) == false) goto L9;
        return arrayToRuntimeValue((ArrayValue) r10, r11);
    L9:
        if ((r10 instanceof EnumValue) == false) goto L14;
        Pair<? extends ClassId, ? extends Name> r12 = ((EnumValue) r10).getValue();
        ClassId r13 = r12.component1();
        Name r14 = r12.component2();
        Class r15 = loadClass$default(r11, r13, 0, 4, null);
        if (r15 != null) goto L39;
        return null;
    L39:
        return Util.getEnumConstantByName(r15, r14.asString());
    L14:
        if ((r10 instanceof KClassValue) == false) goto L29;
        KClassValue.Value r16 = ((KClassValue) r10).getValue();
        if ((r16 instanceof KClassValue.Value.NormalClass) == false) goto L19;
        KClassValue.Value.NormalClass r17 = (KClassValue.Value.NormalClass) r16;
        return loadClass(r11, r17.getClassId(), r17.getArrayDimensions());
    L19:
        if ((r16 instanceof KClassValue.Value.LocalClass) == false) goto L27;
        ClassifierDescriptor r18 = ((KClassValue.Value.LocalClass) r16).getType().getConstructor().mo1323getDeclarationDescriptor();
        if ((r18 instanceof ClassDescriptor) == false) goto L23;
        ClassDescriptor r19 = (ClassDescriptor) r18;
    L24:
        if (r19 != null) goto L42;
        return null;
    L42:
        return toJavaClass(r19);
    L23:
        r19 = null;
        goto L24
    L27:
        throw new NoWhenBranchMatchedException();
    L29:
        if ((r10 instanceof ErrorValue) == false) goto L31;
        boolean r20 = true;
    L32:
        if (r20 == false) goto L35;
        return null;
    L35:
        return r10.getValue();
    L31:
        r20 = r10 instanceof NullValue;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Annotation> unwrapRepeatableAnnotations(List<? extends Annotation> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L6;
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) r11.next())).getSimpleName(), "Container") == false) goto L9;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L32;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.iterator();
    L16:
        if (r14.hasNext() == false) goto L25;
        Annotation r15 = (Annotation) r14.next();
        Class r16 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r15));
        if (Intrinsics.areEqual(r16.getSimpleName(), "Container") == true) goto L20;
    L22:
        List r17 = CollectionsKt.listOf(r15);
    L23:
        CollectionsKt.addAll(r13, r17);
        goto L16
    L20:
        if (r16.getAnnotation(RepeatableContainer.class) == null) goto L22;
        Object r18 = r16.getDeclaredMethod(EventBody.KEY_VALUE, new Class[0]).invoke(r15, new Object[0]);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
        r17 = ArraysKt.asList((Annotation[]) r18);
        goto L23
    L25:
        return r13;
    L32:
        return r10;
    L6:
        r12 = false;
        goto L13
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L6
    }
}
