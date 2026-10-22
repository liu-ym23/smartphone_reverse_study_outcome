package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInlineClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/InlineClassAwareCallerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n1747#2,3:220\n*S KotlinDebug\n*F\n+ 1 InlineClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/InlineClassAwareCallerKt\n*L\n156#1:220,3\n*E\n"})
public final class InlineClassAwareCallerKt {
    public static final Object coerceToExpectedReceiverType(Object r5, CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        if ((r10 instanceof PropertyDescriptor) == true) goto L5;
    L7:
        KotlinType r11 = getExpectedReceiverType(r10);
        if (r11 == null) goto L16;
        Class<?> r12 = toInlineClass(r11);
        if (r12 == null) goto L17;
        Method r13 = getUnboxMethod(r12, r10);
        if (r13 != null) goto L15;
        return r5;
    L15:
        return r13.invoke(r5, null);
    L17:
        return r5;
    L16:
        return r5;
    L5:
        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) r10) == false) goto L7;
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> Caller<M> createInlineClassAwareCallerIfNeeded(Caller<? extends M> r5, CallableMemberDescriptor r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r10) == true) goto L25;
        List<ValueParameterDescriptor> r12 = r10.getValueParameters();
        if (r12 != null) goto L7;
    L9:
        Iterator<T> r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        if (InlineClassesUtilsKt.isInlineClassType(((ValueParameterDescriptor) r13.next()).getType()) == false) goto L11;
    L15:
        KotlinType r14 = r10.getReturnType();
        if (r14 == null) goto L21;
        if (InlineClassesUtilsKt.isInlineClassType(r14) == true) goto L25;
    L21:
        if ((r5 instanceof BoundCaller) == false) goto L23;
        return r5;
    L23:
        if (hasInlineClassReceiver(r10) == true) goto L25;
        return r5;
    L7:
        if (r12.isEmpty() == false) goto L9;
    L25:
        return new InlineClassAwareCaller(r10, r5, r11);
    }

    public static /* synthetic */ Caller createInlineClassAwareCallerIfNeeded$default(Caller r5, CallableMemberDescriptor r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return createInlineClassAwareCallerIfNeeded(r5, r10, r11);
    }

    public static final Method getBoxMethod(Class<?> r5, CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        return r5.getDeclaredMethod("box-impl", new Class[]{getUnboxMethod(r5, r10).getReturnType()});
    L6:
        throw new KotlinReflectionInternalError("No box method found in inline class: " + r5 + " (calling " + r10 + ')');
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor r5) {
        ReceiverParameterDescriptor r10 = r5.getExtensionReceiverParameter();
        ReceiverParameterDescriptor r11 = r5.getDispatchReceiverParameter();
        if (r10 == null) goto L6;
        return r10.getType();
    L6:
        if (r11 != null) goto L9;
    L19:
        return null;
    L9:
        if ((r5 instanceof ConstructorDescriptor) == true) goto L20;
        DeclarationDescriptor r12 = r5.getContainingDeclaration();
        if ((r12 instanceof ClassDescriptor) == false) goto L14;
        ClassDescriptor r13 = (ClassDescriptor) r12;
    L15:
        if (r13 == null) goto L19;
        return r13.getDefaultType();
    L14:
        r13 = null;
        goto L15
    L20:
        return r11.getType();
    }

    public static final Method getUnboxMethod(Class<?> r5, CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        return r5.getDeclaredMethod("unbox-impl", null);
    L6:
        throw new KotlinReflectionInternalError("No unbox method found in inline class: " + r5 + " (calling " + r10 + ')');
    }

    private static final boolean hasInlineClassReceiver(CallableMemberDescriptor r5) {
        KotlinType r10 = getExpectedReceiverType(r5);
        if (r10 != null) goto L5;
        return false;
    L5:
        if (InlineClassesUtilsKt.isInlineClassType(r10) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static final Class<?> toInlineClass(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class<?> r10 = toInlineClass(r5.getConstructor().mo1402getDeclarationDescriptor());
        if (r10 != null) goto L6;
        return null;
    L6:
        if (TypeUtils.isNullableType(r5) == true) goto L8;
        return r10;
    L8:
        KotlinType r11 = InlineClassesUtilsKt.unsubstitutedUnderlyingType(r5);
        if (r11 != null) goto L12;
        return null;
    L12:
        if (TypeUtils.isNullableType(r11) == false) goto L14;
    L16:
        return null;
    L14:
        if (KotlinBuiltIns.isPrimitiveType(r11) == true) goto L16;
        return r10;
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor r5) {
        if ((r5 instanceof ClassDescriptor) == true) goto L5;
    L11:
        return null;
    L5:
        if (InlineClassesUtilsKt.isInlineClass(r5) == false) goto L11;
        ClassDescriptor r10 = (ClassDescriptor) r5;
        Class<?> r11 = UtilKt.toJavaClass(r10);
        if (r11 == null) goto L10;
        return r11;
    L10:
        throw new KotlinReflectionInternalError("Class object for the class " + r10.getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) r5) + ')');
    }
}
