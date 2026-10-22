package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            r10[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r10[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r10[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r10[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r10[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r10[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r10[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r10[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r10[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r10[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r10[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r10[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r10[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor r10, NotFoundClasses r11) {
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r11, "notFoundClasses");
        this.module = r10;
        this.notFoundClasses = r11;
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> r10, KotlinType r11, ProtoBuf.Annotation.Argument.Value r12) {
        ProtoBuf.Annotation.Argument.Value.Type r13 = r12.getType();
        if (r13 != null) goto L5;
        int r14 = -1;
    L7:
        if (r14 != 10) goto L9;
        ClassifierDescriptor r15 = r11.getConstructor().mo1323getDeclarationDescriptor();
        if ((r15 instanceof ClassDescriptor) == false) goto L34;
        ClassDescriptor r16 = (ClassDescriptor) r15;
    L35:
        if (r16 != null) goto L37;
    L39:
        return true;
    L37:
        if (KotlinBuiltIns.isKClass(r16) == true) goto L39;
        return false;
    L34:
        r16 = null;
        goto L35
    L9:
        if (r14 == 13) goto L12;
        return Intrinsics.areEqual(r10.getType(this.module), r11);
    L12:
        if ((r10 instanceof ArrayValue) == true) goto L14;
    L16:
        boolean r17 = false;
    L17:
        if (r17 == false) goto L30;
        KotlinType r18 = getBuiltIns().getArrayElementType(r11);
        Intrinsics.checkNotNullExpressionValue(r18, "builtIns.getArrayElementType(expectedType)");
        ArrayValue r19 = (ArrayValue) r10;
        Iterable r20 = CollectionsKt.getIndices(r19.getValue());
        if ((r20 instanceof Collection) == true) goto L21;
    L23:
        Iterator r21 = r20.iterator();
    L25:
        if (r21.hasNext() == false) goto L39;
        int r22 = ((IntIterator) r21).nextInt();
        ConstantValue<?> r23 = r19.getValue().get(r22);
        ProtoBuf.Annotation.Argument.Value r24 = r12.getArrayElement(r22);
        Intrinsics.checkNotNullExpressionValue(r24, "value.getArrayElement(i)");
        if (doesValueConformToExpectedType(r23, r18, r24) == true) goto L25;
        return false;
    L21:
        if (((Collection) r20).isEmpty() == false) goto L23;
    L30:
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + r10).toString());
    L14:
        if (((ArrayValue) r10).getValue().size() != r12.getArrayElementList().size()) goto L16;
        r17 = true;
        goto L17
    L5:
        r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        goto L7
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument r10, Map<Name, ? extends ValueParameterDescriptor> r11, NameResolver r12) {
        ValueParameterDescriptor r13 = r11.get(NameResolverUtilKt.getName(r12, r10.getNameId()));
        if (r13 != null) goto L6;
        return null;
    L6:
        Name r14 = NameResolverUtilKt.getName(r12, r10.getNameId());
        KotlinType r15 = r13.getType();
        Intrinsics.checkNotNullExpressionValue(r15, "parameter.type");
        ProtoBuf.Annotation.Argument.Value r16 = r10.getValue();
        Intrinsics.checkNotNullExpressionValue(r16, "proto.value");
        return new Pair(r14, resolveValueAndCheckExpectedType(r15, r16, r12));
    }

    private final ClassDescriptor resolveClass(ClassId r10) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r10, this.notFoundClasses);
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType r10, ProtoBuf.Annotation.Argument.Value r11, NameResolver r12) {
        ConstantValue<?> r13 = resolveValue(r10, r11, r12);
        if (doesValueConformToExpectedType(r13, r10, r11) == true) goto L6;
        r13 = null;
    L6:
        if (r13 == null) goto L8;
        return r13;
    L8:
        return ErrorValue.Companion.create("Unexpected argument value: actual type " + r11.getType() + " != expected type " + r10);
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf.Annotation r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        ClassDescriptor r12 = resolveClass(NameResolverUtilKt.getClassId(r11, r10.getId()));
        Map r13 = MapsKt.emptyMap();
        if (r10.getArgumentCount() == 0) goto L22;
        if (ErrorUtils.isError(r12) == true) goto L22;
        if (DescriptorUtils.isAnnotationClass(r12) == false) goto L22;
        Collection<ClassConstructorDescriptor> r14 = r12.getConstructors();
        Intrinsics.checkNotNullExpressionValue(r14, "annotationClass.constructors");
        ClassConstructorDescriptor r15 = (ClassConstructorDescriptor) CollectionsKt.singleOrNull(r14);
        if (r15 == null) goto L22;
        List<ValueParameterDescriptor> r16 = r15.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r16, "constructor.valueParameters");
        LinkedHashMap r17 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r16, 10)), 16));
        Iterator<T> r18 = r16.iterator();
    L12:
        if (r18.hasNext() == false) goto L14;
        Object r19 = r18.next();
        r17.put(((ValueParameterDescriptor) r19).getName(), r19);
        goto L12
    L14:
        List<ProtoBuf.Annotation.Argument> r20 = r10.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(r20, "proto.argumentList");
        ArrayList r21 = new ArrayList();
        Iterator<T> r22 = r20.iterator();
    L16:
        if (r22.hasNext() == false) goto L20;
        ProtoBuf.Annotation.Argument r23 = (ProtoBuf.Annotation.Argument) r22.next();
        Intrinsics.checkNotNullExpressionValue(r23, "it");
        Pair<Name, ConstantValue<?>> r24 = resolveArgument(r23, r17, r11);
        if (r24 == null) goto L16;
        r21.add(r24);
        goto L16
    L20:
        r13 = MapsKt.toMap(r21);
    L22:
        return new AnnotationDescriptorImpl(r12.getDefaultType(), r13, SourceElement.NO_SOURCE);
    }

    public final ConstantValue<?> resolveValue(KotlinType r10, ProtoBuf.Annotation.Argument.Value r11, NameResolver r12) {
        Intrinsics.checkNotNullParameter(r10, "expectedType");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r12, "nameResolver");
        Boolean r13 = Flags.IS_UNSIGNED.get(r11.getFlags());
        Intrinsics.checkNotNullExpressionValue(r13, "IS_UNSIGNED.get(value.flags)");
        boolean r14 = r13.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type r15 = r11.getType();
        if (r15 != null) goto L5;
        int r16 = -1;
    L6:
        switch(r16) {
            case 1: goto L40;
            case 2: goto L54;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L26;
            case 6: goto L52;
            case 7: goto L51;
            case 8: goto L20;
            case 9: goto L49;
            case 10: goto L48;
            case 11: goto L47;
            case 12: goto L14;
            case 13: goto L9;
            default: goto L8;
        };
    L9:
        List<ProtoBuf.Annotation.Argument.Value> r17 = r11.getArrayElementList();
        Intrinsics.checkNotNullExpressionValue(r17, "value.arrayElementList");
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L11:
        if (r19.hasNext() == false) goto L44;
        ProtoBuf.Annotation.Argument.Value r20 = (ProtoBuf.Annotation.Argument.Value) r19.next();
        SimpleType r21 = getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(r21, "builtIns.anyType");
        Intrinsics.checkNotNullExpressionValue(r20, "it");
        r18.add(resolveValue(r21, r20, r12));
        goto L11
    L44:
        return new DeserializedArrayValue(r18, r10);
    L14:
        ProtoBuf.Annotation r22 = r11.getAnnotation();
        Intrinsics.checkNotNullExpressionValue(r22, "value.annotation");
        ConstantValue<?> r23 = new AnnotationValue(deserializeAnnotation(r22, r12));
    L46:
        return r23;
    L26:
        long r24 = r11.getIntValue();
        if (r14 == false) goto L29;
        ConstantValue<?> r25 = new ULongValue(r24);
    L53:
        return r25;
    L29:
        r25 = new LongValue(r24);
        goto L53
    L31:
        int r26 = (int) r11.getIntValue();
        if (r14 == false) goto L34;
        r23 = new UIntValue(r26);
        goto L46
    L34:
        r23 = new IntValue(r26);
        goto L46
    L35:
        short r27 = (short) r11.getIntValue();
        if (r14 == false) goto L38;
        r23 = new UShortValue(r27);
        goto L46
    L38:
        r23 = new ShortValue(r27);
        goto L46
    L40:
        byte r28 = (byte) r11.getIntValue();
        if (r14 == false) goto L43;
        r23 = new UByteValue(r28);
        goto L46
    L43:
        r23 = new ByteValue(r28);
        goto L46
    L8:
        throw new IllegalStateException(("Unsupported annotation argument type: " + r11.getType() + " (expected " + r10 + ')').toString());
    L47:
        return new EnumValue(NameResolverUtilKt.getClassId(r12, r11.getClassId()), NameResolverUtilKt.getName(r12, r11.getEnumValueId()));
    L48:
        return new KClassValue(NameResolverUtilKt.getClassId(r12, r11.getClassId()), r11.getArrayDimensionCount());
    L49:
        return new StringValue(r12.getString(r11.getStringValue()));
    L20:
        if (r11.getIntValue() == 0) goto L22;
        boolean r29 = true;
    L50:
        return new BooleanValue(r29);
    L22:
        r29 = false;
        goto L50
    L51:
        return new DoubleValue(r11.getDoubleValue());
    L52:
        return new FloatValue(r11.getFloatValue());
    L54:
        return new CharValue((char) r11.getIntValue());
    L5:
        r16 = WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
        goto L6
    }
}
