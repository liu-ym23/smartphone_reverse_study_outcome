package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InternalUnderlyingValOfInlineClass implements Caller<Method> {
    private final List<Type> parameterTypes;
    private final Type returnType;
    private final Method unboxMethod;

    public static final class Bound extends InternalUnderlyingValOfInlineClass implements BoundCaller {
        private final Object boundReceiver;

        public Bound(Method r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "unboxMethod");
            super(r10, CollectionsKt.emptyList(), null);
            this.boundReceiver = r11;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            return callMethod(this.boundReceiver, r10);
        }
    }

    public static final class Unbound extends InternalUnderlyingValOfInlineClass {
        public Unbound(Method r10) {
            Intrinsics.checkNotNullParameter(r10, "unboxMethod");
            super(r10, CollectionsKt.listOf(r10.getDeclaringClass()), null);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            Object r11 = r10[0];
            CallerImpl.Companion r12 = CallerImpl.Companion;
            if (r10.length > 1) goto L5;
            Object[] r13 = new Object[0];
        L7:
            return callMethod(r11, r13);
        L5:
            r13 = ArraysKt.copyOfRange(r10, 1, r10.length);
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
            goto L7
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InternalUnderlyingValOfInlineClass(Method r10, List<? extends Type> r11) {
        this.unboxMethod = r10;
        this.parameterTypes = r11;
        Class<?> r12 = r10.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r12, "unboxMethod.returnType");
        this.returnType = r12;
    }

    public /* synthetic */ InternalUnderlyingValOfInlineClass(Method r10, List r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    protected final Object callMethod(Object r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r11, "args");
        return this.unboxMethod.invoke(r10, Arrays.copyOf(r11, r11.length));
    }

    public void checkArguments(Object[] r10) {
        Caller.DefaultImpls.checkArguments(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo1315getMember() {
        return mo1315getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public final Method mo1315getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.returnType;
    }
}
