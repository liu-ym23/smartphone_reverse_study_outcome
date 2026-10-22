package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class KPropertyImplKt {
    public static final /* synthetic */ Caller access$computeCallerForAccessor(KPropertyImpl.Accessor r10, boolean r11) {
        return computeCallerForAccessor(r10, r11);
    }

    private static final Caller<?> computeCallerForAccessor(KPropertyImpl.Accessor<?, ?> r10, boolean r11) {
        if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(r10.getProperty().getSignature()) == true) goto L5;
        JvmPropertySignature r12 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(r10.getProperty().getDescriptor());
        if ((r12 instanceof JvmPropertySignature.KotlinProperty) == false) goto L58;
        JvmPropertySignature.KotlinProperty r13 = (JvmPropertySignature.KotlinProperty) r12;
        JvmProtoBuf.JvmPropertySignature r14 = r13.getSignature();
        if (r11 == false) goto L14;
        if (r14.hasGetter() == false) goto L16;
        JvmProtoBuf.JvmMethodSignature r15 = r14.getGetter();
    L17:
        if (r15 == null) goto L19;
        Method r16 = r10.getProperty().getContainer().findMethodBySignature(r13.getNameResolver().getString(r15.getName()), r13.getNameResolver().getString(r15.getDesc()));
    L20:
        if (r16 != null) goto L41;
        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(r10.getProperty().getDescriptor()) == true) goto L24;
    L35:
        Field r17 = r10.getProperty().getJavaField();
        if (r17 == null) goto L39;
    L60:
        Caller r18 = computeCallerForAccessor$computeFieldCaller(r10, r11, r17);
    L73:
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(r18, r10.getDescriptor(), false, 2, null);
    L39:
        throw new KotlinReflectionInternalError("No accessors or field is found for property " + r10.getProperty());
    L24:
        if (Intrinsics.areEqual(r10.getProperty().getDescriptor().getVisibility(), DescriptorVisibilities.INTERNAL) == false) goto L35;
        Class<?> r19 = InlineClassAwareCallerKt.toInlineClass(r10.getProperty().getDescriptor().getContainingDeclaration());
        if (r19 == null) goto L34;
        Method r20 = InlineClassAwareCallerKt.getUnboxMethod(r19, r10.getProperty().getDescriptor());
        if (r20 == null) goto L34;
        if (r10.isBound() == false) goto L32;
        r18 = new InternalUnderlyingValOfInlineClass.Bound(r20, getBoundReceiver(r10));
        goto L73
    L32:
        r18 = new InternalUnderlyingValOfInlineClass.Unbound(r20);
    L34:
        throw new KotlinReflectionInternalError("Underlying property of inline class " + r10.getProperty() + " should have a field");
    L41:
        if (Modifier.isStatic(r16.getModifiers()) == true) goto L48;
        if (r10.isBound() == false) goto L45;
        Caller r21 = new CallerImpl.Method.BoundInstance(r16, getBoundReceiver(r10));
    L46:
        r18 = r21;
        goto L73
    L45:
        r21 = new CallerImpl.Method.Instance(r16);
        goto L46
    L48:
        if (computeCallerForAccessor$isJvmStaticProperty(r10) == false) goto L54;
        if (r10.isBound() == false) goto L52;
        r21 = new CallerImpl.Method.BoundJvmStaticInObject(r16);
        goto L46
    L52:
        r21 = new CallerImpl.Method.JvmStaticInObject(r16);
        goto L46
    L54:
        if (r10.isBound() == false) goto L56;
        r21 = new CallerImpl.Method.BoundStatic(r16, getBoundReceiver(r10));
        goto L46
    L56:
        r21 = new CallerImpl.Method.Static(r16);
        goto L46
    L19:
        r16 = null;
    L16:
        r15 = null;
        goto L17
    L14:
        if (r14.hasSetter() == false) goto L16;
        r15 = r14.getSetter();
        goto L17
    L58:
        if ((r12 instanceof JvmPropertySignature.JavaField) == false) goto L62;
        r17 = ((JvmPropertySignature.JavaField) r12).getField();
        goto L60
    L62:
        if ((r12 instanceof JvmPropertySignature.JavaMethodProperty) == false) goto L77;
        JvmPropertySignature.JavaMethodProperty r22 = (JvmPropertySignature.JavaMethodProperty) r12;
        if (r11 == false) goto L66;
        Method r23 = r22.getGetterMethod();
    L69:
        if (r10.isBound() == false) goto L71;
        r18 = new CallerImpl.Method.BoundInstance(r23, getBoundReceiver(r10));
        goto L73
    L71:
        r18 = new CallerImpl.Method.Instance(r23);
        goto L73
    L66:
        r23 = r22.getSetterMethod();
        if (r23 != null) goto L69;
        throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + r22.getGetterMethod());
    L77:
        if ((r12 instanceof JvmPropertySignature.MappedKotlinProperty) == false) goto L95;
        JvmPropertySignature.MappedKotlinProperty r24 = (JvmPropertySignature.MappedKotlinProperty) r12;
        if (r11 == false) goto L81;
        JvmFunctionSignature.KotlinFunction r25 = r24.getGetterSignature();
    L83:
        Method r26 = r10.getProperty().getContainer().findMethodBySignature(r25.getMethodName(), r25.getMethodDesc());
        if (r26 == null) goto L91;
        Modifier.isStatic(r26.getModifiers());
        if (r10.isBound() == false) goto L89;
        return new CallerImpl.Method.BoundInstance(r26, getBoundReceiver(r10));
    L89:
        return new CallerImpl.Method.Instance(r26);
    L91:
        throw new KotlinReflectionInternalError("No accessor found for property " + r10.getProperty());
    L81:
        r25 = r24.getSetterSignature();
        if (r25 != null) goto L83;
        throw new KotlinReflectionInternalError("No setter found for property " + r10.getProperty());
    L95:
        throw new NoWhenBranchMatchedException();
    L5:
        return ThrowingCaller.INSTANCE;
    }

    private static final CallerImpl<Field> computeCallerForAccessor$computeFieldCaller(KPropertyImpl.Accessor<?, ?> r10, boolean r11, Field r12) {
        if (isJvmFieldPropertyInCompanionObject(r10.getProperty().getDescriptor()) == false) goto L5;
    L21:
        if (r11 == false) goto L27;
        if (r10.isBound() == false) goto L35;
        CallerImpl<Field> r13 = new CallerImpl.FieldGetter.BoundInstance(r12, getBoundReceiver(r10));
    L31:
        return r13;
    L35:
        return new CallerImpl.FieldGetter.Instance(r12);
    L27:
        if (r10.isBound() == false) goto L29;
        r13 = new CallerImpl.FieldSetter.BoundInstance(r12, computeCallerForAccessor$isNotNullProperty(r10), getBoundReceiver(r10));
        goto L31
    L29:
        r13 = new CallerImpl.FieldSetter.Instance(r12, computeCallerForAccessor$isNotNullProperty(r10));
        goto L31
    L5:
        if (Modifier.isStatic(r12.getModifiers()) == false) goto L21;
        if (computeCallerForAccessor$isJvmStaticProperty(r10) == false) goto L18;
        if (r11 == false) goto L15;
        if (r10.isBound() == false) goto L33;
        return new CallerImpl.FieldGetter.BoundJvmStaticInObject(r12);
    L33:
        return new CallerImpl.FieldGetter.JvmStaticInObject(r12);
    L15:
        if (r10.isBound() == false) goto L17;
        r13 = new CallerImpl.FieldSetter.BoundJvmStaticInObject(r12, computeCallerForAccessor$isNotNullProperty(r10));
        goto L31
    L17:
        r13 = new CallerImpl.FieldSetter.JvmStaticInObject(r12, computeCallerForAccessor$isNotNullProperty(r10));
        goto L31
    L18:
        if (r11 == true) goto L34;
        r13 = new CallerImpl.FieldSetter.Static(r12, computeCallerForAccessor$isNotNullProperty(r10));
        goto L31
    L34:
        return new CallerImpl.FieldGetter.Static(r12);
    }

    private static final boolean computeCallerForAccessor$isJvmStaticProperty(KPropertyImpl.Accessor<?, ?> r10) {
        return r10.getProperty().getDescriptor().getAnnotations().hasAnnotation(UtilKt.getJVM_STATIC());
    }

    private static final boolean computeCallerForAccessor$isNotNullProperty(KPropertyImpl.Accessor<?, ?> r10) {
        return !TypeUtils.isNullableType(r10.getProperty().getDescriptor().getType());
    }

    public static final Object getBoundReceiver(KPropertyImpl.Accessor<?, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getProperty().getBoundReceiver();
    }

    private static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor r10) {
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r11, "containingDeclaration");
        if (DescriptorUtils.isCompanionObject(r11) == true) goto L5;
        return false;
    L5:
        DeclarationDescriptor r12 = r11.getContainingDeclaration();
        if (DescriptorUtils.isInterface(r12) == true) goto L12;
        if (DescriptorUtils.isAnnotationClass(r12) == true) goto L12;
    L16:
        return true;
    L12:
        if ((r10 instanceof DeserializedPropertyDescriptor) == true) goto L14;
        return false;
    L14:
        if (JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) r10).getProto()) == true) goto L16;
        return false;
    }
}
