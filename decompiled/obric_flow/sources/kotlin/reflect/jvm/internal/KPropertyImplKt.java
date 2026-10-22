package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKPropertyImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KPropertyImpl.kt\nkotlin/reflect/jvm/internal/KPropertyImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
public final class KPropertyImplKt {
    public static final /* synthetic */ Caller access$computeCallerForAccessor(KPropertyImpl.Accessor r5, boolean r10) {
        return computeCallerForAccessor(r5, r10);
    }

    private static final Caller<?> computeCallerForAccessor(KPropertyImpl.Accessor<?, ?> r10, boolean r11) {
        if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(r10.getProperty().getSignature()) == true) goto L5;
        JvmPropertySignature r5 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(r10.getProperty().getDescriptor());
        if ((r5 instanceof JvmPropertySignature.KotlinProperty) == false) goto L58;
        JvmPropertySignature.KotlinProperty r12 = (JvmPropertySignature.KotlinProperty) r5;
        JvmProtoBuf.JvmPropertySignature r13 = r12.getSignature();
        if (r11 == false) goto L15;
        if (r13.hasGetter() == false) goto L13;
        JvmProtoBuf.JvmMethodSignature r14 = r13.getGetter();
    L17:
        if (r14 == null) goto L19;
        Method r15 = r10.getProperty().getContainer().findMethodBySignature(r12.getNameResolver().getString(r14.getName()), r12.getNameResolver().getString(r14.getDesc()));
    L20:
        if (r15 != null) goto L41;
        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(r10.getProperty().getDescriptor()) == true) goto L24;
    L35:
        Field r16 = r10.getProperty().getJavaField();
        if (r16 == null) goto L39;
        Caller r17 = computeCallerForAccessor$computeFieldCaller(r10, r11, r16);
    L71:
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(r17, r10.getDescriptor(), false, 2, null);
    L39:
        throw new KotlinReflectionInternalError("No accessors or field is found for property " + r10.getProperty());
    L24:
        if (Intrinsics.areEqual(r10.getProperty().getDescriptor().getVisibility(), DescriptorVisibilities.INTERNAL) == false) goto L35;
        Class<?> r18 = InlineClassAwareCallerKt.toInlineClass(r10.getProperty().getDescriptor().getContainingDeclaration());
        if (r18 == null) goto L34;
        Method r19 = InlineClassAwareCallerKt.getUnboxMethod(r18, r10.getProperty().getDescriptor());
        if (r19 == null) goto L34;
        if (r10.isBound() == false) goto L32;
        r17 = new InternalUnderlyingValOfInlineClass.Bound(r19, getBoundReceiver(r10));
        goto L71
    L32:
        r17 = new InternalUnderlyingValOfInlineClass.Unbound(r19);
    L34:
        throw new KotlinReflectionInternalError("Underlying property of inline class " + r10.getProperty() + " should have a field");
    L41:
        if (Modifier.isStatic(r15.getModifiers()) == true) goto L48;
        if (r10.isBound() == false) goto L46;
        Caller r20 = new CallerImpl.Method.BoundInstance(r15, getBoundReceiver(r10));
    L45:
        r17 = r20;
        goto L71
    L46:
        r20 = new CallerImpl.Method.Instance(r15);
        goto L45
    L48:
        if (computeCallerForAccessor$isJvmStaticProperty(r10) == false) goto L54;
        if (r10.isBound() == false) goto L52;
        r20 = new CallerImpl.Method.BoundJvmStaticInObject(r15);
        goto L45
    L52:
        r20 = new CallerImpl.Method.JvmStaticInObject(r15);
        goto L45
    L54:
        if (r10.isBound() == false) goto L56;
        r20 = new CallerImpl.Method.BoundStatic(r15, getBoundReceiver(r10));
        goto L45
    L56:
        r20 = new CallerImpl.Method.Static(r15);
        goto L45
    L19:
        r15 = null;
    L13:
        r14 = null;
        goto L17
    L15:
        if (r13.hasSetter() == false) goto L13;
        r14 = r13.getSetter();
        goto L17
    L58:
        if ((r5 instanceof JvmPropertySignature.JavaField) == false) goto L61;
        r17 = computeCallerForAccessor$computeFieldCaller(r10, r11, ((JvmPropertySignature.JavaField) r5).getField());
        goto L71
    L61:
        if ((r5 instanceof JvmPropertySignature.JavaMethodProperty) == false) goto L75;
        if (r11 == false) goto L64;
        Method r21 = ((JvmPropertySignature.JavaMethodProperty) r5).getGetterMethod();
    L67:
        if (r10.isBound() == false) goto L69;
        r17 = new CallerImpl.Method.BoundInstance(r21, getBoundReceiver(r10));
        goto L71
    L69:
        r17 = new CallerImpl.Method.Instance(r21);
        goto L71
    L64:
        JvmPropertySignature.JavaMethodProperty r22 = (JvmPropertySignature.JavaMethodProperty) r5;
        r21 = r22.getSetterMethod();
        if (r21 != null) goto L67;
        throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + r22.getGetterMethod());
    L75:
        if ((r5 instanceof JvmPropertySignature.MappedKotlinProperty) == false) goto L92;
        if (r11 == false) goto L78;
        JvmFunctionSignature.KotlinFunction r23 = ((JvmPropertySignature.MappedKotlinProperty) r5).getGetterSignature();
    L80:
        Method r24 = r10.getProperty().getContainer().findMethodBySignature(r23.getMethodName(), r23.getMethodDesc());
        if (r24 == null) goto L88;
        Modifier.isStatic(r24.getModifiers());
        if (r10.isBound() == false) goto L86;
        return new CallerImpl.Method.BoundInstance(r24, getBoundReceiver(r10));
    L86:
        return new CallerImpl.Method.Instance(r24);
    L88:
        throw new KotlinReflectionInternalError("No accessor found for property " + r10.getProperty());
    L78:
        r23 = ((JvmPropertySignature.MappedKotlinProperty) r5).getSetterSignature();
        if (r23 != null) goto L80;
        throw new KotlinReflectionInternalError("No setter found for property " + r10.getProperty());
    L92:
        throw new NoWhenBranchMatchedException();
    L5:
        return ThrowingCaller.INSTANCE;
    }

    private static final CallerImpl<Field> computeCallerForAccessor$computeFieldCaller(KPropertyImpl.Accessor<?, ?> r5, boolean r10, Field r11) {
        if (isJvmFieldPropertyInCompanionObject(r5.getProperty().getDescriptor()) == false) goto L5;
    L22:
        if (r10 == false) goto L28;
        if (r5.isBound() == false) goto L35;
        CallerImpl<Field> r12 = new CallerImpl.FieldGetter.BoundInstance(r11, getBoundReceiver(r5));
    L33:
        return r12;
    L35:
        return new CallerImpl.FieldGetter.Instance(r11);
    L28:
        if (r5.isBound() == false) goto L30;
        r12 = new CallerImpl.FieldSetter.BoundInstance(r11, computeCallerForAccessor$isNotNullProperty(r5), getBoundReceiver(r5));
        goto L33
    L30:
        r12 = new CallerImpl.FieldSetter.Instance(r11, computeCallerForAccessor$isNotNullProperty(r5));
        goto L33
    L5:
        if (Modifier.isStatic(r11.getModifiers()) == false) goto L22;
        if (computeCallerForAccessor$isJvmStaticProperty(r5) == false) goto L19;
        if (r10 == false) goto L15;
        if (r5.isBound() == false) goto L32;
        return new CallerImpl.FieldGetter.BoundJvmStaticInObject(r11);
    L32:
        return new CallerImpl.FieldGetter.JvmStaticInObject(r11);
    L15:
        if (r5.isBound() == false) goto L18;
        r12 = new CallerImpl.FieldSetter.BoundJvmStaticInObject(r11, computeCallerForAccessor$isNotNullProperty(r5));
        goto L33
    L18:
        r12 = new CallerImpl.FieldSetter.JvmStaticInObject(r11, computeCallerForAccessor$isNotNullProperty(r5));
        goto L33
    L19:
        if (r10 == true) goto L34;
        r12 = new CallerImpl.FieldSetter.Static(r11, computeCallerForAccessor$isNotNullProperty(r5));
        goto L33
    L34:
        return new CallerImpl.FieldGetter.Static(r11);
    }

    private static final boolean computeCallerForAccessor$isJvmStaticProperty(KPropertyImpl.Accessor<?, ?> r5) {
        return r5.getProperty().getDescriptor().getAnnotations().hasAnnotation(UtilKt.getJVM_STATIC());
    }

    private static final boolean computeCallerForAccessor$isNotNullProperty(KPropertyImpl.Accessor<?, ?> r5) {
        return !TypeUtils.isNullableType(r5.getProperty().getDescriptor().getType());
    }

    public static final Object getBoundReceiver(KPropertyImpl.Accessor<?, ?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getProperty().getBoundReceiver();
    }

    private static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor r5) {
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        if (DescriptorUtils.isCompanionObject(r10) == true) goto L5;
        return false;
    L5:
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        if (DescriptorUtils.isInterface(r11) == true) goto L12;
        if (DescriptorUtils.isAnnotationClass(r11) == true) goto L12;
    L16:
        return true;
    L12:
        if ((r5 instanceof DeserializedPropertyDescriptor) == true) goto L14;
        return false;
    L14:
        if (JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) r5).getProto()) == true) goto L16;
        return false;
    }
}
