package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
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
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = null;
    private static final ClassId JAVA_LANG_VOID = null;

    static {
        INSTANCE = new RuntimeTypeMapper();
        ClassId r10 = ClassId.topLevel(new FqName("java.lang.Void"));
        Intrinsics.checkNotNullExpressionValue(r10, "topLevel(FqName(\"java.lang.Void\"))");
        JAVA_LANG_VOID = r10;
    }

    private RuntimeTypeMapper() {
    }

    private final PrimitiveType getPrimitiveType(Class<?> r10) {
        if (r10.isPrimitive() == true) goto L7;
        return null;
    L7:
        return JvmPrimitiveType.get(r10.getSimpleName()).getPrimitiveType();
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor r10) {
        if (DescriptorFactory.isEnumValueOfMethod(r10) == false) goto L5;
    L14:
        return true;
    L5:
        if (DescriptorFactory.isEnumValuesMethod(r10) == true) goto L14;
        if (Intrinsics.areEqual(r10.getName(), CloneableClassScope.Companion.getCLONE_NAME()) == true) goto L10;
        return false;
    L10:
        if (r10.getValueParameters().isEmpty() == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor r10) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(r10), MethodSignatureMappingKt.computeJvmDescriptor$default(r10, false, false, 1, null)));
    }

    private final String mapName(CallableMemberDescriptor r10) {
        String r11 = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        if ((r10 instanceof PropertyGetterDescriptor) == false) goto L8;
        String r12 = DescriptorUtilsKt.getPropertyIfAccessor(r10).getName().asString();
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.propertyIfAccessor.name.asString()");
        return JvmAbi.getterName(r12);
    L8:
        if ((r10 instanceof PropertySetterDescriptor) == false) goto L10;
        String r13 = DescriptorUtilsKt.getPropertyIfAccessor(r10).getName().asString();
        Intrinsics.checkNotNullExpressionValue(r13, "descriptor.propertyIfAccessor.name.asString()");
        return JvmAbi.setterName(r13);
    L10:
        String r14 = r10.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r14, "descriptor.name.asString()");
        return r14;
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        if (r10.isArray() == false) goto L11;
        Class<?> r11 = r10.getComponentType();
        Intrinsics.checkNotNullExpressionValue(r11, "klass.componentType");
        PrimitiveType r12 = getPrimitiveType(r11);
        if (r12 != null) goto L7;
        ClassId r13 = ClassId.topLevel(StandardNames.FqNames.array.toSafe());
        Intrinsics.checkNotNullExpressionValue(r13, "topLevel(StandardNames.FqNames.array.toSafe())");
        return r13;
    L7:
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r12.getArrayTypeName());
    L11:
        if (Intrinsics.areEqual(r10, Void.TYPE) == true) goto L13;
        PrimitiveType r14 = getPrimitiveType(r10);
        if (r14 != null) goto L17;
        ClassId r15 = ReflectClassUtilKt.getClassId(r10);
        if (r15.isLocal() == true) goto L23;
        JavaToKotlinClassMap r16 = JavaToKotlinClassMap.INSTANCE;
        FqName r17 = r15.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r17, "classId.asSingleFqName()");
        ClassId r18 = r16.mapJavaToKotlin(r17);
        if (r18 == null) goto L23;
        return r18;
    L23:
        return r15;
    L17:
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r14.getTypeName());
    L13:
        return JAVA_LANG_VOID;
    }

    public final JvmPropertySignature mapPropertySignature(PropertyDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "possiblyOverriddenProperty");
        PropertyDescriptor r11 = ((PropertyDescriptor) DescriptorUtils.unwrapFakeOverride(r10)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(r11, "unwrapFakeOverride(possi…rriddenProperty).original");
        Method r12 = null;
        JvmFunctionSignature.KotlinFunction r13 = null;
        if ((r11 instanceof DeserializedPropertyDescriptor) == false) goto L9;
        DeserializedPropertyDescriptor r14 = (DeserializedPropertyDescriptor) r11;
        ProtoBuf.Property r15 = r14.getProto();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r16 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r16, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r17 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r15, r16);
        if (r17 != null) goto L7;
    L43:
        PropertyGetterDescriptor r18 = r11.getGetter();
        Intrinsics.checkNotNull(r18);
        JvmFunctionSignature.KotlinFunction r19 = mapJvmFunctionSignature(r18);
        PropertySetterDescriptor r20 = r11.getSetter();
        if (r20 == null) goto L47;
        r13 = mapJvmFunctionSignature(r20);
    L47:
        return new JvmPropertySignature.MappedKotlinProperty(r19, r13);
    L7:
        return new JvmPropertySignature.KotlinProperty(r11, r15, r17, r14.getNameResolver(), r14.getTypeTable());
    L9:
        if ((r11 instanceof JavaPropertyDescriptor) == false) goto L43;
        SourceElement r21 = ((JavaPropertyDescriptor) r11).getSource();
        if ((r21 instanceof JavaSourceElement) == false) goto L13;
        JavaSourceElement r22 = (JavaSourceElement) r21;
    L14:
        if (r22 == null) goto L16;
        JavaElement r23 = r22.getJavaElement();
    L18:
        if ((r23 instanceof ReflectJavaField) == false) goto L21;
        return new JvmPropertySignature.JavaField(((ReflectJavaField) r23).getMember());
    L21:
        if ((r23 instanceof ReflectJavaMethod) == false) goto L42;
        Method r24 = ((ReflectJavaMethod) r23).getMember();
        PropertySetterDescriptor r25 = r11.getSetter();
        if (r25 == null) goto L25;
        SourceElement r26 = r25.getSource();
    L27:
        if ((r26 instanceof JavaSourceElement) == false) goto L29;
        JavaSourceElement r27 = (JavaSourceElement) r26;
    L30:
        if (r27 == null) goto L32;
        JavaElement r28 = r27.getJavaElement();
    L34:
        if ((r28 instanceof ReflectJavaMethod) == false) goto L36;
        ReflectJavaMethod r29 = (ReflectJavaMethod) r28;
    L37:
        if (r29 == null) goto L40;
        r12 = r29.getMember();
    L40:
        return new JvmPropertySignature.JavaMethodProperty(r24, r12);
    L36:
        r29 = null;
        goto L37
    L32:
        r28 = null;
        goto L34
    L29:
        r27 = null;
        goto L30
    L25:
        r26 = null;
        goto L27
    L42:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + r11 + " (source = " + r23 + ')');
    L16:
        r23 = null;
        goto L18
    L13:
        r22 = null;
        goto L14
    }

    public final JvmFunctionSignature mapSignature(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "possiblySubstitutedFunction");
        FunctionDescriptor r11 = ((FunctionDescriptor) DescriptorUtils.unwrapFakeOverride(r10)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(r11, "unwrapFakeOverride(possi…titutedFunction).original");
        if ((r11 instanceof DeserializedCallableMemberDescriptor) == false) goto L21;
        DeserializedCallableMemberDescriptor r12 = (DeserializedCallableMemberDescriptor) r11;
        MessageLite r13 = r12.getProto();
        if ((r13 instanceof ProtoBuf.Function) == false) goto L11;
        JvmMemberSignature.Method r14 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) r13, r12.getNameResolver(), r12.getTypeTable());
        if (r14 == null) goto L11;
        return new JvmFunctionSignature.KotlinFunction(r14);
    L11:
        if ((r13 instanceof ProtoBuf.Constructor) == false) goto L20;
        JvmMemberSignature.Method r15 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) r13, r12.getNameResolver(), r12.getTypeTable());
        if (r15 == null) goto L20;
        DeclarationDescriptor r16 = r10.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r16, "possiblySubstitutedFunction.containingDeclaration");
        if (InlineClassesUtilsKt.isInlineClass(r16) == false) goto L18;
        return new JvmFunctionSignature.KotlinFunction(r15);
    L18:
        return new JvmFunctionSignature.KotlinConstructor(r15);
    L20:
        return mapJvmFunctionSignature(r11);
    L21:
        JavaElement r17 = null;
        ReflectJavaMethod r18 = null;
        if ((r11 instanceof JavaMethodDescriptor) == false) goto L41;
        SourceElement r19 = ((JavaMethodDescriptor) r11).getSource();
        if ((r19 instanceof JavaSourceElement) == false) goto L26;
        JavaSourceElement r20 = (JavaSourceElement) r19;
    L27:
        if (r20 == null) goto L29;
        JavaElement r21 = r20.getJavaElement();
    L31:
        if ((r21 instanceof ReflectJavaMethod) == false) goto L33;
        r18 = (ReflectJavaMethod) r21;
    L33:
        if (r18 == null) goto L39;
        Method r22 = r18.getMember();
        if (r22 == null) goto L39;
        return new JvmFunctionSignature.JavaMethod(r22);
    L39:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + r11);
    L29:
        r21 = null;
        goto L31
    L26:
        r20 = null;
        goto L27
    L41:
        if ((r11 instanceof JavaClassConstructorDescriptor) == false) goto L60;
        SourceElement r23 = ((JavaClassConstructorDescriptor) r11).getSource();
        if ((r23 instanceof JavaSourceElement) == false) goto L45;
        JavaSourceElement r24 = (JavaSourceElement) r23;
    L46:
        if (r24 == null) goto L49;
        r17 = r24.getJavaElement();
    L49:
        if ((r17 instanceof ReflectJavaConstructor) == false) goto L52;
        return new JvmFunctionSignature.JavaConstructor(((ReflectJavaConstructor) r17).getMember());
    L52:
        if ((r17 instanceof ReflectJavaClass) == false) goto L58;
        ReflectJavaClass r25 = (ReflectJavaClass) r17;
        if (r25.isAnnotationType() == false) goto L58;
        return new JvmFunctionSignature.FakeJavaAnnotationConstructor(r25.getElement());
    L58:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + r11 + " (" + r17 + ')');
    L45:
        r24 = null;
        goto L46
    L60:
        if (isKnownBuiltInFunction(r11) == false) goto L64;
        return mapJvmFunctionSignature(r11);
    L64:
        throw new KotlinReflectionInternalError("Unknown origin of " + r11 + " (" + r11.getClass() + ')');
    }
}
