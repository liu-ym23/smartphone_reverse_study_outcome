package kotlin.reflect.jvm.internal.calls;

import com.bytedance.crash.event.EnsureReportData;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CallerImpl<M extends Member> implements Caller<M> {
    public static final Companion Companion = null;
    private final Class<?> instanceClass;
    private final M member;
    private final List<Type> parameterTypes;
    private final Type returnType;

    public static final class AccessorForHiddenBoundConstructor extends CallerImpl<java.lang.reflect.Constructor<?>> implements BoundCaller {
        private final Object boundReceiver;

        public AccessorForHiddenBoundConstructor(java.lang.reflect.Constructor<?> r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "constructor");
            Class<?> r12 = r10.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(r12, "constructor.declaringClass");
            Type[] r13 = r10.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r13, "constructor.genericParameterTypes");
            if (r13.length > 2) goto L5;
            Object r14 = new Type[0];
        L6:
            Class r15 = null;
            super(r10, r12, r15, (Type[]) r14, null);
            this.boundReceiver = r11;
            return;
        L5:
            r14 = ArraysKt.copyOfRange(r13, 1, r13.length - 1);
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirstAndLast>");
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            java.lang.reflect.Constructor<?> r11 = mo1315getMember();
            SpreadBuilder r12 = new SpreadBuilder(3);
            r12.add(this.boundReceiver);
            r12.addSpread(r10);
            r12.add(null);
            return r11.newInstance(r12.toArray(new Object[r12.size()]));
        }
    }

    public static final class AccessorForHiddenConstructor extends CallerImpl<java.lang.reflect.Constructor<?>> {
        public AccessorForHiddenConstructor(java.lang.reflect.Constructor<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "constructor");
            Class<?> r11 = r10.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(r11, "constructor.declaringClass");
            Type[] r12 = r10.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r12, "constructor.genericParameterTypes");
            if (r12.length > 1) goto L5;
            Object r13 = new Type[0];
        L6:
            Class r14 = null;
            super(r10, r11, r14, (Type[]) r13, null);
            return;
        L5:
            r13 = ArraysKt.copyOfRange(r12, 0, r12.length - 1);
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropLast>");
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            java.lang.reflect.Constructor<?> r11 = mo1315getMember();
            SpreadBuilder r12 = new SpreadBuilder(2);
            r12.addSpread(r10);
            r12.add(null);
            return r11.newInstance(r12.toArray(new Object[r12.size()]));
        }
    }

    public static final class BoundConstructor extends CallerImpl<java.lang.reflect.Constructor<?>> implements BoundCaller {
        private final Object boundReceiver;

        public BoundConstructor(java.lang.reflect.Constructor<?> r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "constructor");
            Class<?> r12 = r10.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(r12, "constructor.declaringClass");
            Type[] r13 = r10.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r13, "constructor.genericParameterTypes");
            super(r10, r12, null, r13, null);
            this.boundReceiver = r11;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            java.lang.reflect.Constructor<?> r11 = mo1315getMember();
            SpreadBuilder r12 = new SpreadBuilder(2);
            r12.add(this.boundReceiver);
            r12.addSpread(r10);
            return r11.newInstance(r12.toArray(new Object[r12.size()]));
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class Constructor extends CallerImpl<java.lang.reflect.Constructor<?>> {
        public Constructor(java.lang.reflect.Constructor<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "constructor");
            Class<?> r11 = r10.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(r11, "constructor.declaringClass");
            Class<?> r12 = r10.getDeclaringClass();
            Class<?> r13 = r12.getDeclaringClass();
            if (r13 != null) goto L5;
        L7:
            Class<?> r14 = null;
        L8:
            Type[] r15 = r10.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r15, "constructor.genericParameterTypes");
            super(r10, r11, r14, r15, null);
            return;
        L5:
            if (Modifier.isStatic(r12.getModifiers()) == true) goto L7;
            r14 = r13;
            goto L8
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            return mo1315getMember().newInstance(Arrays.copyOf(r10, r10.length));
        }
    }

    public static abstract class FieldGetter extends CallerImpl<Field> {

        public static final class BoundInstance extends FieldGetter implements BoundCaller {
            private final Object boundReceiver;

            public BoundInstance(Field r10, Object r11) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, false, null);
                this.boundReceiver = r11;
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter, kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                return mo1315getMember().get(this.boundReceiver);
            }
        }

        public static final class BoundJvmStaticInObject extends FieldGetter implements BoundCaller {
            public BoundJvmStaticInObject(Field r10) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, false, null);
            }
        }

        public static final class Instance extends FieldGetter {
            public Instance(Field r10) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, true, null);
            }
        }

        public static final class JvmStaticInObject extends FieldGetter {
            public JvmStaticInObject(Field r10) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, true, null);
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl
            public void checkArguments(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                super.checkArguments(r10);
                checkObjectInstance(ArraysKt.firstOrNull(r10));
            }
        }

        public static final class Static extends FieldGetter {
            public Static(Field r10) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, false, null);
            }
        }

        private FieldGetter(Field r10, boolean r11) {
            Type r12 = r10.getGenericType();
            Intrinsics.checkNotNullExpressionValue(r12, "field.genericType");
            if (r11 == false) goto L5;
            Class<?> r13 = r10.getDeclaringClass();
        L6:
            super(r10, r12, r13, new Type[0], null);
            return;
        L5:
            r13 = null;
            goto L6
        }

        public /* synthetic */ FieldGetter(Field r10, boolean r11, DefaultConstructorMarker r12) {
            this(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            Field r11 = mo1315getMember();
            if (getInstanceClass() == null) goto L5;
            Object r12 = ArraysKt.first(r10);
        L7:
            return r11.get(r12);
        L5:
            r12 = null;
            goto L7
        }
    }

    public static abstract class FieldSetter extends CallerImpl<Field> {
        private final boolean notNull;

        public static final class BoundInstance extends FieldSetter implements BoundCaller {
            private final Object boundReceiver;

            public BoundInstance(Field r10, boolean r11, Object r12) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, r11, false, null);
                this.boundReceiver = r12;
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                mo1315getMember().set(this.boundReceiver, ArraysKt.first(r10));
                return Unit.INSTANCE;
            }
        }

        public static final class BoundJvmStaticInObject extends FieldSetter implements BoundCaller {
            public BoundJvmStaticInObject(Field r10, boolean r11) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, r11, false, null);
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                mo1315getMember().set(null, ArraysKt.last(r10));
                return Unit.INSTANCE;
            }
        }

        public static final class Instance extends FieldSetter {
            public Instance(Field r10, boolean r11) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, r11, true, null);
            }
        }

        public static final class JvmStaticInObject extends FieldSetter {
            public JvmStaticInObject(Field r10, boolean r11) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, r11, true, null);
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.CallerImpl
            public void checkArguments(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                super.checkArguments(r10);
                checkObjectInstance(ArraysKt.firstOrNull(r10));
            }
        }

        public static final class Static extends FieldSetter {
            public Static(Field r10, boolean r11) {
                Intrinsics.checkNotNullParameter(r10, "field");
                super(r10, r11, false, null);
            }
        }

        private FieldSetter(Field r10, boolean r11, boolean r12) {
            Class r13 = Void.TYPE;
            Intrinsics.checkNotNullExpressionValue(r13, "TYPE");
            if (r12 == false) goto L5;
            Class<?> r14 = r10.getDeclaringClass();
        L6:
            Type r15 = r10.getGenericType();
            Intrinsics.checkNotNullExpressionValue(r15, "field.genericType");
            super(r10, r13, r14, new Type[]{r15}, null);
            this.notNull = r11;
            return;
        L5:
            r14 = null;
            goto L6
        }

        public /* synthetic */ FieldSetter(Field r10, boolean r11, boolean r12, DefaultConstructorMarker r13) {
            this(r10, r11, r12);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            checkArguments(r10);
            Field r11 = mo1315getMember();
            if (getInstanceClass() == null) goto L5;
            Object r12 = ArraysKt.first(r10);
        L6:
            r11.set(r12, ArraysKt.last(r10));
            return Unit.INSTANCE;
        L5:
            r12 = null;
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.calls.CallerImpl
        public void checkArguments(Object[] r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            super.checkArguments(r10);
            if (this.notNull == true) goto L5;
            return;
        L5:
            if (ArraysKt.last(r10) == null) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("null is not allowed as a value for this property.");
        }
    }

    public static abstract class Method extends CallerImpl<java.lang.reflect.Method> {
        private final boolean isVoidMethod;

        public static final class BoundInstance extends Method implements BoundCaller {
            private final Object boundReceiver;

            public BoundInstance(java.lang.reflect.Method r10, Object r11) {
                Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
                super(r10, false, null, 4, null);
                this.boundReceiver = r11;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                return callMethod(this.boundReceiver, r10);
            }
        }

        public static final class BoundJvmStaticInObject extends Method implements BoundCaller {
            public BoundJvmStaticInObject(java.lang.reflect.Method r10) {
                Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
                super(r10, false, null, 4, null);
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                return callMethod(null, r10);
            }
        }

        public static final class BoundStatic extends Method implements BoundCaller {
            private final Object boundReceiver;

            public BoundStatic(java.lang.reflect.Method r10, Object r11) {
                Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
                Type[] r12 = r10.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(r12, "method.genericParameterTypes");
                boolean r13 = false;
                if (r12.length > 1) goto L5;
                Object r14 = new Type[0];
            L6:
                super(r10, r13, (Type[]) r14, null);
                this.boundReceiver = r11;
                return;
            L5:
                r14 = ArraysKt.copyOfRange(r12, 1, r12.length);
                Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                goto L6
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                SpreadBuilder r11 = new SpreadBuilder(2);
                r11.add(this.boundReceiver);
                r11.addSpread(r10);
                return callMethod(null, r11.toArray(new Object[r11.size()]));
            }
        }

        public static final class Instance extends Method {
            public Instance(java.lang.reflect.Method r10) {
                Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
                super(r10, false, null, 6, null);
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                Object r11 = r10[0];
                if (r10.length > 1) goto L5;
                Object[] r12 = new Object[0];
            L7:
                return callMethod(r11, r12);
            L5:
                r12 = ArraysKt.copyOfRange(r10, 1, r10.length);
                Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                goto L7
            }
        }

        public static final class JvmStaticInObject extends Method {
            public JvmStaticInObject(java.lang.reflect.Method r10) {
                Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
                super(r10, true, null, 4, null);
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                checkObjectInstance(ArraysKt.firstOrNull(r10));
                if (r10.length > 1) goto L5;
                Object[] r11 = new Object[0];
            L7:
                return callMethod(null, r11);
            L5:
                r11 = ArraysKt.copyOfRange(r10, 1, r10.length);
                Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                goto L7
            }
        }

        public static final class Static extends Method {
            public Static(java.lang.reflect.Method r10) {
                Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
                super(r10, false, null, 6, null);
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] r10) {
                Intrinsics.checkNotNullParameter(r10, "args");
                checkArguments(r10);
                return callMethod(null, r10);
            }
        }

        private Method(java.lang.reflect.Method r10, boolean r11, Type[] r12) {
            Type r13 = r10.getGenericReturnType();
            Intrinsics.checkNotNullExpressionValue(r13, "method.genericReturnType");
            if (r11 == false) goto L5;
            Class<?> r14 = r10.getDeclaringClass();
        L6:
            super(r10, r13, r14, r12, null);
            this.isVoidMethod = Intrinsics.areEqual(getReturnType(), Void.TYPE);
            return;
        L5:
            r14 = null;
            goto L6
        }

        public /* synthetic */ Method(java.lang.reflect.Method r10, boolean r11, Type[] r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = !Modifier.isStatic(r10.getModifiers());
        L6:
            if ((r13 & 4) == 0) goto L8;
            r12 = r10.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r12, "method.genericParameterTypes");
        L8:
            this(r10, r11, r12, null);
        }

        public /* synthetic */ Method(java.lang.reflect.Method r10, boolean r11, Type[] r12, DefaultConstructorMarker r13) {
            this(r10, r11, r12);
        }

        protected final Object callMethod(Object r10, Object[] r11) {
            Intrinsics.checkNotNullParameter(r11, "args");
            Object r12 = mo1315getMember().invoke(r10, Arrays.copyOf(r11, r11.length));
            if (this.isVoidMethod == true) goto L5;
            return r12;
        L5:
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private CallerImpl(M r10, Type r11, Class<?> r12, Type[] r13) {
        this.member = r10;
        this.returnType = r11;
        this.instanceClass = r12;
        if (r12 == null) goto L6;
        SpreadBuilder r14 = new SpreadBuilder(2);
        r14.add(r12);
        r14.addSpread(r13);
        List<Type> r15 = CollectionsKt.listOf(r14.toArray(new Type[r14.size()]));
        if (r15 == null) goto L6;
    L7:
        this.parameterTypes = r15;
        return;
    L6:
        r15 = ArraysKt.toList(r13);
        goto L7
    }

    public /* synthetic */ CallerImpl(Member r10, Type r11, Class r12, Type[] r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public void checkArguments(Object[] r10) {
        Caller.DefaultImpls.checkArguments(this, r10);
    }

    protected final void checkObjectInstance(Object r10) {
        if (r10 == null) goto L7;
        if (this.member.getDeclaringClass().isInstance(r10) == false) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
    }

    public final Class<?> getInstanceClass() {
        return this.instanceClass;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public final M mo1315getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.returnType;
    }
}
