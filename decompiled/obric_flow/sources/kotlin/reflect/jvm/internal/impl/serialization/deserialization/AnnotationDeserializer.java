package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import androidx.constraintlayout.motion.widget.a;
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
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAnnotationDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationDeserializer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n121#1:147\n121#1:148\n121#1:149\n121#1:150\n1194#2,2:128\n1222#2,4:130\n1603#2,9:134\n1855#2:143\n1856#2:145\n1612#2:146\n1549#2:151\n1620#2,3:152\n1726#2,3:155\n1#3:144\n*S KotlinDebug\n*F\n+ 1 AnnotationDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/AnnotationDeserializer\n*L\n74#1:147\n76#1:148\n77#1:149\n78#1:150\n47#1:128,2\n47#1:130,4\n48#1:134,9\n48#1:143\n48#1:145\n48#1:146\n87#1:151\n87#1:152,3\n112#1:155,3\n48#1:144\n*E\n"})
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            r5[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r5[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r5[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r5[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r5[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r5[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r5[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r5[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r5[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r5[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r5[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r5[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r5[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor r5, NotFoundClasses r10) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r10, "notFoundClasses");
        this.module = r5;
        this.notFoundClasses = r10;
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> r10, KotlinType r11, ProtoBuf.Annotation.Argument.Value r12) {
        ProtoBuf.Annotation.Argument.Value.Type r5 = r12.getType();
        if (r5 != null) goto L5;
        int r13 = -1;
    L7:
        if (r13 != 10) goto L9;
        ClassifierDescriptor r14 = r11.getConstructor().mo1402getDeclarationDescriptor();
        if ((r14 instanceof ClassDescriptor) == false) goto L31;
        ClassDescriptor r15 = (ClassDescriptor) r14;
    L32:
        if (r15 != null) goto L34;
    L40:
        return true;
    L34:
        if (KotlinBuiltIns.isKClass(r15) == true) goto L40;
        return false;
    L31:
        r15 = null;
        goto L32
    L9:
        if (r13 == 13) goto L12;
        return Intrinsics.areEqual(r10.getType(this.module), r11);
    L12:
        if ((r10 instanceof ArrayValue) == false) goto L27;
        if (((ArrayValue) r10).getValue().size() != r12.getArrayElementList().size()) goto L27;
        KotlinType r16 = getBuiltIns().getArrayElementType(r11);
        ArrayValue r17 = (ArrayValue) r10;
        Iterable r18 = CollectionsKt.getIndices(r17.getValue());
        if ((r18 instanceof Collection) == true) goto L18;
    L20:
        Iterator r19 = r18.iterator();
    L22:
        if (r19.hasNext() == false) goto L40;
        int r20 = ((IntIterator) r19).nextInt();
        if (doesValueConformToExpectedType(r17.getValue().get(r20), r16, r12.getArrayElement(r20)) == true) goto L22;
        return false;
    L18:
        if (((Collection) r18).isEmpty() == false) goto L20;
    L27:
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + r10).toString());
    L5:
        r13 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        goto L7
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument r5, Map<Name, ? extends ValueParameterDescriptor> r10, NameResolver r11) {
        ValueParameterDescriptor r12 = r10.get(NameResolverUtilKt.getName(r11, r5.getNameId()));
        if (r12 != null) goto L7;
        return null;
    L7:
        return new Pair(NameResolverUtilKt.getName(r11, r5.getNameId()), resolveValueAndCheckExpectedType(r12.getType(), r5.getValue(), r11));
    }

    private final ClassDescriptor resolveClass(ClassId r5) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r5, this.notFoundClasses);
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType r5, ProtoBuf.Annotation.Argument.Value r10, NameResolver r11) {
        ConstantValue<?> r12 = resolveValue(r5, r10, r11);
        if (doesValueConformToExpectedType(r12, r5, r10) == true) goto L6;
        r12 = null;
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        return ErrorValue.Companion.create("Unexpected argument value: actual type " + r10.getType() + " != expected type " + r5);
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf.Annotation r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        ClassDescriptor r5 = resolveClass(NameResolverUtilKt.getClassId(r11, r10.getId()));
        Map r12 = MapsKt.emptyMap();
        if (r10.getArgumentCount() == 0) goto L22;
        if (ErrorUtils.isError(r5) == true) goto L22;
        if (DescriptorUtils.isAnnotationClass(r5) == false) goto L22;
        ClassConstructorDescriptor r13 = (ClassConstructorDescriptor) CollectionsKt.singleOrNull(r5.getConstructors());
        if (r13 == null) goto L22;
        List<ValueParameterDescriptor> r14 = r13.getValueParameters();
        LinkedHashMap r15 = new LinkedHashMap(a.e(r14, 16));
        Iterator<T> r16 = r14.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        Object r17 = r16.next();
        r15.put(((ValueParameterDescriptor) r17).getName(), r17);
        goto L12
    L14:
        List<ProtoBuf.Annotation.Argument> r18 = r10.getArgumentList();
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L16:
        if (r20.hasNext() == false) goto L20;
        Pair<Name, ConstantValue<?>> r21 = resolveArgument((ProtoBuf.Annotation.Argument) r20.next(), r15, r11);
        if (r21 == null) goto L16;
        r19.add(r21);
        goto L16
    L20:
        r12 = MapsKt.toMap(r19);
    L22:
        return new AnnotationDescriptorImpl(r5.getDefaultType(), r12, SourceElement.NO_SOURCE);
    }

    public final ConstantValue<?> resolveValue(KotlinType r5, ProtoBuf.Annotation.Argument.Value r10, NameResolver r11) {
        Intrinsics.checkNotNullParameter(r5, "expectedType");
        Intrinsics.checkNotNullParameter(r10, "value");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        boolean r12 = Flags.IS_UNSIGNED.get(r10.getFlags()).booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type r13 = r10.getType();
        if (r13 != null) goto L5;
        int r14 = -1;
    L6:
        switch(r14) {
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
        ConstantValueFactory r15 = ConstantValueFactory.INSTANCE;
        List<ProtoBuf.Annotation.Argument.Value> r16 = r10.getArrayElementList();
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator<T> r18 = r16.iterator();
    L11:
        if (r18.hasNext() == false) goto L44;
        r17.add(resolveValue(getBuiltIns().getAnyType(), (ProtoBuf.Annotation.Argument.Value) r18.next(), r11));
        goto L11
    L44:
        return r15.createArrayValue(r17, r5);
    L14:
        ConstantValue<?> r19 = new AnnotationValue(deserializeAnnotation(r10.getAnnotation(), r11));
    L46:
        return r19;
    L26:
        long r20 = r10.getIntValue();
        if (r12 == false) goto L30;
        ConstantValue<?> r21 = new ULongValue(r20);
    L53:
        return r21;
    L30:
        r21 = new LongValue(r20);
        goto L53
    L31:
        int r22 = (int) r10.getIntValue();
        if (r12 == false) goto L34;
        r19 = new UIntValue(r22);
        goto L46
    L34:
        r19 = new IntValue(r22);
        goto L46
    L35:
        short r23 = (short) r10.getIntValue();
        if (r12 == false) goto L38;
        r19 = new UShortValue(r23);
        goto L46
    L38:
        r19 = new ShortValue(r23);
        goto L46
    L40:
        byte r24 = (byte) r10.getIntValue();
        if (r12 == false) goto L43;
        r19 = new UByteValue(r24);
        goto L46
    L43:
        r19 = new ByteValue(r24);
        goto L46
    L8:
        throw new IllegalStateException(("Unsupported annotation argument type: " + r10.getType() + " (expected " + r5 + ')').toString());
    L47:
        return new EnumValue(NameResolverUtilKt.getClassId(r11, r10.getClassId()), NameResolverUtilKt.getName(r11, r10.getEnumValueId()));
    L48:
        return new KClassValue(NameResolverUtilKt.getClassId(r11, r10.getClassId()), r10.getArrayDimensionCount());
    L49:
        return new StringValue(r11.getString(r10.getStringValue()));
    L20:
        if (r10.getIntValue() == 0) goto L22;
        boolean r25 = true;
    L50:
        return new BooleanValue(r25);
    L22:
        r25 = false;
        goto L50
    L51:
        return new DoubleValue(r10.getDoubleValue());
    L52:
        return new FloatValue(r10.getFloatValue());
    L54:
        return new CharValue((char) r10.getIntValue());
    L5:
        r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        goto L6
    }
}
