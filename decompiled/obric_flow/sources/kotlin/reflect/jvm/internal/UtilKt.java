package kotlin.reflect.jvm.internal;

import ai.j0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001al\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0012*\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001f¢\u0006\u0002\b!H\u0000¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002\u001a(\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020*H\u0002\u001a%\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\bø\u0001\u0000¢\u0006\u0002\u00101\u001a\u0016\u00102\u001a\u0004\u0018\u00010\u000e*\u0002032\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0014\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u00106\u001a\u0004\u0018\u000107*\u0004\u0018\u00010\u000eH\u0000\u001a\u0014\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000109*\u0004\u0018\u00010\u000eH\u0000\u001a\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;*\u00020=H\u0000\u001a\u0014\u0010>\u001a\u0006\u0012\u0002\b\u00030\u0016*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001a\u000e\u0010?\u001a\u0004\u0018\u00010<*\u00020@H\u0002\u001a\u0012\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020BH\u0000\u001a\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020EH\u0000\u001a\u001a\u0010F\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030G2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020<0;*\b\u0012\u0004\u0012\u00020<0;H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", "", "type", "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "unwrapRepeatableAnnotations", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nutil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,311:1\n1603#2,9:312\n1855#2:321\n1856#2:323\n1612#2:324\n1747#2,3:325\n1360#2:328\n1446#2,5:329\n1603#2,9:334\n1855#2:343\n1856#2:346\n1612#2:347\n1549#2:348\n1620#2,3:349\n1#3:322\n1#3:344\n1#3:345\n1#3:352\n*S KotlinDebug\n*F\n+ 1 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n*L\n131#1:312,9\n131#1:321\n131#1:323\n131#1:324\n140#1:325,3\n141#1:328\n141#1:329,5\n161#1:334,9\n161#1:343\n161#1:346\n161#1:347\n191#1:348\n191#1:349,3\n131#1:322\n161#1:345\n*E\n"})
public final class UtilKt {
    private static final FqName JVM_STATIC = null;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[PrimitiveType.values().length];
            r5[PrimitiveType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r5[PrimitiveType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r5[PrimitiveType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r5[PrimitiveType.SHORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r5[PrimitiveType.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r5[PrimitiveType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r5[PrimitiveType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r5[PrimitiveType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r5;
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
        if ((r10 instanceof TypedArrayValue) == false) goto L5;
        TypedArrayValue r5 = (TypedArrayValue) r10;
    L6:
        if (r5 == null) goto L77;
        KotlinType r12 = r5.getType();
        if (r12 == null) goto L77;
        List<? extends ConstantValue<?>> r13 = r10.getValue();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r14.add(toRuntimeValue((ConstantValue) r15.next(), r11));
        goto L12
    L14:
        PrimitiveType r16 = KotlinBuiltIns.getPrimitiveArrayElementType(r12);
        if (r16 != null) goto L17;
        int r17 = -1;
    L18:
        int r18 = 0;
        switch(r17) {
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
        int r19 = r10.getValue().size();
        Object r20 = new double[r19];
    L23:
        if (r18 >= r19) goto L71;
        Object r21 = r14.get(r18);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Double");
        r20[r18] = ((Double) r21).doubleValue();
        r18 = r18 + 1;
    L71:
        return r20;
    L25:
        int r22 = r10.getValue().size();
        r20 = new long[r22];
    L26:
        if (r18 >= r22) goto L71;
        Object r23 = r14.get(r18);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Long");
        r20[r18] = ((Long) r23).longValue();
        r18 = r18 + 1;
        goto L26
    L28:
        int r24 = r10.getValue().size();
        r20 = new float[r24];
    L29:
        if (r18 >= r24) goto L71;
        Object r25 = r14.get(r18);
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.Float");
        r20[r18] = ((Float) r25).floatValue();
        r18 = r18 + 1;
        goto L29
    L31:
        int r26 = r10.getValue().size();
        r20 = new int[r26];
    L32:
        if (r18 >= r26) goto L71;
        Object r27 = r14.get(r18);
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type kotlin.Int");
        r20[r18] = ((Integer) r27).intValue();
        r18 = r18 + 1;
        goto L32
    L34:
        int r28 = r10.getValue().size();
        r20 = new short[r28];
    L35:
        if (r18 >= r28) goto L71;
        Object r29 = r14.get(r18);
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type kotlin.Short");
        r20[r18] = ((Short) r29).shortValue();
        r18 = r18 + 1;
        goto L35
    L37:
        int r30 = r10.getValue().size();
        r20 = new byte[r30];
    L38:
        if (r18 >= r30) goto L71;
        Object r31 = r14.get(r18);
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type kotlin.Byte");
        r20[r18] = ((Byte) r31).byteValue();
        r18 = r18 + 1;
        goto L38
    L40:
        int r32 = r10.getValue().size();
        r20 = new char[r32];
    L41:
        if (r18 >= r32) goto L71;
        Object r33 = r14.get(r18);
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type kotlin.Char");
        r20[r18] = ((Character) r33).charValue();
        r18 = r18 + 1;
        goto L41
    L43:
        int r34 = r10.getValue().size();
        r20 = new boolean[r34];
    L44:
        if (r18 >= r34) goto L71;
        Object r35 = r14.get(r18);
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type kotlin.Boolean");
        r20[r18] = ((Boolean) r35).booleanValue();
        r18 = r18 + 1;
        goto L44
    L21:
        throw new NoWhenBranchMatchedException();
    L47:
        if (KotlinBuiltIns.isArray(r12) == false) goto L76;
        KotlinType r36 = ((TypeProjection) CollectionsKt.single(r12.getArguments())).getType();
        ClassifierDescriptor r37 = r36.getConstructor().mo1402getDeclarationDescriptor();
        if ((r37 instanceof ClassDescriptor) == false) goto L51;
        ClassDescriptor r38 = (ClassDescriptor) r37;
    L52:
        if (r38 == null) goto L74;
        if (KotlinBuiltIns.isString(r36) == false) goto L59;
        int r39 = r10.getValue().size();
        r20 = new String[r39];
    L56:
        if (r18 >= r39) goto L71;
        Object r40 = r14.get(r18);
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type kotlin.String");
        r20[r18] = r40;
        r18 = r18 + 1;
        goto L56
    L59:
        if (KotlinBuiltIns.isKClass(r38) == false) goto L63;
        int r41 = r10.getValue().size();
        r20 = new Class[r41];
    L61:
        if (r18 >= r41) goto L71;
        Object r42 = r14.get(r18);
        Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type java.lang.Class<*>");
        r20[r18] = r42;
        r18 = r18 + 1;
        goto L61
    L63:
        ClassId r43 = DescriptorUtilsKt.getClassId(r38);
        if (r43 == null) goto L72;
        Class r44 = loadClass$default(r11, r43, 0, 4, null);
        if (r44 == null) goto L72;
        Object r45 = Array.newInstance(r44, r10.getValue().size());
        Intrinsics.checkNotNull(r45, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
        r20 = (Object[]) r45;
        int r46 = r14.size();
    L69:
        if (r18 >= r46) goto L71;
        r20[r18] = r14.get(r18);
        r18 = r18 + 1;
    L72:
        return null;
    L74:
        throw new IllegalStateException(("Not a class type: " + r36).toString());
    L51:
        r38 = null;
        goto L52
    L76:
        throw new IllegalStateException(("Not an array type: " + r12).toString());
    L17:
        r17 = WhenMappings.$EnumSwitchMapping$0[r16.ordinal()];
    L77:
        return null;
    L5:
        r5 = null;
        goto L6
    }

    public static final KCallableImpl<?> asKCallableImpl(Object r5) {
        if ((r5 instanceof KCallableImpl) == false) goto L5;
        KCallableImpl<?> r10 = (KCallableImpl) r5;
    L6:
        if (r10 != null) goto L12;
        KFunctionImpl r11 = asKFunctionImpl(r5);
        if (r11 == null) goto L11;
        return r11;
    L11:
        return asKPropertyImpl(r5);
    L12:
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    public static final KFunctionImpl asKFunctionImpl(Object r5) {
        if ((r5 instanceof KFunctionImpl) == false) goto L5;
        KFunctionImpl r10 = (KFunctionImpl) r5;
    L6:
        if (r10 != null) goto L18;
        if ((r5 instanceof FunctionReference) == false) goto L10;
        FunctionReference r11 = (FunctionReference) r5;
    L11:
        if (r11 == null) goto L13;
        KCallable r12 = r11.compute();
    L15:
        if ((r12 instanceof KFunctionImpl) == true) goto L20;
        return null;
    L20:
        return (KFunctionImpl) r12;
    L13:
        r12 = null;
        goto L15
    L10:
        r11 = null;
        goto L11
    L18:
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object r5) {
        if ((r5 instanceof KPropertyImpl) == false) goto L5;
        KPropertyImpl<?> r10 = (KPropertyImpl) r5;
    L6:
        if (r10 != null) goto L18;
        if ((r5 instanceof PropertyReference) == false) goto L10;
        PropertyReference r11 = (PropertyReference) r5;
    L11:
        if (r11 == null) goto L13;
        KCallable r12 = r11.compute();
    L15:
        if ((r12 instanceof KPropertyImpl) == true) goto L20;
        return null;
    L20:
        return (KPropertyImpl) r12;
    L13:
        r12 = null;
        goto L15
    L10:
        r11 = null;
        goto L11
    L18:
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    public static final List<Annotation> computeAnnotations(Annotated r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Annotations r10 = r5.getAnnotations();
        ArrayList r11 = new ArrayList();
        Iterator<AnnotationDescriptor> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        AnnotationDescriptor r13 = r12.next();
        SourceElement r14 = r13.getSource();
        if ((r14 instanceof ReflectAnnotationSource) == false) goto L9;
        Annotation r15 = ((ReflectAnnotationSource) r14).getAnnotation();
    L18:
        if (r15 == null) goto L4;
        r11.add(r15);
        goto L4
    L9:
        if ((r14 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L17;
        ReflectJavaElement r16 = ((RuntimeSourceElementFactory.RuntimeSourceElement) r14).getJavaElement();
        if ((r16 instanceof ReflectJavaAnnotation) == false) goto L13;
        ReflectJavaAnnotation r17 = (ReflectJavaAnnotation) r16;
    L14:
        if (r17 == null) goto L16;
        r15 = r17.getAnnotation();
        goto L18
    L16:
        r15 = null;
        goto L18
    L13:
        r17 = null;
        goto L14
    L17:
        r15 = toAnnotationInstance(r13);
        goto L18
    L21:
        return unwrapRepeatableAnnotations(r11);
    }

    public static final Class<?> createArrayType(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Array.newInstance(r5, 0).getClass();
    }

    public static final Object defaultPrimitiveValue(Type r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if ((r5 instanceof Class) == true) goto L5;
    L36:
        return null;
    L5:
        if (((Class) r5).isPrimitive() == false) goto L36;
        if (Intrinsics.areEqual(r5, Boolean.TYPE) == false) goto L10;
        return Boolean.FALSE;
    L10:
        if (Intrinsics.areEqual(r5, Character.TYPE) == false) goto L13;
        return (char) 0;
    L13:
        if (Intrinsics.areEqual(r5, Byte.TYPE) == false) goto L16;
        return (byte) 0;
    L16:
        if (Intrinsics.areEqual(r5, Short.TYPE) == false) goto L19;
        return (short) 0;
    L19:
        if (Intrinsics.areEqual(r5, Integer.TYPE) == false) goto L22;
        return 0;
    L22:
        if (Intrinsics.areEqual(r5, Float.TYPE) == false) goto L25;
        return Float.valueOf(0.0f);
    L25:
        if (Intrinsics.areEqual(r5, Long.TYPE) == false) goto L28;
        return 0L;
    L28:
        if (Intrinsics.areEqual(r5, Double.TYPE) == false) goto L31;
        return Double.valueOf(0.0d);
    L31:
        if (Intrinsics.areEqual(r5, Void.TYPE) == false) goto L35;
        throw new IllegalStateException("Parameter with void type is illegal");
    L35:
        throw new UnsupportedOperationException(j0.m("Unknown primitive: ", r5));
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> r14, M r15, NameResolver r16, TypeTable r17, BinaryVersion r18, Function2<? super MemberDeserializer, ? super M, ? extends D> r19) {
        Intrinsics.checkNotNullParameter(r14, "moduleAnchor");
        Intrinsics.checkNotNullParameter(r15, "proto");
        Intrinsics.checkNotNullParameter(r16, "nameResolver");
        Intrinsics.checkNotNullParameter(r17, "typeTable");
        Intrinsics.checkNotNullParameter(r18, "metadataVersion");
        Intrinsics.checkNotNullParameter(r19, "createDescriptor");
        RuntimeModuleData r5 = ModuleByClassLoaderKt.getOrCreateModule(r14);
        if ((r15 instanceof ProtoBuf.Function) == false) goto L7;
        List<ProtoBuf.TypeParameter> r10 = ((ProtoBuf.Function) r15).getTypeParameterList();
    L10:
        return r19.mo2invoke(new MemberDeserializer(new DeserializationContext(r5.getDeserialization(), r16, r5.getModule(), r17, VersionRequirementTable.Companion.getEMPTY(), r18, null, null, r10)), r15);
    L7:
        if ((r15 instanceof ProtoBuf.Property) == false) goto L12;
        r10 = ((ProtoBuf.Property) r15).getTypeParameterList();
        goto L10
    L12:
        throw new IllegalStateException(("Unsupported message: " + r15).toString());
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getDispatchReceiverParameter() == null) goto L5;
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) r10).getThisAsReceiverParameter();
    L5:
        return null;
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final boolean isInlineClassType(KType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KTypeImpl) == false) goto L5;
        KTypeImpl r10 = (KTypeImpl) r5;
    L7:
        if (r10 == null) goto L14;
        KotlinType r11 = r10.getType();
        if (r11 != null) goto L11;
        return false;
    L11:
        if (InlineClassesUtilsKt.isInlineClassType(r11) == true) goto L13;
        return false;
    L13:
        return true;
    L14:
        return false;
    L5:
        r10 = null;
        goto L7
    }

    private static final Class<?> loadClass(ClassLoader r5, ClassId r10, int r11) {
        ClassId r12 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r10.asSingleFqName().toUnsafe());
        if (r12 == null) goto L7;
        r10 = r12;
    L7:
        return loadClass(r5, r10.getPackageFqName().asString(), r10.getRelativeClassName().asString(), r11);
    }

    public static /* synthetic */ Class loadClass$default(ClassLoader r5, ClassId r10, int r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = 0;
    L6:
        return loadClass(r5, r10, r11);
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor r10) {
        ClassDescriptor r5 = DescriptorUtilsKt.getAnnotationClass(r10);
        if (r5 == null) goto L5;
        Class<?> r11 = toJavaClass(r5);
    L6:
        if (r11 != null) goto L9;
        r11 = null;
    L9:
        if (r11 != null) goto L11;
        return null;
    L11:
        Set<Map.Entry<Name, ConstantValue<?>>> r12 = r10.getAllValueArguments().entrySet();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L21;
        Map.Entry r15 = (Map.Entry) r14.next();
        Name r16 = (Name) r15.getKey();
        Object r17 = toRuntimeValue((ConstantValue) r15.getValue(), r11.getClassLoader());
        if (r17 == null) goto L17;
        Pair r18 = TuplesKt.to(r16.asString(), r17);
    L18:
        if (r18 == null) goto L13;
        r13.add(r18);
        goto L13
    L17:
        r18 = null;
        goto L18
    L21:
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(r11, MapsKt.toMap(r13), null, 4, null);
    L5:
        r11 = null;
        goto L6
    }

    public static final Class<?> toJavaClass(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SourceElement r10 = r5.getSource();
        if ((r10 instanceof KotlinJvmBinarySourceElement) == false) goto L6;
        KotlinJvmBinaryClass r11 = ((KotlinJvmBinarySourceElement) r10).getBinaryClass();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        return ((ReflectKotlinClass) r11).getKlass();
    L6:
        if ((r10 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L8;
        ReflectJavaElement r12 = ((RuntimeSourceElementFactory.RuntimeSourceElement) r10).getJavaElement();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        return ((ReflectJavaClass) r12).getElement();
    L8:
        ClassId r13 = DescriptorUtilsKt.getClassId(r5);
        if (r13 != null) goto L13;
        return null;
    L13:
        return loadClass(ReflectClassUtilKt.getSafeClassLoader(r5.getClass()), r13, 0);
    }

    public static final KVisibility toKVisibility(DescriptorVisibility r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5, DescriptorVisibilities.PUBLIC) == false) goto L6;
        return KVisibility.PUBLIC;
    L6:
        if (Intrinsics.areEqual(r5, DescriptorVisibilities.PROTECTED) == false) goto L9;
        return KVisibility.PROTECTED;
    L9:
        if (Intrinsics.areEqual(r5, DescriptorVisibilities.INTERNAL) == false) goto L12;
        return KVisibility.INTERNAL;
    L12:
        if (Intrinsics.areEqual(r5, DescriptorVisibilities.PRIVATE) == false) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == true) goto L22;
        return null;
    L22:
        return KVisibility.PRIVATE;
    L14:
        r10 = Intrinsics.areEqual(r5, DescriptorVisibilities.PRIVATE_TO_THIS);
        goto L15
    }

    private static final Object toRuntimeValue(ConstantValue<?> r5, ClassLoader r10) {
        if ((r5 instanceof AnnotationValue) == false) goto L6;
        return toAnnotationInstance(((AnnotationValue) r5).getValue());
    L6:
        if ((r5 instanceof ArrayValue) == false) goto L9;
        return arrayToRuntimeValue((ArrayValue) r5, r10);
    L9:
        if ((r5 instanceof EnumValue) == false) goto L15;
        Pair<? extends ClassId, ? extends Name> r11 = ((EnumValue) r5).getValue();
        ClassId r12 = r11.component1();
        Name r13 = r11.component2();
        Class r14 = loadClass$default(r10, r12, 0, 4, null);
        if (r14 == null) goto L40;
        return Util.getEnumConstantByName(r14, r13.asString());
    L40:
        return null;
    L15:
        if ((r5 instanceof KClassValue) == false) goto L30;
        KClassValue.Value r15 = ((KClassValue) r5).getValue();
        if ((r15 instanceof KClassValue.Value.NormalClass) == false) goto L20;
        KClassValue.Value.NormalClass r16 = (KClassValue.Value.NormalClass) r15;
        return loadClass(r10, r16.getClassId(), r16.getArrayDimensions());
    L20:
        if ((r15 instanceof KClassValue.Value.LocalClass) == false) goto L28;
        ClassifierDescriptor r17 = ((KClassValue.Value.LocalClass) r15).getType().getConstructor().mo1402getDeclarationDescriptor();
        if ((r17 instanceof ClassDescriptor) == false) goto L24;
        ClassDescriptor r18 = (ClassDescriptor) r17;
    L25:
        if (r18 == null) goto L40;
        return toJavaClass(r18);
    L24:
        r18 = null;
        goto L25
    L28:
        throw new NoWhenBranchMatchedException();
    L30:
        if ((r5 instanceof ErrorValue) == false) goto L32;
        boolean r19 = true;
    L33:
        if (r19 == true) goto L40;
        return r5.getValue();
    L32:
        r19 = r5 instanceof NullValue;
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Annotation> unwrapRepeatableAnnotations(List<? extends Annotation> r10) {
        if (r10 != 0) goto L4;
    L6:
        Iterator r5 = r10.iterator();
    L8:
        if (r5.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) r5.next())).getSimpleName(), "Container") == false) goto L8;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L22;
        Annotation r13 = (Annotation) r12.next();
        Class r14 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r13));
        if (Intrinsics.areEqual(r14.getSimpleName(), "Container") == true) goto L17;
    L19:
        List r15 = CollectionsKt.listOf(r13);
    L20:
        CollectionsKt.a(r11, r15);
        goto L13
    L17:
        if (r14.getAnnotation(RepeatableContainer.class) == null) goto L19;
        Object r16 = r14.getDeclaredMethod("value", null).invoke(r13, null);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
        r15 = ArraysKt.asList((Annotation[]) r16);
        goto L20
    L22:
        return r11;
    L30:
        return r10;
    L4:
        if (r10.isEmpty() == false) goto L6;
        return r10;
    }

    private static final Class<?> loadClass(ClassLoader r5, String r10, String r11, int r12) {
        if (Intrinsics.areEqual(r10, "kotlin") == true) goto L5;
    L52:
        StringBuilder r13 = new StringBuilder();
        if (r12 <= 0) goto L59;
        int r14 = 0;
    L55:
        if (r14 >= r12) goto L57;
        r13.append("[");
        r14 = r14 + 1;
        goto L55
    L57:
        r13.append("L");
    L59:
        if (r10.length() <= 0) goto L61;
        r13.append(r10.concat("."));
    L61:
        r13.append(StringsKt.E(r11, '.', Typography.dollar));
        if (r12 <= 0) goto L65;
        r13.append(";");
    L65:
        return ReflectJavaClassFinderKt.tryLoadClass(r5, r13.toString());
    L5:
        switch(r11.hashCode()) {
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
        if (r11.equals("LongArray") == false) goto L52;
        return long[].class;
    L13:
        if (r11.equals("FloatArray") == false) goto L52;
        return float[].class;
    L18:
        if (r11.equals("IntArray") == false) goto L52;
        return int[].class;
    L23:
        if (r11.equals("Array") == false) goto L52;
        return Object[].class;
    L28:
        if (r11.equals("DoubleArray") == false) goto L52;
        return double[].class;
    L33:
        if (r11.equals("ByteArray") == false) goto L52;
        return byte[].class;
    L38:
        if (r11.equals("CharArray") == false) goto L52;
        return char[].class;
    L43:
        if (r11.equals("ShortArray") == false) goto L52;
        return short[].class;
    L48:
        if (r11.equals("BooleanArray") == false) goto L52;
        return boolean[].class;
    }
}
