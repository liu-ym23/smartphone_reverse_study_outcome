package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "<init>", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "isKnownBuiltInFunction", "", "descriptor", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapJvmClassToKotlinClassId", "klass", "Ljava/lang/Class;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = null;
    private static final ClassId JAVA_LANG_VOID = null;

    private RuntimeTypeMapper() {
    }

    static {
        INSTANCE = new RuntimeTypeMapper();
        JAVA_LANG_VOID = ClassId.Companion.topLevel(new FqName("java.lang.Void"));
    }

    private final PrimitiveType getPrimitiveType(Class<?> r2) {
        if (r2.isPrimitive() == true) goto L7;
        return null;
    L7:
        return JvmPrimitiveType.get(r2.getSimpleName()).getPrimitiveType();
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor r4) {
        if (DescriptorFactory.isEnumValueOfMethod(r4) == false) goto L5;
    L14:
        return true;
    L5:
        if (DescriptorFactory.isEnumValuesMethod(r4) == true) goto L14;
        if (Intrinsics.areEqual(r4.getName(), CloneableClassScope.Companion.getCLONE_NAME()) == true) goto L10;
        return false;
    L10:
        if (r4.getValueParameters().isEmpty() == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor r7) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(r7), MethodSignatureMappingKt.computeJvmDescriptor$default(r7, false, false, 1, null)));
    }

    private final String mapName(CallableMemberDescriptor r2) {
        String r0 = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if ((r2 instanceof PropertyGetterDescriptor) == false) goto L8;
        return JvmAbi.getterName(DescriptorUtilsKt.getPropertyIfAccessor(r2).getName().asString());
    L8:
        if ((r2 instanceof PropertySetterDescriptor) == false) goto L11;
        return JvmAbi.setterName(DescriptorUtilsKt.getPropertyIfAccessor(r2).getName().asString());
    L11:
        return r2.getName().asString();
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "klass");
        if (r3.isArray() == false) goto L11;
        PrimitiveType r4 = getPrimitiveType(r3.getComponentType());
        if (r4 == null) goto L9;
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r4.getArrayTypeName());
    L9:
        return ClassId.Companion.topLevel(StandardNames.FqNames.array.toSafe());
    L11:
        if (Intrinsics.areEqual(r3, Void.TYPE) == true) goto L13;
        PrimitiveType r0 = getPrimitiveType(r3);
        if (r0 != null) goto L17;
        ClassId r5 = ReflectClassUtilKt.getClassId(r3);
        if (r5.isLocal() == true) goto L23;
        ClassId r1 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r5.asSingleFqName());
        if (r1 == null) goto L23;
        return r1;
    L23:
        return r5;
    L17:
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r0.getTypeName());
    L13:
        return JAVA_LANG_VOID;
    }

    public final JvmPropertySignature mapPropertySignature(PropertyDescriptor r8) {
        Intrinsics.checkNotNullParameter(r8, "possiblyOverriddenProperty");
        JavaPropertyDescriptor r1 = ((PropertyDescriptor) DescriptorUtils.unwrapFakeOverride(r8)).getOriginal();
        JvmFunctionSignature.KotlinFunction r0 = null;
        if ((r1 instanceof DeserializedPropertyDescriptor) == false) goto L9;
        DeserializedPropertyDescriptor r9 = (DeserializedPropertyDescriptor) r1;
        ProtoBuf$Property r2 = r9.getProto();
        JvmProtoBuf.JvmPropertySignature r3 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r2, JvmProtoBuf.propertySignature);
        if (r3 != null) goto L7;
    L43:
        PropertyGetterDescriptor r10 = r1.getGetter();
        Intrinsics.checkNotNull(r10);
        JvmFunctionSignature.KotlinFunction r11 = mapJvmFunctionSignature(r10);
        PropertySetterDescriptor r4 = r1.getSetter();
        if (r4 == null) goto L47;
        r0 = mapJvmFunctionSignature(r4);
    L47:
        return new JvmPropertySignature.MappedKotlinProperty(r11, r0);
    L7:
        return new JvmPropertySignature.KotlinProperty(r1, r2, r3, r9.getNameResolver(), r9.getTypeTable());
    L9:
        if ((r1 instanceof JavaPropertyDescriptor) == false) goto L43;
        JavaPropertyDescriptor r12 = r1;
        JavaSourceElement r5 = r12.getSource();
        if ((r5 instanceof JavaSourceElement) == false) goto L13;
        JavaSourceElement r6 = r5;
    L14:
        if (r6 == null) goto L16;
        JavaElement r7 = r6.getJavaElement();
    L18:
        if ((r7 instanceof ReflectJavaField) == false) goto L21;
        return new JvmPropertySignature.JavaField(((ReflectJavaField) r7).getMember());
    L21:
        if ((r7 instanceof ReflectJavaMethod) == false) goto L42;
        Method r13 = ((ReflectJavaMethod) r7).getMember();
        PropertySetterDescriptor r14 = r12.getSetter();
        if (r14 == null) goto L25;
        SourceElement r15 = r14.getSource();
    L27:
        if ((r15 instanceof JavaSourceElement) == false) goto L29;
        JavaSourceElement r16 = (JavaSourceElement) r15;
    L30:
        if (r16 == null) goto L32;
        JavaElement r17 = r16.getJavaElement();
    L34:
        if ((r17 instanceof ReflectJavaMethod) == false) goto L36;
        ReflectJavaMethod r18 = (ReflectJavaMethod) r17;
    L37:
        if (r18 == null) goto L40;
        r0 = r18.getMember();
    L40:
        return new JvmPropertySignature.JavaMethodProperty(r13, r0);
    L36:
        r18 = null;
        goto L37
    L32:
        r17 = null;
        goto L34
    L29:
        r16 = null;
        goto L30
    L25:
        r15 = null;
        goto L27
    L42:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + r1 + " (source = " + r7 + ')');
    L16:
        r7 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    }

    public final JvmFunctionSignature mapSignature(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "possiblySubstitutedFunction");
        JavaMethodDescriptor r0 = ((FunctionDescriptor) DescriptorUtils.unwrapFakeOverride(r10)).getOriginal();
        ReflectJavaMethod r2 = null;
        if ((r0 instanceof DeserializedCallableMemberDescriptor) == false) goto L48;
        DeserializedMemberDescriptor r1 = (DeserializedMemberDescriptor) r0;
        MessageLite r3 = r1.getProto();
        if ((r3 instanceof ProtoBuf$Function) == false) goto L11;
        JvmMemberSignature.Method r4 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf$Function) r3, r1.getNameResolver(), r1.getTypeTable());
        if (r4 == null) goto L11;
        return new JvmFunctionSignature.KotlinFunction(r4);
    L11:
        if ((r3 instanceof ProtoBuf$Constructor) == false) goto L46;
        JvmMemberSignature.Method r5 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf$Constructor) r3, r1.getNameResolver(), r1.getTypeTable());
        if (r5 == null) goto L46;
        if (InlineClassesUtilsKt.isInlineClass(r10.getContainingDeclaration()) == false) goto L18;
        return new JvmFunctionSignature.KotlinFunction(r5);
    L18:
        if (InlineClassesUtilsKt.isMultiFieldValueClass(r10.getContainingDeclaration()) == false) goto L44;
        ConstructorDescriptor r11 = (ConstructorDescriptor) r10;
        boolean r6 = true;
        if (r11.isPrimary() == false) goto L32;
        if (Intrinsics.areEqual(r5.getName(), "constructor-impl") == true) goto L24;
    L26:
        r6 = false;
    L27:
        if (r6 == true) goto L92;
        throw new IllegalArgumentException(("Invalid signature: " + r5).toString());
    L92:
        return new JvmFunctionSignature.KotlinFunction(r5);
    L24:
        if (StringsKt.endsWith$default(r5.getDesc(), ")V", false, 2, null) == false) goto L26;
    L32:
        if (Intrinsics.areEqual(r5.getName(), "constructor-impl") == false) goto L42;
        String r12 = ValueClassAwareCallerKt.toJvmDescriptor(r11.getConstructedClass());
        if (StringsKt.endsWith$default(r5.getDesc(), ")V", false, 2, null) == false) goto L37;
        r5 = JvmMemberSignature.Method.copy$default(r5, null, StringsKt.removeSuffix(r5.getDesc(), "V") + r12, 1, null);
        goto L92
    L37:
        if (StringsKt.endsWith$default(r5.getDesc(), r12, false, 2, null) == true) goto L92;
        throw new IllegalArgumentException(("Invalid signature: " + r5).toString());
    L42:
        throw new IllegalArgumentException(("Invalid signature: " + r5).toString());
    L44:
        return new JvmFunctionSignature.KotlinConstructor(r5);
    L46:
        return mapJvmFunctionSignature(r0);
    L48:
        if ((r0 instanceof JavaMethodDescriptor) == false) goto L67;
        JavaSourceElement r13 = r0.getSource();
        if ((r13 instanceof JavaSourceElement) == false) goto L52;
        JavaSourceElement r14 = r13;
    L53:
        if (r14 == null) goto L55;
        JavaElement r15 = r14.getJavaElement();
    L57:
        if ((r15 instanceof ReflectJavaMethod) == false) goto L59;
        r2 = (ReflectJavaMethod) r15;
    L59:
        if (r2 == null) goto L65;
        Method r16 = r2.getMember();
        if (r16 == null) goto L65;
        return new JvmFunctionSignature.JavaMethod(r16);
    L65:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + r0);
    L55:
        r15 = null;
        goto L57
    L52:
        r14 = null;
        goto L53
    L67:
        if ((r0 instanceof JavaClassConstructorDescriptor) == false) goto L86;
        JavaSourceElement r17 = ((JavaClassConstructorDescriptor) r0).getSource();
        if ((r17 instanceof JavaSourceElement) == false) goto L71;
        JavaSourceElement r18 = r17;
    L72:
        if (r18 == null) goto L75;
        r2 = r18.getJavaElement();
    L75:
        if ((r2 instanceof ReflectJavaConstructor) == false) goto L78;
        return new JvmFunctionSignature.JavaConstructor(((ReflectJavaConstructor) r2).getMember());
    L78:
        if ((r2 instanceof ReflectJavaClass) == false) goto L84;
        ReflectJavaClass r19 = (ReflectJavaClass) r2;
        if (r19.isAnnotationType() == false) goto L84;
        return new JvmFunctionSignature.FakeJavaAnnotationConstructor(r19.getElement());
    L84:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + r0 + " (" + r2 + ')');
    L71:
        r18 = null;
        goto L72
    L86:
        if (isKnownBuiltInFunction(r0) == false) goto L90;
        return mapJvmFunctionSignature(r0);
    L90:
        throw new KotlinReflectionInternalError("Unknown origin of " + r0 + " (" + r0.getClass() + ')');
    }
}
