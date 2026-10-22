package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import kotlin.jvm.internal.markers.KMappedMarker;
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
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
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
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    private final ClassDescriptor resolveClass(ClassId r3) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r3, this.notFoundClasses);
    }

    public AnnotationDeserializer(ModuleDescriptor r2, NotFoundClasses r3) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        this.module = r2;
        this.notFoundClasses = r3;
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf$Annotation r6, NameResolver r7) {
        Intrinsics.checkNotNullParameter(r6, "proto");
        Intrinsics.checkNotNullParameter(r7, "nameResolver");
        ClassDescriptor r0 = resolveClass(NameResolverUtilKt.getClassId(r7, r6.getId()));
        Map r1 = MapsKt.emptyMap();
        if (r6.getArgumentCount() == 0) goto L22;
        if (ErrorUtils.isError(r0) == true) goto L22;
        if (DescriptorUtils.isAnnotationClass(r0) == false) goto L22;
        ClassConstructorDescriptor r2 = (ClassConstructorDescriptor) CollectionsKt.singleOrNull(r0.getConstructors());
        if (r2 == null) goto L22;
        List<ValueParameterDescriptor> r3 = r2.getValueParameters();
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator<T> r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        Object r8 = r5.next();
        r4.put(((ValueParameterDescriptor) r8).getName(), r8);
        goto L12
    L14:
        List<ProtoBuf$Annotation.Argument> r9 = r6.getArgumentList();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        ProtoBuf$Annotation.Argument r12 = (ProtoBuf$Annotation.Argument) r11.next();
        Intrinsics.checkNotNull(r12);
        Pair<Name, ConstantValue<?>> r13 = resolveArgument(r12, r4, r7);
        if (r13 == null) goto L16;
        r10.add(r13);
        goto L16
    L20:
        r1 = MapsKt.toMap(r10);
    L22:
        return new AnnotationDescriptorImpl(r0.getDefaultType(), r1, SourceElement.NO_SOURCE);
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> r6, KotlinType r7, ProtoBuf$Annotation.Argument.Value r8) {
        ProtoBuf$Annotation.Argument.Value.Type r0 = r8.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 10) goto L9;
        ClassifierDescriptor r9 = r7.getConstructor().getDeclarationDescriptor();
        if ((r9 instanceof ClassDescriptor) == false) goto L34;
        ClassDescriptor r10 = (ClassDescriptor) r9;
    L35:
        if (r10 != null) goto L37;
    L38:
        return true;
    L37:
        if (KotlinBuiltIns.isKClass(r10) == true) goto L38;
        return false;
    L34:
        r10 = null;
        goto L35
    L9:
        if (r1 == 13) goto L12;
        return Intrinsics.areEqual(r6.getType(this.module), r7);
    L12:
        if ((r6 instanceof ArrayValue) == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L30;
        KotlinType r11 = getBuiltIns().getArrayElementType(r7);
        ArrayValue r12 = (ArrayValue) r6;
        KMappedMarker r3 = CollectionsKt.getIndices((Collection) r12.getValue());
        if ((r3 instanceof Collection) == true) goto L21;
    L23:
        Iterator r4 = r3.iterator();
    L25:
        if (r4.hasNext() == false) goto L38;
        int r5 = ((IntIterator) r4).nextInt();
        if (doesValueConformToExpectedType((ConstantValue) ListProtector.get((List) r12.getValue(), r5), r11, r8.getArrayElement(r5)) == true) goto L25;
        return false;
    L21:
        if (((Collection) r3).isEmpty() == false) goto L23;
    L30:
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + r6).toString());
    L14:
        if (((List) ((ArrayValue) r6).getValue()).size() != r8.getArrayElementList().size()) goto L16;
        r2 = true;
        goto L17
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L7
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf$Annotation.Argument r3, Map<Name, ? extends ValueParameterDescriptor> r4, NameResolver r5) {
        ValueParameterDescriptor r6 = r4.get(NameResolverUtilKt.getName(r5, r3.getNameId()));
        if (r6 != null) goto L7;
        return null;
    L7:
        return new Pair(NameResolverUtilKt.getName(r5, r3.getNameId()), resolveValueAndCheckExpectedType(r6.getType(), r3.getValue(), r5));
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType r3, ProtoBuf$Annotation.Argument.Value r4, NameResolver r5) {
        ConstantValue<?> r6 = resolveValue(r3, r4, r5);
        if (doesValueConformToExpectedType(r6, r3, r4) == true) goto L6;
        r6 = null;
    L6:
        if (r6 == null) goto L8;
        return r6;
    L8:
        return ErrorValue.Companion.create("Unexpected argument value: actual type " + r4.getType() + " != expected type " + r3);
    }

    public final ConstantValue<?> resolveValue(KotlinType r5, ProtoBuf$Annotation.Argument.Value r6, NameResolver r7) {
        Intrinsics.checkNotNullParameter(r5, "expectedType");
        Intrinsics.checkNotNullParameter(r6, "value");
        Intrinsics.checkNotNullParameter(r7, "nameResolver");
        boolean r0 = Flags.IS_UNSIGNED.get(r6.getFlags()).booleanValue();
        ProtoBuf$Annotation.Argument.Value.Type r1 = r6.getType();
        if (r1 != null) goto L5;
        int r2 = -1;
    L6:
        switch(r2) {
            case 1: goto L40;
            case 2: goto L57;
            case 3: goto L34;
            case 4: goto L30;
            case 5: goto L25;
            case 6: goto L52;
            case 7: goto L51;
            case 8: goto L19;
            case 9: goto L49;
            case 10: goto L48;
            case 11: goto L47;
            case 12: goto L46;
            case 13: goto L9;
            default: goto L8;
        };
    L9:
        ConstantValueFactory r3 = ConstantValueFactory.INSTANCE;
        List<ProtoBuf$Annotation.Argument.Value> r8 = r6.getArrayElementList();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L44;
        ProtoBuf$Annotation.Argument.Value r10 = (ProtoBuf$Annotation.Argument.Value) r9.next();
        SimpleType r11 = getBuiltIns().getAnyType();
        Intrinsics.checkNotNull(r10);
        r4.add(resolveValue(r11, r10, r7));
        goto L11
    L44:
        return r3.createArrayValue(r4, r5);
    L25:
        long r12 = r6.getIntValue();
        if (r0 == false) goto L28;
        ULongValue r13 = new ULongValue(r12);
    L53:
        return r13;
    L28:
        r13 = new LongValue(r12);
        goto L53
    L30:
        int r14 = (int) r6.getIntValue();
        if (r0 == false) goto L55;
        return new UIntValue(r14);
    L55:
        return new IntValue(r14);
    L34:
        short r15 = (short) r6.getIntValue();
        if (r0 == false) goto L37;
        UShortValue r16 = new UShortValue(r15);
    L56:
        return r16;
    L37:
        r16 = new ShortValue(r15);
        goto L56
    L40:
        byte r17 = (byte) r6.getIntValue();
        if (r0 == false) goto L43;
        r16 = new UByteValue(r17);
        goto L56
    L43:
        r16 = new ByteValue(r17);
        goto L56
    L8:
        throw new IllegalStateException(("Unsupported annotation argument type: " + r6.getType() + " (expected " + r5 + ')').toString());
    L46:
        return new AnnotationValue(deserializeAnnotation(r6.getAnnotation(), r7));
    L47:
        return new EnumValue(NameResolverUtilKt.getClassId(r7, r6.getClassId()), NameResolverUtilKt.getName(r7, r6.getEnumValueId()));
    L48:
        return new KClassValue(NameResolverUtilKt.getClassId(r7, r6.getClassId()), r6.getArrayDimensionCount());
    L49:
        return new StringValue(r7.getString(r6.getStringValue()));
    L19:
        if (r6.getIntValue() == 0) goto L21;
        boolean r18 = true;
    L50:
        return new BooleanValue(r18);
    L21:
        r18 = false;
        goto L50
    L51:
        return new DoubleValue(r6.getDoubleValue());
    L52:
        return new FloatValue(r6.getFloatValue());
    L57:
        return new CharValue((char) r6.getIntValue());
    L5:
        r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        goto L6
    }
}
