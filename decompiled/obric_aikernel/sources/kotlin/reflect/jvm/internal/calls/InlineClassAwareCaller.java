package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(IntRange r10, Method[] r11, Method r12) {
            Intrinsics.checkNotNullParameter(r10, "argumentRange");
            Intrinsics.checkNotNullParameter(r11, "unbox");
            this.argumentRange = r10;
            this.unbox = r11;
            this.box = r12;
        }

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InlineClassAwareCaller(CallableMemberDescriptor r11, Caller<? extends M> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "caller");
        this.caller = r12;
        this.isDefault = r13;
        KotlinType r14 = r11.getReturnType();
        Intrinsics.checkNotNull(r14);
        Class<?> r15 = InlineClassAwareCallerKt.toInlineClass(r14);
        if (r15 == null) goto L5;
        Method r16 = InlineClassAwareCallerKt.getBoxMethod(r15, r11);
    L7:
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r11) == false) goto L9;
        BoxUnboxData r17 = new BoxUnboxData(IntRange.Companion.getEMPTY(), new Method[0], r16);
    L73:
        this.data = r17;
        return;
    L9:
        int r10 = -1;
        if ((r12 instanceof CallerImpl.Method.BoundStatic) == false) goto L13;
    L26:
        ArrayList r18 = new ArrayList();
        ReceiverParameterDescriptor r19 = r11.getExtensionReceiverParameter();
        if (r19 == null) goto L29;
        KotlinType r20 = r19.getType();
    L30:
        if (r20 == null) goto L33;
    L31:
        r18.add(r20);
    L43:
        List<ValueParameterDescriptor> r21 = r11.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r21, "descriptor.valueParameters");
        Iterator<T> r22 = r21.iterator();
    L45:
        if (r22.hasNext() == false) goto L48;
        r18.add(((ValueParameterDescriptor) r22.next()).getType());
        goto L45
    L48:
        if (this.isDefault == false) goto L50;
        int r23 = (((r18.size() + 32) - 1) / 32) + 1;
    L52:
        if ((r11 instanceof FunctionDescriptor) == true) goto L54;
    L56:
        int r24 = 0;
    L57:
        int r25 = (r18.size() + r10) + (r23 + r24);
        if (CallerKt.getArity(this) != r25) goto L76;
        IntRange r26 = RangesKt.until(Math.max(r10, 0), r18.size() + r10);
        Method[] r27 = new Method[r25];
        int r28 = 0;
    L60:
        if (r28 >= r25) goto L72;
        int r29 = r26.getFirst();
        if (r28 > r26.getLast()) goto L65;
        if (r29 > r28) goto L65;
        boolean r30 = true;
    L66:
        if (r30 == false) goto L70;
        Class<?> r31 = InlineClassAwareCallerKt.toInlineClass((KotlinType) r18.get(r28 - r10));
        if (r31 == null) goto L70;
        Method r32 = InlineClassAwareCallerKt.getUnboxMethod(r31, r11);
    L71:
        r27[r28] = r32;
        r28 = r28 + 1;
    L70:
        r32 = null;
    L65:
        r30 = false;
        goto L66
    L72:
        r17 = new BoxUnboxData(r26, r27, r16);
        goto L73
    L76:
        throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(this) + " != " + r25 + "\nCalling: " + r11 + "\nParameter types: " + getParameterTypes() + ")\nDefault: " + this.isDefault);
    L54:
        if (((FunctionDescriptor) r11).isSuspend() == false) goto L56;
        r24 = 1;
        goto L57
    L50:
        r23 = 0;
        goto L52
    L33:
        if ((r11 instanceof ConstructorDescriptor) == false) goto L38;
        ClassDescriptor r33 = ((ConstructorDescriptor) r11).getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(r33, "descriptor.constructedClass");
        if (r33.isInner() == false) goto L43;
        DeclarationDescriptor r34 = r33.getContainingDeclaration();
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    L37:
        r20 = ((ClassDescriptor) r34).getDefaultType();
        goto L31
    L38:
        r34 = r11.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r34, "descriptor.containingDeclaration");
        if ((r34 instanceof ClassDescriptor) == false) goto L43;
        if (InlineClassesUtilsKt.isInlineClass(r34) == false) goto L43;
    L29:
        r20 = null;
        goto L30
    L13:
        if ((r11 instanceof ConstructorDescriptor) == false) goto L18;
        if ((r12 instanceof BoundCaller) == true) goto L26;
    L25:
        r10 = 0;
        goto L26
    L18:
        if (r11.getDispatchReceiverParameter() == null) goto L25;
        if ((r12 instanceof BoundCaller) == true) goto L25;
        DeclarationDescriptor r110 = r11.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r110, "descriptor.containingDeclaration");
        if (InlineClassesUtilsKt.isInlineClass(r110) == true) goto L25;
        r10 = 1;
        goto L26
    L5:
        r16 = null;
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        BoxUnboxData r11 = this.data;
        IntRange r12 = r11.component1();
        Method[] r13 = r11.component2();
        Method r14 = r11.component3();
        Object[] r15 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r15, "copyOf(this, size)");
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int r16 = r12.getFirst();
        int r17 = r12.getLast();
        if (r16 > r17) goto L12;
    L4:
        Method r18 = r13[r16];
        Object r19 = r10[r16];
        if (r18 == null) goto L9;
        if (r19 == null) goto L8;
        r19 = r18.invoke(r19, new Object[0]);
        goto L9
    L8:
        Class<?> r20 = r18.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r20, "method.returnType");
        r19 = UtilKt.defaultPrimitiveValue(r20);
    L9:
        r15[r16] = r19;
        if (r16 == r17) goto L12;
        r16 = r16 + 1;
    L12:
        Object r21 = this.caller.call(r15);
        if (r14 == null) goto L20;
        Object r110 = r14.invoke(null, new Object[]{r21});
        if (r110 != null) goto L18;
        return r21;
    L18:
        return r110;
    L20:
        return r21;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public M mo1315getMember() {
        return (M) this.caller.mo1315getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}
