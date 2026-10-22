package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassAwareCallerKt {
    public static final Object coerceToExpectedReceiverType(Object r10, CallableMemberDescriptor r11) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        if ((r11 instanceof PropertyDescriptor) == true) goto L5;
    L7:
        KotlinType r12 = getExpectedReceiverType(r11);
        if (r12 == null) goto L16;
        Class<?> r13 = toInlineClass(r12);
        if (r13 == null) goto L17;
        Method r14 = getUnboxMethod(r13, r11);
        if (r14 != null) goto L15;
        return r10;
    L15:
        return r14.invoke(r10, new Object[0]);
    L17:
        return r10;
    L16:
        return r10;
    L5:
        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) r11) == false) goto L7;
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> Caller<M> createInlineClassAwareCallerIfNeeded(Caller<? extends M> r10, CallableMemberDescriptor r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        boolean r13 = true;
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r11) == true) goto L29;
        List<ValueParameterDescriptor> r14 = r11.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "descriptor.valueParameters");
        if ((r14 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L8;
        KotlinType r16 = ((ValueParameterDescriptor) r15.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r16, "it.type");
        if (InlineClassesUtilsKt.isInlineClassType(r16) == false) goto L11;
        boolean r17 = true;
    L15:
        if (r17 == true) goto L29;
        KotlinType r18 = r11.getReturnType();
        if (r18 != null) goto L19;
    L21:
        boolean r19 = false;
    L22:
        if (r19 == true) goto L29;
        if ((r10 instanceof BoundCaller) == false) goto L26;
    L28:
        r13 = false;
        goto L29
    L26:
        if (hasInlineClassReceiver(r11) == false) goto L28;
    L19:
        if (InlineClassesUtilsKt.isInlineClassType(r18) != true) goto L21;
        r19 = true;
    L8:
        r17 = false;
        goto L15
    L7:
        if (r14.isEmpty() == false) goto L9;
    L29:
        if (r13 == true) goto L31;
        return r10;
    L31:
        return new InlineClassAwareCaller(r11, r10, r12);
    }

    public static /* synthetic */ Caller createInlineClassAwareCallerIfNeeded$default(Caller r10, CallableMemberDescriptor r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return createInlineClassAwareCallerIfNeeded(r10, r11, r12);
    }

    public static final Method getBoxMethod(Class<?> r10, CallableMemberDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Method r12 = r10.getDeclaredMethod("box-impl", new Class[]{getUnboxMethod(r10, r11).getReturnType()});     // Catch: NoSuchMethodException -> L5
        Intrinsics.checkNotNullExpressionValue(r12, "{\n        getDeclaredMet…riptor).returnType)\n    }");     // Catch: NoSuchMethodException -> L5
        return r12;
    L6:
        throw new KotlinReflectionInternalError("No box method found in inline class: " + r10 + " (calling " + r11 + ')');
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor r10) {
        ReceiverParameterDescriptor r11 = r10.getExtensionReceiverParameter();
        ReceiverParameterDescriptor r12 = r10.getDispatchReceiverParameter();
        if (r11 != null) goto L17;
        if (r12 != null) goto L8;
        return null;
    L8:
        if ((r10 instanceof ConstructorDescriptor) == true) goto L18;
        DeclarationDescriptor r13 = r10.getContainingDeclaration();
        if ((r13 instanceof ClassDescriptor) == false) goto L13;
        ClassDescriptor r14 = (ClassDescriptor) r13;
    L14:
        if (r14 != null) goto L16;
        return null;
    L16:
        return r14.getDefaultType();
    L13:
        r14 = null;
        goto L14
    L18:
        return r12.getType();
    L17:
        return r11.getType();
    }

    public static final Method getUnboxMethod(Class<?> r10, CallableMemberDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Method r12 = r10.getDeclaredMethod("unbox-impl", new Class[0]);     // Catch: NoSuchMethodException -> L5
        Intrinsics.checkNotNullExpressionValue(r12, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");     // Catch: NoSuchMethodException -> L5
        return r12;
    L6:
        throw new KotlinReflectionInternalError("No unbox method found in inline class: " + r10 + " (calling " + r11 + ')');
    }

    private static final boolean hasInlineClassReceiver(CallableMemberDescriptor r10) {
        KotlinType r11 = getExpectedReceiverType(r10);
        if (r11 == null) goto L8;
        if (InlineClassesUtilsKt.isInlineClassType(r11) != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor r10) {
        if ((r10 instanceof ClassDescriptor) == true) goto L5;
    L11:
        return null;
    L5:
        if (InlineClassesUtilsKt.isInlineClass(r10) == false) goto L11;
        ClassDescriptor r11 = (ClassDescriptor) r10;
        Class<?> r12 = UtilKt.toJavaClass(r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new KotlinReflectionInternalError("Class object for the class " + r11.getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) r10) + ')');
    }

    public static final Class<?> toInlineClass(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<?> r11 = toInlineClass(r10.getConstructor().mo1323getDeclarationDescriptor());
        if (r11 != null) goto L6;
        return null;
    L6:
        if (TypeUtils.isNullableType(r10) == true) goto L8;
        return r11;
    L8:
        KotlinType r12 = InlineClassesUtilsKt.unsubstitutedUnderlyingType(r10);
        if (r12 != null) goto L12;
        return null;
    L12:
        if (TypeUtils.isNullableType(r12) == false) goto L14;
    L16:
        return null;
    L14:
        if (KotlinBuiltIns.isPrimitiveType(r12) == true) goto L16;
        return r11;
    }
}
