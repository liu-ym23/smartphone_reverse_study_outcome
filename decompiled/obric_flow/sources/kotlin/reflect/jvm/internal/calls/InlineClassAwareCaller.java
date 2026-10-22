package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", NotificationCompat.CATEGORY_CALL, "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInlineClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n26#2:220\n1620#3,3:221\n*S KotlinDebug\n*F\n+ 1 InlineClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller\n*L\n53#1:220\n94#1:221,3\n*E\n"})
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(IntRange r5, Method[] r10, Method r11) {
            Intrinsics.checkNotNullParameter(r5, "argumentRange");
            Intrinsics.checkNotNullParameter(r10, "unbox");
            this.argumentRange = r5;
            this.unbox = r10;
            this.box = r11;
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
    public InlineClassAwareCaller(CallableMemberDescriptor r10, Caller<? extends M> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "caller");
        this.caller = r11;
        this.isDefault = r12;
        KotlinType r13 = r10.getReturnType();
        Intrinsics.checkNotNull(r13);
        Class<?> r14 = InlineClassAwareCallerKt.toInlineClass(r13);
        if (r14 == null) goto L5;
        Method r15 = InlineClassAwareCallerKt.getBoxMethod(r14, r10);
    L6:
        int r5 = 0;
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r10) == false) goto L9;
        BoxUnboxData r16 = new BoxUnboxData(IntRange.Companion.getEMPTY(), new Method[0], r15);
    L69:
        this.data = r16;
        return;
    L9:
        int r17 = -1;
        int r18 = 1;
        if ((r11 instanceof CallerImpl.Method.BoundStatic) == false) goto L13;
    L26:
        ArrayList r19 = new ArrayList();
        ReceiverParameterDescriptor r20 = r10.getExtensionReceiverParameter();
        if (r20 == null) goto L29;
        KotlinType r21 = r20.getType();
    L30:
        if (r21 == null) goto L33;
        r19.add(r21);
    L42:
        Iterator<T> r22 = r10.getValueParameters().iterator();
    L44:
        if (r22.hasNext() == false) goto L47;
        r19.add(((ValueParameterDescriptor) r22.next()).getType());
        goto L44
    L47:
        if (this.isDefault == false) goto L49;
        int r23 = ((r19.size() + 31) / 32) + 1;
    L51:
        if ((r10 instanceof FunctionDescriptor) == true) goto L53;
    L55:
        r18 = 0;
    L56:
        int r24 = (r19.size() + r17) + (r23 + r18);
        if (CallerKt.getArity(this) != r24) goto L72;
        IntRange r25 = RangesKt.until(Math.max(r17, 0), r19.size() + r17);
        Method[] r26 = new Method[r24];
    L59:
        if (r5 >= r24) goto L68;
        int r27 = r25.getFirst();
        if (r5 > r25.getLast()) goto L66;
        if (r27 > r5) goto L66;
        Class<?> r28 = InlineClassAwareCallerKt.toInlineClass((KotlinType) r19.get(r5 - r17));
        if (r28 == null) goto L66;
        Method r29 = InlineClassAwareCallerKt.getUnboxMethod(r28, r10);
    L67:
        r26[r5] = r29;
        r5 = r5 + 1;
    L66:
        r29 = null;
        goto L67
    L68:
        r16 = new BoxUnboxData(r25, r26, r15);
        goto L69
    L72:
        throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(this) + " != " + r24 + "\nCalling: " + r10 + "\nParameter types: " + getParameterTypes() + ")\nDefault: " + this.isDefault);
    L53:
        if (((FunctionDescriptor) r10).isSuspend() == false) goto L55;
    L49:
        r23 = 0;
        goto L51
    L33:
        if ((r10 instanceof ConstructorDescriptor) == false) goto L37;
        ClassDescriptor r30 = ((ConstructorDescriptor) r10).getConstructedClass();
        if (r30.isInner() == false) goto L42;
        DeclarationDescriptor r31 = r30.getContainingDeclaration();
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        r19.add(((ClassDescriptor) r31).getDefaultType());
        goto L42
    L37:
        DeclarationDescriptor r32 = r10.getContainingDeclaration();
        if ((r32 instanceof ClassDescriptor) == false) goto L42;
        if (InlineClassesUtilsKt.isInlineClass(r32) == false) goto L42;
        r19.add(((ClassDescriptor) r32).getDefaultType());
        goto L42
    L29:
        r21 = null;
        goto L30
    L13:
        if ((r10 instanceof ConstructorDescriptor) == false) goto L19;
        if ((r11 instanceof BoundCaller) == true) goto L26;
    L17:
        r17 = 0;
        goto L26
    L19:
        if (r10.getDispatchReceiverParameter() == null) goto L17;
        if ((r11 instanceof BoundCaller) == true) goto L17;
        if (InlineClassesUtilsKt.isInlineClass(r10.getContainingDeclaration()) == true) goto L17;
        r17 = 1;
        goto L26
    L5:
        r15 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        BoxUnboxData r5 = this.data;
        IntRange r11 = r5.component1();
        Method[] r12 = r5.component2();
        Method r13 = r5.component3();
        Object[] r14 = Arrays.copyOf(r10, r10.length);
        int r15 = r11.getFirst();
        int r16 = r11.getLast();
        if (r15 > r16) goto L12;
    L4:
        Method r17 = r12[r15];
        Object r18 = r10[r15];
        if (r17 == null) goto L9;
        if (r18 == null) goto L8;
        r18 = r17.invoke(r18, null);
        goto L9
    L8:
        r18 = UtilKt.defaultPrimitiveValue(r17.getReturnType());
    L9:
        r14[r15] = r18;
        if (r15 == r16) goto L12;
        r15 = r15 + 1;
    L12:
        Object r19 = this.caller.call(r14);
        if (r13 == null) goto L20;
        Object r20 = r13.invoke(null, new Object[]{r19});
        if (r20 != null) goto L18;
        return r19;
    L18:
        return r20;
    L20:
        return r19;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public M mo1394getMember() {
        return (M) this.caller.mo1394getMember();
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
