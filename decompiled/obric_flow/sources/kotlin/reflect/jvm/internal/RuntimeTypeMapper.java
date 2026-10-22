package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
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
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRuntimeTypeMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/RuntimeTypeMapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1#2:284\n*E\n"})
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = null;
    private static final ClassId JAVA_LANG_VOID = null;

    static {
        INSTANCE = new RuntimeTypeMapper();
        JAVA_LANG_VOID = ClassId.topLevel(new FqName("java.lang.Void"));
    }

    private RuntimeTypeMapper() {
    }

    private final PrimitiveType getPrimitiveType(Class<?> r5) {
        if (r5.isPrimitive() == true) goto L7;
        return null;
    L7:
        return JvmPrimitiveType.get(r5.getSimpleName()).getPrimitiveType();
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor r5) {
        if (DescriptorFactory.isEnumValueOfMethod(r5) == false) goto L5;
    L14:
        return true;
    L5:
        if (DescriptorFactory.isEnumValuesMethod(r5) == true) goto L14;
        if (Intrinsics.areEqual(r5.getName(), CloneableClassScope.Companion.getCLONE_NAME()) == true) goto L10;
        return false;
    L10:
        if (r5.getValueParameters().isEmpty() == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor r10) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(r10), MethodSignatureMappingKt.computeJvmDescriptor$default(r10, false, false, 1, null)));
    }

    private final String mapName(CallableMemberDescriptor r5) {
        String r10 = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        if ((r5 instanceof PropertyGetterDescriptor) == false) goto L8;
        return JvmAbi.getterName(DescriptorUtilsKt.getPropertyIfAccessor(r5).getName().asString());
    L8:
        if ((r5 instanceof PropertySetterDescriptor) == false) goto L11;
        return JvmAbi.setterName(DescriptorUtilsKt.getPropertyIfAccessor(r5).getName().asString());
    L11:
        return r5.getName().asString();
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        if (r5.isArray() == false) goto L11;
        PrimitiveType r10 = getPrimitiveType(r5.getComponentType());
        if (r10 == null) goto L9;
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r10.getArrayTypeName());
    L9:
        return ClassId.topLevel(StandardNames.FqNames.array.toSafe());
    L11:
        if (Intrinsics.areEqual(r5, Void.TYPE) == true) goto L13;
        PrimitiveType r11 = getPrimitiveType(r5);
        if (r11 != null) goto L17;
        ClassId r12 = ReflectClassUtilKt.getClassId(r5);
        if (r12.isLocal() == true) goto L23;
        ClassId r13 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r12.asSingleFqName());
        if (r13 == null) goto L23;
        return r13;
    L23:
        return r12;
    L17:
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r11.getTypeName());
    L13:
        return JAVA_LANG_VOID;
    }

    public final JvmPropertySignature mapPropertySignature(PropertyDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "possiblyOverriddenProperty");
        PropertyDescriptor r5 = ((PropertyDescriptor) DescriptorUtils.unwrapFakeOverride(r10)).getOriginal();
        Method r11 = null;
        JvmFunctionSignature.KotlinFunction r12 = null;
        if ((r5 instanceof DeserializedPropertyDescriptor) == false) goto L9;
        DeserializedPropertyDescriptor r13 = (DeserializedPropertyDescriptor) r5;
        ProtoBuf.Property r14 = r13.getProto();
        JvmProtoBuf.JvmPropertySignature r15 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r14, JvmProtoBuf.propertySignature);
        if (r15 != null) goto L7;
    L43:
        PropertyGetterDescriptor r16 = r5.getGetter();
        Intrinsics.checkNotNull(r16);
        JvmFunctionSignature.KotlinFunction r17 = mapJvmFunctionSignature(r16);
        PropertySetterDescriptor r18 = r5.getSetter();
        if (r18 == null) goto L47;
        r12 = mapJvmFunctionSignature(r18);
    L47:
        return new JvmPropertySignature.MappedKotlinProperty(r17, r12);
    L7:
        return new JvmPropertySignature.KotlinProperty(r5, r14, r15, r13.getNameResolver(), r13.getTypeTable());
    L9:
        if ((r5 instanceof JavaPropertyDescriptor) == false) goto L43;
        SourceElement r19 = ((JavaPropertyDescriptor) r5).getSource();
        if ((r19 instanceof JavaSourceElement) == false) goto L13;
        JavaSourceElement r20 = (JavaSourceElement) r19;
    L14:
        if (r20 == null) goto L16;
        JavaElement r21 = r20.getJavaElement();
    L18:
        if ((r21 instanceof ReflectJavaField) == false) goto L21;
        return new JvmPropertySignature.JavaField(((ReflectJavaField) r21).getMember());
    L21:
        if ((r21 instanceof ReflectJavaMethod) == false) goto L42;
        Method r22 = ((ReflectJavaMethod) r21).getMember();
        PropertySetterDescriptor r23 = r5.getSetter();
        if (r23 == null) goto L25;
        SourceElement r24 = r23.getSource();
    L27:
        if ((r24 instanceof JavaSourceElement) == false) goto L29;
        JavaSourceElement r25 = (JavaSourceElement) r24;
    L30:
        if (r25 == null) goto L32;
        JavaElement r26 = r25.getJavaElement();
    L34:
        if ((r26 instanceof ReflectJavaMethod) == false) goto L36;
        ReflectJavaMethod r27 = (ReflectJavaMethod) r26;
    L37:
        if (r27 == null) goto L40;
        r11 = r27.getMember();
    L40:
        return new JvmPropertySignature.JavaMethodProperty(r22, r11);
    L36:
        r27 = null;
        goto L37
    L32:
        r26 = null;
        goto L34
    L29:
        r25 = null;
        goto L30
    L25:
        r24 = null;
        goto L27
    L42:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + r5 + " (source = " + r21 + ')');
    L16:
        r21 = null;
        goto L18
    L13:
        r20 = null;
        goto L14
    }

    public final JvmFunctionSignature mapSignature(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "possiblySubstitutedFunction");
        FunctionDescriptor r5 = ((FunctionDescriptor) DescriptorUtils.unwrapFakeOverride(r10)).getOriginal();
        if ((r5 instanceof DeserializedCallableMemberDescriptor) == false) goto L21;
        DeserializedCallableMemberDescriptor r11 = (DeserializedCallableMemberDescriptor) r5;
        MessageLite r12 = r11.getProto();
        if ((r12 instanceof ProtoBuf.Function) == false) goto L11;
        JvmMemberSignature.Method r13 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) r12, r11.getNameResolver(), r11.getTypeTable());
        if (r13 == null) goto L11;
        return new JvmFunctionSignature.KotlinFunction(r13);
    L11:
        if ((r12 instanceof ProtoBuf.Constructor) == false) goto L20;
        JvmMemberSignature.Method r14 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) r12, r11.getNameResolver(), r11.getTypeTable());
        if (r14 == null) goto L20;
        if (InlineClassesUtilsKt.isInlineClass(r10.getContainingDeclaration()) == false) goto L18;
        return new JvmFunctionSignature.KotlinFunction(r14);
    L18:
        return new JvmFunctionSignature.KotlinConstructor(r14);
    L20:
        return mapJvmFunctionSignature(r5);
    L21:
        JavaElement r15 = null;
        ReflectJavaMethod r16 = null;
        if ((r5 instanceof JavaMethodDescriptor) == false) goto L41;
        SourceElement r17 = ((JavaMethodDescriptor) r5).getSource();
        if ((r17 instanceof JavaSourceElement) == false) goto L26;
        JavaSourceElement r18 = (JavaSourceElement) r17;
    L27:
        if (r18 == null) goto L29;
        JavaElement r19 = r18.getJavaElement();
    L31:
        if ((r19 instanceof ReflectJavaMethod) == false) goto L33;
        r16 = (ReflectJavaMethod) r19;
    L33:
        if (r16 == null) goto L39;
        Method r20 = r16.getMember();
        if (r20 == null) goto L39;
        return new JvmFunctionSignature.JavaMethod(r20);
    L39:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + r5);
    L29:
        r19 = null;
        goto L31
    L26:
        r18 = null;
        goto L27
    L41:
        if ((r5 instanceof JavaClassConstructorDescriptor) == false) goto L60;
        SourceElement r21 = ((JavaClassConstructorDescriptor) r5).getSource();
        if ((r21 instanceof JavaSourceElement) == false) goto L45;
        JavaSourceElement r22 = (JavaSourceElement) r21;
    L46:
        if (r22 == null) goto L49;
        r15 = r22.getJavaElement();
    L49:
        if ((r15 instanceof ReflectJavaConstructor) == false) goto L52;
        return new JvmFunctionSignature.JavaConstructor(((ReflectJavaConstructor) r15).getMember());
    L52:
        if ((r15 instanceof ReflectJavaClass) == false) goto L58;
        ReflectJavaClass r23 = (ReflectJavaClass) r15;
        if (r23.isAnnotationType() == false) goto L58;
        return new JvmFunctionSignature.FakeJavaAnnotationConstructor(r23.getElement());
    L58:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + r5 + " (" + r15 + ')');
    L45:
        r22 = null;
        goto L46
    L60:
        if (isKnownBuiltInFunction(r5) == false) goto L64;
        return mapJvmFunctionSignature(r5);
    L64:
        throw new KotlinReflectionInternalError("Unknown origin of " + r5 + " (" + r5.getClass() + ')');
    }
}
