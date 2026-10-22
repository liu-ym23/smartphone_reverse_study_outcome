package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    public static final Companion Companion = null;
    private static final Object EXTENSION_PROPERTY_DELEGATE = null;
    private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;
    private final ReflectProperties.LazyVal<Field> _javaField;
    private final KDeclarationContainerImpl container;
    private final String name;
    private final Object rawBoundReceiver;
    private final String signature;

    public static abstract class Accessor<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        public Accessor() {
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getDefaultCaller() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public abstract PropertyAccessorDescriptor getDescriptor();

        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return getDescriptor().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return getDescriptor().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return getDescriptor().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return getDescriptor().isOperator();
        }

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return KPropertyImpl.access$getEXTENSION_PROPERTY_DELEGATE$cp();
        }
    }

    public static abstract class Getter<V> extends Accessor<V, V> implements KProperty.Getter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final ReflectProperties.LazyVal caller$delegate;
        private final ReflectProperties.LazySoftVal descriptor$delegate;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        public Getter() {
            this.descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Getter$descriptor$2(this));
            this.caller$delegate = ReflectProperties.lazy(new KPropertyImpl$Getter$caller$2(this));
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Getter) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(getProperty(), ((Getter) r10).getProperty()) == false) goto L7;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            T r10 = this.caller$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-caller>(...)");
            return (Caller) r10;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ PropertyAccessorDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertyGetterDescriptor getDescriptor() {
            T r10 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-descriptor>(...)");
            return (PropertyGetterDescriptor) r10;
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<get-" + getProperty().getName() + Typography.greater;
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        public String toString() {
            return "getter of " + getProperty();
        }
    }

    public static abstract class Setter<V> extends Accessor<V, Unit> implements KMutableProperty.Setter<V> {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final ReflectProperties.LazyVal caller$delegate;
        private final ReflectProperties.LazySoftVal descriptor$delegate;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        public Setter() {
            this.descriptor$delegate = ReflectProperties.lazySoft(new KPropertyImpl$Setter$descriptor$2(this));
            this.caller$delegate = ReflectProperties.lazy(new KPropertyImpl$Setter$caller$2(this));
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Setter) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(getProperty(), ((Setter) r10).getProperty()) == false) goto L7;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public Caller<?> getCaller() {
            T r10 = this.caller$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-caller>(...)");
            return (Caller) r10;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public /* bridge */ /* synthetic */ PropertyAccessorDescriptor getDescriptor() {
            return getDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        public PropertySetterDescriptor getDescriptor() {
            T r10 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-descriptor>(...)");
            return (PropertySetterDescriptor) r10;
        }

        @Override // kotlin.reflect.KCallable
        public String getName() {
            return "<set-" + getProperty().getName() + Typography.greater;
        }

        public int hashCode() {
            return getProperty().hashCode();
        }

        public String toString() {
            return "setter of " + getProperty();
        }
    }

    static {
        Companion = new Companion(null);
        EXTENSION_PROPERTY_DELEGATE = new Object();
    }

    public KPropertyImpl(KDeclarationContainerImpl r10, String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        this(r10, r11, r12, null, r13);
    }

    private KPropertyImpl(KDeclarationContainerImpl r10, String r11, String r12, PropertyDescriptor r13, Object r14) {
        this.container = r10;
        this.name = r11;
        this.signature = r12;
        this.rawBoundReceiver = r14;
        ReflectProperties.LazyVal<Field> r15 = ReflectProperties.lazy(new KPropertyImpl$_javaField$1(this));
        Intrinsics.checkNotNullExpressionValue(r15, "lazy {\n        when (val…y -> null\n        }\n    }");
        this._javaField = r15;
        ReflectProperties.LazySoftVal<PropertyDescriptor> r16 = ReflectProperties.lazySoft(r13, new KPropertyImpl$_descriptor$1(this));
        Intrinsics.checkNotNullExpressionValue(r16, "lazySoft(descriptorIniti…or(name, signature)\n    }");
        this._descriptor = r16;
    }

    public KPropertyImpl(KDeclarationContainerImpl r10, PropertyDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        String r12 = r11.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.name.asString()");
        this(r10, r12, RuntimeTypeMapper.INSTANCE.mapPropertySignature(r11).asString(), r11, CallableReference.NO_RECEIVER);
    }

    public static final /* synthetic */ Object access$getEXTENSION_PROPERTY_DELEGATE$cp() {
        return EXTENSION_PROPERTY_DELEGATE;
    }

    protected final Member computeDelegateSource() {
        if (getDescriptor().isDelegated() == true) goto L5;
        return null;
    L5:
        JvmPropertySignature r10 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(getDescriptor());
        if ((r10 instanceof JvmPropertySignature.KotlinProperty) == false) goto L18;
        JvmPropertySignature.KotlinProperty r11 = (JvmPropertySignature.KotlinProperty) r10;
        if (r11.getSignature().hasDelegateMethod() == false) goto L18;
        JvmProtoBuf.JvmMethodSignature r12 = r11.getSignature().getDelegateMethod();
        if (r12.hasName() == true) goto L12;
    L16:
        return null;
    L12:
        if (r12.hasDesc() == false) goto L16;
        String r13 = r11.getNameResolver().getString(r12.getName());
        String r14 = r11.getNameResolver().getString(r12.getDesc());
        return getContainer().findMethodBySignature(r13, r14);
    L18:
        return getJavaField();
    }

    public boolean equals(Object r10) {
        KPropertyImpl<?> r11 = UtilKt.asKPropertyImpl(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getContainer(), r11.getContainer()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getName(), r11.getName()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signature, r11.signature) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawBoundReceiver, r11.rawBoundReceiver) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final Object getDelegateImpl(Member r10, Object r11, Object r12) {
        Object r13 = EXTENSION_PROPERTY_DELEGATE;     // Catch: IllegalAccessException -> L64
        if (r11 == r13) goto L6;
        if (r12 == r13) goto L6;
    L8:
        if (isBound() == false) goto L10;
        Object r14 = getBoundReceiver();     // Catch: IllegalAccessException -> L64
    L12:
        if (r14 == r13) goto L14;
        boolean r15 = true;
    L16:
        if (r15 == true) goto L20;
        r14 = null;
    L20:
        if (isBound() == true) goto L23;
        r11 = r12;
    L23:
        if (r11 == r13) goto L25;
        boolean r16 = true;
    L26:
        if (r16 == true) goto L30;
        r11 = null;
    L30:
        if ((r10 instanceof AccessibleObject) == false) goto L32;
        AccessibleObject r17 = (AccessibleObject) r10;     // Catch: IllegalAccessException -> L64
    L33:
        if (r17 == null) goto L36;
        r17.setAccessible(KCallablesJvm.isAccessible(this));     // Catch: IllegalAccessException -> L64
    L36:
        if (r10 != 0) goto L39;
        return null;
    L39:
        if ((r10 instanceof Field) == false) goto L42;
        return ((Field) r10).get(r14);
    L42:
        if ((r10 instanceof Method) == false) goto L61;
        int r18 = ((Method) r10).getParameterTypes().length;     // Catch: IllegalAccessException -> L64
        if (r18 == 0) goto L59;
        if (r18 != 1) goto L47;
        Method r19 = (Method) r10;     // Catch: IllegalAccessException -> L64
        Object[] r20 = new Object[1];     // Catch: IllegalAccessException -> L64
        if (r14 != null) goto L57;
        Class<?> r21 = ((Method) r10).getParameterTypes()[0];     // Catch: IllegalAccessException -> L64
        Intrinsics.checkNotNullExpressionValue(r21, "fieldOrMethod.parameterTypes[0]");     // Catch: IllegalAccessException -> L64
        r14 = UtilKt.defaultPrimitiveValue(r21);     // Catch: IllegalAccessException -> L64
    L57:
        r20[0] = r14;     // Catch: IllegalAccessException -> L64
        return r19.invoke(null, r20);
    L47:
        if (r18 != 2) goto L53;
        Method r22 = (Method) r10;     // Catch: IllegalAccessException -> L64
        Object[] r23 = new Object[2];     // Catch: IllegalAccessException -> L64
        r23[0] = r14;     // Catch: IllegalAccessException -> L64
        if (r11 != null) goto L51;
        Class<?> r24 = ((Method) r10).getParameterTypes()[1];     // Catch: IllegalAccessException -> L64
        Intrinsics.checkNotNullExpressionValue(r24, "fieldOrMethod.parameterTypes[1]");     // Catch: IllegalAccessException -> L64
        r11 = UtilKt.defaultPrimitiveValue(r24);     // Catch: IllegalAccessException -> L64
    L51:
        r23[1] = r11;     // Catch: IllegalAccessException -> L64
        return r22.invoke(null, r23);
    L53:
        throw new AssertionError("delegate method " + r10 + " should take 0, 1, or 2 parameters");     // Catch: IllegalAccessException -> L64
    L59:
        return ((Method) r10).invoke(null, new Object[0]);
    L61:
        throw new AssertionError("delegate field/method " + r10 + " neither field nor method");     // Catch: IllegalAccessException -> L64
    L32:
        r17 = null;
        goto L33
    L25:
        r16 = false;
        goto L26
    L14:
        r15 = false;
        goto L16
    L10:
        r14 = r11;
    L6:
        if (getDescriptor().getExtensionReceiverParameter() != null) goto L8;
        throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");     // Catch: IllegalAccessException -> L64
    L64:
        e = move-exception;
        throw new IllegalPropertyDelegateAccessException(e);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
        return getDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor r10 = this._descriptor.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_descriptor()");
        return r10;
    }

    public abstract Getter<V> getGetter();

    public final Field getJavaField() {
        return this._javaField.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !Intrinsics.areEqual(this.rawBoundReceiver, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
    }
}
